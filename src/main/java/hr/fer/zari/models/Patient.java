package hr.fer.zari.models;

import java.util.List;

/**
 * Created by eugen on 01/12/2016.
 */
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
