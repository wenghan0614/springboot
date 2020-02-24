package com.venink.slec.service.impl;

import com.venink.slec.base.generic.BaseDao;
import com.venink.slec.base.generic.BaseServiceImpl;
import com.venink.slec.dao.PersonMapper;
import com.venink.slec.entity.Person;
import com.venink.slec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, Integer> implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public BaseDao<Person, Integer> getDao() {
        return personMapper;
    }

    @Override
    public int updatePersonByNoAndType(Person person) {
        return personMapper.updatePersonByNoAndType(person);
    }
}
