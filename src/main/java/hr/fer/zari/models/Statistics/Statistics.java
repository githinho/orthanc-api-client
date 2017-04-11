package hr.fer.zari.models.Statistics;

/**
 * Created by eugen on 09/03/2017.
 */
public class Statistics {

    private String DiskSize;
    private int DiskSizeMB;
    private String UncompressedSize;
    private int UncompressedSizeMB;

    public String getDiskSize() {
        return DiskSize;
    }

    public int getDiskSizeMB() {
        return DiskSizeMB;
    }

    public String getUncompressedSize() {
        return UncompressedSize;
    }

    public int getUncompressedSizeMB() {
        return UncompressedSizeMB;
    }
}
