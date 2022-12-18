package es.florida.tema4;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.commons.codec.binary.Base64;
import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pruebas {

	public static void main(String[] args) {
		/*
		 * File fitxer = new File("imatge.jpg"); try { byte[] fileContent =
		 * Files.readAllBytes(fitxer.toPath()); String encodedString =
		 * Base64.encodeBase64String(fileContent); System.out.println(encodedString); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		File archivo = new File("conexionDDBB.json");
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String conexion = br.readLine();
			br.close();
			fr.close();
			JSONObject obj = new JSONObject(conexion);
			MongoClient mongoClient = new MongoClient(obj.getString("Cliente"), obj.getInt("Puerto"));
			MongoDatabase database = mongoClient.getDatabase(obj.getString("Database"));
			MongoCollection<Document> coleccionBooks = database.getCollection(obj.getString("Coleccion1"));
			MongoCollection<Document> coleccionUsers = database.getCollection(obj.getString("Coleccion2"));
			
			MongoCursor<Document> cursor = coleccionUsers.find().iterator();
			JSONObject usu;
			while (cursor.hasNext()) {
				usu = new JSONObject(cursor);
				System.out.println(cursor.next().toJson());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
