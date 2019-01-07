package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.GoodsDAO;
import model.Goods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class Deletegoods extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	GoodsDAO godao = new GoodsDAO();


	/**
	 * Create the frame.
	 */
	public Deletegoods() {
		setTitle("\u5220\u9664");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton delete_b = new JButton("\u5220\u9664");
		delete_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteg();
			}
		});
		delete_b.setBounds(36, 155, 93, 23);
		contentPane.add(delete_b);
		
		JButton exit_b = new JButton("\u9000\u51FA");
		exit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit_b.setBounds(198, 155, 93, 23);
		contentPane.add(exit_b);
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(36, 49, 74, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(35, 83, 74, 15);
		contentPane.add(label_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(120, 46, 171, 21);
		contentPane.add(id);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(120, 80, 171, 21);
		contentPane.add(name);
	}

	private void deleteg() {
		Goods g=new Goods();
		g.setGoodsid(id.getText());
		g.setGoodsname(name.getText());
		if(godao.delete(g)) {
			JOptionPane.showMessageDialog(this,"É¾³ý³É¹¦");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"É¾³ýÊ§°Ü");
		}
	}
}
