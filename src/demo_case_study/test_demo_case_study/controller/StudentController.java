package demo_case_study.test_demo_case_study.controller;

import demo_case_study.test_demo_case_study.model.Student;
import demo_case_study.test_demo_case_study.service.IStudentService;
import demo_case_study.test_demo_case_study.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();

    public static void ShowStudentMenu() {

        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Hiển thị \n" +
                    "2. Thêm \n" +
                    "3. Xoá \n" +
                    "4. Tìm kiếm tên \n" +
                    "5. Thoát");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("<-------------------------------Hiển thị----------------------------->");
                    studentService.displayStudent();
                    break;
                case 2:
                    System.out.println("<-------------------------------Thêm---------------------------->");
                    Student student = inputStudent();
                    studentService.add(student);
                    break;
                case 3:
                    System.out.println("--------------------------------Xoá--------------------------------->");
                    handleLogicDelete();
                    break;
                case 4:
                    System.out.println("<------------------------------Tìm kiếm tên------------------------------>");
                    displayFindName();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    public static Student inputStudent() {
        System.out.println("Nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.println("Nhập id học sinh: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập lớp học sinh: ");
        String className = scanner.nextLine();

        Student student1 = new Student(name, id, className);
        return student1;
    }

    public static void handleLogicDelete(){
        System.out.println("Nhập id cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentService.delete(id);
    }

    public static void displayFindName() {
        System.out.println("Nhập tên bạn muốn tìm: ");
        String name = scanner.nextLine();
        studentService.searchName(name);
    }
}
