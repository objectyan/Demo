package com.baidu.che.codriver.platform.navi;

import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviDialog {
    public static final String TAG = "NaviDialog";
    String mContent;
    String mDialogId;
    String mFirstBtn;
    String mSecondBtn;

    private NaviDialog() {
    }

    public static NaviDialog create(String params) {
        JSONException e;
        NaviDialog dialog = null;
        try {
            NaviDialog dialog2 = new NaviDialog();
            try {
                JSONObject json = new JSONObject(params);
                dialog2.mDialogId = json.optString("dialogid");
                JSONObject valueObject = json.getJSONObject("value");
                dialog2.mContent = valueObject.optString("content");
                dialog2.mFirstBtn = valueObject.optString("firstbtn");
                dialog2.mSecondBtn = valueObject.optString("secondbtn");
                return dialog2;
            } catch (JSONException e2) {
                e = e2;
                dialog = dialog2;
                e.printStackTrace();
                return dialog;
            }
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return dialog;
        }
    }

    public static NaviDialog create(String content, String firstBtn, String secondBtn, String id) {
        NaviDialog dialog = new NaviDialog();
        dialog.mDialogId = id;
        dialog.mContent = content;
        dialog.mFirstBtn = firstBtn;
        dialog.mSecondBtn = secondBtn;
        return dialog;
    }

    public void notifyBtnClick(boolean first) {
        try {
            JSONObject response = new JSONObject();
            response.put("dialogid", this.mDialogId);
            if (first) {
                response.put(NaviCmdConstants.KEY_NAVI_CMD_ORDER, QPlayAutoJNI.SONG_LIST_ROOT_ID);
            } else {
                response.put(NaviCmdConstants.KEY_NAVI_CMD_ORDER, "-2");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
