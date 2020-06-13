package giacophieu;

import java.util.ArrayList;
import java.util.Random;

import tainguyenchung.CoPhieu;

public class SampleSentencesStockCode extends SampleSentences {
	private CoPhieu coPhieu;
	private int day;
	
	public SampleSentencesStockCode() {
		super();
	}
	
	public SampleSentencesStockCode(CoPhieu coPhieu, int day) {
		super();
		this.coPhieu = coPhieu;
		this.day = day;
	}
	
	@Override
	public String generateSentence() throws GenerateSentenceException {
		Random rd = new Random();
		ArrayList<String> tmp = this.getSampleSentences();
		String res = tmp.get(rd.nextInt(tmp.size()));
		
		if(coPhieu != null) {
		    res = res.replace("$maCP$", coPhieu.getMaCP())
		    		.replace("$giaThamChieu$", Gia.chuanHoaGiaTri(coPhieu.getGiaThamChieu()[day]))
		    		.replace("$giaDongCua$", Gia.chuanHoaGiaTri(coPhieu.getGiaDongCua()[day]))
		    		.replace("$giaThayDoi$", Gia.chuanHoaGiaTri(coPhieu.getThayDoi()[day]))
		    		.replace("$giaThayDoiPhanTram$", Gia.chuanHoaTyLe(coPhieu.getTyLeThayDoi()[day]));
		}

		if(res.contains("$")) {
			throw new GenerateSentenceException("Chưa thay đủ tham số vào câu mẫu!");
		}
		return res;
	}

	public CoPhieu getCoPhieu() {
		return coPhieu;
	}

	public void setCoPhieu(CoPhieu coPhieu) {
		this.coPhieu = coPhieu;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
