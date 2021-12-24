package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class programme implements SuperEntity {
    @Id
    private String programmeID;
    private String programmeName;
    private String duration;
    private double fee;


    public programme() {
    }

    public programme(String programmeID, String programmeName, String duration, double fee) {
        this.programmeID = programmeID;
        this.programmeName = programmeName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(String programmeID) {
        this.programmeID = programmeID;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "programme{" +
                "programmeID='" + programmeID + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
