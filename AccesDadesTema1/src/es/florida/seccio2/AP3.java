package es.florida.seccio2;

import java.io.FileReader;
import java.io.IOException;

public class AP3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader(args[0]);
			int read = fr.read();
			while(read!=-1) {
				System.out.print((char)read);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e){
					System.out.println("Execution Irrumped");
				}
				read = fr.read();
			}
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
