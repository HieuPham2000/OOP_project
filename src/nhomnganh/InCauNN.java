package nhomnganh;
import java.util.List;

import tainguyenchung.CoPhieu;
public class InCauNN {
	private TapDoan tapDoan;
	private NganHang nganHang;
	private BaoHiem baoHiem;
	private XayDung xayDung;
	private CongTyCoPhan congTyCP;
	private ChiaNhom chianhom;
	
	public InCauNN(List<CoPhieu> listCP) {
		chianhom = new ChiaNhom(listCP);
		tapDoan = new TapDoan(chianhom.nhomTapDoan());
		nganHang = new NganHang(chianhom.nhomNganHang());
		baoHiem = new BaoHiem(chianhom.nhomBaoHiem());
		xayDung = new XayDung(chianhom.nhomXayDung());
		congTyCP = new CongTyCoPhan(chianhom.nhomCongTyCoPhan());
	}
	
	public void inCau() {
		tapDoan.cau1();
		tapDoan.cau2();
		tapDoan.cau3();
		nganHang.cau1();
		nganHang.cau2();
		nganHang.cau3();
		baoHiem.cau1();
		baoHiem.cau2();
		baoHiem.cau3();
		xayDung.cau1();
		xayDung.cau2();
		xayDung.cau3();
		congTyCP.cau1();
		congTyCP.cau2();
		congTyCP.cau3();
	}
	

}
