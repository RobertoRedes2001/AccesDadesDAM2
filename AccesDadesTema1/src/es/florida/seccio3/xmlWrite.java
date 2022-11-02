package es.florida.seccio3;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

public class xmlWrite {

	public static void writeXmlFile(List<Cancion> lista) {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("canciones");
			doc.appendChild(raiz);
			for (Cancion can : lista) {
				Element cancion = doc.createElement("cancion");
				String id = String.valueOf(can.getId());
				cancion.setAttribute("id", id);
				raiz.appendChild(cancion);
				Element titulo = doc.createElement("titol");
				titulo.appendChild(doc.createTextNode(String.valueOf(can.getTitol())));
				cancion.appendChild(titulo);
				Element artista = doc.createElement("artista");
				artista.appendChild(doc.createTextNode(String.valueOf(can.getArtista())));
				cancion.appendChild(artista);
				Element anyo = doc.createElement("any");
				anyo.appendChild(doc.createTextNode(String.valueOf(can.getAnyo())));
				cancion.appendChild(anyo);
				Element formato = doc.createElement("format");
				formato.appendChild(doc.createTextNode(String.valueOf(can.getFormato())));
				cancion.appendChild(formato);
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serialitzador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Formato al document
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("canciones2.xml"); // Definir el nom del fitxer i guardar
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
		Cancion cancion1 = new Cancion("1","1", "The Who", "1965", "Vinyl");
        Cancion cancion2 = new Cancion("2","2", "The What", "1987", "Viny2");
        Cancion cancion3 = new Cancion("3","3", "The Where", "1986", "Viny3");
        Cancion cancion4 = new Cancion("4","4", "The When", "2009", "Viny4");
        Cancion cancion5 = new Cancion("5","5", "The Why", "1999", "Viny5");
        List<Cancion> canciones = new ArrayList<Cancion>();
        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);
        canciones.add(cancion4);
        canciones.add(cancion5);
        writeXmlFile(canciones);
        
	}

}
