package com.venink.slec.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.venink.slec.base.utils.ReturnUtils;
import com.venink.slec.entity.*;
import com.venink.slec.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class DataController {

    //Logback
    private static final Logger logger = LoggerFactory.getLogger(PassiveController.class);

    @Autowired
    private GroupService groupService;
    @Autowired
    private PersonService personService;
    @Autowired
    private DevicePersonService devicePersonService;
    @Autowired
    private GroupPersonService groupPersonService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private OperateService operateService;

    //1根据权限名查询权限编号
    @ResponseBody
    @RequestMapping(value = "/groupId",method = RequestMethod.GET)
    public ReturnUtils getGroupId(@RequestParam("groupName")String groupName){
        Integer groupId = groupService.selectGroupIdByGroupName(groupName);
        if (groupId == null){
            return new ReturnUtils(1001,"失败",null);
        }
        return new ReturnUtils(1000,"成功",groupId);
    }

    //2向指定群组添加人员
    @ResponseBody
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public ReturnUtils addPerson(@RequestBody Map<String, String> map){
        logger.info("添加人员："+ JSON.toJSONString(map));
        Integer groupId = Convert.toInt(map.get("groupId"));
        String personNo = map.get("personNo");
        String perName = map.get("perName");
        String perPhoto = map.get("perPhoto");
        String perSex = map.get("perSex");

        //查询权限组是否存在
        Group group = groupService.selectByPrimaryKey(groupId);
        if(group == null){
            return new ReturnUtils(1001,"权限组不存在");
        }

        //封装人员对象
        Person person = new Person();
        person.setPersonNo(personNo);
        person.setPersonName(perName);
        person.setPersonPhoto(perPhoto);
        person.setPersonSex(perSex);
        person.setPersonId(RandomUtil.randomNumbers(10));
        personService.insertSelective(person);
        Integer Id = person.getId();
        logger.info("Id: "+Id);
        if( Id == null || Id == 0 ){
            return new ReturnUtils(1000,"添加人员失败");
        }

        //设置人员与权限组关联
        GroupPerson groupPerson = new GroupPerson();
        groupPerson.setCreateTime(new Date(System.currentTimeMillis()));
        groupPerson.setGroupId(Convert.toInt(groupId));
        groupPerson.setPersonId(Id);
        groupPersonService.insertSelective(groupPerson);

        //根据权限组ID查询设备集合
        List<Device> devices = deviceService.selectDeviceByGroupId(groupId);
        //遍历生成设备操作表
        List<Operate> operates = new ArrayList<>();
        for (Device device: devices) {

            Operate operate = new Operate();
            //1:添加
            operate.setOperateType(1);
            //0:未操作
            operate.setOperateState(0);
            operate.setPersonId(Id);
            operate.setDeviceId(device.getId());
            //封装到操作集合中
            operates.add(operate);

            //设备设置同步状态为：1：更新人员
            device.setSyncState(1);
            deviceService.updateByPrimaryKeySelective(device);
        }

        //批量插入
        operateService.insertBatch(operates);

        return new ReturnUtils(1000,"添加成功");
    }

    //3修改人员
    @ResponseBody
    @RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
    public ReturnUtils updatePerson(@RequestBody Map<String, String> map){

        logger.info("更新人员："+ JSON.toJSONString(map));
        Integer groupId = Convert.toInt(map.get("groupId"));
        String personNo = map.get("personNo");
        String perName = map.get("perName");
        String perPhoto = map.get("perPhoto");
        String perSex = map.get("perSex");
        String perType = map.get("perType");

        Person person = new Person();
        person.setPersonNo(personNo);
        person.setPersonName(perName);
        person.setPersonPhoto(perPhoto);
        person.setPersonSex(perSex);
        person.setPersonType(perType);
        int i = personService.updatePersonByNoAndType(person);
        if(i == 0){
            return new ReturnUtils(1001,"更新失败");
        }

        //根据权限组ID查询设备集合
        List<Device> devices = deviceService.selectDeviceByGroupId(groupId);
        //遍历生成设备操作表
        List<Operate> operates = new ArrayList<>();
        for (Device device: devices) {

            Operate operate = new Operate();
            //1:修改
            operate.setOperateType(2);
            //0:未操作
            operate.setOperateState(0);
            // operate.setPersonId(Id);
            operate.setDeviceId(device.getId());
            //封装到操作集合中
            operates.add(operate);

            //设备设置同步状态为：1：更新人员
            device.setSyncState(1);
            deviceService.updateByPrimaryKeySelective(device);
        }
        //批量插入
        operateService.insertBatch(operates);

        return new ReturnUtils(1000,"更新成功");
    }
}
