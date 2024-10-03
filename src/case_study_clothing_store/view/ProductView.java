package case_study_clothing_store.view;

import case_study_clothing_store.controller.PantsController;
import case_study_clothing_store.controller.ShirtController;
import case_study_clothing_store.controller.ShoesController;
import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.model.Shoes;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ShirtController shirtController = new ShirtController();
    private ShoesController shoesController = new ShoesController();
    private PantsController pantsController = new PantsController();
    private Scanner scanner = new Scanner(System.in);

    public void showProductMenu() {
        while (true) {
            try {
                System.out.println("Chọn chức năng: \n" +
                        "1. Thêm sản phẩm \n" +
                        "2. Hiển thị sản phẩm \n" +
                        "3. Sửa sản phẩm \n" +
                        "4. Xoá sản phẩm \n" +
                        "5. Tìm kiếm sản phẩm \n" +
                        "5. Thoát");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("<----------------------------Thêm sản phẩm---------------------------->");
                        addProduct();
                        break;
                    case 2:
                        System.out.println("<----------------------------Hiển thị sản phẩm---------------------------->");
                        showProduct();
                        break;
                    case 3:
                        System.out.println("<----------------------------Sửa sản phẩm---------------------------->");
                        updateProduct();
                        break;
                    case 4:
                        System.out.println("<----------------------------Xoá sản phẩm---------------------------->");
                        deleteProduct();
                        break;
                    case 5:
                        System.out.println("<----------------------------Tìm kiếm sản phẩm---------------------------->");
                        searchName();
                        break;
                    case 6:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Phải nhập số nguyên.");
            }

        }
    }

    private void searchName() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        List<Shirt> shirtList = shirtController.search(name);
        List<Pants> pantsList = pantsController.search(name);
        List<Shoes> shoesList = shoesController.search(name);

        if (shirtList.isEmpty() && pantsList.isEmpty() && shoesList.isEmpty()) {
            System.out.println("Sản phầm không tồn tại");
        } else {
            if (!shirtList.isEmpty()) {
                for (Shirt shirt : shirtList) {
                    System.out.println(shirt.displayInfo());
                }
            } else if (!pantsList.isEmpty()) {
                for (Pants pants : pantsList) {
                    System.out.println(pants.displayInfo());
                }
            } else if (!shoesList.isEmpty()) {
                for (Shoes shoes : shoesList) {
                    System.out.println(shoes.displayInfo());
                }
            }
        }
    }

    public void updateProduct() {
        System.out.println("Nhập id bạn muốn sửa");
        String id = scanner.nextLine();
        Shirt shirt = shirtController.findId(id);
        Pants pants = pantsController.findId(id);
        Shoes shoes = shoesController.findId(id);
        if (shirt == null && pants == null && shoes == null) {
            System.out.println("Sản phẩm không tồn tại");
            return;
        }
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (shirt != null) {

            System.out.println("Nhập size áo: ");
            String size = scanner.nextLine();
            System.out.println("Nhập màu áo: ");
            String color = scanner.nextLine();
            Shirt updateShirt = new Shirt(id, name, brand, price, quantity, size, color);
            shirtController.update(updateShirt);
        } else if (pants != null) {

            System.out.println("Nhập kích thước vòng eo: ");
            int waistSize = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập chiêu dài của quần: ");
            int length = Integer.parseInt(scanner.nextLine());
            Pants updatePants = new Pants(id, name, brand, price, quantity, waistSize, length);
            pantsController.update(updatePants);
        } else if (shoes != null) {

            System.out.println("Nhập size giày: ");
            int sizeShoes = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập chất liệu");
            String material = scanner.nextLine();
            Shoes updateShoes = new Shoes(id, name, brand, price, quantity, sizeShoes, material);
            shoesController.update(updateShoes);
        }
        System.out.println("Đã sửa sản phẩm thành công");
    }

    public void deleteProduct() {
        System.out.println("Nhập id bạn muốn xoá:");
        String id = scanner.nextLine();
        Shirt shirt = shirtController.findId(id);
        Pants pants = pantsController.findId(id);
        Shoes shoes = shoesController.findId(id);
        if (shirt != null || pants != null || shoes != null) {
            try {
                System.out.println("Bạn chắc chắn xoá không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int choose = Integer.parseInt(scanner.nextLine());
                if (choose == 1) {
                    if (shirt != null) {
                        shirtController.delete(shirt);
                    }
                    if (pants != null) {
                        pantsController.delete(pants);
                    }
                    if (shoes != null) {
                        shoesController.delete(shoes);
                    }
                    System.out.println("Đã xoá sản phẩm thành công");
                } else {
                    System.out.println("Đóng");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập không đúng số nguyên");
            }

        } else {
            System.out.println("Sản phầm không tồn tại");
        }
    }

    public void showProduct() {
        try {
            System.out.println("Chọn sản phẩm để để hiển thị: \n" +
                    "1. Áo \n" +
                    "2. Quần \n" +
                    "3. Giày \n" +
                    "4. Hiển thị tất cả");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("-------------Áo-------------");
                    showShirt();
                    break;
                case 2:
                    System.out.println("-------------Quần-------------");
                    showPants();
                    break;
                case 3:
                    System.out.println("-------------Giày-------------");
                    showShoes();
                    break;
                case 4:
                    System.out.println("-------------Áo-------------");
                    showShirt();
                    System.out.println("-------------Quần-------------");
                    showPants();
                    System.out.println("-------------Giày-------------");
                    showShoes();
                    break;
                default:
                    System.out.println("Chọn từ 1-3, bạn chọn ngoài nên thoát");
            }
        } catch (Exception e) {
            System.out.println("Phải chọn đúng số nguyên");
        }
    }

    private void showShoes() {
        for (int i = 0; i < shoesController.getAll().size(); i++) {
            System.out.println(shoesController.getAll().get(i).displayInfo());
        }
    }

    private void showPants() {
        for (int i = 0; i < pantsController.getAll().size(); i++) {
            System.out.println(pantsController.getAll().get(i).displayInfo());
        }
    }

    private void showShirt() {
        for (int i = 0; i < shirtController.getAll().size(); i++) {
            System.out.println(shirtController.getAll().get(i).displayInfo());
        }
    }

    public void addProduct() {
        try {
            System.out.println("Chọn sản phẩm để thêm: \n" +
                    "1. Áo \n" +
                    "2. Quần \n" +
                    "3. Giày");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addShirt();
                    break;
                case 2:
                    addPants();
                    break;
                case 3:
                    addShoes();
                    break;
                default:
                    System.out.println("Chọn từ 1-3, bạn chọn ngoài nên thoát");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Phải chọn đúng số nguyên");
        }

    }

    private void addShoes() {
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên giày: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập size giày: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại giày: ");
        String material = scanner.nextLine();
        Shoes shoes = new Shoes(id, name, brand, price, quantity, size, material);
        shoesController.add(shoes);
    }

    private void addPants() {
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên quần: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kích thước vòng eo: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chiều dài quần: ");
        int length = Integer.parseInt(scanner.nextLine());
        Pants pants = new Pants(id, name, brand, price, quantity, size, length);
        pantsController.add(pants);
    }

    private void addShirt() {
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên áo: ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập size: ");
        String size = scanner.nextLine();
        System.out.println("Nhập màu: ");
        String color = scanner.nextLine();
        Shirt shirt = new Shirt(id, name, brand, price, quantity, size, color);
        shirtController.add(shirt);
    }
}
