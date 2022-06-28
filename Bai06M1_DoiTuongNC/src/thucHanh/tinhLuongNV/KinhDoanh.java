package thucHanh.tinhLuongNV;

public class KinhDoanh extends NhanVien {

	int soSanPham;

	public KinhDoanh() {
		// TODO Auto-generated constructor stub
		super();
	}

	public KinhDoanh(double heSoLuong, int soSanPham) {
		super(heSoLuong);
		this.soSanPham = soSanPham;
	}

	public int getSosanPham() {
		return soSanPham;
	}

	public void setSosanPham(int soSanPham) {
		this.soSanPham = soSanPham;
	}
	
	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return super.tinhLuong()+(this.soSanPham*20000);
	}

}
