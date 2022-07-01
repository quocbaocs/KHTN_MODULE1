package thucHanh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Vd3 {
	public static void main(String[] args) {
		List<Integer> ds1 = new ArrayList<Integer>();
		ds1.add(1);
		ds1.add(2);
		ds1.add(3);
		ds1.add(4);
		ds1.add(5);
		System.out.println("Danh sach List<Integer>");
		for (Integer x : ds1) {
			System.out.println(x + " ");
		}

		Set<String> ds2 = new HashSet<String>();
		ds2.add("mai");
		ds2.add("lan");
		ds2.add("cuc");
		ds2.add("truc");
		System.out.println("Danh sach Set<String>");
		for (String x : ds2) {
			System.out.println(x + ",");
		}
		Map<Integer, String> td = new TreeMap<Integer, String>();
		td.put(5, "nam");
		td.put(3, "ba");
		td.put(2, "hai");
		td.put(4, "bon");
		td.put(1, "mot");
		System.out.println("Danh sach Map < Integer, String>");
		for (Integer k : td.keySet()) {
			System.out.println(k + "->" + td.get(k));
		}
	}

}
