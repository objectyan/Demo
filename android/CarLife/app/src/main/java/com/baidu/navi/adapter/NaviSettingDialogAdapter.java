package com.baidu.navi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.m.a;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;

public class NaviSettingDialogAdapter
  extends BaseAdapter
{
  private Context mContext;
  private ImageView sbCar3d;
  private SwitchButton sbIts;
  private ImageView sbNorth2d;
  private SwitchButton sbPlayMode;
  
  public NaviSettingDialogAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void initContet(int paramInt, View paramView, ViewHolder paramViewHolder)
  {
    if (paramInt == 0)
    {
      paramViewHolder.north2dorcar3dicon.setBackgroundResource(2130838906);
      paramViewHolder.tv_item_name.setText(2131296571);
      paramViewHolder.tv_item_name.setVisibility(0);
      paramViewHolder.tv_item_name2.setVisibility(8);
      paramViewHolder.line.setVisibility(8);
      this.sbCar3d = ((ImageView)paramView.findViewById(2131625278));
      this.sbCar3d.setVisibility(0);
      updateView(0);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        paramViewHolder.north2dorcar3dicon.setBackgroundResource(2130838905);
        paramViewHolder.tv_item_name.setText(2131296572);
        paramViewHolder.tv_item_name.setVisibility(0);
        paramViewHolder.tv_item_name2.setVisibility(8);
        paramViewHolder.line.setVisibility(0);
        this.sbNorth2d = ((ImageView)paramView.findViewById(2131625278));
        this.sbNorth2d.setVisibility(0);
        updateView(1);
        return;
      }
      if (paramInt == 2)
      {
        paramViewHolder.north2dorcar3dicon.setVisibility(8);
        paramViewHolder.tv_item_name2.setText(2131296573);
        paramViewHolder.tv_item_name.setVisibility(8);
        paramViewHolder.tv_item_name2.setVisibility(0);
        paramViewHolder.line.setVisibility(0);
        this.sbIts = ((SwitchButton)paramView.findViewById(2131625277));
        this.sbIts.setVisibility(0);
        updateView(2);
        return;
      }
    } while (paramInt != 3);
    paramViewHolder.north2dorcar3dicon.setVisibility(8);
    paramViewHolder.tv_item_name2.setText(2131296574);
    paramViewHolder.tv_item_name.setVisibility(8);
    paramViewHolder.tv_item_name2.setVisibility(0);
    paramViewHolder.line.setVisibility(0);
    this.sbPlayMode = ((SwitchButton)paramView.findViewById(2131625277));
    this.sbPlayMode.setVisibility(0);
    updateView(3);
  }
  
  public int getCount()
  {
    return 4;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.mContext).inflate(2130968843, null);
    paramViewGroup = new ViewHolder(null);
    paramViewGroup.north2dorcar3dicon = ((ImageView)paramView.findViewById(2131625275));
    paramViewGroup.tv_item_name = ((TextView)paramView.findViewById(2131624662));
    paramViewGroup.tv_item_name2 = ((TextView)paramView.findViewById(2131625276));
    paramViewGroup.line = paramView.findViewById(2131624067);
    initContet(paramInt, paramView, paramViewGroup);
    return paramView;
  }
  
  public void updateView(int paramInt)
  {
    int i = 2130838907;
    boolean bool = true;
    Object localObject = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
    if ((paramInt == 0) || (paramInt == 1))
    {
      ImageView localImageView;
      if ((localObject != null) && (this.sbCar3d != null))
      {
        localImageView = this.sbCar3d;
        if (localObject == "Car3D")
        {
          paramInt = 2130838907;
          localImageView.setBackgroundResource(paramInt);
        }
      }
      else if ((localObject != null) && (this.sbNorth2d != null))
      {
        localImageView = this.sbNorth2d;
        if (localObject != "North2D") {
          break label96;
        }
        paramInt = i;
        label83:
        localImageView.setBackgroundResource(paramInt);
      }
    }
    label96:
    do
    {
      return;
      paramInt = 2130838908;
      break;
      paramInt = 2130838908;
      break label83;
      if ((paramInt == 2) && (this.sbIts != null))
      {
        this.sbIts.setChecked(BNSettingManager.isRoadCondOnOrOff());
        return;
      }
    } while ((paramInt != 3) || (this.sbPlayMode == null));
    localObject = this.sbPlayMode;
    if (!a.a().g()) {}
    for (;;)
    {
      ((SwitchButton)localObject).setChecked(bool);
      return;
      bool = false;
    }
  }
  
  private static class ViewHolder
  {
    View line;
    ImageView north2dorcar3dicon;
    TextView tv_item_name;
    TextView tv_item_name2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/NaviSettingDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */