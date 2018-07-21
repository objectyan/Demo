package com.baidu.navisdk.module.ugc.data.datarepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UgcDataProvider
{
  private static Map<Integer, Integer> mDrawableIdCache = null;
  private static Map<Integer, String> mUrlCache = null;
  
  public static int getDrawableIdByType(int paramInt)
  {
    if (mDrawableIdCache == null) {
      initDrawableIdCache();
    }
    Integer localInteger = (Integer)mDrawableIdCache.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static String getUrlByType(int paramInt)
  {
    if (mUrlCache == null) {
      initUrlCache();
    }
    return (String)mUrlCache.get(Integer.valueOf(paramInt));
  }
  
  private static void initDrawableIdCache()
  {
    mDrawableIdCache = new HashMap();
    mDrawableIdCache.put(Integer.valueOf(4096), Integer.valueOf(1711408145));
    mDrawableIdCache.put(Integer.valueOf(4098), Integer.valueOf(1711408133));
    mDrawableIdCache.put(Integer.valueOf(4099), Integer.valueOf(1711408133));
    mDrawableIdCache.put(Integer.valueOf(4100), Integer.valueOf(1711408136));
    mDrawableIdCache.put(Integer.valueOf(1), Integer.valueOf(1711408103));
    mDrawableIdCache.put(Integer.valueOf(2), Integer.valueOf(1711408113));
    mDrawableIdCache.put(Integer.valueOf(3), Integer.valueOf(1711408097));
    mDrawableIdCache.put(Integer.valueOf(4), Integer.valueOf(1711408111));
    mDrawableIdCache.put(Integer.valueOf(5), Integer.valueOf(1711408110));
    mDrawableIdCache.put(Integer.valueOf(6), Integer.valueOf(1711408105));
    mDrawableIdCache.put(Integer.valueOf(7), Integer.valueOf(1711408106));
    mDrawableIdCache.put(Integer.valueOf(61445), Integer.valueOf(1711408119));
    mDrawableIdCache.put(Integer.valueOf(61444), Integer.valueOf(1711408120));
    mDrawableIdCache.put(Integer.valueOf(61449), Integer.valueOf(1711408118));
    mDrawableIdCache.put(Integer.valueOf(61450), Integer.valueOf(1711408115));
    mDrawableIdCache.put(Integer.valueOf(61446), Integer.valueOf(1711408116));
    mDrawableIdCache.put(Integer.valueOf(61447), Integer.valueOf(1711408117));
    mDrawableIdCache.put(Integer.valueOf(8), Integer.valueOf(1711408124));
    mDrawableIdCache.put(Integer.valueOf(9), Integer.valueOf(1711408107));
    mDrawableIdCache.put(Integer.valueOf(10), Integer.valueOf(1711408096));
    mDrawableIdCache.put(Integer.valueOf(15), Integer.valueOf(1711408102));
    mDrawableIdCache.put(Integer.valueOf(61441), Integer.valueOf(1711408052));
    mDrawableIdCache.put(Integer.valueOf(61442), Integer.valueOf(1711408050));
    mDrawableIdCache.put(Integer.valueOf(61443), Integer.valueOf(1711408051));
  }
  
  private static void initUrlCache()
  {
    mUrlCache = new HashMap();
    ArrayList localArrayList = UgcDataRepository.getInstance().obtainNaviUgcDataList();
    int i;
    if (localArrayList != null)
    {
      i = 0;
      while (i < localArrayList.size())
      {
        if ((localArrayList.get(i) != null) && (((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).iconUrl != null)) {
          mUrlCache.put(Integer.valueOf(((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).type), ((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).iconUrl);
        }
        i += 1;
      }
    }
    localArrayList = UgcDataRepository.getInstance().obtainMapUgcDataList();
    if (localArrayList != null)
    {
      i = 0;
      while (i < localArrayList.size())
      {
        if ((localArrayList.get(i) != null) && (((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).iconUrl != null)) {
          mUrlCache.put(Integer.valueOf(((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).type + 61440), ((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).iconUrl);
        }
        i += 1;
      }
    }
    if (UgcDataRepository.getInstance().getActBaseDataModel() != null) {
      mUrlCache.put(Integer.valueOf(4096), UgcDataRepository.getInstance().getActBaseDataModel().entryIconUrl);
    }
  }
  
  public static UgcLayout obtainDynamicUgcNaviSubLayout(int paramInt)
  {
    ArrayList localArrayList = UgcDataRepository.getInstance().obtainNaviDynamicUgcDataList();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > paramInt)
      {
        localObject1 = localObject2;
        if (paramInt >= 0) {
          localObject1 = (UgcDataRepository.UgcBaseDataModel)localArrayList.get(paramInt);
        }
      }
    }
    return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), localArrayList, (UgcDataRepository.UgcBaseDataModel)localObject1, paramInt);
  }
  
  public static UgcLayout obtainDynamicUgcNaviSubLayoutByType(int paramInt)
  {
    ArrayList localArrayList = UgcDataRepository.getInstance().obtainNaviDynamicUgcDataList();
    Object localObject2 = null;
    int k = -1;
    int i = 0;
    Object localObject1;
    int j;
    for (;;)
    {
      localObject1 = localObject2;
      j = k;
      if (i < localArrayList.size())
      {
        if (((UgcDataRepository.UgcBaseDataModel)localArrayList.get(i)).type == paramInt)
        {
          localObject1 = (UgcDataRepository.UgcBaseDataModel)localArrayList.get(i);
          j = i;
        }
      }
      else
      {
        if (localObject1 != null) {
          break;
        }
        return null;
      }
      i += 1;
    }
    return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), localArrayList, (UgcDataRepository.UgcBaseDataModel)localObject1, j);
  }
  
  public static UgcLayout obtainUgcMapLayout()
  {
    return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), null, -1);
  }
  
  public static UgcLayout obtainUgcMapSubLayout(int paramInt)
  {
    ArrayList localArrayList = UgcDataRepository.getInstance().obtainMapUgcDataList();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > paramInt)
      {
        localObject1 = localObject2;
        if (paramInt >= 0) {
          localObject1 = (UgcDataRepository.UgcBaseDataModel)localArrayList.get(paramInt);
        }
      }
    }
    return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), (UgcDataRepository.UgcBaseDataModel)localObject1, paramInt);
  }
  
  public static UgcLayout obtainUgcNaviLayout()
  {
    return new UgcLayout(UgcDataRepository.getInstance().obtainNaviUgcDataList(), UgcDataRepository.getInstance().obtainNaviDynamicUgcDataList(), null, -1);
  }
  
  public static UgcLayout obtainUgcNaviSubLayout(int paramInt)
  {
    ArrayList localArrayList = UgcDataRepository.getInstance().obtainNaviUgcDataList();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > paramInt)
      {
        localObject1 = localObject2;
        if (paramInt >= 0) {
          localObject1 = (UgcDataRepository.UgcBaseDataModel)localArrayList.get(paramInt);
        }
      }
    }
    return new UgcLayout(UgcDataRepository.getInstance().obtainMapUgcDataList(), (UgcDataRepository.UgcBaseDataModel)localObject1, paramInt);
  }
  
  public static class UgcLayout
  {
    private ArrayList<UgcDataRepository.UgcBaseDataModel> dynamicMoselList = null;
    private int position = -1;
    private ArrayList<UgcDataRepository.UgcBaseDataModel> ugcMainList = null;
    private UgcDataRepository.UgcBaseDataModel ugcSubModel = null;
    
    public UgcLayout(ArrayList<UgcDataRepository.UgcBaseDataModel> paramArrayList, UgcDataRepository.UgcBaseDataModel paramUgcBaseDataModel)
    {
      this(paramArrayList, paramUgcBaseDataModel, -1);
    }
    
    public UgcLayout(ArrayList<UgcDataRepository.UgcBaseDataModel> paramArrayList, UgcDataRepository.UgcBaseDataModel paramUgcBaseDataModel, int paramInt)
    {
      this(paramArrayList, null, paramUgcBaseDataModel, paramInt);
    }
    
    public UgcLayout(ArrayList<UgcDataRepository.UgcBaseDataModel> paramArrayList1, ArrayList<UgcDataRepository.UgcBaseDataModel> paramArrayList2, UgcDataRepository.UgcBaseDataModel paramUgcBaseDataModel, int paramInt)
    {
      this.ugcMainList = paramArrayList1;
      this.ugcSubModel = paramUgcBaseDataModel;
      this.position = paramInt;
      this.dynamicMoselList = paramArrayList2;
    }
    
    public int getDetailSize()
    {
      if ((this.ugcSubModel == null) || (this.ugcSubModel.ugcSubDataDetail == null)) {
        return 0;
      }
      return this.ugcSubModel.ugcSubDataDetail.size();
    }
    
    public String getDetailTitle(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getDetailSize()) && (this.ugcSubModel.ugcSubDataDetail.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcSubModel.ugcSubDataDetail.get(paramInt)).title;
      }
      return null;
    }
    
    public int getDetailType(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getDetailSize()) && (this.ugcSubModel.ugcSubDataDetail.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcSubModel.ugcSubDataDetail.get(paramInt)).type;
      }
      return -1;
    }
    
    public int getDynamicItemsSize()
    {
      if (this.dynamicMoselList != null) {
        return this.dynamicMoselList.size();
      }
      return 0;
    }
    
    public String getDynamicItemsTitle(int paramInt)
    {
      if ((getDynamicItemsSize() > paramInt) && (paramInt >= 0) && (this.dynamicMoselList.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.dynamicMoselList.get(paramInt)).title;
      }
      return null;
    }
    
    public int getDynamicItemsType(int paramInt)
    {
      if ((getDynamicItemsSize() > paramInt) && (paramInt >= 0) && (this.dynamicMoselList.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.dynamicMoselList.get(paramInt)).type;
      }
      return -1;
    }
    
    public int getLaneSize()
    {
      if ((this.ugcSubModel == null) || (this.ugcSubModel.ugcSubDataLane == null)) {
        return 0;
      }
      return this.ugcSubModel.ugcSubDataLane.size();
    }
    
    public String getLaneTitle(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getLaneSize()) && (this.ugcSubModel.ugcSubDataLane.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcSubModel.ugcSubDataLane.get(paramInt)).title;
      }
      return null;
    }
    
    public int getLaneType(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getLaneSize()) && (this.ugcSubModel.ugcSubDataLane.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcSubModel.ugcSubDataLane.get(paramInt)).type;
      }
      return -1;
    }
    
    public int getMainItemsSize()
    {
      if (this.ugcMainList != null) {
        return this.ugcMainList.size();
      }
      return 0;
    }
    
    public String getMainItemsTitle(int paramInt)
    {
      if ((getMainItemsSize() > paramInt) && (paramInt >= 0) && (this.ugcMainList.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcMainList.get(paramInt)).title;
      }
      return null;
    }
    
    public int getMainItemsType(int paramInt)
    {
      if ((getMainItemsSize() > paramInt) && (paramInt >= 0) && (this.ugcMainList.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcMainList.get(paramInt)).type;
      }
      return -1;
    }
    
    public ArrayList<UgcDataRepository.UgcBaseDataModel> getMainList()
    {
      return this.ugcMainList;
    }
    
    public int getPositionSize()
    {
      if ((this.ugcSubModel == null) || (this.ugcSubModel.ugcSubDataPosition == null)) {
        return 0;
      }
      return this.ugcSubModel.ugcSubDataPosition.size();
    }
    
    public String getPositionTitle(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getPositionSize()) && (this.ugcSubModel.ugcSubDataPosition.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcSubModel.ugcSubDataPosition.get(paramInt)).title;
      }
      return null;
    }
    
    public int getPositionType(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getPositionSize()) && (this.ugcSubModel.ugcSubDataPosition.get(paramInt) != null)) {
        return ((UgcDataRepository.UgcBaseDataModel)this.ugcSubModel.ugcSubDataPosition.get(paramInt)).type;
      }
      return -1;
    }
    
    public String getSubTitle()
    {
      if (this.ugcSubModel != null) {
        return this.ugcSubModel.title;
      }
      return null;
    }
    
    public int getSubType()
    {
      if (this.ugcSubModel != null) {
        return this.ugcSubModel.type;
      }
      return -1;
    }
    
    public UgcDataRepository.UgcBaseDataModel getUgcSubModel()
    {
      return this.ugcSubModel;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/data/datarepository/UgcDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */