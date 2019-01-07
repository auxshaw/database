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

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	public static int right=0;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(80, 60, 70, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(80, 110, 70, 30);
		contentPane.add(label_1);
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.BOLD, 14));
		username.setBounds(170, 60, 140, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		login.setFont(new Font("黑体", Font.PLAIN, 14));
		login.setBounds(100, 200, 90, 25);
		contentPane.add(login);

		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		reset.setFont(new Font("黑体", Font.PLAIN, 14));
		reset.setBounds(240, 200, 90, 25);
		contentPane.add(reset);
		
		password = new JPasswordField();
		password.setBounds(170, 110, 140, 30);
		contentPane.add(password);
		
		right=0;
				
		JRadioButton admin = new JRadioButton("\u7BA1\u7406\u5458");
		admin.setSelected(true);
		admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				right=0;
			}
		});
		admin.setBounds(120, 161, 70, 23);
		contentPane.add(admin);
		
		JRadioButton user = new JRadioButton("\u666E\u901A\u7528\u6237");
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				right=1;
			}
		});
		user.setBounds(240, 161, 90, 23);
		contentPane.add(user);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(user);
		bg.add(admin);
		// enter key listener
//		password.addKeyListener(new LoginListener());
	}
	
//	private class LoginListener extends KeyAdapter {
//
//		@Override
//		public void keyPressed(KeyEvent e) {
//			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//				check();
//			}
//		}
//	}	
	
	private void check() {
		UserDAO userDAO = (UserDAO) BaseDAO.getAbilityDAO(DAO.UserDAO);
		if (userDAO.queryForLogin(username.getText(), String.valueOf(password.getPassword()), right)) {
			JOptionPane.showMessageDialog(this,"登录成功");
			dispose();
			Main frame2 = new Main();
			frame2.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,"用户名或密码错误");
			username.setText("");
			password.setText("");
		}
	}
}

