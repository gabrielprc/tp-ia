package main.java.model.dao;

import java.util.List;

import main.java.persistence.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public abstract class GenericDao<T> {
	
	protected SessionFactory factory = HibernateUtil.getSessionFactory();
	
	
	public abstract void save(T obj);
	
	public abstract List<T> list();
	
	public abstract List<T> list(DaoQuery query);
	
	public void delete(T obj) {
		callWithSession((s, o) -> delete(s, o[0]), obj);
	}
	
	protected void saveGeneric(T obj) {
		callWithSession((s, o) -> saveOrUpdate(s, o[0]), obj);
	}
	
	protected List<T> listGeneric(Class clazz) {
		return listGeneric(clazz, null);
	}
	
	protected List<T> listGeneric(Class clazz, DaoQuery query) {
		return (List<T>) callWithSession(
				(s, c)
					->
				list(s, (Class) c[0], query),
				clazz
			);
	}
	
	private List<T> list(Session session, Class clazz, DaoQuery query) {
		Criteria criteria = session.createCriteria(clazz); 
		if (query != null) {
			if (query.names != null && !query.names.isEmpty()) {
				Criterion criterion = Restrictions.like("name", "%" + query.names.get(0) + "%");
				
				for (int i = 1; i < query.names.size(); i++) {
					criterion = Restrictions.or(criterion, Restrictions.like("name", "%" + query.names.get(i) + "%"));
				}
				
				criteria.add(criterion);
			}
			
			if (query.ids != null && !query.ids.isEmpty()) {				
				Criterion criterion = Restrictions.eq("id", query.ids.get(0));
				
				for (int i = 1; i < query.ids.size(); i++) {
					criterion = Restrictions.or(criterion, Restrictions.eq("id", query.ids.get(i)));
				}
				
				criteria.add(criterion);
			}
			
			if (query.types != null && !query.ids.isEmpty()) {
				Criterion criterion = Restrictions.eq("type", query.types.get(0));
				
				for (int i = 1; i < query.ids.size(); i++) {
					criterion = Restrictions.or(criterion, Restrictions.eq("type", query.types.get(i)));
				}
				
				criteria.add(criterion);
			}
		}
		return (List<T>) criteria.list();
	}
	
	private Object callWithSession(DaoCallable callable, Object... params) {
		Session session = factory.openSession();
		Object res = callable.call(session, params);
		session.close();
		return res;
	}
	
	private Integer saveOrUpdate(Session session, Object obj) {
		try {
			session.saveOrUpdate(obj);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
	private Integer delete(Session session, Object obj) {
		try {
			session.delete(obj);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	public T getByName(String name) {
		return list(new DaoQuery.Builder().name(name).build()).stream().findFirst().orElse(null);
	}

	public List<T> getByNames(List<String> names) {
		DaoQuery.Builder builder = new DaoQuery.Builder();
		names.forEach(builder::name);
		return list(builder.build());
	}
	
}
