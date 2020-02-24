package com.venink.slec.dao;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.entity.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper  extends BaseDao<Device, Integer> {

    //查询唯一性：设备名称/设备ip/设备序列号
    Device selectUnique(@Param("deviceName")String deviceName,  @Param("deviceSn")String deviceSn);

    //查询更新唯一性：设备名称/设备ip/设备序列号/自身id
    Device selectUniqueRenew(@Param("deviceName")String deviceName, @Param("deviceSn")String deviceSn,
                               @Param("id")Integer id);

    //根据主键联表查询
    Device selectJoinByPrimaryKey(@Param("id")Integer id);

    //根据序列号查询设备
    Device selectDeviceByDeviceSn(@Param("deviceSn")String deviceSn);

    //根据权限组id查询设备
    List<Device> selectDeviceByGroupId(@Param("groupId")Integer groupId);
}