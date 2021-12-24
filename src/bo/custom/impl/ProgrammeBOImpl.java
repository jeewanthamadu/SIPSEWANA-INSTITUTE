package bo.custom.impl;

import bo.custom.ProgrammeBO;
import dao.DAOFactory;
import dto.ProgrammeDTO;
import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeBOImpl implements ProgrammeBO {
    ProgrammeBOImpl programmeBO = (ProgrammeBOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAMME);
    @Override
    public boolean add(ProgrammeDTO programmeDTO) {
        return programmeBO.add(new ProgrammeDTO(
                programmeDTO.getProgrammeID(),
                programmeDTO.getProgrammeName(),
                programmeDTO.getDuration(),
                programmeDTO.getFee()
        ));
    }

    @Override
    public List<ProgrammeDTO> find() {
        List<ProgrammeDTO>list = programmeBO.find();
        ArrayList<ProgrammeDTO> dtoArrayList=new ArrayList<>();

        ProgrammeDTO programmeDTO=null;
        for (ProgrammeDTO programme:list
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
        return programmeBO.update(new ProgrammeDTO(
                programmeDTO.getProgrammeID(),
                programmeDTO.getProgrammeName(),
                programmeDTO.getDuration(),
                programmeDTO.getFee()
        ));
    }

    @Override
    public boolean delete(String id) {
        return programmeBO.delete(id);
    }
}
