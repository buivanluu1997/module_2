package case_study_clothing_store.service;

import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.repository.IProductRepository;
import case_study_clothing_store.repository.ShirtRepository;

import java.util.List;

public class ShirtService implements IProductService<Shirt> {
    private IProductRepository<Shirt> shirtRepository = new ShirtRepository();

    @Override
    public void add(Shirt object) {
        shirtRepository.add(object);
    }

    @Override
    public List<Shirt> getAll() {
        return shirtRepository.getAll();
    }

    @Override
    public Shirt findId(String id) {
        return shirtRepository.findId(id);
    }

    @Override
    public void update(Shirt object) {
        shirtRepository.update(object);
    }

    @Override
    public void delete(Shirt object) {
        shirtRepository.delete(object);
    }

    @Override
    public List<Shirt> search(String name) {
        return shirtRepository.search(name);
    }
}
