package tainguyenchung;

public class CoPhieu {
	private String maCP;
	private double[] giaTran;
	private double[] giaSan;
	private double[] giaThamChieu;
	private double[] giaMoCua;
	private double[] giaDongCua;
	private double[] thayDoi;
	private double[] tyLeThayDoi;
	private double[] giaThapNhat;
	private double[] giaCaoNhat;
	private double[] giaBinhquan;
	private double[] khoiLuongKhop;
	private double[] giaTriGiaoDich;
	private String nhomNganh;

	public CoPhieu(String maCP, double[] giaTran, double[] giaSan, double[] giaThamChieu, double[] giaMoCua,
			double[] giaDongCua, double[] thayDoi, double[] tyLeThayDoi, double[] giaThapNhat, double[] giaCaoNhat,
			double[] giaBinhquan, double[] khoiLuongGiaoDich, double[] giaTriGiaoDich, String nhomNganh) {
		super();
		this.maCP = maCP;
		this.giaTran = giaTran;
		this.giaSan = giaSan;
		this.giaThamChieu = giaThamChieu;
		this.giaMoCua = giaMoCua;
		this.giaDongCua = giaDongCua;
		this.thayDoi = thayDoi;
		this.tyLeThayDoi = tyLeThayDoi;
		this.giaThapNhat = giaThapNhat;
		this.giaCaoNhat = giaCaoNhat;
		this.giaBinhquan = giaBinhquan;
		this.khoiLuongKhop = khoiLuongGiaoDich;
		this.giaTriGiaoDich = giaTriGiaoDich;
		this.nhomNganh = nhomNganh;
	}

	public String getMaCP() {
		return maCP;
	}

	public double[] getGiaTran() {
		return giaTran;
	}

	public double[] getGiaSan() {
		return giaSan;
	}

	public double[] getGiaThamChieu() {
		return giaThamChieu;
	}

	public double[] getGiaMoCua() {
		return giaMoCua;
	}

	public double[] getGiaDongCua() {
		return giaDongCua;
	}

	public double[] getThayDoi() {
		return thayDoi;
	}

	public double[] getTyLeThayDoi() {
		return tyLeThayDoi;
	}

	public double[] getGiaThapNhat() {
		return giaThapNhat;
	}

	public double[] getGiaCaoNhat() {
		return giaCaoNhat;
	}

	public double[] getGiaBinhquan() {
		return giaBinhquan;
	}

	public double[] getKhoiLuongKhop() {
		return khoiLuongKhop;
	}

	public double[] getGiaTriGiaoDich() {
		return giaTriGiaoDich;
	}
	
	public String getNhomNganh() {
		return nhomNganh;
	}
	

}
