package test_caseStudy_student.service;

import test_caseStudy_student.model.Student;
import test_caseStudy_student.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public Student[] getAll() {
        return studentRepository.getAll();
    }

    public void addStudent(Student student) {
        // kiem tra dl:
        studentRepository.addStudent(student);
    }
}
