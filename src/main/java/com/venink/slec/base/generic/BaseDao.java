package com.venink.slec.base.generic;

import java.util.List;

public interface BaseDao<T, PK> {

    T selectByPrimaryKey(PK id);

    int deleteByPrimaryKey(PK id);

    int insert(T entity);

    int insertSelective(T entity);

    int updateByPrimaryKey(T entity);

    int updateByPrimaryKeySelective(T entity);

    List<T> queryByConditionWithoutLimit(T entity);

    List<T> queryByCondition(T entity);

    List<T> queryAllData();

    int insertBatch(List<T> list);
}
