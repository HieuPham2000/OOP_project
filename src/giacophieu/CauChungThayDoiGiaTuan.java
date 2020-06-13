package giacophieu;

import java.util.List;
import tainguyenchung.CauChung;
import tainguyenchung.CoPhieu;

public class CauChungThayDoiGiaTuan extends CauChung {
	
	public CauChungThayDoiGiaTuan() {
		super();
	}
	
	public CauChungThayDoiGiaTuan(List<CoPhieu> listCP) {
		super(listCP);
		this.listCP = listCP;
	}
	
	@Override
	public void inCau() {
		
		// in ra số lượng mã tăng, giảm, đứng giá
		int[] thayDoiGiaTuan = {0,0,0}; // theo thứ tự phần tử 0, 1, 2 là để đếm số mã tăng giá, giảm giá, đứng giá
		for (CoPhieu coPhieu : listCP) {
			double tmp = coPhieu.getGiaDongCua()[6] - coPhieu.getGiaDongCua()[0]; // so sánh giá đóng cửa ngày 7 và ngày 1
			if (tmp > 0) {
				thayDoiGiaTuan[0]++;
			} 
			else if (tmp < 0) {
				thayDoiGiaTuan[1]++;
			}
			else {
				thayDoiGiaTuan[2]++;
			}
		}
		
		String[] thayDoiGiaTuanStr = new String[3];
		for (int i=0;i<thayDoiGiaTuan.length;i++) {
			if (thayDoiGiaTuan[i]>0) {
				thayDoiGiaTuanStr[i] = "có " + thayDoiGiaTuan[i] + " mã";
			} else {
				thayDoiGiaTuanStr[i] = "không có mã nào";
			}
		}
		
		// in ra nhận định
		if (thayDoiGiaTuan[0]>=20) { // số lượng mã tăng lớn
			System.out.print("\n\nTuần vừa qua, thị trường chứng kiến sự tăng giá của nhiều cổ phiếu trong rổ VN30 "
					+ "so với giá đóng cửa ngày đầu tuần, đây là một dấu hiệu tích cực. ");
		}
		else if (thayDoiGiaTuan[1]>=20) { // số lượng mã giảm lớn
			System.out.print("\n\nThị trường chứng khoán vừa trải qua một tuần đầy khó khăn: "
					+ "phần lớn cổ phiếu trong rổ VN30 giảm giá so với giá đóng cửa ngày đầu tuần. ");
		}
		else if (thayDoiGiaTuan[0]>=12 && thayDoiGiaTuan[1]>=12) {
			System.out.print("\n\nThị trường chứng khoán vừa trải qua một tuần đầy biến động. ");
		}
		
		// in cụ thể số lượng
		System.out.printf("Tổng kết, so với giá đóng cửa ngày thứ nhất: %s tăng giá, %s giảm giá và %s đứng giá. ",
				thayDoiGiaTuanStr[0], thayDoiGiaTuanStr[1], thayDoiGiaTuanStr[2]);
		
		// in ra lời bình luận
		if (thayDoiGiaTuan[0]>=20) { // số lượng mã tăng lớn
			System.out.print("Hi vọng chuỗi tín hiệu tích cực của các mã cổ phiếu sẽ tiếp tục được nối dài. ");
		}
		else if (thayDoiGiaTuan[1]<3) { // số lượng mã tăng nhỏ
			System.out.print("Hi vọng tuần sau thị trường sẽ được chứng kiến sự hồi phục và tăng giá của nhiều cổ phiếu trong rổ VN30. ");
		}
		
	}
	
}
