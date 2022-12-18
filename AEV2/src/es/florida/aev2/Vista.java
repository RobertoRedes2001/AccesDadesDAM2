package es.florida.aev2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class Vista extends JFrame {
	
	/*Cridem als components que usarem en Vista
	 * de forma global, de manera que no se sobreposen
	 * independentment del seu posició en el codi.**/
	private JPanel contentPane;
	
	private JLabel lblUser;
	private JLabel lblPass;
	private JLabel lblConexion;
	
	private JScrollPane scrollPane;
	private JTextArea txtInfoBBDD;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JTextField txtConsulta;
	
	private JComboBox cmbTablas;
	private JComboBox cmbOption;
	
	private JButton btnContenido;
	private JButton btnConsulta;
	private JButton btnTancarCon;
	private JButton btnConectar;
	private JButton btnEstructura;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista frame = new Vista();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUser = new JLabel("Usuari:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(61, 32, 122, 40);
		contentPane.add(lblUser);
		
		lblPass = new JLabel("Contrasenya: ");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(296, 32, 122, 40);
		contentPane.add(lblPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(389, 40, 173, 25);
		contentPane.add(txtPassword);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setColumns(10);
		txtUser.setBounds(113, 40, 173, 25);
		contentPane.add(txtUser);
		
		lblConexion = new JLabel("Conexi\u00F3 Inactiva");
		lblConexion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblConexion.setBounds(750, 94, 264, 40);
		contentPane.add(lblConexion);
		
		btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConectar.setBounds(591, 35, 113, 34);
		contentPane.add(btnConectar);
		
		btnTancarCon = new JButton("Tancar Conexio");
		btnTancarCon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTancarCon.setBounds(725, 35, 173, 34);
		contentPane.add(btnTancarCon);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 94, 663, 353);
		contentPane.add(scrollPane);
		
		txtInfoBBDD = new JTextArea();
		txtInfoBBDD.setEnabled(false);
		scrollPane.setViewportView(txtInfoBBDD);
		txtInfoBBDD.setWrapStyleWord(true);
		txtInfoBBDD.setLineWrap(true);
		txtInfoBBDD.setEditable(false);
		txtInfoBBDD.setBackground(Color.BLACK);
		
		cmbTablas = new JComboBox();
		cmbTablas.setEnabled(false);
		cmbTablas.setModel(new DefaultComboBoxModel(new String[] {"Database", "Autors", "Editorials", "Titols", "Usuaris"}));
		cmbTablas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbTablas.setBounds(750, 198, 113, 34);
		contentPane.add(cmbTablas);
		
		btnContenido = new JButton("Ver Continguts");
		btnContenido.setEnabled(false);
		btnContenido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContenido.setBounds(890, 242, 148, 34);
		contentPane.add(btnContenido);
		
		btnEstructura = new JButton("Ver Estructura");
		btnEstructura.setEnabled(false);
		btnEstructura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEstructura.setBounds(750, 242, 131, 34);
		contentPane.add(btnEstructura);
		
		cmbOption = new JComboBox();
		cmbOption.setEnabled(false);
		cmbOption.setModel(new DefaultComboBoxModel(new String[] {"-", "SELECT", "INSERT", "UPDATE", "DELETE"}));
		cmbOption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbOption.setBounds(61, 509, 131, 34);
		contentPane.add(cmbOption);
		
		txtConsulta = new JTextField();
		txtConsulta.setEnabled(false);
		txtConsulta.setBackground(new Color(255, 255, 255));
		txtConsulta.setBounds(61, 459, 663, 40);
		contentPane.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		btnConsulta = new JButton("Fer consulta");
		btnConsulta.setEnabled(false);
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsulta.setBounds(750, 459, 148, 40);
		contentPane.add(btnConsulta);
		
		this.setVisible(true); //Fem visible l'objecte vista, perquè al processar-se, podem veure-ho des del main
		
	}
	
	
	//Generem diversos getters per a poder interactuar amb els bottons/textfields al Controlador
	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getLblConexion() {
		return lblConexion;
	}

	public JTextArea getTxtInfoBBDD() {
		return txtInfoBBDD;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public JTextField getTxtConsulta() {
		return txtConsulta;
	}

	public JComboBox getCmbOption() {
		return cmbOption;
	}

	public JButton getBtnContenido() {
		return btnContenido;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public JButton getBtnTancarCon() {
		return btnTancarCon;
	}

	public JButton getBtnConectar() {
		return btnConectar;
	}

	public JButton getBtnEstructura() {
		return btnEstructura;
	}

	public JComboBox getCmbTablas() {
		return cmbTablas;
	}
	
	
}
