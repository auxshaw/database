package supplier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.SupplierDAO;
import model.Supplier;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deletesupplier extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	SupplierDAO sudao=new SupplierDAO();


	/**
	 * Create the frame.
	 */
	public Deletesupplier() {
		setTitle("\u5220\u9664\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 247);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sudelete();
			}
		});
		button_delete.setBounds(50, 140, 93, 23);
		contentPane.add(button_delete);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(212, 140, 93, 23);
		contentPane.add(button_exit);
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(50, 34, 74, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(49, 68, 74, 15);
		contentPane.add(label_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(134, 31, 171, 21);
		contentPane.add(id);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(134, 65, 171, 21);
		contentPane.add(name);
	}

	private void sudelete() {
		Supplier s=new Supplier();
		s.setSupplierid(id.getText());
		s.setSuppliername(name.getText());
		if(sudao.delete(s)) {
			JOptionPane.showMessageDialog(this,"É¾³ý³É¹¦");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"É¾³ýÊ§°Ü");
		}
	}
}
