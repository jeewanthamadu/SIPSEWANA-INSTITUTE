package dao.custom;

import dao.SuperDAO;
import entity.Programme;
import javafx.collections.ObservableList;
import view.tm.ProgrammeTM;

import java.util.List;

public interface ProgrammeDAO extends SuperDAO<Programme,String> {
   List<Programme> searchList (String value);
}
