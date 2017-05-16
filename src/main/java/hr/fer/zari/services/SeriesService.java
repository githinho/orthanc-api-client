package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Header;
import hr.fer.zari.models.Patient;
import hr.fer.zari.models.Series;
import hr.fer.zari.models.Statistics.PatientStatistics;
import hr.fer.zari.models.Statistics.SeriesStatistics;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by eugen on 13/05/2017.
 */
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
