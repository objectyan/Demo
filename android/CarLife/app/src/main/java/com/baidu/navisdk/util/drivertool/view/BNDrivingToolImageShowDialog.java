package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDrivingToolImageShowDialog extends Dialog {
    private ImageView mImageView = null;

    public BNDrivingToolImageShowDialog(Context context) {
        super(context);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_driving_tool_image_show, null);
        setContentView(view);
        this.mImageView = (ImageView) view.findViewById(C4048R.id.image_show);
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.width = ScreenUtil.getInstance().getWidthPixels() / 2;
        lp.height = ScreenUtil.getInstance().getHeightPixels() / 2;
        window.setAttributes(lp);
        window.setGravity(17);
    }

    public void updateImage(Bitmap map) {
        if (this.mImageView != null) {
            this.mImageView.setImageBitmap(map);
        }
    }
}
