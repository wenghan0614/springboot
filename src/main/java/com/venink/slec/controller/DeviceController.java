package com.venink.slec.controller;

import com.venink.slec.base.utils.ReturnUtils;
import com.venink.slec.base.utils.ValidatorUtil;
import com.venink.slec.base.utils.page.PageUtil;
import com.venink.slec.entity.Device;
import com.venink.slec.service.DeviceService;
import com.venink.slec.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/deviceManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(Device device, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){

        //查询数据的总记录数：不分页
        int rows = deviceService.count(device);
        //处理分页逻辑
        device.pageHandle(pageCurrent,pageSize,pageCount,rows);
        //设置完limit开s始值和结束值的订单对象调用分页查询
        List<Device> devices = deviceService.findByCondition(device);
        //通过redis确认设备在线状态：0：未连接；1：在线；2：离线；
        getdeviceOnLineStateByRedis(devices);

        //封装数据
        model.addAttribute("devices", devices);
        //将分页数据拼接成页面需要的数据格式
        String pageHTML = PageUtil.getPageContent("deviceManage_{pageCurrent}_{pageSize}_{pageCount}", device.getPageCurrent(), device.getPageSize(), device.getPageCount());
        //封装分页索引
        model.addAttribute("pageHTML", pageHTML);
        return "device/deviceManage";
    }

    //跳转添加设备页面
    @RequestMapping(value = "/addDeviceHandle")
    private String addDeviceHandle() {
        return "device/addDeviceHandle";
    }

    //添加设备
    @ResponseBody
    @RequestMapping(value = "/addDevice",method = RequestMethod.POST)
    private ReturnUtils addDevice(Device device) {
        String deviceName = device.getDeviceName();
        String deviceIp = device.getDeviceIp();
        String deviceSn = device.getDeviceSn();
        if(deviceName == null||"".equals(deviceName)){
            return new ReturnUtils(1001,"设备名称不能为空!");
        }
        if(deviceIp == null||"".equals(deviceIp)){
            return new ReturnUtils(1001,"设备IP不能为空!");
        }
        if(!ValidatorUtil.isIPAddr(deviceIp)){
            return new ReturnUtils(1001,"设备IP格式错误!");
        }
        if(deviceSn == null||"".equals(deviceSn)){
            return new ReturnUtils(1001,"设备序列号不能为空!");
        }
        if(deviceService.selectUnique(deviceName,deviceSn) != null){
            return new ReturnUtils(1001,"设备名称/设备IP/设备序列号存在冲突!");
        }
        device.setCreateTime(new Date(System.currentTimeMillis()));
        int i = deviceService.insertSelective(device);
        if(i == 0){
            return new ReturnUtils(1001,"添加设备失败!");
        }
        return new ReturnUtils(1000,"添加设备成功!");
    }

    //跳转更新设备页面
    @RequestMapping(value = "/updateDeviceHandle")
    private String updateDeviceHandle(@RequestParam("deviceId")Integer deviceId, Model model) {
        Device device = deviceService.selectJoinByPrimaryKey(deviceId);
        model.addAttribute("device",device);
        return "device/updateDeviceHandle";
    }

    //更新设备
    @ResponseBody
    @RequestMapping(value = "/updateDevice",method = RequestMethod.POST)
    private ReturnUtils updateDevice(Device device) {
        Integer id = device.getId();
        String deviceName = device.getDeviceName();
        String deviceIp = device.getDeviceIp();
        String deviceSn = device.getDeviceSn();
        //距离
        String distinguishRange = device.getDistinguishRange();
        //阈值
        Integer distinguishScore = device.getDistinguishScore();

        if(deviceName == null||"".equals(deviceName)){
            return new ReturnUtils(1001,"设备名称不能为空!");
        }
        if(deviceIp == null||"".equals(deviceIp)){
            return new ReturnUtils(1001,"设备IP不能为空!");
        }
        if(!ValidatorUtil.isIPAddr(deviceIp)){
            return new ReturnUtils(1001,"设备IP格式错误!");
        }
        if(deviceSn == null||"".equals(deviceSn)){
            return new ReturnUtils(1001,"设备序列号不能为空!");
        }
        if(deviceService.selectUniqueRenew(deviceName,deviceSn,id) != null){
            return new ReturnUtils(1001,"设备名称/设备IP/设备序列号存在冲突!");
        }
        device.setUpdateTime(new Date(System.currentTimeMillis()));
        int i = deviceService.updateByPrimaryKeySelective(device);
        if(i == 0){
            return new ReturnUtils(1001,"更新设备失败!");
        }
        return new ReturnUtils(1000,"更新设备成功!");
    }

    //通过redis获取在线状态
    public void getdeviceOnLineStateByRedis(List<Device> devices){

        //获取当前时间戳
        long timestamp = System.currentTimeMillis();
        //遍历当前分页的设备集合
        for (Device device : devices) {
            //获取当前遍历的设备序列号
            String deviceSn = device.getDeviceSn();
            //如果redis中不存在该序列号，则说明设备未对系统产生心跳
            if(!redisUtil.hasKey(deviceSn)){
                //0:未连接
                device.setOnLineState(0);
                continue;
            }
            //获取设备最后的心跳数据
            long deviceSnTimestamp = (long)redisUtil.get(deviceSn);
            //10秒一次心跳，超过1分钟未有心跳视为离线
            if(timestamp - deviceSnTimestamp > 10000 * 6){
                //离线
                device.setOnLineState(2);
                continue;
            }
            //在线
            device.setOnLineState(1);
        }

    }
}
