package com.baidu.navi.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.core.i;
import com.baidu.carlife.util.r;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.favorite.util.FavoritePoiUtils;
import com.baidu.navi.fragment.carmode.CarModeFavoriteFragment;
import com.baidu.navi.interfaces.IFavoriteFragStatusListener;
import com.baidu.navi.interfaces.IFavoriteFragUiUpdateHandler;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FavoritePoisListAdapter
  extends BaseAdapter
{
  public static final long FIXED_ITEM_ID = 100L;
  private static final int MAX_LOAD_NUM = 20;
  public static final String TAG = FavoritePoisListAdapter.class.getSimpleName();
  private ViewHolder holder;
  private String mBduid = "";
  private IFavoriteFragStatusListener mFavoriteFragStatusListener;
  private IFavoriteFragUiUpdateHandler mFavoriteFragUiUpdateHandler;
  private FavoritePois mFavoritePois = FavoritePois.getPoiInstance();
  private List<FavItem> mFavoritesRecordList = new ArrayList();
  private boolean mHasNewData = true;
  private LayoutInflater mInflater;
  private boolean mIsEditable = false;
  private CarModeFavoriteFragment modeFavoriteFragment;
  
  public FavoritePoisListAdapter(Context paramContext, CarModeFavoriteFragment paramCarModeFavoriteFragment)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.mFavoritesRecordList = new ArrayList();
    this.modeFavoriteFragment = paramCarModeFavoriteFragment;
    this.mFavoriteFragStatusListener = new IFavoriteFragStatusListener()
    {
      public void clearListViewData()
      {
        FavoritePoisListAdapter.this.mFavoritesRecordList.clear();
      }
      
      public void editDisable()
      {
        FavoritePoisListAdapter.access$002(FavoritePoisListAdapter.this, false);
        FavoritePoisListAdapter.this.notifyDataSetChanged();
      }
      
      public void editEnable()
      {
        FavoritePoisListAdapter.access$002(FavoritePoisListAdapter.this, true);
        FavoritePoisListAdapter.this.notifyDataSetChanged();
      }
    };
  }
  
  /* Error */
  private int deleteFavItemByIndex(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: iload_1
    //   7: iflt +55 -> 62
    //   10: iload_3
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 68	com/baidu/navi/adapter/FavoritePoisListAdapter:mFavoritesRecordList	Ljava/util/List;
    //   16: ifnull +46 -> 62
    //   19: iload_3
    //   20: istore_2
    //   21: iload_1
    //   22: aload_0
    //   23: getfield 68	com/baidu/navi/adapter/FavoritePoisListAdapter:mFavoritesRecordList	Ljava/util/List;
    //   26: invokeinterface 133 1 0
    //   31: if_icmpge +31 -> 62
    //   34: aload_0
    //   35: getfield 68	com/baidu/navi/adapter/FavoritePoisListAdapter:mFavoritesRecordList	Ljava/util/List;
    //   38: iload_1
    //   39: invokeinterface 137 2 0
    //   44: checkcast 13	com/baidu/navi/adapter/FavoritePoisListAdapter$FavItem
    //   47: getfield 140	com/baidu/navi/adapter/FavoritePoisListAdapter$FavItem:mKey	Ljava/lang/String;
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 84	com/baidu/navi/adapter/FavoritePoisListAdapter:mFavoritePois	Lcom/baidu/navi/favorite/FavoritePois;
    //   56: aload 4
    //   58: invokevirtual 144	com/baidu/navi/favorite/FavoritePois:deleteFavPoi	(Ljava/lang/String;)Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifeq +9 -> 72
    //   66: iconst_1
    //   67: istore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_1
    //   71: ireturn
    //   72: iconst_0
    //   73: istore_1
    //   74: goto -6 -> 68
    //   77: astore 4
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	FavoritePoisListAdapter
    //   0	84	1	paramInt	int
    //   5	58	2	bool1	boolean
    //   3	17	3	bool2	boolean
    //   50	7	4	str	String
    //   77	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	77	finally
    //   21	62	77	finally
  }
  
  private ArrayList<FavItem> getFavDataFromDB(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "9999999999999";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramInt <= 100) {}
    }
    else
    {
      i = 20;
    }
    ArrayList localArrayList = new ArrayList();
    if (this.mFavoritePois == null) {}
    label317:
    for (;;)
    {
      return localArrayList;
      paramInt = 0;
      Object localObject = this.mFavoritePois;
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      paramString1 = ((FavoritePois)localObject).getFavPoiValidGenInfo(paramString2);
      if ((paramString1 != null) && (paramString1.size() > 0))
      {
        paramString1 = paramString1.iterator();
        for (;;)
        {
          if (!paramString1.hasNext()) {
            break label317;
          }
          paramString2 = (String)paramString1.next();
          if (paramString2.compareTo(str) < 0)
          {
            if (paramInt >= i) {
              break;
            }
            localObject = this.mFavoritePois.getFavPoiInfo(paramString2);
            if (localObject != null)
            {
              FavItem localFavItem = new FavItem(null);
              localFavItem.mKey = paramString2;
              localFavItem.mName = ((FavSyncPoi)localObject).poiName;
              localFavItem.mAddr = ((FavSyncPoi)localObject).content;
              localFavItem.mOriginUID = ((FavSyncPoi)localObject).poiId;
              if ((!TextUtils.isEmpty(localFavItem.mAddr)) || (!TextUtils.isEmpty(localFavItem.mName)))
              {
                if (((FavSyncPoi)localObject).pt != null) {
                  localFavItem.mGuidePoint = FavoritePoiUtils.mcTogcjPoint(((FavSyncPoi)localObject).pt);
                }
                if (!TextUtils.isEmpty(((FavSyncPoi)localObject).poiId)) {
                  localFavItem.mOriginUID = ((FavSyncPoi)localObject).poiId;
                }
                while (((FavSyncPoi)localObject).pt != null)
                {
                  localArrayList.add(localFavItem);
                  paramInt += 1;
                  i.b(TAG, localFavItem.toString() + " bduid:" + ((FavSyncPoi)localObject).bduid);
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private View getItemView(View paramView, int paramInt)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      this.holder = new ViewHolder();
      paramView = this.mInflater.inflate(2130968955, null);
      this.holder.poiInfoLayout = ((LinearLayout)paramView.findViewById(2131625837));
      this.holder.pointName = ((TextView)paramView.findViewById(2131625838));
      this.holder.pointDescription = ((TextView)paramView.findViewById(2131625839));
      this.holder.rightArrowIcon = ((ImageView)paramView.findViewById(2131625842));
      this.holder.deleteIcon = ((ImageView)paramView.findViewById(2131625841));
      this.holder.deleteLayout = ((LinearLayout)paramView.findViewById(2131625840));
      paramView.setTag(this.holder);
    }
    Object localObject;
    for (;;)
    {
      localObject = (FavItem)getItem(paramInt);
      if (localObject != null) {
        break;
      }
      return paramView;
      this.holder = ((ViewHolder)paramView.getTag());
    }
    if ((TextUtils.isEmpty(((FavItem)localObject).mName)) || (TextUtils.isEmpty(((FavItem)localObject).mAddr)))
    {
      this.holder.pointDescription.setVisibility(8);
      localObject = new LinearLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(60), 1.0F);
      this.holder.poiInfoLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      setupSkin();
      return paramView;
      this.holder.pointDescription.setVisibility(0);
      localObject = new LinearLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(80), 1.0F);
      this.holder.poiInfoLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void removeItemByIndex(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if ((this.mFavoritesRecordList != null) && (paramInt < this.mFavoritesRecordList.size())) {
        this.mFavoritesRecordList.remove(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void selectFavDataFromDB()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.mFavoritePois;
        if (localObject1 == null) {
          return;
        }
        if (NaviAccountUtils.getInstance().getUid() == null)
        {
          localObject1 = "";
          if (!this.mBduid.equals(localObject1))
          {
            this.mBduid = ((String)localObject1);
            cleanData();
          }
          String str2 = "9999999999999";
          if (this.mFavoritesRecordList.size() > 0) {
            str2 = ((FavItem)this.mFavoritesRecordList.get(this.mFavoritesRecordList.size() - 1)).mKey;
          }
          localObject1 = getFavDataFromDB(str2, 20, (String)localObject1);
          this.mFavoritesRecordList.addAll((Collection)localObject1);
          if (((ArrayList)localObject1).size() >= 20) {
            break label149;
          }
          this.mHasNewData = false;
          i.b(TAG, "没有更多数据");
          continue;
        }
        String str1 = NaviAccountUtils.getInstance().getUid();
      }
      finally {}
      continue;
      label149:
      this.mHasNewData = true;
      i.b(TAG, "还有数据");
    }
  }
  
  private void setItemContent(final int paramInt)
  {
    FavItem localFavItem = (FavItem)getItem(paramInt);
    if (localFavItem == null) {
      return;
    }
    if (!TextUtils.isEmpty(localFavItem.mName))
    {
      this.holder.pointName.setText(localFavItem.mName);
      if (!TextUtils.isEmpty(localFavItem.mAddr)) {
        this.holder.pointDescription.setText(localFavItem.mAddr);
      }
    }
    for (;;)
    {
      this.holder.deleteLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FavoritePoisListAdapter.this.deleteFavItemBackgroud(paramInt);
        }
      });
      if (!this.mIsEditable) {
        break;
      }
      this.holder.rightArrowIcon.setVisibility(8);
      this.holder.deleteIcon.setVisibility(0);
      this.holder.deleteLayout.setClickable(true);
      this.holder.deleteLayout.setBackgroundResource(2130838090);
      return;
      this.holder.pointDescription.setText("");
      continue;
      if (!TextUtils.isEmpty(localFavItem.mAddr))
      {
        this.holder.pointName.setText(localFavItem.mAddr);
        this.holder.pointDescription.setText("");
      }
      else
      {
        this.holder.pointName.setText("");
        this.holder.pointDescription.setText("");
      }
    }
    this.holder.deleteIcon.setVisibility(8);
    this.holder.rightArrowIcon.setVisibility(0);
    this.holder.deleteLayout.setClickable(false);
    this.holder.deleteLayout.setBackground(null);
  }
  
  private void setupSkin()
  {
    this.holder.pointName.setTextColor(r.a(2131558702));
    this.holder.pointDescription.setTextColor(r.a(2131558692));
  }
  
  public void cleanData()
  {
    if (this.mFavoritesRecordList != null) {
      this.mFavoritesRecordList.clear();
    }
  }
  
  public void deleteFavItemBackgroud(int paramInt)
  {
    new DeleteFavInfoTask(null).execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  public int getCount()
  {
    if (this.mFavoritesRecordList != null) {
      return this.mFavoritesRecordList.size();
    }
    return 0;
  }
  
  public IFavoriteFragStatusListener getFavoriteFragStatusListener()
  {
    return this.mFavoriteFragStatusListener;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mFavoritesRecordList != null) && (paramInt < this.mFavoritesRecordList.size())) {
      return this.mFavoritesRecordList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 100L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getItemView(paramView, paramInt);
    setItemContent(paramInt);
    return paramView;
  }
  
  public void setFavoriteFragUiUpdateHandler(IFavoriteFragUiUpdateHandler paramIFavoriteFragUiUpdateHandler)
  {
    this.mFavoriteFragUiUpdateHandler = paramIFavoriteFragUiUpdateHandler;
  }
  
  public void startCalcRoute(int paramInt)
  {
    FavItem localFavItem = (FavItem)getItem(paramInt);
    if (localFavItem == null) {
      return;
    }
    StatisticManager.onEvent("NAVI_0019", "NAVI_0019");
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mGuidePoint = localFavItem.mGuidePoint;
    localSearchPoi.mViewPoint = localFavItem.mGuidePoint;
    localSearchPoi.mAddress = localFavItem.mAddr;
    localSearchPoi.mName = localFavItem.mName;
    localSearchPoi.mOriginUID = localFavItem.mOriginUID;
    NavPoiController.getInstance().startCalcRoute(localSearchPoi);
  }
  
  public void updateData()
  {
    new GetFavInfoTask(null).execute(new Integer[0]);
  }
  
  private class DeleteFavInfoTask
    extends AsyncTask<Integer, Void, Integer>
  {
    private int index;
    
    private DeleteFavInfoTask() {}
    
    protected Integer doInBackground(Integer... paramVarArgs)
    {
      this.index = paramVarArgs[0].intValue();
      int i = FavoritePoisListAdapter.this.deleteFavItemByIndex(this.index);
      if (i == 1) {
        FavoritePoisListAdapter.this.removeItemByIndex(this.index);
      }
      return Integer.valueOf(i);
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      FavoritePoisListAdapter.this.notifyDataSetChanged();
    }
  }
  
  private class FavItem
  {
    public String mAddr;
    public GeoPoint mGuidePoint;
    public String mKey;
    public String mName;
    public String mOriginUID;
    
    private FavItem() {}
    
    public String toString()
    {
      return "FavItem[key:" + this.mKey + ", name:" + this.mName + ", addr:" + this.mAddr + ", originUID:" + this.mOriginUID + ", guidePoint:" + this.mGuidePoint + "]";
    }
  }
  
  private class GetFavInfoTask
    extends AsyncTask<Integer, Void, Integer>
  {
    private GetFavInfoTask() {}
    
    protected Integer doInBackground(Integer... paramVarArgs)
    {
      FavoritePoisListAdapter.this.selectFavDataFromDB();
      return Integer.valueOf(0);
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      if (!FavoritePoisListAdapter.this.mHasNewData)
      {
        if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
          FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.footerShowNoMore();
        }
        if (!FavoritePoisListAdapter.this.mFavoritesRecordList.isEmpty()) {
          break label156;
        }
        if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null)
        {
          FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.hideEditBtn();
          FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.hideLoadMoreFooter();
        }
      }
      for (;;)
      {
        FavoritePoisListAdapter.this.notifyDataSetChanged();
        if (FavoritePoisListAdapter.this.modeFavoriteFragment != null) {
          FavoritePoisListAdapter.this.modeFavoriteFragment.onInitFocusAreas();
        }
        if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null) {
          FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.syncEnd();
        }
        return;
        if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler == null) {
          break;
        }
        FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.footerShowLoadMore();
        break;
        label156:
        if (FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler != null)
        {
          FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.showEditBtn();
          FavoritePoisListAdapter.this.mFavoriteFragUiUpdateHandler.showLoadMoreFooter();
        }
      }
    }
  }
  
  public static class ViewHolder
  {
    public ImageView deleteIcon;
    public LinearLayout deleteLayout;
    public LinearLayout poiInfoLayout;
    public TextView pointDescription;
    public TextView pointName;
    public ImageView rightArrowIcon;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/FavoritePoisListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */