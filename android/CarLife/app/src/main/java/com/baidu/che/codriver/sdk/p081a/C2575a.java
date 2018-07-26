package com.baidu.che.codriver.sdk.p081a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.che.codriver.C2510a;
import com.baidu.che.codriver.p115a.C2505a;
import com.baidu.che.codriver.p122h.C2537a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2737q;
import com.baidu.che.codriver.vr.C2571b;
import com.baidu.che.codriver.vr.C2836l;
import com.baidu.che.codriver.vr.C2840n;
import com.baidu.che.codriver.vr.C2840n.C2839a;
import com.baidu.che.codriver.vr.C2847o;
import com.baidu.che.codriver.vr.C2847o.C1905a;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CdAsrManager */
/* renamed from: com.baidu.che.codriver.sdk.a.a */
public class C2575a {
    /* renamed from: a */
    public static final String f8541a = "CdAsrManager";
    /* renamed from: b */
    public static final String f8542b = ",";
    /* renamed from: c */
    private List<C1979b> f8543c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private Context f8544d;
    /* renamed from: e */
    private String f8545e;
    /* renamed from: f */
    private String f8546f = "小度小度";
    /* renamed from: g */
    private String f8547g = "";
    /* renamed from: h */
    private boolean f8548h = false;
    /* renamed from: i */
    private HashMap<String, String> f8549i = new HashMap(32);
    /* renamed from: j */
    private C2573a f8550j;

    /* compiled from: CdAsrManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.a$b */
    public static abstract class C1979b {
        private Map<String, String> mCmdMap = new HashMap();

        public abstract void onCommand(String str, String str2);

        public C1979b addCommand(String type, String... cmds) {
            StringBuilder sb = new StringBuilder();
            for (String cmd : cmds) {
                sb.append(cmd);
                sb.append(",");
            }
            this.mCmdMap.put(type, sb.toString());
            return this;
        }

        private String getQuery() {
            StringBuilder sb = new StringBuilder();
            for (String cmd : this.mCmdMap.values()) {
                sb.append(cmd);
            }
            return sb.toString();
        }

        private void handleSceneCmd(String word) {
            String cmd = "," + word + ",";
            for (String cmdType : this.mCmdMap.keySet()) {
                if (("," + ((String) this.mCmdMap.get(cmdType))).contains(cmd)) {
                    onCommand(cmdType, word);
                }
            }
        }
    }

    /* compiled from: CdAsrManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.a$2 */
    class C25722 implements C2571b {
        /* renamed from: a */
        final /* synthetic */ C2575a f8539a;

        C25722(C2575a this$0) {
            this.f8539a = this$0;
        }

        /* renamed from: a */
        public void mo1885a(String word) {
            C2725h.m10207b(C2575a.f8541a, "handleSceneCmd: " + word);
            for (C1979b command : this.f8539a.f8543c) {
                command.handleSceneCmd(word);
            }
            this.f8539a.m9711a(word);
        }
    }

    /* compiled from: CdAsrManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.a$a */
    public interface C2573a {
        /* renamed from: a */
        void m9706a();

        /* renamed from: b */
        void m9707b();
    }

    /* compiled from: CdAsrManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.a$c */
    private static class C2574c {
        /* renamed from: a */
        private static C2575a f8540a = new C2575a();

        private C2574c() {
        }
    }

    /* renamed from: a */
    public static C2575a m9709a() {
        return C2574c.f8540a;
    }

    /* renamed from: a */
    public void m9727a(Context context, final C1905a listener) {
        this.f8544d = context;
        m9720i();
        m9712a(true, "WakeUp_Xiaodu.bin", this.f8544d.getFilesDir().getPath() + "/" + C2510a.f8208y);
        this.f8545e = m9724m();
        C2725h.m10207b(f8541a, "wake up words: " + this.f8545e);
        m9725n();
        C2537a.m9625a().m9626a(this.f8544d);
        C2847o.m10687a().m10730a(this.f8544d, C2674b.m9985b(), new C1905a(this) {
            /* renamed from: b */
            final /* synthetic */ C2575a f8538b;

            /* renamed from: a */
            public void mo1712a() {
                this.f8538b.f8548h = true;
                C2725h.m10207b(C2575a.f8541a, "onInitSuccess: " + this.f8538b.f8548h);
                C2847o.m10687a().m10744b(this.f8538b.m9722k(), this.f8538b.m9723l());
                if (listener != null) {
                    listener.mo1712a();
                }
            }
        });
    }

    /* renamed from: b */
    public boolean m9733b() {
        return this.f8548h;
    }

    /* renamed from: c */
    public void m9734c() {
        C2674b.m9985b().m10043t();
    }

    /* renamed from: d */
    public void m9735d() {
        C2674b.m9985b().mo1925a();
    }

    /* renamed from: a */
    public void m9729a(C1979b sceneCommand) {
        if (!this.f8548h || this.f8543c.contains(sceneCommand)) {
            C2725h.m10207b(f8541a, "registerSceneCommand error: " + this.f8548h);
            return;
        }
        this.f8543c.add(sceneCommand);
        C2847o.m10687a().m10732a(new C2836l(m9721j(), new C25722(this)));
    }

    /* renamed from: a */
    private void m9711a(String word) {
        String strEvent = (String) this.f8549i.get(word);
        if (strEvent != null) {
            StatisticManager.onEvent(strEvent);
            Log.d("#######", "####### Statistic [" + strEvent + " : " + word + "]");
        }
    }

    /* renamed from: i */
    private void m9720i() {
        long lstarttime = System.currentTimeMillis();
        this.f8549i.put("白天模式", StatisticConstants.VOICE_SCENE_0001);
        this.f8549i.put("黑夜模式", StatisticConstants.VOICE_SCENE_0002);
        this.f8549i.put("关闭电子狗", StatisticConstants.VOICE_SCENE_0003);
        this.f8549i.put("打开电子狗", StatisticConstants.VOICE_SCENE_0004);
        this.f8549i.put("打开路况", StatisticConstants.VOICE_SCENE_0005);
        this.f8549i.put("关闭路况", StatisticConstants.VOICE_SCENE_0006);
        this.f8549i.put("放大地图", StatisticConstants.VOICE_SCENE_0007);
        this.f8549i.put("缩小地图", StatisticConstants.VOICE_SCENE_0008);
        this.f8549i.put("取消", StatisticConstants.VOICE_SCENE_0009);
        this.f8549i.put("确定", StatisticConstants.VOICE_SCENE_0010);
        this.f8549i.put("跟随模式", StatisticConstants.VOICE_SCENE_0011);
        this.f8549i.put("车头朝上", StatisticConstants.VOICE_SCENE_0012);
        this.f8549i.put("正北模式", StatisticConstants.VOICE_SCENE_0013);
        this.f8549i.put("查看全程", StatisticConstants.VOICE_SCENE_0014);
        this.f8549i.put(FsmEvent.CONTINUE_NAVI, StatisticConstants.VOICE_SCENE_0015);
        this.f8549i.put("关闭导航", StatisticConstants.VOICE_SCENE_0016);
        this.f8549i.put("结束导航", StatisticConstants.VOICE_SCENE_0017);
        this.f8549i.put("开始导航", StatisticConstants.VOICE_SCENE_0018);
        this.f8549i.put("第一个", StatisticConstants.VOICE_SCENE_0019);
        this.f8549i.put("第二个", StatisticConstants.VOICE_SCENE_0020);
        this.f8549i.put("第三个", StatisticConstants.VOICE_SCENE_0021);
        this.f8549i.put("播放音乐", StatisticConstants.VOICE_SCENE_0022);
        this.f8549i.put("暂停播放", StatisticConstants.VOICE_SCENE_0023);
        this.f8549i.put(StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PRE, StatisticConstants.VOICE_SCENE_0024);
        this.f8549i.put("上一曲", StatisticConstants.VOICE_SCENE_0025);
        this.f8549i.put(StatisticConstants.HOME_MUSIC_STATUS_CHANGE_NEXT, StatisticConstants.VOICE_SCENE_0026);
        this.f8549i.put("下一曲", StatisticConstants.VOICE_SCENE_0027);
        this.f8549i.put("继续播放", StatisticConstants.VOICE_SCENE_0028);
        Long time = Long.valueOf(System.currentTimeMillis() - lstarttime);
    }

    /* renamed from: j */
    private String m9721j() {
        StringBuilder sb = new StringBuilder();
        for (C1979b cmd : this.f8543c) {
            sb.append(cmd.getQuery());
        }
        return sb.toString();
    }

    /* renamed from: b */
    public void m9732b(C1979b sceneCommand) {
        this.f8543c.remove(sceneCommand);
        if (this.f8543c.isEmpty()) {
            C2847o.m10687a().m10742b();
        }
    }

    /* renamed from: a */
    public void m9730a(String param, String data) {
        C2725h.m10207b(f8541a, "param:" + param + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8621g, param, data);
    }

    /* renamed from: a */
    public boolean m9731a(String word, boolean replaceable) {
        if (this.f8545e == null || !this.f8545e.contains(word)) {
            C2725h.m10207b(f8541a, "addWakeUpWrd: " + word);
            if (replaceable) {
                this.f8547g = word;
                m9716b(this.f8546f + "," + this.f8547g);
            } else {
                this.f8546f += "," + word;
                m9716b(this.f8546f);
            }
            C2725h.m10207b(f8541a, "wake up words: " + this.f8545e);
            return true;
        }
        C2725h.m10207b(f8541a, word + " already exists");
        return false;
    }

    /* renamed from: e */
    public void m9736e() {
        this.f8547g = "";
        m9716b(this.f8546f);
    }

    /* renamed from: b */
    private void m9716b(String words) {
        this.f8545e = words;
        m9718c(words);
        C2847o.m10687a().m10744b(m9722k(), m9723l());
    }

    /* renamed from: f */
    public boolean m9737f() {
        if (TextUtils.isEmpty(this.f8547g)) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    public String m9738g() {
        return this.f8547g;
    }

    /* renamed from: k */
    private String m9722k() {
        return this.f8544d.getFilesDir().getPath() + "/" + C2510a.f8208y;
    }

    /* renamed from: l */
    private String m9723l() {
        if (this.f8545e.equals("小度小度")) {
            return this.f8544d.getApplicationInfo().nativeLibraryDir + C2510a.f8181H;
        }
        return this.f8544d.getApplicationInfo().nativeLibraryDir + C2510a.f8180G;
    }

    /* renamed from: a */
    private void m9712a(boolean isCover, String source, String dest) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        File file = new File(dest);
        if (isCover || !(isCover || file.exists())) {
            InputStream inputStream = null;
            FileOutputStream fos = null;
            try {
                inputStream = this.f8544d.getResources().getAssets().open(source);
                FileOutputStream fos2 = new FileOutputStream(file);
                try {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int size = inputStream.read(buffer, 0, 1024);
                        if (size < 0) {
                            break;
                        }
                        fos2.write(buffer, 0, size);
                    }
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e2 = e4;
                    fos = fos2;
                    try {
                        e2.printStackTrace();
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3222) {
                                e3222.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e32222) {
                                e32222.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e322222) {
                                e322222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e322222 = e5;
                    fos = fos2;
                    e322222.printStackTrace();
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3222222) {
                            e3222222.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e32222222) {
                            e32222222.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fos = fos2;
                    if (fos != null) {
                        fos.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e2 = e6;
                e2.printStackTrace();
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e7) {
                e32222222 = e7;
                e32222222.printStackTrace();
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
    }

    /* renamed from: m */
    private String m9724m() {
        try {
            return C2737q.m10256a(new File(this.f8544d.getFilesDir().getPath() + "/" + C2510a.f8208y));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    private void m9718c(String wakeUpWords) {
        FileOutputStream fos = null;
        try {
            fos = this.f8544d.openFileOutput(C2510a.f8208y, 0);
            fos.write(C2737q.m10259a(wakeUpWords));
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e322) {
                    e322.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void m9728a(C2573a tool) {
        this.f8550j = tool;
    }

    /* renamed from: h */
    public C2573a m9739h() {
        return this.f8550j;
    }

    /* renamed from: n */
    private void m9725n() {
        C2840n.m10677c(C2505a.m9514d());
        C2840n.m10673b(C2505a.m9513c());
        C2840n.m10669a(C2839a.DEBUG);
        C2716c.m10150b("5");
        C2840n.m10671a(true);
        C2840n.m10670a("https://vehicle.baidu.com/codriverapi");
        C2725h.m10207b(f8541a, "Url:" + C2840n.m10678d());
    }

    /* renamed from: o */
    private void m9726o() {
        C2840n.m10677c(C2505a.m9514d());
        C2840n.m10673b(C2505a.m9513c());
        C2840n.m10669a(C2839a.DEBUG);
        C2716c.m10150b("5");
        C2716c.m10153c("test");
        C2840n.m10671a(true);
        C2840n.m10670a("http://sandbox.codriverapi.baidu.com/codriverapi");
        C2725h.m10207b(f8541a, "SandboxNlp Url:" + C2840n.m10678d());
    }
}
