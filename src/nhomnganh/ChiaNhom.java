package nhomnganh;
import java.util.ArrayList;
import java.util.List;

import tainguyenchung.CoPhieu;

public class ChiaNhom {
	protected ArrayList<CoPhieu> nganHang;
	protected ArrayList<CoPhieu> baoHiem;
	protected ArrayList<CoPhieu> xayDung;
	protected ArrayList<CoPhieu> congTyCoPhan;
	protected ArrayList<CoPhieu> tapDoan;
	protected List<CoPhieu> listCP;

	public ChiaNhom() {
		
	}
	public ChiaNhom(List<CoPhieu> listCP) {
		this.listCP=listCP;
	}

	public List<CoPhieu> getListCP() {
		return this.listCP;
	} 
	
	public ArrayList<CoPhieu> nhomNganHang() {
		ArrayList<CoPhieu> m = new ArrayList<CoPhieu>();
		this.nganHang = m;
		for (CoPhieu a: listCP) {
			if (a.getNhomNganh().equals("Ngan hang")) {
				nganHang.add(a);
			}
		}
		return nganHang;
	}
	
	
	public ArrayList<CoPhieu> nhomCongTyCoPhan() {
		ArrayList<CoPhieu> m = new ArrayList<CoPhieu>();
		this.congTyCoPhan = m;
		for (CoPhieu a: listCP) {
			if (a.getNhomNganh().equals("Cong ty co phan")) {
				congTyCoPhan.add(a);
			}
		}
		return congTyCoPhan;
	}
	
	public ArrayList<CoPhieu> nhomBaoHiem() {
		ArrayList<CoPhieu> m = new ArrayList<CoPhieu>();
		this.baoHiem = m;
		for (CoPhieu a: listCP) {
			if (a.getNhomNganh().equals("Bao hiem")) {
				baoHiem.add(a);
			}
		}
		return baoHiem;
	}
	
	public ArrayList<CoPhieu> nhomXayDung() {
		ArrayList<CoPhieu> m = new ArrayList<CoPhieu>();
		this.xayDung = m;
		for (CoPhieu a: listCP) {
			if (a.getNhomNganh().equals("Xay dung")) {
				xayDung.add(a);
			}
		}
		return xayDung;
	}	
	public ArrayList<CoPhieu> nhomTapDoan() {
		ArrayList<CoPhieu> m = new ArrayList<CoPhieu>();
		this.tapDoan = m;
		for (CoPhieu a: listCP) {
			if (a.getNhomNganh().equals("Tap doan")) {
				tapDoan.add(a);
			}
		}
		return tapDoan;
	}
	
	public ArrayList<CoPhieu> getNganHang() {
		return nganHang;
	}
	
	public ArrayList<CoPhieu> getCongTyCoPhan() {
		return congTyCoPhan;
	}
	
	public ArrayList<CoPhieu> getXayDung() {
		return xayDung;
	}
	
	public ArrayList<CoPhieu> getTapDoan() {
		return tapDoan;
	}
	
	
	
	

}
