package tainguyenchung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
	private static final int SO_NGAY = 7;
	private static final String COMMA_DELIMITER = ","; // Split by comma
	private String duongDan;

	public ReadFileCSV() {

	}

	public ReadFileCSV(String duongDan) {
		this.duongDan = duongDan;
	}

	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}

	public String getDuongDan() {
		return this.duongDan;
	}

	public List<CoPhieu> listcp() {

		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(this.getDuongDan()));
			List<CoPhieu> result = new ArrayList<CoPhieu>();

			// Doc cac du lieu theo dong

			while ((line = br.readLine()) != null) {
				result.add(setCoPhieu(parseCsvLine(line)));
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// tach cac du lieu ngan cac nhau boi dau phay
	public List<String> parseCsvLine(String csvLine) {
		List<String> result = new ArrayList<String>();
		if (csvLine != null) {
			String[] splitData = csvLine.split(COMMA_DELIMITER);
			for (int i = 0; i < splitData.length; i++) {
				result.add(splitData[i]);
			}
		}
		return result;
	}

	public CoPhieu setCoPhieu(List<String> cp) {
	
		CoPhieu cophieu;
		String maCP = cp.get(0);
		double giaTran[] = new double[SO_NGAY];
		double giaSan[] = new double[SO_NGAY];
		double giaThamChieu[] = new double[SO_NGAY];
		double giaMoCua[] = new double[SO_NGAY];
		double giaDongCua[] = new double[SO_NGAY];
		double thayDoi[] = new double[SO_NGAY];
		double tyLeThayDoi[] = new double[SO_NGAY];
		double giaThapNhat[] = new double[SO_NGAY];
		double giaCaoNhat[] = new double[SO_NGAY];
		double giaBinhquan[] = new double[SO_NGAY];
		double khoiLuongGiaoDich[] = new double[SO_NGAY];
		double giaTriGiaoDich[] = new double[SO_NGAY];
		for (int i = 0; i < SO_NGAY; i++) {
			giaTran[i] = Double.parseDouble(cp.get(12 * i + 1));
			giaSan[i] = Double.parseDouble(cp.get(12 * i + 2));
			giaThamChieu[i] = Double.parseDouble(cp.get(12 * i + 3));
			giaMoCua[i] = Double.parseDouble(cp.get(12 * i + 4));
			giaDongCua[i] = Double.parseDouble(cp.get(12 * i + 5));
			thayDoi[i] = Double.parseDouble(cp.get(12 * i + 6));
			tyLeThayDoi[i] = Double.parseDouble(cp.get(12 * i + 7));
			giaThapNhat[i] = Double.parseDouble(cp.get(12 * i + 8));
			giaCaoNhat[i] = Double.parseDouble(cp.get(12 * i + 9));
			giaBinhquan[i] = Double.parseDouble(cp.get(12 * i + 10));
			khoiLuongGiaoDich[i] = Double.parseDouble(cp.get(12 * i + 11));
			giaTriGiaoDich[i] = Double.parseDouble(cp.get(12 * i + 12));
			
		}
		String nhomNganh = cp.get(12 * SO_NGAY + 1);
		cophieu = new CoPhieu(maCP, giaTran, giaSan, giaThamChieu, giaMoCua, giaDongCua, thayDoi, tyLeThayDoi,
				giaThapNhat, giaCaoNhat, giaBinhquan, khoiLuongGiaoDich, giaTriGiaoDich, nhomNganh);
		return cophieu;
	
	}
}
