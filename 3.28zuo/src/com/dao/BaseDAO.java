package com.dao;

import java.util.List;

public interface BaseDAO<T> {
	public void add(T t);
	public void delete(int id);
	public void update(T t);
	public T findById(int id);
	public List<T> findAll();
	public List<T> findBySQL(String sql);
	public List<T> findByName(String name);
}
