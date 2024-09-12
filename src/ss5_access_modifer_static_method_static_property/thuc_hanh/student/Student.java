package ss5_access_modifer_static_method_static_property.thuc_hanh.student;

public class Student {
    public int id;
    public String name;
    public static String school = "CG";
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' + ", school = " + school+
                '}';
    }
}
