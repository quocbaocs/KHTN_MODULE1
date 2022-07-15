package baitap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachLienHe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<LienHe> ds;

	public DanhSachLienHe() {
		ds = new ArrayList<LienHe>();
	}

	public boolean themLienHe(LienHe lh) {
		ds.add(lh);
		return true;
	}

	public LienHe getLienHe(int i) {
		if (i >= 0 && i < ds.size()) {
			return ds.get(i);
		}
		return null;
	}

	public int tongLienHe() {
		return ds.size();
	}

	public LienHe findLienHe(String ten) {
		for (LienHe h : ds) {
			if (h.getHoTen().contains(ten.trim())) {
				return h;
			}
		}
		return null;
	}

	public List<LienHe> getList() {
		return ds;
	}
}
