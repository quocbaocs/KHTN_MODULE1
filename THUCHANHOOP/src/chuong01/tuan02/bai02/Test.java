package chuong01.tuan02.bai02;

public class Test {

	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(1, "Tran Minh", 7.5f, 8.2f);
		SinhVien sv2 = new SinhVien(2, "Le Huong", 7.0f, 9.2f);

		SinhVien sv3 = new SinhVien();
		sv3.setMasv(3);
		sv3.setHoTen("Minh Phước");
		sv3.setDiemLT(6.5f);
		sv3.setDiemTH(7.5f);
		System.out.println(sv1.toString());
		System.out.println(sv2.toString());
		System.out.println(sv3.toString());
	}

}
