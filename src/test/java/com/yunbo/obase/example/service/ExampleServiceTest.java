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
import com.yunbo.obase.example.model.ExampleModel;
import com.yunbo.obase.example.service.ExampleService;

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
	}

	@Test
	public void testSave() {
		ExampleModel entity = new ExampleModel();
		entity.setName("example");
		service.save(entity);
		List<Expression> expressions = new ArrayList<Expression>();
		List<ExampleModel> examples = service.query(expressions);
		assertTrue(examples.size() > 0);
		assertFalse(false);
	}

}
