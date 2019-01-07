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
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Updateshelf extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField location;
	ShelfDAO shdao=new ShelfDAO();



	/**
	 * Create the frame.
	 */
	public Updateshelf() {
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 275);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(66, 40, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D27\u67B6\u4F4D\u7F6E\uFF1A");
		label_1.setBounds(65, 74, 80, 15);
		contentPane.add(label_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(150, 37, 171, 21);
		contentPane.add(id);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(150, 71, 171, 21);
		contentPane.add(location);
		
		JButton button_select = new JButton("\u67E5\u8BE2");
		button_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upquery();
			}
		});
		button_select.setBounds(76, 138, 93, 23);
		contentPane.add(button_select);
		
		JButton button_reset = new JButton("\u91CD\u7F6E");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				location.setText("");
				id.setEditable(true);
			}
		});
		button_reset.setBounds(218, 138, 93, 23);
		contentPane.add(button_reset);
		
		JButton button_update = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up();
			}
		});
		button_update.setBounds(76, 179, 93, 23);
		contentPane.add(button_update);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(218, 179, 93, 23);
		contentPane.add(button_exit);
	}

	private void upquery() {
		String s=id.getText();
		Shelf shelf=new Shelf();
		List<Shelf> list =shdao.querybyid(s);
		for(int i = 0; i < list.size(); i++) {
			shelf=list.get(0);
		}
		try {
			if(shdao.queryByShelfid(s)==1) {
				location.setText(shelf.getShelflocation());			
				id.setEditable(false);
			}
			else {
				JOptionPane.showMessageDialog(this,"查询失败");
				id.setText("");
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}
	
	private void up() {
		Shelf shelf1=new Shelf();
		shelf1.setShelfid(id.getText());
		shelf1.setShelflocation(location.getText());
		if(shdao.update(shelf1)) {
			JOptionPane.showMessageDialog(this,"修改成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"修改失败");
		}
	}
}
