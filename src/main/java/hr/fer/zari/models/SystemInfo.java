package hr.fer.zari.models;

/**
 * Created by eugen on 18/12/2016.
 */
public class SystemInfo {

    private String DatabaseBackendPlugin;
    private int DatabaseVersion;
    private String DicomAet;
    private int DicomPort;
    private int HttpPort;
    private String Name;
    private boolean PluginsEnabled;
    private String StorageAreaPlugin;
    private String Version;

    public String getDatabaseBackendPlugin() {
        return DatabaseBackendPlugin;
    }

    public int getDatabaseVersion() {
        return DatabaseVersion;
    }

    public String getDicomAet() {
        return DicomAet;
    }

    public int getDicomPort() {
        return DicomPort;
    }

    public int getHttpPort() {
        return HttpPort;
    }

    public String getName() {
        return Name;
    }

    public boolean isPluginsEnabled() {
        return PluginsEnabled;
    }

    public String getStorageAreaPlugin() {
        return StorageAreaPlugin;
    }

    public String getVersion() {
        return Version;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "DatabaseBackendPlugin='" + DatabaseBackendPlugin + '\'' +
                ", DatabaseVersion=" + DatabaseVersion +
                ", DicomAet='" + DicomAet + '\'' +
                ", DicomPort=" + DicomPort +
                ", HttpPort=" + HttpPort +
                ", Name='" + Name + '\'' +
                ", PluginsEnabled=" + PluginsEnabled +
                ", StorageAreaPlugin='" + StorageAreaPlugin + '\'' +
                ", Version='" + Version + '\'' +
                '}';
    }
}
