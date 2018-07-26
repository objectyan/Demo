package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;

public abstract class Regular {
    public static final String ATTR_KEY_ATTR = "attr";
    public static final String ATTR_KEY_CATEGORY = "category";
    public static final String ATTR_KEY_FREQUENCY = "freq";
    public static final String ATTR_KEY_ID = "id";
    public static final String ATTR_KEY_NAME = "name";
    public static final String ATTR_KEY_SUMMATION = "summation";
    public static final String ATTR_KEY_TYPE = "type";
    public static final String ATTR_KEY_VALUE = "value";
    public static final String CATEGORY_AREA_VALUE = "area";
    public static final String CATEGORY_ARRAY_VALUE = "arr";
    public static final String CATEGORY_FIX_VALUE = "f";
    public static final String CATEGORY_REGEX_VALUE = "regex";
    public static final String CATEGORY_VARIABLE_VALUE = "v";
    public static final double DOUBLE_AREA_INVALID_VALUE = 8888.0d;
    public static final int INT_AREA_INVALID_VALUE = 8888;
    public static final long LONG_AREA_INVALID_VALUE = 8888;
    public static final String STRING_AREA_INVALID_VALUE = "null";
    public static final String TYPE_DOUBLE = "double";
    public static final String TYPE_INT = "int";
    public static final String TYPE_LONG = "long";
    public static final String TYPE_STRING = "string";
    protected String category = null;
    protected GeneralRegularData mGeneralRegularData = null;
    protected String name = null;
    protected String type = null;

    public abstract boolean check();

    public Regular(GeneralRegularData regularData, String n, String c, String t) {
        this.mGeneralRegularData = regularData;
        this.name = n;
        this.category = c;
        this.type = t;
    }
}
