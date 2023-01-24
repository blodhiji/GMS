import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class buy extends JFrame {

	private JPanel contentPane;
	
	float a;
	
	class cart{
		
		public void addtocart(int Product_id, String Product_Name, String Product_Company ,float Product_Quantity, float Product_Price) {
			
			 String msg = "" + Product_Name;
             msg += " \n";
           
             if(Product_id >= 0  && Product_Name.length() >= 1 &&Product_Quantity >= 0 && Product_Price >= 0 && Product_Company.length() >= 1) {
             try {
            	 int pid = Product_id;
             	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
					
                 String query = "INSERT INTO cart values('" + Product_id + "','" +  Product_Name+ "','" + Product_Company  + "','" + Product_Quantity  + "','" +
                 		Product_Price + "')";
                 java.sql.Statement sta =  con.createStatement();
              int x=  sta.executeUpdate(query);
              float price = 0;
                 if (x == 0) {
                     JOptionPane.showMessageDialog(null, "This is alredy exist");
                 } else {
                	 String Rs = null;
                     JOptionPane.showMessageDialog(null,
                         "Product " + msg +  " is sucessfully added");
                     
                     String sql = "select * from price where id ="+1;
                     Statement pat =  con.createStatement();
 					
 					ResultSet	rs = pat.executeQuery(sql);
 					pat = con.prepareStatement(sql);
 					if(rs.next()){
 						Rs = rs.getString("Price");
 					}
 					float RS = Float.parseFloat(Rs);
 					price = price + (Product_Price * Product_Quantity )+ RS;
                    
                      int id =1;
                     String qry = "UPDATE price set "
                    		+ "Price = '"+ price +"'"
                    	    + "where id = "+ id;
                     Statement st =  con.createStatement();
                     st.executeUpdate(qry);
                     float PQ = 0;
                     PQ = a - Product_Quantity;
                     String qr = "UPDATE product set "
                     		+ "Product_quantity = '"+ PQ +"'"
                     	    + "where Product_id = "+ pid;
                      Statement ast =  con.createStatement();
                      ast.executeUpdate(qr);
                     
                     resetTable();
                     Show();
                     
                 }
                 con.close();
                 textField.setText("");
             
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
             
             }
             else {
             	JOptionPane.showMessageDialog(null, "Please enter vailid data");
             }
		}
		
		
	}
	
	
	
	
	
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblNewLabel_1;
	
	void resetTable() {
		table.setModel(new DefaultTableModel());
                }
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buy frame = new buy();
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
	public buy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10,0,1800,1500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1540, 114);
		panel.setBackground(new Color(0, 128, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer account");
		lblNewLabel.setBounds(10, 0, 517, 70);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginpage l = new loginpage();
				l.setVisible(true);
			}
		});
		btnLogOut.setForeground(new Color(0, 0, 0));
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.setBounds(1267, 40, 139, 46);
		panel.add(btnLogOut);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer c = new customer();
				c.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setBounds(1065, 40, 139, 46);
		panel.add(btnBack);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1.setBounds(20, 73, 139, 31);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 113, 1540, 711);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		// ITEM ADD TO CART ...////
		
		JButton btnNewButton = new JButton("Add to cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
			    float Product_Quantity = Float.parseFloat(textField.getText());
		       int Product_id = Integer.parseInt(textField_1.getText());
		       String Product_Name = textField_2.getText();
		       float Product_Price = Float.parseFloat(textField_3.getText());
		       String Product_Company = textField_4.getText();
				
	                cart c = new cart();
	                c.addtocart(Product_id, Product_Name, Product_Company, Product_Quantity, Product_Price);
				}
		});
		
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(411, 535, 206, 45);
		panel_2.add(btnNewButton);
		
		JButton btnGoToCart = new JButton("Go to cart");
		btnGoToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view v = new view();
				v.setVisible(true);
			}
		});
		btnGoToCart.setForeground(Color.WHITE);
		btnGoToCart.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnGoToCart.setBackground(new Color(0, 128, 0));
		btnGoToCart.setBounds(811, 535, 206, 45);
		panel_2.add(btnGoToCart);
		
		JLabel lblNewLabel_2 = new JLabel("Select quantity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(167, 450, 200, 38);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(424, 450, 174, 38);
		panel_2.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 83, 1082, 339);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(10, 10, 0, 0);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(30, 10, 0, 0);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(30, 10, 0, 0);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(30, 10, 0, 0);
		panel_2.add(textField_4);
		
		
		
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
						textField.setText(rs.getString("Product_quantity"));
						textField_1.setText(rs.getString("Product_id"));
						textField_2.setText(rs.getString("Product_name"));
						textField_3.setText(rs.getString("Product_price"));
						textField_4.setText(rs.getString("Product_company"));
						a = Float.parseFloat(rs.getString("Product_price"));
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
	
	
}
