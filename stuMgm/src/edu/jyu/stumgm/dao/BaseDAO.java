package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class BaseDAO<T> {
	private Class<T> targetClass;

	protected HibernateTemplate template;

	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	protected BaseDAO(Class<T> c) {
		targetClass = c;
	}

	public void save(T obj) {
		
//		Session session = sessionFactory.openSession();
		template.save(obj);

	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) template.get(targetClass, id);
	}

	public void update(T obj) {
		template.update(obj);
	}

	public void delete(T obj) {
		template.delete(obj);
	}

	public void delete(Long id) {
		try {
			T obj = (T) targetClass.newInstance();
			Method method = targetClass.getDeclaredMethod("setId", Long.class);
			method.invoke(obj, id);
			delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createCriteria(targetClass).list();
			}
		});
		
	}
}