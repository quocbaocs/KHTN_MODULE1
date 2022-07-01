package thucHanh;

import java.util.Arrays;

public class Vd1 {
	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 2, 4 };
		System.out.println(Arrays.toString(a));
		System.out.println("Them vao phan tu so 6 vao cuoi danh sach: ");
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = 6;
		System.out.println(Arrays.toString(a));

		System.out.println("Xoa phan tu so 3 o vi tri so 2");
		int vt = 2;
		for (int i = vt; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a = Arrays.copyOf(a, a.length - 1);
		System.out.println(Arrays.toString(a));

		System.out.println("chen vao vi tri 3 phan tu so 7");

		vt = 2;
		a = Arrays.copyOf(a, a.length + 1);
		for (int i = a.length - 1; i > vt; i--) {
			a[i] = a[i - 1];
		}
		a[vt] = 7;
		System.out.println(Arrays.toString(a));
	}

}
