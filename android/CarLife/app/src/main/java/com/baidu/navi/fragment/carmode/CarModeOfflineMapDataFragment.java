package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.baidu.baidumaps.base.localmap.C0679d;
import com.baidu.baidumaps.base.localmap.C0692f;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.view.C2252a;
import com.baidu.carlife.view.C2252a.C2245a;
import com.baidu.carlife.view.C2252a.C2248c;
import com.baidu.carlife.view.C2252a.C2249d;
import com.baidu.carlife.view.KeyboardEditText;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.RoundProgressBar;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.map.LocalMapResource;
import com.baidu.platform.comapi.map.provider.CarRouteProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CarModeOfflineMapDataFragment extends ContentFragment implements C2248c, Observer {
    private boolean canSugShow;
    private boolean isSearchEnable = false;
    private ImageButton mBtnBack;
    private CityListAdapter mCityListAdapter;
    private boolean mEdViewHasFocus = false;
    private View mEditLine;
    private LinearLayout mEditTextContentLayout;
    private ExpandableListView mElvOfflineMapData;
    private C1443g mFocusAreaUp;
    private C1438c mFocusListView;
    private C0936j mHandler = new C0936j(Looper.getMainLooper()) {
        public void careAbout() {
            addMsg(1002);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1002) {
                CarModeOfflineMapDataFragment.this.reAddEditTextView();
            }
        }
    };
    private OnKeyListener mOnKeyListener = new OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (!(event == null || event.getAction() != 0 || CarModeOfflineMapDataFragment.this.canSugShow)) {
                switch (keyCode) {
                    case 300:
                        if (CarModeOfflineMapDataFragment.this.mCityListAdapter.currentyCity != null && ((long) CarModeOfflineMapDataFragment.this.mElvOfflineMapData.getSelectedItemPosition()) == ((long) CarModeOfflineMapDataFragment.this.mCityListAdapter.baseCities.size())) {
                            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(20, event);
                            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(20, event);
                            return true;
                        }
                    case 301:
                        if (CarModeOfflineMapDataFragment.this.mCityListAdapter.currentyCity != null && ((long) CarModeOfflineMapDataFragment.this.mElvOfflineMapData.getSelectedItemPosition()) == ((long) (CarModeOfflineMapDataFragment.this.mCityListAdapter.baseCities.size() + 2))) {
                            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(19, event);
                            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(19, event);
                            return true;
                        } else if (((long) CarModeOfflineMapDataFragment.this.mElvOfflineMapData.getSelectedItemPosition()) == 1) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
    };
    private KeyboardEditText mSearchEditText;
    private String mSearchKey = "";
    private OnKeyListener mUpKeyListener = new OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                switch (keyCode) {
                    case 20:
                        if (CarModeOfflineMapDataFragment.this.canSugShow) {
                            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.requestFocus();
                            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.setSelection(0);
                            return true;
                        }
                        CarModeOfflineMapDataFragment.this.mElvOfflineMapData.requestFocus();
                        CarModeOfflineMapDataFragment.this.mElvOfflineMapData.setSelection(1);
                        return true;
                }
            }
            return false;
        }
    };
    private ViewGroup mViewGroup;
    private Object sync = new Object();

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$1 */
    class C38841 implements OnClickListener {
        C38841() {
        }

        public void onClick(View v) {
            CarModeOfflineMapDataFragment.this.pageBack(CarModeOfflineMapDataFragment.this.mModuleFrom);
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$2 */
    class C38852 implements OnFocusChangeListener {
        C38852() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            boolean iskeyboardShow = C2252a.a().b();
            if (hasFocus && iskeyboardShow) {
                C2252a.a().d();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$3 */
    class C38863 implements OnGroupClickListener {
        C38863() {
        }

        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
            LocalMapResource object = v.getTag(C0965R.id.tag_groupmap);
            if (LocalMapResource.class.isInstance(object)) {
                LocalMapResource city = object;
                if (city != null) {
                    CarModeOfflineMapDataFragment.this.mCityListAdapter.download(city);
                }
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$4 */
    class C38874 implements OnChildClickListener {
        C38874() {
        }

        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            LocalMapResource object = v.getTag(C0965R.id.tag_groupmap);
            if (LocalMapResource.class.isInstance(object)) {
                LocalMapResource city = object;
                if (city != null) {
                    CarModeOfflineMapDataFragment.this.mCityListAdapter.download(city);
                }
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$5 */
    class C38885 implements OnItemClickListener {
        C38885() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            TipTool.onCreateDebugToast(BaseFragment.getNaviActivity(), "item" + position);
            Object item = CarModeOfflineMapDataFragment.this.mCityListAdapter.getGroup(position);
            if (item != null && (item instanceof LocalMapResource)) {
                CarModeOfflineMapDataFragment.this.mCityListAdapter.download((LocalMapResource) item);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$6 */
    class C38896 implements OnScrollListener {
        C38896() {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            C0679d.a(CarModeOfflineMapDataFragment.this.getView());
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$7 */
    class C38907 implements OnEditorActionListener {
        C38907() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == 3) {
                CarModeOfflineMapDataFragment.this.onClickFinish();
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$8 */
    class C38918 implements C2249d {
        C38918() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                CarModeOfflineMapDataFragment.this.mEditLine.setBackgroundColor(CarModeOfflineMapDataFragment.this.getResources().getColor(C0965R.color.cl_other_c));
            } else {
                CarModeOfflineMapDataFragment.this.mEditLine.setBackgroundColor(CarModeOfflineMapDataFragment.this.getResources().getColor(C0965R.color.cl_line_a5));
                C0679d.a(CarModeOfflineMapDataFragment.this.getView());
            }
            CarModeOfflineMapDataFragment.this.mEdViewHasFocus = hasFocus;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$9 */
    class C38929 implements TextWatcher {
        C38929() {
        }

        public void afterTextChanged(Editable s) {
            CarModeOfflineMapDataFragment.this.mSearchKey = CarModeOfflineMapDataFragment.this.mSearchEditText.getText().toString().trim();
            if (TextUtils.isEmpty(CarModeOfflineMapDataFragment.this.mSearchKey)) {
                CarModeOfflineMapDataFragment.this.canSugShow = false;
            } else {
                CarModeOfflineMapDataFragment.this.canSugShow = true;
            }
            CarModeOfflineMapDataFragment.this.mCityListAdapter.reloadData();
            CarModeOfflineMapDataFragment.this.mCityListAdapter.notifyDataSetChanged();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    private class CityListAdapter extends BaseExpandableListAdapter implements OnClickListener {
        private static final int CHILD_TYPE_CITY = 0;
        private static final int CHILD_TYPE_EXPAND_CITY = 1;
        private static final int COLOR_BLUE = -16739346;
        private static final int COLOR_GRAY = -12895429;
        private static final int COLOR_RED = -983040;
        private static final int GROUP_TYPE_CITY = 2;
        private static final int GROUP_TYPE_PROVINCE = 1;
        private static final int GROUP_TYPE_TITLE = 0;
        private static final String LOG_KEY = "com.baidu.baidumaps.base.localmap.LocalMapCityListFragment";
        private List baseCities;
        private List currentData;
        private LocalMapResource currentyCity;
        private final LayoutInflater inflater;
        private List mDomesticData;

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$CityListAdapter$2 */
        class C38942 implements DialogInterface.OnClickListener {
            C38942() {
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
                    return getCityView(convertView, parent, (LocalMapResource) getGroup(groupPosition), true);
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
                    return getCityView(convertView, parent, (LocalMapResource) getChild(groupPosition, childPosition), true);
                case 1:
                    return getCityView(convertView, parent, (LocalMapResource) getChild(groupPosition, childPosition), false);
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
            int i;
            if (this.mDomesticData == null) {
                this.mDomesticData = new ArrayList();
                this.baseCities = new ArrayList();
                this.currentyCity = C0692f.a().k();
                if (this.currentyCity != null) {
                    this.baseCities.add(this.currentyCity);
                    for (LocalMapResource localMapResource : C0692f.a().m()) {
                        if (localMapResource.id == 1 && localMapResource.frc == 1) {
                            localMapResource.name = RoutePlanParams.COUNTRY_OFFLINE_DATA;
                            this.baseCities.add(localMapResource);
                        }
                    }
                    if (this.baseCities != null && this.baseCities.size() > 0) {
                        this.mDomesticData.add(StyleManager.getString(C0965R.string.carlife_map_data_city));
                        this.mDomesticData.addAll(this.baseCities);
                    }
                }
                List tempinternal = new ArrayList();
                List tempcity = new ArrayList();
                List tempabour = new ArrayList();
                List<LocalMapResource> cities = C0692f.a().m();
                if (cities != null && cities.size() > 0) {
                    i = 0;
                    while (i < cities.size()) {
                        if (((LocalMapResource) cities.get(i)).frc == 1) {
                            if (((LocalMapResource) cities.get(i)).id == NaviFragmentManager.TYPE_CAR_DRV_LIST || ((LocalMapResource) cities.get(i)).id == 289 || ((LocalMapResource) cities.get(i)).id == CarRouteProvider.WALK_START_STYLE || ((LocalMapResource) cities.get(i)).id == NaviFragmentManager.TYPE_CAR_DRV_SETTING) {
                                tempcity.add(cities.get(i));
                            } else if (this.currentyCity == null) {
                                tempinternal.add(cities.get(i));
                            } else if (((LocalMapResource) cities.get(i)).id != 1) {
                                tempinternal.add(cities.get(i));
                            }
                        } else if (((LocalMapResource) cities.get(i)).frc == 2 && (((LocalMapResource) cities.get(i)).id == 2912 || ((LocalMapResource) cities.get(i)).id == 9000 || ((LocalMapResource) cities.get(i)).id == 2911)) {
                            tempabour.add(cities.get(i));
                        }
                        i++;
                    }
                    this.mDomesticData.add(StyleManager.getString(C0965R.string.carlife_map_data_cityall));
                    this.mDomesticData.addAll(tempcity);
                    this.mDomesticData.addAll(tempabour);
                    this.mDomesticData.addAll(tempinternal);
                }
            }
            if (CarModeOfflineMapDataFragment.this.mSearchKey == null || CarModeOfflineMapDataFragment.this.mSearchKey.length() == 0) {
                this.currentData = this.mDomesticData;
                return;
            }
            List<LocalMapResource> citiesByName = C0692f.a().a(CarModeOfflineMapDataFragment.this.mSearchKey);
            List<LocalMapResource> relalData = new ArrayList();
            if (citiesByName != null && citiesByName.size() > 0) {
                i = 0;
                while (i < citiesByName.size()) {
                    if (((LocalMapResource) citiesByName.get(i)).type != 1) {
                        if (((LocalMapResource) citiesByName.get(i)).frc == 1) {
                            relalData.add(citiesByName.get(i));
                        } else if (((LocalMapResource) citiesByName.get(i)).frc == 2 && (((LocalMapResource) citiesByName.get(i)).id == 2912 || ((LocalMapResource) citiesByName.get(i)).id == 9000 || ((LocalMapResource) citiesByName.get(i)).id == 2911)) {
                            relalData.add(citiesByName.get(i));
                        }
                    }
                    i++;
                }
            }
            this.currentData = relalData;
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
            holder.expandButton.setImageResource(isExpanded ? C0965R.drawable.com_ic_up_dis : C0965R.drawable.com_ic_down_dis);
            C0679d.k(city);
            return convertView;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.view.View getCityView(android.view.View r21, android.view.ViewGroup r22, com.baidu.platform.comapi.map.LocalMapResource r23, boolean r24) {
            /*
            r20 = this;
            r0 = r20;
            r13 = com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment.this;
            r14 = r13.sync;
            monitor-enter(r14);
            r2 = 0;
            if (r21 != 0) goto L_0x01a3;
        L_0x000c:
            r3 = new com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment$CityListAdapter$Holder;	 Catch:{ all -> 0x01b6 }
            r13 = 0;
            r0 = r20;
            r3.<init>();	 Catch:{ all -> 0x01b6 }
            r0 = r20;
            r13 = r0.inflater;	 Catch:{ all -> 0x03f8 }
            r15 = 2130968680; // 0x7f040068 float:1.754602E38 double:1.052838417E-314;
            r16 = 0;
            r0 = r16;
            r21 = r13.inflate(r15, r0);	 Catch:{ all -> 0x03f8 }
            r13 = 2131624564; // 0x7f0e0274 float:1.8876311E38 double:1.053162467E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (android.widget.RelativeLayout) r13;	 Catch:{ all -> 0x03f8 }
            r3.mInfoLayout = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624575; // 0x7f0e027f float:1.8876334E38 double:1.0531624723E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (android.widget.RelativeLayout) r13;	 Catch:{ all -> 0x03f8 }
            r3.mStatusLayout = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624566; // 0x7f0e0276 float:1.8876315E38 double:1.053162468E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (android.widget.TextView) r13;	 Catch:{ all -> 0x03f8 }
            r3.mNameTV = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624567; // 0x7f0e0277 float:1.8876317E38 double:1.0531624684E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (android.widget.TextView) r13;	 Catch:{ all -> 0x03f8 }
            r3.mInfoTV = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624578; // 0x7f0e0282 float:1.887634E38 double:1.053162474E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (android.widget.TextView) r13;	 Catch:{ all -> 0x03f8 }
            r3.mInfoHint = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624565; // 0x7f0e0275 float:1.8876313E38 double:1.0531624674E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (android.widget.ImageView) r13;	 Catch:{ all -> 0x03f8 }
            r3.mTaskStatusIV = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624532; // 0x7f0e0254 float:1.8876246E38 double:1.053162451E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r3.mListDivider = r13;	 Catch:{ all -> 0x03f8 }
            r13 = 2131624576; // 0x7f0e0280 float:1.8876336E38 double:1.053162473E-314;
            r0 = r21;
            r13 = r0.findViewById(r13);	 Catch:{ all -> 0x03f8 }
            r13 = (com.baidu.navi.view.RoundProgressBar) r13;	 Catch:{ all -> 0x03f8 }
            r3.mRoundProgressBarDownloading = r13;	 Catch:{ all -> 0x03f8 }
            r0 = r21;
            r0.setTag(r3);	 Catch:{ all -> 0x03f8 }
            r2 = r3;
        L_0x008f:
            if (r23 == 0) goto L_0x03e8;
        L_0x0091:
            if (r2 == 0) goto L_0x03e8;
        L_0x0093:
            r13 = r2.mNameTV;	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r15 = r0.name;	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mRoundProgressBarDownloading;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mTaskStatusIV;	 Catch:{ all -> 0x01b6 }
            r15 = 2130838277; // 0x7f020305 float:1.7281532E38 double:1.0527739895E-314;
            r13.setImageResource(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mTaskStatusIV;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoHint;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mStatusLayout;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r2.city = r0;	 Catch:{ all -> 0x01b6 }
            r0 = r20;
            r13 = com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment.this;	 Catch:{ all -> 0x01b6 }
            r13 = r13.canSugShow;	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x01ad;
        L_0x00cf:
            r13 = r2.mListDivider;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
        L_0x00d5:
            r0 = r23;
            r13 = r0.id;	 Catch:{ all -> 0x01b6 }
            r15 = 1;
            if (r13 != r15) goto L_0x01b9;
        L_0x00dc:
            r13 = r2.mInfoHint;	 Catch:{ all -> 0x01b6 }
            r15 = 2131296332; // 0x7f09004c float:1.8210578E38 double:1.0530002987E-314;
            r15 = com.baidu.navi.style.StyleManager.getString(r15);	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoHint;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mListDivider;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
        L_0x00f4:
            if (r24 == 0) goto L_0x01c2;
        L_0x00f6:
            r13 = r2.mNameTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558700; // 0x7f0d012c float:1.8742723E38 double:1.053129926E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
        L_0x0102:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558690; // 0x7f0d0122 float:1.8742703E38 double:1.053129921E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r13 = r0.type;	 Catch:{ all -> 0x01b6 }
            r15 = 1;
            if (r13 == r15) goto L_0x0121;
        L_0x0115:
            r13 = com.baidu.baidumaps.base.localmap.C0692f.a();	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r15 = r0.id;	 Catch:{ all -> 0x01b6 }
            r23 = r13.h(r15);	 Catch:{ all -> 0x01b6 }
        L_0x0121:
            if (r23 == 0) goto L_0x03aa;
        L_0x0123:
            r13 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r0 = r23;
            r15 = r0.downloadProgress;	 Catch:{ all -> 0x01b6 }
            r15 = (float) r15;	 Catch:{ all -> 0x01b6 }
            r16 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
            r15 = r15 / r16;
            r8 = r13 - r15;
            r13 = r2.city;	 Catch:{ all -> 0x01b6 }
            r0 = r13.mapsize;	 Catch:{ all -> 0x01b6 }
            r16 = r0;
            r13 = r2.city;	 Catch:{ all -> 0x01b6 }
            r0 = r13.searchsize;	 Catch:{ all -> 0x01b6 }
            r18 = r0;
            r10 = r16 + r18;
            r13 = (float) r10;	 Catch:{ all -> 0x01b6 }
            r13 = r13 * r8;
            r4 = (long) r13;	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r13 = r0.type;	 Catch:{ all -> 0x01b6 }
            r15 = 1;
            if (r13 != r15) goto L_0x0150;
        L_0x014c:
            r0 = r23;
            r4 = r0.remainSize;	 Catch:{ all -> 0x01b6 }
        L_0x0150:
            r13 = com.baidu.baidumaps.base.localmap.C0679d.a(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x01d0;
        L_0x0156:
            r0 = r23;
            r13 = r0.version;	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x015c;
        L_0x015c:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r15.<init>();	 Catch:{ all -> 0x01b6 }
            r16 = 2131296353; // 0x7f090061 float:1.821062E38 double:1.053000309E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = " ";
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.toString();	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558646; // 0x7f0d00f6 float:1.8742614E38 double:1.053129899E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
        L_0x0190:
            r13 = r2.mInfoLayout;	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r13.setTag(r0);	 Catch:{ all -> 0x01b6 }
            r13 = 2131623941; // 0x7f0e0005 float:1.8875048E38 double:1.053162159E-314;
            r0 = r21;
            r1 = r23;
            r0.setTag(r13, r1);	 Catch:{ all -> 0x01b6 }
        L_0x01a1:
            monitor-exit(r14);	 Catch:{ all -> 0x01b6 }
            return r21;
        L_0x01a3:
            r13 = r21.getTag();	 Catch:{ all -> 0x01b6 }
            r0 = r13;
            r0 = (com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment.CityListAdapter.Holder) r0;	 Catch:{ all -> 0x01b6 }
            r2 = r0;
            goto L_0x008f;
        L_0x01ad:
            r13 = r2.mListDivider;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x00d5;
        L_0x01b6:
            r13 = move-exception;
        L_0x01b7:
            monitor-exit(r14);	 Catch:{ all -> 0x01b6 }
            throw r13;
        L_0x01b9:
            r13 = r2.mInfoHint;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x00f4;
        L_0x01c2:
            r13 = r2.mNameTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558690; // 0x7f0d0122 float:1.8742703E38 double:1.053129921E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x0102;
        L_0x01d0:
            r13 = com.baidu.baidumaps.base.localmap.C0679d.b(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x021a;
        L_0x01d6:
            r0 = r23;
            r13 = r0.version;	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x01dc;
        L_0x01dc:
            r0 = r23;
            r13 = r0.downloadStatus;	 Catch:{ all -> 0x01b6 }
            r15 = 10;
            if (r13 != r15) goto L_0x01e4;
        L_0x01e4:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r15.<init>();	 Catch:{ all -> 0x01b6 }
            r16 = 2131296339; // 0x7f090053 float:1.8210592E38 double:1.053000302E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = " ";
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.toString();	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558646; // 0x7f0d00f6 float:1.8742614E38 double:1.053129899E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x0190;
        L_0x021a:
            r13 = com.baidu.baidumaps.base.localmap.C0679d.c(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x0271;
        L_0x0220:
            r0 = r23;
            r13 = r0.downloadStatus;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            if (r13 != r15) goto L_0x0269;
        L_0x0228:
            r0 = r20;
            r13 = com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment.this;	 Catch:{ all -> 0x01b6 }
            r13 = r13.getActivity();	 Catch:{ all -> 0x01b6 }
            com.baidu.platform.comapi.util.NetworkUtil.isWifiConnected(r13);	 Catch:{ all -> 0x01b6 }
        L_0x0233:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r15.<init>();	 Catch:{ all -> 0x01b6 }
            r16 = 2131296351; // 0x7f09005f float:1.8210616E38 double:1.053000308E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = " ";
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r4);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.toString();	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558641; // 0x7f0d00f1 float:1.8742604E38 double:1.0531298966E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x0190;
        L_0x0269:
            r0 = r23;
            r13 = r0.downloadStatus;	 Catch:{ all -> 0x01b6 }
            r15 = 6;
            if (r13 != r15) goto L_0x0233;
        L_0x0270:
            goto L_0x0233;
        L_0x0271:
            r13 = com.baidu.baidumaps.base.localmap.C0679d.g(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 != 0) goto L_0x027d;
        L_0x0277:
            r13 = com.baidu.baidumaps.base.localmap.C0679d.f(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x0363;
        L_0x027d:
            r0 = r23;
            r0 = r0.mapoldsize;	 Catch:{ all -> 0x01b6 }
            r16 = r0;
            r0 = r23;
            r0 = r0.searcholdsize;	 Catch:{ all -> 0x01b6 }
            r18 = r0;
            r16 = r16 + r18;
            r6 = com.baidu.baidumaps.base.localmap.C0679d.a(r16);	 Catch:{ all -> 0x01b6 }
            r0 = r23;
            r0 = r0.mappatchsize;	 Catch:{ all -> 0x01b6 }
            r16 = r0;
            r0 = r23;
            r0 = r0.searchpatchsize;	 Catch:{ all -> 0x01b6 }
            r18 = r0;
            r16 = r16 + r18;
            r7 = com.baidu.baidumaps.base.localmap.C0679d.a(r16);	 Catch:{ all -> 0x01b6 }
            r13 = com.baidu.baidumaps.base.localmap.C0679d.j(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 != 0) goto L_0x030d;
        L_0x02a7:
            r0 = r23;
            r13 = r0.downloadStatus;	 Catch:{ all -> 0x01b6 }
            r15 = 9;
            if (r13 == r15) goto L_0x02e8;
        L_0x02af:
            r0 = r23;
            r13 = r0.updateStatus;	 Catch:{ all -> 0x01b6 }
            r15 = 4;
            if (r13 == r15) goto L_0x02e8;
        L_0x02b6:
            r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r13.<init>();	 Catch:{ all -> 0x01b6 }
            r15 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r15 = com.baidu.navi.style.StyleManager.getString(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r13.append(r15);	 Catch:{ all -> 0x01b6 }
            r15 = " ";
            r13 = r13.append(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r13.append(r7);	 Catch:{ all -> 0x01b6 }
            r9 = r13.toString();	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r13.setText(r9);	 Catch:{ all -> 0x01b6 }
        L_0x02da:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = 2131558646; // 0x7f0d00f6 float:1.8742614E38 double:1.053129899E-314;
            r15 = com.baidu.navi.style.StyleManager.getColor(r15);	 Catch:{ all -> 0x01b6 }
            r13.setTextColor(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x0190;
        L_0x02e8:
            r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r13.<init>();	 Catch:{ all -> 0x01b6 }
            r15 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r15 = com.baidu.navi.style.StyleManager.getString(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r13.append(r15);	 Catch:{ all -> 0x01b6 }
            r15 = " ";
            r13 = r13.append(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r13.append(r7);	 Catch:{ all -> 0x01b6 }
            r12 = r13.toString();	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r13.setText(r12);	 Catch:{ all -> 0x01b6 }
            goto L_0x02da;
        L_0x030d:
            r0 = r23;
            r13 = r0.updateStatus;	 Catch:{ all -> 0x01b6 }
            r15 = 4;
            if (r13 != r15) goto L_0x033d;
        L_0x0314:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r15.<init>();	 Catch:{ all -> 0x01b6 }
            r16 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = " ";
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r10);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.toString();	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x02da;
        L_0x033d:
            r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r13.<init>();	 Catch:{ all -> 0x01b6 }
            r15 = 2131296348; // 0x7f09005c float:1.821061E38 double:1.0530003067E-314;
            r15 = com.baidu.navi.style.StyleManager.getString(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r13.append(r15);	 Catch:{ all -> 0x01b6 }
            r15 = " ";
            r13 = r13.append(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r13.append(r7);	 Catch:{ all -> 0x01b6 }
            r9 = r13.toString();	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r13.setText(r9);	 Catch:{ all -> 0x01b6 }
            goto L_0x02da;
        L_0x0363:
            r13 = com.baidu.baidumaps.base.localmap.C0679d.d(r23);	 Catch:{ all -> 0x01b6 }
            if (r13 == 0) goto L_0x0393;
        L_0x0369:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b6 }
            r15.<init>();	 Catch:{ all -> 0x01b6 }
            r16 = 2131296344; // 0x7f090058 float:1.8210602E38 double:1.0530003047E-314;
            r16 = com.baidu.navi.style.StyleManager.getString(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = " ";
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r16 = com.baidu.baidumaps.base.localmap.C0679d.a(r10);	 Catch:{ all -> 0x01b6 }
            r15 = r15.append(r16);	 Catch:{ all -> 0x01b6 }
            r15 = r15.toString();	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x0190;
        L_0x0393:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = com.baidu.baidumaps.base.localmap.C0679d.a(r10);	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mTaskStatusIV;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mStatusLayout;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x0190;
        L_0x03aa:
            r13 = r2.mInfoTV;	 Catch:{ all -> 0x01b6 }
            r15 = r2.city;	 Catch:{ all -> 0x01b6 }
            r0 = r15.mapsize;	 Catch:{ all -> 0x01b6 }
            r16 = r0;
            r15 = r2.city;	 Catch:{ all -> 0x01b6 }
            r0 = r15.searchsize;	 Catch:{ all -> 0x01b6 }
            r18 = r0;
            r16 = r16 + r18;
            r15 = com.baidu.baidumaps.base.localmap.C0679d.a(r16);	 Catch:{ all -> 0x01b6 }
            r13.setText(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mTaskStatusIV;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mStatusLayout;	 Catch:{ all -> 0x01b6 }
            r15 = 0;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoLayout;	 Catch:{ all -> 0x01b6 }
            r15 = r2.city;	 Catch:{ all -> 0x01b6 }
            r13.setTag(r15);	 Catch:{ all -> 0x01b6 }
            r13 = 2131623941; // 0x7f0e0005 float:1.8875048E38 double:1.053162159E-314;
            r15 = r2.city;	 Catch:{ all -> 0x01b6 }
            r0 = r21;
            r0.setTag(r13, r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x01a1;
        L_0x03e8:
            r13 = r2.mListDivider;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            r13 = r2.mInfoLayout;	 Catch:{ all -> 0x01b6 }
            r15 = 8;
            r13.setVisibility(r15);	 Catch:{ all -> 0x01b6 }
            goto L_0x01a1;
        L_0x03f8:
            r13 = move-exception;
            r2 = r3;
            goto L_0x01b7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment.CityListAdapter.getCityView(android.view.View, android.view.ViewGroup, com.baidu.platform.comapi.map.LocalMapResource, boolean):android.view.View");
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0965R.id.info_relativelayout:
                    LocalMapResource city = (LocalMapResource) view.getTag();
                    if (city != null) {
                        download(city);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private void download(final LocalMapResource city) {
            if (C0679d.b(city)) {
                TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), StyleManager.getString(C0965R.string.carlife_map_data_download_city));
            } else if (C0679d.d(city)) {
                TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), StyleManager.getString(C0965R.string.carlife_map_data_city_downloaded));
            } else if (!C0679d.g(city) && !C0679d.f(city) && !C0679d.c(city) && !C0679d.e(city) && !C0679d.a(city) && C0679d.h(city)) {
                C0679d.a(CarModeOfflineMapDataFragment.this.getActivity(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        C0692f.a().a(city.id);
                    }
                }, new C38942());
            }
        }

        private void delete(final LocalMapResource city) {
            Activity activity = CarModeOfflineMapDataFragment.this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        C0692f.a().f(city.id);
                        CityListAdapter.this.reloadData();
                        CityListAdapter.this.notifyDataSetChanged();
                        if (!C0679d.d(city)) {
                        }
                    }
                };
            }
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.car_mode_frag_offline_map_data, null);
        initview();
        bindEvents();
        initData();
        return this.mViewGroup;
    }

    private void initData() {
        C0692f.a().addObserver(this);
    }

    private void initview() {
        this.mBtnBack = (ImageButton) this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_back);
        this.mBtnBack.setBackground(C2251b.a(mActivity));
        this.mElvOfflineMapData = (ExpandableListView) this.mViewGroup.findViewById(C0965R.id.elv_offline_map_data);
        this.mCityListAdapter = new CityListAdapter(BaseFragment.getNaviActivity());
        this.mElvOfflineMapData.setAdapter(this.mCityListAdapter);
        this.mSearchEditText = (KeyboardEditText) this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit);
        this.mEditTextContentLayout = (LinearLayout) this.mViewGroup.findViewById(C0965R.id.edittext_content_layout);
        this.mEditLine = this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit_line);
    }

    private void bindEvents() {
        this.mBtnBack.setOnClickListener(new C38841());
        this.mSearchEditText.addTextChangedListener(getTextChangedListener());
        KeyboardEditText keyboardEditText = this.mSearchEditText;
        C2252a a = C2252a.a();
        a.getClass();
        keyboardEditText.setOnTouchListener(new C2245a(a, this.mSearchEditText, 6, this, getFocusChangeListener()));
        this.mElvOfflineMapData.setOnScrollListener(getOnScrollListener());
        this.mElvOfflineMapData.setOnFocusChangeListener(new C38852());
        this.mElvOfflineMapData.setOnGroupClickListener(new C38863());
        this.mElvOfflineMapData.setOnChildClickListener(new C38874());
        C1261k.a(this.mHandler);
    }

    protected void onInitView() {
    }

    public void onPause() {
        super.onPause();
        C0679d.a(getView());
        C2252a.a().d();
    }

    public boolean onBackPressed() {
        pageBack(this.mModuleFrom);
        return true;
    }

    private OnItemClickListener getOnItemClickListener() {
        return new C38885();
    }

    private OnScrollListener getOnScrollListener() {
        return new C38896();
    }

    private OnEditorActionListener getOnEditorActionListener() {
        return new C38907();
    }

    private C2249d getFocusChangeListener() {
        return new C38918();
    }

    private TextWatcher getTextChangedListener() {
        return new C38929();
    }

    public void reAddEditTextView() {
        if (C1190a.a() && this.mEditTextContentLayout != null && this.mSearchEditText != null && this.mSearchKey != null) {
            View view = LayoutInflater.from(mActivity).inflate(C0965R.layout.carmode_map_data_edit_text_view, null);
            LayoutParams lp = new LayoutParams(-1, ScreenUtil.getInstance().dip2px(48));
            this.mEditTextContentLayout.removeAllViews();
            this.mEditTextContentLayout.addView(view, lp);
            if (this.mSearchEditText != null) {
                this.mSearchEditText.setEnabled(false);
                this.mSearchEditText = (KeyboardEditText) view.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit);
                this.mSearchEditText.setEnabled(true);
                this.mSearchEditText.addTextChangedListener(getTextChangedListener());
                KeyboardEditText keyboardEditText = this.mSearchEditText;
                C2252a a = C2252a.a();
                a.getClass();
                keyboardEditText.setOnTouchListener(new C2245a(a, this.mSearchEditText, 3, this, getFocusChangeListener()));
                try {
                    if (!this.mSearchKey.isEmpty()) {
                        this.mSearchEditText.getEditableText().append(this.mSearchKey);
                    }
                } catch (Exception e) {
                }
                C2252a.a().a(this.mSearchEditText);
                this.mFocusAreaUp = null;
            }
        }
    }

    public void update(Observable observable, Object o) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (CarModeOfflineMapDataFragment.this.mCityListAdapter != null) {
                        CarModeOfflineMapDataFragment.this.mCityListAdapter.reloadData();
                        CarModeOfflineMapDataFragment.this.mCityListAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    public void onClickFinish() {
        if (!this.isSearchEnable) {
        }
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        if (this.mFocusAreaUp == null) {
            this.mFocusAreaUp = new C1443g(this.mViewGroup.findViewById(C0965R.id.relative_offline_map_data), 2);
            this.mFocusAreaUp.d(this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_back)).d(this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit));
            this.mFocusAreaUp.a(this.mUpKeyListener);
        }
        if (this.mFocusListView == null) {
            this.mFocusListView = new C1438c(this.mElvOfflineMapData, 6);
            this.mFocusListView.a(this.mOnKeyListener);
        }
        C1440d.a().b(new C1436a[]{this.mFocusAreaUp, this.mFocusListView});
        C1440d.a().h(this.mFocusAreaUp);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            C0692f.a().deleteObserver(this);
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
        } catch (Exception e) {
        }
        C1261k.b(this.mHandler);
    }
}
