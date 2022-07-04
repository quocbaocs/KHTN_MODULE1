package chuong01.tuan02.bai05;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private long soTk;
	private String tenTk;
	private double soTien;
	private String trangThai;

	public Account(long soTk, String tenTk, double soTien) {
		super();
		this.trangThai = "";
		trangThai += soTk;
		trangThai += tenTk;
		trangThai += soTien;

	}

	public Account() {
		this.trangThai = "";
		this.soTk = 9999999;
		this.tenTk = "Chưa xác định";
		this.soTien = 50;
		this.trangThai = "Các thuộc tính của TK chứa giá trị ngẫu nhiên";
	}

	public long getSoTk() {

		return soTk;
	}

	public String setSoTk(long soTk) {
		if (soTk <= 0 || soTk == 999999) {
			this.soTk = 999999;
			return "số tài khoản phải > 0 và khác 999999\n";
		}
		this.soTk = soTk;
		return "";
	}

	public String getTenTk() {
		return tenTk;
	}

	public String setTenTk(String tenTk) {
		if (tenTk.isEmpty()) {
			this.tenTk = "Chưa xác định";
			return "Tên tài khoản không được rỗng";
		}
		this.tenTk = tenTk;
		return "";
	}

	public double getSoTien() {
		return soTien;
	}

	public String setSoTien(double soTien) {
		if (soTien <= 50) {
			this.soTien = 50;
			return "Số tiền phải >=50";
		}
		this.soTien = soTien;
		return "";
	}

	public String getTrangThai() {
		return trangThai;
	}

	/**
	 * Phương thức nạp tiền
	 * 
	 */
	public String naptien(double sotiennap) {
		if (sotiennap <= 0) {
			return "Số tiền nạp phải > 0";
		}
		setSoTien(sotiennap + this.soTien);
		return "Nạp tiền thành công";
	}

	public String chuyenTien(Account tkNhan, double sotienchuyen) {
		if (tkNhan == null) {
			return "Tài khoản nhận không hợp lệ";
		}
		if (sotienchuyen > this.soTien) {
			return String.format("Số tiền chuyển [%f] phải lớn hơn số tiền có [%f] tài khoản ", sotienchuyen,
					this.soTien);
		}
		tkNhan.setSoTien(soTien - sotienchuyen);
		return "Chuyển tiền thành công";
	}

	public String rutTien(double sotienrut) {
		if (sotienrut > this.soTien) {
			return String.format("Số tiền rút [%f] phải nhỏ hơn số tiền có [%f] trong tài khoản", sotienrut,
					this.soTien);
		}
		setSoTien(this.soTien - sotienrut);
		return "Rút tiền thành công";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Locale local = new Locale("vi", "vn");
		NumberFormat formater = NumberFormat.getCurrencyInstance(local);
		return String.format("%10d %15s %15s\n", this.soTk, this.tenTk,String.valueOf(formater.format(soTien)));
	}

}
