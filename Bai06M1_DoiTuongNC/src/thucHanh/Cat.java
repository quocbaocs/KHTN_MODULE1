package thucHanh;

public class Cat extends Animal {

	public Cat() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Cat(String name, String image) {
		super(name, image);

	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return this.getName() + " says Meo meo meo";
	}
}
