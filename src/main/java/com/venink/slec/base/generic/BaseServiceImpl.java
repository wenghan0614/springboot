package com.venink.slec.base.generic;

import java.util.List;

public abstract class BaseServiceImpl<T, PK> implements BaseService<T, PK> {

    public abstract BaseDao<T, PK> getDao();

    @Override
    public T selectByPrimaryKey(PK id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(PK id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T entity) {
        return getDao().insert(entity);
    }

    @Override
    public int insertSelective(T entity) {
        return getDao().insertSelective(entity);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return getDao().updateByPrimaryKey(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return getDao().updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> findByCondition(T entity) {
        return getDao().queryByCondition(entity);
    }

    @Override
    public int count(T entity) {
        //查询所有数据的尺寸：不分页
        List<T> countList = getDao().queryByConditionWithoutLimit(entity);
        return countList.size();
    }

    @Override
    public List<T> queryAllData(){
        return getDao().queryAllData();
    }

    @Override
    public int insertBatch(List<T> list){
        return getDao().insertBatch(list);
    }
}
