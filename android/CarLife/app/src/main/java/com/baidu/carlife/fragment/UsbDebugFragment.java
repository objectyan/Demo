package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.C0965R;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;

public class UsbDebugFragment extends ContentFragment {
    /* renamed from: a */
    public static final String f4828a = "firstEnter";
    /* renamed from: b */
    private View f4829b;

    /* renamed from: com.baidu.carlife.fragment.UsbDebugFragment$1 */
    class C15821 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ UsbDebugFragment f4827a;

        C15821(UsbDebugFragment this$0) {
            this.f4827a = this$0;
        }

        public void onClick(View v) {
            try {
                BaseFragment.mActivity.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            this.f4827a.showFragment(515, null);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(C0965R.layout.frag_usb_debug, null);
        setBottomBarStatus(false);
        this.f4829b = this.mContentView.findViewById(C0965R.id.enter_iv_setting);
        this.f4829b.setOnClickListener(new C15821(this));
        return this.mContentView;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public boolean onBackPressed() {
        return true;
    }
}
