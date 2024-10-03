package case_study_clothing_store.repository;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.util.ReadWriteFile;
import demo_case_study.test_caseStudy_student.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class ShirtRepository implements IProductRepository<Shirt> {

    private final String SHIRT_CSV = "src/case_study_clothing_store/data/shirt.csv";
    @Override
    public void writeFile(List<Shirt> list) {
        List<String> stringList = new ArrayList<>();
        for (Shirt shirt : list) {
            String line = shirt.convertShirtToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(SHIRT_CSV, stringList, false);
    }

    @Override
    public void add(Shirt object) {
       List<Shirt> shirtList = getAll();
       shirtList.add(object);

       writeFile(shirtList);
    }

    @Override
    public List<Shirt> getAll() {
        List<String> stringList = ReadWriteFile.readFile(SHIRT_CSV);
        List<Shirt> shirtList = new ArrayList<>();

        for (String line : stringList) {
            String[] array = line.split(",");
            String id = array[0];
            String name = array[1];
            String brand = array[2];
            double price = Double.parseDouble(array[3]);
            int quantity = Integer.parseInt(array[4]);
            String size = array[5];
            String color = array[6];

            Shirt shirt = new Shirt(id, name, brand, price, quantity, size, color);
            shirtList.add(shirt);
        }
        return shirtList;
    }

    @Override
    public Shirt findId(String id) {
        List<Shirt> shirtList = getAll();
        for (Shirt shirt : shirtList) {
            if (shirt.getId().equals(id)) {
                return shirt;
            }
        }
        return null;
    }

    @Override
    public void update(Shirt object) {
        List<Shirt> shirtList = getAll();
        for (Shirt shirt : shirtList) {
            if (shirt.getId().equals(object.getId())) {
                shirt.setName(object.getName());
                shirt.setBrand(object.getBrand());
                shirt.setPrice(object.getPrice());
                shirt.setQuantity(object.getQuantity());
                shirt.setSize(object.getSize());
                shirt.setColor(object.getColor());
            }
        }
        writeFile(shirtList);
    }

    @Override
    public void delete(Shirt object) {
        List<Shirt> shirtList = getAll();
        for (int i = 0; i < shirtList.size(); i++) {
            if (shirtList.get(i).getId().equals(object.getId())) {
                shirtList.remove(shirtList.get(i));
            }
        }
        writeFile(shirtList);
    }

    @Override
    public List<Shirt> search(String name) {
        List<Shirt> shirtList = getAll();
        List<Shirt> list = new ArrayList<>();
        for (Shirt shirt : shirtList) {
            if (shirt.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(shirt);
            }
        }
        return list;
    }
}
