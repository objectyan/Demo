package com.tencent.qplayauto.device;

import android.os.Handler;
import android.util.Log;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QPlayAutoJNI {
    public static final int BIN_DATA_TYPE_LRC = 3;
    public static final int BIN_DATA_TYPE_PCM = 1;
    public static final int BIN_DATA_TYPE_PIC = 2;
    public static final int CONNECT_STATE_FAIL = 1;
    public static final int CONNECT_STATE_INTERRUPT = 2;
    public static final int CONNECT_STATE_SUCCESS = 0;
    public static final int CONNECT_TYPE_BLUETOOTH = 2;
    public static final int CONNECT_TYPE_LINE = 3;
    public static final int CONNECT_TYPE_LOCAL = 4;
    public static final int CONNECT_TYPE_WIFI = 1;
    private static String CurrentLyricSongID = "";
    private static volatile String CurrentPCMSongID = "";
    private static String CurrentPICSongID = "";
    public static final int DEVICE_TYPE_AUTO = 1;
    private static boolean InvalidPCMData = false;
    private static byte[] LyricBitData = null;
    private static int LyricPackageIndex = 0;
    private static int LyricPackageLen = 0;
    private static int LyricTotalLen = 0;
    private static int LyricType = 0;
    public static final int MESSAGE_INFOS_TYPE_NORMAL = 1;
    public static final int MESSAGE_INFOS_TYPE_PLAY_BUFF_SIZE = 2;
    public static final int MESSAGE_RECEIVE_COMM = 1;
    public static final int MESSAGE_RECEIVE_CONNECT = 4;
    public static final int MESSAGE_RECEIVE_DATA = 2;
    public static final int MESSAGE_RECEIVE_ERROR = 6;
    public static final int MESSAGE_RECEIVE_INFOS = 5;
    public static final int MESSAGE_RECEIVE_PLAY_BUFF = 12;
    public static final int MESSAGE_RECEIVE_PLAY_FINISH = 11;
    public static final int MESSAGE_RECEIVE_SONG_ITEMS = 3;
    private static Handler MessageHandler = null;
    private static byte[] PCMData = null;
    public static volatile int PCMPackageIndex = -1;
    private static int PCMPackageLen = 0;
    private static int PCMPlayDataCount = 0;
    private static final int PCMPlayDataLength = 10240;
    private static int PCMReceivePackageLen = 0;
    private static volatile int PCMReceiveTotalLen = 0;
    private static int PCMTotalLen = 0;
    public static final int PCM_BUFFER_LENGTH = 614400;
    private static byte[] PICBitData = null;
    private static int PICPackageIndex = 0;
    private static int PICPackageLen = 0;
    private static int PICTotalLen = 0;
    public static ConcurrentLinkedQueue<byte[]> PcmQueue = new ConcurrentLinkedQueue();
    public static final int SONG_ITEM_TYPE_LIST = 2;
    public static final int SONG_ITEM_TYPE_RADIO = 3;
    public static final int SONG_ITEM_TYPE_SONG = 1;
    public static final String SONG_LIST_ROOT_ID = "-1";
    public static final int SONG_LYRIC_TYPE_LRC = 1;
    public static final int SONG_LYRIC_TYPE_QRC = 0;
    public static final int SONG_LYRIC_TYPE_TXT = 2;
    private static final String TAG = "QPlayAutoJNI";
    private static boolean isConnected = false;
    private static boolean isConnecting = false;

    public static native int GetLyricData(String str, int i, int i2);

    public static native HashMap GetMediaInfo(String str);

    public static native HashMap GetMobileDeviceInfos();

    public static native HashMap GetPCMData(String str, int i);

    public static native int GetPICData(String str, int i);

    public static native HashMap GetSongLists(ArrayList arrayList, String str, int i, int i2);

    public static native String SendCommand(String str, boolean z);

    public static native int SendDeviceInfos(String str, String str2, String str3, String str4, int i);

    public static native int SendDisconnect();

    public static native int SendRegisterPlayState(int i);

    public static native int SendResult(String str);

    public static native int SendUNRegisterPlayState(int i);

    public static native int Start(int i, int i2, String str, String str2);

    public static native void Stop();

    public static native HashMap StopSendData(String str, int i);

    static {
        try {
            System.loadLibrary("QPlayAutoDevice");
        } catch (UnsatisfiedLinkError t) {
            Log.e(TAG, t.getMessage());
        }
    }

    public static void SetHandler(Handler UIMessageHandler) {
        MessageHandler = UIMessageHandler;
    }

    private static byte[] CopyPCMDataToPlay(byte[] SourceData, byte[] PlayData) {
        int CopyDataLen;
        int SourceIndex = 0;
        if (PlayData == null) {
            PlayData = new byte[10240];
            PCMPlayDataCount = 0;
        }
        while (SourceData.length - SourceIndex > PlayData.length - PCMPlayDataCount) {
            CopyDataLen = PlayData.length - PCMPlayDataCount;
            System.arraycopy(SourceData, SourceIndex, PlayData, PCMPlayDataCount, CopyDataLen);
            PCMPlayDataCount = 0;
            SourceIndex += CopyDataLen;
            PcmQueue.offer(PlayData);
            PlayData = new byte[10240];
        }
        CopyDataLen = SourceData.length - SourceIndex;
        System.arraycopy(SourceData, SourceIndex, PlayData, PCMPlayDataCount, CopyDataLen);
        PCMPlayDataCount += CopyDataLen;
        if (PCMPlayDataCount != PlayData.length) {
            return PlayData;
        }
        PcmQueue.offer(PlayData);
        PCMPlayDataCount = 0;
        return null;
    }

    public static void InitPCMData() {
        CurrentPCMSongID = "";
        PcmQueue.clear();
        PCMPackageIndex = -1;
        PCMReceiveTotalLen = 0;
    }

    public static void OnReceivePCMData(HashMap HeadFlag, byte[] Data) {
        if (HeadFlag != null) {
            if (CurrentPCMSongID.equalsIgnoreCase(HeadFlag.get("songid").toString())) {
                PCMTotalLen = Integer.parseInt(HeadFlag.get("totallength").toString());
                PCMPackageLen = Integer.parseInt(HeadFlag.get("length").toString());
                PCMPackageIndex = Integer.parseInt(HeadFlag.get("packageindex").toString());
                PCMReceivePackageLen = 0;
                Log.d(TAG, "Receive package index:" + PCMPackageIndex);
            } else {
                SendInfo(1, TAG, "PCM数据传送错误,当前ID:" + CurrentPCMSongID + " 数据ID:" + HeadFlag.get("songid").toString() + " 不一致!");
                return;
            }
        } else if (CurrentPCMSongID.equals("")) {
            SendInfo(1, TAG, "PCM数据传送完成!多余数据忽略!(本次丢掉" + Data.length + "字节)");
            return;
        }
        if (Data.length != 0) {
            if (PCMReceiveTotalLen + Data.length > PCMTotalLen) {
                if (PCMReceiveTotalLen < PCMTotalLen) {
                    byte[] UseData = new byte[(PCMTotalLen - PCMReceiveTotalLen)];
                    System.arraycopy(Data, 0, UseData, 0, UseData.length);
                    PCMData = CopyPCMDataToPlay(UseData, PCMData);
                    if (PCMData != null) {
                        PcmQueue.offer(PCMData);
                    }
                    PCMReceiveTotalLen = 0;
                    PCMReceivePackageLen = 0;
                    CurrentPCMSongID = "";
                    PCMData = null;
                    PcmQueue.offer(new byte[0]);
                }
                PCMReceiveTotalLen += Data.length;
                SendInfo(1, TAG, "PCM Data1,ID:" + CurrentPCMSongID + " TotalLen:" + PCMTotalLen + "(" + PCMReceiveTotalLen + ") PackageIndex:" + PCMPackageIndex + " PackageLen:" + PCMPackageLen + "(" + PCMReceivePackageLen + ")");
                return;
            }
            PCMData = CopyPCMDataToPlay(Data, PCMData);
            PCMReceiveTotalLen += Data.length;
            PCMReceivePackageLen += Data.length;
            if (PCMTotalLen <= PCMReceiveTotalLen + PCMPackageLen || (PCMPackageLen < PCM_BUFFER_LENGTH && PCMReceivePackageLen >= PCMPackageLen)) {
                PCMReceiveTotalLen = 0;
                PCMReceivePackageLen = 0;
                CurrentPCMSongID = "";
                PCMData = null;
                PcmQueue.offer(new byte[0]);
            }
        }
    }

    public static void OnReceivePICData(HashMap HeadFlag, byte[] Data) {
        if (HeadFlag == null) {
            Log.d(TAG, "Receive PIC data,SongID:" + CurrentPICSongID + " TotalLen:" + PICTotalLen + " PackageLen:" + PICPackageLen + " DataLen:" + Data.length);
        } else if (CurrentPICSongID.equalsIgnoreCase(HeadFlag.get("songid").toString())) {
            PICPackageLen = Integer.parseInt(HeadFlag.get("length").toString());
            Log.d(TAG, "Receive PIC data New package,SongID:" + CurrentPICSongID + " PackageLen:" + PICPackageLen + " DataLen:" + Data.length);
        } else {
            CurrentPICSongID = HeadFlag.get("songid").toString();
            PICTotalLen = Integer.parseInt(HeadFlag.get("totallength").toString());
            PICPackageLen = Integer.parseInt(HeadFlag.get("length").toString());
            Log.d(TAG, "Receive PIC data new Song,SongID:" + CurrentPICSongID + " TotalLen:" + PICTotalLen + " PackageLen:" + PICPackageLen + " DataLen:" + Data.length);
            PICBitData = new byte[PICTotalLen];
            PICPackageIndex = 0;
        }
        if (Data.length != 0) {
            System.arraycopy(Data, 0, PICBitData, PICBitData.length - PICTotalLen, Data.length);
            PICPackageLen -= Data.length;
            PICTotalLen -= Data.length;
            if (PICTotalLen == 0) {
                CurrentPICSongID = "";
                MessageHandler.obtainMessage(2, 2, 0, PICBitData).sendToTarget();
            } else if (PICPackageLen == 0) {
                PICPackageIndex++;
                Log.d(TAG, "GetPICData--Package Index:" + PICPackageIndex + "->" + GetPICData(CurrentPICSongID, PICPackageIndex));
            } else if (PICPackageLen < 0) {
                Log.d(TAG, "接收PIC数据出错--需要数据:" + PICPackageLen + Data.length + "实际数据:" + Data.length);
            } else if (PICTotalLen < 0) {
                Log.d(TAG, "接收PIC数据出错--需要总数据:" + PICTotalLen + Data.length + "实际数据:" + Data.length);
            }
        }
    }

    public static void OnReceiveLyricData(HashMap HeadFlag, byte[] Data) {
        if (HeadFlag == null) {
            Log.d(TAG, "Receive Lyric data,SongID:" + CurrentLyricSongID + " TotalLen:" + LyricTotalLen + " PackageLen:" + LyricPackageLen + " DataLen:" + Data.length);
        } else if (CurrentLyricSongID.equalsIgnoreCase(HeadFlag.get("songid").toString())) {
            LyricPackageLen = Integer.parseInt(HeadFlag.get("length").toString());
            Log.d(TAG, "Receive Lyric data New package,SongID:" + CurrentLyricSongID + " PackageLen:" + LyricPackageLen + " DataLen:" + Data.length);
        } else {
            CurrentLyricSongID = HeadFlag.get("songid").toString();
            LyricTotalLen = Integer.parseInt(HeadFlag.get("totallength").toString());
            LyricPackageLen = Integer.parseInt(HeadFlag.get("length").toString());
            LyricType = Integer.parseInt(HeadFlag.get("lyrictype").toString());
            Log.d(TAG, "Receive Lyric data new Song,SongID:" + CurrentLyricSongID + " TotalLen:" + LyricTotalLen + " PackageLen:" + LyricPackageLen + " DataLen:" + Data.length);
            LyricBitData = new byte[LyricTotalLen];
            LyricPackageIndex = 0;
        }
        if (Data.length != 0) {
            System.arraycopy(Data, 0, LyricBitData, LyricBitData.length - LyricTotalLen, Data.length);
            LyricPackageLen -= Data.length;
            LyricTotalLen -= Data.length;
            if (LyricTotalLen == 0) {
                CurrentLyricSongID = "";
                MessageHandler.obtainMessage(2, 3, LyricType, LyricBitData).sendToTarget();
            } else if (LyricPackageLen == 0) {
                LyricPackageIndex++;
                Log.d(TAG, "GetLyricData--Package Index:" + LyricPackageIndex + "->" + GetLyricData(CurrentLyricSongID, LyricType, LyricPackageIndex));
            } else if (LyricPackageLen < 0) {
                Log.d(TAG, "接收歌词数据出错--需要数据:" + LyricPackageLen + Data.length + "实际数据:" + Data.length);
            } else if (LyricTotalLen < 0) {
                Log.d(TAG, "接收歌词数据出错--需要总数据:" + LyricTotalLen + Data.length + "实际数据:" + Data.length);
            }
        }
    }

    public static void OnConnectMessage(int ConnectStateType) {
        Log.d(TAG, "Connect message type:" + ConnectStateType);
        MessageHandler.obtainMessage(4, ConnectStateType, 0).sendToTarget();
    }

    public static void OnReceiveCommand(HashMap Command) {
        if (Command.toString().indexOf("Heartbeat") < 0) {
            Log.d(TAG, "Receive Command:" + Command.toString());
        }
        MessageHandler.obtainMessage(1, Command).sendToTarget();
    }

    public static void SetCurrentSongID(String CurrentSongID) {
        CurrentPCMSongID = CurrentSongID;
    }

    public static void ClearPCMData() {
        PcmQueue.clear();
    }

    public static void SendInfo(int Type, String tag, String infos) {
        Log.d(tag, infos);
        MessageHandler.obtainMessage(5, Type, 0, infos).sendToTarget();
    }

    public static void PrintHashMap(String tag, HashMap Result, String Head) {
        if (Result == null) {
            Log.d(tag, Head + "--Result is null");
        } else {
            Log.d(tag, Head + Result.toString());
        }
    }

    public static void PrintList(List list, String Head) {
        for (int i = 0; i < list.size(); i++) {
            PrintHashMap(TAG, (HashMap) list.get(i), Head);
        }
    }

    public static void GetSongPicture(String SongID) {
        GetPICData(SongID, 0);
    }

    public static void ReadSongList(final String ParentID, int Type) {
        new Thread() {
            public void run() {
                int PageIndex = 0;
                ArrayList SendList = new ArrayList();
                SendList.add(ParentID);
                int Count;
                do {
                    ArrayList SongList = new ArrayList();
                    QPlayAutoJNI.SendInfo(1, QPlayAutoJNI.TAG, "Get song list ParentID1:" + ParentID + "  PageIndex:" + PageIndex + "  PagePreCount:" + 10);
                    HashMap hm = QPlayAutoJNI.GetSongLists(SongList, ParentID, PageIndex, 10);
                    if (hm == null) {
                        hm = QPlayAutoJNI.GetSongLists(SongList, ParentID, PageIndex, 10);
                        if (hm == null) {
                            QPlayAutoJNI.SendInfo(1, QPlayAutoJNI.TAG, "Get song list error!");
                            return;
                        }
                    }
                    Object val = hm.get("count");
                    if (val == null) {
                        Object error = hm.get(ParamKey.KEY_MSG_ERRORS);
                        if (error != null) {
                            QPlayAutoJNI.MessageHandler.obtainMessage(6, 0, 0, error).sendToTarget();
                            return;
                        }
                        Count = 0;
                    } else {
                        Count = Integer.parseInt(val.toString());
                    }
                    QPlayAutoJNI.SendInfo(1, QPlayAutoJNI.TAG, "Get song list Count:" + Count + " Items Count:" + SongList.size());
                    SendList.addAll(SongList);
                    PageIndex++;
                } while (SendList.size() < Count);
            }
        }.start();
    }

    public static void StopPlay() {
        if (!CurrentPICSongID.equals("")) {
            StopSendData(CurrentPICSongID, 1);
        }
    }

    public static int startConnect() {
        if (isConnecting) {
            return 0;
        }
        isConnecting = true;
        return Start(1, 4, "Baidu", "CarLife");
    }

    public static void stopConnect() {
        if (isConnecting) {
            isConnecting = false;
            Stop();
        }
    }
}
