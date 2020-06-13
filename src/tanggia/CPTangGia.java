package tanggia;

import java.util.List;

import giacophieu.SampleSentencesStockCode;
import tainguyenchung.CoPhieu;

public class CPTangGia extends CauChungTangGia {
	private CoPhieu cpTangNhieuNhat;
	
	public CPTangGia(List<CoPhieu> listCP) {
		super(listCP);
		if(listCoPhieuTangGia.size()>=3) {
			setCpTangNhieuNhat(listCoPhieuTangGia);
		}
	}
	
	public CPTangGia(List<CoPhieu> listCP, int day) {
		super(listCP, day);
		if(listCoPhieuTangGia.size()>=3) {
			setCpTangNhieuNhat(listCoPhieuTangGia);
		}
	}
	
	
	public void setCpTangNhieuNhat(List<CoPhieu> list) {
		double tyLe = list.get(0).getTyLeThayDoi()[day];
		CoPhieu res = list.get(0);
		for (CoPhieu coPhieu : list) {
			if(coPhieu.getTyLeThayDoi()[day]>tyLe) {
				tyLe = coPhieu.getTyLeThayDoi()[day];
				res = coPhieu;
			}
		}
		this.cpTangNhieuNhat = res;
	}
	
	
	public CoPhieu getCpTangNhieuNhat() {
		return cpTangNhieuNhat;
	}
	
	

	@Override
	public void inCau() {
		
		SampleSentencesStockCode sample= new SampleSentencesStockCode();
		sample.setDay(day);
		
		if (listCoPhieuTangGia.size()<=1) { // không có hoặc có 1 cổ phiếu tăng giá
			return;
		} 
		else { // có từ 2 cổ phiếu tăng giá
			
			if (listCoPhieuTangGia.size()>=3) { // nếu có 3 cổ phiếu tăng trở lên thì mới xét TĂNG NHIỀU NHẤT
				sample.setCoPhieu(cpTangNhieuNhat);
				sample.readSampleSentences("data/tag.tanggiam/tang/tang.nhieunhat.txt");
				try {
					System.out.print(sample.generateSentence());
				} catch(Exception e) {
					e.printStackTrace();
				}	
			}
			
			
			// in ra 2 mã tăng mạnh khác
			sample.readSampleSentences("data/tag.tanggiam/tang/tang.manh.txt");
			int count = 2;
			for (CoPhieu coPhieu : listCoPhieuTangGia) {
				// nếu trùng với cổ phiếu tăng nhiều nhất thì bỏ qua
				try {
					if (coPhieu.getMaCP().equals(cpTangNhieuNhat.getMaCP())) {
						continue;
					}
				} catch (Exception e) {
					
				}
				// cổ phiếu tăng mạnh có mức tăng >  2.5%
				if(coPhieu.getTyLeThayDoi()[day] < 2.5) {
					continue;
				}
				
				if(count==2) { // trước khi in ra cổ phiếu tăng mạnh đầu tiên
					System.out.print("Nhóm cổ phiếu tăng mạnh: ");
				}
				
				sample.setCoPhieu(coPhieu);
				try {
					System.out.print(sample.generateSentence());
				} catch(Exception e) {
					e.printStackTrace();
				}
				count --;
				
				if(count==0) {
					break;
				}
			}
			
			
			// in 3 cổ phiếu tăng nhẹ
			count = 3;
			sample.readSampleSentences("data/tag.tanggiam/tang/tang.cuthe.txt");
			for (CoPhieu coPhieu : listCoPhieuTangGia) {
				// nếu trùng với cổ phiếu tăng nhiều nhất thì bỏ qua
				try {
					if (coPhieu.getMaCP().equals(cpTangNhieuNhat.getMaCP())) {
						continue;
					}
				} catch (Exception e) {
					
				}
				// cổ phiếu tăng nhẹ có mức tăng < 2.5%
				if(coPhieu.getTyLeThayDoi()[day] > 2.5) {
					continue;
				}
				
				if(count==3) { // trước khi in ra cổ phiếu tăng nhẹ đầu tiên
					System.out.print("Cổ phiếu có mức tăng nhẹ: ");
				}
	
				sample.setCoPhieu(coPhieu);
				try {
					System.out.print(sample.generateSentence());
				} catch(Exception e) {
					e.printStackTrace();
				}	
				count --;
				
				if(count==0) {
					break;
				}
			}
			System.out.print("..");
		}
	}

}
