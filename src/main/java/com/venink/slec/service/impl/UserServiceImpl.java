package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.UserMapper;
import com.venink.slec.entity.User;
import com.venink.slec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseDao<User, Integer> getDao() {
        return userMapper;
    }

    @Override
    public List<User> getUsersList() {
        return userMapper.queryUsers();
    }

    @Override
    public List<User> getUserByPhoneNum(String phoneNum) {
        return userMapper.queryUserByPhoneNum(phoneNum);
    }

    @Override
    public List<User> getUserByName(String UserName) {
        return userMapper.queryUserByName(UserName);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if((user.getUserName() != null) && !"".equals(user.getUserName())){
            user.setCreateTime(new Date());
            try{
                int effectedNum = userMapper.insertUser(user);
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

    @Transactional
    @Override
    public boolean modifyUser(User user) {
        if(user.getPhoneNum()!=null){
            try{
                // 更新区域信息
                int effectedNum = userMapper.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新人员信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("更新人员信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("手机号不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(String phoneNum) {
        if(!"".equals(phoneNum)){
            try{
                int effectedNum = userMapper.deleteUser(phoneNum);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("删除信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("删除信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("手机号不能为空！");
        }
    }

}
