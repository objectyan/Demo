package com.baidu.tts.loopj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams implements Serializable {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    protected boolean autoCloseInputStreams;
    protected String contentEncoding;
    protected String elapsedFieldInJsonStreamer;
    protected final ConcurrentHashMap<String, List<FileWrapper>> fileArrayParams;
    protected final ConcurrentHashMap<String, FileWrapper> fileParams;
    protected boolean forceMultipartEntity;
    protected boolean isRepeatable;
    protected final ConcurrentHashMap<String, StreamWrapper> streamParams;
    protected final ConcurrentHashMap<String, String> urlParams;
    protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;
    protected boolean useJsonStreamer;

    /* renamed from: com.baidu.tts.loopj.RequestParams$1 */
    class C51391 extends HashMap<String, String> {
        final /* synthetic */ String val$key;
        final /* synthetic */ String val$value;

        C51391(String str, String str2) {
            this.val$key = str;
            this.val$value = str2;
            put(this.val$key, this.val$value);
        }
    }

    public static class FileWrapper implements Serializable {
        public final String contentType;
        public final String customFileName;
        public final File file;

        public FileWrapper(File file, String contentType, String customFileName) {
            this.file = file;
            this.contentType = contentType;
            this.customFileName = customFileName;
        }
    }

    public static class StreamWrapper {
        public final boolean autoClose;
        public final String contentType;
        public final InputStream inputStream;
        public final String name;

        public StreamWrapper(InputStream inputStream, String name, String contentType, boolean autoClose) {
            this.inputStream = inputStream;
            this.name = name;
            this.contentType = contentType;
            this.autoClose = autoClose;
        }

        static StreamWrapper newInstance(InputStream inputStream, String name, String contentType, boolean autoClose) {
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return new StreamWrapper(inputStream, name, contentType, autoClose);
        }
    }

    public void setContentEncoding(String encoding) {
        if (encoding != null) {
            this.contentEncoding = encoding;
        } else {
            AsyncHttpClient.log.mo3894d(LOG_TAG, "setContentEncoding called with null attribute");
        }
    }

    public void setForceMultipartEntityContentType(boolean force) {
        this.forceMultipartEntity = force;
    }

    public RequestParams() {
        this((Map) null);
    }

    public RequestParams(Map<String, String> source) {
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.urlParams = new ConcurrentHashMap();
        this.streamParams = new ConcurrentHashMap();
        this.fileParams = new ConcurrentHashMap();
        this.fileArrayParams = new ConcurrentHashMap();
        this.urlParamsWithObjects = new ConcurrentHashMap();
        this.contentEncoding = "UTF-8";
        if (source != null) {
            for (Entry entry : source.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public RequestParams(String key, String value) {
        this(new C51391(key, value));
    }

    public RequestParams(Object... keysAndValues) {
        int i = 0;
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.urlParams = new ConcurrentHashMap();
        this.streamParams = new ConcurrentHashMap();
        this.fileParams = new ConcurrentHashMap();
        this.fileArrayParams = new ConcurrentHashMap();
        this.urlParamsWithObjects = new ConcurrentHashMap();
        this.contentEncoding = "UTF-8";
        int length = keysAndValues.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        while (i < length) {
            put(String.valueOf(keysAndValues[i]), String.valueOf(keysAndValues[i + 1]));
            i += 2;
        }
    }

    public void put(String key, String value) {
        if (key != null && value != null) {
            this.urlParams.put(key, value);
        }
    }

    public void put(String key, File[] files) throws FileNotFoundException {
        put(key, files, null, null);
    }

    public void put(String key, File[] files, String contentType, String customFileName) throws FileNotFoundException {
        if (key != null) {
            List arrayList = new ArrayList();
            for (File file : files) {
                if (file == null || !file.exists()) {
                    throw new FileNotFoundException();
                }
                arrayList.add(new FileWrapper(file, contentType, customFileName));
            }
            this.fileArrayParams.put(key, arrayList);
        }
    }

    public void put(String key, File file) throws FileNotFoundException {
        put(key, file, null, null);
    }

    public void put(String key, String customFileName, File file) throws FileNotFoundException {
        put(key, file, null, customFileName);
    }

    public void put(String key, File file, String contentType) throws FileNotFoundException {
        put(key, file, contentType, null);
    }

    public void put(String key, File file, String contentType, String customFileName) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (key != null) {
            this.fileParams.put(key, new FileWrapper(file, contentType, customFileName));
        }
    }

    public void put(String key, InputStream stream) {
        put(key, stream, null);
    }

    public void put(String key, InputStream stream, String name) {
        put(key, stream, name, null);
    }

    public void put(String key, InputStream stream, String name, String contentType) {
        put(key, stream, name, contentType, this.autoCloseInputStreams);
    }

    public void put(String key, InputStream stream, String name, String contentType, boolean autoClose) {
        if (key != null && stream != null) {
            this.streamParams.put(key, StreamWrapper.newInstance(stream, name, contentType, autoClose));
        }
    }

    public void put(String key, Object value) {
        if (key != null && value != null) {
            this.urlParamsWithObjects.put(key, value);
        }
    }

    public void put(String key, int value) {
        if (key != null) {
            this.urlParams.put(key, String.valueOf(value));
        }
    }

    public void put(String key, long value) {
        if (key != null) {
            this.urlParams.put(key, String.valueOf(value));
        }
    }

    public void add(String key, String value) {
        if (key != null && value != null) {
            Object obj = this.urlParamsWithObjects.get(key);
            if (obj == null) {
                obj = new HashSet();
                put(key, obj);
            }
            if (obj instanceof List) {
                ((List) obj).add(value);
            } else if (obj instanceof Set) {
                ((Set) obj).add(value);
            }
        }
    }

    public void remove(String key) {
        this.urlParams.remove(key);
        this.streamParams.remove(key);
        this.fileParams.remove(key);
        this.urlParamsWithObjects.remove(key);
        this.fileArrayParams.remove(key);
    }

    public boolean has(String key) {
        return (this.urlParams.get(key) == null && this.streamParams.get(key) == null && this.fileParams.get(key) == null && this.urlParamsWithObjects.get(key) == null && this.fileArrayParams.get(key) == null) ? false : true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.urlParams.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        for (Entry entry2 : this.streamParams.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry2.getKey());
            stringBuilder.append("=");
            stringBuilder.append("STREAM");
        }
        for (Entry entry22 : this.fileParams.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry22.getKey());
            stringBuilder.append("=");
            stringBuilder.append("FILE");
        }
        for (Entry entry222 : this.fileArrayParams.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry222.getKey());
            stringBuilder.append("=");
            stringBuilder.append("FILES(SIZE=").append(((List) entry222.getValue()).size()).append(")");
        }
        for (BasicNameValuePair basicNameValuePair : getParamsList(null, this.urlParamsWithObjects)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(basicNameValuePair.getName());
            stringBuilder.append("=");
            stringBuilder.append(basicNameValuePair.getValue());
        }
        return stringBuilder.toString();
    }

    public void setHttpEntityIsRepeatable(boolean flag) {
        this.isRepeatable = flag;
    }

    public void setUseJsonStreamer(boolean flag) {
        this.useJsonStreamer = flag;
    }

    public void setElapsedFieldInJsonStreamer(String value) {
        this.elapsedFieldInJsonStreamer = value;
    }

    public void setAutoCloseInputStreams(boolean flag) {
        this.autoCloseInputStreams = flag;
    }

    public HttpEntity getEntity(ResponseHandlerInterface progressHandler) throws IOException {
        if (this.useJsonStreamer) {
            return createJsonStreamerEntity(progressHandler);
        }
        if (!this.forceMultipartEntity && this.streamParams.isEmpty() && this.fileParams.isEmpty() && this.fileArrayParams.isEmpty()) {
            return createFormEntity();
        }
        return createMultipartEntity(progressHandler);
    }

    private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface progressHandler) throws IOException {
        boolean z = (this.fileParams.isEmpty() && this.streamParams.isEmpty()) ? false : true;
        HttpEntity jsonStreamerEntity = new JsonStreamerEntity(progressHandler, z, this.elapsedFieldInJsonStreamer);
        for (Entry entry : this.urlParams.entrySet()) {
            jsonStreamerEntity.addPart((String) entry.getKey(), entry.getValue());
        }
        for (Entry entry2 : this.urlParamsWithObjects.entrySet()) {
            jsonStreamerEntity.addPart((String) entry2.getKey(), entry2.getValue());
        }
        for (Entry entry22 : this.fileParams.entrySet()) {
            jsonStreamerEntity.addPart((String) entry22.getKey(), entry22.getValue());
        }
        for (Entry entry222 : this.streamParams.entrySet()) {
            StreamWrapper streamWrapper = (StreamWrapper) entry222.getValue();
            if (streamWrapper.inputStream != null) {
                jsonStreamerEntity.addPart((String) entry222.getKey(), StreamWrapper.newInstance(streamWrapper.inputStream, streamWrapper.name, streamWrapper.contentType, streamWrapper.autoClose));
            }
        }
        return jsonStreamerEntity;
    }

    private HttpEntity createFormEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
        } catch (Throwable e) {
            AsyncHttpClient.log.mo3897e(LOG_TAG, "createFormEntity failed", e);
            return null;
        }
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface progressHandler) throws IOException {
        HttpEntity simpleMultipartEntity = new SimpleMultipartEntity(progressHandler);
        simpleMultipartEntity.setIsRepeatable(this.isRepeatable);
        for (Entry entry : this.urlParams.entrySet()) {
            simpleMultipartEntity.addPartWithCharset((String) entry.getKey(), (String) entry.getValue(), this.contentEncoding);
        }
        for (BasicNameValuePair basicNameValuePair : getParamsList(null, this.urlParamsWithObjects)) {
            simpleMultipartEntity.addPartWithCharset(basicNameValuePair.getName(), basicNameValuePair.getValue(), this.contentEncoding);
        }
        for (Entry entry2 : this.streamParams.entrySet()) {
            StreamWrapper streamWrapper = (StreamWrapper) entry2.getValue();
            if (streamWrapper.inputStream != null) {
                simpleMultipartEntity.addPart((String) entry2.getKey(), streamWrapper.name, streamWrapper.inputStream, streamWrapper.contentType);
            }
        }
        for (Entry entry22 : this.fileParams.entrySet()) {
            FileWrapper fileWrapper = (FileWrapper) entry22.getValue();
            simpleMultipartEntity.addPart((String) entry22.getKey(), fileWrapper.file, fileWrapper.contentType, fileWrapper.customFileName);
        }
        for (Entry entry222 : this.fileArrayParams.entrySet()) {
            for (FileWrapper fileWrapper2 : (List) entry222.getValue()) {
                simpleMultipartEntity.addPart((String) entry222.getKey(), fileWrapper2.file, fileWrapper2.contentType, fileWrapper2.customFileName);
            }
        }
        return simpleMultipartEntity;
    }

    protected List<BasicNameValuePair> getParamsList() {
        List<BasicNameValuePair> linkedList = new LinkedList();
        for (Entry entry : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        linkedList.addAll(getParamsList(null, this.urlParamsWithObjects));
        return linkedList;
    }

    private List<BasicNameValuePair> getParamsList(String key, Object value) {
        List<BasicNameValuePair> linkedList = new LinkedList();
        if (value instanceof Map) {
            Map map = (Map) value;
            List arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object next : arrayList) {
                if (next instanceof String) {
                    Object obj = map.get(next);
                    if (obj != null) {
                        String str;
                        if (key == null) {
                            str = (String) next;
                        } else {
                            str = String.format(Locale.US, "%s[%s]", new Object[]{key, next});
                        }
                        linkedList.addAll(getParamsList(str, obj));
                    }
                }
            }
        } else if (value instanceof List) {
            List list = (List) value;
            r3 = list.size();
            for (r0 = 0; r0 < r3; r0++) {
                linkedList.addAll(getParamsList(String.format(Locale.US, "%s[%d]", new Object[]{key, Integer.valueOf(r0)}), list.get(r0)));
            }
        } else if (value instanceof Object[]) {
            for (Object paramsList : (Object[]) value) {
                linkedList.addAll(getParamsList(String.format(Locale.US, "%s[%d]", new Object[]{key, Integer.valueOf(r0)}), paramsList));
            }
        } else if (value instanceof Set) {
            for (Object paramsList2 : (Set) value) {
                linkedList.addAll(getParamsList(key, paramsList2));
            }
        } else {
            linkedList.add(new BasicNameValuePair(key, value.toString()));
        }
        return linkedList;
    }

    protected String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }
}
