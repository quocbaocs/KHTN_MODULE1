package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class FrmCheckBox_RadioButton extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCheckBox_RadioButton frame = new FrmCheckBox_RadioButton();
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
	public FrmCheckBox_RadioButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnSoThich = new JPanel();
		pnSoThich.setBorder(new TitledBorder(null, "C\u00E1c s\u1EDF th\u00EDch", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.RED));
		pnSoThich.setBounds(20, 29, 161, 165);
		contentPane.add(pnSoThich);
		pnSoThich.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("\u0110\u1ECDc s\u00E1ch");
		chckbxNewCheckBox.setBounds(30, 41, 93, 21);
		pnSoThich.add(chckbxNewCheckBox);

		JCheckBox chckbxNgheNhc = new JCheckBox("Nghe nh\u1EA1c");
		chckbxNgheNhc.setBounds(30, 77, 93, 21);
		pnSoThich.add(chckbxNgheNhc);

		JCheckBox chckbxXemPhim = new JCheckBox("Xem Phim");
		chckbxXemPhim.setBounds(30, 117, 93, 21);
		pnSoThich.add(chckbxXemPhim);

		JPanel pnMauThich = new JPanel();
		pnMauThich.setBorder(new TitledBorder(null, "M\u00E0u th\u00EDch nh\u1EA5t", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.RED));
		pnMauThich.setBounds(311, 29, 161, 165);
		contentPane.add(pnMauThich);
		pnMauThich.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("M\u00E0u Xanh");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(24, 39, 103, 21);
		pnMauThich.add(rdbtnNewRadioButton);

		JRadioButton rdbtnMu = new JRadioButton("M\u00E0u \u0111\u1ECF");
		buttonGroup.add(rdbtnMu);
		rdbtnMu.setBounds(24, 76, 103, 21);
		pnMauThich.add(rdbtnMu);

		JRadioButton rdbtnMuVng = new JRadioButton("M\u00E0u v\u00E0ng");
		buttonGroup.add(rdbtnMuVng);
		rdbtnMuVng.setBounds(24, 112, 103, 21);
		pnMauThich.add(rdbtnMuVng);

		JButton btnChon = new JButton("Xem Ch\u1ECDn\r\n");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String soThich = "", mauThich = "";
				for (Component com : pnSoThich.getComponents()) {
					JCheckBox cb = (JCheckBox) com;
					if (cb.isSelected()) {
						soThich += cb.getText() +",";
					}
				}
				for (Component com : pnMauThich.getComponents()) {
					JRadioButton rb = (JRadioButton) com;
					if (rb.isSelected()) {
						mauThich += rb.getText();
					}
				}
				JOptionPane.showMessageDialog(rootPane,
						"Các sở thích là : " + soThich + "\n Màu thích nhất là: " + mauThich);
			}
		});
		btnChon.setBounds(176, 204, 140, 44);
		contentPane.add(btnChon);
	}
}
