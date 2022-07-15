package baitap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class frmManHinhThemLienHe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDtdd;
	private JTextField txtHinhanh;
	private final String FILENAME = "src/baitap/lienhe.txt";
	private DanhSachLienHe ds;

	/**
	 * Launch the application.
	 */
	private void initDanhSachLienHe() {
		if (new File(FILENAME).exists())
			napDuLieu();
		else
			ds = new DanhSachLienHe();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmManHinhThemLienHe frame = new frmManHinhThemLienHe();
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
	public frmManHinhThemLienHe() {
		initDanhSachLienHe();

		setTitle("Th\u00EAm m\u1EDBi li\u00EAn h\u1EC7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00EAm m\u1EDBi li\u00EAn h\u1EC7");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 31, 190, 31);
		contentPane.add(lblNewLabel);

		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHTn.setBounds(45, 72, 94, 31);
		contentPane.add(lblHTn);

		JLabel lbltdd = new JLabel("\u0110TDD");
		lbltdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltdd.setBounds(45, 113, 94, 31);
		contentPane.add(lbltdd);

		JLabel lblHnhnh = new JLabel("H\u00ECnh \u1EA3nh");
		lblHnhnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHnhnh.setBounds(45, 154, 94, 31);
		contentPane.add(lblHnhnh);

		txtTen = new JTextField();
		txtTen.setBounds(170, 72, 374, 31);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtDtdd = new JTextField();
		txtDtdd.setColumns(10);
		txtDtdd.setBounds(170, 113, 244, 31);
		contentPane.add(txtDtdd);

		txtHinhanh = new JTextField();
		txtHinhanh.setColumns(10);
		txtHinhanh.setBounds(170, 154, 305, 31);
		contentPane.add(txtHinhanh);

		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(593, 31, 180, 215);
		contentPane.add(lblHinhAnh);

		JButton btnChonHinh = new JButton("...");
		btnChonHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser("src/HinhAnh/contact/");
				openFile.showOpenDialog(null);
				File file = openFile.getSelectedFile();
				String filepath = file.getAbsolutePath();
				txtHinhanh.setText(filepath);
				ImageIcon icon = new ImageIcon(filepath);
//				icon.getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
				lblHinhAnh.setIcon(icon);
			}
		});
		btnChonHinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChonHinh.setBounds(485, 154, 59, 31);
		contentPane.add(btnChonHinh);
		JButton btnThemLienHe = new JButton("Th\u00EAm li\u00EAn h\u1EC7");

		btnThemLienHe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// đưa tập tin hình ảnh được chọn vào thư mục
				File f = new File(txtHinhanh.getText());
				String path = "src/baitap/image/contact/";
				String duong_dan = path + f.getName();

				try {
					Files.copy(f.toPath(), (new File(path + f.getName())).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Đã đưa hình liên hệ thư mục contact");
				} catch (IOException ex) {
					// Logger.getLogger(frmThemLienHeMoi.class.getName()).log(Level.SEVERE, null,
					// ex);
				}
				// lấy dữ liệu gán cho đối tượng liên hệ sau đó ghi vào tập tin lienhe.txt
				String hoTen = txtTen.getText();
				String dtdd = txtDtdd.getText();
				String hinhAnh = f.getName();
				LienHe h = new LienHe(hoTen, dtdd, hinhAnh);

				FileOutputStream out;
				try {
					out = new FileOutputStream(FILENAME);
					ObjectOutputStream oos = new ObjectOutputStream(out);
					ds.themLienHe(h);
					oos.writeObject(ds);
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnThemLienHe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemLienHe.setBounds(170, 225, 180, 31);
		contentPane.add(btnThemLienHe);

	}

	private void napDuLieu() {
		FileInputStream in = null;
		ObjectInputStream ois = null;
		try {
			in = new FileInputStream(FILENAME);
			ois = new ObjectInputStream(in);
			ds = (DanhSachLienHe) ois.readObject();
			ois.close();
		} catch (Exception ex) {
			ds = new  DanhSachLienHe();
			JOptionPane.showMessageDialog(null, "tao moi");
			return;
		}
	}

}
