package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.ErrRecordMapper;
import com.venink.slec.entity.ErrRecord;
import com.venink.slec.service.ErrRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ErrRecordServiceImpl extends BaseServiceImpl<ErrRecord, Integer> implements ErrRecordService {

    @Autowired
    private ErrRecordMapper errRecordMapper;

    @Override
    public BaseDao<ErrRecord, Integer> getDao() {
        return errRecordMapper;
    }
}
