package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.DialogReplaceToastUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNTiptoolDialog extends Dialog {
    private static final int START_MSG = 2;
    private static final int STOP_MSG = 1;
    private TextView mShowText = null;
    private Handler uiHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case 1:
                        LogUtil.m15791e(DialogReplaceToastUtils.TAG, "showToastMessage STOP_MSG");
                        BNTiptoolDialog.this.dismiss();
                        return;
                    case 2:
                        LogUtil.m15791e(DialogReplaceToastUtils.TAG, "showToastMessage START_MSG");
                        String tips = msg.obj;
                        int time = msg.arg2;
                        BNTiptoolDialog.this.mShowText.setText(tips);
                        if (BNaviModuleManager.getActivity() != null && !BNaviModuleManager.getActivity().isFinishing()) {
                            BNTiptoolDialog.this.show();
                            if (BNTiptoolDialog.this.uiHandler != null) {
                                BNTiptoolDialog.this.uiHandler.sendEmptyMessageDelayed(1, (long) time);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    };

    public BNTiptoolDialog(Context context) {
        super(context);
    }

    public BNTiptoolDialog(Context context, int theme, String msg) {
        super(context, theme);
        JarUtils.getResources().newTheme().applyStyle(C4048R.style.TiptoolDialog, true);
        requestWindowFeature(1);
        setContentView(JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_tiptool_dialog, null));
        this.mShowText = (TextView) findViewById(C4048R.id.toast_tx);
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        window.setBackgroundDrawableResource(17170445);
        int length = msg.length();
        LogUtil.m15791e(DialogReplaceToastUtils.TAG, "dialog lenght is " + length);
        lp.width = getPixel(length, msg);
        lp.height = ScreenUtil.getInstance().dip2px(44);
        lp.y = ScreenUtil.getInstance().dip2px(64);
        window.setAttributes(lp);
        window.setGravity(80);
    }

    private int getPixel(int length, String msg) {
        int number = getVacabularyNumber(msg);
        return ScreenUtil.getInstance().dip2px(((((length - 1) - number) * 14) + 38) + (number * 8));
    }

    private int getVacabularyNumber(String msg) {
        int count = 0;
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (c >= '0' && c <= '9') {
                count++;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
            }
        }
        return count;
    }

    public void release() {
        if (this.uiHandler != null) {
            this.uiHandler.removeMessages(1);
            this.uiHandler.removeMessages(2);
        }
        this.uiHandler = null;
    }

    public void showToastMsg(String tips, int lastTime) {
        if (!TextUtils.isEmpty(tips)) {
            clearMessage();
            Message msg = this.uiHandler.obtainMessage();
            msg.what = 2;
            msg.arg2 = lastTime;
            msg.obj = tips;
            this.uiHandler.sendMessage(msg);
        }
    }

    private void clearMessage() {
        if (this.uiHandler != null) {
            this.uiHandler.removeMessages(1);
        }
    }
}
