package services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.RestClient;
import hr.fer.zari.models.Study;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 14/05/2017.
 */
public class ServiceTestStudyService extends BaseServiceTest {

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
    public void testStudy() throws IOException {
        RestClient client = MockClientConstructor.getStudy();
        try {
            Study study = client.getStudyService().getStudy("1");
            assertEquals(study.getType(), "Study");
        } catch (OrthancException e) {
            handleOrthancException(e);
        }
    }

}
