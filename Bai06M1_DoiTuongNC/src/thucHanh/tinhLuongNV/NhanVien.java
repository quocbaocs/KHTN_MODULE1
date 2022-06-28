package thucHanh.tinhLuongNV;

public class NhanVien {
	final double LUONGCOBAN = 1550000;
	double heSoLuong;

	public NhanVien(double heSoLuong) {
		super();
		this.heSoLuong = heSoLuong;
	}

	public NhanVien() {
		super();
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getLUONGCOBAN() {
		return LUONGCOBAN;
	}

	public double tinhLuong() {
		return this.LUONGCOBAN * heSoLuong;
	}
}
