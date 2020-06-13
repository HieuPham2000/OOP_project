package giamgia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import giacophieu.*;
import tainguyenchung.CoPhieu;

public class CauChungGiamGia extends CauChungThayDoiGiaNgay {
	protected List<CoPhieu> listCoPhieuGiamGia;
	
	
	public CauChungGiamGia(List<CoPhieu> listCP) {
		super(listCP);
		this.setListCoPhieuGiamGia(listCP);
	}
	
	public CauChungGiamGia(List<CoPhieu> listCP, int day) {
		super(listCP, day);
		this.setListCoPhieuGiamGia(listCP);
	}
	
	public List<CoPhieu> getListCoPhieuGiamGia() {
		return listCoPhieuGiamGia;
	}

	public void setListCoPhieuGiamGia(List<CoPhieu> listCP) {
		this.listCoPhieuGiamGia = new ArrayList<CoPhieu>();
		for (CoPhieu coPhieu : listCP) {
			if(coPhieu.getThayDoi()[this.day]<0) {
				listCoPhieuGiamGia.add(coPhieu);
			}
		}
	}
	
	@Override
	public void inCau() {
		if (listCoPhieuGiamGia.size() == 0) {
			System.out.print("\nĐóng cửa phiên giao dịch, không có mã nào giảm giá. ");
			return; // không có mã giảm thì không làm gì thêm
		}
		
		System.out.print("\nỞ chiều ngược lại, nhóm giảm giá có " + listCoPhieuGiamGia.size() + " mã. ");
		
		SampleSentencesStockCode sample= new SampleSentencesStockCode();
		sample.setDay(day);
				
		if (listCoPhieuGiamGia.size()==1) { // có duy nhất 1 cổ phiếu giảm giá
			sample.setCoPhieu(listCoPhieuGiamGia.get(0));
			sample.readSampleSentences("data/tag.tanggiam/giam/giam.duynhat.txt");
			try {
				System.out.print(sample.generateSentence());
			} catch(Exception e) {
				e.printStackTrace();
			}	
		} else if (listCoPhieuGiamGia.size()>=20) { // có nhiều mã giảm giá
			Random rd = new Random();
			int tmp = rd.nextInt(listCoPhieuGiamGia.size());
			sample.setCoPhieu(listCoPhieuGiamGia.get(tmp));
			sample.readSampleSentences("data/tag.tanggiam/giam/giam.nhandinh.txt");
			try {
				System.out.print(sample.generateSentence());
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
