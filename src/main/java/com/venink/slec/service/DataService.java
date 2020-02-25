package com.venink.slec.service;

import com.venink.slec.base.utils.ReturnUtils;

import java.util.Map;

public interface DataService {

    //获取组id
    ReturnUtils getGroupId(String groupName);

    //添加人员
    ReturnUtils addPerson(Map<String, String> map);

    //更新人员
    ReturnUtils updatePerson(Map<String, String> map);
}
