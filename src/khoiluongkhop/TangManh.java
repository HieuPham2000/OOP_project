package khoiluongkhop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tainguyenchung.CoPhieu;
public class TangManh extends CauChungKL {
	public TangManh() {
		super();
	}
	public TangManh(List<CoPhieu> listCP) {
		this.listCP = listCP;
	}
	
	public void inCau() {
		ArrayList<Double> listTD = new ArrayList<Double>();
		for(CoPhieu std : listCP) {
			double k = std.getKhoiLuongKhop()[6]-std.getKhoiLuongKhop()[0];
			listTD.add(k);	
		}
		ArrayList<Double> listTD2 = listTD;
		Collections.sort(listTD2);
		int maxindex = listTD.indexOf(listTD2.get(29));
		System.out.println("Cổ phiếu có khối lượng khớp lệnh tăng mạnh nhất trong tuần qua là"+ listCP.get(maxindex).getMaCP() + " với lượng thay đổi là"+ listTD.get(maxindex)+ " cổ phiếu( từ đầu tuần đến cuối tuần).");
	}
	
	
}
