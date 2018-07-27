package com.baidu.carlife.logic.music;

import com.baidu.carlife.model.C1931j;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.navi.util.StatisticConstants;
import java.util.HashMap;
import java.util.List;

/* compiled from: VoiceCommandMapper */
/* renamed from: com.baidu.carlife.logic.music.t */
public class C1852t {
    /* renamed from: a */
    private HashMap<String, Integer> f5726a;

    /* compiled from: VoiceCommandMapper */
    /* renamed from: com.baidu.carlife.logic.music.t$a */
    private static final class C1851a {
        /* renamed from: a */
        private static final C1852t f5725a = new C1852t();

        private C1851a() {
        }
    }

    /* renamed from: a */
    public static C1852t m7034a() {
        return C1851a.f5725a;
    }

    private C1852t() {
        m7036b();
    }

    /* renamed from: b */
    private void m7036b() {
        this.f5726a = new HashMap();
        this.f5726a.put("media_player", Integer.valueOf(0));
        int i = 0 + 1;
        this.f5726a.put("QQ音乐", Integer.valueOf(i));
        i++;
        this.f5726a.put(C2736p.f8984n, Integer.valueOf(i));
        i++;
        this.f5726a.put(C2736p.f8986p, Integer.valueOf(i));
        i++;
        this.f5726a.put(C2736p.f8987q, Integer.valueOf(i));
        i++;
        this.f5726a.put(C2736p.f8989s, Integer.valueOf(i));
        i++;
        this.f5726a.put(C2736p.f8988r, Integer.valueOf(i));
        i++;
    }

    /* renamed from: a */
    public void m7038a(List<C1931j> musicAppList) {
        if (musicAppList != null && musicAppList.size() >= 1) {
            this.f5726a.clear();
            for (int i = 0; i < musicAppList.size(); i++) {
                String vrcmd = m7035a((C1931j) musicAppList.get(i));
                if ("media_player".equals(vrcmd)) {
                    this.f5726a.put("media_player", Integer.valueOf(i));
                }
                this.f5726a.put(vrcmd, Integer.valueOf(i));
            }
        }
    }

    /* renamed from: a */
    private String m7035a(C1931j musicAppModel) {
        if (musicAppModel.l.equals(StatisticConstants.MUSIC_LOCAL_MUSIC) || musicAppModel.m.equals("com.baidu.music.local")) {
            return "media_player";
        }
        if (musicAppModel.l.equals("QQ音乐") || musicAppModel.m.equals("com.tencent.qqmusic")) {
            return "QQ音乐";
        }
        if (musicAppModel.l.equals(StatisticConstants.MUSIC_NETEASE_MUSIC) || musicAppModel.m.equals("com.baidu.music.netease")) {
            return C2736p.f8984n;
        }
        if (musicAppModel.l.equals("喜马拉雅FM") || musicAppModel.m.equals("com.ximalaya.ting.android")) {
            return C2736p.f8986p;
        }
        if (musicAppModel.l.equals("考拉FM") || musicAppModel.m.equals("com.itings.myradio")) {
            return C2736p.f8987q;
        }
        if (musicAppModel.l.equals(C2736p.f8989s)) {
            return C2736p.f8989s;
        }
        if (musicAppModel.l.equals(C2736p.f8988r) || musicAppModel.m.equals("com.shinyv.cnr")) {
            return C2736p.f8988r;
        }
        return musicAppModel.l;
    }

    /* renamed from: a */
    public int m7037a(String voiceCommand) {
        Integer musicIndex = (Integer) this.f5726a.get(voiceCommand);
        return musicIndex == null ? -1 : musicIndex.intValue();
    }
}
