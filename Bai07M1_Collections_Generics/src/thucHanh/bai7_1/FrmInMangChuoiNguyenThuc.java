package thucHanh.bai7_1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FrmInMangChuoiNguyenThuc extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbbLoai;
	private JButton btnSapXep;
	private JTextArea txtaMangXuat;
	private JTextArea txtMangNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInMangChuoiNguyenThuc frame = new FrmInMangChuoiNguyenThuc();
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
	public FrmInMangChuoiNguyenThuc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Lo\u1EA1i m\u1EA3ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 36, 100, 33);
		contentPane.add(lblNewLabel);

		cbbLoai = new JComboBox();
		cbbLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbLoai.setModel(
				new DefaultComboBoxModel(new String[] { "chu\u1ED7i", "s\u1ED1 nguy\u00EAn", "s\u1ED1 th\u1EF1c" }));
		cbbLoai.setBounds(155, 36, 144, 33);
		contentPane.add(cbbLoai);

		JLabel lblNewLabel_1 = new JLabel(
				"Nh\u1EADp m\u1EA3ng (m\u1ED7i ph\u1EA7n t\u1EED c\u00E1ch nhau m\u1ED9t kho\u1EA3ng tr\u1EAFng)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 80, 404, 33);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 124, 343, 118);
		contentPane.add(scrollPane);

		txtMangNhap = new JTextArea();
		scrollPane.setViewportView(txtMangNhap);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 260, 344, 118);
		contentPane.add(scrollPane_1);

		txtaMangXuat = new JTextArea();
		scrollPane_1.setViewportView(txtaMangXuat);

		btnSapXep = new JButton("S\u1EAFp x\u1EBFp m\u1EA3ng");
		btnSapXep.addActionListener(this);
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSapXep.setBounds(137, 389, 162, 23);
		contentPane.add(btnSapXep);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = cbbLoai.getSelectedIndex();
		String[] str = txtMangNhap.getText().split(" ");
		System.out.println(str.length);
		List lst = new ArrayList();
		if (index == 0) {
			lst.addAll(Arrays.asList(str));
		} else if (index == 1) {
			for (String i : str) {
				lst.add(i);
			}

		} else if (index == 2) {
			for (String i : str) {
				lst.add(Double.parseDouble(i));
			}
		}
		Collections.sort(lst);
//		lst.forEach(x -> System.out.println(x));
		txtaMangXuat.setText(lst.toString());

	}

}
