package es.florida.seccio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AP8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("deuchos2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			File dc = new File("deuchos.txt");
			FileReader fr = new FileReader("deuchos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null){
				bw.write(linea);
				bw.newLine();
				linea = br.readLine();
			}
			bw.write("1999, vaya verano.");
			br.close();
			fr.close();
			dc.delete();
			bw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
