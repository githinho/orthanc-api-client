package com.githinho.models.Statistics;

public class SystemStatistics {

    private int CountPatients;
    private int CountStudies;
    private int CountSeries;
    private int CountInstances;
    private String TotalDiskSize;
    private int TotalDiskSizeMB;
    private String TotalUncompressedSize;
    private int TotalUncompressedSizeMB;

    public int getCountPatients() {
        return CountPatients;
    }

    public int getCountStudies() {
        return CountStudies;
    }

    public int getCountSeries() {
        return CountSeries;
    }

    public int getCountInstances() {
        return CountInstances;
    }

    public String getTotalDiskSize() {
        return TotalDiskSize;
    }

    public int getTotalDiskSizeMB() {
        return TotalDiskSizeMB;
    }

    public String getTotalUncompressedSize() {
        return TotalUncompressedSize;
    }

    public int getTotalUncompressedSizeMB() {
        return TotalUncompressedSizeMB;
    }
}
