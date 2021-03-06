package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Programme implements SuperEntity {
    @Id
    private String programmeID;
    private String programmeName;
    private String duration;
    private double fee;

    @ManyToMany(mappedBy = "programmeList")
    private List<Student>studentList = new ArrayList<>();

    public Programme(String programmeID, String programmeName, String duration, double fee, List<Student> studentList) {
        this.programmeID = programmeID;
        this.programmeName = programmeName;
        this.duration = duration;
        this.fee = fee;
        this.studentList = studentList;
    }

    public Programme() {
    }

    public Programme(String programmeID, String programmeName, String duration, double fee) {
        this.programmeID = programmeID;
        this.programmeName = programmeName;
        this.duration = duration;
        this.fee = fee;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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
        return "Programme{" +
                "programmeID='" + programmeID + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", studentList=" + studentList +
                '}';
    }
}
