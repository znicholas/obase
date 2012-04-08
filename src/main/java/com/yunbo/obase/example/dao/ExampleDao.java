package com.yunbo.obase.example.dao;

import org.springframework.stereotype.Repository;

import com.yunbo.obase.example.model.ExampleModel;
import com.yunbo.obase.core.dao.EntityDao;

@Repository
public interface ExampleDao extends EntityDao<ExampleModel> {
}
