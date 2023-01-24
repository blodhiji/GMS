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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class view extends JFrame {

	protected static final AbstractButton tblData = null;
	private JPanel contentPane;
	String Product_price;
	String Product_quantity;
	private JLabel amount;
	
	class cart{
		
		public void delete(int product_id, String Product_name) {
			float Product_Price = Float.parseFloat(Product_price);
			float Product_Quantity = Float.parseFloat(Product_quantity);
			 String msg = "" + Product_name;
	         msg += " \n";
	       if(product_id >= 0) {
	         try {
	             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
	             String query = "DELETE  FROM cart where Product_id = " + product_id ;
	             java.sql.Statement sta =  connection.createStatement();
	        int x=  sta.executeUpdate(query);
	        float price = 0;
	             if (x == 0) {
	             	JOptionPane.showMessageDialog(null, "Please enter vailid prod_id");
	             } else {
	            	 String Rs = null;
	                 JOptionPane.showMessageDialog(null,
	                     "Welcome,  Your product " + msg +  " is sucessfully deleted");
	                 
	                 
	                 String sql = "select * from price where id ="+1;
                     Statement pat =  connection.createStatement();
 					ResultSet	rs = pat.executeQuery(sql);
 					pat = connection.prepareStatement(sql);
 					if(rs.next()){
 						Rs = rs.getString("Price");
 					}
 					float RS = Float.parseFloat(Rs);
 					price = price + RS - (Product_Price * Product_Quantity);
                    
                      int id =1;
                     String qry = "UPDATE price set "
                    		+ "Price = '"+ price +"'"
                    	    + "where id = "+ id;
                     Statement st =  connection.createStatement();
                     st.executeUpdate(qry);
                       
                     String pq = null;
                     String sq = "select * from product where Product_id ="+ product_id;
                     Statement pt =  connection.createStatement();
 					ResultSet	ras = pt.executeQuery(sq);
 					pat = connection.prepareStatement(sq);
 					if(ras.next()){
 						pq = ras.getString("Product_quantity");
 					}
 					float PQ = Float.parseFloat(pq);
 					PQ = PQ + Product_Quantity ;
                    
                     
                     String qr = "UPDATE product set "
                     		+ "Product_quantity = '"+ PQ +"'"
                     	    + "where Product_id = "+ product_id;
                      Statement ast =  connection.createStatement();
                      ast.executeUpdate(qr);
	                 
	                 
	                 
	                 resetTable();
	                 Show();
	                 RS();
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
		
		
		
		
		void Show() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
				Statement st =  con.createStatement();
				String query = "select * from cart";
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
	
	
	 JLabel lblNewLabel_1;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
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
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10,0,1800,1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1540, 114);
		panel.setBackground(new Color(46, 139, 87));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer account");
		lblNewLabel.setBackground(new Color(46, 139, 87));
		lblNewLabel.setBounds(10, 0, 484, 70);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer c = new customer();
				c.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(1223, 38, 120, 40);
		panel.add(btnNewButton_1);
		
		
		
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
		btnNewButton_1_1.setBounds(1382, 38, 120, 40);
		panel.add(btnNewButton_1_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(20, 63, 153, 31);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 115, 1571, 730);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Check out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null, "ORDER PLACED SUCCESSFULLY");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(776, 567, 210, 64);
		panel_2.add(btnNewButton);
		
		
		//DELETE FROM CART ....///
		JButton btnDeleteItem = new JButton("Delete item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Product_id = Integer.parseInt(textField.getText());
				String Product_name = textField_1.getText();
				cart c = new cart();
				c.delete(Product_id, Product_name);
			}
		});
		
		
		btnDeleteItem.setForeground(Color.WHITE);
		btnDeleteItem.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDeleteItem.setBackground(new Color(0, 128, 0));
		btnDeleteItem.setBounds(442, 567, 210, 64);
		panel_2.add(btnDeleteItem);
		
		JLabel lblNewLabel_2 = new JLabel("Total Amount");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(103, 522, 160, 25);
		panel_2.add(lblNewLabel_2);
		
	    amount = new JLabel("");
		amount.setFont(new Font("Times New Roman", Font.BOLD, 25));
		amount.setBounds(1222, 522, 160, 25);
		panel_2.add(amount);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 3, 3);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 81, 1287, 406);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(24, 10, 3, 3);
		panel_2.add(textField_1);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String selection = table.getModel().getValueAt(row,0).toString();
				
				String sql = "select * from cart where Product_id =" + selection;
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
					Statement pat =  con.createStatement();
					
					ResultSet	rs = pat.executeQuery(sql);
					pat = con.prepareStatement(sql);
					if(rs.next()){
						textField.setText(rs.getString("Product_id"));
						textField_1.setText(rs.getString("Product_name"));
						Product_price = rs.getString("Product_Price");
				       Product_quantity = rs.getString("Product_Quantity");
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
				
			}
		});
		RS();
		cart c = new cart();
		c.Show();
		RS();
	}
	
	public void RS() {
		 try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
		   String sql = "select * from price where id ="+1;
          Statement pat =  connection.createStatement();
			ResultSet	rs = pat.executeQuery(sql);
			pat = connection.prepareStatement(sql);
			if(rs.next()){
				amount.setText(rs.getString("Price"));
			}
	} catch (Exception exception) {
       exception.printStackTrace();
    }

}
	
	void Show() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
			Statement st =  con.createStatement();
			String query = "select * from checkout";
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
	
	void resetTable() {
		
		table.setModel(new DefaultTableModel());
		
     }
}
