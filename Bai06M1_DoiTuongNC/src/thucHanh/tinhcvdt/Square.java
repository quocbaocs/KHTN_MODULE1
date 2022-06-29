package thucHanh.tinhcvdt;

public class Square extends Rectangle {

	public Square() {

	}

	public Square(int canh) {
		super(canh, canh);
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return this.getWidth() * 4;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return super.area();
	}
}
