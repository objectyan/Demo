package com.baidu.carlife.custom.elhyf.p074b;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import java.io.FileOutputStream;
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

/* compiled from: OtaManager */
/* renamed from: com.baidu.carlife.custom.elhyf.b.a */
public class C1370a {
    /* renamed from: a */
    public static final String f3976a = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeOta");
    /* renamed from: m */
    static final String f3977m = "version.config";
    /* renamed from: o */
    private static final int f3978o = 0;
    /* renamed from: p */
    private static final int f3979p = 1;
    /* renamed from: q */
    private static final int f3980q = 2;
    /* renamed from: b */
    C1369a f3981b;
    /* renamed from: c */
    String f3982c;
    /* renamed from: d */
    String f3983d;
    /* renamed from: e */
    String f3984e;
    /* renamed from: f */
    String f3985f;
    /* renamed from: g */
    String f3986g;
    /* renamed from: h */
    String f3987h;
    /* renamed from: i */
    String f3988i = "";
    /* renamed from: j */
    long f3989j;
    /* renamed from: k */
    boolean f3990k = false;
    /* renamed from: l */
    String f3991l = "";
    /* renamed from: n */
    private int f3992n = 0;
    /* renamed from: r */
    private Handler f3993r = new C13621(this);

    /* compiled from: OtaManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.b.a$1 */
    class C13621 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1370a f3967a;

        C13621(C1370a this$0) {
            this.f3967a = this$0;
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    this.f3967a.f3981b.mo1541g();
                    return;
                case 1:
                    this.f3967a.f3981b.mo1542h();
                    return;
                case 2:
                    this.f3967a.f3981b.mo1537a(this.f3967a.m4988h(), this.f3967a.f3982c, this.f3967a.f3986g);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: OtaManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.b.a$5 */
    class C13675 implements FileFilter {
        /* renamed from: a */
        final /* synthetic */ C1370a f3974a;

        C13675(C1370a this$0) {
            this.f3974a = this$0;
        }

        public boolean accept(File pathname) {
            if (pathname.getName().endsWith(".fex")) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: OtaManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.b.a$6 */
    class C13686 implements Comparator<File> {
        /* renamed from: a */
        final /* synthetic */ C1370a f3975a;

        C13686(C1370a this$0) {
            this.f3975a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4971a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m4971a(File lhs, File rhs) {
            if (lhs.lastModified() > rhs.lastModified()) {
                return -1;
            }
            if (lhs.lastModified() == rhs.lastModified()) {
                return 0;
            }
            return 1;
        }
    }

    /* compiled from: OtaManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.b.a$a */
    public interface C1369a {
        /* renamed from: a */
        void mo1535a(int i);

        /* renamed from: a */
        void mo1536a(String str, long j);

        /* renamed from: a */
        void mo1537a(String str, String str2, String str3);

        /* renamed from: a */
        void mo1538a(boolean z);

        /* renamed from: b */
        void mo1539b(int i);

        /* renamed from: b */
        void mo1540b(boolean z);

        /* renamed from: g */
        void mo1541g();

        /* renamed from: h */
        void mo1542h();
    }

    public C1370a(C1369a listener) {
        this.f3981b = listener;
        File file = new File(f3976a);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileInputStream versionConfig = new FileInputStream(f3976a + "/" + f3977m);
            byte[] data = new byte[versionConfig.available()];
            versionConfig.read(data);
            versionConfig.close();
            JSONObject config = new JSONObject(new String(data));
            this.f3982c = config.getString("board");
            this.f3987h = config.getString("versionCode");
            if (config.has("ignore")) {
                this.f3988i = config.getString("ignore");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m4986f() {
        JSONObject object = new JSONObject();
        try {
            object.put("ignore", this.f3988i);
            object.put("board", this.f3982c);
            object.put("versionCode", this.f3987h);
            FileOutputStream fileOutputStream = new FileOutputStream(f3976a + "/" + f3977m);
            fileOutputStream.write(object.toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m4989a() {
        C1260i.m4435b("OTAUPDATE", "OTA checkUpdateManual");
        m4991a(this.f3982c, this.f3987h, true);
    }

    /* renamed from: a */
    public void m4991a(String boardName, String versionCode, final boolean manual) {
        this.f3992n = 0;
        C1260i.m4435b("OTAUPDATE", "boardName: " + boardName);
        C1260i.m4435b("OTAUPDATE", "versionCode: " + versionCode);
        C1260i.m4435b("OTAUPDATE", "DEBUG: false");
        this.f3982c = boardName;
        this.f3987h = versionCode;
        m4986f();
        if (!this.f3990k) {
            RequestParams params = new RequestParams();
            params.put("board", boardName);
            params.put("versionCode", versionCode);
            C1352a.m4958a().get("http://caronline.yfgps.com/carlife/ota", params, new JsonHttpResponseHandler(this) {
                /* renamed from: b */
                final /* synthetic */ C1370a f3969b;

                public void onSuccess(int statusCode, C6327f[] headers, JSONObject response) {
                    C1260i.m4435b("OTAUPDATE", "HttpResponseHandler onSuccess: ");
                    try {
                        if (response.getInt(ParamKey.KEY_MSG_ERRORS) == 0) {
                            this.f3969b.f3983d = response.getString("url");
                            this.f3969b.f3985f = response.getString("tips");
                            this.f3969b.f3989j = response.getLong("length");
                            this.f3969b.f3984e = response.getString("md5");
                            this.f3969b.f3986g = "" + response.getLong("versionCode");
                            if (!manual && this.f3969b.f3988i.equals(this.f3969b.f3986g)) {
                                this.f3969b.f3981b.mo1540b(false);
                                return;
                            } else if (!this.f3969b.f3990k || !this.f3969b.f3991l.equals(this.f3969b.f3982c)) {
                                if (this.f3969b.m4987g()) {
                                    this.f3969b.m4990a(new File(this.f3969b.m4988h()));
                                    return;
                                } else {
                                    this.f3969b.f3981b.mo1536a(this.f3969b.f3985f, this.f3969b.f3989j);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        this.f3969b.f3981b.mo1540b(manual);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(int statusCode, C6327f[] headers, Throwable throwable, JSONObject errorResponse) {
                    C1260i.m4435b("OTAUPDATE", "HttpResponseHandler onFailure: ");
                    if (this.f3969b.f3981b != null) {
                        this.f3969b.f3981b.mo1538a(manual);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m4990a(final File file) {
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1370a f3971b;

            public void run() {
                try {
                    this.f3971b.f3993r.sendEmptyMessage(0);
                    FileInputStream fin = new FileInputStream(file);
                    MappedByteBuffer buffer = fin.getChannel().map(MapMode.READ_ONLY, 0, file.length());
                    MessageDigest md5 = MessageDigest.getInstance("MD5");
                    md5.update(buffer);
                    String md5Code = new BigInteger(1, md5.digest()).toString(16).toLowerCase();
                    int l = this.f3971b.f3984e.length() - md5Code.length();
                    for (int i = 0; i < l; i++) {
                        md5Code = "0" + md5Code;
                    }
                    if (this.f3971b.f3984e.equalsIgnoreCase(md5Code)) {
                        this.f3971b.f3993r.sendEmptyMessage(2);
                    } else {
                        this.f3971b.f3993r.sendEmptyMessage(1);
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

    /* renamed from: b */
    public void m4992b() {
        this.f3990k = true;
        this.f3991l = this.f3982c;
        String downloadPath = m4988h();
        File file = new File(downloadPath);
        if (file.exists()) {
            if (file.length() == this.f3989j) {
                m4990a(file);
                return;
            }
            file.delete();
        }
        C1352a.m4958a().setURLEncodingEnabled(false);
        C1352a.m4958a().get(this.f3983d, new FileAsyncHttpResponseHandler(this, new File(downloadPath)) {
            /* renamed from: a */
            final /* synthetic */ C1370a f3973a;

            /* compiled from: OtaManager */
            /* renamed from: com.baidu.carlife.custom.elhyf.b.a$4$1 */
            class C13651 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C13664 f3972a;

                C13651(C13664 this$1) {
                    this.f3972a = this$1;
                }

                public void run() {
                    this.f3972a.f3973a.f3992n = this.f3972a.f3973a.f3992n + 1;
                    this.f3972a.f3973a.m4992b();
                }
            }

            public void onFailure(int statusCode, C6327f[] headers, Throwable throwable, File file) {
                this.f3973a.f3990k = false;
                this.f3973a.f3991l = "";
                Log.i("mai", "retryCount:" + this.f3973a.f3992n);
                if (this.f3973a.f3992n >= 2) {
                    this.f3973a.f3992n = 0;
                    this.f3973a.f3981b.mo1535a(statusCode);
                    return;
                }
                this.f3973a.f3993r.postDelayed(new C13651(this), 3000);
            }

            public void onSuccess(int statusCode, C6327f[] headers, File file) {
                this.f3973a.f3990k = false;
                this.f3973a.f3991l = "";
                this.f3973a.m4990a(file);
            }

            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                this.f3973a.f3981b.mo1539b((int) ((100 * bytesWritten) / totalSize));
            }
        });
        C1352a.m4958a().setURLEncodingEnabled(true);
    }

    /* renamed from: c */
    public void m4993c() {
        this.f3988i = this.f3986g;
        m4986f();
    }

    /* renamed from: d */
    public boolean m4994d() {
        return (this.f3982c == null || "".equals(this.f3982c)) ? false : true;
    }

    /* renamed from: g */
    private boolean m4987g() {
        File file = new File(m4988h());
        if (file.exists() && file.length() == this.f3989j) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    private String m4988h() {
        return f3976a + "/" + this.f3982c + "." + this.f3986g + ".fex";
    }

    /* renamed from: e */
    public void m4995e() {
        File file = new File(f3976a);
        if (file.exists() && file.isDirectory()) {
            List<File> fileList = Arrays.asList(file.listFiles(new C13675(this)));
            Collections.sort(fileList, new C13686(this));
            for (int i = 1; i < fileList.size(); i++) {
                ((File) fileList.get(i)).delete();
            }
        }
    }
}
