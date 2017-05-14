package services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.RestClient;
import hr.fer.zari.models.Header;
import hr.fer.zari.models.Series;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 14/05/2017.
 */
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
}
