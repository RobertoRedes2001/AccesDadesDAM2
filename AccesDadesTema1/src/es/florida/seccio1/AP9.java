package es.florida.seccio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AP9 {

	public static void getInformacio(File arxiu) {
		if(arxiu.isFile()) {
			System.out.println("Name: "+arxiu.getName());
			System.out.println("Path: "+arxiu.getPath());
			System.out.println("Absolute Path: "+arxiu.getAbsolutePath());
			System.out.println("Can Write: "+arxiu.canWrite());
			System.out.println("Can Read: "+arxiu.canRead());
			System.out.println("Length: "+arxiu.length());
		}else {
			String[] array; 
			array = arxiu.list();
			for(int i=0;i<array.length;i++) {
				System.out.println(array[i]);
			}
			
		}	
	}	

	public static void creaCarpeta(File directori) {
		if(directori.exists()) {
			System.out.println("Directori ja exists");
		}else {
			directori.mkdirs();
			System.out.println("Directori ja creat");
		}
		
	}

	public static void creaFitxer() {
		try {
			FileWriter fw = new FileWriter("deuchos2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("1999, vaya verano.");
			bw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void elimina(File arxiu) {
		Scanner sc = new Scanner(System.in);
		String resposta = sc.next();
		if(resposta.equals("y")) {
			arxiu.delete();
		}else if(resposta.equals("n")) {
			System.out.println("Accio detinguda.");
		}else {
			System.out.println("Error.");
		}
		
	}

	public static void renomena(File arxiu) {
		File nouArx = new File("arxiuNou.txt");
        if (arxiu.renameTo(nouArx)) {
            System.out.println("arxiu renombrat");
        } else {
            System.out.println("error");
        }
	}
	
	public static void mostrarMenu() {
		System.out.println("GESTOR D'ARXIUS Y DIRECTORIS FLORIDA");
		System.out.println("====================================");
		System.out.println("1.Mostrar Informació");
		System.out.println("2.Crear directori");
		System.out.println("3.Crear fitxer");
		System.out.println("4.Eliminar");
		System.out.println("5.Renomenar");
		System.out.println("6.Salir");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int option=0;
		File arx = new File("deuchos2.txt");
		
		do {
			mostrarMenu();
			System.out.print("Opció: ");
			option = sc.nextInt();
			switch(option) {
			case 1:
				getInformacio(arx);
				break;
			case 2:
				creaCarpeta(arx);
				break;
			case 3:
				creaFitxer();
				break;
			case 4:
				elimina(arx);
				break;
			case 5:
				renomena(arx);
			}
			
		}while(option!=6);
		
	}

}
