package com.baidu.platform.comapi.util;

import com.baidu.mobstat.Config;
import org.json.JSONObject;

public class JsonBuilder {
    /* renamed from: a */
    private StringBuilder f19870a = new StringBuilder();
    /* renamed from: b */
    private boolean f19871b = false;

    public void reset() {
        this.f19870a.setLength(0);
        this.f19871b = false;
    }

    public JsonBuilder object() {
        m15876a();
        this.f19870a.append("{");
        m15877b();
        return this;
    }

    public JsonBuilder endObject() {
        this.f19870a.append("}");
        m15878c();
        return this;
    }

    public JsonBuilder putStringValue(String key, String value) {
        if (value != null) {
            key(key).value(value);
        }
        return this;
    }

    public JsonBuilder putObjectValue(String key, String value) {
        if (value != null) {
            key(key).objectValue(value);
        }
        return this;
    }

    public JsonBuilder key(String key) {
        m15876a();
        this.f19870a.append(JSONObject.quote(key));
        this.f19870a.append(Config.TRACE_TODAY_VISIT_SPLIT);
        m15877b();
        return this;
    }

    public JsonBuilder value(boolean value) {
        m15876a();
        this.f19870a.append(value);
        m15878c();
        return this;
    }

    public JsonBuilder value(int value) {
        m15876a();
        this.f19870a.append(value);
        m15878c();
        return this;
    }

    public JsonBuilder value(long value) {
        m15876a();
        this.f19870a.append(value);
        m15878c();
        return this;
    }

    public JsonBuilder value(double value) {
        m15876a();
        this.f19870a.append(String.format("%f", new Object[]{Double.valueOf(value)}));
        m15878c();
        return this;
    }

    public JsonBuilder value(String value) {
        m15876a();
        this.f19870a.append(JSONObject.quote(value));
        m15878c();
        return this;
    }

    public JsonBuilder value(Object value) {
        if (value instanceof Number) {
            Number num = (Number) value;
            if (value instanceof Byte) {
                return value(num.byteValue());
            }
            if (value instanceof Short) {
                return value(num.shortValue());
            }
            if (value instanceof Integer) {
                return value(num.intValue());
            }
            if (value instanceof Long) {
                return value(num.longValue());
            }
            if (value instanceof Float) {
                return value((double) num.floatValue());
            }
            if (value instanceof Double) {
                return value(num.doubleValue());
            }
        }
        return value(value.toString());
    }

    public JsonBuilder objectValue(String value) {
        m15876a();
        this.f19870a.append(value);
        m15878c();
        return this;
    }

    public JsonBuilder arrayValue() {
        m15876a();
        this.f19870a.append("[");
        m15877b();
        return this;
    }

    public JsonBuilder endArrayValue() {
        this.f19870a.append("]");
        m15878c();
        return this;
    }

    /* renamed from: a */
    private void m15876a() {
        if (this.f19871b) {
            this.f19870a.append(",");
        }
    }

    /* renamed from: b */
    private void m15877b() {
        this.f19871b = false;
    }

    /* renamed from: c */
    private void m15878c() {
        this.f19871b = true;
    }

    public String getJson() {
        return this.f19870a.toString();
    }

    public String toString() {
        return getJson();
    }
}
