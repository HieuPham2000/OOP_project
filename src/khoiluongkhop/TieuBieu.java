package khoiluongkhop;

import java.util.ArrayList;
import java.util.List;

import tainguyenchung.CoPhieu;

public class TieuBieu extends CauChungKL {
	public TieuBieu() {
		super();
	}
	public TieuBieu(List<CoPhieu> listCP) {
		this.listCP = listCP;
	}

	public void inCau() {
		ArrayList<CoPhieu> listc2 = this.sortlist();
		ArrayList<Double> tongKL = new ArrayList<Double>();
		for (CoPhieu cp : listCP) {
			double tong=0;
			for(int i=0;i<7;i++) {
				tong+=cp.getKhoiLuongKhop()[i];
			}
			tongKL.add(tong);
			
		}
		System.out.print("\nCác cổ phiếu có khối lượng giao dịch thấp nhất: ");
		for(int i=0;i<5;i++) {
			System.out.print("\nTổng khối lượng khớp của mã cổ phiếu  "+ listc2.get(i).getMaCP()+ " là: "+ tongKL.get(i)+ ".");
		}
		System.out.println("\nCác cổ phiếu có khối lượng giao dịch cao nhất: ");
		for(int i=listc2.size()-1;i>listc2.size()-6;i--) {
			System.out.print("\nTổng khối lượng khớp của mã cổ phiếu " + listc2.get(i).getMaCP()+ " là: "+ tongKL.get(i)+",");
		}

	}
	

}
