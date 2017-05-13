package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Series;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

/**
 * Created by eugen on 13/05/2017.
 */
public class SeriesService extends BaseService {

    public SeriesService(OrthancService service) {
        super(service);
    }

    public List<Series> getSeriesForStudy(String studyId) throws IOException, OrthancException {
        Call<List<Series>> call = service.getSeriesForStudy(studyId);
        return (List<Series>) checkResponse(call);
    }

    public List<String> getSeries() throws IOException, OrthancException {
        Call<List<String>> call = service.getSeries();
        return (List<String>) checkResponse(call);
    }

    public Series getSeries(String seriesId) throws IOException, OrthancException {
        Call<Series> call = service.getSeries(seriesId);
        return (Series) checkResponse(call);
    }

    public void downloadSeriesArchive(String seriesId, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getSeriesZipData(seriesId);
        ResponseBody response = (ResponseBody) checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
    }
}
