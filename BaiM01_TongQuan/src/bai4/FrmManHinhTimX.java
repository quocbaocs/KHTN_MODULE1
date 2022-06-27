package bai4;

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

public class FrmManHinhTimX extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private JTextField txtN;
	private JTextField txtX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhTimX frame = new FrmManHinhTimX();
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
	public FrmManHinhTimX() {
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

		txtX = new JTextField();
		txtX.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtX.setColumns(10);
		txtX.setBounds(250, 78, 174, 41);
		contentPane.add(txtX);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(txtN.getText());
				String mangchuoi = mangChuoi(n);
				txtMang.setText(mangchuoi);
				int[] mang = convertArrString(mangchuoi);

				String kq = "";
				int x = Integer.parseInt(txtX.getText());
				int tim = timX(x, mang);
				kq += (tim == -1) ? "Không tìm thấy" : "Tìm thấy tại vị trí " + tim;
				kq += "\n";
				kq += (xLonHon(x, mang)) ? "X lớn hơn tất cả" : "X không lớn hơn tất cả";
				kq += "\n";

				kq += "X nhỏ hơn: " + xNhoHon(x, mang);
				txtMangKQ.setText(kq);

			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimKiem.setBounds(250, 448, 174, 41);
		contentPane.add(btnTimKiem);
	}

	private int[] convertArrString(String str) {
		String[] arr = str.split(" ");
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		return arr2;
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

//	public static boolean isNumeric(String string) {
//		int intValue;
//
//		System.out.println(String.format("Parsing string: \"%s\"", string));
//
//		if (string == null || string.equals("")) {
//			System.out.println("String cannot be parsed, it is null or empty.");
//			return false;
//		}
//
//		try {
//			intValue = Integer.parseInt(string);
//			return true;
//		} catch (NumberFormatException e) {
//			System.out.println("Input String cannot be parsed to Integer.");
//		}
//		return false;
//	}
//
//	private int[] timx(int[] arr, int item) {
//		String str = "";
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == item) {
//				str += i + ",";
//			}
//		}
//		String[] index = str.split(",");
//		List<Integer> list = new ArrayList<Integer>();
//		for (String i : index) {
//			if (isNumeric(i))
//				list.add(Integer.parseInt(i));
//		}
//
//		int[] ints = new int[list.size()];
//		int i = 0;
//		for (Integer n : list) {
//			ints[i++] = n;
//		}
//		return ints;
//	}
	private int timX(int x, int[] mang) {
		int vitri = -1;
		for (int i = 0; i < mang.length; i++) {
			if (x == mang[i]) {
				vitri = i;
				break;
			}
		}
		return vitri;
	}

	private boolean xLonHon(int x, int[] mang) {
		boolean flag = true;
		for (int i : mang) {
			if (x <= i) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private String xNhoHon(int x, int[] mang) {
		String kq = "";
		for (int i : mang) {
			if (x < i)
				kq += i + " ";
		}
		return kq;

	}

}
