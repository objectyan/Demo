package com.baidu.mapframework.commonlib.asynchttp;

import android.text.TextUtils;
import com.baidu.mapframework.commonlib.asynchttp.RequestParams.FileWrapper;
import com.baidu.mapframework.commonlib.asynchttp.RequestParams.StreamWrapper;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
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
    /* renamed from: a */
    private static final String f18869a = "JsonStreamerEntity";
    /* renamed from: b */
    private static final UnsupportedOperationException f18870b = new UnsupportedOperationException("Unsupported operation in this implementation.");
    /* renamed from: c */
    private static final int f18871c = 4096;
    /* renamed from: d */
    private static final byte[] f18872d = "true".getBytes();
    /* renamed from: e */
    private static final byte[] f18873e = "false".getBytes();
    /* renamed from: f */
    private static final byte[] f18874f = "null".getBytes();
    /* renamed from: g */
    private static final byte[] f18875g = m14941a("name");
    /* renamed from: h */
    private static final byte[] f18876h = m14941a("type");
    /* renamed from: i */
    private static final byte[] f18877i = m14941a("contents");
    /* renamed from: j */
    private static final Header f18878j = new BasicHeader("Content-Type", "application/json");
    /* renamed from: k */
    private static final Header f18879k = new BasicHeader("Content-Encoding", "gzip");
    /* renamed from: l */
    private final byte[] f18880l = new byte[4096];
    /* renamed from: m */
    private final Map<String, Object> f18881m = new HashMap();
    /* renamed from: n */
    private final Header f18882n;
    /* renamed from: o */
    private final byte[] f18883o;
    /* renamed from: p */
    private final ResponseHandlerInterface f18884p;

    public JsonStreamerEntity(ResponseHandlerInterface progressHandler, boolean useGZipCompression, String elapsedField) {
        Header header;
        byte[] bArr = null;
        this.f18884p = progressHandler;
        if (useGZipCompression) {
            header = f18879k;
        } else {
            header = null;
        }
        this.f18882n = header;
        if (!TextUtils.isEmpty(elapsedField)) {
            bArr = m14941a(elapsedField);
        }
        this.f18883o = bArr;
    }

    /* renamed from: a */
    static byte[] m14941a(String string) {
        if (string == null) {
            return f18874f;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append('\"');
        int length = string.length();
        int pos = -1;
        while (true) {
            pos++;
            if (pos < length) {
                char ch = string.charAt(pos);
                switch (ch) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    case '\f':
                        sb.append("\\f");
                        break;
                    case '\r':
                        sb.append("\\r");
                        break;
                    case '\"':
                        sb.append("\\\"");
                        break;
                    case '\\':
                        sb.append("\\\\");
                        break;
                    default:
                        if (ch > '\u001f' && ((ch < '' || ch > '') && (ch < ' ' || ch > '⃿'))) {
                            sb.append(ch);
                            break;
                        }
                        String intString = Integer.toHexString(ch);
                        sb.append("\\u");
                        int intLength = 4 - intString.length();
                        for (int zero = 0; zero < intLength; zero++) {
                            sb.append('0');
                        }
                        sb.append(intString.toUpperCase(Locale.US));
                        break;
                        break;
                }
            }
            sb.append('\"');
            return sb.toString().getBytes();
        }
    }

    public void addPart(String key, Object value) {
        this.f18881m.put(key, value);
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
        return this.f18882n;
    }

    public Header getContentType() {
        return f18878j;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw f18870b;
    }

    public void writeTo(OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        OutputStream os;
        long now = System.currentTimeMillis();
        if (this.f18882n != null) {
            os = new GZIPOutputStream(out, 4096);
        } else {
            os = out;
        }
        os.write(123);
        Set<String> keys = this.f18881m.keySet();
        int keysCount = keys.size();
        if (keysCount > 0) {
            int keysProcessed = 0;
            for (String key : keys) {
                keysProcessed++;
                Object value = this.f18881m.get(key);
                os.write(m14941a(key));
                os.write(58);
                if (value == null) {
                    os.write(f18874f);
                } else {
                    try {
                        boolean isFileWrapper = value instanceof FileWrapper;
                        if (isFileWrapper || (value instanceof StreamWrapper)) {
                            os.write(123);
                            if (isFileWrapper) {
                                m14938a(os, (FileWrapper) value);
                            } else {
                                m14939a(os, (StreamWrapper) value);
                            }
                            os.write(RouteLineResConst.LINE_FOOT_GREEN_NORMAL);
                        } else if (value instanceof JsonValueInterface) {
                            os.write(((JsonValueInterface) value).getEscapedJsonValue());
                        } else if (value instanceof JSONObject) {
                            os.write(value.toString().getBytes());
                        } else if (value instanceof JSONArray) {
                            os.write(value.toString().getBytes());
                        } else if (value instanceof Boolean) {
                            os.write(((Boolean) value).booleanValue() ? f18872d : f18873e);
                        } else if (value instanceof Long) {
                            os.write((((Number) value).longValue() + "").getBytes());
                        } else if (value instanceof Double) {
                            os.write((((Number) value).doubleValue() + "").getBytes());
                        } else if (value instanceof Float) {
                            os.write((((Number) value).floatValue() + "").getBytes());
                        } else if (value instanceof Integer) {
                            os.write((((Number) value).intValue() + "").getBytes());
                        } else {
                            os.write(m14941a(value.toString()));
                        }
                    } catch (Throwable th) {
                        if (this.f18883o != null || keysProcessed < keysCount) {
                            os.write(44);
                        }
                    }
                }
                if (this.f18883o != null || keysProcessed < keysCount) {
                    os.write(44);
                }
            }
            long elapsedTime = System.currentTimeMillis() - now;
            if (this.f18883o != null) {
                os.write(this.f18883o);
                os.write(58);
                os.write((elapsedTime + "").getBytes());
            }
            AsyncHttpClient.log.mo2628i(f18869a, "Uploaded JSON in " + Math.floor((double) (elapsedTime / 1000)) + " seconds");
        }
        os.write(RouteLineResConst.LINE_FOOT_GREEN_NORMAL);
        os.flush();
        AsyncHttpClient.silentCloseOutputStream(os);
    }

    /* renamed from: a */
    private void m14939a(OutputStream os, StreamWrapper entry) throws IOException {
        m14940a(os, entry.name, entry.contentType);
        Base64OutputStream bos = new Base64OutputStream(os, 18);
        while (true) {
            int bytesRead = entry.inputStream.read(this.f18880l);
            if (bytesRead == -1) {
                break;
            }
            bos.write(this.f18880l, 0, bytesRead);
        }
        AsyncHttpClient.silentCloseOutputStream(bos);
        m14937a(os);
        if (entry.autoClose) {
            AsyncHttpClient.silentCloseInputStream(entry.inputStream);
        }
    }

    /* renamed from: a */
    private void m14938a(OutputStream os, FileWrapper wrapper) throws IOException {
        m14940a(os, wrapper.file.getName(), wrapper.contentType);
        long bytesWritten = 0;
        long totalSize = wrapper.file.length();
        FileInputStream in = new FileInputStream(wrapper.file);
        Base64OutputStream bos = new Base64OutputStream(os, 18);
        while (true) {
            int bytesRead = in.read(this.f18880l);
            if (bytesRead != -1) {
                bos.write(this.f18880l, 0, bytesRead);
                bytesWritten += (long) bytesRead;
                this.f18884p.sendProgressMessage(bytesWritten, totalSize);
            } else {
                AsyncHttpClient.silentCloseOutputStream(bos);
                m14937a(os);
                AsyncHttpClient.silentCloseInputStream(in);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m14940a(OutputStream os, String name, String contentType) throws IOException {
        os.write(f18875g);
        os.write(58);
        os.write(m14941a(name));
        os.write(44);
        os.write(f18876h);
        os.write(58);
        os.write(m14941a(contentType));
        os.write(44);
        os.write(f18877i);
        os.write(58);
        os.write(34);
    }

    /* renamed from: a */
    private void m14937a(OutputStream os) throws IOException {
        os.write(34);
    }
}
