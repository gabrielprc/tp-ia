package test;

import main.java.model.beans.Affection;
import main.java.model.beans.Patient;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.dao.AffectionDao;
import main.java.model.dao.PatientDao;
import main.java.model.dao.RiskFactorDao;
import main.java.model.dao.SymptomDao;

public class GenericTest {

		
	public static void main(String[] args) {
		AffectionDao affectionDao = new AffectionDao();
		PatientDao patientDao = new PatientDao();
		RiskFactorDao riskFactorDao = new RiskFactorDao();
		SymptomDao symptomDao = new SymptomDao();
		
		System.out.println("Affections\n----------------");
		for (Affection a : affectionDao.list()) {
			System.out.println(a.getName() + "\n");
		}
		
		System.out.println("----------------");
		
		System.out.println("Symptoms\n----------------");
		for (Symptom s : symptomDao.list()) {
			System.out.println(s.getName() + "\n");
		}
		
		System.out.println("----------------");
		
		System.out.println("Risk factors\n----------------");
		for (RiskFactor r : riskFactorDao.list()) {
			System.out.println(r.getName() + "\n");
		}
		
		System.out.println("----------------");
		
		System.out.println("Patients\n----------------");
		for (Patient p : patientDao.list()) {
			System.out.println(p.getName() + "\n");
		}
	}

}
