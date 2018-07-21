package com.baidu.navisdk.hudsdk.socket;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRemoteServer
{
  public static final boolean ENABLE = false;
  private static final int MSG_BROADCAST_ALL_CLIENT = 3000;
  private static final int MSG_SEND_CLIENT = 3001;
  private static BNRemoteServer mInstance;
  private BNRGEventHUDCollection.SendAllClientCallback mBroadcast = new BNRGEventHUDCollection.SendAllClientCallback()
  {
    public void onBroadcast(JSONObject paramAnonymousJSONObject)
    {
      BNRemoteServer.this.broadcast(paramAnonymousJSONObject);
    }
  };
  private ArrayList<SocketClientInfo> mCliensList = new ArrayList();
  private SocketClientInfo.SocketClientEnvetCallback mClientCallback = new SocketClientInfo.SocketClientEnvetCallback()
  {
    public void onRemoveClient(SocketClientInfo paramAnonymousSocketClientInfo)
    {
      BNRemoteServer.this.removeClient(paramAnonymousSocketClientInfo);
    }
  };
  private byte[] mClientsListLock = new byte[0];
  private Context mContext;
  private boolean mIsListened = false;
  private int mPortsPoolType;
  private ServerListenerThread mServerListenerThread;
  private ServerSendHandler mServerSendHandler;
  private Looper mServerSendLooper;
  private HandlerThread mServerSendThread;
  private ServerSocket mServerSocket = null;
  
  private void addClient(SocketClientInfo paramSocketClientInfo)
  {
    LogUtil.e("BNRemote", "BNRemoteServer.......addClient() new client connect success");
    synchronized (this.mClientsListLock)
    {
      this.mCliensList.add(paramSocketClientInfo);
      handleEventCollection();
      paramSocketClientInfo.heartAliveCheck();
      return;
    }
  }
  
  private void broadcast(JSONObject paramJSONObject)
  {
    if (this.mServerSendHandler != null)
    {
      paramJSONObject = this.mServerSendHandler.obtainMessage(3000, paramJSONObject);
      this.mServerSendHandler.sendMessage(paramJSONObject);
    }
  }
  
  private void clearAllClient()
  {
    synchronized (this.mClientsListLock)
    {
      int i = this.mCliensList.size();
      while (i > 0)
      {
        ((SocketClientInfo)this.mCliensList.get(0)).close("");
        this.mCliensList.remove(0);
        i -= 1;
      }
      handleEventCollection();
      return;
    }
  }
  
  private int createSocket()
  {
    int[] arrayOfInt;
    int i;
    if (this.mPortsPoolType == 1)
    {
      arrayOfInt = BNRemoteConstants.NAVI_PORTS_POOL;
      i = 0;
    }
    for (;;)
    {
      if (i < arrayOfInt.length) {}
      try
      {
        this.mServerSocket = new ServerSocket();
        this.mServerSocket.bind(new InetSocketAddress(arrayOfInt[i]));
        if (this.mServerSocket != null)
        {
          if (this.mServerSocket == null) {
            break label94;
          }
          LogUtil.e("BNRemote", "BNRemoteServer.............createSocket() SUCCESS");
          return 0;
          arrayOfInt = BNRemoteConstants.MAP_PORTS_POOL;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mServerSocket = null;
        }
        i += 1;
      }
    }
    label94:
    LogUtil.e("BNRemote", "BNRemoteServer.............createSocket() FAILED");
    return 1;
  }
  
  public static BNRemoteServer getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNRemoteServer();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void handleEventCollection()
  {
    try
    {
      int i = this.mCliensList.size();
      if ((i > 0) && (this.mContext != null)) {
        BNRGEventHUDCollection.getInstance().init(this.mContext, this.mBroadcast);
      }
      if (i == 0) {
        BNRGEventHUDCollection.getInstance().unInit();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void listen()
  {
    try
    {
      if (this.mIsListened) {
        return;
      }
      if (BNSettingManager.getHUDSDKSwitch() == 1)
      {
        this.mIsListened = true;
        this.mServerSendThread = new HandlerThread("send thread");
        this.mServerSendThread.start();
        this.mServerSendLooper = this.mServerSendThread.getLooper();
        this.mServerSendHandler = new ServerSendHandler(this.mServerSendLooper);
        this.mServerListenerThread = new ServerListenerThread();
        this.mServerListenerThread.start();
      }
      return;
    }
    finally {}
  }
  
  private void removeClient(SocketClientInfo paramSocketClientInfo)
  {
    LogUtil.e("BNRemote", "BNRemoteServer.......removeClient() remove client");
    synchronized (this.mClientsListLock)
    {
      this.mCliensList.remove(paramSocketClientInfo);
      handleEventCollection();
      return;
    }
  }
  
  private void sendMsgToAllClient(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    byte[] arrayOfByte = this.mClientsListLock;
    int i = 0;
    try
    {
      if (i < this.mCliensList.size())
      {
        SocketClientInfo localSocketClientInfo = (SocketClientInfo)this.mCliensList.get(i);
        boolean bool = localSocketClientInfo.checkIsAuthSuccess();
        if (bool) {}
        for (;;)
        {
          try
          {
            localSocketClientInfo.sendMsgToClient(paramJSONObject);
            i += 1;
          }
          catch (Exception localException)
          {
            localSocketClientInfo.close("");
            this.mCliensList.remove(localSocketClientInfo);
            handleEventCollection();
            continue;
          }
          LogUtil.e("BNRemote", "BNRemoteServer.............sendMsgToAllClient()...this client is not auth");
        }
      }
    }
    finally {}
  }
  
  public void init(Context paramContext, int paramInt) {}
  
  public void unInit() {}
  
  class ServerListenerThread
    extends Thread
  {
    private boolean mIsStoped = false;
    
    ServerListenerThread() {}
    
    public void quit()
    {
      this.mIsStoped = true;
    }
    
    public void run()
    {
      if (BNRemoteServer.this.createSocket() == 0)
      {
        LogUtil.e("BNRemote", "BNRemoteServer.............ServerListenerThread start RUNNNN!!");
        while (!this.mIsStoped) {
          try
          {
            Object localObject = BNRemoteServer.this.mServerSocket.accept();
            if (localObject != null)
            {
              localObject = new SocketClientInfo((Socket)localObject, BNRemoteServer.this.mContext, BNRemoteServer.this.mClientCallback, BNRemoteServer.this.mServerSendLooper);
              BNRemoteServer.this.addClient((SocketClientInfo)localObject);
            }
          }
          catch (IOException localIOException)
          {
            if (LogUtil.LOGGABLE) {
              localIOException.printStackTrace();
            }
            BNRemoteServer.this.unInit();
            this.mIsStoped = true;
          }
        }
      }
    }
  }
  
  class ServerSendHandler
    extends Handler
  {
    public ServerSendHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = (JSONObject)paramMessage.obj;
      BNRemoteServer.this.sendMsgToAllClient(paramMessage);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/socket/BNRemoteServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */