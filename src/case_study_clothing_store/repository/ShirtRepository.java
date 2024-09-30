package case_study_clothing_store.repository;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;

import java.util.ArrayList;
import java.util.List;

public class ShirtRepository implements IProductRepository<Shirt> {
    private List<Shirt> shirtList;

    public ShirtRepository() {
        this.shirtList = new ArrayList<>();
        shirtList.add(new Shirt("B021", "Áo bull", "Burberry", 500000, 5, "M", "Đen"));
        shirtList.add(new Shirt("S022", "Sơ mi", "LV", 650000, 10, "L", "Trắng"));
    }

    @Override
    public void add(Shirt object) {
        shirtList.add(object);
    }

    @Override
    public List<Shirt> getAll() {
        return shirtList;
    }

    @Override
    public Shirt findId(String id) {
        for (Shirt shirt : shirtList) {
            if (shirt.getId().equals(id)) {
                return shirt;
            }
        }
        return null;
    }

    @Override
    public void update(Shirt object) {
        for (Shirt shirt : shirtList) {
            if (shirt.getId().equals(object.getId())) {
                shirt.setName(object.getName());
                shirt.setBrand(object.getBrand());
                shirt.setPrice(object.getPrice());
                shirt.setQuantity(object.getQuantity());
                shirt.setSize(object.getSize());
                shirt.setColor(object.getColor());
            }
        }
    }

    @Override
    public void delete(Shirt object) {
        shirtList.remove(object);
    }

    @Override
    public List<Shirt> search(String name) {
        List<Shirt> list = new ArrayList<>();
        for (Shirt shirt : shirtList) {
            if (shirt.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(shirt);
            }
        }
        return list;
    }
}
