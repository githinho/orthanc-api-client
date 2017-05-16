package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Header;
import hr.fer.zari.models.Patient;
import hr.fer.zari.models.Statistics.PatientStatistics;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by eugen on 13/05/2017.
 */
public class PatientService extends BaseService{

    public PatientService(OrthancService service) {
        super(service);
    }

    public Call<List<String>> getPatientsIdsAsync() {
        return service.getPatients();
    }

    public List<String> getPatientsIds() throws IOException, OrthancException {
        return checkResponse(getPatientsIdsAsync());
    }

    public Call<Patient> getPatientAsync(String patientId) {
        return service.getPatient(patientId);
    }

    public Patient getPatient(String patientId) throws IOException, OrthancException {
        return checkResponse(getPatientAsync(patientId));
    }

    public List<Patient> getPatients() throws IOException, OrthancException {
        List<String> patientsIds = getPatientsIds();
        List<Patient> patients = new ArrayList<Patient>();
        for (String id : patientsIds) {
            patients.add(getPatient(id));
        }
        return patients;
    }

    public Call<Map<String, Header>> getPatientModuleAsync(String patientId) {
        return service.getPatientModule(patientId);
    }

    public Map<String, Header> getPatientModule(String patientId) throws IOException, OrthancException {
        return checkResponse(getPatientModuleAsync(patientId));
    }

    public Call<Map<String, Header>> getPatientSharedTagsAsync(String patientId) {
        return service.getPatientSharedTags(patientId);
    }

    public Map<String, Header> getPatientSharedTags(String patientId) throws IOException, OrthancException {
        return checkResponse(getPatientSharedTagsAsync(patientId));
    }

    public Call<PatientStatistics> getPatientStatisticsAsync(String patientId) {
        return service.getPatientStatistics(patientId);
    }

    public PatientStatistics getPatientStatistics(String patientId) throws IOException, OrthancException {
        return checkResponse(getPatientStatisticsAsync(patientId));
    }

    public void downloadPatientArchive(String patientId, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getPatientZipData(patientId);
        ResponseBody response = checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
    }
}
