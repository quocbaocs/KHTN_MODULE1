package thucHanh.bai7_4;

public class PetManager<T> {

	private java.util.List<T> pets;

	public void setPets(java.util.List<T> pets) {

		this.pets = pets;
	}

	public java.util.List<T> getPets() {
		if (pets == null) {
			pets = new java.util.ArrayList<T>();
		}
		return this.pets;
	}
}
