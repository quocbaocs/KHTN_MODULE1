package thucHanh.phuongtiengt;

public class TauThuy implements PhuongTienGiaoThong, DongCo {

	double trongLuong;
	int sucTai;
	double vanTocNuocXuoiDong;
	double vanTocNuocNguocDong;
	double nhienLieuTieuHao;

	public TauThuy(double trongLuong, int sucTai, double vanTocNuocXuoiDong, double vanTocNuocNguocDong,
			double nhienLieuTieuHao) {
		super();
		this.trongLuong = trongLuong;
		this.sucTai = sucTai;
		this.vanTocNuocXuoiDong = vanTocNuocXuoiDong;
		this.vanTocNuocNguocDong = vanTocNuocNguocDong;
		this.nhienLieuTieuHao = nhienLieuTieuHao;
	}

	public TauThuy() {
		super();
	}

	public double getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(double trongLuong) {
		this.trongLuong = trongLuong;
	}

	public int getSucTai() {
		return sucTai;
	}

	public void setSucTai(int sucTai) {
		this.sucTai = sucTai;
	}

	public double getVanTocNuocXuoiDong() {
		return vanTocNuocXuoiDong;
	}

	public void setVanTocNuocXuoiDong(double vanTocNuocXuoiDong) {
		this.vanTocNuocXuoiDong = vanTocNuocXuoiDong;
	}

	public double getVanTocNuocNguocDong() {
		return vanTocNuocNguocDong;
	}

	public void setVanTocNuocNguocDong(double vanTocNuocNguocDong) {
		this.vanTocNuocNguocDong = vanTocNuocNguocDong;
	}

	public double getNhienLieuTieuHao() {
		return nhienLieuTieuHao;
	}

	public void setNhienLieuTieuHao(double nhienLieuTieuHao) {
		this.nhienLieuTieuHao = nhienLieuTieuHao;
	}

	@Override
	public double tinhTieuTHuNhienLieu(double quangDuong, double soLit) {
		// TODO Auto-generated method stub

		return quangDuong / (soLit - this.getNhienLieuTieuHao());
	}

	@Override
	public double tinhVanToc(double quangDuong, double thoiGian) {
		// TODO Auto-generated method stub

		double vantoc = (quangDuong / thoiGian) + this.vanTocNuocNguocDong + this.vanTocNuocXuoiDong;
		return vantoc;
	}

}
