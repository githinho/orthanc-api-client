package hr.fer.zari.services;

import hr.fer.zari.OrthancException;
import hr.fer.zari.OrthancService;
import hr.fer.zari.models.Study;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugen on 13/05/2017.
 */
public class StudyService extends BaseService {

    public StudyService(OrthancService service) {
        super(service);
    }

    public List<Study> getStudiesForPatient(String patientId) throws IOException, OrthancException {
        Call<List<Study>> call = service.getStudiesForPatient(patientId);
        return (List<Study>) checkResponse(call);
    }

    public List<String> getStudiesIds() throws IOException, OrthancException {
        Call<List<String>> call = service.getStudies();
        return (List<String>) checkResponse(call);
    }

    public Study getStudy(String studyId) throws IOException, OrthancException {
        Call<Study> call = service.getStudy(studyId);
        return (Study) checkResponse(call);
    }

    public List<Study> getStudies() throws IOException, OrthancException {
        List<String> studiesIds = getStudiesIds();
        List<Study> studies = new ArrayList<Study>();
        for (String id : studiesIds) {
            studies.add(getStudy(id));
        }
        return studies;
    }

    public void downloadStudyArchive(String studyId, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getStudyZipData(studyId);
        ResponseBody response = (ResponseBody) checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
    }
}
