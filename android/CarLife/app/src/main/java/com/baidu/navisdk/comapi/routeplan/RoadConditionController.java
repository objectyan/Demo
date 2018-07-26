package com.baidu.navisdk.comapi.routeplan;

import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RoadConditionController {
    private static final String CHAR_SET = "utf-8";
    public static final int DEFAULT_CITY_LIST_VERSION = 0;
    public static final int DELAY_WAIT_TIME = 5000;
    private static final int K_CITYUPDATE_TIMEOUT = 50000;
    private static final String REQ_CONNECT_SYMBOL = "&";
    private static final String ROAD_CONDITON_CITY = "RoadConditionCity.txt";
    private static final String TAG = "RoadConditionController";
    private static boolean isListPullSuccess = false;
    private static volatile RoadConditionController sInstance = null;
    public List<Integer> mCityList = new ArrayList();
    public int mCityListVersion = 0;

    public static RoadConditionController getInstance() {
        if (sInstance == null) {
            synchronized (RGViewController.class) {
                if (sInstance == null) {
                    sInstance = new RoadConditionController();
                }
            }
        }
        return sInstance;
    }

    public int getCityListVersion() {
        return this.mCityListVersion;
    }

    public void setCityListVersion(int cityListVersion) {
        this.mCityListVersion = cityListVersion;
    }

    public String getPullParams() {
        String req2 = "version=" + String.valueOf(getLocaCityListlVersion());
        StringBuffer params = new StringBuffer();
        params.append("qt=city_list");
        params.append(REQ_CONNECT_SYMBOL);
        params.append(req2);
        params.append(REQ_CONNECT_SYMBOL);
        params.append("cuid=" + PackageUtil.getCuid());
        LogUtil.m15791e(TAG, "request parm are " + params.toString());
        return params.toString().replace("|", "%124");
    }

    public List<Integer> getCityList() {
        return this.mCityList;
    }

    public void setCityList(List<Integer> cityList) {
        this.mCityList = cityList;
    }

    public void addToCityList(int cityID) {
        this.mCityList.add(Integer.valueOf(cityID));
    }

    public boolean checkRoadCondtionSupport(int cityID) {
        if (!(isListPullSuccess && getLocalFile().exists())) {
            LogUtil.m15791e(TAG, "checkRoadCondtionSupport last pull failed.");
        }
        if (!isCityListInitial()) {
            updateCityListByLocal();
        }
        LogUtil.m15791e("RoadConditonController", "dingbin " + cityID + " " + this.mCityList.toString());
        for (Integer i : this.mCityList) {
            if (i.intValue() == cityID) {
                return true;
            }
        }
        return false;
    }

    public int getLocaCityListlVersion() {
        if (this.mCityListVersion == 0) {
            updateCityListByLocal();
        }
        return this.mCityListVersion;
    }

    private File getLocalFile() {
        return new File(SysOSAPI.getInstance().GetSDCardPath() + "/" + ROAD_CONDITON_CITY);
    }

    private byte[] getLineBytes() {
        try {
            return System.getProperty("line.separator").getBytes(CHAR_SET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private void updateCityListVersion() {
        Exception e;
        Throwable th;
        File file = getLocalFile();
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            try {
                fos.write(String.valueOf(this.mCityListVersion).getBytes(CHAR_SET));
                fos.write(getLineBytes());
                for (Integer i : this.mCityList) {
                    fos.write(i.toString().getBytes(CHAR_SET));
                    fos.write(getLineBytes());
                }
                fos.flush();
                if (fos != null) {
                    try {
                        fos.close();
                        fileOutputStream = fos;
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fileOutputStream = fos;
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = fos;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fos;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    private void updateCityListByLocal() {
        Exception e;
        Throwable th;
        File file = getLocalFile();
        if (file.exists()) {
            FileReader reader = null;
            BufferedReader br = null;
            try {
                FileReader reader2 = new FileReader(file);
                try {
                    BufferedReader br2 = new BufferedReader(reader2);
                    try {
                        String versionStr = br2.readLine();
                        if (!StringUtils.isEmpty(versionStr)) {
                            this.mCityListVersion = Integer.valueOf(versionStr).intValue();
                        }
                        this.mCityList.clear();
                        while (true) {
                            String cityID = br2.readLine();
                            if (cityID == null) {
                                break;
                            } else if (!StringUtils.isEmpty(cityID)) {
                                this.mCityList.add(Integer.valueOf(Integer.parseInt(cityID)));
                            }
                        }
                        if (br2 != null) {
                            try {
                                br2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (reader2 != null) {
                            try {
                                reader2.close();
                                br = br2;
                                reader = reader2;
                                return;
                            } catch (IOException e22) {
                                e22.printStackTrace();
                                br = br2;
                                reader = reader2;
                                return;
                            }
                        }
                        reader = reader2;
                    } catch (Exception e3) {
                        e = e3;
                        br = br2;
                        reader = reader2;
                        try {
                            e.printStackTrace();
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                            if (reader == null) {
                                try {
                                    reader.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException e222222) {
                                    e222222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        br = br2;
                        reader = reader2;
                        if (br != null) {
                            br.close();
                        }
                        if (reader != null) {
                            reader.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    reader = reader2;
                    e.printStackTrace();
                    if (br != null) {
                        br.close();
                    }
                    if (reader == null) {
                        reader.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    reader = reader2;
                    if (br != null) {
                        br.close();
                    }
                    if (reader != null) {
                        reader.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (br != null) {
                    br.close();
                }
                if (reader == null) {
                    reader.close();
                }
            }
        }
    }

    private boolean isCityListInitial() {
        if (this.mCityListVersion == 0) {
            return false;
        }
        return true;
    }

    private void pullFailOperation() {
        if (!isCityListInitial()) {
            updateCityListByLocal();
        }
    }
}
