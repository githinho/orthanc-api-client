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
    private static final String STUDY = "study.json";
    private static final String SERIES_SINGLE = "series_single.json";
    private static final String INSTANCE = "instance.json";
    private static final String INSTANCES_FOR_PATIENT = "instances_for_patient.json";
    private static final String PATIENT_MODULE = "patient_module.json";

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

    static RestClient getStudy() throws IOException {
        return getMockClient(STUDY);
    }

    static RestClient getSeriesSingle() throws IOException {
        return getMockClient(SERIES_SINGLE);
    }

    static RestClient getInstance() throws IOException {
        return getMockClient(INSTANCE);
    }

    static RestClient getInstancesForPatient() throws IOException {
        return getMockClient(INSTANCES_FOR_PATIENT);
    }

    static RestClient getPatientModule() throws IOException {
        return getMockClient(PATIENT_MODULE);
    }

    private static RestClient getMockClient(String file) throws IOException {
        return new MockClient(file).getClient();
    }
}
