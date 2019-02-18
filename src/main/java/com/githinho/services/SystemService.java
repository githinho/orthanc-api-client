package com.githinho.services;

import com.githinho.OrthancException;
import com.githinho.OrthancService;
import com.githinho.models.SystemInfo;
import com.githinho.models.Statistics.SystemStatistics;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

public class SystemService extends BaseService {

    public SystemService(OrthancService service) {
        super(service);
    }

    public Call<SystemInfo> getSystemInfoAsync() {
        return service.getSystemInfo();
    }

    public SystemInfo getSystemInfo() throws IOException, OrthancException {
        return checkResponse(getSystemInfoAsync());
    }

    public Call<List<String>> getPluginsAsync() {
        return service.getPlugins();
    }

    public List<String> getPlugins() throws IOException, OrthancException {
        return checkResponse(getPluginsAsync());
    }

    public Call<List<String>> getModalitiesAsync() {
        return service.getModalities();
    }

    public List<String> getModalities() throws IOException, OrthancException {
        return checkResponse(getModalitiesAsync());
    }

    public Call<SystemStatistics> getStatisticsAsync() {
        return service.getStatistics();
    }

    public SystemStatistics getStatistics() throws IOException, OrthancException {
        return checkResponse(getStatisticsAsync());
    }
}
