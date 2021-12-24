package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;
import dto.StudentDTO;

import java.util.List;

public interface ProgrammeBO extends SuperBO {
    boolean add(ProgrammeDTO programmeDTO);
    List<ProgrammeDTO> find();
    boolean update(ProgrammeDTO programmeDTO);
    boolean delete(String id);
}
