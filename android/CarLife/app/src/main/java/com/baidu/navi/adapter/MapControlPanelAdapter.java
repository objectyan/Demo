package com.baidu.navi.adapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import java.util.List;

public class MapControlPanelAdapter
  extends BaseAdapter
{
  private String[] items;
  private Activity mActivity;
  private boolean mHasFavorite = false;
  
  public MapControlPanelAdapter(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.items = StyleManager.getStringArray(2131230730);
  }
  
  private boolean isClickEnabled(int paramInt)
  {
    return true;
  }
  
  public int getCount()
  {
    return this.items.length;
  }
  
  public String getItem(int paramInt)
  {
    return this.items[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      paramView = LayoutInflater.from(this.mActivity).inflate(2130968920, paramViewGroup, false);
      ((TextView)paramView.findViewById(2131625613)).setText(getItem(paramInt));
      return paramView;
    }
    paramView = LayoutInflater.from(this.mActivity).inflate(2130968921, paramViewGroup, false);
    ((TextView)paramView.findViewById(2131625614)).setText(getItem(paramInt));
    paramViewGroup = (SwitchButton)paramView.findViewById(2131624581);
    paramViewGroup.setChecked(BNSettingManager.isRoadCondOnOrOff());
    paramViewGroup.setClickable(false);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return isClickEnabled(paramInt);
  }
  
  public void updateFavoriteItem()
  {
    new CheckFavoriteCountTask(null).execute(new Void[0]);
  }
  
  private class CheckFavoriteCountTask
    extends AsyncTask<Void, Void, Boolean>
  {
    private CheckFavoriteCountTask() {}
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = FavoritePois.getPoiInstance().getFavPoiValidGenInfo(NaviAccountUtils.getInstance().getUid());
      if ((paramVarArgs != null) && (paramVarArgs.size() > 0))
      {
        MapControlPanelAdapter.access$102(MapControlPanelAdapter.this, true);
        return Boolean.valueOf(true);
      }
      MapControlPanelAdapter.access$102(MapControlPanelAdapter.this, false);
      return Boolean.valueOf(false);
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      if (MapControlPanelAdapter.this.mActivity == null) {
        return;
      }
      MapControlPanelAdapter.this.mActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          MapControlPanelAdapter.this.notifyDataSetChanged();
        }
      });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/MapControlPanelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */