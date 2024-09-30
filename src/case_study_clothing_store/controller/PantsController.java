package case_study_clothing_store.controller;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.service.IProductService;
import case_study_clothing_store.service.PantsService;
import case_study_clothing_store.service.ShirtService;

import java.util.List;

public class PantsController {
    private IProductService<Pants> pantsService = new PantsService();

    public void add(Pants object) {
        pantsService.add(object);
    }

    public List<Pants> getAll() {
        return pantsService.getAll();
    }

    public Pants findId(String id) {
        return pantsService.findId(id);
    }

    public void update(Pants object) {
        pantsService.update(object);
    }

    public void delete(Pants object) {
        pantsService.delete(object);
    }

    public List<Pants> search(String name) {
        return pantsService.search(name);
    }
}
