package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.OperateMapper;
import com.venink.slec.entity.Operate;
import com.venink.slec.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateServiceImpl extends BaseServiceImpl<Operate, Integer> implements OperateService {

    @Autowired
    private OperateMapper operateMapper;

    @Override
    public BaseDao<Operate, Integer> getDao() {
        return operateMapper;
    }
}
