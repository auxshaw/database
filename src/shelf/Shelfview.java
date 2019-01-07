package shelf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import base.ShelfDAO;
import model.Shelf;
import model.Supplier;
import view.Login;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shelfview extends JFrame {

	private String[] rowName = { "货架编号", "货架位置"};//从这里开始是二维数组的遍历使用
	private JPanel contentPane;
	private JTextField id;
	private JTable table_1;
	ShelfDAO shdao=new ShelfDAO();


	/**
	 * Create the frame.
	 */
	public Shelfview() {
		setTitle("\u8D27\u67B6\u4FE1\u606F\u8868");
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
		
		List<Shelf> list =shdao.queryAll();
		Object[][] data = new Object[list.size()][rowName.length];
		for (int i = 0; i < list.size(); i++) {
			Shelf sh = list.get(i);
		Object st[] = { sh.getShelfid(),sh.getShelflocation()};
		data[i] = st;
		}
		table_1 = new JTable(model);//用数据模型创建JTable
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1 .getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(50, 60, 680, 430);
		panel.add(scrollPane);
		model.setDataVector( data, rowName);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(141, 11, 70, 25);
		panel.add(id);
		
		JButton button_select = new JButton("\u67E5\u8BE2");
		button_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Shelf> list =shdao.querybyid(id.getText());
				Object[][] data = new Object[list.size()][rowName.length];
				for (int i = 0; i < list.size(); i++) {
					Shelf sh = list.get(i);
				Object st[] = { sh.getShelfid(),sh.getShelflocation()};
				data[i] = st;
				}
				model.setDataVector( data, rowName);
			}
		});
		button_select.setBounds(239, 11, 93, 23);
		panel.add(button_select);
		
		JButton button_update = new JButton("\u4FEE\u6539");
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updateshelf upshframe=new Updateshelf();
				upshframe.setVisible(true);
			}
		});
		button_update.setBounds(368, 11, 93, 23);
		panel.add(button_update);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addshelf ashframe=new Addshelf();
				ashframe.setVisible(true);
			}
		});
		button_add.setBounds(498, 11, 93, 23);
		panel.add(button_add);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deleteshelf dshframe=new Deleteshelf();
				dshframe.setVisible(true);
			}
		});
		button_delete.setBounds(637, 11, 93, 23);
		panel.add(button_delete);
		
		JButton button_queryAll = new JButton("\u67E5\u8BE2\u5168\u90E8");
		button_queryAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Shelf> list =shdao.queryAll();
				Object[][] data = new Object[list.size()][rowName.length];
				for (int i = 0; i < list.size(); i++) {
					Shelf sh = list.get(i);
				Object st[] = { sh.getShelfid(),sh.getShelflocation()};
				data[i] = st;
				}
				model.setDataVector( data, rowName);
			}
		});
		button_queryAll.setBounds(340, 515, 93, 23);
		panel.add(button_queryAll);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setBounds(660, 515, 93, 23);
		panel.add(button_exit);
		
		JLabel label = new JLabel("\u8D27\u67B6\u7F16\u53F7\uFF1A");
		label.setBounds(50, 16, 72, 15);
		panel.add(label);
		
		if(Login.right==1) {
			button_update.setVisible(false);
			button_add.setVisible(false);
			button_delete.setVisible(false);
		}
	}

}
