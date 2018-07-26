package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.baidumaps.base.localmap.C0679d;
import com.baidu.baidumaps.base.localmap.C0692f;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.RoundProgressBar;
import com.baidu.platform.comapi.map.LocalMapResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CarModeOfflineMapManagerFragment extends ContentFragment implements Observer {
    private ImageButton mBtnBack;
    private ImageButton mBtnEdit;
    private SwitchButton mBtnSwitch;
    private CityListAdapter mCityListAdapter;
    private ExpandableListView mElvOfflineMapData;
    private TextView mFinish;
    private C1438c mFocusListView;
    private C1443g mFocusUp;
    private View mFooterView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private View mHeaderView;
    private boolean mIsEditable = false;
    private OnKeyListener mOnKeyListener = new C39038();
    private OnKeyListener mUpKeyListener = new C39027();
    private ViewGroup mViewGroup;
    private Object sync = new Object();

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$1 */
    class C38961 implements OnClickListener {
        C38961() {
        }

        public void onClick(View v) {
            if (CarModeOfflineMapManagerFragment.this.mIsEditable) {
                CarModeOfflineMapManagerFragment.this.quiteEditMode();
            } else {
                CarModeOfflineMapManagerFragment.this.pageBack(CarModeOfflineMapManagerFragment.this.mModuleFrom);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$2 */
    class C38972 implements OnClickListener {
        C38972() {
        }

        public void onClick(View v) {
            CarModeOfflineMapManagerFragment.this.mIsEditable = true;
            CarModeOfflineMapManagerFragment.this.updateEditBtn();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$3 */
    class C38983 implements OnClickListener {
        C38983() {
        }

        public void onClick(View v) {
            CarModeOfflineMapManagerFragment.this.quiteEditMode();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$4 */
    class C38994 implements OnItemClickListener {
        C38994() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getHeaderViewsCount() == 1 && position == 0) {
                CarModeOfflineMapManagerFragment.this.showFragment(NaviFragmentManager.TYPE_LOCAL_MAP_PAGE, null);
            } else if (CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getFooterViewsCount() == 1) {
                CarModeOfflineMapManagerFragment.this.mBtnSwitch.toggle();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$5 */
    class C39005 implements OnCheckedChangeListener {
        C39005() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                GlobalConfig.getInstance().setIsAutoDownload(true);
            } else {
                GlobalConfig.getInstance().setIsAutoDownload(false);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$6 */
    class C39016 implements OnGroupClickListener {
        C39016() {
        }

        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
            LocalMapResource object = v.getTag(C0965R.id.tag_group);
            if (LocalMapResource.class.isInstance(object)) {
                LocalMapResource city = object;
                if (city != null) {
                    if (CarModeOfflineMapManagerFragment.this.mIsEditable) {
                        CarModeOfflineMapManagerFragment.this.mCityListAdapter.delete(city);
                    } else {
                        CarModeOfflineMapManagerFragment.this.mCityListAdapter.download(city);
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$7 */
    class C39027 implements OnKeyListener {
        C39027() {
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0) {
                return false;
            }
            switch (keyCode) {
                case 20:
                    CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.requestFocus();
                    CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.setSelection(0);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$8 */
    class C39038 implements OnKeyListener {
        C39038() {
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                if (CarModeOfflineMapManagerFragment.this.mCityListAdapter.finishedResources == null || CarModeOfflineMapManagerFragment.this.mCityListAdapter.finishedResources.size() <= 0 || ((long) CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getSelectedItemPosition()) != -1) {
                    long selectedPosition;
                    switch (keyCode) {
                        case 300:
                            if (CarModeOfflineMapManagerFragment.this.mCityListAdapter.finishedResources != null && CarModeOfflineMapManagerFragment.this.mCityListAdapter.finishedResources.size() > 0) {
                                selectedPosition = (long) CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getSelectedItemPosition();
                                if (CarModeOfflineMapManagerFragment.this.mCityListAdapter.downloadResources != null) {
                                    if (selectedPosition == ((long) CarModeOfflineMapManagerFragment.this.mCityListAdapter.downloadResources.size())) {
                                        CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, event);
                                        CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, event);
                                        return true;
                                    }
                                } else if (selectedPosition == 0) {
                                    CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, event);
                                    CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, event);
                                    return true;
                                }
                            }
                            break;
                        case 301:
                            if (CarModeOfflineMapManagerFragment.this.mCityListAdapter.finishedResources != null && CarModeOfflineMapManagerFragment.this.mCityListAdapter.finishedResources.size() > 0) {
                                selectedPosition = (long) CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getSelectedItemPosition();
                                if (CarModeOfflineMapManagerFragment.this.mCityListAdapter.downloadResources != null) {
                                    if (selectedPosition == ((long) (CarModeOfflineMapManagerFragment.this.mCityListAdapter.downloadResources.size() + 2))) {
                                        CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, event);
                                        CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, event);
                                        return true;
                                    }
                                } else if (selectedPosition == 2) {
                                    CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, event);
                                    CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, event);
                                    return true;
                                }
                            }
                            break;
                    }
                }
                CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.setSelection(0);
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$9 */
    class C39049 implements Runnable {
        C39049() {
        }

        public void run() {
            if (CarModeOfflineMapManagerFragment.this.mCityListAdapter != null) {
                CarModeOfflineMapManagerFragment.this.mCityListAdapter.reloadData();
                CarModeOfflineMapManagerFragment.this.mCityListAdapter.notifyDataSetChanged();
            }
        }
    }

    private class CityListAdapter extends BaseExpandableListAdapter implements OnClickListener {
        private static final int CHILD_TYPE_CITY = 0;
        private static final int CHILD_TYPE_EXPAND_CITY = 1;
        private static final int GROUP_TYPE_CITY = 2;
        private static final int GROUP_TYPE_PROVINCE = 1;
        private static final int GROUP_TYPE_TITLE = 0;
        private List currentData;
        private List<LocalMapResource> downloadResources;
        private List<LocalMapResource> finishedResources;
        private final LayoutInflater inflater;

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$CityListAdapter$2 */
        class C39062 implements DialogInterface.OnClickListener {
            C39062() {
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }

        private class Holder {
            private LocalMapResource city;
            private TextView cityNameText;
            private ImageView expandButton;
            TextView mInfoHint;
            RelativeLayout mInfoLayout;
            TextView mInfoTV;
            View mListDivider;
            TextView mNameTV;
            RoundProgressBar mRoundProgressBarDownloading;
            RelativeLayout mStatusLayout;
            ImageView mTaskDelete;
            ImageView mTaskStatusIV;
            private TextView statusText;

            private Holder() {
            }
        }

        private CityListAdapter(Activity activity) {
            this.inflater = activity.getLayoutInflater();
            reloadData();
        }

        public int getGroupTypeCount() {
            return 3;
        }

        public int getGroupType(int groupPosition) {
            Object group = getGroup(groupPosition);
            if (!LocalMapResource.class.isInstance(group)) {
                return 0;
            }
            if (C0679d.i((LocalMapResource) group)) {
                return 1;
            }
            return 2;
        }

        public int getGroupCount() {
            return this.currentData != null ? this.currentData.size() : 0;
        }

        public Object getGroup(int groupPosition) {
            return this.currentData.get(groupPosition);
        }

        public long getGroupId(int groupPosition) {
            return (long) groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            switch (getGroupType(groupPosition)) {
                case 0:
                    return getGroupTitleView(convertView, parent, (String) getGroup(groupPosition));
                case 1:
                    return getProvinceView(convertView, parent, (LocalMapResource) getGroup(groupPosition), isExpanded);
                case 2:
                    return getCityView(convertView, parent, (LocalMapResource) getGroup(groupPosition), false);
                default:
                    throw new IllegalStateException();
            }
        }

        public int getChildTypeCount() {
            return 2;
        }

        public int getChildType(int groupPosition, int childPosition) {
            switch (getGroupType(groupPosition)) {
                case 1:
                    return 1;
                default:
                    return 0;
            }
        }

        public int getChildrenCount(int groupPosition) {
            LocalMapResource group = getGroup(groupPosition);
            if (!LocalMapResource.class.isInstance(group)) {
                return 0;
            }
            LocalMapResource city = group;
            if (C0679d.i(city)) {
                return city.children.size();
            }
            return 0;
        }

        public Object getChild(int groupPosition, int childPosition) {
            return ((LocalMapResource) getGroup(groupPosition)).children.get(childPosition);
        }

        public long getChildId(int groupPosition, int childPosition) {
            return (long) childPosition;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            switch (getChildType(groupPosition, childPosition)) {
                case 0:
                    return getCityView(convertView, parent, (LocalMapResource) getChild(groupPosition, childPosition), false);
                case 1:
                    return getCityView(convertView, parent, (LocalMapResource) getChild(groupPosition, childPosition), true);
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private void reloadData() {
            List mDomesticData = new ArrayList();
            this.downloadResources = C0692f.a().f();
            this.finishedResources = C0692f.a().h();
            if (this.downloadResources.size() > 0) {
                mDomesticData.addAll(this.downloadResources);
            }
            if (this.finishedResources.size() > 0) {
                mDomesticData.add(StyleManager.getString(C0965R.string.carlife_map_data_download_finish));
                mDomesticData.addAll(this.finishedResources);
            }
            this.currentData = mDomesticData;
        }

        private View getGroupTitleView(View convertView, ViewGroup parent, String title) {
            Holder holder;
            if (convertView == null) {
                holder = new Holder();
                convertView = this.inflater.inflate(C0965R.layout.carmode_map_data_group_title, parent, false);
                holder.cityNameText = (TextView) convertView.findViewById(C0965R.id.tv_map_data_title);
                holder.mListDivider = convertView.findViewById(C0965R.id.list_item_divider);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.mListDivider.setVisibility(0);
            holder.cityNameText.setText(title);
            return convertView;
        }

        private View getProvinceView(View convertView, ViewGroup parent, LocalMapResource city, boolean isExpanded) {
            Holder holder;
            if (convertView == null) {
                convertView = this.inflater.inflate(C0965R.layout.offline_map_city_list_province, parent, false);
                holder = new Holder();
                holder.cityNameText = (TextView) convertView.findViewById(C0965R.id.local_map_city_list_city_name);
                holder.statusText = (TextView) convertView.findViewById(C0965R.id.local_map_city_list_city_status);
                holder.expandButton = (ImageView) convertView.findViewById(C0965R.id.local_map_city_list_province_expand);
                convertView.setTag(holder);
            }
            holder = (Holder) convertView.getTag();
            holder.city = city;
            holder.cityNameText.setText(city.name);
            holder.expandButton.setImageResource(isExpanded ? C0965R.drawable.icon_arrow_up : C0965R.drawable.sort_arrow_down_normal);
            C0679d.k(city);
            return convertView;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.view.View getCityView(android.view.View r21, android.view.ViewGroup r22, com.baidu.platform.comapi.map.LocalMapResource r23, boolean r24) {
            /*
            r20 = this;
            r0 = r20;
            r14 = com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment.this;
            r15 = r14.sync;
            monitor-enter(r15);
            r2 = 0;
            if (r21 != 0) goto L_0x020c;
        L_0x000c:
            r3 = new com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment$CityListAdapter$Holder;	 Catch:{ all -> 0x0221 }
            r14 = 0;
            r0 = r20;
            r3.<init>();	 Catch:{ all -> 0x0221 }
            r0 = r20;
            r14 = r0.inflater;	 Catch:{ all -> 0x056a }
            r16 = 2130968680; // 0x7f040068 float:1.754602E38 double:1.052838417E-314;
            r17 = 0;
            r0 = r16;
            r1 = r17;
            r21 = r14.inflate(r0, r1);	 Catch:{ all -> 0x056a }
            r14 = 2131624564; // 0x7f0e0274 float:1.8876311E38 double:1.053162467E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.RelativeLayout) r14;	 Catch:{ all -> 0x056a }
            r3.mInfoLayout = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624575; // 0x7f0e027f float:1.8876334E38 double:1.0531624723E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.RelativeLayout) r14;	 Catch:{ all -> 0x056a }
            r3.mStatusLayout = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624566; // 0x7f0e0276 float:1.8876315E38 double:1.053162468E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.TextView) r14;	 Catch:{ all -> 0x056a }
            r3.mNameTV = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624567; // 0x7f0e0277 float:1.8876317E38 double:1.0531624684E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.TextView) r14;	 Catch:{ all -> 0x056a }
            r3.mInfoTV = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624578; // 0x7f0e0282 float:1.887634E38 double:1.053162474E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.TextView) r14;	 Catch:{ all -> 0x056a }
            r3.mInfoHint = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624565; // 0x7f0e0275 float:1.8876313E38 double:1.0531624674E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.ImageView) r14;	 Catch:{ all -> 0x056a }
            r3.mTaskStatusIV = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624577; // 0x7f0e0281 float:1.8876338E38 double:1.0531624733E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (android.widget.ImageView) r14;	 Catch:{ all -> 0x056a }
            r3.mTaskDelete = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624532; // 0x7f0e0254 float:1.8876246E38 double:1.053162451E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r3.mListDivider = r14;	 Catch:{ all -> 0x056a }
            r14 = 2131624576; // 0x7f0e0280 float:1.8876336E38 double:1.053162473E-314;
            r0 = r21;
            r14 = r0.findViewById(r14);	 Catch:{ all -> 0x056a }
            r14 = (com.baidu.navi.view.RoundProgressBar) r14;	 Catch:{ all -> 0x056a }
            r3.mRoundProgressBarDownloading = r14;	 Catch:{ all -> 0x056a }
            r0 = r21;
            r0.setTag(r3);	 Catch:{ all -> 0x056a }
            r2 = r3;
        L_0x009e:
            if (r23 == 0) goto L_0x0556;
        L_0x00a0:
            if (r2 == 0) goto L_0x0556;
        L_0x00a2:
            r14 = r2.mNameTV;	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r0 = r0.name;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mListDivider;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mStatusLayout;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r2.city = r0;	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r14 = r0.id;	 Catch:{ all -> 0x0221 }
            r16 = 1;
            r0 = r16;
            if (r14 != r0) goto L_0x0216;
        L_0x00e2:
            r14 = r2.mInfoHint;	 Catch:{ all -> 0x0221 }
            r16 = 2131296332; // 0x7f09004c float:1.8210578E38 double:1.0530002987E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoHint;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
        L_0x00f9:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = 2131558690; // 0x7f0d0122 float:1.8742703E38 double:1.053129921E-314;
            r16 = com.baidu.navi.style.StyleManager.getColor(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setTextColor(r0);	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r14 = r0.type;	 Catch:{ all -> 0x0221 }
            r16 = 1;
            r0 = r16;
            if (r14 == r0) goto L_0x0121;
        L_0x0111:
            r14 = com.baidu.baidumaps.base.localmap.C0692f.a();	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r0 = r0.id;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r16;
            r23 = r14.h(r0);	 Catch:{ all -> 0x0221 }
        L_0x0121:
            if (r23 == 0) goto L_0x050f;
        L_0x0123:
            r14 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r0 = r23;
            r0 = r0.downloadProgress;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r16;
            r0 = (float) r0;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r17 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
            r16 = r16 / r17;
            r8 = r14 - r16;
            r14 = r2.city;	 Catch:{ all -> 0x0221 }
            r0 = r14.mapsize;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r14 = r2.city;	 Catch:{ all -> 0x0221 }
            r0 = r14.searchsize;	 Catch:{ all -> 0x0221 }
            r18 = r0;
            r10 = r16 + r18;
            r14 = (float) r10;	 Catch:{ all -> 0x0221 }
            r14 = r14 * r8;
            r4 = (long) r14;	 Catch:{ all -> 0x0221 }
            r14 = com.baidu.baidumaps.base.localmap.C0679d.a(r23);	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x0250;
        L_0x0151:
            r0 = r23;
            r14 = r0.version;	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x0224;
        L_0x0157:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296354; // 0x7f090062 float:1.8210622E38 double:1.0530003096E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
        L_0x0181:
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 2130838308; // 0x7f020324 float:1.7281595E38 double:1.052774005E-314;
            r0 = r16;
            r14.setImageResource(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r0 = r0.downloadProgress;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r16;
            r14.setProgress(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mStatusLayout;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = 2131558690; // 0x7f0d0122 float:1.8742703E38 double:1.053129921E-314;
            r16 = com.baidu.navi.style.StyleManager.getColor(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setTextColor(r0);	 Catch:{ all -> 0x0221 }
        L_0x01c1:
            r14 = r2.mInfoLayout;	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r14.setTag(r0);	 Catch:{ all -> 0x0221 }
            r14 = 2131623940; // 0x7f0e0004 float:1.8875046E38 double:1.0531621586E-314;
            r0 = r21;
            r1 = r23;
            r0.setTag(r14, r1);	 Catch:{ all -> 0x0221 }
        L_0x01d2:
            r0 = r20;
            r14 = com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment.this;	 Catch:{ all -> 0x0221 }
            r14 = r14.mIsEditable;	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x054b;
        L_0x01dc:
            r14 = r2.mTaskDelete;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mStatusLayout;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = "";
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
        L_0x020a:
            monitor-exit(r15);	 Catch:{ all -> 0x0221 }
            return r21;
        L_0x020c:
            r14 = r21.getTag();	 Catch:{ all -> 0x0221 }
            r0 = r14;
            r0 = (com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment.CityListAdapter.Holder) r0;	 Catch:{ all -> 0x0221 }
            r2 = r0;
            goto L_0x009e;
        L_0x0216:
            r14 = r2.mInfoHint;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x00f9;
        L_0x0221:
            r14 = move-exception;
        L_0x0222:
            monitor-exit(r15);	 Catch:{ all -> 0x0221 }
            throw r14;
        L_0x0224:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296353; // 0x7f090061 float:1.821062E38 double:1.053000309E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x0181;
        L_0x0250:
            r14 = com.baidu.baidumaps.base.localmap.C0679d.b(r23);	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x0327;
        L_0x0256:
            r0 = r23;
            r14 = r0.version;	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x02fb;
        L_0x025c:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296352; // 0x7f090060 float:1.8210618E38 double:1.0530003086E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
        L_0x0286:
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 2130838308; // 0x7f020324 float:1.7281595E38 double:1.052774005E-314;
            r0 = r16;
            r14.setImageResource(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = 2131558646; // 0x7f0d00f6 float:1.8742614E38 double:1.053129899E-314;
            r16 = com.baidu.navi.style.StyleManager.getColor(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setTextColor(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r0 = r0.downloadProgress;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r16;
            r14.setProgress(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mStatusLayout;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r14 = r0.downloadStatus;	 Catch:{ all -> 0x0221 }
            r16 = 10;
            r0 = r16;
            if (r14 != r0) goto L_0x01c1;
        L_0x02d0:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = 2131296350; // 0x7f09005e float:1.8210614E38 double:1.0530003076E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mStatusLayout;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x01c1;
        L_0x02fb:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296339; // 0x7f090053 float:1.8210592E38 double:1.053000302E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x0286;
        L_0x0327:
            r14 = com.baidu.baidumaps.base.localmap.C0679d.c(r23);	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x03dd;
        L_0x032d:
            r0 = r23;
            r14 = r0.downloadStatus;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            if (r14 != r0) goto L_0x037d;
        L_0x0337:
            r0 = r20;
            r14 = com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment.this;	 Catch:{ all -> 0x0221 }
            r14 = r14.getActivity();	 Catch:{ all -> 0x0221 }
            r13 = com.baidu.platform.comapi.util.NetworkUtil.isWifiConnected(r14);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296328; // 0x7f090048 float:1.821057E38 double:1.053000297E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
        L_0x036d:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = 2131558641; // 0x7f0d00f1 float:1.8742604E38 double:1.0531298966E-314;
            r16 = com.baidu.navi.style.StyleManager.getColor(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setTextColor(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x01c1;
        L_0x037d:
            r0 = r23;
            r14 = r0.downloadStatus;	 Catch:{ all -> 0x0221 }
            r16 = 6;
            r0 = r16;
            if (r14 != r0) goto L_0x03b2;
        L_0x0387:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296349; // 0x7f09005d float:1.8210612E38 double:1.053000307E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x036d;
        L_0x03b2:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r16.<init>();	 Catch:{ all -> 0x0221 }
            r17 = 2131296351; // 0x7f09005f float:1.8210616E38 double:1.053000308E-314;
            r17 = com.baidu.navi.style.StyleManager.getString(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = " ";
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r17 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x0221 }
            r16 = r16.append(r17);	 Catch:{ all -> 0x0221 }
            r16 = r16.toString();	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x036d;
        L_0x03dd:
            r14 = com.baidu.baidumaps.base.localmap.C0679d.g(r23);	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x04c1;
        L_0x03e3:
            r0 = r23;
            r0 = r0.mapoldsize;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r23;
            r0 = r0.searcholdsize;	 Catch:{ all -> 0x0221 }
            r18 = r0;
            r16 = r16 + r18;
            r6 = com.baidu.baidumaps.base.localmap.C0679d.a(r16);	 Catch:{ all -> 0x0221 }
            r0 = r23;
            r0 = r0.mappatchsize;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r0 = r23;
            r0 = r0.searchpatchsize;	 Catch:{ all -> 0x0221 }
            r18 = r0;
            r16 = r16 + r18;
            r7 = com.baidu.baidumaps.base.localmap.C0679d.a(r16);	 Catch:{ all -> 0x0221 }
            r14 = com.baidu.baidumaps.base.localmap.C0679d.j(r23);	 Catch:{ all -> 0x0221 }
            if (r14 != 0) goto L_0x0482;
        L_0x040d:
            r0 = r23;
            r14 = r0.downloadStatus;	 Catch:{ all -> 0x0221 }
            r16 = 9;
            r0 = r16;
            if (r14 == r0) goto L_0x0459;
        L_0x0417:
            r0 = r23;
            r14 = r0.updateStatus;	 Catch:{ all -> 0x0221 }
            r16 = 4;
            r0 = r16;
            if (r14 == r0) goto L_0x0459;
        L_0x0421:
            r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r14.<init>();	 Catch:{ all -> 0x0221 }
            r16 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14 = r14.append(r0);	 Catch:{ all -> 0x0221 }
            r16 = " ";
            r0 = r16;
            r14 = r14.append(r0);	 Catch:{ all -> 0x0221 }
            r14 = r14.append(r7);	 Catch:{ all -> 0x0221 }
            r9 = r14.toString();	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r14.setText(r9);	 Catch:{ all -> 0x0221 }
        L_0x0449:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = 2131558646; // 0x7f0d00f6 float:1.8742614E38 double:1.053129899E-314;
            r16 = com.baidu.navi.style.StyleManager.getColor(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setTextColor(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x01c1;
        L_0x0459:
            r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r14.<init>();	 Catch:{ all -> 0x0221 }
            r16 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14 = r14.append(r0);	 Catch:{ all -> 0x0221 }
            r16 = " ";
            r0 = r16;
            r14 = r14.append(r0);	 Catch:{ all -> 0x0221 }
            r14 = r14.append(r7);	 Catch:{ all -> 0x0221 }
            r12 = r14.toString();	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r14.setText(r12);	 Catch:{ all -> 0x0221 }
            goto L_0x0449;
        L_0x0482:
            r0 = r23;
            r14 = r0.updateStatus;	 Catch:{ all -> 0x0221 }
            r16 = 4;
            r0 = r16;
            if (r14 != r0) goto L_0x0498;
        L_0x048c:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r10);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x0449;
        L_0x0498:
            r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0221 }
            r14.<init>();	 Catch:{ all -> 0x0221 }
            r16 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14 = r14.append(r0);	 Catch:{ all -> 0x0221 }
            r16 = " ";
            r0 = r16;
            r14 = r14.append(r0);	 Catch:{ all -> 0x0221 }
            r14 = r14.append(r7);	 Catch:{ all -> 0x0221 }
            r9 = r14.toString();	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r14.setText(r9);	 Catch:{ all -> 0x0221 }
            goto L_0x0449;
        L_0x04c1:
            r14 = com.baidu.baidumaps.base.localmap.C0679d.f(r23);	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x04f0;
        L_0x04c7:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r10);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 2130838277; // 0x7f020305 float:1.7281532E38 double:1.0527739895E-314;
            r0 = r16;
            r14.setImageResource(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mTaskStatusIV;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mStatusLayout;	 Catch:{ all -> 0x0221 }
            r16 = 0;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x01c1;
        L_0x04f0:
            r14 = com.baidu.baidumaps.base.localmap.C0679d.d(r23);	 Catch:{ all -> 0x0221 }
            if (r14 == 0) goto L_0x0502;
        L_0x04f6:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = "";
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x01c1;
        L_0x0502:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r10);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x01c1;
        L_0x050f:
            r14 = r2.mInfoTV;	 Catch:{ all -> 0x0221 }
            r16 = r2.city;	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r0 = r0.mapsize;	 Catch:{ all -> 0x0221 }
            r16 = r0;
            r18 = r2.city;	 Catch:{ all -> 0x0221 }
            r0 = r18;
            r0 = r0.searchsize;	 Catch:{ all -> 0x0221 }
            r18 = r0;
            r16 = r16 + r18;
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r16);	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setText(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoLayout;	 Catch:{ all -> 0x0221 }
            r16 = r2.city;	 Catch:{ all -> 0x0221 }
            r0 = r16;
            r14.setTag(r0);	 Catch:{ all -> 0x0221 }
            r14 = 2131623940; // 0x7f0e0004 float:1.8875046E38 double:1.0531621586E-314;
            r16 = r2.city;	 Catch:{ all -> 0x0221 }
            r0 = r21;
            r1 = r16;
            r0.setTag(r14, r1);	 Catch:{ all -> 0x0221 }
            goto L_0x01d2;
        L_0x054b:
            r14 = r2.mTaskDelete;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x020a;
        L_0x0556:
            r14 = r2.mListDivider;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            r14 = r2.mInfoLayout;	 Catch:{ all -> 0x0221 }
            r16 = 8;
            r0 = r16;
            r14.setVisibility(r0);	 Catch:{ all -> 0x0221 }
            goto L_0x020a;
        L_0x056a:
            r14 = move-exception;
            r2 = r3;
            goto L_0x0222;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment.CityListAdapter.getCityView(android.view.View, android.view.ViewGroup, com.baidu.platform.comapi.map.LocalMapResource, boolean):android.view.View");
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0965R.id.info_relativelayout:
                    LocalMapResource city = (LocalMapResource) view.getTag();
                    if (city == null) {
                        return;
                    }
                    if (CarModeOfflineMapManagerFragment.this.mIsEditable) {
                        delete(city);
                        return;
                    } else {
                        download(city);
                        return;
                    }
                default:
                    return;
            }
        }

        private void download(final LocalMapResource city) {
            if (C0679d.a(city) || C0679d.b(city)) {
                if (city.downloadStatus != 10) {
                    C0692f.a().d(city.id);
                }
            } else if (!C0679d.d(city) || C0679d.g(city)) {
                C0679d.a(CarModeOfflineMapManagerFragment.this.getActivity(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (C0679d.g(city) || C0679d.f(city)) {
                            C0692f.a().g(city.id);
                        } else if (C0679d.c(city)) {
                            C0692f.a().b(city.id);
                        } else if (C0679d.e(city)) {
                            C0692f.a().g(city.id);
                        } else if (C0679d.h(city)) {
                            C0692f.a().a(city.id);
                        }
                    }
                }, new C39062());
            }
        }

        private void delete(final LocalMapResource city) {
            Activity activity = CarModeOfflineMapManagerFragment.this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                C1309g.a().showDialog(new C1953c(activity).b(StyleManager.getString(C0965R.string.carlife_map_data_delete)).d(StyleManager.getString(C0965R.string.carlife_map_data_comfirm)).e(StyleManager.getString(C0965R.string.carlife_map_data_cancel)).r().a(new C0672b() {
                    public void onClick() {
                        C0692f.a().f(city.id);
                        CityListAdapter.this.reloadData();
                        CityListAdapter.this.notifyDataSetChanged();
                    }
                }));
            }
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.car_mode_frag_offline_map_data_manager, null);
        this.mHeaderView = inflater.inflate(C0965R.layout.carmode_offline_data_map_manager_header, null);
        this.mFooterView = inflater.inflate(C0965R.layout.carmode_offline_map_data_manager_footer, null);
        initview();
        bindEvents();
        initData();
        return this.mViewGroup;
    }

    private void initData() {
        C0692f.a().addObserver(this);
    }

    private void initview() {
        this.mBtnBack = (ImageButton) this.mViewGroup.findViewById(C0965R.id.ib_left);
        setCommonTitleBar(this.mViewGroup, StyleManager.getString(C0965R.string.carlife_map_data_download_manager));
        this.mBtnEdit = (ImageButton) this.mViewGroup.findViewById(C0965R.id.ib_right);
        this.mBtnEdit.setBackground(C2251b.a(mActivity));
        this.mBtnEdit.setVisibility(0);
        this.mFinish = (TextView) this.mViewGroup.findViewById(C0965R.id.tv_over_right_imgbtn);
        this.mFinish.setBackground(C2251b.a(mActivity));
        this.mFinish.setTextColor(StyleManager.getColor(C0965R.color.cl_other_c));
        this.mElvOfflineMapData = (ExpandableListView) this.mViewGroup.findViewById(C0965R.id.elv_offline_map_data);
        this.mCityListAdapter = new CityListAdapter(BaseFragment.getNaviActivity());
        this.mElvOfflineMapData.addHeaderView(this.mHeaderView);
        this.mElvOfflineMapData.addFooterView(this.mFooterView);
        this.mElvOfflineMapData.setAdapter(this.mCityListAdapter);
        this.mBtnSwitch = (SwitchButton) this.mFooterView.findViewById(C0965R.id.map_control_panel_list_item_its_checkbox);
    }

    private void bindEvents() {
        this.mBtnBack.setOnClickListener(new C38961());
        this.mBtnEdit.setOnClickListener(new C38972());
        this.mFinish.setOnClickListener(new C38983());
        this.mElvOfflineMapData.setOnItemClickListener(new C38994());
        this.mBtnSwitch.setOnCheckedChangeListener(new C39005());
        if (GlobalConfig.getInstance().isAutoDownload()) {
            this.mBtnSwitch.setChecked(true);
        } else {
            this.mBtnSwitch.setChecked(false);
        }
        this.mElvOfflineMapData.setOnGroupClickListener(new C39016());
    }

    private void updateEditBtn() {
        if (this.mIsEditable) {
            this.mFinish.setVisibility(0);
            this.mBtnEdit.setVisibility(8);
        } else {
            this.mBtnEdit.setVisibility(0);
            this.mFinish.setVisibility(8);
        }
        this.mCityListAdapter.notifyDataSetChanged();
    }

    private void quiteEditMode() {
        this.mIsEditable = false;
        updateEditBtn();
    }

    protected void onInitView() {
    }

    public void onPause() {
        super.onPause();
        C0679d.a(getView());
    }

    public void onDestroy() {
        try {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            C0692f.a().deleteObserver(this);
        } finally {
            super.onDestroy();
        }
    }

    public boolean onBackPressed() {
        if (this.mIsEditable) {
            quiteEditMode();
        } else {
            pageBack(this.mModuleFrom);
        }
        return true;
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        if (this.mFocusUp == null) {
            this.mFocusUp = new C1443g(this.mViewGroup.findViewById(C0965R.id.common_title_bar), 2);
            this.mFocusUp.d(this.mViewGroup.findViewById(C0965R.id.ib_left)).d(this.mViewGroup.findViewById(C0965R.id.ib_right)).d(this.mViewGroup.findViewById(C0965R.id.tv_over_right_imgbtn));
            this.mFocusUp.a(this.mUpKeyListener);
        }
        if (this.mFocusListView == null) {
            this.mFocusListView = new C1438c(this.mElvOfflineMapData, 4);
            this.mFocusListView.a(this.mOnKeyListener);
        }
        C1440d.a().b(new C1436a[]{this.mFocusUp, this.mFocusListView});
        C1440d.a().h(this.mFocusUp);
    }

    public void update(Observable observable, Object o) {
        if (this.mHandler != null) {
            this.mHandler.post(new C39049());
        }
    }

    public void driving() {
        C1260i.b("yftech", "CarModeOfflineMapManagerFragment driving");
        if (C1343b.a().b()) {
            back();
            back();
        }
    }
}
