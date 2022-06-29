package thucHanh.phuongtiengt;

public class XeHoi implements PhuongTienGiaoThong, DongCo {

	String tenXe;
	String hangSanXuat;

	public XeHoi() {
		super();
	}

	public XeHoi(String tenXe, String hangSanXuat) {
		super();
		this.tenXe = tenXe;
		this.hangSanXuat = hangSanXuat;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	@Override
	public double tinhTieuTHuNhienLieu(double quangDuong, double soLit) {
		// TODO Auto-generated method stub
		return quangDuong / soLit;
	}

	/*
	 * 
	 */
	@Override
	public double tinhVanToc(double quangDuong, double thoiGian) {
		// TODO Auto-generated method stub
		return quangDuong / thoiGian;
	}

}
