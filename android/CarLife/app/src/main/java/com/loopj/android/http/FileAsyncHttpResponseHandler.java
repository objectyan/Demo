package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.C3008n;
import cz.msebera.android.httpclient.C6327f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "FileAsyncHttpRH";
    protected final boolean append;
    protected final File file;
    protected File frontendFile;
    protected final boolean renameIfExists;

    public abstract void onFailure(int i, C6327f[] c6327fArr, Throwable th, File file);

    public abstract void onSuccess(int i, C6327f[] c6327fArr, File file);

    public FileAsyncHttpResponseHandler(File file) {
        this(file, false);
    }

    public FileAsyncHttpResponseHandler(File file, boolean append) {
        this(file, append, false);
    }

    public FileAsyncHttpResponseHandler(File file, boolean append, boolean renameTargetFileIfExists) {
        this(file, append, renameTargetFileIfExists, false);
    }

    public FileAsyncHttpResponseHandler(File file, boolean append, boolean renameTargetFileIfExists, boolean usePoolThread) {
        super(usePoolThread);
        Utils.asserts(file != null, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!(file.isDirectory() || file.getParentFile().isDirectory())) {
            Utils.asserts(file.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file.isDirectory() && !file.mkdirs()) {
            AsyncHttpClient.log.mo4878d(LOG_TAG, "Cannot create directories for requested Directory location, might not be a problem");
        }
        this.file = file;
        this.append = append;
        this.renameIfExists = renameTargetFileIfExists;
    }

    public FileAsyncHttpResponseHandler(Context context) {
        this.file = getTemporaryFile(context);
        this.append = false;
        this.renameIfExists = false;
    }

    public boolean deleteTargetFile() {
        return getTargetFile() != null && getTargetFile().delete();
    }

    protected File getTemporaryFile(Context context) {
        Utils.asserts(context != null, "Tried creating temporary file without having Context");
        try {
            return File.createTempFile("temp_", "_handled", context.getCacheDir());
        } catch (IOException e) {
            AsyncHttpClient.log.mo4881e(LOG_TAG, "Cannot create temporary file", e);
            return null;
        }
    }

    protected File getOriginalFile() {
        Utils.asserts(this.file != null, "Target file is null, fatal!");
        return this.file;
    }

    public File getTargetFile() {
        if (this.frontendFile == null) {
            this.frontendFile = getOriginalFile().isDirectory() ? getTargetFileByParsingURL() : getOriginalFile();
        }
        return this.frontendFile;
    }

    protected File getTargetFileByParsingURL() {
        boolean z;
        Utils.asserts(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
        if (getRequestURI() != null) {
            z = true;
        } else {
            z = false;
        }
        Utils.asserts(z, "RequestURI is null, cannot proceed");
        String requestURL = getRequestURI().toString();
        String filename = requestURL.substring(requestURL.lastIndexOf(47) + 1, requestURL.length());
        File targetFileRtn = new File(getOriginalFile(), filename);
        if (!targetFileRtn.exists() || !this.renameIfExists) {
            return targetFileRtn;
        }
        String format;
        if (filename.contains(".")) {
            format = filename.substring(0, filename.lastIndexOf(46)) + " (%d)" + filename.substring(filename.lastIndexOf(46), filename.length());
        } else {
            format = filename + " (%d)";
        }
        int index = 0;
        while (true) {
            targetFileRtn = new File(getOriginalFile(), String.format(format, new Object[]{Integer.valueOf(index)}));
            if (!targetFileRtn.exists()) {
                return targetFileRtn;
            }
            index++;
        }
    }

    public final void onFailure(int statusCode, C6327f[] headers, byte[] responseBytes, Throwable throwable) {
        onFailure(statusCode, headers, throwable, getTargetFile());
    }

    public final void onSuccess(int statusCode, C6327f[] headers, byte[] responseBytes) {
        onSuccess(statusCode, headers, getTargetFile());
    }

    protected byte[] getResponseData(C3008n entity) throws IOException {
        if (entity != null) {
            InputStream instream = entity.getContent();
            long contentLength = entity.getContentLength();
            FileOutputStream buffer = new FileOutputStream(getTargetFile(), this.append);
            if (instream != null) {
                try {
                    byte[] tmp = new byte[4096];
                    int count = 0;
                    while (true) {
                        int l = instream.read(tmp);
                        if (l == -1 || Thread.currentThread().isInterrupted()) {
                            AsyncHttpClient.silentCloseInputStream(instream);
                            buffer.flush();
                            AsyncHttpClient.silentCloseOutputStream(buffer);
                        } else {
                            count += l;
                            buffer.write(tmp, 0, l);
                            sendProgressMessage((long) count, contentLength);
                        }
                    }
                    AsyncHttpClient.silentCloseInputStream(instream);
                    buffer.flush();
                    AsyncHttpClient.silentCloseOutputStream(buffer);
                } catch (Throwable th) {
                    AsyncHttpClient.silentCloseInputStream(instream);
                    buffer.flush();
                    AsyncHttpClient.silentCloseOutputStream(buffer);
                }
            }
        }
        return null;
    }
}
