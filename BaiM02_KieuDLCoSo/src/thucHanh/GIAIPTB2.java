package bai2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GIAIPTB2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiaTriA;
	private JTextField txtGiaTriB;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GIAIPTB2 frame = new GIAIPTB2();
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
	public GIAIPTB2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Gi\u1EA3i Ph\u01B0\u01A1ng tr\u00ECnh b\u1EADc 2 ax+ b =0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 241, 44);
		contentPane.add(lblNewLabel);

		txtGiaTriA = new JTextField();
		txtGiaTriA.setBounds(173, 51, 168, 44);
		contentPane.add(txtGiaTriA);
		txtGiaTriA.setColumns(10);

		txtGiaTriB = new JTextField();
		txtGiaTriB.setColumns(10);
		txtGiaTriB.setBounds(173, 105, 168, 44);
		contentPane.add(txtGiaTriB);

		txtKetQua = new JTextField();
		txtKetQua.setEnabled(false);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(173, 159, 168, 44);
		contentPane.add(txtKetQua);

		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp a: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(34, 54, 103, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Nh\u1EADp b: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(34, 105, 103, 37);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(34, 160, 103, 37);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnTinh = new JButton("T\u00EDnh");
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float giaTriA = Float.parseFloat(txtGiaTriA.getText());
				float giaTriB = Float.parseFloat(txtGiaTriB.getText());
				txtKetQua.setText(giaiPTB1(giaTriA, giaTriB));

			}
		});
		btnTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinh.setBounds(70, 216, 113, 37);
		contentPane.add(btnTinh);

		JButton btnNhapLai = new JButton("Nh\u1EADp l\u1EA1i");
		btnNhapLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGiaTriA.setText("");
				txtGiaTriB.setText("");
				txtKetQua.setText("");
			}
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhapLai.setBounds(210, 213, 113, 37);
		contentPane.add(btnNhapLai);
	}

	private String giaiPTB1(float a, float b) {
		if (a == 0) {
			if (b == 0) {
				return "Phương trình có vô số nghiệm";
			} else {
				return "Phương trình vô nghiệm";
			}
		} else {
			float kq = -b / a;
			return String.valueOf(kq);
		}

	}
}
