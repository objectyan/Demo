package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.routereport.BNRouteReportModel.RouteReportItem;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RouteReportImgListAdapter extends BaseAdapter {
    private static final String TAG = RouteReportImgListAdapter.class.getSimpleName();
    private GridView mBindedView;
    private GridViewCallback mCallback;
    private Activity mContext;
    private int mCurrentSelectedItem = -1;
    private ArrayList<RouteReportItem> mRouteReportItemsList;
    OnClickListener onClickListener = new C41851();

    public interface GridViewCallback {
        void onItemClick(int i, RouteReportItem routeReportItem);
    }

    /* renamed from: com.baidu.navisdk.module.routereport.RouteReportImgListAdapter$1 */
    class C41851 implements OnClickListener {
        C41851() {
        }

        public void onClick(View v) {
            if (v != null && v.getTag() != null) {
                ViewHolder mViewHolder = (ViewHolder) v.getTag();
                if (mViewHolder.mImgView != null) {
                    LogUtil.m15791e(RouteReportImgListAdapter.TAG, "onClick: item --> " + mViewHolder.position + ", mCurrentSelectedItem = " + RouteReportImgListAdapter.this.mCurrentSelectedItem);
                    if (mViewHolder.position >= 0 && mViewHolder.position < RouteReportImgListAdapter.this.mRouteReportItemsList.size()) {
                        RouteReportItem item = (RouteReportItem) RouteReportImgListAdapter.this.mRouteReportItemsList.get(mViewHolder.position);
                        if (RouteReportImgListAdapter.this.mCallback != null) {
                            RouteReportImgListAdapter.this.mCallback.onItemClick(mViewHolder.position, item);
                        }
                        RouteReportImgListAdapter.this.mCurrentSelectedItem = mViewHolder.position;
                    }
                }
            }
        }
    }

    public static class ViewHolder {
        public ImageView mImgView;
        public TextView mTextView;
        public int position;
    }

    public RouteReportImgListAdapter(Activity mContext, ArrayList<RouteReportItem> mRouteReportItemsList, GridViewCallback callback) {
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
            convertView = JarUtils.inflate(this.mContext, C4048R.layout.nsdk_layout_route_report_img_grid_item, null);
            if (convertView == null) {
                return null;
            }
            holder = new ViewHolder();
            holder.mImgView = (ImageView) convertView.findViewById(C4048R.id.grid_img);
            holder.mTextView = (TextView) convertView.findViewById(C4048R.id.grid_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.position = position;
        if (convertView != null) {
            convertView.setOnClickListener(this.onClickListener);
        }
        if (this.mRouteReportItemsList != null && this.mRouteReportItemsList.size() > position) {
            RouteReportItem mUgcBaseDataModel = (RouteReportItem) this.mRouteReportItemsList.get(position);
            if (mUgcBaseDataModel != null) {
                holder.mTextView.setText(mUgcBaseDataModel.mTitle == null ? "" : mUgcBaseDataModel.mTitle);
                BNRouteReportController.setupUrlDrawable(holder.mImgView, BNRouteReportModel.getInstance().getDefaultResId(mUgcBaseDataModel.mType), mUgcBaseDataModel.mIconUrl);
            }
        }
        return convertView;
    }

    public void releaseBitmapRes() {
        if (this.mBindedView != null) {
            LogUtil.m15791e(TAG, "releaseBitmapRes:  --> ");
            for (int i = 0; i < this.mRouteReportItemsList.size(); i++) {
                View view = this.mBindedView.getChildAt(i);
                if (view != null) {
                    UIUtils.releaseImageViewWithoutNull(((ViewHolder) view.getTag()).mImgView);
                }
            }
        }
    }
}
