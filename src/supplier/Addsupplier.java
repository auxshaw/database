package supplier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.SupplierDAO;
import model.Supplier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addsupplier extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField telephone;
	SupplierDAO sudao=new SupplierDAO();


	/**
	 * Create the frame.
	 */
	public Addsupplier() {
		setTitle("\u6DFB\u52A0\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 341);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F9B\u5E94\u5546\u7F16\u53F7\uFF1A");
		label.setBounds(51, 23, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0\uFF1A");
		label_1.setBounds(50, 57, 80, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5730\u5740\uFF1A");
		label_2.setBounds(51, 93, 64, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_3.setBounds(51, 133, 74, 15);
		contentPane.add(label_3);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(135, 20, 171, 21);
		contentPane.add(id);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(135, 54, 171, 21);
		contentPane.add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(135, 90, 171, 21);
		contentPane.add(address);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(135, 130, 171, 21);
		contentPane.add(telephone);
		
		JButton button_reset = new JButton("\u91CD\u7F6E");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				address.setText("");
				telephone.setText("");
			}
		});
		button_reset.setBounds(202, 190, 93, 23);
		contentPane.add(button_reset);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sinsert();
			}
		});
		button_add.setBounds(51, 190, 93, 23);
		contentPane.add(button_add);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(125, 234, 93, 23);
		contentPane.add(button_exit);
	}
	
	private void sinsert() {
		Supplier s=new Supplier();
		s.setSupplierid(id.getText());
		s.setSuppliername(name.getText());
		s.setAddress(address.getText());
		s.setTelephone(telephone.getText());
		if(sudao.add(s)) {
			JOptionPane.showMessageDialog(this,"添加成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"添加失败");
		}
	}

}
