package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import client.Employee;
import util.HibernateConfig;

public class app {
	public static void main(String[] args) {
		Employee em = new Employee();
//		em.setId(1);
		em.setName("tayal");
		em.setGender("female");
		em.setSalary(65000);
		
		
		
		
		
		SessionFactory sf=HibernateConfig.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee e=session.get(Employee.class, 2);
		System.out.println(e);
		session.save(em);
		tx.commit();
		
	}

}
