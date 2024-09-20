package demo_case_study.test_caseStudy_student.repository;

import demo_case_study.test_caseStudy_student.model.Student;

public interface IStudentRepository {
    public Student[] getAll();

    public void delete(int index );

    public void add(Student student);

}
