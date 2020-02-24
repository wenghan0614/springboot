package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.DevicePersonMapper;
import com.venink.slec.entity.DevicePerson;
import com.venink.slec.service.DevicePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevicePersonServiceImpl extends BaseServiceImpl<DevicePerson, Integer> implements DevicePersonService {

    @Autowired
    private DevicePersonMapper devicePersonMapper;

    @Override
    public BaseDao<DevicePerson, Integer> getDao() {
        return devicePersonMapper;
    }
}
