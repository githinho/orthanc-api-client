package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Header;
import hr.fer.zari.models.Patient;
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

    public List<String> getPatientsIds() throws IOException, OrthancException {
        Call<List<String>> getPatientsIds = service.getPatients();
        return checkResponse(getPatientsIds);
    }

    public Patient getPatient(String patientId) throws IOException, OrthancException {
        Call<Patient> patientCall = service.getPatient(patientId);
        return checkResponse(patientCall);
    }

    public List<Patient> getPatients() throws IOException, OrthancException {
        List<String> patientsIds = getPatientsIds();
        List<Patient> patients = new ArrayList<Patient>();
        for (String id : patientsIds) {
            patients.add(getPatient(id));
        }
        return patients;
    }

    public void downloadPatientArchive(String patientId, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getPatientZipData(patientId);
        ResponseBody response = checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
    }

    public Map<String, Header> getPatientModule(String patientId) throws IOException, OrthancException {
        Call<Map<String, Header>> call = service.getPatientModule(patientId);
        return checkResponse(call);
    }
}
