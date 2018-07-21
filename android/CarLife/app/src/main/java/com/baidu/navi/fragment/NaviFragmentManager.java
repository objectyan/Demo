package com.baidu.navi.fragment;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.OnFragmentListener;
import com.baidu.baidunavis.ui.BNCruiserFragment;
import com.baidu.baidunavis.ui.BNRouteDetailFragment;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.l;
import com.baidu.carlife.core.screen.presentation.h;
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
import com.baidu.carlife.h.a;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class NaviFragmentManager
  extends ContentFragmentManager
  implements IContentFragmentFactory
{
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
  private OnVoiceCommandListener mVoiceCmdListener = new OnVoiceCommandListener()
  {
    public boolean onVoiceCommand(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject, boolean paramAnonymousBoolean)
    {
      if (!NaviFragmentManager.this.mCurrentFragmentInfo.mFragment.onVoiceCommand(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousObject, paramAnonymousBoolean))
      {
        if (paramAnonymousInt1 == 3)
        {
          if (paramAnonymousInt2 == 2) {
            return false;
          }
          if (paramAnonymousInt2 == 1)
          {
            NaviFragmentManager.this.back(null);
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramAnonymousInt1, 1);
            return true;
          }
          return false;
        }
        return false;
      }
      return true;
    }
  };
  
  public NaviFragmentManager(OnFragmentListener paramOnFragmentListener)
  {
    super(paramOnFragmentListener);
    setFragmentFactory(this);
    BNVoiceCommandController.getInstance().setOnVoiceCommandListener(this.mVoiceCmdListener);
  }
  
  private int getIndexFromLast(int paramInt)
  {
    int i = this.mFragmentInfoStack.size() - 1;
    for (;;)
    {
      if ((i < 0) || (((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType == paramInt)) {
        return i;
      }
      i -= 1;
    }
  }
  
  public static boolean isUsingMapMode()
  {
    return false;
  }
  
  public void backTo(int paramInt, Bundle paramBundle)
  {
    int j = -1;
    int i = this.mFragmentInfoStack.size() - 1;
    while (i >= 0)
    {
      if (((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType == paramInt) {
        j = i;
      }
      i -= 1;
    }
    if (j == -1) {
      return;
    }
    i = this.mFragmentInfoStack.size() - 1;
    label62:
    if (i >= 0)
    {
      if ((((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType == paramInt) && (i == j))
      {
        back(paramBundle);
        i.b("NaviFragmentManager", "remove back " + i);
        return;
      }
      if (((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType != paramInt) {
        break label182;
      }
      this.mFragmentInfoStack.remove(i);
      i.b("NaviFragmentManager", "remove " + i);
    }
    for (;;)
    {
      i -= 1;
      break label62;
      break;
      label182:
      removeFragmentFromStack(i);
      i.b("NaviFragmentManager", "remove stack" + i);
    }
  }
  
  public void backToHomeNavi()
  {
    int i = this.mFragmentInfoStack.size() - 1;
    while (i >= 0)
    {
      if (getCurrentFragmentType() != 17) {
        back(null);
      }
      i -= 1;
    }
  }
  
  public ContentFragment createFragment(int paramInt)
  {
    boolean bool = isUsingMapMode();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
      i = paramInt;
      if (0 == 0)
      {
        i = 0;
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((ContentFragment)localObject1).setType(i);
      }
      return (ContentFragment)localObject1;
      localObject1 = new LaunchFragment();
      i = paramInt;
      continue;
      localObject1 = new HomeFragment();
      i = paramInt;
      continue;
      localObject1 = new RadioChannelFragment();
      i = paramInt;
      continue;
      localObject1 = new RadioPlayerFragment();
      i = paramInt;
      continue;
      localObject1 = new WechatFragment();
      i = paramInt;
      continue;
      localObject1 = new WechatLoginFragment();
      i = paramInt;
      continue;
      localObject1 = new SessionFragment();
      i = paramInt;
      continue;
      localObject1 = new ChatFragment();
      i = paramInt;
      continue;
      localObject1 = new ContactFragment();
      i = paramInt;
      continue;
      localObject1 = new WechatSettingFragment();
      i = paramInt;
      continue;
      localObject1 = new BlacklistFragment();
      i = paramInt;
      continue;
      localObject1 = new WechatLogoutFragment();
      i = paramInt;
      continue;
      localObject1 = new MusicPlayerFragment();
      i = paramInt;
      continue;
      localObject1 = new MusicAlbumListFragment();
      i = paramInt;
      continue;
      localObject1 = new SettingFragment();
      i = paramInt;
      continue;
      localObject1 = new FeedbackFragment();
      i = paramInt;
      continue;
      localObject1 = new SettingVoiceFragment();
      i = paramInt;
      continue;
      localObject1 = new SettingAboutFragment();
      i = paramInt;
      continue;
      localObject1 = new SettingServiceFragment();
      i = paramInt;
      continue;
      localObject1 = new PhoneFragment();
      i = paramInt;
      continue;
      if (bool)
      {
        localObject1 = new BrowseMapFragment();
        i = paramInt;
      }
      else
      {
        localObject1 = new CarModeMapFragment();
        i = paramInt;
        continue;
        localObject1 = new PickPointOnMapFragment();
        i = paramInt;
        continue;
        if (bool)
        {
          localObject1 = new PoiDetailFragment();
          i = paramInt;
        }
        else
        {
          localObject1 = new CarModePoiDetailFragment();
          i = paramInt;
          continue;
          localObject1 = new NameSearchFragment();
          i = paramInt;
          continue;
          if (bool)
          {
            localObject1 = new SearchResultFragment();
            i = paramInt;
          }
          else
          {
            localObject1 = new CarModeSearchResultFragment();
            i = paramInt;
            continue;
            localObject1 = new CarModeQuickRoutePlanFragment();
            i = paramInt;
            continue;
            localObject1 = new BNRouteDetailFragment();
            i = paramInt;
            continue;
            localObject1 = new CarModeOfflineDataFragment();
            i = paramInt;
            continue;
            localObject1 = new BNRouteGuideFragment();
            i = paramInt;
            continue;
            localObject1 = new BNCruiserFragment();
            i = paramInt;
            continue;
            localObject1 = new CarModeOfflineMapDataFragment();
            i = paramInt;
            continue;
            localObject1 = new CarModeOfflineMapManagerFragment();
            i = paramInt;
            continue;
            localObject1 = new WebViewFragment();
            i = paramInt;
            continue;
            localObject1 = new CarModeFavoriteDestFragment();
            i = paramInt;
            continue;
            localObject1 = new CarModeFavoriteFragment();
            i = paramInt;
            continue;
            localObject1 = new NewUserGuideFragment();
            i = paramInt;
            continue;
            localObject1 = new SettingNaviFragment();
            i = paramInt;
            continue;
            localObject1 = new SettingTTSFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeMySkinFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeDiscoverFragment();
            i = paramInt;
            continue;
            localObject1 = new ConnectHelpFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeMyDetailFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeMoreFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeDiscoverParkListFragment();
            i = paramInt;
            continue;
            localObject1 = new LoginFragment();
            i = paramInt;
            continue;
            localObject1 = new RoadRescueFragment();
            i = paramInt;
            continue;
            localObject1 = new EditRescueInfoFragment();
            i = paramInt;
            continue;
            localObject1 = new YMServiceDetailFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeDiscoverFoodFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeDiscoverFoodDetailFragment();
            i = paramInt;
            continue;
            localObject1 = new DisclaimerFragment();
            i = paramInt;
            continue;
            localObject1 = new UsbDebugFragment();
            i = paramInt;
            continue;
            localObject1 = new AuthorizationRequestHelpFragment();
            i = paramInt;
            continue;
            localObject1 = new CruiseFollowFragment();
            i = paramInt;
            continue;
            localObject1 = new RouteRecordFragment();
            i = paramInt;
            continue;
            localObject1 = new MyDvrFragment();
            i = paramInt;
            continue;
            localObject1 = new PrivacyPolicyFragment();
            i = paramInt;
            continue;
            localObject1 = new HomeHelpFragment();
            i = paramInt;
            continue;
            localObject1 = new MapSettingFragment();
            i = paramInt;
            continue;
            localObject1 = new CarPlateFragment();
            i = paramInt;
            continue;
            localObject1 = new VoiceSettingFragment();
            i = paramInt;
          }
        }
      }
    }
  }
  
  public void driving()
  {
    this.mIsDriving = true;
    h.a().getNaviFragmentManager().getCurrentFragment().driving();
  }
  
  public String getCurFragmentModule()
  {
    int i = this.mCurrentFragmentInfo.mType;
    if (!isCarlifeFragment(i)) {
      return "MAP";
    }
    if (isCarlifeMusicFragment(i)) {
      return "MUSIC";
    }
    if (isCarlifeTelephoneFragment(i)) {
      return "PHONE";
    }
    return "HOME";
  }
  
  public int getCurFragmentModuleType()
  {
    int i = this.mCurrentFragmentInfo.mType;
    if (!isCarlifeFragment(i)) {
      return 4003;
    }
    if (isCarlifeMusicFragment(i)) {
      return 4004;
    }
    if (isCarlifeTelephoneFragment(i)) {
      return 4002;
    }
    return 4001;
  }
  
  public int getCurrentFragmentType()
  {
    if ((this.mCurrentFragmentInfo != null) && (this.mCurrentFragmentInfo.mFragment != null)) {
      return this.mCurrentFragmentInfo.mFragment.getType();
    }
    return 0;
  }
  
  public ContentFragment getLatestFragment(int paramInt)
  {
    int i = this.mFragmentInfoStack.size() - 1;
    while (i >= 0)
    {
      if (((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType == paramInt) {
        return ((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mFragment;
      }
      i -= 1;
    }
    return null;
  }
  
  public BaseFragment getLatestMusicFragment()
  {
    Object localObject2 = null;
    int i = this.mFragmentInfoStack.size() - 1;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        if (isCarlifeMusicFragment(((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          localObject1 = ((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mFragment;
        }
      }
      else {
        return (BaseFragment)localObject1;
      }
      i -= 1;
    }
  }
  
  public Fragment getLatestNaviFragment()
  {
    int i = this.mFragmentInfoStack.size() - 1;
    while (i >= 0)
    {
      if (!isCarlifeFragment(((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
        return ((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mFragment;
      }
      i -= 1;
    }
    return null;
  }
  
  public int getPreviousFragmentType()
  {
    return this.mPreviousFragmentType;
  }
  
  public boolean isCarLifeMusicSDKFragment(ContentFragment paramContentFragment1, ContentFragment paramContentFragment2)
  {
    return (isCarlifeMusicFragment(paramContentFragment1.getType())) && (((isCarlifeMusicLocalFragment(paramContentFragment1.getType())) && (isCarlifeMusicLocalFragment(paramContentFragment2.getType()))) || ((isCarlifeMusicNeteaseFragment(paramContentFragment1.getType())) && (isCarlifeMusicNeteaseFragment(paramContentFragment2.getType()))) || ((isCarlifeMusicThirdFragment(paramContentFragment1.getType())) && (isCarlifeMusicThirdFragment(paramContentFragment2.getType()))));
  }
  
  public boolean isCarlifeFragment(int paramInt)
  {
    return (paramInt > 512) && (paramInt < 768);
  }
  
  public boolean isCarlifeHomeFragment(int paramInt)
  {
    return (paramInt > 528) && (paramInt < 735);
  }
  
  public boolean isCarlifeLaunchFragment(int paramInt)
  {
    return (paramInt == 514) || (paramInt == 516) || (paramInt == 515) || (paramInt == 513) || (paramInt == 517);
  }
  
  public boolean isCarlifeMusicFragment(int paramInt)
  {
    return (paramInt > 736) && (paramInt < 767);
  }
  
  public boolean isCarlifeMusicLocalFragment(int paramInt)
  {
    return paramInt == 737;
  }
  
  public boolean isCarlifeMusicNeteaseFragment(int paramInt)
  {
    return (paramInt == 737) || (paramInt == 745);
  }
  
  public boolean isCarlifeMusicThirdFragment(int paramInt)
  {
    return (paramInt == 737) || (paramInt == 745);
  }
  
  public boolean isCarlifeRadioMusicFragment(int paramInt)
  {
    return (paramInt > 593) && (paramInt < 596);
  }
  
  public boolean isCarlifeTelephoneFragment(int paramInt)
  {
    return (paramInt > 518) && (paramInt < 527);
  }
  
  public boolean isDriving()
  {
    return this.mIsDriving;
  }
  
  public boolean isMapViewFragment(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isNaviStart()
  {
    boolean bool2 = false;
    Iterator localIterator = this.mFragmentInfoStack.iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (isCarlifeFragment(((ContentFragmentManager.FragmentInfo)localIterator.next()).mType));
    boolean bool1 = true;
    return bool1;
  }
  
  public boolean isNeedHideTabFragment(int paramInt)
  {
    return (paramInt == 516) || (paramInt == 514) || (paramInt == 548) || (paramInt == 515) || (paramInt == 513) || (paramInt == 566) || (paramInt == 562) || (paramInt == 561) || (paramInt == 563) || (paramInt == 553) || (paramInt == 560) || (paramInt == 546) || (paramInt == 551) || (paramInt == 550) || (paramInt == 552) || (paramInt == 564) || (paramInt == 555) || (paramInt == 556) || (paramInt == 554) || (paramInt == 532) || (paramInt == 557);
  }
  
  public boolean isRadioFragment(int paramInt)
  {
    return (paramInt > 593) && (paramInt < 596);
  }
  
  public boolean isShowingPluginFragment()
  {
    return (this.mPluginFragments.size() > 0) && (getCurFragmentModuleType() == 4001);
  }
  
  public boolean isWeChatFragment(int paramInt)
  {
    return (paramInt > 583) && (paramInt < 592);
  }
  
  public void push(ContentFragment paramContentFragment)
  {
    push(new ContentFragmentManager.FragmentInfo(this, paramContentFragment, paramContentFragment.getType()));
  }
  
  public void removeFragmentTo(int paramInt)
  {
    int i = getIndexFromLast(paramInt);
    if (i >= 0)
    {
      paramInt = this.mFragmentInfoStack.size() - 1;
      while (paramInt > i)
      {
        removeFragmentFromStack(paramInt);
        paramInt -= 1;
      }
    }
  }
  
  public void showFirstHomeFragment()
  {
    Object localObject2 = null;
    int i = this.mFragmentInfoStack.size() - 1;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        if (((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType == 531) {
          localObject1 = (ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ContentFragmentManager.FragmentInfo(this, new HomeFragment(), 531);
          push((ContentFragmentManager.FragmentInfo)localObject2);
        }
        showFragment(((ContentFragmentManager.FragmentInfo)localObject2).mType, null);
        if (this.mUiListener != null)
        {
          this.mUiListener.updateGaussianBlurBackground();
          this.mUiListener.updateMainDisplayStatus(4001);
        }
        return;
      }
      i -= 1;
    }
  }
  
  public void showFragment(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 116) {
      EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    }
    if ((BaseFragment.mActivity == null) || ((Build.VERSION.SDK_INT > 16) && (BaseFragment.mActivity.isDestroyed()))) {}
    for (;;)
    {
      return;
      if (isCarlifeFragment(paramInt))
      {
        super.showCarlifeFragment(paramInt, paramBundle);
        label50:
        if (this.mUiListener != null)
        {
          if (!isNeedHideTabFragment(paramInt)) {
            break label137;
          }
          this.mUiListener.setBottomBarStatus(false);
        }
      }
      int i;
      for (;;)
      {
        this.mUiListener.updateGaussianBlurBackground();
        if (paramInt != 20) {
          break label150;
        }
        i = getIndexFromLast(paramInt);
        if (i < 0) {
          break;
        }
        paramInt = this.mFragmentInfoStack.size() - 1;
        while (paramInt >= i)
        {
          removeFragmentFromStack(paramInt);
          paramInt -= 1;
        }
        break;
        super.showFragment(paramInt, paramBundle);
        break label50;
        label137:
        this.mUiListener.setBottomBarStatus(true);
      }
      label150:
      if (paramInt == 113)
      {
        i = getIndexFromLast(17);
        paramInt = getIndexFromLast(113);
        if ((i >= 0) && (paramInt >= 0) && (paramInt > i)) {
          while (paramInt > i)
          {
            removeFragmentFromStack(paramInt);
            paramInt -= 1;
          }
        }
      }
    }
  }
  
  public void showLatestHomeFragment()
  {
    Object localObject2 = null;
    int i = this.mFragmentInfoStack.size() - 1;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        if (isCarlifeHomeFragment(((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          localObject1 = (ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ContentFragmentManager.FragmentInfo(this, new HomeFragment(), 531);
          push((ContentFragmentManager.FragmentInfo)localObject2);
        }
        showFragment(((ContentFragmentManager.FragmentInfo)localObject2).mType, null);
        k.b(4022);
        if (this.mUiListener != null)
        {
          this.mUiListener.updateGaussianBlurBackground();
          this.mUiListener.updateMainDisplayStatus(4001);
        }
        return;
      }
      i -= 1;
    }
  }
  
  public void showLatestMusicFragment()
  {
    Object localObject2 = null;
    int i = this.mFragmentInfoStack.size() - 1;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        if (isCarlifeMusicFragment(((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          localObject1 = (ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ContentFragmentManager.FragmentInfo(this, new MusicPlayerFragment(), 737);
          push((ContentFragmentManager.FragmentInfo)localObject2);
        }
        k.b(4022);
        if (this.mUiListener != null)
        {
          this.mUiListener.updateGaussianBlurBackground();
          this.mUiListener.updateMainDisplayStatus(4004);
        }
        showFragment(((ContentFragmentManager.FragmentInfo)localObject2).mType, null);
        return;
      }
      i -= 1;
    }
  }
  
  public void showLatestNaviFragment()
  {
    backToNavi(null);
  }
  
  public void showLatestPhoneFragment()
  {
    Object localObject2 = null;
    int i = this.mFragmentInfoStack.size() - 1;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        if (isCarlifeTelephoneFragment(((ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          localObject1 = (ContentFragmentManager.FragmentInfo)this.mFragmentInfoStack.get(i);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ContentFragmentManager.FragmentInfo(this, new PhoneFragment(), 519);
          push((ContentFragmentManager.FragmentInfo)localObject2);
        }
        k.b(4022);
        if (this.mUiListener != null)
        {
          this.mUiListener.updateGaussianBlurBackground();
          this.mUiListener.updateMainDisplayStatus(4002);
        }
        showFragment(((ContentFragmentManager.FragmentInfo)localObject2).mType, null);
        return;
      }
      i -= 1;
    }
  }
  
  public void showPluginFrament(Fragment paramFragment)
  {
    addPluginFragment(paramFragment);
  }
  
  public void stopDriving()
  {
    this.mIsDriving = false;
    h.a().getNaviFragmentManager().getCurrentFragment().stopDriving();
  }
  
  public String toString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "TYPE_NONE";
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
    case 88: 
      return "TYPE_FAVORITE_PICK";
    case 89: 
      return "TYPE_FAVORITE_EDIT";
    case 82: 
      return "TYPE_USER_CENTER";
    case 83: 
      return "TYPE_TRACK";
    case 87: 
      return "TYPE_TRACK_DETAIL";
    case 84: 
      return "TYPE_MILEAGE_RANK";
    case 86: 
      return "TYPE_NEWS_CENTER";
    case 554: 
      return "TYPE_OFFLINE_DATA";
    case 113: 
      return "TYPE_ROUTE_GUIDE";
    case 114: 
      return "TYPE_CRUISE";
    case 129: 
      return "TYPE_CAR_DRV_RECORD";
    case 130: 
      return "TYPE_CAR_DRV_PLAY";
    case 131: 
      return "TYPE_CAR_DRV_LIST";
    case 132: 
      return "TYPE_CAR_DRV_SETTING";
    case 17: 
      return "TYPE_HOME_NAVI";
    case 260: 
      return "TYPE_SETTING";
    case 261: 
      return "TYPE_ABOUT";
    case 264: 
      return "TYPE_SHOW_DETAIL";
    case 517: 
      return "TYPE_PRIVACY_POLICY";
    case 263: 
      return "TYPE_HELP";
    case 275: 
      return "TYPE_SELECT_MODE";
    case 273: 
      return "TYPE_ROUTE_FEEDBACK";
    case 289: 
      return "TYPE_ABOUT_WEBVIEW";
    case 320: 
      return "TYPE_VOICE_MAIN";
    case 321: 
      return "TYPE_VOICE_DETAIL";
    case 322: 
      return "TYPE_VOICE_SQUARE";
    case 323: 
      return "TYPE_VOICE_RECORDLIST";
    case 324: 
      return "TYPE_VOICE_RECORD";
    case 325: 
      return "TYPE_UGC_YAW_COMMENT";
    case 326: 
      return "TYPE_UGC_MANAGER";
    case 327: 
      return "TYPE_UGC_PICK_LINK";
    case 514: 
      return "TYPE_LAUNCH";
    case 531: 
      return "TYPE_HOME";
    case 745: 
      return "TYPE_MUSIC_PLAYLIST";
    case 737: 
      return "TYPE_MUSIC_PLAYER";
    case 533: 
      return "TYPE_SETTING_CONTENT";
    case 537: 
      return "TYPE_SETTING_FEEDBACK";
    case 538: 
      return "TYPE_SETTING_VOICE_CONTENT";
    case 539: 
      return "TYPE_SETTING_ABOUT_CONTENT";
    case 540: 
      return "TYPE_SETTING_SERVICE_CONTENT";
    case 529: 
      return "TYPE_USB_CONNECT";
    case 535: 
      return "TYPE_CUSTOM_CENTER";
    case 519: 
      return "TYPE_PHONE";
    case 294: 
      return "TYPE_ROUTE_CUSTOM_DETAIL";
    case 516: 
      return "TYPE_GUID";
    case 532: 
      return "TYPE_SETTING_NAVI";
    case 568: 
      return "TYPE_SETTING_TTS";
    case 549: 
      return "TYPE_HOME_MY_SKIN";
    case 542: 
      return "TYPE_HOME_DISCOVER";
    case 543: 
      return "TYPE_HOME_MY";
    case 547: 
      return "TYPE_CONNECT_HELP";
    case 544: 
      return "TYPE_HOME_MY_DETAIL";
    case 545: 
      return "TYPE_HOME_MORE";
    case 546: 
      return "TYPE_HOME_DISCOVER_PARK";
    case 293: 
    case 550: 
    case 551: 
      return "TYPE_HOME_DISCOVER_EDIT_RESCUE_INFO";
    case 552: 
      return "TYPE_MAP_YMSERVICEDETAIL";
    case 515: 
      return "TYPE_DISCLAIMER";
    case 513: 
      return "TYPE_USB_DEBUG";
    case 565: 
      return "TYPE_HOME_HELP_PANEL";
    case 580: 
      return "TYPE_MAP_SETTING";
    case 557: 
      return "TYPE_SETTING_CAR_PLATE";
    case 581: 
      return "TYPE_VOICE_SETTING";
    }
    return "TYPE_COMMON_QUESTION";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/NaviFragmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */