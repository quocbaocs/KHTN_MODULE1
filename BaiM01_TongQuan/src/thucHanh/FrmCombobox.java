package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCombobox extends JFrame {

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
					FrmCombobox frame = new FrmCombobox();
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
	public FrmCombobox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00E1c m\u00F3n \u0103n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 39, 135, 26);
		contentPane.add(lblNewLabel);
		
		JComboBox cboMonAn = new JComboBox();
		cboMonAn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboMonAn.setModel(new DefaultComboBoxModel(new String[] {"C\u01A1m", "Ph\u1EDF", "B\u00FAn ", "Mi\u1EBFn", "Ch\u00E1o", "G\u1ECFi"}));
		cboMonAn.setBounds(37, 75, 141, 26);
		contentPane.add(cboMonAn);
		
		JLabel lblChMc = new JLabel("Ch\u1EC9 m\u1EE5c");
		lblChMc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChMc.setBounds(253, 39, 135, 26);
		contentPane.add(lblChMc);
		
		JLabel lblMcChn = new JLabel("M\u1EE5c ch\u1ECDn");
		lblMcChn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMcChn.setBounds(253, 75, 135, 26);
		contentPane.add(lblMcChn);
		
		txtChiMuc = new JTextField();
		txtChiMuc.setBounds(361, 39, 159, 26);
		contentPane.add(txtChiMuc);
		txtChiMuc.setColumns(10);
		
		txtMucChon = new JTextField();
		txtMucChon.setColumns(10);
		txtMucChon.setBounds(361, 75, 159, 26);
		contentPane.add(txtMucChon);
		
		JButton btnChon = new JButton("Xem Ch\u1ECDn");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int chiMuc;
				String mucChon = null;
				chiMuc = cboMonAn.getSelectedIndex();
				if(chiMuc>-1) {
					mucChon = cboMonAn.getSelectedItem().toString();
					txtChiMuc.setText(String.valueOf(chiMuc));
					txtMucChon.setText(mucChon);
					
				}
			}
		});
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChon.setBounds(361, 138, 115, 37);
		contentPane.add(btnChon);
		
		JLabel lblCcThng = new JLabel("C\u00E1c th\u00E1ng");
		lblCcThng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCcThng.setBounds(37, 204, 135, 26);
		contentPane.add(lblCcThng);
		
		JComboBox<String> cboThang = new JComboBox<String>();
		cboThang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboThang.setBounds(37, 252, 141, 26);
		contentPane.add(cboThang);
		
		JButton btnPhatSinh = new JButton("Ph\u00E1t Sinh");
		btnPhatSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> dcm = (DefaultComboBoxModel)cboThang.getModel();
				for(int t=1; t<=12; t++) {
					dcm.addElement("Tháng "+t);
				}
				
			}
		});
		btnPhatSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhatSinh.setBounds(37, 303, 115, 37);
		contentPane.add(btnPhatSinh);
	}
}
