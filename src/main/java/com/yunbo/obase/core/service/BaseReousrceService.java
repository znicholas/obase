package com.yunbo.obase.core.service;

import java.util.List;

import com.yunbo.obase.core.dao.EntityDao;
import com.yunbo.obase.core.dao.Expression;
import com.yunbo.obase.core.dao.Pager;

public abstract class BaseReousrceService<T> {
	public List<T> query(List<Expression> exps) {
		return getDao().query(exps);
	}

	public Pager<T> query(List<Expression> exps, int pageNumber, int pageSize) {
		return getDao().query(exps, pageNumber, pageSize);
	}

	public T find(Long id) {
		return getDao().find(id);
	}

	public T save(T entity) {
		return getDao().save(entity);
	}

	public boolean removeById(Long id) {
		return getDao().removeById(id);
	}

	public boolean remove(T entity) {
		return getDao().remove(entity);
	}

	public abstract EntityDao<T> getDao();
}
