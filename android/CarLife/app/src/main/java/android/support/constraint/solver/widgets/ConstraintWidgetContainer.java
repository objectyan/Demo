package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  static boolean ALLOW_ROOT_GROUP = true;
  private static final int CHAIN_FIRST = 0;
  private static final int CHAIN_FIRST_VISIBLE = 2;
  private static final int CHAIN_LAST = 1;
  private static final int CHAIN_LAST_VISIBLE = 3;
  private static final boolean DEBUG = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final boolean DEBUG_OPTIMIZE = false;
  private static final int FLAG_CHAIN_DANGLING = 1;
  private static final int FLAG_CHAIN_OPTIMIZE = 0;
  private static final int FLAG_RECOMPUTE_BOUNDS = 2;
  private static final int MAX_ITERATIONS = 8;
  public static final int OPTIMIZATION_ALL = 2;
  public static final int OPTIMIZATION_BASIC = 4;
  public static final int OPTIMIZATION_CHAIN = 8;
  public static final int OPTIMIZATION_NONE = 1;
  private static final boolean USE_SNAPSHOT = true;
  private static final boolean USE_THREAD = false;
  private boolean[] flags = new boolean[3];
  protected LinearSystem mBackgroundSystem = null;
  private ConstraintWidget[] mChainEnds = new ConstraintWidget[4];
  private boolean mHeightMeasuredTooSmall = false;
  private ConstraintWidget[] mHorizontalChainsArray = new ConstraintWidget[4];
  private int mHorizontalChainsSize = 0;
  private ConstraintWidget[] mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
  private int mOptimizationLevel = 2;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  private Snapshot mSnapshot;
  protected LinearSystem mSystem = new LinearSystem();
  private ConstraintWidget[] mVerticalChainsArray = new ConstraintWidget[4];
  private int mVerticalChainsSize = 0;
  private boolean mWidthMeasuredTooSmall = false;
  int mWrapHeight;
  int mWrapWidth;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = 0;
    while (i < this.mHorizontalChainsSize)
    {
      if (this.mHorizontalChainsArray[i] == paramConstraintWidget) {
        return;
      }
      i += 1;
    }
    if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
      this.mHorizontalChainsArray = ((ConstraintWidget[])Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2));
    }
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = paramConstraintWidget;
    this.mHorizontalChainsSize += 1;
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = 0;
    while (i < this.mVerticalChainsSize)
    {
      if (this.mVerticalChainsArray[i] == paramConstraintWidget) {
        return;
      }
      i += 1;
    }
    if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
      this.mVerticalChainsArray = ((ConstraintWidget[])Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2));
    }
    this.mVerticalChainsArray[this.mVerticalChainsSize] = paramConstraintWidget;
    this.mVerticalChainsSize += 1;
  }
  
  private void applyHorizontalChain(LinearSystem paramLinearSystem)
  {
    int j = 0;
    if (j < this.mHorizontalChainsSize)
    {
      ConstraintWidget localConstraintWidget = this.mHorizontalChainsArray[j];
      int n = countMatchConstraintsChainedWidgets(paramLinearSystem, this.mChainEnds, this.mHorizontalChainsArray[j], 0, this.flags);
      Object localObject2 = this.mChainEnds[2];
      if (localObject2 == null) {}
      Object localObject1;
      label149:
      label161:
      int m;
      label243:
      label249:
      label255:
      Object localObject4;
      Object localObject6;
      Object localObject7;
      Object localObject5;
      Object localObject3;
      label453:
      label792:
      label821:
      label854:
      label958:
      label964:
      label970:
      label976:
      label1039:
      label1124:
      label1128:
      float f;
      for (;;)
      {
        j += 1;
        break;
        if (this.flags[1] != 0)
        {
          i = localConstraintWidget.getDrawX();
          while (localObject2 != null)
          {
            paramLinearSystem.addEquality(((ConstraintWidget)localObject2).mLeft.mSolverVariable, i);
            localObject1 = ((ConstraintWidget)localObject2).mHorizontalNextWidget;
            i += ((ConstraintWidget)localObject2).mLeft.getMargin() + ((ConstraintWidget)localObject2).getWidth() + ((ConstraintWidget)localObject2).mRight.getMargin();
            localObject2 = localObject1;
          }
        }
        else
        {
          if (localConstraintWidget.mHorizontalChainStyle == 0)
          {
            i = 1;
            if (localConstraintWidget.mHorizontalChainStyle != 2) {
              break label243;
            }
            k = 1;
            if (this.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
              break label249;
            }
          }
          for (m = 1;; m = 0)
          {
            if (((this.mOptimizationLevel != 2) && (this.mOptimizationLevel != 8)) || (this.flags[0] == 0) || (!localConstraintWidget.mHorizontalChainFixedPosition) || (k != 0) || (m != 0) || (localConstraintWidget.mHorizontalChainStyle != 0)) {
              break label255;
            }
            Optimizer.applyDirectResolutionHorizontalChain(this, paramLinearSystem, n, localConstraintWidget);
            break;
            i = 0;
            break label149;
            k = 0;
            break label161;
          }
          if ((n == 0) || (k != 0))
          {
            localObject4 = null;
            localObject6 = null;
            m = 0;
            localObject1 = localObject2;
            localObject7 = localObject1;
            if (localObject7 != null)
            {
              localObject5 = ((ConstraintWidget)localObject7).mHorizontalNextWidget;
              if (localObject5 == null)
              {
                localObject6 = this.mChainEnds[1];
                m = 1;
              }
              int i1;
              if (k != 0)
              {
                localObject1 = ((ConstraintWidget)localObject7).mLeft;
                i1 = ((ConstraintAnchor)localObject1).getMargin();
                n = i1;
                if (localObject4 != null) {
                  n = i1 + ((ConstraintWidget)localObject4).mRight.getMargin();
                }
                i1 = 1;
                if (localObject2 != localObject7) {
                  i1 = 3;
                }
                paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, n, i1);
                localObject4 = localObject5;
                if (((ConstraintWidget)localObject7).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
                {
                  localObject3 = ((ConstraintWidget)localObject7).mRight;
                  if (((ConstraintWidget)localObject7).mMatchConstraintDefaultWidth == 1)
                  {
                    n = Math.max(((ConstraintWidget)localObject7).mMatchConstraintMinWidth, ((ConstraintWidget)localObject7).getWidth());
                    paramLinearSystem.addEquality(((ConstraintAnchor)localObject3).mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, n, 3);
                    localObject4 = localObject5;
                  }
                }
                else
                {
                  if (m == 0) {
                    break label976;
                  }
                }
              }
              for (localObject1 = null;; localObject1 = localObject4)
              {
                localObject4 = localObject7;
                break;
                paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, ((ConstraintAnchor)localObject1).mMargin, 3);
                paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject3).mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintWidget)localObject7).mMatchConstraintMinWidth, 3);
                localObject4 = localObject5;
                break label453;
                if ((i == 0) && (m != 0) && (localObject4 != null))
                {
                  if (((ConstraintWidget)localObject7).mRight.mTarget == null)
                  {
                    paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mRight.mSolverVariable, ((ConstraintWidget)localObject7).getDrawRight());
                    localObject4 = localObject5;
                    break label453;
                  }
                  n = ((ConstraintWidget)localObject7).mRight.getMargin();
                  paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mRight.mSolverVariable, ((ConstraintWidget)localObject6).mRight.mTarget.mSolverVariable, -n, 5);
                  localObject4 = localObject5;
                  break label453;
                }
                if ((i == 0) && (m == 0) && (localObject4 == null))
                {
                  if (((ConstraintWidget)localObject7).mLeft.mTarget == null)
                  {
                    paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mLeft.mSolverVariable, ((ConstraintWidget)localObject7).getDrawX());
                    localObject4 = localObject5;
                    break label453;
                  }
                  n = ((ConstraintWidget)localObject7).mLeft.getMargin();
                  paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mLeft.mSolverVariable, localConstraintWidget.mLeft.mTarget.mSolverVariable, n, 5);
                  localObject4 = localObject5;
                  break label453;
                }
                ConstraintAnchor localConstraintAnchor1 = ((ConstraintWidget)localObject7).mLeft;
                ConstraintAnchor localConstraintAnchor2 = ((ConstraintWidget)localObject7).mRight;
                n = localConstraintAnchor1.getMargin();
                i1 = localConstraintAnchor2.getMargin();
                paramLinearSystem.addGreaterThan(localConstraintAnchor1.mSolverVariable, localConstraintAnchor1.mTarget.mSolverVariable, n, 1);
                paramLinearSystem.addLowerThan(localConstraintAnchor2.mSolverVariable, localConstraintAnchor2.mTarget.mSolverVariable, -i1, 1);
                if (localConstraintAnchor1.mTarget != null)
                {
                  localObject3 = localConstraintAnchor1.mTarget.mSolverVariable;
                  if (localObject4 == null)
                  {
                    if (localConstraintWidget.mLeft.mTarget == null) {
                      break label958;
                    }
                    localObject3 = localConstraintWidget.mLeft.mTarget.mSolverVariable;
                  }
                  localObject1 = localObject5;
                  if (localObject5 == null)
                  {
                    if (((ConstraintWidget)localObject6).mRight.mTarget == null) {
                      break label964;
                    }
                    localObject1 = ((ConstraintWidget)localObject6).mRight.mTarget.mOwner;
                  }
                  localObject4 = localObject1;
                  if (localObject1 == null) {
                    break label453;
                  }
                  localObject5 = ((ConstraintWidget)localObject1).mLeft.mSolverVariable;
                  if (m != 0) {
                    if (((ConstraintWidget)localObject6).mRight.mTarget == null) {
                      break label970;
                    }
                  }
                }
                for (localObject5 = ((ConstraintWidget)localObject6).mRight.mTarget.mSolverVariable;; localObject5 = null)
                {
                  localObject4 = localObject1;
                  if (localObject3 == null) {
                    break;
                  }
                  localObject4 = localObject1;
                  if (localObject5 == null) {
                    break;
                  }
                  paramLinearSystem.addCentering(localConstraintAnchor1.mSolverVariable, (SolverVariable)localObject3, n, 0.5F, (SolverVariable)localObject5, localConstraintAnchor2.mSolverVariable, i1, 4);
                  localObject4 = localObject1;
                  break;
                  localObject3 = null;
                  break label792;
                  localObject3 = null;
                  break label821;
                  localObject1 = null;
                  break label854;
                }
              }
            }
            if (k != 0)
            {
              localObject3 = ((ConstraintWidget)localObject2).mLeft;
              localObject4 = ((ConstraintWidget)localObject6).mRight;
              i = ((ConstraintAnchor)localObject3).getMargin();
              k = ((ConstraintAnchor)localObject4).getMargin();
              if (localConstraintWidget.mLeft.mTarget != null)
              {
                localObject1 = localConstraintWidget.mLeft.mTarget.mSolverVariable;
                if (((ConstraintWidget)localObject6).mRight.mTarget == null) {
                  break label1124;
                }
              }
              for (localObject2 = ((ConstraintWidget)localObject6).mRight.mTarget.mSolverVariable;; localObject2 = null)
              {
                if ((localObject1 == null) || (localObject2 == null)) {
                  break label1128;
                }
                paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject4).mSolverVariable, (SolverVariable)localObject2, -k, 1);
                paramLinearSystem.addCentering(((ConstraintAnchor)localObject3).mSolverVariable, (SolverVariable)localObject1, i, localConstraintWidget.mHorizontalBiasPercent, (SolverVariable)localObject2, ((ConstraintAnchor)localObject4).mSolverVariable, k, 4);
                break;
                localObject1 = null;
                break label1039;
              }
            }
          }
          else
          {
            localObject1 = null;
            f = 0.0F;
            if (localObject2 != null)
            {
              if (((ConstraintWidget)localObject2).mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                k = ((ConstraintWidget)localObject2).mLeft.getMargin();
                i = k;
                if (localObject1 != null) {
                  i = k + ((ConstraintWidget)localObject1).mRight.getMargin();
                }
                k = 3;
                if (((ConstraintWidget)localObject2).mLeft.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                }
                paramLinearSystem.addGreaterThan(((ConstraintWidget)localObject2).mLeft.mSolverVariable, ((ConstraintWidget)localObject2).mLeft.mTarget.mSolverVariable, i, k);
                k = ((ConstraintWidget)localObject2).mRight.getMargin();
                i = k;
                if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.mTarget != null)
                {
                  i = k;
                  if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.mTarget.mOwner == localObject2) {
                    i = k + ((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.getMargin();
                  }
                }
                k = 3;
                if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                }
                paramLinearSystem.addLowerThan(((ConstraintWidget)localObject2).mRight.mSolverVariable, ((ConstraintWidget)localObject2).mRight.mTarget.mSolverVariable, -i, k);
              }
              for (;;)
              {
                localObject1 = localObject2;
                localObject2 = ((ConstraintWidget)localObject2).mHorizontalNextWidget;
                break;
                f += ((ConstraintWidget)localObject2).mHorizontalWeight;
                i = 0;
                if (((ConstraintWidget)localObject2).mRight.mTarget != null)
                {
                  k = ((ConstraintWidget)localObject2).mRight.getMargin();
                  i = k;
                  if (localObject2 != this.mChainEnds[3]) {
                    i = k + ((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.getMargin();
                  }
                }
                paramLinearSystem.addGreaterThan(((ConstraintWidget)localObject2).mRight.mSolverVariable, ((ConstraintWidget)localObject2).mLeft.mSolverVariable, 0, 1);
                paramLinearSystem.addLowerThan(((ConstraintWidget)localObject2).mRight.mSolverVariable, ((ConstraintWidget)localObject2).mRight.mTarget.mSolverVariable, -i, 1);
              }
            }
            if (n != 1) {
              break label1764;
            }
            localObject2 = this.mMatchConstraintsChainedWidgets[0];
            k = ((ConstraintWidget)localObject2).mLeft.getMargin();
            i = k;
            if (((ConstraintWidget)localObject2).mLeft.mTarget != null) {
              i = k + ((ConstraintWidget)localObject2).mLeft.mTarget.getMargin();
            }
            m = ((ConstraintWidget)localObject2).mRight.getMargin();
            k = m;
            if (((ConstraintWidget)localObject2).mRight.mTarget != null) {
              k = m + ((ConstraintWidget)localObject2).mRight.mTarget.getMargin();
            }
            localObject1 = localConstraintWidget.mRight.mTarget.mSolverVariable;
            if (localObject2 == this.mChainEnds[3]) {
              localObject1 = this.mChainEnds[1].mRight.mTarget.mSolverVariable;
            }
            if (((ConstraintWidget)localObject2).mMatchConstraintDefaultWidth == 1)
            {
              paramLinearSystem.addGreaterThan(localConstraintWidget.mLeft.mSolverVariable, localConstraintWidget.mLeft.mTarget.mSolverVariable, i, 1);
              paramLinearSystem.addLowerThan(localConstraintWidget.mRight.mSolverVariable, (SolverVariable)localObject1, -k, 1);
              paramLinearSystem.addEquality(localConstraintWidget.mRight.mSolverVariable, localConstraintWidget.mLeft.mSolverVariable, localConstraintWidget.getWidth(), 2);
            }
            else
            {
              paramLinearSystem.addEquality(((ConstraintWidget)localObject2).mLeft.mSolverVariable, ((ConstraintWidget)localObject2).mLeft.mTarget.mSolverVariable, i, 1);
              paramLinearSystem.addEquality(((ConstraintWidget)localObject2).mRight.mSolverVariable, (SolverVariable)localObject1, -k, 1);
            }
          }
        }
      }
      label1764:
      int i = 0;
      label1766:
      if (i < n - 1)
      {
        localObject3 = this.mMatchConstraintsChainedWidgets[i];
        localObject4 = this.mMatchConstraintsChainedWidgets[(i + 1)];
        localObject5 = ((ConstraintWidget)localObject3).mLeft.mSolverVariable;
        localObject6 = ((ConstraintWidget)localObject3).mRight.mSolverVariable;
        localObject7 = ((ConstraintWidget)localObject4).mLeft.mSolverVariable;
        localObject1 = ((ConstraintWidget)localObject4).mRight.mSolverVariable;
        if (localObject4 == this.mChainEnds[3]) {
          localObject1 = this.mChainEnds[1].mRight.mSolverVariable;
        }
        m = ((ConstraintWidget)localObject3).mLeft.getMargin();
        k = m;
        if (((ConstraintWidget)localObject3).mLeft.mTarget != null)
        {
          k = m;
          if (((ConstraintWidget)localObject3).mLeft.mTarget.mOwner.mRight.mTarget != null)
          {
            k = m;
            if (((ConstraintWidget)localObject3).mLeft.mTarget.mOwner.mRight.mTarget.mOwner == localObject3) {
              k = m + ((ConstraintWidget)localObject3).mLeft.mTarget.mOwner.mRight.getMargin();
            }
          }
        }
        paramLinearSystem.addGreaterThan((SolverVariable)localObject5, ((ConstraintWidget)localObject3).mLeft.mTarget.mSolverVariable, k, 2);
        m = ((ConstraintWidget)localObject3).mRight.getMargin();
        k = m;
        if (((ConstraintWidget)localObject3).mRight.mTarget != null)
        {
          k = m;
          if (((ConstraintWidget)localObject3).mHorizontalNextWidget != null) {
            if (((ConstraintWidget)localObject3).mHorizontalNextWidget.mLeft.mTarget == null) {
              break label2429;
            }
          }
        }
      }
      label2429:
      for (int k = ((ConstraintWidget)localObject3).mHorizontalNextWidget.mLeft.getMargin();; k = 0)
      {
        k = m + k;
        paramLinearSystem.addLowerThan((SolverVariable)localObject6, ((ConstraintWidget)localObject3).mRight.mTarget.mSolverVariable, -k, 2);
        if (i + 1 == n - 1)
        {
          m = ((ConstraintWidget)localObject4).mLeft.getMargin();
          k = m;
          if (((ConstraintWidget)localObject4).mLeft.mTarget != null)
          {
            k = m;
            if (((ConstraintWidget)localObject4).mLeft.mTarget.mOwner.mRight.mTarget != null)
            {
              k = m;
              if (((ConstraintWidget)localObject4).mLeft.mTarget.mOwner.mRight.mTarget.mOwner == localObject4) {
                k = m + ((ConstraintWidget)localObject4).mLeft.mTarget.mOwner.mRight.getMargin();
              }
            }
          }
          paramLinearSystem.addGreaterThan((SolverVariable)localObject7, ((ConstraintWidget)localObject4).mLeft.mTarget.mSolverVariable, k, 2);
          localObject2 = ((ConstraintWidget)localObject4).mRight;
          if (localObject4 == this.mChainEnds[3]) {
            localObject2 = this.mChainEnds[1].mRight;
          }
          m = ((ConstraintAnchor)localObject2).getMargin();
          k = m;
          if (((ConstraintAnchor)localObject2).mTarget != null)
          {
            k = m;
            if (((ConstraintAnchor)localObject2).mTarget.mOwner.mLeft.mTarget != null)
            {
              k = m;
              if (((ConstraintAnchor)localObject2).mTarget.mOwner.mLeft.mTarget.mOwner == localObject4) {
                k = m + ((ConstraintAnchor)localObject2).mTarget.mOwner.mLeft.getMargin();
              }
            }
          }
          paramLinearSystem.addLowerThan((SolverVariable)localObject1, ((ConstraintAnchor)localObject2).mTarget.mSolverVariable, -k, 2);
        }
        if (localConstraintWidget.mMatchConstraintMaxWidth > 0) {
          paramLinearSystem.addLowerThan((SolverVariable)localObject6, (SolverVariable)localObject5, localConstraintWidget.mMatchConstraintMaxWidth, 2);
        }
        localObject2 = paramLinearSystem.createRow();
        ((ArrayRow)localObject2).createRowEqualDimension(((ConstraintWidget)localObject3).mHorizontalWeight, f, ((ConstraintWidget)localObject4).mHorizontalWeight, (SolverVariable)localObject5, ((ConstraintWidget)localObject3).mLeft.getMargin(), (SolverVariable)localObject6, ((ConstraintWidget)localObject3).mRight.getMargin(), (SolverVariable)localObject7, ((ConstraintWidget)localObject4).mLeft.getMargin(), (SolverVariable)localObject1, ((ConstraintWidget)localObject4).mRight.getMargin());
        paramLinearSystem.addConstraint((ArrayRow)localObject2);
        i += 1;
        break label1766;
        break;
      }
    }
  }
  
  private void applyVerticalChain(LinearSystem paramLinearSystem)
  {
    int j = 0;
    if (j < this.mVerticalChainsSize)
    {
      ConstraintWidget localConstraintWidget = this.mVerticalChainsArray[j];
      int n = countMatchConstraintsChainedWidgets(paramLinearSystem, this.mChainEnds, this.mVerticalChainsArray[j], 1, this.flags);
      Object localObject2 = this.mChainEnds[2];
      if (localObject2 == null) {}
      Object localObject1;
      label150:
      int m;
      label162:
      label243:
      label249:
      label254:
      Object localObject4;
      Object localObject6;
      Object localObject7;
      Object localObject5;
      Object localObject3;
      label395:
      label483:
      label547:
      label867:
      label896:
      label929:
      label1032:
      label1038:
      label1044:
      label1050:
      label1113:
      label1198:
      label1202:
      float f;
      for (;;)
      {
        j += 1;
        break;
        if (this.flags[1] != 0)
        {
          i = localConstraintWidget.getDrawY();
          while (localObject2 != null)
          {
            paramLinearSystem.addEquality(((ConstraintWidget)localObject2).mTop.mSolverVariable, i);
            localObject1 = ((ConstraintWidget)localObject2).mVerticalNextWidget;
            i += ((ConstraintWidget)localObject2).mTop.getMargin() + ((ConstraintWidget)localObject2).getHeight() + ((ConstraintWidget)localObject2).mBottom.getMargin();
            localObject2 = localObject1;
          }
        }
        else
        {
          if (localConstraintWidget.mVerticalChainStyle == 0)
          {
            k = 1;
            if (localConstraintWidget.mVerticalChainStyle != 2) {
              break label243;
            }
            m = 1;
            if (this.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
              break label249;
            }
          }
          for (i = 1;; i = 0)
          {
            if (((this.mOptimizationLevel != 2) && (this.mOptimizationLevel != 8)) || (this.flags[0] == 0) || (!localConstraintWidget.mVerticalChainFixedPosition) || (m != 0) || (i != 0) || (localConstraintWidget.mVerticalChainStyle != 0)) {
              break label254;
            }
            Optimizer.applyDirectResolutionVerticalChain(this, paramLinearSystem, n, localConstraintWidget);
            break;
            k = 0;
            break label150;
            m = 0;
            break label162;
          }
          if ((n == 0) || (m != 0))
          {
            localObject4 = null;
            localObject6 = null;
            n = 0;
            localObject1 = localObject2;
            localObject7 = localObject1;
            if (localObject7 != null)
            {
              localObject5 = ((ConstraintWidget)localObject7).mVerticalNextWidget;
              if (localObject5 == null)
              {
                localObject6 = this.mChainEnds[1];
                n = 1;
              }
              ConstraintAnchor localConstraintAnchor1;
              int i1;
              int i2;
              if (m != 0)
              {
                localConstraintAnchor1 = ((ConstraintWidget)localObject7).mTop;
                i1 = localConstraintAnchor1.getMargin();
                i = i1;
                if (localObject4 != null) {
                  i = i1 + ((ConstraintWidget)localObject4).mBottom.getMargin();
                }
                i1 = 1;
                if (localObject2 != localObject7) {
                  i1 = 3;
                }
                localObject1 = null;
                localObject3 = null;
                if (localConstraintAnchor1.mTarget != null)
                {
                  localObject1 = localConstraintAnchor1.mSolverVariable;
                  localObject3 = localConstraintAnchor1.mTarget.mSolverVariable;
                  i2 = i;
                  if ((localObject1 != null) && (localObject3 != null)) {
                    paramLinearSystem.addGreaterThan((SolverVariable)localObject1, (SolverVariable)localObject3, i2, i1);
                  }
                  localObject4 = localObject5;
                  if (((ConstraintWidget)localObject7).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
                  {
                    localObject1 = ((ConstraintWidget)localObject7).mBottom;
                    if (((ConstraintWidget)localObject7).mMatchConstraintDefaultHeight != 1) {
                      break label547;
                    }
                    i = Math.max(((ConstraintWidget)localObject7).mMatchConstraintMinHeight, ((ConstraintWidget)localObject7).getHeight());
                    paramLinearSystem.addEquality(((ConstraintAnchor)localObject1).mSolverVariable, localConstraintAnchor1.mSolverVariable, i, 3);
                    localObject4 = localObject5;
                  }
                  if (n == 0) {
                    break label1050;
                  }
                }
              }
              for (localObject1 = null;; localObject1 = localObject4)
              {
                localObject4 = localObject7;
                break;
                i2 = i;
                if (((ConstraintWidget)localObject7).mBaseline.mTarget == null) {
                  break label395;
                }
                localObject1 = ((ConstraintWidget)localObject7).mBaseline.mSolverVariable;
                localObject3 = ((ConstraintWidget)localObject7).mBaseline.mTarget.mSolverVariable;
                i2 = i - localConstraintAnchor1.getMargin();
                break label395;
                paramLinearSystem.addGreaterThan(localConstraintAnchor1.mSolverVariable, localConstraintAnchor1.mTarget.mSolverVariable, localConstraintAnchor1.mMargin, 3);
                paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject1).mSolverVariable, localConstraintAnchor1.mSolverVariable, ((ConstraintWidget)localObject7).mMatchConstraintMinHeight, 3);
                localObject4 = localObject5;
                break label483;
                if ((k == 0) && (n != 0) && (localObject4 != null))
                {
                  if (((ConstraintWidget)localObject7).mBottom.mTarget == null)
                  {
                    paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mBottom.mSolverVariable, ((ConstraintWidget)localObject7).getDrawBottom());
                    localObject4 = localObject5;
                    break label483;
                  }
                  i = ((ConstraintWidget)localObject7).mBottom.getMargin();
                  paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mBottom.mSolverVariable, ((ConstraintWidget)localObject6).mBottom.mTarget.mSolverVariable, -i, 5);
                  localObject4 = localObject5;
                  break label483;
                }
                if ((k == 0) && (n == 0) && (localObject4 == null))
                {
                  if (((ConstraintWidget)localObject7).mTop.mTarget == null)
                  {
                    paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mTop.mSolverVariable, ((ConstraintWidget)localObject7).getDrawY());
                    localObject4 = localObject5;
                    break label483;
                  }
                  i = ((ConstraintWidget)localObject7).mTop.getMargin();
                  paramLinearSystem.addEquality(((ConstraintWidget)localObject7).mTop.mSolverVariable, localConstraintWidget.mTop.mTarget.mSolverVariable, i, 5);
                  localObject4 = localObject5;
                  break label483;
                }
                localConstraintAnchor1 = ((ConstraintWidget)localObject7).mTop;
                ConstraintAnchor localConstraintAnchor2 = ((ConstraintWidget)localObject7).mBottom;
                i = localConstraintAnchor1.getMargin();
                i1 = localConstraintAnchor2.getMargin();
                paramLinearSystem.addGreaterThan(localConstraintAnchor1.mSolverVariable, localConstraintAnchor1.mTarget.mSolverVariable, i, 1);
                paramLinearSystem.addLowerThan(localConstraintAnchor2.mSolverVariable, localConstraintAnchor2.mTarget.mSolverVariable, -i1, 1);
                if (localConstraintAnchor1.mTarget != null)
                {
                  localObject3 = localConstraintAnchor1.mTarget.mSolverVariable;
                  if (localObject4 == null)
                  {
                    if (localConstraintWidget.mTop.mTarget == null) {
                      break label1032;
                    }
                    localObject3 = localConstraintWidget.mTop.mTarget.mSolverVariable;
                  }
                  localObject1 = localObject5;
                  if (localObject5 == null)
                  {
                    if (((ConstraintWidget)localObject6).mBottom.mTarget == null) {
                      break label1038;
                    }
                    localObject1 = ((ConstraintWidget)localObject6).mBottom.mTarget.mOwner;
                  }
                  localObject4 = localObject1;
                  if (localObject1 == null) {
                    break label483;
                  }
                  localObject5 = ((ConstraintWidget)localObject1).mTop.mSolverVariable;
                  if (n != 0) {
                    if (((ConstraintWidget)localObject6).mBottom.mTarget == null) {
                      break label1044;
                    }
                  }
                }
                for (localObject5 = ((ConstraintWidget)localObject6).mBottom.mTarget.mSolverVariable;; localObject5 = null)
                {
                  localObject4 = localObject1;
                  if (localObject3 == null) {
                    break;
                  }
                  localObject4 = localObject1;
                  if (localObject5 == null) {
                    break;
                  }
                  paramLinearSystem.addCentering(localConstraintAnchor1.mSolverVariable, (SolverVariable)localObject3, i, 0.5F, (SolverVariable)localObject5, localConstraintAnchor2.mSolverVariable, i1, 4);
                  localObject4 = localObject1;
                  break;
                  localObject3 = null;
                  break label867;
                  localObject3 = null;
                  break label896;
                  localObject1 = null;
                  break label929;
                }
              }
            }
            if (m != 0)
            {
              localObject3 = ((ConstraintWidget)localObject2).mTop;
              localObject4 = ((ConstraintWidget)localObject6).mBottom;
              i = ((ConstraintAnchor)localObject3).getMargin();
              k = ((ConstraintAnchor)localObject4).getMargin();
              if (localConstraintWidget.mTop.mTarget != null)
              {
                localObject1 = localConstraintWidget.mTop.mTarget.mSolverVariable;
                if (((ConstraintWidget)localObject6).mBottom.mTarget == null) {
                  break label1198;
                }
              }
              for (localObject2 = ((ConstraintWidget)localObject6).mBottom.mTarget.mSolverVariable;; localObject2 = null)
              {
                if ((localObject1 == null) || (localObject2 == null)) {
                  break label1202;
                }
                paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject4).mSolverVariable, (SolverVariable)localObject2, -k, 1);
                paramLinearSystem.addCentering(((ConstraintAnchor)localObject3).mSolverVariable, (SolverVariable)localObject1, i, localConstraintWidget.mVerticalBiasPercent, (SolverVariable)localObject2, ((ConstraintAnchor)localObject4).mSolverVariable, k, 4);
                break;
                localObject1 = null;
                break label1113;
              }
            }
          }
          else
          {
            localObject1 = null;
            f = 0.0F;
            if (localObject2 != null)
            {
              if (((ConstraintWidget)localObject2).mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                k = ((ConstraintWidget)localObject2).mTop.getMargin();
                i = k;
                if (localObject1 != null) {
                  i = k + ((ConstraintWidget)localObject1).mBottom.getMargin();
                }
                k = 3;
                if (((ConstraintWidget)localObject2).mTop.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                }
                paramLinearSystem.addGreaterThan(((ConstraintWidget)localObject2).mTop.mSolverVariable, ((ConstraintWidget)localObject2).mTop.mTarget.mSolverVariable, i, k);
                k = ((ConstraintWidget)localObject2).mBottom.getMargin();
                i = k;
                if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.mTarget != null)
                {
                  i = k;
                  if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.mTarget.mOwner == localObject2) {
                    i = k + ((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.getMargin();
                  }
                }
                k = 3;
                if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                }
                paramLinearSystem.addLowerThan(((ConstraintWidget)localObject2).mBottom.mSolverVariable, ((ConstraintWidget)localObject2).mBottom.mTarget.mSolverVariable, -i, k);
              }
              for (;;)
              {
                localObject1 = localObject2;
                localObject2 = ((ConstraintWidget)localObject2).mVerticalNextWidget;
                break;
                f += ((ConstraintWidget)localObject2).mVerticalWeight;
                i = 0;
                if (((ConstraintWidget)localObject2).mBottom.mTarget != null)
                {
                  k = ((ConstraintWidget)localObject2).mBottom.getMargin();
                  i = k;
                  if (localObject2 != this.mChainEnds[3]) {
                    i = k + ((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.getMargin();
                  }
                }
                paramLinearSystem.addGreaterThan(((ConstraintWidget)localObject2).mBottom.mSolverVariable, ((ConstraintWidget)localObject2).mTop.mSolverVariable, 0, 1);
                paramLinearSystem.addLowerThan(((ConstraintWidget)localObject2).mBottom.mSolverVariable, ((ConstraintWidget)localObject2).mBottom.mTarget.mSolverVariable, -i, 1);
              }
            }
            if (n != 1) {
              break label1838;
            }
            localObject2 = this.mMatchConstraintsChainedWidgets[0];
            k = ((ConstraintWidget)localObject2).mTop.getMargin();
            i = k;
            if (((ConstraintWidget)localObject2).mTop.mTarget != null) {
              i = k + ((ConstraintWidget)localObject2).mTop.mTarget.getMargin();
            }
            m = ((ConstraintWidget)localObject2).mBottom.getMargin();
            k = m;
            if (((ConstraintWidget)localObject2).mBottom.mTarget != null) {
              k = m + ((ConstraintWidget)localObject2).mBottom.mTarget.getMargin();
            }
            localObject1 = localConstraintWidget.mBottom.mTarget.mSolverVariable;
            if (localObject2 == this.mChainEnds[3]) {
              localObject1 = this.mChainEnds[1].mBottom.mTarget.mSolverVariable;
            }
            if (((ConstraintWidget)localObject2).mMatchConstraintDefaultHeight == 1)
            {
              paramLinearSystem.addGreaterThan(localConstraintWidget.mTop.mSolverVariable, localConstraintWidget.mTop.mTarget.mSolverVariable, i, 1);
              paramLinearSystem.addLowerThan(localConstraintWidget.mBottom.mSolverVariable, (SolverVariable)localObject1, -k, 1);
              paramLinearSystem.addEquality(localConstraintWidget.mBottom.mSolverVariable, localConstraintWidget.mTop.mSolverVariable, localConstraintWidget.getHeight(), 2);
            }
            else
            {
              paramLinearSystem.addEquality(((ConstraintWidget)localObject2).mTop.mSolverVariable, ((ConstraintWidget)localObject2).mTop.mTarget.mSolverVariable, i, 1);
              paramLinearSystem.addEquality(((ConstraintWidget)localObject2).mBottom.mSolverVariable, (SolverVariable)localObject1, -k, 1);
            }
          }
        }
      }
      label1838:
      int i = 0;
      label1840:
      if (i < n - 1)
      {
        localObject3 = this.mMatchConstraintsChainedWidgets[i];
        localObject4 = this.mMatchConstraintsChainedWidgets[(i + 1)];
        localObject5 = ((ConstraintWidget)localObject3).mTop.mSolverVariable;
        localObject6 = ((ConstraintWidget)localObject3).mBottom.mSolverVariable;
        localObject7 = ((ConstraintWidget)localObject4).mTop.mSolverVariable;
        localObject1 = ((ConstraintWidget)localObject4).mBottom.mSolverVariable;
        if (localObject4 == this.mChainEnds[3]) {
          localObject1 = this.mChainEnds[1].mBottom.mSolverVariable;
        }
        m = ((ConstraintWidget)localObject3).mTop.getMargin();
        k = m;
        if (((ConstraintWidget)localObject3).mTop.mTarget != null)
        {
          k = m;
          if (((ConstraintWidget)localObject3).mTop.mTarget.mOwner.mBottom.mTarget != null)
          {
            k = m;
            if (((ConstraintWidget)localObject3).mTop.mTarget.mOwner.mBottom.mTarget.mOwner == localObject3) {
              k = m + ((ConstraintWidget)localObject3).mTop.mTarget.mOwner.mBottom.getMargin();
            }
          }
        }
        paramLinearSystem.addGreaterThan((SolverVariable)localObject5, ((ConstraintWidget)localObject3).mTop.mTarget.mSolverVariable, k, 2);
        m = ((ConstraintWidget)localObject3).mBottom.getMargin();
        k = m;
        if (((ConstraintWidget)localObject3).mBottom.mTarget != null)
        {
          k = m;
          if (((ConstraintWidget)localObject3).mVerticalNextWidget != null) {
            if (((ConstraintWidget)localObject3).mVerticalNextWidget.mTop.mTarget == null) {
              break label2503;
            }
          }
        }
      }
      label2503:
      for (int k = ((ConstraintWidget)localObject3).mVerticalNextWidget.mTop.getMargin();; k = 0)
      {
        k = m + k;
        paramLinearSystem.addLowerThan((SolverVariable)localObject6, ((ConstraintWidget)localObject3).mBottom.mTarget.mSolverVariable, -k, 2);
        if (i + 1 == n - 1)
        {
          m = ((ConstraintWidget)localObject4).mTop.getMargin();
          k = m;
          if (((ConstraintWidget)localObject4).mTop.mTarget != null)
          {
            k = m;
            if (((ConstraintWidget)localObject4).mTop.mTarget.mOwner.mBottom.mTarget != null)
            {
              k = m;
              if (((ConstraintWidget)localObject4).mTop.mTarget.mOwner.mBottom.mTarget.mOwner == localObject4) {
                k = m + ((ConstraintWidget)localObject4).mTop.mTarget.mOwner.mBottom.getMargin();
              }
            }
          }
          paramLinearSystem.addGreaterThan((SolverVariable)localObject7, ((ConstraintWidget)localObject4).mTop.mTarget.mSolverVariable, k, 2);
          localObject2 = ((ConstraintWidget)localObject4).mBottom;
          if (localObject4 == this.mChainEnds[3]) {
            localObject2 = this.mChainEnds[1].mBottom;
          }
          m = ((ConstraintAnchor)localObject2).getMargin();
          k = m;
          if (((ConstraintAnchor)localObject2).mTarget != null)
          {
            k = m;
            if (((ConstraintAnchor)localObject2).mTarget.mOwner.mTop.mTarget != null)
            {
              k = m;
              if (((ConstraintAnchor)localObject2).mTarget.mOwner.mTop.mTarget.mOwner == localObject4) {
                k = m + ((ConstraintAnchor)localObject2).mTarget.mOwner.mTop.getMargin();
              }
            }
          }
          paramLinearSystem.addLowerThan((SolverVariable)localObject1, ((ConstraintAnchor)localObject2).mTarget.mSolverVariable, -k, 2);
        }
        if (localConstraintWidget.mMatchConstraintMaxHeight > 0) {
          paramLinearSystem.addLowerThan((SolverVariable)localObject6, (SolverVariable)localObject5, localConstraintWidget.mMatchConstraintMaxHeight, 2);
        }
        localObject2 = paramLinearSystem.createRow();
        ((ArrayRow)localObject2).createRowEqualDimension(((ConstraintWidget)localObject3).mVerticalWeight, f, ((ConstraintWidget)localObject4).mVerticalWeight, (SolverVariable)localObject5, ((ConstraintWidget)localObject3).mTop.getMargin(), (SolverVariable)localObject6, ((ConstraintWidget)localObject3).mBottom.getMargin(), (SolverVariable)localObject7, ((ConstraintWidget)localObject4).mTop.getMargin(), (SolverVariable)localObject1, ((ConstraintWidget)localObject4).mBottom.getMargin());
        paramLinearSystem.addConstraint((ArrayRow)localObject2);
        i += 1;
        break label1840;
        break;
      }
    }
  }
  
  private int countMatchConstraintsChainedWidgets(LinearSystem paramLinearSystem, ConstraintWidget[] paramArrayOfConstraintWidget, ConstraintWidget paramConstraintWidget, int paramInt, boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    int i = 0;
    paramArrayOfBoolean[0] = true;
    paramArrayOfBoolean[1] = false;
    paramArrayOfConstraintWidget[0] = null;
    paramArrayOfConstraintWidget[2] = null;
    paramArrayOfConstraintWidget[1] = null;
    paramArrayOfConstraintWidget[3] = null;
    Object localObject3;
    Object localObject5;
    if (paramInt == 0)
    {
      bool2 = true;
      localObject4 = null;
      bool1 = bool2;
      if (paramConstraintWidget.mLeft.mTarget != null)
      {
        bool1 = bool2;
        if (paramConstraintWidget.mLeft.mTarget.mOwner != this) {
          bool1 = false;
        }
      }
      paramConstraintWidget.mHorizontalNextWidget = null;
      localObject1 = null;
      if (paramConstraintWidget.getVisibility() != 8) {
        localObject1 = paramConstraintWidget;
      }
      localObject2 = localObject1;
      localConstraintWidget = paramConstraintWidget;
      for (paramInt = i;; paramInt = i)
      {
        j = paramInt;
        localObject3 = localObject1;
        localObject5 = localObject2;
        if (localConstraintWidget.mRight.mTarget != null)
        {
          localConstraintWidget.mHorizontalNextWidget = null;
          if (localConstraintWidget.getVisibility() == 8) {
            break label429;
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = localConstraintWidget;
          }
          if ((localObject2 != null) && (localObject2 != localConstraintWidget)) {
            ((ConstraintWidget)localObject2).mHorizontalNextWidget = localConstraintWidget;
          }
          localObject2 = localConstraintWidget;
          localObject1 = localObject3;
          i = paramInt;
          if (localConstraintWidget.getVisibility() != 8)
          {
            i = paramInt;
            if (localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            {
              if (localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                paramArrayOfBoolean[0] = false;
              }
              i = paramInt;
              if (localConstraintWidget.mDimensionRatio <= 0.0F)
              {
                paramArrayOfBoolean[0] = false;
                if (paramInt + 1 >= this.mMatchConstraintsChainedWidgets.length) {
                  this.mMatchConstraintsChainedWidgets = ((ConstraintWidget[])Arrays.copyOf(this.mMatchConstraintsChainedWidgets, this.mMatchConstraintsChainedWidgets.length * 2));
                }
                this.mMatchConstraintsChainedWidgets[paramInt] = localConstraintWidget;
                i = paramInt + 1;
              }
            }
          }
          if (localConstraintWidget.mRight.mTarget.mOwner.mLeft.mTarget != null) {
            break label481;
          }
          localObject5 = localObject2;
          localObject3 = localObject1;
          j = i;
        }
        label429:
        label481:
        do
        {
          do
          {
            bool2 = bool1;
            if (localConstraintWidget.mRight.mTarget != null)
            {
              bool2 = bool1;
              if (localConstraintWidget.mRight.mTarget.mOwner != this) {
                bool2 = false;
              }
            }
            if ((paramConstraintWidget.mLeft.mTarget == null) || (((ConstraintWidget)localObject4).mRight.mTarget == null)) {
              paramArrayOfBoolean[1] = true;
            }
            paramConstraintWidget.mHorizontalChainFixedPosition = bool2;
            ((ConstraintWidget)localObject4).mHorizontalNextWidget = null;
            paramArrayOfConstraintWidget[0] = paramConstraintWidget;
            paramArrayOfConstraintWidget[2] = localObject3;
            paramArrayOfConstraintWidget[1] = localObject4;
            paramArrayOfConstraintWidget[3] = localObject5;
            return j;
            paramLinearSystem.addEquality(localConstraintWidget.mLeft.mSolverVariable, localConstraintWidget.mLeft.mTarget.mSolverVariable, 0, 5);
            paramLinearSystem.addEquality(localConstraintWidget.mRight.mSolverVariable, localConstraintWidget.mLeft.mSolverVariable, 0, 5);
            break;
            j = i;
            localObject3 = localObject1;
            localObject5 = localObject2;
          } while (localConstraintWidget.mRight.mTarget.mOwner.mLeft.mTarget.mOwner != localConstraintWidget);
          j = i;
          localObject3 = localObject1;
          localObject5 = localObject2;
        } while (localConstraintWidget.mRight.mTarget.mOwner == localConstraintWidget);
        localConstraintWidget = localConstraintWidget.mRight.mTarget.mOwner;
        localObject4 = localConstraintWidget;
      }
    }
    boolean bool2 = true;
    Object localObject4 = null;
    boolean bool1 = bool2;
    if (paramConstraintWidget.mTop.mTarget != null)
    {
      bool1 = bool2;
      if (paramConstraintWidget.mTop.mTarget.mOwner != this) {
        bool1 = false;
      }
    }
    paramConstraintWidget.mVerticalNextWidget = null;
    Object localObject1 = null;
    if (paramConstraintWidget.getVisibility() != 8) {
      localObject1 = paramConstraintWidget;
    }
    Object localObject2 = localObject1;
    ConstraintWidget localConstraintWidget = paramConstraintWidget;
    for (paramInt = j;; paramInt = i)
    {
      j = paramInt;
      localObject3 = localObject1;
      localObject5 = localObject2;
      if (localConstraintWidget.mBottom.mTarget != null)
      {
        localConstraintWidget.mVerticalNextWidget = null;
        if (localConstraintWidget.getVisibility() == 8) {
          break label962;
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = localConstraintWidget;
        }
        if ((localObject2 != null) && (localObject2 != localConstraintWidget)) {
          ((ConstraintWidget)localObject2).mVerticalNextWidget = localConstraintWidget;
        }
        localObject2 = localConstraintWidget;
        localObject1 = localObject3;
        i = paramInt;
        if (localConstraintWidget.getVisibility() != 8)
        {
          i = paramInt;
          if (localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            if (localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              paramArrayOfBoolean[0] = false;
            }
            i = paramInt;
            if (localConstraintWidget.mDimensionRatio <= 0.0F)
            {
              paramArrayOfBoolean[0] = false;
              if (paramInt + 1 >= this.mMatchConstraintsChainedWidgets.length) {
                this.mMatchConstraintsChainedWidgets = ((ConstraintWidget[])Arrays.copyOf(this.mMatchConstraintsChainedWidgets, this.mMatchConstraintsChainedWidgets.length * 2));
              }
              this.mMatchConstraintsChainedWidgets[paramInt] = localConstraintWidget;
              i = paramInt + 1;
            }
          }
        }
        if (localConstraintWidget.mBottom.mTarget.mOwner.mTop.mTarget != null) {
          break label1014;
        }
        localObject5 = localObject2;
        localObject3 = localObject1;
        j = i;
      }
      label962:
      label1014:
      do
      {
        do
        {
          bool2 = bool1;
          if (localConstraintWidget.mBottom.mTarget != null)
          {
            bool2 = bool1;
            if (localConstraintWidget.mBottom.mTarget.mOwner != this) {
              bool2 = false;
            }
          }
          if ((paramConstraintWidget.mTop.mTarget == null) || (((ConstraintWidget)localObject4).mBottom.mTarget == null)) {
            paramArrayOfBoolean[1] = true;
          }
          paramConstraintWidget.mVerticalChainFixedPosition = bool2;
          ((ConstraintWidget)localObject4).mVerticalNextWidget = null;
          paramArrayOfConstraintWidget[0] = paramConstraintWidget;
          paramArrayOfConstraintWidget[2] = localObject3;
          paramArrayOfConstraintWidget[1] = localObject4;
          paramArrayOfConstraintWidget[3] = localObject5;
          return j;
          paramLinearSystem.addEquality(localConstraintWidget.mTop.mSolverVariable, localConstraintWidget.mTop.mTarget.mSolverVariable, 0, 5);
          paramLinearSystem.addEquality(localConstraintWidget.mBottom.mSolverVariable, localConstraintWidget.mTop.mSolverVariable, 0, 5);
          break;
          j = i;
          localObject3 = localObject1;
          localObject5 = localObject2;
        } while (localConstraintWidget.mBottom.mTarget.mOwner.mTop.mTarget.mOwner != localConstraintWidget);
        j = i;
        localObject3 = localObject1;
        localObject5 = localObject2;
      } while (localConstraintWidget.mBottom.mTarget.mOwner == localConstraintWidget);
      localConstraintWidget = localConstraintWidget.mBottom.mTarget.mOwner;
      localObject4 = localConstraintWidget;
    }
  }
  
  public static ConstraintWidgetContainer createContainer(ConstraintWidgetContainer paramConstraintWidgetContainer, String paramString, ArrayList<ConstraintWidget> paramArrayList, int paramInt)
  {
    Rectangle localRectangle = getBounds(paramArrayList);
    if ((localRectangle.width == 0) || (localRectangle.height == 0)) {
      paramString = null;
    }
    int i;
    ConstraintWidget localConstraintWidget;
    do
    {
      return paramString;
      if (paramInt > 0)
      {
        int j = Math.min(localRectangle.x, localRectangle.y);
        i = paramInt;
        if (paramInt > j) {
          i = j;
        }
        localRectangle.grow(i, i);
      }
      paramConstraintWidgetContainer.setOrigin(localRectangle.x, localRectangle.y);
      paramConstraintWidgetContainer.setDimension(localRectangle.width, localRectangle.height);
      paramConstraintWidgetContainer.setDebugName(paramString);
      localConstraintWidget = ((ConstraintWidget)paramArrayList.get(0)).getParent();
      paramInt = 0;
      i = paramArrayList.size();
      paramString = paramConstraintWidgetContainer;
    } while (paramInt >= i);
    paramString = (ConstraintWidget)paramArrayList.get(paramInt);
    if (paramString.getParent() != localConstraintWidget) {}
    for (;;)
    {
      paramInt += 1;
      break;
      paramConstraintWidgetContainer.add(paramString);
      paramString.setX(paramString.getX() - localRectangle.x);
      paramString.setY(paramString.getY() - localRectangle.y);
    }
  }
  
  private boolean optimize(LinearSystem paramLinearSystem)
  {
    int i5 = this.mChildren.size();
    int k = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int j = 0;
    int n;
    int i1;
    ConstraintWidget localConstraintWidget;
    for (;;)
    {
      m = i3;
      i = k;
      n = i2;
      i1 = i4;
      if (j >= i5) {
        break;
      }
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(j);
      localConstraintWidget.mHorizontalResolution = -1;
      localConstraintWidget.mVerticalResolution = -1;
      if ((localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
      {
        localConstraintWidget.mHorizontalResolution = 1;
        localConstraintWidget.mVerticalResolution = 1;
      }
      j += 1;
    }
    if ((k == 0) && (j == 0))
    {
      i = 1;
      i1 = i2;
      n = k;
      m = j;
    }
    for (;;)
    {
      i4 = n;
      i3 = m;
      if (i != 0) {
        break label352;
      }
      k = 0;
      j = 0;
      i2 = i1 + 1;
      m = 0;
      label158:
      if (m < i5)
      {
        localConstraintWidget = (ConstraintWidget)this.mChildren.get(m);
        if (localConstraintWidget.mHorizontalResolution == -1)
        {
          if (this.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            break label281;
          }
          localConstraintWidget.mHorizontalResolution = 1;
        }
        label204:
        if (localConstraintWidget.mVerticalResolution == -1)
        {
          if (this.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            break label291;
          }
          localConstraintWidget.mVerticalResolution = 1;
        }
      }
      for (;;)
      {
        n = k;
        if (localConstraintWidget.mVerticalResolution == -1) {
          n = k + 1;
        }
        k = j;
        if (localConstraintWidget.mHorizontalResolution == -1) {
          k = j + 1;
        }
        m += 1;
        j = k;
        k = n;
        break label158;
        break;
        label281:
        Optimizer.checkHorizontalSimpleDependency(this, paramLinearSystem, localConstraintWidget);
        break label204;
        label291:
        Optimizer.checkVerticalSimpleDependency(this, paramLinearSystem, localConstraintWidget);
      }
      m = j;
      n = k;
      i1 = i2;
      if (i4 == k)
      {
        m = j;
        n = k;
        i1 = i2;
        if (i3 == j)
        {
          i = 1;
          m = j;
          n = k;
          i1 = i2;
        }
      }
    }
    label352:
    int m = 0;
    int i = 0;
    j = 0;
    while (j < i5)
    {
      paramLinearSystem = (ConstraintWidget)this.mChildren.get(j);
      if (paramLinearSystem.mHorizontalResolution != 1)
      {
        k = m;
        if (paramLinearSystem.mHorizontalResolution != -1) {}
      }
      else
      {
        k = m + 1;
      }
      if (paramLinearSystem.mVerticalResolution != 1)
      {
        n = i;
        if (paramLinearSystem.mVerticalResolution != -1) {}
      }
      else
      {
        n = i + 1;
      }
      j += 1;
      m = k;
      i = n;
    }
    return (m == 0) && (i == 0);
  }
  
  private void resetChains()
  {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  static int setGroup(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    int j = paramConstraintAnchor.mGroup;
    if (paramConstraintAnchor.mOwner.getParent() == null) {
      i = paramInt;
    }
    do
    {
      return i;
      i = j;
    } while (j <= paramInt);
    paramConstraintAnchor.mGroup = paramInt;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintAnchor.getOpposite();
    ConstraintAnchor localConstraintAnchor2 = paramConstraintAnchor.mTarget;
    int i = paramInt;
    if (localConstraintAnchor1 != null) {
      i = setGroup(localConstraintAnchor1, paramInt);
    }
    paramInt = i;
    if (localConstraintAnchor2 != null) {
      paramInt = setGroup(localConstraintAnchor2, i);
    }
    i = paramInt;
    if (localConstraintAnchor1 != null) {
      i = setGroup(localConstraintAnchor1, paramInt);
    }
    paramConstraintAnchor.mGroup = i;
    return i;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      while ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner.mRight.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner.mRight.mTarget == paramConstraintWidget.mLeft) && (paramConstraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget)) {
        paramConstraintWidget = paramConstraintWidget.mLeft.mTarget.mOwner;
      }
      addHorizontalChain(paramConstraintWidget);
    }
    while (paramInt != 1) {
      return;
    }
    while ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner.mBottom.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner.mBottom.mTarget == paramConstraintWidget.mTop) && (paramConstraintWidget.mTop.mTarget.mOwner != paramConstraintWidget)) {
      paramConstraintWidget = paramConstraintWidget.mTop.mTarget.mOwner;
    }
    addVerticalChain(paramConstraintWidget);
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    addToSolver(paramLinearSystem, paramInt);
    int k = this.mChildren.size();
    int i = 0;
    if ((this.mOptimizationLevel == 2) || (this.mOptimizationLevel == 4))
    {
      if (optimize(paramLinearSystem)) {
        return false;
      }
    }
    else {
      i = 1;
    }
    int j = 0;
    if (j < k)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(j);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.mHorizontalDimensionBehaviour;
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = localConstraintWidget.mVerticalDimensionBehaviour;
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem, paramInt);
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (i != 0) {
          Optimizer.checkMatchParent(this, paramLinearSystem, localConstraintWidget);
        }
        localConstraintWidget.addToSolver(paramLinearSystem, paramInt);
      }
    }
    if (this.mHorizontalChainsSize > 0) {
      applyHorizontalChain(paramLinearSystem);
    }
    if (this.mVerticalChainsSize > 0) {
      applyVerticalChain(paramLinearSystem);
    }
    return true;
  }
  
  public void findHorizontalWrapRecursive(ConstraintWidget paramConstraintWidget, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = false;
    if ((paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int m = paramConstraintWidget.getOptimizerWrapWidth();
    if ((paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int j = m;
    Object localObject2 = null;
    Object localObject1 = null;
    paramConstraintWidget.mHorizontalWrapVisited = true;
    int i;
    int k;
    if ((paramConstraintWidget instanceof Guideline))
    {
      paramArrayOfBoolean = (Guideline)paramConstraintWidget;
      i = m;
      if (paramArrayOfBoolean.getOrientation() == 1)
      {
        k = 0;
        j = 0;
        if (paramArrayOfBoolean.getRelativeBegin() == -1) {
          break label180;
        }
        i = paramArrayOfBoolean.getRelativeBegin();
      }
    }
    label180:
    label537:
    boolean bool1;
    label581:
    label609:
    label622:
    int n;
    label686:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            m = i;
            k = j;
            if (paramConstraintWidget.getVisibility() == 8)
            {
              m = i - paramConstraintWidget.mWidth;
              k = j - paramConstraintWidget.mWidth;
            }
            paramConstraintWidget.mDistToLeft = m;
            paramConstraintWidget.mDistToRight = k;
            return;
            i = k;
            if (paramArrayOfBoolean.getRelativeEnd() != -1)
            {
              j = paramArrayOfBoolean.getRelativeEnd();
              i = k;
              continue;
              if ((paramConstraintWidget.mRight.isConnected()) || (paramConstraintWidget.mLeft.isConnected())) {
                break;
              }
              i = m + paramConstraintWidget.getX();
            }
          }
          if ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mLeft.mTarget != null) && ((paramConstraintWidget.mRight.mTarget == paramConstraintWidget.mLeft.mTarget) || ((paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidget.mLeft.mTarget.mOwner) && (paramConstraintWidget.mRight.mTarget.mOwner != paramConstraintWidget.mParent))))
          {
            paramArrayOfBoolean[0] = false;
            return;
          }
          i = j;
          ConstraintWidget localConstraintWidget;
          if (paramConstraintWidget.mRight.mTarget != null)
          {
            localConstraintWidget = paramConstraintWidget.mRight.mTarget.mOwner;
            j += paramConstraintWidget.mRight.getMargin();
            i = j;
            localObject1 = localConstraintWidget;
            if (!localConstraintWidget.isRoot())
            {
              i = j;
              localObject1 = localConstraintWidget;
              if (!localConstraintWidget.mHorizontalWrapVisited)
              {
                findHorizontalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
                localObject1 = localConstraintWidget;
                i = j;
              }
            }
          }
          k = m;
          if (paramConstraintWidget.mLeft.mTarget != null)
          {
            localConstraintWidget = paramConstraintWidget.mLeft.mTarget.mOwner;
            j = m + paramConstraintWidget.mLeft.getMargin();
            k = j;
            localObject2 = localConstraintWidget;
            if (!localConstraintWidget.isRoot())
            {
              k = j;
              localObject2 = localConstraintWidget;
              if (!localConstraintWidget.mHorizontalWrapVisited)
              {
                findHorizontalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
                localObject2 = localConstraintWidget;
                k = j;
              }
            }
          }
          m = i;
          if (paramConstraintWidget.mRight.mTarget != null)
          {
            m = i;
            if (!((ConstraintWidget)localObject1).isRoot())
            {
              if (paramConstraintWidget.mRight.mTarget.mType != ConstraintAnchor.Type.RIGHT) {
                break;
              }
              j = i + (((ConstraintWidget)localObject1).mDistToRight - ((ConstraintWidget)localObject1).getOptimizerWrapWidth());
              if ((!((ConstraintWidget)localObject1).mRightHasCentered) && ((((ConstraintWidget)localObject1).mLeft.mTarget == null) || (((ConstraintWidget)localObject1).mRight.mTarget == null) || (((ConstraintWidget)localObject1).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                break label823;
              }
              bool1 = true;
              paramConstraintWidget.mRightHasCentered = bool1;
              m = j;
              if (paramConstraintWidget.mRightHasCentered)
              {
                if (((ConstraintWidget)localObject1).mLeft.mTarget != null) {
                  break label829;
                }
                m = j + (j - ((ConstraintWidget)localObject1).mDistToRight);
              }
            }
          }
          i = k;
          j = m;
        } while (paramConstraintWidget.mLeft.mTarget == null);
        i = k;
        j = m;
      } while (((ConstraintWidget)localObject2).isRoot());
      if (paramConstraintWidget.mLeft.mTarget.getType() != ConstraintAnchor.Type.LEFT) {
        break label851;
      }
      n = k + (((ConstraintWidget)localObject2).mDistToLeft - ((ConstraintWidget)localObject2).getOptimizerWrapWidth());
      if (!((ConstraintWidget)localObject2).mLeftHasCentered)
      {
        bool1 = bool2;
        if (((ConstraintWidget)localObject2).mLeft.mTarget != null)
        {
          bool1 = bool2;
          if (((ConstraintWidget)localObject2).mRight.mTarget != null)
          {
            bool1 = bool2;
            if (((ConstraintWidget)localObject2).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      paramConstraintWidget.mLeftHasCentered = bool1;
      i = n;
      j = m;
    } while (!paramConstraintWidget.mLeftHasCentered);
    if (((ConstraintWidget)localObject2).mRight.mTarget == null) {}
    for (;;)
    {
      i = n + (n - ((ConstraintWidget)localObject2).mDistToLeft);
      j = m;
      break;
      j = i;
      if (paramConstraintWidget.mRight.mTarget.getType() != ConstraintAnchor.Type.LEFT) {
        break label537;
      }
      j = i + ((ConstraintWidget)localObject1).mDistToRight;
      break label537;
      label823:
      bool1 = false;
      break label581;
      label829:
      m = j;
      if (((ConstraintWidget)localObject1).mLeft.mTarget.mOwner == paramConstraintWidget) {
        break label622;
      }
      break label609;
      label851:
      n = k;
      if (paramConstraintWidget.mLeft.mTarget.getType() != ConstraintAnchor.Type.RIGHT) {
        break label686;
      }
      n = k + ((ConstraintWidget)localObject2).mDistToLeft;
      break label686;
      i = n;
      j = m;
      if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner == paramConstraintWidget) {
        break;
      }
    }
  }
  
  public void findVerticalWrapRecursive(ConstraintWidget paramConstraintWidget, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = false;
    if ((paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int i = paramConstraintWidget.getOptimizerWrapHeight();
    int k = i;
    int j = i;
    Object localObject1 = null;
    Object localObject2 = null;
    paramConstraintWidget.mVerticalWrapVisited = true;
    if ((paramConstraintWidget instanceof Guideline))
    {
      paramArrayOfBoolean = (Guideline)paramConstraintWidget;
      i = j;
      j = k;
      if (paramArrayOfBoolean.getOrientation() == 0)
      {
        k = 0;
        i = 0;
        if (paramArrayOfBoolean.getRelativeBegin() == -1) {
          break label150;
        }
        j = paramArrayOfBoolean.getRelativeBegin();
      }
    }
    int m;
    label150:
    label646:
    boolean bool1;
    label720:
    label748:
    label761:
    int n;
    label825:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            m = i;
            k = j;
            if (paramConstraintWidget.getVisibility() == 8)
            {
              k = j - paramConstraintWidget.mHeight;
              m = i - paramConstraintWidget.mHeight;
            }
            paramConstraintWidget.mDistToTop = k;
            paramConstraintWidget.mDistToBottom = m;
            return;
            j = k;
            if (paramArrayOfBoolean.getRelativeEnd() != -1)
            {
              i = paramArrayOfBoolean.getRelativeEnd();
              j = k;
              continue;
              if ((paramConstraintWidget.mBaseline.mTarget != null) || (paramConstraintWidget.mTop.mTarget != null) || (paramConstraintWidget.mBottom.mTarget != null)) {
                break;
              }
              k += paramConstraintWidget.getY();
              i = j;
              j = k;
            }
          }
          if ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mTop.mTarget != null) && ((paramConstraintWidget.mBottom.mTarget == paramConstraintWidget.mTop.mTarget) || ((paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidget.mTop.mTarget.mOwner) && (paramConstraintWidget.mBottom.mTarget.mOwner != paramConstraintWidget.mParent))))
          {
            paramArrayOfBoolean[0] = false;
            return;
          }
          if (paramConstraintWidget.mBaseline.isConnected())
          {
            localObject1 = paramConstraintWidget.mBaseline.mTarget.getOwner();
            if (!((ConstraintWidget)localObject1).mVerticalWrapVisited) {
              findVerticalWrapRecursive((ConstraintWidget)localObject1, paramArrayOfBoolean);
            }
            k = Math.max(((ConstraintWidget)localObject1).mDistToTop - ((ConstraintWidget)localObject1).mHeight + i, i);
            m = Math.max(((ConstraintWidget)localObject1).mDistToBottom - ((ConstraintWidget)localObject1).mHeight + i, i);
            j = m;
            i = k;
            if (paramConstraintWidget.getVisibility() == 8)
            {
              i = k - paramConstraintWidget.mHeight;
              j = m - paramConstraintWidget.mHeight;
            }
            paramConstraintWidget.mDistToTop = i;
            paramConstraintWidget.mDistToBottom = j;
            return;
          }
          i = k;
          ConstraintWidget localConstraintWidget;
          if (paramConstraintWidget.mTop.isConnected())
          {
            localConstraintWidget = paramConstraintWidget.mTop.mTarget.getOwner();
            k += paramConstraintWidget.mTop.getMargin();
            i = k;
            localObject1 = localConstraintWidget;
            if (!localConstraintWidget.isRoot())
            {
              i = k;
              localObject1 = localConstraintWidget;
              if (!localConstraintWidget.mVerticalWrapVisited)
              {
                findVerticalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
                localObject1 = localConstraintWidget;
                i = k;
              }
            }
          }
          k = j;
          if (paramConstraintWidget.mBottom.isConnected())
          {
            localConstraintWidget = paramConstraintWidget.mBottom.mTarget.getOwner();
            j += paramConstraintWidget.mBottom.getMargin();
            localObject2 = localConstraintWidget;
            k = j;
            if (!localConstraintWidget.isRoot())
            {
              localObject2 = localConstraintWidget;
              k = j;
              if (!localConstraintWidget.mVerticalWrapVisited)
              {
                findVerticalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
                k = j;
                localObject2 = localConstraintWidget;
              }
            }
          }
          m = i;
          if (paramConstraintWidget.mTop.mTarget != null)
          {
            m = i;
            if (!((ConstraintWidget)localObject1).isRoot())
            {
              if (paramConstraintWidget.mTop.mTarget.getType() != ConstraintAnchor.Type.TOP) {
                break;
              }
              j = i + (((ConstraintWidget)localObject1).mDistToTop - ((ConstraintWidget)localObject1).getOptimizerWrapHeight());
              if ((!((ConstraintWidget)localObject1).mTopHasCentered) && ((((ConstraintWidget)localObject1).mTop.mTarget == null) || (((ConstraintWidget)localObject1).mTop.mTarget.mOwner == paramConstraintWidget) || (((ConstraintWidget)localObject1).mBottom.mTarget == null) || (((ConstraintWidget)localObject1).mBottom.mTarget.mOwner == paramConstraintWidget) || (((ConstraintWidget)localObject1).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                break label1000;
              }
              bool1 = true;
              paramConstraintWidget.mTopHasCentered = bool1;
              m = j;
              if (paramConstraintWidget.mTopHasCentered)
              {
                if (((ConstraintWidget)localObject1).mBottom.mTarget != null) {
                  break label1006;
                }
                m = j + (j - ((ConstraintWidget)localObject1).mDistToTop);
              }
            }
          }
          i = k;
          j = m;
        } while (paramConstraintWidget.mBottom.mTarget == null);
        i = k;
        j = m;
      } while (((ConstraintWidget)localObject2).isRoot());
      if (paramConstraintWidget.mBottom.mTarget.getType() != ConstraintAnchor.Type.BOTTOM) {
        break label1028;
      }
      n = k + (((ConstraintWidget)localObject2).mDistToBottom - ((ConstraintWidget)localObject2).getOptimizerWrapHeight());
      if (!((ConstraintWidget)localObject2).mBottomHasCentered)
      {
        bool1 = bool2;
        if (((ConstraintWidget)localObject2).mTop.mTarget != null)
        {
          bool1 = bool2;
          if (((ConstraintWidget)localObject2).mTop.mTarget.mOwner != paramConstraintWidget)
          {
            bool1 = bool2;
            if (((ConstraintWidget)localObject2).mBottom.mTarget != null)
            {
              bool1 = bool2;
              if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner != paramConstraintWidget)
              {
                bool1 = bool2;
                if (((ConstraintWidget)localObject2).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {}
              }
            }
          }
        }
      }
      else
      {
        bool1 = true;
      }
      paramConstraintWidget.mBottomHasCentered = bool1;
      i = n;
      j = m;
    } while (!paramConstraintWidget.mBottomHasCentered);
    if (((ConstraintWidget)localObject2).mTop.mTarget == null) {}
    for (;;)
    {
      i = n + (n - ((ConstraintWidget)localObject2).mDistToBottom);
      j = m;
      break;
      j = i;
      if (paramConstraintWidget.mTop.mTarget.getType() != ConstraintAnchor.Type.BOTTOM) {
        break label646;
      }
      j = i + ((ConstraintWidget)localObject1).mDistToTop;
      break label646;
      label1000:
      bool1 = false;
      break label720;
      label1006:
      m = j;
      if (((ConstraintWidget)localObject1).mBottom.mTarget.mOwner == paramConstraintWidget) {
        break label761;
      }
      break label748;
      label1028:
      n = k;
      if (paramConstraintWidget.mBottom.mTarget.getType() != ConstraintAnchor.Type.TOP) {
        break label825;
      }
      n = k + ((ConstraintWidget)localObject2).mDistToBottom;
      break label825;
      i = n;
      j = m;
      if (((ConstraintWidget)localObject2).mTop.mTarget.mOwner == paramConstraintWidget) {
        break;
      }
    }
  }
  
  public void findWrapSize(ArrayList<ConstraintWidget> paramArrayList, boolean[] paramArrayOfBoolean)
  {
    int i1 = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int n = 0;
    int k = 0;
    int i5 = paramArrayList.size();
    paramArrayOfBoolean[0] = true;
    int m = 0;
    ConstraintWidget localConstraintWidget;
    for (;;)
    {
      if (m < i5)
      {
        localConstraintWidget = (ConstraintWidget)paramArrayList.get(m);
        if (localConstraintWidget.isRoot())
        {
          m += 1;
        }
        else
        {
          if (!localConstraintWidget.mHorizontalWrapVisited) {
            findHorizontalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
          }
          if (!localConstraintWidget.mVerticalWrapVisited) {
            findVerticalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
          }
          if (paramArrayOfBoolean[0] != 0) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      return;
      int i = localConstraintWidget.mDistToLeft + localConstraintWidget.mDistToRight - localConstraintWidget.getWidth();
      int j = localConstraintWidget.mDistToTop + localConstraintWidget.mDistToBottom - localConstraintWidget.getHeight();
      if (localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
        i = localConstraintWidget.getWidth() + localConstraintWidget.mLeft.mMargin + localConstraintWidget.mRight.mMargin;
      }
      if (localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
        j = localConstraintWidget.getHeight() + localConstraintWidget.mTop.mMargin + localConstraintWidget.mBottom.mMargin;
      }
      if (localConstraintWidget.getVisibility() == 8)
      {
        i = 0;
        j = 0;
      }
      i4 = Math.max(i4, localConstraintWidget.mDistToLeft);
      i3 = Math.max(i3, localConstraintWidget.mDistToRight);
      i2 = Math.max(i2, localConstraintWidget.mDistToBottom);
      i1 = Math.max(i1, localConstraintWidget.mDistToTop);
      n = Math.max(n, i);
      k = Math.max(k, j);
      break;
      i = Math.max(i4, i3);
      this.mWrapWidth = Math.max(this.mMinWidth, Math.max(i, n));
      i = Math.max(i1, i2);
      this.mWrapHeight = Math.max(this.mMinHeight, Math.max(i, k));
      i = 0;
      while (i < i5)
      {
        paramArrayOfBoolean = (ConstraintWidget)paramArrayList.get(i);
        paramArrayOfBoolean.mHorizontalWrapVisited = false;
        paramArrayOfBoolean.mVerticalWrapVisited = false;
        paramArrayOfBoolean.mLeftHasCentered = false;
        paramArrayOfBoolean.mRightHasCentered = false;
        paramArrayOfBoolean.mTopHasCentered = false;
        paramArrayOfBoolean.mBottomHasCentered = false;
        i += 1;
      }
    }
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = this.mChildren.size();
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public LinearSystem getSystem()
  {
    return this.mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = this.mChildren.size();
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout()
  {
    int n = this.mX;
    int i1 = this.mY;
    int i2 = Math.max(0, getWidth());
    int i3 = Math.max(0, getHeight());
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2;
    if (this.mParent != null)
    {
      if (this.mSnapshot == null) {
        this.mSnapshot = new Snapshot(this);
      }
      this.mSnapshot.updateFrom(this);
      setX(this.mPaddingLeft);
      setY(this.mPaddingTop);
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
      i6 = 0;
      localDimensionBehaviour1 = this.mVerticalDimensionBehaviour;
      localDimensionBehaviour2 = this.mHorizontalDimensionBehaviour;
      boolean bool = i6;
      if (this.mOptimizationLevel == 2) {
        if (this.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          bool = i6;
          if (this.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {}
        }
        else
        {
          findWrapSize(this.mChildren, this.flags);
          i5 = this.flags[0];
          i6 = i5;
          if (i2 > 0)
          {
            i6 = i5;
            if (i3 > 0) {
              if (this.mWrapWidth <= i2)
              {
                i6 = i5;
                if (this.mWrapHeight <= i3) {}
              }
              else
              {
                i6 = 0;
              }
            }
          }
          i5 = i6;
          if (i6 != 0)
          {
            if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
            {
              this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
              if ((i2 <= 0) || (i2 >= this.mWrapWidth)) {
                break label392;
              }
              this.mWidthMeasuredTooSmall = true;
              setWidth(i2);
            }
            label272:
            i5 = i6;
            if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
            {
              this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
              if ((i3 <= 0) || (i3 >= this.mWrapHeight)) {
                break label410;
              }
              this.mHeightMeasuredTooSmall = true;
              setHeight(i3);
            }
          }
        }
      }
    }
    int i4;
    ConstraintWidget localConstraintWidget1;
    for (int i5 = i6;; i5 = i6)
    {
      resetChains();
      i4 = this.mChildren.size();
      i = 0;
      while (i < i4)
      {
        localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(i);
        if ((localConstraintWidget1 instanceof WidgetContainer)) {
          ((WidgetContainer)localConstraintWidget1).layout();
        }
        i += 1;
      }
      this.mX = 0;
      this.mY = 0;
      break;
      label392:
      setWidth(Math.max(this.mMinWidth, this.mWrapWidth));
      break label272;
      label410:
      setHeight(Math.max(this.mMinHeight, this.mWrapHeight));
    }
    int i6 = 1;
    int i = 0;
    int j;
    while (i6 != 0)
    {
      int m = i + 1;
      int i7 = i6;
      int i8;
      int i10;
      try
      {
        this.mSystem.reset();
        i7 = i6;
        i6 = addChildrenToSolver(this.mSystem, Integer.MAX_VALUE);
        i7 = i6;
        if (i6 != 0)
        {
          i7 = i6;
          this.mSystem.minimize();
          i7 = i6;
        }
      }
      catch (Exception localException)
      {
        int k;
        for (;;)
        {
          localException.printStackTrace();
        }
        updateFromSolver(this.mSystem, Integer.MAX_VALUE);
        i = 0;
        while (i < i4)
        {
          ConstraintWidget localConstraintWidget2 = (ConstraintWidget)this.mChildren.get(i);
          if ((localConstraintWidget2.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget2.getWidth() < localConstraintWidget2.getWrapWidth()))
          {
            this.flags[2] = true;
            break;
          }
          if ((localConstraintWidget2.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget2.getHeight() < localConstraintWidget2.getWrapHeight()))
          {
            this.flags[2] = true;
            break;
          }
          i += 1;
        }
        j = Math.max(this.mMinWidth, k);
        i = Math.max(this.mMinHeight, i);
        i9 = i10;
        i8 = i5;
        if (localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          break label806;
        }
        i9 = i10;
        i8 = i5;
        if (getWidth() >= j) {
          break label806;
        }
        setWidth(j);
        this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        i8 = 1;
        i9 = 1;
        i7 = i9;
        i6 = i8;
        if (localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          break label856;
        }
        i7 = i9;
        i6 = i8;
        if (getHeight() >= i) {
          break label856;
        }
        setHeight(i);
        this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        i6 = 1;
        i7 = 1;
        i = Math.max(this.mMinWidth, getWidth());
        if (i <= getWidth()) {
          break label894;
        }
        setWidth(i);
        this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        i6 = 1;
        i7 = 1;
        i = Math.max(this.mMinHeight, getHeight());
        i8 = i6;
        if (i <= getHeight()) {
          break label936;
        }
        setHeight(i);
        this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        i8 = 1;
        i7 = 1;
        i = m;
        i6 = i7;
        i5 = i8;
      }
      if (i7 != 0)
      {
        updateChildrenFromSolver(this.mSystem, Integer.MAX_VALUE, this.flags);
        i8 = 0;
        i10 = 0;
        i7 = i8;
        i6 = i5;
        if (m >= 8) {
          break label856;
        }
        i7 = i8;
        i6 = i5;
        if (this.flags[2] == 0) {
          break label856;
        }
        k = 0;
        i = 0;
        j = 0;
        while (j < i4)
        {
          localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(j);
          k = Math.max(k, localConstraintWidget1.mX + localConstraintWidget1.getWidth());
          i = Math.max(i, localConstraintWidget1.mY + localConstraintWidget1.getHeight());
          j += 1;
        }
      }
      int i9;
      label806:
      label856:
      label894:
      label936:
      if (i8 == 0)
      {
        i10 = i7;
        i9 = i8;
        if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          i10 = i7;
          i9 = i8;
          if (i2 > 0)
          {
            i10 = i7;
            i9 = i8;
            if (getWidth() > i2)
            {
              this.mWidthMeasuredTooSmall = true;
              i9 = 1;
              this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
              setWidth(i2);
              i10 = 1;
            }
          }
        }
        i = m;
        i6 = i10;
        i5 = i9;
        if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          i = m;
          i6 = i10;
          i5 = i9;
          if (i3 > 0)
          {
            i = m;
            i6 = i10;
            i5 = i9;
            if (getHeight() > i3)
            {
              this.mHeightMeasuredTooSmall = true;
              i5 = 1;
              this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
              setHeight(i3);
              i6 = 1;
              i = m;
            }
          }
        }
      }
    }
    if (this.mParent != null)
    {
      i = Math.max(this.mMinWidth, getWidth());
      j = Math.max(this.mMinHeight, getHeight());
      this.mSnapshot.applyTo(this);
      setWidth(this.mPaddingLeft + i + this.mPaddingRight);
      setHeight(this.mPaddingTop + j + this.mPaddingBottom);
    }
    for (;;)
    {
      if (i5 != 0)
      {
        this.mHorizontalDimensionBehaviour = localDimensionBehaviour2;
        this.mVerticalDimensionBehaviour = localDimensionBehaviour1;
      }
      resetSolverVariables(this.mSystem.getCache());
      if (this == getRootConstraintContainer()) {
        updateDrawPosition();
      }
      return;
      this.mX = n;
      this.mY = i1;
    }
  }
  
  public int layoutFindGroups()
  {
    Object localObject2 = new ConstraintAnchor.Type[5];
    localObject2[0] = ConstraintAnchor.Type.LEFT;
    localObject2[1] = ConstraintAnchor.Type.RIGHT;
    localObject2[2] = ConstraintAnchor.Type.TOP;
    localObject2[3] = ConstraintAnchor.Type.BASELINE;
    localObject2[4] = ConstraintAnchor.Type.BOTTOM;
    int i = 1;
    int i3 = this.mChildren.size();
    int k = 0;
    Object localObject3;
    if (k < i3)
    {
      localObject1 = (ConstraintWidget)this.mChildren.get(k);
      localObject3 = ((ConstraintWidget)localObject1).mLeft;
      if (((ConstraintAnchor)localObject3).mTarget != null)
      {
        j = i;
        if (setGroup((ConstraintAnchor)localObject3, i) == i) {
          j = i + 1;
        }
        label104:
        localObject3 = ((ConstraintWidget)localObject1).mTop;
        if (((ConstraintAnchor)localObject3).mTarget == null) {
          break label250;
        }
        i = j;
        if (setGroup((ConstraintAnchor)localObject3, j) == j) {
          i = j + 1;
        }
        label135:
        localObject3 = ((ConstraintWidget)localObject1).mRight;
        if (((ConstraintAnchor)localObject3).mTarget == null) {
          break label263;
        }
        j = i;
        if (setGroup((ConstraintAnchor)localObject3, i) == i) {
          j = i + 1;
        }
        label166:
        localObject3 = ((ConstraintWidget)localObject1).mBottom;
        if (((ConstraintAnchor)localObject3).mTarget == null) {
          break label276;
        }
        i = j;
        if (setGroup((ConstraintAnchor)localObject3, j) == j) {
          i = j + 1;
        }
        label197:
        localObject1 = ((ConstraintWidget)localObject1).mBaseline;
        if (((ConstraintAnchor)localObject1).mTarget == null) {
          break label289;
        }
        j = i;
        if (setGroup((ConstraintAnchor)localObject1, i) != i) {}
      }
      for (j = i + 1;; j = i)
      {
        k += 1;
        i = j;
        break;
        ((ConstraintAnchor)localObject3).mGroup = Integer.MAX_VALUE;
        j = i;
        break label104;
        label250:
        ((ConstraintAnchor)localObject3).mGroup = Integer.MAX_VALUE;
        i = j;
        break label135;
        label263:
        ((ConstraintAnchor)localObject3).mGroup = Integer.MAX_VALUE;
        j = i;
        break label166;
        label276:
        ((ConstraintAnchor)localObject3).mGroup = Integer.MAX_VALUE;
        i = j;
        break label197;
        label289:
        ((ConstraintAnchor)localObject1).mGroup = Integer.MAX_VALUE;
      }
    }
    int m = 1;
    int i1 = 0;
    int j = 0;
    if (m != 0)
    {
      k = 0;
      int i2 = i1 + 1;
      int n = 0;
      i = j;
      for (;;)
      {
        i1 = i2;
        j = i;
        m = k;
        if (n >= i3) {
          break;
        }
        localObject3 = (ConstraintWidget)this.mChildren.get(n);
        i1 = 0;
        if (i1 < localObject2.length)
        {
          ConstraintAnchor localConstraintAnchor = localObject2[i1];
          localObject1 = null;
          switch (localConstraintAnchor)
          {
          default: 
            label424:
            localConstraintAnchor = ((ConstraintAnchor)localObject1).mTarget;
            if (localConstraintAnchor != null) {
              break;
            }
          }
          label548:
          do
          {
            do
            {
              i1 += 1;
              break;
              localObject1 = ((ConstraintWidget)localObject3).mLeft;
              break label424;
              localObject1 = ((ConstraintWidget)localObject3).mTop;
              break label424;
              localObject1 = ((ConstraintWidget)localObject3).mRight;
              break label424;
              localObject1 = ((ConstraintWidget)localObject3).mBottom;
              break label424;
              localObject1 = ((ConstraintWidget)localObject3).mBaseline;
              break label424;
              j = i;
              m = k;
              if (localConstraintAnchor.mOwner.getParent() != null)
              {
                j = i;
                m = k;
                if (localConstraintAnchor.mGroup != ((ConstraintAnchor)localObject1).mGroup)
                {
                  if (((ConstraintAnchor)localObject1).mGroup <= localConstraintAnchor.mGroup) {
                    break label642;
                  }
                  j = localConstraintAnchor.mGroup;
                  ((ConstraintAnchor)localObject1).mGroup = j;
                  localConstraintAnchor.mGroup = j;
                  j = i + 1;
                  m = 1;
                }
              }
              localConstraintAnchor = localConstraintAnchor.getOpposite();
              i = j;
              k = m;
            } while (localConstraintAnchor == null);
            i = j;
            k = m;
          } while (localConstraintAnchor.mGroup == ((ConstraintAnchor)localObject1).mGroup);
          if (((ConstraintAnchor)localObject1).mGroup > localConstraintAnchor.mGroup) {}
          for (i = localConstraintAnchor.mGroup;; i = ((ConstraintAnchor)localObject1).mGroup)
          {
            ((ConstraintAnchor)localObject1).mGroup = i;
            localConstraintAnchor.mGroup = i;
            i = j + 1;
            k = 1;
            break;
            label642:
            j = ((ConstraintAnchor)localObject1).mGroup;
            break label548;
          }
        }
        n += 1;
      }
    }
    Object localObject1 = new int[this.mChildren.size() * localObject2.length + 1];
    Arrays.fill((int[])localObject1, -1);
    k = 0;
    i = 0;
    if (k < i3)
    {
      localObject2 = (ConstraintWidget)this.mChildren.get(k);
      localObject3 = ((ConstraintWidget)localObject2).mLeft;
      if (((ConstraintAnchor)localObject3).mGroup == Integer.MAX_VALUE) {
        break label1017;
      }
      m = ((ConstraintAnchor)localObject3).mGroup;
      if (localObject1[m] != -1) {
        break label1012;
      }
      j = i + 1;
      localObject1[m] = i;
      label759:
      ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
    }
    for (;;)
    {
      localObject3 = ((ConstraintWidget)localObject2).mTop;
      i = j;
      if (((ConstraintAnchor)localObject3).mGroup != Integer.MAX_VALUE)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        i = j;
        if (localObject1[m] == -1)
        {
          localObject1[m] = j;
          i = j + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject3 = ((ConstraintWidget)localObject2).mRight;
      j = i;
      if (((ConstraintAnchor)localObject3).mGroup != Integer.MAX_VALUE)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject3 = ((ConstraintWidget)localObject2).mBottom;
      i = j;
      if (((ConstraintAnchor)localObject3).mGroup != Integer.MAX_VALUE)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        i = j;
        if (localObject1[m] == -1)
        {
          localObject1[m] = j;
          i = j + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject2 = ((ConstraintWidget)localObject2).mBaseline;
      j = i;
      if (((ConstraintAnchor)localObject2).mGroup != Integer.MAX_VALUE)
      {
        m = ((ConstraintAnchor)localObject2).mGroup;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((ConstraintAnchor)localObject2).mGroup = localObject1[m];
      }
      k += 1;
      i = j;
      break;
      return i;
      label1012:
      j = i;
      break label759;
      label1017:
      j = i;
    }
  }
  
  public int layoutFindGroupsSimple()
  {
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.mLeft.mGroup = 0;
      localConstraintWidget.mRight.mGroup = 0;
      localConstraintWidget.mTop.mGroup = 1;
      localConstraintWidget.mBottom.mGroup = 1;
      localConstraintWidget.mBaseline.mGroup = 1;
      i += 1;
    }
    return 2;
  }
  
  public void layoutWithGroup(int paramInt)
  {
    int j = this.mX;
    int k = this.mY;
    if (this.mParent != null)
    {
      if (this.mSnapshot == null) {
        this.mSnapshot = new Snapshot(this);
      }
      this.mSnapshot.updateFrom(this);
      this.mX = 0;
      this.mY = 0;
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    }
    for (;;)
    {
      int m = this.mChildren.size();
      i = 0;
      while (i < m)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        if ((localConstraintWidget instanceof WidgetContainer)) {
          ((WidgetContainer)localConstraintWidget).layout();
        }
        i += 1;
      }
      this.mX = 0;
      this.mY = 0;
    }
    this.mLeft.mGroup = 0;
    this.mRight.mGroup = 0;
    this.mTop.mGroup = 1;
    this.mBottom.mGroup = 1;
    this.mSystem.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramInt) {
        try
        {
          addToSolver(this.mSystem, i);
          this.mSystem.minimize();
          updateFromSolver(this.mSystem, i);
          updateFromSolver(this.mSystem, -2);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (this.mParent != null)
    {
      paramInt = getWidth();
      i = getHeight();
      this.mSnapshot.applyTo(this);
      setWidth(paramInt);
      setHeight(i);
    }
    for (;;)
    {
      if (this == getRootConstraintContainer()) {
        updateDrawPosition();
      }
      return;
      this.mX = j;
      this.mY = k;
    }
  }
  
  public void reset()
  {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    super.reset();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[2] = false;
    updateFromSolver(paramLinearSystem, paramInt);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.updateFromSolver(paramLinearSystem, paramInt);
      if ((localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getWidth() < localConstraintWidget.getWrapWidth())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getHeight() < localConstraintWidget.getWrapHeight())) {
        paramArrayOfBoolean[2] = true;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/widgets/ConstraintWidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */