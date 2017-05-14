package hr.fer.zari;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import hr.fer.zari.services.*;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by eugen on 01/12/2016.
 */
public class RestClient {

    private SystemService systemService;
    private PatientService patientService;
    private StudyService studyService;
    private SeriesService seriesService;
    private InstanceService instanceService;

    public RestClient(String apiUrl, String username, String password, boolean enableLogging) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (enableLogging) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(loggingInterceptor);
        }

        if (username != null && password != null) {
            httpClient.addInterceptor(createInterceptor(username, password));
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(apiUrl)
                .client(client)
                .build();
        OrthancService service = retrofit.create(OrthancService.class);
        createServices(service);
    }

    private Interceptor createInterceptor(String username, String password) {
        final String credentials = username + ":" + password;
        final String basic = "Basic " + Base64.encode(credentials.getBytes());

        return new Interceptor() {
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
        };
    }

    private void createServices(OrthancService service) {
        systemService = new SystemService(service);
        patientService = new PatientService(service);
        studyService = new StudyService(service);
        seriesService = new SeriesService(service);
        instanceService = new InstanceService(service);
    }

    public SystemService getSystemService() {
        return systemService;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public StudyService getStudyService() {
        return studyService;
    }

    public SeriesService getSeriesService() {
        return seriesService;
    }

    public InstanceService getInstanceService() {
        return instanceService;
    }
}
