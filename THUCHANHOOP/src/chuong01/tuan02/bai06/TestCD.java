package chuong01.tuan02.bai06;

public class TestCD {
	public static void main(String[] args) {

		ListCD list = new ListCD();
		int chon;
		do {
			chon = menu();
			switch (chon) {
			case 1:
				CD cd = nhapCD();
				list.themCD(cd);
				break;
			case 2:
				System.out.println("Số lượng cd có trong danh sách:" + list.soLuongcd());
				break;
			case 3:
				list.tongGiaThanhCD();
				break;
			case 4:
				list.thongTinToanBoCD();
				break;
			case 5:
				list.sapXepGiamTheoGiaThanh();
				break;
			case 6:
				list.sapXepTangTheoTua();
				break;
			}
		} while (chon < 7);
	}

	private static CD nhapCD() {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		System.out.println("Nhập vào mã CD: ");
		int ma = sc.nextInt();
		System.out.println("Nhập vào tựa CD: ");
		sc.nextLine();
		String tua = sc.nextLine();
		System.out.println("Nhập vào số bài hát: ");
		int sobaihat = sc.nextInt();
		System.out.println("Nhập vào giá thành: ");
		double gia = sc.nextDouble();
		CD cd = new CD(ma, tua, sobaihat, gia);
		return cd;
	}

	private static int menu() {

		// TODO Auto-generated method stub
		int chon;
		System.out.println("1. Thêm một cd");
		System.out.println("2. Tính số lượng CD có trong danh sách");
		System.out.println("3. Tính tổng giá thành của các CD");
		System.out.println("4. Trả thông tin toàn bộ CD có trong danh sách");
		System.out.println("5. Sắp xếp CD giảm dần theo giá thành");
		System.out.println("6. Sắp xếp CD tăng dần theo tựa");
		System.out.println("Nhập vào lựa chọn: ");
		chon = new java.util.Scanner(java.lang.System.in).nextInt();
		return chon;
	}

}
