package es.florida.seccio3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AP8 {

	public static void writeXmlFile(List<Charcter> lista) {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("characters");
			doc.appendChild(raiz);
			for (Charcter player : lista) {
				Element personaje = doc.createElement("character");
				String id = String.valueOf(player.getId());
				personaje.setAttribute("id", id);
				raiz.appendChild(personaje);
				Element titulo = doc.createElement("name");
				titulo.appendChild(doc.createTextNode(String.valueOf(player.getName())));
				personaje.appendChild(titulo);
				Element artista = doc.createElement("title");
				artista.appendChild(doc.createTextNode(String.valueOf(player.getTitle())));
				personaje.appendChild(artista);
				Element anyo = doc.createElement("poweruds");
				anyo.appendChild(doc.createTextNode(String.valueOf(player.getPoweruds())));
				personaje.appendChild(anyo);
				Element formato = doc.createElement("element");
				formato.appendChild(doc.createTextNode(String.valueOf(player.getElement())));
				personaje.appendChild(formato);
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serialitzador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Formato al document
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("AP8.xml"); // Definir el nom del fitxer i guardar
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (TransformerException ex) {
			System.out.println("Error escrivint el documento");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error construint el document");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Charcter> jugaors = new ArrayList<Charcter>();
		for(int i=0; i<=2;i++) {
			Charcter j1 = new Charcter();
			jugaors.add(j1);
		}
		
		writeXmlFile(jugaors);
	}

}
