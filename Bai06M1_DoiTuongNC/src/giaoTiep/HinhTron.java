package giaoTiep;

public class HinhTron implements HinhHoc {

	private int bk;

	public HinhTron() {
		super();
	}

	public HinhTron(int bk) {
		super();
		this.bk = bk;
	}

	public int getBk() {
		return bk;
	}

	public void setBk(int bk) {
		this.bk = bk;
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return bk*2*java.lang.Math.PI;
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return bk*bk*Math.PI;
	}

	@Override
	public String tenHinh() {
		// TODO Auto-generated method stub
		return "Hinh Tron";
	}

}
