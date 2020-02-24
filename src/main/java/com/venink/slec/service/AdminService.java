package com.venink.slec.service;

import com.venink.slec.base.generic.BaseService;
import com.venink.slec.entity.Admin;

public interface AdminService extends BaseService<Admin, Integer> {

    Admin findAdmin(Admin admin);

    Admin hasExisted(Admin admin);


    boolean addAdmin(Admin admin);

    boolean modifyAdmin(Admin admin);
}
