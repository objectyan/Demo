package com.baidu.mpcr.model;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mpcr.jni.MpcrAppJni;
import com.baidu.mpcr.tools.ZipTools;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OEMChannel {
    private static final String TAG = OEMChannel.class.getSimpleName();
    private static OEMChannel oemChannel;
    private boolean hasChannelFile = false;
    private String oemChannelFile = "libBDoeminfo_baidu.so";
    private String path = null;

    static {
        System.loadLibrary("mpcr");
    }

    private OEMChannel() {
    }

    public String getChannelInfo() {
        Exception e;
        Throwable th;
        long readStartTime = System.currentTimeMillis();
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            if (this.path == null || !new File(this.path).exists()) {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
                return null;
            }
            FileInputStream in2 = new FileInputStream(new File(this.path));
            try {
                ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                try {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int len = in2.read(buffer);
                        if (len == -1) {
                            break;
                        }
                        out2.write(buffer, 0, len);
                    }
                    byte[] channelData = ZipTools.decompress(out2.toByteArray());
                    MpcrAppJni jni = new MpcrAppJni();
                    long readEndTime = System.currentTimeMillis();
                    String channel = jni.decryptStr(new String(channelData));
                    long deEndTime = System.currentTimeMillis();
                    if (out2 != null) {
                        try {
                            out2.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    if (in2 != null) {
                        try {
                            in2.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    out = out2;
                    in = in2;
                    return channel;
                } catch (Exception e3) {
                    e = e3;
                    out = out2;
                    in = in2;
                } catch (Throwable th2) {
                    th = th2;
                    out = out2;
                    in = in2;
                }
            } catch (Exception e4) {
                e = e4;
                in = in2;
                try {
                    e.printStackTrace();
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e22222) {
                            e22222.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e222222) {
                            e222222.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e2222222) {
                            e2222222.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e22222222) {
                            e22222222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                in = in2;
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            return null;
        }
    }

    public String decryptStr(String str) {
        return new MpcrAppJni().decryptStr(str);
    }

    public static synchronized OEMChannel getInstance() {
        OEMChannel oEMChannel;
        synchronized (OEMChannel.class) {
            if (oemChannel == null) {
                synchronized (OEMChannel.class) {
                    oemChannel = new OEMChannel();
                }
            }
            oEMChannel = oemChannel;
        }
        return oEMChannel;
    }

    public boolean hasChannel() {
        return this.hasChannelFile;
    }

    public String buildInnerPath() {
        File file = new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(Environment.getRootDirectory().getAbsolutePath())).append("/lib").toString())).append(File.separator).append(this.oemChannelFile).toString());
        if (!file.exists()) {
            return null;
        }
        this.hasChannelFile = true;
        this.path = file.getAbsolutePath();
        return this.path;
    }

    public String buildInnerPath(String soPath) {
        if (soPath == null || TextUtils.isEmpty(soPath)) {
            return null;
        }
        File file = new File(soPath, this.oemChannelFile);
        if (!file.exists()) {
            return null;
        }
        this.hasChannelFile = true;
        this.path = file.getAbsolutePath();
        return this.path;
    }

    public String buildPath(String soPath) {
        if (soPath == null || TextUtils.isEmpty(soPath)) {
            return null;
        }
        File file = new File(soPath);
        if (!file.exists()) {
            return null;
        }
        this.hasChannelFile = true;
        this.path = file.getAbsolutePath();
        return this.path;
    }
}
