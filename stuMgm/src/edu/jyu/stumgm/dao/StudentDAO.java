package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;

public class StudentDAO extends BaseDAO<Student> implements IStudentDAO{
	public StudentDAO(){
		super(Student.class);
	}
	
	public void save(Student s){
		
//		super.setSessionFactory(sessionFactory);
//		super.save(s);	
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
//		template.save(s);
	}

	public void delete(String stuNumber) {
		Student stu = new Student();
		stu.setStuNumber(stuNumber);
		template.delete(stu);		
	}

	@SuppressWarnings("unchecked")
	public List<Student> findByKey(final String key) {
		return (List<Student>)template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria cri = session.createCriteria(Student.class);
				cri.add(Restrictions.or(Restrictions.like("stuNumber", key,
                                    MatchMode.ANYWHERE), 
						Restrictions.or(Restrictions.like("username", key,
                                    MatchMode.ANYWHERE),
						Restrictions.or(Restrictions.like("gender", key,
                                    MatchMode.ANYWHERE),
						Restrictions.or(Restrictions.like("city", key,
                                    MatchMode.ANYWHERE),
												Restrictions.or(Restrictions.like("identityID", key, MatchMode.ANYWHERE),
														Restrictions.or(Restrictions.like("phone", key, MatchMode.ANYWHERE),
																Restrictions.or(Restrictions.like("email", key, MatchMode.ANYWHERE), 
																		Restrictions.or(Restrictions.like("postID", key, MatchMode.ANYWHERE),
																				Restrictions.like("address", key, MatchMode.ANYWHERE))))))))));
				return cri.list();
			}
		});
	}

	public void deleteByNumbers(final List<String> numbers) {
//		template.execute(new HibernateCallback(){
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException{
//				return session.createQuery("delete from Student g where g.stuNumber in (:n)").setParameterList("n", numbers).executeUpdate();
//			}
//		});
		
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Student g where g.stuNumber in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	
	public List<Student> findAll()
	{
//		return template.find("from Student");
//		return super.findAll();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.eq("studentName", name));
		
		List<Student> list = (List<Student>)criteria.list();
		return list;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	public Student get(Serializable stuNumber)
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("stuNumber", stuNumber));
		List<Student> res = (List<Student>)criteria.list();
		if(res==null||res.isEmpty()) return null;
		return res.get(0);
	}
	
	public void update(Student student)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		session.close();
	}
}