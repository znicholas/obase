package com.yunbo.obase.example.dao.impl;

import org.springframework.stereotype.Repository;

import com.yunbo.obase.core.dao.BaseDao;
import com.yunbo.obase.example.dao.ExampleDao;
import com.yunbo.obase.example.model.ExampleModel;

@Repository
public class ExampleDaoImpl extends BaseDao<ExampleModel> implements ExampleDao {

}
