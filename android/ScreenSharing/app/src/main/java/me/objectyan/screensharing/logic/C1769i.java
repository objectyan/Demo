package com.baidu.carlife.logic;

import android.support.annotation.NonNull;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.logic.p088a.C1709n;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HlsDownloadThread */
/* renamed from: com.baidu.carlife.logic.i */
public class C1769i extends C1759e {
    /* renamed from: b */
    private static final int f5372b = 3;
    /* renamed from: c */
    private static final int f5373c = 20;
    /* renamed from: d */
    private static final String f5374d = "HlsDownloadThread";
    /* renamed from: e */
    private String f5375e = "http://ls.qingting.fm/live/386.m3u8";
    /* renamed from: f */
    private List<String> f5376f = new ArrayList();
    /* renamed from: g */
    private List<String> f5377g = new ArrayList();
    /* renamed from: h */
    private ArrayList<String> f5378h;
    /* renamed from: i */
    private int f5379i = -1;
    /* renamed from: j */
    private C1760f f5380j;
    /* renamed from: k */
    private C1760f f5381k;

    /* compiled from: HlsDownloadThread */
    /* renamed from: com.baidu.carlife.logic.i$a */
    private class C1767a extends C1760f {
        /* renamed from: a */
        final /* synthetic */ C1769i f5370a;

        public C1767a(C1769i c1769i, C1758w urlFetcher) {
            this.f5370a = c1769i;
            super(urlFetcher);
        }

        /* renamed from: a */
        void mo1642a(String diskFilePath) throws IOException {
            this.f5370a.f5378h.add(diskFilePath);
        }
    }

    /* compiled from: HlsDownloadThread */
    /* renamed from: com.baidu.carlife.logic.i$b */
    private class C1768b extends C1760f {
        /* renamed from: a */
        final /* synthetic */ C1769i f5371a;

        public C1768b(C1769i c1769i, C1758w urlFetcher) {
            this.f5371a = c1769i;
            super(urlFetcher);
        }

        /* renamed from: a */
        void mo1643a() {
            LogUtil.m4445e(C1769i.f5374d, "index file download fail");
            MsgHandlerCenter.m4461b(424);
        }

        /* renamed from: a */
        void mo1642a(String diskFilePath) throws IOException {
            this.f5371a.m6460e(diskFilePath);
            this.f5371a.m6466j();
            if (this.f5371a.m6465i()) {
                LogUtil.m4445e(C1769i.f5374d, "notify audio track to awake");
                MsgHandlerCenter.m4461b((int) CommonParams.ew);
            }
            this.f5371a.m6467k();
        }
    }

    public C1769i(ArrayList<String> fileList) {
        this.f5378h = fileList;
        this.f5380j = new C1767a(this, this);
        this.f5381k = new C1768b(this, this);
    }

    public void run() {
        while (this.f5376f != null) {
            if (m6420d() && m6463g()) {
                m6459e();
            } else {
                m6418c(300);
            }
        }
    }

    /* renamed from: e */
    private void m6459e() {
        File directory = m6464h();
        this.f5379i = 1;
        this.f5376f.clear();
        m6415b(false);
        m6458d(this.f5375e);
        m6461f();
        m6452a(directory);
    }

    /* renamed from: f */
    private void m6461f() {
        while (m6419c()) {
            if (this.f5376f.size() == 0) {
                LogUtil.d(f5374d, "load more aac url");
                m6418c(1000);
                m6458d(this.f5375e);
            } else {
                m6453a((String) this.f5376f.get(0), this.f5379i);
                this.f5377g.add(this.f5376f.get(0));
                this.f5376f.remove(0);
                this.f5379i++;
            }
        }
        LogUtil.d(f5374d, "download aborted");
    }

    /* renamed from: a */
    private void m6452a(File directory) {
        this.f5376f.clear();
        this.f5377g.clear();
        this.f5378h.clear();
        m6455b(directory);
    }

    /* renamed from: b */
    private void m6455b(File directory) {
        for (File file : directory.listFiles()) {
            file.delete();
        }
    }

    /* renamed from: g */
    private boolean m6463g() {
        return (this.f5375e == null || this.f5375e.isEmpty()) ? false : true;
    }

    @NonNull
    /* renamed from: h */
    private File m6464h() {
        File directory = new File(CommonParams.jm + "/fm");
        if (!directory.exists()) {
            directory.mkdir();
        }
        return directory;
    }

    /* renamed from: b */
    public void mo1644b(String path) {
        this.f5375e = C1709n.m6204a().m6205a(path);
        m6415b(true);
    }

    /* renamed from: d */
    private void m6458d(String m3u8Url) {
        LogUtil.d(f5374d, "m3u8 url is " + m3u8Url);
        m6411a(true);
        try {
            this.f5381k.m6423a(m3u8Url, "test");
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: i */
    private boolean m6465i() {
        return this.f5378h.size() > 3;
    }

    /* renamed from: e */
    private void m6460e(String indexFilePath) throws IOException {
        FileReader fileReader = new FileReader(indexFilePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (true) {
            String aLineInIndexFile = bufferedReader.readLine();
            if (aLineInIndexFile == null) {
                break;
            }
            String aacFileUrl = C1709n.m6204a().m6205a(aLineInIndexFile);
            if (m6462f(aacFileUrl)) {
                LogUtil.d(f5374d, "aac url added " + aacFileUrl);
                this.f5376f.add(aacFileUrl);
            }
        }
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }

    /* renamed from: j */
    private void m6466j() {
        if (this.f5377g.size() > 20) {
            this.f5377g.remove(0);
        }
    }

    /* renamed from: k */
    private void m6467k() {
        while (m6419c() && m6465i()) {
            m6418c(300);
        }
    }

    /* renamed from: f */
    private boolean m6462f(String url) {
        return (url == null || this.f5376f.contains(url) || this.f5377g.contains(url)) ? false : true;
    }

    /* renamed from: a */
    private void m6453a(String url, int fileName) {
        m6411a(true);
        try {
            this.f5380j.m6423a(url, String.valueOf(fileName));
        } catch (SocketTimeoutException e) {
            LogUtil.m4445e(f5374d, "socket time out");
            e.printStackTrace();
        } catch (IOException e2) {
            LogUtil.m4445e(f5374d, "io error");
            e2.printStackTrace();
        }
    }
}
