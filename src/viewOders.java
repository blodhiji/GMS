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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class viewOders extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewOders frame = new viewOders();
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
	public viewOders() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Mr.Singh");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(20, 78, 141, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setBackground(new Color(46, 139, 87));
		lblNewLabel.setBounds(10, 0, 269, 70);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager1 c = new Manager1();
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
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 112, 1540, 723);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(1222, 522, 160, 25);
		panel_2.add(lblNewLabel_2_1);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 106, 1122, 417);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Total amount");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(183, 543, 202, 37);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(1222, 543, 83, 37);
		panel_2.add(lblNewLabel_1_1);
		
		Show();
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
				lblNewLabel_1_1.setText(rs.getString("Price"));
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
	
	void resetTable() {
		
		table.setModel(new DefaultTableModel());
		
     }
}


