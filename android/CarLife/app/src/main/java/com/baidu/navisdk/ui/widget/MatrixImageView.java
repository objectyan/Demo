package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MatrixImageView extends ImageView {
    private static final String TAG = "MatrixImageView";
    private GestureDetector mGestureDetector;
    public float mImageHeight;
    public float mImageWidth;
    private Matrix mMatrix = new Matrix();

    private class GestureListener extends SimpleOnGestureListener {
        private final MatrixTouchListener listener;

        public GestureListener(MatrixTouchListener listener) {
            this.listener = listener;
        }

        public boolean onDown(MotionEvent e) {
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }
    }

    public class MatrixTouchListener implements OnTouchListener {
        private static final int MODE_DRAG = 1;
        private static final int MODE_UNABLE = 3;
        private static final int MODE_ZOOM = 2;
        private Matrix mCurrentMatrix = new Matrix();
        float mDobleClickScale = 2.0f;
        float mMaxScale = 6.0f;
        float mMinScale = 1.0f;
        private int mMode = 0;
        private float mStartDis;
        private PointF startPoint = new PointF();

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getActionMasked()) {
                case 0:
                    this.mMode = 1;
                    this.startPoint.set(event.getX(), event.getY());
                    isMatrixEnable();
                    break;
                case 1:
                case 3:
                    reSetMatrix();
                    break;
                case 2:
                    if (this.mMode != 2) {
                        if (this.mMode == 1) {
                            setDragMatrix(event);
                            break;
                        }
                    }
                    setZoomMatrix(event);
                    break;
                    break;
                case 5:
                    if (this.mMode != 3) {
                        this.mMode = 2;
                        this.mStartDis = distance(event);
                        break;
                    }
                    return true;
            }
            return MatrixImageView.this.mGestureDetector.onTouchEvent(event);
        }

        protected void center(boolean horizontal, boolean vertical) {
            Matrix m = new Matrix();
            m.set(this.mCurrentMatrix);
            RectF rect = new RectF(0.0f, 0.0f, MatrixImageView.this.mImageWidth, MatrixImageView.this.mImageHeight);
            m.mapRect(rect);
            float height = rect.height();
            float width = rect.width();
            float deltaX = 0.0f;
            float deltaY = 0.0f;
            if (vertical) {
                int screenHeight = MatrixImageView.this.getHeight();
                if (height < ((float) screenHeight)) {
                    deltaY = ((((float) screenHeight) - height) / 2.0f) - rect.top;
                } else if (rect.top > 0.0f) {
                    deltaY = -rect.top;
                } else if (rect.bottom < ((float) screenHeight)) {
                    deltaY = ((float) screenHeight) - rect.bottom;
                }
            }
            if (horizontal) {
                int screenWidth = MatrixImageView.this.getWidth();
                if (width < ((float) screenWidth)) {
                    deltaX = ((((float) screenWidth) - width) / 2.0f) - rect.left;
                } else if (rect.left > 0.0f) {
                    deltaX = -rect.left;
                } else if (rect.right < ((float) screenWidth)) {
                    deltaX = ((float) screenWidth) - rect.right;
                }
            }
            this.mCurrentMatrix.postTranslate(deltaX, deltaY);
            MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
        }

        public void setDragMatrix(MotionEvent event) {
            if (isZoomChanged()) {
                float dx = event.getX() - this.startPoint.x;
                float dy = event.getY() - this.startPoint.y;
                if (Math.sqrt((double) ((dx * dx) + (dy * dy))) > 10.0d) {
                    this.startPoint.set(event.getX(), event.getY());
                    this.mCurrentMatrix.set(MatrixImageView.this.getImageMatrix());
                    float[] values = new float[9];
                    this.mCurrentMatrix.getValues(values);
                    this.mCurrentMatrix.postTranslate(checkDxBound(values, dx), checkDyBound(values, dy));
                    MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
                }
            }
        }

        private boolean isZoomChanged() {
            float[] values = new float[9];
            MatrixImageView.this.getImageMatrix().getValues(values);
            float scale = values[0];
            MatrixImageView.this.mMatrix.getValues(values);
            if (scale != values[0]) {
                return true;
            }
            return false;
        }

        private float checkDyBound(float[] values, float dy) {
            float height = (float) MatrixImageView.this.getHeight();
            if (MatrixImageView.this.mImageHeight * values[4] < height) {
                return 0.0f;
            }
            if (values[5] + dy > 0.0f) {
                dy = -values[5];
            } else if (values[5] + dy < (-((MatrixImageView.this.mImageHeight * values[4]) - height))) {
                dy = (-((MatrixImageView.this.mImageHeight * values[4]) - height)) - values[5];
            }
            return dy;
        }

        private float checkDxBound(float[] values, float dx) {
            float width = (float) MatrixImageView.this.getWidth();
            if (MatrixImageView.this.mImageWidth * values[0] < width) {
                return 0.0f;
            }
            if (values[2] + dx > 0.0f) {
                dx = -values[2];
            } else if (values[2] + dx < (-((MatrixImageView.this.mImageWidth * values[0]) - width))) {
                dx = (-((MatrixImageView.this.mImageWidth * values[0]) - width)) - values[2];
            }
            return dx;
        }

        private void setZoomMatrix(MotionEvent event) {
            if (event.getPointerCount() >= 2) {
                float endDis = distance(event);
                if (endDis > 10.0f) {
                    float scale = endDis / this.mStartDis;
                    this.mStartDis = endDis;
                    this.mCurrentMatrix.set(MatrixImageView.this.getImageMatrix());
                    float[] values = new float[9];
                    this.mCurrentMatrix.getValues(values);
                    scale = checkMaxScale(scale, values);
                    MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
                    center(true, true);
                }
            }
        }

        private float checkMaxScale(float scale, float[] values) {
            if (values[0] * scale > this.mMaxScale) {
                scale = this.mMaxScale / values[0];
            } else if (values[0] * scale < this.mMinScale) {
                scale = this.mMinScale / values[0];
                this.mCurrentMatrix.setScale(this.mMinScale, this.mMinScale);
                return scale;
            }
            this.mCurrentMatrix.postScale(scale, scale, (float) (MatrixImageView.this.getWidth() / 2), (float) (MatrixImageView.this.getHeight() / 2));
            return scale;
        }

        private void reSetMatrix() {
            if (checkRest()) {
                this.mCurrentMatrix.set(MatrixImageView.this.mMatrix);
                MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
            }
        }

        private boolean checkRest() {
            float[] values = new float[9];
            MatrixImageView.this.getImageMatrix().getValues(values);
            float scale = values[0];
            MatrixImageView.this.mMatrix.getValues(values);
            if (scale < values[0]) {
                return true;
            }
            return false;
        }

        private void isMatrixEnable() {
            if (MatrixImageView.this.getScaleType() != ScaleType.CENTER) {
                MatrixImageView.this.setScaleType(ScaleType.MATRIX);
            } else {
                this.mMode = 3;
            }
        }

        private float distance(MotionEvent event) {
            float dx = event.getX(1) - event.getX(0);
            float dy = event.getY(1) - event.getY(0);
            return (float) Math.sqrt((double) ((dx * dx) + (dy * dy)));
        }

        public void onDoubleClick() {
            float scale = isZoomChanged() ? 1.0f : this.mDobleClickScale;
            this.mCurrentMatrix.set(MatrixImageView.this.mMatrix);
            this.mCurrentMatrix.postScale(scale, scale, (float) (MatrixImageView.this.getWidth() / 2), (float) (MatrixImageView.this.getHeight() / 2));
            MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
        }
    }

    public MatrixImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setScaleType(ScaleType.FIT_CENTER);
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.mMatrix.set(getImageMatrix());
        float[] values = new float[9];
        this.mMatrix.getValues(values);
        this.mImageWidth /= values[0];
        this.mImageHeight = (this.mImageHeight - (values[5] * 2.0f)) / values[4];
    }

    public void start(float mMaxScale, float mMinScale, float mDobleClickScale) {
        MatrixTouchListener mListener = new MatrixTouchListener();
        mListener.mMaxScale = mMaxScale;
        mListener.mDobleClickScale = mDobleClickScale;
        mListener.mMinScale = mMinScale;
        setOnTouchListener(mListener);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(mListener));
    }
}
