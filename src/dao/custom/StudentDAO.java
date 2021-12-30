package dao.custom;

import dao.SuperDAO;
import entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDAO<Student,String> {
boolean register (Student student,String cmb01,String cmb02,String cmb03);
    List<Student> searchStudent(String value);
    boolean nativeUpdate (String student, String cmb01);
}
