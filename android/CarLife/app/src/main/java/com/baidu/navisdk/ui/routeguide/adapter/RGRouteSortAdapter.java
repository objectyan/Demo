package com.baidu.navisdk.ui.routeguide.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.ArrayList;

public class RGRouteSortAdapter extends BaseAdapter {
    private static final int NUM_COLUMNS = 3;
    private static final String TAG = RGRouteSortAdapter.class.getSimpleName();
    private int mPageFromType = 1;

    public class ViewHolder {
        public View mHorizontalDivider;
        public RelativeLayout mItemDefaultSettingLayout;
        public RelativeLayout mItemDefaultTipsLayout;
        public View mItemLayout;
        public TextView mItemName;
        public int mPosition;
        public View mVerticalDivider;
    }

    public void setPageFromType(int type) {
        this.mPageFromType = type;
    }

    public int getCount() {
        ArrayList<RGRouteSortModel> routeSortList = RGRouteSortController.getInstance().getRouteSortList();
        if (routeSortList == null) {
            return 0;
        }
        return routeSortList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LogUtil.m15791e(TAG, "getView position = " + position);
        if (convertView == null) {
            convertView = JarUtils.inflate(BNaviModuleManager.getActivity(), C4048R.layout.nsdk_layout_route_sort_child_grid_item, null);
            if (convertView == null) {
                return convertView;
            }
            holder = new ViewHolder();
            holder.mItemName = (TextView) convertView.findViewById(C4048R.id.nsdk_route_sort_item_tv);
            holder.mItemLayout = convertView;
            holder.mItemDefaultTipsLayout = (RelativeLayout) convertView.findViewById(C4048R.id.nsdk_route_sort_default_tips_layout);
            holder.mItemDefaultSettingLayout = (RelativeLayout) convertView.findViewById(C4048R.id.nsdk_route_sort_default_setting_layout);
            holder.mVerticalDivider = convertView.findViewById(C4048R.id.nsdk_route_sort_item_divider_vertical);
            holder.mHorizontalDivider = convertView.findViewById(C4048R.id.nsdk_route_sort_item_divider_bottom);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (holder == null || holder.mItemLayout == null || holder.mItemName == null || holder.mItemDefaultTipsLayout == null || holder.mItemDefaultSettingLayout == null) {
            return convertView;
        }
        holder.mItemLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (v != null) {
                    ArrayList<RGRouteSortModel> routeSortList = RGRouteSortController.getInstance().getRouteSortList();
                    if (routeSortList != null) {
                        RGRouteSortModel model = (RGRouteSortModel) routeSortList.get(position);
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
                            if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                                BNaviModuleManager.setLastPreferValue(preferValue);
                                BNSettingManager.setDefaultRouteSort(preferValue);
                                UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_3, preferValue + "", null, null);
                            }
                            RGRouteSortController.getInstance().setPreferValue(preferValue);
                            BNRoutePlaner.getInstance().setCalcPrference(preferValue);
                            if (RGRouteSortAdapter.this.mPageFromType == 2) {
                                if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                                    UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_1, preferValue + "", "3", null);
                                }
                                RGViewController.getInstance().hideRouteSortView();
                                if (isPreferChange) {
                                    XDVoiceInstructManager.getInstance().setWakeupEnable(false);
                                    RGSimpleGuideModel.getInstance();
                                    RGSimpleGuideModel.mCalcRouteType = 2;
                                    RGEngineControl.getInstance().reCalcRoute();
                                }
                            } else if (RGRouteSortAdapter.this.mPageFromType == 1) {
                                if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                                    UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_1, preferValue + "", "2", null);
                                }
                                if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                                    BNSettingManager.setSelectedRouteSortValue(model.mPreferValue);
                                    BNSettingManager.setSelectedRouteSortCount(0);
                                } else if (!(BNSettingManager.hasShowRouteSortSettingGuide() || !isPreferChange || (BNaviModuleManager.getLastPreferValue() & 1) == 0)) {
                                    if ((model.mPreferValue & 1) != 0) {
                                        BNSettingManager.setSelectedRouteSortValue(model.mPreferValue);
                                        BNSettingManager.setSelectedRouteSortCount(0);
                                    } else if (BNSettingManager.getSelectedRouteSortValue() == model.mPreferValue) {
                                        BNSettingManager.setSelectedRouteSortCount(BNSettingManager.getSelectedRouteSortCount() + 1);
                                    } else {
                                        BNSettingManager.setSelectedRouteSortValue(model.mPreferValue);
                                        BNSettingManager.setSelectedRouteSortCount(1);
                                    }
                                }
                                RGRouteSortController.getInstance().onClickItemAction(isPreferChange);
                            }
                            RGRouteSortAdapter.this.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        holder.mItemDefaultSettingLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (v != null) {
                    ArrayList<RGRouteSortModel> routeSortList = RGRouteSortController.getInstance().getRouteSortList();
                    if (routeSortList != null) {
                        RGRouteSortModel model = (RGRouteSortModel) routeSortList.get(position);
                        if (model != null) {
                            int preferValue;
                            if ((RGRouteSortController.getInstance().getPreferValue() & 32) != 0) {
                                preferValue = model.mPreferValue | 32;
                            } else {
                                preferValue = model.mPreferValue;
                            }
                            BNaviModuleManager.setLastPreferValue(preferValue);
                            BNSettingManager.setDefaultRouteSort(preferValue);
                            RGRouteSortController.getInstance().setPreferValue(preferValue);
                            BNRoutePlaner.getInstance().setCalcPrference(preferValue);
                            UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_3, preferValue + "", null, null);
                            if (RGRouteSortAdapter.this.mPageFromType == 2) {
                                RGViewController.getInstance().hideRouteSortView();
                                RGEngineControl.getInstance().reCalcRoute();
                            } else if (RGRouteSortAdapter.this.mPageFromType == 1) {
                                BNSettingManager.setSelectedRouteSortValue(model.mPreferValue);
                                BNSettingManager.setSelectedRouteSortCount(0);
                                RGRouteSortController.getInstance().onSettingDefaultAction();
                            }
                            RGRouteSortAdapter.this.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        holder.mPosition = position;
        if ((position + 1) % 3 == 0) {
            holder.mVerticalDivider.setVisibility(4);
        } else {
            holder.mVerticalDivider.setVisibility(0);
        }
        if (position >= 3) {
            holder.mHorizontalDivider.setVisibility(4);
        } else {
            holder.mHorizontalDivider.setVisibility(0);
        }
        holder.mVerticalDivider.setBackgroundColor(getColor(C4048R.color.cl_bg_d_mm));
        holder.mHorizontalDivider.setBackgroundColor(getColor(C4048R.color.cl_bg_d_mm));
        holder.mItemLayout.setBackgroundDrawable(getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        ArrayList<RGRouteSortModel> routeSortList = RGRouteSortController.getInstance().getRouteSortList();
        if (routeSortList == null) {
            return convertView;
        }
        if (position >= 0 && position < routeSortList.size()) {
            RGRouteSortModel model = (RGRouteSortModel) routeSortList.get(position);
            if (model == null) {
                return convertView;
            }
            holder.mItemName.setText(model.mItemName);
            if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn || (model.mPreferValue & RGRouteSortController.getInstance().getPreferValue()) == 0) {
                holder.mItemName.setTextColor(getColor(C4048R.color.nsdk_route_sort_item_text));
                holder.mItemName.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(RGRouteSortController.getInstance().getmPreferIconId(model.mPreferValue, false)), null, null);
            } else {
                holder.mItemName.setTextColor(getColor(C4048R.color.nsdk_route_sort_setting_default));
                holder.mItemName.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(RGRouteSortController.getInstance().getmPreferIconId(model.mPreferValue, true)), null, null);
            }
            if ((model.mPreferValue & BNaviModuleManager.getLastPreferValue()) != 0) {
                holder.mItemDefaultTipsLayout.setVisibility(0);
            } else {
                holder.mItemDefaultTipsLayout.setVisibility(4);
            }
            if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                holder.mItemDefaultSettingLayout.setVisibility(4);
            } else if ((model.mPreferValue & BNaviModuleManager.getLastPreferValue()) != 0) {
                holder.mItemDefaultSettingLayout.setVisibility(4);
            } else {
                holder.mItemDefaultSettingLayout.setVisibility(0);
            }
        }
        return convertView;
    }

    private Drawable getDrawable(int resId) {
        if (this.mPageFromType == 1) {
            return BNStyleManager.getDrawable(resId, true);
        }
        return BNStyleManager.getDrawable(resId);
    }

    private int getColor(int resId) {
        if (this.mPageFromType == 1) {
            return BNStyleManager.getColor(resId, true);
        }
        return BNStyleManager.getColor(resId);
    }
}
