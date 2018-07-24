package com.baidu.carlife.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.baidu.carlife.R;
import com.baidu.carlife.core.AppContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ArtworkUtils */
/* renamed from: com.baidu.carlife.util.a */
public class C2170a {
    /* renamed from: a */
    private static final Uri f6917a = Uri.parse("content://media/external/audio/albumart");
    /* renamed from: b */
    private static final Options f6918b = new Options();

    /* renamed from: a */
    public static Bitmap m8216a(Context context, long song_id, long album_id, boolean allowdefault) {
        Bitmap bm;
        if (album_id < 0) {
            if (song_id >= 0) {
                try {
                    bm = C2170a.m8215a(context, song_id, -1);
                    if (bm != null) {
                        return bm;
                    }
                } catch (Exception e) {
                    return null;
                }
            }
            return allowdefault ? C2170a.m8214a(context) : null;
        } else {
            ContentResolver res = context.getContentResolver();
            Uri uri = ContentUris.withAppendedId(f6917a, album_id);
            if (uri == null) {
                return null;
            }
            InputStream in = null;
            try {
                in = res.openInputStream(uri);
                Bitmap bmp = BitmapFactory.decodeStream(in, null, f6918b);
                if (bmp == null) {
                    bmp = C2170a.m8214a(context);
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return bmp;
            } catch (FileNotFoundException e3) {
                bm = C2170a.m8215a(context, song_id, album_id);
                if (bm != null) {
                    if (bm.getConfig() == null) {
                        bm = bm.copy(Config.RGB_565, false);
                        if (bm == null && allowdefault) {
                            bm = C2170a.m8214a(context);
                            if (in == null) {
                                return bm;
                            }
                            try {
                                in.close();
                                return bm;
                            } catch (IOException e22) {
                                e22.printStackTrace();
                                return bm;
                            }
                        }
                    }
                } else if (allowdefault) {
                    bm = C2170a.m8214a(context);
                }
                if (in == null) {
                    return bm;
                }
                try {
                    in.close();
                    return bm;
                } catch (IOException e222) {
                    e222.printStackTrace();
                    return bm;
                }
            } catch (SecurityException e4) {
                bm = C2170a.m8214a(context);
                if (in == null) {
                    return bm;
                }
                try {
                    in.close();
                    return bm;
                } catch (IOException e2222) {
                    e2222.printStackTrace();
                    return bm;
                }
            } catch (Throwable th) {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static Bitmap m8215a(Context context, long songid, long albumid) {
        if (albumid < 0 && songid < 0) {
            throw new IllegalArgumentException("Must specify an album or a song id");
        } else if (albumid < 0) {
            try {
                pfd = context.getContentResolver().openFileDescriptor(Uri.parse("content://media/external/audio/media/" + songid + "/albumart"), "r");
                if (pfd != null) {
                    return BitmapFactory.decodeFileDescriptor(pfd.getFileDescriptor());
                }
                return null;
            } catch (FileNotFoundException e) {
                return null;
            } catch (IllegalStateException e2) {
                return null;
            }
        } else {
            pfd = context.getContentResolver().openFileDescriptor(ContentUris.withAppendedId(f6917a, albumid), "r");
            if (pfd != null) {
                return BitmapFactory.decodeFileDescriptor(pfd.getFileDescriptor());
            }
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m8214a(Context context) {
        Options opts = new Options();
        opts.inPreferredConfig = Config.RGB_565;
        return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.music_ic_albumcover), null, opts);
    }

    /* renamed from: a */
    public static boolean m8217a() {
        if (AppContext.m3876a().getApplicationContext().getResources().getConfiguration().locale.getLanguage().endsWith("zh")) {
            return true;
        }
        return false;
    }
}
