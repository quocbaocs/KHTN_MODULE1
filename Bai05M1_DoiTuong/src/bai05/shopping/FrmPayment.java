package bai05.shopping;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPayment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblProduct;
	private JButton btnPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPayment frame = new FrmPayment();
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
	public FrmPayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 603, 310);
		contentPane.add(scrollPane);
//		String data[][] = { { "102", "Jai" }, { "101", "Sachin" } };
		String column[] = { "Product", "Price" };
		DefaultTableModel model = new DefaultTableModel(column,0);
		for(Product p : FrmShopping.listCart) {
			model.addRow(new String[] {p.getProductName(), p.getProductPrice()});
		}
		tblProduct = new JTable(model);
		
		tblProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(tblProduct);
		
		btnPayment = new JButton("Payment");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmInCart frmIncard = new FrmInCart();
				frmIncard.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frmIncard.setVisible(true);
			}
		});
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPayment.setBounds(199, 332, 194, 61);
		contentPane.add(btnPayment);
		
		
	}

}
