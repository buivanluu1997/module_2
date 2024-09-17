package test_caseStudy_student.controller;

import test_caseStudy_student.model.Student;
import test_caseStudy_student.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();

    public static void showStudentMenu(){
        while (true) {
            System.out.println("Chọn chức năng: \n"
                    + "1. Hiển thị \n"
                    + "2. Thêm mới \n"
                    +"3. Xoá \n"
                    + "4. Thoát ra" );
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                        System.out.println("<-------------------------Hiển thị danh sách-------------------------->");
                        Student[] students = studentService.getAll();
                        displayStudent(students);
                        break;
            }
        }
    }
    public static void displayStudent(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i].toString());
            }
        }
    }
}
