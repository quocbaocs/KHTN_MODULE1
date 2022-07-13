package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmList extends JFrame {

	private JPanel contentPane;
	private JTextField txtChiMuc;
	private JTextField txtMucChon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmList frame = new FrmList();
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
	public FrmList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00E1c m\u00F3n \u0103n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 53, 115, 31);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 103, 160, 131);
		contentPane.add(scrollPane);

		JList listMonAn = new JList();
		listMonAn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listMonAn.setModel(new AbstractListModel() {
			String[] values = new String[] { "C\u01A1m", "Ph\u1EDF", "B\u00FAn", "Mi\u1EBFn", "Ch\u00E1o ",
					"G\u1ECFi" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listMonAn);

		JLabel lblChMc = new JLabel("Ch\u1EC9 m\u1EE5c");
		lblChMc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChMc.setBounds(274, 53, 115, 31);
		contentPane.add(lblChMc);

		JLabel lblMcChn = new JLabel("M\u1EE5c Ch\u1ECDn");
		lblMcChn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMcChn.setBounds(274, 94, 115, 31);
		contentPane.add(lblMcChn);

		txtChiMuc = new JTextField();
		txtChiMuc.setBounds(380, 53, 199, 31);
		contentPane.add(txtChiMuc);
		txtChiMuc.setColumns(10);

		txtMucChon = new JTextField();
		txtMucChon.setColumns(10);
		txtMucChon.setBounds(380, 94, 199, 31);
		contentPane.add(txtMucChon);

		JButton btnChon = new JButton("Xem Ch\u1ECDn");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chiMuc;
				String mucChon = null;
				chiMuc = listMonAn.getSelectedIndex();
				if (chiMuc > -1) {
					mucChon = listMonAn.getSelectedValue().toString();
					txtChiMuc.setText(String.valueOf(chiMuc));
					txtMucChon.setText(mucChon);
				}
			}
		});
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChon.setBounds(380, 135, 126, 40);
		contentPane.add(btnChon);
		
		JLabel lblCcThng = new JLabel("C\u00E1c th\u00E1ng");
		lblCcThng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCcThng.setBounds(10, 256, 115, 31);
		contentPane.add(lblCcThng);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 297, 166, 141);
		contentPane.add(scrollPane_1);
		
		JList listThang = new JList();
		scrollPane_1.setViewportView(listThang);
		
		JButton btnPhatSinh = new JButton("Phat Sinh");
		btnPhatSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> model = new DefaultListModel<String>();
				for(int t =1; t<=12;t++) {
					model.addElement("Tháng "+t);
				}
				listThang.setModel(model);
			}
		});
		btnPhatSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhatSinh.setBounds(211, 398, 126, 40);
		contentPane.add(btnPhatSinh);
	}
}
