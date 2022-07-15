package baitap.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		DanhSachDog ds = new DanhSachDog();
//		for (int i = 0; i < 5; i++) {
//			Dog dog = new Dog("name1", 5);
//			ds.insert(dog);
//		}
		try {
			FileInputStream in = new FileInputStream("src/baitap/demo/animal.txt");
			ObjectInputStream ois = new ObjectInputStream(in);
			ds = (DanhSachDog) ois.readObject();
			System.out.println(ds.tongSL());
			for (Dog dog : ds.getList()) {
				System.out.println(dog.toString());
			}

//			FileOutputStream out = new FileOutputStream("src/baitap/demo/animal.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(out);
//			oos.writeObject(ds);
//			oos.close();
//			out.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
