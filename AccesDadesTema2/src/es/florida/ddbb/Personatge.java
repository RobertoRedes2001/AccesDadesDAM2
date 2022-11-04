package es.florida.ddbb;

import java.util.Scanner;

public class Personatge {
	private String name, title, element;
	
	private int id, poweruds;
	
	public Personatge() {
			Scanner sc = new Scanner(System.in);
	
			this.id = 0;
			
			System.out.print("Nom: ");
			this.name = sc.nextLine();
			
			System.out.print("Titol: ");
			this.title = sc.nextLine();
			
			System.out.print("Unitats de poder: ");
			this.poweruds = Integer.parseInt(sc.nextLine());
			
			System.out.print("Poder Elemental: ");
			this.element = sc.nextLine();
		
	}
	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getElement() {
		return element;
	}

	public int getId() {
		return id;
	}

	public int getPoweruds() {
		return poweruds;
	}

	
}

