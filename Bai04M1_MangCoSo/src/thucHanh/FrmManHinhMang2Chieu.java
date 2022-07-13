package thucHanh;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmManHinhMang2Chieu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private JTextField txtN;
	private JTextField txtM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhMang2Chieu frame = new FrmManHinhMang2Chieu();
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
	public FrmManHinhMang2Chieu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 536);
		contentPane = new JPanel();
		setTitle("Tính tổng các phần tử có giá trị ngẫu nhiên trong mảng");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nh\u1EADp n:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(44, 27, 152, 41);
		contentPane.add(lblNewLabel);

		JLabel lblMngcPht = new JLabel("M\u1EA3ng \u0111\u01B0\u1EE3c ph\u00E1t sinh");
		lblMngcPht.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMngcPht.setBounds(44, 139, 174, 41);

		contentPane.add(lblMngcPht);
		JTextArea txtMang = new JTextArea();
		txtMang.setRows(3);
		txtMang.setLineWrap(true);
		txtMang.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtMang.setBounds(250, 146, 353, 109);
		contentPane.add(txtMang);

		JLabel lblTng = new JLabel("Kết quả tìm kiếm");
		lblTng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTng.setBounds(44, 279, 152, 41);
		contentPane.add(lblTng);

		txtN = new JTextField();
		txtN.setBounds(250, 27, 174, 41);
		txtN.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(txtN);
		txtN.setColumns(10);

		JTextArea txtMangKQ = new JTextArea();
		txtMangKQ.setRows(3);
		txtMangKQ.setLineWrap(true);
		txtMangKQ.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtMangKQ.setBounds(250, 289, 353, 109);
		contentPane.add(txtMangKQ);

		JLabel lblNhpX = new JLabel("Nhập x:");
		lblNhpX.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNhpX.setBounds(44, 78, 152, 41);
		contentPane.add(lblNhpX);

		txtM = new JTextField();
		txtM.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtM.setColumns(10);
		txtM.setBounds(250, 78, 174, 41);
		contentPane.add(txtM);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(txtN.getText());
				 int m = Integer.parseInt(txtM.getText());
				int[][] mang = mang(n, m);
				 int[] mangKQ = xulyMangHaiChieu(mang);
				 float tbchan = (float) mangKQ[2] / mangKQ[0];
				 float tble = (float) mangKQ[3] / mangKQ[1];
				 String kq = "";
				 kq += "Số phần tử chẵn = " + mangKQ[0] + "\n";
				 kq += "Số phần tử lẻ = " + mangKQ[1] + "\n";
				 kq += "Trung bình chẵn = " + String.format("%.2f", tbchan) + "\n";
				 kq += "Trung bình lẻ = " + String.format("%.2f", tble) + "\n";
				 kq += "GT max = " + mangKQ[4] + "\n";
				 kq += "GT min = " + mangKQ[5] + "\n";
				 txtMang.setText(mangChuoi(mang));
				 txtMangKQ.setText(kq);

			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimKiem.setBounds(250, 448, 174, 41);
		contentPane.add(btnTimKiem);
	}

	private int[][] mang(int n, int m) {
		int[][] mang = new int[n][m];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mang[i][j] = random.nextInt(100);
			}
		}
		return mang;
	}

	private String mangChuoi(int[][] mang) {
		String chuoi = "";
		for (int i = 0; i < mang.length; i++) {
			for (int j = 0; j < mang[i].length; j++) {
				chuoi += mang[i][j] + " ";
			}
			chuoi += "\n";
		}
		return chuoi;
	}

	private int[] xulyMangHaiChieu(int[][] mang) {
		int[] mangKQ = new int[6];
		int soPTchan = 0;
		int soPTle = 0;
		int tongchan = 0;
		int tongle = 0;
		int max = mang[0][0];
		int min = mang[0][0];
		for (int i = 0; i < mang.length; i++) {
			for (int j = 0; j < mang[i].length; j++) {
				if (mang[i][j] % 2 == 0) {
					soPTchan++;
					tongchan += mang[i][j];
				}
				if (mang[i][j] % 2 != 0) {
					soPTle++;
					tongle += mang[i][j];
				}
				if (max < mang[i][j]) {
					max = mang[i][j];
				}
				if (min > mang[i][j]) {
					min = mang[i][j];
				}

			}
		}
		mangKQ[0] = soPTchan;
		mangKQ[1] = soPTle;
		mangKQ[2] = tongchan;
		mangKQ[3] = tongle;
		mangKQ[4] = max;
		mangKQ[5] = min;
		return mangKQ;
	}
}
