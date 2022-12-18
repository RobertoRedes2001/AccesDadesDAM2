package es.florida.tema3;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AP4 {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personatge.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Personatge fighter = (Personatge) session.get(Personatge.class, 1);
		System.out.println("Nombre: "+fighter.getName());
		System.out.println("Titulo: "+fighter.getTitle());
		System.out.println("Power Units: "+fighter.getPoweruds());
		System.out.println("Elemento: "+fighter.getElement());
		session.getTransaction().commit();
		session.close();
	}

}
