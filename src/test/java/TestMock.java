import hr.fer.zari.OrthancException;
import hr.fer.zari.RestClient;
import hr.fer.zari.models.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by eugen on 12/05/2017.
 */
public class TestMock {

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
    public void testListOfStudies() throws IOException {
        RestClient client = MockClientConstructor.getStudiesIds();
        try {
            List<String> studiesIds = client.getStudyService().getStudiesIds();
            assertEquals(studiesIds.size(), 7);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testListOfSeries() throws IOException {
        RestClient client = MockClientConstructor.getSeriesIds();
        try {
            List<String> studiesIds = client.getSeriesService().getSeries();
            assertEquals(studiesIds.size(), 23);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

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
    public void testPatient() throws IOException {
        RestClient client = MockClientConstructor.getPatient();
        try {
            Patient patient = client.getPatientService().getPatient("1");
            assertEquals(patient.getID(), "da39a3ee-5e6b4b0d-3255bfef-95601890-afd80709");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testStudy() throws IOException {
        RestClient client = MockClientConstructor.getStudy();
        try {
            Study study = client.getStudyService().getStudy("1");
            assertEquals(study.getType(), "Study");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testSeries() throws IOException {
        RestClient client = MockClientConstructor.getSeriesSingle();
        try {
            Series series = client.getSeriesService().getSeries("1");
            assertEquals(series.getInstances().get(0), "38b2a146-1a11768b-4b140230-21f7de01-19873143");
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
    public void testSeriesForPatient() throws IOException {
        RestClient client = MockClientConstructor.getSeriesForPatient();
        try {
            List<Series> series = client.getSeriesService().getSeriesForPatient("1");
            assertEquals(series.get(0).getStatus(), "Unknown");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    private void handleOrthancException(OrthancException e) {
        e.printStackTrace();
        fail(e.getMessage());
    }
}
