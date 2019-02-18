package com.githinho.models;

import java.util.List;

public class Patient extends AbstractModel {

    private boolean IsStable;
    private String LastUpdate;
    private List<String> Studies;

    public boolean isStable() {
        return IsStable;
    }

    public String getLastUpdate() {
        return LastUpdate;
    }

    public List<String> getStudies() {
        return Studies;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + super.getID() +
                ", IsStable=" + IsStable +
                ", MainDicomTas={" + super.getMainDicomTags() + "}" +
                ", LastUpdate='" + LastUpdate + '\'' +
                ", Studies=" + Studies +
                ", Type=" + super.getType() +
                '}';
    }
}
