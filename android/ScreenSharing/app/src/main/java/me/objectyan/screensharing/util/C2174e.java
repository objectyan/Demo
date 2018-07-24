package com.baidu.carlife.util;

import com.baidu.carlife.core.LogUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: CarlifeShell */
/* renamed from: com.baidu.carlife.util.e */
public class C2174e {
    /* renamed from: a */
    public static final String f6938a = "CarlifeShell";
    /* renamed from: b */
    private static C2174e f6939b = null;
    /* renamed from: c */
    private Runtime f6940c;

    /* renamed from: a */
    public static C2174e m8239a() {
        if (f6939b == null) {
            synchronized (C2174e.class) {
                if (f6939b == null) {
                    f6939b = new C2174e();
                }
            }
        }
        return f6939b;
    }

    private C2174e() {
        this.f6940c = null;
        this.f6940c = Runtime.getRuntime();
    }

    /* renamed from: a */
    public boolean m8240a(String cmd) {
        int exitVal = 1;
        LogUtil.d(f6938a, "exec: " + cmd);
        try {
            exitVal = this.f6940c.exec(cmd).waitFor();
        } catch (InterruptedException e) {
            LogUtil.m4445e(f6938a, "exec: " + cmd + " get InterruptedException");
            e.printStackTrace();
        } catch (IOException e2) {
            LogUtil.m4445e(f6938a, "exec: " + cmd + " get IOException");
            e2.printStackTrace();
        }
        LogUtil.d(f6938a, "exit value: " + exitVal);
        if (exitVal != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m8241b(String cmd) {
        LogUtil.d(f6938a, "exec: " + cmd);
        try {
            Process proc = this.f6940c.exec(cmd);
        } catch (IOException e) {
            LogUtil.m4445e(f6938a, "exec: " + cmd + " get IOException");
            e.printStackTrace();
        }
        LogUtil.d(f6938a, "exit value: " + 0);
        if (null != null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public BufferedReader m8242c(String cmd) {
        BufferedInputStream bufferedInputStream;
        InterruptedException e;
        IOException e2;
        int exitVal = 1;
        BufferedReader br = null;
        LogUtil.d(f6938a, "exec: " + cmd);
        try {
            Process proc = this.f6940c.exec(cmd);
            exitVal = proc.waitFor();
            BufferedInputStream in = new BufferedInputStream(proc.getInputStream());
            try {
                br = new BufferedReader(new InputStreamReader(in));
                bufferedInputStream = in;
            } catch (InterruptedException e3) {
                e = e3;
                bufferedInputStream = in;
                LogUtil.m4445e(f6938a, "exec: " + cmd + " get InterruptedException");
                e.printStackTrace();
                LogUtil.d(f6938a, "exit value: " + exitVal);
                if (exitVal != 0) {
                    return br;
                }
                return null;
            } catch (IOException e4) {
                e2 = e4;
                bufferedInputStream = in;
                LogUtil.m4445e(f6938a, "exec: " + cmd + " get IOException");
                e2.printStackTrace();
                LogUtil.d(f6938a, "exit value: " + exitVal);
                if (exitVal != 0) {
                    return null;
                }
                return br;
            }
        } catch (InterruptedException e5) {
            e = e5;
            LogUtil.m4445e(f6938a, "exec: " + cmd + " get InterruptedException");
            e.printStackTrace();
            LogUtil.d(f6938a, "exit value: " + exitVal);
            if (exitVal != 0) {
                return br;
            }
            return null;
        } catch (IOException e6) {
            e2 = e6;
            LogUtil.m4445e(f6938a, "exec: " + cmd + " get IOException");
            e2.printStackTrace();
            LogUtil.d(f6938a, "exit value: " + exitVal);
            if (exitVal != 0) {
                return null;
            }
            return br;
        }
        LogUtil.d(f6938a, "exit value: " + exitVal);
        if (exitVal != 0) {
            return null;
        }
        return br;
    }
}
