package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMRPPreferView extends BNBaseView {
    private static String TAG = RGMMRPPreferView.class.getName();
    private final String[] TIPS_TEXT_CONTENT = new String[]{"躲避拥堵/", "高速优先/", "不走高速/", "少收费/"};
    private final String TIPS_TEXT_DEFAULT = "推荐";
    private final String TIPS_TEXT_PREFIX = "正在使用";
    private final String TIPS_TEXT_SUFFIX = "方案";
    private ViewGroup mRPPreferContainer = null;
    private TextView mRPPreferTV = null;
    private View mRPPreferView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRPPreferView$1 */
    class C44181 implements OnTouchListener {
        C44181() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public RGMMRPPreferView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    public void orientationChanged(ViewGroup p, int orien) {
        if (this.mCurOrientation != orien) {
            super.orientationChanged(p, orien);
        }
    }

    private void initViews() {
        if (this.mRootViewGroup != null && this.mRPPreferContainer != null) {
            this.mRPPreferContainer.removeAllViews();
            this.mRPPreferView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_common_card, null);
            if (this.mRPPreferView != null) {
                this.mRPPreferTV = (TextView) this.mRPPreferView.findViewById(C4048R.id.common_card_text);
                this.mRPPreferContainer.addView(this.mRPPreferView, new LayoutParams(-1, -2));
            }
        }
    }

    private void initListener() {
        if (this.mRPPreferContainer != null) {
            this.mRPPreferContainer.setOnTouchListener(new C44181());
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "show()");
        if (this.mRPPreferContainer != null) {
            this.mRPPreferContainer.setVisibility(0);
        }
        if (this.mRPPreferTV != null) {
            String tips = getTipsText();
            SpannableStringBuilder ssb = new SpannableStringBuilder(tips);
            ssb.setSpan(new ForegroundColorSpan(-1), "正在使用".length(), tips.length() - "方案".length(), 33);
            ssb.setSpan(new RelativeSizeSpan(1.05f), "正在使用".length(), tips.length() - "方案".length(), 33);
            this.mRPPreferTV.setText(ssb);
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "hide()");
        if (this.mRPPreferContainer != null) {
            this.mRPPreferContainer.setVisibility(8);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    private String getTipsText() {
        StringBuilder tips = new StringBuilder("正在使用");
        try {
            int preferValue = BNRoutePlaner.getInstance().getCalcPreference();
            if (isOnLineNetMode() && (preferValue & 16) != 0) {
                tips.append(this.TIPS_TEXT_CONTENT[0]);
            }
            if ((preferValue & 2) != 0) {
                tips.append(this.TIPS_TEXT_CONTENT[1]);
            }
            if ((preferValue & 4) != 0) {
                tips.append(this.TIPS_TEXT_CONTENT[2]);
            }
            if ((preferValue & 8) != 0) {
                tips.append(this.TIPS_TEXT_CONTENT[3]);
            }
            if (tips.toString().equals("正在使用")) {
                tips.append("推荐");
            } else if (tips.toString().length() >= 1) {
                tips = new StringBuilder(tips.substring(0, tips.toString().length() - 1));
            }
            tips.append("方案");
        } catch (Exception e) {
        }
        return tips.toString();
    }

    private boolean isOnLineNetMode() {
        int netMode = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
        if (netMode == 3 || netMode == 1) {
            return true;
        }
        return false;
    }
}
