package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.DeviceMapper;
import com.venink.slec.entity.Device;
import com.venink.slec.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, Integer> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public BaseDao<Device, Integer> getDao() {
        return deviceMapper;
    }

    @Override
    public Device selectUnique(String deviceName, String deviceSn) {
        return deviceMapper.selectUnique(deviceName,deviceSn);
    }

    @Override
    public Device selectUniqueRenew(String deviceName, String deviceSn, Integer id){
        return deviceMapper.selectUniqueRenew(deviceName,deviceSn, id);
    }

    @Override
    public Device selectJoinByPrimaryKey(Integer id) {
        return deviceMapper.selectJoinByPrimaryKey(id);
    }

    @Override
    public Device selectDeviceByDeviceSn(String deviceSn) {
        return deviceMapper.selectDeviceByDeviceSn(deviceSn);
    }

    @Override
    public List<Device> selectDeviceByGroupId(Integer groupId) {
        return deviceMapper.selectDeviceByGroupId(groupId);
    }
}
