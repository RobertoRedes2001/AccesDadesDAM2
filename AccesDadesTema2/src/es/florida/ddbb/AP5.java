package es.florida.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AP5 {

	public static void main(String[] args) {
	
		Personatge nou = new Personatge();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fightingrooster", "root", "");
			Statement stmt = con.createStatement();
			PreparedStatement psInsertar = con.prepareStatement("INSERT INTO `fighter` (ID,CharName,Title,PowerUds,Element) VALUES (?,?,?,?,?)");
			psInsertar.setInt(1,nou.getId());
			psInsertar.setString(2,nou.getName());
			psInsertar.setString(3,nou.getTitle());
			psInsertar.setInt(4,nou.getPoweruds());
			psInsertar.setString(5,nou.getElement());
			int resultadoInsertar = psInsertar.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
