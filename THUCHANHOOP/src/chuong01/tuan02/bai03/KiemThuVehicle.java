package chuong01.tuan02.bai03;

public class KiemThuVehicle {

	public static void main(String[] args) {
		Vehicle xe1 = new Vehicle("Nguyễn Thu Loan ", "Future Neo", 100, 35000000.0);
		Vehicle xe2 = new Vehicle("Lê Minh Tính", "Ford Ranger", 3000, 250000000.0);
		Vehicle xe3 = new Vehicle("Nguyễn Minh Triết ", "Landscape", 1500, 1000000000.0);
		String tieude = String.format("%5s %25s %20s %20s %40s", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá",
				"Thuế phải nộp");
		System.out.println(tieude);
		System.out.println(xe1.toString());
		System.out.println(xe2.toString());
		System.out.println(xe3.toString());

	}
}
