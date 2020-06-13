package tanggia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import giacophieu.*;
import tainguyenchung.CoPhieu;

public class CauChungTangGia extends CauChungThayDoiGiaNgay {
	protected List<CoPhieu> listCoPhieuTangGia;

	public CauChungTangGia(List<CoPhieu> listCP) {
		super(listCP);
		this.setListCoPhieuTangGia(listCP);
	}	
	
	public CauChungTangGia(List<CoPhieu> listCP, int day) {
		super(listCP, day);
		this.setListCoPhieuTangGia(listCP);
	}	
	
	
	public List<CoPhieu> getListCoPhieuTangGia() {
		return listCoPhieuTangGia;
	}

	public void setListCoPhieuTangGia(List<CoPhieu> listCP) {
		this.listCoPhieuTangGia = new ArrayList<CoPhieu>();
		for (CoPhieu coPhieu : listCP) { 
			if(coPhieu.getThayDoi()[this.day]>0) {
				listCoPhieuTangGia.add(coPhieu);
			}
		}
	}
	
	@Override
	public void inCau() {
		if (listCoPhieuTangGia.size() == 0) {
			System.out.print("\nChốt giá phiên giao dịch, không có mã nào tăng giá. ");
			return; // không có mã tăng thì không làm gì thêm
		}
		
		System.out.print("\nCụ thể về nhóm cổ phiếu tăng giá: ");
		
		SampleSentencesStockCode sample= new SampleSentencesStockCode();
		sample.setDay(day);
				
		if (listCoPhieuTangGia.size()==1) { // có duy nhất 1 cổ phiếu tăng giá
			sample.setCoPhieu(listCoPhieuTangGia.get(0));
			sample.readSampleSentences("data/tag.tanggiam/tang/tang.duynhat.txt");
			try {
				System.out.print(sample.generateSentence());
			} catch(Exception e) {
				e.printStackTrace();
			}	
		} else if (listCoPhieuTangGia.size()>=20) { // có nhiều mã tăng giá
			Random rd = new Random();
			int tmp = rd.nextInt(listCoPhieuTangGia.size());
			sample.setCoPhieu(listCoPhieuTangGia.get(tmp));
			sample.readSampleSentences("data/tag.tanggiam/tang/tang.nhandinh.txt");
			try {
				System.out.print(sample.generateSentence());
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
