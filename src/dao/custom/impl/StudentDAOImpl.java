package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Programme;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {
    @Override
    public Boolean add(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class,s);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> find() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student");
        List<Student> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean register(Student student, String cmb01, String cmb02, String cmb03) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if (cmb01 != null && !cmb01.trim().isEmpty()){
            Programme programme1 = session.get(Programme.class,cmb01);
            student.getProgrammeList().add(programme1);
        }

        if (cmb02 != null && !cmb02.trim().isEmpty()){
            Programme programme2 = session.get(Programme.class,cmb02);
            student.getProgrammeList().add(programme2);
        }

        if (cmb03 != null && !cmb03.trim().isEmpty()){
            Programme programme3 = session.get(Programme.class,cmb03);
            student.getProgrammeList().add(programme3);
        }

        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> searchStudent(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Student s WHERE s.regNumber LIKE ?1");
        query.setParameter(1, '%' + value + '%');
        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean nativeUpdate(String studentRegNumber, String cmb01) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        int i = session.createNativeQuery("INSERT INTO student_programme VALUES(?,?)").setParameter(1, studentRegNumber).setParameter(2, cmb01).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }
}
