import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class loginpage extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxCustomer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	class login{
		public void verify() {
			
			    String username = textField.getText();
             @SuppressWarnings("deprecation")
				String password = passwordField.getText();
			if(chckbxNewCheckBox.isSelected()) {
				 try {
	                	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");

	                    PreparedStatement st = (PreparedStatement) con
	                        .prepareStatement("Select username, password from manager where username=? and password=?");

	                    st.setString(1, username);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                    	JOptionPane.showMessageDialog(null, "You have successfully logged in");
	                        dispose();
	                        Manager1 m1 = new Manager1();
	                        
	                        m1.setTitle("Welcome");
	                        m1.setVisible(true);
	                      
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
				
				
			}
			else if(chckbxCustomer.isSelected()) {
				
				  String userName = textField.getText();
	                @SuppressWarnings("deprecation")
					String password1 = passwordField.getText();
	                try {
	                	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");

	                    PreparedStatement st = (PreparedStatement) con
	                        .prepareStatement("Select username, password from customer where username=? and password=?");

	                    st.setString(1, userName);
	                    st.setString(2, password1);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                        dispose();
	                        String msg = textField.getText();
	                        customer ah = new customer();
	                        
	                        ah.setTitle("Welcome");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
	                        ah.lblNewLabel_2.setText(msg);
	                        setVisible(false);
	                      
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }else {
	            	JOptionPane.showMessageDialog(null, "Please select user type");
	            }
	       
			
		}
	}
	
	
	public loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10,0,1800,1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(704, 49, 636, 675);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setBounds(228, 29, 226, 54);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("_______________________________________________________________________________________________________________");
		lblNewLabel_1.setBounds(42, 93, 669, 56);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Type");
		lblNewLabel_2.setBounds(42, 181, 133, 32);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(42, 292, 133, 38);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(42, 340, 525, 32);
		textField.setBackground(new Color(230, 230, 250));
		panel.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setBounds(42, 406, 133, 38);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				login l = new login();
				l.verify( );
				
			}
		});
		btnNewButton.setBounds(247, 529, 143, 44);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		panel.add(btnNewButton);
		
		 chckbxNewCheckBox = new JCheckBox("Manager");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					chckbxCustomer.setSelected(false);
					
				}
			}
		});
		chckbxNewCheckBox.setBounds(39, 232, 136, 25);
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(chckbxNewCheckBox);
		
		 chckbxCustomer = new JCheckBox(" Customer");
		 chckbxCustomer.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(chckbxCustomer.isSelected()) {
		 			chckbxNewCheckBox.setSelected(false);
					
				}
		 	}
		 });
		chckbxCustomer.setBounds(254, 232, 136, 25);
		chckbxCustomer.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(chckbxCustomer);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordField.setBackground(new Color(230, 230, 250));
		passwordField.setBounds(42, 454, 500, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_8 = new JLabel("Create new account");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(115, 594, 135, 18);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("click here");
		lblNewLabel_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signuppage sp = new signuppage();
				
				sp.setVisible(true);
				
			}
		});
		lblNewLabel_8_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(250, 594, 77, 18);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_4 = new JLabel("GROCERY MANAGEMENT ");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_4.setForeground(new Color(0, 128, 0));
		lblNewLabel_4.setBounds(10, 10, 673, 67);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SYSTEM");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		lblNewLabel_5.setBounds(211, 68, 214, 67);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\lodhiji\\OneDrive\\Desktop\\PROJECT\\IMG-20220902-WA0004.jpg"));
		lblNewLabel_6.setBounds(25, 150, 666, 566);
		contentPane.add(lblNewLabel_6);
		  
}

}
