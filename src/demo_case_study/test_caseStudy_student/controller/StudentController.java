package demo_case_study.test_caseStudy_student.controller;


import demo_case_study.test_caseStudy_student.model.Student;
import demo_case_study.test_caseStudy_student.service.IStudentService;
import demo_case_study.test_caseStudy_student.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();

    public static void ShowStudentMenu() {


        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Hiển thị \n" +
                    "2. Thêm mới \n" +
                    "3. Xoá \n" +
                    "4. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("<---------------------------Hiển Thị----------------------------->");
                    studentService.displayStudent();
                    break;
                case 2:
                    System.out.println("<---------------------------Thêm Mới------------------------------");
                    Student student = inputStudent();
                    studentService.add(student);
                    break;
                case 3:
                    System.out.println("<----------------------------Xoá----------------------------->");
                    handleLogicDelete();
                    break;
                case 4:
                    System.exit(0);
            }
        }


    }

    public static Student inputStudent() {
        System.out.println("Nhập họ và tên học sinh: ");
        String name = scanner.nextLine();
        System.out.println("Nhập id của học sinh: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tuổi của học sinh: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Lớp của học sinh: ");

        String className = scanner.nextLine();

        Student student = new Student(name, id, age,className);
        return student;
    }

    public static void handleLogicDelete(){
        System.out.println("Nhap id can xoa");
        int idStudent = Integer.parseInt(scanner.nextLine());
        studentService.DeleteStudent(idStudent);

    }
}
