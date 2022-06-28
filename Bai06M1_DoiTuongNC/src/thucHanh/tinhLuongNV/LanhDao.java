package thucHanh.tinhLuongNV;

public class LanhDao extends NhanVien {

	public LanhDao() {
		// TODO Auto-generated constructor stub
		super();
	}

	public LanhDao(double heSoLuong) {
		super(heSoLuong);

	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return super.tinhLuong() + ((super.tinhLuong() * 10) / 100);
	}

}
