package com.baidu.cloudsdk.common.http;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;

public class MultipartRequestParams extends RequestParams {
    protected HashMap<String, FileWrapper> mFileParams = new HashMap();

    private static class FileWrapper {
        public String mContentType;
        public String mFileName;
        public InputStream mIn;

        public FileWrapper(InputStream in, String filename, String contentType) {
            this.mIn = in;
            this.mFileName = filename;
            this.mContentType = contentType;
        }

        public String getFileName() {
            if (this.mFileName != null) {
                return this.mFileName;
            }
            return "nofilename";
        }
    }

    public MultipartRequestParams(String key, String value) {
        super(key, value);
    }

    public MultipartRequestParams(Map<String, String> params) {
        super((Map) params);
    }

    public MultipartRequestParams(Object... keysAndValues) {
        super(keysAndValues);
    }

    public void put(String key, File file) throws FileNotFoundException {
        if (file != null) {
            put(key, new FileInputStream(file), file.getName());
        }
    }

    public void put(String key, InputStream in) {
        put(key, in, null);
    }

    public void put(String key, InputStream in, String filename) {
        if (TextUtils.isEmpty(filename)) {
            put(key, in, filename, "png");
        } else {
            put(key, in, filename, URLConnection.getFileNameMap().getContentTypeFor(filename));
        }
    }

    public void put(String key, InputStream in, String filename, String contentType) {
        if (!TextUtils.isEmpty(key) && in != null) {
            this.mFileParams.put(key, new FileWrapper(in, filename, contentType));
        }
    }

    public void remove(String key) {
        super.remove(key);
        if (key != null) {
            this.mFileParams.remove(key);
        }
    }

    public HttpEntity getHttpEntity() {
        if (this.mFileParams.isEmpty()) {
            return super.getHttpEntity();
        }
        HttpEntity entity = new MultipartEntity();
        for (Entry<String, String> entry : this.mParams.entrySet()) {
            entity.addPart((String) entry.getKey(), (String) entry.getValue());
        }
        for (Entry<String, ArrayList<String>> entry2 : this.mParamsWithArray.entrySet()) {
            String key = (String) entry2.getKey();
            Iterator i$ = ((ArrayList) entry2.getValue()).iterator();
            while (i$.hasNext()) {
                String value = (String) i$.next();
                if (!TextUtils.isEmpty(value)) {
                    entity.addPart(key, value);
                }
            }
        }
        int currentIndex = 0;
        int lastIndex = this.mFileParams.entrySet().size() - 1;
        for (Entry<String, FileWrapper> entry3 : this.mFileParams.entrySet()) {
            FileWrapper file = (FileWrapper) entry3.getValue();
            entity.addPart((String) entry3.getKey(), file.getFileName(), file.mIn, file.mContentType, currentIndex == lastIndex);
            currentIndex++;
        }
        return entity;
    }

    protected StringBuilder getStringBuilder() {
        StringBuilder builder = super.getStringBuilder();
        for (Entry<String, FileWrapper> entry : this.mFileParams.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append((String) entry.getKey()).append("=").append("FILE");
        }
        return builder;
    }
}
