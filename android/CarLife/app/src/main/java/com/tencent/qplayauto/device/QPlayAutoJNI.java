package com.tencent.qplayauto.device;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QPlayAutoJNI
{
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
  private static String CurrentLyricSongID;
  private static volatile String CurrentPCMSongID;
  private static String CurrentPICSongID;
  public static final int DEVICE_TYPE_AUTO = 1;
  private static boolean InvalidPCMData = false;
  private static byte[] LyricBitData;
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
  private static byte[] PCMData;
  public static volatile int PCMPackageIndex = 0;
  private static int PCMPackageLen = 0;
  private static int PCMPlayDataCount = 0;
  private static final int PCMPlayDataLength = 10240;
  private static int PCMReceivePackageLen = 0;
  private static volatile int PCMReceiveTotalLen = 0;
  private static int PCMTotalLen = 0;
  public static final int PCM_BUFFER_LENGTH = 614400;
  private static byte[] PICBitData;
  private static int PICPackageIndex = 0;
  private static int PICPackageLen = 0;
  private static int PICTotalLen = 0;
  public static ConcurrentLinkedQueue<byte[]> PcmQueue;
  public static final int SONG_ITEM_TYPE_LIST = 2;
  public static final int SONG_ITEM_TYPE_RADIO = 3;
  public static final int SONG_ITEM_TYPE_SONG = 1;
  public static final String SONG_LIST_ROOT_ID = "-1";
  public static final int SONG_LYRIC_TYPE_LRC = 1;
  public static final int SONG_LYRIC_TYPE_QRC = 0;
  public static final int SONG_LYRIC_TYPE_TXT = 2;
  private static final String TAG = "QPlayAutoJNI";
  private static boolean isConnected;
  private static boolean isConnecting;
  
  static
  {
    CurrentPCMSongID = "";
    CurrentPICSongID = "";
    CurrentLyricSongID = "";
    PCMTotalLen = 0;
    PCMPackageLen = 0;
    PCMReceiveTotalLen = 0;
    PCMReceivePackageLen = 0;
    PCMPackageIndex = -1;
    PICTotalLen = 0;
    PICPackageLen = 0;
    PICPackageIndex = 0;
    LyricTotalLen = 0;
    LyricPackageLen = 0;
    LyricPackageIndex = 0;
    LyricType = 0;
    PCMPlayDataCount = 0;
    PCMData = null;
    InvalidPCMData = false;
    isConnected = false;
    isConnecting = false;
    PcmQueue = new ConcurrentLinkedQueue();
    try
    {
      System.loadLibrary("QPlayAutoDevice");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e("QPlayAutoJNI", localUnsatisfiedLinkError.getMessage());
    }
  }
  
  public static void ClearPCMData()
  {
    PcmQueue.clear();
  }
  
  private static byte[] CopyPCMDataToPlay(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 0;
    int i = j;
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null)
    {
      arrayOfByte = new byte['⠀'];
      PCMPlayDataCount = 0;
      i = j;
    }
    while (paramArrayOfByte1.length - i > arrayOfByte.length - PCMPlayDataCount)
    {
      j = arrayOfByte.length - PCMPlayDataCount;
      System.arraycopy(paramArrayOfByte1, i, arrayOfByte, PCMPlayDataCount, j);
      PCMPlayDataCount = 0;
      i += j;
      PcmQueue.offer(arrayOfByte);
      arrayOfByte = new byte['⠀'];
    }
    j = paramArrayOfByte1.length - i;
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte, PCMPlayDataCount, j);
    PCMPlayDataCount += j;
    paramArrayOfByte1 = arrayOfByte;
    if (PCMPlayDataCount == arrayOfByte.length)
    {
      PcmQueue.offer(arrayOfByte);
      PCMPlayDataCount = 0;
      paramArrayOfByte1 = null;
    }
    return paramArrayOfByte1;
  }
  
  public static native int GetLyricData(String paramString, int paramInt1, int paramInt2);
  
  public static native HashMap GetMediaInfo(String paramString);
  
  public static native HashMap GetMobileDeviceInfos();
  
  public static native HashMap GetPCMData(String paramString, int paramInt);
  
  public static native int GetPICData(String paramString, int paramInt);
  
  public static native HashMap GetSongLists(ArrayList paramArrayList, String paramString, int paramInt1, int paramInt2);
  
  public static void GetSongPicture(String paramString)
  {
    GetPICData(paramString, 0);
  }
  
  public static void InitPCMData()
  {
    CurrentPCMSongID = "";
    PcmQueue.clear();
    PCMPackageIndex = -1;
    PCMReceiveTotalLen = 0;
  }
  
  public static void OnConnectMessage(int paramInt)
  {
    Log.d("QPlayAutoJNI", "Connect message type:" + paramInt);
    MessageHandler.obtainMessage(4, paramInt, 0).sendToTarget();
  }
  
  public static void OnReceiveCommand(HashMap paramHashMap)
  {
    if (paramHashMap.toString().indexOf("Heartbeat") < 0) {
      Log.d("QPlayAutoJNI", "Receive Command:" + paramHashMap.toString());
    }
    MessageHandler.obtainMessage(1, paramHashMap).sendToTarget();
  }
  
  public static void OnReceiveLyricData(HashMap paramHashMap, byte[] paramArrayOfByte)
  {
    if (paramHashMap != null) {
      if (CurrentLyricSongID.equalsIgnoreCase(paramHashMap.get("songid").toString()))
      {
        LyricPackageLen = Integer.parseInt(paramHashMap.get("length").toString());
        Log.d("QPlayAutoJNI", "Receive Lyric data New package,SongID:" + CurrentLyricSongID + " PackageLen:" + LyricPackageLen + " DataLen:" + paramArrayOfByte.length);
        if (paramArrayOfByte.length != 0) {
          break label297;
        }
      }
    }
    label297:
    do
    {
      return;
      CurrentLyricSongID = paramHashMap.get("songid").toString();
      LyricTotalLen = Integer.parseInt(paramHashMap.get("totallength").toString());
      LyricPackageLen = Integer.parseInt(paramHashMap.get("length").toString());
      LyricType = Integer.parseInt(paramHashMap.get("lyrictype").toString());
      Log.d("QPlayAutoJNI", "Receive Lyric data new Song,SongID:" + CurrentLyricSongID + " TotalLen:" + LyricTotalLen + " PackageLen:" + LyricPackageLen + " DataLen:" + paramArrayOfByte.length);
      LyricBitData = new byte[LyricTotalLen];
      LyricPackageIndex = 0;
      break;
      Log.d("QPlayAutoJNI", "Receive Lyric data,SongID:" + CurrentLyricSongID + " TotalLen:" + LyricTotalLen + " PackageLen:" + LyricPackageLen + " DataLen:" + paramArrayOfByte.length);
      break;
      System.arraycopy(paramArrayOfByte, 0, LyricBitData, LyricBitData.length - LyricTotalLen, paramArrayOfByte.length);
      LyricPackageLen -= paramArrayOfByte.length;
      LyricTotalLen -= paramArrayOfByte.length;
      if (LyricTotalLen == 0)
      {
        CurrentLyricSongID = "";
        MessageHandler.obtainMessage(2, 3, LyricType, LyricBitData).sendToTarget();
        return;
      }
      if (LyricPackageLen == 0)
      {
        LyricPackageIndex += 1;
        Log.d("QPlayAutoJNI", "GetLyricData--Package Index:" + LyricPackageIndex + "->" + GetLyricData(CurrentLyricSongID, LyricType, LyricPackageIndex));
        return;
      }
      if (LyricPackageLen < 0)
      {
        Log.d("QPlayAutoJNI", "接收歌词数据出错--需要数据:" + LyricPackageLen + paramArrayOfByte.length + "实际数据:" + paramArrayOfByte.length);
        return;
      }
    } while (LyricTotalLen >= 0);
    Log.d("QPlayAutoJNI", "接收歌词数据出错--需要总数据:" + LyricTotalLen + paramArrayOfByte.length + "实际数据:" + paramArrayOfByte.length);
  }
  
  public static void OnReceivePCMData(HashMap paramHashMap, byte[] paramArrayOfByte)
  {
    if (paramHashMap != null) {
      if (CurrentPCMSongID.equalsIgnoreCase(paramHashMap.get("songid").toString()))
      {
        PCMTotalLen = Integer.parseInt(paramHashMap.get("totallength").toString());
        PCMPackageLen = Integer.parseInt(paramHashMap.get("length").toString());
        PCMPackageIndex = Integer.parseInt(paramHashMap.get("packageindex").toString());
        PCMReceivePackageLen = 0;
        Log.d("QPlayAutoJNI", "Receive package index:" + PCMPackageIndex);
        if (paramArrayOfByte.length != 0) {
          break label205;
        }
      }
    }
    label205:
    do
    {
      return;
      SendInfo(1, "QPlayAutoJNI", "PCM数据传送错误,当前ID:" + CurrentPCMSongID + " 数据ID:" + paramHashMap.get("songid").toString() + " 不一致!");
      return;
      if (!CurrentPCMSongID.equals("")) {
        break;
      }
      SendInfo(1, "QPlayAutoJNI", "PCM数据传送完成!多余数据忽略!(本次丢掉" + paramArrayOfByte.length + "字节)");
      return;
      if (PCMReceiveTotalLen + paramArrayOfByte.length > PCMTotalLen)
      {
        if (PCMReceiveTotalLen < PCMTotalLen)
        {
          paramHashMap = new byte[PCMTotalLen - PCMReceiveTotalLen];
          System.arraycopy(paramArrayOfByte, 0, paramHashMap, 0, paramHashMap.length);
          PCMData = CopyPCMDataToPlay(paramHashMap, PCMData);
          if (PCMData != null) {
            PcmQueue.offer(PCMData);
          }
          PCMReceiveTotalLen = 0;
          PCMReceivePackageLen = 0;
          CurrentPCMSongID = "";
          PCMData = null;
          PcmQueue.offer(new byte[0]);
        }
        PCMReceiveTotalLen += paramArrayOfByte.length;
        SendInfo(1, "QPlayAutoJNI", "PCM Data1,ID:" + CurrentPCMSongID + " TotalLen:" + PCMTotalLen + "(" + PCMReceiveTotalLen + ") PackageIndex:" + PCMPackageIndex + " PackageLen:" + PCMPackageLen + "(" + PCMReceivePackageLen + ")");
        return;
      }
      PCMData = CopyPCMDataToPlay(paramArrayOfByte, PCMData);
      PCMReceiveTotalLen += paramArrayOfByte.length;
      PCMReceivePackageLen += paramArrayOfByte.length;
    } while ((PCMTotalLen > PCMReceiveTotalLen + PCMPackageLen) && ((PCMPackageLen >= 614400) || (PCMReceivePackageLen < PCMPackageLen)));
    PCMReceiveTotalLen = 0;
    PCMReceivePackageLen = 0;
    CurrentPCMSongID = "";
    PCMData = null;
    PcmQueue.offer(new byte[0]);
  }
  
  public static void OnReceivePICData(HashMap paramHashMap, byte[] paramArrayOfByte)
  {
    if (paramHashMap != null) {
      if (CurrentPICSongID.equalsIgnoreCase(paramHashMap.get("songid").toString()))
      {
        PICPackageLen = Integer.parseInt(paramHashMap.get("length").toString());
        Log.d("QPlayAutoJNI", "Receive PIC data New package,SongID:" + CurrentPICSongID + " PackageLen:" + PICPackageLen + " DataLen:" + paramArrayOfByte.length);
        if (paramArrayOfByte.length != 0) {
          break label281;
        }
      }
    }
    label281:
    do
    {
      return;
      CurrentPICSongID = paramHashMap.get("songid").toString();
      PICTotalLen = Integer.parseInt(paramHashMap.get("totallength").toString());
      PICPackageLen = Integer.parseInt(paramHashMap.get("length").toString());
      Log.d("QPlayAutoJNI", "Receive PIC data new Song,SongID:" + CurrentPICSongID + " TotalLen:" + PICTotalLen + " PackageLen:" + PICPackageLen + " DataLen:" + paramArrayOfByte.length);
      PICBitData = new byte[PICTotalLen];
      PICPackageIndex = 0;
      break;
      Log.d("QPlayAutoJNI", "Receive PIC data,SongID:" + CurrentPICSongID + " TotalLen:" + PICTotalLen + " PackageLen:" + PICPackageLen + " DataLen:" + paramArrayOfByte.length);
      break;
      System.arraycopy(paramArrayOfByte, 0, PICBitData, PICBitData.length - PICTotalLen, paramArrayOfByte.length);
      PICPackageLen -= paramArrayOfByte.length;
      PICTotalLen -= paramArrayOfByte.length;
      if (PICTotalLen == 0)
      {
        CurrentPICSongID = "";
        MessageHandler.obtainMessage(2, 2, 0, PICBitData).sendToTarget();
        return;
      }
      if (PICPackageLen == 0)
      {
        PICPackageIndex += 1;
        Log.d("QPlayAutoJNI", "GetPICData--Package Index:" + PICPackageIndex + "->" + GetPICData(CurrentPICSongID, PICPackageIndex));
        return;
      }
      if (PICPackageLen < 0)
      {
        Log.d("QPlayAutoJNI", "接收PIC数据出错--需要数据:" + PICPackageLen + paramArrayOfByte.length + "实际数据:" + paramArrayOfByte.length);
        return;
      }
    } while (PICTotalLen >= 0);
    Log.d("QPlayAutoJNI", "接收PIC数据出错--需要总数据:" + PICTotalLen + paramArrayOfByte.length + "实际数据:" + paramArrayOfByte.length);
  }
  
  public static void PrintHashMap(String paramString1, HashMap paramHashMap, String paramString2)
  {
    if (paramHashMap == null)
    {
      Log.d(paramString1, paramString2 + "--Result is null");
      return;
    }
    Log.d(paramString1, paramString2 + paramHashMap.toString());
  }
  
  public static void PrintList(List paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      PrintHashMap("QPlayAutoJNI", (HashMap)paramList.get(i), paramString);
      i += 1;
    }
  }
  
  public static void ReadSongList(String paramString, int paramInt)
  {
    new Thread()
    {
      public void run()
      {
        int i = 0;
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(this.a);
        ArrayList localArrayList2 = new ArrayList();
        QPlayAutoJNI.SendInfo(1, "QPlayAutoJNI", "Get song list ParentID1:" + this.a + "  PageIndex:" + i + "  PagePreCount:" + 10);
        Object localObject2 = QPlayAutoJNI.GetSongLists(localArrayList2, this.a, i, 10);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = QPlayAutoJNI.GetSongLists(localArrayList2, this.a, i, 10);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            QPlayAutoJNI.SendInfo(1, "QPlayAutoJNI", "Get song list error!");
            return;
          }
        }
        localObject2 = ((HashMap)localObject1).get("count");
        if (localObject2 == null)
        {
          localObject1 = ((HashMap)localObject1).get("error");
          if (localObject1 != null)
          {
            QPlayAutoJNI.MessageHandler.obtainMessage(6, 0, 0, localObject1).sendToTarget();
            return;
          }
        }
        for (int j = 0;; j = Integer.parseInt(localObject2.toString()))
        {
          QPlayAutoJNI.SendInfo(1, "QPlayAutoJNI", "Get song list Count:" + j + " Items Count:" + localArrayList2.size());
          localArrayList1.addAll(localArrayList2);
          i += 1;
          if (localArrayList1.size() < j) {
            break;
          }
          return;
        }
      }
    }.start();
  }
  
  public static native String SendCommand(String paramString, boolean paramBoolean);
  
  public static native int SendDeviceInfos(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public static native int SendDisconnect();
  
  public static void SendInfo(int paramInt, String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
    MessageHandler.obtainMessage(5, paramInt, 0, paramString2).sendToTarget();
  }
  
  public static native int SendRegisterPlayState(int paramInt);
  
  public static native int SendResult(String paramString);
  
  public static native int SendUNRegisterPlayState(int paramInt);
  
  public static void SetCurrentSongID(String paramString)
  {
    CurrentPCMSongID = paramString;
  }
  
  public static void SetHandler(Handler paramHandler)
  {
    MessageHandler = paramHandler;
  }
  
  public static native int Start(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public static native void Stop();
  
  public static void StopPlay()
  {
    if (!CurrentPICSongID.equals("")) {
      StopSendData(CurrentPICSongID, 1);
    }
  }
  
  public static native HashMap StopSendData(String paramString, int paramInt);
  
  public static int startConnect()
  {
    if (!isConnecting)
    {
      isConnecting = true;
      return Start(1, 4, "Baidu", "CarLife");
    }
    return 0;
  }
  
  public static void stopConnect()
  {
    if (isConnecting)
    {
      isConnecting = false;
      Stop();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/qplayauto/device/QPlayAutoJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */