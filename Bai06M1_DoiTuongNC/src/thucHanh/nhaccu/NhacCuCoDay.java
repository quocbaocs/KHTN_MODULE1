package thucHanh.nhaccu;

public class NhacCuCoDay extends NhacCu {

	int soDay;

	public NhacCuCoDay() {
		super();
	}

	public NhacCuCoDay(String ten, String hinh, int soDay) {
		super(ten, hinh);
		this.soDay = soDay;
	}

	public int getSoDay() {
		return soDay;
	}

	public void setSoDay(int soDay) {
		this.soDay = soDay;
	}

	@Override
	String choiNhac() {
		// TODO Auto-generated method stub
		return this.getTen() + " có " + this.soDay;
	}

}
