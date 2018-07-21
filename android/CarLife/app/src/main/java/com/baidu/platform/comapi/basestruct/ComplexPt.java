package com.baidu.platform.comapi.basestruct;

import com.baidu.platform.comapi.location.LocationMgr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexPt
{
  public static final int TEN_THOUSAND = 100000;
  public static final int TYPE_LINE = 2;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_POINT = 1;
  public static final int TYPE_POLYGON = 3;
  public int eType;
  public ArrayList<ArrayList<Point>> mGeoPt;
  public Point mLL;
  public Point mRu;
  
  private void addPoint(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    paramList.add(Integer.valueOf(paramInt1));
    paramList.add(Integer.valueOf(paramInt2));
  }
  
  public static ComplexPt createComplexPt(List<? extends Number> paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      localObject = null;
    }
    ComplexPt localComplexPt;
    int j;
    do
    {
      do
      {
        return (ComplexPt)localObject;
        localComplexPt = new ComplexPt();
        j = paramList.size();
        if (j < 5) {
          break;
        }
        localComplexPt.mLL = new Point(((Number)paramList.get(0)).doubleValue(), ((Number)paramList.get(1)).doubleValue());
        localComplexPt.mRu = new Point(((Number)paramList.get(2)).doubleValue(), ((Number)paramList.get(3)).doubleValue());
        localComplexPt.eType = ((int)((Number)paramList.get(4)).doubleValue());
        localComplexPt.mGeoPt = new ArrayList();
        localObject = localComplexPt;
      } while (j < 7);
      ArrayList localArrayList = new ArrayList();
      localObject = new Point(((Number)paramList.get(5)).doubleValue(), ((Number)paramList.get(6)).doubleValue());
      localArrayList.add(localObject);
      int i = 7;
      while (i + 1 < j)
      {
        localObject = new Point(((Point)localObject).getDoubleX() + ((Number)paramList.get(i)).doubleValue(), ((Point)localObject).getDoubleY() + ((Number)paramList.get(i + 1)).doubleValue());
        localArrayList.add(localObject);
        i += 2;
      }
      localComplexPt.mGeoPt.add(localArrayList);
      return localComplexPt;
      localObject = localComplexPt;
    } while (j < 2);
    paramList = new Point(((Number)paramList.get(0)).doubleValue(), ((Number)paramList.get(1)).doubleValue());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramList);
    localComplexPt.mLL = new Point(paramList);
    localComplexPt.mRu = new Point(paramList);
    localComplexPt.eType = 1;
    localComplexPt.mGeoPt = new ArrayList();
    localComplexPt.mGeoPt.add(localObject);
    return localComplexPt;
  }
  
  public boolean isEmpty()
  {
    return (this.mGeoPt == null) || (this.mGeoPt.size() < 1) || (((ArrayList)this.mGeoPt.get(0)).size() < 1);
  }
  
  public ComplexPt toComplexPtGCJ2MC()
  {
    Object localObject;
    if (this.mLL != null)
    {
      localObject = LocationMgr.getInstance().Coordinate_encryptEx(this.mLL.getIntX() / 100000.0F, this.mLL.getIntY() / 100000.0F, "gcj02");
      if (localObject != null)
      {
        this.mLL.setIntX(((Point)localObject).getIntX());
        this.mLL.setIntY(((Point)localObject).getIntY());
      }
    }
    if (this.mRu != null)
    {
      localObject = LocationMgr.getInstance().Coordinate_encryptEx(this.mRu.getIntX() / 100000.0F, this.mRu.getIntY() / 100000.0F, "gcj02");
      if (localObject != null)
      {
        this.mRu.setIntX(((Point)localObject).getIntX());
        this.mRu.setIntY(((Point)localObject).getIntY());
      }
    }
    if ((this.mGeoPt != null) && (this.mGeoPt.size() > 0) && (((ArrayList)this.mGeoPt.get(0)).size() > 0))
    {
      int i = 0;
      while (i < this.mGeoPt.size())
      {
        localObject = (ArrayList)this.mGeoPt.get(i);
        localObject = LocationMgr.getInstance().Coordinate_encryptExArray((ArrayList)localObject, "gcj02");
        if (localObject != null)
        {
          int j = 0;
          while (j < ((ArrayList)localObject).size())
          {
            ((Point)((ArrayList)this.mGeoPt.get(i)).get(j)).setTo((Point)((ArrayList)localObject).get(j));
            j += 1;
          }
        }
        i += 1;
      }
    }
    return this;
  }
  
  public ArrayList<Integer> toIntArray()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mLL != null)
    {
      addPoint(localArrayList, this.mLL.getIntX(), this.mLL.getIntY());
      if (this.mRu == null) {
        break label213;
      }
      addPoint(localArrayList, this.mRu.getIntX(), this.mRu.getIntY());
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(this.eType));
      if ((this.mGeoPt == null) || (this.mGeoPt.size() <= 0) || (((ArrayList)this.mGeoPt.get(0)).size() <= 0)) {
        return localArrayList;
      }
      Object localObject2 = new Point(0.0D, 0.0D);
      Iterator localIterator1 = this.mGeoPt.iterator();
      if (!localIterator1.hasNext()) {
        return localArrayList;
      }
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      for (Object localObject1 = localObject2;; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (Point)localIterator2.next();
        addPoint(localArrayList, ((Point)localObject2).getIntX() - ((Point)localObject1).getIntX(), ((Point)localObject2).getIntY() - ((Point)localObject1).getIntY());
      }
      addPoint(localArrayList, 0, 0);
      break;
      label213:
      addPoint(localArrayList, 0, 0);
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "ComplexPt [eType=" + this.eType + ", mLL=" + this.mLL + ", mRu=" + this.mRu + ", mGeoPt=" + this.mGeoPt + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/basestruct/ComplexPt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */