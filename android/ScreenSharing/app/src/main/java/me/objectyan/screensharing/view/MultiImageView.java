package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.p054k.p055a.C1626e;

public class MultiImageView extends ImageView {
    /* renamed from: a */
    private String f7196a;
    /* renamed from: b */
    private Drawable f7197b;
    /* renamed from: c */
    private ImageLoader f7198c;
    /* renamed from: d */
    private ImageContainer f7199d;

    public MultiImageView(Context context) {
        this(context, null);
    }

    public MultiImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setImageUrl(String url) {
        setImageUrl(url, C1626e.getImageLoader());
    }

    private void setImageUrl(String url, ImageLoader imageLoader) {
        this.f7196a = url;
        this.f7198c = imageLoader;
        m8465a(false);
    }

    public void setDefaultDrawable(Drawable defaultDrawable) {
        this.f7197b = defaultDrawable;
    }

    public void setDefaultDrawableResId(int defaultResId) {
        this.f7197b = BaiduNaviApplication.getInstance().getApplicationContext().getResources().getDrawable(defaultResId);
    }

    /* renamed from: a */
    private void m8465a(final boolean isInLayoutPass) {
        if (TextUtils.isEmpty(this.f7196a)) {
            if (this.f7199d != null) {
                this.f7199d.cancelRequest();
                this.f7199d = null;
            }
            setDefaultImageOrNull();
            return;
        }
        int width = getWidth();
        int height = getHeight();
        ScaleType scaleType = getScaleType();
        boolean wrapWidth = false;
        boolean wrapHeight = false;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width == -2) {
                wrapWidth = true;
            } else {
                wrapWidth = false;
            }
            if (getLayoutParams().height == -2) {
                wrapHeight = true;
            } else {
                wrapHeight = false;
            }
        }
        boolean isFullyWrapContent;
        if (wrapWidth && wrapHeight) {
            isFullyWrapContent = true;
        } else {
            isFullyWrapContent = false;
        }
        if (width != 0 || height != 0 || isFullyWrapContent) {
            int maxWidth;
            int maxHeight;
            if (!(this.f7199d == null || this.f7199d.getRequestUrl() == null)) {
                if (!this.f7199d.getRequestUrl().equals(this.f7196a)) {
                    this.f7199d.cancelRequest();
                    setDefaultImageOrNull();
                } else {
                    return;
                }
            }
            if (wrapWidth) {
                maxWidth = 0;
            } else {
                maxWidth = width;
            }
            if (wrapHeight) {
                maxHeight = 0;
            } else {
                maxHeight = height;
            }
            this.f7199d = this.f7198c.get(this.f7196a, new ImageListener(this) {
                /* renamed from: b */
                final /* synthetic */ MultiImageView f7195b;

                public void onErrorResponse(VolleyError error) {
                }

                public void onResponse(final ImageContainer response, boolean isImmediate) {
                    if (isImmediate && isInLayoutPass) {
                        this.f7195b.post(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C22291 f7193b;

                            public void run() {
                                this.f7193b.onResponse(response, false);
                            }
                        });
                    } else if (response.getBitmap() != null) {
                        this.f7195b.setImageBitmap(response.getBitmap());
                    } else if (this.f7195b.f7197b != null) {
                        this.f7195b.setImageDrawable(this.f7195b.f7197b);
                    }
                }
            }, maxWidth, maxHeight, scaleType);
        }
    }

    private void setDefaultImageOrNull() {
        if (this.f7197b != null) {
            setImageDrawable(this.f7197b);
        } else {
            setImageBitmap(null);
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        m8465a(true);
    }

    protected void onDetachedFromWindow() {
        if (this.f7199d != null) {
            this.f7199d.cancelRequest();
            setImageBitmap(null);
            this.f7199d = null;
        }
        super.onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
