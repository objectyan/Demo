package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeView extends TextView {
    private static final int HANDLER_WHAT_UPDATE_TIME = 4097;
    private Date mDate;
    private SimpleDateFormat mFormat;
    private Handler mHandler;

    /* renamed from: com.baidu.navisdk.ui.widget.TimeView$1 */
    class C46131 extends Handler {
        C46131() {
        }

        public void handleMessage(Message msg) {
            TimeView.this.mDate = new Date();
            TimeView.this.setText(TimeView.this.mFormat.format(TimeView.this.mDate));
            TimeView.this.mHandler.sendEmptyMessageDelayed(4097, 60000);
        }
    }

    public TimeView(Context context) {
        this(context, null, 0);
    }

    public TimeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mFormat = new SimpleDateFormat("HH:mm");
        this.mHandler = new C46131();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDate = new Date();
        setText(this.mFormat.format(this.mDate));
        this.mHandler.sendEmptyMessageDelayed(4097, (long) ((60 - this.mDate.getSeconds()) * 1000));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(4097);
    }
}
