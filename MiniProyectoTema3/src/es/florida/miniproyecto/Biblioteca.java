package es.florida.miniproyecto;

public class Biblioteca {
	private int id, any, pagines;
	private String titol, autor, editorial;
	
	public Biblioteca(int any, int pagines, String titol, String autor, String editorial) {
		this.any = any;
		this.pagines = pagines;
		this.titol = titol;
		this.autor = autor;
		this.editorial = editorial;
	}
	
	public Biblioteca(int id, int any, int pagines, String titol, String autor, String editorial) {
		this.id = id;
		this.any = any;
		this.pagines = pagines;
		this.titol = titol;
		this.autor = autor;
		this.editorial = editorial;
	}
	
	public Biblioteca() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAny() {
		return any;
	}
	public void setAny(int any) {
		this.any = any;
	}
	public int getPagines() {
		return pagines;
	}
	public void setPagines(int pagines) {
		this.pagines = pagines;
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
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
}
