package main.java.model.controllers;

import java.util.List;

import main.java.model.dao.DaoQuery;

public interface Controller<V> {

	public V createOrUpdate(V view);
	
	public List<V> list(DaoQuery query);
	
	public void delete(V view);
	
}
