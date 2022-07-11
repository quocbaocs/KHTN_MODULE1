package thucHanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocGhiData {
	public static void main(String[] args) throws IOException {
		int a[] = { 1, 15, 2, 232, 4 };
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("mang.dat"));
		System.out.println("Ghi tap tin ...");
		for (int so : a) {
			dos.writeInt(so);
		}
		dos.close();
		System.out.println("Da ghi xong tap tin");

		System.out.println("Doc tap tin");
		DataInputStream dis = new DataInputStream(new FileInputStream("mang.dat"));

		while (true) {
			int so;
			try {
				so = dis.readInt();
				System.out.println(so + " ");
			} catch (Exception e) {
				break;
				// TODO: handle exception
			}

		}

	}
}
