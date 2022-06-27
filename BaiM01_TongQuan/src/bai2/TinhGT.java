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

public class TinhGT extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiaTriX;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TinhGT frame = new TinhGT();
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
	public TinhGT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EDnh giai th\u1EEBa c\u1EE7a X");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 26, 214, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNhpX = new JLabel("Nh\u1EADp x:");
		lblNhpX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhpX.setBounds(31, 92, 111, 34);
		contentPane.add(lblNhpX);

		JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3:");
		lblKtQu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKtQu.setBounds(31, 136, 111, 34);
		contentPane.add(lblKtQu);

		txtGiaTriX = new JTextField();
		txtGiaTriX.setBounds(114, 92, 149, 32);
		contentPane.add(txtGiaTriX);
		txtGiaTriX.setColumns(10);

		txtKetQua = new JTextField();
		txtKetQua.setEnabled(false);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(114, 136, 149, 34);
		contentPane.add(txtKetQua);

		JButton btnTinh = new JButton("T\u00EDnh");
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int giatrix = Integer.parseInt(txtGiaTriX.getText());
				txtKetQua.setText(String.valueOf(giaiThua(giatrix)));
			}
		});
		btnTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinh.setBounds(40, 195, 105, 45);
		contentPane.add(btnTinh);

		JButton btnNhapLai = new JButton("Nh\u1EADp l\u1EA1i");
		btnNhapLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGiaTriX.setText("");
				txtKetQua.setText("");
			}
		});
		btnNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhapLai.setBounds(180, 195, 105, 45);
		contentPane.add(btnNhapLai);
	}

	private int giaiThua(int x) {
		if (x > 0)
			return x * giaiThua(x - 1);
		else
			return 1;
	}

}
