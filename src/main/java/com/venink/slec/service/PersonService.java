package com.venink.slec.service;

import com.venink.slec.base.generic.BaseService;
import com.venink.slec.entity.Person;

public interface PersonService extends BaseService<Person, Integer> {

    int updatePersonByNoAndType(Person person);

    Person selectPersonByNoAndType(String personNo, String personType);
}
