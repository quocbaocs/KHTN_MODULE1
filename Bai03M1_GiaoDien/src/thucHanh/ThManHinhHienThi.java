package thucHanh;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ThManHinhHienThi extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDtdd;
	private JTextField txtHinhAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThManHinhHienThi frame = new ThManHinhHienThi();
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
	public ThManHinhHienThi() {
		setTitle("Th\u00F4ng tin li\u00EAn h\u1EC7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin li\u00EAn h\u1EC7");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 10, 282, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 56, 100, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u0110TDD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(25, 95, 100, 29);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("H\u00ECnh \u1EA3nh");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(25, 136, 100, 29);
		contentPane.add(lblNewLabel_3);

		txtTen = new JTextField();
		txtTen.setBounds(135, 56, 293, 29);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtDtdd = new JTextField();
		txtDtdd.setColumns(10);
		txtDtdd.setBounds(135, 97, 172, 29);
		contentPane.add(txtDtdd);

		txtHinhAnh = new JTextField();
		txtHinhAnh.setColumns(10);
		txtHinhAnh.setBounds(135, 136, 293, 29);
		contentPane.add(txtHinhAnh);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 254, 414, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(25, 293, 100, 29);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\u0110TDD");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(25, 332, 100, 29);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("H\u00ECnh \u1EA3nh");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(25, 371, 100, 29);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblHienThiTen = new JLabel("");
		lblHienThiTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHienThiTen.setBounds(135, 293, 293, 29);
		contentPane.add(lblHienThiTen);

		JLabel lblHienTHiDtdd = new JLabel("");
		lblHienTHiDtdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHienTHiDtdd.setBounds(135, 332, 172, 29);
		contentPane.add(lblHienTHiDtdd);

		JLabel lblHienThiHInhAnh = new JLabel("");
		lblHienThiHInhAnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHienThiHInhAnh.setBounds(135, 371, 220, 186);
		contentPane.add(lblHienThiHInhAnh);
		JButton btnHienThi = new JButton("Hi\u1EC3n th\u1ECB");
		
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblHienThiTen.setText(txtTen.getText());
				lblHienTHiDtdd.setText(txtDtdd.getText());
				ImageIcon icon = new ImageIcon(txtHinhAnh.getText());
				icon.getImage().getScaledInstance(lblHienThiHInhAnh.getWidth(), lblHienThiHInhAnh.getHeight(), Image.SCALE_SMOOTH);
				lblHienThiHInhAnh.setIcon(icon);
				
			}
		});
		btnHienThi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHienThi.setBounds(115, 195, 113, 34);
		contentPane.add(btnHienThi);
	}
}
