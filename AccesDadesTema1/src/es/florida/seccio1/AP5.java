package es.florida.seccio1;

import java.io.File;
import java.util.Scanner;

public class AP5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiltroExtension extender = new FiltroExtension(".txt");
		File psp = new File(args[0]);
		String[] array = psp.list(extender);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}

}
