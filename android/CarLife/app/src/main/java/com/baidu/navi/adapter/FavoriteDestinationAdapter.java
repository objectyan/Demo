package com.baidu.navi.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.FavoriteDestinationController.FavoriteDestResultCallBack;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.db.DBManager.DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviFavoriteDestModel;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDestinationAdapter
  extends BaseAdapter
{
  private FavoriteDestinationController.FavoriteDestResultCallBack callBack = new FavoriteDestinationController.FavoriteDestResultCallBack()
  {
    public void onAddResult(boolean paramAnonymousBoolean)
    {
      FavoriteDestinationAdapter.this.notifyDataUpdate();
    }
    
    public void onCheckResult(boolean paramAnonymousBoolean) {}
    
    public void onCleanResult(boolean paramAnonymousBoolean)
    {
      FavoriteDestinationAdapter.this.notifyDataUpdate();
    }
    
    public void onRemoveResult(boolean paramAnonymousBoolean)
    {
      FavoriteDestinationAdapter.this.notifyDataUpdate();
    }
  };
  ViewHolder holder;
  private boolean isCompSetting = false;
  private boolean isHomeSetting = false;
  private DBManager.DBOperateResultCallback mCallback = new DBManager.DBOperateResultCallback()
  {
    public void onAddOrDeleteSuccess() {}
    
    public void onQuerySuccess()
    {
      FavoriteDestinationAdapter.this.notifyDataUpdate();
    }
  };
  protected RoutePlanNode mCompany;
  private Context mContext;
  private List<RoutePlanNode> mDataList = new ArrayList();
  protected RoutePlanNode mFamily;
  private LayoutInflater mInflater;
  private e mOnDialogListener;
  private RoutePlanNode mRoutePlanNode;
  
  public FavoriteDestinationAdapter(Context paramContext, e parame)
  {
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mContext = paramContext;
    this.mOnDialogListener = parame;
    if (!NaviFavoriteDestModel.getInstance().checkIsQueryDB()) {
      FavoriteDestinationController.getInstance().queryAllFavoriteDestFromDB(this.mCallback);
    }
    updateAddr();
  }
  
  private void cleanAllHistoryDesPoi()
  {
    FavoriteDestinationController.getInstance().cleanAllFavoriteDest(this.callBack);
  }
  
  private void delCompAddress()
  {
    if (this.mContext == null) {
      return;
    }
    if (AddressSettingModel.removeCompAddress(this.mContext))
    {
      com.baidu.carlife.logic.codriver.adapter.b.a().b();
      TipTool.onCreateToastDialog(this.mContext, 2131296414);
      this.isCompSetting = false;
      notifyHistoryDataSetChanged();
      return;
    }
    TipTool.onCreateToastDialog(this.mContext, 2131296413);
  }
  
  private void delHomeAddress()
  {
    if (this.mContext == null) {
      return;
    }
    if (AddressSettingModel.removeHomeAddress(this.mContext))
    {
      com.baidu.carlife.logic.codriver.adapter.b.a().c();
      TipTool.onCreateToastDialog(this.mContext, 2131296416);
      this.isHomeSetting = false;
      notifyHistoryDataSetChanged();
      return;
    }
    TipTool.onCreateToastDialog(this.mContext, 2131296415);
  }
  
  private void delRoutePlanHistoryItem(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((paramInt == 0) && (this.mFamily != null)) {
      delHomeAddress();
    }
    for (;;)
    {
      StatisticManager.onEvent("1048", "1048");
      return;
      if ((paramInt == 1) && (this.mCompany != null))
      {
        delCompAddress();
      }
      else if ((this.mDataList == null) || (this.mDataList.size() > paramInt - 2))
      {
        RoutePlanNode localRoutePlanNode = (RoutePlanNode)this.mDataList.get(paramInt - 2);
        FavoriteDestinationController.getInstance().deleteFavoriteDestFromDB(localRoutePlanNode, this.callBack);
      }
    }
  }
  
  private View getItemView(View paramView, int paramInt)
  {
    label149:
    LinearLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      this.holder = new ViewHolder();
      paramView = this.mInflater.inflate(2130968954, null);
      this.holder.poiInfoLayout = ((LinearLayout)paramView.findViewById(2131625837));
      this.holder.pointName = ((TextView)paramView.findViewById(2131625838));
      this.holder.pointDescription = ((TextView)paramView.findViewById(2131625839));
      this.holder.deleteIcon = ((ImageView)paramView.findViewById(2131625841));
      this.holder.deleteLayout = ((LinearLayout)paramView.findViewById(2131625840));
      this.holder.line = paramView.findViewById(2131624067);
      paramView.setTag(this.holder);
      if (paramInt != getCount() - 1) {
        break label288;
      }
      this.holder.line.setVisibility(8);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label302;
      }
      this.holder.pointDescription.setVisibility(0);
      this.holder.deleteLayout.setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(80), 1.0F);
      this.holder.poiInfoLayout.setLayoutParams(localLayoutParams);
      label211:
      setupSkin();
      if (!h.a().getNaviFragmentManager().isDriving()) {
        break label372;
      }
      if (isClickEnabled(paramInt)) {
        break label358;
      }
      this.holder.poiInfoLayout.setAlpha(0.2F);
    }
    for (;;)
    {
      this.holder.deleteLayout.setAlpha(0.2F);
      this.holder.deleteLayout.setEnabled(false);
      return paramView;
      this.holder = ((ViewHolder)paramView.getTag());
      break;
      label288:
      this.holder.line.setVisibility(0);
      break label149;
      label302:
      this.holder.pointDescription.setVisibility(8);
      this.holder.deleteLayout.setVisibility(0);
      localLayoutParams = new LinearLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(60), 1.0F);
      this.holder.poiInfoLayout.setLayoutParams(localLayoutParams);
      break label211;
      label358:
      this.holder.poiInfoLayout.setAlpha(1.0F);
    }
    label372:
    this.holder.poiInfoLayout.setAlpha(1.0F);
    this.holder.deleteLayout.setAlpha(1.0F);
    this.holder.deleteLayout.setEnabled(true);
    return paramView;
  }
  
  private boolean isClickEnabled(int paramInt)
  {
    if (h.a().getNaviFragmentManager().isDriving())
    {
      if ((paramInt == 0) && ((!AddressSettingModel.hasSetHomeAddr(this.mContext)) || (this.mFamily == null))) {}
      while ((paramInt == 1) && ((!AddressSettingModel.hasSetCompAddr(this.mContext)) || (this.mCompany == null))) {
        return false;
      }
      return true;
    }
    return true;
  }
  
  private void setItemContent(final int paramInt)
  {
    if (this.mContext == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.holder.pointName.setText(this.mContext.getString(2131296476));
      if ((AddressSettingModel.hasSetHomeAddr(this.mContext)) && (this.mFamily != null))
      {
        this.holder.pointDescription.setText(this.mFamily.mName);
        this.holder.deleteLayout.setVisibility(0);
        this.isHomeSetting = true;
      }
    }
    for (;;)
    {
      this.holder.deleteLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (paramInt > 1)
          {
            FavoriteDestinationAdapter.this.delRoutePlanHistoryItem(paramInt);
            return;
          }
          FavoriteDestinationAdapter.this.showDelHistoryItemDialog(paramInt);
        }
      });
      return;
      this.holder.pointDescription.setText(this.mContext.getString(2131297171));
      continue;
      if (paramInt == 1)
      {
        this.holder.pointName.setText(this.mContext.getString(2131296477));
        if ((AddressSettingModel.hasSetCompAddr(this.mContext)) && (this.mCompany != null))
        {
          this.holder.pointDescription.setText(this.mCompany.mName);
          this.holder.deleteLayout.setVisibility(0);
          this.isCompSetting = true;
        }
        else
        {
          this.holder.pointDescription.setText(this.mContext.getString(2131297171));
        }
      }
      else
      {
        this.mRoutePlanNode = ((RoutePlanNode)getItem(paramInt));
        if (this.mRoutePlanNode == null) {
          break;
        }
        if (TextUtils.isEmpty(this.mRoutePlanNode.mName)) {
          this.holder.pointName.setText("");
        } else {
          this.holder.pointName.setText(this.mRoutePlanNode.mName);
        }
      }
    }
  }
  
  private void setupSkin()
  {
    this.holder.pointName.setTextColor(r.a(2131558702));
    this.holder.pointDescription.setTextColor(r.a(2131558692));
  }
  
  private void showDelHistoryItemDialog(final int paramInt)
  {
    if (this.mContext == null) {
      return;
    }
    int i = 0;
    if (paramInt == 0) {
      i = 2131296269;
    }
    for (;;)
    {
      c localc = new c(this.mContext).a(i).g(17).c(2131296264).q().d(2131296259);
      localc.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          FavoriteDestinationAdapter.this.delRoutePlanHistoryItem(paramInt);
        }
      });
      this.mOnDialogListener.showDialog(localc);
      return;
      if (paramInt == 1) {
        i = 2131296268;
      }
    }
  }
  
  public int getCount()
  {
    if (this.mDataList == null) {
      return 2;
    }
    return this.mDataList.size() + 2;
  }
  
  public RoutePlanNode getDate(int paramInt)
  {
    LogUtil.e("navi_favorite dest", paramInt + " position:  " + paramInt);
    if (paramInt < 0) {}
    do
    {
      return null;
      if ((paramInt == 0) && (this.mFamily != null)) {
        return this.mFamily;
      }
      if ((paramInt == 1) && (this.mCompany != null)) {
        return this.mCompany;
      }
    } while ((this.mDataList != null) && (this.mDataList.size() <= paramInt - 2));
    return (RoutePlanNode)this.mDataList.get(paramInt - 2);
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mDataList == null) {}
    do
    {
      return null;
      if (paramInt == 0) {
        return this.mFamily;
      }
      if (paramInt == 1) {
        return this.mCompany;
      }
      paramInt -= 2;
    } while (paramInt >= this.mDataList.size());
    return this.mDataList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getItemView(paramView, paramInt);
    setItemContent(paramInt);
    return paramView;
  }
  
  public boolean isBack()
  {
    boolean bool = true;
    if ((this.isHomeSetting == true) || (this.isCompSetting == true)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return isClickEnabled(paramInt);
  }
  
  public void notifyDataUpdate()
  {
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        FavoriteDestinationAdapter.this.notifyHistoryDataSetChanged();
      }
    });
  }
  
  public void notifyHistoryDataSetChanged()
  {
    this.mDataList = NaviFavoriteDestModel.getInstance().getRoutePlanNode();
    updateAddr();
    notifyDataSetChanged();
  }
  
  public void showCleanAllHistoryDialog()
  {
    c localc = new c(this.mContext).a(2131296261).g(17).c(2131296260).q().d(2131296259);
    localc.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        FavoriteDestinationAdapter.this.cleanAllHistoryDesPoi();
      }
    });
    this.mOnDialogListener.showDialog(localc);
  }
  
  public void updateAddr()
  {
    this.mFamily = AddressSettingModel.getHomeAddrNode(BNaviModuleManager.getContext());
    this.mCompany = AddressSettingModel.getCompAddrNode(BNaviModuleManager.getContext());
  }
  
  public static class ViewHolder
  {
    public ImageView deleteIcon;
    public LinearLayout deleteLayout;
    public View line;
    public LinearLayout poiInfoLayout;
    public TextView pointDescription;
    public TextView pointName;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/FavoriteDestinationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */