package supplier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.SupplierDAO;
import model.Goods;
import model.Supplier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Updatesupplier extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField telephone;
	SupplierDAO sudao=new SupplierDAO();


	/**
	 * Create the frame.
	 */
	public Updatesupplier() {
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 324);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F9B\u5E94\u5546\u7F16\u53F7\uFF1A");
		label.setBounds(48, 27, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0\uFF1A");
		label_1.setBounds(47, 61, 80, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5730\u5740\uFF1A");
		label_2.setBounds(48, 97, 64, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_3.setBounds(48, 137, 74, 15);
		contentPane.add(label_3);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(132, 24, 171, 21);
		contentPane.add(id);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(132, 58, 171, 21);
		contentPane.add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(132, 94, 171, 21);
		contentPane.add(address);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(132, 134, 171, 21);
		contentPane.add(telephone);
		
		JButton button_select = new JButton("\u67E5\u8BE2");
		button_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upquery();
			}
		});
		button_select.setBounds(57, 194, 93, 23);
		contentPane.add(button_select);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				address.setText("");
				telephone.setText("");
				id.setEditable(true);
			}
		});
		reset.setBounds(199, 194, 93, 23);
		contentPane.add(reset);
		
		JButton button_update = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up();
			}
		});
		button_update.setBounds(57, 235, 93, 23);
		contentPane.add(button_update);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(199, 235, 93, 23);
		contentPane.add(button_exit);
	}
	
	private void upquery() {
		String s=id.getText();
		Supplier supplier=new Supplier();
		List<Supplier> list=sudao.querybyid(s);
		for(int i = 0; i < list.size(); i++) {
			supplier=list.get(0);
		}
		try {
			if(sudao.queryBySupplierid(s)==1) {
				name.setText(supplier.getSuppliername());
				address.setText(supplier.getAddress());				
				telephone.setText(supplier.getTelephone());				
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
		Supplier s=new Supplier();
		s.setSupplierid(id.getText());
		s.setSuppliername(name.getText());
		s.setAddress(address.getText());
		s.setTelephone(telephone.getText());
		if(sudao.update(s)) {
			JOptionPane.showMessageDialog(this,"修改成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"修改失败");
		}
	}

}
