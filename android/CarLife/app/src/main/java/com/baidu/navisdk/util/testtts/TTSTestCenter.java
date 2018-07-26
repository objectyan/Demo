package com.baidu.navisdk.util.testtts;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TTSTestCenter {
    public static final String TAG = TTSTestCenter.class.getSimpleName();
    public static final String TTSTEST_FOLDER = "/log/tts";
    public static final String[] TTS_TXT = new String[]{"tts_const.txt", "tts_var.txt", "tts_var_poi.txt", "tts_var_road.txt", "tts_var_dist.txt"};
    public static final int TYPE_ALL = 100;
    public static final int TYPE_CONST = 0;
    public static final int TYPE_DIST = 4;
    public static final int TYPE_POI = 2;
    public static final int TYPE_ROAD = 3;
    public static final int TYPE_VAR = 1;
    private static TTSTestCenter sInstance = null;
    private static Object sSyncObj = new Object();
    private List<String> mConsts = new ArrayList();
    private List<String> mDists = new ArrayList();
    private Handler mHD = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            TTSTestCenter.log("what=" + msg.what + ", arg1=" + msg.arg1 + ", stop=" + TTSTestCenter.this.mStopTest);
            if (!TTSTestCenter.this.mStopTest) {
                boolean isok;
                if (1 == TTSPlayerControl.getTTSState()) {
                    isok = true;
                } else {
                    isok = false;
                }
                Message msg2;
                if (!isok) {
                    msg2 = TTSTestCenter.this.mHD.obtainMessage(msg.what);
                    msg2.what = msg.what;
                    msg2.arg1 = msg.arg1;
                    TTSTestCenter.this.mHD.sendMessageDelayed(msg2, 1000);
                } else if (100 == msg.what) {
                    if (msg.arg1 >= 0 && msg.arg1 < TTSTestCenter.this.mPlayTexts.size()) {
                        TTSPlayerControl.playTTS((String) TTSTestCenter.this.mPlayTexts.get(msg.arg1), 1);
                        TTSTestCenter.log("play=" + ((String) TTSTestCenter.this.mPlayTexts.get(msg.arg1)));
                        if (msg.arg1 + 1 < TTSTestCenter.this.mPlayTexts.size()) {
                            msg2 = TTSTestCenter.this.mHD.obtainMessage(100);
                            msg2.what = 100;
                            msg2.arg1 = msg.arg1 + 1;
                            TTSTestCenter.this.mHD.sendMessageDelayed(msg2, 1000);
                        }
                    }
                } else if (msg.what == 0 && msg.arg1 >= 0 && msg.arg1 < TTSTestCenter.this.mConsts.size()) {
                    TTSPlayerControl.playTTS((String) TTSTestCenter.this.mConsts.get(msg.arg1), 1);
                    if (msg.arg1 + 1 < TTSTestCenter.this.mConsts.size()) {
                        msg2 = TTSTestCenter.this.mHD.obtainMessage(0);
                        msg2.what = 0;
                        msg2.arg1 = msg.arg1 + 1;
                        TTSTestCenter.this.mHD.sendMessageDelayed(msg2, 1000);
                        return;
                    }
                    msg2 = TTSTestCenter.this.mHD.obtainMessage(1);
                    msg2.what = 1;
                    msg2.arg1 = 0;
                    TTSTestCenter.this.mHD.sendMessageDelayed(msg2, 1000);
                }
            }
        }
    };
    private boolean mIsInitOK = false;
    private List<String> mPlayTexts = new ArrayList();
    private List<String> mPois = new ArrayList();
    private List<String> mRoads = new ArrayList();
    private boolean mStopTest = false;
    private List<String> mVars = new ArrayList();

    public static TTSTestCenter getInstance() {
        if (sInstance == null) {
            synchronized (sSyncObj) {
                if (sInstance == null) {
                    sInstance = new TTSTestCenter();
                }
            }
        }
        return sInstance;
    }

    private TTSTestCenter() {
    }

    public void init() {
        if (!this.mIsInitOK) {
            initDirs();
            this.mIsInitOK = loadTXT();
            this.mIsInitOK &= generatePlayTexts();
        }
    }

    private static void initDirs() {
        File f = new File(SysOSAPI.getInstance().GetSDCardPath() + TTSTEST_FOLDER);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    private boolean loadTXT() {
        int i = 0;
        while (i < TTS_TXT.length) {
            try {
                FileInputStream fis = new FileInputStream(SysOSAPI.getInstance().GetSDCardPath() + TTSTEST_FOLDER + File.separator + TTS_TXT[i]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    log("loadTXT=" + line);
                    addTTSTxt(i, line);
                }
                fis.close();
                reader.close();
                log("success to load txt file. txt=" + TTS_TXT[i]);
                i++;
            } catch (Exception e) {
                log("failed to load txt file. txt=" + TTS_TXT[i]);
                return false;
            }
        }
        return true;
    }

    private void addTTSTxt(int type, String str) {
        if (type >= 0 && type <= 4 && str != null && str.length() != 0) {
            switch (type) {
                case 0:
                    this.mConsts.add(str);
                    return;
                case 1:
                    this.mVars.add(str);
                    return;
                case 2:
                    this.mPois.add(str);
                    return;
                case 3:
                    this.mRoads.add(str);
                    return;
                case 4:
                    this.mDists.add(str);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean generatePlayTexts() {
        this.mPlayTexts.clear();
        this.mPlayTexts.addAll(this.mConsts);
        for (int i = 0; i < this.mVars.size(); i++) {
            for (int j = 0; j < this.mPois.size(); j++) {
                for (int m = 0; m < this.mRoads.size(); m++) {
                    for (int n = 0; n < this.mDists.size(); n++) {
                        String s1 = ((String) this.mVars.get(i)).replaceAll("poi", (String) this.mPois.get(j)).replaceAll("road", (String) this.mRoads.get(m)).replaceAll("dist", (String) this.mDists.get(n));
                        if (!this.mPlayTexts.contains(s1)) {
                            log("generatePlayTexts() newS=" + s1);
                            this.mPlayTexts.add(s1);
                        }
                    }
                }
            }
        }
        this.mPlayTexts.add("tts测试模式已经完成");
        return true;
    }

    public boolean test() {
        if (!this.mIsInitOK) {
            return false;
        }
        this.mStopTest = false;
        testPlayTexts();
        return true;
    }

    public void stopTest() {
        this.mStopTest = true;
    }

    private void testPlayTexts() {
        Message msg2 = this.mHD.obtainMessage(100);
        msg2.what = 100;
        msg2.arg1 = 0;
        this.mHD.sendMessageDelayed(msg2, 1000);
    }

    private void testTTSConst() {
        Message msg2 = this.mHD.obtainMessage(0);
        msg2.what = 0;
        msg2.arg1 = 0;
        this.mHD.sendMessageDelayed(msg2, 1000);
    }

    private void testTTSVar() {
        if (!this.mStopTest) {
        }
    }

    private void testTTSText(String info) {
        if (!this.mStopTest) {
            int i = 0;
            while (!this.mStopTest && i < this.mConsts.size()) {
                while (1 != TTSPlayerControl.getTTSState() && 2 == TTSPlayerControl.getTTSState()) {
                    try {
                        log("sleep");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
                if (false) {
                    TTSPlayerControl.playTTS((String) this.mConsts.get(i), 1);
                }
                i++;
            }
        }
    }

    public static void log(String info) {
        LogUtil.m15791e(TAG, info);
    }
}
