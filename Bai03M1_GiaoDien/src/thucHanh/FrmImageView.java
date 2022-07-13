package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class FrmImageView extends JFrame {

	private JPanel contentPane;
	private String pathImage1 = "/HinhAnh/icon-Doraemon.jpg";
	private String pathImage2 = "/HinhAnh/Nobita.jpeg";
	private String pathImage3 = "/HinhAnh/Xuka.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmImageView frame = new FrmImageView();
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
	public FrmImageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(279, 26, 583, 591);
		contentPane.add(lblHinhAnh);

		JButton btn1 = new JButton("");

		btn1.setIcon(resizeImageIcon(pathImage1));
		btn1.setBounds(10, 26, 186, 162);
		contentPane.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblHinhAnh.setIcon(ImageIconLabelSize(pathImage1, lblHinhAnh));
			}
		});
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHinhAnh.setIcon(ImageIconLabelSize(pathImage2, lblHinhAnh));

			}
		});
		btn2.setIcon(resizeImageIcon(pathImage2));
		btn2.setBounds(10, 213, 186, 162);
		contentPane.add(btn2);

		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHinhAnh.setIcon(ImageIconLabelSize(pathImage3, lblHinhAnh));
			}
		});
		btn3.setIcon(resizeImageIcon(pathImage3));
		btn3.setBounds(10, 395, 186, 162);
		contentPane.add(btn3);
	}

	private ImageIcon resizeImageIcon(String URL) {
		ImageIcon image1 = new ImageIcon(pathImg(URL));
		Image newImg = image1.getImage().getScaledInstance(170, 145, Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(newImg);
		return newImage;
	}

	private URL pathImg(String url) {
		return FrmImageView.class.getResource(url);
	}

	private ImageIcon ImageIconLabelSize(String url, JLabel lbl) {
		ImageIcon image1 = new ImageIcon(pathImg(url));
		image1.setImage(image1.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
		return image1;
	}

}
