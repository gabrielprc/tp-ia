package main.java.model.dao;

import java.util.List;

import main.java.model.beans.RiskFactor;

public class RiskFactorDao extends GenericDao<RiskFactor> {

	@Override
	public void save(RiskFactor obj) {
		saveGeneric(obj);
	}

	@Override
	public List<RiskFactor> list() {
		return listGeneric(RiskFactor.class);
	}

	@Override
	public List<RiskFactor> list(DaoQuery query) {
		return listGeneric(RiskFactor.class, query);
	}

}
