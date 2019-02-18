package services;

import com.githinho.OrthancException;
import com.githinho.RestClient;
import com.githinho.models.Header;
import com.githinho.models.Patient;
import com.githinho.models.Statistics.PatientStatistics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ServiceTestPatientService extends BaseServiceTest {

    @org.junit.Test
    public void testListOfPatients() throws IOException {
        RestClient client = MockClientConstructor.getPatientsIds();
        try {
            List<String> patientsIds = client.getPatientService().getPatientsIds();
            assertEquals(patientsIds.size(), 7);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testPatient() throws IOException {
        RestClient client = MockClientConstructor.getPatient();
        try {
            Patient patient = client.getPatientService().getPatient("1");
            checkPatient(patient);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testPatientModule() throws IOException {
        RestClient client = MockClientConstructor.getPatientModule();
        try {
            Map<String, Header> module = client.getPatientService().getPatientModule("1");
            Header header = module.get("0010,0010");
            assertEquals(header.getType(), "String");
            assertEquals(header.getName(), "PatientName");
//            assertEquals(header.getValue(), "ASSURANCETOURIX");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testPatientSharedTags() throws IOException {
        RestClient client = MockClientConstructor.getPatientSharedTags();
        try {
            Map<String, Header> module = client.getPatientService().getPatientSharedTags("1");
            Header header = module.get("0008,0005");
            assertEquals(header.getType(), "String");
            assertEquals(header.getName(), "SpecificCharacterSet");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testPatientStatistics() throws IOException {
        RestClient client = MockClientConstructor.getPatientStatistics();
        try {
            PatientStatistics statistics = client.getPatientService().getPatientStatistics("0");
            assertEquals(statistics.getDiskSize(), "144270403");
            assertEquals(statistics.getCountStudies(), 1);
            assertEquals(statistics.getDiskSizeMB(), 137);
            assertEquals(statistics.getCountInstances(), 680);
            assertEquals(statistics.getCountSeries(), 3);
            assertEquals(statistics.getUncompressedSize(), "144270403");
            assertEquals(statistics.getUncompressedSizeMB(), 137);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }
}
