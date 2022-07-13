package thucHanh;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmManHinhTinhNgayTrongThang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtThang;
	private JTextField txtNam;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhTinhNgayTrongThang frame = new FrmManHinhTinhNgayTrongThang();
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
	public FrmManHinhTinhNgayTrongThang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EDnh s\u1ED1 ng\u00E0y theo th\u00E1ng v\u00E0 n\u0103m");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(90, 33, 355, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp th\u00E1ng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(30, 105, 116, 36);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Nh\u1EADp n\u0103m:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(30, 151, 116, 36);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("K\u1EBFt qu\u1EA3:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(30, 197, 116, 36);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("T\u00EDnh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int thang = Integer.parseInt(txtThang.getText());
				int nam = Integer.parseInt(txtNam.getText());
				
				txtKetQua.setText(String.valueOf(tinhNgayTrongThang(thang, nam)));

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(127, 269, 189, 42);
		contentPane.add(btnNewButton);

		txtThang = new JTextField();
		txtThang.setBounds(156, 105, 202, 36);
		contentPane.add(txtThang);
		txtThang.setColumns(10);

		txtNam = new JTextField();
		txtNam.setColumns(10);
		txtNam.setBounds(156, 151, 202, 36);
		contentPane.add(txtNam);

		txtKetQua = new JTextField();
		txtKetQua.setEnabled(false);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(156, 200, 202, 36);
		contentPane.add(txtKetQua);
	}

	private int tinhNgayTrongThang(int thang, int nam) {
		switch (thang) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (laNamNhuan(nam)) {
				return 29;
			}
			return 28;
		}
		return 0;
	}

	private boolean laNamNhuan(int nam) {
		if ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) {
			return true;
		}
		return false;
	}

}
