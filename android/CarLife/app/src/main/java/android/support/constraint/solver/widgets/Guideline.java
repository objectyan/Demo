package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class Guideline
  extends ConstraintWidget
{
  public static final int HORIZONTAL = 0;
  public static final int RELATIVE_BEGIN = 1;
  public static final int RELATIVE_END = 2;
  public static final int RELATIVE_PERCENT = 0;
  public static final int RELATIVE_UNKNWON = -1;
  public static final int VERTICAL = 1;
  private ConstraintAnchor mAnchor = this.mTop;
  private Rectangle mHead = new Rectangle();
  private int mHeadSize = 8;
  private boolean mIsPositionRelaxed = false;
  private int mMinimumPosition = 0;
  private int mOrientation = 0;
  protected int mRelativeBegin = -1;
  protected int mRelativeEnd = -1;
  protected float mRelativePercent = -1.0F;
  
  public Guideline()
  {
    this.mAnchors.clear();
    this.mAnchors.add(this.mAnchor);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    ConstraintWidgetContainer localConstraintWidgetContainer = (ConstraintWidgetContainer)getParent();
    if (localConstraintWidgetContainer == null) {}
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    do
    {
      return;
      localConstraintAnchor1 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
      localConstraintAnchor2 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
      if (this.mOrientation == 0)
      {
        localConstraintAnchor1 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
        localConstraintAnchor2 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
      }
      if (this.mRelativeBegin != -1)
      {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor1), this.mRelativeBegin, false));
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor2), -this.mRelativeEnd, false));
        return;
      }
    } while (this.mRelativePercent == -1.0F);
    paramLinearSystem.addConstraint(LinearSystem.createRowDimensionPercent(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor1), paramLinearSystem.createObjectVariable(localConstraintAnchor2), this.mRelativePercent, this.mIsPositionRelaxed));
  }
  
  public void cyclePosition()
  {
    if (this.mRelativeBegin != -1) {
      inferRelativePercentPosition();
    }
    do
    {
      return;
      if (this.mRelativePercent != -1.0F)
      {
        inferRelativeEndPosition();
        return;
      }
    } while (this.mRelativeEnd == -1);
    inferRelativeBeginPosition();
  }
  
  public ConstraintAnchor getAnchor()
  {
    return this.mAnchor;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (paramType)
    {
    }
    do
    {
      do
      {
        return null;
      } while (this.mOrientation != 1);
      return this.mAnchor;
    } while (this.mOrientation != 0);
    return this.mAnchor;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return this.mAnchors;
  }
  
  public Rectangle getHead()
  {
    this.mHead.setBounds(getDrawX() - this.mHeadSize, getDrawY() - this.mHeadSize * 2, this.mHeadSize * 2, this.mHeadSize * 2);
    if (getOrientation() == 0) {
      this.mHead.setBounds(getDrawX() - this.mHeadSize * 2, getDrawY() - this.mHeadSize, this.mHeadSize * 2, this.mHeadSize * 2);
    }
    return this.mHead;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getRelativeBegin()
  {
    return this.mRelativeBegin;
  }
  
  public int getRelativeBehaviour()
  {
    int i = -1;
    if (this.mRelativePercent != -1.0F) {
      i = 0;
    }
    do
    {
      return i;
      if (this.mRelativeBegin != -1) {
        return 1;
      }
    } while (this.mRelativeEnd == -1);
    return 2;
  }
  
  public int getRelativeEnd()
  {
    return this.mRelativeEnd;
  }
  
  public float getRelativePercent()
  {
    return this.mRelativePercent;
  }
  
  public String getType()
  {
    return "Guideline";
  }
  
  void inferRelativeBeginPosition()
  {
    int i = getX();
    if (this.mOrientation == 0) {
      i = getY();
    }
    setGuideBegin(i);
  }
  
  void inferRelativeEndPosition()
  {
    int i = getParent().getWidth() - getX();
    if (this.mOrientation == 0) {
      i = getParent().getHeight() - getY();
    }
    setGuideEnd(i);
  }
  
  void inferRelativePercentPosition()
  {
    float f = getX() / getParent().getWidth();
    if (this.mOrientation == 0) {
      f = getY() / getParent().getHeight();
    }
    setGuidePercent(f);
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      paramInt1 -= this.mOffsetX;
      if (this.mRelativeBegin != -1) {
        setGuideBegin(paramInt1);
      }
    }
    do
    {
      do
      {
        return;
        if (this.mRelativeEnd != -1)
        {
          setGuideEnd(getParent().getWidth() - paramInt1);
          return;
        }
      } while (this.mRelativePercent == -1.0F);
      setGuidePercent(paramInt1 / getParent().getWidth());
      return;
      paramInt1 = paramInt2 - this.mOffsetY;
      if (this.mRelativeBegin != -1)
      {
        setGuideBegin(paramInt1);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        setGuideEnd(getParent().getHeight() - paramInt1);
        return;
      }
    } while (this.mRelativePercent == -1.0F);
    setGuidePercent(paramInt1 / getParent().getHeight());
  }
  
  public void setGuideBegin(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = paramInt;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuideEnd(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = paramInt;
    }
  }
  
  public void setGuidePercent(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.mRelativePercent = paramFloat;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuidePercent(int paramInt)
  {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt)
  {
    this.mMinimumPosition = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation == paramInt) {
      return;
    }
    this.mOrientation = paramInt;
    this.mAnchors.clear();
    if (this.mOrientation == 1) {}
    for (this.mAnchor = this.mLeft;; this.mAnchor = this.mTop)
    {
      this.mAnchors.add(this.mAnchor);
      return;
    }
  }
  
  public void setPositionRelaxed(boolean paramBoolean)
  {
    if (this.mIsPositionRelaxed == paramBoolean) {
      return;
    }
    this.mIsPositionRelaxed = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    if (getParent() == null) {
      return;
    }
    paramInt = paramLinearSystem.getObjectVariableValue(this.mAnchor);
    if (this.mOrientation == 1)
    {
      setX(paramInt);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
      return;
    }
    setX(0);
    setY(paramInt);
    setWidth(getParent().getWidth());
    setHeight(0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/widgets/Guideline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */