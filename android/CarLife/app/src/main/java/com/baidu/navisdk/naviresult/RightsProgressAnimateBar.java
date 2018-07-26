package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.naviresult.OnSizeChangedRelativeLayout.OnSizeChangedListener;
import com.baidu.navisdk.naviresult.ProgressIncreasingBar.OnAnimationStateListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RightsProgressAnimateBar extends RelativeLayout {
    private static final String TAG = RightsProgressAnimateBar.class.getSimpleName();
    private boolean animateFinish = false;
    private RelativeLayout currentProgressPointer;
    private boolean isLocal = false;
    private OnSizeChangedRelativeLayout kilosContainer;
    private View kilosPointerIc;
    private int kilosPointerIcWidth = 0;
    private TextView kilosTv;
    private int kilosTvCornerWidth = 0;
    private int kilosTvWidth = 0;
    private Handler mHandler = null;
    private BNNaviResultModel model = BNNaviResultModel.getInstance();
    private ProgressIncreasingBar newlyObtainedProgressBar;
    private int newlyObtainedWidth = 0;
    private View presentProgressBar;
    private int presentWidth = 0;
    private ImageView rightsLableIc;
    private boolean sizeChangeFinish = false;
    private int totalWidth = 0;

    /* renamed from: com.baidu.navisdk.naviresult.RightsProgressAnimateBar$1 */
    class C42561 implements OnSizeChangedListener {
        C42561() {
        }

        public void OnSizeChanged(int w, int h, int oldw, int oldh) {
            LogUtil.m15791e(RightsProgressAnimateBar.TAG, "onSizeChanged: w -->> " + w);
            if (RightsProgressAnimateBar.this.kilosTvWidth == 0 && w != 0) {
                RightsProgressAnimateBar.this.sizeChangeFinish = true;
                RightsProgressAnimateBar.this.kilosTvWidth = w;
                RightsProgressAnimateBar.this.delayShowKilosPointer();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.RightsProgressAnimateBar$3 */
    class C42583 implements OnAnimationStateListener {
        C42583() {
        }

        public void onAnimationFinish(boolean finished) {
            LogUtil.m15791e(RightsProgressAnimateBar.TAG, "onAnimationFinish:  -->> ");
            RightsProgressAnimateBar.this.animateFinish = true;
            RightsProgressAnimateBar.this.showKilosPointer(true);
        }
    }

    public RightsProgressAnimateBar(Context context) {
        super(context);
    }

    public RightsProgressAnimateBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initVariables() {
        this.mHandler = new Handler();
        this.totalWidth = 0;
        this.presentWidth = 0;
        this.newlyObtainedWidth = 0;
        this.kilosTvWidth = 0;
        this.kilosPointerIcWidth = 0;
        this.kilosTvCornerWidth = 0;
        this.isLocal = false;
        this.sizeChangeFinish = false;
        this.animateFinish = false;
    }

    public void init() {
        if (this.kilosTv != null) {
            this.kilosTv.setText(this.model.getTotalDistanceStr());
        }
    }

    public void updateRightsLabelIc() {
        if (this.rightsLableIc == null || BusinessActivityManager.getInstance().getModel().userRightIconBitmapEnd == null) {
            LogUtil.m15791e(TAG, "updateRightsLabelIc: bitmap -->> " + BusinessActivityManager.getInstance().getModel().userRightIconBitmapEnd);
            return;
        }
        Drawable drawable = BNNaviResultController.getInstance().getDrawableFromBitmap(BusinessActivityManager.getInstance().getModel().userRightIconBitmapEnd);
        if (drawable != null) {
            this.rightsLableIc.setImageDrawable(drawable);
        }
    }

    public void updateProgress(int initialPercent, int currentPercent, boolean animate, boolean isLocal) {
        this.isLocal = isLocal;
        LogUtil.m15791e(TAG, "updateProgress: -->> isLocal: " + isLocal + ", initialPercent: " + initialPercent + ", currentPercent: " + currentPercent);
        if (currentPercent < initialPercent) {
            showKilosPointer(true);
            return;
        }
        showKilosPointer(false);
        this.presentWidth = (int) (((float) this.totalWidth) * (((float) initialPercent) / 100.0f));
        this.newlyObtainedWidth = (int) (((float) this.totalWidth) * (((float) (currentPercent - initialPercent)) / 100.0f));
        if (initialPercent == currentPercent) {
            animate = false;
        }
        arrangeContent(initialPercent, currentPercent, animate);
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        initVariables();
        this.currentProgressPointer = (RelativeLayout) findViewById(C4048R.id.current_progress_pointer_area);
        this.kilosContainer = (OnSizeChangedRelativeLayout) findViewById(C4048R.id.kilos_container);
        this.kilosTv = (TextView) findViewById(C4048R.id.kilos_tv);
        this.kilosPointerIc = findViewById(C4048R.id.kilos_pointer_ic);
        this.rightsLableIc = (ImageView) findViewById(C4048R.id.rights_lable_ic);
        this.presentProgressBar = findViewById(C4048R.id.present_progress_bar);
        this.newlyObtainedProgressBar = (ProgressIncreasingBar) findViewById(C4048R.id.current_progress_bar);
        this.totalWidth = ScreenUtil.getInstance().getWidthPixels();
        this.kilosPointerIcWidth = ScreenUtil.getInstance().dip2px(9);
        this.kilosTvCornerWidth = ScreenUtil.getInstance().dip2px(4);
        this.kilosContainer.setListener(new C42561());
    }

    private void delayShowKilosPointer() {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("delayShowKilosPointer-" + getClass().getSimpleName(), null) {
            protected String execute() {
                RightsProgressAnimateBar.this.showKilosPointer(true);
                return null;
            }
        }, new BNWorkerConfig(3, 0));
    }

    private void arrangeContent(int initialPercent, int currentPercent, boolean animate) {
        setWidth(this.presentProgressBar, this.presentWidth);
        setWidth(this.newlyObtainedProgressBar, this.newlyObtainedWidth);
        this.newlyObtainedProgressBar.setListener(new C42583());
        this.newlyObtainedProgressBar.setProgress(1.0d);
        this.newlyObtainedProgressBar.setRateBackgroundId(C4048R.drawable.navi_result_current_progress_bar_bg, true, this.newlyObtainedWidth, ScreenUtil.getInstance().dip2px(40));
        this.newlyObtainedProgressBar.setOrientation(0);
        this.newlyObtainedProgressBar.setAnim(animate);
        if (!animate) {
            this.animateFinish = true;
            showKilosPointer(true);
        }
    }

    private synchronized void showKilosPointer(boolean show) {
        if (this.currentProgressPointer != null) {
            if (show) {
                LogUtil.m15791e(TAG, "showKilosPointer: -->> animateFinish: " + this.animateFinish + ", sizeChangeFinish: " + this.sizeChangeFinish);
                if (this.animateFinish && this.sizeChangeFinish) {
                    int targetPositionX = this.presentWidth + this.newlyObtainedWidth;
                    int leftPointer = getSuitableLeftMargin(targetPositionX, this.kilosPointerIcWidth, this.totalWidth, this.kilosTvCornerWidth, this.kilosTvCornerWidth);
                    int leftkilos = getSuitableLeftMargin(targetPositionX, this.kilosTvWidth, this.totalWidth, 2, 2);
                    setMargins(this.kilosContainer, leftkilos, 0, 2, 0);
                    LogUtil.m15791e(TAG, "showKilosPointer: -->> kilosContainer leftkilos: " + leftkilos);
                    setMargins(this.kilosPointerIc, leftPointer, 0, this.kilosTvCornerWidth, 0);
                    LogUtil.m15791e(TAG, "showKilosPointer: -->> kilosPointerIc leftPointer: " + leftPointer);
                    this.currentProgressPointer.setVisibility(0);
                    LogUtil.m15791e(TAG, "showKilosPointer: show -->> done");
                }
            } else {
                this.currentProgressPointer.setVisibility(4);
                LogUtil.m15791e(TAG, "showKilosPointer: hide -->> done");
            }
        }
    }

    private int getSuitableLeftMargin(int targetPositionX, int viewWidth, int screenWidth, int minLeftMargin, int minRightMargin) {
        int maxLeftMargin = (screenWidth - minRightMargin) - viewWidth;
        int targetLeftMargin = targetPositionX - ((int) Math.ceil((double) (((float) viewWidth) / 2.0f)));
        int targetRightX = targetLeftMargin + viewWidth;
        if (targetLeftMargin < 0) {
            return minLeftMargin;
        }
        if (targetRightX <= screenWidth - minRightMargin) {
            return targetLeftMargin;
        }
        return maxLeftMargin;
    }

    public void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof MarginLayoutParams) {
            int lo;
            int to;
            int ro;
            int bo;
            MarginLayoutParams p = (MarginLayoutParams) v.getLayoutParams();
            if (l < 0) {
                lo = p.leftMargin;
            } else {
                lo = l;
            }
            if (t < 0) {
                to = p.topMargin;
            } else {
                to = t;
            }
            if (r < 0) {
                ro = p.rightMargin;
            } else {
                ro = r;
            }
            if (b < 0) {
                bo = p.bottomMargin;
            } else {
                bo = b;
            }
            p.setMargins(lo, to, ro, bo);
            v.setLayoutParams(p);
            v.requestLayout();
        }
    }

    public void setWidth(View v, int w) {
        if (v.getLayoutParams() instanceof MarginLayoutParams) {
            LayoutParams p = v.getLayoutParams();
            p.width = w;
            v.setLayoutParams(p);
            v.requestLayout();
        }
    }
}
