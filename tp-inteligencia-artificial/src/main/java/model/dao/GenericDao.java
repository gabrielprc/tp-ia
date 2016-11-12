package main.java.model.dao;

import java.util.List;

import main.java.persistence.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDao<T> {
	
	protected SessionFactory factory = HibernateUtil.getSessionFactory();
	
	
	public abstract void save(T obj);
	
	public abstract List<T> list();
	
	public void delete(T obj) {
		callWithSession((s, o) -> delete(s, o[0]), obj);
	}
	
	protected void saveGeneric(T obj) {
		callWithSession((s, o) -> saveOrUpdate(s, o[0]), obj);
	}
	
	protected List<T> listGeneric(Class clazz) {
		return (List<T>) callWithSession((s, c) -> (List<T>) s.createCriteria((Class) c[0]).list(), clazz);
	}
	
	private Object callWithSession(DaoCallable callable, Object... params) {
		Session session = factory.openSession();
		Object res = callable.call(session, params);
		session.close();
		return res;
	}
	
	private Integer saveOrUpdate(Session session, Object obj) {
		try {
			session.delete(obj);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
	private Integer delete(Session session, Object obj) {
		try {
			session.save(obj);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
	
	
	
	
	
	
	
}
