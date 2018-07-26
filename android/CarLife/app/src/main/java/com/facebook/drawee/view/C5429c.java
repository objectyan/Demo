package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.facebook.drawee.p146d.C2933q.C2932b;
import com.facebook.drawee.p146d.q$c;
import com.facebook.drawee.p147e.C2934a;

@TargetApi(19)
/* compiled from: DraweeTransition */
/* renamed from: com.facebook.drawee.view.c */
public class C5429c extends Transition {
    /* renamed from: a */
    private static final String f22170a = "draweeTransition:bounds";
    /* renamed from: b */
    private final q$c f22171b;
    /* renamed from: c */
    private final q$c f22172c;

    /* renamed from: a */
    public static TransitionSet m18655a(q$c fromScale, q$c toScale) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new C5429c(fromScale, toScale));
        return transitionSet;
    }

    public C5429c(q$c fromScale, q$c toScale) {
        this.f22171b = fromScale;
        this.f22172c = toScale;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        m18657a(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        m18657a(transitionValues);
    }

    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        if (startValues == null || endValues == null) {
            return null;
        }
        Rect startBounds = (Rect) startValues.values.get(f22170a);
        Rect endBounds = (Rect) endValues.values.get(f22170a);
        if (startBounds == null || endBounds == null || this.f22171b == this.f22172c) {
            return null;
        }
        final GenericDraweeView draweeView = startValues.view;
        final C2932b scaleType = new C2932b(this.f22171b, this.f22172c, startBounds, endBounds);
        ((C2934a) draweeView.getHierarchy()).a(scaleType);
        Animator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        animator.addUpdateListener(new AnimatorUpdateListener(this) {
            /* renamed from: b */
            final /* synthetic */ C5429c f22167b;

            public void onAnimationUpdate(ValueAnimator animation) {
                scaleType.a(((Float) animation.getAnimatedValue()).floatValue());
            }
        });
        animator.addListener(new AnimatorListenerAdapter(this) {
            /* renamed from: b */
            final /* synthetic */ C5429c f22169b;

            public void onAnimationEnd(Animator animation) {
                ((C2934a) draweeView.getHierarchy()).a(this.f22169b.f22172c);
            }
        });
        return animator;
    }

    /* renamed from: a */
    private void m18657a(TransitionValues transitionValues) {
        if (transitionValues.view instanceof GenericDraweeView) {
            transitionValues.values.put(f22170a, new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }
}
