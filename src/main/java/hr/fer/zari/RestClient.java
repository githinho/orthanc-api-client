package hr.fer.zari;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import hr.fer.zari.models.*;
import hr.fer.zari.models.SystemInfo;
import okhttp3.*;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.*;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugen on 01/12/2016.
 */
public class RestClient {

    private OrthancService service;

    public RestClient(String apiUrl, String username, String password, boolean enableLogging) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (enableLogging) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(loggingInterceptor);
        }

        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encode(credentials.getBytes());

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", basic)
                            .header("Accept", "application/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(apiUrl)
                .client(client)
                .build();
        service = retrofit.create(OrthancService.class);
    }

    public OrthancService getService() {
        return service;
    }

    public SystemInfo getSystemInfo() throws IOException, OrthancException {
        Call<SystemInfo> call = service.getSystemInfo();
        return (SystemInfo) checkResponse(call);
    }

    public List<String> getPatientsIds() throws IOException, OrthancException {
        Call<List<String>> getPatientsIds = service.getPatients();
        return (List<String>) checkResponse(getPatientsIds);
    }

    public Patient getPatient(String patientId) throws IOException, OrthancException {
        Call<Patient> patientCall = service.getPatient(patientId);
        return (Patient) checkResponse(patientCall);
    }

    public List<Patient> getPatients() throws IOException, OrthancException {
        List<String> patientsIds = getPatientsIds();
        List<Patient> patients = new ArrayList<Patient>();
        for (String id : patientsIds) {
            patients.add(getPatient(id));
        }
        return patients;
    }

    public void downloadPatientArchive(String patientId, String filePath) throws IOException, OrthancException {
        Call<ResponseBody> call = service.getPatientZipData(patientId);
        ResponseBody response = (ResponseBody) checkResponse(call);
        writeResponseBodyToDisk(response, filePath);
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

    public List<Series> getSeriesForStudy(String studyId) throws IOException, OrthancException {
        Call<List<Series>> call = service.getSeriesForStudy(studyId);
        return (List<Series>) checkResponse(call);
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

    public List<Instance> getInstacesForSeries(String seriesId) throws IOException, OrthancException {
        Call<List<Instance>> call = service.getInstancesForSeries(seriesId);
        return (List<Instance>) checkResponse(call);
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

    private <T> Object checkResponse(Call<T> call) throws IOException, OrthancException {
        retrofit2.Response response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new OrthancException("code = " + response.code());
        }
    }

    private static boolean writeResponseBodyToDisk(ResponseBody body, String file) {
        try {
            File downloadFile = new File(file);
            downloadFile.getParentFile().mkdirs();
//            FileWriter writer = new FileWriter(downloadFile);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

//                long fileSize = body.contentLength();
//                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(downloadFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

//                    fileSizeDownloaded += read;
//                    SystemInfo.out.println("file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}
