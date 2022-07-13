package thucHanh;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmXuLyChuoi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtsb;
	private JTextField txtsb1;
	private JTextField txtsb2;
	private JTextField txtViTri;
	private JTextField txtBatDau;
	private JTextField txtKetThuc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXuLyChuoi frame = new FrmXuLyChuoi();
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
	public FrmXuLyChuoi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chu\u1ED7i sb");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(22, 58, 88, 37);
		contentPane.add(lblNewLabel);

		JLabel lblChuiSb = new JLabel("Chu\u1ED7i sb1");
		lblChuiSb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChuiSb.setBounds(22, 105, 88, 37);
		contentPane.add(lblChuiSb);

		JLabel lblChuiSb_1 = new JLabel("Chu\u1ED7i sb2");
		lblChuiSb_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChuiSb_1.setBounds(22, 152, 88, 37);
		contentPane.add(lblChuiSb_1);

		JLabel lblVTrChn = new JLabel("V\u1ECB tr\u00ED ch\u00E8n");
		lblVTrChn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVTrChn.setBounds(22, 195, 88, 37);
		contentPane.add(lblVTrChn);

		JLabel lblVTru = new JLabel("V\u1ECB tr\u00ED \u0111\u1EA7u");
		lblVTru.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVTru.setBounds(22, 240, 88, 37);
		contentPane.add(lblVTru);

		JLabel lblVTrCui = new JLabel("V\u1ECB tr\u00ED cu\u1ED1i");
		lblVTrCui.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVTrCui.setBounds(22, 287, 88, 37);
		contentPane.add(lblVTrCui);

		JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3");
		lblKtQu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKtQu.setBounds(22, 383, 88, 37);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 409, 193, 170);
		contentPane.add(scrollPane);

		JTextArea txtaResult = new JTextArea();
		scrollPane.setViewportView(txtaResult);
		contentPane.add(lblKtQu);

		JButton btnXuLy = new JButton("X\u1EED l\u00FD chu\u1ED7i");
		btnXuLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sb = txtsb.getText();
				String sb1 = txtsb1.getText();
				String sb2 = txtsb2.getText();

				int viTri = Integer.parseInt(txtViTri.getText());
				int batDau = Integer.parseInt(txtBatDau.getText());
				int ketThuc = Integer.parseInt(txtKetThuc.getText());
				String ketQua = "Kết quả : ";
				StringBuilder str = new StringBuilder();
				str.append(sb);
				ketQua += "\n Chuỗi sb: " + str;
				ketQua += "\n Chi�?u dài: " + str.length();
				str.append(sb1);
				ketQua += "\n Chuỗi sb sau khi nối sb1: " + str;
				ketQua += "\n Chi�?u dài: " + str.length();
				str.insert(viTri, sb2);
				ketQua += "\n Sau khi chèn sb2 vào vị trí " + viTri + ": \n" + str;
				str.delete(batDau, ketThuc);
				ketQua += "\n Sau khi xóa: \n" + str;
				str.reverse();
				ketQua += "\n Sau khi đảo ngược: \n" + str;
				txtaResult.setText(ketQua);
			}
		});
		btnXuLy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXuLy.setBounds(82, 334, 146, 39);
		contentPane.add(btnXuLy);

		txtsb = new JTextField();
		txtsb.setBounds(111, 58, 296, 37);
		contentPane.add(txtsb);
		txtsb.setColumns(10);

		txtsb1 = new JTextField();
		txtsb1.setColumns(10);
		txtsb1.setBounds(111, 105, 296, 37);
		contentPane.add(txtsb1);

		txtsb2 = new JTextField();
		txtsb2.setColumns(10);
		txtsb2.setBounds(111, 152, 296, 37);
		contentPane.add(txtsb2);

		txtViTri = new JTextField();
		txtViTri.setColumns(10);
		txtViTri.setBounds(111, 199, 296, 37);
		contentPane.add(txtViTri);

		txtBatDau = new JTextField();
		txtBatDau.setColumns(10);
		txtBatDau.setBounds(111, 242, 296, 37);
		contentPane.add(txtBatDau);

		txtKetThuc = new JTextField();
		txtKetThuc.setColumns(10);
		txtKetThuc.setBounds(111, 287, 296, 37);
		contentPane.add(txtKetThuc);

	}
}
