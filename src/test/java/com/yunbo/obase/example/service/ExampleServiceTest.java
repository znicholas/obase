package com.yunbo.obase.example.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunbo.obase.core.dao.Expression;
import com.yunbo.obase.core.dao.Pager;
import com.yunbo.obase.example.model.ExampleModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ExampleServiceTest {

	@Autowired
	private ExampleService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		// 删除所有数据
		List<Expression> exps = new ArrayList<Expression>();
		List<ExampleModel> list = service.query(exps);
		for (ExampleModel entity : list) {
			service.remove(entity);
		}
	}

	@Test
	public void testQuery() {
		ExampleModel entity = new ExampleModel();
		entity.setName("nicholas");
		service.save(entity);

		entity = new ExampleModel();
		entity.setName("tracy");
		service.save(entity);

		// 设置查询条件
		List<Expression> exps = new ArrayList<Expression>();
		Expression exp = new Expression("name", "=", "tracy");
		exps.add(exp);

		Pager<ExampleModel> pager = service.query(exps, 1, 10);
		ExampleModel record = pager.getResult().iterator().next();
		assertEquals(1, pager.getRecordCount());
		assertEquals("tracy", record.getName());
	}

	@Test
	public void testPager() {
		// 循环创建100条记录
		for (int i = 0; i < 100; i++) {
			ExampleModel entity = new ExampleModel();
			entity.setName("name" + i);
			service.save(entity);
		}

		List<Expression> exps = new ArrayList<Expression>();
		// 获取第一页数据，每页20条记录
		Pager<ExampleModel> pager = service.query(exps, 1, 20);
		assertEquals(pager.getResult().size(), 20);
		assertEquals(pager.getPageCount(), 5); // 共5页
	}
}
