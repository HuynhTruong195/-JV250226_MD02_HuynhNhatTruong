package entity;

import java.time.LocalDate;

public class Students {
    private int studentId;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate registerDate;
    private Boolean status;

    public Students() {

    }

    public Students(int studentId, String fullName, String email, String phone, LocalDate registerDate, Boolean status) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.registerDate = registerDate;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Số điện thoại:  %s | Ngày đăng ký: %s | Tình trạng: %s", studentId, fullName, email, phone, registerDate, status ? "Hoạt động": "Không hoạt động");
    }
}
