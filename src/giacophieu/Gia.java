package giacophieu;

public class Gia {
	public static String chuanHoaGiaTri(double gia) {
		int res = Math.abs((int)(gia*1000));
		return Integer.toString(res);
	}
	
	public static String chuanHoaTyLe(double tyLe) {
		double res = Math.abs(tyLe);
		return Double.toString(res);
	}
}
