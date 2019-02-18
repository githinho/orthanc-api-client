package com.githinho.services;

import com.githinho.OrthancException;
import com.githinho.OrthancService;
import com.githinho.models.Header;
import com.githinho.models.Series;
import com.githinho.models.Patient;
import com.githinho.models.Statistics.SeriesStatistics;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SeriesService extends BaseService {

    public SeriesService(OrthancService service) {
        super(service);
    }

    public Call<List<Series>> getSeriesForStudyAsync(String studyId) {
        return service.getSeriesForStudy(studyId);
    }

    public List<Series> getSeriesForStudy(String studyId) throws IOException, OrthancException {
        return checkResponse(getSeriesForStudyAsync(studyId));
    }

    public Call<List<String>> getSeriesAsync() {
        return service.getSeries();
    }

    public List<String> getSeries() throws IOException, OrthancException {
        return checkResponse(getSeriesAsync());
    }

    public Call<Series> getSeriesAsync(String seriesId) {
        return service.getSeries(seriesId);
    }

    public Series getSeries(String seriesId) throws IOException, OrthancException {
        return checkResponse(getSeriesAsync(seriesId));
    }

    public Call<List<Series>> getSeriesForPatientAsync(String patientId) {
        return service.getPatientSeries(patientId);
    }

    public List<Series> getSeriesForPatient(String patientId) throws IOException, OrthancException {
        return checkResponse(getSeriesForPatientAsync(patientId));
    }

    public Call<Map<String, Header>> getSeriesModuleAsync(String seriesId) {
        return service.getSeriesModule(seriesId);
    }

    public Map<String, Header> getSeriesModule(String seriesId) throws IOException, OrthancException {
        return checkResponse(getSeriesModuleAsync(seriesId));
    }

    public Call<Patient> getSeriesPatientAsync(String seriesId) {
        return service.getSeriesPatient(seriesId);
    }

    public Patient getSeriesPatient(String seriesId) throws IOException, OrthancException {
        return checkResponse(getSeriesPatientAsync(seriesId));
    }

    public Call<Map<String, Header>> getSeriesSharedTagsAsync(String seriesId) {
        return service.getSeriesSharedTags(seriesId);
    }

    public Map<String, Header> getSeriesSharedTags(String seriesId) throws IOException, OrthancException {
        return checkResponse(getSeriesSharedTagsAsync(seriesId));
    }

    public Call<SeriesStatistics> getSeriesStatisticsAsync(String seriesId) {
        return service.getSeriesStatistics(seriesId);
    }

    public SeriesStatistics getSeriesStatistics(String seriesId) throws IOException, OrthancException {
        return checkResponse(getSeriesStatisticsAsync(seriesId));
    }

    public void downloadSeriesArchive(String seriesId, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getSeriesZipData(seriesId);
        ResponseBody response = checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
    }
}
