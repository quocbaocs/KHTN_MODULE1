package thucHanh;

interface PhepTinh {
	public double tinh(int a, int b);
}

//Cách 1: Cách chính thống
class Cong implements PhepTinh {

	@Override
	public double tinh(int a, int b) {
		// TODO Auto-generated method stub
		return (double) a + b;
	}

}

public class LongCapVoDanh {
	public static void main(String[] args) {
		int a = 5, b = 4;
		double tong, hieu, tich, thuong;
		Cong cong = new Cong();
		tong = cong.tinh(a, b);
		System.out.println("tong = " + tong);

		// Cách 2: lồng cấp vô danh
		PhepTinh tru = new PhepTinh() {

			@Override
			public double tinh(int a, int b) {
				// TODO Auto-generated method stub
				return a - b;
			}
		};
		hieu = tru.tinh(a, b);
		System.out.println("Hieu = " + hieu);

		PhepTinh nhan = new PhepTinh() {

			@Override
			public double tinh(int a, int b) {
				// TODO Auto-generated method stub
				return a * b;
			}

		};
		tich = nhan.tinh(a, b);
		System.out.println("tich = " + tich);

		PhepTinh chia = new PhepTinh() {

			@Override
			public double tinh(int a, int b) {
				// TODO Auto-generated method stub
				return a / b;
			}
		};
	}

}
