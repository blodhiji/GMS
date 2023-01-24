import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class manager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	
	class manageinventory {
		
		public void Additem(int Product_id, String Product_name, float Product_quantity, float Product_price, String Product_company) {
			
			String msg = "" + Product_name;
            msg += " \n";
			if(Product_id >=0  && Product_name.length() >= 1 && Product_quantity >= 0 && Product_price >= 0 && Product_company.length() >= 1) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
                    String query = "INSERT INTO product values('" +Product_id + "','" + Product_name + "','" + Product_company + "','" +  Product_quantity + "','" +
                    		Product_price + "')";
                    java.sql.Statement sta =  connection.createStatement();
               int x=  sta.executeUpdate(query);
               
                    if (x == 0) {
                        JOptionPane.showMessageDialog(null, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "Product " + msg +  " is sucessfully added");
                        resetText();
                        resetTable();
                        Show();
                    }
                    connection.close();
                    
                } catch (Exception exception) {
                    exception.printStackTrace(); 
                }
                }
                else {
                	JOptionPane.showMessageDialog(null, "Please enter vailid data");
                }
		}
	
		
		public void update(int Product_id, String Product_name, float Product_quantity, float Product_price, String Product_company) {
			
			String msg = "" + Product_name;
            msg += " \n";
          
            if(Product_id >=0  && Product_name.length() >= 1 && Product_quantity >= 0 && Product_price >= 0 && Product_company.length() >= 1) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");

                String query = "UPDATE product set "
                		+ "Product_id = '"+Product_id+"',"
                		+ "Product_name = '"+Product_name+"',"
                		+ "Product_quantity = '"+Product_quantity+"',"
                		+ "Product_price = '"+Product_price+"',"
                	    + "Product_company = '"+Product_company+"'"
                	    + "where Product_id = "+ Product_id;
                		

                java.sql.Statement sta =  connection.createStatement();
           int x=  sta.executeUpdate(query);
           
                if (x == 0) {
                    JOptionPane.showMessageDialog(null, "Product id can't change");
                } else {
                    JOptionPane.showMessageDialog(null,"Product "+ msg +  " is sucessfully updeted");
                    resetText();
                    resetTable();
                    Show();
                }
                connection.close();
                
            } catch (Exception exception) {
                exception.printStackTrace();
            }  
            }
            else {
            	JOptionPane.showMessageDialog(null, "Please enter vailid data");
            }
			
		}
		
	 
	public void delete(String Product_name, int Product_id) {
		
		 String msg = "" + Product_name;
         msg += " \n";
       if(Product_id >= 0) {
         try {
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
             String query = "DELETE  FROM product where Product_id = " + Product_id ;
             java.sql.Statement sta =  connection.createStatement();
        int x=  sta.executeUpdate(query);
             if (x == 0) {
             	JOptionPane.showMessageDialog(null, "Please enter vailid prod_id");
             } else {
                 JOptionPane.showMessageDialog(null,
                     "Welcome,  Your product " + msg +  " is sucessfully deleted");
                 resetText();
                 resetTable();
                 Show();
             }
             connection.close();
             
         } catch (Exception exception) {
             exception.printStackTrace();
         }
       }
       else {
     	  JOptionPane.showMessageDialog(null, "Please enter vailid prod_id");
         }
	 	
	 }
	
}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manager frame = new manager();
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
	public manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10,0,1800,1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1540, 126);
		panel.setBackground(new Color(46, 139, 87));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGER");
		lblNewLabel.setBounds(10, 0, 317, 70);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		
		JButton btnNewButton_1_1 = new JButton("Logout");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginpage l = new loginpage();
				l.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(1355, 44, 154, 46);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mr.Singh");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(10, 80, 141, 25);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager1 m1 = new Manager1();
				m1.setVisible(true);
				
			}
		});
		btnNewButton_1_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(1166, 44, 154, 46);
		panel.add(btnNewButton_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 124, 1527, 721);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Product id");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(95, 40, 154, 32);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(353, 42, 284, 37);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Product name");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(95, 120, 169, 37);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setColumns(10);
		textField_1.setBounds(353, 124, 284, 37);
		
		JLabel lblNewLabel_3_1 = new JLabel("Product Rs.");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(713, 38, 154, 37);
		
		JLabel lblNewLabel_3_2 = new JLabel("Product quantity");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3_2.setBounds(713, 120, 193, 37);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setColumns(10);
		textField_2.setBounds(957, 42, 284, 37);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_3.setBackground(new Color(230, 230, 250));
		textField_3.setColumns(10);
		textField_3.setBounds(957, 126, 284, 34);
		
		
		//ADD ITEM  .....////
		
		JButton add = new JButton("Add item");
		add.setBounds(247, 284, 193, 53);
		panel_2.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Product_id = Integer.parseInt(textField.getText());
				String Product_name = textField_1.getText();
				String Product_company = textField_4.getText();
                float Product_quantity = Float.parseFloat(textField_3.getText());
                float Product_price = Float.parseFloat(textField_2.getText());
                
                manageinventory mi = new manageinventory();
                mi.Additem(Product_id, Product_name, Product_quantity, Product_price, Product_company);                
			}
		});
		
		
		
		add.setBackground(new Color(46, 139, 87));
		add.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_3);
		panel_2.add(textField);
		panel_2.add(lblNewLabel_4);
		panel_2.add(textField_1);
		panel_2.add(lblNewLabel_3_1);
		panel_2.add(lblNewLabel_3_2);
		panel_2.add(textField_2);
		panel_2.add(textField_3);
		
		// DELETE ITEM .../////
		
		JButton view = new JButton("Delete");
		view.setBounds(863, 284, 193, 53);
		panel_2.add(view);
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int Product_id = Integer.parseInt(textField.getText());
     			String Product_name = textField_1.getText();
       manageinventory mi = new manageinventory();
       mi.delete(Product_name , Product_id);
               
			}
		});
		
		
		
		view.setBackground(new Color(46, 139, 87));
		view.setForeground(new Color(255, 255, 255));
		view.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		// UPDATE ITEM ..../////
		
		JButton update = new JButton("Update");
		update.setBounds(558, 284, 193, 53);
		panel_2.add(update);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Product_id = Integer.parseInt(textField.getText());
				String Product_name = textField_1.getText();
                float Product_quantity = Float.parseFloat(textField_3.getText());
                float Product_price = Float.parseFloat(textField_2.getText());
                String Product_company = textField_4.getText();
                
                manageinventory mi = new manageinventory();
                mi.update(Product_id, Product_name, Product_quantity, Product_price, Product_company);
                
			}
		});
		
		
		
		update.setBackground(new Color(46, 139, 87));
		update.setForeground(new Color(255, 255, 255));
		update.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_4_1 = new JLabel("Company");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4_1.setBounds(95, 202, 169, 36);
		panel_2.add(lblNewLabel_4_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setColumns(10);
		textField_4.setBounds(353, 206, 284, 37);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("___________________________________________________________________________________________________");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(49, 329, 1420, 37);
		panel_2.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 385, 1178, 231);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				String selection = table.getModel().getValueAt(row,0).toString();
				
				String sql = "select * from product where Product_id =" + selection;
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");

					Statement pat =  con.createStatement();
					
					ResultSet	rs = pat.executeQuery(sql);
					pat = con.prepareStatement(sql);
					if(rs.next()){
						textField.setText(rs.getString("Product_id"));
						textField_1.setText(rs.getString("Product_name"));
						textField_3.setText(rs.getString("Product_quantity"));
						textField_2.setText(rs.getString("Product_price"));
						textField_4.setText(rs.getString("Product_company"));
						
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		Show();
		
	}
		
		
	void Show() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
			Statement st =  con.createStatement();
			String query = "select * from product";
			ResultSet rs = st.executeQuery(query);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			  int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i = 0; i<cols; i++) 
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);  
			
			String Product_id ,Product_name,Product_company,Product_quantity,Product_price;
			while(rs.next()) {
				Product_id = rs.getString(1);
				Product_name = rs.getString(2);
				Product_company = rs.getString(3);
				Product_quantity = rs.getString(4);
				Product_price = rs.getString(5);
				
				String[] row = { Product_id ,Product_name,Product_company,Product_quantity,Product_price};
				model.addRow(row);
			}
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	 
	// RELOAD TABLE ...////
	
		void resetTable() {
			table.setModel(new DefaultTableModel());
	     }
		 
		// RESET TEXT ..../////
		
		public void resetText() {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			
		}
	}
		
		
		
		
	

