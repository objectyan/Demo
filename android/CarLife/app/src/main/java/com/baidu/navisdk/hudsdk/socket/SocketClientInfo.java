package com.baidu.navisdk.hudsdk.socket;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.navisdk.hudsdk.HudSwitchReq;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public class SocketClientInfo
{
  private final int BUFFER_SIZE = 1024;
  private SocketClientEnvetCallback mClientCallback;
  private Handler mClientHandle;
  private ReadThread mClientReadThread;
  private Context mContext;
  private byte[] mData;
  private InputStream mInputStream;
  private boolean mIsAuth = false;
  private Looper mLooper;
  private int mMsgId;
  private OutputStream mOutputStream;
  private Socket mSocket;
  private BNWorkerNormalTask<String, String> mheartAliveTask = new BNWorkerNormalTask("mheartAliveTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      Log.e("BNRemote", "SocketClientInfo...........mheartAliveRunnable...RUNNN!!!  not receive PING PACKET");
      SocketClientInfo.this.close();
      return null;
    }
  };
  
  public SocketClientInfo(Socket paramSocket, Context paramContext, SocketClientEnvetCallback paramSocketClientEnvetCallback, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mLooper = paramLooper;
    this.mClientCallback = paramSocketClientEnvetCallback;
    this.mSocket = paramSocket;
    this.mMsgId = 0;
    try
    {
      this.mInputStream = this.mSocket.getInputStream();
    }
    catch (IOException paramSocket)
    {
      try
      {
        for (;;)
        {
          this.mOutputStream = this.mSocket.getOutputStream();
          this.mData = new byte['Ѐ'];
          this.mClientReadThread = new ReadThread();
          this.mClientReadThread.start();
          this.mClientHandle = new Handler(this.mLooper)
          {
            public void handleMessage(Message paramAnonymousMessage)
            {
              if (paramAnonymousMessage == null) {}
              while (paramAnonymousMessage.what != 1421) {
                return;
              }
              SocketClientInfo.this.processAuthResMsg(paramAnonymousMessage);
            }
          };
          return;
          paramSocket = paramSocket;
          paramSocket.printStackTrace();
        }
      }
      catch (IOException paramSocket)
      {
        for (;;)
        {
          paramSocket.printStackTrace();
          this.mInputStream = null;
        }
      }
    }
  }
  
  private void close()
  {
    close("read error");
    if (this.mClientCallback != null) {
      this.mClientCallback.onRemoveClient(this);
    }
  }
  
  private void preProcessRGInfo(boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException
  {
    if (BNavigator.getInstance().isNaviBegin())
    {
      Log.e("BNRemote", "SocketClientInfo...........already start Naviing");
      sendMsgToClient(PacketJSONData.packetJSONData(100, null));
      sendMsgToClient(PacketJSONData.packetJSONData(103, null));
      sendMsgToClient(PacketJSONData.packetJSONData(104, null));
    }
    if (BNavigator.getInstance().isARRouteBuildSuccess())
    {
      int i = BNRGEventHUDCollection.getInstance().updateRouteID();
      Bundle localBundle = new Bundle();
      localBundle.putInt("routeId", i);
      sendMsgToClient(PacketJSONData.packetJSONData(120, localBundle));
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      Log.e("BNRemote", "SocketClientInfo...........GPSNormal");
      sendMsgToClient(PacketJSONData.packetJSONData(107, null));
      return;
    }
    Log.e("BNRemote", "SocketClientInfo...........GPSLost");
    sendMsgToClient(PacketJSONData.packetJSONData(106, null));
  }
  
  private void processAuthResMsg(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      int j = 1;
      paramMessage = (JSONObject)((RspData)paramMessage.obj).mData;
      int i = j;
      try
      {
        if (paramMessage.getInt("errno") == 0)
        {
          paramMessage = paramMessage.getJSONObject("data");
          i = j;
          if (paramMessage != null) {
            i = paramMessage.getInt("open");
          }
        }
      }
      catch (JSONException paramMessage)
      {
        for (;;)
        {
          try
          {
            sendMsgToClient(PacketJSONData.packetAuthRes(true));
            this.mIsAuth = true;
            preProcessRGInfo(BNSysLocationManager.getInstance().isGpsEnabled(), BNSysLocationManager.getInstance().isGpsAvailable());
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            this.mIsAuth = false;
            close();
            paramMessage.printStackTrace();
            return;
          }
          paramMessage = paramMessage;
          paramMessage.printStackTrace();
          i = j;
        }
      }
      if (i == 1) {
        LogUtil.e("BNRemote", "this client Auth SUCCESS");
      }
      LogUtil.e("BNRemote", "this client:" + this.mSocket.getInetAddress() + " Auth FAILED");
      try
      {
        sendMsgToClient(PacketJSONData.packetAuthRes(false));
        this.mIsAuth = false;
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        this.mIsAuth = false;
        close();
        return;
      }
    }
    try
    {
      sendMsgToClient(PacketJSONData.packetAuthRes(true));
      this.mIsAuth = true;
      preProcessRGInfo(BNSysLocationManager.getInstance().isGpsEnabled(), BNSysLocationManager.getInstance().isGpsAvailable());
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      this.mIsAuth = false;
      close();
    }
  }
  
  private void updateHeartAlive()
  {
    BNWorkerCenter.getInstance().cancelTask(this.mheartAliveTask, false);
    BNWorkerCenter.getInstance().submitNormalTaskDelay(this.mheartAliveTask, new BNWorkerConfig(100, 0), 90000L);
  }
  
  public boolean checkIsAuthSuccess()
  {
    return this.mIsAuth;
  }
  
  public void close(String paramString)
  {
    if (this.mClientReadThread != null)
    {
      this.mClientReadThread.quit();
      this.mClientReadThread = null;
    }
    this.mData = null;
    try
    {
      if (this.mInputStream != null) {
        this.mInputStream.close();
      }
      if (this.mOutputStream != null) {
        this.mOutputStream.close();
      }
      if (this.mSocket != null) {
        this.mSocket.close();
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        this.mInputStream = null;
        this.mOutputStream = null;
        this.mSocket = null;
      }
    }
    finally
    {
      this.mInputStream = null;
      this.mOutputStream = null;
      this.mSocket = null;
    }
    if (this.mClientHandle != null) {
      this.mClientHandle = null;
    }
    BNWorkerCenter.getInstance().cancelTask(this.mheartAliveTask, false);
    this.mLooper = null;
    this.mheartAliveTask = null;
  }
  
  public void heartAliveCheck()
  {
    BNWorkerCenter.getInstance().submitNormalTaskDelay(this.mheartAliveTask, new BNWorkerConfig(100, 0), 90000L);
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException, SocketTimeoutException
  {
    int i = 1024;
    if (this.mInputStream == null) {
      throw new IOException();
    }
    int j = paramByteBuffer.capacity() - paramByteBuffer.position();
    if (j > 1024) {}
    for (;;)
    {
      i = this.mInputStream.read(this.mData, 0, i);
      if (i > 0)
      {
        paramByteBuffer.put(this.mData, 0, i);
        updateHeartAlive();
      }
      return i;
      i = j;
    }
  }
  
  public void sendMsgToClient(JSONObject paramJSONObject)
    throws SocketTimeoutException, IOException, UnsupportedEncodingException
  {
    if (paramJSONObject == null) {
      return;
    }
    this.mMsgId += 1;
    try
    {
      paramJSONObject.put("msgId", this.mMsgId);
      paramJSONObject.put("sendTime", System.currentTimeMillis());
      paramJSONObject = paramJSONObject.toString().getBytes("utf-8");
      int k = paramJSONObject.length;
      byte[] arrayOfByte = new byte[k + 4 + 2];
      arrayOfByte[3] = ((byte)(k & 0xFF));
      arrayOfByte[2] = ((byte)(k >> 8 & 0xFF));
      arrayOfByte[1] = ((byte)(k >> 16 & 0xFF));
      arrayOfByte[0] = ((byte)(k >> 24 & 0xFF));
      j = 4;
      int i = 0;
      while (i < k)
      {
        arrayOfByte[j] = paramJSONObject[i];
        j += 1;
        i += 1;
      }
    }
    catch (JSONException localJSONException)
    {
      int j;
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      localJSONException[j] = 13;
      localJSONException[(j + 1)] = 10;
      write(localJSONException);
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException, SocketTimeoutException
  {
    if (this.mOutputStream == null) {
      throw new IOException();
    }
    this.mOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public class ReadThread
    extends Thread
  {
    ByteBuffer mBuffer = ByteBuffer.allocateDirect(262);
    boolean mIsStopped = false;
    
    public ReadThread() {}
    
    private void consumeData()
      throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException
    {
      int i;
      while (this.mBuffer.hasRemaining())
      {
        i = this.mBuffer.position();
        this.mBuffer.flip();
        if (this.mBuffer.remaining() < 4) {
          break label273;
        }
        int j = this.mBuffer.get() << 24 & 0xFF000000 | this.mBuffer.get() << 16 & 0xFF0000 | this.mBuffer.get() << 8 & 0xFF00 | this.mBuffer.get() & 0xFF;
        if (this.mBuffer.remaining() < j + 2) {
          break label255;
        }
        this.mBuffer.position(4);
        byte[] arrayOfByte = new byte[j];
        this.mBuffer.get(arrayOfByte, 0, j);
        if ((this.mBuffer.get() == 13) && (this.mBuffer.get() == 10))
        {
          unPackedData(new JSONObject(new String(arrayOfByte, "utf-8")));
          if (this.mBuffer.hasRemaining())
          {
            arrayOfByte = new byte[this.mBuffer.limit() - this.mBuffer.position()];
            this.mBuffer.get(arrayOfByte, 0, arrayOfByte.length);
            this.mBuffer.clear();
            this.mBuffer.put(arrayOfByte, 0, arrayOfByte.length);
          }
        }
        else
        {
          throw new JSONException("protocol error");
        }
        this.mBuffer.clear();
      }
      return;
      label255:
      this.mBuffer.clear();
      this.mBuffer.position(i);
      return;
      label273:
      this.mBuffer.clear();
      this.mBuffer.position(i);
    }
    
    private void processAuthReqMsg(JSONObject paramJSONObject)
      throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException
    {
      LogUtil.e("BNRemote", "SocketClientInfo...........processAuthReqMsg()....Recevie AUTH REQ MSG");
      paramJSONObject.getString("appVersion");
      String str = paramJSONObject.getString("hudSdkVersion");
      paramJSONObject = paramJSONObject.getString("packageName");
      Bundle localBundle = new Bundle();
      localBundle.putString("hudAppPkg", paramJSONObject);
      localBundle.putString("hudVer", str);
      NaviStatItem.getInstance().mHudSDKClientPkgName = paramJSONObject;
      HudSwitchReq.asyncHudAuth(1421, localBundle, SocketClientInfo.this.mClientHandle);
    }
    
    private void processPingMsg()
      throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException
    {
      Log.e("BNRemote", "SocketClientInfo...........processPingMsg()..........Receive PING MSG");
      JSONObject localJSONObject = PacketJSONData.packetPong();
      SocketClientInfo.this.sendMsgToClient(localJSONObject);
    }
    
    private void unPackedData(JSONObject paramJSONObject)
      throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      int i = paramJSONObject.getInt("messageType");
      paramJSONObject = paramJSONObject.getJSONObject("messageData");
      switch (i)
      {
      default: 
        return;
      case 11: 
        processAuthReqMsg(paramJSONObject);
        return;
      }
      processPingMsg();
    }
    
    public void quit()
    {
      this.mIsStopped = true;
    }
    
    public void run()
    {
      this.mBuffer.clear();
      while (!this.mIsStopped) {
        try
        {
          if (SocketClientInfo.this.read(this.mBuffer) >= 0) {
            consumeData();
          }
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          Log.e("BNRemote", "SocketClientInfo...........READ THREAD....SocketTimeoutException, e= " + localSocketTimeoutException.toString());
          this.mIsStopped = true;
          SocketClientInfo.this.close();
          continue;
          Log.e("BNRemote", "SocketClientInfo...........READ THREAD....read error, len < 0");
          this.mIsStopped = true;
          SocketClientInfo.this.close();
        }
        catch (IOException localIOException)
        {
          Log.e("BNRemote", "SocketClientInfo...........READ THREAD....IOException, e= " + localIOException.toString());
          this.mIsStopped = true;
          SocketClientInfo.this.close();
        }
        catch (JSONException localJSONException)
        {
          Log.e("BNRemote", "SocketClientInfo...........READ THREAD....JSONException, e= " + localJSONException.toString());
          this.mIsStopped = true;
          SocketClientInfo.this.close();
        }
      }
    }
  }
  
  public static abstract interface SocketClientEnvetCallback
  {
    public abstract void onRemoveClient(SocketClientInfo paramSocketClientInfo);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/socket/SocketClientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */