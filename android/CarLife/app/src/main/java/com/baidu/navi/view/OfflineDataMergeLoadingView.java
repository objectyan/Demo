package com.baidu.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;

public class OfflineDataMergeLoadingView extends FrameLayout {
    private Animation mAnim;
    private Context mContext;
    FrameLayout mFLLayout;
    private ImageView mMergeImage;

    public OfflineDataMergeLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        findView();
    }

    public OfflineDataMergeLoadingView(Context context) {
        super(context);
        this.mContext = context;
        findView();
    }

    private void findView() {
        View mRootParent = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C0965R.layout.bnavi_offline_data_merge_loading_view, this);
        this.mFLLayout = (FrameLayout) mRootParent.findViewById(C0965R.id.layout_merge);
        this.mMergeImage = (ImageView) mRootParent.findViewById(C0965R.id.img_merge);
        this.mAnim = AnimationUtils.loadAnimation(this.mContext, C0965R.drawable.offline_data_merge_loading);
    }

    public void startAnim() {
        this.mAnim.setRepeatMode(1);
        this.mAnim.setRepeatCount(-1);
        this.mMergeImage.startAnimation(this.mAnim);
    }

    public void showLoading() {
        startAnim();
        this.mFLLayout.setVisibility(0);
    }

    public void hideLoading() {
        this.mAnim.cancel();
        this.mFLLayout.setVisibility(8);
    }
}
