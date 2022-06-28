package kethua;

import java.util.Date;
public class KiemThu {
	
	/**
	 * Test class HCN, HV
	 * @param args
	 */
	public static void main1(String[] args) {
		HCN hcn1 = new HCN();
		System.out.println(hcn1.xuat());
		
		HCN hcn2 = new HCN(5,3);
		System.out.println(hcn2.toString());
		
		HV hv1 = new HV();
		System.out.println(hv1.xuat());
		
		HV hv2 = new HV(5);
		System.out.println(hv2.toString());
	}
	
	/**
	 * Test class Nguoi, Hoc sinh
	 * @param args
	 */
	public static void main(String[] args) {
		Nguoi ng1 = new Nguoi();
		System.out.println(ng1.xuat());
		Nguoi ng2 = new Nguoi("Tran Vi Tinh", new Date(), false);
		System.out.println(ng2.toString());
		
		HocSinh hs2 = new HocSinh("Le Van Vui", new Date(), true, "Le Hong Phong", "12A1");
		System.out.println(hs2.xuat());
		System.out.println(hs2.toString());
		
		System.out.println("So nguoi = "+Nguoi.getSoNguoi());
	}

}
