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
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Updateonsale extends JFrame {

	private JPanel contentPane;
	private JTextField shid;
	private JTextField gid;
	private JTextField location;
	OnsaleDAO onsdao=new OnsaleDAO();



	/**
	 * Create the frame.
	 */
	public Updateonsale() {
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 293);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(53, 28, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_1.setBounds(52, 62, 80, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u4F4D\u7F6E");
		label_2.setBounds(53, 98, 64, 15);
		contentPane.add(label_2);
		
		shid = new JTextField();
		shid.setColumns(10);
		shid.setBounds(137, 25, 171, 21);
		contentPane.add(shid);
		
		gid = new JTextField();
		gid.setColumns(10);
		gid.setBounds(137, 59, 171, 21);
		contentPane.add(gid);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(137, 95, 171, 21);
		contentPane.add(location);
		
		JButton button_select = new JButton("\u67E5\u8BE2");
		button_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upquery();
			}
		});
		button_select.setBounds(62, 146, 93, 23);
		contentPane.add(button_select);
		
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
		button_reset.setBounds(204, 146, 93, 23);
		contentPane.add(button_reset);
		
		JButton button_update = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up();
			}
		});
		button_update.setBounds(62, 194, 93, 23);
		contentPane.add(button_update);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(204, 194, 93, 23);
		contentPane.add(button_exit);
	}

	private void upquery() {
		String sh1=shid.getText();
		String g1=gid.getText();
		Onsale onsale=new Onsale();
		List<Onsale> list =onsdao.querybygidsid(sh1, g1);
		for(int i = 0; i < list.size(); i++) {
			onsale=list.get(0);
		}
		try {
			if(onsdao.queryByOnsale(sh1, g1)==1) {
				location.setText(onsale.getGoodslocation());			
				shid.setEditable(false);
				gid.setEditable(false);
			}
			else {
				JOptionPane.showMessageDialog(this,"查询失败");
				shid.setText("");
				gid.setText("");
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}
	
	private void up() {
		Onsale onsale1=new Onsale();
		onsale1.setShelfid(shid.getText());
		onsale1.setGoodsid(gid.getText());
		onsale1.setGoodslocation(location.getText());
		if(onsdao.update(onsale1)) {
			JOptionPane.showMessageDialog(this,"修改成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"修改失败");
		}
	}	
	
}
