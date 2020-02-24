package com.venink.slec.service;

import com.venink.slec.base.generic.BaseService;
import com.venink.slec.entity.Group;


public interface GroupService extends BaseService<Group, Integer> {

    //查询唯一性：组名
    Group selectUnique(String groupName);

    //根据权限组名称查询权限组编号
    Integer selectGroupIdByGroupName(String groupName);
}
