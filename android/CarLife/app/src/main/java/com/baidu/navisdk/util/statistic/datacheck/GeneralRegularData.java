package com.baidu.navisdk.util.statistic.datacheck;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.datacheck.regular.DoubleValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.FrequencyRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.IntValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.LongValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.navisdk.util.statistic.datacheck.regular.StringValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.SummationRegular;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralRegularData {
    public String id = null;
    public long lastestCheckTime = 0;
    private Bundle mCheckDataBundle = null;
    private StatisitcsDataCheck mCurCheckData = null;
    private StringBuffer mErrorInfo = null;
    private StringBuffer mInfo = null;
    private List<Regular> mRegulars = new ArrayList();
    private StringBuffer mToastErrorInfo = null;
    public int summation = 0;

    public synchronized boolean check(StatisitcsDataCheck checkData) {
        boolean isok;
        this.mCurCheckData = checkData;
        if (this.mCurCheckData != null) {
            this.mCheckDataBundle = this.mCurCheckData.getDataBundle();
            addHeadInfo();
            isok = true;
            for (int i = 0; i < this.mRegulars.size(); i++) {
                isok &= ((Regular) this.mRegulars.get(i)).check();
            }
            DataCheckCenter.log("checkID:" + this.mCurCheckData.getID() + ", ret:" + isok);
            generateFinalInfo(isok);
            this.mCurCheckData = null;
            this.mCheckDataBundle = null;
        } else {
            isok = false;
        }
        return isok;
    }

    private void addHeadInfo() {
        this.mInfo = new StringBuffer();
        this.mInfo.append("\n-----------------------------------------\n");
        this.mInfo.append(DataCheckLogCenter.getInstance().getCurTimeString() + "\n");
        if (this.mCurCheckData != null) {
            this.mInfo.append("id:" + this.mCurCheckData.getID() + ", data=" + this.mCurCheckData.getDataBundle().toString() + "\n");
        }
        if (this.mCurCheckData != null) {
            DataCheckHelper.reset();
            try {
                DataCheckHelper.sUpJson.put("id", this.mCurCheckData.getID());
                DataCheckHelper.sUpJson.put("value", this.mCurCheckData.getDataBundle().toString());
                DataCheckHelper.sUpJson.put(BaiduNaviParams.KEY_TIME, SystemClock.elapsedRealtime());
            } catch (JSONException e) {
            }
        }
    }

    private void generateFinalInfo(boolean checkok) {
        DataCheckLogCenter.getInstance().appendLog(this.mInfo.toString());
        if (!(checkok || this.mErrorInfo == null)) {
            DataCheckLogCenter.getInstance().appendLog(this.mErrorInfo.toString());
        }
        DataCheckLogCenter.getInstance().appendLog("stack:\n" + LogUtil.getCallStack() + "\n");
        if (!(checkok || this.mCurCheckData == null)) {
            try {
                DataCheckHelper.sUpJson.put("errors", DataCheckHelper.sUpJsonArr);
                DataCheckHelper.sUpJson.put("stack", LogUtil.getCallStack("com.baidu.navisdk"));
                DataCheckHelper.eventId = Integer.parseInt(this.mCurCheckData.getID());
                DataCheckHelper.uploadDataCheck(DataCheckHelper.sUpJson.toString());
            } catch (JSONException e) {
            }
        }
        if (!(!LogUtil.LOGGABLE || this.mToastErrorInfo == null || BNaviModuleManager.getActivity() == null)) {
            Toast.makeText(BNaviModuleManager.getActivity(), this.mToastErrorInfo.toString(), 1).show();
        }
        this.mInfo = null;
        this.mErrorInfo = null;
        this.mToastErrorInfo = null;
    }

    public Bundle getDataBundle() {
        return this.mCheckDataBundle;
    }

    public void addErrorInfo(String info) {
        if (this.mErrorInfo == null) {
            this.mErrorInfo = new StringBuffer();
            this.mErrorInfo.append("[error][id:" + this.mCurCheckData.getID() + "]\n");
        }
        if (this.mErrorInfo != null && info != null) {
            this.mErrorInfo.append(info + "\n");
        }
    }

    public void addToastErrorInfo(String attrname, String attrvalue) {
        if (this.mToastErrorInfo == null) {
            this.mToastErrorInfo = new StringBuffer();
            this.mToastErrorInfo.append("[err][" + this.mCurCheckData.getID() + "]\n");
        }
        if (this.mToastErrorInfo != null && attrname != null && attrvalue != null) {
            this.mToastErrorInfo.append("[" + attrname + Config.TRACE_TODAY_VISIT_SPLIT + attrvalue + "]");
        }
    }

    public boolean loadRegular(String regularJson) {
        DataCheckCenter.log("start load regulars.");
        try {
            JSONObject eventObject = new JSONObject(regularJson);
            if (!eventObject.has("id")) {
                return false;
            }
            this.id = eventObject.getString("id");
            this.mRegulars.clear();
            if (eventObject.has(Regular.ATTR_KEY_SUMMATION)) {
                this.mRegulars.add(new SummationRegular(this, eventObject.getInt(Regular.ATTR_KEY_SUMMATION)));
            }
            if (eventObject.has(Regular.ATTR_KEY_FREQUENCY)) {
                this.mRegulars.add(new FrequencyRegular(this, eventObject.getLong(Regular.ATTR_KEY_FREQUENCY)));
            }
            JSONArray attrJsonArray = eventObject.getJSONArray(Regular.ATTR_KEY_ATTR);
            int size = attrJsonArray.length();
            for (int i = 0; i < size; i++) {
                JSONObject obj = attrJsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String type = obj.getString("type");
                String ct = obj.getString(Regular.ATTR_KEY_CATEGORY);
                JSONArray valuesArray;
                int index;
                if (Regular.TYPE_INT.equals(type)) {
                    IntValueRegular ivr = new IntValueRegular(this, name, ct, type);
                    if (Regular.CATEGORY_FIX_VALUE.equals(ct)) {
                        ivr.fixValue = obj.getInt("value");
                    } else if (!"v".equals(ct)) {
                        if (Regular.CATEGORY_AREA_VALUE.equals(ct)) {
                            valuesArray = obj.getJSONArray("value");
                            if (valuesArray == null || valuesArray.length() != 2) {
                                ivr = null;
                            } else {
                                int tmpv = valuesArray.getInt(0);
                                if (tmpv != 8888) {
                                    ivr.f19718a = tmpv;
                                }
                                tmpv = valuesArray.getInt(1);
                                if (tmpv != 8888) {
                                    ivr.f19719b = tmpv;
                                }
                            }
                        } else if (Regular.CATEGORY_ARRAY_VALUE.equals(ct)) {
                            ivr.arrValues = new ArrayList();
                            valuesArray = obj.getJSONArray("value");
                            for (index = 0; index < valuesArray.length(); index++) {
                                ivr.arrValues.add(Integer.valueOf(valuesArray.getInt(index)));
                            }
                        } else if (Regular.CATEGORY_REGEX_VALUE.equals(ct)) {
                            ivr.regex = obj.getString("value");
                        } else {
                            ivr = null;
                            DataCheckCenter.log("loadRegular the category is error.");
                        }
                    }
                    if (ivr != null) {
                        this.mRegulars.add(ivr);
                    }
                } else if (Regular.TYPE_LONG.equals(type)) {
                    LongValueRegular lvr = new LongValueRegular(this, name, ct, type);
                    if (Regular.CATEGORY_FIX_VALUE.equals(ct)) {
                        lvr.fixValue = obj.getLong("value");
                    } else if (!"v".equals(ct)) {
                        if (Regular.CATEGORY_AREA_VALUE.equals(ct)) {
                            valuesArray = obj.getJSONArray("value");
                            if (valuesArray == null || valuesArray.length() != 2) {
                                lvr = null;
                            } else {
                                long tmpv2 = valuesArray.getLong(0);
                                if (tmpv2 != Regular.LONG_AREA_INVALID_VALUE) {
                                    lvr.f19720a = tmpv2;
                                }
                                tmpv2 = valuesArray.getLong(1);
                                if (tmpv2 != Regular.LONG_AREA_INVALID_VALUE) {
                                    lvr.f19721b = tmpv2;
                                }
                            }
                        } else if (Regular.CATEGORY_ARRAY_VALUE.equals(ct)) {
                            lvr.arrValues = new ArrayList();
                            valuesArray = obj.getJSONArray("value");
                            for (index = 0; index < valuesArray.length(); index++) {
                                lvr.arrValues.add(Long.valueOf(valuesArray.getLong(index)));
                            }
                        } else if (Regular.CATEGORY_REGEX_VALUE.equals(ct)) {
                            lvr.regex = obj.getString("value");
                        } else {
                            lvr = null;
                            DataCheckCenter.log("loadRegular the category is error.");
                        }
                    }
                    if (lvr != null) {
                        this.mRegulars.add(lvr);
                    }
                } else if (Regular.TYPE_DOUBLE.equals(type)) {
                    DoubleValueRegular dvr = new DoubleValueRegular(this, name, ct, type);
                    if (!(Regular.CATEGORY_FIX_VALUE.equals(ct) || "v".equals(ct))) {
                        if (Regular.CATEGORY_AREA_VALUE.equals(ct)) {
                            valuesArray = obj.getJSONArray("value");
                            if (valuesArray == null || valuesArray.length() != 2) {
                                dvr = null;
                            } else {
                                double tmpv3 = valuesArray.getDouble(0);
                                if (tmpv3 != 8888.0d) {
                                    dvr.f19716a = tmpv3;
                                }
                                tmpv3 = valuesArray.getDouble(1);
                                if (tmpv3 != 8888.0d) {
                                    dvr.f19717b = tmpv3;
                                }
                            }
                        } else if (Regular.CATEGORY_ARRAY_VALUE.equals(ct)) {
                            dvr.arrValues = new ArrayList();
                            valuesArray = obj.getJSONArray("value");
                            for (index = 0; index < valuesArray.length(); index++) {
                                dvr.arrValues.add(Double.valueOf(valuesArray.getDouble(index)));
                            }
                        } else if (Regular.CATEGORY_REGEX_VALUE.equals(ct)) {
                            dvr.regex = obj.getString("value");
                        } else {
                            dvr = null;
                            DataCheckCenter.log("loadRegular the category is error.");
                        }
                    }
                    if (dvr != null) {
                        this.mRegulars.add(dvr);
                    }
                } else if (Regular.TYPE_STRING.equals(type)) {
                    StringValueRegular svr;
                    StringValueRegular stringValueRegular = new StringValueRegular(this, name, ct, type);
                    if (Regular.CATEGORY_FIX_VALUE.equals(ct)) {
                        stringValueRegular.fixValue = obj.getString("value");
                    } else if (!"v".equals(ct)) {
                        if (Regular.CATEGORY_AREA_VALUE.equals(ct)) {
                            valuesArray = obj.getJSONArray("value");
                            if (valuesArray == null || valuesArray.length() != 2) {
                                svr = null;
                            } else {
                                String tmpv4 = valuesArray.getString(0);
                                if (!"null".equals(tmpv4)) {
                                    stringValueRegular.f19722a = tmpv4;
                                }
                                tmpv4 = valuesArray.getString(1);
                                if (!"null".equals(tmpv4)) {
                                    stringValueRegular.f19723b = tmpv4;
                                }
                            }
                        } else if (Regular.CATEGORY_ARRAY_VALUE.equals(ct)) {
                            stringValueRegular.arrValues = new ArrayList();
                            valuesArray = obj.getJSONArray("value");
                            for (index = 0; index < valuesArray.length(); index++) {
                                stringValueRegular.arrValues.add(valuesArray.getString(index));
                            }
                        } else if (Regular.CATEGORY_REGEX_VALUE.equals(ct)) {
                            stringValueRegular.regex = obj.getString("value");
                        } else {
                            svr = null;
                            DataCheckCenter.log("loadRegular the category is error.");
                        }
                    }
                    if (svr != null) {
                        this.mRegulars.add(svr);
                    }
                }
            }
            DataCheckCenter.log("end load regulars.ok");
            return true;
        } catch (Exception e) {
            DataCheckCenter.log("end load regulars.err");
            return false;
        }
    }
}
