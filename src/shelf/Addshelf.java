package shelf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.ShelfDAO;
import model.Shelf;
import model.Supplier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addshelf extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField location;
	ShelfDAO shdao=new ShelfDAO();



	/**
	 * Create the frame.
	 */
	public Addshelf() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 280);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(49, 33, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D27\u67B6\u4F4D\u7F6E\uFF1A");
		label_1.setBounds(48, 67, 80, 15);
		contentPane.add(label_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(133, 30, 171, 21);
		contentPane.add(id);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(133, 64, 171, 21);
		contentPane.add(location);
		
		JButton button_reset = new JButton("\u91CD\u7F6E");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				location.setText("");
			}
		});
		button_reset.setBounds(201, 131, 93, 23);
		contentPane.add(button_reset);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shinsert();
			}
		});
		button_add.setBounds(61, 131, 93, 23);
		contentPane.add(button_add);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(133, 174, 93, 23);
		contentPane.add(button_exit);
	}
	
	private void shinsert() {
		Shelf shelf1=new Shelf();
		shelf1.setShelfid(id.getText());
		shelf1.setShelflocation(location.getText());
		if(shdao.add(shelf1)) {
			JOptionPane.showMessageDialog(this,"添加成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"添加失败");
		}
	}

}
