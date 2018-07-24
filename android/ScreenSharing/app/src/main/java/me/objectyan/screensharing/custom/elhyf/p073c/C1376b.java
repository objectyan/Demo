package com.baidu.carlife.custom.elhyf.p073c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeStopReceiveDataProto.CarlifeStopReceiveData;
import com.baidu.carlife.protobuf.CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Builder;
import com.baidu.carlife.protobuf.CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason;
import com.baidu.carlife.protobuf.CarlifeTransferDataFinishProto.CarlifeTransferDataFinish;
import com.baidu.carlife.protobuf.CarlifeTransferDataSendProto.CarlifeTransferDataSend;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.protobuf.CarlifeTransferDataStopProto.CarlifeTransferDataStop;
import com.baidu.carlife.util.C2201w;
import com.baidu.vi.VDeviceAPI;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ReceiveDataManager */
/* renamed from: com.baidu.carlife.custom.elhyf.c.b */
public class C1376b {
    /* renamed from: a */
    public static String f4012a = C1376b.class.getSimpleName();
    /* renamed from: b */
    public static final String f4013b = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeFile/Unknown");
    /* renamed from: c */
    public static final String f4014c = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeFile/Photo");
    /* renamed from: d */
    public static final String f4015d = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeFile/Video");
    /* renamed from: g */
    private static final int f4016g = 0;
    /* renamed from: h */
    private static final int f4017h = 1;
    /* renamed from: i */
    private static final int f4018i = 2;
    /* renamed from: j */
    private static final int f4019j = 3;
    /* renamed from: o */
    private static C1376b f4020o;
    /* renamed from: e */
    ArrayList<C1374a> f4021e = new ArrayList();
    /* renamed from: f */
    final Handler f4022f = new C13731(this);
    /* renamed from: k */
    private Context f4023k;
    /* renamed from: l */
    private Map<Integer, C1372a> f4024l = new HashMap();
    /* renamed from: m */
    private HandlerThread f4025m;
    /* renamed from: n */
    private MsgBaseHandler f4026n;

    /* compiled from: ReceiveDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.b$1 */
    class C13731 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1376b f4010a;

        C13731(C1376b this$0) {
            this.f4010a = this$0;
        }

        public void handleMessage(Message message) {
            Object[] response = (Object[]) message.obj;
            ArrayList<C1374a> listeners = new ArrayList(this.f4010a.f4021e);
            super.handleMessage(message);
            int i;
            switch (message.what) {
                case 0:
                    if (response != null) {
                        for (i = 0; i < listeners.size(); i++) {
                            ((C1374a) listeners.get(i)).mo1547a((C1372a) response[0]);
                        }
                        return;
                    }
                    return;
                case 1:
                    if (response != null) {
                        for (i = 0; i < listeners.size(); i++) {
                            ((C1374a) listeners.get(i)).mo1549b((C1372a) response[0]);
                        }
                        return;
                    }
                    return;
                case 2:
                    if (response != null) {
                        for (i = 0; i < listeners.size(); i++) {
                            ((C1374a) listeners.get(i)).mo1550c((C1372a) response[0]);
                        }
                        return;
                    }
                    return;
                case 3:
                    if (response != null) {
                        for (i = 0; i < listeners.size(); i++) {
                            ((C1374a) listeners.get(i)).mo1548a((C1372a) response[0], ((Integer) response[1]).intValue());
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ReceiveDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.b$a */
    public interface C1374a {
        /* renamed from: a */
        void mo1547a(C1372a c1372a);

        /* renamed from: a */
        void mo1548a(C1372a c1372a, int i);

        /* renamed from: b */
        void mo1549b(C1372a c1372a);

        /* renamed from: c */
        void mo1550c(C1372a c1372a);
    }

    /* compiled from: ReceiveDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.b$b */
    private class C1375b extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C1376b f4011a;

        public C1375b(C1376b c1376b, Looper looper) {
            this.f4011a = c1376b;
            super(looper);
        }

        public void careAbout() {
            addMsg(CommonParams.f3544K);
            addMsg(CommonParams.f3546M);
            addMsg(CommonParams.f3547N);
            addMsg(CommonParams.f3545L);
            addMsg(1002);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    if (this.f4011a.f4024l.size() != 0) {
                        for (Entry<Integer, C1372a> entry : this.f4011a.f4024l.entrySet()) {
                            this.f4011a.m5041a((C1372a) entry.getValue());
                        }
                    }
                    this.f4011a.f4024l.clear();
                    return;
                case CommonParams.f3544K /*458753*/:
                    LogUtil.d(C1376b.f4012a, "---------MSG_SEND_START---------");
                    this.f4011a.m5040a(msg);
                    return;
                case CommonParams.f3545L /*458754*/:
                    LogUtil.d(C1376b.f4012a, "---------MSG_SENDING_DATA---------");
                    this.f4011a.m5052d(msg);
                    return;
                case CommonParams.f3546M /*458755*/:
                    LogUtil.d(C1376b.f4012a, "---------MSG_SEND_FINISH---------");
                    this.f4011a.m5049c(msg);
                    return;
                case CommonParams.f3547N /*458756*/:
                    LogUtil.d(C1376b.f4012a, "---------MSG_SEND_STOP---------");
                    this.f4011a.m5046b(msg);
                    return;
                default:
                    return;
            }
        }
    }

    private C1376b() {
    }

    /* renamed from: a */
    public static C1376b m5035a() {
        if (f4020o == null) {
            f4020o = new C1376b();
        }
        return f4020o;
    }

    /* renamed from: a */
    public void m5056a(Context context) {
        this.f4023k = context;
        File file = new File(f4013b);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(f4014c);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(f4015d);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f4025m = new HandlerThread("ReceiveDataManager");
        this.f4025m.start();
        this.f4026n = new C1375b(this, this.f4025m.getLooper());
        MsgHandlerCenter.m4460a(this.f4026n);
    }

    /* renamed from: a */
    private void m5040a(Message msg) {
        try {
            CarlifeTransferDataStart startInfo = CarlifeTransferDataStart.parseFrom(msg.obj.m4205f());
            int id = startInfo.getFileId();
            DataType type = startInfo.getDataType();
            String fileName = startInfo.getDataName();
            int len = startInfo.getDataLen();
            String filePath = m5036a(type) + "/" + fileName;
            if (m5045a(filePath)) {
                m5033a(id, Reason.FileExisted);
                C2201w.m8373a(this.f4023k.getString(R.string.home_my_mydvr_toast_file_existed), 1);
                return;
            }
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            C1372a receiveData = new C1372a(id, type, fileName, len, file);
            this.f4024l.put(Integer.valueOf(id), receiveData);
            m5047b(receiveData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m5046b(Message msg) {
        try {
            int id = CarlifeTransferDataStop.parseFrom(msg.obj.m4205f()).getFileId();
            if (this.f4024l.containsKey(Integer.valueOf(id))) {
                m5041a((C1372a) this.f4024l.get(Integer.valueOf(id)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m5049c(Message msg) {
        try {
            int id = CarlifeTransferDataFinish.parseFrom(msg.obj.m4205f()).getFileId();
            if (this.f4024l.containsKey(Integer.valueOf(id))) {
                m5050c((C1372a) this.f4024l.get(Integer.valueOf(id)));
                m5057a(this.f4023k, ((C1372a) this.f4024l.get(Integer.valueOf(id))).m5028e().getAbsolutePath());
                m5038a(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m5052d(Message msg) {
        try {
            CarlifeTransferDataSend sendingInfo = CarlifeTransferDataSend.parseFrom(msg.obj.m4205f());
            int id = sendingInfo.getFileId();
            int len = sendingInfo.getLen();
            byte[] b = sendingInfo.getBodyData().toByteArray();
            if (this.f4024l.containsKey(Integer.valueOf(id))) {
                m5039a(id, b, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m5039a(int id, byte[] data, int len) {
        BufferedOutputStream bos;
        Exception e;
        Throwable th;
        if (((float) VDeviceAPI.getSdcardFreeSpace()) < ((float) len) / 1024.0f) {
            m5033a(id, Reason.NoSpace);
            C2201w.m8373a(this.f4023k.getString(R.string.home_my_mydvr_toast_no_space), 1);
        } else if (C1663a.m5979a().m5993N()) {
            int progress;
            int nTotalSize;
            File file = ((C1372a) this.f4024l.get(Integer.valueOf(id))).m5028e();
            BufferedOutputStream bos2 = null;
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(file, true);
                try {
                    bos = new BufferedOutputStream(fos2);
                } catch (Exception e2) {
                    e = e2;
                    fos = fos2;
                    try {
                        e.printStackTrace();
                        if (bos2 != null) {
                            try {
                                bos2.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        progress = 0;
                        nTotalSize = ((C1372a) this.f4024l.get(Integer.valueOf(id))).m5027d();
                        if (nTotalSize != 0) {
                            progress = (int) (((((double) file.length()) * 1.0d) / ((double) nTotalSize)) * 100.0d);
                        }
                        m5042a((C1372a) this.f4024l.get(Integer.valueOf(id)), progress);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bos2 != null) {
                            try {
                                bos2.close();
                            } catch (IOException e122) {
                                e122.printStackTrace();
                            }
                        }
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e1222) {
                                e1222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fos = fos2;
                    if (bos2 != null) {
                        bos2.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                    throw th;
                }
                try {
                    bos.write(data);
                    if (bos != null) {
                        try {
                            bos.close();
                        } catch (IOException e12222) {
                            e12222.printStackTrace();
                        }
                    }
                    if (fos2 != null) {
                        try {
                            fos2.close();
                            fos = fos2;
                            bos2 = bos;
                        } catch (IOException e122222) {
                            e122222.printStackTrace();
                            fos = fos2;
                            bos2 = bos;
                        }
                    } else {
                        bos2 = bos;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fos = fos2;
                    bos2 = bos;
                    e.printStackTrace();
                    if (bos2 != null) {
                        bos2.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                    progress = 0;
                    nTotalSize = ((C1372a) this.f4024l.get(Integer.valueOf(id))).m5027d();
                    if (nTotalSize != 0) {
                        progress = (int) (((((double) file.length()) * 1.0d) / ((double) nTotalSize)) * 100.0d);
                    }
                    m5042a((C1372a) this.f4024l.get(Integer.valueOf(id)), progress);
                } catch (Throwable th4) {
                    th = th4;
                    fos = fos2;
                    bos2 = bos;
                    if (bos2 != null) {
                        bos2.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (bos2 != null) {
                    bos2.close();
                }
                if (fos != null) {
                    fos.close();
                }
                progress = 0;
                nTotalSize = ((C1372a) this.f4024l.get(Integer.valueOf(id))).m5027d();
                if (nTotalSize != 0) {
                    progress = (int) (((((double) file.length()) * 1.0d) / ((double) nTotalSize)) * 100.0d);
                }
                m5042a((C1372a) this.f4024l.get(Integer.valueOf(id)), progress);
            }
            progress = 0;
            nTotalSize = ((C1372a) this.f4024l.get(Integer.valueOf(id))).m5027d();
            if (nTotalSize != 0) {
                progress = (int) (((((double) file.length()) * 1.0d) / ((double) nTotalSize)) * 100.0d);
            }
            m5042a((C1372a) this.f4024l.get(Integer.valueOf(id)), progress);
        }
    }

    /* renamed from: a */
    public void m5058a(C1374a listener) {
        if (!this.f4021e.contains(listener)) {
            this.f4021e.add(listener);
        }
    }

    /* renamed from: b */
    public void m5059b(C1374a listener) {
        this.f4021e.remove(listener);
    }

    /* renamed from: a */
    private void m5038a(int id) {
        Iterator<Entry<Integer, C1372a>> it = this.f4024l.entrySet().iterator();
        while (it.hasNext()) {
            if (((Integer) ((Entry) it.next()).getKey()).intValue() == id) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private void m5041a(C1372a receiveData) {
        if (receiveData != null) {
            File file = receiveData.m5028e();
            if (file.exists()) {
                file.delete();
                m5053d(receiveData);
                m5038a(receiveData.m5019a());
            }
        }
    }

    /* renamed from: a */
    private synchronized int m5033a(int id, Reason reason) {
        int a;
        if (C1663a.m5979a().m5993N()) {
            if (this.f4024l.containsKey(Integer.valueOf(id))) {
                m5041a((C1372a) this.f4024l.get(Integer.valueOf(id)));
            }
            Builder builder = CarlifeStopReceiveData.newBuilder();
            builder.setFileId(id);
            builder.setReason(reason);
            CarlifeStopReceiveData proto = builder.build();
            CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
            msg.m4199b(proto.toByteArray());
            msg.m4203d(proto.getSerializedSize());
            msg.m4201c(CommonParams.f3548O);
            a = C1663a.m5979a().m6003a(msg);
        } else {
            a = -1;
        }
        return a;
    }

    /* renamed from: a */
    private String m5036a(DataType type) {
        if (type == DataType.Photo) {
            return f4014c;
        }
        if (type == DataType.Video) {
            return f4015d;
        }
        return f4013b;
    }

    /* renamed from: a */
    private boolean m5045a(String filePath) {
        if (new File(filePath).exists()) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private void m5055e(Message msg) {
        this.f4022f.sendMessage(msg);
    }

    /* renamed from: a */
    private Message m5034a(int messageId, Object messageData) {
        return Message.obtain(this.f4022f, messageId, messageData);
    }

    /* renamed from: b */
    private void m5047b(C1372a receiveData) {
        m5055e(m5034a(0, new Object[]{receiveData}));
    }

    /* renamed from: c */
    private void m5050c(C1372a receiveData) {
        m5055e(m5034a(1, new Object[]{receiveData}));
    }

    /* renamed from: d */
    private void m5053d(C1372a receiveData) {
        m5055e(m5034a(2, new Object[]{receiveData}));
    }

    /* renamed from: a */
    private void m5042a(C1372a receiveData, int progress) {
        m5055e(m5034a(3, new Object[]{receiveData, Integer.valueOf(progress)}));
    }

    /* renamed from: a */
    public void m5057a(Context ctx, String filePath) {
        Intent scanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        scanIntent.setData(Uri.fromFile(new File(filePath)));
        ctx.sendBroadcast(scanIntent);
    }
}
