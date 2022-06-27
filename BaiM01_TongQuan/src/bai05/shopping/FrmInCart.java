package bai05.shopping;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmInCart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtCountry;
	private JTextField txtZipCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInCart frame = new FrmInCart();
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
	public FrmInCart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Card type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(97, 37, 109, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCardNumber.setBounds(97, 80, 109, 32);
		contentPane.add(lblCardNumber);
		
		JLabel lblBillInformation = new JLabel("BILL INFORMATION");
		lblBillInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBillInformation.setBounds(129, 123, 195, 32);
		contentPane.add(lblBillInformation);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(97, 176, 109, 32);
		contentPane.add(lblFullName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(97, 219, 109, 32);
		contentPane.add(lblAddress);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCountry.setBounds(97, 262, 109, 32);
		contentPane.add(lblCountry);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZipCode.setBounds(97, 305, 109, 32);
		contentPane.add(lblZipCode);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(168, 348, 109, 32);
		contentPane.add(btnNewButton);
		
		JComboBox cbbTypeCard = new JComboBox();
		cbbTypeCard.setBounds(216, 37, 215, 32);
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbbTypeCard.getModel();
		model.addElement("VisaMaster card");
		contentPane.add(cbbTypeCard);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(216, 80, 215, 32);
		contentPane.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(216, 176, 215, 32);
		contentPane.add(txtName);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(216, 219, 215, 32);
		contentPane.add(txtAddress);
		
		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(216, 262, 215, 32);
		contentPane.add(txtCountry);
		
		txtZipCode = new JTextField();
		txtZipCode.setColumns(10);
		txtZipCode.setBounds(216, 305, 215, 32);
		contentPane.add(txtZipCode);
	}
}
