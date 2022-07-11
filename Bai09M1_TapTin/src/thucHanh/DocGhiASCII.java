package thucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DocGhiASCII {

	public static void main(String[] args) throws FileNotFoundException {

		int a[] = { 1, 15, 2, 232, 4 };
		PrintWriter pw = new PrintWriter(new FileOutputStream("mang.txt"));
		System.out.println("Ghi tap tin ...");
		for (int so : a) {
			// Ghi co dinh dang
			pw.printf(" %d", so);

			// pw.write(so);
		}
		pw.close();
		System.out.println("Da ghi xong tap tin ...");

		System.out.println("Doc tap tin ...");
		Scanner sc = new Scanner(new FileInputStream("mang.txt"));
		int so;
		while (sc.hasNext()) {
			so = sc.nextInt();
			System.out.print(so + " ");
		}
		sc.close();
		System.out.println("\n Da doc xong tap tin");

	}

}
