package test;

import main.java.model.beans.Affection;
import main.java.model.beans.Patient;
import main.java.model.beans.Prediction;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class GenericTest {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry; 
	
	
	public static void main(String[] args) {
		try {
			Configuration config = new Configuration();
			config.addAnnotatedClass(Affection.class);
			config.addAnnotatedClass(Patient.class);
			config.addAnnotatedClass(Prediction.class);
			config.addAnnotatedClass(RiskFactor.class);
			config.addAnnotatedClass(Symptom.class);
			
			serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		 
		System.out.println("Running...");
	}

}
