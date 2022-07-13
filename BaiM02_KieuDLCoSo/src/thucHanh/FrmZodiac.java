package bai2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmZodiac extends JFrame {

	private JPanel contentPane;
	private JTextField txtYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmZodiac frame = new FrmZodiac();
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
	public FrmZodiac() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Year of birth");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 28, 107, 33);
		contentPane.add(lblNewLabel);

		txtYear = new JTextField();
		txtYear.setBounds(149, 28, 128, 33);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		txtYear.setHorizontalAlignment(JTextField.CENTER);
		JLabel lblImage = new JLabel("");
		lblImage.setForeground(Color.RED);
		lblImage.setBounds(143, 113, 164, 124);
		contentPane.add(lblImage);

		JLabel lblCan = new JLabel("");
		lblCan.setForeground(Color.RED);
		lblCan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCan.setBounds(153, 247, 60, 33);
		contentPane.add(lblCan);

		JLabel lblChi = new JLabel("");
		lblChi.setForeground(Color.RED);
		lblChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChi.setBounds(212, 247, 107, 33);
		
		contentPane.add(lblChi);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(txtYear.getText());
				String[] str = returnChi(year).split(",");
				ImageIcon icon = new ImageIcon("src/HinhAnh/" + str[1]);
				icon.setImage(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
						Image.SCALE_SMOOTH));
				lblImage.setIcon(icon);
				lblCan.setText(returnCan(year));
				lblChi.setText(str[0]);
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOK.setBounds(39, 71, 372, 21);
		contentPane.add(btnOK);

	}

	private String returnCan(int year) {
		int can = year % 10;
		System.out.println(can);
		String str = "";
		switch (can) {
		case 0:
			str = "Canh";
			break;
		case 1:
			str = "Tân";
			break;
		case 2:
			str = "Nhâm";
			break;
		case 3:
			str = "Quý";
			break;
		case 4:
			str = "Giáp";
			break;
		case 5:
			str = "Ất";
			break;
		case 6:
			str = "Bính";
			break;
		case 7:
			str = "Đinh";
			break;
		case 8:
			str = "Mậu";
			break;
		case 9:
			str = "Kỷ";
			break;

		}
		return str;
	}

	private String returnChi(int year) {
		int chi = year % 12;
		String str = "";
		switch (chi) {
		case 1:
			str = "Dậu,dau.jpg";
			break;
		case 2:
			str = "Tuất,tuat.jpg";
			break;
		case 3:
			str = "Hợi,1_pig.jpg";
			break;
		case 4:
			str = "Tý,ti.jpg";
			break;
		case 5:
			str = "Sửu,suu.jpg";
			break;
		case 6:
			str = "Dần,dan.jpg";
			break;
		case 7:
			str = "Mão,1_cat.png";
			break;
		case 8:
			str = "Thìn,thin.jpg";
			break;
		case 9:
			str = "Tỵ,ty.jpg";
			break;
		case 10:
			str = "Ngọ,ngo.jpg";
			break;
		case 11:
			str = "Mùi,mui.jpg";
			break;
		case 0:
			str = "Thân,than.jpg";
			break;
		}
		return str;
	}
}
