package com.venink.slec.base.generic;

import java.util.List;

public interface BaseService<T, PK> {

    T selectByPrimaryKey(PK id);

    int deleteByPrimaryKey(PK id);

    int insert(T entity);

    int insertSelective(T entity);

    int updateByPrimaryKey(T entity);

    int updateByPrimaryKeySelective(T entity);

    List<T> findByCondition(T entity);

    int count(T entity);

    List<T> queryAllData();

    int insertBatch(List<T> list);
}
