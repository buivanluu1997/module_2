package ss12_tree_map.bai_tap.quan_li_san_pham.model;

import java.util.Comparator;

public class SortIdAscending implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Integer.compare(product1.getId(), product2.getId());
    }
}
