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

public class MatrixImageView
  extends ImageView
{
  private static final String TAG = "MatrixImageView";
  private GestureDetector mGestureDetector;
  public float mImageHeight;
  public float mImageWidth;
  private Matrix mMatrix = new Matrix();
  
  public MatrixImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.mMatrix.set(getImageMatrix());
    paramBitmap = new float[9];
    this.mMatrix.getValues(paramBitmap);
    this.mImageWidth /= paramBitmap[0];
    this.mImageHeight = ((this.mImageHeight - paramBitmap[5] * 2.0F) / paramBitmap[4]);
  }
  
  public void start(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    MatrixTouchListener localMatrixTouchListener = new MatrixTouchListener();
    localMatrixTouchListener.mMaxScale = paramFloat1;
    localMatrixTouchListener.mDobleClickScale = paramFloat3;
    localMatrixTouchListener.mMinScale = paramFloat2;
    setOnTouchListener(localMatrixTouchListener);
    this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(localMatrixTouchListener));
  }
  
  private class GestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private final MatrixImageView.MatrixTouchListener listener;
    
    public GestureListener(MatrixImageView.MatrixTouchListener paramMatrixTouchListener)
    {
      this.listener = paramMatrixTouchListener;
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return super.onDoubleTapEvent(paramMotionEvent);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      super.onShowPress(paramMotionEvent);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
  
  public class MatrixTouchListener
    implements View.OnTouchListener
  {
    private static final int MODE_DRAG = 1;
    private static final int MODE_UNABLE = 3;
    private static final int MODE_ZOOM = 2;
    private Matrix mCurrentMatrix = new Matrix();
    float mDobleClickScale = 2.0F;
    float mMaxScale = 6.0F;
    float mMinScale = 1.0F;
    private int mMode = 0;
    private float mStartDis;
    private PointF startPoint = new PointF();
    
    public MatrixTouchListener() {}
    
    private float checkDxBound(float[] paramArrayOfFloat, float paramFloat)
    {
      float f2 = MatrixImageView.this.getWidth();
      if (MatrixImageView.this.mImageWidth * paramArrayOfFloat[0] < f2) {
        return 0.0F;
      }
      float f1;
      if (paramArrayOfFloat[2] + paramFloat > 0.0F) {
        f1 = -paramArrayOfFloat[2];
      }
      for (;;)
      {
        return f1;
        f1 = paramFloat;
        if (paramArrayOfFloat[2] + paramFloat < -(MatrixImageView.this.mImageWidth * paramArrayOfFloat[0] - f2)) {
          f1 = -(MatrixImageView.this.mImageWidth * paramArrayOfFloat[0] - f2) - paramArrayOfFloat[2];
        }
      }
    }
    
    private float checkDyBound(float[] paramArrayOfFloat, float paramFloat)
    {
      float f2 = MatrixImageView.this.getHeight();
      if (MatrixImageView.this.mImageHeight * paramArrayOfFloat[4] < f2) {
        return 0.0F;
      }
      float f1;
      if (paramArrayOfFloat[5] + paramFloat > 0.0F) {
        f1 = -paramArrayOfFloat[5];
      }
      for (;;)
      {
        return f1;
        f1 = paramFloat;
        if (paramArrayOfFloat[5] + paramFloat < -(MatrixImageView.this.mImageHeight * paramArrayOfFloat[4] - f2)) {
          f1 = -(MatrixImageView.this.mImageHeight * paramArrayOfFloat[4] - f2) - paramArrayOfFloat[5];
        }
      }
    }
    
    private float checkMaxScale(float paramFloat, float[] paramArrayOfFloat)
    {
      float f;
      if (paramArrayOfFloat[0] * paramFloat > this.mMaxScale) {
        f = this.mMaxScale / paramArrayOfFloat[0];
      }
      do
      {
        this.mCurrentMatrix.postScale(f, f, MatrixImageView.this.getWidth() / 2, MatrixImageView.this.getHeight() / 2);
        return f;
        f = paramFloat;
      } while (paramArrayOfFloat[0] * paramFloat >= this.mMinScale);
      paramFloat = this.mMinScale / paramArrayOfFloat[0];
      this.mCurrentMatrix.setScale(this.mMinScale, this.mMinScale);
      return paramFloat;
    }
    
    private boolean checkRest()
    {
      boolean bool = false;
      float[] arrayOfFloat = new float[9];
      MatrixImageView.this.getImageMatrix().getValues(arrayOfFloat);
      float f = arrayOfFloat[0];
      MatrixImageView.this.mMatrix.getValues(arrayOfFloat);
      if (f < arrayOfFloat[0]) {
        bool = true;
      }
      return bool;
    }
    
    private float distance(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    
    private void isMatrixEnable()
    {
      if (MatrixImageView.this.getScaleType() != ImageView.ScaleType.CENTER)
      {
        MatrixImageView.this.setScaleType(ImageView.ScaleType.MATRIX);
        return;
      }
      this.mMode = 3;
    }
    
    private boolean isZoomChanged()
    {
      boolean bool = false;
      float[] arrayOfFloat = new float[9];
      MatrixImageView.this.getImageMatrix().getValues(arrayOfFloat);
      float f = arrayOfFloat[0];
      MatrixImageView.this.mMatrix.getValues(arrayOfFloat);
      if (f != arrayOfFloat[0]) {
        bool = true;
      }
      return bool;
    }
    
    private void reSetMatrix()
    {
      if (checkRest())
      {
        this.mCurrentMatrix.set(MatrixImageView.this.mMatrix);
        MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
      }
    }
    
    private void setZoomMatrix(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getPointerCount() < 2) {}
      float f1;
      do
      {
        return;
        f1 = distance(paramMotionEvent);
      } while (f1 <= 10.0F);
      float f2 = f1 / this.mStartDis;
      this.mStartDis = f1;
      this.mCurrentMatrix.set(MatrixImageView.this.getImageMatrix());
      paramMotionEvent = new float[9];
      this.mCurrentMatrix.getValues(paramMotionEvent);
      checkMaxScale(f2, paramMotionEvent);
      MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
      center(true, true);
    }
    
    protected void center(boolean paramBoolean1, boolean paramBoolean2)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(this.mCurrentMatrix);
      RectF localRectF = new RectF(0.0F, 0.0F, MatrixImageView.this.mImageWidth, MatrixImageView.this.mImageHeight);
      localMatrix.mapRect(localRectF);
      float f5 = localRectF.height();
      float f4 = localRectF.width();
      float f3 = 0.0F;
      float f2 = 0.0F;
      float f1 = f2;
      int i;
      if (paramBoolean2)
      {
        i = MatrixImageView.this.getHeight();
        if (f5 < i) {
          f1 = (i - f5) / 2.0F - localRectF.top;
        }
      }
      else
      {
        f2 = f3;
        if (paramBoolean1)
        {
          i = MatrixImageView.this.getWidth();
          if (f4 >= i) {
            break label224;
          }
          f2 = (i - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        this.mCurrentMatrix.postTranslate(f2, f1);
        MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
        return;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break;
        }
        f1 = f2;
        if (localRectF.bottom >= i) {
          break;
        }
        f1 = i - localRectF.bottom;
        break;
        label224:
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else
        {
          f2 = f3;
          if (localRectF.right < i) {
            f2 = i - localRectF.right;
          }
        }
      }
    }
    
    public void onDoubleClick()
    {
      if (isZoomChanged()) {}
      for (float f = 1.0F;; f = this.mDobleClickScale)
      {
        this.mCurrentMatrix.set(MatrixImageView.this.mMatrix);
        this.mCurrentMatrix.postScale(f, f, MatrixImageView.this.getWidth() / 2, MatrixImageView.this.getHeight() / 2);
        MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
        return;
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool = true;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        bool = MatrixImageView.this.mGestureDetector.onTouchEvent(paramMotionEvent);
        do
        {
          return bool;
          this.mMode = 1;
          this.startPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          isMatrixEnable();
          break;
          reSetMatrix();
          break;
          if (this.mMode == 2)
          {
            setZoomMatrix(paramMotionEvent);
            break;
          }
          if (this.mMode != 1) {
            break;
          }
          setDragMatrix(paramMotionEvent);
          break;
        } while (this.mMode == 3);
        this.mMode = 2;
        this.mStartDis = distance(paramMotionEvent);
      }
    }
    
    public void setDragMatrix(MotionEvent paramMotionEvent)
    {
      if (isZoomChanged())
      {
        float f2 = paramMotionEvent.getX() - this.startPoint.x;
        float f1 = paramMotionEvent.getY() - this.startPoint.y;
        if (Math.sqrt(f2 * f2 + f1 * f1) > 10.0D)
        {
          this.startPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.mCurrentMatrix.set(MatrixImageView.this.getImageMatrix());
          paramMotionEvent = new float[9];
          this.mCurrentMatrix.getValues(paramMotionEvent);
          f2 = checkDxBound(paramMotionEvent, f2);
          f1 = checkDyBound(paramMotionEvent, f1);
          this.mCurrentMatrix.postTranslate(f2, f1);
          MatrixImageView.this.setImageMatrix(this.mCurrentMatrix);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/MatrixImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */