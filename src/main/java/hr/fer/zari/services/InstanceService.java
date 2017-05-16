package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Instance;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

/**
 * Created by eugen on 13/05/2017.
 */
public class InstanceService extends BaseService {

    public InstanceService(OrthancService service) {
        super(service);
    }

    public Call<List<Instance>> getInstancesForSeriesAsync(String seriesId) {
        return service.getInstancesForSeries(seriesId);
    }

    public List<Instance> getInstancesForSeries(String seriesId) throws IOException, OrthancException {
        return checkResponse(getInstancesForSeriesAsync(seriesId));
    }

    public Call<List<String>> getInstancesAsync() {
        return service.getInstances();
    }

    public List<String> getInstances() throws IOException, OrthancException {
        return checkResponse(getInstancesAsync());
    }

    public Call<Instance> getInstanceAsync(String instanceId) {
        return service.getInstance(instanceId);
    }

    public Instance getInstance(String instanceId) throws IOException, OrthancException {
        return checkResponse(getInstanceAsync(instanceId));
    }

    public Call<List<Instance>> getInstancesForPatientAsync(String patientId) {
        return service.getPatientInstances(patientId);
    }

    public List<Instance> getInstancesForPatient(String patientId) throws IOException, OrthancException {
        return checkResponse(getInstancesForPatientAsync(patientId));
    }

    public Call<List<String>> getInstanceContentAsync(String instanceId) {
        return service.getInstanceContent(instanceId);
    }

    public List<String> getInstanceContent(String instanceId) throws IOException, OrthancException {
        return checkResponse(getInstanceContentAsync(instanceId));
    }
    public void downloadInstanceDicom(String id, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getInstanceDicomData(id);
        ResponseBody body = checkResponse(call);
        writeResponseBodyToDisk(body, filePath);
    }
}
