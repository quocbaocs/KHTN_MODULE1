package thucHanh;

public class LopLongCapTinh {
	static class Cong { // Thuộc về lớp không phải thuộc về đối tượng của lớp
		private int a;
		private int b;

		public Cong(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public double tinh() {
			return a + b;
		}

	}

	public static void main(String[] args) {
		/**
		 * nếu không có static
		 */
//		LopLongCapTinh lct = new LopLongCapTinh();
//		LopLongCapTinh.Cong cong = lct.new Cong(2,3);
//		double tong = cong.tinh();
//		System.out.println("tong = "+tong);

		/*
		 * Nếu có static
		 */

		Cong cong = new Cong(2, 3);
		double tong = cong.tinh();
		System.out.println("tong = " + tong);
	}

}
