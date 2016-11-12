package test;

import java.util.List;

import main.java.model.beans.Affection;
import main.java.model.dao.AffectionDao;

public class GenericTest {

		
	public static void main(String[] args) {
		AffectionDao dao = new AffectionDao();
		List<Affection> affections = dao.list();
	}

}
