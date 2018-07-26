package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDrivingToolUploadDialog extends Dialog {
    private Button mContinueBtn;
    private TextView mResultTx;
    private TextView mSuccesstx;

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolUploadDialog$1 */
    class C47001 implements OnClickListener {
        C47001() {
        }

        public void onClick(View v) {
        }
    }

    public BNDrivingToolUploadDialog(Context context) {
        super(context);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_driving_tool_upload_result, null);
        setContentView(view);
        this.mResultTx = (TextView) view.findViewById(C4048R.id.upload_result_tx);
        this.mContinueBtn = (Button) view.findViewById(C4048R.id.continue_upload);
        if (this.mContinueBtn != null) {
            this.mContinueBtn.setOnClickListener(new C47001());
        }
        this.mSuccesstx = (TextView) view.findViewById(C4048R.id.upload_succes_result_tx);
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.width = (ScreenUtil.getInstance().getWidthPixels() / 3) * 2;
        lp.height = ScreenUtil.getInstance().getHeightPixels() / 3;
        window.setAttributes(lp);
        window.setGravity(17);
    }

    public void updateUploadFailView(String msg) {
        if (this.mResultTx != null) {
            this.mResultTx.setText(msg);
        }
    }

    public void updateUploadSuccessView(String msg) {
        if (this.mSuccesstx != null) {
            this.mSuccesstx.setText(msg);
        }
    }
}
