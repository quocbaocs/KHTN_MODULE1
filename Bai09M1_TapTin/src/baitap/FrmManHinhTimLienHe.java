package baitap;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class FrmManHinhTimLienHe extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTable tblKetQua;
	private DanhSachLienHe ds;
	private final String FILENAME = "src/baitap/lienhe.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhTimLienHe frame = new FrmManHinhTimLienHe();
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
	public FrmManHinhTimLienHe() {

		ds = new DanhSachLienHe();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// lst = new ArrayList<LienHe>();
		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 53, 69, 30);
		contentPane.add(lblNewLabel);

		txtTen = new JTextField();
		txtTen.setBounds(119, 53, 174, 30);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Hình ảnh");
		model.addColumn("Họ tên");
		model.addColumn("ĐTDĐ");
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachLienHe ds = new DanhSachLienHe();
				if (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				boolean flag = false;
				try {
					FileInputStream fi = new FileInputStream(FILENAME);
					ObjectInputStream oi = new ObjectInputStream(fi);
					ds = (DanhSachLienHe) oi.readObject();

					String hoTen = txtTen.getText();
					LienHe result = ds.findLienHe(hoTen.trim());
					System.out.println(FILENAME + result.getHinh());
					ImageIcon icon = new ImageIcon("src/baitap/image/contact/" + result.getHinh());

					model.addRow(new Object[] { icon, result.hoTen, result.dtdd });
					tblKetQua.setRowHeight(60);
					tblKetQua.getColumn(tblKetQua.getColumnName(0)).setCellRenderer(new ImageTableCellRenderer(60, 60));
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim.setBounds(312, 53, 69, 30);
		contentPane.add(btnTim);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 107, 619, 196);
		contentPane.add(scrollPane);

		tblKetQua = new JTable();
		tblKetQua.setModel(model);
		tblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(tblKetQua);
	}
}
