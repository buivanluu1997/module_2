package demo_case_study.test_caseStudy_student.repository;

import demo_case_study.test_caseStudy_student.model.Student;

import java.util.Arrays;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    public static Student[] students = new Student[100];

    static {
        students[0] = new Student("Nguyên Văn Nam", 2, 16,"11A1");
        students[1] = new Student("Trần Như Ngọc", 1, 16,"11A2");
        students[2] = new Student("Đỗ Văn Chiến", 5, 16,"11A4");
        students[3] = new Student("Nguyên Trọng Hoàng", 3, 16,"11A6");
        students[4] = new Student("Lê Huỳnh Đức", 4, 16,"11A3");
    }

    @Override
    public Student[] getAll() {
        return students;
    }

    @Override
    public void delete(int index )
    {
        if(index == students.length -1) {
            students[index] = null;
            return;
        }
        students[index] = null ;
        for(int i = index ; i < students.length -1 ; i ++)
        {
            students[i] = students[i +1];
        }
    }

    @Override
    public void add(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }
}
