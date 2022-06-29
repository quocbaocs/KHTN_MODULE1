package thucHanh.nhaccu;

public class NhacCuKhongDay extends NhacCu {

	private String sudung;

	public NhacCuKhongDay() {
		super();
	}

	public NhacCuKhongDay(String ten, String hinh, String sudung) {
		super(ten, hinh);
		this.sudung = sudung;
	}

	public String getSudung() {
		return sudung;
	}

	public void setSudung(String sudung) {
		this.sudung = sudung;
	}

	@Override
	String choiNhac() {
		// TODO Auto-generated method stub
		return "Phát ra âm thanh khi tác động vào "+this.sudung;
	}
}
