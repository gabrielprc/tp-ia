package main.java.model.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.Prediction;
import main.java.model.dao.DaoQuery;
import main.java.model.dao.PredictionDao;
import main.java.model.views.PredictionView;

public class PredictionController implements Controller<PredictionView> {

	private PredictionDao predictionDao = new PredictionDao();
	
	
	@Override
	public PredictionView createOrUpdate(PredictionView view) {
		Prediction prediction = Prediction.fromView(view);
		predictionDao.save(prediction);
		return prediction.toView();
	}

	@Override
	public List<PredictionView> list(DaoQuery query) {
		List<PredictionView> views = new ArrayList<PredictionView>();
		for (Prediction p : predictionDao.list(query)) {
			views.add(p.toView());
		}
		return views;
	}

	@Override
	public void delete(PredictionView view) {
		Prediction prediction = Prediction.fromView(view);
		predictionDao.delete(prediction);
	}

}
