package es.florida.seccio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Biblioteca {
	private static List<Libro> libros;

	public static List<Libro> getLibros() {
		return libros;
	}

	public Biblioteca(List<Libro> libros) {
		this.libros = libros;
	}
	
	public static void crearLlibre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID: ");
		String id=sc.nextLine();
		System.out.print("Titol: ");
		String titulo=sc.nextLine();
		System.out.print("Autor: ");
		String autor=sc.nextLine();
		System.out.print("Any de publicacio: ");
		String any=sc.nextLine();
		System.out.print("Editorial del llibre: ");
		String editorial=sc.nextLine();
		System.out.print("Nombre de pagines: ");
		String pag=sc.nextLine();
		
		Libro book = new Libro(id,titulo,autor,any,editorial,pag);
		libros.add(book);
	}
	
	public static void mostrarLlibre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduix la ID del llibre que vols buscar: ");
		String id=sc.nextLine();
		int pos=-1;
		for(Integer i=0;i<libros.size();i++) {
			if(libros.get(i).getId().equals(id)) {
				pos=i;
			}
		}
		if(pos!=-1) {
			System.out.println("ID: "+libros.get(pos).getId());
			System.out.println("Titol: "+libros.get(pos).getTitol());
			System.out.println("Autor: "+libros.get(pos).getAutor());
			System.out.println("Any de publicacio: "+libros.get(pos).getAny());
			System.out.println("Editorial del llibre: "+libros.get(pos).getEditorial());
			System.out.println("Nombre de pagines: "+libros.get(pos).getPaginas());	
		}else {
			System.out.println("No se ha encontrado la informacion pedida.");
		}
		
		
		
	}
	
	public static void borrarLlibre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduix la ID del llibre que vols borrar: ");
		String id=sc.nextLine();
		int pos=-1;
		for(Integer i=0;i<libros.size();i++) {
			if(libros.get(i).getId().equals(id)) {
				pos=i;
			}
		}
		if(pos!=-1) {
			System.out.println("Vols borrar aquest llibre? [Y/N]");
			String resposta = sc.nextLine();
			if(resposta.equals("y")||resposta.equals("Y")) {
				libros.remove(pos);
				System.out.println("Esborrar Completat.");
			}else {
				System.out.println("Esborrar Cancelat.");
			}	
		}else {
			System.out.println("No se ha encontrado la informacion pedida.");
		}
	}
	
	public static void actualitzaLlibre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduix la ID del llibre que vols actualitzar: ");
		String id=sc.nextLine();
		int pos=-1;
		for(Integer i=0;i<libros.size();i++) {
			if(libros.get(i).getId().equals(id)) {
				pos=i;
			}
		}
		if(pos!=-1) {
			System.out.print("Titol: ");
			String titulo=sc.nextLine();
			libros.get(pos).setTitol(titulo);
			System.out.print("Autor: ");
			String autor=sc.nextLine();
			libros.get(pos).setAutor(autor);
			System.out.print("Any de publicacio: ");
			String any=sc.nextLine();
			libros.get(pos).setAny(any);
			System.out.print("Editorial del llibre: ");
			String editorial=sc.nextLine();
			libros.get(pos).setEditorial(editorial);
			System.out.print("Nombre de pagines: ");
			String pag=sc.nextLine();
			libros.get(pos).setPaginas(pag);
			
		}else {
			System.out.println("No se ha encontrado la informacion pedida.");
		}
	}
	
	public static void llistarTitols() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Biblioteca.xml"));
			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("libro");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				Element eElement = (Element) node;
				System.out.println("Titol : " + eElement.getElementsByTagName("titulo").item(0).getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void tornarLlista() {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("biblioteca");
			doc.appendChild(raiz);
			for (Libro book : libros) {
				Element libro = doc.createElement("libro");
				String id = String.valueOf(book.getId());
				libro.setAttribute("id", id);
				raiz.appendChild(libro);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(String.valueOf(book.getTitol())));
				libro.appendChild(titulo);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(book.getAutor())));
				libro.appendChild(autor);
				Element any = doc.createElement("any");
				any.appendChild(doc.createTextNode(String.valueOf(book.getAny())));
				libro.appendChild(any);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(book.getEditorial())));
				libro.appendChild(editorial);
				Element pags = doc.createElement("pagines");
				pags.appendChild(doc.createTextNode(String.valueOf(book.getPaginas())));
				libro.appendChild(pags);
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serialitzador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Formato al document
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("Biblioteca.xml"); // Definir el nom del fitxer i guardar
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
	
	
}
