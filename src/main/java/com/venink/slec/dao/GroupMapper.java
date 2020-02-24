package com.venink.slec.dao;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.entity.Group;
import org.apache.ibatis.annotations.Param;


public interface GroupMapper extends BaseDao<Group, Integer> {

    //查询唯一性：组名
    Group selectUnique(@Param("groupName")String groupName);

    //根据权限组名称查询权限组编号
    Integer selectGroupIdByGroupName(@Param("groupName")String groupName);
}