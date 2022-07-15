package thucHanh;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import baitap.LienHe;

public class DocGhiObject {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SanPham sp = new SanPham("Quat treo tuong", 1, 750000);
		SanPham sp2 = new SanPham("Quat treo", 1, 800000);
		System.out.println("Ghi doi tuong vao tap tin");
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("sanpham.obj"));
		os.writeObject(sp);
		os.writeObject(sp2);
		os.close();
		System.out.println("Da ghi xong tap tin");
		System.out.println("Doc tap tin");
		FileInputStream fi = new FileInputStream("src/baitap/lienhe.txt");
		BufferedInputStream bi=new BufferedInputStream(fi);
		ObjectInputStream ois = new ObjectInputStream(bi);
		while (bi.available()>0) {
			LienHe h = (LienHe) ois.readObject();
			System.out.println(h.toString());
		}

		// ois.close();
	}

}
