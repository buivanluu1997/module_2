package demo_case.quan_ly_phuong_tien.repository;

import demo_case.quan_ly_phuong_tien.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepo {
    private static List<Manufacturer> manufacturerList = new ArrayList<>();

    static {
        manufacturerList.add(new Manufacturer("H001", "HonDa", "Nhật Bản"));
        manufacturerList.add(new Manufacturer("T001", "Toyota", "Nhật Bản"));
        manufacturerList.add(new Manufacturer("F001", "Ford", "Mỹ"));
    }

    public static List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }
}
