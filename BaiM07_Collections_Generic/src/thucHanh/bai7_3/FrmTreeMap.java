package thucHanh.bai7_3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmTreeMap extends JFrame {

	private JPanel contentPane;
	private JTextField txtKey;
	private JTextField txtValue;
	private Map<String, String> DanhSach = new TreeMap<String, String>();
	private JList txtList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTreeMap frame = new FrmTreeMap();
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
	public FrmTreeMap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Key");
		lblNewLabel.setBounds(67, 50, 81, 27);
		contentPane.add(lblNewLabel);

		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(277, 50, 81, 27);
		contentPane.add(lblValue);

		txtKey = new JTextField();
		txtKey.setBounds(128, 50, 139, 27);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		txtValue = new JTextField();
		txtValue.setColumns(10);
		txtValue.setBounds(347, 50, 139, 27);
		contentPane.add(txtValue);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String key = txtKey.getText();
				String value = txtValue.getText();

				DanhSach.put(key, value);
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (Object k : DanhSach.keySet()) {
					model.addElement(k + " : " + DanhSach.get(k));
				}

				txtList.setModel(model);
			}
		});
		btnAdd.setBounds(139, 101, 89, 23);
		contentPane.add(btnAdd);

		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtKey.setText("");
				txtValue.setText("");
			}
		});
		btnContinue.setBounds(296, 101, 89, 23);
		contentPane.add(btnContinue);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 566, 216);
		contentPane.add(scrollPane);

		txtList = new JList();
		scrollPane.setViewportView(txtList);
	}
}
