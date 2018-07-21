package com.baidu.navisdk.util.db.object;

import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanNodeDBObject
  extends RoutePlanNode
  implements BaseDBObject
{
  private static final long serialVersionUID = 2089580738007876476L;
  private int mArg1;
  private int mArg2;
  private int mId;
  
  public RoutePlanNodeDBObject() {}
  
  public RoutePlanNodeDBObject(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    super(paramInt1, paramInt2, paramInt3, paramString1, paramString2, null);
  }
  
  public RoutePlanNodeDBObject(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    super(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3);
  }
  
  public static boolean compare(RoutePlanNode paramRoutePlanNode1, RoutePlanNode paramRoutePlanNode2)
  {
    boolean bool2 = false;
    if ((paramRoutePlanNode1 == null) || (paramRoutePlanNode2 == null)) {
      return false;
    }
    String str1 = paramRoutePlanNode1.getName();
    String str2 = paramRoutePlanNode2.getName();
    boolean bool1;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      bool1 = bool2;
      if (Math.abs(paramRoutePlanNode1.getLatitudeE6() - paramRoutePlanNode2.getLatitudeE6()) <= 3)
      {
        bool1 = bool2;
        if (Math.abs(paramRoutePlanNode1.getLongitudeE6() - paramRoutePlanNode2.getLongitudeE6()) <= 3) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (str1.equals(str2)) {
        if ((!TextUtils.isEmpty(paramRoutePlanNode1.getDescription())) && (!TextUtils.isEmpty(paramRoutePlanNode2.getDescription())))
        {
          bool1 = bool2;
          if (paramRoutePlanNode1.getDescription().equals(paramRoutePlanNode2.getDescription())) {
            bool1 = true;
          }
        }
        else
        {
          bool1 = bool2;
          if (Math.abs(paramRoutePlanNode1.getLatitudeE6() - paramRoutePlanNode2.getLatitudeE6()) <= 3)
          {
            bool1 = bool2;
            if (Math.abs(paramRoutePlanNode1.getLongitudeE6() - paramRoutePlanNode2.getLongitudeE6()) <= 3) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public static ArrayList<RoutePlanNode> convertToRoutePlanNodeList(List<RoutePlanNodeDBObject> paramList)
  {
    Object localObject = null;
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= paramList.size()) {
          break;
        }
        localArrayList.add(paramList.get(i));
        i += 1;
      }
    }
    paramList = (List<RoutePlanNodeDBObject>)localObject;
    if (localObject == null) {
      paramList = new ArrayList(0);
    }
    return paramList;
  }
  
  public int getArg1()
  {
    return this.mArg1;
  }
  
  public int getArg2()
  {
    return this.mArg2;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public void setArg1(int paramInt)
  {
    this.mArg1 = paramInt;
  }
  
  public void setArg2(int paramInt)
  {
    this.mArg2 = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/object/RoutePlanNodeDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */