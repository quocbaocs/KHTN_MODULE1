package thucHanh.qlSachTv;

public class SachThamKhao extends Sach {

	private int thue;

	public SachThamKhao() {
		// TODO Auto-generated constructor stub
		super();
	}

	public SachThamKhao(String maSach, String tenSach, String ngayNhap, String nXB, double donGia, int soLuong,
			int thue) {
		super(maSach, tenSach, ngayNhap, nXB, donGia, soLuong);
		this.thue = thue;
	}

	public int getThue() {
		return thue;
	}

	public void setThue(int thue) {
		this.thue = thue;
	}

	@Override
	public double tinhThanhTien() {
		// TODO Auto-generated method stub
		return super.tinhThanhTien() + ((super.tinhThanhTien() * this.thue) / 100);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.thue + " - " + tinhThanhTien();
	}
}
