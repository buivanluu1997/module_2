package case_study_clothing_store.controller;

import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.service.IProductService;
import case_study_clothing_store.service.ShirtService;

import java.util.List;

public class ShirtController {
    private IProductService<Shirt> shirtService = new ShirtService();

    public void add(Shirt object) {
        shirtService.add(object);
    }

    public List<Shirt> getAll() {
        return shirtService.getAll();
    }

    public Shirt findId(String id) {
        return shirtService.findId(id);
    }

    public void update(Shirt object) {
        shirtService.update(object);
    }

    public void delete(Shirt object) {
        shirtService.delete(object);
    }

    public List<Shirt> search(String name) {
        return shirtService.search(name);
    }
}
