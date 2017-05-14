package services;

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
    private static final String SERIES_FOR_PATIENT = "series_for_patient.json";
    private static final String PATIENT_SHARED_TAGS = "patient_shared_tags.json";
    private static final String PATIENT_STATISTICS = "patient_statistics.json";
    private static final String PLUGINS = "plugins.json";
    private static final String SERIES_MODULE = "series_module.json";
    private static final String SERIES_SHARED_TAGS = "series_shared_tags.json";
    private static final String SERIES_STATISTICS = "series_statistics.json";
    private static final String MODALITIES = "modalities.json";
    private static final String INSTACE_CONTENT = "instance_content.json";

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

    static RestClient getSeriesForPatient() throws IOException {
        return getMockClient(SERIES_FOR_PATIENT);
    }

    static RestClient getPatientSharedTags() throws IOException {
        return getMockClient(PATIENT_SHARED_TAGS);
    }

    static RestClient getPatientStatistics() throws IOException {
        return getMockClient(PATIENT_STATISTICS);
    }

    static RestClient getPlugins() throws IOException {
        return getMockClient(PLUGINS);
    }

    static RestClient getSeriesModule() throws IOException {
        return getMockClient(SERIES_MODULE);
    }

    static RestClient getSeriesSharedTags() throws IOException {
        return getMockClient(SERIES_SHARED_TAGS);
    }

    static RestClient getSeriesStatistics() throws IOException {
        return getMockClient(SERIES_STATISTICS);
    }

    static RestClient getModalities() throws IOException {
        return getMockClient(MODALITIES);
    }

    static RestClient getInstanceContent() throws IOException {
        return getMockClient(INSTACE_CONTENT);
    }

    private static RestClient getMockClient(String file) throws IOException {
        return new MockClient(file).getClient();
    }
}
