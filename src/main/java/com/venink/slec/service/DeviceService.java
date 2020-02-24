package com.venink.slec.service;

import com.venink.slec.base.generic.BaseService;
import com.venink.slec.entity.Device;

import java.util.List;

public interface DeviceService extends BaseService<Device, Integer> {

    //查询唯一性：设备名称/设备ip/设备序列号
    public Device selectUnique(String deviceName,String deviceSn);

    //查询更新唯一性：设备名称/设备ip/设备序列号/自身id
    public Device selectUniqueRenew(String deviceName,String deviceSn, Integer id);

    //根据主键联表查询
    public Device selectJoinByPrimaryKey(Integer id);

    //根据序列号查询设备
    public Device selectDeviceByDeviceSn(String deviceSn);

    //根据权限组id查询设备
    List<Device> selectDeviceByGroupId(Integer groupId);
}
