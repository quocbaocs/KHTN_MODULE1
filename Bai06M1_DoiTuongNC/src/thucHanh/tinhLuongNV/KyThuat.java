package thucHanh.tinhLuongNV;

public class KyThuat extends NhanVien {
	int soDuAnHoanThanh;

	public KyThuat() {
		// TODO Auto-generated constructor stub
		super();
	}

	public KyThuat(double heSoLuong, int soDuAnHoanThanh) {
		super(heSoLuong);
		this.soDuAnHoanThanh = soDuAnHoanThanh;
	}

	public int getSoDuAnHoanThanh() {
		return soDuAnHoanThanh;
	}

	public void setSoDuAnHoanThanh(int soDuAnHoanThanh) {
		this.soDuAnHoanThanh = soDuAnHoanThanh;
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return super.tinhLuong() + (this.soDuAnHoanThanh * 1000000);
	}

}
