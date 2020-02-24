package com.venink.slec.dao;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.entity.Person;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper extends BaseDao<Person, Integer> {

    int updatePersonByNoAndType(Person person);
}