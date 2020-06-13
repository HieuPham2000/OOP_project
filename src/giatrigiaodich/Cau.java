package giatrigiaodich;
import tainguyenchung.CoPhieu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import khoiluongkhop.*;

public class Cau extends CauChungKL {
	
	public Cau() {
		super();
	}
	public Cau(List<CoPhieu> listCP) {
		this.listCP=listCP;
	}
	public static boolean sosanh(int[] arr1, int arr2[]) {
		if (arr1.length != arr2.length) {
			return false;
		} else {
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] != arr2[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void inCau() {
		    // top 5 co phieu
		ArrayList<CoPhieu> listc1 = this.sortlist();
		System.out.print("Top 5 cổ phiếu có giá trị giao dịch thấp nhất là: ");
		for(int i=0;i<5;i++) {
			System.out.print(listc1.get(i).getMaCP()+"  ");
		}
		System.out.print("\nTop 5 cổ phiếu có giá trị giao dịch cao nhất là: ");
		for(int i=listc1.size()-1;i>listc1.size()-6;i--) 
			System.out.print(listc1.get(i).getMaCP()+"  ");
		
		    // tong gia tri giao dich
			ArrayList<CoPhieu> listc2 = this.sortlist();
			ArrayList<Double> tongGT = new ArrayList<Double>();
			for (CoPhieu cp : listCP) {
				double tong=0;
				for(int i1=0;i1<7;i1++) {
					tong+=cp.getGiaTriGiaoDich()[i1];
				}
				tongGT.add(tong);
				
			}
			for(int i1=0;i1<5;i1++) {
				System.out.print("\nTổng giá trị giao dịch của mã cổ phiếu là"+ " " + listc2.get(i1).getMaCP() +" "+ "là:"+ " "+ tongGT.get(i1)+".");
			}
			for(int i1=listc2.size()-1;i1>listc2.size()-6;i1--) {
				System.out.print("\nTổng giá trị giao dịch của mã cổ phiếu là " + listc2.get(i1).getMaCP()+ " là: "+ tongGT.get(i1)+".");
			
			}
			
			// giam
			ArrayList<Double> listTD = new ArrayList<Double>();
			for(CoPhieu std : listCP) {
				double k = std.getGiaTriGiaoDich()[6]-std.getGiaTriGiaoDich()[0];
				listTD.add(k);	
			}
			ArrayList<Double> listTD2 = listTD;
			Collections.sort(listTD2);
			int maxindex = listTD.indexOf(listTD2.get(0));
			System.out.println("\nCổ phiếu có giá trị giao dịch giảm mạnh nhất trong tuần qua là:"+ listCP.get(maxindex).getMaCP() + " với lượng thay đổi là "+ listTD.get(maxindex)+ " triệu đồng( từ đầu tuần đến cuối tuần ).");
		    
			// tang
			ArrayList<Double> listTD1 = new ArrayList<Double>();
			for(CoPhieu std : listCP) {
				double k = std.getGiaTriGiaoDich()[6]-std.getGiaTriGiaoDich()[0];
				listTD1.add(k);	
			}
			
			ArrayList<Double> listTD21 = listTD1;
			Collections.sort(listTD21);
			int maxindex1 = listTD1.indexOf(listTD21.get(29));
			System.out.println("Cổ phiếu có giá trị giao dịch tăng mạnh nhất trong tuần qua là "+ listCP.get(maxindex1).getMaCP() + " với lượng thay đổi là "+ listTD1.get(maxindex1)+ " triệu đồng( từ đầu tuần đến cuối tuần).");
           
			// nhan dinh gia tri co phieu

			ArrayList<int[]> listc4 = this.taolistTG();
			ArrayList<Integer> listtong = new ArrayList<Integer>();
			for (var std : listc4) {
				int sum = 0;
				for (int i = 0; i < std.length; i++) {
					sum = sum + std[i];
				}
				listtong.add(sum);

			}
			System.out.print("Giá trị giao dịch của các cổ phiếu : ");
			for(int i=0;i<listtong.size();i++) {
				if(listtong.get(i)>0) {
					System.out.print(listCP.get(i).getMaCP()+ " ");
				}
			}
			System.out.print("có sự thay đổi theo hướng đi lên trong tuần qua.");

			
			System.out.print("\nGiá trị giao dịch của các cổ phiếu: ");
			for(int i=0;i<listtong.size();i++) {
				if(listtong.get(i)<0) {
					System.out.print(listCP.get(i).getMaCP()+ " ");
				}
			}
			System.out.print(" có sự thay đổi theo hướng đi xuống trong tuần qua.");
			
			int count=0;
			for(int i=0;i<listtong.size();i++) {
				if(listtong.get(i)==0) {
					count++;
				}
			}
			System.out.println();
			if(count!=0) {
				System.out.print("Các mã cổ phi ");
				
				for(int i=0;i<listtong.size();i++) {
					if(listtong.get(i)<=-3) {
						System.out.print(listCP.get(i).getMaCP()+ " ");
					}

				}
				System.out.print(" có giá trị giao dịch ổn định(Không có sự biến đổi nhiều).");
			}
			else {
				System.out.println("Các cổ phiếu đề có sự biến động về giá trị giao dịch,không có cổ phiếu nào ổn định trong tuần qua.");
			}
			
			
			// bien doi
			ArrayList<int[]> listc41 = this.taolistTG();

			// tang lien tiep tu dau tuan den cuoi tuan
			int arrT[] = { 0, 1, 1, 1, 1, 1, 1 };
			int count1 = 0;

			for (int[] std : listc41) {
				if (std == arrT) {
					count1++;
				}
			}
			if (count1 != 0) {
				System.out.print("Cổ phiếu ");
				for (int[] std : listc41) {
					if (sosanh(std, arrT)) {
						System.out.println(" " + listCP.get(listc41.indexOf(std)).getMaCP());
					}
				}
				System.out.print(" tăng liên tiếp từ đầu tuần đến cuối tuần.");

			} else {
				System.out.println("Trong tuần qua không có cổ phiếu nào có giá trị giao dịch tăng liên tiếp từng ngày.");
			}
			// giam lien tuc tu dau tuan
			int arrG[] = { 0, -1, -1, -1, -1, -1, -1 };
			int count2 = 0;

			for (int[] std : listc41) {
				if (sosanh(std, arrG)) {
					count2++;
				}
			}
			if (count2 != 0) {
				System.out.print("Cổ phiếu ");
				for (int[] std : listc41) {
					if (std == arrG) {
						System.out.println(" " + listCP.get(listc41.indexOf(std)).getMaCP());
					}
				}
				System.out.print(" giảm liên tiếp từ đầu tuần đến cuối tuần.");

			} else {
				System.out
						.println("Trong tuần qua không có cổ phiếu nào có giá trị giao dịch giảm liên tiếp từng ngày.");
			}

			// Gia tri giao dich tang giam that thuong
			int[] arrTT1 = { 0, 1, -1, -1, 1, -1, 1 };
			int[] arrTT2 = { 0, 1, -1, 1, -1, -1, 1 };
			int[] arrTT3 = { 0, -1, -1, 1, -1, 1, -1 };

			int count3 = 0;

			for (int[] std : listc41) {
				if (sosanh(std, arrTT1) || sosanh(std, arrTT2) || sosanh(std, arrTT3)) {
					count3++;
				}
			}
			if (count3 != 0) {
				System.out.print("Cổ phiếu ");
				for (int[] std : listc41) {
					if (sosanh(std, arrTT1) || sosanh(std, arrTT2) || sosanh(std, arrTT3)) {
						System.out.print(" " + listCP.get(listc41.indexOf(std)).getMaCP());
					}
				}
				System.out.print("tăng giảm thất thường( không có chuỗi ngày tăng giảm liên tục).");

			}

		
		
		// Gia tri giao dich co khoi sac 
		int[] arrKS1 = { 0, -1, -1, -1, 1, 1, 1 };
		int[] arrKS2 = { 0, -1, -1, -1, -1, 1, 1 };
		int[] arrKS3 = { 0, -1, -1, 1, 1, 1, 1 };

		int count4 = 0;

		for (int[] std : listc41) {
			if (sosanh(std, arrKS1) || sosanh(std, arrKS2) || sosanh(std, arrKS3)) {
				count4++;
			}
		}
		if (count4 != 0) {
			System.out.print("Cổ phiếu ");
			for (int[] std : listc41) {
				if (sosanh(std, arrKS1) || sosanh(std, arrKS2) || sosanh(std, arrKS3)) {
					System.out.print(" " + listCP.get(listc41.indexOf(std)).getMaCP());
				}
			}
			System.out.print(" có giá trị giao dịch giảm vào đầu tuần, nhưng đến cuối tuần có dấu hiệu khởi sắc.");

		}
		else {
			System.out.println("\nTrong nhóm cổ phiếu giảm mạnh, không có cổ phiếu nào có khởi sắc");
		}
	}

}
