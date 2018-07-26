package com.baidu.navisdk.ui.download.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNOfflineDataMergeLoadingView extends FrameLayout {
    private Animation mAnim;
    private Context mContext;
    FrameLayout mFLLayout;
    private ImageView mMergeImage;

    public BNOfflineDataMergeLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        findView();
    }

    public BNOfflineDataMergeLoadingView(Context context) {
        super(context);
        this.mContext = context;
        findView();
    }

    private void findView() {
        View mRootParent = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_offline_data_merge_loading_view, this);
        this.mFLLayout = (FrameLayout) mRootParent.findViewById(C4048R.id.layout_merge);
        this.mMergeImage = (ImageView) mRootParent.findViewById(C4048R.id.img_merge);
        this.mAnim = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_offline_data_merge_loading);
    }

    public void startAnim() {
        this.mAnim.setRepeatCount(-1);
        this.mMergeImage.startAnimation(this.mAnim);
    }

    public void showLoading() {
        this.mFLLayout.setVisibility(0);
        startAnim();
    }

    public void hideLoading() {
        this.mAnim.cancel();
        this.mFLLayout.setVisibility(8);
    }
}
