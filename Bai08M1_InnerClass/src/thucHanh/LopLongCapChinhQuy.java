package thucHanh;

class LopNgoai {
	private int a = 2;

	class LopTrong { // Lớp lồng cấp chính quy
		private int b = 3;

		public void xuatTrong() {
			int c = 4;
			System.out.println(String.format("a = %d, b = %d, c = %d", a, b, c));
		}
	}

	public void xuatNgoai() {
		LopTrong lt = new LopTrong(); // tạo đối tượng lớp lồng cấp bên trong lớp ngoài
		lt.xuatTrong();
	}

}

public class LopLongCapChinhQuy {
	public static void main(String[] args) {
		LopNgoai ln = new LopNgoai();
		ln.xuatNgoai();

		LopNgoai.LopTrong lt = ln.new LopTrong(); // Tạo đối tượng lớp lồng cấp bên ngoài lớp ngoài
		lt.xuatTrong();
	}
}
