package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.GroupPersonMapper;
import com.venink.slec.entity.GroupPerson;
import com.venink.slec.service.GroupPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupPersonServiceImpl extends BaseServiceImpl<GroupPerson, Integer> implements GroupPersonService {

    @Autowired
    private GroupPersonMapper groupPersonMapper;

    @Override
    public BaseDao<GroupPerson, Integer> getDao() {
        return groupPersonMapper;
    }

}
