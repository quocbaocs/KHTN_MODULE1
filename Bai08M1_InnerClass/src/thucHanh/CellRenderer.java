package thucHanh;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellRenderer extends JLabel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height;
	private int width;

	public CellRenderer(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	public CellRenderer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		ImageIcon icon = new ImageIcon(value.toString());
		JLabel lb = new JLabel();
		lb.setHorizontalAlignment(JLabel.CENTER);
		icon.setImage(icon.getImage().getScaledInstance(height, width, java.awt.Image.SCALE_SMOOTH));
		lb.setIcon(icon);
		return lb;
	}

}
