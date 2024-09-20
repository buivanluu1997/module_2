package demo_case_study.test_demo_case_study.repository;

import demo_case_study.test_demo_case_study.model.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentRepository implements IStudentRepository {
    private static Student[] students = new Student[100];

    static {
        students[0] = new Student("Trần Văn Nhân", 1, "11A1");
        students[1] = new Student("Nguyễn Như Ngọc", 4, "11A7");
        students[2] = new Student("Lê Văn Hoàng", 3, "11A2");
        students[3] = new Student("Hồ Yến Nhi", 2, "11A3");
    }

    @Override
    public Student[] getAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    @Override
    public void delete(int index) {
        for (int i = index; i < students.length - 1; i++) {
            students[i] = students[i + 1];
        }
        students[students.length - 1] = null;
    }

    @Override
    public void searchName(String name) {
        boolean fount = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getName().equals(name)) {
                System.out.println(students[i]);
                fount = true;
                break;
            }
        }
        if (!fount) {
            System.out.println("Tên không có trong danh sách");
        }

    }
}