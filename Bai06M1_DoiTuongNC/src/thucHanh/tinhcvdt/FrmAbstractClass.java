package thucHanh.tinhcvdt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAbstractClass extends JFrame {

	private JPanel contentPane;
	private JTextField txtR;
	private JTextField txtPTron;
	private JTextField txtSTron;
	private JTextField txtSHCN;
	private JTextField txtPHCN;
	private JTextField txtCanhB;
	private JTextField txtCanhA;
	private JTextField txtCanh;
	private JTextField txtPV;
	private JTextField txtSV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAbstractClass frame = new FrmAbstractClass();
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
	public FrmAbstractClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 610, 348);
		contentPane.add(tabbedPane);

		JPanel pnlCircle = new JPanel();
		tabbedPane.addTab("H\u00ECnh tr\u00F2n", null, pnlCircle, null);
		pnlCircle.setLayout(null);

		JLabel lblNewLabel = new JLabel("B\u00E1n k\u00EDnh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 32, 95, 31);
		pnlCircle.add(lblNewLabel);

		JLabel lblChuVi = new JLabel("Chu vi");
		lblChuVi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChuVi.setBounds(10, 87, 95, 31);
		pnlCircle.add(lblChuVi);

		JLabel lblDinTch = new JLabel("Di\u1EC7n t\u00EDch");
		lblDinTch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDinTch.setBounds(10, 142, 95, 31);
		pnlCircle.add(lblDinTch);

		JButton btnTinhPTron = new JButton("T\u00EDnh chu vi ");
		btnTinhPTron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = Integer.parseInt(txtR.getText());
				Circle c = new Circle(r);
				txtPTron.setText(String.format("%.2f", c.perimeter()));
			}
		});
		btnTinhPTron.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinhPTron.setBounds(377, 32, 154, 31);
		pnlCircle.add(btnTinhPTron);

		JButton btnTinhSTron = new JButton("T\u00EDnh di\u1EC7n t\u00EDch");
		btnTinhSTron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = Integer.parseInt(txtR.getText());
				Circle c = new Circle(r);
				txtSTron.setText(String.format("%.2f", c.area()));
			}
		});
		btnTinhSTron.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinhSTron.setBounds(377, 87, 154, 31);
		pnlCircle.add(btnTinhSTron);

		txtR = new JTextField();
		txtR.setBounds(152, 32, 174, 31);
		pnlCircle.add(txtR);
		txtR.setColumns(10);

		txtPTron = new JTextField();
		txtPTron.setColumns(10);
		txtPTron.setBounds(152, 87, 174, 31);
		pnlCircle.add(txtPTron);

		txtSTron = new JTextField();
		txtSTron.setColumns(10);
		txtSTron.setBounds(152, 142, 174, 31);
		pnlCircle.add(txtSTron);

		JPanel pnlRectangle = new JPanel();
		tabbedPane.addTab("H\u00ECnh ch\u1EEF nh\u1EADt", null, pnlRectangle, null);
		pnlRectangle.setLayout(null);

		JLabel lblChuVi_1 = new JLabel("Chu vi");
		lblChuVi_1.setBounds(27, 108, 95, 31);
		lblChuVi_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlRectangle.add(lblChuVi_1);

		JLabel lblDinTch_1 = new JLabel("Di\u1EC7n t\u00EDch");
		lblDinTch_1.setBounds(27, 150, 95, 31);
		lblDinTch_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlRectangle.add(lblDinTch_1);

		txtSHCN = new JTextField();
		txtSHCN.setBounds(169, 152, 174, 31);
		txtSHCN.setColumns(10);
		pnlRectangle.add(txtSHCN);

		txtPHCN = new JTextField();
		txtPHCN.setBounds(169, 110, 174, 31);
		txtPHCN.setColumns(10);
		pnlRectangle.add(txtPHCN);

		JButton btnPHCN = new JButton("T\u00EDnh chu vi ");
		btnPHCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int width = Integer.parseInt(txtCanhA.getText());
				int height = Integer.parseInt(txtCanhB.getText());
				Rectangle c = new Rectangle(width, height);
				txtPHCN.setText(String.valueOf(c.perimeter()));
			}
		});
		btnPHCN.setBounds(394, 108, 154, 31);
		btnPHCN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlRectangle.add(btnPHCN);

		JButton btnSHCN = new JButton("T\u00EDnh di\u1EC7n t\u00EDch");
		btnSHCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int width = Integer.parseInt(txtCanhA.getText());
				int height = Integer.parseInt(txtCanhB.getText());
				Rectangle c = new Rectangle(width, height);
				txtSHCN.setText(String.valueOf(c.area()));
			}
		});
		btnSHCN.setBounds(394, 150, 154, 31);
		btnSHCN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlRectangle.add(btnSHCN);

		txtCanhB = new JTextField();
		txtCanhB.setBounds(169, 66, 174, 31);
		txtCanhB.setColumns(10);
		pnlRectangle.add(txtCanhB);

		txtCanhA = new JTextField();
		txtCanhA.setBounds(169, 24, 174, 31);
		txtCanhA.setColumns(10);
		pnlRectangle.add(txtCanhA);

		JLabel lblNewLabel_1_1 = new JLabel("Chi\u1EC1u d\u00E0i");
		lblNewLabel_1_1.setBounds(27, 24, 95, 31);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlRectangle.add(lblNewLabel_1_1);

		JLabel lblChuVi_1_1 = new JLabel("Chi\u1EC1u r\u1ED9ng");
		lblChuVi_1_1.setBounds(27, 66, 95, 31);
		lblChuVi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlRectangle.add(lblChuVi_1_1);

		JPanel pnlSquare = new JPanel();
		tabbedPane.addTab("H\u00ECnh vu\u00F4ng", null, pnlSquare, null);
		pnlSquare.setLayout(null);

		JLabel lblCnh = new JLabel("C\u1EA1nh");
		lblCnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCnh.setBounds(31, 45, 95, 31);
		pnlSquare.add(lblCnh);

		JLabel lblChuVi_2 = new JLabel("Chu vi");
		lblChuVi_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChuVi_2.setBounds(31, 100, 95, 31);
		pnlSquare.add(lblChuVi_2);

		JLabel lblDinTch_2 = new JLabel("Di\u1EC7n t\u00EDch");
		lblDinTch_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDinTch_2.setBounds(31, 155, 95, 31);
		pnlSquare.add(lblDinTch_2);

		txtCanh = new JTextField();
		txtCanh.setColumns(10);
		txtCanh.setBounds(173, 45, 174, 31);
		pnlSquare.add(txtCanh);

		txtPV = new JTextField();
		txtPV.setColumns(10);
		txtPV.setBounds(173, 100, 174, 31);
		pnlSquare.add(txtPV);

		txtSV = new JTextField();
		txtSV.setColumns(10);
		txtSV.setBounds(173, 155, 174, 31);
		pnlSquare.add(txtSV);

		JButton btnTinhPV = new JButton("T\u00EDnh chu vi ");
		btnTinhPV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int canh = Integer.valueOf(txtCanh.getText());
				Square sq = new Square(canh);
				txtPV.setText(String.valueOf(sq.perimeter()));
			}
		});
		btnTinhPV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinhPV.setBounds(398, 100, 154, 31);
		pnlSquare.add(btnTinhPV);

		JButton btnTinhSV = new JButton("T\u00EDnh di\u1EC7n t\u00EDch");
		btnTinhSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int canh = Integer.valueOf(txtCanh.getText());
				Square sq = new Square(canh);
				txtSV.setText(String.valueOf(sq.area()));
			}
		});
		btnTinhSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTinhSV.setBounds(398, 155, 154, 31);
		pnlSquare.add(btnTinhSV);
	}
}
