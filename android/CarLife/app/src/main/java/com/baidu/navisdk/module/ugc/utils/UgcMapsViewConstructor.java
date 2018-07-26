package com.baidu.navisdk.module.ugc.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class UgcMapsViewConstructor {
    private static ViewGroup btnContainer;
    private static boolean hasCloudData = false;
    private static CallBackListener mCallBack;
    private static OnClickListener mOnBtnClickListener = new C42372();

    /* renamed from: com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor$2 */
    static class C42372 implements OnClickListener {
        C42372() {
        }

        public void onClick(View v) {
            if (UgcMapsViewConstructor.mCallBack != null) {
                UgcMapsViewConstructor.mCallBack.onBtnClick(1);
            }
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u, "1", null, null);
        }
    }

    public interface CallBackListener {
        void onBtnClick(int i);
    }

    public interface YellowTipsCallback {
        void close();
    }

    public static void getUgcReportBtn(ViewGroup mBtnContainer, CallBackListener listener) {
        if (mBtnContainer != null && listener != null) {
            mCallBack = listener;
            if (hasCloudData) {
                constructUgcReportBtn(BNaviModuleManager.getContext(), mBtnContainer);
            } else {
                btnContainer = mBtnContainer;
            }
        }
    }

    private static void constructUgcReportBtn(Context mContext, final ViewGroup mContainer) {
        if (mContext != null && mContainer != null) {
            mContainer.setOnClickListener(mOnBtnClickListener);
            final ImageView mView = new ImageView(mContext);
            mView.setScaleType(ScaleType.FIT_XY);
            mView.setPadding(6, 6, 6, 6);
            new UgcImageLoaderUtils().updateUgcViewOnLine(4096, mView, new BNImageLoadingListener() {
                public void onLoadingStarted(String imageUri, View view) {
                }

                public void onLoadingFailed(String imageUri, View view, String failReason) {
                    mContainer.removeAllViews();
                    mContainer.addView(mView, new LayoutParams(-1, -1));
                    mContainer.setVisibility(0);
                    if (UgcMapsViewConstructor.mCallBack != null) {
                        UgcMapsViewConstructor.mCallBack.onBtnClick(8);
                    }
                }

                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage, int from) {
                    mContainer.removeAllViews();
                    mContainer.addView(mView, new LayoutParams(-1, -1));
                    mContainer.setVisibility(0);
                    if (UgcMapsViewConstructor.mCallBack != null) {
                        UgcMapsViewConstructor.mCallBack.onBtnClick(8);
                    }
                }
            });
        }
    }

    public static void updateUgcReportBtn() {
        hasCloudData = true;
        if (btnContainer != null) {
            constructUgcReportBtn(BNaviModuleManager.getContext(), btnContainer);
        }
    }

    public static void requestSoundsAuth() {
        if (mCallBack != null) {
            mCallBack.onBtnClick(4);
        }
    }

    public static void requestPhotoCaptureAuth() {
        if (mCallBack != null) {
            mCallBack.onBtnClick(3);
        }
    }

    public static View getUgcResYellowTipsView(Activity activity, final YellowTipsCallback mYellowTipsCallback) {
        View mView = null;
        if (activity != null) {
            mView = JarUtils.inflate(activity, C4048R.layout.ndsk_ugc_ugc_yellow_tips_layout, null);
            if (mView != null) {
                View closeView = mView.findViewById(C4048R.id.yellow_tips_close);
                if (closeView != null) {
                    closeView.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            if (mYellowTipsCallback != null) {
                                mYellowTipsCallback.close();
                            }
                        }
                    });
                }
            }
        }
        return mView;
    }
}
