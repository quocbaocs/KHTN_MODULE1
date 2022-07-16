package baitap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMainLienHe extends JFrame {

	private JPanel contentPane;
	private JTable tblKetQua;
	private final String FILENAME = "src/baitap/lienhe.txt";
	private DefaultTableModel model;
	private List<LienHe> dslh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMainLienHe frame = new FrmMainLienHe();
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
	public FrmMainLienHe() {
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
					JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu");
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Liên hệ");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thêm liên hệ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmManHinhThemLienHe fm= new frmManHinhThemLienHe();
				fm.setVisible(true);
				fm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tìm kiếm liên hệ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmManHinhTimLienHe fm= new FrmManHinhTimLienHe();
				fm.setVisible(true);
				fm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cập nhật - Xóa liên hệ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCapNhatXoaLienhe fm= new FrmCapNhatXoaLienhe();
				fm.setVisible(true);
				fm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 71, 494, 221);
		contentPane.add(scrollPane);

		tblKetQua = new JTable();
		tblKetQua.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u00ECnh \u1EA3nh", "H\u1ECD t\u00EAn", "\u0110TDD"
			}
		));
		tblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(tblKetQua);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ DANH SÁCH LIÊN HỆ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(99, 11, 342, 29);
		contentPane.add(lblNewLabel);
	}
}
