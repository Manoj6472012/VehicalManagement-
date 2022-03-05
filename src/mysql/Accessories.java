package mysql;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;


public class Accessories {

	JFrame frame;
	private JTextField txtacc;
	private JTextField txtqty;
	private JTable table;
	private JTextField txtaid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accessories window = new Accessories();
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
	public Accessories() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtprice;
	
 
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
			 pst = con.prepareStatement("select * from accessories");
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
		frame.setBounds(100, 100, 836, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAccessories = new JLabel(" Accessories");
		lblAccessories.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAccessories.setBackground(SystemColor.inactiveCaptionBorder);
		lblAccessories.setOpaque(true);
		lblAccessories.setForeground(SystemColor.desktop);
		lblAccessories.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		lblAccessories.setBounds(144, 25, 214, 50);
		frame.getContentPane().add(lblAccessories);
		
		JLabel lblAccessory = new JLabel(" Accessorie Name");
		lblAccessory.setOpaque(true);
		lblAccessory.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAccessory.setForeground(Color.BLACK);
		lblAccessory.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblAccessory.setBounds(12, 143, 179, 42);
		frame.getContentPane().add(lblAccessory);
		
		JLabel lblAccessorieId = new JLabel(" Quantity");
		lblAccessorieId.setOpaque(true);
		lblAccessorieId.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAccessorieId.setForeground(Color.BLACK);
		lblAccessorieId.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblAccessorieId.setBounds(12, 205, 179, 42);
		frame.getContentPane().add(lblAccessorieId);
		
		txtacc = new JTextField();
		txtacc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtacc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtacc.setBounds(203, 143, 176, 41);
		frame.getContentPane().add(txtacc);
		txtacc.setColumns(10);
		
		txtqty = new JTextField();
		txtqty.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtqty.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtqty.setBounds(203, 205, 176, 42);
		frame.getContentPane().add(txtqty);
		txtqty.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String accname,accqty,accprice;
				accname = txtacc.getText();
				accqty = txtqty.getText();
				accprice = txtprice.getText();
							
				 try {
					pst = con.prepareStatement("insert into accessories(accname,accqty,accprice)values(?,?,?)");
					pst.setString(1, accname);
					pst.setString(2, accqty);
					pst.setString(3, accprice);
                   	pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					table_load();
						           
					txtacc.setText("");
					txtqty.setText("");
					txtprice.setText("");
					txtacc.requestFocus();
                     }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
				
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBounds(12, 384, 105, 42);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtacc.setText("");
				txtqty.setText("");
				txtprice.setText("");
				txtaid.setText("");
				txtacc.requestFocus();
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(131, 385, 97, 41);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dashboard dash = new Dashboard();
				 dash.setVisible(true);
				 frame.dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(251, 385, 97, 41);
		frame.getContentPane().add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBounds(391, 143, 401, 228);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(391, 384, 401, 161);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAccessorieId_1 = new JLabel("Accessorie ID");
		lblAccessorieId_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAccessorieId_1.setBounds(19, 53, 124, 29);
		panel.add(lblAccessorieId_1);
		
		txtaid = new JTextField();
		txtaid.setBorder(new LineBorder(SystemColor.desktop));
		txtaid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String aid = txtaid.getText();

			                pst = con.prepareStatement("select accname,accqty,accprice from accessories where aid = ?");
			                pst.setString(1, aid);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String accname = rs.getString(1);
			                String accqty = rs.getString(2);
			                String accprice = rs.getString(3);
		 
			                txtacc.setText(accname);
			                txtqty.setText(accqty);
			                txtprice.setText(accprice);
			                 
			            }   
			            else
			            {
			            	 txtacc.setText("");
							 txtqty.setText("");
							 txtprice.setText("");
			            }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
			}
		});
		txtaid.setBounds(171, 53, 153, 29);
		panel.add(txtaid);
		txtaid.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdate.setBounds(44, 107, 97, 41);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String accname,accqty,accprice,aid;
				 accname = txtacc.getText();
				 accqty = txtqty.getText();
				 accprice = txtprice.getText(); 
					aid = txtaid.getText();
						
						 try {
								pst = con.prepareStatement("update accessories set accname= ?,accqty=?,accprice=? where aid =?");
								pst.setString(1, accname);
								pst.setString(2, accqty);
								pst.setString(3, accprice);
								pst.setString(4, aid);
					            pst.executeUpdate();
					            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					            table_load();
					           
					            txtacc.setText("");
								txtqty.setText("");
								txtprice.setText("");
							}

				            catch (SQLException e1) {
								
								e1.printStackTrace();
							}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.setBounds(171, 107, 97, 41);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String aid;
				aid  = txtaid.getText();
				
				 try {
						pst = con.prepareStatement("delete from accessories where aid =?");
				
			            pst.setString(1, aid);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
			            table_load();
			           
			            txtacc.setText("");
						txtqty.setText("");
						txtprice.setText("");
					}

			        catch (SQLException e1) {
						
						e1.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblPrice = new JLabel(" Price");
		lblPrice.setOpaque(true);
		lblPrice.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblPrice.setBounds(12, 262, 179, 41);
		frame.getContentPane().add(lblPrice);
		
		txtprice = new JTextField();
		txtprice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtprice.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtprice.setBounds(203, 262, 176, 41);
		frame.getContentPane().add(txtprice);
		txtprice.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manoj\\Pictures\\vehical project\\acc5.jpg"));
		lblNewLabel.setBounds(0, 0, 830, 565);
		frame.getContentPane().add(lblNewLabel);
	}
}
