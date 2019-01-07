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
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Updategoods extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField type;
	private JTextField price;
	private JTextField date;
	private JTextField size;
	GoodsDAO godao = new GoodsDAO();
	private static int size1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updategoods frame = new Updategoods();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Updategoods() {
		setTitle("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 361);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(24, 22, 74, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(23, 56, 74, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7C7B\u578B\uFF1A");
		label_2.setBounds(24, 92, 64, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		label_3.setBounds(24, 132, 64, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_4.setBounds(24, 169, 74, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5E93\u5B58\u91CF\uFF1A");
		label_5.setBounds(24, 205, 70, 15);
		contentPane.add(label_5);
		
		id = new JTextField();
		id.setBounds(108, 19, 171, 21);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(108, 53, 171, 21);
		contentPane.add(name);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(108, 89, 171, 21);
		contentPane.add(type);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(108, 129, 171, 21);
		contentPane.add(price);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(108, 166, 171, 21);
		contentPane.add(date);
		
		size = new JTextField();
		size.setColumns(10);
		size.setBounds(108, 202, 171, 21);
		contentPane.add(size);
		
		
		
		JButton select = new JButton("\u67E5\u8BE2");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=id.getText();
				Goods goods=new Goods();
				List<Goods> list=godao.querybyGOODSID(s);
				for(int i = 0; i < list.size(); i++) {
				goods=list.get(0);
				}
				try {
					if(godao.queryByGoodsid(s)==1) {
						name.setText(goods.getGoodsname());
						type.setText(goods.getGoodstype());
						price.setText(String.valueOf(goods.getPrice()));
						date.setText(goods.getProductiondate());
						size.setText(String.valueOf(goods.getStocksize()));
						size1=goods.getStocksize();
						id.setEditable(false);
					}
					else {
						dia();
						id.setText("");
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		select.setBounds(24, 248, 93, 23);
		contentPane.add(select);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				type.setText("");
				price.setText("");
				date.setText("");
				size.setText("");
				id.setEditable(true);
			}
		});
		reset.setBounds(166, 248, 93, 23);
		contentPane.add(reset);
		
		JButton update = new JButton("\u786E\u8BA4\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up();
			}
		});
		update.setBounds(24, 289, 93, 23);
		contentPane.add(update);
		
		JButton exit_b = new JButton("\u9000\u51FA");
		exit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit_b.setBounds(166, 289, 93, 23);
		contentPane.add(exit_b);
	}
	
	private void dia() {
		JOptionPane.showMessageDialog(this,"查询失败");
	}
	
	private void up() {
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
		if(godao.update(g)) {
			JOptionPane.showMessageDialog(this,"修改成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this,"修改失败");
		}
	}
	
	private String num(String name) {
	    Pattern p = Pattern.compile("[^0-9]");
	    Matcher m = p.matcher(name);
	    name = m.replaceAll("").trim();
	    return name;
	}
//	private String pr(String name) {
//	    Pattern p = Pattern.compile("[^0-9.]");
//	    Matcher m = p.matcher(name);
//	    name = m.replaceAll("").trim();
//	    return name;
//	}
}
