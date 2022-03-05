package mysql;

import java.awt.image.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLogin.setBounds(66, 59, 113, 39);
		contentPane.add(lblLogin);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUser.setBounds(66, 158, 126, 32);
		contentPane.add(lblUser);
		
		user = new JTextField();
		user.setBorder(new LineBorder(Color.BLACK));
		user.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		user.setBounds(66, 203, 186, 39);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(66, 265, 113, 32);
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBorder(new LineBorder(Color.BLACK));
		pass.setBounds(66, 306, 186, 39);
		contentPane.add(pass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/test","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from tblogin where UserName='"+user.getText()+"' and Password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Login Successfull...");
					Dashboard dash=new Dashboard();
					dash.setVisible(true); }
					else{
						JOptionPane.showMessageDialog(null, "Incorrect username and password ...");}
					con.close();
				}catch(Exception e1) {System.out.print(e1);}
			}
		});
		btnLogin.setBounds(66, 379, 113, 39);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(264, 65, 405, 394);
		contentPane.add(lblNewLabel);
		
	
	}

}
