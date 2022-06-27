package bai3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmManHinhCapNhatLienHe extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenTim;
	private JTextField txtHen;
	private JTextField txtDtdd;
	private JTextField txtHinhAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhCapNhatLienHe frame = new FrmManHinhCapNhatLienHe();
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
	public FrmManHinhCapNhatLienHe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 42, 107, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u1EADp nh\u1EADt li\u00EAn h\u1EC7");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(57, 168, 199, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(57, 218, 107, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110TD\u0110");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(57, 268, 107, 40);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhat.setBounds(139, 384, 121, 40);
		contentPane.add(btnCapNhat);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.GRAY);
		separator.setBounds(39, 138, 536, 2);
		contentPane.add(separator);
		
		JButton btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(139, 92, 121, 36);
		contentPane.add(btnTimKiem);
		
		JLabel lblNewLabel_3_1 = new JLabel("H\u00ECnh \u1EA3nh");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(57, 318, 107, 40);
		contentPane.add(lblNewLabel_3_1);
		
		txtTenTim = new JTextField();
		txtTenTim.setBounds(142, 42, 425, 40);
		contentPane.add(txtTenTim);
		txtTenTim.setColumns(10);
		
		txtHen = new JTextField();
		txtHen.setColumns(10);
		txtHen.setBounds(139, 218, 425, 40);
		contentPane.add(txtHen);
		
		txtDtdd = new JTextField();
		txtDtdd.setColumns(10);
		txtDtdd.setBounds(139, 268, 240, 40);
		contentPane.add(txtDtdd);
		
		txtHinhAnh = new JTextField();
		txtHinhAnh.setColumns(10);
		txtHinhAnh.setBounds(139, 318, 339, 40);
		contentPane.add(txtHinhAnh);
		
		JButton btnChon = new JButton("C\u1EADp nh\u1EADt");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechoose = new JFileChooser();
				filechoose.showOpenDialog(null);
				File file = filechoose.getSelectedFile();
				String pathfile = file.getAbsolutePath();
				txtHinhAnh.setText(pathfile);
				
			}
		});
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChon.setBounds(486, 318, 53, 40);
		contentPane.add(btnChon);
	}

}
