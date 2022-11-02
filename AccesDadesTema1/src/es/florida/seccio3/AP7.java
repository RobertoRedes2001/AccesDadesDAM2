package es.florida.seccio3;

import java.util.ArrayList;
import java.util.List;

public class AP7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Charcter> jugaors = new ArrayList<Charcter>();
		for(int i=0; i<=2;i++) {
			Charcter j1 = new Charcter();
			jugaors.add(j1);
		}
		
		for(int i=0; i<=2;i++) {
			System.out.println("ID del lluitador : " + jugaors.get(i).getId());
			System.out.println("Nom del lluitador : " + jugaors.get(i).getName());
			System.out.println("Titol del lluitador : " + jugaors.get(i).getTitle());
			System.out.println("Unitats de poder del lluitador : " + jugaors.get(i).getPoweruds());
			System.out.println("Element del lluitador : " + jugaors.get(i).getElement());
		}
		
		
	}

}
