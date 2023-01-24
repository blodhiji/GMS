import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class signuppage extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel Lable;
	private JTextField states;
	private JTextField Address;
	private JTextField email;
	private JPasswordField passWord;
	private JTextField userName;
	private JTextField contactno;
	private JTextField Fullname;
	private JLabel lblNewLabel_4_1;
	
	public void reset() {
		Fullname.setText("");
		states.setText("");
		Address.setText("");
		email.setText("");
		userName.setText("");
		contactno.setText("");
		passWord.setText("");
		states.setText("");
	}
     
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signuppage frame = new signuppage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class signup{
		 
		 public void vailidation( int id, String full_name, String state,  String address, String Email, String username, String contact_no ,String password) {
			 
			

	         String msg = "" + full_name;
	         msg += " \n";
	        
	          if(full_name.length() >=1 && state.length() >=1 && address.length()>=1 && address.length() >=1 && username.length() >=1 && contact_no.length() >=10 && contact_no.length() <=13) {
	         try {
	         	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectdatabase", "root", "123456@Bb");
	             String query = "INSERT INTO customer values('" + id + "','" + full_name + "','" + state + "','" + address + "','" +
	             		Email + "', '" + contact_no + "' ,'" + password + "','" + username + "')";
	             
	             java.sql.Statement sta =  con.createStatement();
	        int x=  sta.executeUpdate(query);
	        
	             if (x == 0) {
	                 JOptionPane.showMessageDialog(null, "This is alredy exist");
	             } else {
	                 JOptionPane.showMessageDialog(null,
	                     "Welcome, " + msg + "Your account is sucessfully created");
	                 reset();
	             }
	             con.close();
	             loginpage l =new loginpage();
	             l.setVisible(true);
	             
	         } catch (Exception exception) {
	             exception.printStackTrace();
	         }
	     }
	          else {
	        	  
	         	 JOptionPane.showMessageDialog(null, "Please enter vailid data");
	         	 
	          }
			 
		 }
		
	}
	
	
	public signuppage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10,0,1800,1500);
		Lable = new JPanel();
		Lable.setBackground(new Color(255, 255, 255));
		Lable.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Lable);
		Lable.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign up Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 74));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(28, 27, 545, 86);
		Lable.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(785, 475, 116, 41);
		Lable.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(54, 447, 116, 41);
		Lable.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(54, 353, 116, 41);
		Lable.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1_3.setBounds(785, 572, 137, 41);
		Lable.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("State");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1_4.setBounds(58, 268, 71, 41);
		Lable.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Contact no.");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_5.setBounds(58, 533, 137, 41);
		Lable.add(lblNewLabel_1_5);
		
		states = new JTextField();
		states.setFont(new Font("Times New Roman", Font.BOLD, 20));
		states.setBackground(new Color(230, 230, 250));
		states.setBounds(286, 268, 306, 41);
		Lable.add(states);
		states.setColumns(10);
		
		Address = new JTextField();
		Address.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Address.setBackground(new Color(230, 230, 250));
		Address.setColumns(10);
		Address.setBounds(286, 362, 306, 41);
		Lable.add(Address);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.BOLD, 20));
		email.setBackground(new Color(230, 230, 250));
		email.setColumns(10);
		email.setBounds(286, 449, 306, 41);
		Lable.add(email);
		
		passWord = new JPasswordField();
		passWord.setBackground(new Color(230, 230, 250));
		passWord.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passWord.setBounds(1006, 578, 306, 41);
		Lable.add(passWord);
		
		userName = new JTextField();
		userName.setBackground(new Color(230, 230, 250));
		userName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		userName.setColumns(10);
		userName.setBounds(1006, 479, 306, 41);
		Lable.add(userName);
		
		contactno = new JTextField();
		contactno.setBackground(new Color(230, 230, 250));
		contactno.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contactno.setColumns(10);
		contactno.setBounds(286, 537, 306, 41);
		Lable.add(contactno);
		
		JLabel lblNewLabel_1_6 = new JLabel("FullName");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1_6.setBounds(58, 175, 150, 41);
		Lable.add(lblNewLabel_1_6);
		
		Fullname = new JTextField();
		Fullname.setBackground(new Color(230, 230, 250));
		Fullname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Fullname.setToolTipText("");
		Fullname.setColumns(10);
		Fullname.setBounds(286, 175, 306, 41);
		Lable.add(Fullname);
		
		final JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int id = 0;
				 String Full_name = Fullname.getText();
		         String state = states.getText();
		         String address = Address.getText();
		         String Email = email.getText();
		         String username = userName.getText();
		         String contact_no = contactno.getText();
		         @SuppressWarnings("deprecation")
				String password = passWord.getText();
				
				signup s = new signup();
				s.vailidation(id,Full_name, state ,address ,Email ,username ,contact_no,password);

                
			}
			
		});
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(475, 669, 206, 56);
		Lable.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("__________________________________________________");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(27, 105, 654, 32);
		Lable.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\lodhiji\\OneDrive\\Desktop\\PROJECT\\IMG-20220902-WA0002-removebg-preview (1).png"));
		lblNewLabel_3.setBounds(785, 40, 468, 389);
		Lable.add(lblNewLabel_3);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				
				
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnReset.setBackground(new Color(46, 139, 87));
		btnReset.setBounds(765, 669, 212, 56);
		Lable.add(btnReset);
		
		JLabel lblNewLabel_4 = new JLabel("Already have an account");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(416, 758, 167, 13);
		Lable.add(lblNewLabel_4);
		
		lblNewLabel_4_1 = new JLabel("click here");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpage lp = new loginpage();
				lp.setVisible(true);
				
			}
			
		});
		lblNewLabel_4_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(585, 759, 78, 13);
		Lable.add(lblNewLabel_4_1);
		
	}
}
