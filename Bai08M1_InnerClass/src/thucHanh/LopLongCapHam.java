package thucHanh;

import thucHanh.LopNgoai.LopTrong;

class LopNgoai2 {
	private int a = 2;

	public void xuatNgoai() {
		int c = 4;
		class LopTrong { // Lớp lồng cấp hàm
			private int b = 3;

			public void xuatTrong() {
				int d = 5;
				System.out.println(String.format("a = %d, b = %d, c = %d, d = %d", a, b, c, d));
			}
		}

		LopTrong lt = new LopTrong(); // tạo đối tượng lồng cấp bên trong hàm
		lt.xuatTrong();
	}

}

public class LopLongCapHam {
	public static void main(String[] args) {
		LopNgoai2 ln2 = new LopNgoai2();
		ln2.xuatNgoai();
	}
}
