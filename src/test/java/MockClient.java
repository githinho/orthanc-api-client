import hr.fer.zari.RestClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * Created by eugen on 13/05/2017.
 */
class MockClient {

    private RestClient client;

    MockClient(String fileName) throws IOException {
        client = getRestClient(fileName);
    }

    RestClient getClient() {
        return client;
    }

    private RestClient getRestClient(String file) throws IOException {
        MockResponse response = getMockResponse(file);
        String  serverUrl = setupMockServer(response);

        return new RestClient(
                serverUrl,
                null,
                null,
                false);
    }

    private String setupMockServer(MockResponse response) throws IOException {
        MockWebServer server = new MockWebServer();
        server.enqueue(response);
        server.start();
        return server.url("/").toString();
    }

    private MockResponse getMockResponse(String file) {
        MockResponse response = new MockResponse();
        response.setResponseCode(HTTP_OK);
        try {
            String body = readFile(file);
            response.setBody(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String readFile(String file) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(file);
        return convertInputStreamToString(is);
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
}
