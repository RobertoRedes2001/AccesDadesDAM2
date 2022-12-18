package es.florida.aev2;

public class Principal {

	public static void main(String[] args) {
		
		//Creguem un objecte Model i un altre Vista que usarem per a crear l'objecte Controlador.
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador cont = new Controlador(modelo, vista);
		
	}

}
