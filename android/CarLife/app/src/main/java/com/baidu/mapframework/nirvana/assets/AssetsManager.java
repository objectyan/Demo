package com.baidu.mapframework.nirvana.assets;

import com.baidu.mapframework.nirvana.C3480g;
import com.baidu.mapframework.nirvana.C3534b;
import com.baidu.mapframework.nirvana.C3541e;
import com.baidu.mapframework.nirvana.C3560n;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.p205b.C3533c;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

public class AssetsManager {
    public static void open(@NotNull Module module, @NotNull final AssetsTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config)) {
            C3541e.m15174b().m15142a(C3533c.ASSETS, task, module, config);
            C3541e.m15174b().m15143a((Object) task);
            try {
                final InputStream in = task.m15133c().getAssets().open(task.m15130a(), task.m15132b());
                task.m15131a(new InputStream() {
                    public int available() throws IOException {
                        return in.available();
                    }

                    public void close() throws IOException {
                        AssetsManager.m15129b(task);
                        in.close();
                    }

                    public void mark(int readlimit) {
                        in.mark(readlimit);
                    }

                    public boolean markSupported() {
                        return in.markSupported();
                    }

                    public int read(byte[] buffer) throws IOException {
                        return in.read(buffer);
                    }

                    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
                        return in.read(buffer, byteOffset, byteCount);
                    }

                    public synchronized void reset() throws IOException {
                        in.reset();
                    }

                    public long skip(long byteCount) throws IOException {
                        return in.skip(byteCount);
                    }

                    public int read() throws IOException {
                        return in.read();
                    }
                });
            } catch (Exception e) {
                C3534b callback = task.getExceptionCallback();
                if (callback != null) {
                    callback.m15158a(e);
                } else {
                    C3541e.m15171a("AssetsManager", e);
                }
            }
        }
    }

    /* renamed from: b */
    private static void m15129b(@NotNull AssetsTask task) {
        C3541e.m15174b().m15146b((Object) task);
    }
}
