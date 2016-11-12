package main.java.model.dao;

import java.util.List;

import main.java.model.beans.Prediction;

public class PredictionDao extends GenericDao<Prediction> {

	@Override
	public void save(Prediction obj) {
		saveGeneric(obj);
	}

	@Override
	public List<Prediction> list() {
		return listGeneric(Prediction.class);
	}

	@Override
	public List<Prediction> list(DaoQuery query) {
		return listGeneric(Prediction.class, query);
	}

}
