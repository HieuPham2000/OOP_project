package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import giachamtranchamsan.Servicer;
import giachamtranchamsan.ServicerInterface;
import giacophieu.CauThayDoiGia;
import giatrigiaodich.Cau;

import khoiluongkhop.CauKLKL;
import nhomnganh.InCauNN;
import tainguyenchung.ChungKhoan;
import tainguyenchung.ReadFileCSV;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("========================================");
		System.out.println(" Tuần giao dịch ");
		System.out.println(" Tuần 1: từ ngày 01/05 đến ngày 07/05.");
		System.out.println(" Tuần 2: từ ngày 08/05 đến ngày 14/05.");
		System.out.println(" Tuần 3: từ ngày 15/05 đến ngày 21/05.");
		System.out.println(" Tuần 4: từ ngày 22/05 đến ngày /05.");

		System.out.println("Chọn tuần giao dịch: ");

		int i = scanner.nextInt();
		String duongDan = null;
		switch (i) {
		case 1:
			duongDan = "data\\input\\input2.csv";
			break;
		case 2:
			duongDan = "data\\input\\input3.csv";
			break;
		case 3:
			duongDan = "data\\input\\input4.csv";
			break;
		case 4:
			duongDan = "data\\input\\input5.csv";
			break;
		}
		ReadFileCSV readfile = new ReadFileCSV(duongDan);
		CauThayDoiGia cauThayDoiGia = new CauThayDoiGia(readfile.listcp());
		CauKLKL cauKLKL = new CauKLKL(readfile.listcp());
		Cau cau = new Cau(readfile.listcp());
		System.out.println("Danh sách các tags: ");
		System.out.println("\t 1. Tăng, giảm giá.");
		System.out.println("\t 2. Khối lượng khớp lệnh.");
		System.out.println("\t 3. Giá trị giao dịch.");
		System.out.println("\t 4. Chạm trần,chạm sàn.");
		System.out.println("\t 5. Đầu tư theo từng nhóm ngành.");
		System.out.println("Chọn số tags mà bạn muốn in ra: ");
		int tags = scanner.nextInt();
		while (tags < 0 || tags > 5) {
			System.out.println("Nhập số tags từ 1 -> 5:");
			tags = scanner.nextInt();
		}
		
		int[] arrTag = new int[5];
		for (int j = 0; j < tags; j++) {
			System.out.print("Chọn tag thứ " + (j + 1) + " :");
			arrTag[j] = scanner.nextInt();

		}
		File file = new File("data/out.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
		} catch (Exception e) {
		}
		for (int j = 0; j < tags; j++) {
			if (arrTag[j] == 1) {
				System.out.println("\n=================================TĂNG GIẢM GIÁ====================================================================");
				cauThayDoiGia.inCau();
			}
			if (arrTag[j] == 2) {
				System.out.println("\n=================================KHỐI LƯỢNG KHỚP LỆNH====================================================================");
				cauKLKL.inCauKLKL();
			}
			if (arrTag[j] == 3) {
				System.out.println("\n=================================GIÁ TRỊ GIAO DỊCH====================================================================");
				cau.inCau();
			}
			if (arrTag[j] == 4) {
				System.out.println("\n=================================CHẠM TRẦN CHẠM SÀN====================================================================");
				ServicerInterface servicerInterface = new Servicer();
				List<ChungKhoan> list = servicerInterface.convert(readfile.listcp());
				servicerInterface.listGiaDongCuaChamTranSan(list);
				servicerInterface.listGiaCaoNhatChamTran(list);
				servicerInterface.ListGiaThapNhatChamSan(list);
			}
			if (arrTag[j] == 5) {
				System.out.println("\n=================================ĐẦU TƯ THEO NHÓM NGÀNH====================================================================");
				InCauNN incaunn = new InCauNN(readfile.listcp());
				incaunn.inCau();
				
			}
		}

	}

}
