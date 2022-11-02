package es.florida.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class AP2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fightingrooster", "root", "");
			Statement stmt = con.createStatement();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
