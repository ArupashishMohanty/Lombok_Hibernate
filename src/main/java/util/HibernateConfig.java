package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import client.Employee;

public class HibernateConfig {
	public static SessionFactory getSessionFactory() {
Properties ps=new Properties();
ps.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
ps.put(Environment.URL, "jdbc:mysql://localhost:3306/db");
ps.put("hibernate.connection.username", "root");
ps.put("hibernate.connection.password", "root");
ps.put(Environment.SHOW_SQL, "true");
ps.put(Environment.FORMAT_SQL, "true");
ps.put(Environment.HBM2DDL_AUTO, "update");

StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().applySettings(ps).build();
//Create a MetadataSources and add annotated entity classes
MetadataSources metadataSources =new MetadataSources(ssr).addAnnotatedClass(Employee.class);
Metadata meta=metadataSources.buildMetadata();
//Create a SessionFactory
SessionFactory sessionFactory=meta.buildSessionFactory();
return sessionFactory;
}
}