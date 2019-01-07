package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import base.GoodsDAO;
import model.Goods;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Goodsview extends JFrame {
	
	private String[] rowName = { "商品编号", "商品名称", "类型", "价格", "生产日期", "库存量"};//从这里开始是二维数组的遍历使用
	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	private JScrollPane scrollPane;
	GoodsDAO gdao = new GoodsDAO();


	/**
	 * Create the frame.
	 */
	public Goodsview() {
		setTitle("\u5546\u54C1\u4FE1\u606F\u8868");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
		
		List<Goods> list =gdao.queryAll();
		Object[][] data = new Object[list.size()][rowName.length];
		for (int i = 0; i < list.size(); i++) {
		Goods go = list.get(i);
		Object st[] = { go.getGoodsid(),go.getGoodsname(),go.getGoodstype(),go.getPrice(),go.getProductiondate(),go.getStocksize() };
		data[i] = st;
		}
		table_1 = new JTable(model);//用数据模型创建JTable
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1 .getTableHeader().setReorderingAllowed(false);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(50, 60, 680, 430);
		contentPane.add(scrollPane);
		model.setDataVector( data, rowName); 
		
		String[] gs= {"商品编号", "商品名称","类型", "库存量"};
		JComboBox comboBox = new JComboBox(gs);
		comboBox.setBounds(50, 10, 81, 25);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(141, 11, 70, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton query_b = new JButton("\u67E5\u8BE2");
		query_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("商品编号")) {
					
					List<Goods> gid =gdao.querybyGOODSID(textField.getText());
					Object[][] data = new Object[gid.size()][rowName.length];
					for (int i = 0; i < gid.size(); i++) {
					Goods go = gid.get(i);
					Object st[] = { go.getGoodsid(),go.getGoodsname(),go.getGoodstype(),go.getPrice(),go.getProductiondate(),go.getStocksize() };
					data[i] = st;
					}
					model.setDataVector( data, rowName); 
				}
				else if (comboBox.getSelectedItem().equals("商品名称")) {
					List<Goods> gid =gdao.querybyGoodsname(textField.getText());
					Object[][] data = new Object[gid.size()][rowName.length];
					for (int i = 0; i < gid.size(); i++) {
					Goods go = gid.get(i);
					Object st[] = { go.getGoodsid(),go.getGoodsname(),go.getGoodstype(),go.getPrice(),go.getProductiondate(),go.getStocksize() };
					data[i] = st;
					}
					model.setDataVector( data, rowName); 
				}
				else if(comboBox.getSelectedItem().equals("类型")) {
					List<Goods> gid =gdao.querybyGoodstype(textField.getText());
					Object[][] data = new Object[gid.size()][rowName.length];
					for (int i = 0; i < gid.size(); i++) {
					Goods go = gid.get(i);
					Object st[] = { go.getGoodsid(),go.getGoodsname(),go.getGoodstype(),go.getPrice(),go.getProductiondate(),go.getStocksize() };
					data[i] = st;
					}
					model.setDataVector( data, rowName); 
				}
				else if(comboBox.getSelectedItem().equals("库存量")) {
					String str=textField.getText();
					str=num(str);
					int size=0;
					try {
						size=Integer.parseInt(str);
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();
					}
					List<Goods> gid =gdao.querybyStocksize(size);
					Object[][] data = new Object[gid.size()][rowName.length];
					for (int i = 0; i < gid.size(); i++) {
					Goods go = gid.get(i);
					Object st[] = { go.getGoodsid(),go.getGoodsname(),go.getGoodstype(),go.getPrice(),go.getProductiondate(),go.getStocksize() };
					data[i] = st;
					}
					model.setDataVector( data, rowName); 
				}
			}
		});
		query_b.setBounds(239, 11, 93, 23);
		contentPane.add(query_b);
		
		JButton update_b = new JButton("\u4FEE\u6539");
		update_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updategoods upframe=new Updategoods();
				upframe.setVisible(true);
			}
		});
		update_b.setBounds(368, 11, 93, 23);
		contentPane.add(update_b);
		
		JButton add_b = new JButton("\u6DFB\u52A0");
		add_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addgoods agframe=new addgoods();
				agframe.setVisible(true);
			}
		});
		add_b.setBounds(498, 11, 93, 23);
		contentPane.add(add_b);
		
		JButton delete_b = new JButton("\u5220\u9664");
		delete_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletegoods dgframe=new Deletegoods();
				dgframe.setVisible(true);
			}
		});
		delete_b.setBounds(637, 11, 93, 23);
		contentPane.add(delete_b);
		
		JButton queryall_b = new JButton("\u67E5\u8BE2\u5168\u90E8");
		queryall_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Goods> list1 =gdao.queryAll();
				Object[][] data = new Object[list1.size()][rowName.length];
				for (int i = 0; i < list1.size(); i++) {
				Goods go = list1.get(i);
				Object st[] = { go.getGoodsid(),go.getGoodsname(),go.getGoodstype(),go.getPrice(),go.getProductiondate(),go.getStocksize() };
				data[i] = st;
				}
				model.setDataVector( data, rowName); 
			}
		});
		queryall_b.setBounds(340, 515, 93, 23);
		contentPane.add(queryall_b);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(660, 515, 93, 23);
		contentPane.add(button);
		
		if(Login.right==1) {
			update_b.setVisible(false);
			add_b.setVisible(false);
			delete_b.setVisible(false);
		}
		
	}
	
	private String num(String name) {
	    Pattern p = Pattern.compile("[^0-9]");
	    Matcher m = p.matcher(name);
	    name = m.replaceAll("").trim();
	    return name;
	}
	
}
