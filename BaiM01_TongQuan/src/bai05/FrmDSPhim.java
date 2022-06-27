package bai05;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmDSPhim extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenPhim;
	private JTextField txtTheLoai;
	private JTextField txtNgayChieu;
	private JTextField txtRap;
	public Phim[] phim = new Phim[5];
	public int flag = 0;
	private JLabel lblHinhAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDSPhim frame = new FrmDSPhim();
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
	public FrmDSPhim() {

		Phim p1 = new Phim("Biệt đội chim cánh cụt", "Hoạt hình", "25/12/2014", "CineBox Hòa Bình",
				"src/HinhAnh/bietdoichimcanhcut.jpg");
		Phim p2 = new Phim("Big Heros 6", "Hoạt hình", "10/01/2015", "Galaxy Nguyễn Du", "src/HinhAnh/bighero6.jpg");
		Phim p3 = new Phim("Chàng trai năm ấy", "Tình cảm", "15/01/2015", "CineBox Lý Chính Thắng",
				"src/HinhAnh/changtrainamay.jpg");
		Phim p4 = new Phim("Cuộc chiến chống Pharaon", "Giả sử", "20/01/2015", "Galaxy Nguyễn Trãi",
				"src/HinhAnh/cuocchienchongpharaon.jpg");
		Phim p5 = new Phim("Để mai tính", "Hài", "25/01/2015", "Galaxy Quang Trung", "src/HinhAnh/demaitinh.jpg");
		phim[0] = p1;
		phim[1] = p2;
		phim[2] = p3;
		phim[3] = p4;
		phim[4] = p5;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("");
		ImageIcon iconBack = new ImageIcon("src/HinhAnh/iconBack.png");
		iconBack.setImage(iconBack.getImage().getScaledInstance(82, 58, Image.SCALE_SMOOTH));
		btnBack.setIcon(iconBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackActionPerformed(e);

			}
		});
		btnBack.setBounds(10, 176, 89, 58);
		contentPane.add(btnBack);

		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		ImageIcon iconNext = new ImageIcon("src/HinhAnh/iconNext.png");
		iconNext.setImage(iconNext.getImage().getScaledInstance(82, 58, Image.SCALE_SMOOTH));
		btnNext.setIcon(iconNext);
		btnNext.setBounds(680, 176, 89, 58);
		contentPane.add(btnNext);

		lblHinhAnh = new JLabel("New label");
		lblHinhAnh.setBounds(132, 49, 258, 318);
		ImageIcon iconBig = new ImageIcon(phim[0].getDuongDanHinh());
		iconBig.setImage(iconBig.getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(),
				Image.SCALE_SMOOTH));
		lblHinhAnh.setIcon(iconBig);
		contentPane.add(lblHinhAnh);

		txtTenPhim = new JTextField();
		txtTenPhim.setBackground(Color.YELLOW);
		txtTenPhim.setText(phim[0].getTenPhim());
		txtTenPhim.setBounds(430, 67, 228, 36);
		contentPane.add(txtTenPhim);
		txtTenPhim.setColumns(10);

		txtTheLoai = new JTextField();
		txtTheLoai.setBackground(Color.ORANGE);
		txtTheLoai.setColumns(10);
		txtTheLoai.setText(phim[0].getTheLoai());
		txtTheLoai.setBounds(430, 155, 228, 36);
		contentPane.add(txtTheLoai);

		txtNgayChieu = new JTextField();
		txtNgayChieu.setBackground(Color.GREEN);
		txtNgayChieu.setColumns(10);
		txtNgayChieu.setText(phim[0].getNgayChieu());
		txtNgayChieu.setBounds(430, 242, 228, 36);
		contentPane.add(txtNgayChieu);

		txtRap = new JTextField();
		txtRap.setBackground(Color.PINK);
		txtRap.setColumns(10);
		txtRap.setText(phim[0].getRap());
		txtRap.setBounds(430, 331, 228, 36);
		contentPane.add(txtRap);
	}

	private void setTextFiled(Phim p) {
		txtTenPhim.setText(p.getTenPhim());
		txtRap.setText(p.getRap());
		txtNgayChieu.setText(p.getNgayChieu());
		txtTheLoai.setText(p.getTheLoai());
		ImageIcon icon = new ImageIcon(p.getDuongDanHinh());
		icon.setImage(
				icon.getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
		lblHinhAnh.setIcon(icon);
	}

	private void btnNextActionPerformed(ActionEvent evt) {
		if (flag < 4) {
			flag++;
			setTextFiled(phim[flag]);
		} else {
			JOptionPane.showMessageDialog(rootPane, "Đã hết phim. Vui lòng nhấn <= để xem các phim phía trước!");
		}
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		if (flag == 0) {
			JOptionPane.showMessageDialog(rootPane, "Đây là phim đầu tiên. Vui lòng nhấn => để xem các phim phía sau!");
		} else {
			flag--;
			setTextFiled(phim[flag]);

		}
	}
}
