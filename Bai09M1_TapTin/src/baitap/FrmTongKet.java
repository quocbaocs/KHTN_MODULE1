package baitap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmTongKet extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtTBHK1;
	private JTextField txtTBHK2;
	private JTable tblHocSinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTongKet frame = new FrmTongKet();
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
	public FrmTongKet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel.setBounds(45, 52, 124, 29);
		contentPane.add(lblNewLabel);

		JLabel lblKhiLp = new JLabel("Kh\u1ED1i l\u1EDBp");
		lblKhiLp.setBounds(45, 107, 124, 29);
		contentPane.add(lblKhiLp);

		JLabel lblimTbHk = new JLabel("\u0110i\u1EC3m TB HK1");
		lblimTbHk.setBounds(45, 165, 124, 29);
		contentPane.add(lblimTbHk);

		JLabel lblimTbHk_1 = new JLabel("\u0110i\u1EC3m TB HK2");
		lblimTbHk_1.setBounds(45, 219, 124, 29);
		contentPane.add(lblimTbHk_1);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(171, 52, 151, 29);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		txtTBHK1 = new JTextField();
		txtTBHK1.setColumns(10);
		txtTBHK1.setBounds(171, 165, 151, 29);
		contentPane.add(txtTBHK1);

		txtTBHK2 = new JTextField();
		txtTBHK2.setColumns(10);
		txtTBHK2.setBounds(171, 219, 151, 29);
		contentPane.add(txtTBHK2);

		JComboBox cbbKhoi = new JComboBox();
		cbbKhoi.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cbbKhoi.setBounds(171, 107, 151, 29);
		contentPane.add(cbbKhoi);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "H\u1ECD v\u00E0 t\u00EAn", "Kh\u1ED1i", "TB HK1", "TB HK2", "TB c\u1EA3 n\u0103m" });
		JButton btnAdd = new JButton("Th\u00EAm m\u1EDBi");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoTen = txtHoTen.getText();
				int khoi = Integer.parseInt(cbbKhoi.getSelectedItem().toString());
				double tbhk1 = Double.parseDouble(txtTBHK1.getText());
				double tbhk2 = Double.parseDouble(txtTBHK2.getText());

				try {
					DataOutputStream out = new DataOutputStream(
							new BufferedOutputStream(new FileOutputStream("src/baitap/tongketnamhoc.txt")));
					out.writeUTF(hoTen);
					out.writeInt(khoi);
					out.writeDouble(tbhk1);
					out.writeDouble(tbhk2);
					JOptionPane.showMessageDialog(rootPane, "Kết quả học sinh đã được ghi.");
					out.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnAdd.setBounds(349, 52, 151, 29);
		contentPane.add(btnAdd);

		JButton btnContinue = new JButton("Ti\u1EBFp t\u1EE5c");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHoTen.setText("");
				txtTBHK1.setText("");
				txtTBHK2.setText("");
				cbbKhoi.setSelectedIndex(0);
			}
		});
		btnContinue.setBounds(349, 107, 151, 29);
		contentPane.add(btnContinue);

		JButton btnOpen = new JButton("\u0110\u1ECDc danh s\u00E1ch");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten;
				int khoi;
				double tbhk1;
				double tbhk2;
				double tbcn;
				try {
					DataInputStream in = new DataInputStream(
							new BufferedInputStream(new FileInputStream("src/baitap/tongketnamhoc.txt")));
					while (true) {
						hoten = in.readUTF();
						khoi = in.readInt();
						tbhk1 = in.readDouble();
						tbhk2 = in.readDouble();
						tbcn = (tbhk1 + tbhk2 * 2) / 3;
						DecimalFormat df = new DecimalFormat("###.##");
						tbcn = Double.parseDouble(df.format(tbcn));
						model.addRow(new Object[] { hoten, khoi, tbhk1, tbhk2, tbcn });
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnOpen.setBounds(349, 165, 151, 29);
		contentPane.add(btnOpen);

		JButton btnReport = new JButton("Th\u1ED1ng k\u00EA");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten;
				int khoi;
				double tbhk1;
				double tbhk2;
				double tbcn;
				// --Khoi tao thong ke;
				int soHSGioi = 0;
				int soHSKha = 0;
				int soHSTBKhaTB = 0;
				int soHSYeuKem = 0;
				try {
					DataInputStream in = new DataInputStream(
							new BufferedInputStream(new FileInputStream("src/baitap/tongketnamhoc.txt")));
					while (true) {
						hoten = in.readUTF();
						khoi = in.readInt();
						tbhk1 = in.readDouble();
						tbhk2 = in.readDouble();
						tbcn = (tbhk1 + tbhk2 * 2) / 3;
						if (tbcn >= 8) {
							soHSGioi++;
						} else if (tbcn >= 7 && tbcn < 8) {
							soHSKha++;
						} else if (tbcn >= 5 && tbcn < 7) {
							soHSTBKhaTB++;
						} else {
							soHSYeuKem++;
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				StringBuilder buider = new StringBuilder();
				buider.append("Số HS Giỏi:" + soHSGioi + "\n");
				buider.append("Số HS Khá: " + soHSKha + "\n");
				buider.append("Số HSTBKhaTB :" + soHSTBKhaTB + "\n");
				buider.append("Số HS yếu & kém: " + soHSYeuKem + "\n");

				JOptionPane.showMessageDialog(btnReport, buider.toString(), "Thống kê", 1);

			}
		});
		btnReport.setBounds(349, 219, 151, 29);
		contentPane.add(btnReport);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 263, 558, 203);
		contentPane.add(scrollPane);

		tblHocSinh = new JTable();
		tblHocSinh.setModel(model);
		scrollPane.setViewportView(tblHocSinh);
	}
}
