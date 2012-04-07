package com.yunbo.obase.core.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

public abstract class BaseDao<T> extends GenericDAOImpl<T, Long> {
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}

	@Override
	@Autowired
	public void setSearchProcessor(JPASearchProcessor searchProcessor) {
		super.setSearchProcessor(searchProcessor);
	}

	@Override
	public T save(T entity) {
		return super.save(entity);
	}

	@Override
	public T find(Long id) {
		return super.find(id);
	}

	@Override
	public boolean removeById(Long id) {
		return super.removeById(id);
	}
	
	@Override
	public boolean remove(T entity) {
		return super.remove(entity);
	}

	public <RT> List<RT> query(List<Expression> exps) {
		Search search = new Search(persistentClass);
		for (Iterator<Expression> iterator = exps.iterator(); iterator.hasNext();) {
			Expression ep = iterator.next();
			search.addFilter(ep.getFilter());
		}

		return super.search(search);
	}
}
