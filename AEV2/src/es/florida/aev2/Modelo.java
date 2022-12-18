package es.florida.aev2;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Modelo {
	
	private Connection con; //establim un atribut de connexió per a poder connectar a la base de dades.
	
	public Connection getCon() {
		return con;
	}

	public Modelo() {  /**Usant els fiquedos de DocumentBuilder per a llegir el xml, li passem a (con) 
						els atributs en l'arxiu usant el mètode getConnection i 
						establim la connexió amb la base de dades*/
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("conexion.xml"));
			NodeList nodeList = document.getElementsByTagName("conexion");
			Node node = nodeList.item(0);
			Element eElement = (Element) node;
			con = DriverManager.getConnection(eElement.getElementsByTagName("url").item(0).getTextContent(),eElement.getElementsByTagName("user").item(0).getTextContent(),eElement.getElementsByTagName("pass").item(0).getTextContent());
		} catch (DOMException | SQLException | ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			con.close();  //una vegada acabades les operacions de la base de dades, tanquem la connexió de l'objecte (con)
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String codificarPass(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");		//Este codi presa la contrasenya
			byte[] messageDigest = md.digest(password.getBytes());      //i la convertix en MD5. Usa els
			BigInteger number = new BigInteger(1, messageDigest);       //Bits per a canviar els caràcters
			String hashtext = number.toString(16);                      //Fins a deixar-la codificada.

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/* @verAutors
	 * @verUsers
	 * @verEditorials
	 * @verTitles
	 * 
	 * Per a les 4 funcions es passa un Statement amb l'objecte connexió
	 * i després fem un ResultSet amb la consulta que passarem per excuteQuery,
	 * acabem guardant els resultats en dos strings per a poder passar-los després
	 * pel TextField. Després d'això, tanquem els ResultSet i Statement**/
	
	public String verAutors() {
		String line="";
		String resultats="";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM authors");
			
			while (rs.next()) {
				line=+rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + "\n";
				resultats=resultats+line;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;	
	}
	
	public String verEditorials() {

		String line="";
		String resultats="";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM editorials");
			
			while (rs.next()) {
				line=+rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) +  "\n";
				resultats=resultats+line;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;	
	}
	
	public String verTitles() {
		String line="";
		String resultats="";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM titles");
			
			while (rs.next()) {
				line=+rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " "
						+ rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getInt(6) + "\n";
				resultats=resultats+line;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;	
	}

	public String verUsers() {

		String line="";
		String resultats="";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			while (rs.next()) {
				line=+rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) +  "\n";
				resultats=resultats+line;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;	
	}
	
	/* @insertarDades
	 * @actualitzarDades
	 * @esborrarDades
	 * 
	 * Per a les 3 funcions, es prepara un objecte Statement usant l'atribut de connexió (con)
	 * de la classe Model, després d'això preparem un objecte PreparedStatement el qual del qual el
	 * valor guardarem en un objecte Integer, que després tornarem en cas de ser reeixit.**/
	
	public int insertarDades(String consulta) {
		try {
			Statement stmt = con.createStatement();
			PreparedStatement psInsertar = con.prepareStatement(consulta);
			int resultadoInsertar = psInsertar.executeUpdate();
			stmt.close();
			return resultadoInsertar;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int actualitzarDades(String consulta) {
		try {
			Statement stmt = con.createStatement();
			PreparedStatement psActualizar = con.prepareStatement(consulta);
			int resultadoActualizar = psActualizar.executeUpdate();
			stmt.close();
			return resultadoActualizar;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int esborrarDades(String consulta) {
		try {
			Statement stmt = con.createStatement();
			PreparedStatement psBorrar = con.prepareStatement(consulta);
			int resultadoBorrar = psBorrar.executeUpdate();
			stmt.close();
			return resultadoBorrar;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/* @selectInfo
	 * @selectEstructura
	 * @llenarLlista
	 * @llenarEstructura
	 * 
	 * Ambdós parells de funcions fan en essència el mateix, la diferència és que una presa el nom
	 * de les columnes i l'altre el dels seus labels ja que en la base de dades, les columnes no tenen un nom.
	 * Creguem un objecte ResultSet i una llista a què li passarem totes els (rs) que trobe com a coincidència.
	 * Dins de la funció d'ompliment de llista (@llenarLlista/@llenarEstructura) , creguem una llista usant el (rs)
	 * per a poder carregar-ho de les línies que trobe d'informació en la base de dades. Açò ho passarem després per
	 * un (for) per a poder omplir els Strings que passarem en el TextField. **/
	
	public String selectInfo(String consulta) {
		ResultSet rs = null;
		List lista = new ArrayList();
		String linea="";
		String resultats="";
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(consulta);
			lista = llenarLlista(rs);
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i = 0;i<lista.size();i++) {
			linea=lista.get(i).toString()+"\n";
			resultats=resultats+linea;
		}
		return resultats;
	}
	
	public String selectEstructura(String consulta) {
		ResultSet rs = null;
		List lista = new ArrayList();
		String linea="";
		String resultats="";
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(consulta);
			lista = llenarEstructura(rs);
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i = 0;i<lista.size();i++) {
			linea=lista.get(i).toString()+"\n";
			resultats=resultats+linea;
		}
		return resultats;
	}

	private List llenarLlista(ResultSet rs) {
		
		List renglones = new ArrayList();
		try {
			int cantCol=rs.getMetaData().getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> renglon = new HashMap();
				for(int i=1;i<=cantCol;i++) {
					String nombreCampo=rs.getMetaData().getColumnName(i);
					System.out.println(nombreCampo);
					Object valor = rs.getObject(nombreCampo);
					renglon.put(nombreCampo, valor);
				}
				renglones.add(renglon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return renglones;
		
	}
	
	private List llenarEstructura(ResultSet rs) {
		
		List renglones = new ArrayList();
		try {
			int cantCol=rs.getMetaData().getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> renglon = new HashMap();
				for(int i=1;i<=cantCol;i++) {
					String nombreCampo=rs.getMetaData().getColumnLabel(i);
					System.out.println(nombreCampo);
					Object valor = rs.getObject(nombreCampo);
					renglon.put(nombreCampo, valor);
				}
				renglones.add(renglon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return renglones;
		
	}
}
