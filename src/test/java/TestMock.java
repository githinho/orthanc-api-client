import hr.fer.zari.OrthancException;
import hr.fer.zari.RestClient;

import java.io.IOException;
import java.util.List;

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
            List<String> patientsIds = client.getPatientsIds();
            assertEquals(patientsIds.size(), 7);
        } catch (OrthancException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
