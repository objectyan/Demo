package com.baidu.carlife.core.screen.video;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.screen.OnStatusChangeListener;
import com.baidu.carlife.core.screen.operation.CarlifeTouchManager;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService;
import com.baidu.carlife.core.screen.presentation.view.CarLifePresentationController;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeVideoFrameRateProto.CarlifeVideoFrameRate;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: VideoMsgHandler */
/* renamed from: com.baidu.carlife.core.screen.video.f */
public class VideoMsgHandler {
    /* renamed from: a */
    private static final String f3913a = "Recorder_MsgHandler";
    /* renamed from: b */
    private OnStatusChangeListener f3914b;
    /* renamed from: c */
    private C1339a f3915c = new C1339a(this, Looper.getMainLooper());

    /* compiled from: VideoMsgHandler */
    /* renamed from: com.baidu.carlife.core.screen.video.f$a */
    private class C1339a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ VideoMsgHandler f3912a;

        public C1339a(VideoMsgHandler videoMsgHandler, Looper looper) {
            super(looper);
            this.f3912a = videoMsgHandler;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    if (CarlifeConfig.m4065a()) {
                        CarLifePresentationController.newInstance().onVehicleDisconnect();
                        LogUtil.e(VideoMsgHandler.f3913a, "---------end internal screen capture.---------");
                    }
                    Recorder.newInstance().m4864b(false);
                    return;
                case CommonParams.gM /*4009*/:
                    CarlifeTouchManager.newInstance().uniniLocalSocket();
                    CarlifeTouchManager.newInstance().iniLocalSocket();
                    return;
                case CommonParams.f3549P /*98311*/:
                    CarlifeScreenUtil.m4331a().m4338a(msg);
                    MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.fm, msg.obj);
                    this.f3912a.m4899a(msg);
                    if (this.f3912a.f3914b != null) {
                        this.f3912a.f3914b.mo1346a(Recorder.m4828c(), Recorder.m4830d());
                    }
                    MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.gM, 2000);
                    if (ConnectManager.newInstance().getType() == 2 && VERSION.SDK_INT < 21) {
                        ConnectClient.newInstance().setIS(false);
                        return;
                    } else if (false) {
                        this.f3912a.m4903a(CarLifeSettings.m4069a().m4095m());
                        return;
                    } else {
                        return;
                    }
                case CommonParams.f3551R /*98313*/:
                    Recorder.newInstance().m4873g();
                    this.f3912a.m4905b();
                    return;
                case CommonParams.f3552S /*98314*/:
                    Recorder.newInstance().m4871f();
                    return;
                case CommonParams.f3553T /*98315*/:
                    this.f3912a.m4908c();
                    return;
                case CommonParams.f3554U /*98316*/:
                    this.f3912a.m4906b(msg);
                    return;
                case CommonParams.bc /*98390*/:
                    Recorder.newInstance().m4864b(true);
                    this.f3912a.m4896a();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(CommonParams.bc);
            addMsg(CommonParams.f3549P);
            addMsg(CommonParams.f3551R);
            addMsg(CommonParams.f3552S);
            addMsg(CommonParams.f3553T);
            addMsg(CommonParams.f3554U);
            addMsg(CommonParams.gM);
            addMsg(1002);
        }
    }

    public VideoMsgHandler() {
        MsgHandlerCenter.registerMessageHandler(this.f3915c);
    }

    /* renamed from: a */
    public void m4911a(OnStatusChangeListener listener) {
        this.f3914b = listener;
    }

    /* renamed from: a */
    private void m4903a(boolean isForegroud) {
        if (false) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            if (isForegroud) {
                LogUtil.d(f3913a, "send foreground message");
                command.setServiceType(CommonParams.ao);
            } else {
                LogUtil.d(f3913a, "send background message");
                command.setServiceType(CommonParams.ap);
            }
            CarlifeCoreSDK.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
        }
    }

    /* renamed from: a */
    private void m4896a() {
        CarlifeCoreSDK.newInstance().disconnected((int) CommonParams.bd);
    }

    /* renamed from: a */
    private void m4898a(int width, int height, int destFrameRate) {
        LogUtil.d("#######", "sendVideoSize: [" + height + " : " + width + " ]");
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.setServiceType(CommonParams.f3550Q);
        Builder builder = CarlifeVideoEncoderInfo.newBuilder();
        builder.setWidth(width);
        builder.setHeight(height);
        builder.setFrameRate(destFrameRate);
        CarlifeVideoEncoderInfo videoInfo = builder.build();
        command.setData(videoInfo.toByteArray());
        command.setLength(videoInfo.getSerializedSize());
        ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
    }

    /* renamed from: a */
    private void m4899a(Message msg) {
        if (this.f3914b == null) {
            LogUtil.e(f3913a, "mOnStatusChangeListener == null");
            return;
        }
        try {
            boolean initCodecSucc;
            CarlifeVideoEncoderInfo initInfo = CarlifeVideoEncoderInfo.parseFrom(((CarlifeCmdMessage) msg.obj).getData());
            int destWidth = initInfo.getWidth();
            int destHeight = initInfo.getHeight();
            int destFrameRate = initInfo.getFrameRate();
            LogUtil.d(f3913a, "VIDEO_ENCODER_INIT_INFO: [" + destWidth + " , " + destHeight + "]");
            if (Recorder.newInstance().m4879j()) {
                if (CarlifeConfig.m4065a()) {
                    initCodecSucc = Recorder.newInstance().m4867c(destWidth, destHeight, destFrameRate);
                    this.f3914b.onVehicleConnected();
                } else {
                    initCodecSucc = Recorder.newInstance().m4861a(destWidth, destHeight, destFrameRate);
                }
            } else if (CarlifeConfig.m4065a()) {
                if (AbsCarlifeActivityService.m4601a()) {
                    LogUtil.d(f3913a, "####### initMediaCodec50: " + destWidth + " , " + destHeight);
                    initCodecSucc = Recorder.newInstance().m4860a(destWidth, destHeight);
                    this.f3914b.onVehicleConnected();
                } else {
                    m4898a(Recorder.m4828c(), Recorder.m4830d(), destFrameRate);
                    return;
                }
            } else if (Recorder.newInstance().m4847N()) {
                initCodecSucc = Recorder.newInstance().m4860a(destWidth, destHeight);
                if (this.f3914b.mo1356q()) {
                    Recorder.newInstance().m4878i(true);
                    CarlifeCmdMessage command = new CarlifeCmdMessage(true);
                    command.setServiceType(CommonParams.ap);
                    ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
                } else {
                    if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Recorder.newInstance().m4849P();
                    }
                }
            } else {
                initCodecSucc = Recorder.newInstance().m4865b(destWidth, destHeight, destFrameRate);
            }
            if (initCodecSucc) {
                m4898a(Recorder.m4828c(), Recorder.m4830d(), destFrameRate);
            } else {
                Recorder.newInstance().m4855a(1);
            }
        } catch (InvalidProtocolBufferException e) {
            LogUtil.e(f3913a, "Get VIDEO_ENCODER_INIT_INFO Error");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m4905b() {
        Recorder.newInstance().m4844K();
    }

    /* renamed from: c */
    private void m4908c() {
        Recorder.newInstance().m4839F();
    }

    /* renamed from: b */
    private void m4906b(Message msg) {
        try {
            int changeFrameRate = CarlifeVideoFrameRate.parseFrom(((CarlifeCmdMessage) msg.obj).getData()).getFrameRate();
            if (changeFrameRate >= 3 && changeFrameRate <= 30) {
                Recorder.newInstance().m4863b(changeFrameRate);
                m4897a(changeFrameRate);
            }
        } catch (InvalidProtocolBufferException e) {
            LogUtil.e(f3913a, "Get VIDEO_ENCODER_FRAME_RATE_CHANGE Error");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m4897a(int destFrameRate) {
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.setServiceType(CommonParams.f3555V);
        CarlifeVideoFrameRate.Builder builder = CarlifeVideoFrameRate.newBuilder();
        builder.setFrameRate(destFrameRate);
        CarlifeVideoFrameRate videoInfo = builder.build();
        command.setData(videoInfo.toByteArray());
        command.setLength(videoInfo.getSerializedSize());
        ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
    }
}
