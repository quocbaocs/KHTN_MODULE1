package thucHanh;

public class Animal {

	private String name;
	private String image;

	public Animal(String name, String image) {
		super();
		this.name = name;
		this.image = image;
	}

	public Animal() {
		super();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String sayHello() {
		
		return "Hello";
	}

}
