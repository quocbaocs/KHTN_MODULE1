package chuong01.tuan02.bai06;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;

	public CD() {
		super();
	}

	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
		super();
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}

	public String getTuaCD() {

		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if (tuaCD == null) {
			this.tuaCD = "chưa xác định";
		}
		this.tuaCD = tuaCD;
	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public boolean setSoBaiHat(int soBaiHat) {
		if (soBaiHat <= 0) {
			System.out.println("Số bài hát phải >0");
			return false;
		}
		this.soBaiHat = soBaiHat;
		return true;
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public boolean setGiaThanh(double giaThanh) {
		if (giaThanh <= 0) {
			System.out.println("gia thanh > 0");
			return false;
		}
		this.giaThanh = giaThanh;
		return true;
	}

	@Override
	public String toString() {
		return "CD [maCD=" + maCD + ", tuaCD=" + tuaCD + ", soBaiHat=" + soBaiHat + ", giaThanh=" + giaThanh + "]";
	}

}
