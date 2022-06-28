package thucHanh.tinhLuongNV;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class FrmTinhLuong extends JFrame {

	private JPanel contentPane;
	private JTextField txtHeSoLuong;
	private JTextField txtSoSp;
	private JTextField txtLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTinhLuong frame = new FrmTinhLuong();
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
	public FrmTinhLuong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Lo\u1EA1i NV");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 26, 105, 29);
		contentPane.add(lblNewLabel);

		JLabel lblhsl = new JLabel("H\u1EC7 s\u1ED1 l\u01B0\u01A1ng");
		lblhsl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblhsl.setBounds(31, 77, 105, 29);
		contentPane.add(lblhsl);

		JLabel lblsoSp = new JLabel("Phụ cấp");
		lblsoSp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsoSp.setBounds(31, 134, 105, 29);
		contentPane.add(lblsoSp);

		JLabel lblLng = new JLabel("L\u01B0\u01A1ng");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLng.setBounds(31, 261, 105, 29);
		contentPane.add(lblLng);

		txtHeSoLuong = new JTextField();
		txtHeSoLuong.setBounds(152, 77, 168, 29);
		contentPane.add(txtHeSoLuong);
		txtHeSoLuong.setColumns(10);

		txtSoSp = new JTextField();
		txtSoSp.setColumns(10);
		txtSoSp.setBounds(152, 134, 168, 29);
		contentPane.add(txtSoSp);

		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(152, 261, 168, 29);
		contentPane.add(txtLuong);

		String loainv[] = new String[] { "Hành chánh", "Kỹ thuật", "Kinh doanh", "Lãnh đạo" };
		JComboBox cbbLoaiNV = new JComboBox(loainv);

		cbbLoaiNV.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (cbbLoaiNV.getSelectedIndex() != 0) {
						int index = cbbLoaiNV.getSelectedIndex();
						if (index == 1) {
							lblsoSp.setText("Số dự án");
							lblsoSp.setVisible(true);
							txtSoSp.setVisible(true);
						} else if (index == 2) {
							lblsoSp.setText("Số sản phẩm");
							lblsoSp.setVisible(true);
							txtSoSp.setVisible(true);
						} else if (index == 3) {
							lblsoSp.setVisible(false);
							txtSoSp.setVisible(false);
						}
					}
				}
			}
		});
//		cbbLoaiNV.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int index = cbbLoaiNV.getSelectedIndex();
//				if (index == 1) {
//					lblsoSp.setText("Số dự án");
//				} else if (index == 2) {
//					lblsoSp.setText("Số sản phẩm");
//				} else if (index == 3) {
//					lblsoSp.setVisible(false);
//					txtSoSp.setVisible(false);
//				}
//			}
//		});
		cbbLoaiNV.setBounds(152, 26, 168, 29);
		contentPane.add(cbbLoaiNV);

		JButton btnTinhLuong = new JButton("T\u00EDnh l\u01B0\u01A1ng");
		btnTinhLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cbbLoaiNV.getSelectedIndex() + 1;
				double hsl = Double.parseDouble(txtHeSoLuong.getText());
				int sosp;
				switch (index) {
				case 1:
					sosp = Integer.parseInt(txtSoSp.getText());
					HanhChanh hc = new HanhChanh(hsl, sosp);
					txtLuong.setText(String.valueOf(hc.tinhLuong()));
					break;
				case 2:
					sosp = Integer.parseInt(txtSoSp.getText());
					KyThuat kt = new KyThuat(hsl, sosp);
					txtLuong.setText(String.valueOf(kt.tinhLuong()));

					break;
				case 3:
					sosp = Integer.parseInt(txtSoSp.getText());
					KinhDoanh kd = new KinhDoanh(hsl, sosp);
					txtLuong.setText(String.valueOf(kd.tinhLuong()));
					break;

				case 4:
					LanhDao ld = new LanhDao(hsl);
					txtLuong.setText(String.valueOf(ld.tinhLuong()));
					break;

				default:
					break;
				}
			}
		});
		btnTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinhLuong.setBounds(152, 194, 168, 29);
		contentPane.add(btnTinhLuong);
	}

}
