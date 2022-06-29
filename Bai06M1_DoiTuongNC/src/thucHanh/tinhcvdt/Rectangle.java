package thucHanh.tinhcvdt;

public class Rectangle extends Shape {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
		super();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (this.width + this.height) * 2;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

}
