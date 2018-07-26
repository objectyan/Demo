package com.baidu.baidunavis.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.widget.RouteErrorView;

public class BNLoadingView extends RelativeLayout {
    public static final int LOAD_END = 2;
    public static final int LOAD_FAIL = 3;
    public static final int LOAD_START = 1;
    private RelativeLayout mLoadFailTab = null;
    private RelativeLayout mLoadStartTab = null;
    private View mRootView = null;
    private RouteErrorView mRouteErrorView = null;

    /* renamed from: com.baidu.baidunavis.ui.widget.BNLoadingView$1 */
    class C09011 implements OnClickListener {
        C09011() {
        }

        public void onClick(View v) {
        }
    }

    public BNLoadingView(Context context) {
        super(context);
        initView(context);
        setMapClickable(false);
    }

    private void initView(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(C0965R.layout.car_navi_card_load, this);
        if (this.mRootView != null) {
            this.mRootView.findViewById(C0965R.id.load_root).setBackgroundColor(0);
            this.mLoadStartTab = (RelativeLayout) this.mRootView.findViewById(C0965R.id.load_plan_start);
            this.mLoadFailTab = (RelativeLayout) this.mRootView.findViewById(C0965R.id.load_plan_result);
            this.mRouteErrorView = (RouteErrorView) this.mRootView.findViewById(C0965R.id.route_error_view);
        }
    }

    public void setLoadFailAction(String prompt, OnClickListener retryClickListener) {
        if (!TextUtils.isEmpty(prompt) && this.mRouteErrorView != null) {
            this.mRouteErrorView.setText(prompt);
            this.mRouteErrorView.setRepeatButtonListener(retryClickListener);
        }
    }

    public void resetBottomLoadtab(int loadState) {
        if (loadState == 1) {
            setVisibility(0);
            if (this.mLoadStartTab != null) {
                this.mLoadStartTab.setVisibility(0);
            }
            if (this.mLoadFailTab != null) {
                this.mLoadFailTab.setVisibility(8);
            }
        } else if (loadState == 3) {
            setVisibility(0);
            if (this.mLoadStartTab != null) {
                this.mLoadStartTab.setVisibility(8);
            }
            if (this.mLoadFailTab != null) {
                this.mLoadFailTab.setVisibility(0);
            }
        } else if (loadState == 2) {
            setVisibility(8);
            if (this.mLoadStartTab != null) {
                this.mLoadStartTab.setVisibility(8);
            }
            if (this.mLoadFailTab != null) {
                this.mLoadFailTab.setVisibility(8);
            }
        }
    }

    private void setMapClickable(boolean clickable) {
        if (this.mLoadStartTab == null) {
            return;
        }
        if (clickable) {
            this.mLoadStartTab.setOnClickListener(null);
        } else {
            this.mLoadStartTab.setOnClickListener(new C09011());
        }
    }
}
