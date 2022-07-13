package thucHanh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmBookingMovieTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSeat;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBookingMovieTicket frame = new FrmBookingMovieTicket();
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
	@SuppressWarnings("unchecked")
	public FrmBookingMovieTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.lightGray);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Seat(S)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(29, 39, 113, 42);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setForeground(Color.white);
		lblName.setBounds(29, 94, 113, 42);
		contentPane.add(lblName);

		JLabel lblMovies = new JLabel("Movies");
		lblMovies.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMovies.setBounds(29, 146, 113, 42);
		lblMovies.setForeground(Color.white);
		contentPane.add(lblMovies);

		String[] data = getFilmList();
		Integer[] idx = new Integer[data.length];
		for (int a = 0; a < data.length; a++) {
			idx[a] = new Integer(a);
		}
		JComboBox<?> cbbMovies = new JComboBox<Object>(idx);
		cbbMovies.setRenderer(new ImageRender(data));
		cbbMovies.setBackground(new Color(255, 255, 255));
		cbbMovies.setBounds(172, 147, 215, 155);
		contentPane.add(cbbMovies);

		JButton btnBook = new JButton("Book");
		btnBook.setBackground(Color.white);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBook.setBounds(272, 332, 228, 62);
		contentPane.add(btnBook);

		txtSeat = new JTextField();
		txtSeat.setBounds(172, 42, 207, 42);
		contentPane.add(txtSeat);
		txtSeat.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(172, 94, 342, 42);
		contentPane.add(txtName);
	}

	private String[] getFilmList() {

		// File myFile = new File("./src/FirmList.txt");
		StringBuilder sb = new StringBuilder();
		String temp[] = null;
		try (BufferedReader br = Files.newBufferedReader(Paths.get("./src/FirmList.txt"))) {
			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");

			}
			String subString = sb.toString();
			temp = subString.split("\n");
			return temp;

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return null;

	}

}
