package com.baidu.ufosdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.p248b.C5172e;
import com.baidu.ufosdk.util.C5210c;

public class FeedbackImageViewFlipperActivity extends Activity implements OnGestureListener {
    /* renamed from: a */
    private GestureDetector f21453a;
    /* renamed from: b */
    private ViewFlipper f21454b;

    protected void onCreate(Bundle bundle) {
        int i;
        int i2 = 0;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        View linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(-16777216);
        this.f21454b = new ViewFlipper(this);
        linearLayout.addView(this.f21454b, layoutParams);
        setContentView(linearLayout);
        this.f21453a = new GestureDetector(this);
        for (int i3 = 0; i3 < FeedbackInputActivity.f21455a.size(); i3++) {
            if (FeedbackInputActivity.f21456b.equals(FeedbackInputActivity.f21455a.get(i3))) {
                i = i3;
                break;
            }
        }
        i = 0;
        for (int i4 = i; i4 < FeedbackInputActivity.f21455a.size(); i4++) {
            View imageView = new ImageView(this);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ScaleType.FIT_CENTER);
            imageView.setImageBitmap((Bitmap) FeedbackInputActivity.f21455a.get(i4));
            this.f21454b.addView(imageView, new LayoutParams(-1, -1));
        }
        while (i2 < i) {
            View imageView2 = new ImageView(this);
            imageView2.setAdjustViewBounds(true);
            imageView2.setScaleType(ScaleType.FIT_CENTER);
            imageView2.setImageBitmap((Bitmap) FeedbackInputActivity.f21455a.get(i2));
            this.f21454b.addView(imageView2, new LayoutParams(-1, -1));
            i2++;
        }
        this.f21454b.setAutoStart(true);
        this.f21454b.setFlipInterval(3000);
        if (this.f21454b.isAutoStart() && !this.f21454b.isFlipping()) {
            this.f21454b.startFlipping();
        }
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        super.onResume();
        if (C5167a.ah != null) {
            C5167a.ah.onResumeCallback();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f21454b.stopFlipping();
        this.f21454b.setAutoStart(false);
        return this.f21453a.onTouchEvent(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        C5210c.m17734b("onFling");
        Animation translateAnimation;
        Animation translateAnimation2;
        if (motionEvent2.getX() - motionEvent.getX() > 60.0f) {
            translateAnimation = new TranslateAnimation((float) (-C5172e.m17562a(this)[0]), 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(500);
            translateAnimation2 = new TranslateAnimation(0.0f, (float) C5172e.m17562a(this)[0], 0.0f, 0.0f);
            translateAnimation2.setDuration(500);
            this.f21454b.setInAnimation(translateAnimation);
            this.f21454b.setOutAnimation(translateAnimation2);
            this.f21454b.showNext();
        } else if (motionEvent2.getX() - motionEvent.getX() < -60.0f) {
            translateAnimation = new TranslateAnimation((float) C5172e.m17562a(this)[0], 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(500);
            translateAnimation2 = new TranslateAnimation(0.0f, (float) (-C5172e.m17562a(this)[0]), 0.0f, 0.0f);
            translateAnimation2.setDuration(500);
            this.f21454b.setInAnimation(translateAnimation);
            this.f21454b.setOutAnimation(translateAnimation2);
            this.f21454b.showPrevious();
        }
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        finish();
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }
}
