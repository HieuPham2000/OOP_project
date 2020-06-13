package khoiluongkhop;
import java.util.List;

import tainguyenchung.CoPhieu;
public class CauKLKL {
	private BienDoi cauBD;
	private GiamManh cauGM;
	private TangManh cauTM;
	private NhanDinh cauND;
	private TieuBieu cauTB;
	private Top5 cauT5;
	
	public CauKLKL(List<CoPhieu> listCP) {
		this.cauBD = new BienDoi(listCP);
		this.cauGM = new GiamManh(listCP);
		this.cauTM = new TangManh(listCP);
		this.cauND = new NhanDinh(listCP);
		this.cauTB = new TieuBieu(listCP);
		this.cauT5 = new Top5(listCP);
		
	}
	
	public void inCauKLKL() {
		System.out.println("\n");
		this.cauND.inCau();
		this.cauT5.inCau();
		this.cauTB.inCau();
		this.cauTM.inCau();
		this.cauGM.inCau();
		this.cauBD.inCau();
	}
	

}
