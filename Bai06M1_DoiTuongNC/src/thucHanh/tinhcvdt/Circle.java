package thucHanh.tinhcvdt;

public class Circle extends Shape {

	public double r;

	public Circle() {
		super();
	}

	public Circle(double r) {
		super();
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2 * this.r * java.lang.Math.PI;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.r * this.r * java.lang.Math.PI;
	}

}
