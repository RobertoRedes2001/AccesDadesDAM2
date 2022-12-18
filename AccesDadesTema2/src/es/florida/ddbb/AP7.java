package es.florida.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AP7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introuix una ID: ");
		int idNum = sc.nextInt();
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
	}

}
