package es.florida.seccio3;

public class Libro {
	private String id, titol, autor, any, editorial, paginas;
	
	public Libro(String id, String titol, String autor, String any, String editorial, String paginas) {
		this.id = id;
		this.titol = titol;
		this.autor = autor;
		this.any = any;
		this.editorial = editorial;
		this.paginas = paginas;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAny() {
		return any;
	}

	public void setAny(String any) {
		this.any = any;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
}
