package com.baidu.platform.comapi.p133d;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: ResourceManager */
/* renamed from: com.baidu.platform.comapi.d.b */
public class C2908b {
    /* renamed from: a */
    public static final C2908b f12699a = new C2908b();
    /* renamed from: b */
    public static final int f12700b = 65536;
    /* renamed from: c */
    public static final String f12701c = ".dir";
    /* renamed from: d */
    private C4768c f12702d = new C4768c(C2907c.m10977f(), "res.json");

    private C2908b() {
    }

    /* renamed from: a */
    public void m10986a() {
        Context context = C2907c.m10977f();
        boolean firstInit = true;
        boolean isInitSucceed = true;
        byte[] resBuffer = null;
        File verFile = null;
        try {
            String outputDirPath = m10981b();
            File verFile2 = new File(outputDirPath, "/ver.dat");
            try {
                resBuffer = this.f12702d.a();
                firstInit = m10980a(verFile2, resBuffer);
                if (firstInit) {
                    AssetManager am = context.getAssets();
                    byte[] tmpBuffer = new byte[65536];
                    for (String fileName : this.f12702d.b()) {
                        isInitSucceed = m10979a(am, tmpBuffer, fileName, outputDirPath + "/" + fileName);
                    }
                }
                verFile = verFile2;
            } catch (RuntimeException e) {
                verFile = verFile2;
                isInitSucceed = false;
                if (firstInit) {
                }
                return;
            } catch (Exception e2) {
                verFile = verFile2;
                isInitSucceed = false;
                if (firstInit) {
                    return;
                }
            }
        } catch (RuntimeException e3) {
            isInitSucceed = false;
            if (firstInit) {
            }
            return;
        } catch (Exception e4) {
            isInitSucceed = false;
            if (firstInit) {
                return;
            }
        }
        if (firstInit && isInitSucceed) {
            isInitSucceed = m10983b(verFile, resBuffer);
        }
    }

    /* renamed from: a */
    private void m10978a(String outputDirPath) {
        File origin = new File(outputDirPath.concat("/cfg/a/ResPack.png"));
        File dest = new File(outputDirPath.concat("/cfg/a/ResPack.rs"));
        if (origin.exists()) {
            if (dest.exists()) {
                dest.delete();
            }
            origin.renameTo(dest);
        }
    }

    /* renamed from: b */
    private void m10982b(String outputDirPath) {
        File origin = new File(outputDirPath.concat("/cfg/a/ResPackPoi.png"));
        File dest = new File(outputDirPath.concat("/cfg/a/ResPackPoi.rs"));
        if (origin.exists()) {
            if (dest.exists()) {
                dest.delete();
            }
            origin.renameTo(dest);
        }
    }

    /* renamed from: c */
    private void m10984c(String outputDirPath) {
        File origin = new File(outputDirPath.concat("/cfg/a/ResPackRoute.png"));
        File dest = new File(outputDirPath.concat("/cfg/a/ResPackRoute.rs"));
        if (origin.exists()) {
            if (dest.exists()) {
                dest.delete();
            }
            origin.renameTo(dest);
        }
    }

    /* renamed from: d */
    private void m10985d(String outputDirPath) {
        File origin = new File(outputDirPath.concat("/cfg/a/ResPackTravel.png"));
        File dest = new File(outputDirPath.concat("/cfg/a/ResPackTravel.rs"));
        if (origin.exists()) {
            if (dest.exists()) {
                dest.delete();
            }
            origin.renameTo(dest);
        }
    }

    /* renamed from: b */
    private String m10981b() {
        String outputDirPath = SysOSAPIv2.getInstance().getOutputDirPath();
        File fout = new File(outputDirPath);
        if (!fout.exists()) {
            fout.mkdirs();
        }
        return outputDirPath;
    }

    /* renamed from: a */
    private boolean m10980a(File verFile, byte[] resBuffer) {
        Throwable th;
        if (verFile == null || !verFile.exists() || resBuffer == null) {
            return true;
        }
        FileInputStream verInput = null;
        try {
            FileInputStream verInput2 = new FileInputStream(verFile);
            try {
                byte[] verBuf = new byte[verInput2.available()];
                verInput2.read(verBuf);
                if (Arrays.equals(verBuf, resBuffer)) {
                    C4767a.a(verInput2);
                    return false;
                }
                C4767a.a(verInput2);
                verInput = verInput2;
                return true;
            } catch (IOException e) {
                verInput = verInput2;
                C4767a.a(verInput);
                return true;
            } catch (Throwable th2) {
                th = th2;
                verInput = verInput2;
                C4767a.a(verInput);
                throw th;
            }
        } catch (IOException e2) {
            C4767a.a(verInput);
            return true;
        } catch (Throwable th3) {
            th = th3;
            C4767a.a(verInput);
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m10979a(AssetManager am, byte[] tmpBuffer, String oldFileName, String newFileName) {
        Throwable th;
        InputStream input = null;
        try {
            if (!TextUtils.isEmpty(oldFileName)) {
                if (oldFileName.endsWith(f12701c)) {
                    oldFileName = oldFileName.substring(0, oldFileName.indexOf(f12701c));
                    newFileName = newFileName.substring(0, newFileName.indexOf(f12701c));
                    String[] files = am.list(oldFileName);
                    if (files != null && files.length > 0) {
                        File file = new File(newFileName);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.mkdirs();
                        for (String fileDir : files) {
                            m10979a(am, tmpBuffer, oldFileName + "/" + fileDir, newFileName + "/" + fileDir);
                        }
                    }
                    C4767a.a(input);
                    return true;
                }
            }
            input = am.open(oldFileName);
            File f = new File(newFileName);
            File parentFile = f.getParentFile();
            if (!(parentFile == null || parentFile.isDirectory())) {
                parentFile.mkdirs();
            }
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            FileOutputStream fileOutputStream;
            try {
                C4767a.a(input, out, tmpBuffer);
                fileOutputStream = out;
                C4767a.a(input);
                return true;
            } catch (Exception e) {
                fileOutputStream = out;
                C4767a.a(input);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = out;
                C4767a.a(input);
                throw th;
            }
        } catch (Exception e2) {
            C4767a.a(input);
            return false;
        } catch (Throwable th3) {
            th = th3;
            C4767a.a(input);
            throw th;
        }
    }

    /* renamed from: b */
    private boolean m10983b(File verFile, byte[] resVerBuf) {
        Throwable th;
        if (verFile == null || resVerBuf == null) {
            return false;
        }
        boolean result = false;
        FileOutputStream out = null;
        try {
            if (verFile.exists()) {
                verFile.delete();
            }
            verFile.createNewFile();
            FileOutputStream out2 = new FileOutputStream(verFile);
            try {
                out2.write(resVerBuf);
                result = true;
                C4767a.a(out2);
                out = out2;
            } catch (Exception e) {
                out = out2;
                C4767a.a(out);
                if (out != null) {
                    return result;
                }
                try {
                    out.close();
                    return result;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return result;
                }
            } catch (Throwable th2) {
                th = th2;
                out = out2;
                C4767a.a(out);
                throw th;
            }
        } catch (Exception e3) {
            C4767a.a(out);
            if (out != null) {
                return result;
            }
            out.close();
            return result;
        } catch (Throwable th3) {
            th = th3;
            C4767a.a(out);
            throw th;
        }
        if (out != null) {
            return result;
        }
        out.close();
        return result;
    }
}
