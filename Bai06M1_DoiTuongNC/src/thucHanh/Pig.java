package thucHanh;

public class Pig extends Animal {

	public Pig() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Pig(String name, String image) {
		super(name, image);

	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return this.getName() + " says op op";
	}

}
