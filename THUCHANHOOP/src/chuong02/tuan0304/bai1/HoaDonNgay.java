package chuong02.tuan0304.bai1;

public class HoaDonNgay extends HoaDon {

	int soNgayThue;

	public HoaDonNgay() {
		super();
	}

	public HoaDonNgay(String mahd, String tenkh, String maphong, java.time.LocalDate ngayhd, Double dongia,
			int songaythue) {
		super(mahd, tenkh, maphong, ngayhd, dongia);
		this.soNgayThue = songaythue;
	}

	public HoaDonNgay(HoaDon hoadon, int songaythue) {
		super(hoadon.getMahd(), hoadon.getTenkh(), hoadon.getMaphong(), hoadon.getNgayhd(), hoadon.getDonGia());
		this.soNgayThue = songaythue;
	}

	public int getSoNgayThue() {
		return soNgayThue;
	}

	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}

	public double thanhTien() {
		return this.soNgayThue > 7 ? (donGia * soNgayThue * 0.8) : (donGia * soNgayThue);
	}

	@Override
	public String toString() {
		return "HoaDonNgay [" + super.toString() + "soNgayThue=" + soNgayThue + "thanh tien=" + this.thanhTien() + "]";
	}

}
