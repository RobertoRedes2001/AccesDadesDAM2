package es.florida.seccio1;

import java.io.File;
import java.util.Scanner;

public class AP5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String dir = sc.nextLine();
		FiltroExtension extender = new FiltroExtension(".txt");
		File psp = new File(dir);
		String[] array = psp.list(extender);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}

}
