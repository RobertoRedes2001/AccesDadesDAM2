package es.florida.miniproyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AP8 {
	
	static public void llegirLlibres() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Biblioteca.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List listaLibros = new ArrayList<Biblioteca>();
		listaLibros = session.createQuery("FROM Biblioteca").list();
		for(int i=0;i<listaLibros.size();i++) {
			Biblioteca book = (Biblioteca) listaLibros.get(i);
			System.out.println(i+"."+book.getTitol());
		}
		session.getTransaction().commit();
		session.close();
	}
	
	static public void verLlibre() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Biblioteca.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.print("ELIGE ID DE TU LLIBRE: ");
		int chara = sc.nextInt();
		Biblioteca book = (Biblioteca) session.get(Biblioteca.class, chara);
		System.out.println("Titol: "+book.getTitol());
		System.out.println("Autor: "+book.getAutor());
		System.out.println("Any de publicacio: "+book.getAny());
		System.out.println("Editorial: "+book.getEditorial());
		System.out.println("Pagines: "+book.getPagines());
		session.getTransaction().commit();
		session.close();
	}

	static public void afegirLlibre() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Biblioteca.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Titol: ");
		String tit = sc.nextLine();
		System.out.print("Autor: ");
		String aut = sc.nextLine();
		System.out.print("Editorial: ");
		String edi = sc.nextLine();
		System.out.print("Any de Publicacio: ");
		int any = sc.nextInt();
		System.out.print("Nombre de pagines: ");
		int pag = sc.nextInt();
		
		Biblioteca book = new Biblioteca(any,pag,tit,aut,edi);
		Serializable id = session.save(book);
		session.getTransaction().commit();
		session.close();

	}
	
	static public void editarLlibre() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Biblioteca.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Titol: ");
		String tit = sc.nextLine();
	
		
		System.out.print("Autor: ");
		String aut = sc.nextLine();
		
		
		System.out.print("Editorial: ");
		String edi = sc.nextLine();
	
		
		System.out.print("Any de Publicacio: ");
		int any = sc.nextInt();
	
		
		System.out.print("Nombre de pagines: ");
		int pag = sc.nextInt();
		
		System.out.print("ID del llibre a editar: ");
		int chara = sc.nextInt();

		Biblioteca book = (Biblioteca) session.get(Biblioteca.class, chara);
		
		book.setTitol(tit);
		book.setAutor(aut);
		book.setEditorial(edi);
		book.setAny(any);
		book.setPagines(pag);
		session.update(book);
		session.getTransaction().commit();
		session.close();
	}
	
	static public void esborrarLlibre() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Biblioteca.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ELIGE ID DE TU LLIBRE: ");
		int chara = sc.nextInt();
		Biblioteca book = (Biblioteca) session.get(Biblioteca.class, chara);
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opt=0;
		do {
			System.out.println("SUPER GESTOR DE BASES DE DATOS.");
			System.out.println("===============================");
			System.out.println("1.Llegir tots els llibres");
			System.out.println("2.Llegir un llibre");
			System.out.println("3.Afegir nou llibre");
			System.out.println("4.Editar llibre existent");
			System.out.println("5.Esborrar un llibre");
			System.out.println("6.Salir");
			
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				llegirLlibres();
				break;
			case 2:
				verLlibre();
				break;
			case 3:
				afegirLlibre();
				break;
			case 4:
				editarLlibre();
				break;
			case 5:
				esborrarLlibre();
				break;
			case 6:
				System.out.println("Gracias por usar l'app.");
				break;
			default:
				System.out.println("Funcionalitat no existent o no programada.");
				break;
			}
			
		}while(opt!=6);
		
		
	}

}
