package demo_case_study.test_caseStudy_student.service;

import demo_case_study.test_caseStudy_student.model.Student;

public interface IStudentService {
    public Student[] getAll();

    public void add(Student student);


    public void displayStudent();

    public void DeleteStudent(int id);

}
