package baitap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmManHinhTimLienHe extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTable tblKetQua;
	private List<LienHe> dslh;
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

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (new File(FILENAME).exists()) {
					try {
						FileInputStream in = new FileInputStream(FILENAME);
						ObjectInputStream ois = new ObjectInputStream(in);
						dslh = (List<LienHe>) ois.readObject();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu");
				}

			}
		});
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
				if (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				boolean flag = false;
				try {
					String hoTen = txtTen.getText();
					if (hoTen.isEmpty() && hoTen.trim().length() == 0) {
						JOptionPane.showMessageDialog(rootPane, "Nhập dữ liệu sai, nhập lại");
					} else {
						for (LienHe h : dslh) {
							if (h.getHoTen().contains(hoTen)) {
								ImageIcon icon = new ImageIcon("src/baitap/image/contact/" + h.getHinh());
								model.addRow(new Object[] { icon, h.hoTen, h.dtdd });
								tblKetQua.setRowHeight(60);
								tblKetQua.getColumn(tblKetQua.getColumnName(0))
										.setCellRenderer(new ImageTableCellRenderer(60, 60));
							}

						}
					}
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
