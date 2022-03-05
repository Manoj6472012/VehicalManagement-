package mysql;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class customer1 {

	JFrame frame;
	private JTextField txtfname;
	private JTextField txtsname;
	private JTextField txtpnum;
	private JTextField txtemail;
	private JTextField txtadd;
	private JTextField txtvehicle;
	private JTextField txtvehiclenum;
	private JTextField txtservice;
	private JTextField txtcid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer1 window = new customer1();
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
	public customer1() {
		initialize();
		Connect();
		table_load();
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
	 
	 void table_load()
	 {
		 try
		 {
			 pst = con.prepareStatement("select * from customer");
			 rs = pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	 }
	
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 747, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Customer details");
		lblCustomerDetails.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCustomerDetails.setBounds(26, 13, 262, 36);
		frame.getContentPane().add(lblCustomerDetails);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBorder(null);
		lblFirstName.setForeground(new Color(0, 0, 0));
		lblFirstName.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblFirstName.setBounds(26, 91, 154, 35);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second name");
		lblSecondName.setBorder(null);
		lblSecondName.setForeground(new Color(0, 0, 0));
		lblSecondName.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblSecondName.setBounds(25, 139, 155, 38);
		frame.getContentPane().add(lblSecondName);
		
		JLabel lblNewLabel = new JLabel("Phone number");
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(25, 190, 155, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBorder(null);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblEmail.setBounds(26, 240, 154, 31);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBorder(null);
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblAddress.setBounds(26, 284, 154, 46);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblVehicle = new JLabel("Vehicle ");
		lblVehicle.setBorder(null);
		lblVehicle.setForeground(new Color(0, 0, 0));
		lblVehicle.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblVehicle.setBounds(26, 343, 154, 33);
		frame.getContentPane().add(lblVehicle);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setBorder(null);
		lblVehicleNumber.setForeground(new Color(0, 0, 0));
		lblVehicleNumber.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblVehicleNumber.setBounds(26, 389, 154, 32);
		frame.getContentPane().add(lblVehicleNumber);
		
		JLabel lblServiceType = new JLabel("Service type");
		lblServiceType.setBorder(null);
		lblServiceType.setForeground(new Color(0, 0, 0));
		lblServiceType.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblServiceType.setBounds(26, 434, 154, 39);
		frame.getContentPane().add(lblServiceType);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtfname.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtfname.setBounds(186, 91, 157, 38);
		frame.getContentPane().add(txtfname);
		txtfname.setColumns(10);
		
		txtsname = new JTextField();
		txtsname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtsname.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtsname.setBounds(186, 142, 157, 36);
		frame.getContentPane().add(txtsname);
		txtsname.setColumns(10);
		
		txtpnum = new JTextField();
		txtpnum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtpnum.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtpnum.setBounds(186, 189, 157, 37);
		frame.getContentPane().add(txtpnum);
		txtpnum.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtemail.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtemail.setBounds(186, 239, 157, 31);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtadd = new JTextField();
		txtadd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtadd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtadd.setBounds(186, 283, 157, 48);
		frame.getContentPane().add(txtadd);
		txtadd.setColumns(10);
		
		txtvehicle = new JTextField();
		txtvehicle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtvehicle.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtvehicle.setBounds(186, 342, 157, 33);
		frame.getContentPane().add(txtvehicle);
		txtvehicle.setColumns(10);
		
		txtvehiclenum = new JTextField();
		txtvehiclenum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtvehiclenum.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtvehiclenum.setBounds(186, 388, 157, 36);
		frame.getContentPane().add(txtvehiclenum);
		txtvehiclenum.setColumns(10);
		
		txtservice = new JTextField();
		txtservice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtservice.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtservice.setBounds(186, 437, 157, 36);
		frame.getContentPane().add(txtservice);
		txtservice.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname,sname,pnum,email,addr,vehicle,vehiclenum,service;
				fname = txtfname.getText();
				sname = txtsname.getText();
				pnum = txtpnum.getText();
				email = txtemail.getText();
				addr = txtadd.getText();
				vehicle = txtvehicle.getText();
                vehiclenum = txtvehiclenum.getText();
				service = txtservice.getText();
				if(fname.equals("")){
					JOptionPane.showMessageDialog(new JFrame(),"Enter first name");
					return;
				}
							
				 try {
					pst = con.prepareStatement("insert into customer(firstname,secondname,phonenumber,email,address,vehical,vehicalnumber,service)values(?,?,?,?,?,?,?,?)");
					pst.setString(1, fname);
					pst.setString(2, sname);
					pst.setString(3, pnum);
					pst.setString(4, email);
					pst.setString(5, addr);
					pst.setString(6, vehicle);
                    pst.setString(7, vehiclenum);
					pst.setString(8, service);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					table_load();
						           
					txtfname.setText("");
					txtsname.setText("");
					txtpnum.setText("");
					txtemail.setText("");
					txtadd.setText("");
					txtvehicle.setText("");
                    txtvehiclenum.setText("");
					txtservice.setText("");
					txtfname.requestFocus();
				   }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(33, 506, 97, 46);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfname.setText("");
				txtsname.setText("");
				txtpnum.setText("");
				txtemail.setText("");
				txtadd.setText("");
				txtvehicle.setText("");
                txtvehiclenum.setText("");
				txtservice.setText("");
				txtcid.setText("");
				txtfname.requestFocus();
			}
		});
		btnClear.setBounds(142, 506, 97, 46);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 91, 355, 368);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(362, 472, 355, 127);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBackground(Color.LIGHT_GRAY);
		lblCustomerId.setBounds(35, 31, 125, 21);
		panel.add(lblCustomerId);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtcid = new JTextField();
		txtcid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtcid.setBorder(new LineBorder(SystemColor.desktop));
		txtcid.setBounds(163, 26, 125, 35);
		panel.add(txtcid);
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
				                String secondname = rs.getString(2);
				                String phonenumber = rs.getString(3);
				                String email = rs.getString(4);
				                String address = rs.getString(5);
				                String vehical = rs.getString(6);
				                String vehicalnumber = rs.getString(7);
				                String service = rs.getString(8);
				                
				                
				                txtfname.setText(firstname);
				                txtsname.setText(secondname);
				                txtpnum.setText(phonenumber);
				                txtemail.setText(email);
				                txtadd.setText(address);
				                txtvehicle.setText(vehical);
				                txtvehiclenum.setText(vehicalnumber);
				                txtservice.setText(service);
				                
				                
				                
				            }   
				            else
				            {
				            	txtfname.setText("");
				            	txtsname.setText("");
				            	txtpnum.setText("");
				            	txtemail.setText("");
								txtadd.setText("");
								txtvehicle.setText("");
			                    txtvehiclenum.setText("");
								txtservice.setText(""); 
				            }
				            


				        } 
					
					 catch (SQLException ex) {
				           
				        }
				
				
			}
		});
		txtcid.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(46, 73, 97, 41);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname,sname,pnum,email,addr,vehicle,vehiclenum,service,cid;
				fname = txtfname.getText();
				sname = txtsname.getText();
				pnum = txtpnum.getText();
				email = txtemail.getText();
				addr = txtadd.getText();
				vehicle = txtvehicle.getText();
                vehiclenum = txtvehiclenum.getText();
				service = txtservice.getText();
				cid = txtcid.getText();
					
					 try {
							pst = con.prepareStatement("update customer set firstname= ?,secondname=?,phonenumber=?,email=?,address=?,vehical=?,vehicalnumber=?,service=? where cid =?");
							pst.setString(1, fname);
							pst.setString(2, sname);
							pst.setString(3, pnum);
							pst.setString(4, email);
							pst.setString(5, addr);
							pst.setString(6, vehicle);
		                    pst.setString(7, vehiclenum);
							pst.setString(8, service);
							pst.setString(9, cid);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
				            table_load();
				           
				            txtfname.setText("");
							txtsname.setText("");
							txtpnum.setText("");
							txtemail.setText("");
							txtadd.setText("");
							txtvehicle.setText("");
			                txtvehiclenum.setText("");
							txtservice.setText("");
						}

			            catch (SQLException e1) {
							
							e1.printStackTrace();
						}
		
				}
				
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(163, 74, 97, 39);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String cid;
	cid  = txtcid.getText();
	
	 try {
			pst = con.prepareStatement("delete from customer where cid =?");
	
            pst.setString(1, cid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
            table_load();
           
            txtfname.setText("");
			txtsname.setText("");
			txtpnum.setText("");
			txtemail.setText("");
			txtadd.setText("");
			txtvehicle.setText("");
            txtvehiclenum.setText("");
			txtservice.setText("");
		}

        catch (SQLException e1) {
			
			e1.printStackTrace();
		}
				
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dashboard dash = new Dashboard();
				 dash.setVisible(true);
				 frame.dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(246, 506, 97, 46);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Manoj\\Pictures\\vehical project\\car3.jpg"));
		lblNewLabel_1.setBounds(0, 0, 729, 599);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
