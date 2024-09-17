package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Main {
    public static void main(String[] args) {
       Shape[] shapes = new Shape[3];
       shapes[0] = new Circle(1);
       shapes[1] = new Rectangle(2,3);
       shapes[2] = new Square(3);
        System.out.println("Truoc khi resize: ");
       for (Shape shape : shapes) {
           System.out.println(shape);
       }
        double randomDouble = Math.random()*100;
        System.out.println( "random: " +randomDouble);
       for (int i = 0; i < shapes.length; i++) {
           shapes[i].resize(randomDouble);
       }
        System.out.println("Sau khi resize:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

    }
}
