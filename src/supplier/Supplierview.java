package supplier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import base.SupplierDAO;
import model.Goods;
import model.Supplier;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supplierview extends JFrame {

	private String[] rowName = { "供应商编号", "供应商名称", "地址", "联系方式"};//从这里开始是二维数组的遍历使用
	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	SupplierDAO sudao=new SupplierDAO();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Supplierview frame = new Supplierview();
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
	public Supplierview() {
		setTitle("\u4F9B\u5E94\u5546\u4FE1\u606F\u8868");
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
		
		List<Supplier> list =sudao.queryAll();
		Object[][] data = new Object[list.size()][rowName.length];
		for (int i = 0; i < list.size(); i++) {
			Supplier su = list.get(i);
		Object st[] = { su.getSupplierid(),su.getSuppliername(),su.getAddress(),su.getTelephone() };
		data[i] = st;
		}
		table_1 = new JTable(model);//用数据模型创建JTable
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1 .getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(50, 60, 680, 430);
		panel.add(scrollPane);
		model.setDataVector( data, rowName); 
		
		String[] sb= {"供应商编号", "供应商名称"};
		JComboBox comboBox = new JComboBox(sb);
		comboBox.setBounds(50, 10, 99, 25);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(159, 10, 70, 25);
		panel.add(textField);
		
		JButton button_select = new JButton("\u67E5\u8BE2");
		button_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("供应商编号")) {
					List<Supplier> list =sudao.querybyid(textField.getText());
					Object[][] data = new Object[list.size()][rowName.length];
					for (int i = 0; i < list.size(); i++) {
						Supplier su = list.get(i);
						Object st[] = { su.getSupplierid(),su.getSuppliername(),su.getAddress(),su.getTelephone() };
						data[i] = st;
						}
					model.setDataVector( data, rowName); 
				}else if(comboBox.getSelectedItem().equals("供应商名称")) {
					List<Supplier> list =sudao.querybyname(textField.getText());
					Object[][] data = new Object[list.size()][rowName.length];
					for (int i = 0; i < list.size(); i++) {
						Supplier su = list.get(i);
						Object st[] = { su.getSupplierid(),su.getSuppliername(),su.getAddress(),su.getTelephone() };
						data[i] = st;
						}
					model.setDataVector( data, rowName); 
				}
			}
		});
		button_select.setBounds(239, 11, 93, 23);
		panel.add(button_select);
		
		JButton button_update = new JButton("\u4FEE\u6539");
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updatesupplier usframe=new Updatesupplier();
				usframe.setVisible(true);
			}
		});
		button_update.setBounds(368, 11, 93, 23);
		panel.add(button_update);
		
		JButton button_add = new JButton("\u6DFB\u52A0");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addsupplier asframe=new Addsupplier();
				asframe.setVisible(true);
			}
		});
		button_add.setBounds(498, 11, 93, 23);
		panel.add(button_add);
		
		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletesupplier dsframe=new Deletesupplier();
				dsframe.setVisible(true);
			}
		});
		button_delete.setBounds(637, 11, 93, 23);
		panel.add(button_delete);
		
		JButton button_queryAll = new JButton("\u67E5\u8BE2\u5168\u90E8");
		button_queryAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Supplier> list =sudao.queryAll();
				Object[][] data = new Object[list.size()][rowName.length];
				for (int i = 0; i < list.size(); i++) {
					Supplier su = list.get(i);
				Object st[] = { su.getSupplierid(),su.getSuppliername(),su.getAddress(),su.getTelephone() };
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
	}
}
