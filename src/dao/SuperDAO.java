package dao;

import entity.SuperEntity;

import java.util.List;


public interface SuperDAO <Entity extends SuperEntity,ID> extends SuperDAOMain{
    Boolean add(Entity entity);
    Boolean update(Entity entity);
    Boolean delete(ID id);
    List <Entity> find();
}
