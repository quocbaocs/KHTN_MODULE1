package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import baitap.LienHe;

public class PhanSo implements Serializable {
	protected int tu, mau;
	private float val = 0;

	public PhanSo() {
		tu = 0;
		mau = 1;
	}

	public PhanSo(int tu, int mau) {
		this.tu = tu;
		this.mau = mau;
		val = (float) tu / mau;
	}

	public String toString() {
		return tu + "/" + mau + " (" + val + ")";
	}

	public static void main(String[] args) {
		try {

			// Ghi dữ liệu
			FileOutputStream fo = new FileOutputStream("src/baitap/TestO.bin");
			BufferedOutputStream bo = new BufferedOutputStream(fo);
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			System.out.println("Du lieu ghi duoc:");
			for (int i = 0; i < 4; i++) {
				int tu = (int) (Math.random() * 10);
				int mau = (int) (Math.random() * 9) + 1;
				PhanSo ps = new PhanSo(tu, mau);
				oo.writeObject(ps);
				System.out.println(ps);
			}
			oo.close();
			// Đọc dữ liệu
			FileInputStream fi = new FileInputStream("src/baitap/lienhe.txt");
			BufferedInputStream bi = new BufferedInputStream(fi);
			ObjectInputStream oi = new ObjectInputStream(bi);
			System.out.println("\nDu lieu doc duoc:");
			while (bi.available() > 0) {
				LienHe ps = (LienHe) oi.readObject();
				System.out.println(ps);
			}
			oi.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}