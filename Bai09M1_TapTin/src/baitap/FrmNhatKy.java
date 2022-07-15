package baitap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmNhatKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtNgay;
	private JTextArea txtaNoiDung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhatKy frame = new FrmNhatKy();
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
	public FrmNhatKy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ng\u00E0y - gi\u1EDD");
		lblNewLabel.setBounds(255, 25, 91, 24);
		contentPane.add(lblNewLabel);

		txtNgay = new JTextField();
		txtNgay.setBounds(367, 27, 226, 24);
		contentPane.add(txtNgay);
		txtNgay.setColumns(10);

		// --- seting date now note
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		txtNgay.setText(String.valueOf(dateFormat.format(date)));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 93, 465, 331);
		contentPane.add(scrollPane);

		txtaNoiDung = new JTextArea();
		scrollPane.setViewportView(txtaNoiDung);
		txtaNoiDung.setEditable(true);
		txtaNoiDung.setText("");

		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nhatKy = "";
				String ngay;
				String noiDung;
				try (DataInputStream in = new DataInputStream(
						new BufferedInputStream(new FileInputStream("src/baitap/daily.txt")))) {
					while (true) {
						ngay = in.readUTF();
						noiDung = in.readUTF();
						nhatKy += ngay + "\n" + noiDung + "\n\n";
					}
				} catch (EOFException e2) {
				} catch (IOException ex) {

				}
				txtaNoiDung.setText(nhatKy);
				txtaNoiDung.setEditable(false);
			}
		});

		btnOpen.setIcon(new ImageIcon(FrmNhatKy.class.getResource("/HinhAnh/read.jpg")));
		btnOpen.setBounds(32, 93, 60, 60);
		contentPane.add(btnOpen);

		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNgay.setText(dateFormat.format(date));
				txtaNoiDung.setEditable(true);
				txtaNoiDung.setText("");
			}
		});
		btnNew.setIcon(new ImageIcon(FrmNhatKy.class.getResource("/HinhAnh/write.jpg")));
		btnNew.setBounds(32, 220, 60, 61);
		contentPane.add(btnNew);

		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ngay = txtNgay.getText();
				String noiDung = txtaNoiDung.getText();
				try (DataOutputStream out = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream("src/baitap/daily.txt", true)))) {
					out.writeUTF(ngay);
					out.writeUTF(noiDung);
					JOptionPane.showMessageDialog(rootPane, "Nhật ký đã được ghi.");
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		btnSave.setIcon(new ImageIcon(FrmNhatKy.class.getResource("/HinhAnh/save.jpg")));
		btnSave.setBounds(32, 363, 60, 61);
		contentPane.add(btnSave);
	}
}
