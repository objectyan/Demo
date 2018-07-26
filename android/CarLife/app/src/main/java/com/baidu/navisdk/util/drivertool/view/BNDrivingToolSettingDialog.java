package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDrivingToolSettingDialog extends Dialog {
    private ToggleButton mToggleBtn;
    private Button mUploadBtn;

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolSettingDialog$1 */
    class C46951 implements OnCheckedChangeListener {
        C46951() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                BNSettingManager.setRecordingHighDefinition(true);
            } else {
                BNSettingManager.setRecordingHighDefinition(false);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolSettingDialog$2 */
    class C46992 implements OnClickListener {

        /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolSettingDialog$2$2 */
        class C46972 implements DialogInterface.OnClickListener {
            C46972() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
        }

        /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolSettingDialog$2$3 */
        class C46983 implements OnDismissListener {
            C46983() {
            }

            public void onDismiss(DialogInterface dialog) {
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
        }

        C46992() {
        }

        public void onClick(View v) {
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                BNDrivingToolSettingDialog.this.dismiss();
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
                boolean isWifiAvalible = NetworkUtils.isWifiConnected();
                final Context ctx = BNaviModuleManager.getNaviActivity();
                if (ctx == null) {
                    return;
                }
                if (isWifiAvalible) {
                    BNDrivingToolManager.getInstance().uploadLocalMaterial(ctx);
                    return;
                }
                Builder builder = new Builder(ctx);
                builder.setMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_driving_tool_no_wifi_upload));
                builder.setTitle("提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        BNDrivingToolManager.getInstance().uploadLocalMaterial(ctx);
                    }
                });
                builder.setNegativeButton("取消", new C46972());
                builder.setOnDismissListener(new C46983());
                builder.create().show();
                return;
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_driving_tool_no_network));
        }
    }

    public BNDrivingToolSettingDialog(Context context) {
        super(context);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_driving_tool_setting, null);
        setContentView(view);
        this.mToggleBtn = (ToggleButton) view.findViewById(C4048R.id.video_defination_switch);
        this.mToggleBtn.setChecked(BNSettingManager.isRecordingHighDefinition());
        this.mUploadBtn = (Button) view.findViewById(C4048R.id.upload_material_btn);
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.width = (ScreenUtil.getInstance().getWidthPixels() / 3) * 2;
        lp.height = ScreenUtil.getInstance().getHeightPixels() / 4;
        lp.gravity = 17;
        window.setAttributes(lp);
        window.setGravity(17);
        initListener();
    }

    private void initListener() {
        if (this.mToggleBtn != null) {
            this.mToggleBtn.setOnCheckedChangeListener(new C46951());
        }
        if (this.mUploadBtn != null) {
            this.mUploadBtn.setOnClickListener(new C46992());
        }
    }
}
