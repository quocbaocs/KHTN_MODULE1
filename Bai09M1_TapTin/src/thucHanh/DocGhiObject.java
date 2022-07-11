package thucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DocGhiObject {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SanPham sp = new SanPham("Quat treo tuong", 1, 750000);
		System.out.println("Ghi doi tuong vao tap tin");
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("sanpham.obj"));
		os.writeObject(sp);
		os.close();
		System.out.println("Da ghi xong tap tin");
		System.out.println("Doc tap tin");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sanpham.obj"));
		SanPham sp2 = (SanPham) ois.readObject();
		System.out.println(sp2.xuat());
		ois.close();
	}

}
