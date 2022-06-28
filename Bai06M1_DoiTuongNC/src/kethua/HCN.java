package kethua;

public class HCN {
	private int cd;
	private int cr;
	
	public HCN() {
		// TODO Auto-generated constructor stub
		super();
	}
	public HCN(int cd, int cr) {
		this.cd = cd;
		this.cr = cr;
	}
	
	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public int getCr() {
		return cr;
	}

	public void setCr(int cr) {
		this.cr = cr;
	}

	public double chuVi() {
		return ((double) cd + cr) * 2;
	}

	public double dienTich() {
		return (double) cd * cr;
	}

	public String tenHinh() {
		return "Hinh chu nhat";
	}

	public String xuat() {
		// TODO Auto-generated method stub
		return String.format("%s co Chu vi: %.2f , Dien tich %.2f", tenHinh(), chuVi(), dienTich());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.xuat();
	}

}
