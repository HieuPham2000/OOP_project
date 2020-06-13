package giacophieu;

import java.util.List;
import tainguyenchung.CauChung;
import tainguyenchung.CoPhieu;

public class CauChungThayDoiGiaNgay extends CauChung {
	protected int day;
	

	public CauChungThayDoiGiaNgay() {
		super();
	}
	
	public CauChungThayDoiGiaNgay(List<CoPhieu> listCP) {
		super(listCP);
		this.listCP = listCP;
	}
	
	public CauChungThayDoiGiaNgay(List<CoPhieu> listCP, int day) {
		super(listCP);
		this.listCP = listCP;
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	@Override
	public void inCau() {
		int[] thayDoiGia = {0,0,0}; // theo thứ tự phần tử 0, 1, 2 là để đếm số mã tăng giá, giảm giá, đứng giá
		for (CoPhieu coPhieu : listCP) {
			if (coPhieu.getThayDoi()[day] > 0) {
				thayDoiGia[0]++;
			} 
			else if (coPhieu.getThayDoi()[day] < 0) {
				thayDoiGia[1]++;
			}
			else {
				thayDoiGia[2]++;
			}
		}
		
		String[] thayDoiGiaStr = new String[3];
		for (int i=0;i<thayDoiGia.length;i++) {
			if (thayDoiGia[i]>0) {
				thayDoiGiaStr[i] = thayDoiGia[i] + " mã";
			} else {
				thayDoiGiaStr[i] = "không có mã nào";
			}
		}
		
		
		System.out.printf("\n\nKết thúc phiên giao dịch ngày thứ %d, trong rổ VN30: %s tăng giá, %s giảm giá và %s đứng giá. ",
				(day+1), thayDoiGiaStr[0], thayDoiGiaStr[1], thayDoiGiaStr[2]);
		if (thayDoiGia[0] >= 20) { // nhiều mã tăng
			System.out.print("Sắc xanh là màu chủ đạo trên bảng giá VN30 ngày hôm nay.");
		} else if (thayDoiGia[1] >= 20) { // nhiều mã giảm
			System.out.print("Bảng giá VN30 chìm trong sắc đỏ.");
		} else if (thayDoiGia[0]>=10 && thayDoiGia[1] >=10) { // nhiều mã tăng nhưng đồng thời nhiều mã giảm
			System.out.print("Nhóm VN30 có một ngày đầy biến động.");
		}
		
	}
	
	
}
