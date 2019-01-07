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

public class Addonsale extends JFrame {

	private JPanel contentPane;
	OnsaleDAO onsdao=new OnsaleDAO();
	private JTextField shid;
	private JTextField gid;
	private JTextField location;


	/**
	 * Create the frame.
	 */
	public Addonsale() {
		setTitle("\u6DFB\u52A0\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 291);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(53, 27, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_1.setBounds(52, 61, 80, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u4F4D\u7F6E");
		label_2.setBounds(53, 97, 64, 15);
		contentPane.add(label_2);
		
		shid = new JTextField();
		shid.setColumns(10);
		shid.setBounds(137, 24, 171, 21);
		contentPane.add(shid);
		
		gid = new JTextField();
		gid.setColumns(10);
		gid.setBounds(137, 58, 171, 21);
		contentPane.add(gid);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(137, 94, 171, 21);
		contentPane.add(location);
		
		JButton button_reset = new JButton("\u91CD\u7F6E");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shid.setText("");
				gid.setText("");
				location.setText("");
				shid.setEditable(true);
				gid.setEditable(true);
			}
		});
		button_reset.setBounds(204, 145, 93, 23);
		contentPane.add(button_reset);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onsinsert();
			}
		});
		button_add.setBounds(63, 145, 93, 23);
		contentPane.add(button_add);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(131, 192, 93, 23);
		contentPane.add(button_exit);
	}
	
	private void onsinsert() {
		Onsale onsale1=new Onsale();
		onsale1.setShelfid(shid.getText());
		onsale1.setGoodsid(gid.getText());
		onsale1.setGoodslocation(location.getText());
		if(onsdao.add(onsale1)) {
			JOptionPane.showMessageDialog(this,"添加成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"添加失败");
		}
	}
}
