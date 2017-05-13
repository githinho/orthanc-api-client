import hr.fer.zari.RestClient;

import java.io.IOException;

/**
 * Created by eugen on 13/05/2017.
 */
class MockClientConstructor {

    private static final String PATIENTS = "patients.json";
    private static final String STUDIES = "studies.json";
    private static final String SERIES = "series.json";
    private static final String INSTANCES = "instances.json";
    private static final String SYSTEM = "system.json";
    private static final String PATIENT = "patient.json";

    static RestClient getPatientsIds() throws IOException {
        return getMockClient(PATIENTS);
    }

    static RestClient getStudiesIds() throws IOException {
        return getMockClient(STUDIES);
    }

    static RestClient getSeriesIds() throws IOException {
        return getMockClient(SERIES);
    }

    static RestClient getInstancesIds() throws IOException {
        return getMockClient(INSTANCES);
    }

    static RestClient getSystemInfo() throws IOException {
        return getMockClient(SYSTEM);
    }

    static RestClient getPatient() throws IOException {
        return getMockClient(PATIENT);
    }

    private static RestClient getMockClient(String file) throws IOException {
        return new MockClient(file).getClient();
    }
}
