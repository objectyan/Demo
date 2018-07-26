package com.baidu.che.codriver.p123i;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: VrUtils */
/* renamed from: com.baidu.che.codriver.i.d */
public class C2547d {
    /* renamed from: a */
    public static void m9650a(Context context, String source, String dest) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = context.getResources().getAssets().open(source);
            FileOutputStream fos2 = new FileOutputStream(dest);
            try {
                byte[] buffer = new byte[10240];
                while (true) {
                    int size = is.read(buffer, 0, 10240);
                    if (size < 0) {
                        break;
                    }
                    fos2.write(buffer, 0, size);
                }
                if (fos2 != null) {
                    try {
                        fos2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        fos = fos2;
                        return;
                    }
                }
                fos = fos2;
            } catch (FileNotFoundException e4) {
                e2 = e4;
                fos = fos2;
                try {
                    e2.printStackTrace();
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e3222) {
                            e3222.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e32222) {
                            e32222.printStackTrace();
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e322222) {
                            e322222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e322222 = e5;
                fos = fos2;
                e322222.printStackTrace();
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e3222222) {
                        e3222222.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e32222222) {
                        e32222222.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e2 = e6;
            e2.printStackTrace();
            if (fos != null) {
                fos.close();
            }
            if (is != null) {
                is.close();
            }
        } catch (IOException e7) {
            e32222222 = e7;
            e32222222.printStackTrace();
            if (fos != null) {
                fos.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /* renamed from: a */
    public static boolean m9652a(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        File dirFile = new File(filePath);
        if (!dirFile.exists()) {
            return false;
        }
        dirFile.delete();
        return true;
    }

    /* renamed from: b */
    public static boolean m9653b(String dir) {
        if (dir == null || dir.equals("")) {
            return false;
        }
        File file = new File(dir);
        if (file.exists()) {
            try {
                C2547d.m9651a(file);
            } catch (Exception e) {
                return false;
            }
        }
        file.mkdirs();
        return true;
    }

    /* renamed from: a */
    private static void m9651a(File file) throws Exception {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                C2547d.m9651a(files[i]);
            } else {
                files[i].delete();
            }
        }
    }
}
