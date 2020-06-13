package giacophieu;

import java.util.List;

import giamgia.*;
import tainguyenchung.CauChung;
import tainguyenchung.CoPhieu;
import tanggia.*;

public class CauThayDoiGia extends CauChung {
	private CauChungThayDoiGiaTuan tuan;
	private CauChungThayDoiGiaNgay ngay;
	private CauChungTangGia tangGia;
	private CPTangGia cpTangGia;
	private CauChungGiamGia giamGia;
	private CPGiamGia cpGiamGia;
	
	public CauThayDoiGia(List<CoPhieu> listCP) {
		super(listCP);	
	}
	
	@Override 
	public void inCau() {
		for(int day=0; day<7 ; day++) {
			
			this.ngay = new CauChungThayDoiGiaNgay(listCP, day);
			this.tangGia = new CauChungTangGia(listCP, day);
			this.cpTangGia = new CPTangGia(listCP, day);
			this.giamGia = new CauChungGiamGia(listCP, day);
			this.cpGiamGia = new CPGiamGia(listCP, day);	
			
			
			ngay.inCau();
			tangGia.inCau();
			cpTangGia.inCau();
			giamGia.inCau();
			cpGiamGia.inCau();
		}
		this.tuan = new CauChungThayDoiGiaTuan(listCP);
		tuan.inCau();
	}
	
}
