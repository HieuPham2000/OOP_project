package khoiluongkhop;

import java.util.ArrayList;
import java.util.List;

import tainguyenchung.CoPhieu;

public class BienDoi extends CauChungKL {
	public BienDoi() {
		super();
	}
	public BienDoi(List<CoPhieu> listCP) {
		this.listCP = listCP;
	}

	public static boolean sosanh(int[] arr1, int arr2[]) {
		if (arr1.length != arr2.length) {
			return false;
		} else {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public void inCau() {
		ArrayList<int[]> listc4 = this.taolistTG();

		// tang lien tiep tu dau tuan den cuoi tuan
		int arrT[] = { 0, 1, 1, 1, 1, 1, 1 };
		int count1 = 0;

		for (int[] std : listc4) {
			if (std == arrT) {
				count1++;
			}
		}
		if (count1 != 0) {
			System.out.print("Cổ phiếu ");
			for (int[] std : listc4) {
				if (sosanh(std, arrT)) {
					System.out.println(" " + listCP.get(listc4.indexOf(std)).getMaCP());
				}
			}
			System.out.print(" tăng liên tiếp từ đầu tuần đến cuối tuần.");

		} else {
			System.out.print("\nTrong tuần qua, Không có cổ phiếu nào có khối lượng khớp lệnh tăng liên tiếp từng ngày");
		}
		// giam lien tuc tu dau tuan
		int arrG[] = { 0, -1, -1, -1, -1, -1, -1 };
		int count2 = 0;

		for (int[] std : listc4) {
			if (sosanh(std, arrG)) {
				count2++;
			}
		}
		if (count2 != 0) {
			System.out.print("Cổ phiếu ");
			for (int[] std : listc4) {
				if (std == arrG) {
					System.out.println(" " + listCP.get(listc4.indexOf(std)).getMaCP());
				}
			}
			System.out.print(" giảm liên tục từ đầu tuần đến cuối tuần.");

		} else {
			System.out.print("Trong tuần qua, Không có cổ phiếu nào có khối lượng khớp lệnh giảm liên tiếp từng ngày");
		}

		// Khoi luong khop lenh tang giam that thuong
		int[] arrTT1 = { 0, 1, -1, -1, 1, -1, 1 };
		int[] arrTT2 = { 0, 1, -1, 1, -1, -1, 1 };
		int[] arrTT3 = { 0, -1, -1, 1, -1, 1, -1 };

		int count3 = 0;

		for (int[] std : listc4) {
			if (sosanh(std, arrTT1) || sosanh(std, arrTT2) || sosanh(std, arrTT3)) {
				count3++;
			}
		}
		if (count3 != 0) {
			System.out.print("Cổ phiếu ");
			for (int[] std : listc4) {
				if (sosanh(std, arrTT1) || sosanh(std, arrTT2) || sosanh(std, arrTT3)) {
					System.out.print(" " + listCP.get(listc4.indexOf(std)).getMaCP());
				}
			}
			System.out.print(" tăng giảm thất thường (không có chuỗi ngày tăng,giam liên tục");

		}

	
	
	// Khoi luong khop lenh co khoi sac 
	int[] arrKS1 = { 0, -1, -1, -1, 1, 1, 1 };
	int[] arrKS2 = { 0, -1, -1, -1, -1, 1, 1 };
	int[] arrKS3 = { 0, -1, -1, 1, 1, 1, 1 };

	int count4 = 0;

	for (int[] std : listc4) {
		if (sosanh(std, arrKS1) || sosanh(std, arrKS2) || sosanh(std, arrKS3)) {
			count4++;
		}
	}
	if (count4 != 0) {
		System.out.print("Cổ phiếu ");
		for (int[] std : listc4) {
			if (sosanh(std, arrKS1) || sosanh(std, arrKS2) || sosanh(std, arrKS3)) {
				System.out.print(" " + listCP.get(listc4.indexOf(std)).getMaCP());
			}
		}
		System.out.print(" có khối lượng khớp lệnh giảm vào đầu tuần, nhưng đến cuối tuần có dấu hiệu khởi sắc.");

	}
	else {
		System.out.println("Trong nhóm cổ phiếu giảm mạnh, không có cổ phiếu nào có dấu hiệu khởi sắc.");
	}
}

}
