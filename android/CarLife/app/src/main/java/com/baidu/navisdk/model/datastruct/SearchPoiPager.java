package com.baidu.navisdk.model.datastruct;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class SearchPoiPager
{
  public static final int DEFAULT_SEARCH_COUNT_PRE_PAGER = 10;
  public static final int INVAIL_DISTRCTID = -1000;
  public static final int ROUTESEARCH_MODE_BY_KEYWORD = 1;
  public static final int ROUTESEARCH_MODE_BY_TYPE = 0;
  public static final int SEARCH_TYPE_CATALOG = 4;
  public static final int SEARCH_TYPE_CATALOG_WITH_DISTRCTID = 5;
  public static final int SEARCH_TYPE_KEY = 1;
  public static final int SEARCH_TYPE_KEY_WITH_ROUTE = 6;
  public static final int SEARCH_TYPE_SPACE = 2;
  public static final int SEARCH_TYPE_SPACE_WITH_DISTRCTID = 3;
  public static final int SORT_TYPE_DEFAULT = 1;
  public static final int SORT_TYPE_DISTANCE = 2;
  public static final int SORT_TYPE_DISTANCE_WITH_STARTPOINT = 3;
  public static int mSortType = 1;
  private boolean isLastPager;
  private int mCatalogId;
  private int mCountPerPager;
  private int mCurrentPageNum;
  private ArrayList<SearchPoi> mDistanceSortList;
  private DistrictInfo mDistrctInfo;
  private int mNetMode;
  private SearchPoiPager mNextPager;
  private SearchPoiPager mNextPagerForMap;
  private int mPageCnt;
  private int mPagerNum = 1;
  private int mParPoiSize;
  private ArrayList<SearchPoi> mPoiList;
  private SearchPoiPager mPrevPager;
  private SearchPoiPager mPrevPagerForMap;
  private SearchCircle mSearchCircle;
  private String mSearchKey;
  private int mSearchMode;
  private int mSearchRange;
  private int mSearchType;
  
  private SearchPoiPager() {}
  
  public SearchPoiPager(int paramInt1, DistrictInfo paramDistrictInfo, SearchCircle paramSearchCircle, int paramInt2, int paramInt3)
  {
    this.mSearchType = 5;
    this.mCountPerPager = paramInt2;
    this.mCatalogId = paramInt1;
    this.mNetMode = paramInt3;
    this.mDistrctInfo = paramDistrictInfo;
    this.mSearchCircle = paramSearchCircle;
    mSortType = 1;
  }
  
  public SearchPoiPager(int paramInt1, SearchCircle paramSearchCircle, int paramInt2, int paramInt3)
  {
    this.mSearchType = 4;
    this.mCountPerPager = paramInt2;
    this.mCatalogId = paramInt1;
    this.mNetMode = paramInt3;
    this.mSearchCircle = paramSearchCircle;
    mSortType = 1;
  }
  
  public SearchPoiPager(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSearchType = 6;
    this.mSearchKey = paramString;
    this.mSearchMode = paramInt1;
    this.mSearchRange = paramInt2;
    this.mCountPerPager = paramInt3;
    this.mNetMode = paramInt4;
    mSortType = 2;
  }
  
  public SearchPoiPager(String paramString, DistrictInfo paramDistrictInfo, int paramInt1, int paramInt2)
  {
    this.mSearchType = 1;
    this.mCountPerPager = paramInt1;
    this.mSearchKey = paramString;
    this.mNetMode = paramInt2;
    this.mDistrctInfo = paramDistrictInfo;
    mSortType = 1;
  }
  
  public SearchPoiPager(String paramString, DistrictInfo paramDistrictInfo, SearchCircle paramSearchCircle, int paramInt1, int paramInt2)
  {
    this.mSearchType = 3;
    this.mCountPerPager = paramInt1;
    this.mSearchKey = paramString;
    this.mNetMode = paramInt2;
    this.mDistrctInfo = paramDistrictInfo;
    this.mSearchCircle = paramSearchCircle;
    mSortType = 1;
  }
  
  public SearchPoiPager(String paramString, SearchCircle paramSearchCircle, int paramInt1, int paramInt2)
  {
    this.mSearchType = 2;
    this.mCountPerPager = paramInt1;
    this.mSearchKey = paramString;
    this.mNetMode = paramInt2;
    this.mSearchCircle = paramSearchCircle;
    mSortType = 1;
  }
  
  public void addSearchPoi(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof SearchPoi)))
    {
      if (this.mPoiList == null) {
        this.mPoiList = new ArrayList();
      }
      this.mPoiList.add((SearchPoi)paramObject);
    }
  }
  
  public void clearPoiPager()
  {
    this.mPoiList.clear();
  }
  
  public SearchPoiPager copy()
  {
    SearchPoiPager localSearchPoiPager = new SearchPoiPager();
    localSearchPoiPager.isLastPager = this.isLastPager;
    localSearchPoiPager.mCatalogId = this.mCatalogId;
    localSearchPoiPager.mCountPerPager = this.mCountPerPager;
    localSearchPoiPager.mDistrctInfo = this.mDistrctInfo;
    localSearchPoiPager.mNetMode = this.mNetMode;
    localSearchPoiPager.mNextPager = null;
    localSearchPoiPager.mPagerNum = this.mPagerNum;
    localSearchPoiPager.mPrevPager = null;
    localSearchPoiPager.mSearchCircle = this.mSearchCircle;
    localSearchPoiPager.mSearchKey = this.mSearchKey;
    localSearchPoiPager.mSearchType = this.mSearchType;
    localSearchPoiPager.mSearchMode = this.mSearchMode;
    localSearchPoiPager.mSearchRange = this.mSearchRange;
    return localSearchPoiPager;
  }
  
  public SearchPoiPager createNextPager()
  {
    Object localObject;
    if (this.isLastPager)
    {
      localObject = null;
      return (SearchPoiPager)localObject;
    }
    SearchPoiPager localSearchPoiPager;
    switch (this.mSearchType)
    {
    default: 
      localSearchPoiPager = null;
    }
    for (;;)
    {
      localObject = localSearchPoiPager;
      if (localSearchPoiPager == null) {
        break;
      }
      localSearchPoiPager.mPrevPager = this;
      this.mPagerNum += 1;
      this.mNextPager = localSearchPoiPager;
      return localSearchPoiPager;
      localSearchPoiPager = new SearchPoiPager(this.mSearchKey, this.mDistrctInfo, this.mCountPerPager, this.mNetMode);
      continue;
      localSearchPoiPager = new SearchPoiPager(this.mSearchKey, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
      continue;
      localSearchPoiPager = new SearchPoiPager(this.mSearchKey, this.mDistrctInfo, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
      continue;
      localSearchPoiPager = new SearchPoiPager(this.mCatalogId, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
      continue;
      localSearchPoiPager = new SearchPoiPager(this.mCatalogId, this.mDistrctInfo, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
      continue;
      localSearchPoiPager = new SearchPoiPager(this.mSearchKey, this.mSearchMode, this.mSearchRange, this.mCountPerPager, this.mNetMode);
    }
  }
  
  public int getCatalogId()
  {
    return this.mCatalogId;
  }
  
  public int getCountPerPager()
  {
    return this.mCountPerPager;
  }
  
  public int getCurrentPageNum()
  {
    return this.mCurrentPageNum;
  }
  
  public DistrictInfo getDistrct()
  {
    return this.mDistrctInfo;
  }
  
  public int getNetMode()
  {
    return this.mNetMode;
  }
  
  public SearchPoiPager getNextPager()
  {
    return this.mNextPager;
  }
  
  public int getPageCnt()
  {
    return this.mPageCnt;
  }
  
  public int getPagerNum()
  {
    return this.mPagerNum;
  }
  
  public int getParPoiSize()
  {
    return this.mParPoiSize;
  }
  
  public ArrayList<SearchPoi> getPoiList()
  {
    if ((mSortType == 2) && (this.mSearchType != 6))
    {
      if ((this.mDistanceSortList == null) && (this.mPoiList != null))
      {
        this.mDistanceSortList = new ArrayList(getCountPerPager());
        int i = 0;
        while ((i < getCountPerPager()) && (i < this.mPoiList.size()))
        {
          this.mDistanceSortList.add(this.mPoiList.get(i));
          i += 1;
        }
        GeoPoint localGeoPoint = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getMyPositionGeo();
        if ((localGeoPoint != null) && (localGeoPoint.isValid())) {
          BNPoiSearcher.getInstance().quickSortByDistance(localGeoPoint, this.mDistanceSortList);
        }
        if (this.mPoiList.size() > getCountPerPager())
        {
          i = 0;
          while (i < this.mPoiList.size() - getCountPerPager())
          {
            this.mDistanceSortList.add(this.mPoiList.get(getCountPerPager() + i));
            i += 1;
          }
        }
      }
      return this.mDistanceSortList;
    }
    return this.mPoiList;
  }
  
  public SearchPoiPager getPrevPager()
  {
    return this.mPrevPager;
  }
  
  public SearchCircle getSearchCircle()
  {
    return this.mSearchCircle;
  }
  
  public String getSearchKey()
  {
    return this.mSearchKey;
  }
  
  public int getSearchMode()
  {
    return this.mSearchMode;
  }
  
  public int getSearchRange()
  {
    return this.mSearchRange;
  }
  
  public int getSearchType()
  {
    return this.mSearchType;
  }
  
  public int getSortType()
  {
    return mSortType;
  }
  
  public boolean isLastPager()
  {
    if (this.mPoiList == null) {
      return true;
    }
    return this.isLastPager;
  }
  
  public boolean isVail()
  {
    boolean bool = true;
    switch (this.mSearchType)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool;
              } while (!TextUtils.isEmpty(this.mSearchKey));
              return false;
            } while ((!TextUtils.isEmpty(this.mSearchKey)) && (this.mSearchCircle != null) && (this.mSearchCircle.mCenter != null));
            return false;
          } while ((!TextUtils.isEmpty(this.mSearchKey)) && (this.mSearchCircle != null) && (this.mSearchCircle.mCenter != null));
          return false;
        } while ((this.mSearchCircle != null) && (this.mSearchCircle.mCenter != null));
        return false;
      } while ((this.mSearchCircle != null) && (this.mSearchCircle.mCenter != null));
      return false;
    } while (!TextUtils.isEmpty(this.mSearchKey));
    return false;
  }
  
  public void setCountPerPager(int paramInt)
  {
    this.mCountPerPager = paramInt;
  }
  
  public void setCurrentPageNum(int paramInt)
  {
    this.mCurrentPageNum = paramInt;
    if (this.mCurrentPageNum == this.mPageCnt)
    {
      this.isLastPager = true;
      return;
    }
    this.isLastPager = false;
  }
  
  public void setDistrict(DistrictInfo paramDistrictInfo)
  {
    this.mDistrctInfo = paramDistrictInfo;
  }
  
  public void setLastPager(boolean paramBoolean)
  {
    this.isLastPager = paramBoolean;
  }
  
  public void setNetMode(int paramInt)
  {
    this.mNetMode = paramInt;
  }
  
  public void setPageCnt(int paramInt)
  {
    this.mPageCnt = paramInt;
  }
  
  public void setParPoiSize(int paramInt)
  {
    this.mParPoiSize = paramInt;
  }
  
  public void setPoiList(ArrayList<SearchPoi> paramArrayList)
  {
    if ((this.mPoiList != null) && (paramArrayList != null))
    {
      this.mPoiList.addAll(paramArrayList);
      return;
    }
    this.mPoiList = paramArrayList;
  }
  
  public void setSortType(int paramInt)
  {
    mSortType = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/SearchPoiPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */