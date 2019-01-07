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

public class Addsupply extends JFrame {

	private JPanel contentPane;
	private JTextField gid;
	private JTextField suid;
	SupplyDAO supdao=new SupplyDAO();


	/**
	 * Create the frame.
	 */
	public Addsupply() {
		setTitle("\u6DFB\u52A0\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 270);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(46, 33, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u7F16\u53F7\uFF1A");
		label_1.setBounds(45, 67, 80, 15);
		contentPane.add(label_1);
		
		gid = new JTextField();
		gid.setColumns(10);
		gid.setBounds(130, 30, 171, 21);
		contentPane.add(gid);
		
		suid = new JTextField();
		suid.setColumns(10);
		suid.setBounds(130, 64, 171, 21);
		contentPane.add(suid);
		
		JButton button_reset = new JButton("\u91CD\u7F6E");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gid.setText("");
				suid.setText("");
			}
		});
		button_reset.setBounds(198, 131, 93, 23);
		contentPane.add(button_reset);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supinsert();
			}
		});
		button_add.setBounds(58, 131, 93, 23);
		contentPane.add(button_add);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(130, 174, 93, 23);
		contentPane.add(button_exit);
	}
	
	private void supinsert() {
		Supply s1=new Supply();
		s1.setGoodsid(gid.getText());
		s1.setSupplierid(suid.getText());
		if(supdao.add(s1)) {
			JOptionPane.showMessageDialog(this,"添加成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"添加失败");
		}
	}

}
