package hr.fer.zari.models;

/**
 * Created by eugen on 01/12/2016.
 */
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
