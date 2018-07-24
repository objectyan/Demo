package com.baidu.carlife.custom.elhyf.p073c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeTransferDataFinishProto.CarlifeTransferDataFinish;
import com.baidu.carlife.protobuf.CarlifeTransferDataSendProto.CarlifeTransferDataSend;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.Builder;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.protobuf.CarlifeTransferDataStopProto.CarlifeTransferDataStop;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: TransferDataManager */
/* renamed from: com.baidu.carlife.custom.elhyf.c.d */
public class C1381d {
    /* renamed from: b */
    private static final String f4034b = C1381d.class.getSimpleName();
    /* renamed from: c */
    private static final int f4035c = 30720;
    /* renamed from: d */
    private static final int f4036d = 30;
    /* renamed from: e */
    private static int f4037e = 0;
    /* renamed from: f */
    private static final int f4038f = 0;
    /* renamed from: g */
    private static final int f4039g = 1;
    /* renamed from: h */
    private static final int f4040h = 2;
    /* renamed from: i */
    private static final int f4041i = 3;
    /* renamed from: o */
    private static C1381d f4042o;
    /* renamed from: a */
    final Handler f4043a = new C13803(this);
    /* renamed from: j */
    private Context f4044j;
    /* renamed from: k */
    private boolean f4045k = true;
    /* renamed from: l */
    private boolean f4046l = false;
    /* renamed from: m */
    private LinkedBlockingQueue<C1377c> f4047m = new LinkedBlockingQueue();
    /* renamed from: n */
    private Thread f4048n;
    /* renamed from: p */
    private Runnable f4049p = new C13781(this);
    /* renamed from: q */
    private MsgBaseHandler f4050q = new C13792(this);

    /* compiled from: TransferDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.d$a */
    public interface C1359a {
        /* renamed from: a */
        void mo1531a();

        /* renamed from: a */
        void mo1532a(int i);

        /* renamed from: b */
        void mo1533b();

        /* renamed from: c */
        void mo1534c();
    }

    /* compiled from: TransferDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.d$1 */
    class C13781 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1381d f4031a;

        C13781(C1381d this$0) {
            this.f4031a = this$0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r18 = this;
        L_0x0000:
            r0 = r18;
            r14 = r0.f4031a;
            r14 = r14.f4045k;
            if (r14 == 0) goto L_0x00fc;
        L_0x000a:
            r11 = 0;
            r0 = r18;
            r14 = r0.f4031a;	 Catch:{ InterruptedException -> 0x0051 }
            r14 = r14.f4047m;	 Catch:{ InterruptedException -> 0x0051 }
            r14 = r14.take();	 Catch:{ InterruptedException -> 0x0051 }
            r0 = r14;
            r0 = (com.baidu.carlife.custom.elhyf.p073c.C1377c) r0;	 Catch:{ InterruptedException -> 0x0051 }
            r11 = r0;
        L_0x001b:
            r7 = com.baidu.carlife.custom.elhyf.p073c.C1381d.m5081b();
            r6 = r11.m5060a();
            r13 = r11.m5065b();
            r12 = r11.m5066c();
            r8 = r11.m5067d();
            r10 = 0;
            r10 = r8.available();	 Catch:{ IOException -> 0x0056 }
        L_0x0034:
            r0 = r18;
            r14 = r0.f4031a;
            r14 = r14.m5069a(r7, r13, r10, r6);
            r15 = -1;
            if (r14 != r15) goto L_0x005b;
        L_0x003f:
            r14 = com.baidu.carlife.custom.elhyf.p073c.C1381d.f4034b;
            r15 = "start send file fail";
            com.baidu.carlife.core.LogUtil.d(r14, r15);
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5088c(r12);
            goto L_0x0000;
        L_0x0051:
            r4 = move-exception;
            r4.printStackTrace();
            goto L_0x001b;
        L_0x0056:
            r4 = move-exception;
            r4.printStackTrace();
            goto L_0x0034;
        L_0x005b:
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5075a(r12);
            r0 = r18;
            r14 = r0.f4031a;
            r15 = 0;
            r14.f4046l = r15;
            r2 = 0;
            r5 = 30720; // 0x7800 float:4.3048E-41 double:1.51777E-319;
            r14 = 30720; // 0x7800 float:4.3048E-41 double:1.51777E-319;
            r3 = new byte[r14];
        L_0x0071:
            r5 = r8.read(r3);	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r14 = -1;
            if (r5 == r14) goto L_0x0083;
        L_0x0078:
            r0 = r18;
            r14 = r0.f4031a;	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r14 = r14.m5091a(r7, r3, r5);	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r15 = -1;
            if (r14 != r15) goto L_0x00a3;
        L_0x0083:
            r8.close();	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
        L_0x0086:
            if (r2 != r10) goto L_0x00ec;
        L_0x0088:
            r0 = r18;
            r14 = r0.f4031a;
            r14 = r14.m5068a(r7);
            r15 = -1;
            if (r14 != r15) goto L_0x00e3;
        L_0x0093:
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5082b(r7);
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5088c(r12);
            goto L_0x0000;
        L_0x00a3:
            r2 = r2 + r5;
            r14 = (double) r2;
            r16 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
            r14 = r14 * r16;
            r0 = (double) r10;
            r16 = r0;
            r14 = r14 / r16;
            r16 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
            r14 = r14 * r16;
            r9 = (int) r14;
            r0 = r18;
            r14 = r0.f4031a;	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r14.m5076a(r12, r9);	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r0 = r18;
            r14 = r0.f4031a;	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r14 = r14.f4046l;	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            if (r14 == 0) goto L_0x00d8;
        L_0x00c4:
            r0 = r18;
            r14 = r0.f4031a;	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r14.m5082b(r7);	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r0 = r18;
            r14 = r0.f4031a;	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            r14.m5088c(r12);	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            goto L_0x0083;
        L_0x00d3:
            r4 = move-exception;
            r4.printStackTrace();
            goto L_0x0086;
        L_0x00d8:
            r14 = 30;
            java.lang.Thread.sleep(r14);	 Catch:{ InterruptedException -> 0x00d3, IOException -> 0x00de }
            goto L_0x0071;
        L_0x00de:
            r4 = move-exception;
            r4.printStackTrace();
            goto L_0x0086;
        L_0x00e3:
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5085b(r12);
            goto L_0x0000;
        L_0x00ec:
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5082b(r7);
            r0 = r18;
            r14 = r0.f4031a;
            r14.m5088c(r12);
            goto L_0x0000;
        L_0x00fc:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.custom.elhyf.c.d.1.run():void");
        }
    }

    /* compiled from: TransferDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.d$2 */
    class C13792 extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C1381d f4032a;

        C13792(C1381d this$0) {
            this.f4032a = this$0;
        }

        public void careAbout() {
            addMsg(CommonParams.f3548O);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CommonParams.f3548O /*458757*/:
                    this.f4032a.f4046l = true;
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: TransferDataManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.c.d$3 */
    class C13803 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1381d f4033a;

        C13803(C1381d this$0) {
            this.f4033a = this$0;
        }

        public void handleMessage(Message message) {
            C1359a listener = null;
            Object[] response = (Object[]) message.obj;
            if (response != null) {
                listener = response[0];
            }
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (listener != null) {
                        listener.mo1531a();
                        return;
                    }
                    return;
                case 1:
                    if (listener != null) {
                        listener.mo1533b();
                        return;
                    }
                    return;
                case 2:
                    if (listener != null) {
                        listener.mo1534c();
                        return;
                    }
                    return;
                case 3:
                    if (listener != null && response != null) {
                        listener.mo1532a(((Integer) response[1]).intValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m5081b() {
        int i = f4037e;
        f4037e = i + 1;
        return i;
    }

    private C1381d() {
    }

    /* renamed from: a */
    public static C1381d m5073a() {
        if (f4042o == null) {
            f4042o = new C1381d();
        }
        return f4042o;
    }

    /* renamed from: a */
    public void m5092a(Context context) {
        this.f4044j = context;
        MsgHandlerCenter.m4460a(this.f4050q);
        if (this.f4048n == null) {
            this.f4048n = new Thread(this.f4049p);
            this.f4048n.start();
        }
    }

    /* renamed from: a */
    public void m5094a(byte[] totalBuffer, String name, DataType type, C1359a transferDataListener) {
        if (C1663a.m5979a().m5993N()) {
            InputStream inputStream = new ByteArrayInputStream(totalBuffer);
            C1377c transferData = new C1377c();
            transferData.m5064a(name);
            transferData.m5062a(type);
            transferData.m5061a(transferDataListener);
            transferData.m5063a(inputStream);
            try {
                this.f4047m.put(transferData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m5093a(String filePath, DataType type, C1359a transferDataListener) {
        if (C1663a.m5979a().m5993N()) {
            try {
                File file = new File(filePath);
                if (file.exists()) {
                    InputStream inputStream = new FileInputStream(file);
                    C1377c transferData = new C1377c();
                    transferData.m5064a(file.getName());
                    transferData.m5062a(type);
                    transferData.m5061a(transferDataListener);
                    transferData.m5063a(inputStream);
                    this.f4047m.put(transferData);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private synchronized int m5069a(int id, DataType type, int len, String fileName) {
        int a;
        if (C1663a.m5979a().m5993N()) {
            Builder builder = CarlifeTransferDataStart.newBuilder();
            builder.setDataType(type);
            builder.setDataLen(len);
            builder.setDataName(fileName);
            builder.setFileId(id);
            CarlifeTransferDataStart proto = builder.build();
            CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
            msg.m4199b(proto.toByteArray());
            msg.m4203d(proto.getSerializedSize());
            msg.m4201c(CommonParams.f3544K);
            a = C1663a.m5979a().m6003a(msg);
        } else {
            a = -1;
        }
        return a;
    }

    /* renamed from: a */
    private synchronized int m5068a(int id) {
        int a;
        if (C1663a.m5979a().m5993N()) {
            CarlifeTransferDataFinish.Builder builder = CarlifeTransferDataFinish.newBuilder();
            builder.setFileId(id);
            CarlifeTransferDataFinish proto = builder.build();
            CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
            msg.m4199b(proto.toByteArray());
            msg.m4203d(proto.getSerializedSize());
            msg.m4201c(CommonParams.f3546M);
            a = C1663a.m5979a().m6003a(msg);
        } else {
            a = -1;
        }
        return a;
    }

    /* renamed from: a */
    public synchronized int m5091a(int id, byte[] data, int dataLen) {
        int a;
        if (C1663a.m5979a().m5993N()) {
            CarlifeTransferDataSend.Builder builder = CarlifeTransferDataSend.newBuilder();
            builder.setFileId(id);
            builder.setLen(dataLen);
            builder.setBodyData(ByteString.copyFrom(data));
            CarlifeTransferDataSend proto = builder.build();
            CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
            msg.m4199b(proto.toByteArray());
            msg.m4203d(proto.getSerializedSize());
            msg.m4201c(CommonParams.f3545L);
            a = C1663a.m5979a().m6003a(msg);
        } else {
            a = -1;
        }
        return a;
    }

    /* renamed from: b */
    private synchronized int m5082b(int id) {
        int a;
        if (C1663a.m5979a().m5993N()) {
            CarlifeTransferDataStop.Builder builder = CarlifeTransferDataStop.newBuilder();
            builder.setFileId(id);
            CarlifeTransferDataStop proto = builder.build();
            CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
            msg.m4199b(proto.toByteArray());
            msg.m4203d(proto.getSerializedSize());
            msg.m4201c(CommonParams.f3547N);
            a = C1663a.m5979a().m6003a(msg);
        } else {
            a = -1;
        }
        return a;
    }

    /* renamed from: a */
    private void m5074a(Message msg) {
        this.f4043a.sendMessage(msg);
    }

    /* renamed from: a */
    private Message m5072a(int messageId, Object messageData) {
        return Message.obtain(this.f4043a, messageId, messageData);
    }

    /* renamed from: a */
    private void m5075a(C1359a listener) {
        m5074a(m5072a(0, new Object[]{listener}));
    }

    /* renamed from: b */
    private void m5085b(C1359a listener) {
        m5074a(m5072a(1, new Object[]{listener}));
    }

    /* renamed from: c */
    private void m5088c(C1359a listener) {
        m5074a(m5072a(2, new Object[]{listener}));
    }

    /* renamed from: a */
    private void m5076a(C1359a listener, int progress) {
        m5074a(m5072a(3, new Object[]{listener, Integer.valueOf(progress)}));
    }
}
