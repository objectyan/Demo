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
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.FavoriteDestinationController.FavoriteDestResultCallBack;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.db.DBManager$DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviFavoriteDestModel;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDestinationAdapter extends BaseAdapter {
    private FavoriteDestResultCallBack callBack = new C36265();
    ViewHolder holder;
    private boolean isCompSetting = false;
    private boolean isHomeSetting = false;
    private DBManager$DBOperateResultCallback mCallback = new C36254();
    protected RoutePlanNode mCompany;
    private Context mContext;
    private List<RoutePlanNode> mDataList = new ArrayList();
    protected RoutePlanNode mFamily;
    private LayoutInflater mInflater;
    private C1277e mOnDialogListener;
    private RoutePlanNode mRoutePlanNode;

    /* renamed from: com.baidu.navi.adapter.FavoriteDestinationAdapter$3 */
    class C36243 implements C0672b {
        C36243() {
        }

        public void onClick() {
            FavoriteDestinationAdapter.this.cleanAllHistoryDesPoi();
        }
    }

    /* renamed from: com.baidu.navi.adapter.FavoriteDestinationAdapter$4 */
    class C36254 implements DBManager$DBOperateResultCallback {
        C36254() {
        }

        public void onAddOrDeleteSuccess() {
        }

        public void onQuerySuccess() {
            FavoriteDestinationAdapter.this.notifyDataUpdate();
        }
    }

    /* renamed from: com.baidu.navi.adapter.FavoriteDestinationAdapter$5 */
    class C36265 implements FavoriteDestResultCallBack {
        C36265() {
        }

        public void onCheckResult(boolean isFavorite) {
        }

        public void onAddResult(boolean isSuccess) {
            FavoriteDestinationAdapter.this.notifyDataUpdate();
        }

        public void onRemoveResult(boolean isSuccess) {
            FavoriteDestinationAdapter.this.notifyDataUpdate();
        }

        public void onCleanResult(boolean isSuccess) {
            FavoriteDestinationAdapter.this.notifyDataUpdate();
        }
    }

    /* renamed from: com.baidu.navi.adapter.FavoriteDestinationAdapter$6 */
    class C36276 implements Runnable {
        C36276() {
        }

        public void run() {
            FavoriteDestinationAdapter.this.notifyHistoryDataSetChanged();
        }
    }

    public static class ViewHolder {
        public ImageView deleteIcon;
        public LinearLayout deleteLayout;
        public View line;
        public LinearLayout poiInfoLayout;
        public TextView pointDescription;
        public TextView pointName;
    }

    public FavoriteDestinationAdapter(Context context, C1277e listener) {
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mContext = context;
        this.mOnDialogListener = listener;
        if (!NaviFavoriteDestModel.getInstance().checkIsQueryDB()) {
            FavoriteDestinationController.getInstance().queryAllFavoriteDestFromDB(this.mCallback);
        }
        updateAddr();
    }

    public void updateAddr() {
        this.mFamily = AddressSettingModel.getHomeAddrNode(BNaviModuleManager.getContext());
        this.mCompany = AddressSettingModel.getCompAddrNode(BNaviModuleManager.getContext());
    }

    public int getCount() {
        if (this.mDataList == null) {
            return 2;
        }
        return this.mDataList.size() + 2;
    }

    public Object getItem(int position) {
        if (this.mDataList == null) {
            return null;
        }
        if (position == 0) {
            return this.mFamily;
        }
        if (position == 1) {
            return this.mCompany;
        }
        int pos = position - 2;
        if (pos < this.mDataList.size()) {
            return this.mDataList.get(pos);
        }
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getItemView(convertView, position);
        setItemContent(position);
        return convertView;
    }

    private View getItemView(View convertView, int position) {
        if (convertView == null) {
            this.holder = new ViewHolder();
            convertView = this.mInflater.inflate(C0965R.layout.navi_favorite_des_item, null);
            this.holder.poiInfoLayout = (LinearLayout) convertView.findViewById(C0965R.id.dest_info_layout);
            this.holder.pointName = (TextView) convertView.findViewById(C0965R.id.dest_name);
            this.holder.pointDescription = (TextView) convertView.findViewById(C0965R.id.dest_description);
            this.holder.deleteIcon = (ImageView) convertView.findViewById(C0965R.id.btn_dest_delete);
            this.holder.deleteLayout = (LinearLayout) convertView.findViewById(C0965R.id.dest_delete_layout);
            this.holder.line = convertView.findViewById(C0965R.id.cl_line);
            convertView.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) convertView.getTag();
        }
        if (position == getCount() - 1) {
            this.holder.line.setVisibility(8);
        } else {
            this.holder.line.setVisibility(0);
        }
        if (position == 0 || position == 1) {
            this.holder.pointDescription.setVisibility(0);
            this.holder.deleteLayout.setVisibility(8);
            this.holder.poiInfoLayout.setLayoutParams(new LayoutParams(-2, ScreenUtil.getInstance().dip2px(80), 1.0f));
        } else {
            this.holder.pointDescription.setVisibility(8);
            this.holder.deleteLayout.setVisibility(0);
            this.holder.poiInfoLayout.setLayoutParams(new LayoutParams(-2, ScreenUtil.getInstance().dip2px(60), 1.0f));
        }
        setupSkin();
        if (C1328h.a().getNaviFragmentManager().isDriving()) {
            if (isClickEnabled(position)) {
                this.holder.poiInfoLayout.setAlpha(1.0f);
            } else {
                this.holder.poiInfoLayout.setAlpha(0.2f);
            }
            this.holder.deleteLayout.setAlpha(0.2f);
            this.holder.deleteLayout.setEnabled(false);
        } else {
            this.holder.poiInfoLayout.setAlpha(1.0f);
            this.holder.deleteLayout.setAlpha(1.0f);
            this.holder.deleteLayout.setEnabled(true);
        }
        return convertView;
    }

    private void setupSkin() {
        this.holder.pointName.setTextColor(C2188r.a(C0965R.color.cl_text_a5_content));
        this.holder.pointDescription.setTextColor(C2188r.a(C0965R.color.cl_text_a2_content));
    }

    private void setItemContent(final int position) {
        if (this.mContext != null) {
            if (position == 0) {
                this.holder.pointName.setText(this.mContext.getString(C0965R.string.go_home));
                if (!AddressSettingModel.hasSetHomeAddr(this.mContext) || this.mFamily == null) {
                    this.holder.pointDescription.setText(this.mContext.getString(C0965R.string.tip_click_to_setting));
                } else {
                    this.holder.pointDescription.setText(this.mFamily.mName);
                    this.holder.deleteLayout.setVisibility(0);
                    this.isHomeSetting = true;
                }
            } else if (position == 1) {
                this.holder.pointName.setText(this.mContext.getString(C0965R.string.go_to_company));
                if (!AddressSettingModel.hasSetCompAddr(this.mContext) || this.mCompany == null) {
                    this.holder.pointDescription.setText(this.mContext.getString(C0965R.string.tip_click_to_setting));
                } else {
                    this.holder.pointDescription.setText(this.mCompany.mName);
                    this.holder.deleteLayout.setVisibility(0);
                    this.isCompSetting = true;
                }
            } else {
                this.mRoutePlanNode = (RoutePlanNode) getItem(position);
                if (this.mRoutePlanNode == null) {
                    return;
                }
                if (TextUtils.isEmpty(this.mRoutePlanNode.mName)) {
                    this.holder.pointName.setText("");
                } else {
                    this.holder.pointName.setText(this.mRoutePlanNode.mName);
                }
            }
            this.holder.deleteLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (position > 1) {
                        FavoriteDestinationAdapter.this.delRoutePlanHistoryItem(position);
                    } else {
                        FavoriteDestinationAdapter.this.showDelHistoryItemDialog(position);
                    }
                }
            });
        }
    }

    private void showDelHistoryItemDialog(final int position) {
        if (this.mContext != null) {
            int msg = 0;
            if (position == 0) {
                msg = C0965R.string.alert_delete_home_addr;
            } else if (position == 1) {
                msg = C0965R.string.alert_delete_comp_addr;
            }
            C1953c commonDialog = new C1953c(this.mContext).a(msg).g(17).c(C0965R.string.alert_confirm).q().d(C0965R.string.alert_cancel);
            commonDialog.a(new C0672b() {
                public void onClick() {
                    FavoriteDestinationAdapter.this.delRoutePlanHistoryItem(position);
                }
            });
            this.mOnDialogListener.showDialog(commonDialog);
        }
    }

    public void showCleanAllHistoryDialog() {
        C1953c commonDialog = new C1953c(this.mContext).a(C0965R.string.alert_clear_history_des).g(17).c(C0965R.string.alert_clean).q().d(C0965R.string.alert_cancel);
        commonDialog.a(new C36243());
        this.mOnDialogListener.showDialog(commonDialog);
    }

    private void cleanAllHistoryDesPoi() {
        FavoriteDestinationController.getInstance().cleanAllFavoriteDest(this.callBack);
    }

    private void delRoutePlanHistoryItem(int position) {
        if (position >= 0) {
            if (position == 0 && this.mFamily != null) {
                delHomeAddress();
            } else if (position == 1 && this.mCompany != null) {
                delCompAddress();
            } else if (this.mDataList == null || this.mDataList.size() > position - 2) {
                FavoriteDestinationController.getInstance().deleteFavoriteDestFromDB((RoutePlanNode) this.mDataList.get(position - 2), this.callBack);
            }
            StatisticManager.onEvent(StatisticConstants.HOME_MY_FAV_MODIFY, StatisticConstants.HOME_MY_FAV_MODIFY);
        }
    }

    public void notifyDataUpdate() {
        new Handler(Looper.getMainLooper()).post(new C36276());
    }

    public void notifyHistoryDataSetChanged() {
        this.mDataList = NaviFavoriteDestModel.getInstance().getRoutePlanNode();
        updateAddr();
        notifyDataSetChanged();
    }

    public RoutePlanNode getDate(int position) {
        LogUtil.m15791e("navi_favorite dest", position + " position:  " + position);
        if (position < 0) {
            return null;
        }
        if (position == 0 && this.mFamily != null) {
            return this.mFamily;
        }
        if (position == 1 && this.mCompany != null) {
            return this.mCompany;
        }
        if (this.mDataList == null || this.mDataList.size() > position - 2) {
            return (RoutePlanNode) this.mDataList.get(position - 2);
        }
        return null;
    }

    private void delHomeAddress() {
        if (this.mContext != null) {
            if (AddressSettingModel.removeHomeAddress(this.mContext)) {
                C1754b.a().c();
                TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.del_home_addr_sucess);
                this.isHomeSetting = false;
                notifyHistoryDataSetChanged();
                return;
            }
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.del_home_addr_fail);
        }
    }

    private void delCompAddress() {
        if (this.mContext != null) {
            if (AddressSettingModel.removeCompAddress(this.mContext)) {
                C1754b.a().b();
                TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.del_comp_addr_sucess);
                this.isCompSetting = false;
                notifyHistoryDataSetChanged();
                return;
            }
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.del_comp_addr_fail);
        }
    }

    public boolean isEnabled(int position) {
        return isClickEnabled(position);
    }

    private boolean isClickEnabled(int position) {
        if (!C1328h.a().getNaviFragmentManager().isDriving()) {
            return true;
        }
        if (position == 0 && (!AddressSettingModel.hasSetHomeAddr(this.mContext) || this.mFamily == null)) {
            return false;
        }
        if (position != 1 || (AddressSettingModel.hasSetCompAddr(this.mContext) && this.mCompany != null)) {
            return true;
        }
        return false;
    }

    public boolean isBack() {
        if (this.isHomeSetting || this.isCompSetting) {
            return false;
        }
        return true;
    }
}
