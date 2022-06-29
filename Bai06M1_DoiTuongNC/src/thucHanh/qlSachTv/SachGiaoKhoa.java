package thucHanh.qlSachTv;

public class SachGiaoKhoa extends Sach {
	private boolean tinhTrang;

	public SachGiaoKhoa() {
		super();
	}

	public SachGiaoKhoa(String maSach, String tenSach, String ngayNhap, String nXB, double donGia, int soLuong,
			boolean tinhTrang) {
		super(maSach, tenSach, ngayNhap, nXB, donGia, soLuong);
		this.tinhTrang = tinhTrang;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public double tinhThanhTien() {
		// TODO Auto-generated method stub
		double thanhtien = 0;
		if (tinhTrang == true) {
			thanhtien = super.tinhThanhTien();
		} else if(tinhTrang == false){
			thanhtien = (super.tinhThanhTien() * 50) / 100;
		}
		return thanhtien;
	}

	public String Xuat() {
		return "Sach [maSach=" + this.getMaSach() + ", tenSach=" + this.getTenSach() + ", ngayNhap="
				+ this.getNgayNhap() + ", NXB=" + this.getNXB() + ", donGia=" + this.getDonGia() + ", soLuong="
				+ this.getSoLuong() + "]";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.getSoLuong() + " - " + this.getDonGia() + " - " + tinhThanhTien();
	}
}
