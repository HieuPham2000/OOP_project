package khoiluongkhop;

import java.util.ArrayList;
import java.util.List;

import tainguyenchung.CoPhieu;

public class NhanDinh extends CauChungKL {
	public NhanDinh() {
		super();
	}

	public NhanDinh(List<CoPhieu> listCP) {
		this.listCP = listCP;
	}

	public void inCau() {
		ArrayList<int[]> listc4 = this.taolistTG();
		ArrayList<Integer> listtong = new ArrayList<Integer>();
		for (var std : listc4) {
			int sum = 0;
			for (int i = 0; i < std.length; i++) {
				sum = sum + std[i];
			}
			listtong.add(sum);

		}

		System.out.print("Khối lượng khớp lệnh của các cổ phiếu : ");
		for (int i = 0; i < listtong.size(); i++) {
			if (listtong.get(i) > 0) {
				System.out.print(listCP.get(i).getMaCP() + " ");
			}
		}
		System.out.print(" có sự thay đổi theo hướng đi lên.");

		// Khoi luong khop lenh cua cac co phieu lien tuc giam
		System.out.print("Khối lượng khớp lệnh của các cổ phiếu : ");
		for (int i = 0; i < listtong.size(); i++) {
			if (listtong.get(i) < 0) {
				System.out.print(listCP.get(i).getMaCP() + " ");
			}
		}
		System.out.print(" có sự thay đổi theo hướng đi xuống.");
		// Khoi luong khop lenh cua cac co phieu on dinh
		int count = 0;
		for (int i = 0; i < listtong.size(); i++) {
			if (listtong.get(i) == 0) {
				count++;
			}
		}
		System.out.println();
		if (count != 0) {
			System.out.print("Các mã cổ phiếu ");

			for (int i = 0; i < listtong.size(); i++) {
				if (listtong.get(i) <= -3) {
					System.out.print(listCP.get(i).getMaCP() + " ");
				}

			}
			System.out.print(" có khối lượng khớp lệnh ổn định (không có sự biến đổi nhiều).");
		} else {
			System.out.print("Các cổ phiếu đều có sự biến động về khối lượng khớp lệnh, không có cổ phiếu nào ổn định trong tuần qua.");
		}
	}


}
