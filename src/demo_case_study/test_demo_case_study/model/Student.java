package demo_case_study.test_demo_case_study.model;

public class Student {
    private String name;
    private int id;
    private String className;
    public static String schoolName = "Hai Bà Trưng";

    public Student() {
    }

    public Student(String name, int id, String className) {
        this.name = name;
        this.id = id;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student: name = " + name + ", id = " + id + ", class = " + className + ", school = " + schoolName;
    }
}
