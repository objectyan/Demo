package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drivertool.BNVideoRecordManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNVideoBoardDialog extends Dialog {
    private SurfaceView mSurfaceView = ((SurfaceView) findViewById(C4048R.id.surface_view));
    private TextView mTimeTx = ((TextView) findViewById(C4048R.id.time_tx));
    private Button mVideoBtn = ((Button) findViewById(C4048R.id.video_btn));

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNVideoBoardDialog$1 */
    class C47031 implements OnClickListener {
        C47031() {
        }

        public void onClick(View v) {
            if (BNaviModuleManager.getNaviActivity() != null) {
                BNVideoRecordManager.getInstance().stopRecordVideo();
            }
        }
    }

    public BNVideoBoardDialog(Context context) {
        super(context);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        setContentView(JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_driving_tool_video_panel, null));
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.y = 0;
        lp.width = ScreenUtil.getInstance().getWidthPixels();
        lp.height = ScreenUtil.getInstance().getHeightPixels() / 3;
        window.setAttributes(lp);
        window.setGravity(48);
        initListener();
    }

    public SurfaceView getVideoPanel() {
        return this.mSurfaceView;
    }

    public void setVideoButtonClickbale(boolean clickable) {
        if (this.mVideoBtn != null) {
            this.mVideoBtn.setClickable(clickable);
        }
    }

    private void initListener() {
        if (this.mVideoBtn != null) {
            this.mVideoBtn.setOnClickListener(new C47031());
        }
    }

    public void updateTimeText(int count) {
        if (this.mTimeTx != null) {
            StringBuffer countBuf = new StringBuffer();
            countBuf.append("00:0");
            countBuf.append(String.valueOf(count));
            this.mTimeTx.setText(countBuf.toString());
        }
    }
}
