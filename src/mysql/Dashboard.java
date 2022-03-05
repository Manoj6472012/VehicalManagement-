package mysql;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 613);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVehicalManagementSystem = new JLabel("Vehical Management System");
		lblVehicalManagementSystem.setForeground(SystemColor.text);
		lblVehicalManagementSystem.setBackground(Color.LIGHT_GRAY);
		lblVehicalManagementSystem.setFont(new Font("Trajan Pro 3", Font.BOLD, 25));
		lblVehicalManagementSystem.setBounds(12, 27, 445, 51);
		contentPane.add(lblVehicalManagementSystem);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 customer1 cus = new customer1();
				 setVisible(false);
				 cus.frame.setVisible(true);
			}
		});
		btnCustomer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCustomer.setBounds(37, 153, 180, 57);
		contentPane.add(btnCustomer);
		
		JButton btnNewButton = new JButton("Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Employee emp = new Employee();
				 setVisible(false);
				 emp.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(37, 240, 180, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Accessories ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Accessories acc = new Accessories();
				 acc.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(37, 321, 180, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Billing");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billing bill = new Billing();
				setVisible(false);
				 bill.frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(37, 398, 180, 51);
		contentPane.add(btnNewButton_2);
		Image img = new ImageIcon(this.getClass().getResource("/car.jpg")).getImage();
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg=new Login();				
				lg.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(37, 479, 180, 51);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manoj\\Pictures\\vehical project\\car.jpg"));
		lblNewLabel.setBounds(0, 0, 749, 566);
		contentPane.add(lblNewLabel);
	}
}
