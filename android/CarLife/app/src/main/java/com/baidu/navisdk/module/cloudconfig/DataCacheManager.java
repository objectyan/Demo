package com.baidu.navisdk.module.cloudconfig;

import android.net.http.Headers;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class DataCacheManager {
    private static final String TAG = DataCacheManager.class.getName();
    private static String fileCloudConfigCachePath = (SysOSAPI.getInstance().GetSDCardCachePath() + File.separator + "initConfig9_7_5");
    private JSONObject mCacheJSONObject = null;

    private File getConfigFile() {
        File file = new File(fileCloudConfigCachePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                LogUtil.m15791e(TAG, e.toString());
            }
        }
        return file;
    }

    private boolean isCecheConfigExists() {
        return new File(fileCloudConfigCachePath).exists();
    }

    public String getEtag() {
        JSONObject mJSONObject = getJSonObjectFromFile();
        if (mJSONObject == null) {
            clearFileCache();
            return "";
        }
        try {
            String eTagStr = mJSONObject.getJSONObject("data").getString(Headers.ETAG);
            if (eTagStr != null) {
                this.mCacheJSONObject = mJSONObject;
                return eTagStr;
            }
            clearFileCache();
            return "";
        } catch (Exception e) {
            clearFileCache();
            return "";
        }
    }

    public void clearFileCache() {
        Exception e;
        Throwable th;
        File file = new File(fileCloudConfigCachePath);
        if (file.exists()) {
            FileWriter fw = null;
            try {
                FileWriter fw2 = new FileWriter(file);
                try {
                    fw2.write("");
                    fw2.close();
                    if (fw2 != null) {
                        try {
                            fw2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fw = fw2;
                    try {
                        e.printStackTrace();
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fw = fw2;
                    if (fw != null) {
                        fw.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (fw != null) {
                    fw.close();
                }
            }
        }
    }

    public void saveJSonObjectToFile(JSONObject mJSONObject) {
        Exception e;
        Throwable th;
        String contentStr = mJSONObject.toString();
        File file = getConfigFile();
        if (file.exists()) {
            FileWriter fw = null;
            try {
                FileWriter fw2 = new FileWriter(file);
                try {
                    fw2.write(contentStr);
                    fw2.close();
                    if (fw2 != null) {
                        try {
                            fw2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fw = fw2;
                    try {
                        e.printStackTrace();
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fw = fw2;
                    if (fw != null) {
                        fw.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (fw != null) {
                    fw.close();
                }
            }
        }
    }

    public JSONObject getJSonObjectFromFile() {
        Exception e;
        Throwable th;
        if (this.mCacheJSONObject != null) {
            return this.mCacheJSONObject;
        }
        if (!isCecheConfigExists()) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        char[] tempchars = new char[1024];
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(getConfigFile()));
            while (true) {
                try {
                    int charread = reader.read(tempchars);
                    if (charread == -1) {
                        break;
                    }
                    sb.append(tempchars, 0, charread);
                } catch (Exception e2) {
                    e = e2;
                    inputStreamReader = reader;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = reader;
                }
            }
            JSONObject mJSONObject = new JSONObject(sb.toString());
            if (reader != null) {
                try {
                    reader.close();
                    inputStreamReader = reader;
                    return mJSONObject;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    inputStreamReader = reader;
                    return mJSONObject;
                }
            }
            return mJSONObject;
        } catch (Exception e4) {
            e = e4;
            try {
                LogUtil.m15791e(TAG, e.toString());
                if (inputStreamReader == null) {
                    return null;
                }
                try {
                    inputStreamReader.close();
                    return null;
                } catch (IOException e32) {
                    e32.printStackTrace();
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e322) {
                        e322.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public void destroy() {
        this.mCacheJSONObject = null;
    }
}
