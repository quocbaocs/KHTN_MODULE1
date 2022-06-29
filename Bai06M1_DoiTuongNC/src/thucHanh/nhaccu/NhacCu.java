package thucHanh.nhaccu;

public abstract class NhacCu {

	String ten;
	String hinh;

	abstract String choiNhac();

	public NhacCu() {
		super();
	}

	public NhacCu(String ten, String hinh) {
		super();
		this.ten = ten;
		this.hinh = hinh;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

}
