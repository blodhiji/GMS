import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Manager1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager1 frame = new Manager1();
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
	public Manager1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10,0,1800,1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1540, 113);
		panel.setBackground(new Color(46, 139, 87));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGER");
		lblNewLabel.setBounds(20, 0, 354, 70);
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
		btnLogOut.setBounds(1391, 39, 139, 46);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel_2 = new JLabel("Mr.Singh");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(20, 78, 141, 25);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 111, 1527, 713);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\lodhiji\\OneDrive\\Desktop\\PROJECT\\IMG-20220902-WA00051.jpg"));
		lblNewLabel_3.setBounds(64, 30, 743, 654);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1021, 100, 380, 485);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnManage = new JButton("Manage inventory");
		btnManage.setBounds(47, 101, 273, 46);
		panel_1.add(btnManage);
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager m = new manager();
				m.setVisible(true);
			}
		});
		btnManage.setForeground(new Color(255, 255, 255));
		btnManage.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnManage.setBackground(new Color(0, 128, 0));
		
		JButton btnViewOders = new JButton("View oders");
		btnViewOders.setBounds(47, 277, 273, 46);
		panel_1.add(btnViewOders);
		btnViewOders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOders v = new viewOders();
				v.setVisible(true);
			}
		});
		btnViewOders.setForeground(new Color(255, 255, 255));
		btnViewOders.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnViewOders.setBackground(new Color(0, 128, 0));
		
		

	}
}
