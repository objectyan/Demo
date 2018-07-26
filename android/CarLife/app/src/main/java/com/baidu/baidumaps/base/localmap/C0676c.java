package com.baidu.baidumaps.base.localmap;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.util.MapDataUtil;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.LocalMapManager;
import com.baidu.platform.comapi.map.LocalMapResource;
import com.baidu.platform.comapi.p209e.C4770a;
import java.util.List;

/* compiled from: LMUtil */
/* renamed from: com.baidu.baidumaps.base.localmap.c */
public class C0676c {
    /* renamed from: a */
    static final long f2181a = 3145728;
    /* renamed from: b */
    static final long f2182b = 15728640;
    /* renamed from: c */
    public static boolean f2183c = true;
    /* renamed from: d */
    private static final long f2184d = 2592000000L;
    /* renamed from: e */
    private static final int f2185e = 3;
    /* renamed from: f */
    private static final String f2186f = "您有%s个离线包存在更新";
    /* renamed from: g */
    private static final String f2187g = "您有%s个离线包超过60天未更新";
    /* renamed from: h */
    private static final String f2188h = "您有%s个离线包超过90天未更新";
    /* renamed from: i */
    private static final String f2189i = "您有%s个离线包已过期，无法使用，请您更新";
    /* renamed from: j */
    private static boolean f2190j = true;

    /* compiled from: LMUtil */
    /* renamed from: com.baidu.baidumaps.base.localmap.c$1 */
    static class C06701 implements OnClickListener {
        C06701() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
            GlobalConfig.getInstance().setIsAutoDownload(true);
            C0676c.m2869b();
        }
    }

    /* compiled from: LMUtil */
    /* renamed from: com.baidu.baidumaps.base.localmap.c$2 */
    static class C06712 implements OnClickListener {
        C06712() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
        }
    }

    /* compiled from: LMUtil */
    /* renamed from: com.baidu.baidumaps.base.localmap.c$4 */
    static class C06744 implements OnClickListener {
        C06744() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
            C0669b.m2851a(C0676c.m2863a(false)).m2856a();
        }
    }

    /* renamed from: a */
    public static boolean m2867a(int time) {
        if (time == -1 || !StorageSettings.getInstance().isExternalStorageEnabled() || !StorageSettings.getInstance().isHasExternalStoragePermission()) {
            return false;
        }
        List<LocalMapResource> citys = LocalMapManager.getInstance().getUserResources();
        if (citys == null || citys.size() <= 0) {
            return false;
        }
        for (int i = 0; i < citys.size(); i++) {
            if (C0676c.m2868a((LocalMapResource) citys.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2868a(LocalMapResource city) {
        return city != null && city.updateStatus > 0 && city.updateStatus <= 4;
    }

    /* renamed from: a */
    public static String m2864a() {
        int updateStatus = 1;
        int count = 0;
        int totalCount = 0;
        List<LocalMapResource> citys = LocalMapManager.getInstance().getUserResources();
        if (citys != null && citys.size() > 0) {
            int i = 0;
            while (i < citys.size()) {
                if (citys.get(i) != null && ((LocalMapResource) citys.get(i)).updateStatus <= 4 && ((LocalMapResource) citys.get(i)).updateStatus >= updateStatus) {
                    if (updateStatus != ((LocalMapResource) citys.get(i)).updateStatus) {
                        count = 0;
                    }
                    updateStatus = ((LocalMapResource) citys.get(i)).updateStatus;
                    count++;
                    totalCount++;
                }
                i++;
            }
        }
        if (totalCount >= 3) {
            return String.format(f2186f, new Object[]{Integer.valueOf(totalCount)});
        } else if (count == 0) {
            return null;
        } else {
            switch (updateStatus) {
                case 1:
                    return String.format(f2186f, new Object[]{Integer.valueOf(count)});
                case 2:
                    return String.format(f2187g, new Object[]{Integer.valueOf(count)});
                case 3:
                    return String.format(f2188h, new Object[]{Integer.valueOf(count)});
                case 4:
                    return String.format(f2189i, new Object[]{Integer.valueOf(count)});
                default:
                    return String.format(f2186f, new Object[]{Integer.valueOf(count)});
            }
        }
    }

    /* renamed from: b */
    public static void m2870b(int time) {
        final OnClickListener okButtonListener = new C06701();
        OnClickListener cancelButtonListener = new C06712();
        Activity activity = (Activity) C0676c.m2863a(true);
        if (activity != null && !activity.isFinishing()) {
            C1309g.m4699a().showDialog(new C1953c(activity).m7448c("提示").m7437a(LinearLayout.inflate(activity, C0965R.layout.local_map_update_note, null)).m7451d("开启自动更新").m7454e("以后再说").m7438a(new C0672b() {
                public void onClick() {
                    okButtonListener.onClick(null, 0);
                }
            }));
        }
    }

    /* renamed from: b */
    public static void m2869b() {
        C0692f.m2894a().m2944j();
    }

    /* renamed from: a */
    public static Context m2863a(boolean activityRequired) {
        return activityRequired ? NavMapAdapter.getInstance().getContainerActivity() : C2907c.m10977f();
    }

    /* renamed from: c */
    public static double m2871c() {
        long size = 0;
        for (LocalMapResource resource : C0692f.m2894a().m2937f()) {
            size += ((resource.mapsize + resource.searchsize) / 100) * ((long) resource.downloadProgress);
        }
        for (LocalMapResource resource2 : C0692f.m2894a().m2942h()) {
            size = (resource2.mapsize + size) + resource2.searchsize;
        }
        return (double) size;
    }

    /* renamed from: d */
    public static void m2872d() {
        f2190j = true;
        f2183c = true;
    }

    /* renamed from: a */
    public static void m2866a(boolean dialog, boolean notification) {
        f2190j = dialog;
        f2183c = notification;
    }

    /* renamed from: a */
    public static void m2865a(int total, int imported) {
        if (StorageSettings.getInstance().isExternalStorageEnabled() && StorageSettings.getInstance().isHasExternalStoragePermission()) {
            if (total - imported > 0) {
                C4770a.a().a(C0668a.f2130F);
            }
            if (imported <= 0) {
                MapDataUtil dataUtil = new MapDataUtil(C0676c.m2863a(false));
                if (dataUtil.existsNotImportedData()) {
                    dataUtil.showNotImportedDataTip();
                }
                if (total <= 0) {
                    return;
                }
            }
            final OnClickListener okButtonListener = new C06744();
            if (imported != 0) {
                Activity activity = (Activity) C0676c.m2863a(true);
                if (!(!f2190j || activity == null || activity.isFinishing())) {
                    C1309g.m4699a().showDialog(new C1953c(activity).m7448c("离线地图包导入提醒").m7444b("恭喜！您已成功导入" + imported + "个城市的离线地图包。").m7451d("立即查看").m7438a(new C0672b() {
                        public void onClick() {
                            okButtonListener.onClick(null, 0);
                        }
                    }).m7454e("以后再说"));
                }
            }
            if (f2183c) {
                C0669b.m2851a(C0676c.m2863a(false)).m2857a(imported, total, total - imported);
            }
        }
    }

    /* renamed from: e */
    public static String m2873e() {
        return GlobalConfig.getInstance().getLastLocationCityName();
    }

    /* renamed from: f */
    public static long m2874f() {
        return StorageSettings.getInstance().getCurrentStorage().getAvailableBytes();
    }
}
