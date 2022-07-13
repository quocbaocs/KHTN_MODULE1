package bai4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmScoreBoard extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmScoreBoard frame = new FrmScoreBoard();
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
	public FrmScoreBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setToolTipText("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 161, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Score");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(255, 10, 161, 39);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 492, 345);
		contentPane.add(scrollPane);
		
		JList lstMain = new JList();
		scrollPane.setViewportView(lstMain);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(535, 10, 176, 84);
		contentPane.add(btnAdd);
		
		JButton btnSortName = new JButton("Sort Name");
		btnSortName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSortName.setBounds(535, 106, 176, 84);
		contentPane.add(btnSortName);
		
		JButton btnScore = new JButton("Sort Score");
		btnScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnScore.setBounds(535, 202, 176, 84);
		contentPane.add(btnScore);
		
		JButton btnSearch = new JButton("Find");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(535, 345, 176, 84);
		contentPane.add(btnSearch);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(535, 296, 176, 39);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 10, 176, 39);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(318, 10, 176, 39);
		contentPane.add(textField_1);
		
		
	}
}
