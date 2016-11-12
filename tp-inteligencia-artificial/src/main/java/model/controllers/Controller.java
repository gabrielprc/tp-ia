package main.java.model.controllers;

import java.util.List;

import main.java.model.dao.DaoQuery;

public interface Controller<V> {

	public V create(V view);
	
	public List<V> list(DaoQuery query);
	
	public V update(V view);
	
	public void delete(V view);
	
}
