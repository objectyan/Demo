package com.baidu.navi.controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.C0965R;
import com.baidu.mobstat.Config;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.RouteCustomUtil;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.model.RouteCustomModel;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RouteCustomController {
    public static final String ALARM_BROADCAST = "com.baidu.navi.alarm";
    public static final String REPEAT_DATES_SPLIT = ",";
    public static final String ROUTE_CUSTOM_CALC_ROUTE_RESULT_KEY = "calc_route_result_key";
    private static RouteCustomController mInstance;
    private Calendar mCalendar = Calendar.getInstance();
    private boolean mIsModifiedName;
    private boolean mIsModifiedRepeatDate;
    private int mIsOpen;
    private int mIsRepeat;
    private boolean mIsUpdatePushTime;
    private ContentFragmentManager mNaviFragmentManager;
    private int mNewRouteHisDBId = -1;
    private ArrayList<RoutePlanNode> mNewRouteNodesList = null;
    private int mNewRouteType = -1;
    private int mPushTimeHour;
    private long mPushTimeMills;
    private int mPushTimeMinute;
    private String mRCName;
    private Handler mRPHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(RouteCustomController.this.mRPHandler);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(RouteCustomController.ROUTE_CUSTOM_CALC_ROUTE_RESULT_KEY, true);
                    RouteCustomController.this.mNaviFragmentManager.showFragment(NaviFragmentManager.TYPE_ROUTE_CUSTOM_DETAIL, bundle);
                    return;
                case 7:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(RouteCustomController.this.mRPHandler);
                    Bundle jumpBundle = new Bundle();
                    jumpBundle.putBoolean(RouteCustomController.ROUTE_CUSTOM_CALC_ROUTE_RESULT_KEY, false);
                    RouteCustomController.this.mNaviFragmentManager.showFragment(NaviFragmentManager.TYPE_ROUTE_CUSTOM_DETAIL, jumpBundle);
                    return;
                case 32:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(RouteCustomController.this.mRPHandler);
                    return;
                default:
                    return;
            }
        }
    };
    private String mRepeatDate;
    private int mSelRouteCustomPos;
    private int mUserCurAction = 2;

    private RouteCustomController() {
        clear();
    }

    public static RouteCustomController getInstance() {
        if (mInstance == null) {
            mInstance = new RouteCustomController();
        }
        return mInstance;
    }

    public void clear() {
        this.mSelRouteCustomPos = -1;
        this.mIsOpen = 0;
        this.mIsUpdatePushTime = false;
        this.mPushTimeMills = -1;
        this.mPushTimeHour = -1;
        this.mPushTimeMinute = -1;
        this.mIsModifiedName = false;
        this.mRCName = "";
        this.mIsRepeat = 0;
        this.mIsModifiedRepeatDate = false;
        this.mRepeatDate = "";
    }

    public void setSelRouteCustomPos(int position) {
        clear();
        this.mSelRouteCustomPos = position;
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(this.mSelRouteCustomPos);
        if (obj != null) {
            this.mIsOpen = obj.getOpen();
            this.mIsRepeat = obj.getIsRepeat();
            this.mIsUpdatePushTime = false;
        }
    }

    public int getSelRouteCustomPos() {
        return this.mSelRouteCustomPos;
    }

    public void setUserCurAction(int action) {
        this.mUserCurAction = action;
    }

    public int getUserCurAction() {
        return this.mUserCurAction;
    }

    public void setRCName(String name) {
        this.mRCName = name;
        this.mIsModifiedName = true;
    }

    public String getRCName() {
        return this.mRCName;
    }

    public int getRCPushTimeHour() {
        return this.mPushTimeHour;
    }

    public void setRCPushTimeHourAndMinute(int hour, int minute) {
        this.mPushTimeHour = hour;
        this.mPushTimeMinute = minute;
        this.mIsUpdatePushTime = true;
    }

    public void setRCPushTimeMills(long mills) {
        this.mPushTimeMills = mills;
    }

    public int getRCPushIsRepeat() {
        return this.mIsRepeat;
    }

    public void setRCPushIsRepeat() {
        if (this.mRepeatDate == "" || this.mRepeatDate == null) {
            this.mIsRepeat = 0;
        } else {
            this.mIsRepeat = 1;
        }
    }

    public void setRCPushRepeatDate(String dates) {
        this.mRepeatDate = dates;
        this.mIsUpdatePushTime = true;
        this.mIsModifiedRepeatDate = true;
    }

    public void updateRCSettingsInfo(boolean isUpdateSwitch) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(this.mSelRouteCustomPos);
        if (obj != null) {
            obj.setOpen(this.mIsOpen);
            if (!isUpdateSwitch) {
                if (this.mIsModifiedName) {
                    obj.setName(this.mRCName);
                }
                if (this.mPushTimeHour != -1) {
                    obj.setPushTimeHour(this.mPushTimeHour);
                    obj.setPushTimeMinute(this.mPushTimeMinute);
                    obj.setPushTimeMills(this.mPushTimeMills);
                }
                if (this.mIsModifiedRepeatDate) {
                    obj.setRepeatDate(this.mRepeatDate);
                    obj.setIsRepeat(this.mIsRepeat);
                }
            }
            RouteCustomModel.getInstance().updateRouteCustomInfo(this.mSelRouteCustomPos);
        }
    }

    public void addAlarmNotify(Context context, long timeInMillis, int dbRecordId) {
        AlarmManager am = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(ALARM_BROADCAST);
        intent.putExtra("id", dbRecordId);
        am.set(1, timeInMillis, PendingIntent.getBroadcast(context, dbRecordId, intent, 0));
    }

    public void deleteAlarmNotify(Context context, int dbRecordId) {
        AlarmManager am = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(ALARM_BROADCAST);
        intent.putExtra("id", dbRecordId);
        am.cancel(PendingIntent.getBroadcast(context, dbRecordId, intent, 0));
    }

    private int[] parseRepeatDateStr(String str) {
        int[] iArr = null;
        if (!(StringUtils.isEmpty(str) || str == "")) {
            String[] dateStrArray = str.split(",");
            if (!(dateStrArray == null || dateStrArray.length == 0)) {
                int size = dateStrArray.length;
                iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    try {
                        iArr[i] = Integer.valueOf(dateStrArray[i]).intValue();
                    } catch (Exception e) {
                        iArr[i] = -1;
                    }
                }
            }
        }
        return iArr;
    }

    public long getNextPushTimeMillsByRCId(int rcDBId) {
        long mills = 0;
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoById(rcDBId);
        if (obj != null) {
            int[] dateArray = parseRepeatDateStr(obj.getRepeatDate());
            if (dateArray == null || dateArray.length == 0) {
                return -1;
            }
            int size = dateArray.length;
            int curWeekDay = RouteCustomUtil.getInstance().getWeekByTimeMillis(System.currentTimeMillis());
            int index = 0;
            while (index < size && dateArray[index] <= curWeekDay) {
                index++;
            }
            if (index == size) {
                index = 0;
            }
            mills = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(dateArray[index], obj.getPushTimeHour(), obj.getPushTimeMinute());
        }
        return mills;
    }

    public long getFirstPushTimeMills(int position) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return -1;
        }
        int[] dateArray = parseRepeatDateStr(obj.getRepeatDate());
        if (dateArray == null || dateArray.length == 0) {
            return -1;
        }
        long mills;
        int size = dateArray.length;
        long curWeekDay = (long) RouteCustomUtil.getInstance().getWeekByTimeMillis(System.currentTimeMillis());
        int index = 0;
        while (index < size && ((long) dateArray[index]) < curWeekDay) {
            index++;
        }
        if (index >= size) {
            mills = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(dateArray[0], obj.getPushTimeHour(), obj.getPushTimeMinute());
        } else if (((long) dateArray[index]) == curWeekDay) {
            mills = RouteCustomUtil.getInstance().calcPushTime(obj.getPushTimeHour(), obj.getPushTimeMinute(), obj.getIsRepeat());
            if (mills < System.currentTimeMillis()) {
                mills = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(dateArray[(index + 1) % size], obj.getPushTimeHour(), obj.getPushTimeMinute());
            }
        } else {
            mills = RouteCustomUtil.getInstance().getPushTimeMillsByWeek(dateArray[index], obj.getPushTimeHour(), obj.getPushTimeMinute());
        }
        return mills;
    }

    public void addNewRCPushTimeToAlarm(Context context) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(this.mSelRouteCustomPos);
        if (obj != null && this.mIsOpen != 0 && this.mIsUpdatePushTime) {
            long pushMills;
            this.mPushTimeMills = RouteCustomUtil.getInstance().calcPushTime(this.mPushTimeHour, this.mPushTimeMinute, this.mIsRepeat);
            if (this.mIsRepeat == 0) {
                pushMills = this.mPushTimeMills;
            } else {
                pushMills = getFirstPushTimeMills(this.mSelRouteCustomPos);
            }
            if (pushMills != -1) {
                deleteAlarmNotify(context, obj.getId());
                addAlarmNotify(context, pushMills, obj.getId());
                obj.setPushTimeMills(pushMills);
                RouteCustomModel.getInstance().updateRouteCustomInfo(this.mSelRouteCustomPos);
            }
        }
    }

    public void openOrCloseRCAlarmByPos(Context context, int position, int isOpen, int defHour, int defMinute) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj != null) {
            obj.setOpen(isOpen);
            if (isOpen == 1 && obj.getPushTimeHour() == -1) {
                obj.setPushTimeHour(defHour);
                obj.setPushTimeMinute(defMinute);
            }
            if (isOpen == 0) {
                deleteAlarmNotify(context, obj.getId());
            } else {
                long pushMills = RouteCustomUtil.getInstance().calcPushTime(obj.getPushTimeHour(), obj.getPushTimeMinute(), obj.getIsRepeat());
                if (obj.getIsRepeat() == 1) {
                    pushMills = getFirstPushTimeMills(position);
                }
                if (pushMills != -1) {
                    obj.setPushTimeMills(pushMills);
                    deleteAlarmNotify(context, obj.getId());
                    addAlarmNotify(context, pushMills, obj.getId());
                    obj.setPushTimeMills(pushMills);
                } else {
                    return;
                }
            }
            RouteCustomModel.getInstance().updateRouteCustomInfo(position);
        }
    }

    public void calcExtendRouteResult(ArrayList<RoutePlanNode> navNodeList, NaviFragmentManager manager) {
        if (navNodeList != null && navNodeList.size() != 0) {
            this.mNaviFragmentManager = manager;
            BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
            BNRoutePlaner.getInstance().calcRouteToRouteCustom(navNodeList);
        }
    }

    private String getRCRealNameByRPNodes(ArrayList<RoutePlanNode> nodesList, int type) {
        String name = "";
        if (nodesList == null || nodesList.size() == 0) {
            return name;
        }
        if (type == 1 || type == 2 || nodesList.size() == 1) {
            RoutePlanNode curPos = BNLocationManagerProxy.getInstance().getCurLocationNode();
            if (curPos != null) {
                if (StringUtils.isEmpty(curPos.mName)) {
                    name = StyleManager.getString(C0965R.string.route_plan_start_my_pos);
                } else {
                    name = curPos.mName;
                }
                name = name + "-";
            }
        }
        return name + produceRouteNameByRPNodesList(nodesList);
    }

    private String produceRouteNameByRPNodesList(List<RoutePlanNode> list) {
        String routeDetailInfo = "";
        if (list == null || list.size() == 0) {
            return routeDetailInfo;
        }
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            routeDetailInfo = routeDetailInfo + getRoutePlanNodeName((RoutePlanNode) list.get(i)) + " - ";
        }
        return routeDetailInfo + getRoutePlanNodeName((RoutePlanNode) list.get(size - 1));
    }

    private String getRoutePlanNodeName(RoutePlanNode node) {
        String reStr = "";
        if (node == null) {
            reStr = StyleManager.getString(C0965R.string.navi_unknown_road);
        }
        if (node.isNodeSettedData()) {
            return StringUtils.isEmpty(node.mName) ? StyleManager.getString(C0965R.string.navi_unknown_road) : node.mName;
        } else {
            return reStr;
        }
    }

    public String getNewRCRealName(Context context) {
        ArrayList<RoutePlanNode> nodesList;
        String name = "";
        if (this.mNewRouteType != 3) {
            RoutePlanNode destPosNOde;
            nodesList = new ArrayList();
            if (this.mNewRouteType == 1) {
                destPosNOde = AddressSettingModel.getHomeAddrNode(context);
            } else {
                destPosNOde = AddressSettingModel.getCompAddrNode(context);
            }
            nodesList.add(destPosNOde);
        } else {
            nodesList = this.mNewRouteNodesList;
        }
        return getRCRealNameByRPNodes(nodesList, this.mNewRouteType);
    }

    public String getRCRealNameByPos(int position) {
        String name = "";
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return "";
        }
        return getRCRealNameByRPNodes(obj.getRoutePlanNodes(), obj.getDestType());
    }

    public String getRCShowNameByDBId(int dbId) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoById(dbId);
        if (obj == null) {
            return "";
        }
        String rcTitle = obj.getName();
        if (StringUtils.isEmpty(rcTitle)) {
            return getRCRealNameByRPNodes(obj.getRoutePlanNodes(), obj.getDestType());
        }
        return rcTitle;
    }

    public String getRCShowNameByPos(int position) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return "";
        }
        String rcTitle = obj.getName();
        if (StringUtils.isEmpty(rcTitle)) {
            return getRCRealNameByRPNodes(obj.getRoutePlanNodes(), obj.getDestType());
        }
        return rcTitle;
    }

    public String getRCRemakNameByPos(int position) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return "";
        }
        return obj.getName();
    }

    public String getRCPushTimeStrByPos(int position) {
        String pushTimeStr = "";
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return pushTimeStr;
        }
        int hour = obj.getPushTimeHour();
        int minute = obj.getPushTimeMinute();
        if (hour == -1 || minute == -1) {
            this.mCalendar.setTimeInMillis(System.currentTimeMillis());
            hour = this.mCalendar.get(11);
            minute = this.mCalendar.get(12);
        }
        return RouteCustomUtil.getInstance().getTimeStr(hour, minute);
    }

    public String getNewRCPushTImeStr() {
        this.mCalendar.setTimeInMillis(System.currentTimeMillis());
        return RouteCustomUtil.getInstance().getTimeStr(this.mCalendar.get(11), this.mCalendar.get(12));
    }

    public int[] parsePushTimeStr(String str) {
        int[] timeIntArray = new int[2];
        if (StringUtils.isEmpty(str)) {
            this.mCalendar.setTimeInMillis(System.currentTimeMillis());
            timeIntArray[0] = this.mCalendar.get(11);
            timeIntArray[1] = this.mCalendar.get(12);
        } else {
            String[] timeStrArray = str.split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (timeStrArray != null || timeStrArray.length > 1) {
                try {
                    timeIntArray[0] = Integer.valueOf(timeStrArray[0]).intValue();
                } catch (Exception e) {
                    timeIntArray[0] = this.mCalendar.get(11);
                }
                try {
                    timeIntArray[1] = Integer.valueOf(timeStrArray[1]).intValue();
                } catch (Exception e2) {
                    timeIntArray[1] = this.mCalendar.get(12);
                }
            }
        }
        return timeIntArray;
    }

    public int[] getRCPushRepeatDateByPos(int position) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return null;
        }
        return parseRepeatDateStr(obj.getRepeatDate());
    }

    public String getRCPushRepeatDateStrByPos(int position) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return "";
        }
        return obj.getRepeatDate();
    }

    public int getRCPushStatus(int position) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(position);
        if (obj == null) {
            return 0;
        }
        return obj.getOpen();
    }

    public void asyncGetRouteCustomCondInfo(Handler handler) {
        int size = RouteCustomModel.getInstance().getRouteCustomSize();
        if (size != 0) {
            ArrayList<Bundle> rcNodesList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Bundle bundle = RouteCustomModel.getInstance().getNodesListBundle(i);
                if (bundle != null) {
                    rcNodesList.add(bundle);
                }
            }
        }
    }

    public void setCurRouteInfoByRouteSubcribeResult(ArrayList<RoutePlanNode> nodesList, int type, int hisRouteDBId) {
        if (type != 3) {
            hisRouteDBId = -1;
        }
        int position = RouteCustomModel.getInstance().getCurRouteIndex(type, hisRouteDBId, nodesList);
        if (position >= 0) {
            setSelRouteCustomPos(position);
            this.mUserCurAction = 2;
            return;
        }
        this.mUserCurAction = 1;
        this.mNewRouteNodesList = nodesList;
        this.mNewRouteType = type;
        this.mNewRouteHisDBId = hisRouteDBId;
    }

    public void resetCurRouteInfo() {
        this.mUserCurAction = 2;
        this.mNewRouteNodesList = null;
        this.mNewRouteType = -1;
        this.mNewRouteHisDBId = -1;
    }

    public int subcribeNewRouteAndAddToDB(Context context) {
        if (this.mNewRouteType != 3) {
            this.mNewRouteHisDBId = -1;
        }
        if (this.mNewRouteType == 3 && (this.mNewRouteHisDBId == -1 || this.mNewRouteNodesList == null)) {
            return -1;
        }
        int position = RouteCustomModel.getInstance().addNewCustomRoute(this.mNewRouteHisDBId, this.mNewRouteNodesList, this.mNewRouteType);
        if (position >= 0) {
            setSelRouteCustomPos(position);
        } else if (position == -2) {
            TipTool.onCreateToastDialog(context, (int) C0965R.string.route_custom_max_sum_tips);
        }
        return position;
    }

    public void calcPushTimeAndAddAlarmByRCList(Context context) {
        ArrayList<RouteCustomDBObject> rcDBObjList = RouteCustomModel.getInstance().getRouteCustomList();
        if (rcDBObjList != null && rcDBObjList.size() != 0) {
            int size = rcDBObjList.size();
            for (int position = 0; position < size; position++) {
                RouteCustomDBObject obj = (RouteCustomDBObject) rcDBObjList.get(position);
                if (obj != null && obj.getOpen() == 1) {
                    long pushMills;
                    if (obj.getIsRepeat() == 0) {
                        pushMills = obj.getPushTimeMills();
                        if (pushMills < System.currentTimeMillis()) {
                        }
                    } else {
                        pushMills = getFirstPushTimeMills(position);
                    }
                    deleteAlarmNotify(context, obj.getId());
                    addAlarmNotify(context, pushMills, obj.getId());
                }
            }
        }
    }
}
