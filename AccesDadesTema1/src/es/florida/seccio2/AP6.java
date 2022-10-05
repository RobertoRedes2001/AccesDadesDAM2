package es.florida.seccio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader(args[0]);
            FileWriter fw = new FileWriter("ej3_copia.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw); 
            String linea = br.readLine();
            while (linea != null) {
                    bw.write(linea);
                    bw.newLine();
                    linea = br.readLine();
            }
            bw.close();
            br.close();
            br.close();
            fr.close();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
