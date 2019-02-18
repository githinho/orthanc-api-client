package com.githinho.models;

public class Instance extends AbstractModel {

    private int FileSize;
    private String FileUuid;
    private int IndexInSeries;
    private String ParentSeries;

    public int getFileSize() {
        return FileSize;
    }

    public String getFileUuid() {
        return FileUuid;
    }

    public int getIndexInSeries() {
        return IndexInSeries;
    }

    public String getParentSeries() {
        return ParentSeries;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "ID=" + super.getID() +
                ", FileSize=" + FileSize +
                ", FileUuid='" + FileUuid + '\'' +
                ", IndexInSeries=" + IndexInSeries +
                ", MainDicomTags={" + super.getMainDicomTags() + "}" +
                ", ParentSeries='" + ParentSeries + '\'' +
                ", Type=" + super.getType() +
                '}';
    }
}
