package es.florida.seccio3;

import java.util.Scanner;

public class Charcter {
	private String id, name, title, poweruds, element;

	public Charcter(String id, String name, String title, String poweruds, String element) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.poweruds = poweruds;
		this.element = element;
	}
	
	public Charcter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID: ");
		this.id = sc.nextLine();
		
		System.out.print("Nom: ");
		this.name = sc.nextLine();
		
		System.out.print("Titol: ");
		this.title = sc.nextLine();
		
		System.out.print("Unitats de poder: ");
		this.poweruds = sc.nextLine();
		
		System.out.print("Poder Elemental: ");
		this.element = sc.nextLine();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoweruds() {
		return poweruds;
	}

	public void setPoweruds(String poweruds) {
		this.poweruds = poweruds;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	
}
