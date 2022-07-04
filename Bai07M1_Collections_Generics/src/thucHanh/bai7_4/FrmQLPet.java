package thucHanh.bai7_4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmQLPet extends JFrame {

	private JPanel contentPane;
	private JTextField txtDogs;
	private JTextField txtCats;
	private JList listDogNCat;
	private thucHanh.bai7_4.PetManager<Dog> managerDog = new PetManager<Dog>();
	private thucHanh.bai7_4.PetManager<Cat> managerCat = new PetManager<Cat>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLPet frame = new FrmQLPet();
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
	public FrmQLPet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00E1c b\u1EA1n dog \u0111\u01B0\u1EE3c nh\u1EADp v\u1EC1 ");
		lblNewLabel.setBounds(22, 31, 162, 17);
		contentPane.add(lblNewLabel);

		JLabel lblCcBnCat = new JLabel("C\u00E1c b\u1EA1n Cat \u0111\u01B0\u1EE3c nh\u1EADp v\u1EC1");
		lblCcBnCat.setBounds(22, 59, 151, 20);
		contentPane.add(lblCcBnCat);

		txtDogs = new JTextField();
		txtDogs.setBounds(180, 29, 285, 20);
		contentPane.add(txtDogs);
		txtDogs.setColumns(10);

		txtCats = new JTextField();
		txtCats.setColumns(10);
		txtCats.setBounds(180, 59, 285, 20);
		contentPane.add(txtCats);

		JButton btnThem = new JButton("Th\u00EAm m\u1EDBi");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dogs = txtDogs.getText();
				String cats = txtCats.getText();
				String dogNames[] = dogs.split(",");
				String catNames[] = cats.split(",");
				for (String dogName : dogNames) {
					managerDog.getPets().add(new Dog(dogName));
				}
				for (String catName : catNames) {
					managerCat.getPets().add(new Cat(catName));
				}

				DefaultListModel model = new DefaultListModel();
				if (managerDog != null && !managerDog.getPets().isEmpty()) {
					for (int i = 0; i < managerDog.getPets().size(); i++) {
						model.addElement(managerDog.getPets().get(i));
					}
				}
				if (managerCat != null && !managerCat.getPets().isEmpty()) {
					for (int i = 0; i < managerCat.getPets().size(); i++) {
						model.addElement(managerCat.getPets().get(i));
					}
				}
				listDogNCat.setModel(model);
			}

		});
		btnThem.setBounds(180, 101, 89, 23);
		contentPane.add(btnThem);

		JButton btnTiepTuc = new JButton("Ti\u1EBFp t\u1EE5c");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCats.setText("");
				txtDogs.setText("");
			}
		});
		btnTiepTuc.setBounds(291, 101, 89, 23);
		contentPane.add(btnTiepTuc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 137, 443, 158);
		contentPane.add(scrollPane);

		listDogNCat = new JList();
		scrollPane.setViewportView(listDogNCat);
	}

}
