import hr.fer.zari.OrthancException;
import hr.fer.zari.models.*;
import hr.fer.zari.OrthancService;
import hr.fer.zari.RestClient;

import java.io.*;
import java.util.List;

/**
 * Created by eugen on 02/12/2016.
 */
public class Test {

    private static final String API_BASE_URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private static RestClient client = new RestClient(API_BASE_URL, USERNAME, PASSWORD, true);

    public static void main(String[] args) {
        String patientId = "b6589fc6-ab0dc82c-f12099d1-c2d40ab9-94e8410c";
        String studyId = "fb39cc28-2cbd739c-6f554cdb-effc4460-519234c8";
        String seriesId = "2a0b635e-fd457973-66e8ac9b-7ec5c8ce-6f0ba05e";
        String instancesId = "a9097d88-fcedc876-308089dc-d2f101ca-d37e04d3";

        printSystemInfo();

        printListOfPatients();
        printListOfStudies();
        printListOfStudies(patientId);
        printListOfSeries(studyId);
        printListOfInstancesForSeries(seriesId);

//        downloadInstance(instancesId);
//        downloadPatientArchive(patientId);
    }

    private static void printSystemInfo() {
        try {
            SystemInfo info = client.getSystemInfo();
            System.out.println(info.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }

    private static void printListOfPatients() {
        try {
            List<Patient> patients = client.getPatients();
            System.out.println("NUMBER OF PATINETS: " + patients.size());
            for (Patient patient : patients) {
                System.out.println(patient.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }

    private static void printListOfStudies() {
        try {
            List<Study> studies = client.getStudies();
            System.out.println("NUMBER OF STUDIES: " + studies.size());
            for (Study study : studies) {
                System.out.println(study.toString());
            }
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }

    private static void downloadInstance(String instancesId) {
        try {
            client.downloadInstanceDicom(instancesId, "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }

    private static void downloadPatientArchive(String patientId) {
        try {
            client.downloadPatientArchive(patientId, "" + patientId + ".zip");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }

    private static void printListOfStudies(String patientId) {
        try {
            List<Study> studies = client.getStudiesForPatient(patientId);
            for (Study study : studies) {
                System.out.println(study.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }
    
    private static void printListOfSeries(String studyId) {
        try {
            List<Series> series = client.getSeriesForStudy(studyId);
            for (Series serie : series) {
                System.out.println(serie.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }

    private static void printListOfInstancesForSeries(String seriesId) {
        try {
            List<Instance> instances = client.getInstacesForSeries(seriesId);
            for (Instance instance : instances) {
                System.out.println(instance.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OrthancException e) {
            e.printStackTrace();
        }
    }
}
