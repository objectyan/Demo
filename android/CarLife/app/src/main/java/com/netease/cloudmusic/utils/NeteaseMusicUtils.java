package com.netease.cloudmusic.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.carlife.core.a;
import com.baidu.carlife.model.MusicSongModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NeteaseMusicUtils
{
  private static final int BITRATE_DEFAULT = 160;
  private static final int BITRATE_HIGH = 320;
  private static final int BITRATE_LOW = 96;
  private static final int LOAD_MORE_INTERVAL = 20;
  private static final String NETEASE_MUSIC_SERVER_URI = "http://api.music.163.com/openapi/baidu";
  private static final String REQUEST_PARAM_IMAGE = "param=200y200&quality=70";
  private static final int RESULTCODE_FAIL_NETEASE_SERVER = 500;
  private static final int RESULTCODE_OK_NETEASE_SERVER = 200;
  private static final String TAG = "NeteaseMusicUtils";
  private static final int TYPE_NETEASE_REQUEST_DJRADIO = 3;
  private static final int TYPE_NETEASE_REQUEST_DJRADIO_CHILD = 4;
  private static final int TYPE_NETEASE_REQUEST_PLAYLIST = 2;
  private static final int TYPE_NETEASE_REQUEST_TOPLIST = 1;
  private static boolean isDownloadSong = false;
  private static long mCurSongDownloadSize = 0L;
  private static long mCurSongTotalSize = 0L;
  
  static
  {
    System.loadLibrary("poison");
    nativeInit(a.a());
  }
  
  public static void abortDownloadSong()
  {
    isDownloadSong = false;
  }
  
  public static long getCurSongDownloadSize()
  {
    return mCurSongDownloadSize;
  }
  
  public static long getCurSongTotalSize()
  {
    return mCurSongTotalSize;
  }
  
  public static Bitmap getImage(String paramString)
  {
    Bitmap localBitmap = null;
    Object localObject = paramString + "?" + "param=200y200&quality=70";
    paramString = localBitmap;
    try
    {
      localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
      paramString = localBitmap;
      ((HttpURLConnection)localObject).setConnectTimeout(5000);
      paramString = localBitmap;
      ((HttpURLConnection)localObject).setReadTimeout(3000);
      paramString = localBitmap;
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      paramString = localBitmap;
      if (((HttpURLConnection)localObject).getResponseCode() == 200)
      {
        paramString = localBitmap;
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------getImage OK-------");
        paramString = localBitmap;
        localObject = ((HttpURLConnection)localObject).getInputStream();
        paramString = localBitmap;
        localBitmap = BitmapFactory.decodeStream((InputStream)localObject);
        paramString = localBitmap;
        ((InputStream)localObject).close();
        return localBitmap;
      }
      paramString = localBitmap;
      com.baidu.carlife.core.i.e("NeteaseMusicUtils", "------get netease data Failed!!!---------");
      return null;
    }
    catch (SocketTimeoutException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static String getMusicUrlById(String paramString)
  {
    paramString = getUrlParameters("/url", "{\"songId\":\"" + paramString + "\",\"bitrate\":" + 96 + "}");
    try
    {
      paramString = "http://api.music.163.com/openapi/baidu?params=" + URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<com.baidu.carlife.model.i> getPlayList()
  {
    return getThemeList("/playlist/oftag", "{\"name\":华语,\"order\":hot|new,\"limit\":20,\"offset\":0}", 2);
  }
  
  public static ArrayList<MusicSongModel> getPlaylistDetail(String paramString)
  {
    String str = "{\"limit\":20,\"offset\":0,\"id\":" + paramString + "}";
    try
    {
      paramString = new HttpPost("http://api.music.163.com/openapi/baidu");
      com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------before");
      str = getUrlParameters("/playlist/tracks", str);
      com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------tmpPa:" + str);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("params", str));
      paramString.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
      paramString = new DefaultHttpClient().execute(paramString);
      int i = paramString.getStatusLine().getStatusCode();
      com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------resultCode:" + i);
      if (200 == i) {
        return parsePlayMusicList(EntityUtils.toString(paramString.getEntity()));
      }
      com.baidu.carlife.core.i.e("NeteaseMusicUtils", "------get netease data Failed!!!---------");
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (ClientProtocolException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean getSearchMusicList(String paramString1, String paramString2, List<MusicSongModel> paramList, int paramInt)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    bool1 = true;
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("keyword", paramString1 + " " + paramString2);
        ((JSONObject)localObject).put("type", 1);
        ((JSONObject)localObject).put("limit", 20);
        ((JSONObject)localObject).put("offset", paramInt * 20);
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      try
      {
        paramString1 = new HttpPost("http://api.music.163.com/openapi/baidu");
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        paramString2 = getUrlParameters("/search", ((JSONObject)localObject).toString());
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------params:" + ((JSONObject)localObject).toString());
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        localObject = new ArrayList();
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        ((List)localObject).add(new BasicNameValuePair("params", paramString2));
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        paramString1.setEntity(new UrlEncodedFormEntity((List)localObject, "UTF-8"));
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        paramString1 = new DefaultHttpClient().execute(paramString1);
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        if (200 != paramString1.getStatusLine().getStatusCode()) {
          break label394;
        }
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        paramString1 = EntityUtils.toString(paramString1.getEntity());
        bool2 = bool5;
        bool3 = bool6;
        bool4 = bool7;
        bool1 = parseSearchMusicList(paramString1, paramList);
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------result:" + paramString1);
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        bool1 = bool2;
        continue;
      }
      catch (ClientProtocolException paramString1)
      {
        paramString1.printStackTrace();
        bool1 = bool3;
        continue;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        bool1 = bool4;
        continue;
      }
      return bool1;
      label394:
      bool2 = bool5;
      bool3 = bool6;
      bool4 = bool7;
      com.baidu.carlife.core.i.e("NeteaseMusicUtils", "------get netease data Failed!!!---------");
    }
  }
  
  public static String getSimpleSongUrl(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    paramString = "{\"songId\":\"" + paramString + "\",\"bitrate\":" + 96 + "}";
    com.baidu.carlife.core.i.b("NeteaseMusicUtils", "---------------paramJson:" + paramString);
    paramString = getUrlParameters("/url", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("params", paramString));
    paramString = "http://api.music.163.com/openapi/baidu?" + URLEncodedUtils.format(localArrayList, "UTF-8");
    com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------tmpPa:" + paramString);
    return paramString;
  }
  
  private static ArrayList<com.baidu.carlife.model.i> getThemeList(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return null;
      try
      {
        HttpPost localHttpPost = new HttpPost("http://api.music.163.com/openapi/baidu");
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------before");
        paramString1 = getUrlParameters(paramString1, paramString2);
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------tmpPa:" + paramString1);
        paramString2 = new ArrayList();
        paramString2.add(new BasicNameValuePair("params", paramString1));
        localHttpPost.setEntity(new UrlEncodedFormEntity(paramString2, "UTF-8"));
        paramString1 = new DefaultHttpClient().execute(localHttpPost);
        int i = paramString1.getStatusLine().getStatusCode();
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------resultCode:" + i);
        if (200 == i) {
          paramString1 = EntityUtils.toString(paramString1.getEntity());
        }
        switch (paramInt)
        {
        case 1: 
          return parseTopList(paramString1);
        case 2: 
          return parsePlayList(paramString1);
          if (500 == i)
          {
            com.baidu.carlife.core.i.e("NeteaseMusicUtils", "------get netease data Failed!!!---------");
            return null;
          }
          break;
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      catch (ClientProtocolException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static ArrayList<com.baidu.carlife.model.i> getTopList()
  {
    return getThemeList("/toplist", "{}", 1);
  }
  
  public static ArrayList<MusicSongModel> getToplistDetail(String paramString)
  {
    String str = "{\"id\":" + paramString + "}";
    try
    {
      paramString = new HttpPost("http://api.music.163.com/openapi/baidu");
      str = getUrlParameters("/toplist/detail", str);
      com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------tmpPa:" + str);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("params", str));
      paramString.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
      paramString = new DefaultHttpClient().execute(paramString);
      if (200 == paramString.getStatusLine().getStatusCode())
      {
        paramString = EntityUtils.toString(paramString.getEntity());
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-------HTPPRESPONSE-------result:" + paramString);
        return parseTopMusicList(paramString);
      }
      com.baidu.carlife.core.i.e("NeteaseMusicUtils", "------get netease data Failed!!!---------");
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (ClientProtocolException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static native String getUrlParameters(String paramString1, String paramString2);
  
  public static native void nativeInit(Context paramContext);
  
  private static ArrayList<com.baidu.carlife.model.i> parsePlayList(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("data");
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramString = localJSONArray.getJSONObject(i);
          com.baidu.carlife.model.i locali = new com.baidu.carlife.model.i();
          locali.a = paramString.getString("name").trim();
          locali.b = paramString.getString("coverUrl").trim();
          locali.c = String.valueOf(paramString.getLong("id"));
          localArrayList.add(locali);
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static ArrayList<MusicSongModel> parsePlayMusicList(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("data");
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-----parseMusicList---length:" + localJSONArray.length());
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramString = localJSONArray.getJSONObject(i);
          if (paramString.getBoolean("canPlay"))
          {
            MusicSongModel localMusicSongModel = new MusicSongModel();
            localMusicSongModel.b = paramString.getString("name").trim();
            localMusicSongModel.f = paramString.getString("albumArtistName").trim();
            localMusicSongModel.i = paramString.getString("duration").trim();
            localMusicSongModel.a = paramString.getString("id").trim();
            localMusicSongModel.g = paramString.getString("coverUrl").trim();
            localMusicSongModel.c = paramString.getString("albumName").trim();
            localArrayList.add(localMusicSongModel);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static boolean parseSearchMusicList(String paramString, List<MusicSongModel> paramList)
  {
    boolean bool2;
    if ((paramString == null) || (paramString.length() == 0)) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      bool2 = true;
      bool1 = bool2;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        bool1 = bool2;
        boolean bool3 = localJSONObject.getBoolean("hasMore");
        bool1 = bool3;
        paramString = localJSONObject.getJSONObject("data").getJSONArray("mediaList");
        bool1 = bool3;
        int i = localJSONObject.getJSONObject("data").getInt("totalCount");
        bool1 = bool3;
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-----parseMusicList---length:" + paramString.length() + ", totalCount:" + i + ", hasMore:" + bool3);
        i = 0;
        for (;;)
        {
          bool2 = bool3;
          bool1 = bool3;
          if (i >= paramString.length()) {
            break;
          }
          bool1 = bool3;
          localJSONObject = paramString.getJSONObject(i);
          bool1 = bool3;
          if (localJSONObject.getBoolean("canPlay"))
          {
            bool1 = bool3;
            MusicSongModel localMusicSongModel = new MusicSongModel();
            bool1 = bool3;
            localMusicSongModel.b = localJSONObject.getString("name").trim();
            bool1 = bool3;
            localMusicSongModel.f = localJSONObject.getString("albumArtistName").trim();
            bool1 = bool3;
            localMusicSongModel.i = localJSONObject.getString("duration").trim();
            bool1 = bool3;
            localMusicSongModel.a = localJSONObject.getString("id").trim();
            bool1 = bool3;
            localMusicSongModel.g = localJSONObject.getString("coverUrl").trim();
            bool1 = bool3;
            localMusicSongModel.c = localJSONObject.getString("albumName").trim();
            bool1 = bool3;
            paramList.add(localMusicSongModel);
          }
          i += 1;
        }
        return bool1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static ArrayList<com.baidu.carlife.model.i> parseTopList(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("data");
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramString = localJSONArray.getJSONObject(i);
          com.baidu.carlife.model.i locali = new com.baidu.carlife.model.i();
          locali.a = paramString.getString("name").trim();
          locali.b = paramString.getString("coverUrl").trim();
          locali.c = String.valueOf(paramString.getLong("id"));
          localArrayList.add(locali);
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static ArrayList<MusicSongModel> parseTopMusicList(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONObject("data").getJSONArray("tracks");
        com.baidu.carlife.core.i.b("NeteaseMusicUtils", "-----parseMusicList---length:" + localJSONArray.length());
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramString = localJSONArray.getJSONObject(i);
          if (paramString.getBoolean("canPlay"))
          {
            MusicSongModel localMusicSongModel = new MusicSongModel();
            localMusicSongModel.b = paramString.getString("name").trim();
            localMusicSongModel.f = paramString.getString("albumArtistName").trim();
            localMusicSongModel.i = paramString.getString("duration").trim();
            localMusicSongModel.a = paramString.getString("id").trim();
            localMusicSongModel.g = paramString.getString("coverUrl").trim();
            localMusicSongModel.c = paramString.getString("albumName").trim();
            localArrayList.add(localMusicSongModel);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/netease/cloudmusic/utils/NeteaseMusicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */