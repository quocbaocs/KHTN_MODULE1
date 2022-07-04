package chuong02.tuan0304.bai1;

public class DanhSachHD {
	private HoaDon[] dsHD;
	int count;
	HoaDon hd;

	public DanhSachHD(int x) {
		super();
		count = 0;
		if (x > 0) {
			dsHD = new HoaDon[x];
		} else {
			dsHD = new HoaDon[10];
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int demHoaDonNgay() {
		int dem = 0;
		for (int i = 0; i < dsHD.length; i++) {
			if (dsHD[i] instanceof HoaDonNgay) {
				dem++;
			}
		}
		return dem;
	}

	public int demHoaDonGio() {
		int dem = 0;
		for (HoaDon hd : dsHD) {
			if (hd instanceof HoaDonGio) {
				dem++;
			}
		}
		return dem;
	}

	public String dsHoaDonGio() {
		String kq = "";
		for (HoaDon hd : dsHD) {
			if (hd instanceof HoaDonGio) {
				kq += hd.toString() + "\n";
			}
		}
		return kq;
	}

	public String dsHoaDonNgay() {
		String kq = "";
		for (HoaDon hd : dsHD) {
			if (hd instanceof HoaDonNgay) {
				kq += hd.toString() + "\n";
			}
		}
		return kq;
	}

	public boolean themHD(HoaDon hd) {
		if (count < dsHD.length) {
			dsHD[count] = hd;
			count++;
			return true;
		}
		return false;
	}

}
