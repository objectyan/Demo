package com.baidu.carlife.core.screen.presentation.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.R;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.OnDialogCancelListener;
import com.baidu.carlife.core.screen.CarLifeSearchPoi;
import com.baidu.carlife.core.screen.OnLightnessCoverListener;
import com.baidu.carlife.core.screen.operation.SpecifyKnobKeyListener;
import com.baidu.carlife.core.screen.lightness.LightnessControlManager;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.p087l.CarlifeCoreSDK;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: CarlifeViewWrapper */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.h */
public class CarlifeViewWrapper extends CarlifeView implements OnClickListener {
    /* renamed from: c */
    public static String Tag = "CarlifeActivity#CarlifeViewWrapper";
    /* renamed from: d */
    private CarlifePresenter mCarlifePresenter = new CarlifePresenter(this);
    /* renamed from: e */
    private FrameLayout mFrameLayout = null;
    /* renamed from: f */
    private LinearLayout mLinearLayout = null;
    /* renamed from: g */
    private ImageButton mImageHomeButton = null;
    /* renamed from: h */
    private ImageButton mImageMusicButton = null;
    /* renamed from: i */
    private ImageButton mImagePhoneButton = null;
    /* renamed from: j */
    private ImageButton mImageNaviButton = null;
    /* renamed from: k */
//    private LightVoiceMicView f3787k = null;
    /* renamed from: l */
    private View f3788l = null;
    /* renamed from: m */
    private View f3789m = null;
    /* renamed from: n */
    private View f3790n;
    /* renamed from: o */
    private RelativeLayout f3791o;
    /* renamed from: p */
    private TextView f3792p;
    /* renamed from: q */
    private RelativeLayout f3793q;
    /* renamed from: r */
    private RelativeLayout f3794r;
    /* renamed from: s */
    private TextView f3795s;
    /* renamed from: t */
    private View f3796t;
    /* renamed from: u */
//    private C1443g f3797u;
//    /* renamed from: v */
//    private C2278e f3798v;
    /* renamed from: w */
    private List<BaseDialog> mArrayList = new ArrayList();

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$1 */
    class IVHomeViewFocusListener implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper mCarlifeViewWrapper;

        IVHomeViewFocusListener(CarlifeViewWrapper this$0) {
            this.mCarlifeViewWrapper = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
//                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$2 */
    class IVMusicViewFocusListener implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper f3772a;

        IVMusicViewFocusListener(CarlifeViewWrapper this$0) {
            this.f3772a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
//                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$3 */
    class IVPhoneViewFocusListener implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper f3773a;

        IVPhoneViewFocusListener(CarlifeViewWrapper this$0) {
            this.f3773a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
//                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$4 */
    class IVNaviViewFocusListener implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper f3774a;

        IVNaviViewFocusListener(CarlifeViewWrapper this$0) {
            this.f3774a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
//                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$5 */
    class IVVoiceViewFocusListener implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper f3775a;

        IVVoiceViewFocusListener(CarlifeViewWrapper this$0) {
            this.f3775a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
//                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$6 */
    class ContentFrameTouchListener implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper f3776a;

        ContentFrameTouchListener(CarlifeViewWrapper this$0) {
            this.f3776a = this$0;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$7 */
    class DialogHolderClickListener implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeViewWrapper f3777a;

        DialogHolderClickListener(CarlifeViewWrapper this$0) {
            this.f3777a = this$0;
        }

        public void onClick(View v) {
            BaseDialog dialog = this.f3777a.m4709r();
            if (dialog == null || dialog.m4475e()) {
                this.f3777a.cancelDialog();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$8 */
//    class C13178 implements C0924a {
//        /* renamed from: a */
//        final /* synthetic */ CarlifeViewWrapper f3778a;
//
//        C13178(CarlifeViewWrapper this$0) {
//            this.f3778a = this$0;
//        }
//
//        public void onNetWorkResponse(int responseCode) {
//            if (CommonParams.jr) {
//                this.f3778a.mImageNaviButton.setVisibility(0);
//            } else {
//                this.f3778a.mImageNaviButton.setVisibility(8);
//            }
//        }
//    }

    public CarlifeViewWrapper(Context context) {
        //activtyMain
        super(context, R.layout.support_simple_spinner_dropdown_item);
        CarlifeViewContainer.newInstance().setCarlifeView(this);
        CarlifeProgressDialogContainer.newInstance().initOnProgressDialogListener(this);
        initView();
        m4710s();
    }

    /* renamed from: p */
    private void initView() {
//        this.mImageHomeButton = (ImageButton) this.a.findViewById(R.id.iv_home);
//        this.mImageHomeButton.setOnFocusChangeListener(new IVHomeViewFocusListener(this));
//        this.mImageMusicButton = (ImageButton) this.a.findViewById(R.id.iv_music);
//        this.mImageMusicButton.setOnFocusChangeListener(new IVMusicViewFocusListener(this));
//        this.mImagePhoneButton = (ImageButton) this.a.findViewById(R.id.iv_phone_book);
//        this.mImagePhoneButton.setOnFocusChangeListener(new IVPhoneViewFocusListener(this));
//        this.mImageNaviButton = (ImageButton) this.a.findViewById(R.id.iv_navi);
//        this.mImageNaviButton.setOnFocusChangeListener(new IVNaviViewFocusListener(this));
//        this.f3789m = this.a.findViewById(R.id.iv_voice_focus_bg);
//        this.f3788l = this.a.findViewById(R.id.iv_voice_bg);
//        this.f3787k = (LightVoiceMicView) this.a.findViewById(R.id.iv_voice);
//        this.f3789m.setOnFocusChangeListener(new IVVoiceViewFocusListener(this));
//        this.mLinearLayout = (LinearLayout) this.a.findViewById(R.id.ll_bottom_control);
//        this.f3790n = this.a.findViewById(R.id.main_anim_view);
//        this.f3792p = (TextView) this.a.findViewById(R.id.activity_main_toast_text);
//        this.f3792p.setVisibility(0);
//        this.f3792p.setAlpha(0.0f);
//        C2201w.m8369a().m8377a(this.f3792p);
//        this.f3796t = ((ViewStub) this.a.findViewById(R.id.stub_progress)).inflate();
//        this.f3796t.setBackgroundResource(R.drawable.shape_for_toast_text);
//        this.f3796t.setVisibility(8);
//        this.mImageHomeButton.setOnClickListener(this);
//        this.mImageMusicButton.setOnClickListener(this);
//        this.mImagePhoneButton.setOnClickListener(this);
//        this.mImageNaviButton.setOnClickListener(this);
//        this.f3787k.setOnClickListener(this);
//        this.f3789m.setOnClickListener(this);
//        this.mFrameLayout = (FrameLayout) this.a.findViewById(R.id.content_frame);
//        if (this.mFrameLayout != null) {
//            this.mFrameLayout.setOnTouchListener(new ContentFrameTouchListener(this));
//        }
//        this.f3791o = (RelativeLayout) this.a.findViewById(R.id.dialog_holder);
//        this.f3791o.setOnClickListener(new DialogHolderClickListener(this));
//        this.f3793q = (RelativeLayout) this.a.findViewById(R.id.wmv_holder);
//        this.f3795s = (TextView) this.a.findViewById(R.id.guide_hint_txt);
    }

    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.iv_home:
//                performOpenHome();
//                return;
//            case R.id.iv_phone_book:
//                this.mCarlifePresenter.m4674b();
//                StatisticManager.onEvent(StatisticConstants.HOME_MENU_0001);
//                return;
//            case R.id.iv_voice_focus_bg:
//            case R.id.iv_voice:
//                LogUtil.d(Tag, "click voic recognition btn");
//                m4735k();
//                return;
//            case R.id.iv_navi:
//                this.mCarlifePresenter.m4679d();
//                StatisticManager.onEvent(StatisticConstants.HOME_MENU_0002);
//                return;
//            case R.id.iv_music:
//                this.mCarlifePresenter.m4678c();
//                StatisticManager.onEvent(StatisticConstants.HOME_MENU_0003);
//                return;
//            default:
//                return;
        }
    }

    /* renamed from: k */
    public void m4735k() {
//        if (m4708q()) {
//            LogUtil.d(Tag, "onVoiceClick: Idle");
//            C1912n.m7270a().m7307f();
//            C1912n.m7270a().m7300b(false);
//            return;
//        }
//        C1912n.m7270a().m7306e();
//        if (C1912n.m7270a().m7303c()) {
//            LogUtil.d(Tag, "onVoiceClick: Listening");
//            C1912n.m7270a().m7312k();
//        } else if (C1912n.m7270a().m7301b()) {
//            LogUtil.d(Tag, "onVoiceClick: Processing");
//            C1903m.m7252a().m7255b();
//        } else if (C1912n.m7270a().m7314m()) {
//            LogUtil.d(Tag, "onVoiceClick: Speeching");
//            C1903m.m7252a().m7255b();
//        } else {
//            LogUtil.d(Tag, "onVoiceClick: stopVoice");
//            C1903m.m7252a().m7255b();
//        }
    }

    /* renamed from: q */
//    private boolean m4708q() {
//        return !C1912n.m7270a().m7314m() && C1912n.m7270a().m7305d();
//    }

    /* renamed from: a */
    public void m4716a(int resId) {
//        if (this.a != null) {
//            this.a.setBackgroundResource(resId);
//        }
    }

    /* renamed from: a */
    public void m4718a(Drawable drawable) {
//        if (this.a != null) {
//            this.a.setBackground(drawable);
//        }
    }

    public void setBottomBarBackgroud(Drawable drawable) {
        if (this.mLinearLayout != null) {
            this.mLinearLayout.setBackground(drawable);
        }
    }

    /* renamed from: l */
    public void updateMainDisplayStatus() {
        updateMainDisplayStatus(this.mCarlifePresenter.m4684i());
    }

    public void updateGaussianBlurBackground() {
//        if (!FragmentManagerCallbackProxy.m4757a().m4764b()) {
//            m4716a((int) R.drawable.com_bg);
//        }
    }

    public void updateMainDisplayStatus(int bottomStatus) {
        switch (bottomStatus) {
            case 4001:
            case 4003:
                selectButtom(bottomStatus);
                return;
            case 4002:
                selectButtom(bottomStatus);
                return;
            case 4004:
                selectButtom(bottomStatus);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void selectButtom(int bottomStatus) {
        this.mImageHomeButton.setNextFocusUpId(-1);
        switch (bottomStatus) {
            case 4001:
                this.mImageHomeButton.setSelected(true);
                this.mImagePhoneButton.setSelected(false);
                this.mImageNaviButton.setSelected(false);
                this.mImageMusicButton.setSelected(false);
                return;
            case 4002:
                this.mImageHomeButton.setSelected(false);
                this.mImagePhoneButton.setSelected(true);
                this.mImageNaviButton.setSelected(false);
                this.mImageMusicButton.setSelected(false);
                return;
            case 4003:
                this.mImageHomeButton.setSelected(false);
                this.mImagePhoneButton.setSelected(false);
                this.mImageNaviButton.setSelected(true);
                this.mImageMusicButton.setSelected(false);
                return;
            case 4004:
                this.mImageHomeButton.setSelected(false);
                this.mImagePhoneButton.setSelected(false);
                this.mImageNaviButton.setSelected(false);
                this.mImageMusicButton.setSelected(true);
                return;
            default:
                return;
        }
    }

    public void setBottomBarStatus(boolean show) {
        if (show) {
//            if (this.mLinearLayout != null && this.mLinearLayout.getVisibility() == 8) {
//                this.mLinearLayout.setVisibility(0);
//            }
//            if (this.f3788l != null) {
//                this.f3788l.setVisibility(0);
//            }
//            if (this.f3787k != null) {
//                this.f3787k.setVisibility(0);
//                return;
//            }
            return;
        }
//        if (this.mLinearLayout != null && this.mLinearLayout.getVisibility() == 0) {
//            this.mLinearLayout.setVisibility(8);
//        }
//        if (this.f3788l != null) {
//            this.f3788l.setVisibility(8);
//        }
//        if (this.f3787k != null) {
//            this.f3787k.setVisibility(8);
//        }
    }

    /* renamed from: e */
    public Context mo1482e() {
        return null;//this.b;
    }

    /* renamed from: a */
    public void showFragment(int type, Bundle bundle) {
        this.mCarlifePresenter.showFragment(type, bundle);
    }

    public void showDialog(BaseDialog chldView) {
        showDialog(chldView, C1265a.Center);
    }

    public void showDialog(BaseDialog childView, C1265a gravity) {
        if (childView != null) {
            LogUtil.d("CarlifeViewWrapper", "showDialog=" + isDialogShown());
            if (this.mArrayList.contains(childView)) {
                LogUtil.m4443d(Tag, "showDialog childView is already exists.");
                return;
            }
            this.mArrayList.add(childView);
            LogUtil.d("Dialog", "Carlife's showDialog childView=" + childView + ", size=" + this.mArrayList.size());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            if (gravity == C1265a.Center) {
                layoutParams.addRule(13);
            } else if (gravity == C1265a.Bottom) {
                layoutParams.addRule(12);
                layoutParams.addRule(15);
            } else if (gravity == C1265a.left) {
                layoutParams.addRule(9);
                layoutParams.addRule(15);
            } else {
                layoutParams.addRule(11);
                layoutParams.addRule(15);
            }
            this.f3791o.addView(childView, layoutParams);
//            this.f3791o.setVisibility(0);
            childView.mo1525a(this);
        }
    }

    public void dismissDialog() {
        BaseDialog dialog = m4709r();
        if (dialog != null) {
            dismissDialog(dialog);
        }
    }

    public void dismissDialog(BaseDialog childView) {
        m4704a(childView, true);
    }

    public void cancelDialog() {
        BaseDialog dialog = m4709r();
        if (dialog != null) {
            cancelDialog(dialog);
        }
    }

    public void cancelDialog(BaseDialog childView) {
        m4704a(childView, false);
    }

    /* renamed from: a */
    private void m4704a(BaseDialog childView, boolean dismissOrCancel) {
        if (childView != null && isDialogShown()) {
            LogUtil.d("Dialog", "dismissDialog childView=" + childView);
            boolean result = this.mArrayList.remove(childView);
            this.f3791o.removeView(childView);
            if (this.mArrayList.isEmpty()) {
//                this.f3791o.setVisibility(8);
            }
            LogUtil.d("Dialog", "CarlifeView's dismissDialog mHistories.isEmpty=" + this.mArrayList.isEmpty() + ",remove Result=" + result);
            if (result && !childView.m4478h()) {
                LogUtil.d(Tag, "onCancel child");
                if (dismissOrCancel) {
                    childView.mo1526d();
                } else {
                    childView.mo1629c();
                }
            }
        }
    }

    public boolean isDialogShown() {
        return this.f3791o.isShown() || !this.mArrayList.isEmpty();
    }

    /* renamed from: r */
    private BaseDialog m4709r() {
        int count = this.mArrayList.size();
        if (count > 0) {
            return (BaseDialog) this.mArrayList.get(count - 1);
        }
        return null;
    }

    public boolean showConnectForbidDialog() {
        if (!CarlifeCoreSDK.newInstance().getISConn()) {
            return false;
        }
//        C1953c connectForbidDialog = new C1953c(this.b).m7455f(1);
//        connectForbidDialog.m7458q();
//        connectForbidDialog.m7435a((int) R.string.home_my_dialog_alert);
//        connectForbidDialog.m7447c((int) R.string.alert_confirm);
//        showDialog(connectForbidDialog, C1265a.Center);
        return true;
    }

    /* renamed from: s */
    private void m4710s() {
//        m4711t();
        keyListener();
//        C2342g.m8864e().m8888a(this);
//        C2342g.m8864e().m8887a(this.f3796t);
//        TipTool.setToastinInterface(new C2199v());
//        C1872t.m7136a().m7151a((C1318b) this);
        LightnessControlManager.newInstance().initOnLightnessCoverListener((OnLightnessCoverListener) this);
    }

    /* renamed from: t */
    private void m4711t() {
//        C1651l openNaviRequest = new C1651l();
//        openNaviRequest.toGetRequest();
//        openNaviRequest.registerResponseListener(new C13178(this));
    }

    /* renamed from: u */
    private void keyListener() {
        this.mImageHomeButton.setOnKeyListener(new SpecifyKnobKeyListener(this.mImagePhoneButton, null));
        this.mImagePhoneButton.setOnKeyListener(new SpecifyKnobKeyListener(this.f3789m, this.mImageHomeButton));
        this.f3789m.setOnKeyListener(new SpecifyKnobKeyListener(this.mImageNaviButton, this.mImagePhoneButton));
        this.mImageNaviButton.setOnKeyListener(new SpecifyKnobKeyListener(this.mImageMusicButton, this.f3789m));
        this.mImageMusicButton.setOnKeyListener(new SpecifyKnobKeyListener(null, this.mImageNaviButton));
    }

    /* renamed from: a */
    public void m4719a(Window window) {
//        C1440d focusManager = C1440d.m5251a();
//        focusManager.m5254a(this.a);
//        if (this.f3797u == null) {
//            this.f3797u = new C1443g(this.a, 1);
//            this.f3797u.m5300d(this.mImageHomeButton).m5300d(this.mImagePhoneButton).m5300d(this.f3789m).m5300d(this.mImageNaviButton).m5300d(this.mImageMusicButton);
//        }
//        focusManager.m5252a(this.f3797u);
    }

    /* renamed from: b */
    public void mo1481b(boolean isSuccess) {
        if (!isSuccess) {
        }
    }

    /* renamed from: j */
    public boolean mo1489j() {
        if (this.mImageHomeButton == null || this.mImagePhoneButton == null || this.mImageNaviButton == null || this.mImageMusicButton == null || this.f3789m == null) {
            return false;
        }
        if (this.mImageHomeButton.hasFocus() || this.mImagePhoneButton.hasFocus() || this.mImageNaviButton.hasFocus() || this.mImageMusicButton.hasFocus() || this.f3789m.hasFocus()) {
            return true;
        }
        return false;
    }

    public void innerNameSearch(String key) {
        this.mCarlifePresenter.m4672a(key);
    }

    public void openNaviFromOutSide(int type, Bundle bundle) {
        this.mCarlifePresenter.m4675b(type, bundle);
    }

    public void openNavi() {
        this.mCarlifePresenter.initNavi1();
    }

    public void openNavi(Bundle bundle) {
        this.mCarlifePresenter.initNavi(bundle);
    }

    public void startCalcRoute(CarLifeSearchPoi poi) {
        this.mCarlifePresenter.m4676b(poi);
    }

    /* renamed from: f */
    public void mo1483f() {
        if (this.f3790n != null) {
//            AnimationDrawable drawable = (AnimationDrawable) this.b.getResources().getDrawable(R.drawable.anim_view_drawable_list);
//            this.f3790n.setBackground(drawable);
//            drawable.start();
        }
    }

    /* renamed from: h */
    public void mo1484h() {
        this.mCarlifePresenter.showFragment();
    }

    public void showWindowView(View view, LayoutParams layoutParams) {
        LogUtil.d("CarlifeActivity", "showWindowView");
        this.f3793q.removeAllViews();
        this.f3793q.addView(view, layoutParams);
//        this.f3793q.setVisibility(0);
    }

    public void hideWindowView() {
//        this.f3793q.setVisibility(8);
        this.f3793q.removeAllViews();
    }

    public boolean isWindowViewShown() {
        return this.f3793q.isShown();
    }

    /* renamed from: b */
    public void mo1480b() {
        if (!CarLifeSettings.m4069a().m4088h()) {
            return;
        }
        if (this.f3794r != null) {
//            this.f3794r.setVisibility(0);
            return;
        }
//        this.f3794r = new RelativeLayout(this.b);
//        this.f3794r.setBackgroundColor(-16777216);
//        ImageView imageView = new ImageView(this.b);
//        imageView.setImageResource(R.drawable.com_ic_carlife_black);
//        LayoutParams rParams = new LayoutParams(-2, -2);
//        rParams.addRule(13);
//        this.f3794r.addView(imageView, rParams);
//        ImageView tipIV = new ImageView(this.b);
//        tipIV.setImageResource(R.drawable.com_ic_gesture_slide_guide);
//        LayoutParams params = new LayoutParams(-2, -2);
//        params.setMargins(0, 0, 0, CarlifeScreenUtil.m4331a().m4343c(20));
//        params.addRule(12);
//        params.addRule(14);
//        this.f3794r.addView(tipIV, params);
//        if (this.f3794r != null && this.f3794r.getParent() == null) {
//            m4713v();
//        }
    }

    /* renamed from: a */
    public void mo1479a(boolean isDestroy) {
//        if (!CarlifeConfig.m4065a() && this.f3794r != null && this.f3794r.getParent() != null) {
//            ((WindowManager) this.b.getSystemService("window")).removeView(this.f3794r);
//            this.f3794r = null;
//        }
    }

    /* renamed from: v */
    private void m4713v() {
//        if (!CarlifeConfig.m4065a()) {
//            WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
//            WindowManager.LayoutParams wParams = new WindowManager.LayoutParams();
//            if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) {
//                wParams.type = 2005;
//            } else {
//                wParams.type = 2006;
//            }
//            wParams.format = -2;
//            wParams.gravity = 112;
//            wParams.systemUiVisibility = 5;
//            wParams.verticalMargin = 0.0f;
//            wParams.width = -1;
//            wParams.height = -1;
//            wParams.flags = 24;
//            windowManager.addView(this.f3794r, wParams);
//        }
    }

    /* renamed from: m */
    public boolean m4737m() {
//        if (this.f3794r == null || this.f3794r.getParent() == null || this.f3794r.getVisibility() != 0) {
//            return false;
//        }
        return true;
    }

    /* renamed from: n */
    public void m4738n() {
        if (LightnessControlManager.newInstance().m4499g()) {
            LightnessControlManager.newInstance().brightTouchEvent();
            if (CarLifeSettings.m4069a().m4090i()) {
                mo1480b();
                return;
            } else if (CarLifeSettings.m4069a().m4088h()) {
                LightnessControlManager.newInstance().sendEmptyMessageDelayed();
                return;
            } else {
                return;
            }
        }
        LightnessControlManager.newInstance().changeScreenBrightness(LightnessControlManager.newInstance().m4500h());
    }

    /* renamed from: o */
    public void m4739o() {
//        if (this.f3794r != null) {
//            if (this.f3794r.getVisibility() == 0) {
//                CarLifeSettings.m4069a().m4083f(true);
//            } else {
//                CarLifeSettings.m4069a().m4083f(false);
//            }
//            this.f3794r.setVisibility(8);
        LightnessControlManager.newInstance().removeMessages();
//        }
    }

    /* renamed from: a */
    public void m4724a(boolean noFocus, boolean resume) {
        if (noFocus) {
            mo1479a(false);
            if (resume) {
                LightnessControlManager.newInstance().sendEmptyMessageDelayed();
            }
        }
    }

    /* renamed from: c */
    public void mo1468c() {
//        dismissDialog(this.f3798v);
    }

    /* renamed from: b */
    public void mo1467b(String msg) {
        mo1465a(msg, null);
    }

    /* renamed from: a */
    public void mo1465a(String msg, OnBtnClickListener cancelListener) {
        mo1466a(msg, cancelListener, null);
    }

    /* renamed from: a */
    public void mo1466a(String msg, OnBtnClickListener cancelListener, OnDialogCancelListener listener) {
//        if (this.f3798v != null && isDialogShown()) {
//            dismissDialog(this.f3798v);
//            this.f3798v = null;
//        }
//        this.f3798v = m4714w();
//        this.f3798v.setOnDialogCancelListener(null);
//        this.f3798v.setOnCancelListener(null);
//        if (!TextUtils.isEmpty(msg)) {
//            this.f3798v.m8622b(msg);
//        }
//        if (cancelListener != null) {
//            this.f3798v.setOnCancelListener(cancelListener);
//        }
//        if (listener != null) {
//            this.f3798v.setOnDialogCancelListener(listener);
//        }
//        showDialog(this.f3798v);
    }

    /* renamed from: d */
    public boolean mo1469d() {
//        if (this.f3798v == null || !isDialogShown()) {
//            return false;
//        }
        return true;
    }

    /* renamed from: w */
//    private C2278e m4714w() {
//        if (this.f3798v == null) {
//            this.f3798v = new C2278e(AppContext.getAppContext());
//        }
//        return this.f3798v;
//    }

    /* renamed from: c */
    public void m4729c(boolean dayStyle) {
        this.mCarlifePresenter.m4677b(dayStyle);
    }

    public void performOpenHome() {
        this.mCarlifePresenter.m4668a();
    }

    /* renamed from: a */
    public void mo1478a(String hintStr) {
        this.f3795s.setText(hintStr);
//        this.f3795s.setVisibility(0);
    }

    /* renamed from: a */
    public void mo1477a() {
//        if (this.f3795s != null) {
//            this.f3795s.setVisibility(8);
//        }
    }

    public void hideMapFragment() {
        this.mCarlifePresenter.hideMapFragment();
    }

    public void showMapFragment() {
        this.mCarlifePresenter.showMapFragment();
    }
}
