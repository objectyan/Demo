package com.baidu.carlife.p100n;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.elhyf.C1352a;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.C6327f;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OtaDownLoadManager */
/* renamed from: com.baidu.carlife.n.d */
public class C1962d {
    /* renamed from: a */
    public static final String f6250a = "HUOtaManager";
    /* renamed from: b */
    public static final String f6251b = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeOta");
    /* renamed from: c */
    public static final int f6252c = 1001;
    /* renamed from: d */
    public static final int f6253d = 1002;
    /* renamed from: p */
    static final String f6254p = "version.config";
    /* renamed from: s */
    private static final int f6255s = 0;
    /* renamed from: t */
    private static final int f6256t = 1;
    /* renamed from: u */
    private static final int f6257u = 2;
    /* renamed from: e */
    String f6258e = "http://caronline.yfgps.com/carlife/ota";
    /* renamed from: f */
    String f6259f = "rv02.eroad_5001_u2";
    /* renamed from: g */
    String f6260g;
    /* renamed from: h */
    String f6261h;
    /* renamed from: i */
    String f6262i;
    /* renamed from: j */
    String f6263j = "18039";
    /* renamed from: k */
    String f6264k = "170223";
    /* renamed from: l */
    String f6265l = "";
    /* renamed from: m */
    long f6266m;
    /* renamed from: n */
    boolean f6267n = false;
    /* renamed from: o */
    String f6268o = "";
    /* renamed from: q */
    public Handler f6269q = null;
    /* renamed from: r */
    private int f6270r = 0;
    /* renamed from: v */
    private Handler f6271v = new C19551(this);

    /* compiled from: OtaDownLoadManager */
    /* renamed from: com.baidu.carlife.n.d$1 */
    class C19551 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1962d f6242a;

        C19551(C1962d this$0) {
            this.f6242a = this$0;
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:
                    this.f6242a.m7483c();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: OtaDownLoadManager */
    /* renamed from: com.baidu.carlife.n.d$2 */
    class C19562 extends JsonHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C1962d f6243a;

        C19562(C1962d this$0) {
            this.f6243a = this$0;
        }

        public void onSuccess(int statusCode, C6327f[] headers, JSONObject response) {
            if (this.f6243a.f6269q != null) {
                Message msg = Message.obtain();
                msg.what = 1001;
                msg.arg1 = 50;
                this.f6243a.f6269q.sendMessage(msg);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C1260i.m4435b(C1962d.f6250a, "HttpResponseHandler onSuccess: ");
            try {
                int code = response.getInt(ParamKey.KEY_MSG_ERRORS);
                if (code == 0) {
                    this.f6243a.f6260g = response.getString("url");
                    this.f6243a.f6262i = response.getString("tips");
                    this.f6243a.f6266m = response.getLong("length");
                    this.f6243a.f6261h = response.getString("md5");
                    this.f6243a.f6263j = "" + response.getLong("versionCode");
                    if (this.f6243a.m7477h()) {
                        this.f6243a.m7479a(new File(C1962d.m7476f()));
                    }
                } else {
                    String strMsg = response.getString(PushConstants.EXTRA_PUSH_MESSAGE);
                    C1260i.m4435b(C1962d.f6250a, "HttpResponseHandler code:" + code);
                    C1260i.m4435b(C1962d.f6250a, "HttpResponseHandler strMsg:" + strMsg);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.f6243a.f6269q != null) {
                msg = Message.obtain();
                msg.what = 1001;
                msg.arg1 = 100;
                this.f6243a.f6269q.sendMessage(msg);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            if (this.f6243a.f6269q != null) {
                msg = Message.obtain();
                msg.what = 1002;
                msg.arg1 = 100;
                this.f6243a.f6269q.sendMessage(msg);
            }
        }

        public void onFailure(int statusCode, C6327f[] headers, Throwable throwable, JSONObject errorResponse) {
            C1260i.m4435b(C1962d.f6250a, "HttpResponseHandler onFailure: ");
        }
    }

    /* compiled from: OtaDownLoadManager */
    /* renamed from: com.baidu.carlife.n.d$5 */
    class C19605 implements FileFilter {
        /* renamed from: a */
        final /* synthetic */ C1962d f6248a;

        C19605(C1962d this$0) {
            this.f6248a = this$0;
        }

        public boolean accept(File pathname) {
            if (pathname.getName().endsWith(".fex")) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: OtaDownLoadManager */
    /* renamed from: com.baidu.carlife.n.d$6 */
    class C19616 implements Comparator<File> {
        /* renamed from: a */
        final /* synthetic */ C1962d f6249a;

        C19616(C1962d this$0) {
            this.f6249a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7469a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m7469a(File lhs, File rhs) {
            if (lhs.lastModified() > rhs.lastModified()) {
                return -1;
            }
            if (lhs.lastModified() == rhs.lastModified()) {
                return 0;
            }
            return 1;
        }
    }

    /* renamed from: a */
    public void m7478a() {
        try {
            FileInputStream versionConfig = new FileInputStream(f6251b + "/" + f6254p);
            byte[] data = new byte[versionConfig.available()];
            versionConfig.read(data);
            versionConfig.close();
            C1260i.m4435b(f6250a, "read data: " + new String(data));
            JSONObject config = new JSONObject(new String(data));
            this.f6259f = config.getString("board");
            this.f6264k = config.getString("versionCode");
            if (config.has("ignore")) {
                this.f6265l = config.getString("ignore");
            }
            C1260i.m4435b(f6250a, "mIgnoreVersionCode: " + new String(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public C1962d(Handler handler) {
        File file = new File(f6251b);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f6269q = handler;
    }

    /* renamed from: a */
    public void m7480a(String strServerUrl, String strVersion) {
        C1260i.m4435b(f6250a, "OTA checkUpdateManual");
        m7481a(this.f6259f, this.f6264k, true);
    }

    /* renamed from: b */
    public void m7482b() {
        C1260i.m4435b(f6250a, "OTA checkUpdateManual");
        m7481a(this.f6259f, this.f6264k, true);
    }

    /* renamed from: a */
    public void m7481a(String boardName, String versionCode, boolean manual) {
        this.f6270r = 0;
        C1260i.m4435b(f6250a, "boardName: " + boardName);
        C1260i.m4435b(f6250a, "versionCode: " + versionCode);
        C1260i.m4435b(f6250a, "OtaPath: " + C1962d.m7476f());
        this.f6259f = boardName;
        this.f6264k = versionCode;
        C1260i.m4435b(f6250a, "mIsDownloading: " + this.f6267n);
        if (!this.f6267n) {
            RequestParams params = new RequestParams();
            params.put("board", boardName);
            params.put("versionCode", versionCode);
            C1352a.m4958a().get(this.f6258e, params, new C19562(this));
        }
    }

    /* renamed from: a */
    public void m7479a(final File file) {
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1962d f6245b;

            public void run() {
                try {
                    this.f6245b.f6271v.sendEmptyMessage(0);
                    FileInputStream fin = new FileInputStream(file);
                    MappedByteBuffer buffer = fin.getChannel().map(MapMode.READ_ONLY, 0, file.length());
                    MessageDigest md5 = MessageDigest.getInstance("MD5");
                    md5.update(buffer);
                    String md5Code = new BigInteger(1, md5.digest()).toString(16).toLowerCase();
                    int l = this.f6245b.f6261h.length() - md5Code.length();
                    for (int i = 0; i < l; i++) {
                        md5Code = "0" + md5Code;
                    }
                    if (this.f6245b.f6261h.equalsIgnoreCase(md5Code)) {
                        this.f6245b.f6271v.sendEmptyMessage(2);
                    } else {
                        this.f6245b.f6271v.sendEmptyMessage(1);
                        file.delete();
                    }
                    fin.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
        }).start();
    }

    /* renamed from: c */
    public void m7483c() {
        this.f6267n = true;
        this.f6268o = this.f6259f;
        String downloadPath = C1962d.m7476f();
        C1260i.m4435b(f6250a, "downloadPath: " + downloadPath);
        File file = new File(downloadPath);
        if (file.exists()) {
            if (file.length() == this.f6266m) {
                m7479a(file);
                return;
            }
            file.delete();
        }
        C1352a.m4958a().setURLEncodingEnabled(false);
        C1352a.m4958a().get(this.f6260g, new FileAsyncHttpResponseHandler(this, new File(downloadPath)) {
            /* renamed from: a */
            final /* synthetic */ C1962d f6247a;

            /* compiled from: OtaDownLoadManager */
            /* renamed from: com.baidu.carlife.n.d$4$1 */
            class C19581 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C19594 f6246a;

                C19581(C19594 this$1) {
                    this.f6246a = this$1;
                }

                public void run() {
                    this.f6246a.f6247a.f6270r = this.f6246a.f6247a.f6270r + 1;
                    this.f6246a.f6247a.m7483c();
                }
            }

            public void onFailure(int statusCode, C6327f[] headers, Throwable throwable, File file) {
                this.f6247a.f6267n = false;
                this.f6247a.f6268o = "";
                Log.i("mai", "retryCount:" + this.f6247a.f6270r);
                if (this.f6247a.f6270r >= 2) {
                    this.f6247a.f6270r = 0;
                    C1260i.m4435b(C1962d.f6250a, "onDownloadFailed: " + statusCode);
                    return;
                }
                this.f6247a.f6271v.postDelayed(new C19581(this), 3000);
            }

            public void onSuccess(int statusCode, C6327f[] headers, File file) {
                this.f6247a.f6267n = false;
                this.f6247a.f6268o = "";
                this.f6247a.m7479a(file);
            }

            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                C1260i.m4435b(C1962d.f6250a, "onDownloadProgress: " + ((int) ((100 * bytesWritten) / totalSize)));
            }
        });
        C1352a.m4958a().setURLEncodingEnabled(true);
    }

    /* renamed from: d */
    public boolean m7484d() {
        return (this.f6259f == null || "".equals(this.f6259f)) ? false : true;
    }

    /* renamed from: h */
    private boolean m7477h() {
        File file = new File(C1962d.m7475e());
        if (file.exists() && file.length() == this.f6266m) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public static String m7475e() {
        return f6251b;
    }

    /* renamed from: f */
    public static String m7476f() {
        return C1962d.m7475e() + "/CarLife-Vehicle.apk";
    }

    /* renamed from: g */
    public void m7485g() {
        File file = new File(f6251b);
        if (file.exists() && file.isDirectory()) {
            List<File> fileList = Arrays.asList(file.listFiles(new C19605(this)));
            Collections.sort(fileList, new C19616(this));
            for (int i = 1; i < fileList.size(); i++) {
                ((File) fileList.get(i)).delete();
            }
        }
    }
}
