import hr.fer.zari.RestClient;

import java.io.IOException;

/**
 * Created by eugen on 13/05/2017.
 */
class MockClientConstructor {

    private static final String PATIENTS = "patients.json";
    private static final String STUDIES = "studies.json";
    private static final String SERIES = "series.json";

    static RestClient getPatientsIds() throws IOException {
        return new MockClient(PATIENTS).getClient();
    }

    static RestClient getStudiesIds() throws IOException {
        return new MockClient(STUDIES).getClient();
    }

    static RestClient getSeriesIds() throws IOException {
        return new MockClient(SERIES).getClient();
    }
}
