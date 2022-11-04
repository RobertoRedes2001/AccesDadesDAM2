package es.florida.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AP6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introuix una ID: ");
		int idNum = sc.nextInt();
		Personatge nou = new Personatge();
		System.out.println(nou.getName());
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
	}

}
