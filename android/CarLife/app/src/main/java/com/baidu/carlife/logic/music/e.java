package com.baidu.carlife.logic.music;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.a;
import com.baidu.carlife.util.p;
import com.baidu.navi.utils.CharacterParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class e
  extends b
{
  private static final String T = "content://media/external/audio/albums";
  private static final String[] U = { "_data", "title", "album", "album_id", "artist", "duration", "title_key", "_id" };
  private static final int V = 0;
  private static final int W = 1;
  private static final int X = 2;
  private static final int Y = 3;
  private static final int Z = 4;
  private static final int aa = 5;
  private static final int ab = 6;
  private static final int ac = 7;
  private static final String ad = "LocalMusicIndex";
  
  public e(Context paramContext)
  {
    this.E = a.a[0];
    e(this.E);
    a(paramContext.getResources().getString(2131296646));
    this.C = paramContext;
    this.F = 0;
    a(1);
    new Thread(new Runnable()
    {
      public void run()
      {
        e.this.a(e.this.n(), e.this.A());
        e.this.f(e.a(e.this));
        if ((e.this.g() != null) && (!e.this.g().isEmpty()))
        {
          e.this.b(2);
          return;
        }
        e.this.b(3);
      }
    }).start();
  }
  
  private int B()
  {
    List localList = g();
    int i = p.a().a("LocalMusicIndex", 0);
    i.b("ouyang", "---getLocalMusicRecentIndex:" + i);
    if ((localList != null) && (i < localList.size()))
    {
      if (new File(((MusicSongModel)localList.get(i)).m).exists()) {
        return i;
      }
      return 0;
    }
    return 0;
  }
  
  private Bitmap m(String paramString)
  {
    try
    {
      localObject2 = this.C.getContentResolver().query(Uri.parse(paramString), new String[] { "album_art" }, null, null, null);
      if (localObject2 == null) {
        return null;
      }
    }
    catch (IllegalStateException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    Object localObject1 = null;
    paramString = (String)localObject1;
    if (((Cursor)localObject2).getCount() > 0)
    {
      paramString = (String)localObject1;
      if (((Cursor)localObject2).getColumnCount() > 0)
      {
        ((Cursor)localObject2).moveToNext();
        paramString = ((Cursor)localObject2).getString(0);
      }
    }
    ((Cursor)localObject2).close();
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    localObject1 = new File(paramString);
    int k = 0;
    int i = 0;
    paramString = null;
    for (;;)
    {
      try
      {
        localObject2 = new FileInputStream((File)localObject1);
        if (localObject2 != null) {}
        int j;
        long l;
        localIOException1.printStackTrace();
      }
      catch (IOException localIOException1)
      {
        try
        {
          j = ((FileInputStream)localObject2).read();
          k = i;
          if (j != 255)
          {
            k = i;
            if (j != 137)
            {
              i += 1;
              j = ((FileInputStream)localObject2).read();
              continue;
            }
          }
          ((FileInputStream)localObject2).close();
          localObject1 = new FileInputStream((File)localObject1);
          l = k;
          paramString = (String)localObject1;
          ((FileInputStream)localObject1).skip(l);
          paramString = (String)localObject1;
          if (paramString != null) {
            break;
          }
          return null;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            paramString = (String)localObject2;
          }
        }
        localIOException1 = localIOException1;
      }
    }
    try
    {
      paramString = BitmapFactory.decodeStream(paramString);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      return null;
    }
  }
  
  protected List<MusicSongModel> A()
  {
    ArrayList localArrayList = new ArrayList();
    q.T.clear();
    if (this.C == null) {}
    Cursor localCursor;
    MusicSongModel localMusicSongModel;
    label228:
    long l1;
    long l3;
    long l4;
    long l5;
    long l6;
    label666:
    label677:
    do
    {
      return localArrayList;
      ContentResolver localContentResolver = this.C.getContentResolver();
      int k;
      Object localObject2;
      for (;;)
      {
        Object localObject1;
        try
        {
          localCursor = localContentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, U, null, null, " date_added DESC");
          if ((localCursor == null) || (localCursor.getCount() <= 0)) {
            break label677;
          }
          localCursor.moveToFirst();
          if (localCursor.isAfterLast()) {
            break label677;
          }
          k = 0;
          localMusicSongModel = new MusicSongModel();
          localObject1 = localCursor.getString(0);
          localMusicSongModel.m = ((String)localObject1);
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
          {
            localCursor.moveToNext();
            continue;
          }
          localObject2 = ((String)localObject1).split("/");
        }
        catch (Exception localException)
        {
          return localArrayList;
        }
        j = k;
        String str;
        long l2;
        if (localObject2.length > 1)
        {
          Object localObject3 = localObject2[(localObject2.length - 2)];
          str = "";
          if (localObject2.length > 2) {
            str = localObject2[(localObject2.length - 3)];
          }
          if (!((String)localObject3).equals("BaiduCarlife"))
          {
            if (!str.equals("qqmusic")) {
              break;
            }
            j = 1;
          }
        }
        else
        {
          localMusicSongModel.b = localCursor.getString(1);
          localMusicSongModel.c = localCursor.getString(2);
          localMusicSongModel.d = Integer.toString(localCursor.getInt(3));
          str = localCursor.getString(4);
          localMusicSongModel.f = str;
          l2 = localCursor.getLong(5);
          l1 = l2;
          if (l2 == 0L)
          {
            localObject2 = new MediaPlayer();
            l3 = l2;
            l4 = l2;
            l5 = l2;
            l6 = l2;
          }
        }
        try
        {
          ((MediaPlayer)localObject2).setDataSource((String)localObject1);
          l3 = l2;
          l4 = l2;
          l5 = l2;
          l6 = l2;
          ((MediaPlayer)localObject2).setAudioStreamType(3);
          l3 = l2;
          l4 = l2;
          l5 = l2;
          l6 = l2;
          ((MediaPlayer)localObject2).prepare();
          l3 = l2;
          l4 = l2;
          l5 = l2;
          l6 = l2;
          l1 = ((MediaPlayer)localObject2).getDuration();
          l3 = l1;
          l4 = l1;
          l5 = l1;
          l6 = l1;
          ((MediaPlayer)localObject2).release();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            int m;
            localIllegalArgumentException.printStackTrace();
            l1 = l3;
          }
        }
        catch (SecurityException localSecurityException)
        {
          for (;;)
          {
            localSecurityException.printStackTrace();
            l1 = l4;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          for (;;)
          {
            localIllegalStateException.printStackTrace();
            l1 = l5;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
            l1 = l6;
            continue;
            localMusicSongModel.p = "Z";
          }
        }
        if ((l1 >= 61000L) && (l1 <= 600000L))
        {
          localMusicSongModel.i = String.valueOf(l1);
          localMusicSongModel.a = String.valueOf(localCursor.getLong(7));
          localMusicSongModel.g = localMusicSongModel.a;
          if (TextUtils.isEmpty(str)) {
            break label666;
          }
          localObject1 = new StringBuilder();
          CharacterParser.getAbbreviation(str.substring(0, 1), (StringBuilder)localObject1);
          localMusicSongModel.p = new String((StringBuilder)localObject1).toUpperCase();
          localArrayList.add(localMusicSongModel);
          if (j != 0) {
            q.T.add(localMusicSongModel);
          }
        }
      }
      m = 0;
      int j = 0;
      for (;;)
      {
        int i = m;
        if (j < localObject2.length - 1)
        {
          if (localObject2[j].toLowerCase(Locale.getDefault()).contains("record")) {
            i = 1;
          }
        }
        else
        {
          j = k;
          if (i == 0) {
            break label228;
          }
          break;
        }
        j += 1;
      }
    } while (localCursor == null);
    localCursor.close();
    return localArrayList;
  }
  
  @Deprecated
  public int a(int paramInt, String paramString)
  {
    return 0;
  }
  
  public int a(String paramString1, String paramString2)
  {
    int j;
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    Object localObject = g();
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label97;
      }
      MusicSongModel localMusicSongModel = (MusicSongModel)((Iterator)localObject).next();
      if (localMusicSongModel.f.contains(paramString1))
      {
        j = i;
        if (localMusicSongModel.b.contains(paramString2)) {
          break;
        }
      }
      i += 1;
    }
    label97:
    return -1;
  }
  
  @Deprecated
  public void b(boolean paramBoolean) {}
  
  public Bitmap d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = h(paramString);
    try
    {
      paramString = a.a(this.C, Long.parseLong(paramString.a), Long.parseLong(paramString.d), true);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString) {}
    return null;
  }
  
  @Deprecated
  public void d(int paramInt) {}
  
  @Deprecated
  public boolean e(int paramInt)
  {
    return false;
  }
  
  public List<MusicSongModel> g()
  {
    return f(n());
  }
  
  @Deprecated
  public void h() {}
  
  public int k(String paramString)
  {
    int j;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    Object localObject = g();
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label78;
      }
      j = i;
      if (((MusicSongModel)((Iterator)localObject).next()).b.contains(paramString)) {
        break;
      }
      i += 1;
    }
    label78:
    return -1;
  }
  
  public int l(String paramString)
  {
    int j;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    Object localObject = g();
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label78;
      }
      j = i;
      if (((MusicSongModel)((Iterator)localObject).next()).f.contains(paramString)) {
        break;
      }
      i += 1;
    }
    label78:
    return -1;
  }
  
  public void z()
  {
    i.b("ouyang", "---setLocalMusicRecentIndex:" + this.B);
    p.a().b("LocalMusicIndex", this.B);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */