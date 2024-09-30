package case_study_clothing_store.service;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.repository.IProductRepository;
import case_study_clothing_store.repository.PantsRepository;

import java.util.List;

public class PantsService implements IProductService<Pants>{
    private IProductRepository<Pants> pantsRepository = new PantsRepository();

    @Override
    public void add(Pants object) {
        pantsRepository.add(object);
    }

    @Override
    public List<Pants> getAll() {
        return pantsRepository.getAll();
    }

    @Override
    public Pants findId(String id) {
        return pantsRepository.findId(id);
    }

    @Override
    public void update(Pants object) {
         pantsRepository.update(object);
    }

    @Override
    public void delete(Pants object) {
        pantsRepository.delete(object);
    }

    @Override
    public List<Pants> search(String name) {
        return pantsRepository.search(name);
    }
}
