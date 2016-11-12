package main.java.model.dao;

import java.util.List;

import main.java.model.beans.Symptom;

public class SymptomDao extends GenericDao<Symptom> {

	@Override
	public void save(Symptom obj) {
		saveGeneric(obj);
	}

	@Override
	public List<Symptom> list() {
		return listGeneric(Symptom.class);
	}

	@Override
	public List<Symptom> list(DaoQuery query) {
		return listGeneric(Symptom.class, query);
	}

}
