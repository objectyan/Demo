package com.baidu.carlife.logic.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.l.a;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo;
import com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeMediaProgressBarProto.CarlifeMediaProgressBar;
import com.baidu.carlife.protobuf.CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.Builder;
import com.google.protobuf.ByteString;

public class g
{
  private boolean a;
  private Context b;
  
  protected g(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private boolean c()
  {
    boolean bool = false;
    if ((f.a(f.a.g)) || (f.a(f.a.a)) || (f.a(f.a.i)) || (f.jx.a().equals("20022107")) || (f.jx.a().equals("20022108")) || (f.jx.a().equals("20022109")) || (f.jx.a().equals("20022110")) || (f.jx.a().equals("20032103"))) {
      bool = true;
    }
    return bool;
  }
  
  protected void a(int paramInt)
  {
    if ((!a.a().N()) && (this.a)) {
      return;
    }
    Object localObject1 = new c(true);
    ((c)localObject1).c(65590);
    Object localObject2 = CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.newBuilder();
    if (c()) {
      ((CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.Builder)localObject2).setProgressBar(paramInt);
    }
    for (;;)
    {
      localObject2 = ((CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.Builder)localObject2).build();
      ((c)localObject1).b(((CarlifeMediaProgressBarProto.CarlifeMediaProgressBar)localObject2).toByteArray());
      ((c)localObject1).d(((CarlifeMediaProgressBarProto.CarlifeMediaProgressBar)localObject2).getSerializedSize());
      localObject1 = Message.obtain(null, ((c)localObject1).d(), 1001, 0, localObject1);
      a.a().a((Message)localObject1);
      return;
      ((CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.Builder)localObject2).setProgressBar(paramInt * 1000);
    }
  }
  
  protected void a(MusicSongModel paramMusicSongModel, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramMusicSongModel == null) {}
    while (!a.a().N()) {
      return;
    }
    c localc = new c(true);
    localc.c(65589);
    CarlifeMediaInfoProto.CarlifeMediaInfo.Builder localBuilder = CarlifeMediaInfoProto.CarlifeMediaInfo.newBuilder();
    if (paramMusicSongModel.c == null) {
      localBuilder.setAlbum("");
    }
    for (;;)
    {
      if (paramMusicSongModel.f == null) {
        localBuilder.setArtist("");
      }
      try
      {
        label66:
        if (c()) {
          localBuilder.setDuration(Integer.parseInt(paramMusicSongModel.i));
        }
        for (;;)
        {
          if (paramMusicSongModel.b != null) {
            break label300;
          }
          localBuilder.setSong("");
          localBuilder.setMode(paramInt2);
          localBuilder.setPlaylistNum(paramInt1);
          if (paramMusicSongModel.a != null) {
            break label388;
          }
          localBuilder.setSongId("");
          if (!TextUtils.isEmpty(paramMusicSongModel.m)) {
            break label401;
          }
          localBuilder.setSource("---Inavailable Source Path---");
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
            break label414;
          }
          paramMusicSongModel = BitmapFactory.decodeResource(this.b.getResources(), 2130838794);
          localBuilder.setAlbumArt(ByteString.copyFrom(e.a().a(paramMusicSongModel)));
          paramMusicSongModel = localBuilder.build();
          localc.b(paramMusicSongModel.toByteArray());
          localc.d(paramMusicSongModel.getSerializedSize());
          paramMusicSongModel = Message.obtain(null, localc.d(), 1001, 0, localc);
          a.a().a(paramMusicSongModel);
          this.a = true;
          return;
          localBuilder.setAlbum(paramMusicSongModel.c);
          break;
          localBuilder.setArtist(paramMusicSongModel.f);
          break label66;
          localBuilder.setDuration(Integer.parseInt(paramMusicSongModel.i) / 1000);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localBuilder.setDuration(100);
          continue;
          label300:
          if (a.a().K())
          {
            byte[] arrayOfByte = paramMusicSongModel.b.getBytes();
            int i = arrayOfByte.length;
            Object localObject = paramMusicSongModel.b;
            if (i > 31)
            {
              localObject = new byte[32];
              System.arraycopy(arrayOfByte, 0, localObject, 0, 32);
              localObject = new String((byte[])localObject);
            }
            localBuilder.setSong((String)localObject);
          }
          else
          {
            localBuilder.setSong(paramMusicSongModel.b);
            continue;
            label388:
            localBuilder.setSongId(paramMusicSongModel.a);
            continue;
            label401:
            localBuilder.setSource(paramMusicSongModel.m);
            continue;
            label414:
            if (paramArrayOfByte.length < 30720)
            {
              localBuilder.setAlbumArt(ByteString.copyFrom(paramArrayOfByte));
            }
            else
            {
              try
              {
                paramArrayOfByte = Bitmap.createScaledBitmap(paramMusicSongModel.h, 160, 160, true);
                paramMusicSongModel = e.a().a(paramArrayOfByte);
                paramInt1 = 100;
                while ((paramMusicSongModel.length >= 30720) && (paramInt1 >= 10))
                {
                  paramMusicSongModel = e.a().a(paramArrayOfByte, paramInt1);
                  paramInt1 -= 10;
                }
                paramArrayOfByte = paramMusicSongModel;
              }
              catch (Exception paramMusicSongModel)
              {
                return;
              }
              if (paramMusicSongModel.length > 30720)
              {
                paramMusicSongModel = BitmapFactory.decodeResource(this.b.getResources(), 2130838794);
                paramArrayOfByte = e.a().a(paramMusicSongModel);
              }
              localBuilder.setAlbumArt(ByteString.copyFrom(paramArrayOfByte));
            }
          }
        }
      }
    }
  }
  
  protected boolean a()
  {
    return this.a;
  }
  
  protected void b()
  {
    this.a = false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */