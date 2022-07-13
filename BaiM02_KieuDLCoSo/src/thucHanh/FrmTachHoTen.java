package bai2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class FrmTachHoTen extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtHo;
	private JTextField txtTenDem;
	private JTextField txtTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTachHoTen frame = new FrmTachHoTen();
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
	public FrmTachHoTen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(169, 43, 293, 37);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(169, 118, 111, 37);
		contentPane.add(txtHo);

		txtTenDem = new JTextField();
		txtTenDem.setColumns(10);
		txtTenDem.setBounds(169, 196, 183, 37);
		contentPane.add(txtTenDem);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(169, 266, 111, 37);
		contentPane.add(txtTen);

		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 43, 122, 37);
		contentPane.add(lblNewLabel);

		JLabel lblH = new JLabel("H\u1ECD");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblH.setBounds(21, 116, 122, 37);
		contentPane.add(lblH);

		JLabel lblTnm = new JLabel("T\u00EAn \u0111\u1EC7m");
		lblTnm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnm.setBounds(21, 194, 122, 37);
		contentPane.add(lblTnm);

		JLabel lblTn = new JLabel("T\u00EAn");
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTn.setBounds(21, 266, 122, 37);
		contentPane.add(lblTn);

		JButton btnTach = new JButton("T\u00E1ch h\u1ECD t\u00EAn");
		btnTach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten = txtHoTen.getText();
				StringTokenizer str = new StringTokenizer(hoten);
				int count = str.countTokens();
				if (count == 4) {
					txtHo.setText(str.nextToken());
					txtTenDem.setText(str.nextToken() + " " + str.nextToken());
					txtTen.setText(str.nextToken());
				} else if (count == 3) {
					txtHo.setText(str.nextToken());
					txtTenDem.setText(str.nextToken());
					txtTen.setText(str.nextToken());
				}

			}
		});
		btnTach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTach.setBounds(169, 335, 156, 48);
		contentPane.add(btnTach);
	}

}
