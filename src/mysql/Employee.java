package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Employee {

	JFrame frame;
	private JTable table;
	private JTextField txteid;
	private JTextField txtempname;
	private JTextField txtempage;
	private JTextField txtempnum;
	private JTextField txtempmail;
	private JTextField txtempdis;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
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
			 pst = con.prepareStatement("select * from employee");
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
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 744, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblEmployeeDetails.setBounds(12, 27, 336, 51);
		frame.getContentPane().add(lblEmployeeDetails);
		
		JLabel lblEmployeeName = new JLabel("Employee name");
		lblEmployeeName.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblEmployeeName.setBounds(12, 114, 155, 36);
		frame.getContentPane().add(lblEmployeeName);
		
		JLabel lblEmployeeAge = new JLabel("Employee age");
		lblEmployeeAge.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblEmployeeAge.setBounds(12, 163, 155, 35);
		frame.getContentPane().add(lblEmployeeAge);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblPhoneNumber.setBounds(12, 211, 155, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblEmail.setBounds(12, 256, 155, 31);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblDesignation.setBounds(12, 300, 155, 28);
		frame.getContentPane().add(lblDesignation);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String empname,empage,empnum,empmail,empdis,gender;
				empname = txtempname.getText();
				empage = txtempage.getText();
				empnum = txtempnum.getText();
				empmail = txtempmail.getText();
				empdis = txtempdis.getText();
				
				gender = (String)comboBox.getSelectedItem(); 
//				System.out.println("Working");
				
				 try {
					pst = con.prepareStatement("insert into employee(empname,empage,empnum,empmail,empdis,gender)values(?,?,?,?,?,?)");
					pst.setString(1, empname);
					pst.setString(2, empage);
					pst.setString(3, empnum);
					pst.setString(4, empmail);
					pst.setString(5, empdis);
					pst.setString(6, gender);
                   	pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					table_load();
						           
					txtempname.setText("");
					txtempage.setText("");
					txtempnum.setText("");
					txtempmail.setText("");
					txtempdis.setText("");
					txtempname.requestFocus();
					comboBox.setSelectedItem("");
                     }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
				
				
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBounds(12, 427, 97, 43);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtempname.setText("");
				txtempage.setText("");
				txtempnum.setText("");
				txtempmail.setText("");
				txtempdis.setText("");
				txteid.setText("");
				txtempname.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(121, 427, 97, 43);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBounds(364, 102, 355, 258);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtempname = new JTextField();
		txtempname.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtempname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtempname.setBounds(179, 112, 170, 37);
		frame.getContentPane().add(txtempname);
		txtempname.setColumns(10);
		
		txtempage = new JTextField();
		txtempage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtempage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtempage.setBounds(179, 162, 170, 35);
		frame.getContentPane().add(txtempage);
		txtempage.setColumns(10);
		
		txtempnum = new JTextField();
		txtempnum.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtempnum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtempnum.setBounds(179, 210, 170, 32);
		frame.getContentPane().add(txtempnum);
		txtempnum.setColumns(10);
		
		txtempmail = new JTextField();
		txtempmail.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtempmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtempmail.setBounds(179, 255, 170, 37);
		frame.getContentPane().add(txtempmail);
		txtempmail.setColumns(10);
		
		txtempdis = new JTextField();
		txtempdis.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtempdis.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtempdis.setBounds(179, 305, 170, 43);
		frame.getContentPane().add(txtempdis);
		txtempdis.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBackground(Color.WHITE);
		lblGender.setOpaque(true);
		lblGender.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblGender.setBounds(12, 354, 155, 33);
		frame.getContentPane().add(lblGender);
		
		String[] g = {"Male","Female","Others"};
		comboBox = new <String>JComboBox(g);
		comboBox.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
//		comboBox.setSelectedItem(null);
		comboBox.setBounds(179, 361, 170, 36);
		frame.getContentPane().add(comboBox);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard dash = new Dashboard();
				 dash.setVisible(true);
				 frame.dispose();
			}
		});
		btnExit.setBounds(230, 427, 97, 43);
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(374, 373, 345, 138);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(30, 35, 112, 28);
		panel.add(lblEmployeeId);
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txteid = new JTextField();
		txteid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txteid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txteid.setBounds(167, 35, 112, 28);
		panel.add(txteid);
		txteid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				

				 try {
			          
			            String eid = txteid.getText();

			                pst = con.prepareStatement("select empname,empage,empnum,empmail,empdis from employee where eid = ?");
			                pst.setString(1, eid);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String empname = rs.getString(1);
			                String empage = rs.getString(2);
			                String empnum = rs.getString(3);
			                String empmail = rs.getString(4);
			                String empdis = rs.getString(5);
			                
			                
			               
			                txtempname.setText(empname);
			                txtempage.setText(empage);
			                txtempnum.setText(empnum);
			                txtempmail.setText(empmail);
			                txtempdis.setText(empdis);
			               
			                
			            }   
			            else
			            {
			            	txtempname.setText("");
			                txtempage.setText("");
			                txtempnum.setText("");
			                txtempmail.setText("");
			                txtempdis.setText("");
                              
			            }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
			}
		});
		txteid.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(30, 89, 112, 36);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    String empname,empage,empnum,empmail,empdis,gender,eid;
			    empname = txtempname.getText();
				empage = txtempage.getText();
				empnum = txtempnum.getText();
				empmail = txtempmail.getText();
				empdis = txtempdis.getText();
				gender = (String)comboBox.getSelectedItem(); 
				eid = txteid.getText();
					
					 try {
							pst = con.prepareStatement("update employee set empname= ?,empage=?,empnum=?,empmail=?,empdis=?,gender=? where eid =?");
							pst.setString(1, empname);
							pst.setString(2, empage);
							pst.setString(3, empnum);
							pst.setString(4, empmail);
							pst.setString(5, empdis);
							pst.setString(6, gender);
							pst.setString(7, eid);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
				            table_load();
				           
				            txtempname.setText("");
							txtempage.setText("");
							txtempnum.setText("");
							txtempmail.setText("");
							txtempdis.setText("");
						}

			            catch (SQLException e1) {
							
							e1.printStackTrace();
						}
				
				
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(167, 89, 112, 36);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eid;
				eid  = txteid.getText();
				
				 try {
						pst = con.prepareStatement("delete from employee where eid =?");
				
			            pst.setString(1, eid);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
			            table_load();
			           
			            txtempname.setText("");
						txtempage.setText("");
						txtempnum.setText("");
						txtempmail.setText("");
						txtempdis.setText("");
					}

			        catch (SQLException e1) {
						
						e1.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manoj\\Pictures\\vehical project\\employeeimg.jpg"));
		lblNewLabel.setBounds(0, -34, 754, 558);
		frame.getContentPane().add(lblNewLabel);
	}
}
