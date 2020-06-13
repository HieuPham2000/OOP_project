package khoiluongkhop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tainguyenchung.CauChung;
import tainguyenchung.CoPhieu;

public class CauChungKL extends CauChung {

	public CauChungKL() {
		
	}

	public List<CoPhieu> getListCP() {
		return this.listCP;
	}

	public ArrayList<CoPhieu> sortlist() {
		ArrayList<Double> tongKL = new ArrayList<Double>();
		for (CoPhieu cp : listCP) {
			double tong = 0;
			for (int i = 0; i < 7; i++) {
				tong += cp.getKhoiLuongKhop()[i];
			}
			tongKL.add(tong);

		}
		ArrayList<Double> tongKL2 = tongKL;
		Collections.sort(tongKL2);
		ArrayList<CoPhieu> sortedlist = new ArrayList<CoPhieu>();
		for (double db : tongKL2) {
			sortedlist.add(listCP.get(tongKL.indexOf(db)));
		}
		return sortedlist;
	}

	public ArrayList<int[]> taolistTG() {
		ArrayList<int[]> listTG = new ArrayList<int[]>();
		for (CoPhieu std : listCP) {
			int[] arr = new int[7];
			for (int i = 1; i < 7; i++) {
				arr[0] = 0;
				if (std.getKhoiLuongKhop()[i] > std.getKhoiLuongKhop()[i - 1]) {
					arr[i] = 1;
				} else if (std.getKhoiLuongKhop()[i] < std.getKhoiLuongKhop()[i - 1])
					arr[i] = -1;
				else
					arr[i] = 0;
			}
			listTG.add(arr);
		}
		return listTG;
	}

	public void inCau() {

	}


}
