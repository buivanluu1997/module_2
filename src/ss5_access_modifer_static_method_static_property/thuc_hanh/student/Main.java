package ss5_access_modifer_static_method_static_property.thuc_hanh.student;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nam");
        Student student2 = new Student(1, "Quang");

        Student.school = "new CG";
        System.out.println(student1);
        System.out.println(student2);

        System.out.println(Student.school);
    }
}
