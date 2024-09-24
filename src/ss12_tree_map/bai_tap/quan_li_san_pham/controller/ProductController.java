package ss12_tree_map.bai_tap.quan_li_san_pham.controller;

import ss12_tree_map.bai_tap.quan_li_san_pham.model.Product;
import ss12_tree_map.bai_tap.quan_li_san_pham.service.IProductService;
import ss12_tree_map.bai_tap.quan_li_san_pham.service.impl.ProductService;

import java.util.List;

public class ProductController {
    private IProductService productService = new ProductService();

    public boolean save(Product product) {
        return this.productService.save(product);

    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public Product findByID(int id) {
        return this.productService.findById(id);
    }

    public void delete(Product product) {
        this.productService.delete(product);
    }

    public boolean edit(Product editProduct) {
        return this.productService.edit(editProduct);
    }

    public List<Product> search(String name) {
        return this.productService.search(name);
    }

    public List<Product> sortedProducts (int typeSort) {
        return productService.sortedProducts(typeSort);
    }
}
