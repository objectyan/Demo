package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;

public class Optimizer
{
  static void applyDirectResolutionHorizontalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget)
  {
    int k = 0;
    Object localObject4 = null;
    int m = 0;
    float f2 = 0.0F;
    Object localObject1 = paramConstraintWidget;
    label33:
    int i;
    label95:
    label116:
    label133:
    Object localObject2;
    if (localObject1 != null)
    {
      int n;
      Object localObject3;
      if (((ConstraintWidget)localObject1).getVisibility() == 8)
      {
        j = 1;
        n = m;
        f1 = f2;
        i = k;
        if (j == 0)
        {
          n = m + 1;
          if (((ConstraintWidget)localObject1).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            break label304;
          }
          m = ((ConstraintWidget)localObject1).getWidth();
          if (((ConstraintWidget)localObject1).mLeft.mTarget == null) {
            break label292;
          }
          i = ((ConstraintWidget)localObject1).mLeft.getMargin();
          if (((ConstraintWidget)localObject1).mRight.mTarget == null) {
            break label298;
          }
          j = ((ConstraintWidget)localObject1).mRight.getMargin();
          i = k + m + i + j;
          f1 = f2;
        }
        localObject3 = localObject1;
        if (((ConstraintWidget)localObject1).mRight.mTarget == null) {
          break label321;
        }
      }
      label292:
      label298:
      label304:
      label321:
      for (localObject2 = ((ConstraintWidget)localObject1).mRight.mTarget.mOwner;; localObject2 = null)
      {
        m = n;
        localObject4 = localObject3;
        f2 = f1;
        k = i;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break;
        }
        if (((ConstraintWidget)localObject2).mLeft.mTarget != null)
        {
          m = n;
          localObject4 = localObject3;
          f2 = f1;
          k = i;
          localObject1 = localObject2;
          if (((ConstraintWidget)localObject2).mLeft.mTarget == null) {
            break;
          }
          m = n;
          localObject4 = localObject3;
          f2 = f1;
          k = i;
          localObject1 = localObject2;
          if (((ConstraintWidget)localObject2).mLeft.mTarget.mOwner == localObject3) {
            break;
          }
        }
        localObject1 = null;
        m = n;
        localObject4 = localObject3;
        f2 = f1;
        k = i;
        break;
        j = 0;
        break label33;
        i = 0;
        break label95;
        j = 0;
        break label116;
        f1 = f2 + ((ConstraintWidget)localObject1).mHorizontalWeight;
        i = k;
        break label133;
      }
    }
    int j = 0;
    if (localObject4 != null)
    {
      if (((ConstraintWidget)localObject4).mRight.mTarget == null) {
        break label672;
      }
      i = ((ConstraintWidget)localObject4).mRight.mTarget.mOwner.getX();
      j = i;
      if (((ConstraintWidget)localObject4).mRight.mTarget != null)
      {
        j = i;
        if (((ConstraintWidget)localObject4).mRight.mTarget.mOwner == paramConstraintWidgetContainer) {
          j = paramConstraintWidgetContainer.getRight();
        }
      }
    }
    float f5 = j - 0 - k;
    float f3 = f5 / (m + 1);
    float f1 = 0.0F;
    label434:
    label457:
    label476:
    label542:
    float f4;
    if (paramInt == 0)
    {
      f1 = f3;
      if (paramConstraintWidget == null) {
        return;
      }
      if (paramConstraintWidget.mLeft.mTarget == null) {
        break label688;
      }
      i = paramConstraintWidget.mLeft.getMargin();
      if (paramConstraintWidget.mRight.mTarget == null) {
        break label694;
      }
      j = paramConstraintWidget.mRight.getMargin();
      if (paramConstraintWidget.getVisibility() == 8) {
        break label739;
      }
      f1 += i;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, (int)(0.5F + f1));
      if (paramConstraintWidget.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        break label726;
      }
      if (f2 != 0.0F) {
        break label700;
      }
      f1 += f3 - i - j;
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, (int)(0.5F + f1));
      f4 = f1;
      if (paramInt == 0) {
        f4 = f1 + f3;
      }
      f4 += j;
      label582:
      if (paramConstraintWidget.mRight.mTarget == null) {
        break label789;
      }
    }
    label672:
    label688:
    label694:
    label700:
    label726:
    label739:
    label789:
    for (localObject1 = paramConstraintWidget.mRight.mTarget.mOwner;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((ConstraintWidget)localObject1).mLeft.mTarget != null)
        {
          localObject2 = localObject1;
          if (((ConstraintWidget)localObject1).mLeft.mTarget.mOwner != paramConstraintWidget) {
            localObject2 = null;
          }
        }
      }
      f1 = f4;
      paramConstraintWidget = (ConstraintWidget)localObject2;
      if (localObject2 != paramConstraintWidgetContainer) {
        break label434;
      }
      paramConstraintWidget = null;
      f1 = f4;
      break label434;
      i = 0;
      break;
      f3 = f5 / paramInt;
      break label434;
      i = 0;
      break label457;
      j = 0;
      break label476;
      f1 += paramConstraintWidget.mHorizontalWeight * f5 / f2 - i - j;
      break label542;
      f1 += paramConstraintWidget.getWidth();
      break label542;
      f4 = f1 - f3 / 2.0F;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, (int)(0.5F + f4));
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, (int)(0.5F + f4));
      f4 = f1;
      break label582;
    }
  }
  
  static void applyDirectResolutionVerticalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget)
  {
    int k = 0;
    Object localObject4 = null;
    int m = 0;
    float f2 = 0.0F;
    Object localObject1 = paramConstraintWidget;
    label33:
    int i;
    label95:
    label116:
    label133:
    Object localObject2;
    if (localObject1 != null)
    {
      int n;
      Object localObject3;
      if (((ConstraintWidget)localObject1).getVisibility() == 8)
      {
        j = 1;
        n = m;
        f1 = f2;
        i = k;
        if (j == 0)
        {
          n = m + 1;
          if (((ConstraintWidget)localObject1).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            break label304;
          }
          m = ((ConstraintWidget)localObject1).getHeight();
          if (((ConstraintWidget)localObject1).mTop.mTarget == null) {
            break label292;
          }
          i = ((ConstraintWidget)localObject1).mTop.getMargin();
          if (((ConstraintWidget)localObject1).mBottom.mTarget == null) {
            break label298;
          }
          j = ((ConstraintWidget)localObject1).mBottom.getMargin();
          i = k + m + i + j;
          f1 = f2;
        }
        localObject3 = localObject1;
        if (((ConstraintWidget)localObject1).mBottom.mTarget == null) {
          break label321;
        }
      }
      label292:
      label298:
      label304:
      label321:
      for (localObject2 = ((ConstraintWidget)localObject1).mBottom.mTarget.mOwner;; localObject2 = null)
      {
        m = n;
        localObject4 = localObject3;
        f2 = f1;
        k = i;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break;
        }
        if (((ConstraintWidget)localObject2).mTop.mTarget != null)
        {
          m = n;
          localObject4 = localObject3;
          f2 = f1;
          k = i;
          localObject1 = localObject2;
          if (((ConstraintWidget)localObject2).mTop.mTarget == null) {
            break;
          }
          m = n;
          localObject4 = localObject3;
          f2 = f1;
          k = i;
          localObject1 = localObject2;
          if (((ConstraintWidget)localObject2).mTop.mTarget.mOwner == localObject3) {
            break;
          }
        }
        localObject1 = null;
        m = n;
        localObject4 = localObject3;
        f2 = f1;
        k = i;
        break;
        j = 0;
        break label33;
        i = 0;
        break label95;
        j = 0;
        break label116;
        f1 = f2 + ((ConstraintWidget)localObject1).mVerticalWeight;
        i = k;
        break label133;
      }
    }
    int j = 0;
    if (localObject4 != null)
    {
      if (((ConstraintWidget)localObject4).mBottom.mTarget == null) {
        break label672;
      }
      i = ((ConstraintWidget)localObject4).mBottom.mTarget.mOwner.getX();
      j = i;
      if (((ConstraintWidget)localObject4).mBottom.mTarget != null)
      {
        j = i;
        if (((ConstraintWidget)localObject4).mBottom.mTarget.mOwner == paramConstraintWidgetContainer) {
          j = paramConstraintWidgetContainer.getBottom();
        }
      }
    }
    float f5 = j - 0 - k;
    float f3 = f5 / (m + 1);
    float f1 = 0.0F;
    label434:
    label457:
    label476:
    label542:
    float f4;
    if (paramInt == 0)
    {
      f1 = f3;
      if (paramConstraintWidget == null) {
        return;
      }
      if (paramConstraintWidget.mTop.mTarget == null) {
        break label688;
      }
      i = paramConstraintWidget.mTop.getMargin();
      if (paramConstraintWidget.mBottom.mTarget == null) {
        break label694;
      }
      j = paramConstraintWidget.mBottom.getMargin();
      if (paramConstraintWidget.getVisibility() == 8) {
        break label739;
      }
      f1 += i;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, (int)(0.5F + f1));
      if (paramConstraintWidget.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        break label726;
      }
      if (f2 != 0.0F) {
        break label700;
      }
      f1 += f3 - i - j;
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, (int)(0.5F + f1));
      f4 = f1;
      if (paramInt == 0) {
        f4 = f1 + f3;
      }
      f4 += j;
      label582:
      if (paramConstraintWidget.mBottom.mTarget == null) {
        break label789;
      }
    }
    label672:
    label688:
    label694:
    label700:
    label726:
    label739:
    label789:
    for (localObject1 = paramConstraintWidget.mBottom.mTarget.mOwner;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((ConstraintWidget)localObject1).mTop.mTarget != null)
        {
          localObject2 = localObject1;
          if (((ConstraintWidget)localObject1).mTop.mTarget.mOwner != paramConstraintWidget) {
            localObject2 = null;
          }
        }
      }
      f1 = f4;
      paramConstraintWidget = (ConstraintWidget)localObject2;
      if (localObject2 != paramConstraintWidgetContainer) {
        break label434;
      }
      paramConstraintWidget = null;
      f1 = f4;
      break label434;
      i = 0;
      break;
      f3 = f5 / paramInt;
      break label434;
      i = 0;
      break label457;
      j = 0;
      break label476;
      f1 += paramConstraintWidget.mVerticalWeight * f5 / f2 - i - j;
      break label542;
      f1 += paramConstraintWidget.getHeight();
      break label542;
      f4 = f1 - f3 / 2.0F;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, (int)(0.5F + f4));
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, (int)(0.5F + f4));
      f4 = f1;
      break label582;
    }
  }
  
  static void checkHorizontalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramConstraintWidget.mHorizontalResolution = 1;
    }
    label850:
    label863:
    Guideline localGuideline;
    do
    {
      return;
      if ((paramConstraintWidgetContainer.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
      {
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        i = paramConstraintWidget.mLeft.mMargin;
        j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
        paramConstraintWidget.setHorizontalDimension(i, j);
        paramConstraintWidget.mHorizontalResolution = 2;
        return;
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
      {
        if ((paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidgetContainer) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidgetContainer))
        {
          i = paramConstraintWidget.mLeft.getMargin();
          j = paramConstraintWidget.mRight.getMargin();
          if (paramConstraintWidgetContainer.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {}
          for (j = paramConstraintWidgetContainer.getWidth() - j;; j = i + paramConstraintWidget.getWidth())
          {
            paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
            paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
            paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
            paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
            paramConstraintWidget.mHorizontalResolution = 2;
            paramConstraintWidget.setHorizontalDimension(i, j);
            return;
            int k = paramConstraintWidget.getWidth();
            i += (int)((paramConstraintWidgetContainer.getWidth() - i - j - k) * paramConstraintWidget.mHorizontalBiasPercent + 0.5F);
          }
        }
        paramConstraintWidget.mHorizontalResolution = 1;
        return;
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        i = paramConstraintWidget.mLeft.getMargin();
        j = i + paramConstraintWidget.getWidth();
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
        paramConstraintWidget.mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i, j);
        return;
      }
      if ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        i = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.getMargin();
        j = i - paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, j);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
        paramConstraintWidget.mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(j, i);
        return;
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner.mHorizontalResolution == 2))
      {
        paramConstraintWidgetContainer = paramConstraintWidget.mLeft.mTarget.mSolverVariable;
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        i = (int)(paramConstraintWidgetContainer.computedValue + paramConstraintWidget.mLeft.getMargin() + 0.5F);
        j = i + paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
        paramConstraintWidget.mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i, j);
        return;
      }
      if ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner.mHorizontalResolution == 2))
      {
        paramConstraintWidgetContainer = paramConstraintWidget.mRight.mTarget.mSolverVariable;
        paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
        paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
        i = (int)(paramConstraintWidgetContainer.computedValue - paramConstraintWidget.mRight.getMargin() + 0.5F);
        j = i - paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, j);
        paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
        paramConstraintWidget.mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(j, i);
        return;
      }
      if (paramConstraintWidget.mLeft.mTarget == null) {
        break;
      }
      i = 1;
      if (paramConstraintWidget.mRight.mTarget == null) {
        break label1008;
      }
      j = 1;
      if ((i != 0) || (j != 0)) {
        break label1012;
      }
      if (!(paramConstraintWidget instanceof Guideline)) {
        break label1053;
      }
      localGuideline = (Guideline)paramConstraintWidget;
    } while (localGuideline.getOrientation() != 1);
    paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
    paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
    float f;
    if (localGuideline.getRelativeBegin() != -1) {
      f = localGuideline.getRelativeBegin();
    }
    for (;;)
    {
      i = (int)(0.5F + f);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, i);
      paramConstraintWidget.setVerticalDimension(0, paramConstraintWidgetContainer.getHeight());
      return;
      i = 0;
      break label850;
      label1008:
      j = 0;
      break label863;
      label1012:
      break;
      if (localGuideline.getRelativeEnd() != -1) {
        f = paramConstraintWidgetContainer.getWidth() - localGuideline.getRelativeEnd();
      } else {
        f = paramConstraintWidgetContainer.getWidth() * localGuideline.getRelativePercent();
      }
    }
    label1053:
    paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
    paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
    int i = paramConstraintWidget.getX();
    int j = paramConstraintWidget.getWidth();
    paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
    paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, i + j);
    paramConstraintWidget.mHorizontalResolution = 2;
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.setHorizontalDimension(i, j);
      paramConstraintWidget.mHorizontalResolution = 2;
    }
    if ((paramConstraintWidgetContainer.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.setVerticalDimension(i, j);
      paramConstraintWidget.mVerticalResolution = 2;
    }
  }
  
  static void checkVerticalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramConstraintWidget.mVerticalResolution = 1;
    }
    int k;
    label1315:
    label1328:
    label1341:
    Guideline localGuideline;
    do
    {
      return;
      if ((paramConstraintWidgetContainer.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
      {
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        i = paramConstraintWidget.mTop.mMargin;
        j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
        }
        paramConstraintWidget.setVerticalDimension(i, j);
        paramConstraintWidget.mVerticalResolution = 2;
        return;
      }
      if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
      {
        if ((paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidgetContainer) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidgetContainer))
        {
          j = paramConstraintWidget.mTop.getMargin();
          i = paramConstraintWidget.mBottom.getMargin();
          if (paramConstraintWidgetContainer.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {}
          for (i = j + paramConstraintWidget.getHeight();; i = j + paramConstraintWidget.getHeight())
          {
            paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
            paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
            paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
            paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
            if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
            {
              paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
              paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
            }
            paramConstraintWidget.mVerticalResolution = 2;
            paramConstraintWidget.setVerticalDimension(j, i);
            return;
            k = paramConstraintWidget.getHeight();
            int m = paramConstraintWidgetContainer.getHeight();
            j = (int)(j + (m - j - i - k) * paramConstraintWidget.mVerticalBiasPercent + 0.5F);
          }
        }
        paramConstraintWidget.mVerticalResolution = 1;
        return;
      }
      if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        i = paramConstraintWidget.mTop.getMargin();
        j = i + paramConstraintWidget.getHeight();
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
        }
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i, j);
        return;
      }
      if ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        i = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.getMargin();
        j = i - paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
        }
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(j, i);
        return;
      }
      if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner.mVerticalResolution == 2))
      {
        paramConstraintWidgetContainer = paramConstraintWidget.mTop.mTarget.mSolverVariable;
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        i = (int)(paramConstraintWidgetContainer.computedValue + paramConstraintWidget.mTop.getMargin() + 0.5F);
        j = i + paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
        }
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i, j);
        return;
      }
      if ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner.mVerticalResolution == 2))
      {
        paramConstraintWidgetContainer = paramConstraintWidget.mBottom.mTarget.mSolverVariable;
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        i = (int)(paramConstraintWidgetContainer.computedValue - paramConstraintWidget.mBottom.getMargin() + 0.5F);
        j = i - paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
        if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
        {
          paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
          paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
        }
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(j, i);
        return;
      }
      if ((paramConstraintWidget.mBaseline.mTarget != null) && (paramConstraintWidget.mBaseline.mTarget.mOwner.mVerticalResolution == 2))
      {
        paramConstraintWidgetContainer = paramConstraintWidget.mBaseline.mTarget.mSolverVariable;
        paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
        paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
        i = (int)(paramConstraintWidgetContainer.computedValue - paramConstraintWidget.mBaselineDistance + 0.5F);
        j = i + paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
        paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
        paramConstraintWidget.mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i, j);
        return;
      }
      if (paramConstraintWidget.mBaseline.mTarget == null) {
        break;
      }
      i = 1;
      if (paramConstraintWidget.mTop.mTarget == null) {
        break label1490;
      }
      j = 1;
      if (paramConstraintWidget.mBottom.mTarget == null) {
        break label1496;
      }
      k = 1;
      if ((i != 0) || (j != 0) || (k != 0)) {
        break label1500;
      }
      if (!(paramConstraintWidget instanceof Guideline)) {
        break label1541;
      }
      localGuideline = (Guideline)paramConstraintWidget;
    } while (localGuideline.getOrientation() != 0);
    paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
    paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
    float f;
    if (localGuideline.getRelativeBegin() != -1) {
      f = localGuideline.getRelativeBegin();
    }
    for (;;)
    {
      i = (int)(0.5F + f);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, i);
      paramConstraintWidget.setHorizontalDimension(0, paramConstraintWidgetContainer.getWidth());
      return;
      i = 0;
      break label1315;
      label1490:
      j = 0;
      break label1328;
      label1496:
      k = 0;
      break label1341;
      label1500:
      break;
      if (localGuideline.getRelativeEnd() != -1) {
        f = paramConstraintWidgetContainer.getHeight() - localGuideline.getRelativeEnd();
      } else {
        f = paramConstraintWidgetContainer.getHeight() * localGuideline.getRelativePercent();
      }
    }
    label1541:
    paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
    paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
    int i = paramConstraintWidget.getY();
    int j = paramConstraintWidget.getHeight();
    paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
    paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i + j);
    if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
    {
      paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
      paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
    }
    paramConstraintWidget.mVerticalResolution = 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/widgets/Optimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */