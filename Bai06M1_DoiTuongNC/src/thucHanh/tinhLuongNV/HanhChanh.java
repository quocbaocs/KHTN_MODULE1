package thucHanh.tinhLuongNV;

public class HanhChanh extends NhanVien {

	double phuCap;

	public HanhChanh() {
		// TODO Auto-generated constructor stub
		super();
	}

	public HanhChanh(double heSoLuong, double phuCap) {
		super(heSoLuong);
		this.phuCap = phuCap;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return super.tinhLuong() + this.phuCap;
	}

}
