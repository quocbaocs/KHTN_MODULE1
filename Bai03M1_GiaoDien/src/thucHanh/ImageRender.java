package thucHanh;

import java.awt.Component;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ImageRender extends JLabel implements ListCellRenderer {

	String daftar[];

	public ImageRender(String[] gmb) {
		// TODO Auto-generated constructor stub
		daftar = gmb;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		int idx = ((Integer) value).intValue();
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		ImageIcon img = new ImageIcon("./src/HinhAnh/" + daftar[idx].toLowerCase() + ".jpg");
		String var = daftar[idx];
		img.setImage(img.getImage().getScaledInstance(90, 130, Image.SCALE_SMOOTH));
		setIcon(img);
		setText(var);
		setHorizontalAlignment(CENTER);
		return this;
	}

}
