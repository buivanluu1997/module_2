package ss7_abstract_interface.thuc_hanh.animal_interface_edible;

import ss7_abstract_interface.thuc_hanh.animal_interface_edible.fruit.Apple;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.fruit.Fruit;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
