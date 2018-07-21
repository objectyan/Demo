package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintTableLayout
  extends ConstraintWidgetContainer
{
  public static final int ALIGN_CENTER = 0;
  private static final int ALIGN_FULL = 3;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList();
  private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList();
  private int mNumCols = 0;
  private int mNumRows = 0;
  private int mPadding = 8;
  private boolean mVerticalGrowth = true;
  private ArrayList<Guideline> mVerticalGuidelines = new ArrayList();
  private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList();
  private LinearSystem system = null;
  
  public ConstraintTableLayout() {}
  
  public ConstraintTableLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintTableLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setChildrenConnections()
  {
    int k = this.mChildren.size();
    int j = 0;
    int i = 0;
    if (i < k)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(i);
      j += localConstraintWidget1.getContainerItemSkip();
      int m = this.mNumCols;
      int n = j / this.mNumCols;
      Object localObject = (HorizontalSlice)this.mHorizontalSlices.get(n);
      VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(j % m);
      ConstraintWidget localConstraintWidget2 = localVerticalSlice.left;
      ConstraintWidget localConstraintWidget3 = localVerticalSlice.right;
      ConstraintWidget localConstraintWidget4 = ((HorizontalSlice)localObject).top;
      localObject = ((HorizontalSlice)localObject).bottom;
      localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).connect(localConstraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
      if ((localConstraintWidget3 instanceof Guideline))
      {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
        label166:
        switch (localVerticalSlice.alignment)
        {
        default: 
          label196:
          localConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP).connect(localConstraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
          if ((localObject instanceof Guideline)) {
            localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
          }
          break;
        }
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mPadding);
        break label166;
        localConstraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        break label196;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
        break label196;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
        break label196;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM), this.mPadding);
      }
    }
  }
  
  private void setHorizontalSlices()
  {
    this.mHorizontalSlices.clear();
    float f2 = 100.0F / this.mNumRows;
    float f1 = f2;
    Object localObject = this;
    int i = 0;
    if (i < this.mNumRows)
    {
      HorizontalSlice localHorizontalSlice = new HorizontalSlice();
      localHorizontalSlice.top = ((ConstraintWidget)localObject);
      if (i < this.mNumRows - 1)
      {
        localObject = new Guideline();
        ((Guideline)localObject).setOrientation(0);
        ((Guideline)localObject).setParent(this);
        ((Guideline)localObject).setGuidePercent((int)f1);
        f1 += f2;
        localHorizontalSlice.bottom = ((ConstraintWidget)localObject);
        this.mHorizontalGuidelines.add(localObject);
      }
      for (;;)
      {
        localObject = localHorizontalSlice.bottom;
        this.mHorizontalSlices.add(localHorizontalSlice);
        i += 1;
        break;
        localHorizontalSlice.bottom = this;
      }
    }
    updateDebugSolverNames();
  }
  
  private void setVerticalSlices()
  {
    this.mVerticalSlices.clear();
    Object localObject = this;
    float f2 = 100.0F / this.mNumCols;
    float f1 = f2;
    int i = 0;
    if (i < this.mNumCols)
    {
      VerticalSlice localVerticalSlice = new VerticalSlice();
      localVerticalSlice.left = ((ConstraintWidget)localObject);
      if (i < this.mNumCols - 1)
      {
        localObject = new Guideline();
        ((Guideline)localObject).setOrientation(1);
        ((Guideline)localObject).setParent(this);
        ((Guideline)localObject).setGuidePercent((int)f1);
        f1 += f2;
        localVerticalSlice.right = ((ConstraintWidget)localObject);
        this.mVerticalGuidelines.add(localObject);
      }
      for (;;)
      {
        localObject = localVerticalSlice.right;
        this.mVerticalSlices.add(localVerticalSlice);
        i += 1;
        break;
        localVerticalSlice.right = this;
      }
    }
    updateDebugSolverNames();
  }
  
  private void updateDebugSolverNames()
  {
    if (this.system == null) {}
    for (;;)
    {
      return;
      int j = this.mVerticalGuidelines.size();
      int i = 0;
      while (i < j)
      {
        ((Guideline)this.mVerticalGuidelines.get(i)).setDebugSolverName(this.system, getDebugName() + ".VG" + i);
        i += 1;
      }
      j = this.mHorizontalGuidelines.size();
      i = 0;
      while (i < j)
      {
        ((Guideline)this.mHorizontalGuidelines.get(i)).setDebugSolverName(this.system, getDebugName() + ".HG" + i);
        i += 1;
      }
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    super.addToSolver(paramLinearSystem, paramInt);
    int j = this.mChildren.size();
    if (j == 0) {}
    for (;;)
    {
      return;
      setTableDimensions();
      if (paramLinearSystem == this.mSystem)
      {
        int k = this.mVerticalGuidelines.size();
        int i = 0;
        Guideline localGuideline;
        boolean bool;
        if (i < k)
        {
          localGuideline = (Guideline)this.mVerticalGuidelines.get(i);
          if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {}
          for (bool = true;; bool = false)
          {
            localGuideline.setPositionRelaxed(bool);
            localGuideline.addToSolver(paramLinearSystem, paramInt);
            i += 1;
            break;
          }
        }
        k = this.mHorizontalGuidelines.size();
        i = 0;
        if (i < k)
        {
          localGuideline = (Guideline)this.mHorizontalGuidelines.get(i);
          if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {}
          for (bool = true;; bool = false)
          {
            localGuideline.setPositionRelaxed(bool);
            localGuideline.addToSolver(paramLinearSystem, paramInt);
            i += 1;
            break;
          }
        }
        i = 0;
        while (i < j)
        {
          ((ConstraintWidget)this.mChildren.get(i)).addToSolver(paramLinearSystem, paramInt);
          i += 1;
        }
      }
    }
  }
  
  public void computeGuidelinesPercentPositions()
  {
    int j = this.mVerticalGuidelines.size();
    int i = 0;
    while (i < j)
    {
      ((Guideline)this.mVerticalGuidelines.get(i)).inferRelativePercentPosition();
      i += 1;
    }
    j = this.mHorizontalGuidelines.size();
    i = 0;
    while (i < j)
    {
      ((Guideline)this.mHorizontalGuidelines.get(i)).inferRelativePercentPosition();
      i += 1;
    }
  }
  
  public void cycleColumnAlignment(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(paramInt);
    switch (localVerticalSlice.alignment)
    {
    }
    for (;;)
    {
      setChildrenConnections();
      return;
      localVerticalSlice.alignment = 0;
      continue;
      localVerticalSlice.alignment = 1;
      continue;
      localVerticalSlice.alignment = 2;
    }
  }
  
  public String getColumnAlignmentRepresentation(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(paramInt);
    if (localVerticalSlice.alignment == 1) {
      return "L";
    }
    if (localVerticalSlice.alignment == 0) {
      return "C";
    }
    if (localVerticalSlice.alignment == 3) {
      return "F";
    }
    if (localVerticalSlice.alignment == 2) {
      return "R";
    }
    return "!";
  }
  
  public String getColumnsAlignmentRepresentation()
  {
    int j = this.mVerticalSlices.size();
    Object localObject2 = "";
    int i = 0;
    if (i < j)
    {
      VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(i);
      Object localObject1;
      if (localVerticalSlice.alignment == 1) {
        localObject1 = (String)localObject2 + "L";
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        if (localVerticalSlice.alignment == 0)
        {
          localObject1 = (String)localObject2 + "C";
        }
        else if (localVerticalSlice.alignment == 3)
        {
          localObject1 = (String)localObject2 + "F";
        }
        else
        {
          localObject1 = localObject2;
          if (localVerticalSlice.alignment == 2) {
            localObject1 = (String)localObject2 + "R";
          }
        }
      }
    }
    return (String)localObject2;
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    return this.mHorizontalGuidelines;
  }
  
  public int getNumCols()
  {
    return this.mNumCols;
  }
  
  public int getNumRows()
  {
    return this.mNumRows;
  }
  
  public int getPadding()
  {
    return this.mPadding;
  }
  
  public String getType()
  {
    return "ConstraintTableLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    return this.mVerticalGuidelines;
  }
  
  public boolean handlesInternalConstraints()
  {
    return true;
  }
  
  public boolean isVerticalGrowth()
  {
    return this.mVerticalGrowth;
  }
  
  public void setColumnAlignment(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.mVerticalSlices.size())
    {
      ((VerticalSlice)this.mVerticalSlices.get(paramInt1)).alignment = paramInt2;
      setChildrenConnections();
    }
  }
  
  public void setColumnAlignment(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      int k = paramString.charAt(i);
      if (k == 76) {
        setColumnAlignment(i, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == 67) {
          setColumnAlignment(i, 0);
        } else if (k == 70) {
          setColumnAlignment(i, 3);
        } else if (k == 82) {
          setColumnAlignment(i, 2);
        } else {
          setColumnAlignment(i, 0);
        }
      }
    }
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    this.system = paramLinearSystem;
    super.setDebugSolverName(paramLinearSystem, paramString);
    updateDebugSolverNames();
  }
  
  public void setNumCols(int paramInt)
  {
    if ((this.mVerticalGrowth) && (this.mNumCols != paramInt))
    {
      this.mNumCols = paramInt;
      setVerticalSlices();
      setTableDimensions();
    }
  }
  
  public void setNumRows(int paramInt)
  {
    if ((!this.mVerticalGrowth) && (this.mNumCols != paramInt))
    {
      this.mNumRows = paramInt;
      setHorizontalSlices();
      setTableDimensions();
    }
  }
  
  public void setPadding(int paramInt)
  {
    if (paramInt > 1) {
      this.mPadding = paramInt;
    }
  }
  
  public void setTableDimensions()
  {
    int j = 0;
    int k = this.mChildren.size();
    int i = 0;
    while (i < k)
    {
      j += ((ConstraintWidget)this.mChildren.get(i)).getContainerItemSkip();
      i += 1;
    }
    k += j;
    if (this.mVerticalGrowth)
    {
      if (this.mNumCols == 0) {
        setNumCols(1);
      }
      j = k / this.mNumCols;
      i = j;
      if (this.mNumCols * j < k) {
        i = j + 1;
      }
      if ((this.mNumRows == i) && (this.mVerticalGuidelines.size() == this.mNumCols - 1)) {
        return;
      }
      this.mNumRows = i;
      setHorizontalSlices();
    }
    for (;;)
    {
      setChildrenConnections();
      return;
      if (this.mNumRows == 0) {
        setNumRows(1);
      }
      j = k / this.mNumRows;
      i = j;
      if (this.mNumRows * j < k) {
        i = j + 1;
      }
      if ((this.mNumCols == i) && (this.mHorizontalGuidelines.size() == this.mNumRows - 1)) {
        break;
      }
      this.mNumCols = i;
      setVerticalSlices();
    }
  }
  
  public void setVerticalGrowth(boolean paramBoolean)
  {
    this.mVerticalGrowth = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    super.updateFromSolver(paramLinearSystem, paramInt);
    if (paramLinearSystem == this.mSystem)
    {
      int j = this.mVerticalGuidelines.size();
      int i = 0;
      while (i < j)
      {
        ((Guideline)this.mVerticalGuidelines.get(i)).updateFromSolver(paramLinearSystem, paramInt);
        i += 1;
      }
      j = this.mHorizontalGuidelines.size();
      i = 0;
      while (i < j)
      {
        ((Guideline)this.mHorizontalGuidelines.get(i)).updateFromSolver(paramLinearSystem, paramInt);
        i += 1;
      }
    }
  }
  
  class HorizontalSlice
  {
    ConstraintWidget bottom;
    int padding;
    ConstraintWidget top;
    
    HorizontalSlice() {}
  }
  
  class VerticalSlice
  {
    int alignment = 1;
    ConstraintWidget left;
    int padding;
    ConstraintWidget right;
    
    VerticalSlice() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/widgets/ConstraintTableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */