package es.florida.seccio1;

import java.io.File;

public class AP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File psp = new File(".");
		if(psp.exists()) {
			System.out.println("Existe");
		}else {
			System.out.println("No existe");
		}
	}

}
