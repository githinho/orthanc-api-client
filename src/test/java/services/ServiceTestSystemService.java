package services;

import com.githinho.OrthancException;
import com.githinho.RestClient;
import com.githinho.models.Statistics.SystemStatistics;
import com.githinho.models.SystemInfo;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceTestSystemService extends BaseServiceTest {

    @org.junit.Test
    public void testSystemInfo() throws IOException {
        RestClient client = MockClientConstructor.getSystemInfo();
        try {
            SystemInfo systemInfo = client.getSystemService().getSystemInfo();
            assertEquals(systemInfo.getName(), "Orthanc Demo");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testPlugins() throws IOException {
        RestClient client = MockClientConstructor.getPlugins();
        try {
            List<String> plugins = client.getSystemService().getPlugins();
            assertEquals(plugins.size(), 8);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testModalities() throws IOException {
        RestClient client = MockClientConstructor.getModalities();
        try {
            List<String> plugins = client.getSystemService().getModalities();
            assertEquals(plugins.size(), 1);
            assertEquals(plugins.get(0), "modality");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }


    @org.junit.Test
    public void testSystemStatistics() throws IOException {
        RestClient client = MockClientConstructor.getSystemStatistics();
        try {
            SystemStatistics statistics = client.getSystemService().getStatistics();
            assertEquals(statistics.getCountPatients(), 7);
            assertEquals(statistics.getCountStudies(), 7);
            assertEquals(statistics.getCountInstances(), 2352);
            assertEquals(statistics.getCountSeries(), 23);
            assertEquals(statistics.getTotalDiskSize(), "913213057");
            assertEquals(statistics.getTotalDiskSizeMB(), 870);
            assertEquals(statistics.getTotalUncompressedSize(), "913213057");
            assertEquals(statistics.getTotalUncompressedSizeMB(), 870);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }
}
