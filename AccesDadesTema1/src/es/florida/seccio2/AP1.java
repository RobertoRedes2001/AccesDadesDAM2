package es.florida.seccio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader(args[0]);
			int read = fr.read();
			while(read!=-1) {
				System.out.print((char)read);
				try {
					Thread.sleep(500);
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
