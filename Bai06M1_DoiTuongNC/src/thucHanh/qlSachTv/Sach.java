package thucHanh.qlSachTv;

public class Sach {
	private String maSach;
	private String tenSach;
	private String ngayNhap;
	private String NXB;
	private double donGia;
	private int soLuong;

	public Sach() {
		super();
	}

	public Sach(String maSach, String tenSach, String ngayNhap, String nXB, double donGia, int soLuong) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.ngayNhap = ngayNhap;
		this.NXB = nXB;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double tinhThanhTien() {

		return this.soLuong * this.donGia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.maSach + " - " + this.getTenSach() + " - " + this.ngayNhap + " - " + this.NXB + " - ";
	}

	
	
	

}
