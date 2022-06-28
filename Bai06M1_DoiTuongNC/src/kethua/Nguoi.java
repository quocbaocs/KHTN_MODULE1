package kethua;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Nguoi {
	private String ht;
	private Date ns;
	private boolean gt;

	private static int soNguoi; // using static

	//khoi lenh khoi tao gia tri cho bien static
	static {
		soNguoi = 0;
	}

	public static int getSoNguoi() {
		return soNguoi;
	}

	public Nguoi(String ht, Date ns, boolean gt) {
		super();
		this.ht = ht;
		this.ns = ns;
		this.gt = gt;
		soNguoi++;
	}

	public Nguoi() {
		super();
		soNguoi++;
	}

	public String getHt() {
		return ht;
	}

	public void setHt(String ht) {
		this.ht = ht;
	}

	public Date getNs() {
		return ns;
	}

	public void setNs(Date ns) {
		this.ns = ns;
	}

	public boolean isGt() {
		return gt;
	}

	public void setGt(boolean gt) {
		this.gt = gt;
	}

	public String xuat() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%s - %s - %s", ht, ns == null ? null : df.format(ns), false);
	}

	@Override
	public String toString() {
		return this.xuat();
	}

}
