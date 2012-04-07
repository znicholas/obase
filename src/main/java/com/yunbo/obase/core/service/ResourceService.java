package com.yunbo.obase.core.service;

import java.util.List;

import com.yunbo.obase.core.dao.Expression;

public interface ResourceService<T> {
	public List<T> query(List<Expression> exps);

	public T find(Long id);

	public T save(T entity);

	public boolean removeById(Long id);

	public boolean remove(T entity);
}
