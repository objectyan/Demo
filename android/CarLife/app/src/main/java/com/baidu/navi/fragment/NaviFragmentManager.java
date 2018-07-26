package com.baidu.navi.fragment;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.OnFragmentListener;
import com.baidu.baidunavis.ui.BNCruiserFragment;
import com.baidu.baidunavis.ui.BNRouteDetailFragment;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment;
import com.baidu.carlife.fragment.AuthorizationRequestHelpFragment;
import com.baidu.carlife.fragment.ConnectHelpFragment;
import com.baidu.carlife.fragment.DisclaimerFragment;
import com.baidu.carlife.fragment.EditRescueInfoFragment;
import com.baidu.carlife.fragment.FeedbackFragment;
import com.baidu.carlife.fragment.HomeDiscoverFoodDetailFragment;
import com.baidu.carlife.fragment.HomeDiscoverFoodFragment;
import com.baidu.carlife.fragment.HomeDiscoverFragment;
import com.baidu.carlife.fragment.HomeDiscoverParkListFragment;
import com.baidu.carlife.fragment.HomeFragment;
import com.baidu.carlife.fragment.HomeHelpFragment;
import com.baidu.carlife.fragment.HomeMoreFragment;
import com.baidu.carlife.fragment.HomeMyDetailFragment;
import com.baidu.carlife.fragment.HomeMySkinFragment;
import com.baidu.carlife.fragment.LaunchFragment;
import com.baidu.carlife.fragment.LoginFragment;
import com.baidu.carlife.fragment.MapSettingFragment;
import com.baidu.carlife.fragment.MusicAlbumListFragment;
import com.baidu.carlife.fragment.MusicPlayerFragment;
import com.baidu.carlife.fragment.NewUserGuideFragment;
import com.baidu.carlife.fragment.PhoneFragment;
import com.baidu.carlife.fragment.PrivacyPolicyFragment;
import com.baidu.carlife.fragment.RoadRescueFragment;
import com.baidu.carlife.fragment.SettingAboutFragment;
import com.baidu.carlife.fragment.SettingFragment;
import com.baidu.carlife.fragment.SettingNaviFragment;
import com.baidu.carlife.fragment.SettingServiceFragment;
import com.baidu.carlife.fragment.SettingTTSFragment;
import com.baidu.carlife.fragment.SettingVoiceFragment;
import com.baidu.carlife.fragment.UsbDebugFragment;
import com.baidu.carlife.fragment.VoiceSettingFragment;
import com.baidu.carlife.fragment.WebViewFragment;
import com.baidu.carlife.fragment.YMServiceDetailFragment;
import com.baidu.carlife.radio.channel.RadioChannelFragment;
import com.baidu.carlife.radio.player.RadioPlayerFragment;
import com.baidu.carlife.wechat.fragment.BlacklistFragment;
import com.baidu.carlife.wechat.fragment.ChatFragment;
import com.baidu.carlife.wechat.fragment.ContactFragment;
import com.baidu.carlife.wechat.fragment.SessionFragment;
import com.baidu.carlife.wechat.fragment.WechatFragment;
import com.baidu.carlife.wechat.fragment.WechatLoginFragment;
import com.baidu.carlife.wechat.fragment.WechatLogoutFragment;
import com.baidu.carlife.wechat.fragment.WechatSettingFragment;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment;
import com.baidu.navi.fragment.carmode.CarModeFavoriteFragment;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment;
import com.baidu.navi.fragment.carmode.CarModeOfflineMapDataFragment;
import com.baidu.navi.fragment.carmode.CarModeOfflineMapManagerFragment;
import com.baidu.navi.fragment.carmode.CarModePoiDetailFragment;
import com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment;
import com.baidu.navi.fragment.carmode.CarModeSearchResultFragment;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.comapi.voicecommand.OnVoiceCommandListener;
import java.util.Iterator;

public class NaviFragmentManager extends ContentFragmentManager implements IContentFragmentFactory {
    public static final int CAR_MODE = 2;
    public static final int MAP_MODE = 1;
    public static final int TYPE_ABOUT = 261;
    public static final int TYPE_ABOUT_WEBVIEW = 289;
    public static final int TYPE_ASR_CONTROL = 65;
    public static final int TYPE_ASR_DISTRICT = 66;
    public static final int TYPE_AUTHORIZATION_REQUEST_HELP = 577;
    public static final int TYPE_CAR_DRV_LIST = 131;
    public static final int TYPE_CAR_DRV_PLAY = 130;
    public static final int TYPE_CAR_DRV_RECORD = 129;
    public static final int TYPE_CAR_DRV_SETTING = 132;
    public static final int TYPE_COMMON_QUESTION = 567;
    public static final int TYPE_CONNECT_HELP = 547;
    public static final int TYPE_CRUISE = 114;
    public static final int TYPE_CRUISE_FOLLOW = 116;
    public static final int TYPE_CUSTOM_CENTER = 535;
    public static final int TYPE_DATA_UPDATE_LOG = 292;
    public static final int TYPE_DISCLAIMER = 515;
    public static final int TYPE_FAVORITE = 81;
    public static final int TYPE_FAVORITE_EDIT = 89;
    public static final int TYPE_FAVORITE_PICK = 88;
    public static final int TYPE_GUID = 516;
    public static final int TYPE_GUIDE_END = 115;
    public static final int TYPE_HELP = 263;
    public static final int TYPE_HISTORY_DEST = 304;
    public static final int TYPE_HOME = 531;
    public static final int TYPE_HOME_DISCOVER = 542;
    public static final int TYPE_HOME_DISCOVER_CWYD = 566;
    public static final int TYPE_HOME_DISCOVER_EDIT_RESCUE_INFO = 551;
    public static final int TYPE_HOME_DISCOVER_ETCP = 562;
    public static final int TYPE_HOME_DISCOVER_FOOD = 553;
    public static final int TYPE_HOME_DISCOVER_FOOD_DETAIL = 560;
    public static final int TYPE_HOME_DISCOVER_JYB = 561;
    public static final int TYPE_HOME_DISCOVER_LXC = 563;
    public static final int TYPE_HOME_DISCOVER_PARK = 546;
    public static final int TYPE_HOME_DISCOVER_RESCUE = 550;
    public static final int TYPE_HOME_DOWNLOAD_PLUGIN = 576;
    public static final int TYPE_HOME_END = 735;
    public static final int TYPE_HOME_HELP_PANEL = 565;
    public static final int TYPE_HOME_MORE = 545;
    public static final int TYPE_HOME_MORE_ACTS = 564;
    public static final int TYPE_HOME_MY = 543;
    public static final int TYPE_HOME_MY_DETAIL = 544;
    public static final int TYPE_HOME_MY_SKIN = 549;
    public static final int TYPE_HOME_NAVI = 17;
    public static final int TYPE_HOME_START = 528;
    public static final int TYPE_LAUNCH = 514;
    public static final int TYPE_LINE_CARLIFE_NAVI_END = 768;
    public static final int TYPE_LINE_CARLIFE_NAVI_START = 512;
    public static final int TYPE_LOCAL_MAP_MANAGER = 556;
    public static final int TYPE_LOCAL_MAP_PAGE = 555;
    public static final int TYPE_LOGIN = 548;
    public static final int TYPE_MAP_FAVORITE = 306;
    public static final int TYPE_MAP_HOME_PLUGIN = 305;
    public static final int TYPE_MAP_SETTING = 580;
    public static final int TYPE_MAP_YMSERVICEDETAIL = 552;
    public static final int TYPE_MARKET_ACTIVE = 291;
    public static final int TYPE_MILEAGE_RANK = 84;
    public static final int TYPE_MORE_CATALOG_SEARCH = 38;
    public static final int TYPE_MUSIC_ALBUMLIST = 745;
    public static final int TYPE_MUSIC_END = 767;
    public static final int TYPE_MUSIC_PLAYER = 737;
    public static final int TYPE_MUSIC_START = 736;
    public static final int TYPE_MY_CAR_RECORD = 579;
    public static final int TYPE_NAME_SEARCH = 34;
    public static final int TYPE_NEWS_CENTER = 86;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OFFLINE_DATA = 554;
    public static final int TYPE_PHONE = 519;
    public static final int TYPE_PHONE_END = 527;
    public static final int TYPE_PHONE_START = 518;
    public static final int TYPE_PICK_POINT_ON_MAP = 18;
    public static final int TYPE_POI_DETAIL = 33;
    public static final int TYPE_PRIVACY_POLICY = 517;
    public static final int TYPE_QUICK_ROUTE_PLAN = 49;
    public static final int TYPE_RADIO_CHANNEL = 594;
    public static final int TYPE_RADIO_END = 596;
    public static final int TYPE_RADIO_PLAYER = 595;
    public static final int TYPE_RADIO_START = 593;
    public static final int TYPE_ROUTE_CUSTOM_DETAIL = 294;
    public static final int TYPE_ROUTE_CUSTOM_MGR = 293;
    public static final int TYPE_ROUTE_DETAIL = 52;
    public static final int TYPE_ROUTE_DRIVING_REFERENCE = 53;
    public static final int TYPE_ROUTE_FEEDBACK = 273;
    public static final int TYPE_ROUTE_GUIDE = 113;
    public static final int TYPE_ROUTE_PLAN = 50;
    public static final int TYPE_ROUTE_PLAN_NODE = 51;
    public static final int TYPE_ROUTE_RECORD = 578;
    public static final int TYPE_SCORE_SHOP = 290;
    public static final int TYPE_SEAECH_DISTRICT = 36;
    public static final int TYPE_SEARCH_RESULT = 35;
    public static final int TYPE_SELECT_MODE = 275;
    public static final int TYPE_SETTING = 260;
    public static final int TYPE_SETTING_ABOUT_CONTENT = 539;
    public static final int TYPE_SETTING_CAR_PLATE = 557;
    public static final int TYPE_SETTING_CONTENT = 533;
    public static final int TYPE_SETTING_FEEDBACK = 537;
    public static final int TYPE_SETTING_NAVI = 532;
    public static final int TYPE_SETTING_SERVICE_CONTENT = 540;
    public static final int TYPE_SETTING_TTS = 568;
    public static final int TYPE_SETTING_VOICE_CONTENT = 538;
    public static final int TYPE_SHOW_DETAIL = 264;
    public static final int TYPE_STREETSCAPE = 20;
    public static final int TYPE_TRACK = 83;
    public static final int TYPE_TRACK_DETAIL = 87;
    public static final int TYPE_UGC_MANAGER = 326;
    public static final int TYPE_UGC_PICK_LINK = 327;
    public static final int TYPE_UGC_YAW_COMMENT = 325;
    public static final int TYPE_USB_CONNECT = 529;
    public static final int TYPE_USB_DEBUG = 513;
    public static final int TYPE_USER_CENTER = 82;
    public static final int TYPE_VOICE_DETAIL = 321;
    public static final int TYPE_VOICE_MAIN = 320;
    public static final int TYPE_VOICE_RECORD = 324;
    public static final int TYPE_VOICE_RECORDLIST = 323;
    public static final int TYPE_VOICE_SETTING = 581;
    public static final int TYPE_VOICE_SQUARE = 322;
    public static final int TYPE_WECHAT_BLACKLIST = 590;
    public static final int TYPE_WECHAT_CHAT = 587;
    public static final int TYPE_WECHAT_CONTACT = 588;
    public static final int TYPE_WECHAT_END = 592;
    public static final int TYPE_WECHAT_LOGIN = 585;
    public static final int TYPE_WECHAT_LOGOUT = 591;
    public static final int TYPE_WECHAT_MAIN = 584;
    public static final int TYPE_WECHAT_SESSION = 586;
    public static final int TYPE_WECHAT_SETTING = 589;
    public static final int TYPE_WECHAT_START = 583;
    private boolean mIsDriving = false;
    private int mPreviousFragmentType = 0;
    private OnVoiceCommandListener mVoiceCmdListener = new C38111();

    /* renamed from: com.baidu.navi.fragment.NaviFragmentManager$1 */
    class C38111 implements OnVoiceCommandListener {
        C38111() {
        }

        public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
            if (NaviFragmentManager.this.mCurrentFragmentInfo.mFragment.onVoiceCommand(type, subType, arg1, arg2, needResponse)) {
                return true;
            }
            if (type != 3) {
                return false;
            }
            if (subType == 2) {
                return false;
            }
            if (subType != 1) {
                return false;
            }
            NaviFragmentManager.this.back(null);
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
            return true;
        }
    }

    public NaviFragmentManager(OnFragmentListener activity) {
        super(activity);
        setFragmentFactory(this);
        BNVoiceCommandController.getInstance().setOnVoiceCommandListener(this.mVoiceCmdListener);
    }

    public static boolean isUsingMapMode() {
        return false;
    }

    public ContentFragment createFragment(int type) {
        boolean isMapMode = isUsingMapMode();
        ContentFragment fragment = null;
        switch (type) {
            case 17:
                if (!isMapMode) {
                    fragment = new CarModeMapFragment();
                    break;
                }
                fragment = new BrowseMapFragment();
                break;
            case 18:
                fragment = new PickPointOnMapFragment();
                break;
            case 20:
            case 50:
            case 51:
            case 53:
            case 65:
            case 66:
            case 81:
            case 82:
            case 83:
            case 84:
            case 86:
            case 87:
            case 88:
            case 89:
            case 115:
            case TYPE_CAR_DRV_RECORD /*129*/:
            case 130:
            case TYPE_CAR_DRV_LIST /*131*/:
            case TYPE_CAR_DRV_SETTING /*132*/:
            case 260:
            case 261:
            case 263:
            case 264:
            case 273:
            case 275:
            case 289:
            case 290:
            case TYPE_DATA_UPDATE_LOG /*292*/:
            case TYPE_ROUTE_CUSTOM_MGR /*293*/:
            case TYPE_ROUTE_CUSTOM_DETAIL /*294*/:
            case 305:
            case TYPE_VOICE_MAIN /*320*/:
            case TYPE_VOICE_DETAIL /*321*/:
            case TYPE_VOICE_SQUARE /*322*/:
            case TYPE_VOICE_RECORDLIST /*323*/:
            case TYPE_VOICE_RECORD /*324*/:
            case 325:
            case TYPE_UGC_MANAGER /*326*/:
            case TYPE_UGC_PICK_LINK /*327*/:
                break;
            case 33:
                if (!isMapMode) {
                    fragment = new CarModePoiDetailFragment();
                    break;
                }
                fragment = new PoiDetailFragment();
                break;
            case 34:
                fragment = new NameSearchFragment();
                break;
            case 35:
                if (!isMapMode) {
                    fragment = new CarModeSearchResultFragment();
                    break;
                }
                fragment = new SearchResultFragment();
                break;
            case 49:
                fragment = new CarModeQuickRoutePlanFragment();
                break;
            case 52:
                fragment = new BNRouteDetailFragment();
                break;
            case 113:
                fragment = new BNRouteGuideFragment();
                break;
            case 114:
                fragment = new BNCruiserFragment();
                break;
            case 116:
                fragment = new CruiseFollowFragment();
                break;
            case 304:
                fragment = new CarModeFavoriteDestFragment();
                break;
            case 306:
                fragment = new CarModeFavoriteFragment();
                break;
            case 513:
                fragment = new UsbDebugFragment();
                break;
            case 514:
                fragment = new LaunchFragment();
                break;
            case 515:
                fragment = new DisclaimerFragment();
                break;
            case 516:
                fragment = new NewUserGuideFragment();
                break;
            case 517:
                fragment = new PrivacyPolicyFragment();
                break;
            case 519:
                fragment = new PhoneFragment();
                break;
            case TYPE_HOME /*531*/:
                fragment = new HomeFragment();
                break;
            case TYPE_SETTING_NAVI /*532*/:
                fragment = new SettingNaviFragment();
                break;
            case TYPE_SETTING_CONTENT /*533*/:
                fragment = new SettingFragment();
                break;
            case TYPE_SETTING_FEEDBACK /*537*/:
                fragment = new FeedbackFragment();
                break;
            case TYPE_SETTING_VOICE_CONTENT /*538*/:
                fragment = new SettingVoiceFragment();
                break;
            case 539:
                fragment = new SettingAboutFragment();
                break;
            case 540:
                fragment = new SettingServiceFragment();
                break;
            case TYPE_HOME_DISCOVER /*542*/:
                fragment = new HomeDiscoverFragment();
                break;
            case TYPE_HOME_MY_DETAIL /*544*/:
                fragment = new HomeMyDetailFragment();
                break;
            case TYPE_HOME_MORE /*545*/:
                fragment = new HomeMoreFragment();
                break;
            case TYPE_HOME_DISCOVER_PARK /*546*/:
                fragment = new HomeDiscoverParkListFragment();
                break;
            case TYPE_CONNECT_HELP /*547*/:
                fragment = new ConnectHelpFragment();
                break;
            case TYPE_LOGIN /*548*/:
                fragment = new LoginFragment();
                break;
            case TYPE_HOME_MY_SKIN /*549*/:
                fragment = new HomeMySkinFragment();
                break;
            case TYPE_HOME_DISCOVER_RESCUE /*550*/:
                fragment = new RoadRescueFragment();
                break;
            case 551:
                fragment = new EditRescueInfoFragment();
                break;
            case TYPE_MAP_YMSERVICEDETAIL /*552*/:
                fragment = new YMServiceDetailFragment();
                break;
            case TYPE_HOME_DISCOVER_FOOD /*553*/:
                fragment = new HomeDiscoverFoodFragment();
                break;
            case TYPE_OFFLINE_DATA /*554*/:
                fragment = new CarModeOfflineDataFragment();
                break;
            case TYPE_LOCAL_MAP_PAGE /*555*/:
                fragment = new CarModeOfflineMapDataFragment();
                break;
            case TYPE_LOCAL_MAP_MANAGER /*556*/:
                fragment = new CarModeOfflineMapManagerFragment();
                break;
            case TYPE_SETTING_CAR_PLATE /*557*/:
                fragment = new CarPlateFragment();
                break;
            case TYPE_HOME_DISCOVER_FOOD_DETAIL /*560*/:
                fragment = new HomeDiscoverFoodDetailFragment();
                break;
            case TYPE_HOME_DISCOVER_JYB /*561*/:
            case TYPE_HOME_DISCOVER_ETCP /*562*/:
            case TYPE_HOME_DISCOVER_LXC /*563*/:
            case TYPE_HOME_MORE_ACTS /*564*/:
            case TYPE_HOME_DISCOVER_CWYD /*566*/:
            case TYPE_COMMON_QUESTION /*567*/:
                fragment = new WebViewFragment();
                break;
            case TYPE_HOME_HELP_PANEL /*565*/:
                fragment = new HomeHelpFragment();
                break;
            case TYPE_SETTING_TTS /*568*/:
                fragment = new SettingTTSFragment();
                break;
            case TYPE_AUTHORIZATION_REQUEST_HELP /*577*/:
                fragment = new AuthorizationRequestHelpFragment();
                break;
            case TYPE_ROUTE_RECORD /*578*/:
                fragment = new RouteRecordFragment();
                break;
            case TYPE_MY_CAR_RECORD /*579*/:
                fragment = new MyDvrFragment();
                break;
            case TYPE_MAP_SETTING /*580*/:
                fragment = new MapSettingFragment();
                break;
            case TYPE_VOICE_SETTING /*581*/:
                fragment = new VoiceSettingFragment();
                break;
            case TYPE_WECHAT_MAIN /*584*/:
                fragment = new WechatFragment();
                break;
            case TYPE_WECHAT_LOGIN /*585*/:
                fragment = new WechatLoginFragment();
                break;
            case TYPE_WECHAT_SESSION /*586*/:
                fragment = new SessionFragment();
                break;
            case TYPE_WECHAT_CHAT /*587*/:
                fragment = new ChatFragment();
                break;
            case TYPE_WECHAT_CONTACT /*588*/:
                fragment = new ContactFragment();
                break;
            case TYPE_WECHAT_SETTING /*589*/:
                fragment = new WechatSettingFragment();
                break;
            case TYPE_WECHAT_BLACKLIST /*590*/:
                fragment = new BlacklistFragment();
                break;
            case TYPE_WECHAT_LOGOUT /*591*/:
                fragment = new WechatLogoutFragment();
                break;
            case TYPE_RADIO_CHANNEL /*594*/:
                fragment = new RadioChannelFragment();
                break;
            case TYPE_RADIO_PLAYER /*595*/:
                fragment = new RadioPlayerFragment();
                break;
            case TYPE_MUSIC_PLAYER /*737*/:
                fragment = new MusicPlayerFragment();
                break;
            case TYPE_MUSIC_ALBUMLIST /*745*/:
                fragment = new MusicAlbumListFragment();
                break;
            default:
                if (null == null) {
                    type = 0;
                    break;
                }
                break;
        }
        if (fragment != null) {
            fragment.setType(type);
        }
        return fragment;
    }

    public String toString(int type) {
        String str;
        switch (type) {
            case 17:
                return "TYPE_HOME_NAVI";
            case 18:
                return "TYPE_PICK_POINT_ON_MAP";
            case 20:
                return "TYPE_STREETSCAPE";
            case 33:
                return "TYPE_POI_DETAIL";
            case 34:
                return "TYPE_NAME_SEARCH";
            case 35:
                return "TYPE_SEARCH_RESULT";
            case 36:
                return "TYPE_SEAECH_DISTRICT";
            case 38:
                return "TYPE_MORE_CATALOG_SEARCH";
            case 49:
                return "TYPE_QUICK_ROUTE_PLAN";
            case 50:
                return "TYPE_ROUTE_PLAN";
            case 51:
                return "TYPE_ROUTE_PLAN_NODE";
            case 52:
                return "TYPE_ROUTE_DETAIL";
            case 53:
                return "TYPE_ROUTE_DRIVING_REFERENCE";
            case 65:
                return "TYPE_ASR_CONTROL";
            case 66:
                return "TYPE_ASR_DISTRICT";
            case 81:
                return "TYPE_FAVORITE";
            case 82:
                return "TYPE_USER_CENTER";
            case 83:
                return "TYPE_TRACK";
            case 84:
                return "TYPE_MILEAGE_RANK";
            case 86:
                return "TYPE_NEWS_CENTER";
            case 87:
                return "TYPE_TRACK_DETAIL";
            case 88:
                return "TYPE_FAVORITE_PICK";
            case 89:
                return "TYPE_FAVORITE_EDIT";
            case 113:
                return "TYPE_ROUTE_GUIDE";
            case 114:
                return "TYPE_CRUISE";
            case TYPE_CAR_DRV_RECORD /*129*/:
                return "TYPE_CAR_DRV_RECORD";
            case 130:
                return "TYPE_CAR_DRV_PLAY";
            case TYPE_CAR_DRV_LIST /*131*/:
                return "TYPE_CAR_DRV_LIST";
            case TYPE_CAR_DRV_SETTING /*132*/:
                return "TYPE_CAR_DRV_SETTING";
            case 260:
                return "TYPE_SETTING";
            case 261:
                return "TYPE_ABOUT";
            case 263:
                return "TYPE_HELP";
            case 264:
                return "TYPE_SHOW_DETAIL";
            case 273:
                return "TYPE_ROUTE_FEEDBACK";
            case 275:
                return "TYPE_SELECT_MODE";
            case 289:
                return "TYPE_ABOUT_WEBVIEW";
            case TYPE_ROUTE_CUSTOM_MGR /*293*/:
                str = "TYPE_ROUTE_CUSTOM_MGR";
                break;
            case TYPE_ROUTE_CUSTOM_DETAIL /*294*/:
                return "TYPE_ROUTE_CUSTOM_DETAIL";
            case TYPE_VOICE_MAIN /*320*/:
                return "TYPE_VOICE_MAIN";
            case TYPE_VOICE_DETAIL /*321*/:
                return "TYPE_VOICE_DETAIL";
            case TYPE_VOICE_SQUARE /*322*/:
                return "TYPE_VOICE_SQUARE";
            case TYPE_VOICE_RECORDLIST /*323*/:
                return "TYPE_VOICE_RECORDLIST";
            case TYPE_VOICE_RECORD /*324*/:
                return "TYPE_VOICE_RECORD";
            case 325:
                return "TYPE_UGC_YAW_COMMENT";
            case TYPE_UGC_MANAGER /*326*/:
                return "TYPE_UGC_MANAGER";
            case TYPE_UGC_PICK_LINK /*327*/:
                return "TYPE_UGC_PICK_LINK";
            case 513:
                return "TYPE_USB_DEBUG";
            case 514:
                return "TYPE_LAUNCH";
            case 515:
                return "TYPE_DISCLAIMER";
            case 516:
                return "TYPE_GUID";
            case 517:
                return "TYPE_PRIVACY_POLICY";
            case 519:
                return "TYPE_PHONE";
            case TYPE_USB_CONNECT /*529*/:
                return "TYPE_USB_CONNECT";
            case TYPE_HOME /*531*/:
                return "TYPE_HOME";
            case TYPE_SETTING_NAVI /*532*/:
                return "TYPE_SETTING_NAVI";
            case TYPE_SETTING_CONTENT /*533*/:
                return "TYPE_SETTING_CONTENT";
            case TYPE_CUSTOM_CENTER /*535*/:
                return "TYPE_CUSTOM_CENTER";
            case TYPE_SETTING_FEEDBACK /*537*/:
                return "TYPE_SETTING_FEEDBACK";
            case TYPE_SETTING_VOICE_CONTENT /*538*/:
                return "TYPE_SETTING_VOICE_CONTENT";
            case 539:
                return "TYPE_SETTING_ABOUT_CONTENT";
            case 540:
                return "TYPE_SETTING_SERVICE_CONTENT";
            case TYPE_HOME_DISCOVER /*542*/:
                return "TYPE_HOME_DISCOVER";
            case TYPE_HOME_MY /*543*/:
                return "TYPE_HOME_MY";
            case TYPE_HOME_MY_DETAIL /*544*/:
                return "TYPE_HOME_MY_DETAIL";
            case TYPE_HOME_MORE /*545*/:
                return "TYPE_HOME_MORE";
            case TYPE_HOME_DISCOVER_PARK /*546*/:
                return "TYPE_HOME_DISCOVER_PARK";
            case TYPE_CONNECT_HELP /*547*/:
                return "TYPE_CONNECT_HELP";
            case TYPE_HOME_MY_SKIN /*549*/:
                return "TYPE_HOME_MY_SKIN";
            case TYPE_HOME_DISCOVER_RESCUE /*550*/:
                break;
            case 551:
                break;
            case TYPE_MAP_YMSERVICEDETAIL /*552*/:
                return "TYPE_MAP_YMSERVICEDETAIL";
            case TYPE_OFFLINE_DATA /*554*/:
                return "TYPE_OFFLINE_DATA";
            case TYPE_SETTING_CAR_PLATE /*557*/:
                return "TYPE_SETTING_CAR_PLATE";
            case TYPE_HOME_HELP_PANEL /*565*/:
                return "TYPE_HOME_HELP_PANEL";
            case TYPE_COMMON_QUESTION /*567*/:
                return "TYPE_COMMON_QUESTION";
            case TYPE_SETTING_TTS /*568*/:
                return "TYPE_SETTING_TTS";
            case TYPE_MAP_SETTING /*580*/:
                return "TYPE_MAP_SETTING";
            case TYPE_VOICE_SETTING /*581*/:
                return "TYPE_VOICE_SETTING";
            case TYPE_MUSIC_PLAYER /*737*/:
                return "TYPE_MUSIC_PLAYER";
            case TYPE_MUSIC_ALBUMLIST /*745*/:
                return "TYPE_MUSIC_PLAYLIST";
            default:
                return "TYPE_NONE";
        }
        str = "TYPE_HOME_DISCOVER_RESCUE";
        return "TYPE_HOME_DISCOVER_EDIT_RESCUE_INFO";
    }

    public int getCurrentFragmentType() {
        if (this.mCurrentFragmentInfo == null || this.mCurrentFragmentInfo.mFragment == null) {
            return 0;
        }
        return this.mCurrentFragmentInfo.mFragment.getType();
    }

    public int getPreviousFragmentType() {
        return this.mPreviousFragmentType;
    }

    public void backTo(int type, Bundle bundle) {
        int index = -1;
        for (int j = this.mFragmentInfoStack.size() - 1; j >= 0; j--) {
            if (((FragmentInfo) this.mFragmentInfoStack.get(j)).mType == type) {
                index = j;
            }
        }
        if (index != -1) {
            int i = this.mFragmentInfoStack.size() - 1;
            while (i >= 0) {
                if (((FragmentInfo) this.mFragmentInfoStack.get(i)).mType == type && i == index) {
                    back(bundle);
                    C1260i.b("NaviFragmentManager", "remove back " + i);
                    return;
                }
                if (((FragmentInfo) this.mFragmentInfoStack.get(i)).mType == type) {
                    this.mFragmentInfoStack.remove(i);
                    C1260i.b("NaviFragmentManager", "remove " + i);
                } else {
                    removeFragmentFromStack(i);
                    C1260i.b("NaviFragmentManager", "remove stack" + i);
                }
                i--;
            }
        }
    }

    public void backToHomeNavi() {
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (getCurrentFragmentType() != 17) {
                back(null);
            }
        }
    }

    public void removeFragmentTo(int type) {
        int index = getIndexFromLast(type);
        if (index >= 0) {
            for (int i = this.mFragmentInfoStack.size() - 1; i > index; i--) {
                removeFragmentFromStack(i);
            }
        }
    }

    public ContentFragment getLatestFragment(int type) {
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (((FragmentInfo) this.mFragmentInfoStack.get(i)).mType == type) {
                return ((FragmentInfo) this.mFragmentInfoStack.get(i)).mFragment;
            }
        }
        return null;
    }

    public void showLatestHomeFragment() {
        FragmentInfo fragmentInfo = null;
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeHomeFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                break;
            }
        }
        if (fragmentInfo == null) {
            fragmentInfo = new FragmentInfo(new HomeFragment(), TYPE_HOME);
            push(fragmentInfo);
        }
        showFragment(fragmentInfo.mType, null);
        C1261k.b(C1253f.gR);
        if (this.mUiListener != null) {
            this.mUiListener.updateGaussianBlurBackground();
            this.mUiListener.updateMainDisplayStatus(4001);
        }
    }

    public void showFirstHomeFragment() {
        FragmentInfo fragmentInfo = null;
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (((FragmentInfo) this.mFragmentInfoStack.get(i)).mType == TYPE_HOME) {
                fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                break;
            }
        }
        if (fragmentInfo == null) {
            fragmentInfo = new FragmentInfo(new HomeFragment(), TYPE_HOME);
            push(fragmentInfo);
        }
        showFragment(fragmentInfo.mType, null);
        if (this.mUiListener != null) {
            this.mUiListener.updateGaussianBlurBackground();
            this.mUiListener.updateMainDisplayStatus(4001);
        }
    }

    public void showLatestPhoneFragment() {
        FragmentInfo fragmentInfo = null;
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeTelephoneFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                break;
            }
        }
        if (fragmentInfo == null) {
            fragmentInfo = new FragmentInfo(new PhoneFragment(), 519);
            push(fragmentInfo);
        }
        C1261k.b(C1253f.gR);
        if (this.mUiListener != null) {
            this.mUiListener.updateGaussianBlurBackground();
            this.mUiListener.updateMainDisplayStatus(4002);
        }
        showFragment(fragmentInfo.mType, null);
    }

    public BaseFragment getLatestMusicFragment() {
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeMusicFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                return ((FragmentInfo) this.mFragmentInfoStack.get(i)).mFragment;
            }
        }
        return null;
    }

    public void showLatestMusicFragment() {
        FragmentInfo fragmentInfo = null;
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeMusicFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                break;
            }
        }
        if (fragmentInfo == null) {
            fragmentInfo = new FragmentInfo(new MusicPlayerFragment(), TYPE_MUSIC_PLAYER);
            push(fragmentInfo);
        }
        C1261k.b(C1253f.gR);
        if (this.mUiListener != null) {
            this.mUiListener.updateGaussianBlurBackground();
            this.mUiListener.updateMainDisplayStatus(4004);
        }
        showFragment(fragmentInfo.mType, null);
    }

    public void showFragment(int type, Bundle bundle) {
        if (type != 116) {
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
        if (BaseFragment.mActivity == null) {
            return;
        }
        if (VERSION.SDK_INT <= 16 || !BaseFragment.mActivity.isDestroyed()) {
            if (isCarlifeFragment(type)) {
                super.showCarlifeFragment(type, bundle);
            } else {
                super.showFragment(type, bundle);
            }
            if (this.mUiListener != null) {
                if (isNeedHideTabFragment(type)) {
                    this.mUiListener.setBottomBarStatus(false);
                } else {
                    this.mUiListener.setBottomBarStatus(true);
                }
                this.mUiListener.updateGaussianBlurBackground();
            }
            int i;
            if (type == 20) {
                int index = getIndexFromLast(type);
                if (index >= 0) {
                    for (i = this.mFragmentInfoStack.size() - 1; i >= index; i--) {
                        removeFragmentFromStack(i);
                    }
                }
            } else if (type == 113) {
                int index_home = getIndexFromLast(17);
                int index_routeguide = getIndexFromLast(113);
                if (index_home >= 0 && index_routeguide >= 0 && index_routeguide > index_home) {
                    for (i = index_routeguide; i > index_home; i--) {
                        removeFragmentFromStack(i);
                    }
                }
            }
        }
    }

    public boolean isNeedHideTabFragment(int type) {
        if (type == 516 || type == 514 || type == TYPE_LOGIN || type == 515 || type == 513 || type == TYPE_HOME_DISCOVER_CWYD || type == TYPE_HOME_DISCOVER_ETCP || type == TYPE_HOME_DISCOVER_JYB || type == TYPE_HOME_DISCOVER_LXC || type == TYPE_HOME_DISCOVER_FOOD || type == TYPE_HOME_DISCOVER_FOOD_DETAIL || type == TYPE_HOME_DISCOVER_PARK || type == 551 || type == TYPE_HOME_DISCOVER_RESCUE || type == TYPE_MAP_YMSERVICEDETAIL || type == TYPE_HOME_MORE_ACTS || type == TYPE_LOCAL_MAP_PAGE || type == TYPE_LOCAL_MAP_MANAGER || type == TYPE_OFFLINE_DATA || type == TYPE_SETTING_NAVI || type == TYPE_SETTING_CAR_PLATE) {
            return true;
        }
        return false;
    }

    private int getIndexFromLast(int type) {
        int i = this.mFragmentInfoStack.size() - 1;
        while (i >= 0 && ((FragmentInfo) this.mFragmentInfoStack.get(i)).mType != type) {
            i--;
        }
        return i;
    }

    public boolean isNaviStart() {
        Iterator it = this.mFragmentInfoStack.iterator();
        while (it.hasNext()) {
            if (!isCarlifeFragment(((FragmentInfo) it.next()).mType)) {
                return true;
            }
        }
        return false;
    }

    public void showLatestNaviFragment() {
        backToNavi(null);
    }

    public Fragment getLatestNaviFragment() {
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (!isCarlifeFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                return ((FragmentInfo) this.mFragmentInfoStack.get(i)).mFragment;
            }
        }
        return null;
    }

    public void push(ContentFragment fragment) {
        push(new FragmentInfo(fragment, fragment.getType()));
    }

    public boolean isCarlifeFragment(int type) {
        if (type <= 512 || type >= TYPE_LINE_CARLIFE_NAVI_END) {
            return false;
        }
        return true;
    }

    public boolean isCarlifeHomeFragment(int type) {
        if (type <= TYPE_HOME_START || type >= TYPE_HOME_END) {
            return false;
        }
        return true;
    }

    public boolean isCarlifeRadioMusicFragment(int type) {
        if (type <= TYPE_RADIO_START || type >= TYPE_RADIO_END) {
            return false;
        }
        return true;
    }

    public boolean isCarlifeMusicFragment(int type) {
        if (type <= TYPE_MUSIC_START || type >= TYPE_MUSIC_END) {
            return false;
        }
        return true;
    }

    public boolean isCarlifeMusicNeteaseFragment(int type) {
        if (type == TYPE_MUSIC_PLAYER || type == TYPE_MUSIC_ALBUMLIST) {
            return true;
        }
        return false;
    }

    public boolean isCarlifeMusicThirdFragment(int type) {
        if (type == TYPE_MUSIC_PLAYER || type == TYPE_MUSIC_ALBUMLIST) {
            return true;
        }
        return false;
    }

    public boolean isCarlifeMusicLocalFragment(int type) {
        if (type == TYPE_MUSIC_PLAYER) {
            return true;
        }
        return false;
    }

    public boolean isCarlifeTelephoneFragment(int type) {
        if (type <= 518 || type >= TYPE_PHONE_END) {
            return false;
        }
        return true;
    }

    public boolean isCarlifeLaunchFragment(int type) {
        return type == 514 || type == 516 || type == 515 || type == 513 || type == 517;
    }

    public boolean isWeChatFragment(int type) {
        return type > TYPE_WECHAT_START && type < TYPE_WECHAT_END;
    }

    public boolean isRadioFragment(int type) {
        return type > TYPE_RADIO_START && type < TYPE_RADIO_END;
    }

    public String getCurFragmentModule() {
        int curType = this.mCurrentFragmentInfo.mType;
        if (!isCarlifeFragment(curType)) {
            return "MAP";
        }
        if (isCarlifeMusicFragment(curType)) {
            return "MUSIC";
        }
        if (isCarlifeTelephoneFragment(curType)) {
            return "PHONE";
        }
        return "HOME";
    }

    public int getCurFragmentModuleType() {
        int curType = this.mCurrentFragmentInfo.mType;
        if (!isCarlifeFragment(curType)) {
            return 4003;
        }
        if (isCarlifeMusicFragment(curType)) {
            return 4004;
        }
        if (isCarlifeTelephoneFragment(curType)) {
            return 4002;
        }
        return 4001;
    }

    public boolean isCarLifeMusicSDKFragment(ContentFragment cruFra, ContentFragment fra) {
        if (isCarlifeMusicFragment(cruFra.getType()) && ((isCarlifeMusicLocalFragment(cruFra.getType()) && isCarlifeMusicLocalFragment(fra.getType())) || ((isCarlifeMusicNeteaseFragment(cruFra.getType()) && isCarlifeMusicNeteaseFragment(fra.getType())) || (isCarlifeMusicThirdFragment(cruFra.getType()) && isCarlifeMusicThirdFragment(fra.getType()))))) {
            return true;
        }
        return false;
    }

    public boolean isMapViewFragment(int type) {
        switch (type) {
            case 17:
            case 33:
            case 52:
            case 113:
            case 114:
            case 116:
                return true;
            default:
                return false;
        }
    }

    public void showPluginFrament(Fragment fragment) {
        addPluginFragment(fragment);
    }

    public boolean isShowingPluginFragment() {
        if (this.mPluginFragments.size() <= 0 || getCurFragmentModuleType() != 4001) {
            return false;
        }
        return true;
    }

    public boolean isDriving() {
        return this.mIsDriving;
    }

    public void driving() {
        this.mIsDriving = true;
        C1328h.a().getNaviFragmentManager().getCurrentFragment().driving();
    }

    public void stopDriving() {
        this.mIsDriving = false;
        C1328h.a().getNaviFragmentManager().getCurrentFragment().stopDriving();
    }
}
