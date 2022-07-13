package bai2;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FrmXemBoiTinhYeu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXemBoiTinhYeu frame = new FrmXemBoiTinhYeu();
					frame.setResizable(true);
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
	public FrmXemBoiTinhYeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 582, 496);
		ImageIcon imageIcon = new ImageIcon("src/HinhAnh/love.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(800, 550, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);
	
	}
}
