package com.baidu.navi.routedetails;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.util.C2188r;
import com.baidu.navisdk.util.common.LogUtil;

public class RGRouteDetailsOutlineItemView extends LinearLayout {
    private AnimationSet animationExperienceSet;
    private AnimationSet animationScrownSet;
    private boolean hasSetupStampAnimation = false;
    private boolean initSucceeded = false;
    private boolean isFiveStarRoute = false;
    private boolean isFocus = false;
    private Activity mActivity;
    private View mAnimationLayout;
    private ImageView mAnimationStampView;
    private RelativeLayout mDetailItemLL;
    private TextView mDistTv;
    private GestureDetector mGestureDetector;
    private TextView mLightsNew;
    private int mOrientation;
    private int mRouteIndex;
    private TextView mRouteTag;
    private TextView mTimeTv;
    private OnDragOpenListener mTragOpenListener;
    private int testcount = 0;

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsOutlineItemView$1 */
    class C39441 implements OnClickListener {
        C39441() {
        }

        public void onClick(View v) {
            if (RGRouteDetailsOutlineItemView.this.mTragOpenListener != null) {
                RGRouteDetailsOutlineItemView.this.mTragOpenListener.onClick();
            }
        }
    }

    class MyOnGestureListener extends SimpleOnGestureListener {
        MyOnGestureListener() {
        }

        public boolean onSingleTapUp(MotionEvent e) {
            if (RGRouteDetailsOutlineItemView.this.mTragOpenListener != null) {
                RGRouteDetailsOutlineItemView.this.mTragOpenListener.onClick();
            }
            return false;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }

    public interface OnDragOpenListener {
        void onClick();

        void onOpen();
    }

    public RGRouteDetailsOutlineItemView(Context context) {
        super(context);
        this.initSucceeded = setupView((Activity) context);
    }

    private boolean setupView(Activity activity) {
        this.mActivity = activity;
        this.mOrientation = activity.getResources().getConfiguration().orientation;
        View view = this.mActivity.getLayoutInflater().inflate(C0965R.layout.nsdk_layout_rd_route_detail_outline_item_land, this);
        if (view == null) {
            LogUtil.m15791e("RGRouteDetailsOutlineItemView", "setupView: -->> Inflate failed!");
            return false;
        }
        this.mTimeTv = (TextView) view.findViewById(C0965R.id.tv_route_time);
        this.mDistTv = (TextView) view.findViewById(C0965R.id.tv_route_distance);
        this.mRouteTag = (TextView) view.findViewById(C0965R.id.tv_route_tag);
        this.mLightsNew = (TextView) view.findViewById(C0965R.id.tv_lights_new);
        this.mDetailItemLL = (RelativeLayout) view.findViewById(C0965R.id.ll_route_detail_item);
        if (this.mDetailItemLL != null) {
            this.mDetailItemLL.setBackground(C2188r.b(C0965R.drawable.com_bg_item_selector));
            this.mDetailItemLL.setOnClickListener(new C39441());
        }
        return true;
    }

    public boolean isInitSucceeded() {
        return this.initSucceeded;
    }

    public void setData(String time, String dist, String tagName, int lights, int index) {
        if (this.initSucceeded) {
            this.mTimeTv.setText(time);
            this.mDistTv.setText(dist);
            this.mRouteTag.setText(tagName);
            this.mLightsNew.setText("红绿灯" + lights + "个");
            this.mRouteIndex = index;
        }
    }

    public void focusItem() {
        if (this.initSucceeded && this.mActivity != null) {
            this.mTimeTv.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_other_c));
            this.mDistTv.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_other_c));
            this.mRouteTag.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_other_c));
            this.mLightsNew.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_other_c));
            this.isFocus = true;
        }
    }

    public void unfocusItem() {
        if (this.initSucceeded) {
            this.mTimeTv.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_text_a5_title));
            this.mDistTv.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_text_a2_content));
            this.mRouteTag.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_text_a2_content));
            this.mLightsNew.setTextColor(this.mActivity.getResources().getColor(C0965R.color.cl_text_a2_content));
            this.isFocus = false;
        }
    }

    public int getRouteIndex() {
        return this.mRouteIndex;
    }

    public void setTragOpenListener(OnDragOpenListener lis) {
        this.mTragOpenListener = lis;
    }

    public View getDetailItem() {
        return this.mDetailItemLL;
    }
}
