package com.baidu.baidumaps.base.localmap;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.widget.MToast;
import com.baidu.platform.comapi.map.LocalMapResource;
import com.baidu.platform.comapi.util.NetworkUtil;
import java.util.Locale;

/* compiled from: LocalMapHelper */
/* renamed from: com.baidu.baidumaps.base.localmap.d */
public final class C0679d {
    private C0679d() {
    }

    /* renamed from: a */
    public static boolean m2879a(LocalMapResource resource) {
        return resource.downloadStatus == 2;
    }

    /* renamed from: b */
    public static boolean m2880b(LocalMapResource resource) {
        return resource.downloadStatus == 1 || resource.downloadStatus == 10;
    }

    /* renamed from: c */
    public static boolean m2881c(LocalMapResource resource) {
        int status = resource.downloadStatus;
        return status == 3 || status == 6 || status == 8 || status == 7 || status == 5;
    }

    /* renamed from: d */
    public static boolean m2882d(LocalMapResource resource) {
        return resource.downloadStatus == 4 || resource.downloadStatus == 9 || resource.updateStatus == 4;
    }

    /* renamed from: e */
    public static boolean m2883e(LocalMapResource resource) {
        return resource.updateStatus == 4 || resource.downloadStatus == 9;
    }

    /* renamed from: f */
    public static boolean m2884f(LocalMapResource resource) {
        return !C0679d.m2882d(resource) && resource.needUpdate;
    }

    /* renamed from: g */
    public static boolean m2885g(LocalMapResource resource) {
        if (C0679d.m2882d(resource)) {
            return resource.needUpdate;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m2886h(LocalMapResource resource) {
        if (C0679d.m2884f(resource)) {
            return false;
        }
        switch (resource.downloadStatus) {
            case 1:
            case 2:
            case 4:
                return false;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public static void m2877a(Context context, final OnClickListener okListener, final OnClickListener cancelListener) {
        NetworkInfo networkInfo = NetworkUtil.getActiveNetworkInfo(context);
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            MToast.show(context, C0965R.string.no_network_txt);
        } else if (networkInfo.getType() == 1) {
            okListener.onClick(null, 0);
            C0692f.m2894a().f2230j = false;
        } else {
            C1309g.m4699a().showDialog(new C1953c(context).m7448c("提示").m7435a((int) C0965R.string.not_wifi_network).m7451d("取消").m7454e("确定").m7459r().m7438a(new C0672b() {
                public void onClick() {
                    cancelListener.onClick(null, 1);
                }
            }).m7443b(new C0672b() {
                public void onClick() {
                    okListener.onClick(null, 0);
                }
            }));
        }
    }

    /* renamed from: i */
    public static boolean m2887i(LocalMapResource resource) {
        switch (resource.type) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: j */
    public static boolean m2888j(LocalMapResource city) {
        return city.mapsize + city.searchsize != city.mappatchsize + city.searchpatchsize;
    }

    /* renamed from: k */
    public static void m2889k(LocalMapResource province) {
        LocalMapResource provincePack = null;
        long total = 0;
        int notStartedCount = 0;
        int waitingCount = 0;
        int downloadingCount = 0;
        int stopedCount = 0;
        int finishedCount = 0;
        if (province != null) {
            for (LocalMapResource city : province.children) {
                LocalMapResource city2;
                if (city2.type == 1) {
                    provincePack = city2;
                } else {
                    city2 = C0692f.m2894a().m2941h(city2.id);
                    if (city2 == null) {
                        notStartedCount++;
                        break;
                    }
                    if (C0679d.m2879a(city2)) {
                        waitingCount++;
                    } else if (C0679d.m2880b(city2)) {
                        downloadingCount++;
                    } else if (C0679d.m2881c(city2)) {
                        stopedCount++;
                    } else if (C0679d.m2882d(city2)) {
                        finishedCount++;
                    } else {
                        notStartedCount++;
                    }
                    total += (long) (((float) (city2.mapsize + city2.searchsize)) * (1.0f - (((float) city2.downloadProgress) / 100.0f)));
                }
            }
            if (notStartedCount > 0) {
                province.downloadStatus = 0;
            } else if (waitingCount > 0 || downloadingCount > 0) {
                province.downloadStatus = 1;
            } else if (stopedCount > 0) {
                province.downloadStatus = 3;
            } else if (finishedCount > 0) {
                province.downloadStatus = 4;
            } else {
                province.downloadStatus = 0;
            }
            if (provincePack != null) {
                provincePack.downloadStatus = province.downloadStatus;
                provincePack.remainSize = total;
            }
        }
    }

    /* renamed from: a */
    public static Context m2875a(boolean activityRequired) {
        return C0676c.m2863a(activityRequired);
    }

    /* renamed from: a */
    public static String m2876a(long size) {
        if (size < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return "1K";
        }
        if (size < 1048576) {
            return String.format(Locale.getDefault(), "%dK", new Object[]{Long.valueOf(size / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)});
        } else if (size < 1073741824) {
            return String.format(Locale.getDefault(), "%.1fM", new Object[]{Double.valueOf(((double) size) / 1048576.0d)});
        } else {
            return String.format(Locale.getDefault(), "%.1fG", new Object[]{Double.valueOf(((double) size) / 1.073741824E9d)});
        }
    }

    /* renamed from: a */
    public static void m2878a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
