package hr.fer.zari;

import hr.fer.zari.models.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

import java.util.List;

/**
 * Created by eugen on 01/12/2016.
 */
public interface OrthancService {

    @GET("system")
    Call<SystemInfo> getSystemInfo();

    @GET("patients")
    Call<List<String>> getPatients();
    @GET("patients/{id}")
    Call<Patient> getPatient(@Path("id") String patientId);
    @Streaming
    @GET("patients/{id}/archive")
    Call<ResponseBody> getPatientZipData(@Path("id") String patientId);
    @GET("patients/{id}/studies")
    Call<List<Study>> getStudiesForPatient(@Path("id") String patientId);

    @GET("studies")
    Call<List<String>> getStudies();
    @GET("studies/{id}")
    Call<Study> getStudy(@Path("id") String studyId);
    @Streaming
    @GET("studies/{id}/archive")
    Call<ResponseBody> getStudyZipData(@Path("id") String studyId);
    @GET("studies/{id}/series")
    Call<List<Series>> getSeriesForStudy(@Path("id") String studyId);

    @GET("series")
    Call<List<String>> getSeries();
    @GET("series/{id}")
    Call<Series> getSeries(@Path("id") String seriesId);
    @Streaming
    @GET("series/{id}/archive")
    Call<ResponseBody> getSeriesZipData(@Path("id") String seriesId);
    @GET("series/{id}/instances")
    Call<List<Instance>> getInstancesForSeries(@Path("id") String seriesId);

    @GET("instances")
    Call<List<String>> getInstances();
    @GET("instances/{id}")
    Call<Instance> getInstance(@Path("id") String instanceId);
    @Streaming
    @GET("instances/{id}/file")
    Call<ResponseBody> getInstanceDicomData(@Path("id") String instanceId);

}
