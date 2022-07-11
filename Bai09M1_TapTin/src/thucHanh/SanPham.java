package thucHanh;

import java.io.Serializable;

public class SanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tenSP;
	private int soLuong;
	private double donGia;

	public SanPham() {
		super();
	}

	public SanPham(String tenSP, int soLuong, double donGia) {
		super();
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String xuat() {
		return String.format("%s -%d -%.2f", tenSP, soLuong, donGia);
	}
}
