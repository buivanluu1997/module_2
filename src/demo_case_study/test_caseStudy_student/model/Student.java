package demo_case_study.test_caseStudy_student.model;

public class Student{
    private String name;
    private int age;
    private int id;
    private String className;
    public static String schoolName = "Nguyễn Đình Chiểu";

    public Student() {
    }

    public Student(String name, int id, int age, String className) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }




    public String toString() {
        return "Student: Name = " + name + ", Age = " + age + ", id = " + id + ", Class = " + className
                + ", School = " + schoolName;
    }


}
