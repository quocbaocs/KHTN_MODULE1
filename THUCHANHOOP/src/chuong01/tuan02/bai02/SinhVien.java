package chuong01.tuan02.bai02;

public class SinhVien {
	private int masv;
	private String hoTen;
	private float diemLT, diemTH;

	public SinhVien() {
		super();
		this.masv = 0;
		this.hoTen = "";
		this.diemLT = 0;
		this.diemTH = 0;
	}

	public SinhVien(int masv, String hoTen, float diemLT, float diemTH) {
		super();
		this.masv = masv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getMasv() {
		return this.masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	public float tinhDTB() {
		return (this.diemLT + this.diemTH) / 2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5d %-15s %8.2f %8.2f %8.2f", this.masv, this.hoTen, this.diemLT, this.diemTH, tinhDTB());
	}
}
