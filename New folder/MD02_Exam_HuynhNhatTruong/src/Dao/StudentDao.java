package Dao;

import entity.Students;
import ultil.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static List<Students> getAllStudents() {
        List<Students> listStudent = null;
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call get_all_student()}");
            ResultSet rs = call.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()) {
                Students student = new Students();
                student.setStudentId(rs.getInt("student_id"));
                student.setFullName(rs.getString("full_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone_number"));
                student.setRegisterDate(LocalDate.parse(rs.getString("register_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                student.setStatus(rs.getBoolean("status"));
                listStudent.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return listStudent;
    }

    public static void main(String[] args) {
        getAllStudents();
    }


    public static Boolean updateStudent(Students student) {
        Connection conn = null;
        CallableStatement call = null;
        Boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call update_student(?,?,?,?,?,?)}");
            call.setInt(1, student.getStudentId());
            call.setString(2, student.getFullName());
            call.setString(3, student.getEmail());
            call.setString(4, student.getPhone());
            call.setDate(5, Date.valueOf(student.getRegisterDate()));
            call.setBoolean(6, student.getStatus());
            call.executeUpdate();
            result = true;


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return result;
    }


    public static Students getStudentById(int id) {
        Connection conn = null;
        CallableStatement call = null;
        Students student = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call get_student_by_id(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                student = new Students();
                student.setFullName(rs.getString("full_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone_number"));
                student.setRegisterDate(LocalDate.parse(rs.getString("register_date")));
                student.setStatus(rs.getBoolean("status"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return student;
    }


    public static Boolean addStudent(Students student) {
        Connection conn = null;
        CallableStatement call = null;
        Boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call add_student(?,?,?,?)}");
            call.setString(1, student.getFullName());
            call.setString(2, student.getEmail());
            call.setString(3, student.getPhone());
            call.setDate(4, Date.valueOf(student.getRegisterDate()));
            call.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return result;
    }

    public static Boolean deleteStudent(int id) {
        Connection conn = null;
        CallableStatement call = null;
        Boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call delete_student(?)}");
            call.setInt(1, id);
            call.executeUpdate();
            result = true;


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return result;
    }

    public static List<Students> getStudentByName(String fullName) {
        List<Students> listStudent = null;
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call find_student_by_name(?)}");
            call.setString(1, fullName);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Students student = new Students();
                student.setStudentId(rs.getInt("student_id"));
                student.setFullName(rs.getString("full_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone_number"));
                student.setRegisterDate(LocalDate.parse(rs.getString("register_date")));
                student.setStatus(rs.getBoolean("status"));
                listStudent.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return listStudent;

    }


    public static List<Students> sortStudent() {
        List<Students> listStudent = null;
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("SELECT * FROM student ORDER BY Register_date DESC");
            ResultSet rs = call.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()) {
                Students student = new Students();
                student.setStudentId(rs.getInt("student_id"));
                student.setFullName(rs.getString("full_name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone_number"));
                student.setRegisterDate(LocalDate.parse(rs.getString("register_date")));
                student.setStatus(rs.getBoolean("status"));
                listStudent.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return listStudent;

    }
}



