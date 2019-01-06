package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

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

public class Goodsview extends JFrame {
	
	private String[] rowName = { "商品编号", "商品名称", "类型", "价格", "生产日期", "库存量"};//从这里开始是二维数组的遍历使用
	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	private JScrollPane scrollPane;
	GoodsDAO gdao = new GoodsDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Goodsview frame = new Goodsview();
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
	public Goodsview() {
		setTitle("\u5546\u54C1\u4FE1\u606F\u8868");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		table_1 .getTableHeader().setReorderingAllowed(false);
		table_1.setRowSelectionAllowed(false);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(50, 60, 680, 430);
		contentPane.add(scrollPane);
		model.setDataVector( data, rowName); 
		
		String[] gs= {"商品编号", "商品名称"};
		JComboBox comboBox = new JComboBox(gs);
		comboBox.setBounds(50, 10, 81, 25);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(141, 11, 70, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
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
			}
		});
		button.setBounds(239, 11, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBounds(368, 11, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6DFB\u52A0");
		button_2.setBounds(498, 11, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u5220\u9664");
		button_3.setBounds(637, 11, 93, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setDataVector( data, rowName); 
			}
		});
		button_4.setBounds(340, 515, 93, 23);
		contentPane.add(button_4);
		
	}
	
}
