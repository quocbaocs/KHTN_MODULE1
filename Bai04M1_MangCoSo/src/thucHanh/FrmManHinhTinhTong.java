package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FrmManHinhTinhTong extends JFrame {

	private JPanel contentPane;
	private JTextField txtN;
	private JTextField txtTong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhTinhTong frame = new FrmManHinhTinhTong();
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
	public FrmManHinhTinhTong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 488);
		contentPane = new JPanel();
		setTitle("Tính tổng các phần tử có giá trị ngẫu nhiên trong mảng");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nh\u1EADp n:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(44, 43, 152, 41);
		contentPane.add(lblNewLabel);

		JLabel lblMngcPht = new JLabel("M\u1EA3ng \u0111\u01B0\u1EE3c ph\u00E1t sinh");
		lblMngcPht.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMngcPht.setBounds(44, 105, 174, 41);

		contentPane.add(lblMngcPht);
		JTextArea txtMang = new JTextArea();
		txtMang.setRows(3);
		txtMang.setLineWrap(true);
		txtMang.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtMang.setBounds(250, 105, 353, 149);
		contentPane.add(txtMang);

		JLabel lblTng = new JLabel("T\u1ED5ng");
		lblTng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTng.setBounds(44, 279, 152, 41);
		contentPane.add(lblTng);

		txtN = new JTextField();
		txtN.setBounds(250, 45, 174, 41);
		txtN.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(txtN);
		txtN.setColumns(10);

		txtTong = new JTextField();
		txtTong.setColumns(10);
		txtTong.setBounds(250, 281, 174, 41);
		txtTong.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(txtTong);

		JButton btnTinhTong = new JButton("T\u00EDnh t\u1ED5ng");
		btnTinhTong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(txtN.getText());

				txtMang.setText(mangChuoi(n));
				txtTong.setText(String.valueOf(tong(n)));

			}
		});
		btnTinhTong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTinhTong.setBounds(250, 355, 174, 41);
		contentPane.add(btnTinhTong);

	}

	private int[] mang(int n) {
		int[] mang = new int[n];
		Random ramdom = new Random();
		for (int i = 0; i < n; i++) {
			mang[i] = ramdom.nextInt(100);
		}
		return mang;
	}

	private String mangChuoi(int n) {
		int[] arr = mang(n);
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i] + " ";

		}
		return str;
	}

	private int tong(int n) {
		int[] arr = mang(n);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
