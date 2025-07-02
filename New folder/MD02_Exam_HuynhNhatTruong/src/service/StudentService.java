package service;

import Dao.StudentDao;
import entity.Students;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    Scanner scanner = new Scanner(System.in);

    public static void getStudent() {
        List<Students> listStudent = StudentDao.getAllStudents();
        if (listStudent == null) {
            System.err.println("Có lỗi xảy ra trong quá trình xử lý");
        } else {
            System.out.println("Danh sách sinh viên");
            listStudent.forEach(System.out::println);
        }
    }

//    public static void main(String[] args) {
//        getStudent();
//    }


    public static void addStudent(Scanner scanner) {
        Students student = new Students();
        System.out.println("Nhập tên sinh viên");
        student.setFullName(scanner.nextLine());
        System.out.println("Nhập Email ");
        student.setEmail(scanner.nextLine());
        System.out.println("Nhập số điện thoại");
        student.setPhone(scanner.nextLine());
        System.out.println("Nhập ngày đăng ký");
        student.setRegisterDate(LocalDate.parse(scanner.nextLine()));

        Boolean result = StudentDao.addStudent(student);
        if (result) {
            System.out.println("Thêm sinh viên thành công");
        } else {
            System.out.println("Có lỗi trong quá trình thêm sinh viên");
        }
    }

    public static void updateStudent(Scanner scanner) {
        System.out.println("Nhập id sinh viên cần cập nhật");
        int id = Integer.parseInt(scanner.nextLine());
        Students student = StudentDao.getStudentById(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên có ID là " + id);
            return;
        } else {
            Boolean isExit = false;
            do {
                System.out.println("****Cập Nhật****");
                System.out.println("1. Cập nhật tên");
                System.out.println("2. Cập Email ");
                System.out.println("3. Cập nhật số điện thoại");
                System.out.println("4. Cập nhật ngày đăng ký");
                System.out.println("5. Cập nhật trạng thái");
                System.out.println("6. Thoát");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tên mới");
                        student.setFullName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập Email mới");
                        student.setEmail(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập số điện thoại mới");
                        student.setPhone(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập ngày đăng ký mới");
                        student.setRegisterDate(LocalDate.parse(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Nhập trạng thái mới true/false");
                        student.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 6:
                        isExit = true;
                }
            } while (isExit);
        }

        Boolean studentUpdate = StudentDao.updateStudent(student);
        if (studentUpdate) {
            System.out.println("Cập nhật thành công");
        } else {
            System.err.println("Có lỗi trong quá trình cập nhật");
        }
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("Nhập ID sinh viên cần xoá");
        int id = Integer.parseInt(scanner.nextLine());
        Students student = StudentDao.getStudentById(id);
        if (student != null) {
            Boolean students = StudentDao.deleteStudent(id);
            if (students) {
                System.out.println("Xoá thành công sinh viên có ID là" + id);
            } else {
                System.err.println("Có lỗi trong quá trình xoá");
            }
        } else {
            System.out.printf("ID sinh viên '%d' không tồn tại %n", id);
        }
    }

    public static void findstudent(Scanner scanner) {
        System.out.println("Nhập tên sinh viên cần tìm");
        String name = scanner.nextLine().trim().toLowerCase();
        List<Students> listSearchStudent = StudentDao.getStudentByName(name);
        if (listSearchStudent != null) {
            listSearchStudent.forEach(System.out::println);
        } else {
            System.out.printf("Không tìm thấy sinh viên tên %s%n", name);
        }

    }



    public static void sortStudentByDate(){
        List<Students> listSortStudentByDate = StudentDao.sortStudent();
        if (listSortStudentByDate != null) {
            System.out.println("Danh sách sinh viên sắp xếp theo ngày đăng ký");
            listSortStudentByDate.forEach(System.out::println);
        }
    }

}
