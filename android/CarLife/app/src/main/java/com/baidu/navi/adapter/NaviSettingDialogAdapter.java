package com.baidu.navi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;

public class NaviSettingDialogAdapter extends BaseAdapter {
    private Context mContext;
    private ImageView sbCar3d;
    private SwitchButton sbIts;
    private ImageView sbNorth2d;
    private SwitchButton sbPlayMode;

    private static class ViewHolder {
        View line;
        ImageView north2dorcar3dicon;
        TextView tv_item_name;
        TextView tv_item_name2;

        private ViewHolder() {
        }
    }

    public NaviSettingDialogAdapter(Context context) {
        this.mContext = context;
    }

    public int getCount() {
        return 4;
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int pos, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(this.mContext).inflate(C0965R.layout.innavi_setting_list_item, null);
        ViewHolder cache = new ViewHolder();
        cache.north2dorcar3dicon = (ImageView) convertView.findViewById(C0965R.id.north2dorcar3dicon);
        cache.tv_item_name = (TextView) convertView.findViewById(C0965R.id.tv_item_name);
        cache.tv_item_name2 = (TextView) convertView.findViewById(C0965R.id.tv_item_name2);
        cache.line = convertView.findViewById(C0965R.id.cl_line);
        initContet(pos, convertView, cache);
        return convertView;
    }

    private void initContet(int pos, View convertView, ViewHolder cache) {
        if (pos == 0) {
            cache.north2dorcar3dicon.setBackgroundResource(C0965R.drawable.map_ic_navigating_set_orientation);
            cache.tv_item_name.setText(C0965R.string.map_in_navi_setting_car3d);
            cache.tv_item_name.setVisibility(0);
            cache.tv_item_name2.setVisibility(8);
            cache.line.setVisibility(8);
            this.sbCar3d = (ImageView) convertView.findViewById(C0965R.id.checkicon);
            this.sbCar3d.setVisibility(0);
            updateView(0);
        } else if (pos == 1) {
            cache.north2dorcar3dicon.setBackgroundResource(C0965R.drawable.map_ic_navigating_set_north);
            cache.tv_item_name.setText(C0965R.string.map_in_navi_setting_north2d);
            cache.tv_item_name.setVisibility(0);
            cache.tv_item_name2.setVisibility(8);
            cache.line.setVisibility(0);
            this.sbNorth2d = (ImageView) convertView.findViewById(C0965R.id.checkicon);
            this.sbNorth2d.setVisibility(0);
            updateView(1);
        } else if (pos == 2) {
            cache.north2dorcar3dicon.setVisibility(8);
            cache.tv_item_name2.setText(C0965R.string.map_in_navi_setting_route_its);
            cache.tv_item_name.setVisibility(8);
            cache.tv_item_name2.setVisibility(0);
            cache.line.setVisibility(0);
            this.sbIts = (SwitchButton) convertView.findViewById(C0965R.id.sw_01);
            this.sbIts.setVisibility(0);
            updateView(2);
        } else if (pos == 3) {
            cache.north2dorcar3dicon.setVisibility(8);
            cache.tv_item_name2.setText(C0965R.string.map_in_navi_setting_route_voice_play_mode);
            cache.tv_item_name.setVisibility(8);
            cache.tv_item_name2.setVisibility(0);
            cache.line.setVisibility(0);
            this.sbPlayMode = (SwitchButton) convertView.findViewById(C0965R.id.sw_01);
            this.sbPlayMode.setVisibility(0);
            updateView(3);
        }
    }

    public void updateView(int pos) {
        int i = C0965R.drawable.map_ic_navigating_set_selected;
        boolean z = true;
        String map2DOr3DState = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
        if (pos == 0 || pos == 1) {
            if (!(map2DOr3DState == null || this.sbCar3d == null)) {
                this.sbCar3d.setBackgroundResource(map2DOr3DState == FsmState.Car3D ? C0965R.drawable.map_ic_navigating_set_selected : C0965R.drawable.map_ic_navigating_set_unchecked);
            }
            if (map2DOr3DState != null && this.sbNorth2d != null) {
                ImageView imageView = this.sbNorth2d;
                if (map2DOr3DState != FsmState.North2D) {
                    i = C0965R.drawable.map_ic_navigating_set_unchecked;
                }
                imageView.setBackgroundResource(i);
            }
        } else if (pos == 2 && this.sbIts != null) {
            this.sbIts.setChecked(BNSettingManager.isRoadCondOnOrOff());
        } else if (pos == 3 && this.sbPlayMode != null) {
            SwitchButton switchButton = this.sbPlayMode;
            if (C1915a.a().g()) {
                z = false;
            }
            switchButton.setChecked(z);
        }
    }
}
