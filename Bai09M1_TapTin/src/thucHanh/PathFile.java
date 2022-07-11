package thucHanh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JOptionPane;

public class PathFile {
	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("D:\\KHTN_MODULE1\\Bai09M1_TapTin\\mang.dat");
		System.out.println("File name : " + p1.getFileName());
		System.out.println("Root: " + p1.getRoot());
		System.out.println("Parent: " + p1.getParent());
		Path p2 = Paths.get("src/thucHanh/trung-tam.txt"); // tao ra duong dan
		// Method 1:
		if (Files.exists(p2) == false) {
			Files.copy(p1, p2);
		} // Method 2:
		else {
			if (JOptionPane.showConfirmDialog(null, "Ban co muon ghi de khong? ") == JOptionPane.YES_OPTION) {
				Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Đã ghi đè tâp tin");
			}
		}

	}

}
