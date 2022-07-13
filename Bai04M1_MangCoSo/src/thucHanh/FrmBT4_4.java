package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmBT4_4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtNam;
	private String[] ds = new String[0];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBT4_4 frame = new FrmBT4_4();
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
	public FrmBT4_4() {
		setTitle("B\u00E0i t\u1EADp 4.4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EAn");
		lblNewLabel.setBounds(55, 30, 76, 14);
		contentPane.add(lblNewLabel);

		txtTen = new JTextField();
		txtTen.setBounds(141, 27, 86, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("N\u0103m sinh");
		lblNewLabel_1.setBounds(55, 70, 76, 14);
		contentPane.add(lblNewLabel_1);

		txtNam = new JTextField();
		txtNam.setBounds(141, 67, 86, 20);
		contentPane.add(txtNam);
		txtNam.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 112, 170, 121);
		contentPane.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten;
				int nam;
				try {
					ten = txtTen.getText();
					if (ten.isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "Vui long nhap ten");
						txtTen.grabFocus();
						return;
					}
					try {
						nam = Integer.parseInt(txtNam.getText());
						Date homNay = new Date();
						Calendar lich = Calendar.getInstance();
						lich.setTime(homNay);
						int namHienTai = lich.get(Calendar.YEAR);
						
						if (nam < namHienTai - 90 || nam > namHienTai) {
							JOptionPane.showMessageDialog(rootPane, "Nam sinh phai tu "+ (namHienTai - 90) +" - " + namHienTai);
							txtNam.grabFocus();
							return;
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(rootPane, "Vui long nhap nam sinh la so");
						txtNam.grabFocus();
						return;
					}
					ds = Arrays.copyOf(ds, ds.length + 1);
					ds[ds.length - 1] = nam + " " + ten; // 1988 Hoang

					Arrays.sort(ds); // sap xep theo nam tang dan

					DefaultListModel dlm = new DefaultListModel();
					for (String s : ds) {
						dlm.addElement(s.substring(s.indexOf(' ')).trim() + " " + s.substring(0, s.indexOf(' ')));
					}
					list.setModel(dlm);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(rootPane, "Bi loi: " + ex.getMessage());
					txtTen.grabFocus();
					return;
				}
			}
		});
		btnThem.setBounds(282, 48, 89, 23);
		contentPane.add(btnThem);
	}
}
