package services;

import hr.fer.zari.OrthancException;

import static org.junit.Assert.fail;

/**
 * Created by eugen on 14/05/2017.
 */
abstract class BaseServiceTest {

    void handleOrthancException(OrthancException e) {
        e.printStackTrace();
        fail(e.getMessage());
    }
}
