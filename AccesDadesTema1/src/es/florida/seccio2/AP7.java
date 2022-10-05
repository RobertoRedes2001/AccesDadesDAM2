package es.florida.seccio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AP7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner (System.in);
			FileWriter fw = new FileWriter("deuchos3.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String nuevaLinea;
			do{
				nuevaLinea = sc.nextLine();
				bw.write(nuevaLinea);
				bw.newLine();
			}while(!nuevaLinea.equals("exit"));
			bw.write("Fin.");
			bw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
