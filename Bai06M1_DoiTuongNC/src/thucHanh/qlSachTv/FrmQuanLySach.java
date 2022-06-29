package thucHanh.qlSachTv;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmQuanLySach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup rbtgLoaiSach = new ButtonGroup();
	private JTextField txtTienSTK;
	private JTextField txtTBCDonGia;
	private JTextField txtThue;
	private JTextField txtTenSach;
	private JTextField txtNXB;
	private JTextField txtSoLuong;
	private JTextField txtMaSach;
	private JTextField txtNgayNhap;
	private JTextField txtDonGia;
	private JTextField txtTienSGK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLySach frame = new FrmQuanLySach();
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
	public FrmQuanLySach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin chung");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 11, 161, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u00E3 s\u00E1ch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 56, 99, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y nh\u1EADp");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(25, 94, 99, 27);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(25, 132, 99, 27);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("T\u00EAn s\u00E1ch");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(294, 56, 99, 27);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("NXB");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(294, 94, 99, 27);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(294, 132, 99, 27);
		contentPane.add(lblNewLabel_1_5);

		JRadioButton rbtSGK = new JRadioButton("S\u00E1ch gi\u00E1o khoa");
		rbtgLoaiSach.add(rbtSGK);
		rbtSGK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbtSGK.setBounds(25, 185, 161, 23);
		contentPane.add(rbtSGK);

		JRadioButton rbtSTK = new JRadioButton("S\u00E1ch tham kh\u1EA3o");
		rbtgLoaiSach.add(rbtSTK);
		rbtSTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbtSTK.setBounds(294, 187, 161, 23);
		contentPane.add(rbtSTK);
		JLabel lblNewLabel_1_2_1 = new JLabel("T\u00ECnh tr\u1EA1ng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(25, 215, 99, 27);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Thu\u1EBF(1-100)");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(294, 217, 99, 27);
		contentPane.add(lblNewLabel_1_2_2);

		JButton btnTiepTuc = new JButton("Ti\u1EBFp t\u1EE5c");
		btnTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTiepTuc.setBounds(304, 264, 109, 27);
		contentPane.add(btnTiepTuc);

		JTabbedPane tplThongKe = new JTabbedPane(JTabbedPane.TOP);
		tplThongKe.setBounds(25, 319, 689, 215);
		contentPane.add(tplThongKe);

		JPanel pnlSGK = new JPanel();
		tplThongKe.addTab("S\u00E1ch gi\u00E1o khoa", null, pnlSGK, null);
		pnlSGK.setLayout(null);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("T\u1ED5ng th\u00E0nh ti\u1EC1n");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(10, 11, 130, 29);
		pnlSGK.add(lblNewLabel_1_2_1_1);

		txtTienSGK = new JTextField();
		txtTienSGK.setColumns(10);
		txtTienSGK.setBounds(150, 11, 166, 29);
		pnlSGK.add(txtTienSGK);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 53, 664, 123);
		pnlSGK.add(scrollPane_1);

		JList lstSGK = new JList();
		scrollPane_1.setViewportView(lstSGK);

		JPanel pnlSTK = new JPanel();
		tplThongKe.addTab("S\u00E1ch tham kh\u1EA3o", null, pnlSTK, null);
		pnlSTK.setLayout(null);

		JLabel lblNewLabel_1_6 = new JLabel("T\u1ED5ng th\u00E0nh ti\u1EC1n");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(20, 11, 141, 27);
		pnlSTK.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_6_1 = new JLabel("\u0110\u01A1n gi\u00E1 trung b\u00ECnh");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6_1.setBounds(303, 11, 141, 27);
		pnlSTK.add(lblNewLabel_1_6_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 654, 116);
		pnlSTK.add(scrollPane);

		JList lstSTK = new JList();
		scrollPane.setViewportView(lstSTK);

		txtTienSTK = new JTextField();
		txtTienSTK.setBounds(171, 11, 122, 27);
		pnlSTK.add(txtTienSTK);
		txtTienSTK.setColumns(10);

		txtTBCDonGia = new JTextField();
		txtTBCDonGia.setColumns(10);
		txtTBCDonGia.setBounds(454, 11, 149, 27);
		pnlSTK.add(txtTBCDonGia);

		JComboBox cbbLoaiSach = new JComboBox();
		cbbLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbLoaiSach.setModel(new DefaultComboBoxModel(new String[] { "M\u1EDBi", "C\u0169" }));
		cbbLoaiSach.setBounds(134, 214, 104, 27);
		contentPane.add(cbbLoaiSach);

		txtThue = new JTextField();
		txtThue.setBounds(404, 217, 220, 25);
		contentPane.add(txtThue);
		txtThue.setColumns(10);

		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(403, 56, 221, 27);
		contentPane.add(txtTenSach);

		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(403, 94, 221, 27);
		contentPane.add(txtNXB);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(403, 130, 221, 27);
		contentPane.add(txtSoLuong);

		txtMaSach = new JTextField();
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(134, 56, 104, 27);
		contentPane.add(txtMaSach);

		txtNgayNhap = new JTextField();
		txtNgayNhap.setColumns(10);
		txtNgayNhap.setBounds(134, 94, 104, 27);
		contentPane.add(txtNgayNhap);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(134, 132, 104, 27);
		contentPane.add(txtDonGia);

		JButton btnNhap = new JButton("Nh\u1EADp s\u00E1ch");
		btnNhap.addActionListener(new ActionListener() {

			SachGiaoKhoa[] listSgk = new SachGiaoKhoa[0];
			SachThamKhao[] listStk = new SachThamKhao[0];

			public void actionPerformed(ActionEvent e) {

				String maSach = txtMaSach.getText();
				String tenSach = txtTenSach.getText();
				String ngayNhap = txtNgayNhap.getText();
				String nxb = txtNXB.getText();
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				double donGia = Double.parseDouble(txtDonGia.getText());
				if (rbtSGK.isSelected()) {
					int index = cbbLoaiSach.getSelectedIndex();
					boolean tt = true;
					if (index == 1) {
						tt = false;
					} else if (index == 0) {
						tt = true;
					}

					listSgk = Arrays.copyOf(listSgk, listSgk.length + 1);
					SachGiaoKhoa sgk = new SachGiaoKhoa(maSach, tenSach, ngayNhap, nxb, donGia, soLuong, tt);
					listSgk[listSgk.length - 1] = sgk;
					DefaultListModel<String> model = new DefaultListModel<String>();
					double tongTTSGK = 0;
					for (SachGiaoKhoa s : listSgk) {
						model.addElement(s.toString());
						tongTTSGK += s.tinhThanhTien();
						System.out.println(tongTTSGK);
					}
					txtTienSGK.setText(String.valueOf(tongTTSGK));
					lstSGK.setModel(model);

				} else if (rbtSTK.isSelected()) {
					int thue = Integer.parseInt(txtThue.getText());
					DefaultListModel<String> model = new DefaultListModel<String>();
					listStk = Arrays.copyOf(listStk, listStk.length);
					SachThamKhao stk = new SachThamKhao(maSach, tenSach, ngayNhap, nxb, donGia, soLuong, thue);
					listStk = Arrays.copyOf(listStk, listStk.length + 1);
					listStk[listStk.length - 1] = stk;
					double tongTienStk = 0;
					int tongslSp = 0;
					for(SachThamKhao s : listStk) {
						model.addElement(s.toString());
						tongTienStk+=s.tinhThanhTien();
						tongslSp+=s.getSoLuong();
					}
					txtTienSTK.setText(String.valueOf(tongTienStk));
					txtTBCDonGia.setText(String.valueOf(tongTienStk/tongslSp));
					lstSTK.setModel(model);
				}

			}
		});
		btnNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhap.setBounds(89, 264, 134, 27);
		contentPane.add(btnNhap);
	}

}
