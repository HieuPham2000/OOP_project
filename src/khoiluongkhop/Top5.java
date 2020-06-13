package khoiluongkhop;

import java.util.ArrayList;
import java.util.List;

import tainguyenchung.CoPhieu;

// Top 5 khối lượng khớp lệnh
public class Top5 extends CauChungKL {
	public Top5() {
		super();
	}

	public Top5(List<CoPhieu> listCP) {
		this.listCP = listCP;
	}

	public void inCau() {
		ArrayList<CoPhieu> listc1 = this.sortlist();
		System.out.print("\nTop 5 cổ phiếu có khối lượng khớp thấp nhất là: ");
		for (int i = 0; i < 5; i++) {
			System.out.print(listc1.get(i).getMaCP() + "  ");
		}
		System.out.print("\nTop 5 cổ phiếu có khối lượng khớp cao nhất là: ");
		for (int i = listc1.size() - 1; i > listc1.size() - 6; i--) {
			System.out.print(listc1.get(i).getMaCP() + "  ");

		}

	}

}
