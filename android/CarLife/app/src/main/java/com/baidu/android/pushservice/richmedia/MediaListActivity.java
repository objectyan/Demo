package com.baidu.android.pushservice.richmedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.pushservice.d.a.g;
import com.baidu.android.pushservice.j.p;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaListActivity
  extends Activity
{
  private static String r = "downloadUrl";
  ArrayList<HashMap<String, Object>> a;
  NotificationManager b;
  private ListView c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private LinearLayout l = null;
  private RemoteViews m;
  private int n;
  private int o;
  private int p;
  private int q;
  private final AdapterView.OnItemClickListener s = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = (String)((HashMap)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt)).get(MediaListActivity.a());
      paramAnonymousView = com.baidu.android.pushservice.d.a.a(MediaListActivity.this, paramAnonymousAdapterView);
      ContentValues localContentValues;
      if (paramAnonymousView != null)
      {
        if (paramAnonymousView.i != a.f) {
          break label213;
        }
        paramAnonymousAdapterView = paramAnonymousView.e;
        paramAnonymousView = paramAnonymousView.f;
        if (paramAnonymousView.length() > 0)
        {
          paramAnonymousAdapterView = paramAnonymousAdapterView + "/" + paramAnonymousView.substring(0, paramAnonymousView.lastIndexOf(".")) + "/index.html";
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(MediaListActivity.this, MediaViewActivity.class);
          paramAnonymousInt = p.A(MediaListActivity.this, MediaListActivity.this.getPackageName());
          paramAnonymousAdapterView = new File(paramAnonymousAdapterView);
          if (paramAnonymousInt < 24) {
            break label205;
          }
          localContentValues = new ContentValues(1);
          localContentValues.put("_data", paramAnonymousAdapterView.getAbsolutePath());
        }
      }
      label205:
      for (paramAnonymousAdapterView = MediaListActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);; paramAnonymousAdapterView = Uri.fromFile(paramAnonymousAdapterView))
      {
        paramAnonymousView.setData(paramAnonymousAdapterView);
        paramAnonymousView.addFlags(268435456);
        MediaListActivity.this.startActivity(paramAnonymousView);
        return;
      }
      label213:
      MediaListActivity.a(MediaListActivity.this, paramAnonymousView.b, paramAnonymousView.c, paramAnonymousView.d);
    }
  };
  private final AdapterView.OnItemLongClickListener t = new AdapterView.OnItemLongClickListener()
  {
    public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, final long paramAnonymousLong)
    {
      new AlertDialog.Builder(MediaListActivity.this).setTitle("提示").setMessage("确定要删除该记录？").setPositiveButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          paramAnonymous2DialogInterface = (String)((Map)MediaListActivity.this.a.get((int)paramAnonymousLong)).get(MediaListActivity.a());
          a.g localg = com.baidu.android.pushservice.d.a.a(MediaListActivity.this, paramAnonymous2DialogInterface);
          if (localg != null) {
            new File(localg.e).delete();
          }
          com.baidu.android.pushservice.d.a.b(MediaListActivity.this, paramAnonymous2DialogInterface);
          paramAnonymous2DialogInterface = new Intent();
          paramAnonymous2DialogInterface.setClass(MediaListActivity.this, MediaListActivity.class);
          MediaListActivity.this.startActivity(paramAnonymous2DialogInterface);
        }
      }).setNegativeButton("取消", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
      }).show();
      return true;
    }
  };
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = Uri.parse(paramString1);
    String str = ((Uri)localObject).getPath();
    paramString1 = new String();
    if (str.length() > 0) {
      paramString1 = str.substring(0, str.lastIndexOf('/'));
    }
    paramString1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "baidu/pushservice/files" + "/" + ((Uri)localObject).getAuthority() + "/" + paramString1);
    localObject = d.a(c.a.a, ((Uri)localObject).toString());
    ((c)localObject).b = paramString1.getAbsolutePath();
    ((c)localObject).c = paramString2;
    ((c)localObject).d = paramString3;
    new a(this, new f()
    {
      public void a(a paramAnonymousa) {}
      
      public void a(a paramAnonymousa, b paramAnonymousb)
      {
        String str = paramAnonymousa.d.c();
        if (paramAnonymousb.a == paramAnonymousb.b) {}
        while (MediaListActivity.a(MediaListActivity.this) == null) {
          return;
        }
        int i = (int)(paramAnonymousb.a * 100.0D / paramAnonymousb.b);
        MediaListActivity.a(MediaListActivity.this).setTextViewText(MediaListActivity.b(MediaListActivity.this), i + "%");
        MediaListActivity.a(MediaListActivity.this).setTextViewText(MediaListActivity.c(MediaListActivity.this), str);
        MediaListActivity.a(MediaListActivity.this).setProgressBar(MediaListActivity.d(MediaListActivity.this), 100, i, false);
        MediaListActivity.a(MediaListActivity.this).setImageViewResource(MediaListActivity.e(MediaListActivity.this), 17301633);
        if (Build.VERSION.SDK_INT >= 16) {}
        for (paramAnonymousa = new Notification.Builder(MediaListActivity.this).setSmallIcon(17301633).setWhen(System.currentTimeMillis()).build();; paramAnonymousa = new Notification(17301633, null, System.currentTimeMillis()))
        {
          paramAnonymousa.contentView = MediaListActivity.a(MediaListActivity.this);
          paramAnonymousa.contentIntent = PendingIntent.getActivity(MediaListActivity.this, 0, new Intent(), 0);
          paramAnonymousa.flags |= 0x20;
          paramAnonymousa.flags |= 0x2;
          MediaListActivity.this.b.notify(str, 0, paramAnonymousa);
          return;
        }
      }
      
      public void a(a paramAnonymousa, e paramAnonymouse)
      {
        paramAnonymousa = paramAnonymousa.d.c();
        MediaListActivity.this.b.cancel(paramAnonymousa, 0);
        paramAnonymouse = com.baidu.android.pushservice.d.a.a(MediaListActivity.this, paramAnonymousa);
        ContentValues localContentValues;
        if ((paramAnonymouse != null) && (paramAnonymouse.i == a.f))
        {
          paramAnonymousa = paramAnonymouse.e;
          paramAnonymouse = paramAnonymouse.f;
          if (paramAnonymouse.length() > 0)
          {
            paramAnonymousa = paramAnonymousa + "/" + paramAnonymouse.substring(0, paramAnonymouse.lastIndexOf(".")) + "/index.html";
            paramAnonymouse = new Intent();
            paramAnonymouse.setClass(MediaListActivity.this, MediaViewActivity.class);
            int i = p.A(MediaListActivity.this, MediaListActivity.this.getPackageName());
            paramAnonymousa = new File(paramAnonymousa);
            if (i < 24) {
              break label207;
            }
            localContentValues = new ContentValues(1);
            localContentValues.put("_data", paramAnonymousa.getAbsolutePath());
          }
        }
        label207:
        for (paramAnonymousa = MediaListActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);; paramAnonymousa = Uri.fromFile(paramAnonymousa))
        {
          paramAnonymouse.setData(paramAnonymousa);
          paramAnonymouse.addFlags(268435456);
          MediaListActivity.this.startActivity(paramAnonymouse);
          return;
        }
      }
      
      public void a(a paramAnonymousa, Throwable paramAnonymousThrowable)
      {
        paramAnonymousa = paramAnonymousa.d.c();
        MediaListActivity.this.b.cancel(paramAnonymousa, 0);
        MediaListActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Toast localToast = Toast.makeText(MediaListActivity.this, "下载富媒体失败", 1);
            localToast.setGravity(17, 0, 0);
            localToast.show();
          }
        });
      }
      
      public void b(a paramAnonymousa)
      {
        paramAnonymousa = paramAnonymousa.d.c();
        MediaListActivity.this.b.cancel(paramAnonymousa, 0);
      }
    }, (c)localObject).start();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getResources().getIdentifier("bpush_media_list", "layout", getPackageName());
    requestWindowFeature(1);
    if (this.d != 0)
    {
      setContentView(this.d);
      paramBundle = getResources();
      String str = getPackageName();
      this.e = paramBundle.getIdentifier("bpush_media_list_item", "layout", str);
      this.f = paramBundle.getIdentifier("bpush_type_listview", "id", str);
      this.g = paramBundle.getIdentifier("bpush_media_list_img", "id", str);
      this.h = paramBundle.getIdentifier("bpush_media_list_title", "id", str);
      this.i = paramBundle.getIdentifier("bpush_media_list_from_text", "id", str);
      this.j = paramBundle.getIdentifier("bpush_media_list_time_text", "id", str);
      this.k = paramBundle.getIdentifier("bpush_media_none_layout", "id", str);
      this.l = ((LinearLayout)findViewById(this.k));
      this.c = ((ListView)findViewById(this.f));
      paramBundle = (Button)findViewById(paramBundle.getIdentifier("bpush_media_list_return_btn", "id", str));
      paramBundle.setClickable(true);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MediaListActivity.this.finish();
        }
      });
      int i1 = getResources().getIdentifier("bpush_download_progress", "layout", getPackageName());
      if (i1 != 0)
      {
        this.m = new RemoteViews(getPackageName(), i1);
        this.n = getResources().getIdentifier("bpush_downLoad_progress", "id", getPackageName());
        this.o = getResources().getIdentifier("bpush_progress_percent", "id", getPackageName());
        this.p = getResources().getIdentifier("bpush_progress_text", "id", getPackageName());
        this.q = getResources().getIdentifier("bpush_downLoad_icon", "id", getPackageName());
      }
      this.c.setOnItemClickListener(this.s);
      this.c.setDividerHeight(0);
      this.c.setOnItemLongClickListener(this.t);
    }
    this.b = ((NotificationManager)getSystemService("notification"));
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject;
    List localList;
    if (this.d != 0)
    {
      localObject = new String[4];
      localObject[0] = "img";
      localObject[1] = "title";
      localObject[2] = "fromtext";
      localObject[3] = "timetext";
      this.a = new ArrayList();
      localList = com.baidu.android.pushservice.d.a.b(this);
      if ((localList == null) || (localList.isEmpty()))
      {
        this.l.setVisibility(0);
        this.c.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.l.setVisibility(8);
    this.c.setVisibility(0);
    this.c.setItemsCanFocus(true);
    PackageManager localPackageManager = getPackageManager();
    int i1 = 0;
    for (;;)
    {
      HashMap localHashMap;
      if (i1 < localList.size()) {
        localHashMap = new HashMap();
      }
      try
      {
        ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(((a.g)localList.get(i1)).a, 0);
        localHashMap.put(localObject[0], localPackageManager.getApplicationIcon(localApplicationInfo));
        localHashMap.put(localObject[1], ((a.g)localList.get(i1)).c);
        localHashMap.put(localObject[2], "来自：" + localPackageManager.getApplicationLabel(localApplicationInfo));
        localHashMap.put(localObject[3], p.a(((a.g)localList.get(i1)).j));
        localHashMap.put(r, ((a.g)localList.get(i1)).b);
        this.a.add(localHashMap);
        i1 += 1;
        continue;
        localObject = new a(this, this.a);
        this.c.setAdapter((ListAdapter)localObject);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private final Context b;
    private final ArrayList<HashMap<String, Object>> c;
    
    public a(ArrayList<HashMap<String, Object>> paramArrayList)
    {
      this.b = paramArrayList;
      ArrayList localArrayList;
      this.c = localArrayList;
    }
    
    public int getCount()
    {
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.c != null) && (paramInt < this.c.size())) {
        return this.c.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(this.b.getApplicationContext()).inflate(MediaListActivity.f(MediaListActivity.this), null);
      paramView.setBackgroundColor(-7829368);
      paramViewGroup = (ImageView)paramView.findViewById(MediaListActivity.g(MediaListActivity.this));
      TextView localTextView1 = (TextView)paramView.findViewById(MediaListActivity.h(MediaListActivity.this));
      TextView localTextView2 = (TextView)paramView.findViewById(MediaListActivity.i(MediaListActivity.this));
      TextView localTextView3 = (TextView)paramView.findViewById(MediaListActivity.j(MediaListActivity.this));
      try
      {
        if ((this.c != null) && (paramInt < this.c.size()))
        {
          HashMap localHashMap = (HashMap)this.c.get(paramInt);
          if (localHashMap != null)
          {
            if ((localTextView1 != null) && (localHashMap.get("title") != null)) {
              localTextView1.setText(localHashMap.get("title").toString());
            }
            if ((localTextView2 != null) && (localHashMap.get("fromtext") != null)) {
              localTextView2.setText(localHashMap.get("fromtext").toString());
            }
            if ((localTextView3 != null) && (localHashMap.get("timetext") != null)) {
              localTextView3.setText(localHashMap.get("timetext").toString());
            }
            if ((paramViewGroup != null) && (localHashMap.get("img") != null)) {
              paramViewGroup.setImageDrawable((Drawable)localHashMap.get("img"));
            }
          }
        }
        return paramView;
      }
      catch (Exception paramViewGroup) {}
      return paramView;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/richmedia/MediaListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */