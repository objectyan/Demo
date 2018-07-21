package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer
  extends ConstraintWidget
{
  protected ArrayList<ConstraintWidget> mChildren = new ArrayList();
  
  public WidgetContainer() {}
  
  public WidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public WidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Rectangle getBounds(ArrayList<ConstraintWidget> paramArrayList)
  {
    Rectangle localRectangle = new Rectangle();
    if (paramArrayList.size() == 0) {
      return localRectangle;
    }
    int i2 = Integer.MAX_VALUE;
    int m = 0;
    int n = Integer.MAX_VALUE;
    int i = 0;
    int j = 0;
    int i3 = paramArrayList.size();
    while (j < i3)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(j);
      int k = i2;
      if (localConstraintWidget.getX() < i2) {
        k = localConstraintWidget.getX();
      }
      int i1 = n;
      if (localConstraintWidget.getY() < n) {
        i1 = localConstraintWidget.getY();
      }
      n = m;
      if (localConstraintWidget.getRight() > m) {
        n = localConstraintWidget.getRight();
      }
      i2 = i;
      if (localConstraintWidget.getBottom() > i) {
        i2 = localConstraintWidget.getBottom();
      }
      j += 1;
      m = n;
      i = i2;
      i2 = k;
      n = i1;
    }
    localRectangle.setBounds(i2, n, m - i2, i - n);
    return localRectangle;
  }
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.add(paramConstraintWidget);
    if (paramConstraintWidget.getParent() != null) {
      ((WidgetContainer)paramConstraintWidget.getParent()).remove(paramConstraintWidget);
    }
    paramConstraintWidget.setParent(this);
  }
  
  public ConstraintWidget findWidget(float paramFloat1, float paramFloat2)
  {
    Object localObject2 = null;
    int i = getDrawX();
    int j = getDrawY();
    int k = getWidth();
    int m = getHeight();
    Object localObject1 = localObject2;
    if (paramFloat1 >= i)
    {
      localObject1 = localObject2;
      if (paramFloat1 <= i + k)
      {
        localObject1 = localObject2;
        if (paramFloat2 >= j)
        {
          localObject1 = localObject2;
          if (paramFloat2 <= j + m) {
            localObject1 = this;
          }
        }
      }
    }
    i = 0;
    j = this.mChildren.size();
    localObject2 = localObject1;
    if (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof WidgetContainer))
      {
        localConstraintWidget = ((WidgetContainer)localConstraintWidget).findWidget(paramFloat1, paramFloat2);
        localObject1 = localObject2;
        if (localConstraintWidget != null) {
          localObject1 = localConstraintWidget;
        }
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        k = localConstraintWidget.getDrawX();
        m = localConstraintWidget.getDrawY();
        int n = localConstraintWidget.getWidth();
        int i1 = localConstraintWidget.getHeight();
        localObject1 = localObject2;
        if (paramFloat1 >= k)
        {
          localObject1 = localObject2;
          if (paramFloat1 <= k + n)
          {
            localObject1 = localObject2;
            if (paramFloat2 >= m)
            {
              localObject1 = localObject2;
              if (paramFloat2 <= m + i1) {
                localObject1 = localConstraintWidget;
              }
            }
          }
        }
      }
    }
    return (ConstraintWidget)localObject2;
  }
  
  public ArrayList<ConstraintWidget> findWidgets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    Rectangle localRectangle1 = new Rectangle();
    localRectangle1.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    paramInt2 = this.mChildren.size();
    while (paramInt1 < paramInt2)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(paramInt1);
      Rectangle localRectangle2 = new Rectangle();
      localRectangle2.setBounds(localConstraintWidget.getDrawX(), localConstraintWidget.getDrawY(), localConstraintWidget.getWidth(), localConstraintWidget.getHeight());
      if (localRectangle1.intersects(localRectangle2)) {
        localArrayList.add(localConstraintWidget);
      }
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<ConstraintWidget> getChildren()
  {
    return this.mChildren;
  }
  
  public ConstraintWidgetContainer getRootConstraintContainer()
  {
    ConstraintWidget localConstraintWidget2 = getParent();
    ConstraintWidgetContainer localConstraintWidgetContainer = null;
    ConstraintWidget localConstraintWidget1 = localConstraintWidget2;
    if ((this instanceof ConstraintWidgetContainer))
    {
      localConstraintWidgetContainer = (ConstraintWidgetContainer)this;
      localConstraintWidget1 = localConstraintWidget2;
    }
    for (;;)
    {
      ConstraintWidget localConstraintWidget3 = localConstraintWidget1;
      if (localConstraintWidget3 == null) {
        break;
      }
      localConstraintWidget2 = localConstraintWidget3.getParent();
      localConstraintWidget1 = localConstraintWidget2;
      if ((localConstraintWidget3 instanceof ConstraintWidgetContainer))
      {
        localConstraintWidgetContainer = (ConstraintWidgetContainer)localConstraintWidget3;
        localConstraintWidget1 = localConstraintWidget2;
      }
    }
    return localConstraintWidgetContainer;
  }
  
  public void layout()
  {
    updateDrawPosition();
    if (this.mChildren == null) {}
    for (;;)
    {
      return;
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        if ((localConstraintWidget instanceof WidgetContainer)) {
          ((WidgetContainer)localConstraintWidget).layout();
        }
        i += 1;
      }
    }
  }
  
  public void remove(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.remove(paramConstraintWidget);
    paramConstraintWidget.setParent(null);
  }
  
  public void removeAllChildren()
  {
    this.mChildren.clear();
  }
  
  public void reset()
  {
    this.mChildren.clear();
    super.reset();
  }
  
  public void resetGroups()
  {
    super.resetGroups();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).resetGroups();
      i += 1;
    }
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    super.resetSolverVariables(paramCache);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).resetSolverVariables(paramCache);
      i += 1;
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    super.setOffset(paramInt1, paramInt2);
    paramInt2 = this.mChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((ConstraintWidget)this.mChildren.get(paramInt1)).setOffset(getRootX(), getRootY());
      paramInt1 += 1;
    }
  }
  
  public void updateDrawPosition()
  {
    super.updateDrawPosition();
    if (this.mChildren == null) {}
    for (;;)
    {
      return;
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        localConstraintWidget.setOffset(getDrawX(), getDrawY());
        if (!(localConstraintWidget instanceof ConstraintWidgetContainer)) {
          localConstraintWidget.updateDrawPosition();
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/constraint/solver/widgets/WidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */