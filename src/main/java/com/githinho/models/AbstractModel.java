package com.githinho.models;

import java.util.HashMap;

public abstract class AbstractModel {

    private String ID;
    private HashMap<String, String> MainDicomTags;
    private String Type;

    public String getID() {
        return ID;
    }

    public HashMap<String, String> getMainDicomTags() {
        return MainDicomTags;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "AbstractModel{" +
                "ID='" + ID + '\'' +
                ", MainDicomTags=" + MainDicomTags +
                ", Type='" + Type + '\'' +
                '}';
    }
}
