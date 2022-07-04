package chuong01.tuan02.bai03;

public class Vehicle {
	private String tenChuXe;
	private String loaiXe;
	private int dungTich;
	private double triGia;

	public Vehicle() {
		super();
	}

	public Vehicle(String tenChuXe, String loaiXe, int dungTich, double triGia) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	public String getTenChuXe() {
		return tenChuXe;
	}

	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public int getDungTich() {
		return dungTich;
	}

	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}

	public double getTriGia() {
		return triGia;
	}

	public void setTriGia(double triGia) {
		this.triGia = triGia;
	}

	public double tinhThue() {
		double thue = 0;
		if (this.dungTich < 100) {
			thue = this.triGia * 0.01;
		} else if (this.dungTich >= 100 && this.dungTich <= 200) {
			thue = this.triGia * 0.03;
		} else if (this.dungTich > 200) {
			thue = this.triGia * 0.05;
		}
		return thue;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5s %20s %15d %28.2f %35.2f", this.tenChuXe, this.loaiXe, this.dungTich, this.triGia, this.tinhThue());
	}
}
