package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Billing {

	JFrame frame;
	private JTextField txtfname;
	private JTextField txtpnum;
	private JTextField txtvehicle;
	private JTextField txtvehiclenum;
	private JTextField txtservice;
	private JTextField txtprice;
	private JTextArea txtReceipt;
	private JTextField txtcid;
	//private JLabel nlab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing window = new Billing();
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
	public Billing() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
 
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/test", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	
	        }
 
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 755, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBilling = new JLabel("Billing");
		lblBilling.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblBilling.setBounds(24, 36, 151, 47);
		frame.getContentPane().add(lblBilling);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblCustomerName.setBounds(35, 124, 154, 32);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblPhoneNumber.setBounds(35, 169, 140, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblVehicle.setBounds(35, 219, 140, 30);
		frame.getContentPane().add(lblVehicle);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblVehicleNumber.setBounds(35, 256, 154, 36);
		frame.getContentPane().add(lblVehicleNumber);
		
		txtfname = new JTextField();
		txtfname.setBorder(new LineBorder(Color.BLACK));
		txtfname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtfname.setBounds(207, 118, 152, 38);
		frame.getContentPane().add(txtfname);
		txtfname.setColumns(10);
		
		txtpnum = new JTextField();
		txtpnum.setBorder(new LineBorder(Color.BLACK));
		txtpnum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtpnum.setBounds(207, 168, 152, 36);
		frame.getContentPane().add(txtpnum);
		txtpnum.setColumns(10);
		
		txtvehicle = new JTextField();
		txtvehicle.setBorder(new LineBorder(Color.BLACK));
		txtvehicle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtvehicle.setBounds(207, 213, 152, 36);
		frame.getContentPane().add(txtvehicle);
		txtvehicle.setColumns(10);
		
		txtvehiclenum = new JTextField();
		txtvehiclenum.setBorder(new LineBorder(Color.BLACK));
		txtvehiclenum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtvehiclenum.setBounds(207, 256, 152, 36);
		frame.getContentPane().add(txtvehiclenum);
		txtvehiclenum.setColumns(10);
		
		txtservice = new JTextField();
		txtservice.setBorder(new LineBorder(Color.BLACK));
		txtservice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtservice.setBounds(207, 299, 152, 38);
		frame.getContentPane().add(txtservice);
		txtservice.setColumns(10);
		
		JLabel lblServiceType = new JLabel("Service Type");
		lblServiceType.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblServiceType.setBounds(35, 299, 140, 38);
		frame.getContentPane().add(lblServiceType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblPrice.setBounds(35, 354, 140, 26);
		frame.getContentPane().add(lblPrice);
		
		txtprice = new JTextField();
		txtprice.setBorder(new LineBorder(Color.BLACK));
		txtprice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtprice.setBounds(207, 348, 152, 32);
		frame.getContentPane().add(txtprice);
		txtprice.setColumns(10);
		
		txtReceipt = new JTextArea();
		txtReceipt.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReceipt.setBounds(371, 118, 354, 278);
		frame.getContentPane().add(txtReceipt);
		txtReceipt.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Billing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(371, 401, 343, 147);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBackground(Color.GRAY);
		lblCustomerId.setBounds(33, 41, 118, 32);
		panel.add(lblCustomerId);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtcid = new JTextField();
		txtcid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtcid.setBorder(new LineBorder(Color.BLACK));
		txtcid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String cid = txtcid.getText();

			                pst = con.prepareStatement("select firstname,secondname,phonenumber,email,address,vehical,vehicalnumber,service from customer where cid = ?");
			                pst.setString(1, cid);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String firstname = rs.getString(1);
			                //String secondname = rs.getString(2);
			                String phonenumber = rs.getString(3);
			                //String email = rs.getString(4);
			                //String address = rs.getString(5);
			                String vehical = rs.getString(6);
			                String vehicalnumber = rs.getString(7);
			                String service = rs.getString(8);
			                
			                
			                txtfname.setText(firstname);
			                //txtsname.setText(secondname);
			                txtpnum.setText(phonenumber);
			                //txtemail.setText(email);
			               // txtadd.setText(address);
			                txtvehicle.setText(vehical);
			                txtvehiclenum.setText(vehicalnumber);
			                txtservice.setText(service);
			                
			                
			                
			            }   
			            else
			            {
			            	txtfname.setText("");
			            	//txtsname.setText("");
			            	txtpnum.setText("");
			            	//txtemail.setText("");
							//txtadd.setText("");
							txtvehicle.setText("");
		                    txtvehiclenum.setText("");
							txtservice.setText(""); 
			            }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
			}
		});
		txtcid.setBounds(163, 39, 140, 34);
		panel.add(txtcid);
		txtcid.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(33, 86, 97, 48);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtfname.setText("");
            	//txtsname.setText("");
            	txtpnum.setText("");
            	//txtemail.setText("");
				//txtadd.setText("");
				txtvehicle.setText("");
                txtvehiclenum.setText("");
				txtservice.setText("");
				txtprice.setText("");
				txtcid.setText("");
				txtReceipt.setText("");
				txtfname.requestFocus();
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(151, 86, 97, 48);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dashboard dash = new Dashboard();
				 dash.setVisible(true);
				 frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Print Receipt");
		btnNewButton.setBounds(35, 427, 146, 48);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtReceipt.setText("\tVehicle Management System \n\n" +
					    "Customer Name: \t"+ txtfname.getText() + "\n" +
					    "\n=======================================================\n"+
					    "Customer Number: \t"+ txtpnum.getText() + "\n\n" +
					    "Vehicle: \t\t" + txtvehicle.getText() + "\n\n" +
					    "Vehicle Number: \t" + txtvehiclenum.getText() + "\n\n" +
					    "Service Type: \t\t" + txtservice.getText() + "\n" +
					    "Price: \t\t" + txtprice.getText() + "\n" +
					    "===========================================================\n"+
					    "Total Price: \t\t" + txtprice.getText() + "\n\n" +
					    "Thank you for visiting!!!!!"
								
								);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manoj\\Pictures\\vehical project\\billingimg2.jpg"));
		lblNewLabel.setBounds(0, 0, 737, 576);
		frame.getContentPane().add(lblNewLabel);
	}
}
