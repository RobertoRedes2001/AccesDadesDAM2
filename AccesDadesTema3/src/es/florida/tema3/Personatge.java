package es.florida.tema3;

public class Personatge {
private String name, title, element;
	
	private int id, poweruds;
	
	public Personatge(String name, String title, String element, int id, int poweruds) {
		this.name = name;
		this.title = title;
		this.element = element;
		this.id = id;
		this.poweruds = poweruds;
	}
	
	public Personatge(String name, String title, String element, int poweruds) {
		this.name = name;
		this.title = title;
		this.element = element;
		this.poweruds = poweruds;
	}

	public Personatge() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoweruds() {
		return poweruds;
	}

	public void setPoweruds(int poweruds) {
		this.poweruds = poweruds;
	}
	
	
	
}
