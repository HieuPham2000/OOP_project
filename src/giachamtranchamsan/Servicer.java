package giachamtranchamsan;

import java.util.ArrayList;
import java.util.List;

import tainguyenchung.ChungKhoan;
import tainguyenchung.CoPhieu;

public class Servicer implements ServicerInterface {
    @Override
    public List<ChungKhoan> convert(List<CoPhieu> coPhieuList) {
        List<ChungKhoan> list = new ArrayList<>();
        for (CoPhieu coPhieu : coPhieuList
        ) {
            for (int i = 0; i < 7; i++) {
                String day = "";
                if (i == 0) day = "thứ 2";
                else if (i == 1) day = "thứ 3";
                else if (i == 2) day = "thứ 4";
                else if (i == 4) day = "thứ 5";
                else if (i == 5) day = "thứ 6";
                else if (i == 6) day = "thứ 7";
                else day = "chủ nhật";
                ChungKhoan chungKhoan = new ChungKhoan();
                chungKhoan.setMaCK(coPhieu.getMaCP());
                chungKhoan.setGiaMoCua(coPhieu.getGiaMoCua()[i]);
                chungKhoan.setGiaDongCua(coPhieu.getGiaDongCua()[i]);
                chungKhoan.setGiaSan(coPhieu.getGiaSan()[i]);
                chungKhoan.setGiaTran(coPhieu.getGiaTran()[i]);
                chungKhoan.setGiaCaoNhat(coPhieu.getGiaCaoNhat()[i]);
                chungKhoan.setGiaThapNhat(coPhieu.getGiaThapNhat()[i]);
                chungKhoan.setThuGiaoDich(day);
                list.add(chungKhoan);
            }
        }
        return list;
    }

    private boolean giaDongCuaChamTranSan(ChungKhoan chungKhoan) {
        if (chungKhoan.getGiaDongCua() < chungKhoan.getGiaTran() && chungKhoan.getGiaDongCua() > chungKhoan.getGiaSan())
            return false;
        return true;
    }


    private boolean giaCaoNhatChamTran(ChungKhoan chungKhoan) {
        if (chungKhoan.getGiaCaoNhat() >= chungKhoan.getGiaTran()) return true;
        return false;
    }


    private boolean giaThapNhatChamSan(ChungKhoan chungKhoan) {
        if (chungKhoan.getGiaThapNhat() <= chungKhoan.getGiaSan()) return true;
        return false;
    }

    @Override
    public void listGiaDongCuaChamTranSan(List<ChungKhoan> list) {
        int i = 0;
        System.out.println(" Các mã có giá đóng cửa chạm trần/chạm sàn trong tuần:  ");
        System.out.println("+--------+--------------+--------------+----------------+---------------+");
        System.out.println("|  MãCK  |  Giá trần    |   Giá Sàn    |  Giá đóng cửa  | Ngày giao dịch| ");
        System.out.println("+--------+--------------+--------------+----------------+---------------|");
        for (ChungKhoan chungKhoan : list
        ) {
            if (giaDongCuaChamTranSan(chungKhoan)) {
                i++;
                System.out.printf("%9s|%14s|%14s|%16s|%15s|", 
                		chungKhoan.getMaCK(), chungKhoan.getGiaTran(), chungKhoan.getGiaSan(), 
                		chungKhoan.getGiaDongCua(), chungKhoan.getThuGiaoDich());
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Số lượng: " + i + " mã\n\n");
    }

    @Override
    public void listGiaCaoNhatChamTran(List<ChungKhoan> list) {
        int i = 0;
        System.out.println(" Các mã đã từng có thời điểm chạm trần trong ngày:  ");
        System.out.println("+--------+--------------+-------------------+------------------------------+-----------------+");
        System.out.println("|  MãCK  |  Giá trần    | Giá cao nhất ngày |  Giá đóng cửa chạm giá trần  |  Ngày giao dịch |");
        System.out.println("+--------+--------------+-------------------+------------------------------+-----------------|");
        for (ChungKhoan chungKhoan : list
        ) {
            if (giaCaoNhatChamTran(chungKhoan)) {
                String check = "Không";
                if (chungKhoan.getGiaDongCua() >= chungKhoan.getGiaSan()) check = "Có";
                i++;
                System.out.printf("%9s|%14s|%19s|%30s|%17s|", 
                		chungKhoan.getMaCK(), chungKhoan.getGiaTran(), chungKhoan.getGiaCaoNhat(), 
                		check, chungKhoan.getThuGiaoDich());
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.print("Số lượng: " + i +" mã\n\n");
    }

    @Override
    public void ListGiaThapNhatChamSan(List<ChungKhoan> list) {
        int i = 0;
        System.out.println(" Các mã đã từng có thời điểm chạm sàn trong ngày:  ");
        System.out.println("+--------+--------------+-------------------+------------------------------+-----------------+");
        System.out.println("|  MãCK  |  Giá sàn     |Giá thấp nhất ngày |    Giá đóng cửa chạm sàn     | Ngày giao dịch  |");
        System.out.println("+--------+--------------+-------------------+------------------------------+-----------------|");
        for (ChungKhoan chungKhoan : list
        ) {
            if (giaThapNhatChamSan(chungKhoan)) {
                String check = "Không";
                if (chungKhoan.getGiaDongCua() <= chungKhoan.getGiaSan()) check = "Có";
                i++;
                System.out.printf("%9s|%14s|%19s|%30s|%17s|", 
                		chungKhoan.getMaCK(), chungKhoan.getGiaSan(), chungKhoan.getGiaThapNhat(),
                		check, chungKhoan.getThuGiaoDich());
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.print("Số lượng: " + i +" mã\n\n");
    }
}
