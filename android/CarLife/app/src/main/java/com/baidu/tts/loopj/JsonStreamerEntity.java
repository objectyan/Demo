package com.baidu.tts.loopj;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.baidu.tts.loopj.RequestParams.FileWrapper;
import com.baidu.tts.loopj.RequestParams.StreamWrapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = "null".getBytes();
    private static final byte[] JSON_TRUE = "true".getBytes();
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final byte[] STREAM_NAME = escape("name");
    private static final byte[] STREAM_TYPE = escape("type");
    private final byte[] buffer = new byte[4096];
    private final Header contentEncoding;
    private final byte[] elapsedField;
    private final Map<String, Object> jsonParams = new HashMap();
    private final ResponseHandlerInterface progressHandler;

    public JsonStreamerEntity(ResponseHandlerInterface progressHandler, boolean useGZipCompression, String elapsedField) {
        Header header;
        byte[] bArr = null;
        this.progressHandler = progressHandler;
        if (useGZipCompression) {
            header = HEADER_GZIP_ENCODING;
        } else {
            header = null;
        }
        this.contentEncoding = header;
        if (!TextUtils.isEmpty(elapsedField)) {
            bArr = escape(elapsedField);
        }
        this.elapsedField = bArr;
    }

    public void addPart(String key, Object value) {
        this.jsonParams.put(key, value);
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public long getContentLength() {
        return -1;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw ERR_UNSUPPORTED;
    }

    public void writeTo(OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.contentEncoding != null) {
            out = new GZIPOutputStream(out, 4096);
        }
        out.write(123);
        Set<String> keySet = this.jsonParams.keySet();
        int size = keySet.size();
        if (size > 0) {
            int i = 0;
            for (String str : keySet) {
                int i2 = i + 1;
                Object obj = this.jsonParams.get(str);
                out.write(escape(str));
                out.write(58);
                if (obj == null) {
                    out.write(JSON_NULL);
                } else {
                    boolean z = obj instanceof FileWrapper;
                    if (z || (obj instanceof StreamWrapper)) {
                        out.write(123);
                        if (z) {
                            writeToFromFile(out, (FileWrapper) obj);
                        } else {
                            try {
                                writeToFromStream(out, (StreamWrapper) obj);
                            } catch (Throwable th) {
                                if (this.elapsedField != null || i2 < size) {
                                    out.write(44);
                                }
                            }
                        }
                        out.write(RouteLineResConst.LINE_FOOT_GREEN_NORMAL);
                    } else if (obj instanceof JsonValueInterface) {
                        out.write(((JsonValueInterface) obj).getEscapedJsonValue());
                    } else if (obj instanceof JSONObject) {
                        out.write(obj.toString().getBytes());
                    } else if (obj instanceof JSONArray) {
                        out.write(obj.toString().getBytes());
                    } else if (obj instanceof Boolean) {
                        out.write(((Boolean) obj).booleanValue() ? JSON_TRUE : JSON_FALSE);
                    } else if (obj instanceof Long) {
                        out.write((((Number) obj).longValue() + "").getBytes());
                    } else if (obj instanceof Double) {
                        out.write((((Number) obj).doubleValue() + "").getBytes());
                    } else if (obj instanceof Float) {
                        out.write((((Number) obj).floatValue() + "").getBytes());
                    } else if (obj instanceof Integer) {
                        out.write((((Number) obj).intValue() + "").getBytes());
                    } else {
                        out.write(escape(obj.toString()));
                    }
                }
                if (this.elapsedField != null || i2 < size) {
                    out.write(44);
                }
                i = i2;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.elapsedField != null) {
                out.write(this.elapsedField);
                out.write(58);
                out.write((currentTimeMillis2 + "").getBytes());
            }
            AsyncHttpClient.log.mo3899i(LOG_TAG, "Uploaded JSON in " + Math.floor((double) (currentTimeMillis2 / 1000)) + " seconds");
        }
        out.write(RouteLineResConst.LINE_FOOT_GREEN_NORMAL);
        out.flush();
        AsyncHttpClient.silentCloseOutputStream(out);
    }

    private void writeToFromStream(OutputStream os, StreamWrapper entry) throws IOException {
        writeMetaData(os, entry.name, entry.contentType);
        OutputStream base64OutputStream = new Base64OutputStream(os, 18);
        while (true) {
            int read = entry.inputStream.read(this.buffer);
            if (read == -1) {
                break;
            }
            base64OutputStream.write(this.buffer, 0, read);
        }
        AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
        endMetaData(os);
        if (entry.autoClose) {
            AsyncHttpClient.silentCloseInputStream(entry.inputStream);
        }
    }

    private void writeToFromFile(OutputStream os, FileWrapper wrapper) throws IOException {
        writeMetaData(os, wrapper.file.getName(), wrapper.contentType);
        long j = 0;
        long length = wrapper.file.length();
        InputStream fileInputStream = new FileInputStream(wrapper.file);
        OutputStream base64OutputStream = new Base64OutputStream(os, 18);
        while (true) {
            int read = fileInputStream.read(this.buffer);
            if (read != -1) {
                base64OutputStream.write(this.buffer, 0, read);
                j += (long) read;
                this.progressHandler.sendProgressMessage(j, length);
            } else {
                AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
                endMetaData(os);
                AsyncHttpClient.silentCloseInputStream(fileInputStream);
                return;
            }
        }
    }

    private void writeMetaData(OutputStream os, String name, String contentType) throws IOException {
        os.write(STREAM_NAME);
        os.write(58);
        os.write(escape(name));
        os.write(44);
        os.write(STREAM_TYPE);
        os.write(58);
        os.write(escape(contentType));
        os.write(44);
        os.write(STREAM_CONTENTS);
        os.write(58);
        os.write(34);
    }

    private void endMetaData(OutputStream os) throws IOException {
        os.write(34);
    }

    static byte[] escape(String string) {
        if (string == null) {
            return JSON_NULL;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append('\"');
        int length = string.length();
        int i = -1;
        while (true) {
            int i2 = i + 1;
            if (i2 < length) {
                char charAt = string.charAt(i2);
                switch (charAt) {
                    case '\b':
                        stringBuilder.append("\\b");
                        break;
                    case '\t':
                        stringBuilder.append("\\t");
                        break;
                    case '\n':
                        stringBuilder.append("\\n");
                        break;
                    case '\f':
                        stringBuilder.append("\\f");
                        break;
                    case '\r':
                        stringBuilder.append("\\r");
                        break;
                    case '\"':
                        stringBuilder.append("\\\"");
                        break;
                    case '\\':
                        stringBuilder.append("\\\\");
                        break;
                    default:
                        if (charAt > '\u001f' && ((charAt < '' || charAt > '') && (charAt < ' ' || charAt > '⃿'))) {
                            stringBuilder.append(charAt);
                            break;
                        }
                        String toHexString = Integer.toHexString(charAt);
                        stringBuilder.append("\\u");
                        int length2 = 4 - toHexString.length();
                        for (i = 0; i < length2; i++) {
                            stringBuilder.append('0');
                        }
                        stringBuilder.append(toHexString.toUpperCase(Locale.US));
                        break;
                        break;
                }
                i = i2;
            } else {
                stringBuilder.append('\"');
                return stringBuilder.toString().getBytes();
            }
        }
    }
}
