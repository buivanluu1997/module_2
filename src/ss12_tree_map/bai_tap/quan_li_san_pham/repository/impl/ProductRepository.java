package ss12_tree_map.bai_tap.quan_li_san_pham.repository.impl;

import ss12_tree_map.bai_tap.quan_li_san_pham.model.Product;
import ss12_tree_map.bai_tap.quan_li_san_pham.repository.IProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class ProductRepository implements IProductRepository {
    private List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(1, "Iphone 15", 1500));
        productList.add(new Product(4, "SamSung Galaxy 24", 2000));
        productList.add(new Product(2, "Nokia A7", 1200));
        productList.add(new Product(3, "Xiaomi", 1400));
    }

    @Override
    public boolean save(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                return false;
            }
        }
        productList.add(product);
        return true;

    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(Product product) {
        this.productList.remove(product);
    }

    @Override
    public boolean edit(Product editProduct) {
        for (Product product : productList) {
            if (product.getId() == editProduct.getId()) {
                product.setName(editProduct.getName());
                product.setPrice(editProduct.getPrice());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> result = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> sortedProducts(int typeSort) {
        List<Product> result = new ArrayList<>();
        result = productList;

        if (typeSort == 1) {
            Collections.sort(result);
        }
        if (typeSort == 2) {
            Collections.sort(result);
            result = result.reversed();
        }
        return result;
    }


}
