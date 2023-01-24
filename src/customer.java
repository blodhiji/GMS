import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

 

@SuppressWarnings("serial")
public class customer extends  JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer frame = new customer();
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
	public customer() {
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
		lblNewLabel.setBounds(20, 0, 517, 70);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
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
		btnLogOut.setBounds(1344, 36, 139, 46);
		panel.add(btnLogOut);
		
		 lblNewLabel_2 = new JLabel("");
		 lblNewLabel_2.setForeground(new Color(255, 255, 255));
		 lblNewLabel_2.setBackground(new Color(46, 139, 87));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(42, 70, 157, 34);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 111, 1527, 713);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(55, 23, 800, 702);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\lodhiji\\OneDrive\\Desktop\\PROJECT\\Grocery-Shopping-Online1.png"));
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1089, 140, 336, 463);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("View Cart");
		btnNewButton.setBounds(78, 113, 164, 46);
		panel_1.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = lblNewLabel_2.getText();
				view v = new view();
				v.setVisible(true);
				v.lblNewLabel_1.setText(as);
				setVisible(false);
			}
			
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnBuyItem = new JButton("Buy item");
		btnBuyItem.setBounds(78, 248, 164, 46);
		panel_1.add(btnBuyItem);
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = lblNewLabel_2.getText();
				buy b = new buy();
				b.setVisible(true);
				b.lblNewLabel_1.setText(as);
				setVisible(false);
			}
		});
		btnBuyItem.setForeground(Color.WHITE);
		btnBuyItem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnBuyItem.setBackground(new Color(0, 128, 0));
		
		
		
	}
}
