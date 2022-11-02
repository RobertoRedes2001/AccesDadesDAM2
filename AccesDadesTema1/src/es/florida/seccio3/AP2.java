package es.florida.seccio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AP2 {

	public static void main(String[] args) {
		File nouXml = new File("seccion3.xml");
		try {
			FileReader fr = new FileReader(nouXml);
			BufferedReader br = new BufferedReader(fr);
			String read = br.readLine();
			while(read!=null) {
				System.out.println(read);
				read = br.readLine();
			};
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
