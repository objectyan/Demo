package com.baidu.che.codriver.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.che.codriver.util.C2731l;

public class CustomNetworkImageView extends ImageView {
    /* renamed from: a */
    private String f9421a;
    /* renamed from: b */
    private int f9422b;
    /* renamed from: c */
    private int f9423c;
    /* renamed from: d */
    private ImageLoader f9424d;
    /* renamed from: e */
    private ImageContainer f9425e;
    /* renamed from: f */
    private Bitmap f9426f;
    /* renamed from: g */
    private boolean f9427g;
    /* renamed from: h */
    private Context f9428h;

    /* renamed from: com.baidu.che.codriver.widget.CustomNetworkImageView$2 */
    class C28702 implements ImageListener {
        /* renamed from: a */
        final /* synthetic */ CustomNetworkImageView f9420a;

        C28702(CustomNetworkImageView this$0) {
            this.f9420a = this$0;
        }

        public void onErrorResponse(VolleyError error) {
            if (this.f9420a.f9423c != 0) {
                this.f9420a.setImageResource(this.f9420a.f9423c);
            }
        }

        public void onResponse(final ImageContainer response, boolean isImmediate) {
            if (isImmediate) {
                this.f9420a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C28702 f9419b;

                    public void run() {
                        this.f9419b.onResponse(response, false);
                    }
                });
            } else if (response.getBitmap() != null) {
                this.f9420a.setImageBitmap(response.getBitmap());
            } else if (this.f9420a.f9422b != 0) {
                this.f9420a.setImageResource(this.f9420a.f9422b);
            }
        }
    }

    public void setLocalImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.f9427g = true;
        }
        this.f9426f = bitmap;
        requestLayout();
    }

    public CustomNetworkImageView(Context context) {
        this(context, null);
        this.f9428h = context;
    }

    public CustomNetworkImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.f9428h = context;
    }

    public CustomNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f9428h = context;
    }

    public void setImageUrl(String url, ImageLoader imageLoader) {
        this.f9427g = false;
        this.f9421a = url;
        this.f9424d = imageLoader;
        m10858a(false);
        m10857a();
    }

    public void setDefaultImageResId(int defaultImage) {
        this.f9422b = defaultImage;
    }

    public void setErrorImageResId(int errorImage) {
        this.f9423c = errorImage;
    }

    /* renamed from: a */
    void m10858a(final boolean isInLayoutPass) {
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
            if (TextUtils.isEmpty(this.f9421a)) {
                if (this.f9425e != null) {
                    this.f9425e.cancelRequest();
                    this.f9425e = null;
                }
                setDefaultImageOrNull();
                return;
            }
            int maxWidth;
            int maxHeight;
            if (!(this.f9425e == null || this.f9425e.getRequestUrl() == null)) {
                if (!this.f9425e.getRequestUrl().equals(this.f9421a)) {
                    this.f9425e.cancelRequest();
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
            this.f9425e = this.f9424d.get(this.f9421a, new ImageListener(this) {
                /* renamed from: b */
                final /* synthetic */ CustomNetworkImageView f9417b;

                public void onErrorResponse(VolleyError error) {
                    if (this.f9417b.f9423c != 0) {
                        this.f9417b.setImageResource(this.f9417b.f9423c);
                    }
                }

                public void onResponse(final ImageContainer response, boolean isImmediate) {
                    if (isImmediate && isInLayoutPass) {
                        this.f9417b.post(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C28681 f9415b;

                            public void run() {
                                this.f9415b.onResponse(response, false);
                            }
                        });
                    } else if (response.getBitmap() != null) {
                        this.f9417b.setImageBitmap(response.getBitmap());
                    } else if (this.f9417b.f9422b != 0) {
                        this.f9417b.setImageResource(this.f9417b.f9422b);
                    }
                }
            }, maxWidth, maxHeight, scaleType);
        }
    }

    private void setDefaultImageOrNull() {
        if (this.f9422b != 0) {
            setImageResource(this.f9422b);
        } else {
            setImageBitmap((Bitmap) null);
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        m10858a(true);
        if (this.f9427g) {
            setImageBitmap(this.f9426f);
        }
    }

    protected void onDetachedFromWindow() {
        if (this.f9425e != null) {
            this.f9425e.cancelRequest();
            setImageBitmap((Bitmap) null);
            this.f9425e = null;
        }
        super.onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* renamed from: a */
    public void m10857a() {
        if (this.f9425e == null || this.f9425e.getRequestUrl() == null || !this.f9425e.getRequestUrl().equals(this.f9421a)) {
            C2731l.m10230b(this.f9428h, CarlifeActivity.f2351c, this.f9421a);
            return;
        }
        int maxWidth;
        int maxHeight;
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
        this.f9424d.get(this.f9421a, new C28702(this), maxWidth, maxHeight, scaleType);
    }
}
