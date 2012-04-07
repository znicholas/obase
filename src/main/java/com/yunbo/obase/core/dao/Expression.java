package com.yunbo.obase.core.dao;

import com.googlecode.genericdao.search.Filter;

public class Expression {
	private String name;
	private String operator;
	private Object value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * 根据表达式获取过滤
	 * 
	 * @return
	 */
	public Filter getFilter() {
		if ("eq".equalsIgnoreCase(this.getOperator()) || "=".equals(this.getOperator())) {
			return Filter.equal(this.getName(), this.getValue());
		} else if ("neq".equalsIgnoreCase(this.getOperator()) || "<>".equals(this.getOperator())) {
			return Filter.notEqual(this.getName(), this.getValue());
		} else if ("goe".equalsIgnoreCase(this.getOperator()) || ">=".equals(this.getOperator())) {
			return Filter.greaterOrEqual(this.getName(), this.getValue());
		} else if ("gt".equalsIgnoreCase(this.getOperator()) || ">".equals(this.getOperator())) {
			return Filter.greaterThan(this.getName(), this.getValue());
		} else if ("ilike".equalsIgnoreCase(this.getOperator())) {
			return Filter.ilike(this.getName(), (String) this.getValue());
		} else if ("like".equalsIgnoreCase(this.getOperator())) {
			return Filter.ilike(this.getName(), (String) this.getValue());
		} else if ("null".equalsIgnoreCase(this.getOperator())) {
			return Filter.isNull(this.getName());
		} else if ("notNull".equalsIgnoreCase(this.getOperator())) {
			return Filter.isNotNull(this.getName());
		} else if ("in".equalsIgnoreCase(this.getOperator())) {
			return Filter.in(this.getName(), this.getValue());
		} else if ("notIn".equalsIgnoreCase(this.getOperator())) {
			return Filter.notIn(this.getName());
		} else if ("lt".equalsIgnoreCase(this.getOperator()) || "<".equals(this.getOperator())) {
			return Filter.lessThan(this.getName(), this.getValue());
		} else if ("loe".equalsIgnoreCase(this.getOperator()) || "<".equals(this.getOperator())) {
			return Filter.lessOrEqual(this.getName(), this.getValue());
		} else if ("empty".equalsIgnoreCase(this.getOperator())) {
			return Filter.isEmpty(this.getName());
		} else if ("notEmpty".equalsIgnoreCase(this.getOperator())) {
			return Filter.isNotEmpty(this.getName());
		}

		return Filter.isNotNull(this.getName());
	}
}
