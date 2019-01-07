package supply;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.SupplyDAO;
import model.Shelf;
import model.Supply;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deletesupply extends JFrame {

	private JPanel contentPane;
	private JTextField gid;
	private JTextField suid;
	SupplyDAO supdao=new SupplyDAO();


	/**
	 * Create the frame.
	 */
	public Deletesupply() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 234);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(47, 29, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u7F16\u53F7\uFF1A");
		label_1.setBounds(46, 63, 80, 15);
		contentPane.add(label_1);
		
		gid = new JTextField();
		gid.setColumns(10);
		gid.setBounds(131, 26, 171, 21);
		contentPane.add(gid);
		
		suid = new JTextField();
		suid.setColumns(10);
		suid.setBounds(131, 60, 171, 21);
		contentPane.add(suid);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supdelete();
			}
		});
		button_delete.setBounds(59, 127, 93, 23);
		contentPane.add(button_delete);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(198, 127, 93, 23);
		contentPane.add(button_exit);
	}

	private void supdelete() {
		Supply s1=new Supply();
		s1.setGoodsid(gid.getText());
		s1.setSupplierid(suid.getText());
		if(supdao.delete(s1)) {
			JOptionPane.showMessageDialog(this,"É¾³ý³É¹¦");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"É¾³ýÊ§°Ü");
		}
	}
}
