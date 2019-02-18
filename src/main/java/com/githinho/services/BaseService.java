package com.githinho.services;

import com.githinho.OrthancException;
import com.githinho.OrthancService;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public abstract class BaseService {

    protected OrthancService service;

    public BaseService(OrthancService service) {
        this.service = service;
    }

    protected <T> T checkResponse(Call<T> call) throws IOException, OrthancException {
        retrofit2.Response response = call.execute();
        if (response.isSuccessful()) {
            return (T) response.body();
        } else {
            throw new OrthancException("code = " + response.code());
        }
    }

    protected boolean writeResponseBodyToDisk(ResponseBody body, String file) {
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
