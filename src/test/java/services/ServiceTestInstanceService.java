package services;

import com.githinho.OrthancException;
import com.githinho.RestClient;
import com.githinho.models.Instance;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceTestInstanceService extends BaseServiceTest {

    @org.junit.Test
    public void testListOfInstances() throws IOException {
        RestClient client = MockClientConstructor.getInstancesIds();
        try {
            List<String> studiesIds = client.getInstanceService().getInstances();
            assertEquals(studiesIds.size(), 2352);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testInstance() throws IOException {
        RestClient client = MockClientConstructor.getInstance();
        try {
            Instance instance = client.getInstanceService().getInstance("1");
            assertEquals(instance.getMainDicomTags().get("ImageIndex"), "39");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testInstanceForPatient() throws IOException {
        RestClient client = MockClientConstructor.getInstancesForPatient();
        try {
            List<Instance> instances = client.getInstanceService().getInstancesForPatient("1");
            assertEquals(instances.get(0).getFileSize(), 526864);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testInstanceContent() throws IOException {
        RestClient client = MockClientConstructor.getInstanceContent();
        try {
            List<String> content = client.getInstanceService().getInstanceContent("0");
            assertEquals(content.size(), 82);
            assertEquals(content.get(1), "0008-0008");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }
}
