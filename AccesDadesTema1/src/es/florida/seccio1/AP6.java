package es.florida.seccio1;

import java.io.File;

public class AP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File psp = new File(args[0]);
		String[] array; 
		if(args.length==1) {
			array = psp.list();
		}else {
			FiltroExtension extender = new FiltroExtension(args[1]);
			array = psp.list(extender);
		}
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

}
