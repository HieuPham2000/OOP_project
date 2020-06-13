package nhomnganh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tainguyenchung.CoPhieu;

public class NganHang extends ChiaNhom{
	
	public NganHang(List<CoPhieu> listCP) {
		super(listCP);
	}
	
	public void cau1() {
		ArrayList<Double> b = new ArrayList<Double>();
		for (CoPhieu cp : listCP) {
			double i = cp.getGiaTriGiaoDich()[6];
			b.add(i);
		}
		ArrayList<Double> c = b;
		Collections.sort(c);
		int minindex = b.indexOf(c.get(listCP.size()-1));
		System.out.print("\nTrong nhóm ngân hàng,Ngân hàng bị đặt dấu hỏi nghi ngờ hoạt động " + listCP.get(minindex).getMaCP()+".");
	}
	
	public void cau2() {
		ArrayList<Double> b = new ArrayList<Double>();
		for (CoPhieu cp : listCP) {
			double i = cp.getGiaTriGiaoDich()[6];
			b.add(i);
		}
		ArrayList<Double> c = b;
		Collections.sort(c);
		int maxindex = b.indexOf(c.get(0));
		System.out.print("Ngân hàng đáng để đầu tư: " + listCP.get(maxindex).getMaCP()+".");
	}
	
	public void cau3() {
		ArrayList<Double> c = new ArrayList<Double>();
		for (CoPhieu cp : listCP) {
			double i = cp.getGiaTriGiaoDich()[6] - cp.getGiaTriGiaoDich()[0];
			c.add(i);
		}
		ArrayList<Double> d =c;
		Collections.sort(d);
		int maxindex = c.indexOf(d.get(listCP.size()-1));
		System.out.print("Cũng trong nhóm ngân hàng, Cổ phiếu có biến động lớn nhất tuần qua: " + listCP.get(maxindex).getMaCP()+".");
	}
}
	
	