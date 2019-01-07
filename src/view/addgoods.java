package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.GoodsDAO;
import model.Goods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class addgoods extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField type;
	private JTextField price;
	private JTextField date;
	private JTextField size;
	private static int size1;
	GoodsDAO godao = new GoodsDAO();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					addgoods frame = new addgoods();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public addgoods() {
		setTitle("\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 378);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(29, 24, 74, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(28, 58, 74, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7C7B\u578B\uFF1A");
		label_2.setBounds(29, 94, 64, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		label_3.setBounds(29, 134, 64, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_4.setBounds(29, 171, 74, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5E93\u5B58\u91CF\uFF1A");
		label_5.setBounds(29, 207, 70, 15);
		contentPane.add(label_5);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(113, 21, 171, 21);
		contentPane.add(id);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(113, 55, 171, 21);
		contentPane.add(name);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(113, 91, 171, 21);
		contentPane.add(type);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(113, 131, 171, 21);
		contentPane.add(price);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(113, 168, 171, 21);
		contentPane.add(date);
		
		size = new JTextField();
		size.setColumns(10);
		size.setBounds(113, 204, 171, 21);
		contentPane.add(size);
		
		JButton add_b = new JButton("\u6DFB\u52A0");
		add_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		add_b.setBounds(29, 250, 93, 23);
		contentPane.add(add_b);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				type.setText("");
				price.setText("");
				date.setText("");
				size.setText("");
			}
		});
		reset.setBounds(171, 250, 93, 23);
		contentPane.add(reset);
		
		JButton exit_b = new JButton("\u9000\u51FA");
		exit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit_b.setBounds(99, 293, 93, 23);
		contentPane.add(exit_b);
	}

	private void insert() {
		Goods g=new Goods();
		g.setGoodsid(id.getText());
		g.setGoodsname(name.getText());
		g.setGoodstype(type.getText());
		
//		String tmpstr=pr(price.getText());
		String tmpstr=price.getText();
		BigDecimal pri = new BigDecimal(tmpstr);			
		g.setPrice(pri);
		
		g.setProductiondate(date.getText());
		
		String st=num(size.getText());				
		try {
			size1=Integer.parseInt(st);
		} catch (NumberFormatException e1) {
		    e1.printStackTrace();
		}
		g.setStocksize(size1);
		if(godao.add(g)) {
			JOptionPane.showMessageDialog(this,"添加成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"添加失败");
		}
	}
	
	private String num(String name) {
	    Pattern p = Pattern.compile("[^0-9]");
	    Matcher m = p.matcher(name);
	    name = m.replaceAll("").trim();
	    return name;
	}
}
