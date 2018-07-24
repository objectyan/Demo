package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.LogUtil;

public class HomeCardMusicMelodyView extends View {
    /* renamed from: a */
    private Paint f7109a = new Paint();
    /* renamed from: b */
    private final int f7110b = CarlifeScreenUtil.m4331a().m4343c(2);
    /* renamed from: c */
    private final int f7111c = CarlifeScreenUtil.m4331a().m4335a(3.6f);
    /* renamed from: d */
    private int f7112d;
    /* renamed from: e */
    private int f7113e;
    /* renamed from: f */
    private int f7114f = 0;
    /* renamed from: g */
    private int f7115g = 0;
    /* renamed from: h */
    private int f7116h = 0;
    /* renamed from: i */
    private int f7117i;
    /* renamed from: j */
    private int f7118j;
    /* renamed from: k */
    private boolean f7119k = true;
    /* renamed from: l */
    private int[] f7120l = new int[]{4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9};

    public HomeCardMusicMelodyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7109a.setColor(1728053247);
        this.f7109a.setStrokeWidth(0.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7119k) {
            this.f7119k = false;
            this.f7112d = getWidth();
            this.f7113e = getHeight();
            this.f7115g = (this.f7112d - this.f7110b) / (this.f7110b + this.f7111c);
            this.f7116h = this.f7112d - (this.f7115g * (this.f7110b + this.f7111c));
            if (this.f7116h >= this.f7110b) {
                this.f7115g++;
                this.f7116h -= this.f7110b;
            }
            this.f7116h /= 2;
            LogUtil.d("HomeCardMusicMelodyView", "width = " + this.f7110b);
            LogUtil.d("HomeCardMusicMelodyView", "padding = " + this.f7111c);
            LogUtil.d("HomeCardMusicMelodyView", "margin = " + this.f7116h);
            LogUtil.d("HomeCardMusicMelodyView", "parentwidth = " + this.f7112d);
        }
        int i = 0;
        while (i < this.f7120l.length && i < this.f7115g) {
            this.f7117i = ((this.f7111c + this.f7110b) * i) + this.f7116h;
            this.f7118j = this.f7113e - ((int) ((((double) this.f7113e) * 0.1d) * ((double) this.f7120l[this.f7114f + i])));
            canvas.drawRect((float) this.f7117i, (float) this.f7118j, (float) (this.f7117i + this.f7110b), (float) this.f7113e, this.f7109a);
            i++;
        }
    }

    public void setStartIndex(int index) {
        if (this.f7115g + index < this.f7120l.length) {
            this.f7114f = index;
        }
    }
}
