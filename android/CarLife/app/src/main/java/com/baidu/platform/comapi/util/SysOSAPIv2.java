package com.baidu.platform.comapi.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.navi.track.database.DataService;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.util.p212c.C4801a;
import com.baidu.platform.comapi.util.p212c.C4805c;
import com.baidu.platform.comapi.util.p212c.C4806d;
import com.baidu.platform.comapi.util.p212c.C4807e;
import com.baidu.platform.comapi.util.p212c.C4815i;
import com.baidu.platform.comapi.util.p212c.C4816j;
import com.baidu.platform.comapi.util.p212c.C4817k;
import com.baidu.platform.comapi.util.p212c.C4818l;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

public class SysOSAPIv2 {
    public static final String RES_ID = "01";
    /* renamed from: a */
    private static final String f12722a = "bdmap_channel";
    /* renamed from: b */
    private static final String f12723b = "bdmap_oem";
    /* renamed from: c */
    private NACommonMemCache f12724c;
    /* renamed from: d */
    private boolean f12725d;
    /* renamed from: e */
    private C4801a f12726e;
    /* renamed from: f */
    private C4807e f12727f;
    /* renamed from: g */
    private C4805c f12728g;
    /* renamed from: h */
    private C4806d f12729h;
    /* renamed from: i */
    private C4816j f12730i;
    /* renamed from: j */
    private C4815i f12731j;
    /* renamed from: k */
    private C4818l f12732k;
    /* renamed from: l */
    private String f12733l;
    /* renamed from: m */
    private String f12734m;
    /* renamed from: n */
    private String f12735n;
    /* renamed from: o */
    private String f12736o;
    /* renamed from: p */
    private String f12737p;
    /* renamed from: q */
    private String f12738q;
    /* renamed from: r */
    private String f12739r;
    /* renamed from: s */
    private String f12740s;
    /* renamed from: t */
    private String f12741t;
    /* renamed from: u */
    private String f12742u;

    public static SysOSAPIv2 getInstance() {
        return SysOSAPIv2$a.a();
    }

    private SysOSAPIv2() {
        this.f12724c = new NACommonMemCache();
        this.f12726e = new C4801a();
        this.f12727f = new C4807e();
        this.f12728g = new C4805c();
        this.f12729h = new C4806d();
        this.f12730i = new C4816j();
        this.f12731j = new C4815i();
        this.f12732k = new C4818l();
        this.f12733l = "";
        this.f12734m = "";
        this.f12735n = "";
        this.f12736o = "";
        this.f12737p = "";
        this.f12738q = "";
        this.f12739r = "";
        this.f12740s = "";
        this.f12741t = "";
        this.f12742u = "";
    }

    public void init() {
        if (!this.f12725d) {
            m11000a();
            this.f12725d = true;
        }
    }

    public void destroy() {
        this.f12724c.dispose();
        this.f12725d = false;
    }

    public String getGLRenderer() {
        return this.f12736o;
    }

    public void setGLInfo(String mGLRenderer, String mGLVersion) {
        if (mGLRenderer != null && mGLVersion != null) {
            if (!mGLRenderer.equals(this.f12736o) || !mGLVersion.equals(this.f12737p)) {
                this.f12736o = mGLRenderer;
                this.f12737p = mGLVersion;
                if (this.f12725d) {
                    this.f12724c.setKey("glv", this.f12737p);
                    this.f12724c.setKey("glr", this.f12736o);
                }
            }
        }
    }

    public String getGLVersion() {
        return this.f12737p;
    }

    public int getGPSOn() {
        return this.f12731j.a();
    }

    public int getNetOn() {
        return this.f12731j.b();
    }

    public String getNetMode() {
        return NetworkUtil.getCurrentNetMode(C2907c.m10977f());
    }

    public String getMacAddress() {
        return this.f12730i.a();
    }

    public String getSecureMacString() {
        return this.f12730i.b();
    }

    public String getCuid() {
        return this.f12728g.a();
    }

    public String getVersionName() {
        return this.f12726e.a();
    }

    public int getVersionCode() {
        return this.f12726e.b();
    }

    public int getScreenWidth() {
        return this.f12727f.a();
    }

    public int getScreenHeight() {
        return this.f12727f.b();
    }

    public float getDensity() {
        return this.f12727f.c();
    }

    public int getXDpi() {
        return this.f12727f.d();
    }

    public int getYDpi() {
        return this.f12727f.e();
    }

    public int getDensityDpi() {
        return this.f12727f.f();
    }

    public double getDpiRatio() {
        return this.f12727f.g();
    }

    public String getPhoneType() {
        return this.f12729h.b();
    }

    public String getPhoneBrand() {
        return this.f12729h.a();
    }

    public String getOSVersion() {
        return this.f12729h.c();
    }

    public String getDeviceId() {
        return this.f12729h.d();
    }

    public String getIsArt() {
        return this.f12729h.e();
    }

    public String getOperatorInfo() {
        if (TextUtils.isEmpty(this.f12740s)) {
            this.f12740s = NetworkUtil.getNetworkOperatorInfo(C2907c.m10977f());
        }
        return this.f12740s;
    }

    public String getResID() {
        return RES_ID;
    }

    public void updateNetType(String netType) {
        this.f12733l = netType;
        if (this.f12724c != null) {
            this.f12724c.setKey("net", this.f12733l);
        }
    }

    public String getOem() {
        if (TextUtils.isEmpty(this.f12735n)) {
            m10998a(C2907c.m10977f(), false);
        }
        return this.f12735n;
    }

    public void setOem(String mOem) {
        this.f12735n = mOem;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.f12734m)) {
        }
        return this.f12734m;
    }

    public String getPatchVersion() {
        if (TextUtils.isEmpty(this.f12739r)) {
            this.f12739r = C4817k.a();
        }
        return this.f12739r;
    }

    public void setChannel(String mChannel) {
        this.f12734m = mChannel;
    }

    public String getNetType() {
        if (TextUtils.isEmpty(this.f12733l)) {
            this.f12733l = NetworkUtil.getCurrentNetMode(C2907c.m10977f());
        }
        return this.f12733l;
    }

    public String getCPUProcessor() {
        return "";
    }

    public Bundle getPhoneInfoBundle() {
        Bundle b = new Bundle();
        b.putString("cuid", getCuid());
        b.putString("cpu", this.f12742u);
        b.putString("resid", getResID());
        b.putString("channel", getChannel());
        b.putString("glr", getGLRenderer());
        b.putString("glv", getGLVersion());
        b.putString("mb", getPhoneType());
        b.putString("sv", getVersionName());
        b.putString("os", getOSVersion());
        b.putString("oem", getOem());
        b.putString("net", getNetType());
        b.putString(DataService.EXTRA_BDUID, this.f12738q);
        b.putString("zid", getZid());
        b.putInt("dpi_x", getDensityDpi());
        b.putInt("dpi_y", getDensityDpi());
        b.putString("phonebrand", getPhoneBrand());
        b.putString("patchver", getPatchVersion());
        b.putString("isart", getIsArt());
        b.putString("co", getOperatorInfo());
        return b;
    }

    public JsonBuilder buildPhoneinfoJSON() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.putStringValue("cuid", getCuid());
        jsonBuilder.putStringValue("cpu", this.f12742u);
        jsonBuilder.putStringValue("resid", getResID());
        jsonBuilder.putStringValue("channel", getChannel());
        jsonBuilder.putStringValue("glr", getGLRenderer());
        jsonBuilder.putStringValue("glv", getGLVersion());
        jsonBuilder.putStringValue("mb", getPhoneType());
        jsonBuilder.putStringValue("sv", getVersionName());
        jsonBuilder.putStringValue("os", getOSVersion());
        jsonBuilder.putStringValue("oem", getOem());
        jsonBuilder.putStringValue("net", getNetType());
        jsonBuilder.putStringValue(DataService.EXTRA_BDUID, this.f12738q);
        jsonBuilder.putStringValue("zid", getZid());
        jsonBuilder.putStringValue("phonebrand", getPhoneBrand());
        jsonBuilder.putStringValue("patchver", getPatchVersion());
        jsonBuilder.putStringValue("isart", getIsArt());
        jsonBuilder.key("dpi_x").value(getDensityDpi());
        jsonBuilder.key("dpi_y").value(getDensityDpi());
        jsonBuilder.key("co").value(getOperatorInfo());
        jsonBuilder.endObject();
        return jsonBuilder;
    }

    public String getSataInfo(boolean bValidLocation, Point pt) {
        if (this.f12724c == null) {
            return null;
        }
        if (!bValidLocation) {
            return this.f12724c.getSataInfo(bValidLocation, -1, -1);
        }
        if (pt != null) {
            return this.f12724c.getSataInfo(bValidLocation, pt.getIntX(), pt.getIntY());
        }
        return null;
    }

    public String getPhoneInfoUrl() {
        C2911f.m11015b("PhoneInfoUrl", this.f12724c.getPhoneInfoUrl());
        return this.f12724c.getPhoneInfoUrl();
    }

    public Bundle getNativePhoneInfoBundle(boolean isUrlEncode) {
        return this.f12724c.getPhoneInfoBundle(isUrlEncode);
    }

    /* renamed from: a */
    private void m11000a() {
        Context context = C2907c.m10977f();
        JsonBuilder builder = new JsonBuilder();
        String cuid = getCuid();
        String resID = RES_ID;
        String channel = getChannel();
        String phoneType = getPhoneType();
        String versionName = "10.1.0";
        String osVersion = getOSVersion();
        int densityDpi = getDensityDpi();
        builder.object();
        builder.putStringValue("cuid", cuid);
        builder.putStringValue("cpu", this.f12742u);
        builder.putStringValue("resid", resID);
        builder.putStringValue("channel", channel);
        builder.putStringValue("glr", this.f12736o);
        builder.putStringValue("glv", this.f12737p);
        builder.putStringValue("mb", phoneType);
        builder.putStringValue("sv", versionName);
        builder.putStringValue("os", osVersion);
        builder.putStringValue("oem", getOem());
        builder.key("dpi_x").value(densityDpi);
        builder.key("dpi_y").value(densityDpi);
        builder.putStringValue(DataService.EXTRA_BDUID, this.f12738q);
        builder.putStringValue("net", this.f12733l);
        builder.putStringValue("zid", getZid());
        builder.putStringValue("phonebrand", getPhoneBrand());
        builder.putStringValue("patchver", getPatchVersion());
        builder.putStringValue("isart", getIsArt());
        builder.putStringValue("co", getOperatorInfo());
        builder.endObject();
        this.f12724c.init(builder.getJson());
        builder.reset();
        builder.object();
        builder.putStringValue("pd", "map");
        builder.putStringValue("ov", osVersion);
        builder.putStringValue("ver", "2");
        builder.key("sw").value(getScreenWidth());
        builder.key("sh").value(getScreenHeight());
        builder.putStringValue("channel", channel);
        builder.putStringValue("mb", phoneType);
        builder.putStringValue("sv", versionName);
        builder.putStringValue("os", "android");
        builder.putStringValue("cuid", cuid);
        builder.putStringValue("path", getOutputDirPath() + "/udc/");
        builder.endObject();
        this.f12724c.setKeyJSON("logstatistics", builder.getJson());
        builder.reset();
        builder.object();
        builder.putStringValue("cuid", cuid);
        builder.putStringValue("app", "1");
        builder.putStringValue("path", C2907c.m10977f().getCacheDir().getAbsolutePath() + "/");
        builder.putStringValue("domain", "");
        builder.endObject();
        this.f12724c.setKeyJSON("longlink", builder.getJson());
    }

    public String getOutputDirPath() {
        return this.f12732k.a();
    }

    public String getSdcardPath() {
        return this.f12732k.b();
    }

    public void setSdcardPath(String sdcardPath) {
        this.f12732k.a(sdcardPath);
    }

    public void setSdcardDataPath(String sdcardDataPath) {
        this.f12732k.b(sdcardDataPath);
    }

    public String getSdcardDataPath() {
        return this.f12732k.c();
    }

    public String getOutputCache() {
        return this.f12732k.d();
    }

    public void setOutputCache(String outputCache) {
        this.f12732k.c(outputCache);
    }

    public String getOutputSecondCache() {
        return this.f12732k.e();
    }

    public void setOutputSecondCache(String outputSecondCache) {
        this.f12732k.d(outputSecondCache);
    }

    /* renamed from: b */
    private boolean m11002b() {
        String channel = m11004d();
        if (channel == null || TextUtils.isEmpty(channel)) {
            return false;
        }
        this.f12734m = channel;
        return true;
    }

    /* renamed from: c */
    private boolean m11003c() {
        String channel = m10999a(m11005e(), true);
        if (channel == null || TextUtils.isEmpty(channel)) {
            return false;
        }
        this.f12734m = channel;
        return true;
    }

    public boolean setChl(String json) {
        if (json == null || TextUtils.isEmpty(json)) {
            return false;
        }
        try {
            String channel = (String) new JSONObject(json).get("channel");
            if (channel == null || TextUtils.isEmpty(channel)) {
                return false;
            }
            this.f12734m = channel.trim();
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    private String m11004d() {
        Throwable th;
        File channelFile = new File("/system/etc/", "channel");
        String channel = "";
        if (channelFile.exists()) {
            FileInputStream in = null;
            try {
                FileInputStream in2 = new FileInputStream(channelFile);
                try {
                    byte[] b = new byte[in2.available()];
                    in2.read(b);
                    channel = new String(b).trim();
                    if (in2 != null) {
                        try {
                            in2.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    in = in2;
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e3) {
                        }
                    }
                    return channel;
                } catch (Throwable th2) {
                    th = th2;
                    in = in2;
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (in != null) {
                    in.close();
                }
                return channel;
            } catch (Throwable th3) {
                th = th3;
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        }
        return channel;
    }

    /* renamed from: a */
    private void m11001a(String outputDirPath) {
        File file;
        Throwable th;
        Context context = C2907c.m10977f();
        BufferedWriter bw = null;
        try {
            File fres = new File(outputDirPath + "/channel_oem");
            try {
                if (fres.createNewFile()) {
                    BufferedWriter bw2 = new BufferedWriter(new FileWriter(fres));
                    try {
                        bw2.write("bdmap_channel:" + m10998a(context, true));
                        bw2.newLine();
                        bw2.write("bdmap_oem:" + m10998a(context, false));
                        bw2.close();
                        bw = bw2;
                    } catch (IOException e) {
                        bw = bw2;
                        file = fres;
                        if (bw == null) {
                            try {
                                bw.close();
                            } catch (IOException e2) {
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bw = bw2;
                        file = fres;
                        if (bw != null) {
                            try {
                                bw.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                }
                m10998a(context, true);
                m10998a(context, false);
                if (bw != null) {
                    try {
                        bw.close();
                        file = fres;
                        return;
                    } catch (IOException e4) {
                        file = fres;
                        return;
                    }
                }
            } catch (IOException e5) {
                file = fres;
                if (bw == null) {
                    bw.close();
                }
            } catch (Throwable th3) {
                th = th3;
                file = fres;
                if (bw != null) {
                    bw.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            if (bw == null) {
                bw.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (bw != null) {
                bw.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private String m10999a(String outputDirPath, boolean isChannel) {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        String channel = "";
        String oem = "";
        BufferedReader br = null;
        String filePath = outputDirPath + File.separator + "channel_oem";
        if (new File(filePath).exists()) {
            try {
                BufferedReader br2 = new BufferedReader(new FileReader(filePath));
                while (true) {
                    try {
                        String sCurrentLine = br2.readLine();
                        if (sCurrentLine == null) {
                            break;
                        }
                        int indexOff = sCurrentLine.indexOf(Config.TRACE_TODAY_VISIT_SPLIT);
                        String key = "";
                        String content = "";
                        if (sCurrentLine.length() >= indexOff) {
                            key = sCurrentLine.substring(0, indexOff);
                        }
                        if (sCurrentLine.length() >= indexOff + 1) {
                            content = sCurrentLine.substring(indexOff + 1);
                        }
                        if (f12722a.equals(key)) {
                            channel = content;
                        } else if (f12723b.equals(key)) {
                            oem = content;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        br = br2;
                    } catch (IOException e4) {
                        e2 = e4;
                        br = br2;
                    } catch (Throwable th2) {
                        th = th2;
                        br = br2;
                    }
                }
                if (br2 != null) {
                    try {
                        br2.close();
                    } catch (IOException ex) {
                        C2911f.m11015b("SysOSAPIv2", "getChannelInfoFromExternal IOException in finally:" + ex.getMessage());
                        br = br2;
                    }
                }
                br = br2;
            } catch (FileNotFoundException e5) {
                e = e5;
                try {
                    C2911f.m11015b("SysOSAPIv2", "getChannelInfoFromExternal FileNotFoundException:" + e.getMessage());
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException ex2) {
                            C2911f.m11015b("SysOSAPIv2", "getChannelInfoFromExternal IOException in finally:" + ex2.getMessage());
                        }
                    }
                    if (isChannel) {
                        return oem;
                    }
                    return channel;
                } catch (Throwable th3) {
                    th = th3;
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException ex22) {
                            C2911f.m11015b("SysOSAPIv2", "getChannelInfoFromExternal IOException in finally:" + ex22.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                C2911f.m11015b("SysOSAPIv2", "getChannelInfoFromExternal IOException:" + e2.getMessage());
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ex222) {
                        C2911f.m11015b("SysOSAPIv2", "getChannelInfoFromExternal IOException in finally:" + ex222.getMessage());
                    }
                }
                if (isChannel) {
                    return channel;
                }
                return oem;
            }
        }
        if (isChannel) {
            return channel;
        }
        return oem;
    }

    /* renamed from: e */
    private String m11005e() {
        String outputDirPath = getOutputDirPath();
        File fout = new File(outputDirPath);
        if (!fout.exists()) {
            fout.mkdirs();
        }
        return outputDirPath;
    }

    /* renamed from: a */
    private String m10998a(Context context, boolean channelOrOem) {
        String str;
        AssetManager am = context.getAssets();
        BufferedInputStream is = null;
        BufferedReader br = null;
        String content = "";
        if (channelOrOem) {
            try {
                is = new BufferedInputStream(am.open("channel"));
            } catch (IOException e) {
                try {
                    str = "";
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e2) {
                            return str;
                        }
                    }
                    if (br == null) {
                        return str;
                    }
                    br.close();
                    return str;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e3) {
                            throw th2;
                        }
                    }
                    if (br != null) {
                        br.close();
                    }
                    throw th2;
                }
            }
        }
        is = new BufferedInputStream(am.open("oem"));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String content2 = content;
        while (true) {
            try {
                String sCurrentLine = br2.readLine();
                if (sCurrentLine == null) {
                    break;
                }
                content2 = content2 + sCurrentLine;
            } catch (IOException e4) {
                content = content2;
                br = br2;
            } catch (Throwable th3) {
                th2 = th3;
                content = content2;
                br = br2;
            }
        }
        if (channelOrOem) {
            this.f12734m = content2;
            content = content2;
        } else {
            this.f12735n = content2;
            content = content2;
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e5) {
            }
        }
        if (br2 != null) {
            br2.close();
        }
        br = br2;
        str = content;
        return str;
    }

    public void updateCuid() {
        if (this.f12724c != null) {
            this.f12728g.b();
            this.f12724c.setKey("cuid", getCuid());
        }
    }

    public void updateBduid(String bduid) {
        this.f12738q = bduid;
        if (this.f12724c != null) {
            this.f12724c.setKey(DataService.EXTRA_BDUID, this.f12738q);
        }
    }

    public String getZid() {
        return this.f12741t;
    }

    public void setZid(String zid) {
        this.f12741t = zid;
        if (this.f12724c != null) {
            this.f12724c.setKey("zid", this.f12741t);
        }
    }

    public String decodeUsyncString(String param) {
        if (this.f12724c != null) {
            return this.f12724c.decodeUsync(param);
        }
        return "";
    }

    public String enCrypt(String bduid, String type) {
        if (this.f12724c != null) {
            return this.f12724c.enCrypt(bduid, type);
        }
        return null;
    }

    public void updateSinan(String sinan) {
        if (this.f12724c != null) {
            this.f12724c.setKey("sinan", sinan);
        }
    }

    public void updateMarket(String market) {
        if (this.f12724c != null) {
            this.f12724c.setKey("market", market);
        }
    }

    public void setCpuName(String cpuName) {
        this.f12742u = cpuName;
        if (this.f12724c != null) {
            this.f12724c.setKey("cpu", this.f12742u);
        }
    }

    public Boolean checkExistsOfflineData(String sdcardPath) {
        boolean z = false;
        File file = new File(sdcardPath + "/BaiduCarlife/bnav/vmp/h");
        if (!file.isDirectory()) {
            return Boolean.valueOf(false);
        }
        String[] files = file.list(new SysOSAPIv2$1(this));
        if (files != null && files.length > 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
