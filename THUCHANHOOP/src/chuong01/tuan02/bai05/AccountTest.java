package chuong01.tuan02.bai05;

public class AccountTest {

	public static void main(String[] args) {
		AccountList list = new AccountList();
		int chon = 0;
		do {

			chon = menu();
			switch (chon) {
			case 1:
				themTK(list);
				break;
			case 2:
				System.out.println("Số tài khoản hiện có là: " + list.getSoLuongTK());

				break;
			case 3:
				inThongTinTatCaTK(list);
				break;
			case 4:
				napTien(list);
				break;
			case 6:
				chuyenTien(list);
				break;
			case 5:
				rutTien(list);
				break;
			}
		} while (chon < 7);
	}

	private static void rutTien(AccountList list) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		int sotk;
		double sotienrut;
		System.out.println("Nhập vào số tài khoản : ");
		sotk = sc.nextInt();
		Account acc = list.timTK(sotk);
		if (acc != null) {
			System.out.println("Nhập số tiền cần rút: ");
			sotienrut = sc.nextDouble();
			System.out.println(acc.rutTien(sotienrut));
		}
	}

	private static void chuyenTien(AccountList list) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in) ;
		int sotkchuyen, sotkNhan;
		double soTienChuyen;
		System.out.println("Nhập số tài khoản chuyển : ");
		sotkchuyen = sc.nextInt();
		Account tkChuyen = list.timTK(sotkchuyen);
		if(tkChuyen!=null) {
			System.out.println("Nhập số tài khoản nhận");
			sotkNhan = sc.nextInt();
			Account tkNhan = list.timTK(sotkNhan);
			System.out.println("Nhập số tiền : ");
			soTienChuyen = sc.nextDouble();
			System.out.println(tkChuyen.chuyenTien(tkNhan, soTienChuyen));
		}
	}

	private static void napTien(AccountList list) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		int sotk;
		double sotiennap;
		System.out.println("Nhập số tk: ");
		sotk = sc.nextInt();
		Account acc = list.timTK(sotk);
		if (acc != null) {
			System.out.println("Nhập số tiền : ");
			sotiennap = sc.nextDouble();
			System.out.println(acc.naptien(sotiennap));
		}
	}

	private static void inThongTinTatCaTK(AccountList list) {
		// TODO Auto-generated method stub
		System.out.println(list.thongtinTatCaTK());
	}

	private static void themTK(AccountList list) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		int sotk;
		String tentk;
		double sotien;
		System.out.println("Nhập số tk: ");
		sotk = sc.nextInt();
		System.out.println("Nhập tên tk : ");
		sc.nextLine();// Loại bỏ phím enter lần nhập trước
		tentk = sc.nextLine();
		System.out.println("Nhập số tiền: ");
		sotien = sc.nextDouble();
		System.out.println(list.themTK(sotk, tentk, sotien));
	}

	private static int menu() {
		int chon;
		java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		System.out.println("1. Thêm tài khoản");
		System.out.println("2. Số tài khoản hiện có");
		System.out.println("3. In thông tin tất cả tài khoản");
		System.out.println("4. Nạp tiền vào tài khoản");
		System.out.println("5. Rút tiền");
		System.out.println("6. Chuyển tiền");
		chon = sc.nextInt();
		return chon;
	}

}
