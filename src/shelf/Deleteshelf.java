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

public class Deleteshelf extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	ShelfDAO shdao=new ShelfDAO();


	/**
	 * Create the frame.
	 */
	public Deleteshelf() {
		setTitle("\u5220\u9664\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 371, 219);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(48, 31, 80, 15);
		contentPane.add(label);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(132, 28, 171, 21);
		contentPane.add(id);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shdelete();
			}
		});
		button_delete.setBounds(60, 101, 93, 23);
		contentPane.add(button_delete);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(201, 101, 93, 23);
		contentPane.add(button_exit);
	}

	private void shdelete() {
		Shelf shelf1=new Shelf();
		shelf1.setShelfid(id.getText());
		if(shdao.delete(shelf1)) {
			JOptionPane.showMessageDialog(this,"É¾³ý³É¹¦");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"É¾³ýÊ§°Ü");
		}
	}
}
