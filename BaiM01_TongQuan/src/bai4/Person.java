package bai4;

public class Person implements Comparable<Person> {
	private String name;
	private int year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Person() {
		super();
	}

	public Person(String name, int year) {
		super();
		this.name = name;
		this.year = year;
	}

	@Override
	public String toString() {
		return name + " " + year;
	}

	@Override
	public int compareTo(Person per) {
		// TODO Auto-generated method stub
		return  this.year-per.year ;
	}

}
