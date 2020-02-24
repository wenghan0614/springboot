package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.AdminMapper;
import com.venink.slec.entity.Admin;
import com.venink.slec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public BaseDao<Admin, Integer> getDao() {
        return adminMapper;
    }

    @Override
    public Admin findAdmin(Admin admin) {
        return adminMapper.queryByAdmin(admin);
    }

    @Override
    public Admin hasExisted(Admin admin) {
        return adminMapper.hasExisted(admin);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        if(admin.getUserName()!=null && !"".equals(admin.getUserName()) && admin.getPassword()!=null){
            admin.setAddDate(new Date());
            try{
                int effectedNum = adminMapper.insertAdmin(admin);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加人员信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("添加人员信息失败:" + e.toString());
            }
        }else{
            throw new RuntimeException("姓名信息不能为空！");
        }
    }

    @Override
    public boolean modifyAdmin(Admin admin) {
        if(admin.getUserName()!=null){
            admin.setUpdateDate(new Date());
            try{
                int effectedNum = adminMapper.updateAdmin(admin);
                if(effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("更新人员信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("更新人员信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("手机号不能为空！");
        }
    }
}
