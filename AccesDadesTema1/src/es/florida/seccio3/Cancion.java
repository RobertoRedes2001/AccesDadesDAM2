package es.florida.seccio3;

public class Cancion {
	private String id, titol, artista, anyo, formato;

	public String getId() {
		return id;
	}

	public String getTitol() {
		return titol;
	}

	public String getArtista() {
		return artista;
	}

	public String getAnyo() {
		return anyo;
	}

	public String getFormato() {
		return formato;
	}

	public Cancion(String id, String titol, String artista, String anyo, String formato) {
		this.id = id;
		this.titol = titol;
		this.artista = artista;
		this.anyo = anyo;
		this.formato = formato;
	}
	
	
}
