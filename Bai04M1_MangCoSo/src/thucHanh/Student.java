package bai4;

public class Student {
	private String name;
	private double diem;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public Student() {
		super();
	}

	public Student(String name, double diem) {
		super();
		this.name = name;
		this.diem = diem;
	}

	@Override
	public String toString() {
		return name + " " + diem;
	}

}
