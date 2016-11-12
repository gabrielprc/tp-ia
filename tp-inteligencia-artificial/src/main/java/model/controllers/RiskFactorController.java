package main.java.model.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.RiskFactor;
import main.java.model.dao.DaoQuery;
import main.java.model.dao.RiskFactorDao;
import main.java.model.views.RiskFactorView;

public class RiskFactorController implements Controller<RiskFactorView> {
	
	private RiskFactorDao riskFactorDao = new RiskFactorDao();

	@Override
	public RiskFactorView createOrUpdate(RiskFactorView view) {
		RiskFactor riskFactor = RiskFactor.fromView(view);
		riskFactorDao.save(riskFactor);
		return riskFactor.toView();
	}

	@Override
	public List<RiskFactorView> list(DaoQuery query) {
		List<RiskFactorView> views = new ArrayList<RiskFactorView>();
		for (RiskFactor r : riskFactorDao.list(query)) {
			views.add(r.toView());
		}
		return views;
	}

	@Override
	public void delete(RiskFactorView view) {
		RiskFactor riskFactor = RiskFactor.fromView(view);
		riskFactorDao.delete(riskFactor);
	}

}
