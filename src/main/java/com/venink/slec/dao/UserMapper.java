package com.venink.slec.dao;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.entity.User;

import java.util.List;

public interface UserMapper  extends BaseDao<User, Integer> {
    /**
     * 获取所有订单
     **/
    List<User> queryUsers();
    /**
     * 通过手机号查询
     * */
    List<User> queryUserByPhoneNum(String phoneNum);
    /**
     * 用过姓名模糊查询
     * */
    List<User> queryUserByName(String userName);



    /**
     * 对成员的增删改
     * */
    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(String phoneNum);
}