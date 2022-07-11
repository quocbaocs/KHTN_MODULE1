package thucHanh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocGhiByte {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/HinhAnh/contact/aman.jpg");
		FileOutputStream fos = new FileOutputStream("mot_nguoi_dan_ong.jpg");
		int b;
		int dem = 0;
		System.out.println("Dang ghi tap tin ...");
		while ((b = fis.read()) != -1) {
			fos.write(b);
			//System.out.println("Da ghi byte thu: " + ++dem);
		}
		fis.close();
		fos.close();
		System.out.println("Da ghi xong tap tin ...");
	}

}
