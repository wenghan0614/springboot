package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.GroupMapper;
import com.venink.slec.entity.Device;
import com.venink.slec.entity.Group;
import com.venink.slec.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GroupServiceImpl extends BaseServiceImpl<Group, Integer> implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public BaseDao<Group, Integer> getDao() {
        return groupMapper;
    }

    //查询唯一性：组名
    @Override
    public Group selectUnique(String groupName) {
        return groupMapper.selectUnique(groupName);
    }

    @Override
    public Integer selectGroupIdByGroupName(String groupName) {
        return groupMapper.selectGroupIdByGroupName(groupName);
    }

}
