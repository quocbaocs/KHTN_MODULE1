package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSendGift extends JFrame {

	private JPanel contentPane;
	private JTextField txtHinhDang;
	private JTextField txtMauSac;
	private JTextField txtTenQua;
	private JTextField txtTrongLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSendGift frame = new FrmSendGift();
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
	public FrmSendGift() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u00ECnh d\u00E1ng h\u1ED9p qu\u00E0");
		lblNewLabel.setBounds(60, 65, 105, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblThngTinHp = new JLabel("Th\u00F4ng tin h\u1ED9p qu\u00E0");
		lblThngTinHp.setBounds(10, 11, 121, 26);
		contentPane.add(lblThngTinHp);
		
		JLabel lblMuSc = new JLabel("M\u00E0u s\u1EAFc");
		lblMuSc.setBounds(60, 118, 89, 26);
		contentPane.add(lblMuSc);
		
		JLabel lblThngTinHp_1 = new JLabel("Th\u00F4ng tin h\u1ED9p qu\u00E0");
		lblThngTinHp_1.setBounds(60, 171, 89, 26);
		contentPane.add(lblThngTinHp_1);
		
		JLabel lblTnQu = new JLabel("T\u00EAn qu\u00E0");
		lblTnQu.setBounds(76, 208, 89, 26);
		contentPane.add(lblTnQu);
		
		JLabel lblTrngLng = new JLabel("Tr\u1ECDng l\u01B0\u1EE3ng");
		lblTrngLng.setBounds(76, 255, 89, 26);
		contentPane.add(lblTrngLng);
		
		JLabel lblThngTinGi = new JLabel("Th\u00F4ng tin g\u1EEDi qu\u00E0");
		lblThngTinGi.setBounds(60, 349, 89, 26);
		contentPane.add(lblThngTinGi);
		
		JButton btnGui = new JButton("G\u1EEDi qu\u00E0");
		btnGui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGui.setBounds(240, 305, 89, 34);
		contentPane.add(btnGui);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 386, 399, 120);
		contentPane.add(scrollPane);
		
		JTextArea txtaKetQua = new JTextArea();
		scrollPane.setViewportView(txtaKetQua);
		
		txtHinhDang = new JTextField();
		txtHinhDang.setBounds(193, 65, 265, 26);
		contentPane.add(txtHinhDang);
		txtHinhDang.setColumns(10);
		
		txtMauSac = new JTextField();
		txtMauSac.setColumns(10);
		txtMauSac.setBounds(193, 118, 265, 26);
		contentPane.add(txtMauSac);
		
		txtTenQua = new JTextField();
		txtTenQua.setColumns(10);
		txtTenQua.setBounds(193, 213, 265, 26);
		contentPane.add(txtTenQua);
		
		txtTrongLuong = new JTextField();
		txtTrongLuong.setColumns(10);
		txtTrongLuong.setBounds(193, 255, 265, 26);
		contentPane.add(txtTrongLuong);
		
		JLabel lblNewLabel_1 = new JLabel("g");
		lblNewLabel_1.setBounds(466, 261, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
