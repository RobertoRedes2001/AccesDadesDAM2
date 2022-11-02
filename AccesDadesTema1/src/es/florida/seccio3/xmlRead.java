package es.florida.seccio3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class xmlRead {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("canciones2.xml"));
			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("cancion");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				Element eElement = (Element) node;
				System.out.println("ID can�o : " + eElement.getAttribute("id"));
				System.out.println("Titol : " + eElement.getElementsByTagName("titol").item(0).getTextContent());
				System.out.println("Artista : " + eElement.getElementsByTagName("artista").item(0).getTextContent());
				System.out.println("Any : " + eElement.getElementsByTagName("any").item(0).getTextContent());
				System.out.println("Format : " + eElement.getElementsByTagName("format").item(0).getTextContent());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
