package com.baidu.navi.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1437b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.common.util.FileUtils;
import com.baidu.navi.controller.NameSearchHelper;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.protocol.model.HUDGuideDataStruct;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.db.model.SearchNameHistroyModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NameSearchFragment extends ContentFragment implements OnClickListener {
    public static final String COME_FROM = "come_from";
    public static final int COME_FROM_DISCOVER_OIL = 8;
    public static final int INCOMING_CARLIFE_MAP_PAGE = 6;
    public static final int INCOMING_INTENT_API_COMMAND = 4;
    public static final int INCOMING_MORE_CATALOG_SEARCH = 1;
    public static final int INCOMING_NAME_SEARCH = 2;
    public static final int INCOMING_REMAIN_OIL_COMMAND = 5;
    public static final int INCOMING_ROUTE_PLAN_NODE_PAGE = 7;
    public static final String INCOMING_TYPE = "incoming_type";
    public static final int INCOMING_VOICE_COMMAND = 3;
    public static final String INTENT_API_POI_POINT = "intent_api_point";
    public static final String INTENT_API_POI_RADIUS = "intent_api_radius";
    public static final String POI_CENTER_MODE = "poi_center_mode";
    private static final String TAG = "PoiSearch";
    public static final String VOICE_SEARCH_KEY = "voice_key";
    private int cityId = 0;
    private boolean hasData = false;
    private GeoPoint intentApiPoint;
    private int intentApiRadius = 0;
    private boolean isFromIntentApi = false;
    private boolean isFromVoice = false;
    private boolean isPoiSearchMod = false;
    private boolean isSpaceSearchMode = false;
    private GridViewAdapter mAdapter;
    private C1953c mAlertDlg = null;
    private ImageButton mBackBtn;
    private GeoPoint mCurrentGeoPoint;
    private SearchPoi mCurrentPoi;
    private DistrictInfo mDistrictInfo;
    private C1443g mFocusAreaUp;
    private C1437b mFocusGridView;
    private GridView mGridView;
    private ViewGroup mGroupView;
    private Handler mHandler = new C38072();
    private int mLastOrientation = 0;
    private C0672b mSearchDialogCancelListener = new C38105();
    private int mSearchId;
    private String mSearchKey;
    private ImageButton mVoiceBtn;
    private int netMode = 3;

    /* renamed from: com.baidu.navi.fragment.NameSearchFragment$1 */
    class C38061 implements OnItemClickListener {
        C38061() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Item item = NameSearchFragment.this.mAdapter.getItem(position);
            if (item.type != 2) {
                NameSearchHelper.getInstance().search(BaseFragment.mActivity, NameSearchFragment.this, item.name, Long.decode("0x" + item.id).intValue(), 3, false, false);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.NameSearchFragment$2 */
    class C38072 extends Handler {
        C38072() {
        }

        public void handleMessage(Message msg) {
            if (NameSearchFragment.this.canProcessUI()) {
                RspData rsp = msg.obj;
                if (msg.what == 1005) {
                    C1307e.a().c();
                    SearchPoiPager searchPoiPager = rsp.mData;
                    if (searchPoiPager != null) {
                        searchPoiPager.setNetMode(BNPoiSearcher.getInstance().getNetModeOfLastResult());
                        switch (searchPoiPager.getSearchType()) {
                            case 1:
                                if (msg.arg1 != 0) {
                                    C1260i.e("PoiSearch", "Name Search fail");
                                    TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                                    if (C1912n.a().l()) {
                                        C1261k.b(4162);
                                        break;
                                    }
                                }
                                NameSearchFragment.this.handleNameSearchSuc(searchPoiPager);
                                C1261k.b(4160);
                                break;
                                break;
                            case 3:
                                if (msg.arg1 != 0) {
                                    C1260i.e("PoiSearch", "Space Search fail");
                                    TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                                    if (C1912n.a().l()) {
                                        C1261k.b(4162);
                                        break;
                                    }
                                }
                                C1260i.e("PoiSearch", "onSearchCatalogSucc()");
                                NameSearchFragment.this.handleSpaceKeySearchSuc(searchPoiPager);
                                C1261k.b(4160);
                                return;
                                break;
                            case 5:
                                if (msg.arg1 != 0) {
                                    C1260i.e("PoiSearch", "Space Search fail");
                                    TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), (int) C0965R.string.search_space_result_failed);
                                    break;
                                }
                                C1260i.e("PoiSearch", "onSearchCatalogSucc()");
                                NameSearchFragment.this.handleSpaceCatalogSearchSuc(searchPoiPager);
                                C1261k.b(4160);
                                break;
                        }
                        if (NameSearchFragment.this.isFromVoice && msg.arg1 != 0) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                        }
                    } else if (NameSearchFragment.this.netMode == 1 && NameSearchFragment.this.hasData) {
                        NameSearchFragment.this.handleTimeout((SearchPoiPager) rsp.mReq.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGER));
                        NameSearchFragment.this.hasData = false;
                    } else {
                        C1260i.e("PoiSearch", "search with pager fail");
                        if (NameSearchFragment.this.isFromVoice) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                        }
                        TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        if (C1912n.a().l()) {
                            C1261k.b(4162);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.NameSearchFragment$4 */
    class C38094 implements C0672b {
        C38094() {
        }

        public void onClick() {
            NameSearchFragment.this.dismissTwoBtnDialog();
        }
    }

    /* renamed from: com.baidu.navi.fragment.NameSearchFragment$5 */
    class C38105 implements C0672b {
        C38105() {
        }

        public void onClick() {
            BNPoiSearcher.getInstance().cancelQuery();
            C1261k.b(4165);
        }
    }

    private class GridViewAdapter extends BaseAdapter {
        private List<Item> datas = new ArrayList();

        class Item {
            String icon;
            String id;
            String name;
            int type;

            Item(GridViewAdapter this$1, int type, String name, String id) {
                this(type, name, id, "");
            }

            Item(int type, String name, String id, String icon) {
                this.type = 0;
                this.name = "";
                this.id = "";
                this.icon = "";
                this.type = type;
                this.name = name;
                this.id = id;
                this.icon = icon;
            }
        }

        private class ViewHolder {
            TextView textView;

            private ViewHolder() {
            }
        }

        public GridViewAdapter() {
            initData();
        }

        private void initData() {
            try {
                JSONArray array = new JSONArray(FileUtils.getStringFromAssertFile(NameSearchFragment.this.getContext(), "name_search_item.json"));
                int len = array.length();
                for (int i = 0; i < len; i++) {
                    JSONObject json = array.getJSONObject(i);
                    int type = json.getInt("type");
                    if (type == 1) {
                        this.datas.add(new Item(type, json.getString("name"), json.getString("id"), json.getString(HUDGuideDataStruct.KEY_ICON_NAME)));
                    } else {
                        this.datas.add(new Item(this, type, json.getString("name"), json.getString("id")));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return this.datas.size();
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public Item getItem(int position) {
            return (Item) this.datas.get(position);
        }

        public int getViewTypeCount() {
            return 2;
        }

        public int getItemViewType(int position) {
            return getItem(position).type == 1 ? 0 : 1;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                int resource = C0965R.layout.name_search_gridview_item2;
                if (getItemViewType(position) == 0) {
                    resource = C0965R.layout.name_search_gridview_item1;
                }
                convertView = LayoutInflater.from(NameSearchFragment.this.getContext()).inflate(resource, parent, false);
                viewHolder.textView = (TextView) convertView.findViewById(C0965R.id.name_search_gridview_item_txt);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Item item = getItem(position);
            viewHolder.textView.setText(item.name);
            if (getItemViewType(position) == 0) {
                Resources res = NameSearchFragment.this.getContext().getResources();
                int indentify = res.getIdentifier(NameSearchFragment.this.getContext().getPackageName() + ":drawable/" + item.icon, null, null);
                if (indentify > 0) {
                    Drawable top;
                    if (VERSION.SDK_INT >= 21) {
                        top = res.getDrawable(indentify, null);
                    } else {
                        top = res.getDrawable(indentify);
                    }
                    viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                }
            } else {
                viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            switch (item.type) {
                case 1:
                    viewHolder.textView.setTextColor(NameSearchFragment.this.getResources().getColor(C0965R.color.cl_text_a5_content));
                    break;
                case 2:
                    viewHolder.textView.setTextColor(NameSearchFragment.this.getResources().getColor(C0965R.color.cl_text_a1_content));
                    break;
                case 3:
                    viewHolder.textView.setTextColor(NameSearchFragment.this.getResources().getColor(C0965R.color.cl_text_a2_content));
                    break;
            }
            return convertView;
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mLastOrientation = getResources().getConfiguration().orientation;
        this.mGroupView = (ViewGroup) inflater.inflate(C0965R.layout.carmode_frag_name_search, null);
        findViews();
        updateDistrict();
        return this.mGroupView;
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        initFocusChain(this.mGroupView);
    }

    private void findViews() {
        this.mBackBtn = (ImageButton) this.mGroupView.findViewById(C0965R.id.name_search_back);
        this.mBackBtn.setOnClickListener(this);
        this.mVoiceBtn = (ImageButton) this.mGroupView.findViewById(C0965R.id.name_search_voice);
        this.mGridView = (GridView) this.mGroupView.findViewById(C0965R.id.name_search_gridView);
        this.mGridView.setOnItemClickListener(new C38061());
    }

    protected void onInitView() {
        C1260i.e("PoiSearch", "onInitView()");
        getBundle();
    }

    public void onResume() {
        super.onResume();
        updateDistrict();
        clearLastResult();
        if (this.mAdapter == null) {
            this.mAdapter = new GridViewAdapter();
            this.mGridView.setAdapter(this.mAdapter);
        } else {
            this.mAdapter.notifyDataSetChanged();
        }
        boolean isDataDownloaded;
        if (this.isSpaceSearchMode) {
            this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
            isDataDownloaded = SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedByPoint(this.mCurrentGeoPoint);
        } else {
            isDataDownloaded = SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
        }
        if (this.mDistrictInfo == null) {
            C1260i.b("PoiSearch", "mDistrictInfo null");
            return;
        }
        C1260i.b("PoiSearch", "mDistrictInfo " + this.mDistrictInfo);
        if (NavMapManager.getInstance().getNaviMapMode() == 5) {
            C0705a.a().e();
            C0705a.a().g();
            NavMapManager.getInstance().handleMapOverlays(0);
            NavMapManager.getInstance().setNaviMapMode(0);
        }
    }

    public void onPause() {
        BNPoiSearcher.getInstance().cancelQuery();
        C1307e.a().c();
        super.onPause();
    }

    protected void onUpdateOrientation(int orientation) {
        if (orientation != this.mLastOrientation) {
            this.mLastOrientation = orientation;
        }
    }

    public boolean onBackPressed() {
        C1307e.a().c();
        pageBack(this.mModuleFrom);
        return true;
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    private void updateDistrict() {
        SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
        this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
        if (this.mDistrictInfo == null) {
            this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.name_search_back:
                onBackPressed();
                return;
            case C0965R.id.name_search_voice:
                C1912n.a().f();
                return;
            default:
                return;
        }
    }

    private void getBundle() {
        int from = 0;
        if (this.mShowBundle != null) {
            from = this.mShowBundle.getInt("incoming_type");
        }
        switch (from) {
            case 1:
                C1260i.e("PoiSearch", "catalog in space search");
                this.isSpaceSearchMode = true;
                if (this.mShowBundle.containsKey("poi_center_mode")) {
                    this.isPoiSearchMod = this.mShowBundle.getBoolean("poi_center_mode");
                    if (this.isPoiSearchMod) {
                        this.mCurrentPoi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSpaceSearchPoi();
                        return;
                    }
                    return;
                }
                return;
            case 2:
                this.isSpaceSearchMode = true;
                if (this.mShowBundle.containsKey("poi_center_mode")) {
                    this.isPoiSearchMod = this.mShowBundle.getBoolean("poi_center_mode");
                    if (this.isPoiSearchMod) {
                        this.mCurrentPoi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSpaceSearchPoi();
                    }
                }
                initFocusChain(this.mGroupView);
                return;
            case 3:
                String key = null;
                this.isFromVoice = true;
                if (this.mShowBundle.containsKey(VOICE_SEARCH_KEY)) {
                    key = this.mShowBundle.getString(VOICE_SEARCH_KEY);
                }
                if (this.mShowBundle.containsKey("poi_center_mode")) {
                    this.isSpaceSearchMode = this.mShowBundle.getBoolean("poi_center_mode");
                    if (this.isSpaceSearchMode) {
                        trySearchSpace(key);
                        return;
                    } else {
                        trySearch(key);
                        return;
                    }
                }
                return;
            case 4:
                String key1 = null;
                if (this.mShowBundle.containsKey(VOICE_SEARCH_KEY)) {
                    key1 = this.mShowBundle.getString(VOICE_SEARCH_KEY);
                }
                if (this.mShowBundle.containsKey("poi_center_mode")) {
                    this.isSpaceSearchMode = this.mShowBundle.getBoolean("poi_center_mode");
                    if (this.isSpaceSearchMode) {
                        this.isFromIntentApi = true;
                        if (this.mShowBundle.containsKey(INTENT_API_POI_POINT)) {
                            this.intentApiPoint = parseGeoPointFromString(this.mShowBundle.getString(INTENT_API_POI_POINT));
                        }
                        if (this.mShowBundle.containsKey(INTENT_API_POI_RADIUS)) {
                            this.intentApiRadius = this.mShowBundle.getInt(INTENT_API_POI_RADIUS);
                        }
                        SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
                        trySearchSpace(Long.decode("0x" + key1).intValue());
                        return;
                    }
                    trySearch(key1);
                    return;
                }
                return;
            case 5:
                this.mSearchKey = ActionTypeSearchParams.Gas_Station;
                this.mSearchId = Long.decode("0x7b40").intValue();
                trySearchSpace(this.mSearchId);
                return;
            case 6:
                this.isSpaceSearchMode = true;
                if (this.mShowBundle.containsKey("poi_center_mode")) {
                    this.isPoiSearchMod = this.mShowBundle.getBoolean("poi_center_mode");
                    if (this.isPoiSearchMod) {
                        this.mCurrentPoi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSpaceSearchPoi();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private GeoPoint parseGeoPointFromString(String geoString) {
        if (TextUtils.isEmpty(geoString)) {
            return null;
        }
        String[] geoArr = geoString.split(",");
        if (geoArr == null || geoArr.length != 2 || TextUtils.isEmpty(geoArr[0]) || TextUtils.isEmpty(geoArr[0])) {
            return null;
        }
        try {
            return new GeoPoint((int) (Double.valueOf(geoArr[1]).doubleValue() * 100000.0d), (int) (100000.0d * Double.valueOf(geoArr[0]).doubleValue()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void handleNameSearchSuc(SearchPoiPager searchPoiPager) {
        List<SearchPoiPager> searchPoiPagers = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
        if (searchPoiPagers.size() != 1) {
            resultEmpty(searchPoiPager);
            return;
        }
        List<SearchPoi> poiList = ((SearchPoiPager) searchPoiPagers.get(0)).getPoiList();
        if (poiList == null || poiList.size() == 0) {
            resultEmpty(searchPoiPager);
            return;
        }
        SearchNameHistroyModel.getInstance().addSearchName(searchPoiPager.getSearchKey());
        Bundle bundle = this.mShowBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("search_key", searchPoiPager.getSearchKey());
        bundle.putInt("search_mode", this.netMode);
        bundle.putInt("search_type", 17);
        bundle.putInt("district_id", this.mDistrictInfo.mId);
        bundle.putInt(ContentFragmentManager.MODULE_FROM, this.mModuleFrom);
        if (this.isFromVoice) {
            bundle.putInt("incoming_type", 35);
            bundle.putInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, -1));
            bundle.putInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, -1));
            bundle.putInt(ContentFragmentManager.MODULE_FROM, this.mShowBundle.getInt(ContentFragmentManager.MODULE_FROM, 3));
        }
        showFragment(35, bundle);
    }

    private void handleSpaceKeySearchSuc(SearchPoiPager searchPoiPager) {
        List<SearchPoiPager> searchPoiPagers = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
        if (searchPoiPagers.size() != 1) {
            resultEmpty(searchPoiPager);
            return;
        }
        List<SearchPoi> poiList = ((SearchPoiPager) searchPoiPagers.get(0)).getPoiList();
        if (poiList == null || poiList.size() == 0) {
            resultEmpty(searchPoiPager);
            return;
        }
        SearchNameHistroyModel.getInstance().addSearchName(searchPoiPager.getSearchKey());
        Bundle bundle = this.mShowBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("search_key", searchPoiPager.getSearchKey());
        bundle.putInt("district_id", this.cityId);
        bundle.putInt("search_mode", this.netMode);
        bundle.putInt("search_type", 18);
        if (this.isPoiSearchMod) {
            bundle.putBoolean("poi_center_mode", true);
        }
        if (this.isFromVoice) {
            bundle.putInt("incoming_type", 35);
            bundle.putInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, -1));
            bundle.putInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, -1));
            bundle.putInt(ContentFragmentManager.MODULE_FROM, this.mShowBundle.getInt(ContentFragmentManager.MODULE_FROM, 3));
        }
        showFragment(35, bundle);
    }

    private void handleSpaceCatalogSearchSuc(SearchPoiPager searchPoiPager) {
        List<SearchPoiPager> searchPoiPagers = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
        if (searchPoiPagers.size() != 1) {
            resultEmpty(searchPoiPager);
            return;
        }
        List<SearchPoi> poiList = ((SearchPoiPager) searchPoiPagers.get(0)).getPoiList();
        if (poiList == null || poiList.size() == 0) {
            resultEmpty(searchPoiPager);
            return;
        }
        SearchNameHistroyModel.getInstance().addSearchName(searchPoiPager.getSearchKey());
        Bundle bundle = this.mShowBundle;
        if (bundle.containsKey("incoming_type")) {
            loge("contains incoming key");
            if (bundle.getInt("incoming_type") == 5) {
                loge("来自一键加油");
            } else {
                loge("不是来自一键加油");
            }
        }
        if (bundle == null) {
            loge("bundle is null");
            bundle = new Bundle();
        }
        if (this.isPoiSearchMod) {
            bundle.putBoolean("poi_center_mode", true);
        }
        bundle.putString("search_key", this.mSearchKey);
        bundle.putInt("search_mode", this.netMode);
        if (bundle.getInt("incoming_type") == 5) {
            loge("来自一键加油，不用重新设置来源");
        } else {
            bundle.putInt("incoming_type", 33);
        }
        bundle.putInt("incoming_type", 33);
        bundle.putInt("search_type", 19);
        bundle.putInt("district_id", new DistrictInfo().mId);
        showFragment(35, bundle);
    }

    private void handleTimeout(SearchPoiPager searchPoiPager) {
        if (this.hasData && this.netMode == 1) {
            this.netMode = 0;
            if (searchPoiPager != null) {
                searchPoiPager.setNetMode(this.netMode);
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
                C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
                return;
            }
            return;
        }
        if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.search_result_toast_failed);
        if (C1912n.a().l()) {
            C1261k.b(4162);
        }
    }

    private void clearLastResult() {
        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
    }

    private void trySearch(String key) {
        this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeBySet(this.mDistrictInfo);
        int settingMode = BNSettingManager.getPrefSearchMode();
        this.netMode = getFinalNetMode(this.netMode);
        search(key);
    }

    private void search(String key) {
        SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
        if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode)) {
            if (BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(key, this.mDistrictInfo, 10, this.netMode), this.mHandler)) {
                C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            }
        } else if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private void trySearchSpace(String key) {
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid() || this.isPoiSearchMod) {
            if (this.isPoiSearchMod && this.mCurrentPoi != null) {
                this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
            }
            this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeByPoint(this.mCurrentGeoPoint);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            searchSpace(key);
            return;
        }
        if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_center_error);
    }

    private void searchSpace(String key) {
        SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
        SearchCircle circle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        DistrictInfo districtInfo = null;
        if (null == null) {
            districtInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
        if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode)) {
            BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(key, districtInfo, circle, 10, this.netMode), this.mHandler);
            C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
        } else if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private void trySearchSpace(int id) {
        if (this.isFromIntentApi && this.intentApiPoint != null && this.intentApiPoint.isValid()) {
            this.mCurrentGeoPoint = this.intentApiPoint;
        } else {
            this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        }
        if (BNLocationManagerProxy.getInstance().isLocationValid() || this.isPoiSearchMod) {
            if (this.isPoiSearchMod && this.mCurrentPoi != null) {
                this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
            }
            this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeByPoint(this.mCurrentGeoPoint);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            searchSpace(id);
            return;
        }
        if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_center_error);
    }

    private void searchSpace(int id) {
        int i = 5000;
        SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
        SearchCircle cricle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (this.isFromIntentApi) {
            this.isFromIntentApi = false;
            GeoPoint geoPoint = this.mCurrentGeoPoint;
            if (this.intentApiRadius != 0) {
                i = this.intentApiRadius;
            }
            cricle = new SearchCircle(geoPoint, i);
        }
        DistrictInfo districtInfo = null;
        if (null == null) {
            districtInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
        if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode)) {
            BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(id, districtInfo, cricle, 10, this.netMode), this.mHandler);
            C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
        } else if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private int getFinalNetMode(int mode) {
        int settingMode = BNSettingManager.getPrefSearchMode();
        if (mode == 0) {
            this.hasData = true;
        } else {
            this.hasData = false;
        }
        if (settingMode == 2) {
            if (this.hasData) {
                return 0;
            }
            return 1;
        } else if (NetworkUtils.isNetworkAvailable(getContext()) || !this.hasData) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean resultEmpty(final SearchPoiPager searchPoiPager) {
        if (this.netMode == 0 && this.hasData) {
            showTwoBtnDialog(C0965R.string.search_result_empty_offline, new C0672b() {
                public void onClick() {
                    NameSearchFragment.this.dismissTwoBtnDialog();
                    NameSearchFragment.this.netMode = 1;
                    if (SearchStrategyHelper.getInstance(NameSearchFragment.this.getContext()).checkCanSearchByNetMode(NameSearchFragment.this.netMode)) {
                        searchPoiPager.setNetMode(NameSearchFragment.this.netMode);
                        BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, NameSearchFragment.this.mHandler);
                        C1307e.a().a(NameSearchFragment.this.getResources().getString(C0965R.string.progress_searching), NameSearchFragment.this.mSearchDialogCancelListener);
                    }
                }
            }, new C38094());
            return true;
        } else if (this.netMode == 1) {
            if (this.hasData) {
                this.hasData = false;
                this.netMode = 0;
                searchPoiPager.setNetMode(this.netMode);
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
            } else {
                if (this.isFromVoice) {
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                }
                if (NetworkUtils.isNetworkAvailable(getContext())) {
                    TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.search_result_toast_failed);
                    if (C1912n.a().l()) {
                        C1261k.b(4162);
                    }
                } else {
                    TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_network_unavailable);
                    if (C1912n.a().l()) {
                        C1261k.b(4162);
                    }
                }
            }
            return false;
        } else {
            if (this.isFromVoice) {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
            }
            TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.search_result_toast_failed);
            if (!C1912n.a().l()) {
                return true;
            }
            C1261k.b(4162);
            return true;
        }
    }

    public void showTwoBtnDialog(int contentStr, C0672b confirmListener, C0672b cancleListener) {
        dismissTwoBtnDialog();
        if (this.mAlertDlg == null) {
            this.mAlertDlg = new C1953c(mActivity).a(contentStr).g(17).c(C0965R.string.alert_confirm).q().d(C0965R.string.alert_cancel);
            this.mAlertDlg.b(confirmListener);
            this.mAlertDlg.a(cancleListener);
        }
        showDialog(this.mAlertDlg);
    }

    public boolean dismissTwoBtnDialog() {
        dismissDialog(this.mAlertDlg);
        this.mAlertDlg = null;
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void initFocusChain(View root) {
        if (getCurrentFragmentType() == 34) {
            if (this.mFocusAreaUp == null) {
                this.mFocusAreaUp = new C1443g(root.findViewById(C0965R.id.name_search_focus_area_up), 2);
                this.mFocusAreaUp.d(this.mBackBtn);
            }
            if (this.mFocusGridView == null) {
                this.mFocusGridView = new C1437b(this.mGridView, 6);
            }
            C1440d.a().b(new C1436a[]{this.mFocusAreaUp, this.mFocusGridView});
            C1440d.a().h(this.mFocusGridView);
        }
    }

    protected void onUpdateSkin() {
        if (this.mBackBtn != null) {
            this.mBackBtn.setBackground(C2251b.a(getContext()));
        }
        if (this.mVoiceBtn != null) {
            this.mVoiceBtn.setBackground(C2251b.a(getContext()));
        }
    }

    public void driving() {
        C1260i.b("yftech", "NameSearchFragment driving");
        dismissAllDialog();
        if (C1343b.a().b()) {
            int from = 0;
            if (this.mShowBundle != null) {
                from = this.mShowBundle.getInt("incoming_type");
            }
            C1260i.b("yftech", "NameSearchFragment driving from:" + from);
            if (from == 8 || from == 3) {
                pageBack(this.mModuleFrom);
            } else {
                backTo(17, null);
            }
        } else {
            backTo(17, null);
        }
        C1342a.a().d();
    }

    public void stopDriving() {
    }

    private void dismissAllDialog() {
        if (!(mActivity == null || mActivity.isFinishing())) {
            C1307e.a().c();
        }
        dismissTwoBtnDialog();
    }
}
