package main.java.model.dao;

import org.hibernate.Session;

public interface DaoCallable<T> {

	public T call(Session session, Object... params);
	
}
