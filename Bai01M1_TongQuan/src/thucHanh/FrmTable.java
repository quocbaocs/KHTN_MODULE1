package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTen;
	private JTextField txtDt;
	private JTextField txtHinhAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTable frame = new FrmTable();
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
	public FrmTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 30, 756, 140);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] { { "TR\u1EA7n thanh nh\u00E2n", "056585900", "jpg" }, },
				new String[] { "H\u1ECD t\u00EAn", "\u0110i\u1EC7n tho\u1EA1i", "H\u00ECnh \u1EA3nh" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(216);
		table.getColumnModel().getColumn(2).setPreferredWidth(196);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(163, 217, 105, 30);
		contentPane.add(lblNewLabel);

		JLabel lblinThoi = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblinThoi.setBounds(163, 257, 105, 30);
		contentPane.add(lblinThoi);

		JLabel lblHnhnh = new JLabel("H\u00ECnh \u1EA3nh");
		lblHnhnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHnhnh.setBounds(163, 297, 105, 30);
		contentPane.add(lblHnhnh);

		txtTen = new JTextField();
		txtTen.setBounds(264, 217, 245, 30);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtDt = new JTextField();
		txtDt.setColumns(10);
		txtDt.setBounds(264, 257, 245, 30);
		contentPane.add(txtDt);

		txtHinhAnh = new JTextField();
		txtHinhAnh.setColumns(10);
		txtHinhAnh.setBounds(264, 297, 245, 30);
		contentPane.add(txtHinhAnh);

		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ten = txtTen.getText();
				String dt = txtDt.getText();
				String ha = txtHinhAnh.getText();
//				table.setValueAt(ten, 0, 0);
//				table.setValueAt(dt, 0, 1);
//				table.setValueAt(ha, 0, 2);

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new String[] { ten, dt, ha });
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(264, 354, 131, 48);
		contentPane.add(btnThem);
	}
}
