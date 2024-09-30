package case_study_clothing_store.service;

import java.util.List;

public interface IProductService<T> {
    void add(T object);

    List<T> getAll();

    T findId(String id);

    void update(T object);

    void delete(T object);

    List<T> search(String name);
}
