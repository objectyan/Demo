package com.baidu.navisdk.ui.routeguide.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.widget.AlwaysMarqueeTextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGRouteDescWindow extends PopupWindow {
    private static final int MSG_DISMISS = 1;
    private static final String TAG = "RouteGuide";
    private final Context mContext;
    private AlwaysMarqueeTextView mEndNameTextView;
    private Handler mHandler = new C44541();
    private View mParent;
    private TextView mRouteDist;
    private TextView mRouteDistUnit;
    private TextView mRouteTime;
    protected OnRGSubViewListener mSubViewListener;

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.RGRouteDescWindow$1 */
    class C44541 extends Handler {
        C44541() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (RGRouteDescWindow.this.mContext != null && !((Activity) RGRouteDescWindow.this.mContext).isFinishing() && RGRouteDescWindow.this.isShowing()) {
                        RGRouteDescWindow.this.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.RGRouteDescWindow$2 */
    class C44552 implements OnKeyListener {
        C44552() {
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            LogUtil.m15791e("RouteGuide", "返回了");
            switch (keyCode) {
                case 4:
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.RGRouteDescWindow$3 */
    class C44563 implements OnDismissListener {
        C44563() {
        }

        public void onDismiss() {
            if (RGRouteDescWindow.this.mSubViewListener != null) {
                RGRouteDescWindow.this.mSubViewListener.onRouteDescWindowHide();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.RGRouteDescWindow$4 */
    class C44574 implements OnTouchListener {
        C44574() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public RGRouteDescWindow(Context context, View parent, OnRGSubViewListener listener) {
        super(context);
        this.mContext = context;
        this.mSubViewListener = listener;
        this.mParent = parent;
        View contentView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_route_desc_window, null);
        this.mRouteDist = (TextView) contentView.findViewById(C4048R.id.route_desc_distance);
        this.mRouteDistUnit = (TextView) contentView.findViewById(C4048R.id.route_desc_distance_unit);
        this.mRouteTime = (TextView) contentView.findViewById(C4048R.id.route_desc_time);
        this.mEndNameTextView = (AlwaysMarqueeTextView) contentView.findViewById(C4048R.id.route_desc_end_name);
        setWindowLayoutMode(-2, -2);
        setContentView(contentView);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(C4048R.style.RGRouteDescWinAnimation);
        onMeasureAndLayout();
        setOutsideTouchable(true);
        getContentView().setFocusableInTouchMode(true);
        setTouchable(true);
        getContentView().setOnKeyListener(new C44552());
        setOnDismissListener(new C44563());
        setTouchInterceptor(new C44574());
    }

    public void show() {
        LogUtil.m15791e("RouteGuide", "show");
        try {
            if (this.mContext != null && !((Activity) this.mContext).isFinishing()) {
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onRouteDescWindowShow();
                }
                onMeasureAndLayout();
                showAtLocation(this.mParent, 17, 0, 0);
                getContentView().setFocusable(true);
                setFocusable(true);
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, 2000);
            }
        } catch (Exception e) {
        }
    }

    private void onMeasureAndLayout() {
        getContentView().measure(MeasureSpec.makeMeasureSpec(ScreenUtil.getInstance().getWidthPixels(), Integer.MIN_VALUE), -2);
        setWidth(getContentView().getMeasuredWidth());
        setHeight(getContentView().getMeasuredHeight());
    }

    public void dismiss() {
        this.mHandler.removeMessages(1);
        if (this.mContext != null && !((Activity) this.mContext).isFinishing() && isShowing()) {
            if (this != null) {
                try {
                    super.dismiss();
                } catch (Exception e) {
                }
            }
            setFocusable(false);
            getContentView().setFocusable(false);
        }
    }

    public void setDistanceAndTime(int distance, int time) {
        String[] dist = StringUtils.formatDistance(distance, UnitLangEnum.ZH);
        String strTime = StringUtils.formatTime2(time, 2);
        this.mRouteDist.setText(dist[0]);
        this.mRouteDistUnit.setText(dist[1]);
        setRouteTime(strTime);
    }

    private void setRouteTime(String strTime) {
        Spannable WordtoSpan = new SpannableString(strTime);
        Matcher m = Pattern.compile("[0-9.<]+").matcher(strTime);
        while (m.find()) {
            WordtoSpan.setSpan(new ForegroundColorSpan(-5180122), m.start(), m.end(), 33);
        }
        this.mRouteTime.setText(WordtoSpan);
    }

    public void setEndName(String endName) {
        this.mEndNameTextView.setText(endName);
    }
}
