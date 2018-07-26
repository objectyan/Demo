package com.baidu.navisdk.module.car;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class BNYellowBannerTipsModel {
    private static BNYellowBannerTipsModel instance = new BNYellowBannerTipsModel();
    protected ArrayList<TipsType> TipsTypeList = null;
    protected String[] bgcolors = null;
    protected int expireTime = 10;
    protected String[] icons = null;
    protected int[] iconsId = new int[]{C4048R.drawable.yellow_banner_ydgy, C4048R.drawable.yellow_banner_green, C4048R.drawable.yellow_banner_xian, C4048R.drawable.yellow_banner_jtgz, C4048R.drawable.yellow_banner_fl, C4048R.drawable.yellow_banner_dlsg, C4048R.drawable.yellow_banner_dlxq, C4048R.drawable.yellow_banner_dlqw, C4048R.drawable.yellow_banner_dljb, C4048R.drawable.yellow_banner_dljs, C4048R.drawable.yellow_banner_ydgy, C4048R.drawable.yellow_banner_jj, C4048R.drawable.yellow_banner_lxld, C4048R.drawable.yellow_banner_jtyd, C4048R.drawable.yellow_banner_ydgy, C4048R.drawable.yellow_banner_fwq, C4048R.drawable.yellow_banner_ydgy};

    public static class TipsType {
        String name;
        int priority;
        String text;
        int type;

        public TipsType(int type, String name, int priority, String text) {
            this.type = type;
            this.name = name;
            this.priority = priority;
            this.text = text;
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("type:" + this.type + ";");
            sb.append("name:" + this.name + ";");
            sb.append("priority:" + this.priority + ";");
            sb.append("text:" + this.text + ";");
            return sb.toString();
        }
    }

    private BNYellowBannerTipsModel() {
    }

    public static BNYellowBannerTipsModel getInstance() {
        return instance;
    }

    private void reset() {
        this.expireTime = 10;
        this.icons = null;
        this.bgcolors = null;
        this.TipsTypeList = null;
        this.iconsId = null;
    }

    public void parseJson(JSONObject data) {
        try {
            JSONObject objData = data.getJSONObject("yellow_tips");
            this.expireTime = objData.getInt("expire_time");
            this.icons = getStringArr(objData.getString("icons"));
            this.bgcolors = getStringArr(objData.getString("bgcolors"));
            if (this.TipsTypeList == null) {
                this.TipsTypeList = new ArrayList();
            }
            JSONArray mArr = objData.getJSONArray("types");
            for (int i = 0; i < mArr.length(); i++) {
                JSONObject mJSONObject = mArr.getJSONObject(i);
                String priority = mJSONObject.getString(LogFactory.PRIORITY_KEY);
                if (TextUtils.isEmpty(priority)) {
                    priority = "0";
                }
                this.TipsTypeList.add(new TipsType(mJSONObject.getInt("type"), mJSONObject.getString("name"), Integer.parseInt(priority), mJSONObject.getString("text")));
            }
        } catch (Exception e) {
            reset();
            e.printStackTrace();
        }
    }

    private String[] getStringArr(String str) {
        try {
            if (str.startsWith("[")) {
                str = str.substring(1);
            }
            if (str.endsWith("]")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str != null) {
                String[] split = str.split(",");
                for (int i = 0; i < split.length; i++) {
                    split[i] = split[i].replace("\"", "");
                    split[i] = split[i].replace("\\", "");
                }
                return split;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        try {
            sb.append("expireTime:" + this.expireTime + ";");
            int i = 0;
            while (this.icons != null && i < this.icons.length) {
                sb.append("icons" + i + Config.TRACE_TODAY_VISIT_SPLIT + this.icons[i] + ";");
                i++;
            }
            i = 0;
            while (this.bgcolors != null && i < this.bgcolors.length) {
                sb.append("bgcolors" + i + Config.TRACE_TODAY_VISIT_SPLIT + this.bgcolors[i] + ";");
                i++;
            }
            i = 0;
            while (this.TipsTypeList != null && i < this.TipsTypeList.size()) {
                sb.append("TipsTypeList" + i + Config.TRACE_TODAY_VISIT_SPLIT + ((TipsType) this.TipsTypeList.get(i)).toString() + ";");
                i++;
            }
        } catch (Exception e) {
            LogUtil.m15791e("Navi", "toString Exception");
        }
        return sb.toString();
    }

    public void update() {
        if (this.icons == null || this.bgcolors == null || this.TipsTypeList == null) {
            initDefaultData();
        }
        LogUtil.m15791e("BNYellowBannerTipsModel:", toString());
    }

    public void initDefaultData() {
        this.expireTime = 10;
        this.bgcolors = new String[]{"#FFFFFF", "#FFFFFF", "#F75B5B"};
        this.TipsTypeList = new ArrayList();
        this.TipsTypeList.add(new TipsType(0, "在转离", 1, null));
        this.TipsTypeList.add(new TipsType(1, "离转在", 1, null));
        this.TipsTypeList.add(new TipsType(2, "网络连接中断", 0, null));
        this.TipsTypeList.add(new TipsType(3, "本地化车牌设置提示", 4, null));
        this.TipsTypeList.add(new TipsType(4, "本地化可以/无法规避提示", 3, null));
        this.TipsTypeList.add(new TipsType(5, "非官方云端干预信息", 6, null));
        this.TipsTypeList.add(new TipsType(6, "官方云端干预信息", 7, null));
        this.TipsTypeList.add(new TipsType(7, "躲避拥堵", 11, null));
        this.TipsTypeList.add(new TipsType(8, "路线雷达进入提示", 0, null));
        this.TipsTypeList.add(new TipsType(9, "轨迹路线提示", 10, null));
        this.TipsTypeList.add(new TipsType(10, "官方事故提醒", 8, null));
        this.TipsTypeList.add(new TipsType(11, "恶劣天气", 0, null));
        this.TipsTypeList.add(new TipsType(12, "长途服务区", 0, null));
        this.TipsTypeList.add(new TipsType(13, "终点纠错", 2, null));
        this.TipsTypeList.add(new TipsType(14, "轮渡提示", 5, null));
        this.TipsTypeList.add(new TipsType(15, "路线排序", 0, null));
        this.TipsTypeList.add(new TipsType(16, "离线优先", 12, null));
        this.TipsTypeList.add(new TipsType(17, "途径路小黄条", 0, null));
        this.TipsTypeList.add(new TipsType(18, "WIFI提示", 9, null));
    }

    public void initBackGroundColor() {
        this.bgcolors = new String[]{"#FFFFFF", "#FFFFFF", "#F75B5B"};
    }
}
