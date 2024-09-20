package demo_case_study.test_caseStudy_student.service;

import demo_case_study.test_caseStudy_student.model.Student;
import demo_case_study.test_caseStudy_student.repository.StudentRepository;

import java.util.Arrays;

public class StudentService implements IStudentService {
    private StudentRepository studentRepository = new StudentRepository();

    @Override
    public Student[] getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }


    @Override
    public void displayStudent() {
        for (Student student : this.studentRepository.getAll()) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void DeleteStudent(int id) {
        int index = -1;
        for (int i = 0; i < this.studentRepository.getAll().length; i++) {
            if (this.studentRepository.getAll()[i] == null) {
                break;
            }
            if (this.studentRepository.getAll()[i].getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return;
        }

        this.studentRepository.delete(index);

    }

}
