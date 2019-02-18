package com.githinho.services;

import com.githinho.OrthancException;
import com.githinho.OrthancService;
import com.githinho.models.Study;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudyService extends BaseService {

    public StudyService(OrthancService service) {
        super(service);
    }

    public Call<List<Study>> getStudiesForPatientAsync(String patientId) {
        return service.getStudiesForPatient(patientId);
    }

    public List<Study> getStudiesForPatient(String patientId) throws IOException, OrthancException {
        return checkResponse(getStudiesForPatientAsync(patientId));
    }

    public Call<List<String>>  getStudiesIdsAsync() throws IOException, OrthancException {
        return service.getStudies();
    }

    public List<String> getStudiesIds() throws IOException, OrthancException {
        return checkResponse(getStudiesIdsAsync());
    }

    public Call<Study> getStudyAsync(String studyId) {
        return service.getStudy(studyId);
    }

    public Study getStudy(String studyId) throws IOException, OrthancException {
        return checkResponse(getStudyAsync(studyId));
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
        ResponseBody response = checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
    }
}
