package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegistrationDetails implements SuperEntity{
    @Id
    String regNumber;
    @Id
    String programmeID;
    String joinDate;

}
