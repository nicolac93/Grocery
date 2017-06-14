package Login_Registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField nameField;
	private JTextField cognomeField;
	private JTextField indirizzoField;
	private JTextField cittaField;
	private JTextField passwordField;
	private JTextField emailField;
	private JTextField telefonoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGroceryRegistration = new JLabel("Grocery Registration");
		lblGroceryRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroceryRegistration.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblGroceryRegistration.setBounds(6, 6, 438, 25);
		frame.getContentPane().add(lblGroceryRegistration);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(6, 74, 61, 16);
		frame.getContentPane().add(lblNome);
		
		nameField = new JTextField();
		nameField.setBounds(261, 69, 130, 26);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(6, 125, 61, 16);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(6, 183, 61, 16);
		frame.getContentPane().add(lblIndirizzo);
		
		JLabel lblCitta = new JLabel("Citta");
		lblCitta.setBounds(6, 241, 61, 16);
		frame.getContentPane().add(lblCitta);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(261, 120, 130, 26);
		frame.getContentPane().add(cognomeField);
		cognomeField.setColumns(10);
		
		indirizzoField = new JTextField();
		indirizzoField.setBounds(261, 178, 130, 26);
		frame.getContentPane().add(indirizzoField);
		indirizzoField.setColumns(10);
		
		cittaField = new JTextField();
		cittaField.setBounds(261, 236, 130, 26);
		frame.getContentPane().add(cittaField);
		cittaField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 303, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(6, 366, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(6, 431, 61, 16);
		frame.getContentPane().add(lblTelefono);
		
		passwordField = new JTextField();
		passwordField.setBounds(261, 298, 130, 26);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(261, 361, 130, 26);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(261, 426, 130, 26);
		frame.getContentPane().add(telefonoField);
		telefonoField.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(53, 472, 117, 29);
		frame.getContentPane().add(btnAnnulla);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					DBConnect db = new DBConnect();
					
					
					db.insertUser(nameField.getText(), cognomeField.getText(), indirizzoField.getText(), cittaField.getText(),
							passwordField.getText() , emailField.getText(), telefonoField.getText());
						JOptionPane.showConfirmDialog(frame, "Registrato");

					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRegistrati.setBounds(236, 472, 117, 29);
		frame.getContentPane().add(btnRegistrati);
	}
}
