package com.baidu.navisdk.ui.util;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;

public class UIUtils {
    private static final String TAG = "UIUtils";

    public static void releaseImageView(ImageView iv) {
        if (iv != null) {
            try {
                iv.setImageBitmap(null);
                iv.setBackgroundResource(17170445);
                iv.setBackgroundDrawable(null);
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "releaseImageView Exception :" + e.getMessage());
            }
        }
    }

    public static void releaseImageViewWithoutNull(ImageView iv) {
        if (iv != null) {
            try {
                iv.setImageBitmap(null);
                iv.setBackgroundResource(17170445);
                iv.setBackgroundDrawable(null);
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "releaseImageView Exception :" + e.getMessage());
            }
        }
    }

    public static boolean isTextFullDisplay(TextView view, int viewWidth, String text, int lineCount) {
        if (viewWidth < 0) {
            LogUtil.m15791e("UiUtil", "isTextFullDisplay viewWidth < 0");
            LogUtil.printCallStatck();
            return true;
        }
        DynamicLayout layout;
        if (VERSION.SDK_INT >= 16) {
            layout = new DynamicLayout(text, view.getPaint(), viewWidth, Alignment.ALIGN_NORMAL, view.getLineSpacingMultiplier(), view.getLineSpacingExtra(), view.getIncludeFontPadding());
        } else {
            layout = new DynamicLayout(text, view.getPaint(), viewWidth, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        return layout.getLineCount() <= lineCount;
    }

    public static boolean isTextFullDisplay(TextView view, int width, String text) {
        return ((float) width) >= view.getPaint().measureText(text);
    }

    public static int mearsureTextWidth(TextView view, String text) {
        Paint paint = view.getPaint();
        if (paint == null) {
            return -1;
        }
        return (int) paint.measureText(text);
    }
}
