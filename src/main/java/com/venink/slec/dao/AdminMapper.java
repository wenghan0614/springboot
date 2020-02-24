package com.venink.slec.dao;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.entity.Admin;

public interface AdminMapper extends BaseDao<Admin, Integer> {

    Admin queryByAdmin(Admin admin);

    Admin hasExisted(Admin admin);

    int insertAdmin(Admin admin);

    int updateAdmin(Admin admin);
}