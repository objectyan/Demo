package com.baidu.carlife.view.recyclingviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.baidu.carlife.core.C1249d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RecyclingViewPager extends ViewPager {
    /* renamed from: a */
    private C2149a f7770a;
    /* renamed from: b */
    private HashMap<View, Integer> f7771b = new LinkedHashMap();
    /* renamed from: c */
    private boolean f7772c = false;
    /* renamed from: d */
    private float f7773d;
    /* renamed from: e */
    private float f7774e;
    /* renamed from: f */
    private boolean f7775f = true;
    /* renamed from: g */
    private boolean f7776g = false;

    /* renamed from: com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager$a */
    public interface C2149a {
        /* renamed from: a */
        void mo1783a(RecyclingViewPager recyclingViewPager, int i);
    }

    public RecyclingViewPager(Context context) {
        super(context);
        m8939c();
    }

    public RecyclingViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        m8939c();
    }

    public void setOnItemClickListener(C2149a onItemClickListener) {
        this.f7770a = onItemClickListener;
    }

    public void setChildrenView(int position, View view) {
        this.f7771b.put(view, Integer.valueOf(position));
    }

    /* renamed from: a */
    public boolean m8941a() {
        return this.f7775f;
    }

    /* renamed from: b */
    public boolean m8943b() {
        return this.f7776g;
    }

    public void setTouch(boolean touch) {
        this.f7776g = touch;
    }

    public void setSelectEnable(boolean selectEnable) {
        this.f7775f = selectEnable;
    }

    /* renamed from: a */
    public View m8940a(int position) {
        for (View view : this.f7771b.keySet()) {
            if (((Integer) this.f7771b.get(view)).intValue() == position) {
                return view;
            }
        }
        return null;
    }

    public HashMap<View, Integer> getChildrenViews() {
        return this.f7771b;
    }

    /* renamed from: a */
    public boolean m8942a(MotionEvent ev) {
        this.f7772c = true;
        return dispatchTouchEvent(ev);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.f7773d = ev.getX();
            if (!this.f7772c) {
                this.f7773d += (float) getLeft();
            }
            this.f7772c = false;
        } else if (ev.getAction() == 1) {
            float upX = ev.getX();
            if (!this.f7772c) {
                upX += (float) getLeft();
            }
            this.f7772c = false;
            int viewPosition = m8936a(upX);
            if (viewPosition >= 0) {
                if (viewPosition == getCurrentItem() && this.f7774e != 0.0f) {
                    this.f7775f = false;
                    setCurrentItem(viewPosition - 1);
                }
                this.f7776g = true;
                setCurrentItem(viewPosition);
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    protected int getChildDrawingOrder(int childCount, int i) {
        int position = getCurrentItem();
        if (position < 0) {
            return i;
        }
        if (i == childCount - 1) {
            if (position > i) {
                position = i;
            }
            return position;
        } else if (i == position) {
            return childCount - 1;
        } else {
            return i;
        }
    }

    /* renamed from: c */
    private void m8939c() {
        setPageTransformer(false, new ScalePageTransformer());
        setSpeedScroller(300);
        setChildrenDrawingOrderEnabled(true);
        this.f7776g = false;
    }

    private void setSpeedScroller(int duration) {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            C2354b scroller = new C2354b(getContext(), new AccelerateInterpolator());
            mScroller.set(this, scroller);
            scroller.m8952a(duration);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m8936a(float x) {
        int downOffset = m8937b(this.f7773d);
        int upOffset = m8937b(x);
        this.f7774e = x - this.f7773d;
        if (downOffset != upOffset) {
            return (getCurrentItem() + downOffset) - upOffset;
        }
        if (Math.abs(this.f7774e) > 10.0f) {
            return getCurrentItem();
        }
        if (upOffset == 0 && this.f7770a != null) {
            this.f7770a.mo1783a(this, getCurrentItem());
        }
        return getCurrentItem() + downOffset;
    }

    /* renamed from: b */
    private int m8937b(float x) {
        if (C1249d.m4334m()) {
            return m8938c(x);
        }
        float viewPagerLeft = (float) getLeft();
        float viewPagerRight = (float) getRight();
        float itemWidth = viewPagerRight - viewPagerLeft;
        if (x < viewPagerLeft - (2.0f * itemWidth)) {
            return -3;
        }
        if (((double) x) < ((double) viewPagerLeft) - (1.15d * ((double) itemWidth))) {
            return -2;
        }
        if (((double) x) < ((double) viewPagerLeft) - (0.3d * ((double) itemWidth))) {
            return -1;
        }
        if (((double) x) < ((double) viewPagerRight) + (0.3d * ((double) itemWidth))) {
            return 0;
        }
        if (((double) x) < ((double) viewPagerRight) + (1.15d * ((double) itemWidth))) {
            return 1;
        }
        if (x < (2.0f * itemWidth) + viewPagerRight) {
            return 2;
        }
        return 3;
    }

    /* renamed from: c */
    private int m8938c(float x) {
        float viewPagerLeft = (float) getLeft();
        float viewPagerRight = (float) getRight();
        float itemWidth = viewPagerRight - viewPagerLeft;
        if (x < viewPagerLeft - (3.0f * itemWidth)) {
            return -4;
        }
        if (((double) x) < ((double) viewPagerLeft) - (2.1d * ((double) itemWidth))) {
            return -3;
        }
        if (((double) x) < ((double) viewPagerLeft) - (1.2d * ((double) itemWidth))) {
            return -2;
        }
        if (((double) x) < ((double) viewPagerLeft) - (0.3d * ((double) itemWidth))) {
            return -1;
        }
        if (((double) x) < ((double) viewPagerRight) + (0.3d * ((double) itemWidth))) {
            return 0;
        }
        if (((double) x) < ((double) viewPagerRight) + (1.2d * ((double) itemWidth))) {
            return 1;
        }
        if (((double) x) < ((double) viewPagerRight) + (2.1d * ((double) itemWidth))) {
            return 2;
        }
        if (x < (3.0f * itemWidth) + viewPagerRight) {
            return 3;
        }
        return 4;
    }
}
