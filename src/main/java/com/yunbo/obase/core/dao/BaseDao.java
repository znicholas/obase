package com.yunbo.obase.core.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;
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

	/**
	 * 保存，新建或更新
	 */
	@Override
	public T save(T entity) {
		return super.save(entity);
	}

	/**
	 * 根据ID查找记录
	 */
	@Override
	public T find(Long id) {
		return super.find(id);
	}

	@Override
	public T[] find(Long... ids) {
		return super.find(ids);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public boolean removeById(Long id) {
		return super.removeById(id);
	}

	@Override
	public boolean remove(T entity) {
		return super.remove(entity);
	}

	/**
	 * 指删除
	 * */
	@Override
	public void removeByIds(Long... ids) {
		super.removeByIds(ids);
	}

	public void removeByIds(T... entities) {
		super.remove(entities);
	}

	/**
	 * 一般查询
	 * 
	 * @param exps
	 * @return
	 */
	public <RT> List<RT> query(List<Expression> exps) {
		Search search = new Search(persistentClass);
		for (Iterator<Expression> iterator = exps.iterator(); iterator
				.hasNext();) {
			Expression ep = iterator.next();
			search.addFilter(ep.getFilter());
		}

		return super.search(search);
	}

	/**
	 * 分页查询
	 * 
	 * @param exps
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Pager<T> query(List<Expression> exps, int pageNumber, int pageSize) {
		Pager<T> pager = new Pager<T>();
		Search search = new Search(persistentClass);
		for (Iterator<Expression> iterator = exps.iterator(); iterator
				.hasNext();) {
			Expression ep = iterator.next();
			search.addFilter(ep.getFilter());
		}

		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		// 查询从0开始计算
		search.setPage(pageNumber - 1);
		search.setMaxResults(pageSize);

		SearchResult<T> searchResult = super.searchAndCount(search);

		pager.setPageNumber(pageNumber);
		pager.setPageSize(pageSize);
		pager.setRecordCount(searchResult.getTotalCount());
		pager.setResult(searchResult.getResult());

		return pager;
	}
}
