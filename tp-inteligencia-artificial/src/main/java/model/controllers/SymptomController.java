package main.java.model.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.Symptom;
import main.java.model.dao.DaoQuery;
import main.java.model.dao.SymptomDao;
import main.java.model.views.SymptomView;

public class SymptomController implements Controller<SymptomView> {

	private SymptomDao symptomDao = new SymptomDao();
	
	@Override
	public SymptomView createOrUpdate(SymptomView view) {
		Symptom symptom = Symptom.fromView(view);
		symptomDao.save(symptom);
		return symptom.toView();
	}

	@Override
	public List<SymptomView> list(DaoQuery query) {
		List<SymptomView> views = new ArrayList<SymptomView>();
		for (Symptom s : symptomDao.list(query)) {
			views.add(s.toView());
		}
		return views;
	}

	@Override
	public void delete(SymptomView view) {
		Symptom symptom = Symptom.fromView(view);
		symptomDao.delete(symptom);
	}

}
