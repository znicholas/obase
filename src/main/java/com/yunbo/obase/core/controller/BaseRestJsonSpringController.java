package com.yunbo.obase.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yunbo.obase.core.controller.format.JsonFormat;
import com.yunbo.obase.core.dao.Expression;
import com.yunbo.obase.core.dao.Pager;

/**
 * 定义标准的rest方法以对应实体对象的操作,以达到统一rest的方法名称, 还可以避免子类需要重复编写@RequestMapping
 * annotation.
 * 
 * 子类要实现某功能只需覆盖下面的方法即可. 注意: 覆盖时请使用@Override,以确保不会发生错误
 * 
 * <pre>
 * /module                => index()  
 * /module/new            => _new()  
 * /module/{id}           => view()  
 * /module/create         => create()  
 * /module        POST     => save()  
 * /module/{id}   DELETE  => delete()  
 * /module        DELETE  => batchDelete()
 * /module/query      	  => query()
 * </pre>
 * 
 * @author nicholas
 */
public class BaseRestJsonSpringController<Entity, PK> extends BaseSpringController {

	@RequestMapping
	public ModelAndView index(Entity model) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 显示 */
	@RequestMapping(value = "/{id}")
	public @ResponseBody
	Entity view(Long id) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 保存新增或更新 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Entity save(Entity model) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 进入新增 */
	@RequestMapping(value = "/new")
	public @ResponseBody
	Entity _new(Entity model) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 新建 */
	@RequestMapping(value = "/create")
	public @ResponseBody
	ModelAndView create() throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 删除 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String delete(@PathVariable PK id) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 批量删除 */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody
	String batchDelete(@RequestParam("ids") PK[] items) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 查询 */
	@RequestMapping(value = "/query")
	public @ResponseBody
	Pager<Entity> query(@RequestParam @JsonFormat(contentType = Expression.class) List<Expression> exps,
			int pageNumber, int pageSize) {
		throw new UnsupportedOperationException("not yet implement");
	}
}
