package demo_case_study.test_demo_case_study.service;

import demo_case_study.test_demo_case_study.model.Student;
import demo_case_study.test_demo_case_study.repository.StudentRepository;


public class StudentService implements IStudentService{

    private StudentRepository studentRepository = new StudentRepository();

    @Override
    public Student[] getAll() {
        return studentRepository.getAll();
    }
    @Override
    public void displayStudent() {
        for (Student student : studentRepository.getAll()) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }
    @Override
    public void add(Student student){
        studentRepository.add(student);
    }
    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < studentRepository.getAll().length; i++ ) {
            if (studentRepository.getAll()[i] == null) {
                break;
            }
            if (studentRepository.getAll()[i].getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên với id = " + id);
        }

        studentRepository.delete(index);
    }

    @Override
    public void searchName(String name) {
        studentRepository.searchName(name);
    }

}
