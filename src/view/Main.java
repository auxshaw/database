package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.BaseDAO;
import base.DAO;
import base.UserDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main frame = new Main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton goods = new JButton("\u5546\u54C1\u4FE1\u606F\u8868");
		goods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		goods.setBounds(44, 98, 110, 30);
		contentPane.add(goods);
		
		JButton supplier = new JButton("\u4F9B\u5E94\u5546\u4FE1\u606F\u8868");
		supplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		supplier.setBounds(44, 200, 110, 30);
		contentPane.add(supplier);
		
		JButton shelf = new JButton("\u8D27\u67B6\u4FE1\u606F\u8868");
		shelf.setBounds(392, 98, 110, 30);
		contentPane.add(shelf);
		
		JButton goodslocation = new JButton("\u5546\u54C1\u4F4D\u7F6E\u8868");
		goodslocation.setBounds(219, 98, 110, 30);
		contentPane.add(goodslocation);
		
		JButton supply = new JButton("\u4F9B\u5E94\u5BF9\u7167\u8868");
		supply.setBounds(219, 200, 110, 30);
		contentPane.add(supply);
		
		JButton onsale = new JButton("\u4E0A\u67B6\u5BF9\u7167\u8868");
		onsale.setBounds(392, 200, 110, 30);
		contentPane.add(onsale);
		
		JButton updatepassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		updatepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updatepass up=new Updatepass();
				up.setVisible(true);
			}
		});
		updatepassword.setBounds(151, 302, 93, 23);
		contentPane.add(updatepassword);
		
		JButton loginout = new JButton("\u9000\u51FA\u767B\u5F55");
		loginout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out();
			}
		});
		loginout.setBounds(293, 302, 93, 23);
		contentPane.add(loginout);
		
		if(Login.right==1) {
			supplier.setVisible(false);
			supply.setVisible(false);
			onsale.setVisible(false);
			updatepassword.setEnabled(false);
		}
	}
	
	private void out() {
			JOptionPane.showMessageDialog(this,"ÍË³öµÇÂ¼");
			dispose();
			Login lo = new Login();
			lo.setVisible(true);
	}
}
