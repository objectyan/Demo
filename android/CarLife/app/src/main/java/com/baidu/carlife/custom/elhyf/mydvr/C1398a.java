package com.baidu.carlife.custom.elhyf.mydvr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.custom.elhyf.mydvr.C1400b.C1399a;
import com.baidu.carlife.custom.elhyf.p073c.C1372a;
import com.baidu.carlife.custom.elhyf.p073c.C1376b;
import com.baidu.carlife.custom.elhyf.p073c.C1376b.C1374a;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.util.C2201w;
import com.baidu.mobstat.Config;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: MyDvrManager */
/* renamed from: com.baidu.carlife.custom.elhyf.mydvr.a */
public class C1398a {
    /* renamed from: a */
    public static String f4092a = C1398a.class.getSimpleName();
    /* renamed from: b */
    private static final int f4093b = 0;
    /* renamed from: c */
    private static final int f4094c = 1;
    /* renamed from: j */
    private static C1398a f4095j;
    /* renamed from: d */
    private ArrayList<C1400b> f4096d = new ArrayList();
    /* renamed from: e */
    private ArrayList<C1400b> f4097e = new ArrayList();
    /* renamed from: f */
    private ArrayList<C1382a> f4098f = new ArrayList();
    /* renamed from: g */
    private Context f4099g;
    /* renamed from: h */
    private Thread f4100h;
    /* renamed from: i */
    private Handler f4101i = new C13951(this);
    /* renamed from: k */
    private C1374a f4102k = new C13973(this);

    /* compiled from: MyDvrManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.a$a */
    public interface C1382a {
        /* renamed from: a */
        void mo1543a(ArrayList<C1400b> arrayList);

        /* renamed from: b */
        void mo1544b(ArrayList<C1400b> arrayList);
    }

    /* compiled from: MyDvrManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.a$1 */
    class C13951 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1398a f4089a;

        C13951(C1398a this$0) {
            this.f4089a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    this.f4089a.f4096d = (ArrayList) msg.obj;
                    this.f4089a.m5148e();
                    return;
                case 1:
                    this.f4089a.f4097e = (ArrayList) msg.obj;
                    this.f4089a.m5149f();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: MyDvrManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.a$2 */
    class C13962 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1398a f4090a;

        C13962(C1398a this$0) {
            this.f4090a = this$0;
        }

        public void run() {
            int i = 0;
            File videoPath = new File(C1376b.f4015d);
            if (!this.f4090a.f4096d.isEmpty()) {
                this.f4090a.f4096d.clear();
            }
            if (videoPath.listFiles().length > 0) {
                for (File file : videoPath.listFiles()) {
                    File file2;
                    if (this.f4090a.m5146d(file2.getName())) {
                        C1400b speech = new C1400b();
                        speech.m5163a(file2.getName());
                        speech.m5165b(this.f4090a.m5128a(file2.getName()));
                        speech.m5171e(this.f4090a.m5134b(file2.getName()));
                        speech.m5167c(this.f4090a.m5126a(file2.length()));
                        speech.m5169d(file2.getPath());
                        speech.m5162a(this.f4090a.m5138c(file2.getName()));
                        this.f4090a.f4096d.add(speech);
                    }
                }
                Collections.sort(this.f4090a.f4096d);
                Message msg = new Message();
                msg.what = 0;
                msg.obj = this.f4090a.f4096d;
                this.f4090a.f4101i.sendMessage(msg);
            }
            File photoPath = new File(C1376b.f4014c);
            if (!this.f4090a.f4097e.isEmpty()) {
                this.f4090a.f4097e.clear();
            }
            if (photoPath.listFiles().length > 0) {
                File[] listFiles = photoPath.listFiles();
                int length = listFiles.length;
                while (i < length) {
                    file2 = listFiles[i];
                    if (this.f4090a.m5146d(file2.getName())) {
                        speech = new C1400b();
                        speech.m5163a(file2.getName());
                        speech.m5165b(this.f4090a.m5128a(file2.getName()));
                        speech.m5171e(this.f4090a.m5134b(file2.getName()));
                        speech.m5167c(this.f4090a.m5126a(file2.length()));
                        speech.m5169d(file2.getPath());
                        speech.m5162a(this.f4090a.m5138c(file2.getName()));
                        this.f4090a.f4097e.add(speech);
                    }
                    i++;
                }
                Collections.sort(this.f4090a.f4097e);
                msg = new Message();
                msg.what = 1;
                msg.obj = this.f4090a.f4097e;
                this.f4090a.f4101i.sendMessage(msg);
            }
        }
    }

    /* compiled from: MyDvrManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.a$3 */
    class C13973 implements C1374a {
        /* renamed from: a */
        final /* synthetic */ C1398a f4091a;

        C13973(C1398a this$0) {
            this.f4091a = this$0;
        }

        /* renamed from: a */
        public void mo1547a(C1372a receiveData) {
        }

        /* renamed from: b */
        public void mo1549b(C1372a receiveData) {
            if (this.f4091a.m5146d(receiveData.m5026c())) {
                C1400b speech = new C1400b();
                speech.m5163a(receiveData.m5026c());
                speech.m5165b(this.f4091a.m5128a(receiveData.m5026c()));
                speech.m5171e(this.f4091a.m5134b(receiveData.m5026c()));
                speech.m5167c(this.f4091a.m5126a(receiveData.m5028e().length()));
                speech.m5169d(receiveData.m5028e().getPath());
                speech.m5162a(this.f4091a.m5138c(receiveData.m5026c()));
                if (receiveData.m5024b() == DataType.Video) {
                    this.f4091a.m5141c(speech);
                    this.f4091a.f4096d.add(speech);
                    Collections.sort(this.f4091a.f4096d);
                    this.f4091a.m5148e();
                } else if (receiveData.m5024b() == DataType.Photo) {
                    this.f4091a.m5145d(speech);
                    this.f4091a.f4097e.add(speech);
                    Collections.sort(this.f4091a.f4097e);
                    this.f4091a.m5149f();
                }
            }
        }

        /* renamed from: c */
        public void mo1550c(C1372a receiveData) {
        }

        /* renamed from: a */
        public void mo1548a(C1372a receiveData, int progress) {
        }
    }

    private C1398a() {
    }

    /* renamed from: a */
    public static C1398a m5125a() {
        if (f4095j == null) {
            f4095j = new C1398a();
        }
        return f4095j;
    }

    /* renamed from: a */
    public void m5150a(Context context) {
        this.f4099g = context;
        m5144d();
        C1376b.m5035a().m5058a(this.f4102k);
    }

    /* renamed from: b */
    public ArrayList<C1400b> m5154b() {
        return this.f4096d;
    }

    /* renamed from: c */
    public ArrayList<C1400b> m5158c() {
        return this.f4097e;
    }

    /* renamed from: a */
    public void m5153a(C1400b speech) {
        File file = new File(speech.m5170e());
        if (file.exists()) {
            file.delete();
            this.f4096d.remove(speech);
            m5148e();
        }
    }

    /* renamed from: b */
    public void m5157b(C1400b speech) {
        File file = new File(speech.m5170e());
        if (file.exists()) {
            file.delete();
            this.f4097e.remove(speech);
            m5149f();
        }
    }

    /* renamed from: d */
    private void m5144d() {
        this.f4100h = new Thread(new C13962(this));
        this.f4100h.start();
    }

    /* renamed from: a */
    public void m5152a(C1382a listener) {
        if (!this.f4098f.contains(listener)) {
            this.f4098f.add(listener);
        }
    }

    /* renamed from: b */
    public void m5156b(C1382a listener) {
        this.f4098f.remove(listener);
    }

    /* renamed from: e */
    private void m5148e() {
        ArrayList<C1382a> listeners = new ArrayList(this.f4098f);
        for (int i = 0; i < listeners.size(); i++) {
            ((C1382a) listeners.get(i)).mo1543a(m5154b());
        }
    }

    /* renamed from: f */
    private void m5149f() {
        ArrayList<C1382a> listeners = new ArrayList(this.f4098f);
        for (int i = 0; i < listeners.size(); i++) {
            ((C1382a) listeners.get(i)).mo1544b(m5158c());
        }
    }

    /* renamed from: a */
    private String m5128a(String fileName) {
        try {
            String data = "";
            if (fileName.length() >= 4) {
                data = fileName.substring(0, 4) + "/";
            }
            if (fileName.length() >= 6) {
                data = data + fileName.substring(4, 6) + "/";
            }
            if (fileName.length() >= 8) {
                return data + fileName.substring(4, 8);
            }
            return data;
        } catch (Exception e) {
            return "unknown";
        }
    }

    /* renamed from: b */
    private String m5134b(String fileName) {
        try {
            String hour = "";
            if (fileName.length() >= 11) {
                hour = fileName.substring(9, 11) + Config.TRACE_TODAY_VISIT_SPLIT;
            }
            if (fileName.length() >= 13) {
                hour = hour + fileName.substring(11, 13) + Config.TRACE_TODAY_VISIT_SPLIT;
            }
            if (fileName.length() >= 15) {
                return hour + fileName.substring(11, 15);
            }
            return hour;
        } catch (Exception e) {
            return "unknown";
        }
    }

    /* renamed from: a */
    private String m5126a(long size) {
        if (size < 0) {
            size = 0;
        }
        return new DecimalFormat("0.0").format((double) ((((float) size) / 1024.0f) / 1024.0f));
    }

    /* renamed from: a */
    public void m5151a(Context context, String filePath) {
        try {
            File file = new File(filePath);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "image/*");
            context.startActivity(intent);
        } catch (Exception e) {
            C2201w.m8373a(context.getString(C0965R.string.home_my_mydvr_no_play_video), 1);
        }
    }

    /* renamed from: b */
    public void m5155b(Context context, String filePath) {
        try {
            File file = new File(filePath);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "video/*");
            context.startActivity(intent);
        } catch (Exception e) {
            C2201w.m8373a(context.getString(C0965R.string.home_my_mydvr_no_open_photo), 1);
        }
    }

    /* renamed from: c */
    private void m5141c(C1400b receivedFileSpeech) {
        Iterator it = this.f4096d.iterator();
        while (it.hasNext()) {
            C1400b speech = (C1400b) it.next();
            if (speech.m5164b().equals(receivedFileSpeech.m5164b())) {
                this.f4096d.remove(speech);
                return;
            }
        }
    }

    /* renamed from: d */
    private void m5145d(C1400b receivedFileSpeech) {
        Iterator it = this.f4097e.iterator();
        while (it.hasNext()) {
            C1400b speech = (C1400b) it.next();
            if (speech.m5164b().equals(receivedFileSpeech.m5164b())) {
                this.f4097e.remove(speech);
                return;
            }
        }
    }

    /* renamed from: c */
    private C1399a m5138c(String fileName) {
        try {
            if (fileName.charAt(15) == 'B') {
                return C1399a.Back_Camera;
            }
            return C1399a.Front_Camera;
        } catch (Exception e) {
            return C1399a.Front_Camera;
        }
    }

    /* renamed from: d */
    private boolean m5146d(String fileName) {
        return Pattern.compile("[0-9]{8}_[0-9]{6}(A|B)(.jpg|.mpg)").matcher(fileName).matches();
    }
}
