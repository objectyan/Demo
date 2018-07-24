package com.baidu.carlife.view.pinnedheaderlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2188r;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;

public class BladeView extends View {
    /* renamed from: a */
    int f7746a;
    /* renamed from: b */
    Paint f7747b;
    /* renamed from: c */
    boolean f7748c;
    /* renamed from: d */
    Runnable f7749d;
    /* renamed from: e */
    private C2350a f7750e;
    /* renamed from: f */
    private String[] f7751f;
    /* renamed from: g */
    private String[] f7752g;
    /* renamed from: h */
    private PopupWindow f7753h;
    /* renamed from: i */
    private TextView f7754i;
    /* renamed from: j */
    private Handler f7755j;

    /* renamed from: com.baidu.carlife.view.pinnedheaderlistview.BladeView$1 */
    class C23491 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BladeView f7745a;

        C23491(BladeView this$0) {
            this.f7745a = this$0;
        }

        public void run() {
            if (this.f7745a.f7753h != null && this.f7745a.f7753h.isShowing()) {
                this.f7745a.f7753h.dismiss();
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.pinnedheaderlistview.BladeView$a */
    public interface C2350a {
        /* renamed from: a */
        void m8927a(String str);
    }

    public BladeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7751f = new String[]{"A", ".", "D", ".", "G", ".", "K", ".", "O", ".", "R", ".", "W", ".", "Z", "#"};
        this.f7752g = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", RoutePlanDataStruct.KEY_X, RoutePlanDataStruct.KEY_Y, "Z", "#"};
        this.f7746a = -1;
        this.f7747b = new Paint();
        this.f7748c = false;
        this.f7755j = new Handler();
        this.f7749d = new C23491(this);
    }

    public BladeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7751f = new String[]{"A", ".", "D", ".", "G", ".", "K", ".", "O", ".", "R", ".", "W", ".", "Z", "#"};
        this.f7752g = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", RoutePlanDataStruct.KEY_X, RoutePlanDataStruct.KEY_Y, "Z", "#"};
        this.f7746a = -1;
        this.f7747b = new Paint();
        this.f7748c = false;
        this.f7755j = new Handler();
        this.f7749d = new C23491(this);
    }

    public BladeView(Context context) {
        super(context);
        this.f7751f = new String[]{"A", ".", "D", ".", "G", ".", "K", ".", "O", ".", "R", ".", "W", ".", "Z", "#"};
        this.f7752g = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", RoutePlanDataStruct.KEY_X, RoutePlanDataStruct.KEY_Y, "Z", "#"};
        this.f7746a = -1;
        this.f7747b = new Paint();
        this.f7748c = false;
        this.f7755j = new Handler();
        this.f7749d = new C23491(this);
    }

    public void setLetterDisplayList(String[] list) {
        this.f7751f = list;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / this.f7751f.length;
        for (int i = 0; i < this.f7751f.length; i++) {
            this.f7747b.setColor(C2188r.m8328a((int) R.color.cl_other_d_index));
            this.f7747b.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.bladeview_fontsize));
            this.f7747b.setFakeBoldText(true);
            this.f7747b.setAntiAlias(true);
            canvas.drawText(this.f7751f[i], (float) (width / 3), (float) ((singleHeight * i) + singleHeight), this.f7747b);
            this.f7747b.reset();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float y = event.getY();
        int oldChoose = this.f7746a;
        int c = 0;
        if (getHeight() > 0 && this.f7752g.length > 0) {
            c = (int) ((y / ((float) getHeight())) * ((float) this.f7752g.length));
        }
        switch (action) {
            case 0:
                this.f7748c = true;
                if (oldChoose != c && c >= 0 && c < this.f7752g.length) {
                    m8929a(c);
                    this.f7746a = c;
                    invalidate();
                    break;
                }
            case 1:
                m8931a();
                invalidate();
                break;
            case 2:
                if (!C1663a.m5979a().m5993N() && oldChoose != c && c >= 0 && c < this.f7752g.length) {
                    m8929a(c);
                    this.f7746a = c;
                    invalidate();
                    break;
                }
        }
        return true;
    }

    /* renamed from: a */
    private void m8930a(String text) {
        if (this.f7753h == null) {
            this.f7755j.removeCallbacks(this.f7749d);
            this.f7754i = new TextView(getContext());
            this.f7754i.setBackground(C2188r.m8331b(R.drawable.com_ic_cursorindex));
            this.f7754i.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_title));
            this.f7754i.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.bladeview_popup_fontsize));
            this.f7754i.setGravity(17);
            int height = getResources().getDimensionPixelSize(R.dimen.bladeview_popup_height);
            this.f7753h = new PopupWindow(this.f7754i, getResources().getDimensionPixelSize(R.dimen.bladeview_popup_width), height);
        }
        this.f7754i.setText(text);
        if (this.f7753h.isShowing()) {
            this.f7753h.update();
        } else {
            this.f7753h.showAtLocation(getRootView(), 17, 0, 0);
        }
    }

    /* renamed from: a */
    public void m8931a() {
        this.f7748c = false;
        this.f7746a = -1;
        this.f7755j.postDelayed(this.f7749d, 800);
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOnItemClickListener(C2350a listener) {
        this.f7750e = listener;
    }

    /* renamed from: a */
    private void m8929a(int item) {
        if (this.f7750e != null) {
            this.f7750e.m8927a(this.f7752g[item]);
            m8930a(this.f7752g[item]);
        }
    }
}
