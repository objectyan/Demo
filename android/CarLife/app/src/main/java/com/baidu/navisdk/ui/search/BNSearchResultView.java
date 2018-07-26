package com.baidu.navisdk.ui.search;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.search.xpulltorefresh.XListView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNListDialog;
import com.baidu.navisdk.ui.widget.BNMapControlPanel;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.ui.widget.BNMapTitleBar;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import com.google.android.support.v4.view.PagerAdapter;
import com.google.android.support.v4.view.ViewPager;
import com.google.android.support.v4.view.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BNSearchResultView extends RelativeLayout {
    public static final String DISTRICT_ID = "district_id";
    private static int FOCUS_HEIGHT_MIDDLE = ((ScreenUtil.getInstance().getWindowHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight()) - ScreenUtil.getInstance().dip2px(250));
    public static final int INCOMING_CATALOG_SEARCH = 33;
    public static final int INCOMING_QUICK_ROUTE_PLAN = 34;
    public static final String INCOMING_TYPE = "incoming_type";
    public static final int INCOMING_VOICE_COMMAND = 35;
    private static int MARGINTOP_NORMAL = ((ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight()) - ScreenUtil.getInstance().dip2px(100));
    private static int Middle_TOP_NORMAL = ScreenUtil.getInstance().dip2px(250);
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 50;
    public static final String SEACHRESULT_SHOW_NEWER_GUIDE_KEY = "searchresult_show_newer_key";
    public static final int SEARCH_CIRCLE_1000 = 1000;
    public static final int SEARCH_CIRCLE_2000 = 2000;
    public static final int SEARCH_CIRCLE_500 = 500;
    public static final int SEARCH_CIRCLE_5000 = 5000;
    public static final int SEARCH_CIRCLE_DEAFAULT = 5000;
    public static final String SEARCH_ID = "search_id";
    public static final String SEARCH_KEY = "search_key";
    public static final String SEARCH_NET_MODE = "search_mode";
    public static final String SEARCH_TYPE = "search_type";
    public static final int SEARCH_TYPE_NAME = 17;
    public static final int SEARCH_TYPE_SPACE_CATALOG = 19;
    public static final int SEARCH_TYPE_SPACE_KEY = 18;
    public static final String SORT_BY_DISTANCE = "sort_by_distance";
    public static final String SORT_BY_KEY = "sort_by_key";
    private static int VIEW_PAGE_FOCUS_HEIGHT = ScreenUtil.getInstance().dip2px(100);
    private static BNNetworkingDialog mNetworkingDialog;
    private static float mStartY;
    private int focusHeight = FOCUS_HEIGHT_MIDDLE;
    private boolean isSetPointMode = false;
    private Activity mActivity;
    private boolean mAddMapCtrlPanel = true;
    private BNMapObserver mBNMapObserver = new BNMapObserver() {
        public void update(BNSubject o, int type, int event, Object arg) {
            if (1 == type) {
                switch (event) {
                    case 257:
                        if (BNSearchResultView.this.mMapControlPanel != null) {
                            BNSearchResultView.this.mMapControlPanel.updateView();
                            break;
                        }
                        break;
                    case 262:
                        BNSearchResultView.this.handleCompassClicked();
                        break;
                    case 274:
                        if (BNSearchResultView.this.mMapControlPanel != null) {
                            BNSearchResultView.this.mMapControlPanel.updateView();
                            break;
                        }
                        break;
                }
            }
            if (2 == type) {
                switch (event) {
                    case 514:
                        if (BNSearchResultView.this.mMapControlPanel != null) {
                            BNSearchResultView.this.mMapControlPanel.handleSingleTouchGesture();
                        }
                        if (!(BNSearchResultView.this.mViewPager == null || BNSearchResultView.this.mViewPager.isShown() || BNSearchResultView.this.isGeoLayoutVisible() || BNSearchResultView.this.mLastTopMargin != BNSearchResultView.Middle_TOP_NORMAL)) {
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.MARGINTOP_NORMAL);
                            BNSearchResultView.this.mViewPager.setVisibility(0);
                            BNSearchResultView.this.mResultListView.setVisibility(8);
                            BNSearchResultView.this.mViewMapLayput.setVisibility(0);
                            BNSearchResultView.this.loadMapCtrlPanel(BNSearchResultView.this.view, true, true);
                            BNSearchResultView.this.focusHeight = BNSearchResultView.VIEW_PAGE_FOCUS_HEIGHT;
                            BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.MARGINTOP_NORMAL, BNSearchResultView.this.focusHeight);
                        }
                        BNSearchResultView.this.switchMapcontrolVisible();
                        return;
                    case 518:
                        if (BNSearchResultView.this.mMapControlPanel != null) {
                            BNSearchResultView.this.mMapControlPanel.handleScrollGesture();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private IBNSearchResultListener mBNSearchResutlListerner = null;
    private RelativeLayout mBgView;
    private View mBtnNameAddr;
    private View mBtnStartNavi;
    private BNListDialog mCityListDialog;
    private OnClickListener mClickListener = new C44775();
    private ImageView mCloseSortingIv;
    private Context mContext;
    private int mCurrentIndex = -1;
    private DistrictInfo mDistrict;
    View mDivider;
    private LinearLayout mDrawingLayout;
    private boolean mFirstItsOn = false;
    private FrameLayout mGeoLayout;
    private ImageView mHandleView;
    ImageView mIcResult;
    public IItsClickListener mItsClickListener = new C44753();
    private BNMessageDialog mItsSettingAlertDialog;
    private int mLastTopMargin = Middle_TOP_NORMAL;
    private float mLastY = -1.0f;
    private ILocationBtnClickListener mLocationBtnClickListener = new C44742();
    private BNMapControlPanel mMapControlPanel;
    private MapGLSurfaceView mNMapView;
    private RelativeLayout mNewerGuideLayout;
    private OnPageChangeListener mOnPageChangeListener = new C44819();
    private List<SearchPoi> mPreSearchCityList;
    public SearchResultAdapter mResultAdapter;
    private XListView mResultListView;
    private OnCancelListener mSearchDialogCancelListener = new C44808();
    private SearchPoiPager mSearchPoiPager;
    public SearchResultViewPagerAdapter mSearchResultViewPagerAdapter;
    private boolean mShowTwoBtn = true;
    private RelativeLayout mSortByDistance;
    private ImageView mSortByDistanceIv;
    private TextView mSortByDistanceTv;
    private RelativeLayout mSortByKey;
    private ImageView mSortByKeyIv;
    private TextView mSortByKeyTv;
    private RelativeLayout mSortingRl;
    private BNMapTitleBar mTitleBar;
    public OnTouchListener mTouchListener = new OnTouchListener() {
        public boolean onTouch(View v, MotionEvent ev) {
            if (BNSearchResultView.this.mLastY == -1.0f) {
                BNSearchResultView.this.mLastY = ev.getRawY();
            }
            switch (ev.getAction()) {
                case 0:
                    BNSearchResultView.this.mLastY = ev.getRawY();
                    BNSearchResultView.mStartY = ev.getRawY();
                    break;
                case 2:
                    float deltaY = ev.getRawY() - BNSearchResultView.this.mLastY;
                    BNSearchResultView.this.mLastY = ev.getRawY();
                    if (BNSearchResultView.this.getTopMargin() <= BNSearchResultView.this.mTitleBar.getHeight()) {
                        deltaY /= BNSearchResultView.OFFSET_RADIO;
                    }
                    BNSearchResultView.this.updateTopMargin(deltaY);
                    break;
                default:
                    LogUtil.m15791e("wywywy", "reset");
                    float startDel = ev.getRawY() - BNSearchResultView.mStartY;
                    int topMarginFinal = BNSearchResultView.this.getTopMargin();
                    if (Math.abs(startDel) >= 50.0f) {
                        if (topMarginFinal < BNSearchResultView.Middle_TOP_NORMAL && BNSearchResultView.this.mLastTopMargin == BNSearchResultView.Middle_TOP_NORMAL) {
                            if (BNSearchResultView.this.mViewPager.getVisibility() == 0) {
                                BNSearchResultView.this.mViewPager.setVisibility(8);
                                BNSearchResultView.this.mResultListView.setVisibility(0);
                                BNSearchResultView.this.mViewMapLayput.setVisibility(8);
                                BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
                                BNSearchResultView.this.focusHeight = BNSearchResultView.FOCUS_HEIGHT_MIDDLE;
                            }
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.this.mTitleBar.getHeight());
                        } else if (topMarginFinal < BNSearchResultView.Middle_TOP_NORMAL && BNSearchResultView.this.mLastTopMargin < BNSearchResultView.Middle_TOP_NORMAL) {
                            if (BNSearchResultView.this.mViewPager.getVisibility() == 0) {
                                BNSearchResultView.this.mViewPager.setVisibility(8);
                                BNSearchResultView.this.mResultListView.setVisibility(0);
                                BNSearchResultView.this.mViewMapLayput.setVisibility(8);
                                BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
                                BNSearchResultView.this.focusHeight = BNSearchResultView.FOCUS_HEIGHT_MIDDLE;
                                BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
                                if (BNSearchResultView.this.mMapControlPanel != null) {
                                    BNSearchResultView.this.mMapControlPanel.setVisible(false);
                                }
                            }
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.Middle_TOP_NORMAL);
                        } else if ((topMarginFinal > BNSearchResultView.MARGINTOP_NORMAL && BNSearchResultView.this.mLastTopMargin > BNSearchResultView.Middle_TOP_NORMAL) || BNSearchResultView.this.mLastTopMargin < BNSearchResultView.Middle_TOP_NORMAL) {
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.MARGINTOP_NORMAL);
                            BNSearchResultView.this.mViewPager.setVisibility(0);
                            BNSearchResultView.this.mResultListView.setVisibility(8);
                            BNSearchResultView.this.mViewMapLayput.setVisibility(0);
                            BNSearchResultView.this.loadMapCtrlPanel(BNSearchResultView.this.view, true, true);
                            BNSearchResultView.this.focusHeight = BNSearchResultView.VIEW_PAGE_FOCUS_HEIGHT;
                            BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.MARGINTOP_NORMAL, BNSearchResultView.this.focusHeight);
                        } else if (topMarginFinal > BNSearchResultView.Middle_TOP_NORMAL && BNSearchResultView.this.mLastTopMargin == BNSearchResultView.Middle_TOP_NORMAL) {
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.MARGINTOP_NORMAL);
                            BNSearchResultView.this.mViewPager.setVisibility(0);
                            BNSearchResultView.this.mResultListView.setVisibility(8);
                            BNSearchResultView.this.mViewMapLayput.setVisibility(0);
                            BNSearchResultView.this.loadMapCtrlPanel(BNSearchResultView.this.view, true, true);
                            BNSearchResultView.this.focusHeight = BNSearchResultView.VIEW_PAGE_FOCUS_HEIGHT;
                            BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.MARGINTOP_NORMAL, BNSearchResultView.this.focusHeight);
                        } else if (topMarginFinal >= BNSearchResultView.Middle_TOP_NORMAL || BNSearchResultView.this.mLastTopMargin <= BNSearchResultView.Middle_TOP_NORMAL) {
                            if (BNSearchResultView.this.mViewPager.getVisibility() == 0) {
                                BNSearchResultView.this.mViewPager.setVisibility(8);
                                BNSearchResultView.this.mResultListView.setVisibility(0);
                                BNSearchResultView.this.mViewMapLayput.setVisibility(8);
                                BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
                                BNSearchResultView.this.focusHeight = BNSearchResultView.FOCUS_HEIGHT_MIDDLE;
                                BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
                                if (BNSearchResultView.this.mMapControlPanel != null) {
                                    BNSearchResultView.this.mMapControlPanel.setVisible(false);
                                }
                            }
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.Middle_TOP_NORMAL);
                        } else {
                            if (BNSearchResultView.this.mViewPager.getVisibility() == 0) {
                                BNSearchResultView.this.mViewPager.setVisibility(8);
                                BNSearchResultView.this.mResultListView.setVisibility(0);
                                BNSearchResultView.this.mViewMapLayput.setVisibility(8);
                                BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
                                BNSearchResultView.this.focusHeight = BNSearchResultView.FOCUS_HEIGHT_MIDDLE;
                            }
                            BNSearchResultView.this.setListViewMargin(BNSearchResultView.this.mTitleBar.getHeight());
                        }
                        BNSearchResultView.this.mLastY = -1.0f;
                        BNSearchResultView.this.mLastTopMargin = BNSearchResultView.this.getTopMargin();
                        break;
                    }
                    if (Math.abs(topMarginFinal - BNSearchResultView.Middle_TOP_NORMAL) < 3) {
                        BNSearchResultView.this.setListViewMargin(BNSearchResultView.Middle_TOP_NORMAL);
                    } else if (Math.abs(topMarginFinal - BNSearchResultView.this.mTitleBar.getHeight()) < 3) {
                        BNSearchResultView.this.setListViewMargin(BNSearchResultView.this.mTitleBar.getHeight());
                    }
                    BNSearchResultView.this.mLastY = -1.0f;
                    break;
                    break;
            }
            return true;
        }
    };
    private TextView mTvAddr;
    private TextView mTvDistance;
    private TextView mTvName;
    private TextView mTvStartNavi;
    private View mViewMapLayput;
    private ViewPager mViewPager;
    private SearchPoi searchGeoPoi;
    private View view = null;

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$1 */
    class C44731 implements OnTouchListener {
        C44731() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$2 */
    class C44742 implements ILocationBtnClickListener {
        C44742() {
        }

        public void onClick(int curLocMode) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$3 */
    class C44753 implements IItsClickListener {
        C44753() {
        }

        public void onClickIts() {
            BNSearchResultView.this.mFirstItsOn = BNSettingManager.isFirstItsOn();
            GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
            if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                BNSearchResultView.this.mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
            }
            if (BNSettingManager.isRoadCondOnOrOff()) {
                BNMapController.getInstance().showTrafficMap(false);
                BNSettingManager.setRoadCondOnOff(false);
            } else if (PreferenceHelper.getInstance(BNSearchResultView.this.mContext).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
                if (BNSearchResultView.this.mFirstItsOn) {
                    BNSettingManager.setFirstItsOn(false);
                }
                if (NetworkUtils.isNetworkAvailable(BNSearchResultView.this.mContext)) {
                    BNMapController.getInstance().switchITSMode(true);
                    BNMapController.getInstance().showTrafficMap(true);
                    BNSettingManager.setRoadCondOnOff(true);
                    if (BNSearchResultView.this.mDistrict == null || BNMapController.getInstance().checkRoadConditionSupport(BNSearchResultView.this.mDistrict.mId)) {
                        TipTool.onCreateToastDialog(BNSearchResultView.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_is_on));
                        return;
                    } else {
                        TipTool.onCreateToastDialog(BNSearchResultView.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_missing_data));
                        return;
                    }
                }
                BNSearchResultView.this.showItsSettingDialog();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$4 */
    class C44764 implements OnNaviClickListener {
        C44764() {
        }

        public void onClick() {
            if (BNSearchResultView.this.mActivity != null && BNSearchResultView.this.mItsSettingAlertDialog != null) {
                BNSearchResultView.this.mItsSettingAlertDialog.dismiss();
                BNSearchResultView.this.mItsSettingAlertDialog = null;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$5 */
    class C44775 implements OnClickListener {
        C44775() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                int id = v.getId();
                if (id == C4048R.id.btn_poi_gonavi) {
                    if (BNSearchResultView.this.searchGeoPoi != null && BNSearchResultView.this.mBNSearchResutlListerner != null) {
                        BNSearchResultView.this.mBNSearchResutlListerner.startGoNavi(false, BNSearchResultView.this.searchGeoPoi);
                    }
                } else if (id == C4048R.id.poi_name_addr_layout && BNSearchResultView.this.searchGeoPoi != null) {
                    BNSearchResultView.this.mBNSearchResutlListerner.setFocusMadianIndex(BNSearchResultView.this.searchGeoPoi, false, -1);
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$6 */
    class C44786 implements OnTouchListener {
        C44786() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$8 */
    class C44808 implements OnCancelListener {
        C44808() {
        }

        public void onCancel(DialogInterface dialog) {
            if (BNSearchResultView.this.mResultAdapter == null) {
                BNSearchResultView.this.mBNSearchResutlListerner.pressleftTitleBack();
            }
            BNSearchResultView.this.mPreSearchCityList = null;
            BNPoiSearcher.getInstance().cancelQuery();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.search.BNSearchResultView$9 */
    class C44819 implements OnPageChangeListener {
        C44819() {
        }

        public void onPageSelected(int arg0) {
            BNSearchResultView.this.mCurrentIndex = arg0;
            BNSearchResultView.this.mResultAdapter.setFocusIndex(arg0);
            ArrayList<SearchPoi> mPoiList = BNSearchResultView.this.mSearchPoiPager.getPoiList();
            if (mPoiList != null && mPoiList.size() > BNSearchResultView.this.mCurrentIndex) {
                BNSearchResultView.this.mBNSearchResutlListerner.setFocusMadianIndex((SearchPoi) mPoiList.get(BNSearchResultView.this.mCurrentIndex), true, BNSearchResultView.this.mCurrentIndex);
            }
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageScrollStateChanged(int arg0) {
        }
    }

    public class SearchResultViewPagerAdapter extends PagerAdapter {
        View convertView;
        List<SearchPoi> mPoiList;

        public SearchResultViewPagerAdapter(List<SearchPoi> mPoiList) {
            this.mPoiList = mPoiList;
        }

        public void setPoiList(List<SearchPoi> mPoiList) {
            this.mPoiList = mPoiList;
        }

        public void destroyItem(View arg0, int arg1, Object object) {
            ((ViewPager) arg0).removeView((View) object);
        }

        public void finishUpdate(View arg0) {
        }

        public int getCount() {
            return this.mPoiList.size();
        }

        public Object instantiateItem(View arg0, int position) {
            ViewGroup convertView = (ViewGroup) JarUtils.inflate(BNSearchResultView.this.mActivity, C4048R.layout.search_result_list_item, null);
            ViewHodler viewHodler = new ViewHodler();
            viewHodler.mVerDiverderA = convertView.findViewById(C4048R.id.line_poi_vertical_a);
            viewHodler.mBtnStartNavi = convertView.findViewById(C4048R.id.btn_poi_gonavi);
            viewHodler.mBtnNameAddr = convertView.findViewById(C4048R.id.poi_name_addr_layout);
            viewHodler.mTvName = (TextView) convertView.findViewById(C4048R.id.tv_poi_title);
            viewHodler.mTvAddr = (TextView) convertView.findViewById(C4048R.id.tv_poi_addr);
            viewHodler.mTvStartNavi = (TextView) convertView.findViewById(C4048R.id.tv_poi_gonavi);
            viewHodler.mTvDistance = (TextView) convertView.findViewById(C4048R.id.tv_poi_distance);
            viewHodler.mTvNum = (TextView) convertView.findViewById(C4048R.id.tv_num);
            viewHodler.mDivider = convertView.findViewById(C4048R.id.ls_divider);
            viewHodler.mIcResult = (ImageView) convertView.findViewById(C4048R.id.ic_result);
            viewHodler.mLayoutChildBottom = (LinearLayout) convertView.findViewById(C4048R.id.layout_child_bottom);
            viewHodler.mPoiParent = (RelativeLayout) convertView.findViewById(C4048R.id.btn_poi_parent);
            viewHodler.mParInforLayout = convertView.findViewById(C4048R.id.par_infor_layout);
            convertView.setTag(viewHodler);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
            viewHodler.mVerDiverderA.setBackgroundColor(BNStyleManager.getColor(C4048R.color.poi_line));
            viewHodler.mBtnStartNavi.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_bg_pressed_mask_selector));
            viewHodler.mBtnNameAddr.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_bg_pressed_mask_selector));
            viewHodler.mTvName.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mTvAddr.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mTvNum.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mTvStartNavi.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mTvDistance.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mLayoutChildBottom.setBackgroundColor(BNStyleManager.getColor(C4048R.color.poi_result_layout_background));
            viewHodler.mTvNum.setText((position + 1) + ".");
            SearchPoi searchPoi = (SearchPoi) this.mPoiList.get(position);
            if (searchPoi != null) {
                viewHodler.mTvName.setText(searchPoi.mName);
                viewHodler.mTvAddr.setText(searchPoi.mAddress);
                viewHodler.mTvDistance.setText(BNSearchResultView.this.mBNSearchResutlListerner.getDistance(searchPoi));
            }
            viewHodler.mBtnStartNavi.setTag(searchPoi);
            viewHodler.mParInforLayout.setTag(Integer.valueOf(position));
            viewHodler.mBtnStartNavi.setOnClickListener(BNSearchResultView.this.mResultAdapter.getNameSearchResultListener());
            viewHodler.mParInforLayout.setOnClickListener(BNSearchResultView.this.mResultAdapter.getNameSearchResultListener());
            if (arg0 != null) {
                ((ViewPager) arg0).addView(convertView, 0);
            }
            return convertView;
        }

        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }

        public int getItemPosition(Object object) {
            return -2;
        }
    }

    static class ViewHodler {
        View mBtnNameAddr;
        View mBtnStartNavi;
        GridView mChildGrideList;
        View mDivider;
        ImageView mIcResult;
        LinearLayout mLayoutChildBottom;
        View mParInforLayout;
        RelativeLayout mPoiParent;
        TextView mTvAddr;
        TextView mTvDistance;
        TextView mTvName;
        TextView mTvNum;
        TextView mTvStartNavi;
        View mVerDiverderA;

        ViewHodler() {
        }
    }

    public BNSearchResultView(Context context, MapGLSurfaceView nmapView) {
        super(context);
        this.mContext = context;
        this.mNMapView = nmapView;
        setupView((Activity) context);
    }

    private void setupView(Activity activity) {
        try {
            this.mActivity = activity;
            this.view = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_search_result_list, this);
            if (this.view != null) {
                this.mResultListView = (XListView) this.view.findViewById(C4048R.id.lv_search_result);
                this.mTitleBar = (BNMapTitleBar) this.view.findViewById(C4048R.id.title_bar);
                this.mDrawingLayout = (LinearLayout) this.view.findViewById(C4048R.id.slide_drawer);
                this.mHandleView = (ImageView) this.view.findViewById(C4048R.id.pull_handle);
                this.mViewPager = (ViewPager) this.view.findViewById(C4048R.id.vp_search_result);
                this.mHandleView.setOnTouchListener(this.mTouchListener);
                this.mTitleBar.setRightButtonBackground(BNStyleManager.getDrawable(C4048R.drawable.sort_default_normal));
                this.mTitleBar.setRightButtonVisible(true);
                this.mTitleBar.setLeftOnClickedListener(getOnClickListener());
                this.mTitleBar.setRightOnClickedListener(getOnClickListener());
                this.mResultListView.setAutoLoadEnable(false);
                this.mResultListView.setDividerHeight(0);
                this.mResultListView.setPullRefreshEnable(false);
                this.mSortingRl = (RelativeLayout) this.view.findViewById(C4048R.id.sr_cover_sorting);
                this.mSortingRl.setVisibility(8);
                this.mSortingRl.setOnTouchListener(new C44731());
                this.mCloseSortingIv = (ImageView) this.view.findViewById(C4048R.id.iv_close_sorting);
                this.mSortByKey = (RelativeLayout) this.view.findViewById(C4048R.id.rl_sort_by_key);
                this.mSortByDistance = (RelativeLayout) this.view.findViewById(C4048R.id.rl_sort_by_distance);
                this.mSortByKeyTv = (TextView) this.view.findViewById(C4048R.id.tv_sort_by_key);
                this.mSortByDistanceTv = (TextView) this.view.findViewById(C4048R.id.tv_sort_by_distance);
                this.mSortByKeyIv = (ImageView) this.view.findViewById(C4048R.id.iv_sort_by_key);
                this.mSortByDistanceIv = (ImageView) this.view.findViewById(C4048R.id.iv_sort_by_distance);
                this.mCloseSortingIv.setOnClickListener(getOnClickListener());
                this.mSortByKey.setOnClickListener(getOnClickListener());
                this.mSortByDistance.setOnClickListener(getOnClickListener());
                this.mBgView = (RelativeLayout) this.view.findViewById(C4048R.id.mapview_frame);
                if (this.mBgView != null) {
                    this.mBgView.removeAllViews();
                }
                if (BSearchConfig.pRGViewMode != 0) {
                    BSearchConfig.pRGViewMode = 1;
                } else if (this.mNMapView != null) {
                    try {
                        ViewParent parent = this.mNMapView.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(this.mNMapView);
                        }
                    } catch (Exception e) {
                    }
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.mBgView != null) {
                        this.mBgView.addView(this.mNMapView, lp);
                    }
                    this.view.requestLayout();
                }
                this.mGeoLayout = (FrameLayout) this.view.findViewById(C4048R.id.poilayout);
                this.mBtnStartNavi = this.view.findViewById(C4048R.id.btn_poi_gonavi);
                this.mBtnNameAddr = this.view.findViewById(C4048R.id.poi_name_addr_layout);
                this.mTvName = (TextView) this.view.findViewById(C4048R.id.tv_poi_title);
                this.mTvAddr = (TextView) this.view.findViewById(C4048R.id.tv_poi_addr);
                this.mTvStartNavi = (TextView) this.view.findViewById(C4048R.id.tv_poi_gonavi);
                this.mTvDistance = (TextView) this.view.findViewById(C4048R.id.tv_poi_distance);
                this.mGeoLayout.setVisibility(8);
                this.mBtnStartNavi.setOnClickListener(this.mClickListener);
                this.mBtnNameAddr.setOnClickListener(this.mClickListener);
                this.mViewMapLayput = this.view.findViewById(C4048R.id.view_map_layout);
                loadMapCtrlPanel(this.view, true, true);
            }
        } catch (Exception e2) {
        }
    }

    public void loadMapCtrlPanel(View view, boolean showTwoBtn, boolean showMapCtrlPanel) {
        this.mShowTwoBtn = showTwoBtn;
        this.mAddMapCtrlPanel = showMapCtrlPanel;
        reloadMapControlPanel(view);
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setVisible(true);
        }
    }

    public void reloadMapControlPanel(View view) {
        if (view != null && this.mContext != null && this.mAddMapCtrlPanel) {
            this.mMapControlPanel = new BNMapControlPanel(this.mContext, view, this.mShowTwoBtn);
            BNMapController.getInstance().setObserver(this.mBNMapObserver);
            this.mMapControlPanel.setNoNightStyle(true);
            this.mMapControlPanel.updateView();
            this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
            this.mMapControlPanel.setLocationBtnClickListener(this.mLocationBtnClickListener);
        }
    }

    private void showItsSettingDialog() {
        if (this.mItsSettingAlertDialog == null) {
            this.mItsSettingAlertDialog = new BNMessageDialog(this.mActivity);
            this.mItsSettingAlertDialog.setTitleText(BNStyleManager.getString(C4048R.string.alert_notification));
            this.mItsSettingAlertDialog.setMessage(BNStyleManager.getString(C4048R.string.its_switch_to_history));
            this.mItsSettingAlertDialog.setFirstBtnText(BNStyleManager.getString(C4048R.string.alert_know));
            this.mItsSettingAlertDialog.setOnFirstBtnClickListener(new C44764());
        }
        this.mItsSettingAlertDialog.show();
    }

    public void setGeoLayoutGone() {
        this.mGeoLayout.setVisibility(8);
        this.mDrawingLayout.setVisibility(0);
        this.mTitleBar.setRightButtonVisible(true);
    }

    public boolean isGeoLayoutVisible() {
        if (this.mGeoLayout == null || !this.mGeoLayout.isShown()) {
            return false;
        }
        return true;
    }

    public void setGeoLayoutVisible(SearchPoi poi) {
        if (poi != null) {
            this.mDrawingLayout.setVisibility(4);
            this.mGeoLayout.setVisibility(0);
            this.mTitleBar.setRightButtonVisible(false);
            this.mTvName.setText(poi.mName);
            this.mTvAddr.setText(poi.mAddress);
            this.mTvDistance.setText(this.mBNSearchResutlListerner.getDistance(poi));
            this.searchGeoPoi = poi;
        }
    }

    public void onResume() {
        BNMapController.getInstance().onResume();
    }

    public void onPause() {
        BNPoiSearcher.getInstance().clearBkgCache();
        BNMapController.getInstance().clearLayer(4);
        BNMapController.getInstance().onPause();
    }

    public void updateMapView(MapGLSurfaceView mapView) {
        if (this.mBgView != null) {
            this.mBgView.removeAllViews();
        }
        if (BSearchConfig.pRGViewMode == 0 && mapView != null) {
            try {
                ViewParent parent = mapView.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(mapView);
                }
            } catch (Exception e) {
            }
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, -1);
            if (this.mBgView != null) {
                this.mBgView.addView(mapView, lp);
            }
            this.view.requestLayout();
        }
        if (mapView != null) {
            BNMapController.getInstance().setObserver(this.mBNMapObserver);
        }
    }

    public void setViewPagerCurrentIndex(int index) {
        this.mCurrentIndex = index;
        if (this.mViewPager != null) {
            this.mViewPager.setCurrentItem(index);
        }
    }

    public void initView() {
        if (!(this.mBNSearchResutlListerner == null || this.mResultListView == null)) {
            this.mResultListView.setXListViewListener(this.mBNSearchResutlListerner);
        }
        if (this.mDrawingLayout != null) {
            this.mDrawingLayout.setOnTouchListener(new C44786());
        }
    }

    public void showCityDialog(final List<SearchPoi> list, boolean isOnline) {
        if (this.mCityListDialog != null && this.mCityListDialog.isShowing()) {
            this.mCityListDialog.dismiss();
        }
        this.mCityListDialog = new BNListDialog(this.mActivity).setListTitleText(BNStyleManager.getString(C4048R.string.select_city_title)).setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DistrictInfo districtInfo;
                BNSearchResultView.this.mCityListDialog.dismiss();
                SearchPoi searchPoi = (SearchPoi) list.get(position);
                if ((searchPoi.mDistrictId & -65536) <= 0 || (searchPoi.mDistrictId & 65535) != 0) {
                    districtInfo = BNPoiSearcher.getInstance().getDistrictById(searchPoi.mDistrictId);
                } else {
                    districtInfo = BNPoiSearcher.getInstance().getDistrictById(searchPoi.mDistrictId >> 16);
                }
                BNSearchResultView.this.mBNSearchResutlListerner.asynSearchCityList(new SearchPoiPager(BNSearchResultView.this.mSearchPoiPager.getSearchKey(), districtInfo, 10, BNSearchResultView.this.mSearchPoiPager.getNetMode()), searchPoi);
                BNSearchResultView.this.mPreSearchCityList = list;
            }
        });
        ArrayList<String> mDataList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SearchPoi tempPoi = (SearchPoi) list.get(i);
            if (isOnline) {
                mDataList.add(tempPoi.mName + "(" + (tempPoi.mWeight == 0 ? 1 : tempPoi.mWeight) + ")");
            } else {
                mDataList.add(tempPoi.mName);
            }
        }
        this.mCityListDialog.setListAdapter(mDataList);
        this.mCityListDialog.setCanceledOnTouchOutside(false);
        this.mCityListDialog.setOnCancelListener(this.mSearchDialogCancelListener);
        this.mCityListDialog.show();
    }

    public void setBNRouteDetailsListener(IBNSearchResultListener lis) {
        this.mBNSearchResutlListerner = lis;
    }

    public void removeBNRouteDetailsListener() {
        this.mBNSearchResutlListerner = null;
    }

    public void onUpdateStyle(boolean dayStyle) {
        if (this.mTitleBar != null) {
            this.mTitleBar.onUpdateStyle(dayStyle);
        }
        if (this.mHandleView != null) {
            this.mHandleView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_btn_poi_dragon_selector));
            this.mHandleView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_poi_list_drag));
        }
        if (this.mResultAdapter != null) {
            this.mResultAdapter.notifyDataSetChanged();
        }
        if (this.mResultListView != null) {
            this.mResultListView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.poi_result_layout_background));
            this.mResultListView.setTextColor(BNStyleManager.getColor(C4048R.color.poi_detail_addr));
        }
    }

    public boolean onBackPressed() {
        if (this.mSortingRl == null || this.mSortingRl.getVisibility() != 0) {
            return false;
        }
        this.mSortingRl.setVisibility(8);
        return true;
    }

    public void updateAdapter(SearchPoiPager searchPoiPager) {
        this.mSearchPoiPager = searchPoiPager;
        this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
        updateListView();
        this.mSearchResultViewPagerAdapter.setPoiList(searchPoiPager.getPoiList());
        this.mSearchResultViewPagerAdapter.notifyDataSetChanged();
    }

    public void updateAdaperView(SearchPoiPager searchPoiPager) {
        this.mSearchPoiPager = searchPoiPager;
        if (this.mResultAdapter != null) {
            this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
        } else {
            this.mResultAdapter = new SearchResultAdapter(this.mActivity, this.mSearchPoiPager, this.isSetPointMode);
            this.mResultAdapter.setOnlineSearchListener(this.mBNSearchResutlListerner);
            this.mResultListView.setAdapter(this.mResultAdapter);
            int parCnt = this.mSearchPoiPager.getCountPerPager();
            ArrayList<SearchPoi> mResultPoiList = new ArrayList(parCnt);
            int i = 0;
            while (i < parCnt && i < this.mSearchPoiPager.getPoiList().size()) {
                mResultPoiList.add(this.mSearchPoiPager.getPoiList().get(i));
                i++;
            }
            this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(mResultPoiList);
            this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
            this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
            this.mViewPager.setCurrentItem(0);
        }
        updateListView();
    }

    public void setSearchResultViewPagerAdapter(SearchPoiPager searchPoiPager) {
        if (this.mResultListView != null) {
            this.mSearchPoiPager = searchPoiPager;
            this.mResultAdapter = new SearchResultAdapter(this.mActivity, this.mSearchPoiPager, this.isSetPointMode);
            this.mResultAdapter.setOnlineSearchListener(this.mBNSearchResutlListerner);
            this.mResultListView.setAdapter(this.mResultAdapter);
            updateListView();
            int parCnt = this.mSearchPoiPager.getCountPerPager();
            ArrayList<SearchPoi> mResultPoiList = new ArrayList(parCnt);
            int i = 0;
            while (i < parCnt && i < this.mSearchPoiPager.getPoiList().size()) {
                mResultPoiList.add(this.mSearchPoiPager.getPoiList().get(i));
                i++;
            }
            this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(mResultPoiList);
            this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
            this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
            this.mViewPager.setCurrentItem(0);
        }
    }

    public void updateSortView(SearchPoiPager searchPoiPager) {
        if (searchPoiPager != null) {
            this.mSearchPoiPager = searchPoiPager;
            switch (this.mSearchPoiPager.getSearchType()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    if (this.mSortByKeyIv != null) {
                        this.mSortByKeyIv.setVisibility(0);
                    }
                    if (this.mSortByDistanceIv != null) {
                        this.mSortByDistanceIv.setVisibility(8);
                    }
                    if (this.mSortByKeyTv != null) {
                        this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_selected_text_color));
                    }
                    if (this.mSortByDistanceTv != null) {
                        this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_unselected_text_color));
                    }
                    this.mSearchPoiPager.setSortType(1);
                    return;
                case 6:
                    if (this.mSortByKeyIv != null) {
                        this.mSortByKeyIv.setVisibility(8);
                    }
                    if (this.mSortByDistanceIv != null) {
                        this.mSortByDistanceIv.setVisibility(0);
                    }
                    if (this.mSortByKeyTv != null) {
                        this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_unselected_text_color));
                    }
                    if (this.mSortByDistanceTv != null) {
                        this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_selected_text_color));
                    }
                    this.mSearchPoiPager.setSortType(2);
                    return;
                default:
                    return;
            }
        }
    }

    public void stopRefresh() {
        this.mResultListView.stopRefresh();
    }

    public void stopLoadMore() {
        this.mResultListView.stopLoadMore();
    }

    public void scrollResultListView(int position) {
        this.mCurrentIndex = position;
        this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
        this.mResultListView.smoothScrollToPositionFromTop(position, 0);
        this.mResultAdapter.setFocusIndex(position);
    }

    public void updateListView() {
        if (this.mSearchPoiPager != null) {
            if (this.mSearchPoiPager.getPrevPager() != null) {
                this.mResultListView.setPullRefreshEnable(true);
            } else {
                this.mResultListView.setPullRefreshEnable(false);
            }
            if (this.mSearchPoiPager.isLastPager()) {
                this.mResultListView.setPullLoadEnable(false);
            } else {
                this.mResultListView.setPullLoadEnable(true);
            }
            this.mResultListView.setSelection(0);
        }
    }

    public void updateViewWithOrientation(int orientation, boolean dayStyle) {
    }

    public static void showSearchNetworkingDialog(Activity activity, int contentResId, int confirmResId, OnClickListener confirmListener, OnClickListener downloadListener, OnClickListener cancleListener) {
        dismissSearchNetworkingDialog();
        if (mNetworkingDialog == null) {
            mNetworkingDialog = new BNNetworkingDialog(activity).setTwoButtonMode(true);
            mNetworkingDialog.setNetworkingContentMessage(BNStyleManager.getString(C4048R.string.search_net_connect_tips));
            mNetworkingDialog.setConfirmNetworkingListener(confirmListener);
            mNetworkingDialog.setCancleListener(cancleListener);
        }
        mNetworkingDialog.show();
    }

    public static boolean dismissSearchNetworkingDialog() {
        if (mNetworkingDialog != null && mNetworkingDialog.isShowing()) {
            mNetworkingDialog.dismiss();
        }
        mNetworkingDialog = null;
        return true;
    }

    private void switchMapcontrolVisible() {
        if (this.mMapControlPanel == null) {
            return;
        }
        if (this.mMapControlPanel.isVisible()) {
            this.mMapControlPanel.setVisible(false);
        } else {
            this.mMapControlPanel.setVisible(true);
        }
    }

    public void handleCompassClicked() {
        MapStatus mapstatus = BNMapController.getInstance().getMapStatus();
        mapstatus._Rotation = 0;
        mapstatus._Overlooking = 0;
        mapstatus._Level = -1.0f;
        BNMapController.getInstance().setMapStatus(mapstatus, AnimationType.eAnimationNone);
    }

    public int getTopMargin() {
        return ((RelativeLayout.LayoutParams) this.mDrawingLayout.getLayoutParams()).topMargin;
    }

    public int updateTopMargin(float deltaY) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDrawingLayout.getLayoutParams();
        layoutParams.topMargin = (int) (((float) layoutParams.topMargin) + deltaY);
        this.mDrawingLayout.setLayoutParams(layoutParams);
        return layoutParams.topMargin;
    }

    public void setListViewMargin(int margin) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDrawingLayout.getLayoutParams();
        layoutParams.topMargin = margin;
        this.mDrawingLayout.setLayoutParams(layoutParams);
    }

    private OnClickListener getOnClickListener() {
        return new OnClickListener() {
            public void onClick(View v) {
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_8);
                int id = v.getId();
                if (id == C4048R.id.left_imageview) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410132", "410132");
                    BNSearchResultView.this.mBNSearchResutlListerner.pressleftTitleBack();
                } else if (id == C4048R.id.right_imageview) {
                    BNSearchResultView.this.mSortingRl.setVisibility(0);
                } else if (id == C4048R.id.iv_close_sorting) {
                    BNSearchResultView.this.mSortingRl.setVisibility(8);
                } else if (id == C4048R.id.rl_sort_by_key) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410133", "410133");
                    BNSearchResultView.this.mSearchPoiPager.setSortType(1);
                    BNSearchResultView.this.mSortingRl.setVisibility(8);
                    BNSearchResultView.this.sortListByRule();
                    BNSearchResultView.this.mSortByKeyIv.setVisibility(0);
                    BNSearchResultView.this.mSortByDistanceIv.setVisibility(8);
                    BNSearchResultView.this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_selected_text_color));
                    BNSearchResultView.this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_unselected_text_color));
                    BNSearchResultView.this.mBNSearchResutlListerner.updateResultPoiBkgLayer(BNSearchResultView.this.mSearchPoiPager.getPoiList());
                    BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
                } else if (id == C4048R.id.rl_sort_by_distance) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410134", "410134");
                    GeoPoint center = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getMyPositionGeo();
                    if (center == null || !center.isValid()) {
                        TipTool.onCreateToastDialog(BNSearchResultView.this.mActivity, (int) C4048R.string.carmode_searchresult_sort_fail);
                        return;
                    }
                    BNSearchResultView.this.mSearchPoiPager.setSortType(2);
                    BNSearchResultView.this.mSortingRl.setVisibility(8);
                    BNSearchResultView.this.sortListByRule();
                    BNSearchResultView.this.mSortByKeyIv.setVisibility(8);
                    BNSearchResultView.this.mSortByDistanceIv.setVisibility(0);
                    BNSearchResultView.this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_unselected_text_color));
                    BNSearchResultView.this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(C4048R.color.search_sort_selected_text_color));
                    BNSearchResultView.this.mBNSearchResutlListerner.updateResultPoiBkgLayer(BNSearchResultView.this.mSearchPoiPager.getPoiList());
                    BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
                }
            }
        };
    }

    protected void sortListByRule() {
        if (this.mResultAdapter != null) {
            this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
            this.mResultListView.smoothScrollToPositionFromTop(this.mCurrentIndex, 0);
            this.mResultAdapter.setFocusIndex(this.mCurrentIndex);
            int parCnt = this.mSearchPoiPager.getCountPerPager();
            ArrayList<SearchPoi> mResultPoiList = new ArrayList(parCnt);
            int i = 0;
            while (i < parCnt && i < this.mSearchPoiPager.getPoiList().size()) {
                mResultPoiList.add(this.mSearchPoiPager.getPoiList().get(i));
                i++;
            }
            this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(mResultPoiList);
            this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
            this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
            this.mViewPager.setCurrentItem(0);
        }
    }
}
