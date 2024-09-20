package demo_case_study.test_demo_case_study.repository;

import demo_case_study.test_demo_case_study.model.Student;

public interface IStudentRepository {
    public Student[] getAll();

    public void add(Student student);

    public void delete(int index);

    public void searchName(String name);
}
