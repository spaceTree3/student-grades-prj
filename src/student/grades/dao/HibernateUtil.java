package student.grades.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class HibernateUtil {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
	public void openSession() {
		this.setSession(this.getSessionFactory().openSession());
		this.getSession().beginTransaction();
	}
	
	public void closeSession() {
		this.getSession().getTransaction().commit();
		this.getSession().close();

	}
}
