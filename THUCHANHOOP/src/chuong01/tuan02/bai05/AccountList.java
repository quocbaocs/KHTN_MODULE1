package chuong01.tuan02.bai05;

public class AccountList {
	Account[] accList;
	int count;

	public AccountList() {
		accList = new Account[10];
		count = 0;
	}

	public String themTK(int soTK, String tenTK, double soTien) {
		if (count >= accList.length)
			return "Mảng đầy không thể thêm tài khoản";
		Account acc = new Account(soTK, tenTK, soTien);
//		if (acc.getTrangThai().length() != 0)
//			return acc.getTrangThai() + "\n Thuộc tính tài khoản mới có dữ liệu mặc nhiên";
		accList[count] = acc;
		count++;
		return "Thêm TK thành công";
	}

	public int getSoLuongTK() {
		return this.count;
	}

	public Account timTK(int soTk) {
		for (int i = 0; i < accList.length; i++) {
			if (accList[i].getSoTk() == soTk) {
				return accList[i];
			}
		}
		return null;
	}

	public String thongtinTatCaTK() {
		String ttTatCaTK = "";
		for(int i =0; i < count; i++) {
			ttTatCaTK += accList[i].toString();
		}
		return ttTatCaTK;
	}

}
