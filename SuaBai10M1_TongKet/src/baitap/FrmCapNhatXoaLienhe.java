package baitap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrmCapNhatXoaLienhe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDTDD;
	private JTextField txtHinh;
	private JTable tblKetQua;
	private List<LienHe> dslh;
	JScrollPane scrollPane;
	private final String FILENAME = "src/baitap/lienhe.txt";
	private DefaultTableModel model;
	private int dongChon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCapNhatXoaLienhe frame = new FrmCapNhatXoaLienhe();
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
	public FrmCapNhatXoaLienhe() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (new File(FILENAME).exists()) {
					try {
						FileInputStream in = new FileInputStream(FILENAME);
						ObjectInputStream ois = new ObjectInputStream(in);
						dslh = (List<LienHe>) ois.readObject();
						model = (DefaultTableModel) tblKetQua.getModel();
						for (LienHe lh : dslh) {
							ImageIcon icon = new ImageIcon("src/baitap/image/contact/" + lh.getHinh());
							model.addRow(new Object[] { icon, lh.hoTen, lh.dtdd });
							tblKetQua.setRowHeight(60);
							tblKetQua.getColumn(tblKetQua.getColumnName(0))
									.setCellRenderer(new ImageTableCellRenderer(60, 60));
						}

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(rootPane, "Kh??ng c?? d??? li???u");
				}
				tblKetQua.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						if (e.getValueIsAdjusting() == false) {
							dongChon = tblKetQua.getSelectedRow();

							if (dongChon != -1) {
								txtTen.setText(tblKetQua.getValueAt(dongChon, 1).toString());
								txtDTDD.setText(tblKetQua.getValueAt(dongChon, 2).toString());
								txtHinh.setText(tblKetQua.getValueAt(dongChon, 0).toString());
							}
						}
					}
				});
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 472);

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T??n");
		lblNewLabel.setBounds(34, 40, 121, 20);
		contentPane.add(lblNewLabel);

		JLabel lblHnh = new JLabel("H??nh");
		lblHnh.setBounds(34, 87, 121, 20);
		contentPane.add(lblHnh);

		JLabel lbltd = new JLabel("??TD??");
		lbltd.setBounds(324, 40, 121, 20);
		contentPane.add(lbltd);

		txtTen = new JTextField();
		txtTen.setBounds(109, 40, 178, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtDTDD = new JTextField();
		txtDTDD.setColumns(10);
		txtDTDD.setBounds(371, 40, 208, 20);
		contentPane.add(txtDTDD);

		txtHinh = new JTextField();
		txtHinh.setColumns(10);
		txtHinh.setBounds(109, 87, 419, 20);
		contentPane.add(txtHinh);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser("src/HinhAnh/contact/");
				openFile.showOpenDialog(null);
				File file = openFile.getSelectedFile();
				String filepath = file.getAbsolutePath();
				txtHinh.setText(filepath);
			}
		});
		btnNewButton.setBounds(538, 87, 41, 20);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("C???p nh???t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ht, dt, ha;
				ht = txtTen.getText();
				dt = txtDTDD.getText();
				ha = txtHinh.getText();
				File file = new File(ha);
				Path pathOriginal = Paths.get(ha);
				String pathImageNew = "src/baitap/image/contact/";
				try {
					Files.copy(pathOriginal, new File(pathImageNew + file.getName()).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
					System.out.println("???? ????a h??nh li??n h??? th?? m???c contact");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (dongChon != -1) {
					System.out.println(dongChon);
					LienHe lh = dslh.get(dongChon);
					lh.setDtdd(dt);
					lh.setHoTen(ht);
					lh.setHinh(file.getName());
					dslh.set(dongChon, lh);
					try (ObjectOutputStream out = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream("src/baitap/lienhe.txt")))) {
						out.writeObject(dslh);

					} catch (Exception e2) {
						// TODO: handle exception
					}

				}
			}

		});
		btnNewButton_1.setBounds(109, 129, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("X??a");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaActionPerformed(e);
			}
		});
		btnNewButton_1_1.setBounds(208, 129, 89, 23);
		contentPane.add(btnNewButton_1_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 179, 676, 210);
		contentPane.add(scrollPane);

		tblKetQua = new JTable();

		String[] columnHeaders = { "H??nh ???nh", "H??? t??n", "??TD??" };
		tblKetQua = new JTable();
		tblKetQua.setModel(new DefaultTableModel(new Object[][] {}, columnHeaders));
		tblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(tblKetQua);
	}

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
		// X??c nh???n th??ng tin x??a, n???u ch???n ?????ng ?? x??a
		if (dongChon != -1) {
			// 1. X??a trong list
			dslh.remove(dongChon);
			// 2. X??a text tr??n form
			txtTen.setText("");
			txtHinh.setText("");
			txtDTDD.setText("");
			// 3. Ghi danh s??ch vao t???p tin
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/baitap/lienhe.txt")))) {
				out.writeObject(dslh);
			} catch (Exception e) {
				// TODO: handle exception
			}
			// 4. x??a ch???n
			((DefaultTableModel) tblKetQua.getModel()).removeRow(dongChon);
			dongChon = -1;
		}

	}

}
