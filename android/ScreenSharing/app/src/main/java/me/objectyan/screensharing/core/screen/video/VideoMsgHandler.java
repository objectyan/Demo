package me.objectyan.screensharing.core.screen.video;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import me.objectyan.screensharing.core.CarLifeSettings;
import me.objectyan.screensharing.core.CarlifeScreenUtil;
import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.config.CarlifeConfig;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.core.connect.ConnectClient;
import me.objectyan.screensharing.core.connect.ConnectManager;
import me.objectyan.screensharing.core.screen.OnStatusChangeListener;
import me.objectyan.screensharing.core.screen.operation.CarlifeTouchManager;
import me.objectyan.screensharing.core.screen.presentation.AbsCarlifeActivityService;
import me.objectyan.screensharing.core.screen.presentation.view.CarLifePresentationController;
import me.objectyan.screensharing.util.CarlifeCoreSDK;
import me.objectyan.screensharing.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;
import me.objectyan.screensharing.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder;
import me.objectyan.screensharing.protobuf.CarlifeVideoFrameRateProto.CarlifeVideoFrameRate;

import com.google.protobuf.InvalidProtocolBufferException;


public class VideoMsgHandler {

    private static final String Tag = "Recorder_MsgHandler";

    private OnStatusChangeListener mOnStatusChangeListener;

    private VideoMsgBaseHandler mVideoMsgBaseHandler = new VideoMsgBaseHandler(this, Looper.getMainLooper());


    private class VideoMsgBaseHandler extends MsgBaseHandler {

        final VideoMsgHandler mVideoMsgHandler;

        public VideoMsgBaseHandler(VideoMsgHandler videoMsgHandler, Looper looper) {
            super(looper);
            this.mVideoMsgHandler = videoMsgHandler;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    if (CarlifeConfig.isSupportInternalScreen()) {
                        CarLifePresentationController.newInstance().onVehicleDisconnect();
                        Log.e(VideoMsgHandler.Tag, "---------end internal screen capture.---------");
                    }
                    Recorder.newInstance().setIsJPEGMode(false);
                    return;
                case 4009:
                    CarlifeTouchManager.newInstance().uniniLocalSocket();
                    CarlifeTouchManager.newInstance().iniLocalSocket();
                    return;
                case 98311:
                    CarlifeScreenUtil.newInstance().initInfoForVideoEncoder(msg);
                    MsgHandlerCenter.dispatchMessageDelay(1040, msg.obj);
                    this.mVideoMsgHandler.initVideoEncoder(msg);
                    if (this.mVideoMsgHandler.mOnStatusChangeListener != null) {
                        this.mVideoMsgHandler.mOnStatusChangeListener.mo1346a(Recorder.getContainerWidth(), Recorder.getContainerHeight());
                    }
                    MsgHandlerCenter.dispatchMessageDelay(4009, 2000);
                    if (ConnectManager.newInstance().getType() == 2 && VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        ConnectClient.newInstance().setIS(false);
                        return;
                    } else if (false) {
                        this.mVideoMsgHandler.sendMessage(CarLifeSettings.m4069a().m4095m());
                        return;
                    } else {
                        return;
                    }
                case 98313:
                    Recorder.newInstance().m4873g();
                    this.mVideoMsgHandler.startThread();
                    return;
                case 98314:
                    Recorder.newInstance().m4871f();
                    return;
                case 98315:
                    this.mVideoMsgHandler.m4908c();
                    return;
                case 98316:
                    this.mVideoMsgHandler.videoEncoderFrameRateChange(msg);
                    return;
                case 98390:
                    Recorder.newInstance().setIsJPEGMode(true);
                    this.mVideoMsgHandler.disConnected();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(98390);
            addMsg(98311);
            addMsg(98313);
            addMsg(98314);
            addMsg(98315);
            addMsg(98316);
            addMsg(4009);
            addMsg(1002);
        }
    }

    public VideoMsgHandler() {
        MsgHandlerCenter.registerMessageHandler(this.mVideoMsgBaseHandler);
    }


    public void setStatusChangeListener(OnStatusChangeListener listener) {
        this.mOnStatusChangeListener = listener;
    }


    private void sendMessage(boolean isForegroud) {
        if (false) {
            CarlifeCmdMessage command = new CarlifeCmdMessage(true);
            if (isForegroud) {
                Log.d(Tag, "send foreground message");
                command.setServiceType(65563);
            } else {
                Log.d(Tag, "send background message");
                command.setServiceType(65564);
            }
            CarlifeCoreSDK.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(),
                    1001, 0, command));
        }
    }


    private void disConnected() {
        CarlifeCoreSDK.newInstance().disconnected(65623);
    }


    private void sendVideoSize(int width, int height, int destFrameRate) {
        Log.d("#######", "sendVideoSize: [" + height + " : " + width + " ]");
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.setServiceType(CommonParams.f3550Q);
        Builder builder = CarlifeVideoEncoderInfo.newBuilder();
        builder.setWidth(width);
        builder.setHeight(height);
        builder.setFrameRate(destFrameRate);
        CarlifeVideoEncoderInfo videoInfo = builder.build();
        command.setData(videoInfo.toByteArray());
        command.setLength(videoInfo.getSerializedSize());
        ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(),
                1001, 0, command));
    }


    private void initVideoEncoder(Message msg) {
        if (this.mOnStatusChangeListener == null) {
            Log.e(Tag, "mOnStatusChangeListener == null");
            return;
        }
        try {
            boolean initCodecSucc;
            CarlifeVideoEncoderInfo initInfo = CarlifeVideoEncoderInfo.parseFrom(((CarlifeCmdMessage) msg.obj).getData());
            int destWidth = initInfo.getWidth();
            int destHeight = initInfo.getHeight();
            int destFrameRate = initInfo.getFrameRate();
            Log.d(Tag, "VIDEO_ENCODER_INIT_INFO: [" + destWidth + " , " + destHeight + "]");
            if (Recorder.newInstance().getIsJPEGMode()) {
                if (CarlifeConfig.isSupportInternalScreen()) {
                    initCodecSucc = Recorder.newInstance().initMediaCodec50TextureView(destWidth, destHeight, destFrameRate);
                    this.mOnStatusChangeListener.onVehicleConnected();
                } else {
                    initCodecSucc = Recorder.newInstance().initJPEGCodec(destWidth, destHeight, destFrameRate);
                }
            } else if (CarlifeConfig.isSupportInternalScreen()) {
                if (AbsCarlifeActivityService.m4601a()) {
                    Log.d(Tag, "####### initMediaCodec50: " + destWidth + " , " + destHeight);
                    initCodecSucc = Recorder.newInstance().startMediaCodec(destWidth, destHeight);
                    this.mOnStatusChangeListener.onVehicleConnected();
                } else {
                    sendVideoSize(Recorder.getContainerWidth(), Recorder.getContainerHeight(), destFrameRate);
                    return;
                }
            } else if (Recorder.newInstance().getIsLollipop()) {
                initCodecSucc = Recorder.newInstance().startMediaCodec(destWidth, destHeight);
                if (this.mOnStatusChangeListener.mo1356q()) {
                    Recorder.newInstance().setIsDelayInitScreenShare(true);
                    CarlifeCmdMessage command = new CarlifeCmdMessage(true);
                    command.setServiceType(CommonParams.ap);
                    ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(), 1001, 0, command));
                } else {
                    if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Recorder.newInstance().initMediaProjection();
                    }
                }
            } else {
                initCodecSucc = Recorder.newInstance().initMediaCodec(destWidth, destHeight, destFrameRate);
            }
            if (initCodecSucc) {
                sendVideoSize(Recorder.getContainerWidth(), Recorder.getContainerHeight(), destFrameRate);
            } else {
                Recorder.newInstance().sendTypeMsgToService(1);
            }
        } catch (InvalidProtocolBufferException e) {
            Log.e(Tag, "Get VIDEO_ENCODER_INIT_INFO Error");
            e.printStackTrace();
        }
    }


    private void startThread() {
        Recorder.newInstance().startThread();
    }


    private void m4908c() {
        Recorder.newInstance().m4839F();
    }


    private void videoEncoderFrameRateChange(Message msg) {
        try {
            int changeFrameRate = CarlifeVideoFrameRate.parseFrom(((CarlifeCmdMessage) msg.obj).getData()).getFrameRate();
            if (changeFrameRate >= 3 && changeFrameRate <= 30) {
                Recorder.newInstance().setThreadFrameRate(changeFrameRate);
                sendFrameRate(changeFrameRate);
            }
        } catch (InvalidProtocolBufferException e) {
            Log.e(Tag, "Get VIDEO_ENCODER_FRAME_RATE_CHANGE Error");
            e.printStackTrace();
        }
    }


    private void sendFrameRate(int destFrameRate) {
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.setServiceType(65549);
        CarlifeVideoFrameRate.Builder builder = CarlifeVideoFrameRate.newBuilder();
        builder.setFrameRate(destFrameRate);
        CarlifeVideoFrameRate videoInfo = builder.build();
        command.setData(videoInfo.toByteArray());
        command.setLength(videoInfo.getSerializedSize());
        ConnectClient.newInstance().sendMsgToService(Message.obtain(null, command.getServiceType(),
                1001, 0, command));
    }
}
