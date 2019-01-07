package supply;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import base.SupplyDAO;
import model.Supplier;
import model.Supply;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supplyview extends JFrame {

	private String[] rowName = {"商品编号", "商品名称","供应商编号","供应商名称"};
	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	SupplyDAO supdao=new SupplyDAO();



	/**
	 * Create the frame.
	 */
	public Supplyview() {
		setTitle("\u4F9B\u5E94\u4FE1\u606F\u8868");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 784, 561);
		contentPane.add(panel);
		
		DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
		
		List<Supply> list =supdao.queryAll();
		Object[][] data = new Object[list.size()][rowName.length];
		for (int i = 0; i < list.size(); i++) {
			Supply su = list.get(i);
			Object st[] = { su.getGoodsid(),su.getGoodsname(),su.getSupplierid(),su.getSuppliername() };
			data[i] = st;
		}
		table_1 = new JTable(model);//用数据模型创建JTable
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1 .getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(50, 60, 680, 430);
		panel.add(scrollPane);
		model.setDataVector( data, rowName); 
		
		String[] sub= {"商品编号" ,"供应商编号"};
		JComboBox comboBox = new JComboBox(sub);
		comboBox.setBounds(50, 10, 99, 25);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(175, 10, 70, 25);
		panel.add(textField);
		
		JButton button_select = new JButton("\u67E5\u8BE2");
		button_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("商品编号")) {
					List<Supply> list =supdao.querybygid(textField.getText());
					Object[][] data = new Object[list.size()][rowName.length];
					for (int i = 0; i < list.size(); i++) {
						Supply su = list.get(i);
						Object st[] = { su.getGoodsid(),su.getGoodsname(),su.getSupplierid(),su.getSuppliername() };
						data[i] = st;
					}
					model.setDataVector( data, rowName); 
				}else if(comboBox.getSelectedItem().equals("供应商编号")) {
					List<Supply> list =supdao.querybysuid(textField.getText());
					Object[][] data = new Object[list.size()][rowName.length];
					for (int i = 0; i < list.size(); i++) {
						Supply su = list.get(i);
						Object st[] = { su.getGoodsid(),su.getGoodsname(),su.getSupplierid(),su.getSuppliername() };
						data[i] = st;
					}
					model.setDataVector( data, rowName); 
				}
			}
		});
		button_select.setBounds(275, 11, 93, 23);
		panel.add(button_select);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addsupply asupframe=new Addsupply();
				asupframe.setVisible(true);
			}
		});
		button_add.setBounds(440, 11, 93, 23);
		panel.add(button_add);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletesupply dsupframe=new Deletesupply();
				dsupframe.setVisible(true);
			}
		});
		button_delete.setBounds(584, 11, 93, 23);
		panel.add(button_delete);
		
		JButton button_queryAll = new JButton("\u67E5\u8BE2\u5168\u90E8");
		button_queryAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Supply> list =supdao.queryAll();
				Object[][] data = new Object[list.size()][rowName.length];
				for (int i = 0; i < list.size(); i++) {
					Supply su = list.get(i);
					Object st[] = { su.getGoodsid(),su.getGoodsname(),su.getSupplierid(),su.getSuppliername() };
					data[i] = st;
				}
				model.setDataVector( data, rowName); 
			}
		});
		button_queryAll.setBounds(340, 515, 93, 23);
		panel.add(button_queryAll);
		
		JButton button_eixt = new JButton("\u9000\u51FA");
		button_eixt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_eixt.setBounds(660, 515, 93, 23);
		panel.add(button_eixt);
	}

}
