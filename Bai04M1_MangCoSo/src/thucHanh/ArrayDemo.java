package thucHanh;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		String[] str = new String[0];
		System.out.println(str.length);
		String s = "Qb";
		str = Arrays.copyOf(str, str.length+1);
		System.out.println(str.length);
		str[str.length-1] = s;
		System.out.println(str.length);
		
	}

}
