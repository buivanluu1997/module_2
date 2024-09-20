package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Main {
    public static void main(String[] args) {
       Shape[] shapes = new Shape[3];
       shapes[0] = new Circle(1);
       shapes[1] = new Rectangle(2,3);
       shapes[2] = new Square(3);
        System.out.println("Dien tich Truoc khi resize: ");
       for (Shape shape : shapes) {
           System.out.println(shape);
       }
        double randomDouble = Math.random()*100;
        System.out.println( "random: " +randomDouble);
        System.out.println("Dien tich sau khi resize");
        for (Shape shape : shapes) {
            if (shape instanceof Resizeable) {
                ((Resizeable) shape).resize(randomDouble);
                System.out.println(shape);
            }
        }

    }
}
