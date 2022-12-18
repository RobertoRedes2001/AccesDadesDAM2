package es.florida.tema4;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

public class Practica {
	
	static public void llegirDB() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("llibres");
		Bson query = eq("Id", "13");
		MongoCursor<Document> cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
		System.out.println(cursor.next().toJson());
		}
		mongoClient.close();
	}
	
	static public void crearRegistre() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("llibres");
		Document doc = new Document();
		doc.append("Id", 15);
		doc.append("Titol", "El Gran Mono");
		doc.append("Autor", "La Roca");
		doc.append("Any_naixement", 2000);
		doc.append("Any_publicacio", 2022);
		doc.append("Any_naixement", 2000);
		doc.append("Editorial", "La editorial del perreo");
		doc.append("Nombre_pagines", 59);
		coleccion.insertOne(doc);
		mongoClient.close();
		System.out.println("Registre afegit");
	}
	
	static public void actualitzarRegistre() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("llibres");
		coleccion.updateMany(eq("Autor", "La Roca"), new Document("$set",
				new Document("Autor", "Sergio Palomares")));
		mongoClient.close();
		System.out.println("Registre Actualitzat");
	}
	
	static public void esborrarRegistre() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("llibres");
		coleccion.deleteOne(eq("Autor", "Sergio Palomares")); //borra uno
		//coleccion.deleteMany(eq("Autor", "Sergio Palomares"));  //borra varios
		//coleccion.drop(); //borra todos
		mongoClient.close();
		System.out.println("Registre Esborrat");
	}
	
	public static void main(String[] args) {

		llegirDB();

	}

}
