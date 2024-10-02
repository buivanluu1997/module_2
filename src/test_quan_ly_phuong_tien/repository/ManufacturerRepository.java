package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepository {
    public List<Manufacturer> manufactures;
    public ManufacturerRepository() {
        this.manufactures = new ArrayList<>();
        manufactures.add(new Manufacturer("H01", "Honda", "Nhật Bản"));
        manufactures.add(new Manufacturer("F01", "Ford", "Mỹ"));
        manufactures.add(new Manufacturer("K01", "Kia", "Hàn Quốc"));
    }

    public Manufacturer findById (String id) {
        for (int i = 0; i < manufactures.size(); i++) {
            if (manufactures.get(i).getManufacturerId().equals(id)) {
                return manufactures.get(i);
            }
        }
        return null;
    }
}
