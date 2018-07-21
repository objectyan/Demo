package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MediaBrowserCompat
{
  private static final String TAG = "MediaBrowserCompat";
  private final MediaBrowserImpl mImpl;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, ConnectionCallback paramConnectionCallback, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.mImpl = new MediaBrowserImplApi23(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mImpl = new MediaBrowserImplApi21(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    this.mImpl = new MediaBrowserImplBase(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
  }
  
  public void connect()
  {
    this.mImpl.connect();
  }
  
  public void disconnect()
  {
    this.mImpl.disconnect();
  }
  
  @Nullable
  public Bundle getExtras()
  {
    return this.mImpl.getExtras();
  }
  
  public void getItem(@NonNull String paramString, @NonNull ItemCallback paramItemCallback)
  {
    this.mImpl.getItem(paramString, paramItemCallback);
  }
  
  @NonNull
  public String getRoot()
  {
    return this.mImpl.getRoot();
  }
  
  @NonNull
  public ComponentName getServiceComponent()
  {
    return this.mImpl.getServiceComponent();
  }
  
  @NonNull
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mImpl.getSessionToken();
  }
  
  public boolean isConnected()
  {
    return this.mImpl.isConnected();
  }
  
  public void subscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    this.mImpl.subscribe(paramString, paramSubscriptionCallback);
  }
  
  public void unsubscribe(@NonNull String paramString)
  {
    this.mImpl.unsubscribe(paramString);
  }
  
  public static class ConnectionCallback
  {
    final Object mConnectionCallbackObj;
    
    public ConnectionCallback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(null));
        return;
      }
      this.mConnectionCallbackObj = null;
    }
    
    public void onConnected() {}
    
    public void onConnectionFailed() {}
    
    public void onConnectionSuspended() {}
    
    private class StubApi21
      implements MediaBrowserCompatApi21.ConnectionCallback
    {
      private StubApi21() {}
      
      public void onConnected()
      {
        MediaBrowserCompat.ConnectionCallback.this.onConnected();
      }
      
      public void onConnectionFailed()
      {
        MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
      }
      
      public void onConnectionSuspended()
      {
        MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
      }
    }
  }
  
  public static abstract class ItemCallback
  {
    final Object mItemCallbackObj;
    
    public ItemCallback()
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23(null));
        return;
      }
      this.mItemCallbackObj = null;
    }
    
    public void onError(@NonNull String paramString) {}
    
    public void onItemLoaded(MediaBrowserCompat.MediaItem paramMediaItem) {}
    
    private class StubApi23
      implements MediaBrowserCompatApi23.ItemCallback
    {
      private StubApi23() {}
      
      public void onError(@NonNull String paramString)
      {
        MediaBrowserCompat.ItemCallback.this.onError(paramString);
      }
      
      public void onItemLoaded(Parcel paramParcel)
      {
        paramParcel.setDataPosition(0);
        MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(paramParcel);
        paramParcel.recycle();
        MediaBrowserCompat.ItemCallback.this.onItemLoaded(localMediaItem);
      }
    }
  }
  
  static abstract interface MediaBrowserImpl
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    @Nullable
    public abstract Bundle getExtras();
    
    public abstract void getItem(@NonNull String paramString, @NonNull MediaBrowserCompat.ItemCallback paramItemCallback);
    
    @NonNull
    public abstract String getRoot();
    
    public abstract ComponentName getServiceComponent();
    
    @NonNull
    public abstract MediaSessionCompat.Token getSessionToken();
    
    public abstract boolean isConnected();
    
    public abstract void subscribe(@NonNull String paramString, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);
    
    public abstract void unsubscribe(@NonNull String paramString);
  }
  
  static class MediaBrowserImplApi21
    implements MediaBrowserCompat.MediaBrowserImpl
  {
    protected Object mBrowserObj;
    protected Handler mHandler = new Handler();
    protected Messenger mMessenger;
    
    public MediaBrowserImplApi21(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(paramContext, paramComponentName, paramConnectionCallback.mConnectionCallbackObj, paramBundle);
    }
    
    private void sendRequest(int paramInt, Object paramObject, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.obj = paramObject;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.mMessenger.send(localMessage);
    }
    
    public void connect()
    {
      MediaBrowserCompatApi21.connect(this.mBrowserObj);
    }
    
    public void disconnect()
    {
      MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
    }
    
    @Nullable
    public Bundle getExtras()
    {
      return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
    }
    
    public void getItem(@NonNull final String paramString, @NonNull final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("mediaId is empty.");
      }
      if (paramItemCallback == null) {
        throw new IllegalArgumentException("cb is null.");
      }
      if (!MediaBrowserCompatApi21.isConnected(this.mBrowserObj))
      {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      if (this.mMessenger == null)
      {
        localObject = BundleCompat.getBinder(MediaBrowserCompatApi21.getExtras(this.mBrowserObj), "extra_messenger");
        if (localObject != null) {
          this.mMessenger = new Messenger((IBinder)localObject);
        }
      }
      if (this.mMessenger == null)
      {
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onItemLoaded(null);
          }
        });
        return;
      }
      Object localObject = new ResultReceiver(this.mHandler)
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          if ((paramAnonymousInt != 0) || (paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("media_item")))
          {
            paramItemCallback.onError(paramString);
            return;
          }
          paramAnonymousBundle = paramAnonymousBundle.getParcelable("media_item");
          if (!(paramAnonymousBundle instanceof MediaBrowserCompat.MediaItem))
          {
            paramItemCallback.onError(paramString);
            return;
          }
          paramItemCallback.onItemLoaded((MediaBrowserCompat.MediaItem)paramAnonymousBundle);
        }
      };
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("data_result_receiver", (Parcelable)localObject);
        sendRequest(5, paramString, localBundle, null);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error getting media item.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
      }
    }
    
    @NonNull
    public String getRoot()
    {
      return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
    }
    
    public ComponentName getServiceComponent()
    {
      return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken()
    {
      return MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
    }
    
    public boolean isConnected()
    {
      return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
    }
    
    public void subscribe(@NonNull String paramString, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompatApi21.subscribe(this.mBrowserObj, paramString, paramSubscriptionCallback.mSubscriptionCallbackObj);
    }
    
    public void unsubscribe(@NonNull String paramString)
    {
      MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, paramString);
    }
  }
  
  static class MediaBrowserImplApi23
    extends MediaBrowserCompat.MediaBrowserImplApi21
  {
    public MediaBrowserImplApi23(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }
    
    public void getItem(@NonNull String paramString, @NonNull MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      MediaBrowserCompatApi23.getItem(this.mBrowserObj, paramString, paramItemCallback.mItemCallbackObj);
    }
  }
  
  static class MediaBrowserImplBase
    implements MediaBrowserCompat.MediaBrowserImpl
  {
    private static final int CONNECT_STATE_CONNECTED = 2;
    private static final int CONNECT_STATE_CONNECTING = 1;
    private static final int CONNECT_STATE_DISCONNECTED = 0;
    private static final int CONNECT_STATE_SUSPENDED = 3;
    private static final boolean DBG = false;
    private final MediaBrowserCompat.ConnectionCallback mCallback;
    private Messenger mCallbacksMessenger;
    private final Context mContext;
    private Bundle mExtras;
    private final CallbackHandler mHandler = new CallbackHandler(null);
    private MediaSessionCompat.Token mMediaSessionToken;
    private final Bundle mRootHints;
    private String mRootId;
    private ServiceBinderWrapper mServiceBinderWrapper;
    private final ComponentName mServiceComponent;
    private MediaServiceConnection mServiceConnection;
    private int mState = 0;
    private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap();
    
    public MediaBrowserImplBase(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      if (paramContext == null) {
        throw new IllegalArgumentException("context must not be null");
      }
      if (paramComponentName == null) {
        throw new IllegalArgumentException("service component must not be null");
      }
      if (paramConnectionCallback == null) {
        throw new IllegalArgumentException("connection callback must not be null");
      }
      this.mContext = paramContext;
      this.mServiceComponent = paramComponentName;
      this.mCallback = paramConnectionCallback;
      this.mRootHints = paramBundle;
    }
    
    private void forceCloseConnection()
    {
      if (this.mServiceConnection != null) {
        this.mContext.unbindService(this.mServiceConnection);
      }
      this.mState = 0;
      this.mServiceConnection = null;
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mRootId = null;
      this.mMediaSessionToken = null;
    }
    
    private static String getStateLabel(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "UNKNOWN/" + paramInt;
      case 0: 
        return "CONNECT_STATE_DISCONNECTED";
      case 1: 
        return "CONNECT_STATE_CONNECTING";
      case 2: 
        return "CONNECT_STATE_CONNECTED";
      }
      return "CONNECT_STATE_SUSPENDED";
    }
    
    private boolean isCurrent(Messenger paramMessenger, String paramString)
    {
      if (this.mCallbacksMessenger != paramMessenger)
      {
        if (this.mState != 0) {
          Log.i("MediaBrowserCompat", paramString + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
        }
        return false;
      }
      return true;
    }
    
    private final void onConnectionFailed(Messenger paramMessenger)
    {
      Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
      if (!isCurrent(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (this.mState != 1)
      {
        Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
        return;
      }
      forceCloseConnection();
      this.mCallback.onConnectionFailed();
    }
    
    private final void onLoadChildren(Messenger paramMessenger, String paramString, List paramList)
    {
      if (!isCurrent(paramMessenger, "onLoadChildren")) {}
      do
      {
        return;
        paramMessenger = (Subscription)this.mSubscriptions.get(paramString);
      } while (paramMessenger == null);
      paramMessenger.callback.onChildrenLoaded(paramString, paramList);
    }
    
    private final void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!isCurrent(paramMessenger, "onConnect")) {}
      for (;;)
      {
        return;
        if (this.mState != 1)
        {
          Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
          return;
        }
        this.mRootId = paramString;
        this.mMediaSessionToken = paramToken;
        this.mExtras = paramBundle;
        this.mState = 2;
        this.mCallback.onConnected();
        paramMessenger = this.mSubscriptions.keySet().iterator();
        while (paramMessenger.hasNext())
        {
          paramString = (String)paramMessenger.next();
          try
          {
            this.mServiceBinderWrapper.addSubscription(paramString);
          }
          catch (RemoteException paramToken)
          {
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + paramString);
          }
        }
      }
    }
    
    public void connect()
    {
      if (this.mState != 0) {
        throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")");
      }
      if (this.mServiceBinderWrapper != null) {
        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.mServiceBinderWrapper);
      }
      if (this.mCallbacksMessenger != null) {
        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.mCallbacksMessenger);
      }
      this.mState = 1;
      Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
      localIntent.setComponent(this.mServiceComponent);
      final MediaServiceConnection localMediaServiceConnection = new MediaServiceConnection(null);
      this.mServiceConnection = localMediaServiceConnection;
      int i = 0;
      try
      {
        boolean bool = this.mContext.bindService(localIntent, this.mServiceConnection, 1);
        i = bool;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MediaBrowserCompat", "Failed binding to service " + this.mServiceComponent);
        }
      }
      if (i == 0) {
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (localMediaServiceConnection == MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection)
            {
              MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
              MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
            }
          }
        });
      }
    }
    
    public void disconnect()
    {
      if (this.mCallbacksMessenger != null) {}
      try
      {
        this.mServiceBinderWrapper.disconnect();
        forceCloseConnection();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.mServiceComponent);
        }
      }
    }
    
    void dump()
    {
      Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
      Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
      Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
      Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
      Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
      Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
      Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
      Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
      Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
      Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
    }
    
    @Nullable
    public Bundle getExtras()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
      }
      return this.mExtras;
    }
    
    public void getItem(@NonNull final String paramString, @NonNull final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("mediaId is empty.");
      }
      if (paramItemCallback == null) {
        throw new IllegalArgumentException("cb is null.");
      }
      if (this.mState != 2)
      {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      ResultReceiver local3 = new ResultReceiver(this.mHandler)
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          if ((paramAnonymousInt != 0) || (paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("media_item")))
          {
            paramItemCallback.onError(paramString);
            return;
          }
          paramAnonymousBundle = paramAnonymousBundle.getParcelable("media_item");
          if (!(paramAnonymousBundle instanceof MediaBrowserCompat.MediaItem))
          {
            paramItemCallback.onError(paramString);
            return;
          }
          paramItemCallback.onItemLoaded((MediaBrowserCompat.MediaItem)paramAnonymousBundle);
        }
      };
      try
      {
        this.mServiceBinderWrapper.getMediaItem(paramString, local3);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error getting media item.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
      }
    }
    
    @NonNull
    public String getRoot()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
      }
      return this.mRootId;
    }
    
    @NonNull
    public ComponentName getServiceComponent()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
      }
      return this.mServiceComponent;
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      }
      return this.mMediaSessionToken;
    }
    
    public boolean isConnected()
    {
      return this.mState == 2;
    }
    
    public void subscribe(@NonNull String paramString, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("parentId is null");
      }
      if (paramSubscriptionCallback == null) {
        throw new IllegalArgumentException("callback is null");
      }
      Subscription localSubscription = (Subscription)this.mSubscriptions.get(paramString);
      if (localSubscription == null) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localSubscription = new Subscription(paramString);
          this.mSubscriptions.put(paramString, localSubscription);
        }
        localSubscription.callback = paramSubscriptionCallback;
        if (this.mState == 2) {}
        try
        {
          this.mServiceBinderWrapper.addSubscription(paramString);
          return;
        }
        catch (RemoteException paramSubscriptionCallback)
        {
          Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + paramString);
        }
      }
    }
    
    public void unsubscribe(@NonNull String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("parentId is empty.");
      }
      Subscription localSubscription = (Subscription)this.mSubscriptions.remove(paramString);
      if ((this.mState == 2) && (localSubscription != null)) {}
      try
      {
        this.mServiceBinderWrapper.removeSubscription(paramString);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + paramString);
      }
    }
    
    private class CallbackHandler
      extends Handler
    {
      private CallbackHandler() {}
      
      public void handleMessage(Message paramMessage)
      {
        Bundle localBundle = paramMessage.getData();
        switch (paramMessage.what)
        {
        default: 
          Log.w("MediaBrowserCompat", "Unhandled message: " + paramMessage + "\n  Client version: " + 1 + "\n  Service version: " + paramMessage.arg1);
          return;
        case 1: 
          MediaBrowserCompat.MediaBrowserImplBase.this.onServiceConnected(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger, (String)paramMessage.obj, (MediaSessionCompat.Token)localBundle.getParcelable("data_media_session_token"), localBundle.getBundle("data_extras"));
          return;
        case 2: 
          MediaBrowserCompat.MediaBrowserImplBase.this.onConnectionFailed(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
          return;
        }
        MediaBrowserCompat.MediaBrowserImplBase.this.onLoadChildren(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger, (String)paramMessage.obj, localBundle.getParcelableArrayList("data_media_item_list"));
      }
    }
    
    private class MediaServiceConnection
      implements ServiceConnection
    {
      private MediaServiceConnection() {}
      
      private boolean isCurrent(String paramString)
      {
        if (MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection != this)
        {
          if (MediaBrowserCompat.MediaBrowserImplBase.this.mState != 0) {
            Log.i("MediaBrowserCompat", paramString + " for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
          }
          return false;
        }
        return true;
      }
      
      private void postOrRun(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(paramRunnable);
      }
      
      public void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
              return;
            }
            MediaBrowserCompat.MediaBrowserImplBase.access$1302(MediaBrowserCompat.MediaBrowserImplBase.this, new MediaBrowserCompat.MediaBrowserImplBase.ServiceBinderWrapper(MediaBrowserCompat.MediaBrowserImplBase.this, paramIBinder));
            MediaBrowserCompat.MediaBrowserImplBase.access$1102(MediaBrowserCompat.MediaBrowserImplBase.this, new Messenger(MediaBrowserCompat.MediaBrowserImplBase.this.mHandler));
            MediaBrowserCompat.MediaBrowserImplBase.access$1502(MediaBrowserCompat.MediaBrowserImplBase.this, 1);
            try
            {
              MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.connect();
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
            }
          }
        });
      }
      
      public void onServiceDisconnected(final ComponentName paramComponentName)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
              return;
            }
            MediaBrowserCompat.MediaBrowserImplBase.access$1302(MediaBrowserCompat.MediaBrowserImplBase.this, null);
            MediaBrowserCompat.MediaBrowserImplBase.access$1102(MediaBrowserCompat.MediaBrowserImplBase.this, null);
            MediaBrowserCompat.MediaBrowserImplBase.access$1502(MediaBrowserCompat.MediaBrowserImplBase.this, 3);
            MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
          }
        });
      }
    }
    
    private class ServiceBinderWrapper
    {
      private Messenger mMessenger;
      
      public ServiceBinderWrapper(IBinder paramIBinder)
      {
        this.mMessenger = new Messenger(paramIBinder);
      }
      
      private void sendRequest(int paramInt, Object paramObject, Bundle paramBundle, Messenger paramMessenger)
        throws RemoteException
      {
        Message localMessage = Message.obtain();
        localMessage.what = paramInt;
        localMessage.arg1 = 1;
        localMessage.obj = paramObject;
        localMessage.setData(paramBundle);
        localMessage.replyTo = paramMessenger;
        this.mMessenger.send(localMessage);
      }
      
      void addSubscription(String paramString)
        throws RemoteException
      {
        sendRequest(3, paramString, null, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
      }
      
      void connect()
        throws RemoteException
      {
        sendRequest(1, MediaBrowserCompat.MediaBrowserImplBase.this.mContext.getPackageName(), MediaBrowserCompat.MediaBrowserImplBase.this.mRootHints, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
      }
      
      void disconnect()
        throws RemoteException
      {
        sendRequest(2, null, null, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
      }
      
      void getMediaItem(String paramString, ResultReceiver paramResultReceiver)
        throws RemoteException
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("data_result_receiver", paramResultReceiver);
        sendRequest(5, paramString, localBundle, null);
      }
      
      void removeSubscription(String paramString)
        throws RemoteException
      {
        sendRequest(4, paramString, null, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
      }
    }
    
    private static class Subscription
    {
      MediaBrowserCompat.SubscriptionCallback callback;
      final String id;
      
      Subscription(String paramString)
      {
        this.id = paramString;
      }
    }
  }
  
  public static class MediaItem
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator()
    {
      public MediaBrowserCompat.MediaItem createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MediaBrowserCompat.MediaItem(paramAnonymousParcel, null);
      }
      
      public MediaBrowserCompat.MediaItem[] newArray(int paramAnonymousInt)
      {
        return new MediaBrowserCompat.MediaItem[paramAnonymousInt];
      }
    };
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;
    
    private MediaItem(Parcel paramParcel)
    {
      this.mFlags = paramParcel.readInt();
      this.mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }
    
    public MediaItem(@NonNull MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat == null) {
        throw new IllegalArgumentException("description cannot be null");
      }
      if (TextUtils.isEmpty(paramMediaDescriptionCompat.getMediaId())) {
        throw new IllegalArgumentException("description must have a non-empty media id");
      }
      this.mFlags = paramInt;
      this.mDescription = paramMediaDescriptionCompat;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    @NonNull
    public MediaDescriptionCompat getDescription()
    {
      return this.mDescription;
    }
    
    public int getFlags()
    {
      return this.mFlags;
    }
    
    @NonNull
    public String getMediaId()
    {
      return this.mDescription.getMediaId();
    }
    
    public boolean isBrowsable()
    {
      return (this.mFlags & 0x1) != 0;
    }
    
    public boolean isPlayable()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
      localStringBuilder.append("mFlags=").append(this.mFlags);
      localStringBuilder.append(", mDescription=").append(this.mDescription);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mFlags);
      this.mDescription.writeToParcel(paramParcel, paramInt);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Flags {}
  }
  
  public static abstract class SubscriptionCallback
  {
    final Object mSubscriptionCallbackObj;
    
    public SubscriptionCallback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21(null));
        return;
      }
      this.mSubscriptionCallbackObj = null;
    }
    
    public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowserCompat.MediaItem> paramList) {}
    
    public void onError(@NonNull String paramString) {}
    
    private class StubApi21
      implements MediaBrowserCompatApi21.SubscriptionCallback
    {
      private StubApi21() {}
      
      public void onChildrenLoaded(@NonNull String paramString, @NonNull List<Parcel> paramList)
      {
        Object localObject = null;
        if (paramList != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          for (;;)
          {
            localObject = localArrayList;
            if (!paramList.hasNext()) {
              break;
            }
            localObject = (Parcel)paramList.next();
            ((Parcel)localObject).setDataPosition(0);
            localArrayList.add(MediaBrowserCompat.MediaItem.CREATOR.createFromParcel((Parcel)localObject));
            ((Parcel)localObject).recycle();
          }
        }
        MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, (List)localObject);
      }
      
      public void onError(@NonNull String paramString)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/media/MediaBrowserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */