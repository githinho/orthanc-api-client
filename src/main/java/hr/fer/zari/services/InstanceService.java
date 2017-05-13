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

    public List<Instance> getInstacesForSeries(String seriesId) throws IOException, OrthancException {
        Call<List<Instance>> call = service.getInstancesForSeries(seriesId);
        return (List<Instance>) checkResponse(call);
    }

    public List<String> getInstances() throws IOException, OrthancException {
        Call<List<String>> call = service.getInstances();
        return (List<String>) checkResponse(call);
    }

    public Instance getInstance(String instanceId) throws IOException, OrthancException {
        Call<Instance> call = service.getInstance(instanceId);
        return (Instance) checkResponse(call);
    }

    public void downloadInstanceDicom(String id, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getInstanceDicomData(id);
        ResponseBody body = (ResponseBody) checkResponse(call);
        writeResponseBodyToDisk(body, filePath);
    }
}
