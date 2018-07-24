package com.baidu.carlife.logic.music;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.MusicSDKListAdapter;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.model.C1929i;
import com.baidu.carlife.model.C1930o;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p054k.C1658q;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.platform.C1776b;
import com.baidu.carlife.platform.C1995c;
import com.baidu.carlife.platform.model.CLAlbum;
import com.baidu.carlife.util.C2170a;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.speech.asr.SpeechConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AppListManager */
/* renamed from: com.baidu.carlife.logic.music.a */
public class C1785a implements C0924a {
    /* renamed from: a */
    public static final String[] f5429a = new String[]{"com.baidu.music.local", "com.tencent.qqmusic", "com.baidu.music.netease"};
    /* renamed from: b */
    private static final String f5430b = "CarLifeMusic";
    /* renamed from: c */
    private static final String f5431c = "appListData";
    /* renamed from: i */
    private static final int[] f5432i = new int[]{R.drawable.music_ic_localmusic_display, R.drawable.music_ic_qqmusic_display, R.drawable.music_ic_netease_display};
    /* renamed from: j */
    private static final int[] f5433j = new int[]{0, 1, 2};
    /* renamed from: d */
    private C1658q f5434d;
    /* renamed from: e */
    private C1781a f5435e;
    /* renamed from: f */
    private HandlerThread f5436f = new HandlerThread("CarLifeMusic");
    /* renamed from: g */
    private Context f5437g;
    /* renamed from: h */
    private C1782b f5438h;
    /* renamed from: k */
    private List<C1931j> f5439k = new ArrayList();
    /* renamed from: l */
    private HashMap<String, C1790b> f5440l;
    /* renamed from: m */
    private MusicSDKListAdapter f5441m;
    /* renamed from: n */
    private OnItemClickListener f5442n;
    /* renamed from: o */
    private int f5443o = 0;
    /* renamed from: p */
    private C1776b f5444p = new C17771(this);

    /* compiled from: AppListManager */
    /* renamed from: com.baidu.carlife.logic.music.a$1 */
    class C17771 implements C1776b {
        /* renamed from: a */
        final /* synthetic */ C1785a f5413a;

        C17771(C1785a this$0) {
            this.f5413a = this$0;
        }

        /* renamed from: a */
        public void mo1650a(int errorNo, String errorMsg, String packageName, String songListId, List<MusicSongModel> songList, int pn, int rn, int total) {
            C1849s dataManager = (C1849s) C1818h.m6730b().m6792b(packageName);
            if (dataManager == null) {
                C2201w.m8373a("非法第三方音乐,不能同步", 1);
                return;
            }
            List<C1929i> mTopList = dataManager.m6648r();
            if (!(mTopList == null || mTopList.size() == 0)) {
                String albumID = ((C1929i) mTopList.get(0)).f6055c;
                String albumName = ((C1929i) mTopList.get(0)).f6053a;
                if (albumID != null && albumID.equals(songListId) && albumName != null && albumName.equals("下载听")) {
                    dataManager.m7023a(songList, songListId, pn, rn, total);
                    return;
                }
            }
            LogUtil.d("CarLifePlatform", "--onGetSongList-pn:" + pn + "-rn:" + rn + "---total:" + total);
            if (errorNo != 0) {
                LogUtil.d("CarLifePlatform", "PlatformManager.onGetSongList() - FAIL");
                MsgHandlerCenter.m4462b(CommonParams.dR, dataManager.m6649s());
                return;
            }
            LogUtil.d("CarLifePlatform", "PlatformManager.onGetSongList() - OK");
            dataManager.m7023a(songList, songListId, pn, rn, total);
        }

        /* renamed from: a */
        public void mo1649a(int errorNo, String errorMsg, String packageName, String songId, long downloadSize, long totalSize, boolean stop) {
            if (errorNo != 0) {
                LogUtil.m4445e("CarLifeMusic", "---onGetSong---error:" + errorNo + "---packageName:" + packageName);
                return;
            }
            C1849s dataManager = (C1849s) C1818h.m6730b().m6792b(packageName);
            if (dataManager == null) {
                LogUtil.m4445e("CarLifeMusic", "---onGetSong--dataManager == Null----packageName:" + packageName);
            } else {
                dataManager.m7021a(songId, downloadSize, totalSize, stop);
            }
        }

        /* renamed from: a */
        public void mo1651a(int errorNo, String errorMsg, String packageName, List<CLAlbum> albumList) {
            C1849s dataManager = (C1849s) C1818h.m6730b().m6792b(packageName);
            if (dataManager != null) {
                if (errorNo != 0 || albumList == null || albumList.size() <= 0) {
                    MsgHandlerCenter.m4454a((int) CommonParams.dQ, dataManager.m6649s(), 1000);
                    switch (dataManager.m6649s()) {
                        case 3:
                            StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0010, "同步成功但网络失败");
                            return;
                        case 4:
                            StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0010, "同步成功但网络失败");
                            return;
                        case 5:
                            StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0010, "同步成功但网络失败");
                            return;
                        default:
                            return;
                    }
                }
                LogUtil.d("CarLifePlatform", "PlatformManager.onGetAlbumList() --OK-");
                dataManager.m7022a((List) albumList);
            }
        }

        /* renamed from: a */
        public void mo1652a(String packageName) {
            MsgHandlerCenter.m4459a(412, (Object) packageName);
        }

        /* renamed from: b */
        public void mo1653b(String packageName) {
            StatisticManager.onEvent(StatisticConstants.PLATFORM_CONNECT_TIMES, packageName);
            this.f5413a.f5435e.sendMessage(Message.obtain(this.f5413a.f5435e, 422, packageName));
        }
    }

    /* compiled from: AppListManager */
    /* renamed from: com.baidu.carlife.logic.music.a$2 */
    class C17782 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1785a f5414a;

        C17782(C1785a this$0) {
            this.f5414a = this$0;
        }

        public void run() {
            String data = CarlifeUtil.m4374g(C1785a.f5431c);
            LogUtil.d("CarLifeMusic", "----getLocalData---" + data);
            this.f5414a.m6553a(C1785a.m6550a(data));
            this.f5414a.f5434d.toGetRequest();
        }
    }

    /* compiled from: AppListManager */
    /* renamed from: com.baidu.carlife.logic.music.a$3 */
    class C17793 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1785a f5415a;

        C17793(C1785a this$0) {
            this.f5415a = this$0;
        }

        public void run() {
            this.f5415a.f5441m.notifyDataSetChanged();
        }
    }

    /* compiled from: AppListManager */
    /* renamed from: com.baidu.carlife.logic.music.a$a */
    private class C1781a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C1785a f5418a;

        public C1781a(C1785a c1785a, Looper looper) {
            this.f5418a = c1785a;
            super(looper);
        }

        public void careAbout() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 422:
                    if (CarLifeSettings.m4069a().m4082e()) {
                        final String packageName = msg.obj;
                        if (this.f5418a.m6567b(packageName) != null && BaseFragment.getNaviActivity() != null) {
                            BaseFragment.getNaviActivity().runOnUiThread(new Runnable(this) {
                                /* renamed from: b */
                                final /* synthetic */ C1781a f5417b;

                                public void run() {
                                    this.f5417b.f5418a.m6567b(packageName).m6637j();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    sendMessageDelayed(Message.obtain(msg), 300);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AppListManager */
    /* renamed from: com.baidu.carlife.logic.music.a$b */
    public interface C1782b {
        /* renamed from: a */
        int mo1671a();

        /* renamed from: a */
        void mo1672a(int i);

        /* renamed from: a */
        void mo1673a(boolean z);
    }

    protected C1785a() {
        this.f5436f.start();
        this.f5435e = new C1781a(this, this.f5436f.getLooper());
        MsgHandlerCenter.m4460a(this.f5435e);
    }

    /* renamed from: a */
    public void m6565a(Context context, C1782b callBack) {
        this.f5437g = context;
        this.f5438h = callBack;
        this.f5440l = new HashMap();
        this.f5441m = new MusicSDKListAdapter(this.f5437g, this.f5439k);
        this.f5442n = new C1820j(this.f5437g);
        C1995c.m7602a().m7615a(this.f5437g, this.f5444p);
        this.f5434d = new C1658q(this.f5437g);
        this.f5434d.registerResponseListener(this);
        this.f5435e.post(new C17782(this));
    }

    public void onNetWorkResponse(int responseCode) {
        switch (responseCode) {
            case -3:
                m6556b(null);
                CarlifeUtil.m4365c(f5431c, "");
                return;
            case 0:
                LogUtil.d("ouyang", "------RESPONSE_SUCCESS------");
                String jsonData = this.f5434d.m5970b();
                if (!TextUtils.isEmpty(jsonData) && !jsonData.equals(CarlifeUtil.m4374g(f5431c))) {
                    LogUtil.d("ouyang", "------RESPONSE_SUCCESS---1---");
                    m6556b(this.f5434d.m5969a());
                    CarlifeUtil.m4365c(f5431c, jsonData);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static List<C1931j> m6550a(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            if (jsonArray != null) {
                int arrayLength = jsonArray.length();
                if (arrayLength >= 1) {
                    List<C1931j> appList = new ArrayList();
                    for (int i = 0; i < arrayLength; i++) {
                        JSONObject jsonObject = jsonArray.optJSONObject(i);
                        if (jsonObject != null) {
                            C1931j model = new C1931j();
                            model.i = jsonObject.optString("sdk_address");
                            model.h = jsonObject.optString(SpeechConstant.APP_ID);
                            model.g = jsonObject.optInt("app_type");
                            model.k = jsonObject.optString("app_description");
                            model.m = jsonObject.optString("sdk_name");
                            model.n = jsonObject.optString("akey");
                            model.l = jsonObject.optString("app_name");
                            model.j = jsonObject.optString("app_icon_address");
                            model.f6068c = i + 3;
                            appList.add(model);
                        }
                    }
                    return appList;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private C1790b m6549a(int type, String packageName) {
        switch (type) {
            case 0:
                return new C1798e(this.f5437g);
            case 1:
                return new C1838q(this.f5437g, f5433j[1], f5429a[1]);
            case 2:
                return new C1825l(this.f5437g);
            default:
                if (type >= 3) {
                    return new C1849s(this.f5437g, type, packageName);
                }
                return null;
        }
    }

    /* renamed from: a */
    protected void m6564a() {
        for (Object obj : this.f5440l.keySet()) {
            C1790b dataManager = (C1790b) this.f5440l.get(obj);
            if (!(m6560f(dataManager.m6649s()) || dataManager.m6649s() == 0)) {
                dataManager.m6599a(0);
                dataManager.m6623e(null);
            }
        }
    }

    /* renamed from: b */
    protected C1790b m6567b(String packageName) {
        return (C1790b) this.f5440l.get(packageName);
    }

    /* renamed from: a */
    protected C1790b m6563a(int type) {
        if (!C1818h.m6745i(type)) {
            return null;
        }
        for (C1931j temp : this.f5439k) {
            if (type == temp.f6068c) {
                return m6567b(temp.m);
            }
        }
        return null;
    }

    /* renamed from: b */
    protected C1790b m6566b() {
        C1790b result = m6567b(m6574e(m6576f()));
        if (result != null) {
            return result;
        }
        if (this.f5440l.isEmpty()) {
            this.f5440l.put(f5429a[0], new C1798e(this.f5437g));
        }
        return m6567b(f5429a[0]);
    }

    /* renamed from: b */
    protected void m6568b(int pos) {
        if (pos < 0) {
            pos = 0;
        }
        m6571c(pos);
        C1820j.m6845a(pos);
        m6575e();
    }

    /* renamed from: c */
    protected MusicSDKListAdapter m6569c() {
        return this.f5441m;
    }

    /* renamed from: d */
    protected OnItemClickListener m6572d() {
        return this.f5442n;
    }

    /* renamed from: e */
    protected void m6575e() {
        if (this.f5441m != null && BaseFragment.getNaviActivity() != null) {
            BaseFragment.getNaviActivity().runOnUiThread(new C17793(this));
        }
    }

    /* renamed from: c */
    protected void m6571c(int index) {
        if (this.f5439k != null) {
            if (this.f5443o < 0 || this.f5443o >= this.f5439k.size()) {
                this.f5443o = 0;
            } else {
                ((C1931j) this.f5439k.get(this.f5443o)).f6066a = false;
            }
            if (index >= 0 && index < this.f5439k.size()) {
                ((C1931j) this.f5439k.get(index)).f6066a = true;
                this.f5443o = index;
            }
        }
    }

    /* renamed from: f */
    protected int m6576f() {
        return this.f5443o;
    }

    /* renamed from: c */
    protected String m6570c(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        for (C1931j model : this.f5439k) {
            if (!TextUtils.isEmpty(model.m) && model.m.equalsIgnoreCase(packageName)) {
                return model.l;
            }
        }
        return null;
    }

    /* renamed from: d */
    protected C1931j m6573d(int pos) {
        try {
            return (C1931j) this.f5439k.get(pos);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /* renamed from: b */
    private void m6555b(int type, String packageName) {
        C1790b dataManager = m6549a(type, packageName);
        if (dataManager != null) {
            this.f5440l.put(dataManager.m6647q(), dataManager);
        }
    }

    /* renamed from: d */
    private void m6558d(String packageName) {
        C1790b dataManager = m6567b(packageName);
        if (m6560f(dataManager.m6649s())) {
            this.f5438h.mo1673a(true);
            m6561g(-1);
        }
        dataManager.mo1690y();
        this.f5440l.remove(packageName);
    }

    /* renamed from: a */
    private void m6552a(C1931j app) {
        if (this.f5439k != null) {
            this.f5439k.add(app);
            m6555b(app.f6068c, app.m);
        }
    }

    /* renamed from: e */
    private int m6559e(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return -1;
        }
        C1790b dataManager = m6567b(packageName);
        if (dataManager != null) {
            return dataManager.m6649s();
        }
        return -1;
    }

    /* renamed from: e */
    protected String m6574e(int type) {
        for (C1931j app : this.f5439k) {
            if (type == app.f6068c) {
                return app.m;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m6553a(List<C1931j> list) {
        String[] appNameList = this.f5437g.getResources().getStringArray(R.array.module_music_apps_list);
        for (int i = 0; i < appNameList.length; i++) {
            m6552a(new C1931j(appNameList[i], f5432i[i], f5433j[i], f5429a[i]));
        }
        if (!(list == null || list.isEmpty())) {
            for (C1931j model : list) {
                m6555b(model.f6068c, model.m);
            }
            this.f5439k.addAll(list);
        }
        C1852t.m7034a().m7038a(this.f5439k);
        try {
            m6568b(m6559e(C2186p.m8304a().m8309a(C1818h.f5600k, f5429a[0])));
        } catch (ClassCastException e) {
            C2186p.m8304a().m8322c(C1818h.f5600k);
            m6568b(0);
        }
    }

    /* renamed from: b */
    private void m6556b(List<C1931j> list) {
        int i;
        C1931j curPlayApp;
        if (list == null) {
            list = new ArrayList();
        }
        List<C1931j> newList = new ArrayList(this.f5439k.subList(0, 3));
        for (i = 0; i < list.size(); i++) {
            boolean isExist = false;
            int j = 3;
            while (j < this.f5439k.size()) {
                if (((C1931j) list.get(i)).equals(this.f5439k.get(j))) {
                    isExist = true;
                    break;
                }
                j++;
            }
            if (isExist) {
                newList.add(new C1931j((C1930o) this.f5439k.get(j), i + 3));
                m6567b(((C1931j) this.f5439k.get(j)).m).f5484F = i + 3;
            } else {
                newList.add(new C1931j((C1930o) list.get(i), i + 3));
                m6555b(i + 3, ((C1931j) list.get(i)).m);
            }
        }
        C1931j selectedApp = (C1931j) this.f5439k.get(m6576f());
        if (m6562j() <= 0 || m6562j() >= this.f5439k.size()) {
            curPlayApp = null;
        } else {
            curPlayApp = (C1931j) this.f5439k.get(m6562j());
        }
        for (C1931j temp1 : this.f5439k) {
            isExist = false;
            for (C1931j temp2 : newList) {
                if (temp1.equals(temp2)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                if (temp1.equals(selectedApp)) {
                    this.f5443o = m6567b(temp1.m).f5484F;
                }
                if (temp1.equals(curPlayApp)) {
                    m6561g(m6567b(temp1.m).f5484F);
                    C2186p.m8304a().m8319b(C1818h.f5600k, temp1.m);
                }
            } else {
                if (temp1.equals(curPlayApp)) {
                    this.f5438h.mo1673a(true);
                    m6578h();
                }
                if (temp1.equals(selectedApp) && !temp1.equals(curPlayApp)) {
                    m6578h();
                }
                m6558d(temp1.m);
            }
        }
        if (!C2170a.m8217a()) {
            for (i = 0; i < newList.size(); i++) {
                if ("com.ximalaya.ting.android".equalsIgnoreCase(((C1931j) newList.get(i)).m)) {
                    ((C1931j) newList.get(i)).l = "XimalayaFM";
                } else if ("com.itings.myradio".equalsIgnoreCase(((C1931j) newList.get(i)).m)) {
                    ((C1931j) newList.get(i)).l = "Kaola FM";
                } else if ("com.shinyv.cnr".equalsIgnoreCase(((C1931j) newList.get(i)).m)) {
                    ((C1931j) newList.get(i)).l = "China Radio";
                }
            }
        }
        this.f5439k.clear();
        this.f5439k.addAll(newList);
        m6568b(m6576f());
        C1852t.m7034a().m7038a(this.f5439k);
    }

    /* renamed from: f */
    private boolean m6560f(int type) {
        return m6562j() == type;
    }

    /* renamed from: j */
    private int m6562j() {
        return this.f5438h.mo1671a();
    }

    /* renamed from: g */
    private void m6561g(int type) {
        this.f5438h.mo1672a(type);
    }

    /* renamed from: g */
    protected void m6577g() {
        m6568b(0);
        Bundle arg = new Bundle();
        arg.putBoolean(C1790b.f5466i, true);
        NaviFragmentManager fragManager = FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager();
        int curFragmentType = fragManager.getCurrentFragmentType();
        if (curFragmentType == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
            fragManager.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
        } else if (curFragmentType != NaviFragmentManager.TYPE_MUSIC_PLAYER) {
            ContentFragment fragment = fragManager.getLatestFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER);
            if (fragment.getArguments() != null) {
                fragment.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                fragment.onStart();
            }
        } else if (fragManager.getCurrentFragment() != null && fragManager.getCurrentFragment().getArguments() != null) {
            fragManager.getCurrentFragment().getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
            fragManager.getCurrentFragment().onStart();
        }
    }

    /* renamed from: h */
    protected void m6578h() {
        m6568b(2);
        NaviFragmentManager fragManager = FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager();
        Bundle arg = new Bundle();
        arg.putBoolean(C1790b.f5466i, true);
        int curFragmentType = fragManager.getCurrentFragmentType();
        if (curFragmentType == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
            if (fragManager.getCurrentFragment() != null && fragManager.getCurrentFragment().getArguments() != null) {
                fragManager.getCurrentFragment().getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                fragManager.getCurrentFragment().onStart();
            }
        } else if (curFragmentType == NaviFragmentManager.TYPE_MUSIC_PLAYER) {
            fragManager.showFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST, arg);
        } else {
            ContentFragment fragment = fragManager.getLatestFragment(NaviFragmentManager.TYPE_MUSIC_ALBUMLIST);
            if (fragment != null && fragment.getArguments() != null) {
                fragment.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                fragment.onStart();
                m6566b().m6599a(0);
            }
        }
    }

    /* renamed from: i */
    protected void m6579i() {
        m6568b(2);
        NaviFragmentManager fragManager = FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager();
        Bundle arg = new Bundle();
        arg.putString("album_id", C1799f.f5533C);
        int curFragmentType = fragManager.getCurrentFragmentType();
        if (curFragmentType == NaviFragmentManager.TYPE_MUSIC_ALBUMLIST) {
            fragManager.showFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER, arg);
        } else if (curFragmentType != NaviFragmentManager.TYPE_MUSIC_PLAYER) {
            ContentFragment fragment = fragManager.getLatestFragment(NaviFragmentManager.TYPE_MUSIC_PLAYER);
            if (fragment.getArguments() != null) {
                fragment.getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
                fragment.onStart();
            }
        } else if (fragManager.getCurrentFragment() != null && fragManager.getCurrentFragment().getArguments() != null) {
            fragManager.getCurrentFragment().getArguments().putBundle(ContentFragmentManager.KEY_SHOW_BUNDLE, arg);
            fragManager.getCurrentFragment().onStart();
        }
    }
}
