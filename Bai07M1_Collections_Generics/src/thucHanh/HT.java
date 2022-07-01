package thucHanh;

public class HT<T> {
	private T bk;

	public HT(T bk) {
		super();
		this.bk = bk;
	}

	public HT() {

	}

	public double chuVi() {
		double r = Double.parseDouble(bk.toString());
		return r * 2 * Math.PI;
	}

	public double dientich() {
		double r = Double.parseDouble(bk.toString());
		return r * r * Math.PI;
	}

	public String xuat() {
		// TODO Auto-generated method stub
		return String.format("Chu vi :%.2f, Dien tich: %.2f", this.chuVi(), this.dientich());
	}

	public static <E> void inMang(E[] arr) {
		for (E x : arr) {
			System.out.print(x + " ");
		}
	}

	public static void main(String[] args) {
		HT<Integer> ht = new HT<Integer>(5);
		System.out.println(ht.xuat());
		HT<Float> ht1 = new HT<Float>(6.5f);
		System.out.println(ht1.xuat());
		HT<Double> ht2 = new HT<Double>(8.5);
		System.out.println(ht2.xuat());

//		HT ht5 = new HT(5);//

		System.out.println("Mang a ");
		Integer[] a = { 1, 5, 3, 2, 4 };
		inMang(a);
		Double[] b = { 5.1, 6.2, 7.5, 8.3, 9.6 };
		inMang(b);

	}
}
