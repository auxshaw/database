package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.BaseDAO;
import base.DAO;
import base.UserDAO;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updatepass extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;


	/**
	 * Create the frame.
	 */
	public Updatepass() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 275);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(25, 50, 55, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(25, 105, 55, 20);
		contentPane.add(label_1);
		
		username = new JTextField();
		username.setBounds(100, 50, 130, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(100, 105, 130, 20);
		contentPane.add(password);
		
		JButton OK = new JButton("\u786E\u8BA4\u4FEE\u6539");
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		OK.setBounds(25, 175, 93, 23);
		contentPane.add(OK);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		reset.setBounds(150, 175, 93, 23);
		contentPane.add(reset);
	}
	
	private void check() {
		UserDAO userDAO = (UserDAO) BaseDAO.getAbilityDAO(DAO.UserDAO);
		User u1=new User();
		u1.setUsername(username.getText());
		u1.setPassword(String.valueOf(password.getPassword()));
		if (userDAO.update(u1)) {
			JOptionPane.showMessageDialog(this,"修改成功");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this,"用户名或密码错误");
			username.setText("");
			password.setText("");
		}
	}
	
}
