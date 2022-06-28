package example;

public class Student extends Person{
	
	public String universityName;
	
	public Student(String name, int age, float height, String universityName) {
		super(name, age, height);
		// TODO Auto-generated constructor stub
		this.universityName = universityName;
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		super.getInfo();
		System.out.println("University Name : "+this.universityName);
	}
}
