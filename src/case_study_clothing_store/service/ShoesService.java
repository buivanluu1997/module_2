package case_study_clothing_store.service;

import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.model.Shoes;
import case_study_clothing_store.repository.IProductRepository;
import case_study_clothing_store.repository.ShirtRepository;
import case_study_clothing_store.repository.ShoesRepository;

import java.util.List;

public class ShoesService implements IProductService<Shoes> {
    private IProductRepository<Shoes> shoesRepository = new ShoesRepository();

    @Override
    public void add(Shoes object) {
        shoesRepository.add(object);
    }

    @Override
    public List<Shoes> getAll() {
        return shoesRepository.getAll();
    }

    @Override
    public Shoes findId(String id) {
        return shoesRepository.findId(id);
    }

    @Override
    public void update(Shoes object) {
        shoesRepository.update(object);
    }

    @Override
    public void delete(Shoes object) {
        shoesRepository.delete(object);
    }

    @Override
    public List<Shoes> search(String name) {
        return shoesRepository.search(name);
    }
}
