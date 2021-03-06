package dao.custom.impl;

import dao.SuperDAOMain;
import dao.custom.QueryDAO;
import entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Programme> getProgrammeList(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "select p.* from student_programme sp inner join programme p ON sp.programmeList_programmeID = p.programmeID where sp.studentList_regNumber=?1";
        NativeQuery nativeQuery = session.createNativeQuery(sql).addEntity(Programme.class);
        nativeQuery.setParameter(1, s);
        List list = nativeQuery.list();

        transaction.commit();
        session.close();
        return list;
    }
}
