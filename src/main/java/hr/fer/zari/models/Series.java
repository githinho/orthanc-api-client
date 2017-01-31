package hr.fer.zari.models;

import java.util.HashMap;
import java.util.List;

/**
 * Created by eugen on 01/12/2016.
 */
public class Series extends AbstractModel{

    private List<String> Instances;
    private boolean IsStable;
    private String LastUpdate;
    private String ParentStudy;
    private HashMap<String, String> PatientMainDicomTags;
    private String Status;

    public List<String> getInstances() {
        return Instances;
    }

    public String getParentStudy() {
        return ParentStudy;
    }

    public HashMap<String, String> getPatientMainDicomTags() {
        return PatientMainDicomTags;
    }

    public String getStatus() {
        return Status;
    }

    public boolean isStable() {
        return IsStable;
    }

    public String getLastUpdate() {
        return LastUpdate;
    }

    @Override
    public String toString() {
        return "Series{" +
                "ID=" + super.getID() +
                ", Instances=" + Instances +
                ", IsStable=" + IsStable +
                ", MainDicomTags={" + super.getMainDicomTags() + "}" +
                ", LastUpdate='" + LastUpdate + '\'' +
                ", ParentStudy='" + ParentStudy + '\'' +
                ", PatientMainDicomTags=" + PatientMainDicomTags +
                ", Status='" + Status + '\'' +
                ", Type=" + super.getType() +
                '}';
    }
}
