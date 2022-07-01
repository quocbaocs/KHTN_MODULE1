package thucHanh.nhaccu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmChoiNhac extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtHinh;
	private JTextField txtSoDay;
	private JTextField txtSuDung;
	private ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChoiNhac frame = new FrmChoiNhac();
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
	public FrmChoiNhac() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHinh = new JLabel("");
		lblHinh.setBounds(549, 11, 219, 225);
		contentPane.add(lblHinh);

		JLabel lblten = new JLabel("T\u00EAn nh\u1EA1c c\u1EE5");
		lblten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblten.setBounds(57, 44, 137, 37);
		contentPane.add(lblten);

		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn h\u00ECnh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(57, 114, 137, 37);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Lo\u1EA1i nh\u1EA1c c\u1EE5");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(57, 187, 137, 37);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblSuDung = new JLabel("S\u1EED d\u1EE5ng");
		lblSuDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuDung.setBounds(57, 306, 137, 37);
		contentPane.add(lblSuDung);

		JLabel lblSuDung1 = new JLabel("\u0111\u1EC3 ch\u01A1i");
		lblSuDung1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuDung1.setBounds(408, 306, 82, 37);
		contentPane.add(lblSuDung1);

		JLabel lblSoDay = new JLabel("S\u1ED1 d\u00E2y");
		lblSoDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoDay.setBounds(57, 243, 137, 37);
		contentPane.add(lblSoDay);

		txtSuDung = new JTextField();
		txtSuDung.setColumns(10);
		txtSuDung.setBounds(204, 308, 193, 37);
		contentPane.add(txtSuDung);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(527, 263, 273, 158);
		contentPane.add(scrollPane);

		JTextArea txtMieuTa = new JTextArea();
		txtMieuTa.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMieuTa.setLineWrap(true);
		scrollPane.setViewportView(txtMieuTa);

		txtTen = new JTextField();
		txtTen.setBounds(200, 44, 264, 37);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtHinh = new JTextField();
		txtHinh.setColumns(10);
		txtHinh.setBounds(200, 116, 264, 37);
		contentPane.add(txtHinh);

		txtSoDay = new JTextField();
		txtSoDay.setColumns(10);
		txtSoDay.setBounds(204, 245, 137, 37);
		contentPane.add(txtSoDay);
		icon = new ImageIcon("src/HinhAnh/instrutment.jpg");
		icon.setImage(icon.getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH));
		lblHinh.setIcon(icon);
		JComboBox cbbLoai = new JComboBox();
		cbbLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cbbLoai.getSelectedIndex();
				if (index == 0) {
					txtSuDung.setVisible(false);
					lblSuDung.setVisible(false);
					lblSuDung1.setVisible(false);
					txtSoDay.setVisible(true);
					lblSoDay.setVisible(true);
				} else {
					txtSuDung.setVisible(true);
					lblSuDung.setVisible(true);
					lblSuDung1.setVisible(true);
					
				}
			}
		});
		cbbLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbLoai.setModel(new DefaultComboBoxModel(new String[] { "C\u00F3 d\u00E2y", "Kh\u00F4ng d\u00E2y" }));

		cbbLoai.setBounds(204, 193, 264, 28);
		contentPane.add(cbbLoai);
		JButton btnChoi = new JButton("Ch\u01A1i nh\u1EA1c");
		btnChoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ten = txtTen.getText();
				String hinh = "src/HinhAnh/" + txtHinh.getText();

				int index = cbbLoai.getSelectedIndex();
				if (index == 0) {
					int soday = Integer.parseInt(txtSoDay.getText());
					NhacCuCoDay nc = new NhacCuCoDay(ten, hinh, soday);
					txtMieuTa.setText(nc.choiNhac());
				} else {
					String sudung = txtSuDung.getText();
					NhacCuKhongDay nc = new NhacCuKhongDay(ten, hinh, sudung);
					txtMieuTa.setText(nc.choiNhac());
				}
				icon = new ImageIcon(hinh);
				
				icon.setImage(icon.getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH));
				lblHinh.setIcon(icon);
				

			}
		});
		btnChoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChoi.setBounds(250, 384, 128, 37);
		contentPane.add(btnChoi);

	}
}
