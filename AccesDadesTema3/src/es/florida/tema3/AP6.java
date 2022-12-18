package es.florida.tema3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AP6 {

	public static void main(String[] args) {
	
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personatge.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Personatge fighter = (Personatge) session.get(Personatge.class, 1);
		fighter.setName("Kusanali");
		session.update(fighter);
		session.getTransaction().commit();
		session.close();
	}

}
