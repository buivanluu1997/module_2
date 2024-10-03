package case_study_clothing_store.repository;

import case_study_clothing_store.model.Pants;
import case_study_clothing_store.model.Shirt;
import case_study_clothing_store.util.ReadWriteFile;
import demo_case_study.test_caseStudy_student.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class PantsRepository implements IProductRepository<Pants> {

    private final String PANTS_CSV = "src/case_study_clothing_store/data/pants.csv";

    @Override
    public void writeFile(List<Pants> pantsList) {
        List<String> stringList = new ArrayList<>();
        for (Pants pants : pantsList) {
            String line = pants.convertPantsToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(PANTS_CSV, stringList, false);
    }

    @Override
    public void add(Pants pants) {
        List<Pants> pantsList = getAll();
        pantsList.add(pants);

        writeFile(pantsList);
    }

    @Override
    public List<Pants> getAll() {
        List<String> stringList = ReadWriteFile.readFile(PANTS_CSV);
        List<Pants> pantsList = new ArrayList<>();

        for (String line : stringList) {
            String[] array = line.split(",");
            String id = array[0];
            String name = array[1];
            String brand = array[2];
            double price = Double.parseDouble(array[3]);
            int quantity = Integer.parseInt(array[4]);
            int waistSize = Integer.parseInt(array[5]);
            int length = Integer.parseInt(array[6]);

            Pants pants = new Pants(id, name, brand, price, quantity, waistSize, length);
            pantsList.add(pants);
        }
        return pantsList;
    }


    @Override
    public Pants findId(String id) {
        List<Pants> pantsList = getAll();
        for (Pants pants : pantsList) {
            if (pants.getId().equals(id)) {
                return pants;
            }
        }
        return null;
    }

    @Override
    public void update(Pants object) {
        List<Pants> pantsList = getAll();
        for (Pants pants : pantsList) {
            if (pants.getId().equals(object.getId())) {
                pants.setName(object.getName());
                pants.setBrand(object.getBrand());
                pants.setPrice(object.getPrice());
                pants.setQuantity(object.getQuantity());
                pants.setWaistSize(object.getWaistSize());
                pants.setLength(object.getLength());
            }
        }
        writeFile(pantsList);
    }

    @Override
    public void delete(Pants object) {
        List<Pants> pantsList = getAll();
        for (int i = 0; i < pantsList.size(); i++) {
            if (pantsList.get(i).getId().equals(object.getId())) {
                pantsList.remove(pantsList.get(i));
            }
        }
        writeFile(pantsList);
    }

    @Override
    public List<Pants> search(String name) {
        List<Pants> pantsList = getAll();
        List<Pants> list = new ArrayList<>();
        for (Pants pants : pantsList) {
            if (pants.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(pants);
            }
        }
        return list;
    }
}