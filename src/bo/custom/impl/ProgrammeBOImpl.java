package bo.custom.impl;

import bo.custom.ProgrammeBO;
import dao.DAOFactory;
import dao.custom.impl.ProgrammeDAOImpl;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import entity.Programme;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeBOImpl implements ProgrammeBO {
    ProgrammeDAOImpl programmeDAO = (ProgrammeDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAMME);
    @Override
    public boolean add(ProgrammeDTO programmeDTO) {
        return programmeDAO.add(new Programme(
                programmeDTO.getProgrammeID(),
                programmeDTO.getProgrammeName(),
                programmeDTO.getDuration(),
                programmeDTO.getFee()
        ));
    }

    @Override
    public List<ProgrammeDTO> find() {
        List<Programme>list = programmeDAO.find();
        ArrayList<ProgrammeDTO> dtoArrayList=new ArrayList<>();

        ProgrammeDTO programmeDTO=null;

        for (Programme programme:list
             ) {dtoArrayList.add(new ProgrammeDTO(
                programme.getProgrammeID(),
                programme.getProgrammeName(),
                programme.getDuration(),
                programme.getFee()
                ));
        }
        return dtoArrayList;
    }

    @Override
    public boolean update(ProgrammeDTO programmeDTO) {
        return programmeDAO.update(new Programme(
                programmeDTO.getProgrammeID(),
                programmeDTO.getProgrammeName(),
                programmeDTO.getDuration(),
                programmeDTO.getFee()
        ));
    }

    @Override
    public boolean delete(String id) {
        return programmeDAO.delete(id);
    }
}
