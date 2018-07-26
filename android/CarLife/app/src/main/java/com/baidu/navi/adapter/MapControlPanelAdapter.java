package com.baidu.navi.adapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import java.util.List;

public class MapControlPanelAdapter extends BaseAdapter {
    private String[] items;
    private Activity mActivity;
    private boolean mHasFavorite = false;

    private class CheckFavoriteCountTask extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: com.baidu.navi.adapter.MapControlPanelAdapter$CheckFavoriteCountTask$1 */
        class C36441 implements Runnable {
            C36441() {
            }

            public void run() {
                MapControlPanelAdapter.this.notifyDataSetChanged();
            }
        }

        private CheckFavoriteCountTask() {
        }

        protected Boolean doInBackground(Void... params) {
            List<String> data = FavoritePois.getPoiInstance().getFavPoiValidGenInfo(NaviAccountUtils.getInstance().getUid());
            if (data == null || data.size() <= 0) {
                MapControlPanelAdapter.this.mHasFavorite = false;
                return Boolean.valueOf(false);
            }
            MapControlPanelAdapter.this.mHasFavorite = true;
            return Boolean.valueOf(true);
        }

        protected void onPostExecute(Boolean flag) {
            if (MapControlPanelAdapter.this.mActivity != null) {
                MapControlPanelAdapter.this.mActivity.runOnUiThread(new C36441());
            }
        }
    }

    public MapControlPanelAdapter(Activity activity) {
        this.mActivity = activity;
        this.items = StyleManager.getStringArray(C0965R.array.map_ctrl_menu_item);
    }

    public int getCount() {
        return this.items.length;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int position) {
        return position == 1 ? 1 : 0;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public String getItem(int position) {
        return this.items[position];
    }

    public View getView(int position, View convertView, ViewGroup root) {
        if (getItemViewType(position) == 0) {
            convertView = LayoutInflater.from(this.mActivity).inflate(C0965R.layout.map_control_panel_list_item, root, false);
            ((TextView) convertView.findViewById(C0965R.id.map_control_panel_list_item_tv)).setText(getItem(position));
            return convertView;
        }
        convertView = LayoutInflater.from(this.mActivity).inflate(C0965R.layout.map_control_panel_list_item_its, root, false);
        ((TextView) convertView.findViewById(C0965R.id.map_control_panel_list_item_its_tv)).setText(getItem(position));
        SwitchButton switchButton = (SwitchButton) convertView.findViewById(C0965R.id.map_control_panel_list_item_its_checkbox);
        switchButton.setChecked(BNSettingManager.isRoadCondOnOrOff());
        switchButton.setClickable(false);
        return convertView;
    }

    public boolean isEnabled(int position) {
        return isClickEnabled(position);
    }

    private boolean isClickEnabled(int position) {
        return true;
    }

    public void updateFavoriteItem() {
        new CheckFavoriteCountTask().execute(new Void[0]);
    }
}
