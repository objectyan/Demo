package com.baidu.carlife;

import android.app.Activity;
import android.os.AsyncTask;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.view.C2252a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class KeyboardService {
    public static final String DIRECTORY_PATH = (CommonParams.jm + File.separator + "keyboard" + File.separator);
    public static final String LIB_SQLITE = "keyboardlib_v4.sqlite";
    private static final String TAG = KeyboardService.class.getSimpleName();
    private static KeyboardService mInstance;
    private boolean loadLibSuc;
    private C0942a mKeyboardCallBack;
    private long startLoadLibrary;

    /* renamed from: com.baidu.carlife.KeyboardService$a */
    public interface C0942a {
        /* renamed from: a */
        void m3127a(boolean z);
    }

    /* renamed from: com.baidu.carlife.KeyboardService$b */
    private class C0943b extends AsyncTask<Void, Void, Void> {
        /* renamed from: a */
        final /* synthetic */ KeyboardService f2398a;

        private C0943b(KeyboardService keyboardService) {
            this.f2398a = keyboardService;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3129a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m3130a((Void) obj);
        }

        /* renamed from: a */
        protected Void m3129a(Void... params) {
            this.f2398a.startLoadLibrary = System.currentTimeMillis();
            if (m3128a()) {
                this.f2398a.initService(KeyboardService.DIRECTORY_PATH + KeyboardService.LIB_SQLITE);
            }
            return null;
        }

        /* renamed from: a */
        protected void m3130a(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        /* renamed from: a */
        private boolean m3128a() {
            Throwable th;
            File sqliteFile = new File(KeyboardService.DIRECTORY_PATH + KeyboardService.LIB_SQLITE);
            if (sqliteFile.exists()) {
                return true;
            }
            File dir = new File(KeyboardService.DIRECTORY_PATH);
            if (dir.exists()) {
                File[] files = dir.listFiles();
                for (File delete : files) {
                    delete.delete();
                }
            } else {
                dir.mkdirs();
            }
            try {
                sqliteFile.createNewFile();
                byte[] buffer = new byte[1024];
                InputStream inputStream = null;
                FileOutputStream fos = null;
                try {
                    inputStream = BaiduNaviApplication.getInstance().getResources().openRawResource(R.raw.keyboardlib_v4);
                    FileOutputStream fos2 = new FileOutputStream(sqliteFile);
                    while (true) {
                        try {
                            int count = inputStream.read(buffer);
                            if (count <= 0) {
                                break;
                            }
                            fos2.write(buffer, 0, count);
                        } catch (FileNotFoundException e) {
                            fos = fos2;
                        } catch (IOException e2) {
                            fos = fos2;
                        } catch (Throwable th2) {
                            th = th2;
                            fos = fos2;
                        }
                    }
                    fos2.flush();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            return false;
                        }
                    }
                    if (fos2 == null) {
                        return true;
                    }
                    try {
                        fos2.close();
                        return true;
                    } catch (IOException e4) {
                        return false;
                    }
                } catch (FileNotFoundException e5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            return false;
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e7) {
                            return false;
                        }
                    }
                    return false;
                } catch (IOException e8) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                            return false;
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e10) {
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                            return false;
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e12) {
                            return false;
                        }
                    }
                    throw th;
                }
            } catch (IOException e13) {
                return false;
            }
        }
    }

    public native void initService(String str);

    public native ArrayList<String> relateWords(String str);

    public native ArrayList<String> search(String str);

    public native void userSelected(String str);

    static {
        System.loadLibrary("KeyboardService");
    }

    public void initServiceCallback(boolean isSuccess) {
        LogUtil.d("KeyboardService", "LoadLibrary:" + isSuccess + ",time=" + (System.currentTimeMillis() - this.startLoadLibrary));
        this.loadLibSuc = isSuccess;
        if (this.mKeyboardCallBack != null) {
            this.mKeyboardCallBack.m3127a(isSuccess);
        }
    }

    public void setKeyboardCallBack(C0942a keyboardCallBack) {
        this.mKeyboardCallBack = keyboardCallBack;
    }

    public static KeyboardService getInstance() {
        if (mInstance == null) {
            mInstance = new KeyboardService();
        }
        return mInstance;
    }

    public boolean isLoadLibSuc() {
        return this.loadLibSuc;
    }

    public void init(Activity activity, OnDialogListener listener) {
        new C0943b().execute(new Void[0]);
        C2252a.m8531a().m8561a(activity, listener);
    }
}
