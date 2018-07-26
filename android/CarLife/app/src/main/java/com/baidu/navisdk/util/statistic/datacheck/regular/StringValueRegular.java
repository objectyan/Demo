package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class StringValueRegular extends Regular {
    /* renamed from: a */
    public String f19722a = null;
    public List<String> arrValues = null;
    /* renamed from: b */
    public String f19723b = null;
    public String fixValue = null;
    private Pattern pattern = null;
    public String regex = null;

    public StringValueRegular(GeneralRegularData regularData, String n, String c, String t) {
        super(regularData, n, c, t);
    }

    public boolean check() {
        if (this.mGeneralRegularData != null && this.mGeneralRegularData.getDataBundle() != null && !this.mGeneralRegularData.getDataBundle().containsKey(this.name)) {
            return true;
        }
        String actualValue = null;
        boolean ret = false;
        if (!(this.mGeneralRegularData == null || this.mGeneralRegularData.getDataBundle() == null || !this.mGeneralRegularData.getDataBundle().containsKey(this.name))) {
            actualValue = this.mGeneralRegularData.getDataBundle().getString(this.name);
            if (Regular.CATEGORY_FIX_VALUE.equals(this.category) && this.fixValue != null && this.fixValue.equals(actualValue)) {
                ret = true;
            } else if ("v".equals(this.category)) {
                ret = true;
            } else if (Regular.CATEGORY_ARRAY_VALUE.equals(this.category)) {
                ret = this.arrValues != null && this.arrValues.contains(actualValue);
            } else if (Regular.CATEGORY_AREA_VALUE.equals(this.category)) {
                if (this.f19722a != null && this.f19723b != null) {
                    ret = actualValue.compareTo(this.f19722a) > 0 && actualValue.compareTo(this.f19723b) < 0;
                } else if (this.f19722a != null && this.f19723b == null) {
                    ret = actualValue.compareTo(this.f19722a) > 0;
                } else if (this.f19722a == null && this.f19723b != null) {
                    ret = actualValue.compareTo(this.f19723b) < 0;
                }
            } else if (Regular.CATEGORY_REGEX_VALUE.equals(this.category)) {
                if (this.pattern == null && this.regex != null && this.regex.length() > 0) {
                    this.pattern = Pattern.compile(this.regex);
                }
                if (this.pattern != null) {
                    try {
                        ret = this.pattern.matcher(actualValue).matches();
                    } catch (Exception e) {
                        ret = false;
                    }
                }
            }
        }
        if (!ret) {
            String tmpregularValue = "-";
            String msg = "[error][name:" + this.name + "][category:" + this.category + "][type:" + this.type + "][regularValue:";
            if (Regular.CATEGORY_FIX_VALUE.equals(this.category)) {
                msg = msg + this.fixValue;
                tmpregularValue = "" + this.fixValue;
            } else if (!"v".equals(this.category)) {
                if (Regular.CATEGORY_ARRAY_VALUE.equals(this.category)) {
                    msg = msg + this.arrValues;
                    tmpregularValue = this.arrValues.toString();
                } else if (Regular.CATEGORY_AREA_VALUE.equals(this.category)) {
                    msg = msg + this.f19722a + "," + this.f19723b;
                    tmpregularValue = this.f19722a + "," + this.f19723b;
                } else if (Regular.CATEGORY_REGEX_VALUE.equals(this.category)) {
                    msg = msg + this.regex;
                    tmpregularValue = this.regex;
                }
            }
            this.mGeneralRegularData.addErrorInfo(msg + "][actualvalue:" + actualValue + "]");
            this.mGeneralRegularData.addToastErrorInfo(this.name, "" + actualValue);
            try {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("name", this.name);
                jsonObj.put(Regular.ATTR_KEY_CATEGORY, this.category);
                jsonObj.put("type", this.type);
                jsonObj.put("regularValue", tmpregularValue);
                jsonObj.put("actualvalue", "" + actualValue);
                DataCheckHelper.sUpJsonArr.put(jsonObj);
            } catch (JSONException e2) {
            }
        }
        return ret;
    }
}
