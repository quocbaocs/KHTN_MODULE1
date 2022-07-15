package baitap;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class KiemThu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		try {
			DanhSachLienHe ds = new DanhSachLienHe();
			FileInputStream fi = new FileInputStream("src/baitap/lienhe.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);
			ds = (DanhSachLienHe) oi.readObject();
			
			
			for(LienHe h: ds.getList()) {
				System.out.println(h.hinh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public static void main1(String[] args) {
		try {
			DanhSachLienHe ds = new DanhSachLienHe();
			FileInputStream fi = new FileInputStream("src/baitap/lienhe.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);
			ds = (DanhSachLienHe) oi.readObject();
			for (LienHe h : ds.getList()) {
				if (h.getHoTen().contains("bao")) {
					System.out.println(h.toString());
				}
			}

			// System.out.println(ds.findLienHe("bao").toString());
			for (LienHe h : ds.getList()) {
				System.out.println(h.hinh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
