package com.yunbo.obase.core.dao;

import java.util.List;

public interface EntityDao<T> {

	public T find(Long id);

	public T save(T entity);

	public boolean removeById(Long id);

	public boolean remove(T entity);

	public <RT> List<RT> query(List<Expression> exps);

	public Pager<T> query(List<Expression> exps, int pageNumber, int pageSize);
}
