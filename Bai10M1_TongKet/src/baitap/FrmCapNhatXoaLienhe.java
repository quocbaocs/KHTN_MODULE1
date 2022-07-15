package baitap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmCapNhatXoaLienhe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDTDD;
	private JTextField txtHinh;
	private JTable tblKetQua;
	private DanhSachLienHe ds;
	private final String FILENAME = "src/baitap/lienhe.txt";
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCapNhatXoaLienhe frame = new FrmCapNhatXoaLienhe();
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
	public FrmCapNhatXoaLienhe() {
		initDanhSachLienHe();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 472);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Liên hệ");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thêm liên hệ");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tìm kiếm liên hệ");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cập nhật - Xóa liên hệ");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setBounds(34, 40, 121, 20);
		contentPane.add(lblNewLabel);

		JLabel lblHnh = new JLabel("Hình");
		lblHnh.setBounds(34, 87, 121, 20);
		contentPane.add(lblHnh);

		JLabel lbltd = new JLabel("ĐTDĐ");
		lbltd.setBounds(324, 40, 121, 20);
		contentPane.add(lbltd);

		txtTen = new JTextField();
		txtTen.setBounds(109, 40, 178, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtDTDD = new JTextField();
		txtDTDD.setColumns(10);
		txtDTDD.setBounds(371, 40, 208, 20);
		contentPane.add(txtDTDD);

		txtHinh = new JTextField();
		txtHinh.setColumns(10);
		txtHinh.setBounds(109, 87, 419, 20);
		contentPane.add(txtHinh);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser(
						"C:\\Users\\Virus\\git\\KHTN_MODULE1\\Bai09M1_TapTin\\src\\HinhAnh\\contact\\");
				openFile.showOpenDialog(null);
				File file = openFile.getSelectedFile();
				String filepath = file.getAbsolutePath();
				txtHinh.setText(filepath);
			}
		});
		btnNewButton.setBounds(538, 87, 41, 20);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cập nhật");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// đưa tập tin hình ảnh được chọn vào thư mục
				File f = new File(txtHinh.getText());
				String path = "src/baitap/image/contact/";
				String duong_dan = path + f.getName();

				try {
					Files.copy(f.toPath(), (new File(path + f.getName())).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Đã đưa hình liên hệ thư mục contact");
				} catch (IOException ex) {
					// Logger.getLogger(frmThemLienHeMoi.class.getName()).log(Level.SEVERE, null,
					// ex);
				}
				// lấy dữ liệu gán cho đối tượng liên hệ sau đó ghi vào tập tin lienhe.txt
				String hoTen = txtTen.getText();
				String dtdd = txtDTDD.getText();
				String hinhAnh = f.getName();
				System.out.println(hinhAnh);
				LienHe h = new LienHe(hoTen, dtdd, hinhAnh);
				ds.suaThongTinLienHe(dtdd, h);
				FileOutputStream out;
				try {
					out = new FileOutputStream(FILENAME);
					ObjectOutputStream oos = new ObjectOutputStream(out);
					oos.writeObject(ds);
					oos.close();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				napDuLieu();

			}

		});
		btnNewButton_1.setBounds(109, 129, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Xóa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaActionPerformed(e);
			}
		});
		btnNewButton_1_1.setBounds(208, 129, 89, 23);
		contentPane.add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 179, 676, 210);
		contentPane.add(scrollPane);

		tblKetQua = new JTable();
		tblKetQua.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				tblKetQuaMouseClicked(evt);
			}
		});
		model = new DefaultTableModel(new Object[][] {},
				new String[] { "H\u00ECnh \u1EA3nh", "H\u1ECD t\u00EAn", "\u0110TD\u0110" });
		for (LienHe lh : ds.getList()) {
			ImageIcon img = new ImageIcon("src/baitap/image/contact/" + lh.hinh);
			model.addRow(new Object[] { img, lh.hoTen, lh.dtdd });
		}
		tblKetQua.setRowHeight(60);
		tblKetQua.setModel(model);
		tblKetQua.getColumn(tblKetQua.getColumnName(0)).setCellRenderer(new ImageTableCellRenderer(60, 60));

		tblKetQua.setModel(model);
		scrollPane.setViewportView(tblKetQua);
	}

	private void napDuLieu() {
		FileInputStream in = null;
		ObjectInputStream ois = null;
		try {
			in = new FileInputStream(FILENAME);
			ois = new ObjectInputStream(in);
			ds = (DanhSachLienHe) ois.readObject();
			ois.close();
		} catch (Exception ex) {
			ds = new DanhSachLienHe();
			JOptionPane.showMessageDialog(null, "tao moi");
			return;
		}
	}

	private void initDanhSachLienHe() {
		napDuLieu();

	}

	private void tblKetQuaMouseClicked(java.awt.event.MouseEvent evt) {
		String path = String.valueOf(model.getValueAt(tblKetQua.getSelectedRow(), 0));
		File f = new File(path);
		txtHinh.setText(f.getAbsolutePath());
		txtTen.setText(String.valueOf(model.getValueAt(tblKetQua.getSelectedRow(), 1)));
		txtDTDD.setText(String.valueOf(model.getValueAt(tblKetQua.getSelectedRow(), 2)));
	}

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
		// Xác nhận thông tin xóa, nếu chọn đồng ý xóa
		int reply = JOptionPane.showConfirmDialog(rootPane, "Bạn có thật sự muốn xóa '" + txtTen.getText() + "'?",
				"Xác nhận", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			String txtdt = txtDTDD.getText();
			if (ds.xoaLienHe(txtdt)) {
				JOptionPane.showMessageDialog(contentPane, "Xoa thanh cong");
				try (ObjectOutputStream out = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream("src/baitap/lienhe.txt")))) {
					out.writeObject(ds);
					out.flush();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				// xóa các liên hệ trong lst và đưa các liên hệ trong list mới vào
				// ds.clear();
				// boolean addAll = lst.addAll(lstAfter);
				// xóa dòng đã chọn trên table
				model.removeRow(tblKetQua.getSelectedRow());
				// xóa nội dung trên các điều khiển để người dùng tiếp tục thao tác
				txtTen.setText("");
				txtHinh.setText("");
				txtDTDD.setText("");
				napDuLieu();
			}
			// ghi list mới này vào tập tin lienhe.txt

		}
	}

}
