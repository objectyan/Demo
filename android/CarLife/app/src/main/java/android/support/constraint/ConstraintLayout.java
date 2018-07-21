package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class ConstraintLayout
  extends ViewGroup
{
  static final boolean ALLOWS_EMBEDDED = false;
  private static final boolean SIMPLE_LAYOUT = true;
  private static final String TAG = "ConstraintLayout";
  public static final String VERSION = "ConstraintLayout-1.0.0";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private ConstraintSet mConstraintSet = null;
  private boolean mDirtyHierarchy = true;
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = Integer.MAX_VALUE;
  private int mMaxWidth = Integer.MAX_VALUE;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOptimizationLevel = 2;
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return this.mLayoutWidget;
    }
    View localView = (View)this.mChildrenByIds.get(paramInt);
    if (localView == this) {
      return this.mLayoutWidget;
    }
    if (localView == null) {
      return null;
    }
    return ((LayoutParams)localView.getLayoutParams()).widget;
  }
  
  private final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return this.mLayoutWidget;
    }
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).widget;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          this.mMinWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMinWidth);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == R.styleable.ConstraintLayout_Layout_android_minHeight)
          {
            this.mMinHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMinHeight);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth)
          {
            this.mMaxWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxWidth);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight)
          {
            this.mMaxHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxHeight);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
          {
            this.mOptimizationLevel = paramAttributeSet.getInt(k, this.mOptimizationLevel);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_constraintSet)
          {
            k = paramAttributeSet.getResourceId(k, 0);
            this.mConstraintSet = new ConstraintSet();
            this.mConstraintSet.load(getContext(), k);
          }
        }
      }
      paramAttributeSet.recycle();
    }
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2)
  {
    int i6 = getPaddingTop() + getPaddingBottom();
    int i7 = getPaddingLeft() + getPaddingRight();
    int i8 = getChildCount();
    int k = 0;
    if (k < i8)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8) {}
      LayoutParams localLayoutParams;
      ConstraintWidget localConstraintWidget;
      do
      {
        k += 1;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = localLayoutParams.widget;
      } while (localLayoutParams.isGuideline);
      int i4 = localLayoutParams.width;
      int i2 = localLayoutParams.height;
      int i;
      label174:
      int i1;
      int i5;
      int i3;
      int n;
      int m;
      if ((localLayoutParams.horizontalDimensionFixed) || (localLayoutParams.verticalDimensionFixed) || ((!localLayoutParams.horizontalDimensionFixed) && (localLayoutParams.matchConstraintDefaultWidth == 1)) || (localLayoutParams.width == -1) || ((!localLayoutParams.verticalDimensionFixed) && ((localLayoutParams.matchConstraintDefaultHeight == 1) || (localLayoutParams.height == -1))))
      {
        i = 1;
        i1 = 0;
        i5 = 0;
        j = 0;
        i3 = 0;
        n = i2;
        m = i4;
        if (i != 0)
        {
          if ((i4 != 0) && (i4 != -1)) {
            break label342;
          }
          m = getChildMeasureSpec(paramInt1, i7, -2);
          i = 1;
          label221:
          if ((i2 != 0) && (i2 != -1)) {
            break label358;
          }
          n = getChildMeasureSpec(paramInt2, i6, -2);
        }
      }
      for (int j = 1;; j = i3)
      {
        localView.measure(m, n);
        m = localView.getMeasuredWidth();
        n = localView.getMeasuredHeight();
        i1 = i;
        localConstraintWidget.setWidth(m);
        localConstraintWidget.setHeight(n);
        if (i1 != 0) {
          localConstraintWidget.setWrapWidth(m);
        }
        if (j != 0) {
          localConstraintWidget.setWrapHeight(n);
        }
        if (!localLayoutParams.needsBaseline) {
          break;
        }
        i = localView.getBaseline();
        if (i == -1) {
          break;
        }
        localConstraintWidget.setBaselineDistance(i);
        break;
        i = 0;
        break label174;
        label342:
        m = getChildMeasureSpec(paramInt1, i7, i4);
        i = i5;
        break label221;
        label358:
        n = getChildMeasureSpec(paramInt2, i6, i2);
      }
    }
  }
  
  private void setChildrenConstraints()
  {
    if (this.mConstraintSet != null) {
      this.mConstraintSet.applyToInternal(this);
    }
    int i9 = getChildCount();
    this.mLayoutWidget.removeAllChildren();
    int n = 0;
    if (n < i9)
    {
      Object localObject2 = getChildAt(n);
      Object localObject1 = getViewWidget((View)localObject2);
      if (localObject1 == null) {}
      LayoutParams localLayoutParams;
      label213:
      do
      {
        for (;;)
        {
          n += 1;
          break;
          localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
          ((ConstraintWidget)localObject1).reset();
          ((ConstraintWidget)localObject1).setVisibility(((View)localObject2).getVisibility());
          ((ConstraintWidget)localObject1).setCompanionWidget(localObject2);
          this.mLayoutWidget.add((ConstraintWidget)localObject1);
          if ((!localLayoutParams.verticalDimensionFixed) || (!localLayoutParams.horizontalDimensionFixed)) {
            this.mVariableDimensionsWidgets.add(localObject1);
          }
          if (!localLayoutParams.isGuideline) {
            break label213;
          }
          localObject1 = (android.support.constraint.solver.widgets.Guideline)localObject1;
          if (localLayoutParams.guideBegin != -1) {
            ((android.support.constraint.solver.widgets.Guideline)localObject1).setGuideBegin(localLayoutParams.guideBegin);
          }
          if (localLayoutParams.guideEnd != -1) {
            ((android.support.constraint.solver.widgets.Guideline)localObject1).setGuideEnd(localLayoutParams.guideEnd);
          }
          if (localLayoutParams.guidePercent != -1.0F) {
            ((android.support.constraint.solver.widgets.Guideline)localObject1).setGuidePercent(localLayoutParams.guidePercent);
          }
        }
      } while ((localLayoutParams.resolvedLeftToLeft == -1) && (localLayoutParams.resolvedLeftToRight == -1) && (localLayoutParams.resolvedRightToLeft == -1) && (localLayoutParams.resolvedRightToRight == -1) && (localLayoutParams.topToTop == -1) && (localLayoutParams.topToBottom == -1) && (localLayoutParams.bottomToTop == -1) && (localLayoutParams.bottomToBottom == -1) && (localLayoutParams.baselineToBaseline == -1) && (localLayoutParams.editorAbsoluteX == -1) && (localLayoutParams.editorAbsoluteY == -1) && (localLayoutParams.width != -1) && (localLayoutParams.height != -1));
      int i3 = localLayoutParams.resolvedLeftToLeft;
      int i4 = localLayoutParams.resolvedLeftToRight;
      int k = localLayoutParams.resolvedRightToLeft;
      int m = localLayoutParams.resolvedRightToRight;
      int i1 = localLayoutParams.resolveGoneLeftMargin;
      int i2 = localLayoutParams.resolveGoneRightMargin;
      float f1 = localLayoutParams.resolvedHorizontalBias;
      int i7;
      int i8;
      int i5;
      int i6;
      float f2;
      int i;
      int j;
      if (Build.VERSION.SDK_INT < 17)
      {
        k = localLayoutParams.leftToLeft;
        m = localLayoutParams.leftToRight;
        i7 = localLayoutParams.rightToLeft;
        i8 = localLayoutParams.rightToRight;
        i5 = localLayoutParams.goneLeftMargin;
        i6 = localLayoutParams.goneRightMargin;
        f2 = localLayoutParams.horizontalBias;
        i = k;
        j = m;
        if (k == -1)
        {
          i = k;
          j = m;
          if (m == -1)
          {
            if (localLayoutParams.startToStart == -1) {
              break label1188;
            }
            i = localLayoutParams.startToStart;
            j = m;
          }
        }
        label479:
        i1 = i5;
        i2 = i6;
        f1 = f2;
        i3 = i;
        i4 = j;
        k = i7;
        m = i8;
        if (i7 == -1)
        {
          i1 = i5;
          i2 = i6;
          f1 = f2;
          i3 = i;
          i4 = j;
          k = i7;
          m = i8;
          if (i8 == -1)
          {
            if (localLayoutParams.endToStart == -1) {
              break label1217;
            }
            k = localLayoutParams.endToStart;
            m = i8;
            i4 = j;
            i3 = i;
            f1 = f2;
            i2 = i6;
            i1 = i5;
          }
        }
      }
      label578:
      if (i3 != -1)
      {
        localObject2 = getTargetWidget(i3);
        if (localObject2 != null) {
          ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject2, ConstraintAnchor.Type.LEFT, localLayoutParams.leftMargin, i1);
        }
        label617:
        if (k == -1) {
          break label1324;
        }
        localObject2 = getTargetWidget(k);
        if (localObject2 != null) {
          ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject2, ConstraintAnchor.Type.LEFT, localLayoutParams.rightMargin, i2);
        }
        label656:
        if (localLayoutParams.topToTop == -1) {
          break label1366;
        }
        localObject2 = getTargetWidget(localLayoutParams.topToTop);
        if (localObject2 != null) {
          ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject2, ConstraintAnchor.Type.TOP, localLayoutParams.topMargin, localLayoutParams.goneTopMargin);
        }
        label704:
        if (localLayoutParams.bottomToTop == -1) {
          break label1417;
        }
        localObject2 = getTargetWidget(localLayoutParams.bottomToTop);
        if (localObject2 != null) {
          ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject2, ConstraintAnchor.Type.TOP, localLayoutParams.bottomMargin, localLayoutParams.goneBottomMargin);
        }
        label752:
        if (localLayoutParams.baselineToBaseline != -1)
        {
          Object localObject3 = (View)this.mChildrenByIds.get(localLayoutParams.baselineToBaseline);
          localObject2 = getTargetWidget(localLayoutParams.baselineToBaseline);
          if ((localObject2 != null) && (localObject3 != null) && ((((View)localObject3).getLayoutParams() instanceof LayoutParams)))
          {
            localObject3 = (LayoutParams)((View)localObject3).getLayoutParams();
            localLayoutParams.needsBaseline = true;
            ((LayoutParams)localObject3).needsBaseline = true;
            ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.BASELINE).connect(((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
            ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.TOP).reset();
            ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
          }
        }
        if ((f1 >= 0.0F) && (f1 != 0.5F)) {
          ((ConstraintWidget)localObject1).setHorizontalBiasPercent(f1);
        }
        if ((localLayoutParams.verticalBias >= 0.0F) && (localLayoutParams.verticalBias != 0.5F)) {
          ((ConstraintWidget)localObject1).setVerticalBiasPercent(localLayoutParams.verticalBias);
        }
        if ((isInEditMode()) && ((localLayoutParams.editorAbsoluteX != -1) || (localLayoutParams.editorAbsoluteY != -1))) {
          ((ConstraintWidget)localObject1).setOrigin(localLayoutParams.editorAbsoluteX, localLayoutParams.editorAbsoluteY);
        }
        if (localLayoutParams.horizontalDimensionFixed) {
          break label1485;
        }
        if (localLayoutParams.width != -1) {
          break label1468;
        }
        ((ConstraintWidget)localObject1).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.LEFT).mMargin = localLayoutParams.leftMargin;
        ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = localLayoutParams.rightMargin;
        label1030:
        if (localLayoutParams.verticalDimensionFixed) {
          break label1523;
        }
        if (localLayoutParams.height != -1) {
          break label1506;
        }
        ((ConstraintWidget)localObject1).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.TOP).mMargin = localLayoutParams.topMargin;
        ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = localLayoutParams.bottomMargin;
      }
      for (;;)
      {
        if (localLayoutParams.dimensionRatio != null) {
          ((ConstraintWidget)localObject1).setDimensionRatio(localLayoutParams.dimensionRatio);
        }
        ((ConstraintWidget)localObject1).setHorizontalWeight(localLayoutParams.horizontalWeight);
        ((ConstraintWidget)localObject1).setVerticalWeight(localLayoutParams.verticalWeight);
        ((ConstraintWidget)localObject1).setHorizontalChainStyle(localLayoutParams.horizontalChainStyle);
        ((ConstraintWidget)localObject1).setVerticalChainStyle(localLayoutParams.verticalChainStyle);
        ((ConstraintWidget)localObject1).setHorizontalMatchStyle(localLayoutParams.matchConstraintDefaultWidth, localLayoutParams.matchConstraintMinWidth, localLayoutParams.matchConstraintMaxWidth);
        ((ConstraintWidget)localObject1).setVerticalMatchStyle(localLayoutParams.matchConstraintDefaultHeight, localLayoutParams.matchConstraintMinHeight, localLayoutParams.matchConstraintMaxHeight);
        break;
        label1188:
        i = k;
        j = m;
        if (localLayoutParams.startToEnd == -1) {
          break label479;
        }
        j = localLayoutParams.startToEnd;
        i = k;
        break label479;
        label1217:
        i1 = i5;
        i2 = i6;
        f1 = f2;
        i3 = i;
        i4 = j;
        k = i7;
        m = i8;
        if (localLayoutParams.endToEnd == -1) {
          break label578;
        }
        m = localLayoutParams.endToEnd;
        i1 = i5;
        i2 = i6;
        f1 = f2;
        i3 = i;
        i4 = j;
        k = i7;
        break label578;
        if (i4 == -1) {
          break label617;
        }
        localObject2 = getTargetWidget(i4);
        if (localObject2 == null) {
          break label617;
        }
        ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject2, ConstraintAnchor.Type.RIGHT, localLayoutParams.leftMargin, i1);
        break label617;
        label1324:
        if (m == -1) {
          break label656;
        }
        localObject2 = getTargetWidget(m);
        if (localObject2 == null) {
          break label656;
        }
        ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject2, ConstraintAnchor.Type.RIGHT, localLayoutParams.rightMargin, i2);
        break label656;
        label1366:
        if (localLayoutParams.topToBottom == -1) {
          break label704;
        }
        localObject2 = getTargetWidget(localLayoutParams.topToBottom);
        if (localObject2 == null) {
          break label704;
        }
        ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject2, ConstraintAnchor.Type.BOTTOM, localLayoutParams.topMargin, localLayoutParams.goneTopMargin);
        break label704;
        label1417:
        if (localLayoutParams.bottomToBottom == -1) {
          break label752;
        }
        localObject2 = getTargetWidget(localLayoutParams.bottomToBottom);
        if (localObject2 == null) {
          break label752;
        }
        ((ConstraintWidget)localObject1).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject2, ConstraintAnchor.Type.BOTTOM, localLayoutParams.bottomMargin, localLayoutParams.goneBottomMargin);
        break label752;
        label1468:
        ((ConstraintWidget)localObject1).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        ((ConstraintWidget)localObject1).setWidth(0);
        break label1030;
        label1485:
        ((ConstraintWidget)localObject1).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ((ConstraintWidget)localObject1).setWidth(localLayoutParams.width);
        break label1030;
        label1506:
        ((ConstraintWidget)localObject1).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        ((ConstraintWidget)localObject1).setHeight(0);
        continue;
        label1523:
        ((ConstraintWidget)localObject1).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ((ConstraintWidget)localObject1).setHeight(localLayoutParams.height);
      }
    }
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
    int j = 0;
    int i = 0;
    getLayoutParams();
    switch (i1)
    {
    default: 
      paramInt1 = j;
      switch (k)
      {
      default: 
        paramInt2 = i;
      }
      break;
    }
    for (;;)
    {
      this.mLayoutWidget.setMinWidth(0);
      this.mLayoutWidget.setMinHeight(0);
      this.mLayoutWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
      this.mLayoutWidget.setWidth(paramInt1);
      this.mLayoutWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
      this.mLayoutWidget.setHeight(paramInt2);
      this.mLayoutWidget.setMinWidth(this.mMinWidth - getPaddingLeft() - getPaddingRight());
      this.mLayoutWidget.setMinHeight(this.mMinHeight - getPaddingTop() - getPaddingBottom());
      return;
      localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      break;
      localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      paramInt1 = j;
      break;
      paramInt1 = Math.min(this.mMaxWidth, paramInt1) - (i2 + i3);
      break;
      localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      continue;
      localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      paramInt2 = i;
      continue;
      paramInt2 = Math.min(this.mMaxHeight, paramInt2) - (m + n);
    }
  }
  
  private void updateHierarchy()
  {
    int m = getChildCount();
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (getChildAt(i).isLayoutRequested()) {
          j = 1;
        }
      }
      else
      {
        if (j != 0)
        {
          this.mVariableDimensionsWidgets.clear();
          setChildrenConstraints();
        }
        return;
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      if ((localView.getVisibility() == 8) && (!((LayoutParams)localObject).isGuideline) && (!paramBoolean)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        localObject = ((LayoutParams)localObject).widget;
        paramInt3 = ((ConstraintWidget)localObject).getDrawX();
        paramInt4 = ((ConstraintWidget)localObject).getDrawY();
        localView.layout(paramInt3, paramInt4, paramInt3 + ((ConstraintWidget)localObject).getWidth(), paramInt4 + ((ConstraintWidget)localObject).getHeight());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getPaddingLeft();
    int m = getPaddingTop();
    this.mLayoutWidget.setX(j);
    this.mLayoutWidget.setY(m);
    setSelfDimensionBehaviour(paramInt1, paramInt2);
    if (this.mDirtyHierarchy)
    {
      this.mDirtyHierarchy = false;
      updateHierarchy();
    }
    internalMeasureChildren(paramInt1, paramInt2);
    if (getChildCount() > 0) {
      solveLinearSystem();
    }
    int k = 0;
    int i = 0;
    int i3 = this.mVariableDimensionsWidgets.size();
    int i4 = m + getPaddingBottom();
    int i5 = j + getPaddingRight();
    if (i3 > 0)
    {
      j = 0;
      int n;
      label141:
      int i1;
      label144:
      ConstraintWidget localConstraintWidget;
      if (this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
      {
        m = 1;
        if (this.mLayoutWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          break label202;
        }
        n = 1;
        i1 = 0;
        if (i1 >= i3) {
          break label606;
        }
        localConstraintWidget = (ConstraintWidget)this.mVariableDimensionsWidgets.get(i1);
        if (!(localConstraintWidget instanceof android.support.constraint.solver.widgets.Guideline)) {
          break label208;
        }
        i2 = j;
        k = i;
      }
      label202:
      label208:
      View localView;
      do
      {
        do
        {
          i1 += 1;
          i = k;
          j = i2;
          break label144;
          m = 0;
          break;
          n = 0;
          break label141;
          localView = (View)localConstraintWidget.getCompanionWidget();
          k = i;
          i2 = j;
        } while (localView == null);
        k = i;
        i2 = j;
      } while (localView.getVisibility() == 8);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.width == -2)
      {
        k = getChildMeasureSpec(paramInt1, i5, localLayoutParams.width);
        label280:
        if (localLayoutParams.height != -2) {
          break label590;
        }
      }
      label590:
      for (int i2 = getChildMeasureSpec(paramInt2, i4, localLayoutParams.height);; i2 = View.MeasureSpec.makeMeasureSpec(localConstraintWidget.getHeight(), 1073741824))
      {
        localView.measure(k, i2);
        k = localView.getMeasuredWidth();
        i2 = localView.getMeasuredHeight();
        if (k != localConstraintWidget.getWidth())
        {
          localConstraintWidget.setWidth(k);
          if ((m != 0) && (localConstraintWidget.getRight() > this.mLayoutWidget.getWidth()))
          {
            j = localConstraintWidget.getRight();
            k = localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
            this.mLayoutWidget.setWidth(Math.max(this.mMinWidth, j + k));
          }
          j = 1;
        }
        k = j;
        if (i2 != localConstraintWidget.getHeight())
        {
          localConstraintWidget.setHeight(i2);
          if ((n != 0) && (localConstraintWidget.getBottom() > this.mLayoutWidget.getHeight()))
          {
            j = localConstraintWidget.getBottom();
            k = localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
            this.mLayoutWidget.setHeight(Math.max(this.mMinHeight, j + k));
          }
          k = 1;
        }
        j = k;
        if (localLayoutParams.needsBaseline)
        {
          i2 = localView.getBaseline();
          j = k;
          if (i2 != -1)
          {
            j = k;
            if (i2 != localConstraintWidget.getBaselineDistance())
            {
              localConstraintWidget.setBaselineDistance(i2);
              j = 1;
            }
          }
        }
        k = i;
        i2 = j;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
        k = combineMeasuredStates(i, localView.getMeasuredState());
        i2 = j;
        break;
        k = View.MeasureSpec.makeMeasureSpec(localConstraintWidget.getWidth(), 1073741824);
        break label280;
      }
      label606:
      k = i;
      if (j != 0)
      {
        solveLinearSystem();
        k = i;
      }
    }
    i = this.mLayoutWidget.getWidth() + i5;
    j = this.mLayoutWidget.getHeight() + i4;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = resolveSizeAndState(i, paramInt1, k);
      paramInt2 = resolveSizeAndState(j, paramInt2, k << 16);
      paramInt1 = Math.min(this.mMaxWidth, paramInt1);
      i = Math.min(this.mMaxHeight, paramInt2);
      paramInt2 = paramInt1 & 0xFFFFFF;
      i &= 0xFFFFFF;
      paramInt1 = paramInt2;
      if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
        paramInt1 = paramInt2 | 0x1000000;
      }
      paramInt2 = i;
      if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
        paramInt2 = i | 0x1000000;
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(i, j);
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof android.support.constraint.solver.widgets.Guideline)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      ((LayoutParams)localObject).widget = new android.support.constraint.solver.widgets.Guideline();
      ((LayoutParams)localObject).isGuideline = true;
      ((android.support.constraint.solver.widgets.Guideline)((LayoutParams)localObject).widget).setOrientation(((LayoutParams)localObject).orientation);
      localObject = ((LayoutParams)localObject).widget;
    }
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.mChildrenByIds.remove(paramView.getId());
    this.mLayoutWidget.remove(getViewWidget(paramView));
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mDirtyHierarchy = true;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet)
  {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setId(int paramInt)
  {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.mMaxHeight) {
      return;
    }
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.mMaxWidth) {
      return;
    }
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.mMinHeight) {
      return;
    }
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.mMinWidth) {
      return;
    }
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  protected void solveLinearSystem()
  {
    this.mLayoutWidget.layout();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public String dimensionRatio = null;
    int dimensionRatioSide = 1;
    float dimensionRatioValue = 0.0F;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    boolean horizontalDimensionFixed = true;
    public float horizontalWeight = 0.0F;
    boolean isGuideline = false;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int matchConstraintDefaultHeight = 0;
    public int matchConstraintDefaultWidth = 0;
    public int matchConstraintMaxHeight = 0;
    public int matchConstraintMaxWidth = 0;
    public int matchConstraintMinHeight = 0;
    public int matchConstraintMinWidth = 0;
    boolean needsBaseline = false;
    public int orientation = -1;
    int resolveGoneLeftMargin = -1;
    int resolveGoneRightMargin = -1;
    float resolvedHorizontalBias = 0.5F;
    int resolvedLeftToLeft = -1;
    int resolvedLeftToRight = -1;
    int resolvedRightToLeft = -1;
    int resolvedRightToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    boolean verticalDimensionFixed = true;
    public float verticalWeight = 0.0F;
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramContext.getIndexCount();
      int i = 0;
      if (i < k)
      {
        int j = paramContext.getIndex(i);
        if (j == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf)
        {
          this.leftToLeft = paramContext.getResourceId(j, this.leftToLeft);
          if (this.leftToLeft == -1) {
            this.leftToLeft = paramContext.getInt(j, -1);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf)
          {
            this.leftToRight = paramContext.getResourceId(j, this.leftToRight);
            if (this.leftToRight == -1) {
              this.leftToRight = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf)
          {
            this.rightToLeft = paramContext.getResourceId(j, this.rightToLeft);
            if (this.rightToLeft == -1) {
              this.rightToLeft = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf)
          {
            this.rightToRight = paramContext.getResourceId(j, this.rightToRight);
            if (this.rightToRight == -1) {
              this.rightToRight = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf)
          {
            this.topToTop = paramContext.getResourceId(j, this.topToTop);
            if (this.topToTop == -1) {
              this.topToTop = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf)
          {
            this.topToBottom = paramContext.getResourceId(j, this.topToBottom);
            if (this.topToBottom == -1) {
              this.topToBottom = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf)
          {
            this.bottomToTop = paramContext.getResourceId(j, this.bottomToTop);
            if (this.bottomToTop == -1) {
              this.bottomToTop = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf)
          {
            this.bottomToBottom = paramContext.getResourceId(j, this.bottomToBottom);
            if (this.bottomToBottom == -1) {
              this.bottomToBottom = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf)
          {
            this.baselineToBaseline = paramContext.getResourceId(j, this.baselineToBaseline);
            if (this.baselineToBaseline == -1) {
              this.baselineToBaseline = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX)
          {
            this.editorAbsoluteX = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteX);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY)
          {
            this.editorAbsoluteY = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteY);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin)
          {
            this.guideBegin = paramContext.getDimensionPixelOffset(j, this.guideBegin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end)
          {
            this.guideEnd = paramContext.getDimensionPixelOffset(j, this.guideEnd);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent)
          {
            this.guidePercent = paramContext.getFloat(j, this.guidePercent);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_android_orientation)
          {
            this.orientation = paramContext.getInt(j, this.orientation);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf)
          {
            this.startToEnd = paramContext.getResourceId(j, this.startToEnd);
            if (this.startToEnd == -1) {
              this.startToEnd = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf)
          {
            this.startToStart = paramContext.getResourceId(j, this.startToStart);
            if (this.startToStart == -1) {
              this.startToStart = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf)
          {
            this.endToStart = paramContext.getResourceId(j, this.endToStart);
            if (this.endToStart == -1) {
              this.endToStart = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf)
          {
            this.endToEnd = paramContext.getResourceId(j, this.endToEnd);
            if (this.endToEnd == -1) {
              this.endToEnd = paramContext.getInt(j, -1);
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft)
          {
            this.goneLeftMargin = paramContext.getDimensionPixelSize(j, this.goneLeftMargin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop)
          {
            this.goneTopMargin = paramContext.getDimensionPixelSize(j, this.goneTopMargin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight)
          {
            this.goneRightMargin = paramContext.getDimensionPixelSize(j, this.goneRightMargin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom)
          {
            this.goneBottomMargin = paramContext.getDimensionPixelSize(j, this.goneBottomMargin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart)
          {
            this.goneStartMargin = paramContext.getDimensionPixelSize(j, this.goneStartMargin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd)
          {
            this.goneEndMargin = paramContext.getDimensionPixelSize(j, this.goneEndMargin);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias)
          {
            this.horizontalBias = paramContext.getFloat(j, this.horizontalBias);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias)
          {
            this.verticalBias = paramContext.getFloat(j, this.verticalBias);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio)
          {
            this.dimensionRatio = paramContext.getString(j);
            this.dimensionRatioValue = NaN.0F;
            this.dimensionRatioSide = -1;
            if (this.dimensionRatio != null)
            {
              int m = this.dimensionRatio.length();
              j = this.dimensionRatio.indexOf(',');
              if ((j > 0) && (j < m - 1))
              {
                paramAttributeSet = this.dimensionRatio.substring(0, j);
                if (paramAttributeSet.equalsIgnoreCase("W"))
                {
                  this.dimensionRatioSide = 0;
                  label1334:
                  j += 1;
                }
              }
              float f1;
              float f2;
              for (;;)
              {
                int n = this.dimensionRatio.indexOf(':');
                if ((n < 0) || (n >= m - 1)) {
                  break label1496;
                }
                paramAttributeSet = this.dimensionRatio.substring(j, n);
                String str = this.dimensionRatio.substring(n + 1);
                if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                  break;
                }
                try
                {
                  f1 = Float.parseFloat(paramAttributeSet);
                  f2 = Float.parseFloat(str);
                  if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
                    break;
                  }
                  if (this.dimensionRatioSide != 1) {
                    break label1480;
                  }
                  this.dimensionRatioValue = Math.abs(f2 / f1);
                }
                catch (NumberFormatException paramAttributeSet) {}
                break;
                if (!paramAttributeSet.equalsIgnoreCase("H")) {
                  break label1334;
                }
                this.dimensionRatioSide = 1;
                break label1334;
                j = 0;
              }
              label1480:
              f1 /= f2;
              this.dimensionRatioValue = Math.abs(f1);
              continue;
              label1496:
              paramAttributeSet = this.dimensionRatio.substring(j);
              if (paramAttributeSet.length() > 0) {
                try
                {
                  this.dimensionRatioValue = Float.parseFloat(paramAttributeSet);
                }
                catch (NumberFormatException paramAttributeSet) {}
              }
            }
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight)
          {
            this.horizontalWeight = paramContext.getFloat(j, 0.0F);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight)
          {
            this.verticalWeight = paramContext.getFloat(j, 0.0F);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle)
          {
            this.horizontalChainStyle = paramContext.getInt(j, 0);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle)
          {
            this.verticalChainStyle = paramContext.getInt(j, 0);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default)
          {
            this.matchConstraintDefaultWidth = paramContext.getInt(j, 0);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default)
          {
            this.matchConstraintDefaultHeight = paramContext.getInt(j, 0);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min)
          {
            this.matchConstraintMinWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMinWidth);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max)
          {
            this.matchConstraintMaxWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxWidth);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min)
          {
            this.matchConstraintMinHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMinHeight);
          }
          else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max)
          {
            this.matchConstraintMaxHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxHeight);
          }
          else if ((j == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator) || (j == R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator) || (j == R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator) || (j == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator) || (j != R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator)) {}
        }
      }
      paramContext.recycle();
      validate();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.goneLeftMargin = paramLayoutParams.goneLeftMargin;
      this.goneTopMargin = paramLayoutParams.goneTopMargin;
      this.goneRightMargin = paramLayoutParams.goneRightMargin;
      this.goneBottomMargin = paramLayoutParams.goneBottomMargin;
      this.goneStartMargin = paramLayoutParams.goneStartMargin;
      this.goneEndMargin = paramLayoutParams.goneEndMargin;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.dimensionRatioValue = paramLayoutParams.dimensionRatioValue;
      this.dimensionRatioSide = paramLayoutParams.dimensionRatioSide;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.matchConstraintDefaultWidth = paramLayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = paramLayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = paramLayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = paramLayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = paramLayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = paramLayoutParams.matchConstraintMaxHeight;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.horizontalDimensionFixed = paramLayoutParams.horizontalDimensionFixed;
      this.verticalDimensionFixed = paramLayoutParams.verticalDimensionFixed;
      this.needsBaseline = paramLayoutParams.needsBaseline;
      this.isGuideline = paramLayoutParams.isGuideline;
      this.resolvedLeftToLeft = paramLayoutParams.resolvedLeftToLeft;
      this.resolvedLeftToRight = paramLayoutParams.resolvedLeftToRight;
      this.resolvedRightToLeft = paramLayoutParams.resolvedRightToLeft;
      this.resolvedRightToRight = paramLayoutParams.resolvedRightToRight;
      this.resolveGoneLeftMargin = paramLayoutParams.resolveGoneLeftMargin;
      this.resolveGoneRightMargin = paramLayoutParams.resolveGoneRightMargin;
      this.resolvedHorizontalBias = paramLayoutParams.resolvedHorizontalBias;
      this.widget = paramLayoutParams.widget;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i = 1;
      super.resolveLayoutDirection(paramInt);
      this.resolvedRightToLeft = -1;
      this.resolvedRightToRight = -1;
      this.resolvedLeftToLeft = -1;
      this.resolvedLeftToRight = -1;
      this.resolveGoneLeftMargin = -1;
      this.resolveGoneRightMargin = -1;
      this.resolveGoneLeftMargin = this.goneLeftMargin;
      this.resolveGoneRightMargin = this.goneRightMargin;
      this.resolvedHorizontalBias = this.horizontalBias;
      if (1 == getLayoutDirection())
      {
        paramInt = i;
        if (paramInt == 0) {
          break label254;
        }
        if (this.startToEnd == -1) {
          break label235;
        }
        this.resolvedRightToLeft = this.startToEnd;
        label91:
        if (this.endToStart != -1) {
          this.resolvedLeftToRight = this.endToStart;
        }
        if (this.endToEnd != -1) {
          this.resolvedLeftToLeft = this.endToEnd;
        }
        if (this.goneStartMargin != -1) {
          this.resolveGoneRightMargin = this.goneStartMargin;
        }
        if (this.goneEndMargin != -1) {
          this.resolveGoneLeftMargin = this.goneEndMargin;
        }
        this.resolvedHorizontalBias = (1.0F - this.horizontalBias);
        label165:
        if ((this.endToStart == -1) && (this.endToEnd == -1))
        {
          if (this.rightToLeft == -1) {
            break label353;
          }
          this.resolvedRightToLeft = this.rightToLeft;
        }
        label197:
        if ((this.startToStart == -1) && (this.startToEnd == -1))
        {
          if (this.leftToLeft == -1) {
            break label372;
          }
          this.resolvedLeftToLeft = this.leftToLeft;
        }
      }
      label235:
      label254:
      label353:
      label372:
      while (this.leftToRight == -1)
      {
        return;
        paramInt = 0;
        break;
        if (this.startToStart == -1) {
          break label91;
        }
        this.resolvedRightToRight = this.startToStart;
        break label91;
        if (this.startToEnd != -1) {
          this.resolvedLeftToRight = this.startToEnd;
        }
        if (this.startToStart != -1) {
          this.resolvedLeftToLeft = this.startToStart;
        }
        if (this.endToStart != -1) {
          this.resolvedRightToLeft = this.endToStart;
        }
        if (this.endToEnd != -1) {
          this.resolvedRightToRight = this.endToEnd;
        }
        if (this.goneStartMargin != -1) {
          this.resolveGoneLeftMargin = this.goneStartMargin;
        }
        if (this.goneEndMargin == -1) {
          break label165;
        }
        this.resolveGoneRightMargin = this.goneEndMargin;
        break label165;
        if (this.rightToRight == -1) {
          break label197;
        }
        this.resolvedRightToRight = this.rightToRight;
        break label197;
      }
      this.resolvedLeftToRight = this.leftToRight;
    }
    
    public void validate()
    {
      this.isGuideline = false;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      if ((this.width == 0) || (this.width == -1)) {
        this.horizontalDimensionFixed = false;
      }
      if ((this.height == 0) || (this.height == -1)) {
        this.verticalDimensionFixed = false;
      }
      if ((this.guidePercent != -1.0F) || (this.guideBegin != -1) || (this.guideEnd != -1))
      {
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof android.support.constraint.solver.widgets.Guideline)) {
          this.widget = new android.support.constraint.solver.widgets.Guideline();
        }
        ((android.support.constraint.solver.widgets.Guideline)this.widget).setOrientation(this.orientation);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */