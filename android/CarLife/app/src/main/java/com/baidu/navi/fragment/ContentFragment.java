package com.baidu.navi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.C1872t;
import com.baidu.carlife.p084h.C1606a;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import java.util.Collection;
import java.util.Map;

public abstract class ContentFragment extends BaseFragment implements C1606a {
    public static final String TAG = "Framework";
    protected boolean isAddFt;
    public boolean isDisplayed;
    protected boolean isResumed;
    public Bundle mBackBundle;
    protected View mContentView;
    protected int mModuleFrom;
    protected boolean mNeedInitView;
    protected boolean mNeedRetoreView;
    public Bundle mShowBundle;
    protected String mSkinName;

    /* renamed from: com.baidu.navi.fragment.ContentFragment$1 */
    class C37871 implements OnClickListener {
        C37871() {
        }

        public void onClick(View v) {
            ContentFragment.this.back();
        }
    }

    /* renamed from: com.baidu.navi.fragment.ContentFragment$2 */
    class C37882 implements OnClickListener {
        C37882() {
        }

        public void onClick(View v) {
            ContentFragment.this.back();
        }
    }

    protected abstract View onCreateContentView(LayoutInflater layoutInflater);

    protected abstract void onInitView();

    public ContentFragment() {
        this.isDisplayed = false;
        this.mNeedInitView = false;
        this.mNeedRetoreView = false;
        this.isResumed = false;
        this.isAddFt = false;
        this.isDisplayed = false;
        this.isResumed = false;
    }

    public boolean isAddFt() {
        return this.isAddFt;
    }

    public void setAddFt(boolean isAddFt) {
        this.isAddFt = isAddFt;
    }

    public void onAttach(Context activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.isAddFt = false;
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(ContentFragmentManager.KEY_BACK_BUNDLE)) {
                this.mBackBundle = bundle.getBundle(ContentFragmentManager.KEY_BACK_BUNDLE);
            }
            if (bundle.containsKey(ContentFragmentManager.KEY_FRAGMENT_TYPE)) {
                this.fragmentType = bundle.getInt(ContentFragmentManager.KEY_FRAGMENT_TYPE);
            }
            this.mShowBundle = bundle.getBundle(ContentFragmentManager.KEY_SHOW_BUNDLE);
            if (this.mShowBundle != null && this.mShowBundle.containsKey(ContentFragmentManager.MODULE_FROM)) {
                this.mModuleFrom = this.mShowBundle.getInt(ContentFragmentManager.MODULE_FROM);
            }
        }
        if (isMapPage()) {
            showMapFragment();
        } else {
            hideMapFragment();
        }
        int orientation = C1192c.a().g();
        boolean dayStyle = StyleManager.getRealDayStyle();
        String currentSkinName = C1872t.a().c();
        if (this.mContentView != null) {
            ViewGroup parent = (ViewGroup) this.mContentView.getParent();
            if (parent != null) {
                parent.removeView(this.mContentView);
            }
            this.mViewCreated = true;
            if (this.mOrientation != orientation) {
                updateOrientation(orientation);
            }
            if (this.mDayStyle != dayStyle) {
                updateStyle(dayStyle);
            }
            if (!currentSkinName.equals(this.mSkinName)) {
                C1260i.b("Framework", "onCreateView skin");
                onUpdateSkin();
                this.mSkinName = currentSkinName;
            }
        } else {
            this.mContentView = onCreateContentView(inflater);
            this.mViewCreated = true;
            updateOrientation(orientation);
            updateStyle(dayStyle);
            this.mSkinName = C1872t.a().c();
            onUpdateSkin();
        }
        if (!(isMapPage() || this.mContentView == null)) {
            this.mContentView.setClickable(true);
        }
        if (this.fragmentType == getCurrentFragmentType()) {
            onInitFocusAreas();
        }
        onInit();
        return this.mContentView;
    }

    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            if (isMapPage()) {
                showMapFragment();
            } else {
                hideMapFragment();
            }
        }
        super.onHiddenChanged(hidden);
        String currentSkinName = C1872t.a().c();
        if (!(hidden || currentSkinName.equals(this.mSkinName))) {
            C1260i.b("Framework", "onHiddenChanged Skin");
            onUpdateSkin();
            this.mSkinName = currentSkinName;
        }
        if (!hidden) {
            onInitFocusAreas();
        }
    }

    protected void onUpdateSkin() {
    }

    public void onInitFocusAreas() {
    }

    protected void updateCommonSkin() {
        if (this.mContentView != null) {
            ImageButton btnBack = (ImageButton) this.mContentView.findViewById(C0965R.id.ib_left);
            if (btnBack != null) {
                btnBack.setImageDrawable(C2188r.b(C0965R.drawable.com_ic_back));
                btnBack.setBackground(C2251b.a(mActivity));
            }
            TextView titleTV = (TextView) this.mContentView.findViewById(C0965R.id.tv_title);
            if (titleTV != null) {
                titleTV.setTextColor(C2188r.a(C0965R.color.cl_text_a4_title));
            }
        }
    }

    protected void setCommonTitleBar(View root, String title) {
        ImageButton btnBack = (ImageButton) root.findViewById(C0965R.id.ib_left);
        if (btnBack != null) {
            btnBack.setBackground(C2251b.a(mActivity));
            btnBack.setOnClickListener(new C37871());
        }
        View hide = root.findViewById(C0965R.id.view_hide);
        if (hide != null) {
            hide.setOnClickListener(new C37882());
        }
        TextView titleTV = (TextView) root.findViewById(C0965R.id.tv_title);
        if (titleTV != null && !TextUtils.isEmpty(title)) {
            titleTV.setText(title);
        }
    }

    public void onDestroyView() {
        this.mViewCreated = false;
        this.mNeedInitView = false;
        this.mNeedRetoreView = false;
        this.isDisplayed = false;
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!isNaviMapFragment()) {
            hideMapFragment();
        }
    }

    public void requestInitView() {
        if (this.mViewCreated) {
            onInitView();
        } else {
            this.mNeedInitView = true;
        }
    }

    public void requestRestoreView() {
        if (this.mViewCreated) {
            onRestoreView();
        } else {
            this.mNeedRetoreView = true;
        }
    }

    protected void onRestoreView() {
    }

    public boolean onBackPressed() {
        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    protected void onInit() {
        if (this.mNeedInitView) {
            onInitView();
            this.mNeedInitView = false;
        }
        if (this.mNeedRetoreView) {
            onRestoreView();
            this.mNeedRetoreView = false;
        }
    }

    protected long getAnimationTotalDuration(Collection<Animation> animList) {
        long duration = 0;
        if (animList != null) {
            for (Animation anim : animList) {
                duration = Math.max(anim.getStartOffset() + anim.getDuration(), duration);
            }
        }
        return duration;
    }

    protected void startAnimation(Map<View, Animation> animMap) {
        if (animMap != null) {
            for (View view : animMap.keySet()) {
                Animation anim = (Animation) animMap.get(view);
                if (!(anim == null || view == null)) {
                    view.startAnimation(anim);
                }
            }
        }
    }

    public void onResume() {
        this.isDisplayed = true;
        try {
            if (!this.isResumed) {
                this.isResumed = true;
                StatisticManager.onPageStart(mActivity, getClass().getSimpleName());
            }
        } catch (Exception e) {
            C1260i.a("", e.toString());
        }
        super.onResume();
    }

    public void onPause() {
        try {
            if (this.isResumed) {
                this.isResumed = false;
                StatisticManager.onPageEnd(mActivity, getClass().getSimpleName());
            }
        } catch (Exception e) {
            C1260i.a("", e.toString());
        }
        super.onPause();
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (2 == type) {
            switch (subType) {
                case 2:
                case 3:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 29:
                case 30:
                    return true;
            }
        }
        return false;
    }

    protected boolean isGausianFragment() {
        return getCurrentFragmentType() == NaviFragmentManager.TYPE_MUSIC_PLAYER;
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        return false;
    }

    public boolean onVoiceCommand(int selectIndex) {
        return false;
    }

    public void replyVoiceCommand(int type, int result, boolean needResponse) {
        if (needResponse) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, result);
        }
    }

    public void loge(String msg) {
    }

    public void pageBack(int moduleFrom) {
        if (moduleFrom == 1 || moduleFrom == 4 || moduleFrom == 2) {
            if (getCurrentFragmentType() == 35) {
                backTo(34, null);
            }
            back();
            if (moduleFrom == 1) {
                performOpenHome();
                return;
            } else if (moduleFrom == 4) {
                showLatestMusicFragment();
                return;
            } else if (moduleFrom == 2) {
                showLatestPhoneFragment();
                return;
            } else {
                return;
            }
        }
        back();
    }

    public boolean isMapPage() {
        return false;
    }

    public void driving() {
    }

    public void stopDriving() {
    }
}
