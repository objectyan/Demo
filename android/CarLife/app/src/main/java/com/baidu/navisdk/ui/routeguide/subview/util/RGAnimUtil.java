package com.baidu.navisdk.ui.routeguide.subview.util;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RGAnimUtil {
    private static IAnimationLister mAnimationListener;

    public interface IAnimationLister {
        void onEnd1();

        void onEnd2();
    }

    private static final class DisplayNextView implements AnimationListener {
        private View mDestView;
        private final int mPosition;

        private DisplayNextView(int position, View destView) {
            this.mPosition = position;
            this.mDestView = destView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            LogUtil.m15791e("anim", "src onAnimationEnd");
            BNWorkerCenter.getInstance().submitMainThreadTask(new SwapViews("RGAnimUtil.SwapViews", null, this.mPosition, this.mDestView), new BNWorkerConfig(2, 0));
            RGAnimUtil.mAnimationListener.onEnd1();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private static class Rotate3dAnimation extends Animation {
        private Camera mCamera;
        private final float mCenterX;
        private final float mCenterY;
        private final float mDepthZ;
        private final float mFromDegrees;
        private final boolean mReverse;
        private final float mToDegrees;

        public Rotate3dAnimation(float fromDegrees, float toDegrees, float centerX, float centerY, float depthZ, boolean reverse) {
            this.mFromDegrees = fromDegrees;
            this.mToDegrees = toDegrees;
            this.mCenterX = centerX;
            this.mCenterY = centerY;
            this.mDepthZ = depthZ;
            this.mReverse = reverse;
        }

        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            this.mCamera = new Camera();
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float fromDegrees = this.mFromDegrees;
            float degrees = fromDegrees + ((this.mToDegrees - fromDegrees) * interpolatedTime);
            float centerX = this.mCenterX;
            float centerY = this.mCenterY;
            Camera camera = this.mCamera;
            Matrix matrix = t.getMatrix();
            camera.save();
            if (this.mReverse) {
                camera.translate(0.0f, 0.0f, this.mDepthZ * interpolatedTime);
            } else {
                camera.translate(0.0f, 0.0f, this.mDepthZ * (1.0f - interpolatedTime));
            }
            camera.rotateY(degrees);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-centerX, -centerY);
            matrix.postTranslate(centerX, centerY);
        }
    }

    private static final class SwapViews<K, T> extends BNWorkerNormalTask<K, T> {
        private final int mPosition;
        private View mView;

        /* renamed from: com.baidu.navisdk.ui.routeguide.subview.util.RGAnimUtil$SwapViews$1 */
        class C44631 implements AnimationListener {
            C44631() {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                RGAnimUtil.mAnimationListener.onEnd2();
            }
        }

        public SwapViews(String taskName, K pInData, int position, View view) {
            super(taskName, pInData);
            this.mPosition = position;
            this.mView = view;
        }

        public T execute() {
            Rotate3dAnimation rotation;
            float centerX = ((float) this.mView.getWidth()) / 2.0f;
            float centerY = ((float) this.mView.getHeight()) / 2.0f;
            if (this.mPosition > -1) {
                this.mView.setVisibility(0);
                this.mView.requestFocus();
                rotation = new Rotate3dAnimation(90.0f, 180.0f, centerX, centerY, 310.0f, false);
            } else {
                this.mView.setVisibility(0);
                rotation = new Rotate3dAnimation(90.0f, 0.0f, centerX, centerY, 310.0f, false);
            }
            rotation.setDuration(500);
            rotation.setFillAfter(false);
            rotation.setRepeatMode(1);
            rotation.setInterpolator(new DecelerateInterpolator());
            rotation.setAnimationListener(new C44631());
            this.mView.startAnimation(rotation);
            return null;
        }
    }

    public static void applyRotation(ViewGroup srcViewGroup, View destView, int position, float start, float end) {
        Rotate3dAnimation rotation = new Rotate3dAnimation(start, end, ((float) srcViewGroup.getWidth()) / 2.0f, ((float) srcViewGroup.getHeight()) / 2.0f, 310.0f, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setRepeatMode(1);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(position, destView));
        srcViewGroup.startAnimation(rotation);
    }

    public static void setAnimationListener(IAnimationLister listener) {
        mAnimationListener = listener;
    }
}
