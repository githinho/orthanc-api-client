package com.githinho.models;

import java.util.HashMap;
import java.util.List;

public class Study extends AbstractModel {

    private boolean IsStable;
    private String LastUpdate;
    private String ParentPatient;
    private HashMap<String, String> PatientMainDicomTags;
    private List<String> Series;

    public boolean isStable() {
        return IsStable;
    }

    public String getLastUpdate() {
        return LastUpdate;
    }

    public String getParentPatient() {
        return ParentPatient;
    }

    public HashMap<String, String> getPatientMainDicomTags() {
        return PatientMainDicomTags;
    }

    public List<String> getSeries() {
        return Series;
    }

    @Override
    public String toString() {
        return "Study{" +
                "IsStable=" + IsStable +
                ", LastUpdate='" + LastUpdate + '\'' +
                ", ParentPatient='" + ParentPatient + '\'' +
                ", PatientMainDicomTags=" + PatientMainDicomTags +
                ", Series=" + Series +
                '}';
    }
}
