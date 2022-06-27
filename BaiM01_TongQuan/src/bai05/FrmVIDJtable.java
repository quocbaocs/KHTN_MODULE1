package bai05;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class FrmVIDJtable extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtDienThoai;
	private JTextField txtHoTen;
	private JTextField txtHinh;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVIDJtable frame = new FrmVIDJtable();
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
	public FrmVIDJtable() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 620, 166);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "H\u1ECD t\u00EAn", "\u0110i\u1EC7n tho\u1EA1i", "H\u00ECnh \u1EA3nh" }));
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				Point p = evt.getPoint();
				int row = table.rowAtPoint(p);
				txtHoTen.setText(dtm.getValueAt(row, 0).toString());
				txtDienThoai.setText(dtm.getValueAt(row, 1).toString());
				txtHinh.setText(dtm.getValueAt(row, 2).toString());
			}
		});

		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(204, 253, 205, 36);
		contentPane.add(txtDienThoai);
		txtDienThoai.setColumns(10);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(204, 210, 286, 32);
		contentPane.add(txtHoTen);

		dtm = (DefaultTableModel) table.getModel();
		dtm.addRow(new String[] { "mai", "lan", "cuc" });

		txtHinh = new JTextField();
		txtHinh.setColumns(10);
		txtHinh.setBounds(204, 300, 286, 36);
		contentPane.add(txtHinh);

		JLabel lblNewLabel = new JLabel("Họ tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(92, 210, 102, 32);
		contentPane.add(lblNewLabel);

		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblinThoi.setBounds(92, 257, 102, 32);
		contentPane.add(lblinThoi);

		JLabel lblHnhnh = new JLabel("Hình ảnh");
		lblHnhnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHnhnh.setBounds(92, 300, 102, 36);
		contentPane.add(lblHnhnh);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaActionPerformed(e);
			}
		});

		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(293, 362, 116, 42);

		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(461, 362, 116, 42);
		btnXoa.addActionListener(this);
		contentPane.add(btnXoa);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 197, 620, 2);
		contentPane.add(separator);

		JButton btnGetImage = new JButton("...");
		btnGetImage.addActionListener(this);
		btnGetImage.setBounds(500, 300, 53, 36);
		contentPane.add(btnGetImage);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(this);

		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(120, 362, 116, 42);
		contentPane.add(btnThem);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.getText().equals("...")) {
			System.out.println("...");
			JFileChooser file = new JFileChooser("H:\\KITS JAVA\\BaiM01_TongQuan\\src\\HinhAnh");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Các tập tin *.jpg, *png", "jpg", "png");
			file.setDialogTitle("Chọn hình ảnh");
			file.setFileFilter(filter);
			int kq = file.showOpenDialog(null);
			if (kq == JFileChooser.APPROVE_OPTION) {
				File f = file.getSelectedFile();
				txtHinh.setText(f.getAbsolutePath());

			}

		}
		if (buttonPressed.getText().equals("Thêm")) {
			String hoten = txtHoTen.getText();
			String dt = txtDienThoai.getText();
			dtm.addRow(new String[] { hoten, dt, txtHinh.getText() });
		}
		if (buttonPressed.getText().equals("Xóa")) {
			int row = table.getSelectedRow();
			if (row > -1) {
				int kq = JOptionPane.showConfirmDialog(rootPane, "Bạn muốn xóa mẫu tin này?", "Chú ý",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (kq == JOptionPane.YES_OPTION) {
					dtm.removeRow(row);
					txtHoTen.setText(null);
					txtDienThoai.setText(null);
					txtHinh.setText(null);
				}
			}
		}

	}

	private void btnSuaActionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row >= -1) {

			dtm.setValueAt(txtHoTen.getText(), row, 0);
			dtm.setValueAt(txtDienThoai.getText(), row, 1);
			dtm.setValueAt(txtHinh.getText(), row, 2);

		}
	}

}
