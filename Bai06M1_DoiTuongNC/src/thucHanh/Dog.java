package thucHanh;

public class Dog extends Animal {

	public Dog() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Dog(String name, String image) {
		super(name, image);
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return this.getName() + " says Gâu gâu gâu";
	}
}
