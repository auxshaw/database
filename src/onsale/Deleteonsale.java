package onsale;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.OnsaleDAO;
import model.Onsale;
import model.Shelf;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deleteonsale extends JFrame {

	private JPanel contentPane;
	OnsaleDAO onsdao=new OnsaleDAO();
	private JTextField shid;
	private JTextField gid;


	/**
	 * Create the frame.
	 */
	public Deleteonsale() {
		setTitle("\u5220\u9664\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 221);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(46, 28, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_1.setBounds(45, 62, 80, 15);
		contentPane.add(label_1);
		
		shid = new JTextField();
		shid.setColumns(10);
		shid.setBounds(130, 25, 171, 21);
		contentPane.add(shid);
		
		gid = new JTextField();
		gid.setColumns(10);
		gid.setBounds(130, 59, 171, 21);
		contentPane.add(gid);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onsdelete();
			}
		});
		button_delete.setBounds(56, 121, 93, 23);
		contentPane.add(button_delete);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(195, 121, 93, 23);
		contentPane.add(button_exit);
	}

	private void onsdelete() {
		Onsale onsale1=new Onsale();
		onsale1.setShelfid(shid.getText());
		onsale1.setGoodsid(gid.getText());
		if(onsdao.delete(onsale1)) {
			JOptionPane.showMessageDialog(this,"É¾³ý³É¹¦");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"É¾³ýÊ§°Ü");
		}
	}
}
