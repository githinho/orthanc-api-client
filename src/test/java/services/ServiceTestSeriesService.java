package services;

import com.githinho.OrthancException;
import com.githinho.RestClient;
import com.githinho.models.Header;
import com.githinho.models.Patient;
import com.githinho.models.Series;
import com.githinho.models.Statistics.SeriesStatistics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ServiceTestSeriesService extends BaseServiceTest {

    @org.junit.Test
    public void testSeriesModule() throws IOException {
        RestClient client = MockClientConstructor.getSeriesModule();
        try {
            Map<String, Header> module = client.getSeriesService().getSeriesModule("0");
            Header header = module.get("0008,0031");
            assertEquals(header.getType(), "String");
            assertEquals(header.getName(), "SeriesTime");
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
    public void testSeriesPatient() throws IOException {
        RestClient client = MockClientConstructor.getPatient();
        try {
            Patient patient = client.getSeriesService().getSeriesPatient("1");
            checkPatient(patient);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testSeriesSharedTags() throws IOException {
        RestClient client = MockClientConstructor.getSeriesSharedTags();
        try {
            Map<String, Header> module = client.getSeriesService().getSeriesSharedTags("5");
            Header header = module.get("0008,0005");
            assertEquals(header.getType(), "String");
            assertEquals(header.getName(), "SpecificCharacterSet");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

    @org.junit.Test
    public void testPatientStatistics() throws IOException {
        RestClient client = MockClientConstructor.getSeriesStatistics();
        try {
            SeriesStatistics statistics = client.getSeriesService().getSeriesStatistics("1");
            assertEquals(statistics.getDiskSize(), "11081078");
            assertEquals(statistics.getDiskSizeMB(), 10);
            assertEquals(statistics.getCountInstances(), 227);
            assertEquals(statistics.getUncompressedSize(), "11081078");
            assertEquals(statistics.getUncompressedSizeMB(), 10);
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }
}
