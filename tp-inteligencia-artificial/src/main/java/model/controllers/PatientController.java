package main.java.model.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.Patient;
import main.java.model.dao.DaoQuery;
import main.java.model.dao.PatientDao;
import main.java.model.views.PatientView;

public class PatientController implements Controller<PatientView> {

	private PatientDao patientDao = new PatientDao();
	
	
	@Override
	public PatientView create(PatientView view) {
		Patient patient = Patient.fromView(view);
		patientDao.save(patient);
		return patient.toView();
	}

	@Override
	public List<PatientView> list(DaoQuery query) {
		List<PatientView> views = new ArrayList<PatientView>();
		for (Patient p : patientDao.list(query)) {
			views.add(p.toView());
		}
		return views;
	}

	@Override
	public PatientView update(PatientView view) {
		Patient patient = Patient.fromView(view);
		patientDao.save(patient);
		return patient.toView();
	}

	@Override
	public void delete(PatientView view) {
		Patient patient = Patient.fromView(view);
		patientDao.delete(patient);
	}

	
}
