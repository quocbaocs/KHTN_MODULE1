package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public FrmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 562);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("H\u1EC7 th\u1ED1ng");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Gi\u1EDBi thi\u1EC7u");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmngNhp = new JMenuItem("\u0110\u0103ng nh\u1EADp");
		mnNewMenu.add(mntmngNhp);

		JMenuItem mntmThotRa = new JMenuItem("Tho\u00E1t ra");
		mntmThotRa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmThotRa);

		JMenu mnNewMenu_1 = new JMenu("B\u00E0i t\u1EADp");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("CheckBox - RadioButton");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCheckBox_RadioButton fcr  = new FrmCheckBox_RadioButton();
				fcr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				fcr.setAlwaysOnTop(true);
				fcr.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("List");
		mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmList frlist = new FrmList();
				frlist.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frlist.setAlwaysOnTop(true);
				frlist.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3_1);

		JMenuItem mntmNewMenuItem_3_3 = new JMenuItem("Combobox");
		mnNewMenu_1.add(mntmNewMenuItem_3_3);

		JMenuItem mntmNewMenuItem_3_2 = new JMenuItem("Table");
		mnNewMenu_1.add(mntmNewMenuItem_3_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
