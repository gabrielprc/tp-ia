package main.java.model.dao;

import java.util.List;

import main.java.model.beans.Patient;

public class PatientDao extends GenericDao<Patient> {

	@Override
	public void save(Patient obj) {
		saveGeneric(obj);
	}

	@Override
	public List<Patient> list() {
		return listGeneric(Patient.class);
	}

}
