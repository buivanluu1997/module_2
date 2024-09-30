package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Manufacture;

import java.util.ArrayList;
import java.util.List;

public class ManufactureRepository {
    public List<Manufacture> manufactures;
    public ManufactureRepository() {
        this.manufactures = new ArrayList<>();
        manufactures.add(new Manufacture("H01", "Honda", "Nhật Bản"));
        manufactures.add(new Manufacture("F01", "Ford", "Mỹ"));
        manufactures.add(new Manufacture("K01", "Kia", "Hàn Quốc"));
    }
}
