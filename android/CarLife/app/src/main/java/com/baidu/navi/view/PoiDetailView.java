package com.baidu.navi.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.PoiController.FavoriteResultCallBack;
import com.baidu.navi.controller.PoiController.ShareEventCallBack;
import com.baidu.navi.controller.PoiController.StreetSearchCallBack;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.AppCommandConst;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.NL_Net_Mode;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;

public class PoiDetailView extends FrameLayout {
    public static int OUT_CAP;
    public static boolean isPanelOut = true;
    private int VIEW_HEIGHT = 0;
    private boolean isAnimationing = false;
    private boolean isFavorite = false;
    private boolean isMyPosition = false;
    private boolean isOut = false;
    private boolean isPickPoi = false;
    private boolean isSetStreetId = false;
    private boolean isSupportDragon = false;
    private OnClickListener mBtnClickListener = new C40112();
    private View mBtnFaverite;
    private View mBtnGooutPref;
    private View mBtnNameAddr;
    private View mBtnPhoneCall;
    private View mBtnSetEnd;
    private View mBtnSetStart;
    private View mBtnSetVia;
    private View mBtnShare;
    private View mBtnSpace;
    private View mBtnStartNavi;
    private View mBtnStreet;
    private View mContentLayout;
    private Context mContext;
    private SearchPoi mCurrentPoi;
    private OnClickListener mDragonOnClickListener;
    private OnTouchListener mDragonOnTouchListener;
    private int mDuration;
    private FavoriteResultCallBack mFavoriteResultCallBack = new C40101();
    private View mHorDiverderA;
    private View mHorDiverderB;
    private View mHorDiverderC;
    private View mHorDiverderD;
    private int mIndex;
    private boolean mIsFavOperate = false;
    private ImageView mIvDragon;
    private View mLayoutPanel2;
    private View mLayoutPanel3;
    private LayoutParams mLayoutParams;
    private NL_Net_Mode mNetMode;
    private C1277e mOnDialogListener;
    private ProgressBar mPbAntiGeo;
    private ProgressBar mPbFaverite;
    private ProgressBar mPbStreet;
    private PoiController mPoiController;
    private ShareEventCallBack mShareEventCallBack = new C40123();
    private StreetSearchCallBack mStreetSearchCallBack = new C40134();
    private TextView mTvAddr;
    private TextView mTvDistance;
    private TextView mTvFaverite;
    private TextView mTvGoouPref;
    private TextView mTvName;
    private TextView mTvNum;
    private TextView mTvPhoneCall;
    private TextView mTvSetEnd;
    private TextView mTvSetStart;
    private TextView mTvSetVia;
    private TextView mTvShare;
    private TextView mTvSpace;
    private TextView mTvStartNavi;
    private TextView mTvStreet;
    private Handler mUIHandler;
    private View mVerDiverder1A;
    private View mVerDiverder1B;
    private View mVerDiverder2A;
    private View mVerDiverder2B;
    private View mVerDiverder3A;
    private View mVerDiverder3B;
    private View mVerDiverderA;

    /* renamed from: com.baidu.navi.view.PoiDetailView$1 */
    class C40101 implements FavoriteResultCallBack {
        C40101() {
        }

        public void onRemoveResult(boolean isSuccess) {
            if (isSuccess) {
                PoiDetailView.this.isFavorite = false;
            }
            PoiDetailView.this.updateFavoriteIcon();
            PoiDetailView.this.mPbFaverite.setVisibility(8);
            PoiDetailView.this.mTvFaverite.setVisibility(0);
            PoiDetailView.this.mBtnFaverite.setClickable(true);
        }

        public void onFavoritEventStart() {
            PoiDetailView.this.mPbFaverite.setVisibility(0);
            PoiDetailView.this.mTvFaverite.setVisibility(8);
            PoiDetailView.this.mBtnFaverite.setClickable(false);
        }

        public void onCheckResult(boolean favorite) {
            PoiDetailView.this.isFavorite = favorite;
            PoiDetailView.this.mPbFaverite.setVisibility(8);
            PoiDetailView.this.mTvFaverite.setVisibility(0);
            PoiDetailView.this.mBtnFaverite.setClickable(true);
            PoiDetailView.this.updateFavoriteIcon();
        }

        public void onAddResult(boolean isSuccess) {
            if (isSuccess) {
                PoiDetailView.this.isFavorite = true;
            }
            PoiDetailView.this.mPbFaverite.setVisibility(8);
            PoiDetailView.this.mTvFaverite.setVisibility(0);
            PoiDetailView.this.mBtnFaverite.setClickable(true);
            PoiDetailView.this.updateFavoriteIcon();
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$2 */
    class C40112 implements OnClickListener {
        C40112() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                int id = v.getId();
                if (id == C0965R.id.btn_street) {
                    PoiDetailView.this.mPoiController.viewStreet(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.getContext(), PoiDetailView.this.mOnDialogListener);
                } else if (id == C0965R.id.btn_phone_call) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_CALL, StatisticConstants.POIDETAIL_CALL);
                    PoiDetailView.this.mPoiController.callPhone(PoiDetailView.this.mCurrentPoi);
                } else if (id == C0965R.id.btn_trip_ref) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_REFERENCE, StatisticConstants.POIDETAIL_REFERENCE);
                    PoiDetailView.this.mPoiController.startRef(PoiDetailView.this.mCurrentPoi);
                } else if (id == C0965R.id.btn_set_start) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_STARTPOINT, StatisticConstants.POIDETAIL_STARTPOINT);
                    PoiDetailView.this.mPoiController.setStart(PoiDetailView.this.mCurrentPoi);
                } else if (id == C0965R.id.btn_set_end) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_DESTINATION, StatisticConstants.POIDETAIL_DESTINATION);
                    PoiDetailView.this.mPoiController.setEnd(PoiDetailView.this.mCurrentPoi);
                } else if (id == C0965R.id.btn_set_via) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_WAYPOINT, StatisticConstants.POIDETAIL_WAYPOINT);
                    PoiDetailView.this.mPoiController.setVia(PoiDetailView.this.mCurrentPoi);
                } else if (id == C0965R.id.btn_space_search) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_SEARCHNEARBY, StatisticConstants.POIDETAIL_SEARCHNEARBY);
                    PoiDetailView.this.mPoiController.searchSpace(PoiDetailView.this.mCurrentPoi);
                } else if (id == C0965R.id.btn_fav) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_COLLECTIONSWITCH, StatisticConstants.POIDETAIL_COLLECTIONSWITCH);
                    PoiDetailView.this.mIsFavOperate = true;
                    if (PoiDetailView.this.isFavorite) {
                        PoiDetailView.this.mPoiController.removeFavorite(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mFavoriteResultCallBack);
                    } else {
                        PoiDetailView.this.mPoiController.addFavorite(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mFavoriteResultCallBack);
                    }
                } else if (id == C0965R.id.btn_share_pos) {
                    C1307e.a().b("分享中，请稍等...");
                    PoiDetailView.this.mPoiController.sharePoiGetShortUrl(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mUIHandler);
                } else if (id == C0965R.id.btn_poi_gonavi) {
                    StatisticManager.onEvent(StatisticConstants.POIDETAIL_START, StatisticConstants.POIDETAIL_START);
                    PoiDetailView.this.mPoiController.startCalcRoute(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mOnDialogListener);
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$3 */
    class C40123 implements ShareEventCallBack {
        C40123() {
        }

        public void onStart() {
        }

        public void onEnd() {
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$4 */
    class C40134 implements StreetSearchCallBack {
        C40134() {
        }

        public void onStart() {
            PoiDetailView.this.mPbStreet.setVisibility(0);
            PoiDetailView.this.mTvStreet.setVisibility(8);
            PoiDetailView.this.mBtnStreet.setClickable(false);
        }

        public void onRevStreetId(String streetId) {
            PoiDetailView.this.mCurrentPoi.mStreetId = streetId;
            PoiDetailView.this.isSetStreetId = true;
            PoiDetailView.this.mPbStreet.setVisibility(8);
            PoiDetailView.this.mTvStreet.setVisibility(0);
            PoiDetailView.this.updateStreetIcon();
            if (!TextUtils.isEmpty(streetId)) {
                PoiDetailView.this.mBtnStreet.setClickable(true);
            }
        }

        public void onFail() {
            PoiDetailView.this.mPbStreet.setVisibility(8);
            PoiDetailView.this.mTvStreet.setVisibility(0);
            PoiDetailView.this.updateStreetIcon();
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$6 */
    class C40156 implements OnTouchListener {
        C40156() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$7 */
    class C40167 implements OnClickListener {
        C40167() {
        }

        public void onClick(View v) {
            PoiDetailView.this.onClickDragon();
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$8 */
    class C40178 implements OnClickListener {
        C40178() {
        }

        public void onClick(View v) {
            PoiDetailView.this.onClickDragon();
        }
    }

    /* renamed from: com.baidu.navi.view.PoiDetailView$9 */
    class C40189 implements OnTouchListener {
        C40189() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

    public PoiDetailView(Context context) {
        super(context);
        this.mContext = context;
        findViews(context);
        OUT_CAP = getCap();
        this.mDuration = OUT_CAP / 5;
        initHandler();
    }

    public PoiDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        findViews(context);
        OUT_CAP = getCap();
        this.mDuration = OUT_CAP / 5;
        initHandler();
    }

    public PoiDetailView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        findViews(context);
        OUT_CAP = getCap();
        this.mDuration = OUT_CAP / 5;
        initHandler();
    }

    public static int getCap() {
        if (OUT_CAP == 0) {
            OUT_CAP = ScreenUtil.getInstance().dip2px(161);
        }
        return OUT_CAP;
    }

    public void setSupportDragon(boolean isSupportDragon) {
        this.isSupportDragon = isSupportDragon;
    }

    public int getViewHeight() {
        if (this.isOut) {
            return ScreenUtil.getInstance().dip2px(329);
        }
        return ScreenUtil.getInstance().dip2px(169);
    }

    private void initHandler() {
        this.mUIHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1003:
                        if (msg.arg1 == 0) {
                            SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                            PoiDetailView.this.mPbAntiGeo.setVisibility(8);
                            if (!PoiDetailView.this.isPickPoi) {
                                PoiDetailView.this.mTvName.setVisibility(0);
                                PoiDetailView.this.mTvAddr.setVisibility(0);
                            }
                            PoiDetailView.this.isSetStreetId = true;
                            PoiDetailView.this.updatePoiByAntiPoi(poi);
                            return;
                        }
                        PoiDetailView.this.mPbAntiGeo.setVisibility(8);
                        if (!PoiDetailView.this.isPickPoi) {
                            PoiDetailView.this.mTvName.setVisibility(0);
                            PoiDetailView.this.mTvAddr.setVisibility(8);
                            PoiDetailView.this.mTvName.setText(C0965R.string.poi_on_map);
                            if (PoiDetailView.this.mCurrentPoi != null) {
                                PoiDetailView.this.mCurrentPoi.mName = BNStyleManager.getString(C4048R.string.nsdk_string_poi_on_map);
                                return;
                            }
                            return;
                        }
                        return;
                    case AppCommandConst.K_MSG_SHARE_GETSHORTURL /*1002001*/:
                        C1307e.a().c();
                        if (CommandResult.isNetworkErr(msg.arg1)) {
                            TipTool.onCreateToastDialog(PoiDetailView.this.mContext, "网络错误，请稍后尝试...");
                            return;
                        } else if (msg.arg1 == 0) {
                            PoiDetailView.this.mPoiController.sharePoi(PoiDetailView.this.mCurrentPoi, ((RspData) msg.obj).mData, BNaviModuleManager.getActivity(), PoiDetailView.this.mShareEventCallBack);
                            return;
                        } else {
                            TipTool.onCreateToastDialog(PoiDetailView.this.mContext, "未知错误，请稍后尝试...");
                            return;
                        }
                    case AppCommandConst.K_MSG_SHARE_PARSESHORTURL /*1002003*/:
                        C1307e.a().c();
                        if (msg.arg1 == 0) {
                            Point mPoint = ((RspData) msg.obj).mData;
                            Bundle bundle = CoordinateTransformUtil.MC2LLE6(mPoint.f19727x, mPoint.f19728y);
                            GeoPoint geopt = new GeoPoint(bundle.getInt("LLx"), bundle.getInt("LLy"));
                            LogUtil.m15791e("", "K_MSG_SHARE_PARSESHORTURL " + msg.arg1 + " mPoint " + mPoint + "  mPoint.x " + mPoint.f19727x + " mPoint.y " + mPoint.f19728y + " getLatitudeE6 " + geopt.getLatitudeE6() + " getLongitudeE6 " + geopt.getLongitudeE6());
                            PoiDetailView.this.setMyPositionMode(false);
                            PoiDetailView.this.antiPoi(geopt, 0, PoiDetailView.this.getHeight() / 2);
                            PoiDetailView.this.setVisibility(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void setDragonOnClickListener(OnClickListener listener) {
        this.mDragonOnClickListener = listener;
    }

    public void setDragonOnTouchListener(OnTouchListener listener) {
        this.mDragonOnTouchListener = listener;
    }

    public void setController(PoiController controller) {
        this.mPoiController = controller;
    }

    public void setFavSearchPoi(SearchPoi poi) {
        if (poi != null) {
            this.isFavorite = true;
            this.mIsFavOperate = false;
            this.mCurrentPoi = poi;
            initContents();
            updateFavoriteIcon();
        }
    }

    public boolean isOut() {
        return this.isOut;
    }

    public void setSearchPoiIndex(int index, int fcType) {
        if (index >= 0 && fcType == 0) {
            this.mTvNum.setVisibility(0);
            this.mTvNum.setText((index + 1) + ".");
            this.mTvNum.setTextColor(StyleManager.getColor(C0965R.color.poi_num));
        } else if (index < 0 || fcType != 1) {
            this.mTvNum.setVisibility(8);
        } else {
            this.mTvNum.setVisibility(0);
            this.mTvNum.setText((index + 1) + "");
            this.mTvNum.setTextColor(StyleManager.getColor(0));
        }
        this.mIndex = index;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public SearchPoi getSearchPoi() {
        return this.mCurrentPoi;
    }

    public void setSearchPoi(SearchPoi poi) {
        if (poi != null) {
            this.mCurrentPoi = poi;
            initContents();
        }
    }

    private void findViews(Context context) {
        this.mContentLayout = LayoutInflater.from(context).inflate(C0965R.layout.poi_info_panel, null);
        setOnTouchListener(new C40156());
        this.mHorDiverderA = this.mContentLayout.findViewById(C0965R.id.line_poi_horizontal_a);
        this.mHorDiverderB = this.mContentLayout.findViewById(C0965R.id.line_poi_horizontal_b);
        this.mHorDiverderC = this.mContentLayout.findViewById(C0965R.id.line_poi_horizontal_c);
        this.mHorDiverderD = this.mContentLayout.findViewById(C0965R.id.line_poi_horizontal_d);
        this.mVerDiverderA = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_a);
        this.mVerDiverder1A = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_1a);
        this.mVerDiverder1B = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_1b);
        this.mVerDiverder2A = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_2a);
        this.mVerDiverder2B = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_2b);
        this.mVerDiverder3A = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_3a);
        this.mVerDiverder3B = this.mContentLayout.findViewById(C0965R.id.line_poi_vertical_3b);
        this.mBtnStreet = this.mContentLayout.findViewById(C0965R.id.btn_street);
        this.mBtnPhoneCall = this.mContentLayout.findViewById(C0965R.id.btn_phone_call);
        this.mBtnGooutPref = this.mContentLayout.findViewById(C0965R.id.btn_trip_ref);
        this.mBtnSetStart = this.mContentLayout.findViewById(C0965R.id.btn_set_start);
        this.mBtnSetEnd = this.mContentLayout.findViewById(C0965R.id.btn_set_end);
        this.mBtnSetVia = this.mContentLayout.findViewById(C0965R.id.btn_set_via);
        this.mBtnSpace = this.mContentLayout.findViewById(C0965R.id.btn_space_search);
        this.mBtnFaverite = this.mContentLayout.findViewById(C0965R.id.btn_fav);
        this.mBtnShare = this.mContentLayout.findViewById(C0965R.id.btn_share_pos);
        this.mBtnStartNavi = this.mContentLayout.findViewById(C0965R.id.btn_poi_gonavi);
        this.mBtnNameAddr = this.mContentLayout.findViewById(C0965R.id.poi_name_addr_layout);
        this.mBtnStreet.setOnClickListener(this.mBtnClickListener);
        this.mBtnPhoneCall.setOnClickListener(this.mBtnClickListener);
        this.mBtnGooutPref.setOnClickListener(this.mBtnClickListener);
        this.mBtnSetStart.setOnClickListener(this.mBtnClickListener);
        this.mBtnSetEnd.setOnClickListener(this.mBtnClickListener);
        this.mBtnSetVia.setOnClickListener(this.mBtnClickListener);
        this.mBtnSpace.setOnClickListener(this.mBtnClickListener);
        this.mBtnFaverite.setOnClickListener(this.mBtnClickListener);
        this.mBtnShare.setOnClickListener(this.mBtnClickListener);
        this.mBtnStartNavi.setOnClickListener(this.mBtnClickListener);
        this.mBtnNameAddr.setOnClickListener(this.mBtnClickListener);
        this.mTvName = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_title);
        this.mTvAddr = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_addr);
        this.mTvStartNavi = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_gonavi);
        this.mTvDistance = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_distance);
        this.mTvStreet = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_street);
        this.mTvPhoneCall = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_call);
        this.mTvGoouPref = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_trip_ref);
        this.mTvSetStart = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_start);
        this.mTvSetEnd = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_end);
        this.mTvSetVia = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_via);
        this.mTvFaverite = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_fav);
        this.mTvShare = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_share_pos);
        this.mTvSpace = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_poi_space_search);
        this.mTvNum = (TextView) this.mContentLayout.findViewById(C0965R.id.tv_num);
        this.mPbStreet = (ProgressBar) this.mContentLayout.findViewById(C0965R.id.progress_hasstreet);
        this.mPbFaverite = (ProgressBar) this.mContentLayout.findViewById(C0965R.id.progress_isfav);
        this.mPbAntiGeo = (ProgressBar) this.mContentLayout.findViewById(C0965R.id.progress_antigeo);
        this.mIvDragon = (ImageView) this.mContentLayout.findViewById(C0965R.id.image_dragon);
        this.mIvDragon.setOnClickListener(new C40167());
        this.mBtnNameAddr.setOnClickListener(new C40178());
        this.mIvDragon.setOnTouchListener(new C40189());
        this.mLayoutPanel2 = this.mContentLayout.findViewById(C0965R.id.layout_button_panel_2);
        this.mLayoutPanel3 = this.mContentLayout.findViewById(C0965R.id.layout_button_panel_3);
        updatePanelVisibility();
        addView(this.mContentLayout, new FrameLayout.LayoutParams(-1, -2));
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (PoiDetailView.this.VIEW_HEIGHT == 0 || PoiDetailView.this.mLayoutParams == null) {
                    PoiDetailView.this.VIEW_HEIGHT = PoiDetailView.this.getHeight();
                    PoiDetailView.this.mLayoutParams = PoiDetailView.this.getLayoutParams();
                    if (PoiDetailView.this.isSupportDragon && PoiDetailView.this.VIEW_HEIGHT != 0 && PoiDetailView.this.mLayoutParams != null) {
                        PoiDetailView.this.mLayoutParams.height = PoiDetailView.this.VIEW_HEIGHT - PoiDetailView.getCap();
                        PoiDetailView.this.setLayoutParams(PoiDetailView.this.mLayoutParams);
                        PoiDetailView.this.isOut = false;
                        PoiDetailView.this.updateDragonView();
                        PoiDetailView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    private void onClickDragon() {
        if (this.mDragonOnClickListener != null) {
            this.mDragonOnClickListener.onClick(null);
        } else if (this.isOut) {
            inAnimation();
        } else {
            outAnimation();
        }
    }

    public void updateLayoutParams() {
        if (this.VIEW_HEIGHT == 0) {
            this.VIEW_HEIGHT = getHeight();
            this.mLayoutParams.height = this.VIEW_HEIGHT - getCap();
            setLayoutParams(this.mLayoutParams);
            this.isOut = false;
            updateDragonView();
        }
    }

    private void initSkins() {
        this.mHorDiverderA.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mHorDiverderA.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mHorDiverderB.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mHorDiverderC.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mHorDiverderD.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverderA.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverder1A.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverder1B.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverder2A.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverder2B.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverder3A.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mVerDiverder3B.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
        this.mBtnStreet.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnPhoneCall.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnGooutPref.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnSetStart.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnSetEnd.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnSetVia.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnSpace.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnFaverite.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnShare.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnStartNavi.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnNameAddr.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mTvName.setTextColor(StyleManager.getColor(C0965R.color.poi_name));
        this.mTvAddr.setTextColor(StyleManager.getColor(C0965R.color.poi_addr));
        this.mTvStartNavi.setTextColor(StyleManager.getColor(C0965R.color.poi_gonavi));
        this.mTvDistance.setTextColor(StyleManager.getColor(C0965R.color.poi_distance));
        this.mTvStreet.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvPhoneCall.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvGoouPref.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvSetStart.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvSetEnd.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvSetVia.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvFaverite.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvShare.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mTvSpace.setTextColor(StyleManager.getColor(C0965R.color.poi_item));
        this.mIvDragon.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_ic_pull_up_selector));
        this.mIvDragon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_btn_poi_dragon_selector));
        this.mContentLayout.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
    }

    public void updateStyle() {
        initSkins();
        updateDragonView();
    }

    public void setPanelOut() {
        isPanelOut = true;
        this.mLayoutPanel3.setVisibility(0);
        this.mLayoutPanel2.setVisibility(0);
    }

    public void setPanelIn() {
        isPanelOut = false;
        this.mLayoutPanel3.setVisibility(8);
        this.mLayoutPanel2.setVisibility(8);
    }

    public void trigglePanel() {
        isPanelOut = !isPanelOut;
        updatePanel();
    }

    private void updatePanel() {
    }

    private void outAnimation() {
        this.mLayoutParams.height = this.VIEW_HEIGHT;
        this.isAnimationing = false;
        this.isOut = true;
        updateDragonView();
        this.mPoiController.setMapffset(0, BNMapController.getInstance().getMapStatus()._Yoffset + ((long) (OUT_CAP / 2)));
        setLayoutParams(this.mLayoutParams);
    }

    public void setIsGragonOut(boolean isDragonOut) {
        this.isOut = isDragonOut;
        updateDragonView();
    }

    private void inAnimation() {
        this.mLayoutParams.height = this.VIEW_HEIGHT - OUT_CAP;
        this.isOut = false;
        updateDragonView();
        this.mPoiController.setMapffset(0, BNMapController.getInstance().getMapStatus()._Yoffset - ((long) (OUT_CAP / 2)));
        setLayoutParams(this.mLayoutParams);
    }

    private void updateDragonView() {
        if (this.isOut) {
            this.mIvDragon.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_ic_pull_down_selector));
        } else {
            this.mIvDragon.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_ic_pull_up_selector));
        }
    }

    private void updatePanelVisibility() {
        this.mLayoutPanel3.setVisibility(0);
        this.mLayoutPanel2.setVisibility(0);
        this.mHorDiverderC.setVisibility(0);
        this.mHorDiverderD.setVisibility(0);
    }

    public void updateContent() {
        initContents();
    }

    private void initContents() {
        if (this.mCurrentPoi != null) {
            this.mTvName.setText(this.mCurrentPoi.mName);
            this.mTvAddr.setText(this.mCurrentPoi.mAddress);
            if (TextUtils.isEmpty(this.mCurrentPoi.mPhone) || this.mCurrentPoi.mPhone.equals("null")) {
                this.mTvPhoneCall.setCompoundDrawablesWithIntrinsicBounds(null, StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_hasphone_disable), null, null);
                this.mBtnPhoneCall.setClickable(false);
            }
            if (!NetworkUtils.getConnectStatus()) {
                this.mTvGoouPref.setCompoundDrawablesWithIntrinsicBounds(null, StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_goout_disable), null, null);
                this.mBtnGooutPref.setClickable(false);
            }
            TextView textView = this.mTvDistance;
            PoiController poiController = this.mPoiController;
            textView.setText(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi));
            this.mPoiController.checkFavorite(this.mCurrentPoi, this.mFavoriteResultCallBack);
            updateStreetIcon();
        }
    }

    private void updateFavoriteIcon() {
        Drawable d;
        if (this.isFavorite) {
            d = StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_faverities);
            this.mTvFaverite.setText(C0965R.string.detail_favorite);
        } else {
            d = StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_not_faverities);
            this.mTvFaverite.setText(C0965R.string.detail_unfavorite);
        }
        this.mTvFaverite.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
    }

    private void updateStreetIcon() {
        Drawable d;
        if (TextUtils.isEmpty(this.mCurrentPoi.mStreetId)) {
            d = StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_street_disable);
            this.mBtnStreet.setClickable(false);
        } else {
            d = StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_street);
            this.mBtnStreet.setClickable(true);
        }
        this.mTvStreet.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
    }

    public void checkStreetId() {
    }

    public void antiPoi(GeoPoint geopoint, int xOffset, int yOffset) {
        if (geopoint != null && geopoint.isValid()) {
            this.isPickPoi = false;
            SearchPoi poi = new SearchPoi();
            poi.mViewPoint = geopoint;
            poi.mGuidePoint = geopoint;
            if (this.isMyPosition) {
                this.mPoiController.clearPoiCache();
            } else {
                this.mPoiController.focusPoi(poi);
                this.mPoiController.animationTo(geopoint, (long) xOffset, (long) yOffset);
            }
            int netMode = this.mPoiController.getAntiPoiNetMode(geopoint);
            if (netMode == -1) {
                poi.mName = StyleManager.getString(C0965R.string.poi_on_map);
            } else if (this.mPoiController.antiGeo(poi, netMode, this.mUIHandler)) {
                startAntiGeo();
            }
            setSearchPoi(poi);
        }
    }

    public void pickPoi(SearchPoi searchPoi, int xOffset, int yOffset) {
        if (searchPoi != null && searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
            this.isPickPoi = true;
            if (this.isMyPosition) {
                this.mPoiController.clearPoiCache();
            } else {
                this.mPoiController.focusPoi(searchPoi);
                this.mPoiController.animationTo(searchPoi, (long) xOffset, (long) yOffset);
            }
            int netMode = this.mPoiController.getAntiPoiNetMode(searchPoi.mViewPoint);
            if (netMode != -1 && this.mPoiController.antiGeo(searchPoi, netMode, this.mUIHandler)) {
                startAntiGeo();
            }
            setSearchPoi(searchPoi);
        }
    }

    private void updatePoiByAntiPoi(SearchPoi poi) {
        if (poi != null && this.mCurrentPoi != null) {
            if (this.isPickPoi) {
                String orgpoiName = this.mCurrentPoi.mName;
                this.mCurrentPoi = poi;
                this.mCurrentPoi.mName = orgpoiName;
            } else {
                this.mCurrentPoi = poi;
                if (poi.mType == 0) {
                    this.mCurrentPoi.mName = String.format(StyleManager.getString(C0965R.string.search_poi_fix), new Object[]{this.mCurrentPoi.mName});
                }
            }
            initContents();
        }
    }

    private void startAntiGeo() {
        if (!this.isPickPoi) {
            this.mPbAntiGeo.setVisibility(0);
            this.mTvName.setVisibility(8);
            this.mTvAddr.setVisibility(8);
        }
    }

    public void setMyPositionMode(boolean isMyPosition) {
        int i;
        boolean z;
        Drawable d;
        int i2 = 8;
        boolean z2 = true;
        this.isMyPosition = isMyPosition;
        View view = this.mBtnStartNavi;
        if (isMyPosition) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        View view2 = this.mVerDiverderA;
        if (!isMyPosition) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        View view3 = this.mBtnGooutPref;
        if (isMyPosition) {
            z = false;
        } else {
            z = true;
        }
        view3.setClickable(z);
        view2 = this.mBtnStartNavi;
        if (isMyPosition) {
            z2 = false;
        }
        view2.setClickable(z2);
        if (isMyPosition) {
            d = StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_goout_disable);
        } else {
            d = StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_goout);
        }
        this.mTvGoouPref.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void hide() {
        setVisibility(8);
        this.mCurrentPoi = null;
        this.mPoiController.clearPoiCache();
    }

    public void show() {
        if (this.VIEW_HEIGHT == 0) {
            this.VIEW_HEIGHT = ScreenUtil.getInstance().dip2px(NaviFragmentManager.TYPE_UGC_PICK_LINK);
            this.mLayoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.getInstance().dip2px(RouteLineResConst.LINE_ARR_FOOT_GREEN_NORMAL));
            setLayoutParams(this.mLayoutParams);
            this.isOut = false;
            updateDragonView();
        } else if (!isVisible()) {
            this.mLayoutParams.height = ScreenUtil.getInstance().dip2px(RouteLineResConst.LINE_ARR_FOOT_GREEN_NORMAL);
            setLayoutParams(this.mLayoutParams);
            this.isOut = false;
            updateDragonView();
        }
        setVisibility(0);
    }

    public void onResume() {
        if (this.mPoiController != null && isVisible() && !this.isMyPosition) {
            this.mPoiController.focusPoi(this.mCurrentPoi);
            int offset = ((getHeight() - ScreenUtil.getInstance().dip2px(60)) - ScreenUtil.getInstance().getStatusBarHeight()) / 2;
            if (this.mCurrentPoi != null) {
                this.mPoiController.animationTo(this.mCurrentPoi.mViewPoint, 0, (long) offset, -1, false);
            }
        }
    }

    public void handleShortUri(String shortUri) {
        C1307e.a().b("分享中，请稍等...");
        this.mPoiController.sharePoiParseShortUrl(shortUri, this.mUIHandler);
    }

    public boolean checkIsReGetAllFavPois() {
        return this.isFavorite && this.mIsFavOperate;
    }

    public void setOnDialogListener(C1277e listener) {
        this.mOnDialogListener = listener;
    }
}
