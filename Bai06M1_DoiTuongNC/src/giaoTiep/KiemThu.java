package giaoTiep;


public class KiemThu {

	public static void main(String[] args) {

		HinhHoc[] mh = new HinhHoc[3];
		mh[0] = new HinhTron(8);
		mh[1] = new HCN(8, 5);
		mh[2] = new HV(6);
		
		for (HinhHoc h : mh) {
			System.out.println(h.tenHinh() + " Chu vi: " + h.chuVi() + ", Dien tich : " + h.dienTich());
		}
	}

}
