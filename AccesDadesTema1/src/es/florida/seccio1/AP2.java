package es.florida.seccio1;

import java.io.File;

public class AP2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File psp = new File(".");
		System.out.println("Name: "+psp.getName());
		System.out.println("Path: "+psp.getPath());
		System.out.println("Absolute Path: "+psp.getAbsolutePath());
		System.out.println("Can Write: "+psp.canWrite());
		System.out.println("Can Read: "+psp.canRead());
		System.out.println("Length: "+psp.length());
	}

}
