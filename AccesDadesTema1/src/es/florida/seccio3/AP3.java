package es.florida.seccio3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class AP3 {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("seccion3.xml"));
			NodeList nodeList = document.getElementsByTagName("character");
			System.out.println("\nObjectes encontrats al fitxer: "+ nodeList.getLength() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
