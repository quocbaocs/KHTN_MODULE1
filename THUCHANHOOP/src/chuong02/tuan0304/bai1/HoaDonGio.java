package chuong02.tuan0304.bai1;

import java.time.LocalDate;

public class HoaDonGio extends HoaDon {
	int soGioThue;

	public HoaDonGio(int soGioThue) {
		super();
		this.soGioThue = soGioThue;
	}

	public HoaDonGio(String mahd, String tenkh, String maphong, LocalDate ngayhd, Double dongia, int sogiothue) {
		super(mahd, tenkh, maphong, ngayhd, dongia);
		this.soGioThue = sogiothue;
	}

	public HoaDonGio(HoaDon hoadon, int sogiothue) {
		super(hoadon.getMahd(), hoadon.getTenkh(), hoadon.getMaphong(), hoadon.getNgayhd(), hoadon.getDonGia());
		this.soGioThue = sogiothue;
	}

	public int getSoGioThue() {
		return soGioThue;
	}

	public void setSoGioThue(int soGioThue) {
		this.soGioThue = soGioThue;
	}

	public double thanhTien() {
		if (soGioThue > 24 || soGioThue < 30) {
			return 24 * donGia;
		} else {
			return donGia * soGioThue;
		}
	}

	@Override
	public String toString() {
		return "HoaDonGio ["+super.toString()+" + soGioThue ="+this.soGioThue+"+, thanh tien ="+this.thanhTien()+"]";
	}

}
