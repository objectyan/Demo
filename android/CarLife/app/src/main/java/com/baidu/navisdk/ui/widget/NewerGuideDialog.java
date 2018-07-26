package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class NewerGuideDialog extends Dialog {
    private static final int HIGHT_VIEW_ID = 1;
    private RelativeLayout mContent;
    private Activity mContext;
    private ImageView mInfoImageView;

    /* renamed from: com.baidu.navisdk.ui.widget.NewerGuideDialog$1 */
    class C46041 implements OnClickListener {
        C46041() {
        }

        public void onClick(View v) {
            NewerGuideDialog.this.dissmss();
        }
    }

    public NewerGuideDialog(Activity activity) {
        super(activity);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_newer_guide_dialog, null);
        setContentView(view);
        this.mContent = (RelativeLayout) view.findViewById(C4048R.id.content);
        this.mInfoImageView = (ImageView) view.findViewById(C4048R.id.infor_imageview);
        getWindow().setLayout(-1, -1);
        this.mContext = activity;
        view.setOnClickListener(new C46041());
    }

    public NewerGuideDialog addHighLightView(View view, int resid, boolean isBelow) {
        try {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            MarginLayoutParams margin = new MarginLayoutParams(view.getLayoutParams());
            Rect localRect = new Rect();
            this.mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
            LogUtil.m15791e("NewER", "status bar height2=" + localRect.top);
            margin.setMargins(rect.left, rect.top - localRect.top, 0, 0);
            LayoutParams layoutParams = new LayoutParams(margin);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            ImageView hightLightView = new ImageView(this.mContext);
            Bitmap bitmap = Bitmap.createBitmap(rect.right - rect.left, rect.bottom - rect.top, Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
            hightLightView.setImageBitmap(bitmap);
            hightLightView.setId(1);
            if (this.mContent != null) {
                this.mContent.addView(hightLightView, layoutParams);
            }
            this.mInfoImageView.setBackgroundDrawable(JarUtils.getResources().getDrawable(resid));
            LayoutParams infoLayoutParams = new LayoutParams(-2, -2);
            if (isBelow) {
                infoLayoutParams.addRule(3, 1);
            } else {
                infoLayoutParams.addRule(2, 1);
            }
            infoLayoutParams.addRule(5, 1);
            this.mInfoImageView.setLayoutParams(infoLayoutParams);
            if (this.mContent != null) {
                this.mContent.requestLayout();
                this.mContent.invalidate();
            }
        } catch (Exception e) {
        }
        return this;
    }

    public void dissmss() {
        dismiss();
    }
}
