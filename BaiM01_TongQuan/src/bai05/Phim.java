package bai05;

public class Phim {

	private String tenPhim;
	private String theLoai;
	private String ngayChieu;
	private String rap;
	private String duongDanHinh;

	public Phim() {
		super();
	}

	public Phim(String tenPhim, String theLoai, String ngayChieu, String rap, String duongDanHinh) {
		super();
		this.tenPhim = tenPhim;
		this.theLoai = theLoai;
		this.ngayChieu = ngayChieu;
		this.rap = rap;
		this.duongDanHinh = duongDanHinh;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(String ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public String getRap() {
		return rap;
	}

	public void setRap(String rap) {
		this.rap = rap;
	}

	public String getDuongDanHinh() {
		return duongDanHinh;
	}

	public void setDuongDanHinh(String duongDanHinh) {
		this.duongDanHinh = duongDanHinh;
	}

	@Override
	public String toString() {
		return "Phim [tenPhim=" + tenPhim + ", theLoai=" + theLoai + ", ngayChieu=" + ngayChieu + ", rap=" + rap
				+ ", duongDanHinh=" + duongDanHinh + "]";
	}

}
