package thucHanh;

import java.io.FileReader;
import java.io.FileWriter;

public class DocGhiChar {
	public static void main(String[] args) {
		String s = "Trung tâm tin học Đại học Khoa học tự nhiên";
		System.out.println("Ghi tap tin Unicode...");
		try (FileWriter fw = new FileWriter("t3h.txt")) {
			fw.write(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Da ghi xong tap tin.");
		int b;
		try (FileReader fr = new FileReader("t3h.txt")) {
			while ((b = fr.read()) != -1) {

				System.out.print((char) b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("\nDoc xong tap tin");
	}

}
