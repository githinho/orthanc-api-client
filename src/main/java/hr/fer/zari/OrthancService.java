package hr.fer.zari;

import hr.fer.zari.models.*;
import hr.fer.zari.models.Header;
import hr.fer.zari.models.Statistics.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by eugen on 01/12/2016.
 */
public interface OrthancService {

    /* SYSTEM */
    @GET("system")
    Call<SystemInfo> getSystemInfo();
    @GET("statistics")
    Call<OverallStatistics> getStatistics();

    /* PATIENTS */
    @GET("patients")
    Call<List<String>> getPatients();
    @GET("patients/{id}")
    Call<Patient> getPatient(@Path("id") String patientId);
    /* Create ZIP */
    @Streaming
    @GET("patients/{id}/archive")
    Call<ResponseBody> getPatientZipData(@Path("id") String patientId);
    /* Retrieve all the instances of this patient in a single REST call */
    @GET("patients/{id}/instances")
    Call<List<Instance>> getPatientInstances(@Path("id") String patientId);
    /* Create a ZIP archive for media storage with DICOMDIR */
    @Streaming
    @GET("patients/{id}/media")
    Call<ResponseBody> getPatientMedia(@Path("id") String patientId);
    /* */
    @GET("patients/{id}/module")
    Call<Map<String, Header>> getPatientModule(@Path("id") String patientId);
    /* Retrieve all the series of this patient in a single REST call */
    @GET("patients/{id}/series")
    Call<List<Series>> getPatientSeries(@Path("id") String patientId);
    /* "?simplify" argument to simplify output */
    @GET("patients/{id}/shared-tags")
    Call<Map<String, Header>> getPatientSharedTags(@Path("id") String patientId);
    /* */
    @GET("patients/{id}/statistics")
    Call<PatientStatistics> getPatientStatistics(@Path("id") String patientId);
    /* Retrieve all the studies of this patient in a single REST call */
    @GET("patients/{id}/studies")
    Call<List<Study>> getStudiesForPatient(@Path("id") String patientId);

    /* PLUGINS */
    /* Get the list of all the registered plugins */
    @GET("plugins")
    Call<List<String>> getPlugins();

    /* SERIES */
    @GET("series")
    Call<List<String>> getSeries();
    @GET("series/{id}")
    Call<Series> getSeries(@Path("id") String seriesId);
    /* Create a ZIP archive for media storage with DICOMDIR */
    @Streaming
    @GET("series/{id}/archive")
    Call<ResponseBody> getSeriesZipData(@Path("id") String seriesId);
    /* Retrieve all the instances of this series in a single REST call */
    @GET("series/{id}/instances")
    Call<List<Instance>> getInstancesForSeries(@Path("id") String seriesId);
    /* Create archives for media storage with DICOMDIR */
    @GET("series/{id}/media")
    Call<List<Instance>> getSeriesMedia(@Path("id") String seriesId);
    /* "?simplify" argument to simplify output */
    @GET("series/{id}/module")
    Call<Map<String, Header>> getSeriesModule(@Path("id") String seriesId);
    /* Retrieve the parent study of this series */
    @GET("series/{id}/patient")
    Call<Patient> getSeriesPatient(@Path("id") String seriesId);
    /* "?simplify" argument to simplify output */
    @GET("series/{id}/shared-tags")
    Call<Map<String, Header>> getSeriesSharedTags(@Path("id") String seriesId);
    /* */
    @GET("series/{id}/statistics")
    Call<SeriesStatistics> getSeriesStatistics(@Path("id") String seriesId);

    /* STUDIES */
    @GET("studies")
    Call<List<String>> getStudies();
    @GET("studies/{id}")
    Call<Study> getStudy(@Path("id") String studyId);
    /* Create ZIP */
    @Streaming
    @GET("studies/{id}/archive")
    Call<ResponseBody> getStudyZipData(@Path("id") String studyId);
    /* Retrieve all the instances of this patient in a single REST call */
    @GET("studies/{id}/instances")
    Call<List<Instance>> getStudyInstances(@Path("id") String studyId);
    /* Create a ZIP archive for media storage with DICOMDIR */
    @GET("studies/{id}/media")
    Call<ResponseBody> getStudyMedia(@Path("id") String studyId);
    /* "?simplify" argument to simplify output */
    @GET("studies/{id}/module")
    Call<Map<String, Header>> getStudyModule(@Path("id") String studyId);
    /* "?simplify" argument to simplify output */
    @GET("studies/{id}/module-patient")
    Call<Map<String, Header>> getStudyModulePatient(@Path("id") String studyId);
    /* "Retrieve the parent patient of this study */
    @GET("studies/{id}/patient")
    Call<Patient> getStudyPatient(@Path("id") String studyId);
    /* Retrieve all the series of this study in a single REST call */
    @GET("studies/{id}/series")
    Call<List<Series>> getSeriesForStudy(@Path("id") String studyId);
    /* "?simplify" argument to simplify output */
    @GET("studies/{id}/shared-tags")
    Call<Map<String, Header>> getStudySharedTags(@Path("id") String studyId);
    /* */
    @GET("study/{id}/statistics")
    Call<StudyStatistics> getStudyStatistics(@Path("id") String studyId);

    /* INSTANCES */
    @GET("instances")
    Call<List<String>> getInstances();
    @GET("instances/{id}")
    Call<Instance> getInstance(@Path("id") String instanceId);
    @Streaming
    @GET("instances/{id}/file")
    Call<ResponseBody> getInstanceDicomData(@Path("id") String instanceId);
    /* List the first-level DICOM tags */
    @GET("instances/{id}/content")
    Call<List<String>> getInstanceContent(@Path("id") String instanceId);
    /* Raw access to the value of DICOM tags (comprising the padding character) */
    @GET("instances/{id}/content/{group}-{element}")
    Call<List<String>> getInstanceContent(@Path("id") String instanceId,
                                          @Path("group") String group,
                                          @Path("element") String element);
    /* List the frames */
    @GET("instances/{id}/frames")
    Call<List<Integer>> getInstanceFrames(@Path("id") String instanceId);
    /* Truncated image to the [-32768;32767] range */
    @GET("instances/{id}/frames/{frameNumber}/image-int16")
    Call<ResponseBody> getInstanceFrameImageInt16(@Path("id") String instanceId,
                                                  @Path("frameNumber") String frameNumber);
    /* Truncated image to the [0;65535] range */
    @GET("instances/{id}/frames/{frameNumber}/image-uint16")
    Call<ResponseBody> getInstanceFrameImageUInt16(@Path("id") String instanceId,
                                                   @Path("frameNumber") String frameNumber);
    /* Truncated image to the [0;255] range */
    @GET("instances/{id}/frames/{frameNumber}/image-uint8")
    Call<ResponseBody> getInstanceFrameImageUInt8(@Path("id") String instanceId,
                                                  @Path("frameNumber") String frameNumber);
    /* a = eval(urlread('http://localhost:8042/instances/.../frames/0/matlab')) */
    @GET("instances/{id}/frames/{frameNumber}/matlab")
    Call<ResponseBody> getInstanceFrameMatlab(@Path("id") String instanceId,
                                              @Path("frameNumber") String frameNumber);
    /* Rescaled image (so that all the range [0;255] is used) */
    @GET("instances/{id}/frames/{frameNumber}/preview")
    Call<ResponseBody> getInstanceFramePreview(@Path("id") String instanceId,
                                               @Path("frameNumber") String frameNumber);
    /* Access to the raw content of one frame (bypass image decoding) */
    @GET("instances/{id}/frames/{frameNumber}/raw")
    Call<ResponseBody> getInstanceFrameRaw(@Path("id") String instanceId,
                                           @Path("frameNumber") String frameNumber);

    /* Get the meta information (header) of the DICOM file, "?simplify" argument to simplify output */
    @GET("instances/{id}/header")
    Call<Map<String, Header>> getInstanceHeader(@Path("id") String instanceId);

    /* Truncated image to the [-32768;32767] range */
    @GET("instances/{id}/image-int16")
    Call<ResponseBody> getInstanceImageInt16(@Path("id") String instanceId);
    /* Truncated image to the [0;65535] range */
    @GET("instances/{id}/image-uint16")
    Call<ResponseBody> getInstanceImageUInt16(@Path("id") String instanceId);
    /* Truncated image to the [0;255] range */
    @GET("instances/{id}/image-uint8")
    Call<ResponseBody> getInstanceImageUInt8(@Path("id") String instanceId);
    /* a = eval(urlread('http://localhost:8042/instances/.../frames/0/matlab')) */
    @GET("instances/{id}/matlab")
    Call<ResponseBody> getInstanceMatlab(@Path("id") String instanceId);
    /* Rescaled image (so that all the range [0;255] is used) */
    @GET("instances/{id}/preview")
    Call<ResponseBody> getInstancePreview(@Path("id") String instanceId);
    /* Return the encapsulated PDF inside the DICOM file, if any */
    @GET("instances/{id}/pdf")
    Call<ResponseBody> getInstancePDF(@Path("id") String instanceId);
    /* */
    @GET("instances/{id}/module")
    Call<Map<String, Header>> getInstanceModule(@Path("id") String instanceId);
    /* Retrieve the parent patient of this instance */
    @GET("instances/{id}/patient")
    Call<Patient> getInstancePatient(@Path("id") String instanceId);
    /* Retrieve the parent series of this instance */
    @GET("instances/{id}/series")
    Call<Series> getInstanceSeries(@Path("id") String instanceId);
    /* */
    @GET("instances/{id}/simplified-tags")
    Call<Map<String, String>> getInstanceSimplifiedTags(@Path("id") String instanceId);
    /* */
    @GET("instances/{id}/statistics")
    Call<Statistics> getInstanceStatistics(@Path("id") String instanceId);
    /* Retrieve the parent study of this instance */
    @GET("instances/{id}/study")
    Call<Study> getInstanceStudy(@Path("id") String instanceId);
    /* "?simplify" argument to simplify output (same as "simplified-tags") */
    @GET("instances/{id}/tags")
    Call<Map<String, Header>> getInstanceTags(@Path("id") String instanceId);

    /* MODALITIES */
    @GET("modalities")
    Call<List<String>> getModalities();


    /* not implemented */
    /* Protection against recycling: "0" means unprotected, "1" protected */
//    @GET("patients/{id}/protected")
//    Call<Integer> getPatientProtected(@Path("id") String patientId);
}
