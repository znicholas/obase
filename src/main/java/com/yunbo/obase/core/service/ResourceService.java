package com.yunbo.obase.core.service;

import java.util.List;

import com.yunbo.obase.core.dao.Expression;
import com.yunbo.obase.core.dao.Pager;

public interface ResourceService<T> {
	public List<T> query(List<Expression> exps);
	
	public Pager<T> query(List<Expression> exps, int pageNumber, int pageSize);

	public T find(Long id);

	public T save(T entity);

	public boolean removeById(Long id);

	public boolean remove(T entity);
}
