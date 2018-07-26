package com.baidu.che.codriver.p115a;

import android.text.TextUtils;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: CommonConfig */
/* renamed from: com.baidu.che.codriver.a.a */
public class C2505a {
    /* renamed from: a */
    private static final String f8151a = "CoDriver";
    /* renamed from: b */
    private static final String f8152b = "cl";
    /* renamed from: c */
    private static final String f8153c = "D%k2tJ";
    /* renamed from: d */
    private static final String f8154d = "GmDW#U";
    /* renamed from: e */
    private String f8155e;
    /* renamed from: f */
    private String f8156f;
    /* renamed from: g */
    private String f8157g;
    /* renamed from: h */
    private String f8158h;

    /* compiled from: CommonConfig */
    /* renamed from: com.baidu.che.codriver.a.a$a */
    private static class C2504a {
        /* renamed from: a */
        private static final C2505a f8150a = new C2505a();

        private C2504a() {
        }
    }

    private C2505a() {
        m9516f();
    }

    /* renamed from: e */
    private static C2505a m9515e() {
        return C2504a.f8150a;
    }

    /* renamed from: a */
    public static String m9511a() {
        String channel = C2505a.m9515e().f8155e;
        return TextUtils.isEmpty(channel) ? f8151a : channel;
    }

    /* renamed from: b */
    public static String m9512b() {
        return "cl";
    }

    /* renamed from: c */
    public static String m9513c() {
        return f8153c;
    }

    /* renamed from: d */
    public static String m9514d() {
        return f8154d;
    }

    /* renamed from: a */
    public void m9518a(String channel) {
        this.f8155e = channel;
    }

    /* renamed from: f */
    private void m9516f() {
        m9517g();
    }

    /* renamed from: g */
    private void m9517g() {
        Exception e;
        Throwable th;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(C2716c.m10141a().getAssets().open("channel_config"));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                try {
                    String result = "";
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        result = result + line;
                    }
                    if (!TextUtils.isEmpty(result)) {
                        String[] configs = result.split(",");
                        if (configs != null && configs.length == 4) {
                            this.f8155e = configs[0];
                            this.f8156f = configs[1];
                            this.f8157g = configs[2];
                            this.f8158h = configs[3];
                            C2725h.m10210c("CommonConfig", "channel=" + this.f8155e);
                            C2725h.m10210c("CommonConfig", "ak=" + this.f8156f);
                            C2725h.m10210c("CommonConfig", "sign_key_prefix=" + this.f8157g);
                            C2725h.m10210c("CommonConfig", "sign_key_suffix=" + this.f8158h);
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                            bufferedReader = bufferedReader2;
                            inputStreamReader = inputStreamReader2;
                            return;
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            bufferedReader = bufferedReader2;
                            inputStreamReader = inputStreamReader2;
                            return;
                        }
                    }
                    inputStreamReader = inputStreamReader2;
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    inputStreamReader = inputStreamReader2;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        if (inputStreamReader == null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e222222) {
                                e222222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    inputStreamReader = inputStreamReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                inputStreamReader = inputStreamReader2;
                e.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader == null) {
                    inputStreamReader.close();
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = inputStreamReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader == null) {
                inputStreamReader.close();
            }
        }
    }
}
