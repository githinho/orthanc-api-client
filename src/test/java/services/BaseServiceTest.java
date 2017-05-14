package services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.models.Patient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by eugen on 14/05/2017.
 */
abstract class BaseServiceTest {

    void checkPatient(Patient patient) {
        assertEquals(patient.getID(), "da39a3ee-5e6b4b0d-3255bfef-95601890-afd80709");
        assertEquals(patient.isStable(), true);
        assertEquals(patient.getLastUpdate(), "20161117T161444");
        assertEquals(patient.getMainDicomTags().get("PatientName"), "ASSURANCETOURIX");
        assertEquals(patient.getStudies().size(), 1);
        assertEquals(patient.getStudies().get(0), "6b9e19d9-62094390-5f9ddb01-4a191ae7-9766b715");
        assertEquals(patient.getType(), "Patient");
    }
    void handleOrthancException(OrthancException e) {
        e.printStackTrace();
        fail(e.getMessage());
    }
}
