package main.java.model.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.Affection;
import main.java.model.dao.AffectionDao;
import main.java.model.dao.DaoQuery;
import main.java.model.views.AffectionView;

public class AffectionController implements Controller<AffectionView> {

	private AffectionDao affectionDao = new AffectionDao();
	
	
	@Override
	public AffectionView createOrUpdate(AffectionView view) {
		Affection affection = Affection.fromView(view);
		affectionDao.save(affection);
		return affection.toView();
	}

	@Override
	public List<AffectionView> list(DaoQuery query) {
		List<AffectionView> views = new ArrayList<AffectionView>();
		for (Affection a : affectionDao.list(query)) {
			views.add(a.toView());
		}
		return views;
	}

	@Override
	public void delete(AffectionView view) {
		Affection affection = Affection.fromView(view);
		affectionDao.delete(affection);
	}

}
