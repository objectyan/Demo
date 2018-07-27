package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProcFile extends File implements Parcelable {
    public static final Creator<ProcFile> CREATOR = new C20341();
    /* renamed from: b */
    public final String f6567b;

    /* renamed from: com.baidu.carlife.processes.models.ProcFile$1 */
    static class C20341 implements Creator<ProcFile> {
        C20341() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7812a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7813a(i);
        }

        /* renamed from: a */
        public ProcFile m7812a(Parcel in) {
            return new ProcFile(in);
        }

        /* renamed from: a */
        public ProcFile[] m7813a(int size) {
            return new ProcFile[size];
        }
    }

    protected ProcFile(String path) throws IOException {
        super(path);
        this.f6567b = m7807b(path);
    }

    protected ProcFile(Parcel in) {
        super(in.readString());
        this.f6567b = in.readString();
    }

    /* renamed from: b */
    protected static String m7807b(String path) throws IOException {
        Throwable th;
        BufferedReader reader = null;
        try {
            StringBuilder output = new StringBuilder();
            BufferedReader reader2 = new BufferedReader(new FileReader(path));
            try {
                String newLine = "";
                for (String line = reader2.readLine(); line != null; line = reader2.readLine()) {
                    output.append(newLine).append(line);
                    newLine = "\n";
                }
                String stringBuilder = output.toString();
                if (reader2 != null) {
                    reader2.close();
                }
                return stringBuilder;
            } catch (Throwable th2) {
                th = th2;
                reader = reader2;
                if (reader != null) {
                    reader.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (reader != null) {
                reader.close();
            }
            throw th;
        }
    }

    public long length() {
        return (long) this.f6567b.length();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getAbsolutePath());
        dest.writeString(this.f6567b);
    }
}
