package case_study_clothing_store.controller;

import case_study_clothing_store.model.Shoes;
import case_study_clothing_store.service.IProductService;
import case_study_clothing_store.service.ShoesService;

import java.util.List;

public class ShoesController {
    private IProductService<Shoes> shoesService = new ShoesService();

    public void add(Shoes object) {
        shoesService.add(object);
    }

    public List<Shoes> getAll() {
        return shoesService.getAll();
    }

    public Shoes findId(String id) {
        return shoesService.findId(id);
    }

    public void update(Shoes object) {
        shoesService.update(object);
    }

    public void delete(Shoes object) {
        shoesService.delete(object);
    }

    public List<Shoes> search(String name) {
        return shoesService.search(name);
    }

}
