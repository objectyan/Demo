package com.baidu.navisdk.module.cloudconfig;

public class CloudlConfigDataModel {
    private static volatile CloudlConfigDataModel instance = null;
    public boolean isWebDataValid;
    public CommonConfig mCommonConfig;
    public MultiRoadConfig mMultiRoadConfig;
    public RequestBaseDataConfig mRequestBaseDataConfig;

    public static class CommonConfig {
        public String abroadVoice = null;
        public boolean colladaComponentDownload = true;
        public boolean colladaComponentInit = true;
        public int colladaFlag = -1;
        public boolean coreLogRecord = true;
        public String engineStr = null;
        public boolean foregroundService = false;
        public int guidecaseFlag = -1;
        public boolean httpsControl = true;
        public boolean isCarNaviRecording = false;
        public boolean isEyespyPagerOpen = false;
        public boolean isWifiDownload = true;
        public boolean isXmlyOpen = false;
        public String mCastrolYellowIconURL = null;
        public String mCastrolYellowText = null;
        public String mixVoiceIds = null;
        public String safetyIpoIcon = null;
        public String safetyNavIcon = null;
        public String safetyNavNightIcon = null;
        public String safetyNavingIcon = null;
        public boolean safetyNavingShow = false;
        public boolean safetyShow = false;
        public String safetyText = "迎团圆";
        public String switchTips = null;
        public int xdVoice = 0;
    }

    public static class MultiRoadConfig {
        private int cardShowTime = 20;
        private int lastMile = -1;
        private boolean multiRoadOpenFlag = false;
        private int[] tagDiatanceArr = null;

        public boolean isMultiRoadOpen() {
            return this.multiRoadOpenFlag;
        }

        public int[] getTagDistance() {
            return this.tagDiatanceArr;
        }

        public int getCardShowTime() {
            return this.cardShowTime;
        }

        public int getLastMile() {
            return this.lastMile;
        }

        public MultiRoadConfig(boolean flag, int[] tagDiatanceArr, int showTime, int lastmile) {
            this.tagDiatanceArr = tagDiatanceArr;
            this.multiRoadOpenFlag = flag;
            this.cardShowTime = showTime;
            this.lastMile = lastmile;
        }

        public void destroy() {
            if (CloudlConfigDataModel.instance != null) {
                CloudlConfigDataModel.instance.mMultiRoadConfig = null;
                CloudlConfigDataModel.instance.destroy(false);
            }
        }
    }

    public static class RequestBaseDataConfig {
        private String etag = null;
        private long serReqTime = 0;

        public String getEtag() {
            return this.etag;
        }

        public long getSerReqTime() {
            return this.serReqTime;
        }

        public void destroy() {
            if (CloudlConfigDataModel.instance != null) {
                CloudlConfigDataModel.instance.mRequestBaseDataConfig = null;
                CloudlConfigDataModel.instance.destroy(false);
            }
        }

        public RequestBaseDataConfig(String etag, long serReqTime) {
            this.etag = etag;
            this.serReqTime = serReqTime;
        }
    }

    private CloudlConfigDataModel() {
        this.mMultiRoadConfig = null;
        this.mRequestBaseDataConfig = null;
        this.mCommonConfig = null;
        this.isWebDataValid = false;
        this.mCommonConfig = new CommonConfig();
    }

    public static CloudlConfigDataModel getInstance() {
        if (instance == null) {
            synchronized (CloudlConfigDataModel.class) {
                if (instance == null) {
                    instance = new CloudlConfigDataModel();
                }
            }
        }
        return instance;
    }

    public void destroy(boolean forceDestroy) {
        if (forceDestroy) {
            instance = null;
        } else if (this.mMultiRoadConfig == null && this.mRequestBaseDataConfig == null) {
            instance = null;
        }
    }
}
