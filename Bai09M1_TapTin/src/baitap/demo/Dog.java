package baitap.demo;

import java.io.Serializable;

public class Dog implements Serializable {

	private String name;
	private int sochan;

	public Dog(String name, int sochan) {
		super();
		this.name = name;
		this.sochan = sochan;
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSochan() {
		return sochan;
	}

	public void setSochan(int sochan) {
		this.sochan = sochan;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", sochan=" + sochan + "]";
	}

}
