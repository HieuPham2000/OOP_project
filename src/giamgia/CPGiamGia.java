package giamgia;

import java.util.List;

import giacophieu.SampleSentencesStockCode;
import tainguyenchung.CoPhieu;

public class CPGiamGia extends CauChungGiamGia {
	private CoPhieu cpGiamNhieuNhat;
	
	public CPGiamGia(List<CoPhieu> listCP) {
		super(listCP);
		if(listCoPhieuGiamGia.size()>=3) {
			setCpGiamNhieuNhat(listCoPhieuGiamGia);
		}
	}
	
	public CPGiamGia(List<CoPhieu> listCP, int day) {
		super(listCP, day);
		if(listCoPhieuGiamGia.size()>=3) {
			setCpGiamNhieuNhat(listCoPhieuGiamGia);
		}
	}
	
	
	public void setCpGiamNhieuNhat(List<CoPhieu> list) {
		double tyLe = list.get(0).getTyLeThayDoi()[day];
		CoPhieu res = list.get(0);
		for (CoPhieu coPhieu : list) {
			if(coPhieu.getTyLeThayDoi()[day]<tyLe) {
				tyLe = coPhieu.getTyLeThayDoi()[day];
				res = coPhieu;
			}
		}
		this.cpGiamNhieuNhat = res;
	}
	
	
	public CoPhieu getCpGiamNhieuNhat() {
		return cpGiamNhieuNhat;
	}
	
	

	@Override
	public void inCau() {
		
		SampleSentencesStockCode sample= new SampleSentencesStockCode();
		sample.setDay(day);
		
		if (listCoPhieuGiamGia.size()<=1) { // không có hoặc có 1 cổ phiếu giảm giá
			return;
		} 
		else { // có từ 2 cổ phiếu giảm giá
			
			if (listCoPhieuGiamGia.size()>=3) { // nếu có 3 cổ phiếu giảm trở lên thì mới xét GiẢM NHIỀU NHẤT
				sample.setCoPhieu(cpGiamNhieuNhat);
				sample.readSampleSentences("data/tag.tanggiam/giam/giam.nhieunhat.txt");
				try {
					System.out.print(sample.generateSentence());
				} catch(Exception e) {
					e.printStackTrace();
				}	
			}
			
			
			// in ra 2 mã giảm mạnh khác
			sample.readSampleSentences("data/tag.tanggiam/giam/giam.manh.txt");
			int count = 2;
			for (CoPhieu coPhieu : listCoPhieuGiamGia) {
				// nếu trùng với cổ phiếu giảm nhiều nhất thì bỏ qua
				try {
					if (coPhieu.getMaCP().equals(cpGiamNhieuNhat.getMaCP())) {
						continue;
					}
				} catch (Exception e) {
					
				}
				// cổ phiếu giảm mạnh có mức giảm abs >  2.5%
				if(Math.abs(coPhieu.getTyLeThayDoi()[day]) < 2.5) {
					continue;
				}
				
				if(count==2) { // trước khi in ra cổ phiếu giảm mạnh đầu tiên
					System.out.print("Nhóm mã giảm mạnh: ");
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
			
			
			// in 3 cổ phiếu giảm nhẹ
			count = 3;
			sample.readSampleSentences("data/tag.tanggiam/giam/giam.cuthe.txt");
			for (CoPhieu coPhieu : listCoPhieuGiamGia) {
				// nếu trùng với cổ phiếu giảm nhiều nhất thì bỏ qua
				try {
					if (coPhieu.getMaCP().equals(cpGiamNhieuNhat.getMaCP())) {
						continue;
					}
				} catch(Exception e) {
					
				}
				// cổ phiếu giảm nhẹ có mức giảm abs < 2.5%
				if(Math.abs(coPhieu.getTyLeThayDoi()[day]) > 2.5) {
					continue;
				}
	
				
				// trước khi in ra cổ phiếu giảm nhẹ đầu tiên
				if(count==3) { 
					System.out.print("Nhóm cổ phiếu có mức giảm nhẹ: ");
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
