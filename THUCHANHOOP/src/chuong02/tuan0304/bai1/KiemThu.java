package chuong02.tuan0304.bai1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KiemThu {

	public static void main(String[] args) {
		DanhSachHD dshd = new DanhSachHD(20);
		int chon;
		HoaDon hd;
		do {
			chon = menu();
			switch (chon) {
			case 1:
				hd = taoHD(1);
				dshd.themHD(hd);
				break;
			case 2:
				hd = taoHD(2);
				dshd.themHD(hd);
				break;
			case 3:
				System.out.println(dshd.dsHoaDonNgay());

				break;
			case 4:
				System.out.println(dshd.dsHoaDonGio());

				break;

			}

		} while (chon < 5);
	}

	private static HoaDon taoHD(int loai) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		String mahd, tenkh, maphong;
		LocalDate ngayhd;
		Double dongia;
		int sogiothue, songaythue;
		HoaDonNgay hdngay = null;
		HoaDonGio hdgio = null;
		System.out.println("Nhap ma hd: ");
		mahd = sc.nextLine();
		System.out.println("Nhap ten kh: ");
		tenkh = sc.nextLine();
		System.out.println("Nhap ma phong: ");
		maphong = sc.nextLine();
		System.out.println("Nhap ngay lap hd: dd/mm/yyyy");
		String ngay = sc.nextLine();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ngayhd = LocalDate.parse(ngay, df);
		System.out.println("Nhập đơn giá: ");
		dongia = sc.nextDouble();
		switch (loai) {
		case 1:
			System.out.println("Nhập số ngày thuê: ");
			songaythue = sc.nextInt();
			hdngay = new HoaDonNgay(mahd, tenkh, maphong, ngayhd, dongia, songaythue);
			break;
		case 2:
			System.out.println("Nhập số giờ thuê: ");
			sogiothue = sc.nextInt();
			hdgio = new HoaDonGio(mahd, tenkh, maphong, ngayhd, dongia, sogiothue);
			break;
		}
		return loai == 1 ? hdngay : hdgio;
	}

	private static int menu() {
		// TODO Auto-generated method stub

		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		System.out.println("1. Thêm hóa đơn ngày");
		System.out.println("2. Thêm hóa đơn giờ");
		System.out.println("3. In danh sách hoa đơn ngày");
		System.out.println("4. In danh sách hóa đơn giờ");
		System.out.println("5. kết thúc");
		System.out.println("Nhập vào lựa chọn: ");
		int chon = sc.nextInt();
		return chon;

	}
}
