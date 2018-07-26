package com.baidu.android.pushservice.richmedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0463a.C0459g;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.richmedia.C0641c.C0640a;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaListActivity extends Activity {
    /* renamed from: r */
    private static String f1994r = "downloadUrl";
    /* renamed from: a */
    ArrayList<HashMap<String, Object>> f1995a;
    /* renamed from: b */
    NotificationManager f1996b;
    /* renamed from: c */
    private ListView f1997c;
    /* renamed from: d */
    private int f1998d;
    /* renamed from: e */
    private int f1999e;
    /* renamed from: f */
    private int f2000f;
    /* renamed from: g */
    private int f2001g;
    /* renamed from: h */
    private int f2002h;
    /* renamed from: i */
    private int f2003i;
    /* renamed from: j */
    private int f2004j;
    /* renamed from: k */
    private int f2005k;
    /* renamed from: l */
    private LinearLayout f2006l = null;
    /* renamed from: m */
    private RemoteViews f2007m;
    /* renamed from: n */
    private int f2008n;
    /* renamed from: o */
    private int f2009o;
    /* renamed from: p */
    private int f2010p;
    /* renamed from: q */
    private int f2011q;
    /* renamed from: s */
    private final OnItemClickListener f2012s = new C06292(this);
    /* renamed from: t */
    private final OnItemLongClickListener f2013t = new C06323(this);

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$1 */
    class C06281 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MediaListActivity f1983a;

        C06281(MediaListActivity mediaListActivity) {
            this.f1983a = mediaListActivity;
        }

        public void onClick(View view) {
            this.f1983a.finish();
        }
    }

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$2 */
    class C06292 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ MediaListActivity f1984a;

        C06292(MediaListActivity mediaListActivity) {
            this.f1984a = mediaListActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C0459g a = C0463a.m1996a(this.f1984a, (String) ((HashMap) adapterView.getItemAtPosition(i)).get(MediaListActivity.f1994r));
            if (a == null) {
                return;
            }
            if (a.f1490i == C0638a.f2021f) {
                String str = a.f1486e;
                String str2 = a.f1487f;
                if (str2.length() > 0) {
                    Uri insert;
                    str2 = str + "/" + str2.substring(0, str2.lastIndexOf(".")) + "/index.html";
                    Intent intent = new Intent();
                    intent.setClass(this.f1984a, MediaViewActivity.class);
                    int A = C0578p.m2492A(this.f1984a, this.f1984a.getPackageName());
                    File file = new File(str2);
                    if (A >= 24) {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("_data", file.getAbsolutePath());
                        insert = this.f1984a.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        insert = Uri.fromFile(file);
                    }
                    intent.setData(insert);
                    intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    this.f1984a.startActivity(intent);
                    return;
                }
                return;
            }
            this.f1984a.m2782a(a.f1483b, a.f1484c, a.f1485d);
        }
    }

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$3 */
    class C06323 implements OnItemLongClickListener {
        /* renamed from: a */
        final /* synthetic */ MediaListActivity f1988a;

        /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$3$1 */
        class C06301 implements DialogInterface.OnClickListener {
            /* renamed from: a */
            final /* synthetic */ C06323 f1985a;

            C06301(C06323 c06323) {
                this.f1985a = c06323;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C06323(MediaListActivity mediaListActivity) {
            this.f1988a = mediaListActivity;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, final long j) {
            new Builder(this.f1988a).setTitle("提示").setMessage("确定要删除该记录？").setPositiveButton("确定", new DialogInterface.OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C06323 f1987b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    String str = (String) ((Map) this.f1987b.f1988a.f1995a.get((int) j)).get(MediaListActivity.f1994r);
                    C0459g a = C0463a.m1996a(this.f1987b.f1988a, str);
                    if (a != null) {
                        new File(a.f1486e).delete();
                    }
                    C0463a.m2002b(this.f1987b.f1988a, str);
                    Intent intent = new Intent();
                    intent.setClass(this.f1987b.f1988a, MediaListActivity.class);
                    this.f1987b.f1988a.startActivity(intent);
                }
            }).setNegativeButton("取消", new C06301(this)).show();
            return true;
        }
    }

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$4 */
    class C06344 implements C0424f {
        /* renamed from: a */
        final /* synthetic */ MediaListActivity f1990a;

        /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$4$1 */
        class C06331 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C06344 f1989a;

            C06331(C06344 c06344) {
                this.f1989a = c06344;
            }

            public void run() {
                Toast makeText = Toast.makeText(this.f1989a.f1990a, "下载富媒体失败", 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }

        C06344(MediaListActivity mediaListActivity) {
            this.f1990a = mediaListActivity;
        }

        /* renamed from: a */
        public void mo1273a(C0638a c0638a) {
        }

        /* renamed from: a */
        public void mo1274a(C0638a c0638a, C0639b c0639b) {
            Object c = c0638a.f2026d.m2808c();
            if (c0639b.f2028a != c0639b.f2029b && this.f1990a.f2007m != null) {
                int i = (int) ((((double) c0639b.f2028a) * 100.0d) / ((double) c0639b.f2029b));
                this.f1990a.f2007m.setTextViewText(this.f1990a.f2009o, i + "%");
                this.f1990a.f2007m.setTextViewText(this.f1990a.f2010p, c);
                this.f1990a.f2007m.setProgressBar(this.f1990a.f2008n, 100, i, false);
                this.f1990a.f2007m.setImageViewResource(this.f1990a.f2011q, 17301633);
                Notification build = VERSION.SDK_INT >= 16 ? new Notification.Builder(this.f1990a).setSmallIcon(17301633).setWhen(System.currentTimeMillis()).build() : new Notification(17301633, null, System.currentTimeMillis());
                build.contentView = this.f1990a.f2007m;
                build.contentIntent = PendingIntent.getActivity(this.f1990a, 0, new Intent(), 0);
                build.flags |= 32;
                build.flags |= 2;
                this.f1990a.f1996b.notify(c, 0, build);
            }
        }

        /* renamed from: a */
        public void mo1275a(C0638a c0638a, C0644e c0644e) {
            String c = c0638a.f2026d.m2808c();
            this.f1990a.f1996b.cancel(c, 0);
            C0459g a = C0463a.m1996a(this.f1990a, c);
            if (a != null && a.f1490i == C0638a.f2021f) {
                String str = a.f1486e;
                c = a.f1487f;
                if (c.length() > 0) {
                    Uri insert;
                    c = str + "/" + c.substring(0, c.lastIndexOf(".")) + "/index.html";
                    Intent intent = new Intent();
                    intent.setClass(this.f1990a, MediaViewActivity.class);
                    int A = C0578p.m2492A(this.f1990a, this.f1990a.getPackageName());
                    File file = new File(c);
                    if (A >= 24) {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("_data", file.getAbsolutePath());
                        insert = this.f1990a.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        insert = Uri.fromFile(file);
                    }
                    intent.setData(insert);
                    intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    this.f1990a.startActivity(intent);
                }
            }
        }

        /* renamed from: a */
        public void mo1276a(C0638a c0638a, Throwable th) {
            this.f1990a.f1996b.cancel(c0638a.f2026d.m2808c(), 0);
            this.f1990a.runOnUiThread(new C06331(this));
        }

        /* renamed from: b */
        public void mo1277b(C0638a c0638a) {
            this.f1990a.f1996b.cancel(c0638a.f2026d.m2808c(), 0);
        }
    }

    /* renamed from: com.baidu.android.pushservice.richmedia.MediaListActivity$a */
    public class C0635a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ MediaListActivity f1991a;
        /* renamed from: b */
        private final Context f1992b;
        /* renamed from: c */
        private final ArrayList<HashMap<String, Object>> f1993c;

        public C0635a(MediaListActivity mediaListActivity, Context context, ArrayList<HashMap<String, Object>> arrayList) {
            this.f1991a = mediaListActivity;
            this.f1992b = context;
            this.f1993c = arrayList;
        }

        public int getCount() {
            return this.f1993c.size();
        }

        public Object getItem(int i) {
            return (this.f1993c == null || i >= this.f1993c.size()) ? null : this.f1993c.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.f1992b.getApplicationContext()).inflate(this.f1991a.f1999e, null);
            inflate.setBackgroundColor(-7829368);
            ImageView imageView = (ImageView) inflate.findViewById(this.f1991a.f2001g);
            TextView textView = (TextView) inflate.findViewById(this.f1991a.f2002h);
            TextView textView2 = (TextView) inflate.findViewById(this.f1991a.f2003i);
            TextView textView3 = (TextView) inflate.findViewById(this.f1991a.f2004j);
            try {
                if (this.f1993c != null && i < this.f1993c.size()) {
                    HashMap hashMap = (HashMap) this.f1993c.get(i);
                    if (hashMap != null) {
                        if (!(textView == null || hashMap.get("title") == null)) {
                            textView.setText(hashMap.get("title").toString());
                        }
                        if (!(textView2 == null || hashMap.get("fromtext") == null)) {
                            textView2.setText(hashMap.get("fromtext").toString());
                        }
                        if (!(textView3 == null || hashMap.get("timetext") == null)) {
                            textView3.setText(hashMap.get("timetext").toString());
                        }
                        if (!(imageView == null || hashMap.get("img") == null)) {
                            imageView.setImageDrawable((Drawable) hashMap.get("img"));
                        }
                    }
                }
            } catch (Exception e) {
            }
            return inflate;
        }
    }

    /* renamed from: a */
    private void m2782a(String str, String str2, String str3) {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        String str4 = new String();
        if (path.length() > 0) {
            str4 = path.substring(0, path.lastIndexOf(47));
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "baidu/pushservice/files" + "/" + parse.getAuthority() + "/" + str4);
        C0641c a = C0643d.m2809a(C0640a.REQ_TYPE_GET_ZIP, parse.toString());
        a.f2033b = file.getAbsolutePath();
        a.f2034c = str2;
        a.f2035d = str3;
        new C0638a(this, new C06344(this), a).start();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1998d = getResources().getIdentifier("bpush_media_list", "layout", getPackageName());
        requestWindowFeature(1);
        if (this.f1998d != 0) {
            setContentView(this.f1998d);
            Resources resources = getResources();
            String packageName = getPackageName();
            this.f1999e = resources.getIdentifier("bpush_media_list_item", "layout", packageName);
            this.f2000f = resources.getIdentifier("bpush_type_listview", "id", packageName);
            this.f2001g = resources.getIdentifier("bpush_media_list_img", "id", packageName);
            this.f2002h = resources.getIdentifier("bpush_media_list_title", "id", packageName);
            this.f2003i = resources.getIdentifier("bpush_media_list_from_text", "id", packageName);
            this.f2004j = resources.getIdentifier("bpush_media_list_time_text", "id", packageName);
            this.f2005k = resources.getIdentifier("bpush_media_none_layout", "id", packageName);
            this.f2006l = (LinearLayout) findViewById(this.f2005k);
            this.f1997c = (ListView) findViewById(this.f2000f);
            Button button = (Button) findViewById(resources.getIdentifier("bpush_media_list_return_btn", "id", packageName));
            button.setClickable(true);
            button.setOnClickListener(new C06281(this));
            int identifier = getResources().getIdentifier("bpush_download_progress", "layout", getPackageName());
            if (identifier != 0) {
                this.f2007m = new RemoteViews(getPackageName(), identifier);
                this.f2008n = getResources().getIdentifier("bpush_downLoad_progress", "id", getPackageName());
                this.f2009o = getResources().getIdentifier("bpush_progress_percent", "id", getPackageName());
                this.f2010p = getResources().getIdentifier("bpush_progress_text", "id", getPackageName());
                this.f2011q = getResources().getIdentifier("bpush_downLoad_icon", "id", getPackageName());
            }
            this.f1997c.setOnItemClickListener(this.f2012s);
            this.f1997c.setDividerHeight(0);
            this.f1997c.setOnItemLongClickListener(this.f2013t);
        }
        this.f1996b = (NotificationManager) getSystemService("notification");
    }

    public void onResume() {
        super.onResume();
        if (this.f1998d != 0) {
            String[] strArr = new String[]{"img", "title", "fromtext", "timetext"};
            this.f1995a = new ArrayList();
            List b = C0463a.m2005b(this);
            if (b == null || b.isEmpty()) {
                this.f2006l.setVisibility(0);
                this.f1997c.setVisibility(8);
                return;
            }
            this.f2006l.setVisibility(8);
            this.f1997c.setVisibility(0);
            this.f1997c.setItemsCanFocus(true);
            PackageManager packageManager = getPackageManager();
            for (int i = 0; i < b.size(); i++) {
                HashMap hashMap = new HashMap();
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(((C0459g) b.get(i)).f1482a, 0);
                    hashMap.put(strArr[0], packageManager.getApplicationIcon(applicationInfo));
                    hashMap.put(strArr[1], ((C0459g) b.get(i)).f1484c);
                    hashMap.put(strArr[2], "来自：" + packageManager.getApplicationLabel(applicationInfo));
                    hashMap.put(strArr[3], C0578p.m2518a(((C0459g) b.get(i)).f1491j));
                    hashMap.put(f1994r, ((C0459g) b.get(i)).f1483b);
                    this.f1995a.add(hashMap);
                } catch (NameNotFoundException e) {
                }
            }
            this.f1997c.setAdapter(new C0635a(this, this, this.f1995a));
        }
    }
}
