package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Calendar;

public class BNDigitalClock extends TextView {
    private static final String m12 = "现在h:mm";
    private static final String m24 = "现在k:mm";
    Calendar mCalendar;
    String mFormat = m24;
    private Handler mHandler;
    private Runnable mTicker;
    private boolean mTickerStopped = false;

    /* renamed from: com.baidu.navisdk.ui.widget.BNDigitalClock$1 */
    class C45771 implements Runnable {
        C45771() {
        }

        public void run() {
            if (!BNDigitalClock.this.mTickerStopped) {
                BNDigitalClock.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
                BNDigitalClock.this.setText(DateFormat.format(BNDigitalClock.this.mFormat, BNDigitalClock.this.mCalendar));
                BNDigitalClock.this.invalidate();
                long now = SystemClock.uptimeMillis();
                BNDigitalClock.this.mHandler.postAtTime(BNDigitalClock.this.mTicker, now + (1000 - (now % 1000)));
            }
        }
    }

    public BNDigitalClock(Context context) {
        super(context);
        initClock(context);
    }

    public BNDigitalClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        initClock(context);
    }

    private void initClock(Context context) {
        if (this.mCalendar == null) {
            this.mCalendar = Calendar.getInstance();
        }
        setFormat();
    }

    protected void onAttachedToWindow() {
        this.mTickerStopped = false;
        super.onAttachedToWindow();
        this.mHandler = new Handler();
        this.mTicker = new C45771();
        this.mTicker.run();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTickerStopped = true;
    }

    private void setFormat() {
        this.mFormat = m24;
    }
}
