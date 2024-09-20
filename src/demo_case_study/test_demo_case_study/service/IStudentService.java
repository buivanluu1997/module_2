package demo_case_study.test_demo_case_study.service;

import demo_case_study.test_demo_case_study.model.Student;

public interface IStudentService {

    public Student[] getAll();

    public void displayStudent();

    public void add(Student student);

    public void delete(int id);

    public void searchName(String name);
}
