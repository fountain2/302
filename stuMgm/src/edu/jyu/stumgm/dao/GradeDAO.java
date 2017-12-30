package edu.jyu.stumgm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.HibernateCallback;

import edu.jyu.stumgm.entity.Grade;
import edu.jyu.stumgm.entity.Student;

public class GradeDAO extends BaseDAO<Grade> implements IGradeDAO{
	public GradeDAO(){
		super(Grade.class);
	}
	
	private SessionFactory sessionFactory;
	private List<Grade> gradelist;

	public void deleteByStudentsNumbers(final List<String> numbers) {
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Grade g where g.student.stuNumber in (:n)")
        .setParameterList("n", numbers).executeUpdate();
//		template.execute(new HibernateCallback(){
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				return session.createQuery("delete from Grade g where g.student.stuNumber in (:n)")
//			          .setParameterList("n", numbers).executeUpdate();
//			}
//			
//		});
	}

	public Grade findByStudentNumber(final String number) {
		return (Grade)template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				  return session.createQuery("from Grade g where g.student.stuNumber = :n")
				     .setParameter("n", number).setMaxResults(1).uniqueResult();
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	public List<Grade> findByScoreLessThan(final int score) {
		return (List<Grade>)template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria cri = session.createCriteria(Grade.class);
				cri.add(
						Restrictions.or(Restrictions.lt("numElectron", score),
						(Restrictions.or(Restrictions.lt("numSoftware", score),
						(Restrictions.or(Restrictions.lt("numSecurity", score),
					(Restrictions.or(Restrictions.lt("numJava", score),
					(Restrictions.or(Restrictions.lt("numDB", score),
					(Restrictions.or(Restrictions.lt("numImage", score),
					(Restrictions.or(Restrictions.lt("numDistributed", score),
					(Restrictions.lt("numTest", score))))))))))))))));
				return cri.list();
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	public List<Grade> findOrderBySum(final int number, final boolean isAsc) {
		return (List<Grade>)template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String order = null;
				if(! isAsc){
					order = "desc";
				}else{
					order = "asc";
				}
				Query query = session.createQuery("from Grade g order by (g.numElectron + g.numSoftware + g.numSecurity " +
						          "+ g.numJava + g.numDB + g.numImage + g.numDistributed + g.numTest) " + order);
				query.setMaxResults(number);
				return query.list();
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	public List<Grade> findGradebyStudentNumberOrName(final String key) {
		return (List<Grade>)template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria cri = session.createCriteria(Grade.class);
				cri.createCriteria("student")
				.add(Restrictions.or(Restrictions.like("stuNumber", key,
 MatchMode.ANYWHERE), 
						Restrictions.like("username", key,
MatchMode.ANYWHERE)));
				cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				return cri.list();
			}
		});
	}

	public void deleteByStudentNumber(final String stuNumber) {			
		template.bulkUpdate("delete from Grade g where g.student.stuNumber = ?", stuNumber);		
	}	
	
	public void deleteAll(){
		template.bulkUpdate("delete from Grade");
	}

	public void saveOrUpdate(Grade obj) {
		template.saveOrUpdate(obj);
		
	}
	
	public List<Grade> findAll()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Grade.class);

		List<Grade> gradelist = (List<Grade>)criteria.list();
		return gradelist;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Grade> getGradelist() {
		return gradelist;
	}

	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}
	
	public void update(Grade grade)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(grade);
		session.getTransaction().commit();
		session.close();
	}
}