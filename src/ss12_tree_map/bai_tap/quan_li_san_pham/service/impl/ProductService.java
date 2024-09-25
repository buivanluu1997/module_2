package ss12_tree_map.bai_tap.quan_li_san_pham.service.impl;

import ss12_tree_map.bai_tap.quan_li_san_pham.model.Product;
import ss12_tree_map.bai_tap.quan_li_san_pham.repository.IProductRepository;
import ss12_tree_map.bai_tap.quan_li_san_pham.repository.impl.ProductRepository;
import ss12_tree_map.bai_tap.quan_li_san_pham.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public boolean save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void delete(Product product) {
        this.productRepository.delete(product);
    }

    @Override
    public boolean edit(Product editProduct) {
        return this.productRepository.edit(editProduct);
    }

    @Override
    public List<Product> search(String name) {
        return this.productRepository.search(name);
    }

    @Override
    public List<Product> ascendingId() {
        return productRepository.ascendingId();
    }

    @Override
    public List<Product> sortName() {
        return productRepository.sortName();
    }

}
