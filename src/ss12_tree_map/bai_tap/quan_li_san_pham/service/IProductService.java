package ss12_tree_map.bai_tap.quan_li_san_pham.service;

import ss12_tree_map.bai_tap.quan_li_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    boolean save(Product product);

    List<Product> getAll();

    Product findById(int id);

    void delete(Product product);

    boolean edit(Product editProduct);

    List<Product> search(String name);

    List<Product> ascendingId();

    List<Product> sortName();

    ;

}
