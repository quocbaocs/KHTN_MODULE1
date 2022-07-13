package thucHanh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmCalculateYourBMI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHeight;
	private JTextField txtWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCalculateYourBMI frame = new FrmCalculateYourBMI();
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
	public FrmCalculateYourBMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Your height (m)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 35, 137, 27);
		contentPane.add(lblNewLabel);

		JLabel lblYourWeightkg = new JLabel("Your weight (kg)");
		lblYourWeightkg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYourWeightkg.setBounds(10, 82, 137, 27);
		contentPane.add(lblYourWeightkg);

		txtHeight = new JTextField();
		txtHeight.setBounds(138, 35, 137, 33);
		contentPane.add(txtHeight);
		txtHeight.setColumns(10);

		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(138, 81, 137, 33);
		contentPane.add(txtWeight);

		JLabel lblBmi = new JLabel("");
		lblBmi.setBackground(Color.RED);
		lblBmi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBmi.setBounds(156, 225, 105, 50);
		contentPane.add(lblBmi);

		JLabel lblmage = new JLabel("");
		lblmage.setBounds(10, 225, 121, 106);
		contentPane.add(lblmage);

		JButton btnCompute = new JButton("Compute BMI");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("src/HinhAnh/bmi.png");
				float height = Float.parseFloat(txtHeight.getText());
				float weight = Float.parseFloat(txtWeight.getText());
				float BMI = weight / (height * height);
				DecimalFormat df = new DecimalFormat("#.0");
				lblBmi.setText(String.valueOf(df.format(Math.round(BMI))));
				icon.setImage(
						icon.getImage().getScaledInstance(lblmage.getWidth(), lblmage.getHeight(), Image.SCALE_SMOOTH));
				lblmage.setIcon(icon);

			}
		});
		btnCompute.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCompute.setBounds(10, 147, 251, 68);
		contentPane.add(btnCompute);

	}

}
