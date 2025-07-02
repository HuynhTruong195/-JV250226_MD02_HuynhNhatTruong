import Dao.StudentDao;
import entity.Students;
import service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********* STUDENT MANAGEMENT ********");
            System.out.println("1. Danh sách sinh viên ");
            System.out.println("2. Thêm mới sinh viên ");
            System.out.println("3. Cập nhật sinh viên ");
            System.out.println("4. Xoá sinh viên ");
            System.out.println("5. Tìm kiếm sinh viên theo tên ");
            System.out.println("6. Sắp xếp sinh viên theo ngày đăng ký");
            System.out.println("7. Thoát ");
            System.out.println("Nhập lựa chọn");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentService.getStudent();
                    break;
                case 2:
                    StudentService.addStudent(scanner);
                    break;
                case 3:
                    StudentService.updateStudent(scanner);
                    break;
                case 4:
                    StudentService.deleteStudent(scanner);
                    break;
                case 5:
                    StudentService.findstudent(scanner);
                    break;
                case 6:
                    StudentService.sortStudentByDate();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }

        } while (true);

    }
}