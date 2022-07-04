package chuong01.tuan02.bai04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private double donGia;
	private java.time.LocalDate ngaySX;
	private java.time.LocalDate ngayHH;
	private int hsd;

	public HangThucPham() {
		super();
	}

	public HangThucPham(String maHang) {
		super();
		this.maHang = maHang;
	}

	public HangThucPham(String maHang, String tenHang, double donGia, int hsd, LocalDate ngaySX, LocalDate ngayHH) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.hsd = hsd;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;

	}

	public String getMaHang() {
		return maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {

		this.tenHang = tenHang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia < 0) {
			System.out.println("Don gia phai > 0");
		} else {
			this.donGia = donGia;
		}
	}

	public java.time.LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(java.time.LocalDate ngaySX) {
		if (ngaySX == null) {
			System.out.println("ngay san xuat khong duoc de rong");
		} else {
			this.ngaySX = ngaySX;
		}
	}

	public int getHsd() {
		return hsd;
	}

	public void setHsd(int hsd) {
		this.hsd = hsd;
	}

	public java.time.LocalDate getNgayHH() {

		return ngayHH;
	}

	public void setNgayHH(java.time.LocalDate ngayHH) {
		if (ngayHH == null && ngaySX.isBefore(ngayHH)) {
			System.out.println("Ngay khong duoc de rong ngay hh > ngay sx");
		} else {
			this.ngayHH = ngayHH;
		}
	}

	public boolean kiemTraNgay() {
		if (ngaySX.plusMonths(hsd).isBefore(ngayHH)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%s %5s %18.2f %18s %18s %18s %25s", this.maHang, this.tenHang, this.donGia,
				this.ngaySX.format(df), this.ngayHH.format(df), this.hsd,
				this.kiemTraNgay() ? "còn hạn sửa dụng" : "hết hạn sử dụng");
	}

	public static void main(String[] args) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		HangThucPham h1 = new HangThucPham("H001", "Sua Vinamik", 15000, 7, LocalDate.parse("15/06/2017", df),
				LocalDate.parse("15/01/2019", df));
		String tieude = String.format("%s %15s %18.2s %18s %18s %18s %25s", "Mã thực phẩm", "Tên thực phẩm", "Đơn giá", "ngày sản xuất", "ngày hết hạn", "hạn sử dụng", "kiem tra");
		System.out.println(tieude);
		System.out.println(h1.toString());
	}
}
