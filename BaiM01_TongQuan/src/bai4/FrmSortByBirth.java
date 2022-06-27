package bai4;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmSortByBirth extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtBirth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSortByBirth frame = new FrmSortByBirth();
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
	public FrmSortByBirth() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 100, 38);
		contentPane.add(lblNewLabel);

		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBirth.setBounds(10, 58, 100, 38);
		contentPane.add(lblBirth);

		txtName = new JTextField();
		txtName.setBounds(120, 10, 182, 38);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtBirth = new JTextField();
		txtBirth.setColumns(10);
		txtBirth.setBounds(120, 58, 182, 38);
		contentPane.add(txtBirth);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 438, 319);
		contentPane.add(scrollPane);

		JList lstMain = new JList();
		scrollPane.setViewportView(lstMain);

		List<Person> list = new ArrayList<Person>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				String name = txtName.getText();
				int birth = Integer.parseInt(txtBirth.getText());
				Person per = new Person(name, birth);
				System.out.println("---------------");
				list.add(per);
				Collections.sort(list);
				for(Person p: list) {
					System.out.println(p);
					model.addElement(p.toString());
				}
				lstMain.setModel(model);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(312, 10, 136, 86);
		contentPane.add(btnAdd);
	}
}
