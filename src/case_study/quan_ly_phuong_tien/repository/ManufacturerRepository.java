package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepository {
    public List<Manufacturer> manufacturerList;

    public ManufacturerRepository() {
        this.manufacturerList = new ArrayList<>();
        manufacturerList.add(new Manufacturer("H003", "Honda", "Nhật Bản"));
        manufacturerList.add(new Manufacturer("F002", "Ford", "Mỹ"));
        manufacturerList.add(new Manufacturer("H004", "Huyndai", "Hàn Quốc"));
    }

}
