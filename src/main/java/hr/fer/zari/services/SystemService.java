package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Statistics.SystemStatistics;
import hr.fer.zari.models.SystemInfo;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

/**
 * Created by eugen on 13/05/2017.
 */
public class SystemService extends BaseService {

    public SystemService(OrthancService service) {
        super(service);
    }

    public SystemInfo getSystemInfo() throws IOException, OrthancException {
        Call<SystemInfo> call = service.getSystemInfo();
        return checkResponse(call);
    }

    public List<String> getPlugins() throws IOException, OrthancException {
        Call<List<String>> call = service.getPlugins();
        return checkResponse(call);
    }

    public List<String> getModalities() throws IOException, OrthancException {
        Call<List<String>> call = service.getModalities();
        return checkResponse(call);
    }

    public SystemStatistics getStatistics() throws IOException, OrthancException {
        Call<SystemStatistics> call = service.getStatistics();
        return checkResponse(call);
    }
}
