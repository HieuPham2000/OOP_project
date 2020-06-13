package giacophieu;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class SampleSentences {
	private ArrayList<String> sampleSentences;
	
	public SampleSentences() {
	}
	
	public void readSampleSentences(String fileName) {
		sampleSentences = new ArrayList<String>(); // mỗi lần đọc khởi tạo list mới, tránh việc add thêm vào list cũ khi dùng chung 1 đối tượng
		try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){
			stream.forEach(line ->{
				sampleSentences.add(line);
			});
		} catch (Exception e) {
			System.out.println("Lỗi khi đọc file mẫu câu!");
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getSampleSentences() {
		return this.sampleSentences;
	}
	
	public abstract String generateSentence() throws Exception;
}
