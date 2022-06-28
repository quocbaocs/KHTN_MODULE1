package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmAnimalSayHello extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAnimalSayHello frame = new FrmAnimalSayHello();
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
	public FrmAnimalSayHello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(61, 22, 85, 32);
		contentPane.add(lblNewLabel);

		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnimal.setBounds(61, 73, 85, 32);
		contentPane.add(lblAnimal);

		JLabel lblHello = new JLabel("");
		lblHello.setForeground(Color.RED);
		lblHello.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHello.setBounds(61, 196, 247, 32);
		contentPane.add(lblHello);

		JComboBox cmbAnimal = new JComboBox();
		cmbAnimal.setBounds(163, 73, 125, 32);
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel) cmbAnimal.getModel();
		model.addElement("Cat");
		model.addElement("Dog");
		contentPane.add(cmbAnimal);

		txtName = new JTextField();
		txtName.setBounds(163, 24, 125, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblImage = new JLabel("New label");
		lblImage.setBounds(308, 37, 261, 259);
		contentPane.add(lblImage);

		JButton btnSayHello = new JButton("Say hello");
		btnSayHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String path = "src/HinhAnh/";
				javax.swing.ImageIcon img = null;
				switch (cmbAnimal.getSelectedItem().toString()) {
				case "Dog":
					Dog dog = new Dog(name, "1_dog.png");
					lblHello.setText(dog.sayHello());
					img = new javax.swing.ImageIcon(path + dog.getImage());
					img.setImage(img.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
							Image.SCALE_SMOOTH));
					lblImage.setIcon(img);
					break;
				case "Cat":
					Cat cat = new Cat(name, "1_cat.png");
					lblHello.setText(cat.sayHello());
					img = new javax.swing.ImageIcon(path + cat.getImage());
					img.setImage(img.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
							Image.SCALE_SMOOTH));
					lblImage.setIcon(img);
					break;
				default:
				case "Pig":
					Pig pig = new Pig(name, "1_pig.png");
					lblHello.setText(pig.sayHello());
					img = new javax.swing.ImageIcon(path + pig.getImage());
					img.setImage(img.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
					lblImage.setIcon(img);
					break;
					
				}
			}
		});
		btnSayHello.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSayHello.setBounds(163, 129, 125, 32);
		contentPane.add(btnSayHello);

	}
}
