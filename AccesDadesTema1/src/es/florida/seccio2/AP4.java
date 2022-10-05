package es.florida.seccio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			String read = br.readLine();
			while(read!=null) {
				System.out.println(read);
				try {
					Thread.sleep(500);
				}catch(InterruptedException e){
					System.out.println("Execution Irrumped");
				}
				read = br.readLine();
			};
			br.close();
			fr.close();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
