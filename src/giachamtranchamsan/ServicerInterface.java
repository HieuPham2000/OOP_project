package giachamtranchamsan;

import java.util.List;

import tainguyenchung.ChungKhoan;
import tainguyenchung.CoPhieu;

public interface ServicerInterface {
    List<ChungKhoan> convert(List<CoPhieu> coPhieuList);
    void listGiaDongCuaChamTranSan(List<ChungKhoan> list );
    void listGiaCaoNhatChamTran(List<ChungKhoan> list );
    void ListGiaThapNhatChamSan(List<ChungKhoan> list );
}
