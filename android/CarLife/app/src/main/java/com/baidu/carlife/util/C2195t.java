package com.baidu.carlife.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p054k.C1655o;
import com.baidu.carlife.p054k.C1657p;
import com.baidu.carlife.p054k.C1657p.C1656a;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: StatisticVehicleUtil */
/* renamed from: com.baidu.carlife.util.t */
public class C2195t {
    /* renamed from: a */
    public static final String f7027a = "StatisticVehicleUtil";
    /* renamed from: b */
    public static final String f7028b = (C1253f.jm + File.separator + "vehicle/log/");
    /* renamed from: c */
    public static final String f7029c = "CarlifeVechicleCrash.log";
    /* renamed from: d */
    public static int f7030d = 120000;
    /* renamed from: e */
    private static Timer f7031e = null;
    /* renamed from: f */
    private static TimerTask f7032f = null;
    /* renamed from: g */
    private static Handler f7033g = null;

    /* renamed from: a */
    public static void m8347a(final CarlifeStatisticsInfo statisInfo) {
        final Context context = BaiduNaviApplication.getInstance();
        if (context != null && statisInfo != null) {
            new Thread(new Runnable() {
                public void run() {
                    C2195t.m8346a(context, statisInfo);
                    C2195t.m8350b(context, statisInfo);
                    C2195t.m8352c(context, statisInfo);
                }
            }).start();
        }
    }

    /* renamed from: a */
    public static void m8346a(Context context, CarlifeStatisticsInfo statisInfo) {
        int temp = statisInfo.getConnectCount();
        for (int i = 0; i < temp; i++) {
            StatisticManager.onEvent(StatisticConstants.VEHICLE_HU_CONNECT_MOBILE);
        }
        StatisticManager.onEvent(StatisticConstants.VEHICLE_HU_CONNECT_MOBILE_SCCESS);
        StatisticManager.onEventDuration(context, StatisticConstants.VEHICLE_HU_CONNECT_MOBILE_AVG_TIME, StatisticConstants.VEHICLE_HU_CONNECT_MOBILE_AVG_TIME, statisInfo.getConnectTime());
    }

    /* renamed from: b */
    public static void m8350b(Context context, CarlifeStatisticsInfo statisInfo) {
        String time = C2186p.m8304a().m8309a(C1253f.ik, "");
        if (time.split(",").length > 1000) {
            time = null;
            C2186p.m8304a().m8322c(C1253f.ik);
        }
        if (TextUtils.isEmpty(time)) {
            time = String.valueOf(new Date().getTime() / 1000);
        } else {
            time = time + "," + String.valueOf(new Date().getTime() / 1000);
        }
        C2186p.m8304a().m8319b(C1253f.ik, time);
        if (C1251e.m4358a().m4401r()) {
            C1657p request = new C1657p();
            request.getClass();
            C1656a params = new C1656a(request);
            params.f5096b = statisInfo.getCuid();
            params.f5095a = statisInfo.getChannel();
            params.f5097c = statisInfo.getVersionName();
            params.f5098d = params.m5967a(time);
            request.m5968a(params);
            request.toPostRequest();
        }
    }

    /* renamed from: c */
    public static void m8352c(Context context, CarlifeStatisticsInfo statisInfo) {
        FileOutputStream fout;
        String log = statisInfo.getCrashLog();
        if (!TextUtils.isEmpty(log)) {
            log = log + "\n##########\n";
            fout = null;
            try {
                fout = context.openFileOutput(f7029c, 32768);
                fout.write(log.getBytes());
                if (fout != null) {
                    try {
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (fout != null) {
                    try {
                        fout.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (fout != null) {
                    try {
                        fout.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
            }
        }
        FileInputStream fileInputStream = null;
        byte[] bArr = null;
        try {
            fileInputStream = context.openFileInput(f7029c);
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            while (fileInputStream.read(bytes) != -1) {
                arrayOutputStream.write(bytes, 0, bytes.length);
            }
            arrayOutputStream.flush();
            bArr = arrayOutputStream.toByteArray();
            arrayOutputStream.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e322) {
            e322.printStackTrace();
        }
        if (bArr != null && bArr.length >= 1) {
            fout = null;
            try {
                fout = context.openFileOutput("CarlifeVechicleCrash.log.gz", 0);
                C2177h.m8272a(bArr, fout);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3222) {
                        e3222.printStackTrace();
                    }
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e22) {
                e22.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e32222) {
                        e32222.printStackTrace();
                    }
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (Throwable th2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e322222) {
                        e322222.printStackTrace();
                    }
                }
                if (fout != null) {
                    fout.close();
                }
            }
            InputStream in = null;
            try {
                in = context.openFileInput("CarlifeVechicleCrash.log.gz");
                if (C1251e.m4358a().m4401r() && in != null) {
                    new C1655o(statisInfo.getVersionName(), "CarlifeVechicleCrash.log.gz", in).toPostRequest();
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e3222222) {
                    e3222222.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8348a(String log) {
        IOException e;
        Throwable th;
        File direct = new File(f7028b);
        if (!direct.exists()) {
            direct.mkdirs();
        }
        File file = new File(f7028b + (String.valueOf(System.currentTimeMillis()) + ".txt"));
        FileWriter fw = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fw2 = new FileWriter(file, false);
                try {
                    fw2.write(log);
                    fw2.flush();
                    if (fw2 != null) {
                        try {
                            fw2.close();
                            fw = fw2;
                            return;
                        } catch (IOException e2) {
                            fw = fw2;
                            return;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    fw = fw2;
                    try {
                        e.printStackTrace();
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fw = fw2;
                    if (fw != null) {
                        fw.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                e.printStackTrace();
                if (fw != null) {
                    fw.close();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8345a(final Context context, final C1277e listener) {
        C2195t.m8344a();
        try {
            C1260i.m4445e(f7027a, "Carlife Statstic Connect Timer Start");
            f7031e = new Timer();
            f7033g = new Handler();
            f7032f = new TimerTask() {

                /* compiled from: StatisticVehicleUtil */
                /* renamed from: com.baidu.carlife.util.t$2$1 */
                class C21931 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C21942 f7024a;

                    C21931(C21942 this$0) {
                        this.f7024a = this$0;
                    }

                    public void run() {
                        C2204x.m8380a(context, listener);
                    }
                }

                public void run() {
                    C1260i.m4445e(C2195t.f7027a, "Carlife Statstic Connect Timeout 1");
                    if (C2195t.f7031e != null) {
                        C1260i.m4445e(C2195t.f7027a, "Carlife Statstic Connect Timeout 2");
                        if (C2195t.f7033g != null) {
                            C2195t.f7033g.post(new C21931(this));
                        }
                        C2195t.m8344a();
                    }
                }
            };
            f7031e.schedule(f7032f, (long) f7030d);
        } catch (Exception ex) {
            C1260i.m4435b(f7027a, "startTimer get exception");
            ex.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m8344a() {
        C1260i.m4445e(f7027a, "Carlife Statstic Connect Timer Stop");
        if (f7031e != null) {
            f7031e.cancel();
            f7031e = null;
        }
        if (f7033g != null) {
            f7033g = null;
        }
        if (f7032f != null) {
            f7032f.cancel();
            f7032f = null;
        }
    }
}
