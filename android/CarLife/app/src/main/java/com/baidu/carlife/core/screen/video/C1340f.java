package com.baidu.carlife.core.screen.video;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.connect.C1215d;
import com.baidu.carlife.core.connect.C1218e;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.C0940j;
import com.baidu.carlife.core.screen.p053b.C1276f;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService;
import com.baidu.carlife.core.screen.presentation.p071a.C1299b;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.p087l.C1667d;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeVideoFrameRateProto.CarlifeVideoFrameRate;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: VideoMsgHandler */
/* renamed from: com.baidu.carlife.core.screen.video.f */
public class C1340f {
    /* renamed from: a */
    private static final String f3913a = "Recorder_MsgHandler";
    /* renamed from: b */
    private C0940j f3914b;
    /* renamed from: c */
    private C1339a f3915c = new C1339a(this, Looper.getMainLooper());

    /* compiled from: VideoMsgHandler */
    /* renamed from: com.baidu.carlife.core.screen.video.f$a */
    private class C1339a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1340f f3912a;

        public C1339a(C1340f c1340f, Looper looper) {
            this.f3912a = c1340f;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    if (C1190a.m4065a()) {
                        C1299b.m4626b().mo1355p();
                        C1260i.m4445e(C1340f.f3913a, "---------end internal screen capture.---------");
                    }
                    C1338e.m4826b().m4864b(false);
                    return;
                case C1253f.gM /*4009*/:
                    C1276f.m4515a().m4545c();
                    C1276f.m4515a().m4541b();
                    return;
                case C1253f.f3549P /*98311*/:
                    C1249d.m4331a().m4338a(msg);
                    C1261k.m4459a((int) C1253f.fm, msg.obj);
                    this.f3912a.m4899a(msg);
                    if (this.f3912a.f3914b != null) {
                        this.f3912a.f3914b.mo1346a(C1338e.m4828c(), C1338e.m4830d());
                    }
                    C1261k.m4453a((int) C1253f.gM, 2000);
                    if (C1218e.m4228a().m4240b() == 2 && VERSION.SDK_INT < 21) {
                        C1215d.m4207a().m4222a(false);
                        return;
                    } else if (C1667d.m6102a().m6115h()) {
                        this.f3912a.m4903a(C1192c.m4069a().m4095m());
                        return;
                    } else {
                        return;
                    }
                case C1253f.f3551R /*98313*/:
                    C1338e.m4826b().m4873g();
                    this.f3912a.m4905b();
                    return;
                case C1253f.f3552S /*98314*/:
                    C1338e.m4826b().m4871f();
                    return;
                case C1253f.f3553T /*98315*/:
                    this.f3912a.m4908c();
                    return;
                case C1253f.f3554U /*98316*/:
                    this.f3912a.m4906b(msg);
                    return;
                case C1253f.bc /*98390*/:
                    C1338e.m4826b().m4864b(true);
                    this.f3912a.m4896a();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(C1253f.bc);
            addMsg(C1253f.f3549P);
            addMsg(C1253f.f3551R);
            addMsg(C1253f.f3552S);
            addMsg(C1253f.f3553T);
            addMsg(C1253f.f3554U);
            addMsg(C1253f.gM);
            addMsg(1002);
        }
    }

    public C1340f() {
        C1261k.m4460a(this.f3915c);
    }

    /* renamed from: a */
    public void m4911a(C0940j listener) {
        this.f3914b = listener;
    }

    /* renamed from: a */
    private void m4903a(boolean isForegroud) {
        if (C1667d.m6102a().m6120m()) {
            C1212c command = new C1212c(true);
            if (isForegroud) {
                C1260i.m4435b(f3913a, "send foreground message");
                command.m4201c(C1253f.ao);
            } else {
                C1260i.m4435b(f3913a, "send background message");
                command.m4201c(C1253f.ap);
            }
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    private void m4896a() {
        C1663a.m5979a().m6026c((int) C1253f.bd);
    }

    /* renamed from: a */
    private void m4898a(int width, int height, int destFrameRate) {
        C1260i.m4435b("#######", "sendVideoSize: [" + height + " : " + width + " ]");
        C1212c command = new C1212c(true);
        command.m4201c(C1253f.f3550Q);
        Builder builder = CarlifeVideoEncoderInfo.newBuilder();
        builder.setWidth(width);
        builder.setHeight(height);
        builder.setFrameRate(destFrameRate);
        CarlifeVideoEncoderInfo videoInfo = builder.build();
        command.m4199b(videoInfo.toByteArray());
        command.m4203d(videoInfo.getSerializedSize());
        C1215d.m4207a().m4223a(Message.obtain(null, command.m4202d(), 1001, 0, command));
    }

    /* renamed from: a */
    private void m4899a(Message msg) {
        if (this.f3914b == null) {
            C1260i.m4445e(f3913a, "mOnStatusChangeListener == null");
            return;
        }
        try {
            boolean initCodecSucc;
            CarlifeVideoEncoderInfo initInfo = CarlifeVideoEncoderInfo.parseFrom(msg.obj.m4205f());
            int destWidth = initInfo.getWidth();
            int destHeight = initInfo.getHeight();
            int destFrameRate = initInfo.getFrameRate();
            C1260i.m4435b(f3913a, "VIDEO_ENCODER_INIT_INFO: [" + destWidth + " , " + destHeight + "]");
            if (C1338e.m4826b().m4879j()) {
                if (C1190a.m4065a()) {
                    initCodecSucc = C1338e.m4826b().m4867c(destWidth, destHeight, destFrameRate);
                    this.f3914b.mo1348o();
                } else {
                    initCodecSucc = C1338e.m4826b().m4861a(destWidth, destHeight, destFrameRate);
                }
            } else if (C1190a.m4065a()) {
                if (AbsCarlifeActivityService.m4601a()) {
                    C1260i.m4435b(f3913a, "####### initMediaCodec50: " + destWidth + " , " + destHeight);
                    initCodecSucc = C1338e.m4826b().m4860a(destWidth, destHeight);
                    this.f3914b.mo1348o();
                } else {
                    m4898a(C1338e.m4828c(), C1338e.m4830d(), destFrameRate);
                    return;
                }
            } else if (C1338e.m4826b().m4847N()) {
                initCodecSucc = C1338e.m4826b().m4860a(destWidth, destHeight);
                if (this.f3914b.mo1356q()) {
                    C1338e.m4826b().m4878i(true);
                    C1212c command = new C1212c(true);
                    command.m4201c(C1253f.ap);
                    C1215d.m4207a().m4223a(Message.obtain(null, command.m4202d(), 1001, 0, command));
                } else {
                    C1338e.m4826b().m4849P();
                }
            } else {
                initCodecSucc = C1338e.m4826b().m4865b(destWidth, destHeight, destFrameRate);
            }
            if (initCodecSucc) {
                m4898a(C1338e.m4828c(), C1338e.m4830d(), destFrameRate);
            } else {
                C1338e.m4826b().m4855a(1);
            }
        } catch (InvalidProtocolBufferException e) {
            C1260i.m4445e(f3913a, "Get VIDEO_ENCODER_INIT_INFO Error");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m4905b() {
        C1338e.m4826b().m4844K();
    }

    /* renamed from: c */
    private void m4908c() {
        C1338e.m4826b().m4839F();
    }

    /* renamed from: b */
    private void m4906b(Message msg) {
        try {
            int changeFrameRate = CarlifeVideoFrameRate.parseFrom(msg.obj.m4205f()).getFrameRate();
            if (changeFrameRate >= 3 && changeFrameRate <= 30) {
                C1338e.m4826b().m4863b(changeFrameRate);
                m4897a(changeFrameRate);
            }
        } catch (InvalidProtocolBufferException e) {
            C1260i.m4445e(f3913a, "Get VIDEO_ENCODER_FRAME_RATE_CHANGE Error");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m4897a(int destFrameRate) {
        C1212c command = new C1212c(true);
        command.m4201c(C1253f.f3555V);
        CarlifeVideoFrameRate.Builder builder = CarlifeVideoFrameRate.newBuilder();
        builder.setFrameRate(destFrameRate);
        CarlifeVideoFrameRate videoInfo = builder.build();
        command.m4199b(videoInfo.toByteArray());
        command.m4203d(videoInfo.getSerializedSize());
        C1215d.m4207a().m4223a(Message.obtain(null, command.m4202d(), 1001, 0, command));
    }
}
