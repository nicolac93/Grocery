package Login_Registration;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DBConnect db = new DBConnect();
					
					if(db.checkUser(username.getText(), password.getText())){
						JOptionPane.showConfirmDialog(frame, "yeah");
					}
					else{
						JOptionPane.showConfirmDialog(frame, "Error");
					}
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
			}
		});
		btnLogin.setBounds(169, 200, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		username = new JTextField();
		username.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		username.setBounds(253, 59, 130, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(253, 131, 130, 26);
		frame.getContentPane().add(password);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblUsername.setBounds(56, 64, 70, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblPassword.setBounds(56, 136, 70, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblGrocery = new JLabel("Grocery");
		lblGrocery.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
		lblGrocery.setBounds(169, 6, 130, 29);
		frame.getContentPane().add(lblGrocery);
		
		JLabel messageLogin = new JLabel("");
		messageLogin.setBounds(205, 241, 61, 16);
		frame.getContentPane().add(messageLogin);
	}
}
