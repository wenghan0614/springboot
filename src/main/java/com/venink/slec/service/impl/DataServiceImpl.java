package com.venink.slec.service.impl;


import cn.hutool.core.convert.Convert;
import com.venink.slec.base.utils.ReturnUtils;
import com.venink.slec.controller.PassiveController;
import com.venink.slec.dao.*;
import com.venink.slec.entity.*;
import com.venink.slec.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService{

    //Logback
    private static final Logger logger = LoggerFactory.getLogger(PassiveController.class);

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private DevicePersonMapper devicePersonMapper;
    @Autowired
    private GroupPersonMapper groupPersonMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private OperateMapper operateMapper;

    @Override
    public ReturnUtils getGroupId(String groupName) {
        Integer groupId = groupMapper.selectGroupIdByGroupName(groupName);
        if (groupId == null){
            return new ReturnUtils(1001,"失败",null);
        }
        return new ReturnUtils(1000,"成功",groupId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ReturnUtils addPerson(Map<String, String> map) {
        Integer groupId = Convert.toInt(map.get("groupId"));
        String personNo = map.get("personNo");
        String perName = map.get("perName");
        String perPhoto = map.get("perPhoto");
        String perSex = map.get("perSex");
        String perType = map.get("perType");

        //查询权限组是否存在
        Group group = groupMapper.selectByPrimaryKey(groupId);
        if(group == null){
            return new ReturnUtils(1001,"权限组不存在");
        }

        //封装人员对象
        Person person = new Person();
        person.setPersonNo(personNo);
        person.setPersonName(perName);
        person.setPersonPhoto(perPhoto);
        person.setPersonSex(perSex);
        person.setPersonType(perType);
        //随机生成10位的人员id
        // person.setPersonId(RandomUtil.randomNumbers(10));
        personMapper.insertSelective(person);
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
        groupPersonMapper.insertSelective(groupPerson);

        //根据权限组ID查询设备集合
        List<Device> devices = deviceMapper.selectDeviceByGroupId(groupId);
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
            deviceMapper.updateByPrimaryKeySelective(device);
        }

        //批量插入
        operateMapper.insertBatch(operates);

        return new ReturnUtils(1000,"添加成功");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ReturnUtils updatePerson(Map<String, String> map) {
        Integer groupId = Convert.toInt(map.get("groupId"));
        String personNo = map.get("personNo");
        String perName = map.get("perName");
        String perPhoto = map.get("perPhoto");
        String perSex = map.get("perSex");
        String perType = map.get("perType");

        //查询人员是否存在
        Person person = personMapper.selectPersonByNoAndType(personNo,perType);
        if(person == null){
            return new ReturnUtils(1001,"更新失败,人员不存在");
        }
        Integer Id = person.getId();

        person.setPersonName(perName);
        person.setPersonPhoto(perPhoto);
        person.setPersonSex(perSex);
        int i = personMapper.updatePersonByNoAndType(person);
        if(i == 0){
            return new ReturnUtils(1001,"更新失败");
        }

        //根据权限组ID查询设备集合
        List<Device> devices = deviceMapper.selectDeviceByGroupId(groupId);
        //遍历生成设备操作表
        List<Operate> operates = new ArrayList<>();
        for (Device device: devices) {

            Operate operate = new Operate();
            //1:修改
            operate.setOperateType(2);
            //0:未操作
            operate.setOperateState(0);
            operate.setPersonId(Id);
            operate.setDeviceId(device.getId());
            //封装到操作集合中
            operates.add(operate);

            //设备设置同步状态为：1：更新人员
            device.setSyncState(1);
            deviceMapper.updateByPrimaryKeySelective(device);
        }
        //批量插入
        operateMapper.insertBatch(operates);

        return new ReturnUtils(1000,"更新成功");
    }
}
