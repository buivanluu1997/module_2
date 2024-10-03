package case_study_clothing_store.repository;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.model.Shoes;
import case_study_clothing_store.util.ReadWriteFile;
import demo_case_study.test_caseStudy_student.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class ShoesRepository implements IProductRepository<Shoes> {

    private final String SHOES_CSV = "src/case_study_clothing_store/data/shoes.csv";

    @Override
    public void writeFile(List<Shoes> list) {
        List<String> stringList = new ArrayList<>();
        for (Shoes shoe : list) {
            String line = shoe.convertShoesToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(SHOES_CSV, stringList, false);
    }

    @Override
    public void add(Shoes object) {
        List<Shoes> shoesList = getAll();
        shoesList.add(object);

        writeFile(shoesList);
    }

    @Override
    public List<Shoes> getAll() {
        List<String> stringList = ReadWriteFile.readFile(SHOES_CSV);
        List<Shoes> shoesList = new ArrayList<>();
        for (String line : stringList) {
            String[] array = line.split(",");
            String id = array[0];
            String name = array[1];
            String brand = array[2];
            double price = Double.parseDouble(array[3]);
            int quantity = Integer.parseInt(array[4]);
            int sizeShoes = Integer.parseInt(array[5]);
            String material = array[6];

            Shoes shoes = new Shoes(id, name, brand, price, quantity, sizeShoes, material);
            shoesList.add(shoes);
        }
        return shoesList;
    }

    @Override
    public Shoes findId(String id) {
        List<Shoes> shoesList = getAll();
        for (Shoes shoes : shoesList) {
            if (shoes.getId().equals(id)) {
                return shoes;
            }
        }
        return null;
    }

    @Override
    public void update(Shoes object) {
        List<Shoes> shoesList = getAll();
        for (Shoes shoes : shoesList) {
            if (shoes.getId().equals(object.getId())) {
                shoes.setName(object.getName());
                shoes.setBrand(object.getBrand());
                shoes.setPrice(object.getPrice());
                shoes.setQuantity(object.getQuantity());
                shoes.setSizeShoes(object.getSizeShoes());
                shoes.setMaterial(object.getMaterial());
            }
        }
        writeFile(shoesList);
    }

    @Override
    public void delete(Shoes object) {
        List<Shoes> shoesList = getAll();
        for (int i = 0; i < shoesList.size(); i++) {
            if (shoesList.get(i).getId().equals(object.getId())) {
                shoesList.remove(shoesList.get(i));
            }
        }
        writeFile(shoesList);
    }

    @Override
    public List<Shoes> search(String name) {
        List<Shoes> shoesList = getAll();
        List<Shoes> list = new ArrayList<>();
        for (Shoes shoes : shoesList) {
            if (shoes.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(shoes);
            }
        }
        return list;
    }
}
