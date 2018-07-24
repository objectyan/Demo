package com.baidu.carlife.logic;

import android.support.annotation.NonNull;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DownLoadThread */
/* renamed from: com.baidu.carlife.logic.e */
public class C1759e extends Thread implements C1758w {
    /* renamed from: a */
    public static final int f5320a = -1000;
    /* renamed from: b */
    private static final String f5321b = "DownLoadThread";
    /* renamed from: c */
    private static final int f5322c = 1024;
    /* renamed from: d */
    private static final int f5323d = 200;
    /* renamed from: e */
    private static final int f5324e = 206;
    /* renamed from: f */
    private static final int f5325f = 5000;
    /* renamed from: g */
    private boolean f5326g = false;
    /* renamed from: h */
    private boolean f5327h = false;
    /* renamed from: i */
    private byte[] f5328i = new byte[1024];

    /* renamed from: a */
    public void m6407a() {
        m6411a(false);
    }

    @NonNull
    /* renamed from: a */
    public HttpURLConnection mo1639a(String url) throws IOException {
        LogUtil.d(f5321b, "start to download " + url);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        mo1647a(connection);
        return connection;
    }

    /* renamed from: a */
    void mo1647a(HttpURLConnection connection) {
    }

    /* renamed from: b */
    public void m6412b() {
        m6415b(true);
    }

    /* renamed from: a */
    void mo1646a(RandomAccessFile file) {
    }

    /* renamed from: a */
    public String mo1638a(String url, String fileName) {
        return CommonParams.jm + "/" + fileName + m6403d(url);
    }

    /* renamed from: d */
    private String m6403d(String url) {
        if (url.endsWith(".m3u8")) {
            return ".m3u8";
        }
        if (url.endsWith(".aac")) {
            return ".aac";
        }
        return ".mp3";
    }

    /* renamed from: b */
    public boolean mo1640b(HttpURLConnection conn) throws IOException {
        try {
            int statusCode = conn.getResponseCode();
            if ((206 == statusCode || 200 == statusCode) && conn.getContentLength() >= 0) {
                return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    /* renamed from: b */
    public void mo1644b(String path) {
    }

    /* renamed from: a */
    public int mo1637a(String diskFilePath, HttpURLConnection conn) throws IOException {
        RandomAccessFile diskFile = m6417c(diskFilePath);
        if (conn.getResponseCode() == 206) {
            mo1646a(diskFile);
        }
        InputStream inStream = conn.getInputStream();
        int contentLength = conn.getContentLength();
        mo1645a(contentLength);
        diskFile.setLength((long) contentLength);
        int totalByteDownload = m6402a(inStream, diskFile);
        diskFile.close();
        inStream.close();
        conn.disconnect();
        return totalByteDownload;
    }

    @NonNull
    /* renamed from: c */
    RandomAccessFile m6417c(String diskFilePath) throws FileNotFoundException {
        int index = diskFilePath.lastIndexOf("/");
        String dirPath = "";
        if (diskFilePath.length() >= index) {
            dirPath = diskFilePath.substring(0, index);
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return new RandomAccessFile(diskFilePath, "rwd");
    }

    /* renamed from: a */
    void mo1645a(int songLength) {
    }

    /* renamed from: a */
    private int m6402a(InputStream inStream, RandomAccessFile diskFile) throws IOException {
        int totalByteRead = 0;
        while (m6419c()) {
            int byteReadThisTime = inStream.read(this.f5328i, 0, 1024);
            if (byteReadThisTime == -1) {
                break;
            }
            diskFile.write(this.f5328i, 0, byteReadThisTime);
            mo1648b(byteReadThisTime);
            totalByteRead += byteReadThisTime;
        }
        return totalByteRead;
    }

    /* renamed from: b */
    void mo1648b(int byteReadThisTime) {
    }

    /* renamed from: a */
    public void m6411a(boolean downloadStatus) {
        this.f5326g = downloadStatus;
    }

    /* renamed from: b */
    public void m6415b(boolean startDownload) {
        this.f5327h = startDownload;
    }

    /* renamed from: c */
    public boolean m6419c() {
        return this.f5326g;
    }

    /* renamed from: d */
    public boolean m6420d() {
        return this.f5327h;
    }

    /* renamed from: c */
    protected void m6418c(int waitTimeMilliseconds) {
        try {
            Thread.sleep((long) waitTimeMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
