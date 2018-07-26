package com.baidu.location.indoor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.baidu.location.indoor.c */
public class C3422c {
    /* renamed from: a */
    private static final char[] f18515a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private static C3422c f18516b = null;
    /* renamed from: c */
    private Context f18517c;
    /* renamed from: d */
    private boolean f18518d = false;
    /* renamed from: e */
    private boolean f18519e = false;
    /* renamed from: f */
    private BluetoothAdapter f18520f;
    /* renamed from: g */
    private boolean f18521g = false;
    /* renamed from: h */
    private C3421a f18522h;
    /* renamed from: i */
    private HashMap<String, ScanResult> f18523i = new HashMap();
    /* renamed from: j */
    private Handler f18524j = new Handler();
    /* renamed from: k */
    private Runnable f18525k = new C34191(this);
    /* renamed from: l */
    private Object f18526l = null;

    /* renamed from: com.baidu.location.indoor.c$1 */
    class C34191 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3422c f18513a;

        C34191(C3422c c3422c) {
            this.f18513a = c3422c;
        }

        public void run() {
            try {
                this.f18513a.m14602a(this.f18513a.f18523i);
            } catch (Exception e) {
            }
            if (this.f18513a.f18520f != null && this.f18513a.f18520f.isEnabled()) {
                this.f18513a.m14606a(false);
            }
            this.f18513a.f18523i.clear();
        }
    }

    /* renamed from: com.baidu.location.indoor.c$2 */
    class C34202 extends ScanCallback {
        /* renamed from: a */
        final /* synthetic */ C3422c f18514a;

        C34202(C3422c c3422c) {
            this.f18514a = c3422c;
        }

        public void onScanResult(int i, ScanResult scanResult) {
            if (this.f18514a.f18523i != null) {
                this.f18514a.f18523i.put(scanResult.getDevice().getAddress(), scanResult);
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.c$a */
    public interface C3421a {
        /* renamed from: a */
        void mo2521a(boolean z, String str, String str2, String str3);
    }

    private C3422c(Context context) {
        this.f18517c = context;
        if (this.f18520f != null) {
            return;
        }
        if (VERSION.SDK_INT > 18) {
            this.f18520f = ((BluetoothManager) context.getSystemService(C1981b.f6363c)).getAdapter();
            this.f18521g = this.f18517c.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            return;
        }
        this.f18520f = BluetoothAdapter.getDefaultAdapter();
    }

    /* renamed from: a */
    public static C3422c m14598a(Context context) {
        if (f18516b == null) {
            f18516b = new C3422c(context);
        }
        return f18516b;
    }

    /* renamed from: a */
    public static String m14599a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f18515a[i2 >>> 4];
            cArr[(i * 2) + 1] = f18515a[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private void m14602a(HashMap<String, ScanResult> hashMap) {
        boolean z = false;
        List<ScanResult> arrayList = new ArrayList(hashMap.values());
        List arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        for (ScanResult scanResult : arrayList) {
            scanResult.getScanRecord().getAdvertiseFlags();
            byte[] bytes = scanResult.getScanRecord().getBytes();
            if (bytes.length >= 26) {
                String a = C3422c.m14599a(Arrays.copyOfRange(bytes, 9, 25));
                arrayList2.add(a);
                hashMap2.put(a, scanResult.getDevice().getName());
                hashMap3.put(a, C3422c.m14599a(Arrays.copyOfRange(bytes, 0, 9)));
                if (hashMap4.get(a) == null) {
                    hashMap4.put(a, Integer.valueOf(0));
                }
                hashMap4.put(a, Integer.valueOf(((Integer) hashMap4.get(a)).intValue() + 1));
            }
        }
        String str = null;
        boolean z2 = false;
        for (String str2 : hashMap4.keySet()) {
            String str22;
            boolean intValue;
            if (((Integer) hashMap4.get(str22)).intValue() > z2) {
                intValue = ((Integer) hashMap4.get(str22)).intValue();
            } else {
                str22 = str;
                intValue = z2;
            }
            str = str22;
            z2 = intValue;
        }
        if (z2 > true) {
            z = true;
        }
        if (this.f18522h != null) {
            this.f18522h.mo2521a(z, str, (String) hashMap2.get(str), (String) hashMap3.get(str));
        }
    }

    /* renamed from: c */
    private boolean m14604c() {
        String str;
        Exception e;
        File file = new File(this.f18517c.getCacheDir(), "ibct");
        if (!file.exists()) {
            return false;
        }
        String str2 = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            str = "";
            while (true) {
                str2 = bufferedReader.readLine();
                if (str2 != null) {
                    str = str + str2;
                } else {
                    try {
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str;
                        e.printStackTrace();
                        str = str2;
                        return str != null ? false : false;
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            str = str2;
            if (str != null) {
            }
        }
        if (str != null && !str.trim().equals("")) {
            try {
                return System.currentTimeMillis() - Long.valueOf(str).longValue() < 259200;
            } catch (Exception e4) {
                return false;
            }
        }
    }

    /* renamed from: d */
    private void m14605d() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f18517c.getCacheDir(), "ibct"));
            fileWriter.write(System.currentTimeMillis() + "");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m14606a(boolean z) {
        if (this.f18520f != null) {
            try {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if (z) {
                    this.f18526l = new C34202(this);
                    this.f18520f.getBluetoothLeScanner().startScan((ScanCallback) this.f18526l);
                    this.f18524j.postDelayed(this.f18525k, Config.BPLUS_DELAY_TIME);
                    this.f18518d = true;
                    return;
                }
                if (this.f18522h != null) {
                    this.f18520f.getBluetoothLeScanner().stopScan((ScanCallback) this.f18526l);
                }
                this.f18518d = false;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public boolean m14607a() {
        return (this.f18520f == null || !this.f18521g) ? false : this.f18520f.isEnabled();
    }

    /* renamed from: a */
    public boolean m14608a(C3421a c3421a) {
        if (this.f18518d || this.f18519e) {
            return false;
        }
        this.f18519e = true;
        if (!m14607a() || m14604c()) {
            return false;
        }
        m14605d();
        this.f18522h = c3421a;
        m14606a(true);
        return true;
    }

    /* renamed from: b */
    public void m14609b() {
        this.f18519e = false;
        this.f18518d = false;
    }
}
