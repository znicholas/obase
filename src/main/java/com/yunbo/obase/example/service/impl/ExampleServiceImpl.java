package com.yunbo.obase.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunbo.obase.core.dao.EntityDao;
import com.yunbo.obase.core.service.BaseReousrceService;
import com.yunbo.obase.example.dao.ExampleDao;
import com.yunbo.obase.example.model.ExampleModel;
import com.yunbo.obase.example.service.ExampleService;

@Service
public class ExampleServiceImpl extends BaseReousrceService<ExampleModel> implements ExampleService {
	@Autowired
	private ExampleDao dao;

	@Override
	public EntityDao<ExampleModel> getDao() {
		return dao;
	}
}
