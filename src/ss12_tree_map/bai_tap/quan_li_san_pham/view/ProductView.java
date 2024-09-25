package ss12_tree_map.bai_tap.quan_li_san_pham.view;


import ss12_tree_map.bai_tap.quan_li_san_pham.controller.ProductController;
import ss12_tree_map.bai_tap.quan_li_san_pham.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private ProductController productController = new ProductController();

    public void randerProductMenu() {
        while (true) {
            System.out.println("Quản lý sản phẩm: \n" +
                    "1. Thêm sản phẩm \n" +
                    "2. Sửa thông tin sản phẩm theo id \n" +
                    "3. Xoá sản phẩm theo id \n" +
                    "4. Hiển thị danh sách sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên \n" +
                    "6. Sắp xếp sản phẩm tăng dần theo id hoặc theo tên \n" +
                    "7. Thoát");
            System.out.println("Chọn chức năng: ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("<-----------------------------Thêm sản phẩm---------------------------->");
                    addNewProduct();
                    break;
                case 2:
                    System.out.println("<-----------------------Sửa thông tin sản phẩm theo id---------------------->");
                    updateProduct();
                    break;
                case 3:
                    System.out.println("<-----------------------Xoá sản phẩm theo id-------------------------->");
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("<-----------------------------Hiển thị danh sách sản phẩm---------------------------->");
                    displayProduct();
                    break;
                case 5:
                    System.out.println("<---------------------------Tìm kiếm sản phẩm theo tên-------------------------->");
                    searchNameProduct();
                    break;
                case 6:
                    System.out.println("<------------------------------Sắp xếp sản phẩm------------------------------------>");
                    sortProduct();
                    break;
            }
        }
    }

    private void sortProduct() {
        System.out.println("Chọn kiểu sắp xếp");
        System.out.println("1. Sắp xếp từ bé đến lớn");
        System.out.println("2. Sắp xếp theo tên");
        int typeSort = Integer.parseInt(scanner.nextLine());
        switch (typeSort) {
            case 1:
                List<Product> sortIDs = productController.ascendingId();
                for (Product product : sortIDs) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                List<Product> sortNames = productController.sortName();
                for (Product product : sortNames) {
                    System.out.println(product.toString());
                }
                break;
            default:
                System.out.println("Chọn số sai");
                break;
        }
    }
    private void searchNameProduct() {
        System.out.println("Nhập tên sản phẩm muốn tìm kiếm: ");
        String name = scanner.nextLine();
        List<Product> findProducts = this.productController.search(name);
        if (findProducts.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm");
        }
        for (Product product : findProducts) {
            System.out.println(product.toString());
        }
    }
    private void updateProduct() {
        System.out.println("Nhập id muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm để sửa:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm để sửa: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product editProduct = new Product(id, name, price);

        if (this.productController.edit(editProduct)) {
            System.out.println("Đã cập nhật sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    private void deleteProduct() {
        System.out.println("Nhập id bạn muốn xoá");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = this.productController.findByID(id);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            System.out.println("Bạn thật sự muốn xoá? \n" +
                    "1. Có \n" +
                    "2. Không");
            int deletechoise = Integer.parseInt(scanner.nextLine());
            if (deletechoise == 1) {
                this.productController.delete(product);
                System.out.println("Đã xoá sản phẩm");
            } else {
                System.out.println("Đóng");
            }
        }
    }

    private void displayProduct() {
        List<Product> productList = this.productController.getAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private void addNewProduct() {
        System.out.println("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        boolean result = this.productController.save(product);
        if (result == false) {
            System.out.println("Id sản phẩm đã tồn tại");
        } else {
            System.out.println("Thêm sản phẩm thành công");
        }
    }
}
