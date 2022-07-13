package thucHanh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmColorChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmColorChooser frame = new FrmColorChooser();
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
	public FrmColorChooser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Choose your color");
		setBounds(100, 100, 686, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlColor = new JPanel();
		pnlColor.setBounds(0, -11, 679, 438);
		contentPane.add(pnlColor);
		pnlColor.setLayout(null);
		
		JButton btnColorChooser = new JButton("  Choose color");
		btnColorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color c = new Color(0);//default color gray
				c = JColorChooser.showDialog(null, "Pick a color", c);
				btnColorChooser.setForeground(c);
				pnlColor.setBackground(c);
				contentPane.add(pnlColor, c);
			}
		});
		btnColorChooser.setIcon(new ImageIcon(FrmColorChooser.class.getResource("/HinhAnh/color-chooser-icon.png")));
		btnColorChooser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnColorChooser.setBounds(215, 10, 227, 58);
		pnlColor.add(btnColorChooser);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 10, 679, 428);
		ImageIcon img = new ImageIcon(FrmColorChooser.class.getResource("/HinhAnh/flower.png"));
		img.setImage(img.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(img);
		pnlColor.add(lblImage);
	}
}
