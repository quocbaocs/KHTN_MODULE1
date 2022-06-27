package bai05.shopping;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;

public class FrmShopping extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  Product[] list = new Product[4];
	private JLabel lblProduct1, lblProduct2, lblProduct3, lblProduct4;
	public static Product[] listCart = new Product[0];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmShopping frame = new FrmShopping();
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
	public FrmShopping() {
		Product p1 = new Product("Whey Gold Standard 2lbs 900g", "500000", "src/HinhAnh/Whey-stand.jpg");
		Product p2 = new Product("Gold Standard 100% Casein 4lbs 1.82kg", "450000", "src/HinhAnh/anabolic-whey.jpg");
		Product p3 = new Product("Whey Gold Standard 2lbs 900g", "600000", "src/HinhAnh/Hydro-Whey-1590-.jpg");
		Product p4 = new Product("Labrada Lean Pro 8 5lbs 2.27kg", "450000", "src/HinhAnh/bsn-syntha-6-whey.jpg");
		list[0] = p1;
		list[1] = p2;
		list[2] = p3;
		list[3] = p4;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblProduct1 = new JLabel("1");
		lblProduct1.setBounds(0, 11, 237, 233);
		contentPane.add(lblProduct1);
		setProductImage(list[0], lblProduct1);

		lblProduct2 = new JLabel("2");
		lblProduct2.setBounds(244, 11, 237, 233);

		contentPane.add(lblProduct2);

		lblProduct3 = new JLabel("3");
		lblProduct3.setBounds(0, 255, 237, 233);
		contentPane.add(lblProduct3);

		lblProduct4 = new JLabel("4");
		lblProduct4.setBounds(244, 255, 237, 233);
		contentPane.add(lblProduct4);

		setProductImage(list[1], lblProduct2);
		setProductImage(list[2], lblProduct3);
		setProductImage(list[3], lblProduct4);

		lblProduct1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				mouseClickedLabel(evt);
			}
		});
		lblProduct2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				mouseClickedLabel(evt);
			}
		});
		lblProduct3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				mouseClickedLabel(evt);
			}
		});
		lblProduct4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				mouseClickedLabel(evt);
			}
		});

		JButton btnCart = new JButton(" Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmPayment payment = new FrmPayment();
				payment.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				payment.setVisible(true);
			}
		});
		btnCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCart.setIcon(new ImageIcon(FrmShopping.class.getResource("/HinhAnh/Cart-icon.png")));
		btnCart.setBounds(0, 486, 481, 53);
		contentPane.add(btnCart);
	}

	private void setProductImage(Product p, JLabel label) {
		ImageIcon icon = new ImageIcon(p.getProductImage());
		icon.setImage(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(icon);
	}

	private void mouseClickedLabel(MouseEvent evt) {

		System.out.println(listCart.length);
		// TODO Auto-generated method stub
		Component component = evt.getComponent();
		if (component instanceof JLabel) {
			JLabel label = (JLabel) component;
			String actionProduct = label.getText();
			if (actionProduct.equals("1")) {
				int kq = JOptionPane.showConfirmDialog(rootPane,
						"Do you want to buy ? " + list[0].getProductName().toUpperCase(), "Chu y",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (kq == JOptionPane.YES_OPTION) {
					listCart = Arrays.copyOf(listCart, listCart.length + 1);
					listCart[listCart.length - 1] = list[0];
				}
			}
			if (actionProduct.equals("2")) {
				int kq = JOptionPane.showConfirmDialog(rootPane,
						"Do you want to buy ? " + list[1].getProductName().toUpperCase(), "Chu y",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (kq == JOptionPane.YES_OPTION) {
					listCart = Arrays.copyOf(listCart, listCart.length + 1);
					listCart[listCart.length - 1] = list[1];
				}
			}
			if (actionProduct.equals("3")) {
				int kq = JOptionPane.showConfirmDialog(rootPane,
						"Do you want to buy ? " + list[2].getProductName().toUpperCase(), "Chu y",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (kq == JOptionPane.YES_OPTION) {
					listCart = Arrays.copyOf(listCart, listCart.length + 1);
					listCart[listCart.length - 1] = list[2];
				}
			}
			if (actionProduct.equals("4")) {
				int kq = JOptionPane.showConfirmDialog(rootPane,
						"Do you want to buy ? " + list[3].getProductName().toUpperCase(), "Chu y",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (kq == JOptionPane.YES_OPTION) {
					listCart = Arrays.copyOf(listCart, listCart.length + 1);
					listCart[listCart.length - 1] = list[3];
				}
			}

		}
	}

}
