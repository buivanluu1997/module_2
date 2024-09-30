package case_study_clothing_store.repository;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.model.Shoes;

import java.util.ArrayList;
import java.util.List;

public class ShoesRepository implements IProductRepository<Shoes>{
    private List<Shoes> shoesList;

    public ShoesRepository() {
        this.shoesList = new ArrayList<>();
        shoesList.add(new Shoes("A011", "Thể thao", "Adidas", 1500000, 5, 39, "Vãi"));
        shoesList.add(new Shoes("H012", "Giày tây", "HM", 1600000, 6, 41, "Da"));
    }

    @Override
    public void add(Shoes object) {
        shoesList.add(object);
    }

    @Override
    public List<Shoes> getAll() {
        return shoesList;
    }

    @Override
    public Shoes findId(String id) {
        for (Shoes shoes : shoesList) {
            if (shoes.getId().equals(id)){
                return shoes;
            }
        }
        return null;
    }

    @Override
    public void update(Shoes object) {
        for (Shoes shoes : shoesList) {
            if (shoes.getId().equals(object.getId())) {
                shoes.setName(object.getName());
                shoes.setBrand(object.getBrand());
                shoes.setPrice(object.getPrice());
                shoes.setQuantity(object.getQuantity());
                shoes.setSizeShoes(object.getSizeShoes());
                shoes.setMaterial(object.getMaterial());
            }
        }
    }

    @Override
    public void delete(Shoes object) {
        shoesList.remove(object);
    }

    @Override
    public List<Shoes> search(String name) {
        List<Shoes> list = new ArrayList<>();
        for (Shoes shoes : shoesList) {
            if (shoes.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(shoes);
            }
        }
        return list;
    }
}
