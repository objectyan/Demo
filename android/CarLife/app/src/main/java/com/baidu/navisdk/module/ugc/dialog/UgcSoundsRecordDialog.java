package com.baidu.navisdk.module.ugc.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources.Theme;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.MediaFocuseChangeListener;
import java.util.Timer;
import java.util.TimerTask;

public class UgcSoundsRecordDialog extends Dialog {
    private static final String TAG = UgcSoundsRecordDialog.class.getName();
    private static final int TIME_COUNT_SUM = 20;
    private static final int WHAT_RECORD_STOP = 1000;
    private static UgcSoundsRecordDialog mUgcSoundsRecordDialog = null;
    private String filePath = null;
    private boolean isRecording = false;
    private TextView leftTimeTView = null;
    private OnUgcSoundsRecordCallback mOnUgcSoundsRecordCallback;
    private MediaRecorder mRecorder;
    private RotateAnimation mRoateAnimation;
    private Timer mTimer;
    private ImageView recordProcessIView = null;
    private TextView startOrStopRecordTView = null;
    private ImageView startRecordIView = null;
    private int timeCount = 0;
    private int timeCountTime = 20;
    private Handler timeHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (!UgcSoundsRecordDialog.this.isRecording) {
                return;
            }
            if (msg.what == 1000) {
                UgcSoundsRecordDialog.this.stopRecord();
                return;
            }
            int leftTime = msg.what;
            UgcSoundsRecordDialog.this.timeCount = UgcSoundsRecordDialog.this.timeCount + 1;
            if (UgcSoundsRecordDialog.this.timeCount > 3) {
                UgcSoundsRecordDialog.this.timeCount = 1;
            }
            String addStr = "";
            for (int i = 0; i < UgcSoundsRecordDialog.this.timeCount; i++) {
                addStr = addStr + ".";
            }
            if (UgcSoundsRecordDialog.this.titleTView != null && UgcSoundsRecordDialog.this.leftTimeTView != null) {
                UgcSoundsRecordDialog.this.titleTView.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_sounds_record_title) + addStr);
                UgcSoundsRecordDialog.this.leftTimeTView.setText("剩下" + leftTime + "\"");
            }
        }
    };
    private TextView titleTView = null;

    /* renamed from: com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog$1 */
    class C41881 implements OnDismissListener {
        C41881() {
        }

        public void onDismiss(DialogInterface dialog) {
            UgcSoundsRecordDialog.this.stopRecord();
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog$2 */
    class C41892 implements OnClickListener {
        C41892() {
        }

        public void onClick(View v) {
            UgcSoundsRecordDialog.this.recordBtnClick();
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog$3 */
    class C41903 implements OnClickListener {
        C41903() {
        }

        public void onClick(View v) {
            UgcSoundsRecordDialog.this.recordBtnClick();
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog$4 */
    class C41914 extends TimerTask {
        C41914() {
        }

        public void run() {
            if (UgcSoundsRecordDialog.this.isRecording) {
                UgcSoundsRecordDialog.this.timeCountTime = UgcSoundsRecordDialog.this.timeCountTime - 1;
                if (UgcSoundsRecordDialog.this.timeCountTime <= 0) {
                    UgcSoundsRecordDialog.this.timeHandler.sendEmptyMessage(1000);
                } else {
                    UgcSoundsRecordDialog.this.timeHandler.sendEmptyMessage(UgcSoundsRecordDialog.this.timeCountTime);
                }
            }
        }
    }

    public interface OnUgcSoundsRecordCallback {
        void onRecordFinish(int i, String str, boolean z);
    }

    public static boolean checkAudioAuth() {
        if (SystemAuth.checkAuth("android.permission.RECORD_AUDIO", true, "没有麦克风权限，请打开后重试")) {
            return true;
        }
        UgcMapsViewConstructor.requestSoundsAuth();
        return false;
    }

    public UgcSoundsRecordDialog(Context context) {
        super(context);
        mUgcSoundsRecordDialog = this;
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_ugc_report_sounds_dialog, null);
        setContentView(view);
        this.titleTView = (TextView) view.findViewById(C4048R.id.nsdk_ugc_report_sounds_title);
        this.leftTimeTView = (TextView) view.findViewById(C4048R.id.nsdk_ugc_report_sounds_lefttime);
        this.recordProcessIView = (ImageView) view.findViewById(C4048R.id.nsdk_ugc_report_sounds_record_process);
        this.startRecordIView = (ImageView) view.findViewById(C4048R.id.nsdk_ugc_report_sounds_start_iview);
        this.startOrStopRecordTView = (TextView) view.findViewById(C4048R.id.nsdk_ugc_report_sounds_startorstop_tview);
        this.startOrStopRecordTView.setText("点击开始");
        this.leftTimeTView.setVisibility(4);
        this.recordProcessIView.setVisibility(8);
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.width = ScreenUtil.getInstance().dip2px(BNOfflineDataObserver.EVENT_DELETE_FINISH);
        lp.height = ScreenUtil.getInstance().dip2px(255);
        window.setAttributes(lp);
        window.setGravity(17);
        initListener();
        initAnimate();
    }

    public void setOnUgcSoundsRecordCallback(OnUgcSoundsRecordCallback mOnUgcSoundsRecordCallback) {
        this.mOnUgcSoundsRecordCallback = mOnUgcSoundsRecordCallback;
    }

    private void initListener() {
        setOnDismissListener(new C41881());
        if (this.startRecordIView != null) {
            this.startRecordIView.setOnClickListener(new C41892());
        }
        if (this.startOrStopRecordTView != null) {
            this.startOrStopRecordTView.setOnClickListener(new C41903());
        }
    }

    public void recordBtnClick() {
        if (this.isRecording) {
            stopRecord();
        } else {
            startRecord();
        }
    }

    private void startRecord() {
        MediaFocuseChangeListener.requestAudioFocus(BNaviModuleManager.getContext());
        this.isRecording = true;
        TTSPlayerControl.stopVoiceTTSOutput();
        TTSPlayerControl.pauseVoiceTTSOutput();
        BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
        if (!(this.titleTView == null || this.leftTimeTView == null || this.recordProcessIView == null || this.startRecordIView == null || this.startOrStopRecordTView == null)) {
            this.titleTView.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_sounds_record_title));
            this.leftTimeTView.setVisibility(0);
            this.recordProcessIView.setVisibility(0);
            this.startOrStopRecordTView.setText("点击停止");
            if (this.mRoateAnimation == null) {
                initAnimate();
            }
            this.leftTimeTView.setText("剩下20\"");
            this.recordProcessIView.startAnimation(this.mRoateAnimation);
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        this.timeCountTime = 20;
        this.mTimer.schedule(new C41914(), 1000, 1000);
        try {
            if (this.mRecorder == null) {
                this.mRecorder = new MediaRecorder();
            }
            this.mRecorder = new MediaRecorder();
            this.filePath = getUniqueSoundsFileName();
            this.mRecorder.setAudioSource(1);
            this.mRecorder.setOutputFormat(1);
            this.mRecorder.setOutputFile(this.filePath);
            this.mRecorder.setAudioEncoder(1);
            this.mRecorder.prepare();
            this.mRecorder.start();
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "MediaRecorder error:" + e.toString());
        }
    }

    private void initAnimate() {
        if (this.mRoateAnimation == null) {
            this.mRoateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.mRoateAnimation.setDuration(1000);
            this.mRoateAnimation.setRepeatMode(1);
            this.mRoateAnimation.setRepeatCount(-1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void stopRecord() {
        /*
        r6 = this;
        r5 = 0;
        r1 = r6.isRecording;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r1 = com.baidu.navisdk.BNaviModuleManager.getContext();
        com.baidu.navisdk.util.listener.MediaFocuseChangeListener.releaseAudioFocus(r1);
        com.baidu.navisdk.comapi.tts.TTSPlayerControl.resumeVoiceTTSOutput();
        r1 = 0;
        r6.isRecording = r1;
        r1 = r6.recordProcessIView;
        if (r1 == 0) goto L_0x001c;
    L_0x0017:
        r1 = r6.recordProcessIView;
        r1.clearAnimation();
    L_0x001c:
        r1 = r6.mTimer;	 Catch:{ Exception -> 0x004d }
        if (r1 == 0) goto L_0x0025;
    L_0x0020:
        r1 = r6.mTimer;	 Catch:{ Exception -> 0x004d }
        r1.cancel();	 Catch:{ Exception -> 0x004d }
    L_0x0025:
        r1 = r6.mRecorder;	 Catch:{ Exception -> 0x004d }
        if (r1 == 0) goto L_0x0036;
    L_0x0029:
        r1 = r6.mRecorder;	 Catch:{ Exception -> 0x005c }
        r1.stop();	 Catch:{ Exception -> 0x005c }
    L_0x002e:
        r1 = r6.mRecorder;	 Catch:{ Exception -> 0x004d }
        r1.release();	 Catch:{ Exception -> 0x004d }
        r1 = 0;
        r6.mRecorder = r1;	 Catch:{ Exception -> 0x004d }
    L_0x0036:
        r6.mRecorder = r5;
        r6.mTimer = r5;
    L_0x003a:
        r1 = r6.mOnUgcSoundsRecordCallback;
        if (r1 == 0) goto L_0x004a;
    L_0x003e:
        r1 = r6.mOnUgcSoundsRecordCallback;
        r2 = r6.timeCountTime;
        r2 = 20 - r2;
        r3 = r6.filePath;
        r4 = 1;
        r1.onRecordFinish(r2, r3, r4);
    L_0x004a:
        mUgcSoundsRecordDialog = r5;
        goto L_0x0005;
    L_0x004d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0056 }
        r6.mRecorder = r5;
        r6.mTimer = r5;
        goto L_0x003a;
    L_0x0056:
        r1 = move-exception;
        r6.mRecorder = r5;
        r6.mTimer = r5;
        throw r1;
    L_0x005c:
        r1 = move-exception;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog.stopRecord():void");
    }

    public static void stopRecordAndDismiss() {
        if (mUgcSoundsRecordDialog != null && mUgcSoundsRecordDialog.isRecording) {
            mUgcSoundsRecordDialog.stopRecord();
        }
    }

    private String getUniqueSoundsFileName() {
        return SysOSAPI.getInstance().GetSDCardCachePath() + "/" + new Object().hashCode() + ".amr";
    }

    public void show() {
        XDVoiceInstructManager.getInstance().setWakeupEnable(false);
        super.show();
    }

    public void dismiss() {
        XDVoiceInstructManager.getInstance().setWakeupEnable(true);
        super.dismiss();
    }

    public void cancel() {
        XDVoiceInstructManager.getInstance().setWakeupEnable(true);
        super.cancel();
    }
}
