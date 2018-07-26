package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.routereport.BNRouteReportModel.RouteReportItem;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RouteReportTextListAdapter extends BaseAdapter {
    private static final String TAG = RouteReportImgListAdapter.class.getSimpleName();
    private GridView mBindedView;
    private GridViewCallback mCallback;
    private Activity mContext;
    private int mCurrentSelectedItem = -1;
    private ArrayList<RouteReportItem> mRouteReportItemsList;

    public interface GridViewCallback {
        void onItemClick(int i, RouteReportItem routeReportItem);
    }

    /* renamed from: com.baidu.navisdk.module.routereport.RouteReportTextListAdapter$1 */
    class C41861 implements OnClickListener {
        C41861() {
        }

        public void onClick(View v) {
            ViewHolder mViewHolder = (ViewHolder) v.getTag();
            LogUtil.m15791e(RouteReportTextListAdapter.TAG, "onClick: item --> " + mViewHolder.position + ", mCurrentSelectedItem = " + RouteReportTextListAdapter.this.mCurrentSelectedItem);
            if (mViewHolder.position >= 0 && mViewHolder.position < RouteReportTextListAdapter.this.mRouteReportItemsList.size()) {
                RouteReportItem item = (RouteReportItem) RouteReportTextListAdapter.this.mRouteReportItemsList.get(mViewHolder.position);
                if (RouteReportTextListAdapter.this.mCallback != null) {
                    RouteReportTextListAdapter.this.mCallback.onItemClick(mViewHolder.position, item);
                }
                if (item.mIsSubType && mViewHolder.position != RouteReportTextListAdapter.this.mCurrentSelectedItem) {
                    if (RouteReportTextListAdapter.this.mBindedView != null && RouteReportTextListAdapter.this.mCurrentSelectedItem >= 0 && RouteReportTextListAdapter.this.mCurrentSelectedItem < RouteReportTextListAdapter.this.mRouteReportItemsList.size()) {
                        ViewHolder currentViewHolder = (ViewHolder) RouteReportTextListAdapter.this.mBindedView.getChildAt(RouteReportTextListAdapter.this.mCurrentSelectedItem).getTag();
                        currentViewHolder.setSuperscriptShow(false);
                        currentViewHolder.mTextView.setTextColor(Color.parseColor("#333333"));
                        currentViewHolder.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.route_report_grid_item_bg_normal));
                    }
                    mViewHolder.setSuperscriptShow(true);
                    mViewHolder.mTextView.setTextColor(Color.parseColor("#3385ff"));
                    mViewHolder.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.route_report_grid_item_bg_selected));
                }
                RouteReportTextListAdapter.this.mCurrentSelectedItem = mViewHolder.position;
            }
        }
    }

    public static class ViewHolder {
        public View mGridContainer;
        public ImageView mSuperscript;
        public TextView mTextView;
        public int position;

        public void setSuperscriptShow(boolean show) {
            if (this.mSuperscript != null) {
                this.mSuperscript.setVisibility(show ? 0 : 8);
            }
        }
    }

    public RouteReportTextListAdapter(Activity mContext, ArrayList<RouteReportItem> mRouteReportItemsList, GridViewCallback callback) {
        this.mContext = mContext;
        this.mRouteReportItemsList = mRouteReportItemsList;
        this.mCallback = callback;
    }

    public void setBindedView(GridView bindedView) {
        this.mBindedView = bindedView;
    }

    public int getCount() {
        return this.mRouteReportItemsList.size();
    }

    public Object getItem(int position) {
        return this.mRouteReportItemsList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = JarUtils.inflate(this.mContext, C4048R.layout.nsdk_layout_route_report_text_grid_item, null);
            if (convertView == null) {
                return null;
            }
            holder = new ViewHolder();
            holder.mGridContainer = convertView.findViewById(C4048R.id.grid_container);
            holder.mTextView = (TextView) convertView.findViewById(C4048R.id.grid_title);
            holder.mSuperscript = (ImageView) convertView.findViewById(C4048R.id.grid_superscript);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.position = position;
        if (this.mRouteReportItemsList != null && this.mRouteReportItemsList.size() > position) {
            RouteReportItem mUgcBaseDataModel = (RouteReportItem) this.mRouteReportItemsList.get(position);
            if (mUgcBaseDataModel != null) {
                holder.mTextView.setText(mUgcBaseDataModel.mTitle == null ? "" : mUgcBaseDataModel.mTitle);
            }
        }
        if (position == this.mCurrentSelectedItem) {
            holder.setSuperscriptShow(true);
            holder.mTextView.setTextColor(Color.parseColor("#3385ff"));
            holder.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.route_report_grid_item_bg_selected));
        } else {
            holder.setSuperscriptShow(false);
            holder.mTextView.setTextColor(Color.parseColor("#333333"));
            holder.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.route_report_grid_item_bg_normal));
        }
        convertView.setOnClickListener(new C41861());
        return convertView;
    }

    public void setCurrentSelectedItem(String type) {
        if (type == null) {
            this.mCurrentSelectedItem = -1;
        } else if (this.mRouteReportItemsList != null && this.mRouteReportItemsList.size() > 0) {
            for (int i = 0; i < this.mRouteReportItemsList.size(); i++) {
                RouteReportItem item = (RouteReportItem) this.mRouteReportItemsList.get(i);
                if (item != null && type.equals("" + item.mType)) {
                    this.mCurrentSelectedItem = i;
                }
            }
        }
    }
}
