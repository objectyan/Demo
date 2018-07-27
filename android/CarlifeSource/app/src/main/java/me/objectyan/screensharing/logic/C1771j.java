package com.baidu.carlife.logic;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: MP3DownLoadThread */
/* renamed from: com.baidu.carlife.logic.j */
public class C1771j extends C1759e {
    /* renamed from: b */
    public static final int f5383b = -1000;
    /* renamed from: c */
    private static final String f5384c = "MP3DownLoadThread";
    /* renamed from: d */
    private List<MusicSongModel> f5385d = null;
    /* renamed from: e */
    private MusicSongModel f5386e;
    /* renamed from: f */
    private C1760f f5387f;

    /* compiled from: MP3DownLoadThread */
    /* renamed from: com.baidu.carlife.logic.j$a */
    private class C1770a extends C1760f {
        /* renamed from: a */
        final /* synthetic */ C1771j f5382a;

        public C1770a(C1771j c1771j, C1758w urlFetcher) {
            this.f5382a = c1771j;
            super(urlFetcher);
        }

        /* renamed from: a */
        void mo1642a(String diskFilePath) throws IOException {
            if (this.f5382a.f5386e.f5922n >= this.f5382a.f5386e.f5923o) {
                LogUtil.d(C1771j.f5384c, "download complete");
                MsgHandlerCenter.m4458a(217, 2, this.f5382a.f5386e);
            }
            this.f5382a.m6473h();
        }
    }

    public C1771j(List<MusicSongModel> list) {
        this.f5385d = list;
        this.f5387f = new C1770a(this, this);
    }

    public void run() {
        while (true) {
            if (!m6420d()) {
                m6418c(300);
            } else if (!m6478e()) {
                m6415b(false);
                this.f5386e = (MusicSongModel) this.f5385d.get(this.f5385d.size() - 1);
                if (m6479f()) {
                    this.f5385d.remove(this.f5385d.size() - 1);
                } else {
                    m6472g();
                }
            }
        }
    }

    /* renamed from: e */
    protected boolean m6478e() {
        return this.f5385d == null || this.f5385d.isEmpty();
    }

    /* renamed from: f */
    protected boolean m6479f() {
        return this.f5386e == null || this.f5386e.f5921m == null || this.f5386e.f5921m.isEmpty();
    }

    /* renamed from: g */
    private void m6472g() {
        m6411a(true);
        try {
            this.f5387f.m6423a(this.f5386e.f5921m, this.f5386e.f5910b);
        } catch (IOException e) {
            LogUtil.d(f5384c, "downloadSimpleSong fail");
            e.printStackTrace();
            this.f5386e.f5922n = -1000;
        }
    }

    /* renamed from: h */
    private void m6473h() {
        long downLoadBytes = this.f5386e.m7372m();
        if (downLoadBytes > 0 && this.f5386e.f5925q > 0) {
            while (downLoadBytes > 17999999) {
                StatisticManager.onEventDuration(AppContext.m3876a(), StatisticConstants.FM_FLOW_0001, StatisticConstants.FM_FLOW_0001, 17999999);
                if (CarlifeUtil.m4381s() == 1) {
                    StatisticManager.onEventDuration(AppContext.m3876a(), StatisticConstants.FM_FLOW_0002, StatisticConstants.FM_FLOW_0002, 17999999);
                }
                downLoadBytes -= 17999999;
            }
            if (downLoadBytes > 0) {
                StatisticManager.onEventDuration(AppContext.m3876a(), StatisticConstants.FM_FLOW_0001, StatisticConstants.FM_FLOW_0001, (int) downLoadBytes);
                if (CarlifeUtil.m4381s() == 1) {
                    StatisticManager.onEventDuration(AppContext.m3876a(), StatisticConstants.FM_FLOW_0002, StatisticConstants.FM_FLOW_0002, (int) downLoadBytes);
                }
            }
        }
    }

    /* renamed from: a */
    void mo1646a(RandomAccessFile file) {
        if (this.f5386e.f5922n > 0) {
            try {
                file.seek(this.f5386e.f5922n);
            } catch (IOException e) {
                LogUtil.d(f5384c, "seek fail");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    void mo1647a(HttpURLConnection connection) {
        if (this.f5386e.f5922n > 0) {
            connection.setRequestProperty("Range", "bytes=" + this.f5386e.f5922n + "-");
        }
    }

    /* renamed from: a */
    void mo1645a(int songLength) {
        this.f5386e.f5923o = (long) songLength;
    }

    /* renamed from: b */
    void mo1648b(int byteReadThisTime) {
        MusicSongModel musicSongModel = this.f5386e;
        musicSongModel.f5922n += (long) byteReadThisTime;
    }
}
