package main.java.model.dao;

import java.util.List;

import main.java.model.beans.Affection;

public class AffectionDao extends GenericDao<Affection> {

	@Override
	public void save(Affection obj) {
		saveGeneric(obj);
	}

	@Override
	public List<Affection> list() {
		return listGeneric(Affection.class);
	}

	
	
}
