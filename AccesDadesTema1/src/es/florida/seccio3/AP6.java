package es.florida.seccio3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document document = dBuilder.parse(new File("seccion3.xml"));
				Element raiz = document.getDocumentElement();
				System.out.println("Contingut XML " + raiz.getNodeName() + ":");
				NodeList nodeList = document.getElementsByTagName("character");
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					System.out.println("");
					Element eElement = (Element) node;
					System.out.println("ID del lluitador : " + eElement.getAttribute("id"));
					System.out.println("Nom del lluitador : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Titol del lluitador : " + eElement.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("Unitats de poder del lluitador : " + eElement.getElementsByTagName("poweruds").item(0).getTextContent());
					System.out.println("Element del lluitador : " + eElement.getElementsByTagName("element").item(0).getTextContent());
					Charcter personatge = new Charcter(eElement.getAttribute("id"),
							eElement.getElementsByTagName("name").item(0).getTextContent(), 
							eElement.getElementsByTagName("title").item(0).getTextContent(), 
							eElement.getElementsByTagName("poweruds").item(0).getTextContent(), 
							eElement.getElementsByTagName("element").item(0).getTextContent());
					
				}
				System.out.println("\nObjectes encontrats al fitxer: "+ nodeList.getLength() );
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
