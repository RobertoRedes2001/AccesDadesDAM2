package es.florida.aev2;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Controlador {
	
	/**
	 * Creguem una classe Controlador amb què manipularem Vista
	 * i usarem les funcions que creguem en Modelo perquè interactue
	 * amb la base de dades.
	 * 
	 * Establim un atribut Vista i un altre Model, després generem tants
	 * actionListener com necessitem per a programar la interfície.
	 * */

	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListener_Contenido, actionListener_Consulta, actionListener_TancarCon, 
	actionListener_Conectar, actionListener_Estructura,actionListener_Option, actionListener_Tablas;
	
	Controlador(Modelo m, Vista v){
		this.modelo=m;
		this.vista=v;
		control(); //Dins del constructor cridem a la funció que conté tots els actionListeners
	}
	
	public void control() {
		actionListener_Conectar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Cridem a la funció de codificació i li passem la contrasenya
				 * per un TextField, després la codifiquem usant la funció.*/
				String passHash = modelo.codificarPass(vista.getTxtPassword().getText());
				boolean coincidencia=false;
				try {
					Statement stmt = modelo.getCon().createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM users");
					while (rs.next()) {
						if(vista.getTxtUser().getText().equals(rs.getString(2))&&passHash.equals(rs.getString(3))) {
							coincidencia=true;
						}
					}
					
					if(coincidencia) { //Si la coincidència de contrasenyes és True, establim connexió amb la base de dades i habilitem els controls.
						showMessageDialog(null, "Conexio feta.");
						vista.getLblConexion().setText("Conexion Estableida");
						vista.getBtnConsulta().setEnabled(true);
						vista.getBtnEstructura().setEnabled(true);
						vista.getBtnConsulta().setEnabled(true);
						vista.getCmbOption().setEnabled(true);
						vista.getCmbTablas().setEnabled(true);
						vista.getTxtUser().setText("");
						vista.getTxtPassword().setText("");
						vista.getBtnTancarCon().setEnabled(true);
						stmt.close();
						rs.close();
					}else {
						showMessageDialog(null, "Les dades no coinciden"); //En el cas que no, mostrem un Pop up avisant que les credencials són incorrectes.
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		};
		vista.getBtnConectar().addActionListener(actionListener_Conectar);
	
		actionListener_TancarCon = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Desea tancar la conexió?", "Tancar Conexio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(JOptionPane.YES_OPTION==0) {  //Despleguem una finestra de Dialog que ens preguntara si volem tancar la connexió
					modelo.cerrarConexion();     //De ser afirmativa la resposta, tancarem connexió amb la funció en Modelo i deshabilitem els controls.
					vista.getLblConexion().setText("Conexió Inactiva");
					vista.getBtnConsulta().setEnabled(false);
					vista.getBtnContenido().setEnabled(false);
					vista.getBtnEstructura().setEnabled(false);
					vista.getBtnConsulta().setEnabled(false);
					vista.getCmbOption().setEnabled(false);
					vista.getCmbTablas().setEnabled(false);
					vista.getTxtUser().setText("");
					vista.getTxtPassword().setText("");
					vista.getTxtInfoBBDD().setText("");
					vista.getTxtInfoBBDD().setText("");
					vista.getBtnTancarCon().setEnabled(false);
				}
				
				}
		};
		vista.getBtnTancarCon().addActionListener(actionListener_TancarCon);
	
		actionListener_Contenido = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pick = vista.getCmbTablas().getSelectedIndex()+1;  //Basant-se en l'opció seleccionada en el ComboBox, cridem a una de les funcions de veure taula en Modelo.
				switch(pick) {
					case 1:
						vista.getTxtInfoBBDD().setText(modelo.verAutors());
						break;
					case 2:
						vista.getTxtInfoBBDD().setText(modelo.verEditorials());
						break;
					case 3:
						vista.getTxtInfoBBDD().setText(modelo.verTitles());
						break;
					case 4:
						vista.getTxtInfoBBDD().setText(modelo.verUsers());
						break;
				}
			}
		};
		vista.getBtnContenido().addActionListener(actionListener_Contenido);
	
		actionListener_Consulta = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int pick = vista.getCmbOption().getSelectedIndex();
				switch(pick) { //Basant-se en l'opció seleccionada en el ComboBox, cridem a una de les funcions de consulta en Modelo. 
					
					case 1:
							vista.getTxtInfoBBDD().setText(modelo.selectInfo(vista.getTxtConsulta().getText()));
						break;
					case 2:
						JOptionPane.showConfirmDialog(null, "Realment desea insertar aquest registre?", "Confirmar consulta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(JOptionPane.YES_OPTION==0) {
							modelo.insertarDades(vista.getTxtConsulta().getText());
						}
						break;
					case 3:
						JOptionPane.showConfirmDialog(null, "Realment desea actualitzar aquest registre?", "Confirmar consulta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(JOptionPane.YES_OPTION==0) {
							modelo.actualitzarDades(vista.getTxtConsulta().getText());
						}
						break;
					case 4:
						JOptionPane.showConfirmDialog(null, "Realment desea esborrar aquest registre?", "Confirmar consulta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(JOptionPane.YES_OPTION==0) {
							modelo.esborrarDades(vista.getTxtConsulta().getText());
						}
						break;
				}
			}
		};
		vista.getBtnConsulta().addActionListener(actionListener_Consulta);
		
		actionListener_Estructura = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pick = vista.getCmbTablas().getSelectedIndex(); //Basant-se en l'opció seleccionada en el ComboBox, cridem a la funció de revisar l'estructura
				switch(pick) { 										//de les taules o de la base de dades en Modelo.
					case 0:
						vista.getTxtInfoBBDD().setText(modelo.selectEstructura("SHOW TABLES"));
						break;
					case 1:
						vista.getTxtInfoBBDD().setText(modelo.selectEstructura("DESCRIBE authors"));
						break;
					case 2:
						vista.getTxtInfoBBDD().setText(modelo.selectEstructura("DESCRIBE editorials"));
						break;
					case 3:
						vista.getTxtInfoBBDD().setText(modelo.selectEstructura("DESCRIBE titles"));
						break;
					case 4:
						vista.getTxtInfoBBDD().setText(modelo.selectEstructura("DESCRIBE users"));
						break;
				}
			}
		};
		vista.getBtnEstructura().addActionListener(actionListener_Estructura);
		
		/**
		 * @actionListener_Option
		 * @actionListener_Tablas
		 * 
		 * Quan certa opció del ComboBox és seleccionada
		 * deshabilitem el TextField/Boton en qüestió.*/
		
		actionListener_Option = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vista.getCmbOption().getSelectedIndex()!=0) {
					vista.getTxtConsulta().setEnabled(true);
				}else {
					vista.getTxtConsulta().setEnabled(false);
				}
			}
		};
		vista.getCmbOption().addActionListener(actionListener_Option);
		
		actionListener_Tablas = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vista.getCmbTablas().getSelectedIndex()!=0) {
					vista.getBtnContenido().setEnabled(true);
				}else {
					vista.getBtnContenido().setEnabled(false);
				}
			}
		};
		vista.getCmbTablas().addActionListener(actionListener_Tablas);
	}
	
	

}




