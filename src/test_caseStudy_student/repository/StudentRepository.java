package test_caseStudy_student.repository;

import test_caseStudy_student.model.Student;

public class StudentRepository {
    private static Student[] students = new Student[100];

    static {
        students[0] = new Student("Nguyen Van An", 18, "C07");
        students[1] = new Student("Tran Minh Nhan", 21, "C08");
        students[2] = new Student("Tran Ngoc Minh", 19, "C09");
        students[3] = new Student("Le Van Kha", 23, "C06");
    }

    public Student[] getAll() {
        return students;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }
}
