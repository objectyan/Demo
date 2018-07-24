package com.baidu.carlife.p054k.p055a;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p054k.p055a.C1635h.C1489c;
import com.baidu.carlife.p054k.p055a.C1635h.C1633a;
import com.baidu.carlife.p054k.p055a.C1635h.C1634b;
import com.baidu.carlife.util.C2201w;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: NetWorkDownloadTask */
/* renamed from: com.baidu.carlife.k.a.i */
public class C1638i extends Thread implements Comparable<C1638i> {
    /* renamed from: a */
    public static final String f5033a = "NetWorkDownload";
    /* renamed from: b */
    private static final String f5034b = C1638i.class.getSimpleName();
    /* renamed from: c */
    private static final int f5035c = 1;
    /* renamed from: d */
    private static final int f5036d = 2;
    /* renamed from: e */
    private static final int f5037e = 15000;
    /* renamed from: f */
    private C1489c f5038f;
    /* renamed from: g */
    private C1632g f5039g;
    /* renamed from: h */
    private File f5040h;
    /* renamed from: i */
    private HttpURLConnection f5041i;
    /* renamed from: j */
    private Context f5042j;
    /* renamed from: k */
    private String f5043k;
    /* renamed from: l */
    private boolean f5044l;
    /* renamed from: m */
    private boolean f5045m;
    /* renamed from: n */
    private Handler f5046n = new C16361(this);

    /* compiled from: NetWorkDownloadTask */
    /* renamed from: com.baidu.carlife.k.a.i$1 */
    class C16361 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1638i f5030a;

        C16361(C1638i this$0) {
            this.f5030a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Bundle bundle = msg.getData();
                    C1634b state = (C1634b) bundle.getSerializable("state");
                    C1633a errorCode = (C1633a) bundle.getSerializable("errorCode");
                    this.f5030a.m5926a(errorCode);
                    if (this.f5030a.f5038f != null) {
                        this.f5030a.f5038f.mo1561a(state, errorCode);
                        LogUtil.d(C1638i.f5034b, this.f5030a.f5039g.f5007d + ":state=" + state.name() + ",errorCode=" + errorCode.name());
                        return;
                    }
                    return;
                case 2:
                    if (this.f5030a.f5038f != null) {
                        this.f5030a.f5038f.mo1560a(this.f5030a.f5039g.f5009f, msg.arg1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m5934a((C1638i) obj);
    }

    C1638i(Context context, C1632g info, C1489c callback, String directoryPath) {
        this.f5039g = info;
        this.f5039g.f5004a = System.currentTimeMillis();
        this.f5042j = context;
        this.f5043k = directoryPath;
        this.f5038f = callback;
        m5927a(C1634b.WAITING, C1633a.NO_ERROR);
    }

    /* renamed from: a */
    public void m5936a(C1489c callBack) {
        this.f5038f = callBack;
    }

    /* renamed from: a */
    public void m5935a() {
        this.f5038f = null;
    }

    /* renamed from: b */
    public File m5937b() {
        return this.f5040h;
    }

    /* renamed from: a */
    private void m5926a(C1633a errorCode) {
        switch (errorCode) {
            case ERROR_MAKE_FILE:
                C2201w.m8371a((int) R.string.error_make_file, 0);
                return;
            case ERROR_SDCARD_UNUSE:
                C2201w.m8371a((int) R.string.error_sdcard_unuse, 0);
                return;
            case ERROR_NONETWORK:
                C2201w.m8371a((int) R.string.common_error_nonetwork, 0);
                return;
            default:
                return;
        }
    }

    public void run() {
        m5941f();
        m5942g();
        m5943h();
    }

    /* renamed from: c */
    public C1632g m5938c() {
        return this.f5039g;
    }

    /* renamed from: d */
    public boolean m5939d() {
        return this.f5045m || this.f5044l;
    }

    /* renamed from: e */
    public void m5940e() {
        m5927a(C1634b.CANCEL, C1633a.NO_ERROR);
        if (this.f5039g.f5010g && this.f5040h != null) {
            this.f5040h.delete();
        }
        this.f5045m = true;
    }

    /* renamed from: f */
    protected void m5941f() {
        if (!CarlifeUtil.m4358a().m4401r()) {
            m5927a(C1634b.ERROR, C1633a.ERROR_NONETWORK);
        } else if (m5929a(this.f5043k)) {
            m5927a(C1634b.START, C1633a.NO_ERROR);
        }
    }

    /* renamed from: a */
    private void m5927a(C1634b state, C1633a errorCode) {
        if (!this.f5045m) {
            Message msg = new Message();
            msg.what = 1;
            Bundle bundle = new Bundle();
            bundle.putSerializable("state", state);
            bundle.putSerializable("errorCode", errorCode);
            msg.setData(bundle);
            this.f5046n.sendMessage(msg);
            switch (state) {
                case CANCEL:
                case ERROR:
                case SUCESS:
                    this.f5044l = true;
                    C1639j.m5944a().m5946b(this);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m5925a(int process) {
        if (!this.f5045m) {
            Message msg = new Message();
            msg.what = 2;
            msg.arg1 = process;
            this.f5046n.sendMessage(msg);
        }
    }

    /* renamed from: a */
    private boolean m5929a(String directoryPath) {
        if (TextUtils.isEmpty(this.f5039g.f5007d)) {
            m5927a(C1634b.ERROR, C1633a.ERROR_MAKE_FILE);
            return false;
        }
        if (!TextUtils.isEmpty(directoryPath)) {
            this.f5039g.f5008e = directoryPath;
        } else if (Environment.getExternalStorageState().equals("mounted")) {
            this.f5039g.f5008e = Environment.getExternalStorageDirectory().toString() + File.separator + "BaiduCarlife" + File.separator + f5033a;
        } else {
            m5927a(C1634b.ERROR, C1633a.ERROR_SDCARD_UNUSE);
            return false;
        }
        if (m5931b(this.f5039g.f5008e)) {
            File file = new File(this.f5039g.f5008e + File.separator + this.f5039g.f5007d);
            if (file.exists() && this.f5039g.f5010g) {
                file.delete();
            } else if (this.f5039g.f5010g || !file.exists()) {
                boolean temp = false;
                try {
                    temp = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!temp) {
                    m5927a(C1634b.ERROR, C1633a.ERROR_MAKE_FILE);
                    return false;
                }
            }
            this.f5040h = file;
            return true;
        }
        m5927a(C1634b.ERROR, C1633a.ERROR_MAKE_FILE);
        return false;
    }

    /* renamed from: b */
    private boolean m5931b(String directoryPath) {
        File file = new File(directoryPath);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    /* renamed from: g */
    protected void m5942g() {
        MalformedURLException e;
        Throwable th;
        IOException e2;
        Exception e3;
        if (!m5939d()) {
            InputStream in = null;
            RandomAccessFile out = null;
            long currentSize = 0;
            try {
                this.f5041i = (HttpURLConnection) new URL(this.f5039g.f5006c).openConnection();
                this.f5041i.setRequestMethod("GET");
                this.f5041i.setConnectTimeout(15000);
                this.f5041i.setUseCaches(false);
                if (!this.f5039g.f5010g) {
                    currentSize = this.f5040h.length();
                    this.f5041i.setRequestProperty("Range", "bytes=" + currentSize + "-");
                    LogUtil.d(f5034b, this.f5039g.f5007d + ":续传初始Size=" + currentSize);
                }
                if (this.f5041i.getResponseCode() == 200 || this.f5041i.getResponseCode() == 206) {
                    m5927a(C1634b.LOADING, C1633a.NO_ERROR);
                    in = this.f5041i.getInputStream();
                    int serverSize = this.f5041i.getContentLength();
                    if (serverSize >= 0) {
                        this.f5039g.f5009f = ((long) serverSize) + currentSize;
                    }
                    LogUtil.d(f5034b, this.f5039g.f5007d + ":serverSize=" + serverSize + ",totalSize=" + this.f5039g.f5009f);
                    RandomAccessFile out2 = new RandomAccessFile(this.f5040h, "rw");
                    try {
                        out2.seek(currentSize);
                        byte[] b = new byte[1024];
                        int tempOnePerSize = 0;
                        int tempByte = 0;
                        if (this.f5039g.f5009f > 0 && !this.f5045m) {
                            tempOnePerSize = (int) (this.f5039g.f5009f / 100);
                            m5925a((int) (((((double) currentSize) + 0.0d) / ((double) this.f5039g.f5009f)) * 100.0d));
                        }
                        while (true) {
                            int len = in.read(b);
                            if (len == -1 || this.f5045m) {
                                out = out2;
                            } else {
                                out2.write(b, 0, len);
                                if (tempOnePerSize != 0) {
                                    tempByte += len;
                                    if (tempByte > tempOnePerSize) {
                                        currentSize += (long) tempByte;
                                        m5925a((int) (((((double) currentSize) + 0.0d) / ((double) this.f5039g.f5009f)) * 100.0d));
                                        tempByte = 0;
                                    }
                                }
                            }
                        }
                        out = out2;
                    } catch (MalformedURLException e4) {
                        e = e4;
                        out = out2;
                        try {
                            m5927a(C1634b.ERROR, C1633a.ERROR_HTTP);
                            e.printStackTrace();
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (IOException e5) {
                                    if (this.f5041i == null) {
                                        this.f5041i.disconnect();
                                    }
                                }
                            }
                            if (out != null) {
                                out.close();
                            }
                            if (this.f5041i == null) {
                                this.f5041i.disconnect();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (IOException e6) {
                                    if (this.f5041i != null) {
                                        this.f5041i.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            if (out != null) {
                                out.close();
                            }
                            if (this.f5041i != null) {
                                this.f5041i.disconnect();
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        e2 = e7;
                        out = out2;
                        m5927a(C1634b.ERROR, C1633a.ERROR_HTTP);
                        e2.printStackTrace();
                        LogUtil.m4445e(f5034b, "IOException");
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e8) {
                                if (this.f5041i == null) {
                                    this.f5041i.disconnect();
                                }
                            }
                        }
                        if (out != null) {
                            out.close();
                        }
                        if (this.f5041i == null) {
                            this.f5041i.disconnect();
                        }
                    } catch (Exception e9) {
                        e3 = e9;
                        out = out2;
                        m5927a(C1634b.ERROR, C1633a.ERROR_HTTP);
                        e3.printStackTrace();
                        LogUtil.m4445e(f5034b, "OtherException");
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e10) {
                                if (this.f5041i == null) {
                                    this.f5041i.disconnect();
                                }
                            }
                        }
                        if (out != null) {
                            out.close();
                        }
                        if (this.f5041i == null) {
                            this.f5041i.disconnect();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        out = out2;
                        if (in != null) {
                            in.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                        if (this.f5041i != null) {
                            this.f5041i.disconnect();
                        }
                        throw th;
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e11) {
                    }
                }
                if (out != null) {
                    out.close();
                }
                if (this.f5041i != null) {
                    this.f5041i.disconnect();
                }
            } catch (MalformedURLException e12) {
                e = e12;
                m5927a(C1634b.ERROR, C1633a.ERROR_HTTP);
                e.printStackTrace();
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (this.f5041i == null) {
                    this.f5041i.disconnect();
                }
            } catch (IOException e13) {
                e2 = e13;
                m5927a(C1634b.ERROR, C1633a.ERROR_HTTP);
                e2.printStackTrace();
                LogUtil.m4445e(f5034b, "IOException");
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (this.f5041i == null) {
                    this.f5041i.disconnect();
                }
            } catch (Exception e14) {
                e3 = e14;
                m5927a(C1634b.ERROR, C1633a.ERROR_HTTP);
                e3.printStackTrace();
                LogUtil.m4445e(f5034b, "OtherException");
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (this.f5041i == null) {
                    this.f5041i.disconnect();
                }
            }
        }
    }

    /* renamed from: h */
    protected void m5943h() {
        if (!m5939d()) {
            m5925a(100);
            m5927a(C1634b.SUCESS, C1633a.NO_ERROR);
            LogUtil.d(f5034b, this.f5039g.f5007d + ":下载成功");
        }
    }

    public String toString() {
        return this.f5039g.f5007d;
    }

    /* renamed from: a */
    public int m5934a(C1638i another) {
        int temp = another.m5938c().f5005b - this.f5039g.f5005b;
        if (temp == 0) {
            return (int) (this.f5039g.f5004a - another.m5938c().f5004a);
        }
        return temp;
    }
}
