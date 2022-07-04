package chuong02.tuan0304.bai1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HoaDon {
	protected String mahd, tenkh, maphong;
	protected java.time.LocalDate ngayhd;
	protected Double donGia;

	public HoaDon() {
		super();
	}

	public HoaDon(String mahd, String tenkh, String maphong, LocalDate ngayhd, Double donGia) {
		super();
		this.mahd = mahd;
		this.tenkh = tenkh;
		this.maphong = maphong;
		this.ngayhd = ngayhd;
		this.donGia = donGia;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getMaphong() {
		return maphong;
	}

	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}

	public java.time.LocalDate getNgayhd() {
		return ngayhd;
	}

	public boolean setNgayhd(java.time.LocalDate ngayhd) {
		java.time.LocalDate curdate = java.time.LocalDate.now();
		if (ngayhd.compareTo(curdate) == 0) {
			this.ngayhd = ngayhd;
			return true;
		}

		return false;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		Locale local = new Locale("vi", "vn");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "HoaDon [mahd=" + mahd + ", tenkh=" + tenkh + ", maphong=" + maphong + ", ngayhd=" + ngayhd.format(df) + ", donGia="
				+ donGia + "]";
	}
	
	

}
