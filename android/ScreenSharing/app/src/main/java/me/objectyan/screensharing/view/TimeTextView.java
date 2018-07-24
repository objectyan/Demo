package com.baidu.carlife.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTextView extends TextView {
    /* renamed from: a */
    private SimpleDateFormat f7295a;
    /* renamed from: b */
    private Handler f7296b;

    /* renamed from: com.baidu.carlife.view.TimeTextView$1 */
    class C22411 extends Handler {
        /* renamed from: a */
        final /* synthetic */ TimeTextView f7294a;

        C22411(TimeTextView this$0) {
            this.f7294a = this$0;
        }

        public void handleMessage(Message msg) {
            this.f7294a.setText(this.f7294a.f7295a.format(new Date()));
            sendEmptyMessageDelayed(0, 60000);
        }
    }

    public TimeTextView(Context context) {
        this(context, null, 0);
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7295a = new SimpleDateFormat("HH:mm");
        this.f7296b = new C22411(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Date date = new Date();
        setText(this.f7295a.format(date));
        this.f7296b.sendEmptyMessageDelayed(0, (long) ((60 - date.getSeconds()) * 1000));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7296b.removeMessages(0);
    }
}
