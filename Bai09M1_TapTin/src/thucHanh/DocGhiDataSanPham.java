package thucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocGhiDataSanPham {

	public static void main(String[] args) throws IOException {
		String[] tenSP = { "Ban Phim", "Man Hinh", "Chuot" };
		int[] soLuong = { 2, 3, 4 };
		double[] donGia = { 400000.0, 250000.0, 300000.0 };

		System.out.println("Ghi tap tin SanPham.dat...");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("sanpham.dat"));
		for (int i = 0; i < 3; i++) {
			dos.writeUTF(tenSP[i]);
			dos.writeInt(soLuong[i]);
			dos.writeDouble(donGia[i]);
		}
		dos.close();
		System.out.println("Da ghi xong tap tin");
		
		System.out.println("Doc tap tin ...");
		DataInputStream dis = new DataInputStream(new FileInputStream("sanpham.dat"));
		while(true) {
		
			try {
				String tensp = dis.readUTF();
				int sl = dis.readInt();
				double dg = dis.readDouble();
				System.out.println(String.format("%s -%d -%.2f", tensp, sl, dg));
				
			} catch (Exception e) {
				break;
				// TODO: handle exception
			}
		}
		dis.close();
		
	}

}
