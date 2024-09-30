package case_study_clothing_store.repository;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;

import java.util.ArrayList;
import java.util.List;

public class PantsRepository implements IProductRepository<Pants> {
    private List<Pants> pantsList;

    public PantsRepository() {
        this.pantsList = new ArrayList<>();
        pantsList.add(new Pants("J001", "Quần Jeans", "Gucci", 800000, 20, 90, 92));
        pantsList.add(new Pants("T002", "Quần Âu", "LV", 750000, 30, 85, 88));
    }

    @Override
    public void add(Pants object) {
        pantsList.add(object);
    }

    @Override
    public List<Pants> getAll() {
        return pantsList;
    }

    @Override
    public Pants findId(String id) {
        for (Pants pants : pantsList) {
            if (pants.getId().equals(id)) {
                return pants;
            }
        }
        return null;
    }

    @Override
    public void update(Pants object) {
        for (Pants pants : pantsList) {
            if (pants.getId().equals(object.getId())) {
                pants.setName(object.getName());
                pants.setBrand(object.getBrand());
                pants.setPrice(object.getPrice());
                pants.setQuantity(object.getQuantity());
                pants.setWaistSize(object.getWaistSize());
                pants.setLength(object.getLength());
            }
        }
    }

    @Override
    public void delete(Pants object) {
        pantsList.remove(object);
    }

    @Override
    public List<Pants> search(String name) {
        List<Pants> list = new ArrayList<>();
        for (Pants pants : pantsList) {
            if (pants.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(pants);
            }
        }
        return list;
    }
}
