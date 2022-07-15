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

	public boolean xoaLienHe(String dt) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getDtdd().contains(dt.trim())) {
				ds.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean suaThongTinLienHe(String dt, LienHe lhNew) {
		LienHe lh = new LienHe();
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getDtdd().contains(dt.trim())) {
				lh = ds.get(i);
				lh.setHoTen(lhNew.getHoTen());
				lh.setDtdd(lhNew.getDtdd());
				lh.setHoTen(lhNew.getHinh());
				ds.set(i, lh);
				return true;
			}
		}
		return false;
	}
}
