package services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.RestClient;
import hr.fer.zari.models.SystemInfo;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 12/05/2017.
 */
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
        RestClient client = MockClientConstructor.getModalties();
        try {
            List<String> plugins = client.getSystemService().getModalities();
            assertEquals(plugins.size(), 1);
            assertEquals(plugins.get(0), "modality");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }
}
