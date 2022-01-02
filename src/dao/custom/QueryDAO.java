package dao.custom;

import dao.SuperDAOMain;
import entity.Programme;

import java.util.List;

public interface QueryDAO extends SuperDAOMain {
    List<Programme>getProgrammeList(String s);
}
