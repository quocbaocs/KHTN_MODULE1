package thucHanh;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FrmHinhTrongTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHinhTrongTable frame = new FrmHinhTrongTable();
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
	public FrmHinhTrongTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 619, 419);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "L\u00EA v\u0103n th\u1EAFng", "0123456789", "src/HinhAnh/contact/aman.jpg" },
						{ "Nguy\u1EC5n thanh duy", "6541236448", "src/HinhAnh/contact/aodai1.jpg" },
						{ "H\u1ED3 ng\u1ECDc h\u1EA3i", "0135498704", "src/HinhAnh/contact/aodai2.jpg" }, },
				new String[] { "H\u1ECD t\u00EAn", "\u0110i\u1EC7n tho\u1EA1i", "H\u00ECnh \u1EA3nh" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(186);
		scrollPane.setViewportView(table);

		scrollPane.setRowHeaderView(lblNewLabel);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				table.getColumnModel().getColumn(2).setCellRenderer(new TableCellRenderer() {

					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// TODO Auto-generated method stub
						javax.swing.ImageIcon icon = new javax.swing.ImageIcon(value.toString());

						JLabel lb = new JLabel();
						icon.setImage(icon.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH));

						lb.setHorizontalAlignment(JLabel.CENTER);

						lb.setIcon(icon);
						return lb;
					}

				});
				table.setRowHeight(80);
				table.repaint();

//				CellRenderer renderer = new CellRenderer();
//				table.getColumnModel().getColumn(2).setCellRenderer(renderer);
//				table.repaint();
			}
		});
	}
}
