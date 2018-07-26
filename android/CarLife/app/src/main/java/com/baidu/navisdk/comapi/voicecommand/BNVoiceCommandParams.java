package com.baidu.navisdk.comapi.voicecommand;

import android.os.Bundle;

public class BNVoiceCommandParams {
    public static final String Key_Bundle_VC_Sub_Type = "Key_Bundle_VC_Sub_Type";
    public static final String Key_Bundle_VC_Top_Type = "Key_Bundle_VC_Top_Type";
    public static final String Key_VoiceASR_Cur_POI_Info = "curpoiinfo";
    public static final String Key_VoiceASR_Guidance_Info = "guidanceinfo";
    public static final String Key_VoiceASR_POIKey_Param = "poiname";
    public static final String Key_VoiceASR_Weather_Info = "weatherinfo";
    public static final int MSG_VC_Reponse_Timeout = 100;
    public static final int VC_Response_Timeout = 90000;

    public interface VoiceAPPStatus {
        public static final int Active = 1;
        public static final int BackGround = 3;
        public static final int Calling = 2;
        public static final int Invalid = 0;
        public static final int ResignActive = 4;
    }

    public interface VoiceCommandKey {
        public static final String POIActionType = "POIActionType";
        public static final String actionStatus = "actionStatus";
        public static final String extraStr = "extraStr";
        public static final String pageActionType = "pageActionType";
        public static final String regStatus = "regStatus";
        public static final String targetType = "targetType";
        public static final String uIActionType = "UIActionType";
    }

    public interface VoiceGuidanceAction {
        public static final int CurCarSpeed = 6;
        public static final int CurRoadSpeed = 7;
        public static final int EDog = 9;
        public static final int Invalid = 0;
        public static final int MapDirection = 1;
        public static final int MyLoc = 2;
        public static final int NextGuidance = 5;
        public static final int RemainDist = 3;
        public static final int RemainTime = 4;
        public static final int RoadCondation = 8;
        public static final int SpeakAgain = 10;
    }

    public interface VoicePOIAction {
        public static final int Home = 5;
        public static final int Invalid = 0;
        public static final int Office = 6;
        public static final int Route = 2;
        public static final int SeachChx = 1;
        public static final int SearchAround = 4;
        public static final int SearchName = 3;
    }

    public interface VoicePageAction {
        public static final int Back = 1;
        public static final int Choose = 3;
        public static final int Invalid = 0;
        public static final int Jump = 2;
        public static final int StartNavi = 4;
    }

    public interface VoiceRecorderStatus {
        public static final int Allow = 1;
        public static final int Invalid = 0;
        public static final int NoAllowUser = 2;
        public static final int NoVoice = 3;
        public static final int PhoneNoSupport = 4;
    }

    public static class VoiceRegActionFinishResult {
        public int actionStatus;
        public Bundle extras;
        public int regStatus;
    }

    public interface VoiceRegActionRet {
        public static final int FinishFail = 2;
        public static final int FinishSuccess = 1;
        public static final int Invalid = 0;
        public static final int NoHomePoi = 5;
        public static final int NoOffPoi = 6;
        public static final int NoPOI = 7;
        public static final int NoSupport = 3;
        public static final int OrgIsEqualCur = 4;
        public static final int Searching = 8;
    }

    public interface VoiceRegDeviceLevel {
        public static final int High = 4;
        public static final int Invalid = 0;
        public static final int Low = 2;
        public static final int Lowest = 1;
        public static final int Normal = 3;
    }

    public interface VoiceRegError {
        public static final int CommandError = 4;
        public static final int DecodeError = 5;
        public static final int INVALID = 0;
        public static final int NetError = 6;
        public static final int NoData = 1;
        public static final int None = 2;
        public static final int TimeOut = 3;
    }

    public interface VoiceRegMode {
        public static final int GUIDANCE = 4;
        public static final int INVALID = 0;
        public static final int None = 1;
        public static final int PAGE = 3;
        public static final int SEARCH = 5;
        public static final int UI = 2;
    }

    public interface VoiceRegNetMode {
        public static final int Invalid = 0;
        public static final int Offline = 2;
        public static final int OfflinePriority = 4;
        public static final int Online = 1;
        public static final int OnlinePriority = 3;
    }

    public static class VoiceRegResult {
        public int guidanceActionType;
        public int pageActionType;
        public int poiActionType;
        public int regStatus;
        public int targetType;
        public int uiActionType;

        public String toString() {
            return "regStatus=" + this.regStatus + ", uiActionType=" + this.uiActionType + ", pageActionType=" + this.pageActionType + ", poiActionType=" + this.poiActionType + ", guidanceActionType=" + this.guidanceActionType + ", targetType=" + this.targetType;
        }
    }

    public interface VoiceRegRet {
        public static final int Fail = 1;
        public static final int Invalid = 0;
        public static final int Success = 2;
    }

    public interface VoiceStatusParams {
        public static final int BeginDecode = 1;
        public static final int DecodeFail = 3;
        public static final int DecodeSuccess = 2;
        public static final int WakeUping = 0;
    }

    public interface VoiceTarget {
        public static final int CarLive = 13;
        public static final int Custom = 2;
        public static final int DataDown = 11;
        public static final int EDog = 16;
        public static final int Favorite = 15;
        public static final int Home = 3;
        public static final int IWillGo = 20;
        public static final int IllegalQuery = 7;
        public static final int Index1 = 21;
        public static final int Index10 = 30;
        public static final int Index2 = 22;
        public static final int Index3 = 23;
        public static final int Index4 = 24;
        public static final int Index5 = 25;
        public static final int Index6 = 26;
        public static final int Index7 = 27;
        public static final int Index8 = 28;
        public static final int Index9 = 29;
        public static final int Invalid = 0;
        public static final int Map = 19;
        public static final int NO = 18;
        public static final int None = 1;
        public static final int Office = 4;
        public static final int PersonCenter = 12;
        public static final int Route1 = 31;
        public static final int Route2 = 32;
        public static final int Route3 = 33;
        public static final int RouteDetail = 5;
        public static final int RoutePlan = 10;
        public static final int Setting = 14;
        public static final int Tachograph = 6;
        public static final int Taxi = 9;
        public static final int TirePressureTest = 8;
        public static final int YES = 17;
    }

    public interface VoiceUIAction {
        public static final int AR = 26;
        public static final int AutomaticMode = 51;
        public static final int ByeBye = 45;
        public static final int Calling = 1;
        public static final int CarFront = 30;
        public static final int ChooseAndStartNavi = 66;
        public static final int ChooseIndex = 67;
        public static final int ChxDayMode = 32;
        public static final int ChxNightMode = 31;
        public static final int CloseEDogSpeak = 47;
        public static final int CloseOverSpeedSpeak = 63;
        public static final int CloseRoadCondation = 8;
        public static final int CloseRoadCondationSpeak = 61;
        public static final int CloseSafeDriveSpeak = 49;
        public static final int CloseScreenConstant = 55;
        public static final int CloseSpeed = 15;
        public static final int CloseStraightSpeak = 13;
        public static final int Compass = 19;
        public static final int DriveMode = 52;
        public static final int ExitApp = 39;
        public static final int ExitNavi = 38;
        public static final int FullView = 16;
        public static final int HUDMirror = 27;
        public static final int HUDText = 28;
        public static final int Help = 43;
        public static final int Invalid = 0;
        public static final int Limitline = 42;
        public static final int LockPhone = 44;
        public static final int Longwinded = 35;
        public static final int MapMode = 53;
        public static final int MoreThanWords = 36;
        public static final int MoveDown = 23;
        public static final int MoveLeft = 20;
        public static final int MoveRight = 21;
        public static final int MoveUp = 22;
        public static final int MyLoc = 18;
        public static final int NaviMode = 25;
        public static final int NewerMode = 33;
        public static final int NoVoice = 6;
        public static final int NoVoiceMode = 11;
        public static final int North = 29;
        public static final int OlderMode = 34;
        public static final int OpenEDogSpeak = 46;
        public static final int OpenOverSpeedSpeak = 62;
        public static final int OpenRoadCondation = 7;
        public static final int OpenRoadCondationSpeak = 60;
        public static final int OpenSafeDriveSpeak = 48;
        public static final int OpenScreenConstant = 54;
        public static final int OpenSpeed = 14;
        public static final int OpenStraightSpeak = 12;
        public static final int OpenVoiceHelp = 64;
        public static final int OutAllView = 50;
        public static final int Quite = 37;
        public static final int QuiteMode = 10;
        public static final int ReRoute = 24;
        public static final int RoutePlanOffline = 59;
        public static final int RoutePlanOnline = 58;
        public static final int SafeMode = 9;
        public static final int SearchOffline = 57;
        public static final int SearchOnline = 56;
        public static final int SlaveRoad = 17;
        public static final int StartNavi = 65;
        public static final int VoiceDown = 5;
        public static final int VoiceUp = 4;
        public static final int WashCar = 40;
        public static final int Weather = 41;
        public static final int ZoomIn = 3;
        public static final int ZoomOut = 2;
    }
}
