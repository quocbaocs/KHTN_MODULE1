package baitap.demo;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachDog implements Serializable {

	private ArrayList<Dog> ds;

	public DanhSachDog() {
		ds = new ArrayList<Dog>();
		// TODO Auto-generated constructor stub
	}

	public boolean insert(Dog dog) {
		ds.add(dog);
		return true;
	}

	public int tongSL() {
		return ds.size();
	}

	public ArrayList<Dog> getList() {
		return ds;
	}
}
