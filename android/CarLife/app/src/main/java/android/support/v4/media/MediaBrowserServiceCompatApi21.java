package android.support.v4.media;

import android.a.a.a.a;
import android.a.a.b;
import android.content.Intent;
import android.content.pm.ParceledListSlice;
import android.media.MediaDescription.Builder;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompatApi21
{
  public static Object createService()
  {
    return new MediaBrowserServiceAdaptorApi21();
  }
  
  public static IBinder onBind(Object paramObject, Intent paramIntent)
  {
    return ((MediaBrowserServiceAdaptorApi21)paramObject).onBind(paramIntent);
  }
  
  public static void onCreate(Object paramObject, ServiceImplApi21 paramServiceImplApi21)
  {
    ((MediaBrowserServiceAdaptorApi21)paramObject).onCreate(paramServiceImplApi21);
  }
  
  static class MediaBrowserServiceAdaptorApi21
  {
    ServiceBinderProxyApi21 mBinder;
    
    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction())) {
        return this.mBinder;
      }
      return null;
    }
    
    public void onCreate(MediaBrowserServiceCompatApi21.ServiceImplApi21 paramServiceImplApi21)
    {
      this.mBinder = new ServiceBinderProxyApi21(paramServiceImplApi21);
    }
    
    static class ServiceBinderProxyApi21
      extends a.a
    {
      final MediaBrowserServiceCompatApi21.ServiceImplApi21 mServiceImpl;
      
      ServiceBinderProxyApi21(MediaBrowserServiceCompatApi21.ServiceImplApi21 paramServiceImplApi21)
      {
        this.mServiceImpl = paramServiceImplApi21;
      }
      
      public void addSubscription(String paramString, b paramb)
      {
        this.mServiceImpl.addSubscription(paramString, new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(paramb));
      }
      
      public void connect(String paramString, Bundle paramBundle, b paramb)
      {
        this.mServiceImpl.connect(paramString, paramBundle, new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(paramb));
      }
      
      public void disconnect(b paramb)
      {
        this.mServiceImpl.disconnect(new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(paramb));
      }
      
      public void getMediaItem(String paramString, ResultReceiver paramResultReceiver) {}
      
      public void removeSubscription(String paramString, b paramb)
      {
        this.mServiceImpl.removeSubscription(paramString, new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(paramb));
      }
    }
  }
  
  public static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();
    
    public abstract void onConnect(String paramString, Object paramObject, Bundle paramBundle)
      throws RemoteException;
    
    public abstract void onConnectFailed()
      throws RemoteException;
    
    public abstract void onLoadChildren(String paramString, List<Parcel> paramList)
      throws RemoteException;
  }
  
  public static class ServiceCallbacksApi21
    implements MediaBrowserServiceCompatApi21.ServiceCallbacks
  {
    private static final ParceledListSlice sNullParceledListSlice;
    private final b mCallbacks;
    
    static
    {
      MediaBrowser.MediaItem localMediaItem = new MediaBrowser.MediaItem(new MediaDescription.Builder().setMediaId("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM").build(), 0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localMediaItem);
      sNullParceledListSlice = new ParceledListSlice(localArrayList);
    }
    
    ServiceCallbacksApi21(b paramb)
    {
      this.mCallbacks = paramb;
    }
    
    public IBinder asBinder()
    {
      return this.mCallbacks.asBinder();
    }
    
    public void onConnect(String paramString, Object paramObject, Bundle paramBundle)
      throws RemoteException
    {
      this.mCallbacks.a(paramString, (MediaSession.Token)paramObject, paramBundle);
    }
    
    public void onConnectFailed()
      throws RemoteException
    {
      this.mCallbacks.a();
    }
    
    public void onLoadChildren(String paramString, List<Parcel> paramList)
      throws RemoteException
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
          localArrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel((Parcel)localObject));
          ((Parcel)localObject).recycle();
        }
      }
      if (Build.VERSION.SDK_INT > 23)
      {
        if (localObject == null) {}
        for (paramList = null;; paramList = new ParceledListSlice((List)localObject))
        {
          this.mCallbacks.a(paramString, paramList);
          return;
        }
      }
      if (localObject == null) {}
      for (paramList = sNullParceledListSlice;; paramList = new ParceledListSlice((List)localObject)) {
        break;
      }
    }
  }
  
  public static abstract interface ServiceImplApi21
  {
    public abstract void addSubscription(String paramString, MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks);
    
    public abstract void connect(String paramString, Bundle paramBundle, MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks);
    
    public abstract void disconnect(MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks);
    
    public abstract void removeSubscription(String paramString, MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/media/MediaBrowserServiceCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */