package thucHanh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmHeThongBaiTap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHeThongBaiTap frame = new FrmHeThongBaiTap();
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
	public FrmHeThongBaiTap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 628);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mniBai1 = new JMenu("B\u00E0i 1");
		menuBar.add(mniBai1);
		
		JMenuItem mnThemThongTinLienHe = new JMenuItem("Th\u00F4ng tin li\u00EAn h\u1EC7");
		mnThemThongTinLienHe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmManHinhThem frmThem = new FrmManHinhThem();
				frmThem.setVisible(true);
			}
		});
		mniBai1.add(mnThemThongTinLienHe);
		
		JMenu mniBai2 = new JMenu("B\u00E0i 2");
		menuBar.add(mniBai2);
		
		JMenu mniBai3 = new JMenu("B\u00E0i 3");
		menuBar.add(mniBai3);
		
		JMenu mniBai4 = new JMenu("B\u00E0i 4");
		menuBar.add(mniBai4);
		
		JMenu mniBai5 = new JMenu("B\u00E0i 5");
		menuBar.add(mniBai5);
		
		JMenu mniBai6 = new JMenu("B\u00E0i 6");
		menuBar.add(mniBai6);
		
		JMenu mniBai7 = new JMenu("B\u00E0i 7");
		menuBar.add(mniBai7);
		
		JMenu mniBai8 = new JMenu("B\u00E0i 8");
		menuBar.add(mniBai8);
		
		JMenu mniBai9 = new JMenu("B\u00E0i 9");
		menuBar.add(mniBai9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
