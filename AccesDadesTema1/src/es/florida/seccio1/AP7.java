package es.florida.seccio1;

import java.io.File;

public class AP7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File psp = new File(args[0]);
		String[] array; 
		if(args.length==1) {
			array = psp.list();
		}else {
			for(int i=1;i<args.length;i++) {
				FiltroExtension extender = new FiltroExtension(args[i]);
				array = psp.list(extender);
				for(int j=0;j<array.length;j++) {
					System.out.println(array[j]);
				}
			}
		}
		
	}

}