package es.florida.seccio1;

import java.io.File;
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
		File ax = new File("arxiu.txt");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
