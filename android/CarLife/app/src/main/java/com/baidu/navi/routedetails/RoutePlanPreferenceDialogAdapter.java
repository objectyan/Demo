package com.baidu.navi.routedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import java.util.ArrayList;

public class RoutePlanPreferenceDialogAdapter extends BaseAdapter {
    private static final String TAG = "RoutePlanPreferenceDialogAdapter";
    private Context mContext;
    private OnItemClickListener mOnItemClickListener = new C39541();
    private RoutePlanModel mRoutePlanModel = null;
    private ArrayList<RGRouteSortModel> routeSortList;

    /* renamed from: com.baidu.navi.routedetails.RoutePlanPreferenceDialogAdapter$1 */
    class C39541 implements OnItemClickListener {
        C39541() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (RoutePlanPreferenceDialogAdapter.this.routeSortList != null && RoutePlanPreferenceDialogAdapter.this.routeSortList.size() > position && RoutePlanPreferenceDialogAdapter.this.routeSortList.size() >= 0) {
                RGRouteSortModel model = (RGRouteSortModel) RoutePlanPreferenceDialogAdapter.this.routeSortList.get(position);
                if (model != null) {
                    int preferValue;
                    boolean isPreferChange;
                    if ((RGRouteSortController.getInstance().getPreferValue() & 32) != 0) {
                        preferValue = model.mPreferValue | 32;
                    } else {
                        preferValue = model.mPreferValue;
                    }
                    if (preferValue != RGRouteSortController.getInstance().getPreferValue()) {
                        isPreferChange = true;
                    } else {
                        isPreferChange = false;
                    }
                    BNaviModuleManager.setLastPreferValue(preferValue);
                    BNSettingManager.setDefaultRouteSort(preferValue);
                    RGRouteSortController.getInstance().setPreferValue(preferValue);
                    BNRoutePlaner.getInstance().setCalcPrference(preferValue);
                    if (isPreferChange && RoutePlanPreferenceDialogAdapter.this.mRoutePlanModel != null) {
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(RoutePlanPreferenceDialogAdapter.this.mRoutePlanModel.getRouteInput(), 0);
                    }
                }
            }
        }
    }

    private static class ViewHolder {
        ImageView ivItemCheck;
        View line;
        TextView tvItemName;

        private ViewHolder() {
        }
    }

    public RoutePlanPreferenceDialogAdapter(Context context) {
        this.mContext = context;
        this.routeSortList = RGRouteSortController.getInstance().getRouteSortList();
        this.mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
    }

    public int getCount() {
        this.routeSortList = RGRouteSortController.getInstance().getRouteSortList();
        if (this.routeSortList == null) {
            return 0;
        }
        return this.routeSortList.size();
    }

    public Object getItem(int position) {
        if (this.routeSortList == null || this.routeSortList.size() <= position) {
            return null;
        }
        return this.routeSortList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder cache = new ViewHolder();
        convertView = LayoutInflater.from(this.mContext).inflate(C0965R.layout.routeplan_preference_list_item, null);
        cache.tvItemName = (TextView) convertView.findViewById(C0965R.id.tv_item_name);
        cache.line = convertView.findViewById(C0965R.id.cl_line);
        cache.ivItemCheck = (ImageView) convertView.findViewById(C0965R.id.iv_item_check);
        if (this.routeSortList != null && position >= 0 && position < this.routeSortList.size()) {
            RGRouteSortModel model = (RGRouteSortModel) this.routeSortList.get(position);
            if (model != null) {
                cache.tvItemName.setText(model.mItemName);
                cache.ivItemCheck.setVisibility((model.mPreferValue & RGRouteSortController.getInstance().getPreferValue()) != 0 ? 0 : 8);
            }
        }
        return convertView;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }
}
