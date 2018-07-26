package com.baidu.tts.tools;

import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

public class MD5 {
    /* renamed from: a */
    private static volatile MD5 f21315a = null;
    /* renamed from: b */
    private char[] f21316b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5() {
    }

    public static MD5 getInstance() {
        if (f21315a == null) {
            synchronized (MD5.class) {
                if (f21315a == null) {
                    f21315a = new MD5();
                }
            }
        }
        return f21315a;
    }

    public String getMD5(byte[] data) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(data);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                cArr[i2] = this.f21316b[(digest[i] >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = this.f21316b[digest[i] & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public String getBigFileMd5(File file) {
        Throwable th;
        String str = null;
        if (file != null) {
            FileInputStream fileInputStream;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                    str = m17544a(instance.digest());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                Object obj = str;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = str;
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return str;
    }

    public String getBigFileMd5(String filePath) {
        return getBigFileMd5(new File(filePath));
    }

    public String getFileMd5(String filePath) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        FileChannel fileChannel = null;
        FileChannel channel;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            File file = new File(filePath);
            fileInputStream = new FileInputStream(file);
            try {
                channel = fileInputStream.getChannel();
                try {
                    instance.update(channel.map(MapMode.READ_ONLY, 0, file.length()));
                    String a = m17544a(instance.digest());
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return a;
                } catch (Exception e2) {
                    fileInputStream2 = fileInputStream;
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    fileChannel = channel;
                    th = th2;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                channel = null;
                fileInputStream2 = fileInputStream;
                if (channel != null) {
                    channel.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            channel = null;
            fileInputStream2 = null;
            if (channel != null) {
                channel.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private String m17544a(byte[] bArr) {
        return m17545a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private String m17545a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            m17546a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m17546a(byte b, StringBuffer stringBuffer) {
        char c = this.f21316b[(b & RGHUDDataModel.MAX_CAR_SPEED) >> 4];
        char c2 = this.f21316b[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
