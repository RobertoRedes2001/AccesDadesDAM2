package es.florida.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AP8 {

	public static void deleteInfo() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introuix una ID: ");
		int idNum = Integer.parseInt(sc.nextLine());
		System.out.println("Vols borrar aquest lluitaor? [Y/N]");
		String resposta = sc.nextLine();
		if(resposta.equals("y")||resposta.equals("Y")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fightingrooster", "root", "");
				Statement stmt = con.createStatement();
				PreparedStatement psBorrar = con.prepareStatement("DELETE FROM fighter WHERE id ='"+idNum+"'");
				int resultadoBorrar = psBorrar.executeUpdate();
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Esborrar Completat.");
		}else {
			System.out.println("Esborrar Cancelat.");
		}
		
	}
	
	public static void updateInfo() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introuix una ID: ");
		int idNum = Integer.parseInt(sc.nextLine());
		System.out.println("Vols actualitzar aquest lluitaor? [Y/N]");
		String resposta = sc.nextLine();
		if(resposta.equals("y")||resposta.equals("Y")) {
			Personatge nou = new Personatge();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fightingrooster", "root", "");
				Statement stmt = con.createStatement();
				PreparedStatement psActualizar = con.prepareStatement("UPDATE fighter SET CharName= '"+nou.getName()+"', Title= '"+nou.getTitle()+"', PowerUds = '"+nou.getPoweruds()+"' , Element='"+nou.getElement()+"' WHERE ID = '"+idNum+"'");
				int resultadoActualizar = psActualizar.executeUpdate();
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Actualitzacio Completada.");
		}else {
			System.out.println("Actualitzacio Cancelada.");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("   MENU   ");
		System.out.println("==========");
		System.out.println("1.Actualizar");
		System.out.println("  2.Borrar  ");
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Introuix una opcio: ");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				updateInfo();
				break;
			case 2:
				deleteInfo();
				break;
		}
	}

}
