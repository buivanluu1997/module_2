package case_study_clothing_store.repository;

import java.util.List;

public interface IProductRepository<T> {
    void add(T object);

    List<T> getAll();

    T findId(String id);

    void update(T object);

    void delete(T object);

    List<T> search(String name);
}
