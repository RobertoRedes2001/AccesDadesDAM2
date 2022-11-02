package es.florida.seccio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AP9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Libro> libros = new ArrayList<Libro>();
		Biblioteca bibli = new Biblioteca(libros);
		int opt;
		do {
			System.out.println("BIBLIOTECA PACHECO");
			System.out.println("==================");
			System.out.println("1.Guardar Llista y mostrar titols.");
			System.out.println("2.Mostrar info de un llibre.");
			System.out.println("3.Registrar un llibre.");
			System.out.println("4.Actualitzar un llibre.");
			System.out.println("5.Esborrar un llibre.");
			System.out.println("6.Salir");
			System.out.print("Elgie una opcion: ");
			opt = sc.nextInt();
			switch (opt) { 
			case 1:
				 bibli.tornarLlista();
				 bibli.llistarTitols();
				 break;
		    case 2: 
		    	 bibli.mostrarLlibre();
		    	 break;
		    case 3:
			     bibli.crearLlibre();
			     break;
		    case 4:
			     bibli.actualitzaLlibre();
			     break;
		    case 5:
			     bibli.borrarLlibre();
			     break;
		    case 6:
			     System.out.println("Gracies por venir");
			     break;
			}
		}while(opt!=6);
		
		
	}

}
