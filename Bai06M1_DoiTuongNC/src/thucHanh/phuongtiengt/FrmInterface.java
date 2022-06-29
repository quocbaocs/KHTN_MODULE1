package thucHanh.phuongtiengt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuangDuong;
	private JTextField txtThoiGian;
	private JTextField txtNhienLieu;
	private JTextField txttenXe;
	private JTextField txtHSX;
	private JTextField txtVanToc;
	private JTextField txtTrongLuong;
	private JTextField txtSucTai;
	private JTextField txtXuoi;
	private JTextField txtNguoc;
	private JTextField txtTieuHao;
	private JTextField txtTieuThuNL;
	private final ButtonGroup btngTauXe = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInterface frame = new FrmInterface();
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
	public FrmInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin chung");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 32, 178, 29);
		contentPane.add(lblNewLabel);

		JLabel lblQungngkm = new JLabel("Qu\u00E3ng \u0111\u01B0\u1EDDng (km)");
		lblQungngkm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQungngkm.setBounds(21, 72, 138, 29);
		contentPane.add(lblQungngkm);

		JLabel lblNewLabel_1_1 = new JLabel("Th\u1EDDi gian (gi\u1EDD)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(311, 70, 138, 29);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Nhi\u00EAn li\u1EC7u (l\u00EDt)");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(571, 72, 138, 29);
		contentPane.add(lblNewLabel_1_2);

		txtQuangDuong = new JTextField();
		txtQuangDuong.setBounds(169, 72, 108, 29);
		contentPane.add(txtQuangDuong);
		txtQuangDuong.setColumns(10);

		txtThoiGian = new JTextField();
		txtThoiGian.setColumns(10);
		txtThoiGian.setBounds(437, 72, 108, 29);
		contentPane.add(txtThoiGian);

		txtNhienLieu = new JTextField();
		txtNhienLieu.setColumns(10);
		txtNhienLieu.setBounds(694, 70, 108, 29);
		contentPane.add(txtNhienLieu);

		JRadioButton rbtXe = new JRadioButton("Xe h\u01A1i");
		btngTauXe.add(rbtXe);
		rbtXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbtXe.setBounds(97, 124, 149, 23);
		contentPane.add(rbtXe);

		JRadioButton rbtTau = new JRadioButton("T\u00E0u th\u1EE7y");
		btngTauXe.add(rbtTau);
		rbtTau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbtTau.setBounds(437, 124, 149, 23);
		contentPane.add(rbtTau);

		JLabel lblTnXe = new JLabel("T\u00EAn xe");
		lblTnXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnXe.setBounds(21, 175, 138, 29);
		contentPane.add(lblTnXe);

		JLabel lblQungngkm_1_1 = new JLabel("H\u00E3ng s\u1EA3n xu\u1EA5t");
		lblQungngkm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQungngkm_1_1.setBounds(21, 227, 138, 29);
		contentPane.add(lblQungngkm_1_1);

		txttenXe = new JTextField();
		txttenXe.setColumns(10);
		txttenXe.setBounds(169, 175, 108, 29);
		contentPane.add(txttenXe);

		txtHSX = new JTextField();
		txtHSX.setColumns(10);
		txtHSX.setBounds(169, 227, 108, 29);
		contentPane.add(txtHSX);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tr\u1ECDng l\u01B0\u1EE3ng (kg)");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(437, 175, 138, 29);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("S\u1EE9c t\u1EA3i (kg)");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(437, 227, 138, 29);
		contentPane.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("V\u1EADn t\u1ED1c n\u01B0\u1EDBc xu\u00F4i d\u00F2ng (km/h)");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_3.setBounds(437, 278, 223, 29);
		contentPane.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_2_4 = new JLabel("V\u1EADn t\u1ED1c n\u01B0\u1EDBc ng\u01B0\u1EE3c d\u00F2ng (km/h)");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4.setBounds(437, 330, 237, 29);
		contentPane.add(lblNewLabel_1_2_4);

		JLabel lblNewLabel_1_2_5 = new JLabel("Nhi\u00EAn li\u1EC7u ti\u00EAu hao (l\u00EDt)");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5.setBounds(437, 388, 237, 29);
		contentPane.add(lblNewLabel_1_2_5);

		JLabel lblNewLabel_1_2_5_1 = new JLabel("V\u1EADn t\u1ED1c (km/gi\u1EDD)");
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5_1.setBounds(21, 526, 138, 29);
		contentPane.add(lblNewLabel_1_2_5_1);

		JLabel lblNewLabel_1_2_5_2 = new JLabel("Ti\u00EAu th\u1EE5 nhi\u00EAn li\u1EC7u (km/l\u00EDt)");
		lblNewLabel_1_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5_2.setBounds(445, 526, 215, 29);
		contentPane.add(lblNewLabel_1_2_5_2);

		txtVanToc = new JTextField();
		txtVanToc.setColumns(10);
		txtVanToc.setBounds(169, 526, 108, 29);
		contentPane.add(txtVanToc);

		txtTrongLuong = new JTextField();
		txtTrongLuong.setColumns(10);
		txtTrongLuong.setBounds(694, 175, 108, 29);
		contentPane.add(txtTrongLuong);

		txtSucTai = new JTextField();
		txtSucTai.setColumns(10);
		txtSucTai.setBounds(694, 227, 108, 29);
		contentPane.add(txtSucTai);

		txtXuoi = new JTextField();
		txtXuoi.setColumns(10);
		txtXuoi.setBounds(694, 278, 108, 29);
		contentPane.add(txtXuoi);

		txtNguoc = new JTextField();
		txtNguoc.setColumns(10);
		txtNguoc.setBounds(694, 330, 108, 29);
		contentPane.add(txtNguoc);

		txtTieuHao = new JTextField();
		txtTieuHao.setColumns(10);
		txtTieuHao.setBounds(694, 390, 108, 29);
		contentPane.add(txtTieuHao);

		txtTieuThuNL = new JTextField();
		txtTieuThuNL.setColumns(10);
		txtTieuThuNL.setBounds(694, 526, 108, 29);
		contentPane.add(txtTieuThuNL);

		JButton btnVanToc_TieuThuNhienLieu = new JButton(
				"T\u00EDnh v\u1EADn t\u1ED1c  - Ti\u00EAu th\u1EE5 nhi\u00EAn li\u1EC7u");
		btnVanToc_TieuThuNhienLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double quangDuong = Double.parseDouble(txtQuangDuong.getText());
				double thoiGian = Double.parseDouble(txtThoiGian.getText());
				double soLit = Double.parseDouble(txtNhienLieu.getText());
				if (rbtXe.isSelected()) {
					String tenXe = txttenXe.getText();
					String hsx = txtHSX.getText();
					XeHoi xe = new XeHoi(tenXe, hsx);
					txtVanToc.setText(String.valueOf(xe.tinhVanToc(quangDuong, thoiGian)));
					txtTieuThuNL.setText(String.valueOf(xe.tinhTieuTHuNhienLieu(quangDuong, soLit)));
				} else {
					int trongluong = Integer.parseInt(txtTrongLuong.getText());
					int suctai = Integer.parseInt(txtSucTai.getText());
					double xuoi = Double.parseDouble(txtXuoi.getText());
					double nguoc = Double.parseDouble(txtNguoc.getText());
					double nlTieuHao = Double.parseDouble(txtTieuHao.getText());
					TauThuy tau = new TauThuy(trongluong, suctai, xuoi, nguoc, nlTieuHao);
					txtVanToc.setText(String.valueOf(tau.tinhVanToc(quangDuong, thoiGian)));
					txtTieuThuNL.setText(String.valueOf(tau.tinhTieuTHuNhienLieu(quangDuong, soLit)));
				}

			}
		});
		btnVanToc_TieuThuNhienLieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVanToc_TieuThuNhienLieu.setBounds(252, 445, 323, 37);
		contentPane.add(btnVanToc_TieuThuNhienLieu);
	}
}
